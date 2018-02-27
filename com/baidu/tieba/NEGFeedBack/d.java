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
    private int bON;
    private int bOO;
    private int bOP;
    private PopupWindow bOR;
    private TextView bOS;
    private TextView bOT;
    private b bOU;
    private boolean bOV;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mYOffset;
    private PopupWindow bOK = null;
    private ah bOL = null;
    private SparseArray<String> bOA = null;
    private List<b.a> bOM = new ArrayList();
    private c.a bOQ = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bOD = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.d.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (d.this.bOQ != null) {
                d.this.bOQ.a(d.this.bOL, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!d.this.bOM.contains(aVar)) {
                        d.this.bOM.add(aVar);
                    }
                } else {
                    d.this.bOM.remove(aVar);
                }
            }
            d.this.Ta();
        }
    };
    private View.OnClickListener bOW = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bOL != null && d.this.bOK != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject z = d.this.z(arrayList);
                if (!StringUtils.isNull(d.this.bOL.getType())) {
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
                d.this.SZ();
                e eVar = new e();
                eVar.baV = 1500L;
                eVar.r(d.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (d.this.bOQ != null) {
                    d.this.bOQ.a(arrayList, d.this.bOL);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bOX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.d.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (d.this.bOR != null) {
                d.this.bOR.dismiss();
                d.this.bOR = null;
            }
        }
    };
    private CustomMessageListener bOY = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.SZ();
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
        this.bON = l.ao(this.mContext) - (this.HY * 2);
        this.bOP = l.t(this.mContext, d.e.ds120);
        this.bOU = new b(this.mPageContext);
        this.bOU.a(this.bOD);
        this.mPageContext.registerListener(this.bOY);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bOY != null) {
                this.bOY.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bOY);
        }
    }

    public void SY() {
        if (this.mContext != null && this.bOA != null && this.bOA.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bOK = new PopupWindow(contentView, this.bON, this.mWindowHeight);
            this.bOK.setFocusable(true);
            this.bOK.setTouchable(true);
            this.bOK.setOnDismissListener(this.bOX);
            Tb();
            this.bOR = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bOR.setAttachedInDecor(false);
            }
            this.bOR.showAtLocation(this.QQ, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.QQ, this.mWindowHeight, this.bON, this.bOP, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bOK.setAnimationStyle(d.k.scale_rb2lt_anim);
                    aj.a(this.bOK, d.f.bg_home_feedback_under);
                } else {
                    this.bOK.setAnimationStyle(d.k.scale_rt2lb_anim);
                    aj.a(this.bOK, d.f.bg_home_feedback_top);
                }
                this.bOK.showAtLocation(this.QQ, 0, iArr[0] - this.HY, iArr[1]);
                if (this.bOQ != null) {
                    this.bOQ.a(this.bOL);
                }
                this.bOV = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bOS = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bOT = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bOT.setOnClickListener(this.bOW);
        }
        Em();
        View view = this.bOU.getView();
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
        this.bOO = this.mContentView.getMeasuredHeight() + l.t(this.mContext, d.e.ds12);
        return this.bOO;
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
        if (this.bOL == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.E(this.bOM)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bOM.size()) {
                    b.a aVar = this.bOM.get(i2);
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
            jSONObject.put("tid", this.bOL.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bOL.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bOL.getType())) {
                jSONObject.put("type", this.bOL.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bOL.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bOL.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bOL.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ta() {
        int size = this.bOM.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(aj.getColor(d.C0141d.cp_link_tip_a)));
            this.bOS.setText(spannableString);
            this.bOT.setText(this.mContext.getResources().getString(d.j.confirm));
            return;
        }
        this.bOS.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        this.bOT.setText(this.mContext.getResources().getString(d.j.not_interested));
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.bOL = ahVar;
            this.bOA = ahVar.yo();
            if (this.bOA != null && this.bOA.size() > 9) {
                for (int size = this.bOA.size() - 1; size >= 9; size--) {
                    this.bOA.removeAt(size);
                }
            }
            this.bOU.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bOU.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(c.a aVar) {
        this.bOQ = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bOU.setDefaultReasonArray(strArr);
    }

    public void SZ() {
        if (this.bOK != null) {
            this.bOK.dismiss();
            this.bOK = null;
        }
        if (this.bOR != null) {
            this.bOR.dismiss();
            this.bOR = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bOY);
        SZ();
    }

    private void Tb() {
        if (this.bOV && this.bOM.size() != 0) {
            this.bOM.clear();
            Ta();
        }
    }

    private void Em() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            aj.e(this.bOS, d.C0141d.cp_cont_j, 1);
            aj.e(this.bOT, d.C0141d.cp_cont_i, 1);
            aj.s(this.bOT, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
