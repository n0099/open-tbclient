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
    private static String euR;
    private int euU;
    private int euV;
    private int euW;
    private PopupWindow euY;
    private TextView euZ;
    private TextView eva;
    private b evb;
    private boolean evc;
    private NEGFeedBackView evd;
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
    private al euS = null;
    private SparseArray<String> euG = null;
    private List<b.a> euT = new ArrayList();
    private NEGFeedBackView.a euX = null;
    private int mSkinType = 3;
    private boolean eve = true;
    private boolean evf = false;
    private CompoundButton.OnCheckedChangeListener euJ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.euX != null) {
                c.this.euX.a(c.this.euS, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.euT.contains(aVar)) {
                        c.this.euT.add(aVar);
                    }
                } else {
                    c.this.euT.remove(aVar);
                }
            }
            c.this.beD();
        }
    };
    private View.OnClickListener evg = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.euS != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject O = c.this.O(arrayList);
                if (c.this.eve) {
                    if (!StringUtils.isNull(c.this.euS.getType())) {
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
                c.this.beB();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.toastTime = 1500L;
                dVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.euX != null) {
                    c.this.euX.a(arrayList, c.this.beC(), c.this.euS);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener evh = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.evd != null) {
                c.this.evd.setACRotateAnimation();
                c.this.evd = null;
            }
            if (c.this.euY != null) {
                c.this.euY.dismiss();
                c.this.euY = null;
            }
        }
    };
    private CustomMessageListener evi = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.beB();
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
        this.euW = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.euV = l.getDimens(this.mContext, R.dimen.tbds160);
        this.evb = new b(this.mPageContext);
        this.evb.a(this.euJ);
        this.mPageContext.registerListener(this.evi);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.evi != null) {
                this.evi.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.evi);
        }
    }

    public void T(View view) {
        if (this.mContext != null) {
            if (this.evf || (this.euG != null && this.euG.size() != 0)) {
                this.evd = (NEGFeedBackView) view;
                this.evd.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.euV, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.evh);
                resetState();
                this.euY = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.euY.setAttachedInDecor(false);
                }
                this.euY.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.euX != null) {
                        this.euX.b(this.euS);
                    }
                    this.evc = true;
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
            this.euZ = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!aq.isEmpty(euR)) {
                this.euZ.setText(euR);
            }
            this.eva = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.eva.setOnClickListener(this.evg);
            this.mContentView.setPadding(this.euW, this.mMargin, this.euW, this.euW + this.mArrowHeight);
            if (this.evf) {
                this.euZ.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.eva.setLayoutParams(layoutParams);
            }
        }
        aQm();
        View view = this.evb.getView();
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
        this.euU = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.euU;
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
            this.mContentView.setPadding(this.euW, this.mMargin, this.euW, this.euW + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.euW, this.mMargin + this.mArrowHeight, this.euW, this.euW);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject O(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.euS == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.euT)) {
            for (b.a aVar : this.euT) {
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
            jSONObject.put("tid", this.euS.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.euS.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.euS.getType())) {
                jSONObject.put("type", this.euS.getType());
            }
            if (this.euS.aJi() != 0) {
                jSONObject.put("topic_id", this.euS.aJi());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String beC() {
        if (v.isEmpty(this.euT)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.euT) {
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
    public void beD() {
        int size = this.euT.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.euZ != null) {
                this.euZ.setText(spannableString);
            }
            if (this.eva != null) {
                this.eva.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.euZ != null) {
            if (!aq.isEmpty(euR)) {
                this.euZ.setText(euR);
            } else {
                this.euZ.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.eva != null) {
            this.eva.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.euS = alVar;
            this.euG = alVar.getFeedBackReasonMap();
            if (this.euG != null && this.euG.size() > 9) {
                for (int size = this.euG.size() - 1; size >= 9; size--) {
                    this.euG.removeAt(size);
                }
            }
            this.evb.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.evb.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.euX = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.eve = z;
    }

    public void setHeadText(String str) {
        if (!aq.isEmpty(str)) {
            euR = str;
        }
    }

    public void aD(boolean z) {
        this.evf = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.evb.setDefaultReasonArray(strArr);
    }

    public void beB() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.euY != null) {
            this.euY.dismiss();
            this.euY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.evi);
        beB();
    }

    private void resetState() {
        if (this.evc && this.euT.size() != 0) {
            this.euT.clear();
            beD();
        }
    }

    private void aQm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.euZ, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eva, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.eva, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
