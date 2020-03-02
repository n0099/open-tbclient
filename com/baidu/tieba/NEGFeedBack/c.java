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
    private static String dUj;
    private int dUm;
    private int dUn;
    private int dUo;
    private int dUp;
    private PopupWindow dUr;
    private TextView dUs;
    private TextView dUt;
    private b dUu;
    private boolean dUv;
    private NEGFeedBackView dUw;
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
    private al dUk = null;
    private SparseArray<String> dTY = null;
    private List<b.a> dUl = new ArrayList();
    private NEGFeedBackView.a dUq = null;
    private int mSkinType = 3;
    private boolean dUx = true;
    private boolean dUy = false;
    private CompoundButton.OnCheckedChangeListener dUb = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.dUq != null) {
                c.this.dUq.a(c.this.dUk, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.dUl.contains(aVar)) {
                        c.this.dUl.add(aVar);
                    }
                } else {
                    c.this.dUl.remove(aVar);
                }
            }
            c.this.aWp();
        }
    };
    private View.OnClickListener dUz = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dUk != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject O = c.this.O(arrayList);
                if (c.this.dUx) {
                    if (!StringUtils.isNull(c.this.dUk.getType())) {
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
                c.this.aWn();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.toastTime = 1500L;
                dVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.dUq != null) {
                    c.this.dUq.a(arrayList, c.this.aWo(), c.this.dUk);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener dUA = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.dUw != null) {
                c.this.dUw.setACRotateAnimation();
                c.this.dUw = null;
            }
            if (c.this.dUr != null) {
                c.this.dUr.dismiss();
                c.this.dUr = null;
            }
        }
    };
    private CustomMessageListener dUB = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aWn();
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
        this.dUp = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.dUm = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dUo = l.getDimens(this.mContext, R.dimen.tbds160);
        this.dUu = new b(this.mPageContext);
        this.dUu.a(this.dUb);
        this.mPageContext.registerListener(this.dUB);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dUB != null) {
                this.dUB.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dUB);
        }
    }

    public void R(View view) {
        if (this.mContext != null) {
            if (this.dUy || (this.dTY != null && this.dTY.size() != 0)) {
                this.dUw = (NEGFeedBackView) view;
                this.dUw.setCWRotateAnimation();
                View contentView = getContentView();
                this.dUm = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.dUm, this.dUo, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.dUm, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.dUA);
                resetState();
                this.dUr = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.dUr.setAttachedInDecor(false);
                }
                this.dUr.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.dUq != null) {
                        this.dUq.b(this.dUk);
                    }
                    this.dUv = true;
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
            this.dUs = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!aq.isEmpty(dUj)) {
                this.dUs.setText(dUj);
            }
            this.dUt = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.dUt.setOnClickListener(this.dUz);
            this.mContentView.setPadding(this.dUp, this.mMargin, this.dUp, this.dUp + this.mArrowHeight);
            if (this.dUy) {
                this.dUs.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.dUt.setLayoutParams(layoutParams);
            }
        }
        aHN();
        View view = this.dUu.getView();
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
        this.dUn = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.dUn;
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
            this.mContentView.setPadding(this.dUp, this.mMargin, this.dUp, this.dUp + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.dUp, this.mMargin + this.mArrowHeight, this.dUp, this.dUp);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject O(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.dUk == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.dUl)) {
            for (b.a aVar : this.dUl) {
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
            jSONObject.put("tid", this.dUk.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.dUk.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.dUk.getType())) {
                jSONObject.put("type", this.dUk.getType());
            }
            if (this.dUk.aAU() != 0) {
                jSONObject.put("topic_id", this.dUk.aAU());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aWo() {
        if (v.isEmpty(this.dUl)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.dUl) {
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
    public void aWp() {
        int size = this.dUl.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.dUs != null) {
                this.dUs.setText(spannableString);
            }
            if (this.dUt != null) {
                this.dUt.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.dUs != null) {
            if (!aq.isEmpty(dUj)) {
                this.dUs.setText(dUj);
            } else {
                this.dUs.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.dUt != null) {
            this.dUt.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dUk = alVar;
            this.dTY = alVar.getFeedBackReasonMap();
            if (this.dTY != null && this.dTY.size() > 9) {
                for (int size = this.dTY.size() - 1; size >= 9; size--) {
                    this.dTY.removeAt(size);
                }
            }
            this.dUu.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dUu.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dUq = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.dUx = z;
    }

    public void setHeadText(String str) {
        if (!aq.isEmpty(str)) {
            dUj = str;
        }
    }

    public void ae(boolean z) {
        this.dUy = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dUu.setDefaultReasonArray(strArr);
    }

    public void aWn() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dUr != null) {
            this.dUr.dismiss();
            this.dUr = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.dUB);
        aWn();
    }

    private void resetState() {
        if (this.dUv && this.dUl.size() != 0) {
            this.dUl.clear();
            aWp();
        }
    }

    private void aHN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.dUs, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.dUt, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.dUt, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
