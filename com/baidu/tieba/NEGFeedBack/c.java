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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes21.dex */
public class c {
    private static String fWt;
    private PopupWindow fWB;
    private TextView fWC;
    private TBSpecificationBtn fWD;
    private com.baidu.tbadk.core.view.commonBtn.b fWE;
    private b fWF;
    private boolean fWG;
    private NEGFeedBackView fWH;
    private int fWw;
    private int fWx;
    private int fWy;
    private int fWz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private at fWu = null;
    private SparseArray<String> fWf = null;
    private List<b.a> fWv = new ArrayList();
    private NEGFeedBackView.a fWA = null;
    private int mSkinType = 3;
    private boolean fWI = true;
    private boolean fWJ = false;
    private CompoundButton.OnCheckedChangeListener fWj = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.fWA != null) {
                c.this.fWA.onCheckedChanged(c.this.fWu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.fWv.contains(aVar)) {
                        c.this.fWv.add(aVar);
                    }
                } else {
                    c.this.fWv.remove(aVar);
                }
            }
            if (c.this.fWH != null && !y.isEmpty(c.this.fWv)) {
                c.this.fWH.removeCallbacks(c.this.fWK);
                c.this.fWH.postDelayed(c.this.fWK, 500L);
            }
        }
    };
    private Runnable fWK = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLs();
        }
    };
    private View.OnClickListener fWL = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bLs();
        }
    };
    private PopupWindow.OnDismissListener fWM = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.fWH != null) {
                c.this.fWH.setACRotateAnimation();
                c.this.fWH.removeCallbacks(c.this.fWK);
                c.this.fWH = null;
            }
            if (c.this.fWB != null) {
                c.this.fWB.dismiss();
                c.this.fWB = null;
            }
        }
    };
    private CustomMessageListener fWN = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bLp();
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
        this.mXOffset = com.baidu.tbadk.a.d.bkA() ? l.getDimens(this.mContext, R.dimen.M_W_X007) : l.getDimens(this.mContext, R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.tbds14);
        this.fWy = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.fWz = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fWx = l.getDimens(this.mContext, R.dimen.tbds160);
        this.fWF = new b(this.mPageContext);
        this.fWF.lz(true);
        this.fWF.lA(false);
        this.fWF.a(this.fWj);
        this.mPageContext.registerListener(this.fWN);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.fWN != null) {
                this.fWN.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fWN);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.fWJ || (this.fWf != null && this.fWf.size() != 0)) {
                this.fWH = (NEGFeedBackView) view;
                this.fWH.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.fWx, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.fWM);
                UW();
                this.fWB = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fWB.setAttachedInDecor(false);
                }
                this.fWB.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.fWA != null) {
                        this.fWA.onNEGFeedbackWindowShow(this.fWu);
                    }
                    this.fWG = true;
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
            this.fWC = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!au.isEmpty(fWt)) {
                this.fWC.setText(fWt);
            }
            this.fWD = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.fWE = new com.baidu.tbadk.core.view.commonBtn.b();
            this.fWE.rh(R.color.CAM_X0304);
            this.fWD.setConfig(this.fWE);
            this.fWD.setOnClickListener(this.fWL);
            this.fWD.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.fWD.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.fWy, 0, this.fWy, this.fWJ ? 0 : this.fWz);
        }
        bvt();
        View view = this.fWF.getView();
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
        this.fWw = this.mContentView.getMeasuredHeight();
        return this.fWw;
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
        if (this.fWu == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.fWv)) {
            for (b.a aVar : this.fWv) {
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
            jSONObject.put("tid", this.fWu.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.fWu.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.fWu.getType())) {
                jSONObject.put("type", this.fWu.getType());
            }
            if (this.fWu.bno() != 0) {
                jSONObject.put("topic_id", this.fWu.bno());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bLq() {
        if (y.isEmpty(this.fWv)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.fWv) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bLr() {
        int size = this.fWv.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)));
            if (this.fWC != null) {
                this.fWC.setText(spannableString);
            }
            if (this.fWD != null) {
                this.fWD.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.fWC != null) {
            if (!au.isEmpty(fWt)) {
                this.fWC.setText(fWt);
            } else {
                this.fWC.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.fWD != null) {
            this.fWD.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.fWu = atVar;
            this.fWf = atVar.getFeedBackReasonMap();
            if (this.fWf != null && this.fWf.size() > 9) {
                for (int size = this.fWf.size() - 1; size >= 9; size--) {
                    this.fWf.removeAt(size);
                }
            }
            this.fWF.setData(atVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fWF.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWA = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.fWI = z;
    }

    public void setHeadText(String str) {
        if (!au.isEmpty(str)) {
            fWt = str;
        }
    }

    public void aJ(boolean z) {
        this.fWJ = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWF.setDefaultReasonArray(strArr);
    }

    public void bLp() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWB != null) {
            this.fWB.dismiss();
            this.fWB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fWN);
        bLp();
    }

    private void UW() {
        if (this.fWG && this.fWv.size() != 0) {
            this.fWv.clear();
            bLr();
        }
    }

    private void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fWC, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLs() {
        if (this.fWu != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject V = V(arrayList);
            if (this.fWI) {
                if (!StringUtils.isNull(this.fWu.getType())) {
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
            bLp();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            cVar.showSuccessToast(this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
            if (this.fWA != null) {
                this.fWA.onNEGFeedbackConfirm(arrayList, bLq(), this.fWu);
            }
        }
    }
}
