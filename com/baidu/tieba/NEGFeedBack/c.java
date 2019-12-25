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
/* loaded from: classes5.dex */
public class c {
    private static String dPT;
    private int dPW;
    private int dPX;
    private int dPY;
    private int dPZ;
    private PopupWindow dQb;
    private TextView dQc;
    private TextView dQd;
    private b dQe;
    private boolean dQf;
    private NEGFeedBackView dQg;
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
    private al dPU = null;
    private SparseArray<String> dPI = null;
    private List<b.a> dPV = new ArrayList();
    private NEGFeedBackView.a dQa = null;
    private int mSkinType = 3;
    private boolean dQh = true;
    private boolean dQi = false;
    private CompoundButton.OnCheckedChangeListener dPL = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.dQa != null) {
                c.this.dQa.a(c.this.dPU, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.dPV.contains(aVar)) {
                        c.this.dPV.add(aVar);
                    }
                } else {
                    c.this.dPV.remove(aVar);
                }
            }
            c.this.aTD();
        }
    };
    private View.OnClickListener dQj = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dPU != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject M = c.this.M(arrayList);
                if (c.this.dQh) {
                    if (!StringUtils.isNull(c.this.dPU.getType())) {
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, M);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    } else {
                        CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, M);
                        customResponsedMessage2.setOrginalMessage(customMessage2);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                    }
                }
                c.this.aTB();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.toastTime = 1500L;
                dVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.dQa != null) {
                    c.this.dQa.a(arrayList, c.this.aTC(), c.this.dPU);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener dQk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.dQg != null) {
                c.this.dQg.setACRotateAnimation();
                c.this.dQg = null;
            }
            if (c.this.dQb != null) {
                c.this.dQb.dismiss();
                c.this.dQb = null;
            }
        }
    };
    private CustomMessageListener dQl = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aTB();
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
        this.dPZ = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.dPW = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dPY = l.getDimens(this.mContext, R.dimen.tbds160);
        this.dQe = new b(this.mPageContext);
        this.dQe.a(this.dPL);
        this.mPageContext.registerListener(this.dQl);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dQl != null) {
                this.dQl.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dQl);
        }
    }

    public void P(View view) {
        if (this.mContext != null) {
            if (this.dQi || (this.dPI != null && this.dPI.size() != 0)) {
                this.dQg = (NEGFeedBackView) view;
                this.dQg.setCWRotateAnimation();
                View contentView = getContentView();
                this.dPW = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.dPW, this.dPY, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.dPW, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.dQk);
                resetState();
                this.dQb = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.dQb.setAttachedInDecor(false);
                }
                this.dQb.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.dQa != null) {
                        this.dQa.b(this.dPU);
                    }
                    this.dQf = true;
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
            this.dQc = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!aq.isEmpty(dPT)) {
                this.dQc.setText(dPT);
            }
            this.dQd = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.dQd.setOnClickListener(this.dQj);
            this.mContentView.setPadding(this.dPZ, this.mMargin, this.dPZ, this.dPZ + this.mArrowHeight);
            if (this.dQi) {
                this.dQc.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.dQd.setLayoutParams(layoutParams);
            }
        }
        aFd();
        View view = this.dQe.getView();
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
        this.dPX = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.dPX;
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
            this.mContentView.setPadding(this.dPZ, this.mMargin, this.dPZ, this.dPZ + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.dPZ, this.mMargin + this.mArrowHeight, this.dPZ, this.dPZ);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject M(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.dPU == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.dPV)) {
            for (b.a aVar : this.dPV) {
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
            jSONObject.put("tid", this.dPU.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.dPU.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.dPU.getType())) {
                jSONObject.put("type", this.dPU.getType());
            }
            if (this.dPU.ayl() != 0) {
                jSONObject.put("topic_id", this.dPU.ayl());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTC() {
        if (v.isEmpty(this.dPV)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.dPV) {
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
    public void aTD() {
        int size = this.dPV.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.dQc != null) {
                this.dQc.setText(spannableString);
            }
            if (this.dQd != null) {
                this.dQd.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.dQc != null) {
            if (!aq.isEmpty(dPT)) {
                this.dQc.setText(dPT);
            } else {
                this.dQc.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.dQd != null) {
            this.dQd.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dPU = alVar;
            this.dPI = alVar.getFeedBackReasonMap();
            if (this.dPI != null && this.dPI.size() > 9) {
                for (int size = this.dPI.size() - 1; size >= 9; size--) {
                    this.dPI.removeAt(size);
                }
            }
            this.dQe.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dQe.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQa = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.dQh = z;
    }

    public void setHeadText(String str) {
        if (!aq.isEmpty(str)) {
            dPT = str;
        }
    }

    public void ab(boolean z) {
        this.dQi = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dQe.setDefaultReasonArray(strArr);
    }

    public void aTB() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dQb != null) {
            this.dQb.dismiss();
            this.dQb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.dQl);
        aTB();
    }

    private void resetState() {
        if (this.dQf && this.dPV.size() != 0) {
            this.dPV.clear();
            aTD();
        }
    }

    private void aFd() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.dQc, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.dQd, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.dQd, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
