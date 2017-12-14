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
    private int aYL;
    private int aYM;
    private int aYN;
    private int aYO;
    private PopupWindow aYQ;
    private View aYR;
    private TextView aYS;
    private TextView aYT;
    private b aYU;
    private boolean aYV;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow aYI = null;
    private ah aYJ = null;
    private SparseArray<String> aYy = null;
    private List<b.a> aYK = new ArrayList();
    private c.a aYP = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener aYB = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.aYP != null) {
                d.this.aYP.a(d.this.aYJ, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.aYK.contains(aVar)) {
                        d.this.aYK.add(aVar);
                    }
                } else {
                    d.this.aYK.remove(aVar);
                }
            }
            d.this.Lf();
        }
    };
    private View.OnClickListener aYW = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.aYJ != null && d.this.aYI != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject y = d.this.y(arrayList);
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, d.this.mPageContext.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, y);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                d.this.Le();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.alk = 1500L;
                dVar.d(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.aYP != null) {
                    d.this.aYP.a(arrayList, d.this.aYJ);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aYX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.aYQ != null) {
                d.this.aYQ.dismiss();
                d.this.aYQ = null;
            }
        }
    };
    private CustomMessageListener aYY = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
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
        this.aYR = view;
        init();
    }

    private void init() {
        this.aYO = l.f(this.mContext, d.e.tbds32);
        this.mYOffset = l.f(this.mContext, d.e.ds6);
        this.aYL = l.ac(this.mContext) - (this.aYO * 2);
        this.aYN = l.f(this.mContext, d.e.ds120);
        this.aYU = new b(this.mPageContext);
        this.aYU.a(this.aYB);
        this.mPageContext.registerListener(this.aYY);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aYY != null) {
                this.aYY.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.aYY);
        }
    }

    public void Ld() {
        if (this.mContext != null && this.aYy != null && this.aYy.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aYI = new PopupWindow(contentView, this.aYL, this.mWindowHeight);
            this.aYI.setFocusable(true);
            this.aYI.setTouchable(true);
            this.aYI.setOnDismissListener(this.aYX);
            Lg();
            this.aYQ = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aYQ.showAtLocation(this.aYR, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.aYR, this.mWindowHeight, this.aYL, this.aYN, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aYI.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.aYI, d.f.bg_home_feedback_under);
                } else {
                    this.aYI.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.aYI, d.f.bg_home_feedback_top);
                }
                this.aYI.showAtLocation(this.aYR, 0, iArr[0] - this.aYO, iArr[1]);
                if (this.aYP != null) {
                    this.aYP.a(this.aYJ);
                }
                this.aYV = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.aYS = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.aYT = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.aYT.setOnClickListener(this.aYW);
        }
        wC();
        View view = this.aYU.getView();
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
        this.aYM = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.e.ds12);
        return this.aYM;
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
        if (this.aYJ == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.w(this.aYK)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYK.size()) {
                    b.a aVar = this.aYK.get(i2);
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
            jSONObject.put("tid", this.aYJ.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.aYJ.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aYJ.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.aYJ.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lf() {
        int size = this.aYK.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0096d.cp_link_tip_a)));
            this.aYS.setText(spannableString);
            this.aYT.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.aYS.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.aYT.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.aYJ = ahVar;
            this.aYy = ahVar.ql();
            if (this.aYy != null && this.aYy.size() > 9) {
                for (int size = this.aYy.size() - 1; size >= 9; size--) {
                    this.aYy.removeAt(size);
                }
            }
            this.aYU.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYU.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.aYP = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYU.setDefaultReasonArray(strArr);
    }

    public void Le() {
        if (this.aYI != null) {
            this.aYI.dismiss();
            this.aYI = null;
        }
        if (this.aYQ != null) {
            this.aYQ.dismiss();
            this.aYQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.aYY);
        Le();
    }

    private void Lg() {
        if (this.aYV && this.aYK.size() != 0) {
            this.aYK.clear();
            Lf();
        }
    }

    private void wC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.c(this.aYS, d.C0096d.cp_cont_j, 1);
            aj.c(this.aYT, d.C0096d.cp_cont_i, 1);
            aj.j(this.aYT, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
