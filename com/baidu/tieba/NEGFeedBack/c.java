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
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private int biT;
    private int biU;
    private int biV;
    private PopupWindow biX;
    private TextView biY;
    private TextView biZ;
    private b bja;
    private boolean bjb;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow biQ = null;
    private ah biR = null;
    private SparseArray<String> biD = null;
    private List<b.a> biS = new ArrayList();
    private NEGFeedBackView.a biW = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener biG = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.biW != null) {
                c.this.biW.a(c.this.biR, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.biS.contains(aVar)) {
                        c.this.biS.add(aVar);
                    }
                } else {
                    c.this.biS.remove(aVar);
                }
            }
            c.this.Pw();
        }
    };
    private View.OnClickListener bjc = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.biR != null && c.this.biQ != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject B = c.this.B(arrayList);
                if (!StringUtils.isNull(c.this.biR.getType())) {
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
                c.this.Pv();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.auS = 1500L;
                dVar.f(c.this.mContext.getResources().getString(d.j.reduce_related_thread_recommend));
                if (c.this.biW != null) {
                    c.this.biW.a(arrayList, c.this.biR);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bjd = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.biX != null) {
                c.this.biX.dismiss();
                c.this.biX = null;
            }
        }
    };
    private CustomMessageListener bje = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.Pv();
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
        this.mXOffset = l.f(this.mContext, d.e.tbds32);
        this.mYOffset = l.f(this.mContext, d.e.ds6);
        this.biT = l.ah(this.mContext) - (this.mXOffset * 2);
        this.biV = l.f(this.mContext, d.e.ds120);
        this.bja = new b(this.mPageContext);
        this.bja.a(this.biG);
        this.mPageContext.registerListener(this.bje);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bje != null) {
                this.bje.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bje);
        }
    }

    public void Pu() {
        if (this.mContext != null && this.biD != null && this.biD.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.biQ = new PopupWindow(contentView, this.biT, this.mWindowHeight);
            this.biQ.setFocusable(true);
            this.biQ.setTouchable(true);
            this.biQ.setOnDismissListener(this.bjd);
            Px();
            this.biX = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.biX.setAttachedInDecor(false);
            }
            this.biX.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.biT, this.biV, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.biQ.setAnimationStyle(d.k.scale_rb2lt_anim);
                    am.a(this.biQ, d.f.bg_home_feedback_under);
                } else {
                    this.biQ.setAnimationStyle(d.k.scale_rt2lb_anim);
                    am.a(this.biQ, d.f.bg_home_feedback_top);
                }
                this.biQ.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.biW != null) {
                    this.biW.a(this.biR);
                }
                this.bjb = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.biY = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.biZ = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.biZ.setOnClickListener(this.bjc);
            int f = l.f(this.mContext, d.e.ds40);
            this.mContentView.setPadding(f, 0, f, f);
        }
        AG();
        View view = this.bja.getView();
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
        this.biU = this.mContentView.getMeasuredHeight() + l.f(this.mContext, d.e.ds12);
        return this.biU;
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
        if (this.biR == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.z(this.biS)) {
            for (b.a aVar : this.biS) {
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
            jSONObject.put("tid", this.biR.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.biR.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.biR.getType())) {
                jSONObject.put("type", this.biR.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pw() {
        int size = this.biS.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(d.C0140d.cp_link_tip_a)));
            if (this.biY != null) {
                this.biY.setText(spannableString);
            }
            if (this.biZ != null) {
                this.biZ.setText(this.mContext.getResources().getString(d.j.confirm));
                return;
            }
            return;
        }
        if (this.biY != null) {
            this.biY.setText(this.mContext.getResources().getString(d.j.tell_us_reason));
        }
        if (this.biZ != null) {
            this.biZ.setText(this.mContext.getResources().getString(d.j.not_interested));
        }
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.biR = ahVar;
            this.biD = ahVar.ui();
            if (this.biD != null && this.biD.size() > 9) {
                for (int size = this.biD.size() - 1; size >= 9; size--) {
                    this.biD.removeAt(size);
                }
            }
            this.bja.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bja.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.biW = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bja.setDefaultReasonArray(strArr);
    }

    public void Pv() {
        if (this.biQ != null) {
            this.biQ.dismiss();
            this.biQ = null;
        }
        if (this.biX != null) {
            this.biX.dismiss();
            this.biX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bje);
        Pv();
    }

    private void Px() {
        if (this.bjb && this.biS.size() != 0) {
            this.biS.clear();
            Pw();
        }
    }

    private void AG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.c(this.biY, d.C0140d.cp_cont_j, 1);
            am.c(this.biZ, d.C0140d.cp_cont_i, 1);
            am.i(this.biZ, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
