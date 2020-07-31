package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.os.Build;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c {
    private static String fal;
    private int fao;
    private int fap;
    private int faq;
    private PopupWindow fas;
    private TextView fat;
    private TextView fau;
    private b fav;
    private boolean faw;
    private NEGFeedBackView fax;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private aq fam = null;
    private SparseArray<String> eZZ = null;
    private List<b.a> fan = new ArrayList();
    private NEGFeedBackView.a far = null;
    private int mSkinType = 3;
    private boolean fay = true;
    private boolean faz = false;
    private CompoundButton.OnCheckedChangeListener fad = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.far != null) {
                c.this.far.a(c.this.fam, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.fan.contains(aVar)) {
                        c.this.fan.add(aVar);
                    }
                } else {
                    c.this.fan.remove(aVar);
                }
            }
            c.this.brn();
        }
    };
    private View.OnClickListener faA = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.fam != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject P = c.this.P(arrayList);
                if (c.this.fay) {
                    if (!StringUtils.isNull(c.this.fam.getType())) {
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, P);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    } else {
                        CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, P);
                        customResponsedMessage2.setOrginalMessage(customMessage2);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                    }
                }
                c.this.brl();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.toastTime = 1500L;
                cVar.showSuccessToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.far != null) {
                    c.this.far.a(arrayList, c.this.brm(), c.this.fam);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener faB = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.fax != null) {
                c.this.fax.setACRotateAnimation();
                c.this.fax = null;
            }
            if (c.this.fas != null) {
                c.this.fas.dismiss();
                c.this.fas = null;
            }
        }
    };
    private CustomMessageListener faC = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.brl();
        }
    };

    public c(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.tbds44);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.tbds28);
        this.mMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        this.faq = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fap = l.getDimens(this.mContext, R.dimen.tbds160);
        this.fav = new b(this.mPageContext);
        this.fav.a(this.fad);
        this.mPageContext.registerListener(this.faC);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.faC != null) {
                this.faC.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.faC);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.faz || (this.eZZ != null && this.eZZ.size() != 0)) {
                this.fax = (NEGFeedBackView) view;
                this.fax.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.fap, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.faB);
                resetState();
                this.fas = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fas.setAttachedInDecor(false);
                }
                this.fas.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        ao.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        ao.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.far != null) {
                        this.far.b(this.fam);
                    }
                    this.faw = true;
                }
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.fat = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!as.isEmpty(fal)) {
                this.fat.setText(fal);
            }
            this.fau = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.fau.setOnClickListener(this.faA);
            this.mContentView.setPadding(this.faq, this.mMargin, this.faq, this.faq + this.mArrowHeight);
            if (this.faz) {
                this.fat.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.fau.setLayoutParams(layoutParams);
            }
        }
        bci();
        View view = this.fav.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fao = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.fao;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int equipmentHeight = l.getEquipmentHeight(context);
        int equipmentWidth = l.getEquipmentWidth(context);
        boolean z = ((equipmentHeight - iArr2[1]) - height) - i3 < i;
        iArr[0] = equipmentWidth - i2;
        if (z) {
            this.mContentView.setPadding(this.faq, this.mMargin, this.faq, this.faq + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.faq, this.mMargin + this.mArrowHeight, this.faq, this.faq);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject P(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.fam == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!x.isEmpty(this.fan)) {
            for (b.a aVar : this.fan) {
                if (aVar != null) {
                    arrayList.add(Integer.valueOf(aVar.id));
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(String.valueOf(aVar.id));
                    if (sb2.length() != 0) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb2.append(aVar.extra);
                }
            }
        }
        try {
            jSONObject.put("tid", this.fam.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.fam.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.fam.getType())) {
                jSONObject.put("type", this.fam.getType());
            }
            if (this.fam.aUK() != 0) {
                jSONObject.put("topic_id", this.fam.aUK());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String brm() {
        if (x.isEmpty(this.fan)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.fan) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brn() {
        int size = this.fan.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ao.getColor(R.color.cp_link_tip_a)));
            if (this.fat != null) {
                this.fat.setText(spannableString);
            }
            if (this.fau != null) {
                this.fau.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.fat != null) {
            if (!as.isEmpty(fal)) {
                this.fat.setText(fal);
            } else {
                this.fat.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.fau != null) {
            this.fau.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(aq aqVar) {
        if (aqVar != null) {
            this.fam = aqVar;
            this.eZZ = aqVar.getFeedBackReasonMap();
            if (this.eZZ != null && this.eZZ.size() > 9) {
                for (int size = this.eZZ.size() - 1; size >= 9; size--) {
                    this.eZZ.removeAt(size);
                }
            }
            this.fav.setData(aqVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fav.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.far = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.fay = z;
    }

    public void setHeadText(String str) {
        if (!as.isEmpty(str)) {
            fal = str;
        }
    }

    public void aI(boolean z) {
        this.faz = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fav.setDefaultReasonArray(strArr);
    }

    public void brl() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fas != null) {
            this.fas.dismiss();
            this.fas = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.faC);
        brl();
    }

    private void resetState() {
        if (this.faw && this.fan.size() != 0) {
            this.fan.clear();
            brn();
        }
    }

    private void bci() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setViewTextColor(this.fat, R.color.cp_cont_b, 1);
            ao.setViewTextColor(this.fau, R.color.cp_cont_a, 1);
            ao.setBackgroundResource(this.fau, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
