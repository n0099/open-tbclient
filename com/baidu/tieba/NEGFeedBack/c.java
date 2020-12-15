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
    private static String fWv;
    private int fWA;
    private int fWB;
    private PopupWindow fWD;
    private TextView fWE;
    private TBSpecificationBtn fWF;
    private com.baidu.tbadk.core.view.commonBtn.b fWG;
    private b fWH;
    private boolean fWI;
    private NEGFeedBackView fWJ;
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
    private at fWw = null;
    private SparseArray<String> fWh = null;
    private List<b.a> fWx = new ArrayList();
    private NEGFeedBackView.a fWC = null;
    private int mSkinType = 3;
    private boolean fWK = true;
    private boolean fWL = false;
    private CompoundButton.OnCheckedChangeListener fWl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.fWC != null) {
                c.this.fWC.onCheckedChanged(c.this.fWw, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.fWx.contains(aVar)) {
                        c.this.fWx.add(aVar);
                    }
                } else {
                    c.this.fWx.remove(aVar);
                }
            }
            if (c.this.fWJ != null && !y.isEmpty(c.this.fWx)) {
                c.this.fWJ.removeCallbacks(c.this.fWM);
                c.this.fWJ.postDelayed(c.this.fWM, 500L);
            }
        }
    };
    private Runnable fWM = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bLt();
        }
    };
    private View.OnClickListener fWN = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bLt();
        }
    };
    private PopupWindow.OnDismissListener fWO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.fWJ != null) {
                c.this.fWJ.setACRotateAnimation();
                c.this.fWJ.removeCallbacks(c.this.fWM);
                c.this.fWJ = null;
            }
            if (c.this.fWD != null) {
                c.this.fWD.dismiss();
                c.this.fWD = null;
            }
        }
    };
    private CustomMessageListener fWP = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bLq();
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
        this.fWA = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.fWB = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fWz = l.getDimens(this.mContext, R.dimen.tbds160);
        this.fWH = new b(this.mPageContext);
        this.fWH.lz(true);
        this.fWH.lA(false);
        this.fWH.a(this.fWl);
        this.mPageContext.registerListener(this.fWP);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.fWP != null) {
                this.fWP.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fWP);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.fWL || (this.fWh != null && this.fWh.size() != 0)) {
                this.fWJ = (NEGFeedBackView) view;
                this.fWJ.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.fWz, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.fWO);
                UW();
                this.fWD = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fWD.setAttachedInDecor(false);
                }
                this.fWD.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.fWC != null) {
                        this.fWC.onNEGFeedbackWindowShow(this.fWw);
                    }
                    this.fWI = true;
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
            this.fWE = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!au.isEmpty(fWv)) {
                this.fWE.setText(fWv);
            }
            this.fWF = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.fWG = new com.baidu.tbadk.core.view.commonBtn.b();
            this.fWG.rh(R.color.CAM_X0304);
            this.fWF.setConfig(this.fWG);
            this.fWF.setOnClickListener(this.fWN);
            this.fWF.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.fWF.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.fWA, 0, this.fWA, this.fWL ? 0 : this.fWB);
        }
        bvt();
        View view = this.fWH.getView();
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
        this.fWy = this.mContentView.getMeasuredHeight();
        return this.fWy;
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
        if (this.fWw == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.fWx)) {
            for (b.a aVar : this.fWx) {
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
            jSONObject.put("tid", this.fWw.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.fWw.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.fWw.getType())) {
                jSONObject.put("type", this.fWw.getType());
            }
            if (this.fWw.bno() != 0) {
                jSONObject.put("topic_id", this.fWw.bno());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bLr() {
        if (y.isEmpty(this.fWx)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.fWx) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bLs() {
        int size = this.fWx.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)));
            if (this.fWE != null) {
                this.fWE.setText(spannableString);
            }
            if (this.fWF != null) {
                this.fWF.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.fWE != null) {
            if (!au.isEmpty(fWv)) {
                this.fWE.setText(fWv);
            } else {
                this.fWE.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.fWF != null) {
            this.fWF.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.fWw = atVar;
            this.fWh = atVar.getFeedBackReasonMap();
            if (this.fWh != null && this.fWh.size() > 9) {
                for (int size = this.fWh.size() - 1; size >= 9; size--) {
                    this.fWh.removeAt(size);
                }
            }
            this.fWH.setData(atVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fWH.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fWC = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.fWK = z;
    }

    public void setHeadText(String str) {
        if (!au.isEmpty(str)) {
            fWv = str;
        }
    }

    public void aJ(boolean z) {
        this.fWL = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWH.setDefaultReasonArray(strArr);
    }

    public void bLq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWD != null) {
            this.fWD.dismiss();
            this.fWD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fWP);
        bLq();
    }

    private void UW() {
        if (this.fWI && this.fWx.size() != 0) {
            this.fWx.clear();
            bLs();
        }
    }

    private void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fWE, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLt() {
        if (this.fWw != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject V = V(arrayList);
            if (this.fWK) {
                if (!StringUtils.isNull(this.fWw.getType())) {
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
            bLq();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            cVar.showSuccessToast(this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
            if (this.fWC != null) {
                this.fWC.onNEGFeedbackConfirm(arrayList, bLr(), this.fWw);
            }
        }
    }
}
