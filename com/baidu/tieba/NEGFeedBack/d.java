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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.NEGFeedBack.c;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class d {
    private int Ie;
    private View QX;
    private int bMT;
    private int bMU;
    private int bMV;
    private PopupWindow bMX;
    private TextView bMY;
    private TextView bMZ;
    private b bNa;
    private boolean bNb;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow bMQ = null;
    private ah bMR = null;
    private SparseArray<String> bMG = null;
    private List<b.a> bMS = new ArrayList();
    private c.a bMW = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bMJ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.bMW != null) {
                d.this.bMW.a(d.this.bMR, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.bMS.contains(aVar)) {
                        d.this.bMS.add(aVar);
                    }
                } else {
                    d.this.bMS.remove(aVar);
                }
            }
            d.this.Su();
        }
    };
    private View.OnClickListener bNc = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bMR != null && d.this.bMQ != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject z = d.this.z(arrayList);
                if (!StringUtils.isNull(d.this.bMR.getType())) {
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, d.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, z);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, d.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, z);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                d.this.St();
                e eVar = new e();
                eVar.aZw = 1500L;
                eVar.r(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.bMW != null) {
                    d.this.bMW.a(arrayList, d.this.bMR);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bNd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.bMX != null) {
                d.this.bMX.dismiss();
                d.this.bMX = null;
            }
        }
    };
    private CustomMessageListener bNe = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.St();
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.QX = view;
        init();
    }

    private void init() {
        this.Ie = l.s(this.mContext, d.e.tbds32);
        this.mYOffset = l.s(this.mContext, d.e.ds6);
        this.bMT = l.ao(this.mContext) - (this.Ie * 2);
        this.bMV = l.s(this.mContext, d.e.ds120);
        this.bNa = new b(this.mPageContext);
        this.bNa.a(this.bMJ);
        this.mPageContext.registerListener(this.bNe);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bNe != null) {
                this.bNe.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bNe);
        }
    }

    public void Ss() {
        if (this.mContext != null && this.bMG != null && this.bMG.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bMQ = new PopupWindow(contentView, this.bMT, this.mWindowHeight);
            this.bMQ.setFocusable(true);
            this.bMQ.setTouchable(true);
            this.bMQ.setOnDismissListener(this.bNd);
            Sv();
            this.bMX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bMX.setAttachedInDecor(false);
            }
            this.bMX.showAtLocation(this.QX, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.QX, this.mWindowHeight, this.bMT, this.bMV, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bMQ.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bMQ, d.f.bg_home_feedback_under);
                } else {
                    this.bMQ.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bMQ, d.f.bg_home_feedback_top);
                }
                this.bMQ.showAtLocation(this.QX, 0, iArr[0] - this.Ie, iArr[1]);
                if (this.bMW != null) {
                    this.bMW.a(this.bMR);
                }
                this.bNb = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bMY = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bMZ = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bMZ.setOnClickListener(this.bNc);
        }
        DT();
        View view = this.bNa.getView();
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
        this.bMU = this.mContentView.getMeasuredHeight() + l.s(this.mContext, d.e.ds12);
        return this.bMU;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int aq = l.aq(context);
        int ao = l.ao(context);
        boolean z = ((aq - iArr2[1]) - height) - i3 < i;
        iArr[0] = ao - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:4|(8:6|(2:7|(3:9|(2:11|(2:13|14)(1:16))(1:17)|15)(0))|19|(1:21)|22|(1:24)|26|27)(0)|18|19|(0)|22|(0)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:18:0x0050, B:20:0x0062, B:21:0x006c, B:23:0x008e), top: B:27:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[Catch: Exception -> 0x009d, TRY_LEAVE, TryCatch #0 {Exception -> 0x009d, blocks: (B:18:0x0050, B:20:0x0062, B:21:0x006c, B:23:0x008e), top: B:27:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject z(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.bMR == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.bMS)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bMS.size()) {
                    b.a aVar = this.bMS.get(i2);
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
            jSONObject.put("tid", this.bMR.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bMR.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bMR.getType())) {
                jSONObject.put("type", this.bMR.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bMR.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bMR.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bMR.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Su() {
        int size = this.bMS.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_a)));
            this.bMY.setText(spannableString);
            this.bMZ.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.bMY.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.bMZ.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bMR = ahVar;
            this.bMG = ahVar.xM();
            if (this.bMG != null && this.bMG.size() > 9) {
                for (int size = this.bMG.size() - 1; size >= 9; size--) {
                    this.bMG.removeAt(size);
                }
            }
            this.bNa.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bNa.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.bMW = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bNa.setDefaultReasonArray(strArr);
    }

    public void St() {
        if (this.bMQ != null) {
            this.bMQ.dismiss();
            this.bMQ = null;
        }
        if (this.bMX != null) {
            this.bMX.dismiss();
            this.bMX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bNe);
        St();
    }

    private void Sv() {
        if (this.bNb && this.bMS.size() != 0) {
            this.bMS.clear();
            Su();
        }
    }

    private void DT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.e(this.bMY, d.C0108d.cp_cont_j, 1);
            aj.e(this.bMZ, d.C0108d.cp_cont_i, 1);
            aj.s(this.bMZ, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
