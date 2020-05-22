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
import com.baidu.tbadk.core.data.ak;
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
    private static String eJt;
    private PopupWindow eJA;
    private TextView eJB;
    private TextView eJC;
    private b eJD;
    private boolean eJE;
    private NEGFeedBackView eJF;
    private int eJw;
    private int eJx;
    private int eJy;
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
    private ak eJu = null;
    private SparseArray<String> eJi = null;
    private List<b.a> eJv = new ArrayList();
    private NEGFeedBackView.a eJz = null;
    private int mSkinType = 3;
    private boolean eJG = true;
    private boolean eJH = false;
    private CompoundButton.OnCheckedChangeListener eJl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.eJz != null) {
                c.this.eJz.a(c.this.eJu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.eJv.contains(aVar)) {
                        c.this.eJv.add(aVar);
                    }
                } else {
                    c.this.eJv.remove(aVar);
                }
            }
            c.this.bkQ();
        }
    };
    private View.OnClickListener eJI = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.eJu != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject O = c.this.O(arrayList);
                if (c.this.eJG) {
                    if (!StringUtils.isNull(c.this.eJu.getType())) {
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
                c.this.bkO();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.toastTime = 1500L;
                cVar.showFailToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.eJz != null) {
                    c.this.eJz.a(arrayList, c.this.bkP(), c.this.eJu);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener eJJ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.eJF != null) {
                c.this.eJF.setACRotateAnimation();
                c.this.eJF = null;
            }
            if (c.this.eJA != null) {
                c.this.eJA.dismiss();
                c.this.eJA = null;
            }
        }
    };
    private CustomMessageListener eJK = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bkO();
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
        this.eJy = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.eJx = l.getDimens(this.mContext, R.dimen.tbds160);
        this.eJD = new b(this.mPageContext);
        this.eJD.a(this.eJl);
        this.mPageContext.registerListener(this.eJK);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.eJK != null) {
                this.eJK.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.eJK);
        }
    }

    public void S(View view) {
        if (this.mContext != null) {
            if (this.eJH || (this.eJi != null && this.eJi.size() != 0)) {
                this.eJF = (NEGFeedBackView) view;
                this.eJF.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.eJx, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.eJJ);
                resetState();
                this.eJA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.eJA.setAttachedInDecor(false);
                }
                this.eJA.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        am.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.eJz != null) {
                        this.eJz.b(this.eJu);
                    }
                    this.eJE = true;
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
            this.eJB = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!aq.isEmpty(eJt)) {
                this.eJB.setText(eJt);
            }
            this.eJC = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.eJC.setOnClickListener(this.eJI);
            this.mContentView.setPadding(this.eJy, this.mMargin, this.eJy, this.eJy + this.mArrowHeight);
            if (this.eJH) {
                this.eJB.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.eJC.setLayoutParams(layoutParams);
            }
        }
        aWq();
        View view = this.eJD.getView();
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
        this.eJw = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.eJw;
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
            this.mContentView.setPadding(this.eJy, this.mMargin, this.eJy, this.eJy + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.eJy, this.mMargin + this.mArrowHeight, this.eJy, this.eJy);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject O(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.eJu == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.isEmpty(this.eJv)) {
            for (b.a aVar : this.eJv) {
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
            jSONObject.put("tid", this.eJu.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.eJu.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.eJu.getType())) {
                jSONObject.put("type", this.eJu.getType());
            }
            if (this.eJu.aPd() != 0) {
                jSONObject.put("topic_id", this.eJu.aPd());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bkP() {
        if (v.isEmpty(this.eJv)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.eJv) {
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
    public void bkQ() {
        int size = this.eJv.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.eJB != null) {
                this.eJB.setText(spannableString);
            }
            if (this.eJC != null) {
                this.eJC.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.eJB != null) {
            if (!aq.isEmpty(eJt)) {
                this.eJB.setText(eJt);
            } else {
                this.eJB.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.eJC != null) {
            this.eJC.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(ak akVar) {
        if (akVar != null) {
            this.eJu = akVar;
            this.eJi = akVar.getFeedBackReasonMap();
            if (this.eJi != null && this.eJi.size() > 9) {
                for (int size = this.eJi.size() - 1; size >= 9; size--) {
                    this.eJi.removeAt(size);
                }
            }
            this.eJD.setData(akVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.eJD.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.eJz = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.eJG = z;
    }

    public void setHeadText(String str) {
        if (!aq.isEmpty(str)) {
            eJt = str;
        }
    }

    public void aF(boolean z) {
        this.eJH = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.eJD.setDefaultReasonArray(strArr);
    }

    public void bkO() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.eJA != null) {
            this.eJA.dismiss();
            this.eJA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.eJK);
        bkO();
    }

    private void resetState() {
        if (this.eJE && this.eJv.size() != 0) {
            this.eJv.clear();
            bkQ();
        }
    }

    private void aWq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.setViewTextColor(this.eJB, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.eJC, R.color.cp_cont_a, 1);
            am.setBackgroundResource(this.eJC, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
