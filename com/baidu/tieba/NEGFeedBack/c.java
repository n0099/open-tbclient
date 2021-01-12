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
    private static String gbs;
    private PopupWindow gbA;
    private TextView gbB;
    private TBSpecificationBtn gbC;
    private com.baidu.tbadk.core.view.commonBtn.b gbD;
    private b gbE;
    private boolean gbF;
    private NEGFeedBackView gbG;
    private int gbv;
    private int gbw;
    private int gbx;
    private int gby;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private at gbt = null;
    private SparseArray<String> gbe = null;
    private List<b.a> gbu = new ArrayList();
    private NEGFeedBackView.a gbz = null;
    private int mSkinType = 3;
    private boolean gbH = true;
    private boolean gbI = false;
    private CompoundButton.OnCheckedChangeListener gbi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.gbz != null) {
                c.this.gbz.onCheckedChanged(c.this.gbt, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.gbu.contains(aVar)) {
                        c.this.gbu.add(aVar);
                    }
                } else {
                    c.this.gbu.remove(aVar);
                }
            }
            if (c.this.gbG != null && !x.isEmpty(c.this.gbu)) {
                c.this.gbG.removeCallbacks(c.this.gbJ);
                c.this.gbG.postDelayed(c.this.gbJ, 500L);
            }
        }
    };
    private Runnable gbJ = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bJU();
        }
    };
    private View.OnClickListener gbK = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bJU();
        }
    };
    private PopupWindow.OnDismissListener gbL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.gbG != null) {
                c.this.gbG.setACRotateAnimation();
                c.this.gbG.removeCallbacks(c.this.gbJ);
                c.this.gbG = null;
            }
            if (c.this.gbA != null) {
                c.this.gbA.dismiss();
                c.this.gbA = null;
            }
        }
    };
    private CustomMessageListener gbM = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bJR();
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
        this.gbx = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.gby = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gbw = l.getDimens(this.mContext, R.dimen.tbds160);
        this.gbE = new b(this.mPageContext);
        this.gbE.lS(true);
        this.gbE.lT(false);
        this.gbE.a(this.gbi);
        this.mPageContext.registerListener(this.gbM);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.gbM != null) {
                this.gbM.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.gbM);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.gbI || (this.gbe != null && this.gbe.size() != 0)) {
                this.gbG = (NEGFeedBackView) view;
                this.gbG.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.gbw, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ao.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.gbL);
                Si();
                this.gbA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gbA.setAttachedInDecor(false);
                }
                this.gbA.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.gbz != null) {
                        this.gbz.onNEGFeedbackWindowShow(this.gbt);
                    }
                    this.gbF = true;
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
            this.gbB = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!com.baidu.tbadk.core.util.at.isEmpty(gbs)) {
                this.gbB.setText(gbs);
            }
            this.gbC = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.gbD = new com.baidu.tbadk.core.view.commonBtn.b();
            this.gbD.pM(R.color.CAM_X0304);
            this.gbC.setConfig(this.gbD);
            this.gbC.setOnClickListener(this.gbK);
            this.gbC.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.gbC.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.gbx, 0, this.gbx, this.gbI ? 0 : this.gby);
        }
        btV();
        View view = this.gbE.getView();
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
        this.gbv = this.mContentView.getMeasuredHeight();
        return this.gbv;
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

    private JSONObject Q(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.gbt == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!x.isEmpty(this.gbu)) {
            for (b.a aVar : this.gbu) {
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
            jSONObject.put("tid", this.gbt.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.gbt.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.gbt.getType())) {
                jSONObject.put("type", this.gbt.getType());
            }
            if (this.gbt.blU() != 0) {
                jSONObject.put("topic_id", this.gbt.blU());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bJS() {
        if (x.isEmpty(this.gbu)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.gbu) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bJT() {
        int size = this.gbu.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ao.getColor(R.color.CAM_X0302)));
            if (this.gbB != null) {
                this.gbB.setText(spannableString);
            }
            if (this.gbC != null) {
                this.gbC.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.gbB != null) {
            if (!com.baidu.tbadk.core.util.at.isEmpty(gbs)) {
                this.gbB.setText(gbs);
            } else {
                this.gbB.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.gbC != null) {
            this.gbC.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.gbt = atVar;
            this.gbe = atVar.getFeedBackReasonMap();
            if (this.gbe != null && this.gbe.size() > 9) {
                for (int size = this.gbe.size() - 1; size >= 9; size--) {
                    this.gbe.removeAt(size);
                }
            }
            this.gbE.setData(atVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gbE.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gbz = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.gbH = z;
    }

    public void setHeadText(String str) {
        if (!com.baidu.tbadk.core.util.at.isEmpty(str)) {
            gbs = str;
        }
    }

    public void aI(boolean z) {
        this.gbI = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gbE.setDefaultReasonArray(strArr);
    }

    public void bJR() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gbA != null) {
            this.gbA.dismiss();
            this.gbA = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.gbM);
        bJR();
    }

    private void Si() {
        if (this.gbF && this.gbu.size() != 0) {
            this.gbu.clear();
            bJT();
        }
    }

    private void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setViewTextColor(this.gbB, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJU() {
        if (this.gbt != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject Q = Q(arrayList);
            if (this.gbH) {
                if (!StringUtils.isNull(this.gbt.getType())) {
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, Q);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, Q);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
            }
            bJR();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            cVar.showSuccessToast(this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
            if (this.gbz != null) {
                this.gbz.onNEGFeedbackConfirm(arrayList, bJS(), this.gbt);
            }
        }
    }
}
