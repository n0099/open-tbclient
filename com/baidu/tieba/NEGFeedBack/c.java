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
import com.baidu.tbadk.core.data.av;
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
/* loaded from: classes.dex */
public class c {
    private static String gdM;
    private int gdP;
    private int gdQ;
    private int gdR;
    private int gdS;
    private PopupWindow gdU;
    private TextView gdV;
    private TBSpecificationBtn gdW;
    private com.baidu.tbadk.core.view.commonBtn.b gdX;
    private b gdY;
    private boolean gdZ;
    private NEGFeedBackView gea;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private av gdN = null;
    private SparseArray<String> gdy = null;
    private List<b.a> gdO = new ArrayList();
    private NEGFeedBackView.a gdT = null;
    private int mSkinType = 3;
    private boolean geb = true;
    private boolean gec = false;
    private CompoundButton.OnCheckedChangeListener gdC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.gdT != null) {
                c.this.gdT.onCheckedChanged(c.this.gdN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.gdO.contains(aVar)) {
                        c.this.gdO.add(aVar);
                    }
                } else {
                    c.this.gdO.remove(aVar);
                }
            }
            if (c.this.gea != null && !y.isEmpty(c.this.gdO)) {
                c.this.gea.removeCallbacks(c.this.ged);
                c.this.gea.postDelayed(c.this.ged, 500L);
            }
        }
    };
    private Runnable ged = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bKt();
        }
    };
    private View.OnClickListener gee = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bKt();
        }
    };
    private PopupWindow.OnDismissListener gef = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.gea != null) {
                c.this.gea.setACRotateAnimation();
                c.this.gea.removeCallbacks(c.this.ged);
                c.this.gea = null;
            }
            if (c.this.gdU != null) {
                c.this.gdU.dismiss();
                c.this.gdU = null;
            }
        }
    };
    private CustomMessageListener geg = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bKq();
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
        this.gdR = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.gdS = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gdQ = l.getDimens(this.mContext, R.dimen.tbds160);
        this.gdY = new b(this.mPageContext);
        this.gdY.lW(true);
        this.gdY.lX(false);
        this.gdY.a(this.gdC);
        this.mPageContext.registerListener(this.geg);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.geg != null) {
                this.geg.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.geg);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.gec || (this.gdy != null && this.gdy.size() != 0)) {
                this.gea = (NEGFeedBackView) view;
                this.gea.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.gdQ, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.gef);
                TP();
                this.gdU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gdU.setAttachedInDecor(false);
                }
                this.gdU.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.gdT != null) {
                        this.gdT.onNEGFeedbackWindowShow(this.gdN);
                    }
                    this.gdZ = true;
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
            this.gdV = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!au.isEmpty(gdM)) {
                this.gdV.setText(gdM);
            }
            this.gdW = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.gdX = new com.baidu.tbadk.core.view.commonBtn.b();
            this.gdX.pR(R.color.CAM_X0304);
            this.gdW.setConfig(this.gdX);
            this.gdW.setOnClickListener(this.gee);
            this.gdW.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.gdW.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.gdR, 0, this.gdR, this.gec ? 0 : this.gdS);
        }
        bup();
        View view = this.gdY.getView();
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
        this.gdP = this.mContentView.getMeasuredHeight();
        return this.gdP;
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

    private JSONObject P(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.gdN == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.gdO)) {
            for (b.a aVar : this.gdO) {
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
            jSONObject.put("tid", this.gdN.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.gdN.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.gdN.getType())) {
                jSONObject.put("type", this.gdN.getType());
            }
            if (this.gdN.bmn() != 0) {
                jSONObject.put("topic_id", this.gdN.bmn());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bKr() {
        if (y.isEmpty(this.gdO)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.gdO) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bKs() {
        int size = this.gdO.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)));
            if (this.gdV != null) {
                this.gdV.setText(spannableString);
            }
            if (this.gdW != null) {
                this.gdW.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.gdV != null) {
            if (!au.isEmpty(gdM)) {
                this.gdV.setText(gdM);
            } else {
                this.gdV.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.gdW != null) {
            this.gdW.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gdN = avVar;
            this.gdy = avVar.getFeedBackReasonMap();
            if (this.gdy != null && this.gdy.size() > 9) {
                for (int size = this.gdy.size() - 1; size >= 9; size--) {
                    this.gdy.removeAt(size);
                }
            }
            this.gdY.setData(avVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gdY.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdT = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.geb = z;
    }

    public void setHeadText(String str) {
        if (!au.isEmpty(str)) {
            gdM = str;
        }
    }

    public void aI(boolean z) {
        this.gec = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdY.setDefaultReasonArray(strArr);
    }

    public void bKq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gdU != null) {
            this.gdU.dismiss();
            this.gdU = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.geg);
        bKq();
    }

    private void TP() {
        if (this.gdZ && this.gdO.size() != 0) {
            this.gdO.clear();
            bKs();
        }
    }

    private void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.gdV, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKt() {
        if (this.gdN != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject P = P(arrayList);
            if (this.geb) {
                if (!StringUtils.isNull(this.gdN.getType())) {
                    CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, P);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, P);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
            }
            bKq();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            String string = this.mContext.getResources().getString(R.string.reduce_related_thread_recommend);
            if (P != null && "7".equals(P.optString("dislike_ids"))) {
                string = this.mContext.getResources().getString(R.string.forbidden_forum_success);
            }
            cVar.showSuccessToast(string);
            if (this.gdT != null) {
                this.gdT.onNEGFeedbackConfirm(arrayList, bKr(), this.gdN);
            }
        }
    }
}
