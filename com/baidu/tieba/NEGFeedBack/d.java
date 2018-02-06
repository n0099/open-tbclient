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
    private int Id;
    private View QW;
    private int bPa;
    private int bPb;
    private int bPc;
    private PopupWindow bPe;
    private TextView bPf;
    private TextView bPg;
    private b bPh;
    private boolean bPi;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow bOX = null;
    private ah bOY = null;
    private SparseArray<String> bON = null;
    private List<b.a> bOZ = new ArrayList();
    private c.a bPd = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bOQ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.bPd != null) {
                d.this.bPd.a(d.this.bOY, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.bOZ.contains(aVar)) {
                        d.this.bOZ.add(aVar);
                    }
                } else {
                    d.this.bOZ.remove(aVar);
                }
            }
            d.this.Tb();
        }
    };
    private View.OnClickListener bPj = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bOY != null && d.this.bOX != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject z = d.this.z(arrayList);
                if (!StringUtils.isNull(d.this.bOY.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, d.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, z);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, d.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, z);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                d.this.Ta();
                e eVar = new e();
                eVar.bbh = 1500L;
                eVar.r(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.bPd != null) {
                    d.this.bPd.a(arrayList, d.this.bOY);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bPk = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.bPe != null) {
                d.this.bPe.dismiss();
                d.this.bPe = null;
            }
        }
    };
    private CustomMessageListener bPl = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.Ta();
        }
    };

    public d(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.QW = view;
        init();
    }

    private void init() {
        this.Id = l.t(this.mContext, d.e.tbds32);
        this.mYOffset = l.t(this.mContext, d.e.ds6);
        this.bPa = l.ao(this.mContext) - (this.Id * 2);
        this.bPc = l.t(this.mContext, d.e.ds120);
        this.bPh = new b(this.mPageContext);
        this.bPh.a(this.bOQ);
        this.mPageContext.registerListener(this.bPl);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bPl != null) {
                this.bPl.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bPl);
        }
    }

    public void SZ() {
        if (this.mContext != null && this.bON != null && this.bON.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bOX = new PopupWindow(contentView, this.bPa, this.mWindowHeight);
            this.bOX.setFocusable(true);
            this.bOX.setTouchable(true);
            this.bOX.setOnDismissListener(this.bPk);
            Tc();
            this.bPe = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bPe.setAttachedInDecor(false);
            }
            this.bPe.showAtLocation(this.QW, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.QW, this.mWindowHeight, this.bPa, this.bPc, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bOX.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bOX, d.f.bg_home_feedback_under);
                } else {
                    this.bOX.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bOX, d.f.bg_home_feedback_top);
                }
                this.bOX.showAtLocation(this.QW, 0, iArr[0] - this.Id, iArr[1]);
                if (this.bPd != null) {
                    this.bPd.a(this.bOY);
                }
                this.bPi = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bPf = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bPg = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bPg.setOnClickListener(this.bPj);
        }
        En();
        View view = this.bPh.getView();
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
        this.bPb = this.mContentView.getMeasuredHeight() + l.t(this.mContext, d.e.ds12);
        return this.bPb;
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
        if (this.bOY == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.bOZ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOZ.size()) {
                    b.a aVar = this.bOZ.get(i2);
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
            jSONObject.put("tid", this.bOY.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bOY.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bOY.getType())) {
                jSONObject.put("type", this.bOY.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bOY.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bOY.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bOY.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb() {
        int size = this.bOZ.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0140d.cp_link_tip_a)));
            this.bPf.setText(spannableString);
            this.bPg.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.bPf.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.bPg.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bOY = ahVar;
            this.bON = ahVar.yo();
            if (this.bON != null && this.bON.size() > 9) {
                for (int size = this.bON.size() - 1; size >= 9; size--) {
                    this.bON.removeAt(size);
                }
            }
            this.bPh.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bPh.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.bPd = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bPh.setDefaultReasonArray(strArr);
    }

    public void Ta() {
        if (this.bOX != null) {
            this.bOX.dismiss();
            this.bOX = null;
        }
        if (this.bPe != null) {
            this.bPe.dismiss();
            this.bPe = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bPl);
        Ta();
    }

    private void Tc() {
        if (this.bPi && this.bOZ.size() != 0) {
            this.bOZ.clear();
            Tb();
        }
    }

    private void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.e(this.bPf, d.C0140d.cp_cont_j, 1);
            aj.e(this.bPg, d.C0140d.cp_cont_i, 1);
            aj.s(this.bPg, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
