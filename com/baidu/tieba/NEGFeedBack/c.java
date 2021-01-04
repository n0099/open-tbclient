package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {
    private static String ggb;
    private int gge;
    private int ggf;
    private int ggg;
    private int ggh;
    private PopupWindow ggj;
    private TextView ggk;
    private TBSpecificationBtn ggl;
    private com.baidu.tbadk.core.view.commonBtn.b ggm;
    private b ggn;
    private boolean ggo;
    private NEGFeedBackView ggp;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private at ggc = null;
    private SparseArray<String> gfN = null;
    private List<b.a> ggd = new ArrayList();
    private NEGFeedBackView.a ggi = null;
    private int mSkinType = 3;
    private boolean ggq = true;
    private boolean ggr = false;
    private CompoundButton.OnCheckedChangeListener gfR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.ggi != null) {
                c.this.ggi.onCheckedChanged(c.this.ggc, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.ggd.contains(aVar)) {
                        c.this.ggd.add(aVar);
                    }
                } else {
                    c.this.ggd.remove(aVar);
                }
            }
            if (c.this.ggp != null && !x.isEmpty(c.this.ggd)) {
                c.this.ggp.removeCallbacks(c.this.ggs);
                c.this.ggp.postDelayed(c.this.ggs, 500L);
            }
        }
    };
    private Runnable ggs = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bNL();
        }
    };
    private View.OnClickListener ggt = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bNL();
        }
    };
    private PopupWindow.OnDismissListener ggu = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.ggp != null) {
                c.this.ggp.setACRotateAnimation();
                c.this.ggp.removeCallbacks(c.this.ggs);
                c.this.ggp = null;
            }
            if (c.this.ggj != null) {
                c.this.ggj.dismiss();
                c.this.ggj = null;
            }
        }
    };
    private CustomMessageListener ggv = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bNI();
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
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.tbds14);
        this.ggg = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.ggh = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.ggf = l.getDimens(this.mContext, R.dimen.tbds160);
        this.ggn = new b(this.mPageContext);
        this.ggn.lW(true);
        this.ggn.lX(false);
        this.ggn.a(this.gfR);
        this.mPageContext.registerListener(this.ggv);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.ggv != null) {
                this.ggv.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.ggv);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.ggr || (this.gfN != null && this.gfN.size() != 0)) {
                this.ggp = (NEGFeedBackView) view;
                this.ggp.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.ggf, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ao.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.ggu);
                Wb();
                this.ggj = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.ggj.setAttachedInDecor(false);
                }
                this.ggj.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.ggi != null) {
                        this.ggi.onNEGFeedbackWindowShow(this.ggc);
                    }
                    this.ggo = true;
                }
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.ggk = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!com.baidu.tbadk.core.util.at.isEmpty(ggb)) {
                this.ggk.setText(ggb);
            }
            this.ggl = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.ggm = new com.baidu.tbadk.core.view.commonBtn.b();
            this.ggm.rs(R.color.CAM_X0304);
            this.ggl.setConfig(this.ggm);
            this.ggl.setOnClickListener(this.ggt);
            this.ggl.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.ggl.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.ggg, 0, this.ggg, this.ggr ? 0 : this.ggh);
        }
        bxO();
        View view = this.ggn.getView();
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
        this.gge = this.mContentView.getMeasuredHeight();
        return this.gge;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int equipmentHeight = l.getEquipmentHeight(context);
        int equipmentWidth = l.getEquipmentWidth(context);
        boolean z = ((equipmentHeight - iArr2[1]) - height) - i3 < i;
        iArr[0] = equipmentWidth - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    private JSONObject V(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.ggc == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!x.isEmpty(this.ggd)) {
            for (b.a aVar : this.ggd) {
                if (aVar != null) {
                    arrayList.add(Integer.valueOf(aVar.id));
                    if (sb.length() != 0) {
                        sb.append(",");
                    }
                    sb.append(String.valueOf(aVar.id));
                    if (sb2.length() != 0) {
                        sb2.append(",");
                    }
                    sb2.append(aVar.extra);
                }
            }
        }
        try {
            jSONObject.put("tid", this.ggc.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.ggc.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.ggc.getType())) {
                jSONObject.put("type", this.ggc.getType());
            }
            if (this.ggc.bpN() != 0) {
                jSONObject.put("topic_id", this.ggc.bpN());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bNJ() {
        if (x.isEmpty(this.ggd)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.ggd) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bNK() {
        int size = this.ggd.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)));
            if (this.ggk != null) {
                this.ggk.setText(spannableString);
            }
            if (this.ggl != null) {
                this.ggl.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.ggk != null) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(ggb)) {
                this.ggk.setText(ggb);
            } else {
                this.ggk.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.ggl != null) {
            this.ggl.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.ggc = atVar;
            this.gfN = atVar.getFeedBackReasonMap();
            if (this.gfN != null && this.gfN.size() > 9) {
                for (int size = this.gfN.size() - 1; size >= 9; size--) {
                    this.gfN.removeAt(size);
                }
            }
            this.ggn.setData(atVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.ggn.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.ggi = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.ggq = z;
    }

    public void setHeadText(String str) {
        if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
            ggb = str;
        }
    }

    public void aI(boolean z) {
        this.ggr = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ggn.setDefaultReasonArray(strArr);
    }

    public void bNI() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.ggj != null) {
            this.ggj.dismiss();
            this.ggj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.ggv);
        bNI();
    }

    private void Wb() {
        if (this.ggo && this.ggd.size() != 0) {
            this.ggd.clear();
            bNK();
        }
    }

    private void bxO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setViewTextColor(this.ggk, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNL() {
        if (this.ggc != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject V = V(arrayList);
            if (this.ggq) {
                if (!StringUtils.isNull(this.ggc.getType())) {
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, V);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, V);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
            }
            bNI();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            cVar.showSuccessToast(this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
            if (this.ggi != null) {
                this.ggi.onNEGFeedbackConfirm(arrayList, bNJ(), this.ggc);
            }
        }
    }
}
