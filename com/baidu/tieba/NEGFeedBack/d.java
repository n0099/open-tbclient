package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int aYJ;
    private int aYK;
    private int aYL;
    private int aYM;
    private PopupWindow aYO;
    private View aYP;
    private TextView aYQ;
    private TextView aYR;
    private b aYS;
    private boolean aYT;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow aYG = null;
    private ah aYH = null;
    private SparseArray<String> aYw = null;
    private List<b.a> aYI = new ArrayList();
    private c.a aYN = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener aYz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.aYN != null) {
                d.this.aYN.a(d.this.aYH, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.aYI.contains(aVar)) {
                        d.this.aYI.add(aVar);
                    }
                } else {
                    d.this.aYI.remove(aVar);
                }
            }
            d.this.Lf();
        }
    };
    private View.OnClickListener aYU = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.aYH != null && d.this.aYG != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject y = d.this.y(arrayList);
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, d.this.mPageContext.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, y);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                d.this.Le();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.alo = 1500L;
                cVar.d(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.aYN != null) {
                    d.this.aYN.a(arrayList, d.this.aYH);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aYV = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.aYO != null) {
                d.this.aYO.dismiss();
                d.this.aYO = null;
            }
        }
    };
    private CustomMessageListener aYW = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.Le();
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.aYP = view;
        init();
    }

    private void init() {
        this.aYM = l.f(this.mContext, d.e.tbds32);
        this.mYOffset = l.f(this.mContext, d.e.ds6);
        this.aYJ = l.ac(this.mContext) - (this.aYM * 2);
        this.aYL = l.f(this.mContext, d.e.ds120);
        this.aYS = new b(this.mPageContext);
        this.aYS.a(this.aYz);
        this.mPageContext.registerListener(this.aYW);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aYW != null) {
                this.aYW.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.aYW);
        }
    }

    public void Ld() {
        if (this.mContext != null && this.aYw != null && this.aYw.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aYG = new PopupWindow(contentView, this.aYJ, this.mWindowHeight);
            this.aYG.setFocusable(true);
            this.aYG.setTouchable(true);
            this.aYG.setOnDismissListener(this.aYV);
            Lg();
            this.aYO = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aYO.showAtLocation(this.aYP, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.aYP, this.mWindowHeight, this.aYJ, this.aYL, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aYG.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.aYG, d.f.bg_home_feedback_under);
                } else {
                    this.aYG.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.aYG, d.f.bg_home_feedback_top);
                }
                this.aYG.showAtLocation(this.aYP, 0, iArr[0] - this.aYM, iArr[1]);
                if (this.aYN != null) {
                    this.aYN.a(this.aYH);
                }
                this.aYT = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.aYQ = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.aYR = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.aYR.setOnClickListener(this.aYU);
        }
        wE();
        View view = this.aYS.getView();
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
        this.aYK = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.e.ds12);
        return this.aYK;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ae = l.ae(context);
        int ac = l.ac(context);
        boolean z = ((ae - iArr2[1]) - height) - i3 < i;
        iArr[0] = ac - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(8:4|(7:6|(2:7|(3:9|(2:11|(2:13|14)(1:16))(1:17)|15)(0))|19|(1:21)|22|23|24)(0)|18|19|(0)|22|23|24) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x0084, TryCatch #0 {Exception -> 0x0084, blocks: (B:18:0x0050, B:20:0x0062, B:21:0x006c), top: B:25:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject y(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.aYH == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.w(this.aYI)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYI.size()) {
                    b.a aVar = this.aYI.get(i2);
                    if (aVar != null) {
                        arrayList.add(Integer.valueOf(aVar.id));
                        if (sb.length() != 0) {
                            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    sb.append(String.valueOf(aVar.id));
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.aYH.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.aYH.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aYH.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.aYH.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf() {
        int size = this.aYI.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0082d.cp_link_tip_a)));
            this.aYQ.setText(spannableString);
            this.aYR.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.aYQ.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.aYR.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.aYH = ahVar;
            this.aYw = ahVar.qn();
            if (this.aYw != null && this.aYw.size() > 9) {
                for (int size = this.aYw.size() - 1; size >= 9; size--) {
                    this.aYw.removeAt(size);
                }
            }
            this.aYS.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYS.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.aYN = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYS.setDefaultReasonArray(strArr);
    }

    public void Le() {
        if (this.aYG != null) {
            this.aYG.dismiss();
            this.aYG = null;
        }
        if (this.aYO != null) {
            this.aYO.dismiss();
            this.aYO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.aYW);
        Le();
    }

    private void Lg() {
        if (this.aYT && this.aYI.size() != 0) {
            this.aYI.clear();
            Lf();
        }
    }

    private void wE() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.c(this.aYQ, d.C0082d.cp_cont_j, 1);
            aj.c(this.aYR, d.C0082d.cp_cont_i, 1);
            aj.j(this.aYR, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
