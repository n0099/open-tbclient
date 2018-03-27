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
    private int HY;
    private View QQ;
    private int bOQ;
    private int bOR;
    private int bOS;
    private PopupWindow bOU;
    private TextView bOV;
    private TextView bOW;
    private b bOX;
    private boolean bOY;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow bON = null;
    private ah bOO = null;
    private SparseArray<String> bOD = null;
    private List<b.a> bOP = new ArrayList();
    private c.a bOT = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bOG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.bOT != null) {
                d.this.bOT.a(d.this.bOO, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.bOP.contains(aVar)) {
                        d.this.bOP.add(aVar);
                    }
                } else {
                    d.this.bOP.remove(aVar);
                }
            }
            d.this.Tb();
        }
    };
    private View.OnClickListener bOZ = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bOO != null && d.this.bON != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject z = d.this.z(arrayList);
                if (!StringUtils.isNull(d.this.bOO.getType())) {
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
                eVar.baX = 1500L;
                eVar.r(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.bOT != null) {
                    d.this.bOT.a(arrayList, d.this.bOO);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bPa = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.bOU != null) {
                d.this.bOU.dismiss();
                d.this.bOU = null;
            }
        }
    };
    private CustomMessageListener bPb = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.d.4
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
        this.QQ = view;
        init();
    }

    private void init() {
        this.HY = l.t(this.mContext, d.e.tbds32);
        this.mYOffset = l.t(this.mContext, d.e.ds6);
        this.bOQ = l.ao(this.mContext) - (this.HY * 2);
        this.bOS = l.t(this.mContext, d.e.ds120);
        this.bOX = new b(this.mPageContext);
        this.bOX.a(this.bOG);
        this.mPageContext.registerListener(this.bPb);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bPb != null) {
                this.bPb.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bPb);
        }
    }

    public void SZ() {
        if (this.mContext != null && this.bOD != null && this.bOD.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bON = new PopupWindow(contentView, this.bOQ, this.mWindowHeight);
            this.bON.setFocusable(true);
            this.bON.setTouchable(true);
            this.bON.setOnDismissListener(this.bPa);
            Tc();
            this.bOU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bOU.setAttachedInDecor(false);
            }
            this.bOU.showAtLocation(this.QQ, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.QQ, this.mWindowHeight, this.bOQ, this.bOS, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bON.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bON, d.f.bg_home_feedback_under);
                } else {
                    this.bON.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bON, d.f.bg_home_feedback_top);
                }
                this.bON.showAtLocation(this.QQ, 0, iArr[0] - this.HY, iArr[1]);
                if (this.bOT != null) {
                    this.bOT.a(this.bOO);
                }
                this.bOY = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bOV = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bOW = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bOW.setOnClickListener(this.bOZ);
        }
        En();
        View view = this.bOX.getView();
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
        this.bOR = this.mContentView.getMeasuredHeight() + l.t(this.mContext, d.e.ds12);
        return this.bOR;
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
        if (this.bOO == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.bOP)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOP.size()) {
                    b.a aVar = this.bOP.get(i2);
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
            jSONObject.put("tid", this.bOO.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bOO.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bOO.getType())) {
                jSONObject.put("type", this.bOO.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bOO.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bOO.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bOO.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb() {
        int size = this.bOP.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)));
            this.bOV.setText(spannableString);
            this.bOW.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.bOV.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.bOW.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bOO = ahVar;
            this.bOD = ahVar.yo();
            if (this.bOD != null && this.bOD.size() > 9) {
                for (int size = this.bOD.size() - 1; size >= 9; size--) {
                    this.bOD.removeAt(size);
                }
            }
            this.bOX.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bOX.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.bOT = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bOX.setDefaultReasonArray(strArr);
    }

    public void Ta() {
        if (this.bON != null) {
            this.bON.dismiss();
            this.bON = null;
        }
        if (this.bOU != null) {
            this.bOU.dismiss();
            this.bOU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bPb);
        Ta();
    }

    private void Tc() {
        if (this.bOY && this.bOP.size() != 0) {
            this.bOP.clear();
            Tb();
        }
    }

    private void En() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.e(this.bOV, d.C0141d.cp_cont_j, 1);
            aj.e(this.bOW, d.C0141d.cp_cont_i, 1);
            aj.s(this.bOW, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
