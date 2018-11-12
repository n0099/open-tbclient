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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {
    private PopupWindow btA;
    private TextView btB;
    private TextView btC;
    private b btD;
    private boolean btE;
    private int btw;
    private int btx;
    private int bty;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private ah btu = null;
    private SparseArray<String> bth = null;
    private List<b.a> btv = new ArrayList();
    private NEGFeedBackView.a btz = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener btk = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.btz != null) {
                c.this.btz.a(c.this.btu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.btv.contains(aVar)) {
                        c.this.btv.add(aVar);
                    }
                } else {
                    c.this.btv.remove(aVar);
                }
            }
            c.this.Tu();
        }
    };
    private View.OnClickListener btF = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.btu != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject B = c.this.B(arrayList);
                if (!StringUtils.isNull(c.this.btu.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, B);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, B);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.Tt();
                g gVar = new g();
                gVar.aDC = 1500L;
                gVar.f(c.this.mContext.getResources().getString(e.j.reduce_related_thread_recommend));
                if (c.this.btz != null) {
                    c.this.btz.a(arrayList, c.this.btu);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener btG = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.btA != null) {
                c.this.btA.dismiss();
                c.this.btA = null;
            }
        }
    };
    private CustomMessageListener btH = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.Tt();
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
        this.mXOffset = l.h(this.mContext, e.C0200e.tbds32);
        this.mYOffset = l.h(this.mContext, e.C0200e.ds6);
        this.btw = l.aO(this.mContext) - (this.mXOffset * 2);
        this.bty = l.h(this.mContext, e.C0200e.ds120);
        this.btD = new b(this.mPageContext);
        this.btD.a(this.btk);
        this.mPageContext.registerListener(this.btH);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.btH != null) {
                this.btH.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.btH);
        }
    }

    public void Ts() {
        if (this.mContext != null && this.bth != null && this.bth.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.mPopupWindow = new PopupWindow(contentView, this.btw, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.btG);
            Tv();
            this.btA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.btA.setAttachedInDecor(false);
            }
            this.btA.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.btw, this.bty, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.mPopupWindow.setAnimationStyle(e.k.scale_rb2lt_anim);
                    al.a(this.mPopupWindow, e.f.bg_home_feedback_under);
                } else {
                    this.mPopupWindow.setAnimationStyle(e.k.scale_rt2lb_anim);
                    al.a(this.mPopupWindow, e.f.bg_home_feedback_top);
                }
                this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.btz != null) {
                    this.btz.a(this.btu);
                }
                this.btE = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.btB = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.btC = (TextView) this.mContentView.findViewById(e.g.uninterested_text);
            this.btC.setOnClickListener(this.btF);
            int h = l.h(this.mContext, e.C0200e.ds40);
            this.mContentView.setPadding(h, 0, h, h);
        }
        Ef();
        View view = this.btD.getView();
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
        this.btx = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0200e.ds12);
        return this.btx;
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
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject B(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.btu == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.I(this.btv)) {
            for (b.a aVar : this.btv) {
                if (aVar != null) {
                    arrayList.add(Integer.valueOf(aVar.id));
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(String.valueOf(aVar.id));
                }
            }
        }
        try {
            jSONObject.put("tid", this.btu.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.btu.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.btu.getType())) {
                jSONObject.put("type", this.btu.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tu() {
        int size = this.btv.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(e.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)));
            if (this.btB != null) {
                this.btB.setText(spannableString);
            }
            if (this.btC != null) {
                this.btC.setText(this.mContext.getResources().getString(e.j.confirm));
                return;
            }
            return;
        }
        if (this.btB != null) {
            this.btB.setText(this.mContext.getResources().getString(e.j.tell_us_reason));
        }
        if (this.btC != null) {
            this.btC.setText(this.mContext.getResources().getString(e.j.not_interested));
        }
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.btu = ahVar;
            this.bth = ahVar.xB();
            if (this.bth != null && this.bth.size() > 9) {
                for (int size = this.bth.size() - 1; size >= 9; size--) {
                    this.bth.removeAt(size);
                }
            }
            this.btD.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.btD.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.btz = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.btD.setDefaultReasonArray(strArr);
    }

    public void Tt() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.btA != null) {
            this.btA.dismiss();
            this.btA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.btH);
        Tt();
    }

    private void Tv() {
        if (this.btE && this.btv.size() != 0) {
            this.btv.clear();
            Tu();
        }
    }

    private void Ef() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.btB, e.d.cp_cont_j, 1);
            al.c(this.btC, e.d.cp_cont_i, 1);
            al.i(this.btC, e.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
