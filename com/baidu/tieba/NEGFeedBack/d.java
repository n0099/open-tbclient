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
    private int aVI;
    private int aVJ;
    private int aVK;
    private int aVL;
    private PopupWindow aVN;
    private View aVO;
    private TextView aVP;
    private TextView aVQ;
    private b aVR;
    private boolean aVS;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow aVF = null;
    private al aVG = null;
    private SparseArray<String> aVv = null;
    private List<b.a> aVH = new ArrayList();
    private c.a aVM = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener aVy = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.aVM != null) {
                d.this.aVM.a(d.this.aVG, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.aVH.contains(aVar)) {
                        d.this.aVH.add(aVar);
                    }
                } else {
                    d.this.aVH.remove(aVar);
                }
            }
            d.this.KJ();
        }
    };
    private View.OnClickListener aVT = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.aVG != null && d.this.aVF != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject y = d.this.y(arrayList);
                CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, d.this.mPageContext.getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, y);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                d.this.KH();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.akR = 1500L;
                cVar.d(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.aVM != null) {
                    d.this.aVM.a(arrayList, d.this.aVG);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aVU = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.aVN != null) {
                d.this.aVN.dismiss();
                d.this.aVN = null;
            }
        }
    };
    private CustomMessageListener aVV = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.KH();
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.aVO = view;
        init();
    }

    private void init() {
        this.aVL = l.f(this.mContext, d.e.ds34);
        this.mYOffset = l.f(this.mContext, d.e.ds6);
        this.aVI = l.ac(this.mContext) - (this.aVL * 2);
        this.aVK = l.f(this.mContext, d.e.ds120);
        this.aVR = new b(this.mPageContext);
        this.aVR.a(this.aVy);
        this.mPageContext.registerListener(this.aVV);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aVV != null) {
                this.aVV.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.aVV);
        }
    }

    public void KG() {
        if (this.mContext != null && this.aVv != null && this.aVv.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = KI();
            this.aVF = new PopupWindow(contentView, this.aVI, this.mWindowHeight);
            this.aVF.setFocusable(true);
            this.aVF.setTouchable(true);
            this.aVF.setOnDismissListener(this.aVU);
            KK();
            this.aVN = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            this.aVN.showAtLocation(this.aVO, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.aVO, this.mWindowHeight, this.aVI, this.aVK, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aVF.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.aVF, d.f.bg_home_feedback_under);
                } else {
                    this.aVF.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.aVF, d.f.bg_home_feedback_top);
                }
                this.aVF.showAtLocation(this.aVO, 0, iArr[0] - this.aVL, iArr[1]);
                if (this.aVM != null) {
                    this.aVM.a(this.aVG);
                }
                this.aVS = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.aVP = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.aVQ = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.aVQ.setOnClickListener(this.aVT);
        }
        wB();
        View view = this.aVR.getView();
        if (view != null && view.getParent() == null) {
            this.mContentView.addView(view);
        }
        return this.mContentView;
    }

    private int KI() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.aVJ = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.e.ds12);
        return this.aVJ;
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
        if (this.aVG == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.v(this.aVH)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aVH.size()) {
                    b.a aVar = this.aVH.get(i2);
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
            jSONObject.put("tid", this.aVG.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.aVG.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            return jSONObject;
        }
        jSONObject.put("tid", this.aVG.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.aVG.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KJ() {
        int size = this.aVH.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0080d.cp_link_tip_a)));
            this.aVP.setText(spannableString);
            this.aVQ.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.aVP.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.aVQ.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(al alVar) {
        if (alVar != null) {
            this.aVG = alVar;
            this.aVv = alVar.qk();
            if (this.aVv != null && this.aVv.size() > 9) {
                for (int size = this.aVv.size() - 1; size >= 9; size--) {
                    this.aVv.removeAt(size);
                }
            }
            this.aVR.setData(alVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVR.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.aVM = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVR.setDefaultReasonArray(strArr);
    }

    public void KH() {
        if (this.aVF != null) {
            this.aVF.dismiss();
            this.aVF = null;
        }
        if (this.aVN != null) {
            this.aVN.dismiss();
            this.aVN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.aVV);
        KH();
    }

    private void KK() {
        if (this.aVS && this.aVH.size() != 0) {
            this.aVH.clear();
            KJ();
        }
    }

    private void wB() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.c(this.aVP, d.C0080d.cp_cont_j, 1);
            aj.c(this.aVQ, d.C0080d.cp_cont_i, 1);
            aj.j(this.aVQ, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
