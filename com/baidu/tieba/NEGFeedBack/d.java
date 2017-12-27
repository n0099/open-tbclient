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
import com.baidu.tbadk.core.data.ai;
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
    private int Ie;
    private View QX;
    private int bMD;
    private int bME;
    private int bMF;
    private PopupWindow bMH;
    private TextView bMI;
    private TextView bMJ;
    private b bMK;
    private boolean bML;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow bMA = null;
    private ai bMB = null;
    private SparseArray<String> bMq = null;
    private List<b.a> bMC = new ArrayList();
    private c.a bMG = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bMt = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.bMG != null) {
                d.this.bMG.a(d.this.bMB, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.bMC.contains(aVar)) {
                        d.this.bMC.add(aVar);
                    }
                } else {
                    d.this.bMC.remove(aVar);
                }
            }
            d.this.SE();
        }
    };
    private View.OnClickListener bMM = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bMB != null && d.this.bMA != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject z = d.this.z(arrayList);
                if (!StringUtils.isNull(d.this.bMB.getType())) {
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
                d.this.SD();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.aZp = 1500L;
                dVar.r(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.bMG != null) {
                    d.this.bMG.a(arrayList, d.this.bMB);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bMN = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.bMH != null) {
                d.this.bMH.dismiss();
                d.this.bMH = null;
            }
        }
    };
    private CustomMessageListener bMO = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.SD();
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
        this.bMD = l.ao(this.mContext) - (this.Ie * 2);
        this.bMF = l.s(this.mContext, d.e.ds120);
        this.bMK = new b(this.mPageContext);
        this.bMK.a(this.bMt);
        this.mPageContext.registerListener(this.bMO);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bMO != null) {
                this.bMO.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bMO);
        }
    }

    public void SC() {
        if (this.mContext != null && this.bMq != null && this.bMq.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bMA = new PopupWindow(contentView, this.bMD, this.mWindowHeight);
            this.bMA.setFocusable(true);
            this.bMA.setTouchable(true);
            this.bMA.setOnDismissListener(this.bMN);
            SF();
            this.bMH = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bMH.setAttachedInDecor(false);
            }
            this.bMH.showAtLocation(this.QX, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.QX, this.mWindowHeight, this.bMD, this.bMF, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bMA.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bMA, d.f.bg_home_feedback_under);
                } else {
                    this.bMA.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bMA, d.f.bg_home_feedback_top);
                }
                this.bMA.showAtLocation(this.QX, 0, iArr[0] - this.Ie, iArr[1]);
                if (this.bMG != null) {
                    this.bMG.a(this.bMB);
                }
                this.bML = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bMI = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bMJ = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bMJ.setOnClickListener(this.bMM);
        }
        Ea();
        View view = this.bMK.getView();
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
        this.bME = this.mContentView.getMeasuredHeight() + l.s(this.mContext, d.e.ds12);
        return this.bME;
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
        if (this.bMB == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.G(this.bMC)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bMC.size()) {
                    b.a aVar = this.bMC.get(i2);
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
            jSONObject.put("tid", this.bMB.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bMB.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bMB.getType())) {
                jSONObject.put("type", this.bMB.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bMB.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bMB.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bMB.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SE() {
        int size = this.bMC.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0108d.cp_link_tip_a)));
            this.bMI.setText(spannableString);
            this.bMJ.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.bMI.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.bMJ.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bMB = aiVar;
            this.bMq = aiVar.xO();
            if (this.bMq != null && this.bMq.size() > 9) {
                for (int size = this.bMq.size() - 1; size >= 9; size--) {
                    this.bMq.removeAt(size);
                }
            }
            this.bMK.setData(aiVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bMK.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.bMG = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bMK.setDefaultReasonArray(strArr);
    }

    public void SD() {
        if (this.bMA != null) {
            this.bMA.dismiss();
            this.bMA = null;
        }
        if (this.bMH != null) {
            this.bMH.dismiss();
            this.bMH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bMO);
        SD();
    }

    private void SF() {
        if (this.bML && this.bMC.size() != 0) {
            this.bMC.clear();
            SE();
        }
    }

    private void Ea() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.e(this.bMI, d.C0108d.cp_cont_j, 1);
            aj.e(this.bMJ, d.C0108d.cp_cont_i, 1);
            aj.s(this.bMJ, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
