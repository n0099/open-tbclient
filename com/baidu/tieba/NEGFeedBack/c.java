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
    private int dcc;
    private int dcd;
    private int dce;
    private int dcf;
    private PopupWindow dch;
    private TextView dci;
    private TextView dcj;
    private b dck;
    private boolean dcl;
    private NEGFeedBackView dcm;
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
    private aj dca = null;
    private SparseArray<String> dbM = null;
    private List<b.a> dcb = new ArrayList();
    private NEGFeedBackView.a dcg = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener dbP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.dcg != null) {
                c.this.dcg.a(c.this.dca, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.dcb.contains(aVar)) {
                        c.this.dcb.add(aVar);
                    }
                } else {
                    c.this.dcb.remove(aVar);
                }
            }
            c.this.aBP();
        }
    };
    private View.OnClickListener dcn = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dca != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject J = c.this.J(arrayList);
                if (!StringUtils.isNull(c.this.dca.getType())) {
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
                c.this.aBM();
                com.baidu.tbadk.core.view.e eVar = new com.baidu.tbadk.core.view.e();
                eVar.toastTime = 1500L;
                eVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.dcg != null) {
                    c.this.dcg.a(arrayList, c.this.aBO(), c.this.dca);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener dco = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.dcm != null) {
                c.this.dcm.setACRotateAnimation();
                c.this.dcm = null;
            }
            if (c.this.dch != null) {
                c.this.dch.dismiss();
                c.this.dch = null;
            }
        }
    };
    private CustomMessageListener dcp = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aBM();
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
        this.dcf = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.dcc = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.dce = l.getDimens(this.mContext, R.dimen.tbds160);
        this.dck = new b(this.mPageContext);
        this.dck.a(this.dbP);
        this.mPageContext.registerListener(this.dcp);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.dcp != null) {
                this.dcp.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.dcp);
        }
    }

    public void O(View view) {
        if (this.mContext != null && this.dbM != null && this.dbM.size() != 0) {
            this.dcm = (NEGFeedBackView) view;
            this.dcm.setCWRotateAnimation();
            View contentView = getContentView();
            this.dcc = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.dcc, this.dce, this.mYOffset, iArr);
            this.mPopupWindow = new PopupWindow(contentView, this.dcc, getWindowMeasuredHeight());
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.dco);
            vg();
            this.dch = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.dch.setAttachedInDecor(false);
            }
            this.dch.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                } else {
                    this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                }
                this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.dcg != null) {
                    this.dcg.b(this.dca);
                }
                this.dcl = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.dci = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.dcj = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.dcj.setOnClickListener(this.dcn);
            this.mContentView.setPadding(this.dcf, this.mMargin, this.dcf, this.dcf + this.mArrowHeight);
        }
        anM();
        View view = this.dck.getView();
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
        this.dcd = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.dcd;
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
            this.mContentView.setPadding(this.dcf, this.mMargin, this.dcf, this.dcf + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.dcf, this.mMargin + this.mArrowHeight, this.dcf, this.dcf);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject J(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.dca == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.dcb)) {
            for (b.a aVar : this.dcb) {
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
            jSONObject.put("tid", this.dca.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.dca.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.dca.getType())) {
                jSONObject.put("type", this.dca.getType());
            }
            if (this.dca.ahr() != 0) {
                jSONObject.put("topic_id", this.dca.ahr());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aBO() {
        if (v.isEmpty(this.dcb)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.dcb) {
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
    public void aBP() {
        int size = this.dcb.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.dci != null) {
                this.dci.setText(spannableString);
            }
            if (this.dcj != null) {
                this.dcj.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.dci != null) {
            this.dci.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
        }
        if (this.dcj != null) {
            this.dcj.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.dca = ajVar;
            this.dbM = ajVar.getFeedBackReasonMap();
            if (this.dbM != null && this.dbM.size() > 9) {
                for (int size = this.dbM.size() - 1; size >= 9; size--) {
                    this.dbM.removeAt(size);
                }
            }
            this.dck.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.dck.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.dcg = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.dck.setDefaultReasonArray(strArr);
    }

    public void aBM() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.dch != null) {
            this.dch.dismiss();
            this.dch = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.dcp);
        aBM();
    }

    private void vg() {
        if (this.dcl && this.dcb.size() != 0) {
            this.dcb.clear();
            aBP();
        }
    }

    private void anM() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.dci, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.dcj, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.dcj, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
