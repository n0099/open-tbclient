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
import com.baidu.tbadk.core.data.al;
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
    private int aVD;
    private int aVE;
    private int aVF;
    private int aVG;
    private PopupWindow aVI;
    private View aVJ;
    private TextView aVK;
    private TextView aVL;
    private b aVM;
    private boolean aVN;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mG;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow aVA = null;
    private al aVB = null;
    private SparseArray<String> aVq = null;
    private List<b.a> aVC = new ArrayList();
    private c.a aVH = null;
    private CompoundButton.OnCheckedChangeListener aVt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.aVH != null) {
                d.this.aVH.a(d.this.aVB, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.aVC.contains(aVar)) {
                        d.this.aVC.add(aVar);
                    }
                } else {
                    d.this.aVC.remove(aVar);
                }
            }
            d.this.Kv();
        }
    };
    private View.OnClickListener aVO = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.aVB != null && d.this.aVA != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject x = d.this.x(arrayList);
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, d.this.mG.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, x);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                d.this.Kt();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.akH = 1500L;
                cVar.d(d.this.mContext.getResources().getString(d.l.reduce_related_thread_recommend));
                if (d.this.aVH != null) {
                    d.this.aVH.a(arrayList, d.this.aVB);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aVP = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.aVI != null) {
                d.this.aVI.dismiss();
                d.this.aVI = null;
            }
        }
    };
    private CustomMessageListener aVQ = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.Kt();
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mG = tbPageContext;
        this.aVJ = view;
        init();
    }

    private void init() {
        this.aVG = l.f(this.mContext, d.f.ds34);
        this.mYOffset = l.f(this.mContext, d.f.ds6);
        this.aVD = l.ad(this.mContext) - (this.aVG * 2);
        this.aVF = l.f(this.mContext, d.f.ds120);
        this.aVM = new b(this.mG);
        this.aVM.a(this.aVt);
        this.mG.registerListener(this.aVQ);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aVQ != null) {
                this.aVQ.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.aVQ);
        }
    }

    public void Ks() {
        if (this.mContext != null && this.aVq != null && this.aVq.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = Ku();
            this.aVA = new PopupWindow(contentView, this.aVD, this.mWindowHeight);
            this.aVA.setFocusable(true);
            this.aVA.setTouchable(true);
            this.aVA.setOnDismissListener(this.aVP);
            Kw();
            this.aVI = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.j.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aVI.showAtLocation(this.aVJ, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.aVJ, this.mWindowHeight, this.aVD, this.aVF, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aVA.setAnimationStyle(d.m.scale_rb2lt_anim);
                    aj.a(this.aVA, d.g.bg_home_feedback_under);
                } else {
                    this.aVA.setAnimationStyle(d.m.scale_rt2lb_anim);
                    aj.a(this.aVA, d.g.bg_home_feedback_top);
                }
                this.aVA.showAtLocation(this.aVJ, 0, iArr[0] - this.aVG, iArr[1]);
                if (this.aVH != null) {
                    this.aVH.a(this.aVB);
                }
                this.aVN = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.j.neg_feedback_popupwindow, (ViewGroup) null);
            this.aVK = (TextView) this.mContentView.findViewById(d.h.head_text);
            this.aVL = (TextView) this.mContentView.findViewById(d.h.uninterested_text);
            this.aVL.setOnClickListener(this.aVO);
            aj.c(this.aVK, d.e.cp_cont_j, 1);
            aj.c(this.aVL, d.e.cp_cont_i, 1);
            aj.j(this.aVL, d.g.bg_blue_rec_n);
        }
        View view = this.aVM.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int Ku() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.aVE = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.f.ds12);
        return this.aVE;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int af = l.af(context);
        int ad = l.ad(context);
        boolean z = ((af - iArr2[1]) - height) - i3 < i;
        iArr[0] = ad - i2;
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
    public JSONObject x(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.aVB == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.u(this.aVC)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aVC.size()) {
                    b.a aVar = this.aVC.get(i2);
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
            jSONObject.put("tid", this.aVB.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.aVB.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aVB.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.aVB.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv() {
        int size = this.aVC.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.l.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)));
            this.aVK.setText(spannableString);
            this.aVL.setText(this.mContext.getResources().getString(d.l.confirm));
            return;
        }
        this.aVK.setText(this.mContext.getResources().getString(d.l.tell_us_reason));
        this.aVL.setText(this.mContext.getResources().getString(d.l.not_interested));
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.aVB = alVar;
            this.aVq = alVar.qm();
            if (this.aVq != null && this.aVq.size() > 9) {
                for (int size = this.aVq.size() - 1; size >= 9; size--) {
                    this.aVq.removeAt(size);
                }
            }
            this.aVM.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVM.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.aVH = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVM.setDefaultReasonArray(strArr);
    }

    public void Kt() {
        if (this.aVA != null) {
            this.aVA.dismiss();
            this.aVA = null;
        }
        if (this.aVI != null) {
            this.aVI.dismiss();
            this.aVI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.aVQ);
        Kt();
    }

    private void Kw() {
        if (this.aVN && this.aVC.size() != 0) {
            this.aVC.clear();
            Kv();
        }
    }
}
