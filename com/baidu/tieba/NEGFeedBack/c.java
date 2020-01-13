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
/* loaded from: classes6.dex */
public class c {
    private static String dQc;
    private int dQf;
    private int dQg;
    private int dQh;
    private int dQi;
    private PopupWindow dQk;
    private TextView dQl;
    private TextView dQm;
    private b dQn;
    private boolean dQo;
    private NEGFeedBackView dQp;
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
    private al dQd = null;
    private SparseArray<String> dPR = null;
    private List<b.a> dQe = new ArrayList();
    private NEGFeedBackView.a dQj = null;
    private int mSkinType = 3;
    private boolean dQq = true;
    private boolean dQr = false;
    private CompoundButton.OnCheckedChangeListener dPU = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.dQj != null) {
                c.this.dQj.a(c.this.dQd, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.dQe.contains(aVar)) {
                        c.this.dQe.add(aVar);
                    }
                } else {
                    c.this.dQe.remove(aVar);
                }
            }
            c.this.aTX();
        }
    };
    private View.OnClickListener dQs = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dQd != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject M = c.this.M(arrayList);
                if (c.this.dQq) {
                    if (!StringUtils.isNull(c.this.dQd.getType())) {
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
                c.this.aTV();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.toastTime = 1500L;
                dVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.dQj != null) {
                    c.this.dQj.a(arrayList, c.this.aTW(), c.this.dQd);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener dQt = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.dQp != null) {
                c.this.dQp.setACRotateAnimation();
                c.this.dQp = null;
            }
            if (c.this.dQk != null) {
                c.this.dQk.dismiss();
                c.this.dQk = null;
            }
        }
    };
    private CustomMessageListener dQu = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aTV();
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
        this.dQi = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.dQf = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dQh = l.getDimens(this.mContext, R.dimen.tbds160);
        this.dQn = new b(this.mPageContext);
        this.dQn.a(this.dPU);
        this.mPageContext.registerListener(this.dQu);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dQu != null) {
                this.dQu.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dQu);
        }
    }

    public void R(View view) {
        if (this.mContext != null) {
            if (this.dQr || (this.dPR != null && this.dPR.size() != 0)) {
                this.dQp = (NEGFeedBackView) view;
                this.dQp.setCWRotateAnimation();
                View contentView = getContentView();
                this.dQf = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.dQf, this.dQh, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.dQf, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.dQt);
                resetState();
                this.dQk = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.dQk.setAttachedInDecor(false);
                }
                this.dQk.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.dQj != null) {
                        this.dQj.b(this.dQd);
                    }
                    this.dQo = true;
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
            this.dQl = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!aq.isEmpty(dQc)) {
                this.dQl.setText(dQc);
            }
            this.dQm = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.dQm.setOnClickListener(this.dQs);
            this.mContentView.setPadding(this.dQi, this.mMargin, this.dQi, this.dQi + this.mArrowHeight);
            if (this.dQr) {
                this.dQl.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.dQm.setLayoutParams(layoutParams);
            }
        }
        aFw();
        View view = this.dQn.getView();
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
        this.dQg = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.dQg;
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
            this.mContentView.setPadding(this.dQi, this.mMargin, this.dQi, this.dQi + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.dQi, this.mMargin + this.mArrowHeight, this.dQi, this.dQi);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject M(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.dQd == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.dQe)) {
            for (b.a aVar : this.dQe) {
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
            jSONObject.put("tid", this.dQd.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.dQd.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.dQd.getType())) {
                jSONObject.put("type", this.dQd.getType());
            }
            if (this.dQd.ayE() != 0) {
                jSONObject.put("topic_id", this.dQd.ayE());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aTW() {
        if (v.isEmpty(this.dQe)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.dQe) {
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
    public void aTX() {
        int size = this.dQe.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.dQl != null) {
                this.dQl.setText(spannableString);
            }
            if (this.dQm != null) {
                this.dQm.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.dQl != null) {
            if (!aq.isEmpty(dQc)) {
                this.dQl.setText(dQc);
            } else {
                this.dQl.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.dQm != null) {
            this.dQm.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.dQd = alVar;
            this.dPR = alVar.getFeedBackReasonMap();
            if (this.dPR != null && this.dPR.size() > 9) {
                for (int size = this.dPR.size() - 1; size >= 9; size--) {
                    this.dPR.removeAt(size);
                }
            }
            this.dQn.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dQn.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dQj = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.dQq = z;
    }

    public void setHeadText(String str) {
        if (!aq.isEmpty(str)) {
            dQc = str;
        }
    }

    public void ab(boolean z) {
        this.dQr = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dQn.setDefaultReasonArray(strArr);
    }

    public void aTV() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dQk != null) {
            this.dQk.dismiss();
            this.dQk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.dQu);
        aTV();
    }

    private void resetState() {
        if (this.dQo && this.dQe.size() != 0) {
            this.dQe.clear();
            aTX();
        }
    }

    private void aFw() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.dQl, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.dQm, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.dQm, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
