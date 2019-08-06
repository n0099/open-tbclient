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
    private int cSG;
    private int cSH;
    private int cSI;
    private int cSJ;
    private PopupWindow cSL;
    private TextView cSM;
    private TextView cSN;
    private b cSO;
    private boolean cSP;
    private NEGFeedBackView cSQ;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow aPu = null;
    private aj cSE = null;
    private SparseArray<String> cSq = null;
    private List<b.a> cSF = new ArrayList();
    private NEGFeedBackView.a cSK = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener cSt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.cSK != null) {
                c.this.cSK.a(c.this.cSE, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.cSF.contains(aVar)) {
                        c.this.cSF.add(aVar);
                    }
                } else {
                    c.this.cSF.remove(aVar);
                }
            }
            c.this.aBs();
        }
    };
    private View.OnClickListener cSR = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.cSE != null && c.this.aPu != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject H = c.this.H(arrayList);
                if (!StringUtils.isNull(c.this.cSE.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, H);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, H);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.aBp();
                com.baidu.tbadk.core.view.e eVar = new com.baidu.tbadk.core.view.e();
                eVar.bYO = 1500L;
                eVar.j(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.cSK != null) {
                    c.this.cSK.a(arrayList, c.this.aBr(), c.this.cSE);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener cSS = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.cSQ != null) {
                c.this.cSQ.setACRotateAnimation();
                c.this.cSQ = null;
            }
            if (c.this.cSL != null) {
                c.this.cSL.dismiss();
                c.this.cSL = null;
            }
        }
    };
    private CustomMessageListener cST = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aBp();
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
        this.mXOffset = l.g(this.mContext, R.dimen.tbds44);
        this.mYOffset = l.g(this.mContext, R.dimen.tbds28);
        this.mMargin = l.g(this.mContext, R.dimen.tbds44);
        this.cSJ = l.g(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.g(this.mContext, R.dimen.tbds39);
        this.cSG = l.af(this.mContext) - (this.mXOffset * 2);
        this.cSI = l.g(this.mContext, R.dimen.tbds160);
        this.cSO = new b(this.mPageContext);
        this.cSO.a(this.cSt);
        this.mPageContext.registerListener(this.cST);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cST != null) {
                this.cST.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cST);
        }
    }

    public void bo(View view) {
        if (this.mContext != null && this.cSq != null && this.cSq.size() != 0) {
            this.cSQ = (NEGFeedBackView) view;
            this.cSQ.setCWRotateAnimation();
            View contentView = getContentView();
            this.cSG = l.af(this.mContext) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.cSG, this.cSI, this.mYOffset, iArr);
            this.aPu = new PopupWindow(contentView, this.cSG, getWindowMeasuredHeight());
            this.aPu.setFocusable(true);
            this.aPu.setTouchable(true);
            this.aPu.setOnDismissListener(this.cSS);
            aBt();
            this.cSL = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cSL.setAttachedInDecor(false);
            }
            this.cSL.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aPu.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.a(this.aPu, (int) R.drawable.bg_tost_feedback_down);
                } else {
                    this.aPu.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.a(this.aPu, (int) R.drawable.bg_tost_feedback_up);
                }
                this.aPu.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.cSK != null) {
                    this.cSK.b(this.cSE);
                }
                this.cSP = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.cSM = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cSN = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.cSN.setOnClickListener(this.cSR);
            this.mContentView.setPadding(this.cSJ, this.mMargin, this.cSJ, this.cSJ + this.mArrowHeight);
        }
        akN();
        View view = this.cSO.getView();
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
        this.cSH = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.cSH;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ah = l.ah(context);
        int af = l.af(context);
        boolean z = ((ah - iArr2[1]) - height) - i3 < i;
        iArr[0] = af - i2;
        if (z) {
            this.mContentView.setPadding(this.cSJ, this.mMargin, this.cSJ, this.cSJ + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.cSJ, this.mMargin + this.mArrowHeight, this.cSJ, this.cSJ);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject H(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.cSE == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.aa(this.cSF)) {
            for (b.a aVar : this.cSF) {
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
            jSONObject.put("tid", this.cSE.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.cSE.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.cSE.getType())) {
                jSONObject.put("type", this.cSE.getType());
            }
            if (this.cSE.adk() != 0) {
                jSONObject.put("topic_id", this.cSE.adk());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aBr() {
        if (v.aa(this.cSF)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.cSF) {
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
    public void aBs() {
        int size = this.cSF.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.cSM != null) {
                this.cSM.setText(spannableString);
            }
            if (this.cSN != null) {
                this.cSN.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.cSM != null) {
            this.cSM.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
        }
        if (this.cSN != null) {
            this.cSN.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cSE = ajVar;
            this.cSq = ajVar.adh();
            if (this.cSq != null && this.cSq.size() > 9) {
                for (int size = this.cSq.size() - 1; size >= 9; size--) {
                    this.cSq.removeAt(size);
                }
            }
            this.cSO.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cSO.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSK = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cSO.setDefaultReasonArray(strArr);
    }

    public void aBp() {
        if (this.aPu != null) {
            this.aPu.dismiss();
            this.aPu = null;
        }
        if (this.cSL != null) {
            this.cSL.dismiss();
            this.cSL = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.cST);
        aBp();
    }

    private void aBt() {
        if (this.cSP && this.cSF.size() != 0) {
            this.cSF.clear();
            aBs();
        }
    }

    private void akN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.f(this.cSM, R.color.cp_cont_b, 1);
            am.f(this.cSN, R.color.cp_btn_a, 1);
            am.k(this.cSN, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
