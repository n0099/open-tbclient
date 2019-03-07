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
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private int cIS;
    private int cIT;
    private int cIU;
    private int cIV;
    private PopupWindow cIX;
    private TextView cIY;
    private TextView cIZ;
    private b cJa;
    private boolean cJb;
    private NEGFeedBackView cJc;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow aMI = null;
    private aj cIQ = null;
    private SparseArray<String> cIC = null;
    private List<b.a> cIR = new ArrayList();
    private NEGFeedBackView.a cIW = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener cIF = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.cIW != null) {
                c.this.cIW.a(c.this.cIQ, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.cIR.contains(aVar)) {
                        c.this.cIR.add(aVar);
                    }
                } else {
                    c.this.cIR.remove(aVar);
                }
            }
            c.this.auX();
        }
    };
    private View.OnClickListener cJd = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.cIQ != null && c.this.aMI != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject E = c.this.E(arrayList);
                if (!StringUtils.isNull(c.this.cIQ.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, E);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, E);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.auU();
                com.baidu.tbadk.core.view.e eVar = new com.baidu.tbadk.core.view.e();
                eVar.bPN = 1500L;
                eVar.j(c.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (c.this.cIW != null) {
                    c.this.cIW.a(arrayList, c.this.auW(), c.this.cIQ);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener cJe = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.cJc != null) {
                c.this.cJc.setACRotateAnimation();
                c.this.cJc = null;
            }
            if (c.this.cIX != null) {
                c.this.cIX.dismiss();
                c.this.cIX = null;
            }
        }
    };
    private CustomMessageListener cJf = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.auU();
        }
    };

    public c(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.h(this.mContext, d.e.tbds44);
        this.mYOffset = l.h(this.mContext, d.e.tbds28);
        this.mMargin = l.h(this.mContext, d.e.tbds44);
        this.cIV = l.h(this.mContext, d.e.tbds14);
        this.mArrowHeight = l.h(this.mContext, d.e.tbds39);
        this.cIS = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIU = l.h(this.mContext, d.e.tbds160);
        this.cJa = new b(this.mPageContext);
        this.cJa.a(this.cIF);
        this.mPageContext.registerListener(this.cJf);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cJf != null) {
                this.cJf.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cJf);
        }
    }

    public void bg(View view) {
        if (this.mContext != null && this.cIC != null && this.cIC.size() != 0) {
            this.cJc = (NEGFeedBackView) view;
            this.cJc.setCWRotateAnimation();
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.cIS, this.cIU, this.mYOffset, iArr);
            this.aMI = new PopupWindow(contentView, this.cIS, getWindowMeasuredHeight());
            this.aMI.setFocusable(true);
            this.aMI.setTouchable(true);
            this.aMI.setOnDismissListener(this.cJe);
            auY();
            this.cIX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIX.setAttachedInDecor(false);
            }
            this.cIX.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aMI.setAnimationStyle(d.k.scale_rb2lt_anim);
                    al.a(this.aMI, d.f.bg_tost_feedback_down);
                } else {
                    this.aMI.setAnimationStyle(d.k.scale_rt2lb_anim);
                    al.a(this.aMI, d.f.bg_tost_feedback_up);
                }
                this.aMI.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.cIW != null) {
                    this.cIW.b(this.cIQ);
                }
                this.cJb = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.cIY = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.cIZ = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.cIZ.setOnClickListener(this.cJd);
            this.mContentView.setPadding(this.cIV, this.mMargin, this.cIV, this.cIV + this.mArrowHeight);
        }
        aeK();
        View view = this.cJa.getView();
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
        this.cIT = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.cIT;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int aQ = l.aQ(context);
        int aO = l.aO(context);
        boolean z = ((aQ - iArr2[1]) - height) - i3 < i;
        iArr[0] = aO - i2;
        if (z) {
            this.mContentView.setPadding(this.cIV, this.mMargin, this.cIV, this.cIV + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.cIV, this.mMargin + this.mArrowHeight, this.cIV, this.cIV);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject E(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.cIQ == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.T(this.cIR)) {
            for (b.a aVar : this.cIR) {
                if (aVar != null) {
                    arrayList.add(Integer.valueOf(aVar.id));
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(String.valueOf(aVar.id));
                    if (sb2.length() != 0) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb2.append(aVar.extra);
                }
            }
        }
        try {
            jSONObject.put("tid", this.cIQ.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.cIQ.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.cIQ.getType())) {
                jSONObject.put("type", this.cIQ.getType());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String auW() {
        if (v.T(this.cIR)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.cIR) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auX() {
        int size = this.cIR.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(al.getColor(d.C0236d.cp_link_tip_a)));
            if (this.cIY != null) {
                this.cIY.setText(spannableString);
            }
            if (this.cIZ != null) {
                this.cIZ.setText(this.mContext.getResources().getString(d.j.confirm));
                return;
            }
            return;
        }
        if (this.cIY != null) {
            this.cIY.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        }
        if (this.cIZ != null) {
            this.cIZ.setText(this.mContext.getResources().getString(d.j.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIQ = ajVar;
            this.cIC = ajVar.XA();
            if (this.cIC != null && this.cIC.size() > 9) {
                for (int size = this.cIC.size() - 1; size >= 9; size--) {
                    this.cIC.removeAt(size);
                }
            }
            this.cJa.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cJa.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIW = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cJa.setDefaultReasonArray(strArr);
    }

    public void auU() {
        if (this.aMI != null) {
            this.aMI.dismiss();
            this.aMI = null;
        }
        if (this.cIX != null) {
            this.cIX.dismiss();
            this.cIX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.cJf);
        auU();
    }

    private void auY() {
        if (this.cJb && this.cIR.size() != 0) {
            this.cIR.clear();
            auX();
        }
    }

    private void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.d(this.cIY, d.C0236d.cp_cont_b, 1);
            al.d(this.cIZ, d.C0236d.cp_btn_a, 1);
            al.k(this.cIZ, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
