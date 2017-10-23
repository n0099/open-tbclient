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
    private boolean aVA;
    private int aVq;
    private int aVr;
    private int aVs;
    private int aVt;
    private PopupWindow aVv;
    private View aVw;
    private TextView aVx;
    private TextView aVy;
    private b aVz;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mH;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow aVn = null;
    private al aVo = null;
    private SparseArray<String> aVd = null;
    private List<b.a> aVp = new ArrayList();
    private c.a aVu = null;
    private CompoundButton.OnCheckedChangeListener aVg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.aVu != null) {
                d.this.aVu.a(d.this.aVo, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.aVp.contains(aVar)) {
                        d.this.aVp.add(aVar);
                    }
                } else {
                    d.this.aVp.remove(aVar);
                }
            }
            d.this.Kp();
        }
    };
    private View.OnClickListener aVB = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.aVo != null && d.this.aVn != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject x = d.this.x(arrayList);
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, d.this.mH.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, x);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                d.this.Kn();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.akv = 1500L;
                cVar.d(d.this.mContext.getResources().getString(d.l.reduce_related_thread_recommend));
                if (d.this.aVu != null) {
                    d.this.aVu.a(arrayList, d.this.aVo);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aVC = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.aVv != null) {
                d.this.aVv.dismiss();
                d.this.aVv = null;
            }
        }
    };
    private CustomMessageListener aVD = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.Kn();
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mH = tbPageContext;
        this.aVw = view;
        init();
    }

    private void init() {
        this.aVt = l.f(this.mContext, d.f.ds34);
        this.mYOffset = l.f(this.mContext, d.f.ds6);
        this.aVq = l.ad(this.mContext) - (this.aVt * 2);
        this.aVs = l.f(this.mContext, d.f.ds120);
        this.aVz = new b(this.mH);
        this.aVz.a(this.aVg);
        this.mH.registerListener(this.aVD);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aVD != null) {
                this.aVD.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.aVD);
        }
    }

    public void Km() {
        if (this.mContext != null && this.aVd != null && this.aVd.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = Ko();
            this.aVn = new PopupWindow(contentView, this.aVq, this.mWindowHeight);
            this.aVn.setFocusable(true);
            this.aVn.setTouchable(true);
            this.aVn.setOnDismissListener(this.aVC);
            Kq();
            this.aVv = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.j.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aVv.showAtLocation(this.aVw, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.aVw, this.mWindowHeight, this.aVq, this.aVs, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aVn.setAnimationStyle(d.m.scale_rb2lt_anim);
                    aj.a(this.aVn, d.g.bg_home_feedback_under);
                } else {
                    this.aVn.setAnimationStyle(d.m.scale_rt2lb_anim);
                    aj.a(this.aVn, d.g.bg_home_feedback_top);
                }
                this.aVn.showAtLocation(this.aVw, 0, iArr[0] - this.aVt, iArr[1]);
                if (this.aVu != null) {
                    this.aVu.a(this.aVo);
                }
                this.aVA = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.j.neg_feedback_popupwindow, (ViewGroup) null);
            this.aVx = (TextView) this.mContentView.findViewById(d.h.head_text);
            this.aVy = (TextView) this.mContentView.findViewById(d.h.uninterested_text);
            this.aVy.setOnClickListener(this.aVB);
            aj.c(this.aVx, d.e.cp_cont_j, 1);
            aj.c(this.aVy, d.e.cp_cont_i, 1);
            aj.j(this.aVy, d.g.bg_blue_rec_n);
        }
        View view = this.aVz.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int Ko() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.aVr = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.f.ds12);
        return this.aVr;
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
        if (this.aVo == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.u(this.aVp)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aVp.size()) {
                    b.a aVar = this.aVp.get(i2);
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
            jSONObject.put("tid", this.aVo.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.aVo.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aVo.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put("fid", this.aVo.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kp() {
        int size = this.aVp.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.l.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.e.cp_link_tip_a)));
            this.aVx.setText(spannableString);
            this.aVy.setText(this.mContext.getResources().getString(d.l.confirm));
            return;
        }
        this.aVx.setText(this.mContext.getResources().getString(d.l.tell_us_reason));
        this.aVy.setText(this.mContext.getResources().getString(d.l.not_interested));
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.aVo = alVar;
            this.aVd = alVar.qf();
            if (this.aVd != null && this.aVd.size() > 9) {
                for (int size = this.aVd.size() - 1; size >= 9; size--) {
                    this.aVd.removeAt(size);
                }
            }
            this.aVz.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVz.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.aVu = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVz.setDefaultReasonArray(strArr);
    }

    public void Kn() {
        if (this.aVn != null) {
            this.aVn.dismiss();
            this.aVn = null;
        }
        if (this.aVv != null) {
            this.aVv.dismiss();
            this.aVv = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.aVD);
        Kn();
    }

    private void Kq() {
        if (this.aVA && this.aVp.size() != 0) {
            this.aVp.clear();
            Kp();
        }
    }
}
