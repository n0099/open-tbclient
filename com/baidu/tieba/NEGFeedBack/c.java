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
import com.baidu.tbadk.core.data.ap;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    private static String eTQ;
    private int eTT;
    private int eTU;
    private int eTV;
    private PopupWindow eTX;
    private TextView eTY;
    private TextView eTZ;
    private b eUa;
    private boolean eUb;
    private NEGFeedBackView eUc;
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
    private ap eTR = null;
    private SparseArray<String> eTF = null;
    private List<b.a> eTS = new ArrayList();
    private NEGFeedBackView.a eTW = null;
    private int mSkinType = 3;
    private boolean eUd = true;
    private boolean eUe = false;
    private CompoundButton.OnCheckedChangeListener eTI = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.eTW != null) {
                c.this.eTW.a(c.this.eTR, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.eTS.contains(aVar)) {
                        c.this.eTS.add(aVar);
                    }
                } else {
                    c.this.eTS.remove(aVar);
                }
            }
            c.this.bns();
        }
    };
    private View.OnClickListener eUf = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.eTR != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject O = c.this.O(arrayList);
                if (c.this.eUd) {
                    if (!StringUtils.isNull(c.this.eTR.getType())) {
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
                c.this.bnq();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.toastTime = 1500L;
                cVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.eTW != null) {
                    c.this.eTW.a(arrayList, c.this.bnr(), c.this.eTR);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener eUg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.eUc != null) {
                c.this.eUc.setACRotateAnimation();
                c.this.eUc = null;
            }
            if (c.this.eTX != null) {
                c.this.eTX.dismiss();
                c.this.eTX = null;
            }
        }
    };
    private CustomMessageListener eUh = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bnq();
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
        this.eTV = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.eTU = l.getDimens(this.mContext, R.dimen.tbds160);
        this.eUa = new b(this.mPageContext);
        this.eUa.a(this.eTI);
        this.mPageContext.registerListener(this.eUh);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.eUh != null) {
                this.eUh.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eUh);
        }
    }

    public void L(View view) {
        if (this.mContext != null) {
            if (this.eUe || (this.eTF != null && this.eTF.size() != 0)) {
                this.eUc = (NEGFeedBackView) view;
                this.eUc.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.eTU, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.eUg);
                resetState();
                this.eTX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.eTX.setAttachedInDecor(false);
                }
                this.eTX.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        an.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        an.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.eTW != null) {
                        this.eTW.b(this.eTR);
                    }
                    this.eUb = true;
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
            this.eTY = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!ar.isEmpty(eTQ)) {
                this.eTY.setText(eTQ);
            }
            this.eTZ = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.eTZ.setOnClickListener(this.eUf);
            this.mContentView.setPadding(this.eTV, this.mMargin, this.eTV, this.eTV + this.mArrowHeight);
            if (this.eUe) {
                this.eTY.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.eTZ.setLayoutParams(layoutParams);
            }
        }
        aYj();
        View view = this.eUa.getView();
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
        this.eTT = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.eTT;
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
            this.mContentView.setPadding(this.eTV, this.mMargin, this.eTV, this.eTV + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.eTV, this.mMargin + this.mArrowHeight, this.eTV, this.eTV);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject O(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.eTR == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!w.isEmpty(this.eTS)) {
            for (b.a aVar : this.eTS) {
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
            jSONObject.put("tid", this.eTR.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.eTR.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.eTR.getType())) {
                jSONObject.put("type", this.eTR.getType());
            }
            if (this.eTR.aQO() != 0) {
                jSONObject.put("topic_id", this.eTR.aQO());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bnr() {
        if (w.isEmpty(this.eTS)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.eTS) {
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
    public void bns() {
        int size = this.eTS.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(an.getColor(R.color.cp_link_tip_a)));
            if (this.eTY != null) {
                this.eTY.setText(spannableString);
            }
            if (this.eTZ != null) {
                this.eTZ.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.eTY != null) {
            if (!ar.isEmpty(eTQ)) {
                this.eTY.setText(eTQ);
            } else {
                this.eTY.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.eTZ != null) {
            this.eTZ.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(ap apVar) {
        if (apVar != null) {
            this.eTR = apVar;
            this.eTF = apVar.getFeedBackReasonMap();
            if (this.eTF != null && this.eTF.size() > 9) {
                for (int size = this.eTF.size() - 1; size >= 9; size--) {
                    this.eTF.removeAt(size);
                }
            }
            this.eUa.setData(apVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eUa.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eTW = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.eUd = z;
    }

    public void setHeadText(String str) {
        if (!ar.isEmpty(str)) {
            eTQ = str;
        }
    }

    public void aG(boolean z) {
        this.eUe = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eUa.setDefaultReasonArray(strArr);
    }

    public void bnq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.eTX != null) {
            this.eTX.dismiss();
            this.eTX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eUh);
        bnq();
    }

    private void resetState() {
        if (this.eUb && this.eTS.size() != 0) {
            this.eTS.clear();
            bns();
        }
    }

    private void aYj() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            an.setViewTextColor(this.eTY, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.eTZ, R.color.cp_cont_a, 1);
            an.setBackgroundResource(this.eTZ, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
