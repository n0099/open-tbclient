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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private int biZ;
    private int bja;
    private int bjb;
    private PopupWindow bjd;
    private TextView bje;
    private TextView bjf;
    private b bjg;
    private boolean bjh;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow biW = null;
    private ah biX = null;
    private SparseArray<String> biJ = null;
    private List<b.a> biY = new ArrayList();
    private NEGFeedBackView.a bjc = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener biM = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.bjc != null) {
                c.this.bjc.a(c.this.biX, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.biY.contains(aVar)) {
                        c.this.biY.add(aVar);
                    }
                } else {
                    c.this.biY.remove(aVar);
                }
            }
            c.this.PC();
        }
    };
    private View.OnClickListener bji = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.biX != null && c.this.biW != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject B = c.this.B(arrayList);
                if (!StringUtils.isNull(c.this.biX.getType())) {
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
                c.this.PB();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.auR = 1500L;
                dVar.f(c.this.mContext.getResources().getString(f.j.reduce_related_thread_recommend));
                if (c.this.bjc != null) {
                    c.this.bjc.a(arrayList, c.this.biX);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bjj = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.bjd != null) {
                c.this.bjd.dismiss();
                c.this.bjd = null;
            }
        }
    };
    private CustomMessageListener bjk = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.PB();
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
        this.mXOffset = l.f(this.mContext, f.e.tbds32);
        this.mYOffset = l.f(this.mContext, f.e.ds6);
        this.biZ = l.ah(this.mContext) - (this.mXOffset * 2);
        this.bjb = l.f(this.mContext, f.e.ds120);
        this.bjg = new b(this.mPageContext);
        this.bjg.a(this.biM);
        this.mPageContext.registerListener(this.bjk);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bjk != null) {
                this.bjk.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bjk);
        }
    }

    public void PA() {
        if (this.mContext != null && this.biJ != null && this.biJ.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.biW = new PopupWindow(contentView, this.biZ, this.mWindowHeight);
            this.biW.setFocusable(true);
            this.biW.setTouchable(true);
            this.biW.setOnDismissListener(this.bjj);
            PD();
            this.bjd = new PopupWindow(LayoutInflater.from(this.mContext).inflate(f.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bjd.setAttachedInDecor(false);
            }
            this.bjd.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.biZ, this.bjb, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.biW.setAnimationStyle(f.k.scale_rb2lt_anim);
                    am.a(this.biW, f.C0146f.bg_home_feedback_under);
                } else {
                    this.biW.setAnimationStyle(f.k.scale_rt2lb_anim);
                    am.a(this.biW, f.C0146f.bg_home_feedback_top);
                }
                this.biW.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.bjc != null) {
                    this.bjc.a(this.biX);
                }
                this.bjh = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(f.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.bje = (TextView) this.mContentView.findViewById(f.g.head_text);
            this.bjf = (TextView) this.mContentView.findViewById(f.g.uninterested_text);
            this.bjf.setOnClickListener(this.bji);
            int f = l.f(this.mContext, f.e.ds40);
            this.mContentView.setPadding(f, 0, f, f);
        }
        AD();
        View view = this.bjg.getView();
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
        this.bja = this.mContentView.getMeasuredHeight() + l.f(this.mContext, f.e.ds12);
        return this.bja;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int aj = l.aj(context);
        int ah = l.ah(context);
        boolean z = ((aj - iArr2[1]) - height) - i3 < i;
        iArr[0] = ah - i2;
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
        if (this.biX == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.z(this.biY)) {
            for (b.a aVar : this.biY) {
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
            jSONObject.put("tid", this.biX.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.biX.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.biX.getType())) {
                jSONObject.put("type", this.biX.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PC() {
        int size = this.biY.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(f.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(f.d.cp_link_tip_a)));
            if (this.bje != null) {
                this.bje.setText(spannableString);
            }
            if (this.bjf != null) {
                this.bjf.setText(this.mContext.getResources().getString(f.j.confirm));
                return;
            }
            return;
        }
        if (this.bje != null) {
            this.bje.setText(this.mContext.getResources().getString(f.j.tell_us_reason));
        }
        if (this.bjf != null) {
            this.bjf.setText(this.mContext.getResources().getString(f.j.not_interested));
        }
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.biX = ahVar;
            this.biJ = ahVar.uh();
            if (this.biJ != null && this.biJ.size() > 9) {
                for (int size = this.biJ.size() - 1; size >= 9; size--) {
                    this.biJ.removeAt(size);
                }
            }
            this.bjg.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bjg.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bjc = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bjg.setDefaultReasonArray(strArr);
    }

    public void PB() {
        if (this.biW != null) {
            this.biW.dismiss();
            this.biW = null;
        }
        if (this.bjd != null) {
            this.bjd.dismiss();
            this.bjd = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bjk);
        PB();
    }

    private void PD() {
        if (this.bjh && this.biY.size() != 0) {
            this.biY.clear();
            PC();
        }
    }

    private void AD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.c(this.bje, f.d.cp_cont_j, 1);
            am.c(this.bjf, f.d.cp_cont_i, 1);
            am.i(this.bjf, f.C0146f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
