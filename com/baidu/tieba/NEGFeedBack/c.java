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
    private int cSA;
    private int cSB;
    private int cSC;
    private PopupWindow cSE;
    private TextView cSF;
    private TextView cSG;
    private b cSH;
    private boolean cSI;
    private NEGFeedBackView cSJ;
    private int cSz;
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
    private aj cSx = null;
    private SparseArray<String> cSj = null;
    private List<b.a> cSy = new ArrayList();
    private NEGFeedBackView.a cSD = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener cSm = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.cSD != null) {
                c.this.cSD.a(c.this.cSx, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.cSy.contains(aVar)) {
                        c.this.cSy.add(aVar);
                    }
                } else {
                    c.this.cSy.remove(aVar);
                }
            }
            c.this.aBq();
        }
    };
    private View.OnClickListener cSK = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.cSx != null && c.this.aPu != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject H = c.this.H(arrayList);
                if (!StringUtils.isNull(c.this.cSx.getType())) {
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
                c.this.aBn();
                com.baidu.tbadk.core.view.e eVar = new com.baidu.tbadk.core.view.e();
                eVar.bYI = 1500L;
                eVar.j(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.cSD != null) {
                    c.this.cSD.a(arrayList, c.this.aBp(), c.this.cSx);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener cSL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.cSJ != null) {
                c.this.cSJ.setACRotateAnimation();
                c.this.cSJ = null;
            }
            if (c.this.cSE != null) {
                c.this.cSE.dismiss();
                c.this.cSE = null;
            }
        }
    };
    private CustomMessageListener cSM = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.aBn();
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
        this.cSC = l.g(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.g(this.mContext, R.dimen.tbds39);
        this.cSz = l.af(this.mContext) - (this.mXOffset * 2);
        this.cSB = l.g(this.mContext, R.dimen.tbds160);
        this.cSH = new b(this.mPageContext);
        this.cSH.a(this.cSm);
        this.mPageContext.registerListener(this.cSM);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cSM != null) {
                this.cSM.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cSM);
        }
    }

    public void bo(View view) {
        if (this.mContext != null && this.cSj != null && this.cSj.size() != 0) {
            this.cSJ = (NEGFeedBackView) view;
            this.cSJ.setCWRotateAnimation();
            View contentView = getContentView();
            this.cSz = l.af(this.mContext) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.cSz, this.cSB, this.mYOffset, iArr);
            this.aPu = new PopupWindow(contentView, this.cSz, getWindowMeasuredHeight());
            this.aPu.setFocusable(true);
            this.aPu.setTouchable(true);
            this.aPu.setOnDismissListener(this.cSL);
            aBr();
            this.cSE = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cSE.setAttachedInDecor(false);
            }
            this.cSE.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aPu.setAnimationStyle(R.style.scale_rb2lt_anim);
                    am.a(this.aPu, (int) R.drawable.bg_tost_feedback_down);
                } else {
                    this.aPu.setAnimationStyle(R.style.scale_rt2lb_anim);
                    am.a(this.aPu, (int) R.drawable.bg_tost_feedback_up);
                }
                this.aPu.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.cSD != null) {
                    this.cSD.b(this.cSx);
                }
                this.cSI = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.cSF = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cSG = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.cSG.setOnClickListener(this.cSK);
            this.mContentView.setPadding(this.cSC, this.mMargin, this.cSC, this.cSC + this.mArrowHeight);
        }
        akL();
        View view = this.cSH.getView();
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
        this.cSA = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.cSA;
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
            this.mContentView.setPadding(this.cSC, this.mMargin, this.cSC, this.cSC + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.cSC, this.mMargin + this.mArrowHeight, this.cSC, this.cSC);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject H(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.cSx == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.aa(this.cSy)) {
            for (b.a aVar : this.cSy) {
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
            jSONObject.put("tid", this.cSx.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.cSx.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.cSx.getType())) {
                jSONObject.put("type", this.cSx.getType());
            }
            if (this.cSx.adj() != 0) {
                jSONObject.put("topic_id", this.cSx.adj());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aBp() {
        if (v.aa(this.cSy)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.cSy) {
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
    public void aBq() {
        int size = this.cSy.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(R.color.cp_link_tip_a)));
            if (this.cSF != null) {
                this.cSF.setText(spannableString);
            }
            if (this.cSG != null) {
                this.cSG.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.cSF != null) {
            this.cSF.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
        }
        if (this.cSG != null) {
            this.cSG.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cSx = ajVar;
            this.cSj = ajVar.adg();
            if (this.cSj != null && this.cSj.size() > 9) {
                for (int size = this.cSj.size() - 1; size >= 9; size--) {
                    this.cSj.removeAt(size);
                }
            }
            this.cSH.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cSH.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cSD = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cSH.setDefaultReasonArray(strArr);
    }

    public void aBn() {
        if (this.aPu != null) {
            this.aPu.dismiss();
            this.aPu = null;
        }
        if (this.cSE != null) {
            this.cSE.dismiss();
            this.cSE = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.cSM);
        aBn();
    }

    private void aBr() {
        if (this.cSI && this.cSy.size() != 0) {
            this.cSy.clear();
            aBq();
        }
    }

    private void akL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.f(this.cSF, R.color.cp_cont_b, 1);
            am.f(this.cSG, R.color.cp_btn_a, 1);
            am.k(this.cSG, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
