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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private int dcU;
    private int dcV;
    private int dcW;
    private int dcX;
    private PopupWindow dcZ;
    private TextView dda;
    private TextView ddb;
    private b ddc;
    private boolean ddd;
    private NEGFeedBackView dde;
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
    private aj dcS = null;
    private SparseArray<String> dcE = null;
    private List<b.a> dcT = new ArrayList();
    private NEGFeedBackView.a dcY = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener dcH = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.dcY != null) {
                c.this.dcY.a(c.this.dcS, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.dcT.contains(aVar)) {
                        c.this.dcT.add(aVar);
                    }
                } else {
                    c.this.dcT.remove(aVar);
                }
            }
            c.this.aBR();
        }
    };
    private View.OnClickListener ddf = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dcS != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject J = c.this.J(arrayList);
                if (!StringUtils.isNull(c.this.dcS.getType())) {
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, J);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, J);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.aBO();
                com.baidu.tbadk.core.view.e eVar = new com.baidu.tbadk.core.view.e();
                eVar.toastTime = 1500L;
                eVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.dcY != null) {
                    c.this.dcY.a(arrayList, c.this.aBQ(), c.this.dcS);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener ddg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.dde != null) {
                c.this.dde.setACRotateAnimation();
                c.this.dde = null;
            }
            if (c.this.dcZ != null) {
                c.this.dcZ.dismiss();
                c.this.dcZ = null;
            }
        }
    };
    private CustomMessageListener ddh = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aBO();
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
        this.dcX = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.dcU = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dcW = l.getDimens(this.mContext, R.dimen.tbds160);
        this.ddc = new b(this.mPageContext);
        this.ddc.a(this.dcH);
        this.mPageContext.registerListener(this.ddh);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ddh != null) {
                this.ddh.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ddh);
        }
    }

    public void O(View view) {
        if (this.mContext != null && this.dcE != null && this.dcE.size() != 0) {
            this.dde = (NEGFeedBackView) view;
            this.dde.setCWRotateAnimation();
            View contentView = getContentView();
            this.dcU = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.dcU, this.dcW, this.mYOffset, iArr);
            this.mPopupWindow = new PopupWindow(contentView, this.dcU, getWindowMeasuredHeight());
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.ddg);
            vf();
            this.dcZ = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dcZ.setAttachedInDecor(false);
            }
            this.dcZ.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                }
                this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.dcY != null) {
                    this.dcY.b(this.dcS);
                }
                this.ddd = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.dda = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.ddb = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.ddb.setOnClickListener(this.ddf);
            this.mContentView.setPadding(this.dcX, this.mMargin, this.dcX, this.dcX + this.mArrowHeight);
        }
        anO();
        View view = this.ddc.getView();
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
        this.dcV = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.dcV;
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
            this.mContentView.setPadding(this.dcX, this.mMargin, this.dcX, this.dcX + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.dcX, this.mMargin + this.mArrowHeight, this.dcX, this.dcX);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject J(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.dcS == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.dcT)) {
            for (b.a aVar : this.dcT) {
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
            jSONObject.put("tid", this.dcS.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.dcS.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.dcS.getType())) {
                jSONObject.put("type", this.dcS.getType());
            }
            if (this.dcS.aht() != 0) {
                jSONObject.put("topic_id", this.dcS.aht());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aBQ() {
        if (v.isEmpty(this.dcT)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.dcT) {
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
    public void aBR() {
        int size = this.dcT.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.dda != null) {
                this.dda.setText(spannableString);
            }
            if (this.ddb != null) {
                this.ddb.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.dda != null) {
            this.dda.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
        }
        if (this.ddb != null) {
            this.ddb.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.dcS = ajVar;
            this.dcE = ajVar.getFeedBackReasonMap();
            if (this.dcE != null && this.dcE.size() > 9) {
                for (int size = this.dcE.size() - 1; size >= 9; size--) {
                    this.dcE.removeAt(size);
                }
            }
            this.ddc.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.ddc.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcY = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ddc.setDefaultReasonArray(strArr);
    }

    public void aBO() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dcZ != null) {
            this.dcZ.dismiss();
            this.dcZ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.ddh);
        aBO();
    }

    private void vf() {
        if (this.ddd && this.dcT.size() != 0) {
            this.dcT.clear();
            aBR();
        }
    }

    private void anO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.dda, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.ddb, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.ddb, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
