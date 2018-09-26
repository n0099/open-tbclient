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
/* loaded from: classes2.dex */
public class c {
    private int boJ;
    private int boK;
    private int boL;
    private PopupWindow boN;
    private TextView boO;
    private TextView boP;
    private b boQ;
    private boolean boR;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow boG = null;
    private ah boH = null;
    private SparseArray<String> bot = null;
    private List<b.a> boI = new ArrayList();
    private NEGFeedBackView.a boM = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bow = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.boM != null) {
                c.this.boM.a(c.this.boH, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.boI.contains(aVar)) {
                        c.this.boI.add(aVar);
                    }
                } else {
                    c.this.boI.remove(aVar);
                }
            }
            c.this.Rp();
        }
    };
    private View.OnClickListener boS = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.boH != null && c.this.boG != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject B = c.this.B(arrayList);
                if (!StringUtils.isNull(c.this.boH.getType())) {
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
                c.this.Ro();
                g gVar = new g();
                gVar.ayd = 1500L;
                gVar.f(c.this.mContext.getResources().getString(e.j.reduce_related_thread_recommend));
                if (c.this.boM != null) {
                    c.this.boM.a(arrayList, c.this.boH);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener boT = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.boN != null) {
                c.this.boN.dismiss();
                c.this.boN = null;
            }
        }
    };
    private CustomMessageListener boU = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.Ro();
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
        this.mXOffset = l.h(this.mContext, e.C0141e.tbds32);
        this.mYOffset = l.h(this.mContext, e.C0141e.ds6);
        this.boJ = l.aO(this.mContext) - (this.mXOffset * 2);
        this.boL = l.h(this.mContext, e.C0141e.ds120);
        this.boQ = new b(this.mPageContext);
        this.boQ.a(this.bow);
        this.mPageContext.registerListener(this.boU);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.boU != null) {
                this.boU.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.boU);
        }
    }

    public void Rn() {
        if (this.mContext != null && this.bot != null && this.bot.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.boG = new PopupWindow(contentView, this.boJ, this.mWindowHeight);
            this.boG.setFocusable(true);
            this.boG.setTouchable(true);
            this.boG.setOnDismissListener(this.boT);
            Rq();
            this.boN = new PopupWindow(LayoutInflater.from(this.mContext).inflate(e.h.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.boN.setAttachedInDecor(false);
            }
            this.boN.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.boJ, this.boL, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.boG.setAnimationStyle(e.k.scale_rb2lt_anim);
                    al.a(this.boG, e.f.bg_home_feedback_under);
                } else {
                    this.boG.setAnimationStyle(e.k.scale_rt2lb_anim);
                    al.a(this.boG, e.f.bg_home_feedback_top);
                }
                this.boG.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.boM != null) {
                    this.boM.a(this.boH);
                }
                this.boR = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(e.h.neg_feedback_popupwindow, (ViewGroup) null);
            this.boO = (TextView) this.mContentView.findViewById(e.g.head_text);
            this.boP = (TextView) this.mContentView.findViewById(e.g.uninterested_text);
            this.boP.setOnClickListener(this.boS);
            int h = l.h(this.mContext, e.C0141e.ds40);
            this.mContentView.setPadding(h, 0, h, h);
        }
        BQ();
        View view = this.boQ.getView();
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
        this.boK = this.mContentView.getMeasuredHeight() + l.h(this.mContext, e.C0141e.ds12);
        return this.boK;
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
        if (this.boH == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!v.z(this.boI)) {
            for (b.a aVar : this.boI) {
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
            jSONObject.put("tid", this.boH.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.boH.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.boH.getType())) {
                jSONObject.put("type", this.boH.getType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Rp() {
        int size = this.boI.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(e.j.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(al.getColor(e.d.cp_link_tip_a)));
            if (this.boO != null) {
                this.boO.setText(spannableString);
            }
            if (this.boP != null) {
                this.boP.setText(this.mContext.getResources().getString(e.j.confirm));
                return;
            }
            return;
        }
        if (this.boO != null) {
            this.boO.setText(this.mContext.getResources().getString(e.j.tell_us_reason));
        }
        if (this.boP != null) {
            this.boP.setText(this.mContext.getResources().getString(e.j.not_interested));
        }
    }

    public void setData(ah ahVar) {
        if (ahVar != null) {
            this.boH = ahVar;
            this.bot = ahVar.vk();
            if (this.bot != null && this.bot.size() > 9) {
                for (int size = this.bot.size() - 1; size >= 9; size--) {
                    this.bot.removeAt(size);
                }
            }
            this.boQ.setData(ahVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.boQ.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.boM = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.boQ.setDefaultReasonArray(strArr);
    }

    public void Ro() {
        if (this.boG != null) {
            this.boG.dismiss();
            this.boG = null;
        }
        if (this.boN != null) {
            this.boN.dismiss();
            this.boN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.boU);
        Ro();
    }

    private void Rq() {
        if (this.boR && this.boI.size() != 0) {
            this.boI.clear();
            Rp();
        }
    }

    private void BQ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.boO, e.d.cp_cont_j, 1);
            al.c(this.boP, e.d.cp_cont_i, 1);
            al.i(this.boP, e.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
