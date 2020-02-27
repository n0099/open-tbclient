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
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static String dUi;
    private int dUl;
    private int dUm;
    private int dUn;
    private int dUo;
    private PopupWindow dUq;
    private TextView dUr;
    private TextView dUs;
    private b dUt;
    private boolean dUu;
    private NEGFeedBackView dUv;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private al dUj = null;
    private SparseArray<String> dTX = null;
    private List<b.a> dUk = new ArrayList();
    private NEGFeedBackView.a dUp = null;
    private int mSkinType = 3;
    private boolean dUw = true;
    private boolean dUx = false;
    private CompoundButton.OnCheckedChangeListener dUa = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.dUp != null) {
                c.this.dUp.a(c.this.dUj, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.dUk.contains(aVar)) {
                        c.this.dUk.add(aVar);
                    }
                } else {
                    c.this.dUk.remove(aVar);
                }
            }
            c.this.aWn();
        }
    };
    private View.OnClickListener dUy = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dUj != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject O = c.this.O(arrayList);
                if (c.this.dUw) {
                    if (!StringUtils.isNull(c.this.dUj.getType())) {
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, O);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    } else {
                        CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, O);
                        customResponsedMessage2.setOrginalMessage(customMessage2);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                    }
                }
                c.this.aWl();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.toastTime = 1500L;
                dVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.dUp != null) {
                    c.this.dUp.a(arrayList, c.this.aWm(), c.this.dUj);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener dUz = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.dUv != null) {
                c.this.dUv.setACRotateAnimation();
                c.this.dUv = null;
            }
            if (c.this.dUq != null) {
                c.this.dUq.dismiss();
                c.this.dUq = null;
            }
        }
    };
    private CustomMessageListener dUA = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aWl();
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
        this.dUo = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.dUl = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dUn = l.getDimens(this.mContext, R.dimen.tbds160);
        this.dUt = new b(this.mPageContext);
        this.dUt.a(this.dUa);
        this.mPageContext.registerListener(this.dUA);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dUA != null) {
                this.dUA.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dUA);
        }
    }

    public void R(View view) {
        if (this.mContext != null) {
            if (this.dUx || (this.dTX != null && this.dTX.size() != 0)) {
                this.dUv = (NEGFeedBackView) view;
                this.dUv.setCWRotateAnimation();
                View contentView = getContentView();
                this.dUl = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.dUl, this.dUn, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.dUl, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.dUz);
                resetState();
                this.dUq = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.dUq.setAttachedInDecor(false);
                }
                this.dUq.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.dUp != null) {
                        this.dUp.b(this.dUj);
                    }
                    this.dUu = true;
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
            this.dUr = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!aq.isEmpty(dUi)) {
                this.dUr.setText(dUi);
            }
            this.dUs = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.dUs.setOnClickListener(this.dUy);
            this.mContentView.setPadding(this.dUo, this.mMargin, this.dUo, this.dUo + this.mArrowHeight);
            if (this.dUx) {
                this.dUr.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.dUs.setLayoutParams(layoutParams);
            }
        }
        aHL();
        View view = this.dUt.getView();
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
        this.dUm = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.dUm;
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
            this.mContentView.setPadding(this.dUo, this.mMargin, this.dUo, this.dUo + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.dUo, this.mMargin + this.mArrowHeight, this.dUo, this.dUo);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject O(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.dUj == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.dUk)) {
            for (b.a aVar : this.dUk) {
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
            jSONObject.put("tid", this.dUj.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.dUj.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.dUj.getType())) {
                jSONObject.put("type", this.dUj.getType());
            }
            if (this.dUj.aAS() != 0) {
                jSONObject.put("topic_id", this.dUj.aAS());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aWm() {
        if (v.isEmpty(this.dUk)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.dUk) {
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
    public void aWn() {
        int size = this.dUk.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.dUr != null) {
                this.dUr.setText(spannableString);
            }
            if (this.dUs != null) {
                this.dUs.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.dUr != null) {
            if (!aq.isEmpty(dUi)) {
                this.dUr.setText(dUi);
            } else {
                this.dUr.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.dUs != null) {
            this.dUs.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUj = alVar;
            this.dTX = alVar.getFeedBackReasonMap();
            if (this.dTX != null && this.dTX.size() > 9) {
                for (int size = this.dTX.size() - 1; size >= 9; size--) {
                    this.dTX.removeAt(size);
                }
            }
            this.dUt.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dUt.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUp = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.dUw = z;
    }

    public void setHeadText(String str) {
        if (!aq.isEmpty(str)) {
            dUi = str;
        }
    }

    public void ae(boolean z) {
        this.dUx = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUt.setDefaultReasonArray(strArr);
    }

    public void aWl() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dUq != null) {
            this.dUq.dismiss();
            this.dUq = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.dUA);
        aWl();
    }

    private void resetState() {
        if (this.dUu && this.dUk.size() != 0) {
            this.dUk.clear();
            aWn();
        }
    }

    private void aHL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.dUr, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.dUs, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.dUs, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
