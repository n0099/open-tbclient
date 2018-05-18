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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private int aYM;
    private int aYN;
    private int aYO;
    private PopupWindow aYQ;
    private TextView aYR;
    private TextView aYS;
    private b aYT;
    private boolean aYU;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow aYJ = null;
    private ai aYK = null;
    private SparseArray<String> aYz = null;
    private List<b.a> aYL = new ArrayList();
    private NEGFeedBackView.a aYP = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener aYC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.aYP != null) {
                c.this.aYP.a(c.this.aYK, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.aYL.contains(aVar)) {
                        c.this.aYL.add(aVar);
                    }
                } else {
                    c.this.aYL.remove(aVar);
                }
            }
            c.this.Lw();
        }
    };
    private View.OnClickListener aYV = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            if (c.this.aYK != null && c.this.aYJ != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject y = c.this.y(arrayList);
                if (!StringUtils.isNull(c.this.aYK.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, y);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, y);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.Lv();
                com.baidu.tbadk.core.view.b bVar = new com.baidu.tbadk.core.view.b();
                bVar.ams = 1500L;
                bVar.j(c.this.mContext.getResources().getString(d.k.reduce_related_thread_recommend));
                if (c.this.aYP != null) {
                    c.this.aYP.a(arrayList, c.this.aYK);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener aYW = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.aYQ != null) {
                c.this.aYQ.dismiss();
                c.this.aYQ = null;
            }
        }
    };
    private CustomMessageListener aYX = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.Lv();
        }
    };

    public c(TbPageContext tbPageContext, View view2) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view2;
        init();
    }

    private void init() {
        this.mXOffset = l.e(this.mContext, d.e.tbds32);
        this.mYOffset = l.e(this.mContext, d.e.ds6);
        this.aYM = l.af(this.mContext) - (this.mXOffset * 2);
        this.aYO = l.e(this.mContext, d.e.ds120);
        this.aYT = new b(this.mPageContext);
        this.aYT.a(this.aYC);
        this.mPageContext.registerListener(this.aYX);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.aYX != null) {
                this.aYX.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.aYX);
        }
    }

    public void Lu() {
        if (this.mContext != null && this.aYz != null && this.aYz.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.aYJ = new PopupWindow(contentView, this.aYM, this.mWindowHeight);
            this.aYJ.setFocusable(true);
            this.aYJ.setTouchable(true);
            this.aYJ.setOnDismissListener(this.aYW);
            Lx();
            this.aYQ = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.aYQ.setAttachedInDecor(false);
            }
            this.aYQ.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.aYM, this.aYO, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aYJ.setAnimationStyle(d.l.scale_rb2lt_anim);
                    ak.a(this.aYJ, d.f.bg_home_feedback_under);
                } else {
                    this.aYJ.setAnimationStyle(d.l.scale_rt2lb_anim);
                    ak.a(this.aYJ, d.f.bg_home_feedback_top);
                }
                this.aYJ.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.aYP != null) {
                    this.aYP.a(this.aYK);
                }
                this.aYU = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.neg_feedback_popupwindow, (ViewGroup) null);
            this.aYR = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.aYS = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.aYS.setOnClickListener(this.aYV);
        }
        wX();
        View view2 = this.aYT.getView();
        if (view2 != null && view2.getParent() == null) {
            this.mContentView.addView(view2);
        }
        return this.mContentView;
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.aYN = this.mContentView.getMeasuredHeight() + l.e(this.mContext, d.e.ds12);
        return this.aYN;
    }

    private boolean a(Context context, View view2, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view2 == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view2.getLocationOnScreen(iArr2);
        int height = view2.getHeight();
        int ah = l.ah(context);
        int af = l.af(context);
        boolean z = ((ah - iArr2[1]) - height) - i3 < i;
        iArr[0] = af - i2;
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
    public JSONObject y(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.aYK == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.w(this.aYL)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.aYL.size()) {
                    b.a aVar = this.aYL.get(i2);
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
            jSONObject.put("tid", this.aYK.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.aYK.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.aYK.getType())) {
                jSONObject.put("type", this.aYK.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.aYK.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.aYK.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.aYK.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lw() {
        int size = this.aYL.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.k.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ak.getColor(d.C0126d.cp_link_tip_a)));
            this.aYR.setText(spannableString);
            this.aYS.setText(this.mContext.getResources().getString(d.k.confirm));
            return;
        }
        this.aYR.setText(this.mContext.getResources().getString(d.k.tell_us_reason));
        this.aYS.setText(this.mContext.getResources().getString(d.k.not_interested));
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.aYK = aiVar;
            this.aYz = aiVar.qT();
            if (this.aYz != null && this.aYz.size() > 9) {
                for (int size = this.aYz.size() - 1; size >= 9; size--) {
                    this.aYz.removeAt(size);
                }
            }
            this.aYT.setData(aiVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aYT.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.aYP = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aYT.setDefaultReasonArray(strArr);
    }

    public void Lv() {
        if (this.aYJ != null) {
            this.aYJ.dismiss();
            this.aYJ = null;
        }
        if (this.aYQ != null) {
            this.aYQ.dismiss();
            this.aYQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.aYX);
        Lv();
    }

    private void Lx() {
        if (this.aYU && this.aYL.size() != 0) {
            this.aYL.clear();
            Lw();
        }
    }

    private void wX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ak.c(this.aYR, d.C0126d.cp_cont_j, 1);
            ak.c(this.aYS, d.C0126d.cp_cont_i, 1);
            ak.i(this.aYS, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
