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
    private int bML;
    private int bMM;
    private int bMN;
    private PopupWindow bMP;
    private TextView bMQ;
    private TextView bMR;
    private b bMS;
    private boolean bMT;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow bMI = null;
    private ah bMJ = null;
    private SparseArray<String> bMy = null;
    private List<b.a> bMK = new ArrayList();
    private c.a bMO = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bMB = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.bMO != null) {
                d.this.bMO.a(d.this.bMJ, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.bMK.contains(aVar)) {
                        d.this.bMK.add(aVar);
                    }
                } else {
                    d.this.bMK.remove(aVar);
                }
            }
            d.this.Ss();
        }
    };
    private View.OnClickListener bMU = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bMJ != null && d.this.bMI != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject z = d.this.z(arrayList);
                if (!StringUtils.isNull(d.this.bMJ.getType())) {
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
                d.this.Sr();
                e eVar = new e();
                eVar.aZo = 1500L;
                eVar.r(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.bMO != null) {
                    d.this.bMO.a(arrayList, d.this.bMJ);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bMV = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.bMP != null) {
                d.this.bMP.dismiss();
                d.this.bMP = null;
            }
        }
    };
    private CustomMessageListener bMW = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.Sr();
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
        this.bML = l.ao(this.mContext) - (this.Ie * 2);
        this.bMN = l.s(this.mContext, d.e.ds120);
        this.bMS = new b(this.mPageContext);
        this.bMS.a(this.bMB);
        this.mPageContext.registerListener(this.bMW);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bMW != null) {
                this.bMW.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bMW);
        }
    }

    public void Sq() {
        if (this.mContext != null && this.bMy != null && this.bMy.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bMI = new PopupWindow(contentView, this.bML, this.mWindowHeight);
            this.bMI.setFocusable(true);
            this.bMI.setTouchable(true);
            this.bMI.setOnDismissListener(this.bMV);
            St();
            this.bMP = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bMP.setAttachedInDecor(false);
            }
            this.bMP.showAtLocation(this.QX, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.QX, this.mWindowHeight, this.bML, this.bMN, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bMI.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bMI, d.f.bg_home_feedback_under);
                } else {
                    this.bMI.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bMI, d.f.bg_home_feedback_top);
                }
                this.bMI.showAtLocation(this.QX, 0, iArr[0] - this.Ie, iArr[1]);
                if (this.bMO != null) {
                    this.bMO.a(this.bMJ);
                }
                this.bMT = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bMQ = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bMR = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bMR.setOnClickListener(this.bMU);
        }
        DR();
        View view = this.bMS.getView();
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
        this.bMM = this.mContentView.getMeasuredHeight() + l.s(this.mContext, d.e.ds12);
        return this.bMM;
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
        if (this.bMJ == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.bMK)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bMK.size()) {
                    b.a aVar = this.bMK.get(i2);
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
            jSONObject.put("tid", this.bMJ.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bMJ.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bMJ.getType())) {
                jSONObject.put("type", this.bMJ.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bMJ.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bMJ.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bMJ.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ss() {
        int size = this.bMK.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0107d.cp_link_tip_a)));
            this.bMQ.setText(spannableString);
            this.bMR.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.bMQ.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.bMR.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bMJ = ahVar;
            this.bMy = ahVar.xL();
            if (this.bMy != null && this.bMy.size() > 9) {
                for (int size = this.bMy.size() - 1; size >= 9; size--) {
                    this.bMy.removeAt(size);
                }
            }
            this.bMS.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bMS.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.bMO = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bMS.setDefaultReasonArray(strArr);
    }

    public void Sr() {
        if (this.bMI != null) {
            this.bMI.dismiss();
            this.bMI = null;
        }
        if (this.bMP != null) {
            this.bMP.dismiss();
            this.bMP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bMW);
        Sr();
    }

    private void St() {
        if (this.bMT && this.bMK.size() != 0) {
            this.bMK.clear();
            Ss();
        }
    }

    private void DR() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.e(this.bMQ, d.C0107d.cp_cont_j, 1);
            aj.e(this.bMR, d.C0107d.cp_cont_i, 1);
            aj.s(this.bMR, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
