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
    private int cIP;
    private int cIQ;
    private int cIR;
    private int cIS;
    private PopupWindow cIU;
    private TextView cIV;
    private TextView cIW;
    private b cIX;
    private boolean cIY;
    private NEGFeedBackView cIZ;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow aMJ = null;
    private aj cIN = null;
    private SparseArray<String> cIz = null;
    private List<b.a> cIO = new ArrayList();
    private NEGFeedBackView.a cIT = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener cIC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.cIT != null) {
                c.this.cIT.a(c.this.cIN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.cIO.contains(aVar)) {
                        c.this.cIO.add(aVar);
                    }
                } else {
                    c.this.cIO.remove(aVar);
                }
            }
            c.this.auX();
        }
    };
    private View.OnClickListener cJa = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.cIN != null && c.this.aMJ != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject E = c.this.E(arrayList);
                if (!StringUtils.isNull(c.this.cIN.getType())) {
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
                eVar.bPO = 1500L;
                eVar.j(c.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (c.this.cIT != null) {
                    c.this.cIT.a(arrayList, c.this.auW(), c.this.cIN);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener cJb = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.cIZ != null) {
                c.this.cIZ.setACRotateAnimation();
                c.this.cIZ = null;
            }
            if (c.this.cIU != null) {
                c.this.cIU.dismiss();
                c.this.cIU = null;
            }
        }
    };
    private CustomMessageListener cJc = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
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
        this.cIS = l.h(this.mContext, d.e.tbds14);
        this.mArrowHeight = l.h(this.mContext, d.e.tbds39);
        this.cIP = l.aO(this.mContext) - (this.mXOffset * 2);
        this.cIR = l.h(this.mContext, d.e.tbds160);
        this.cIX = new b(this.mPageContext);
        this.cIX.a(this.cIC);
        this.mPageContext.registerListener(this.cJc);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cJc != null) {
                this.cJc.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cJc);
        }
    }

    public void bg(View view) {
        if (this.mContext != null && this.cIz != null && this.cIz.size() != 0) {
            this.cIZ = (NEGFeedBackView) view;
            this.cIZ.setCWRotateAnimation();
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.cIP, this.cIR, this.mYOffset, iArr);
            this.aMJ = new PopupWindow(contentView, this.cIP, getWindowMeasuredHeight());
            this.aMJ.setFocusable(true);
            this.aMJ.setTouchable(true);
            this.aMJ.setOnDismissListener(this.cJb);
            auY();
            this.cIU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cIU.setAttachedInDecor(false);
            }
            this.cIU.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aMJ.setAnimationStyle(d.k.scale_rb2lt_anim);
                    al.a(this.aMJ, d.f.bg_tost_feedback_down);
                } else {
                    this.aMJ.setAnimationStyle(d.k.scale_rt2lb_anim);
                    al.a(this.aMJ, d.f.bg_tost_feedback_up);
                }
                this.aMJ.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.cIT != null) {
                    this.cIT.b(this.cIN);
                }
                this.cIY = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.cIV = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.cIW = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.cIW.setOnClickListener(this.cJa);
            this.mContentView.setPadding(this.cIS, this.mMargin, this.cIS, this.cIS + this.mArrowHeight);
        }
        aeK();
        View view = this.cIX.getView();
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
        this.cIQ = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.cIQ;
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
            this.mContentView.setPadding(this.cIS, this.mMargin, this.cIS, this.cIS + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.cIS, this.mMargin + this.mArrowHeight, this.cIS, this.cIS);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject E(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.cIN == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.T(this.cIO)) {
            for (b.a aVar : this.cIO) {
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
            jSONObject.put("tid", this.cIN.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.cIN.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.cIN.getType())) {
                jSONObject.put("type", this.cIN.getType());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String auW() {
        if (v.T(this.cIO)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.cIO) {
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
        int size = this.cIO.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(al.getColor(d.C0277d.cp_link_tip_a)));
            if (this.cIV != null) {
                this.cIV.setText(spannableString);
            }
            if (this.cIW != null) {
                this.cIW.setText(this.mContext.getResources().getString(d.j.confirm));
                return;
            }
            return;
        }
        if (this.cIV != null) {
            this.cIV.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        }
        if (this.cIW != null) {
            this.cIW.setText(this.mContext.getResources().getString(d.j.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cIN = ajVar;
            this.cIz = ajVar.XA();
            if (this.cIz != null && this.cIz.size() > 9) {
                for (int size = this.cIz.size() - 1; size >= 9; size--) {
                    this.cIz.removeAt(size);
                }
            }
            this.cIX.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cIX.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cIT = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cIX.setDefaultReasonArray(strArr);
    }

    public void auU() {
        if (this.aMJ != null) {
            this.aMJ.dismiss();
            this.aMJ = null;
        }
        if (this.cIU != null) {
            this.cIU.dismiss();
            this.cIU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.cJc);
        auU();
    }

    private void auY() {
        if (this.cIY && this.cIO.size() != 0) {
            this.cIO.clear();
            auX();
        }
    }

    private void aeK() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.d(this.cIV, d.C0277d.cp_cont_b, 1);
            al.d(this.cIW, d.C0277d.cp_btn_a, 1);
            al.k(this.cIW, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
