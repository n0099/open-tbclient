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
    private static String gdH;
    private int gdK;
    private int gdL;
    private int gdM;
    private int gdN;
    private PopupWindow gdP;
    private TextView gdQ;
    private TBSpecificationBtn gdR;
    private com.baidu.tbadk.core.view.commonBtn.b gdS;
    private b gdT;
    private boolean gdU;
    private NEGFeedBackView gdV;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private av gdI = null;
    private SparseArray<String> gdt = null;
    private List<b.a> gdJ = new ArrayList();
    private NEGFeedBackView.a gdO = null;
    private int mSkinType = 3;
    private boolean gdW = true;
    private boolean gdX = false;
    private CompoundButton.OnCheckedChangeListener gdx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.gdO != null) {
                c.this.gdO.onCheckedChanged(c.this.gdI, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.gdJ.contains(aVar)) {
                        c.this.gdJ.add(aVar);
                    }
                } else {
                    c.this.gdJ.remove(aVar);
                }
            }
            if (c.this.gdV != null && !y.isEmpty(c.this.gdJ)) {
                c.this.gdV.removeCallbacks(c.this.gdY);
                c.this.gdV.postDelayed(c.this.gdY, 500L);
            }
        }
    };
    private Runnable gdY = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bKo();
        }
    };
    private View.OnClickListener gdZ = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bKo();
        }
    };
    private PopupWindow.OnDismissListener gea = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.gdV != null) {
                c.this.gdV.setACRotateAnimation();
                c.this.gdV.removeCallbacks(c.this.gdY);
                c.this.gdV = null;
            }
            if (c.this.gdP != null) {
                c.this.gdP.dismiss();
                c.this.gdP = null;
            }
        }
    };
    private CustomMessageListener geb = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bKl();
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
        this.gdM = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.gdN = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gdL = l.getDimens(this.mContext, R.dimen.tbds160);
        this.gdT = new b(this.mPageContext);
        this.gdT.lW(true);
        this.gdT.lX(false);
        this.gdT.a(this.gdx);
        this.mPageContext.registerListener(this.geb);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.geb != null) {
                this.geb.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.geb);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.gdX || (this.gdt != null && this.gdt.size() != 0)) {
                this.gdV = (NEGFeedBackView) view;
                this.gdV.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.gdL, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.gea);
                TP();
                this.gdP = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gdP.setAttachedInDecor(false);
                }
                this.gdP.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.gdO != null) {
                        this.gdO.onNEGFeedbackWindowShow(this.gdI);
                    }
                    this.gdU = true;
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
            this.gdQ = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!au.isEmpty(gdH)) {
                this.gdQ.setText(gdH);
            }
            this.gdR = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.gdS = new com.baidu.tbadk.core.view.commonBtn.b();
            this.gdS.pR(R.color.CAM_X0304);
            this.gdR.setConfig(this.gdS);
            this.gdR.setOnClickListener(this.gdZ);
            this.gdR.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.gdR.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.gdM, 0, this.gdM, this.gdX ? 0 : this.gdN);
        }
        bup();
        View view = this.gdT.getView();
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
        this.gdK = this.mContentView.getMeasuredHeight();
        return this.gdK;
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
        if (this.gdI == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.gdJ)) {
            for (b.a aVar : this.gdJ) {
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
            jSONObject.put("tid", this.gdI.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.gdI.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.gdI.getType())) {
                jSONObject.put("type", this.gdI.getType());
            }
            if (this.gdI.bmn() != 0) {
                jSONObject.put("topic_id", this.gdI.bmn());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bKm() {
        if (y.isEmpty(this.gdJ)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.gdJ) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bKn() {
        int size = this.gdJ.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)));
            if (this.gdQ != null) {
                this.gdQ.setText(spannableString);
            }
            if (this.gdR != null) {
                this.gdR.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.gdQ != null) {
            if (!au.isEmpty(gdH)) {
                this.gdQ.setText(gdH);
            } else {
                this.gdQ.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.gdR != null) {
            this.gdR.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gdI = avVar;
            this.gdt = avVar.getFeedBackReasonMap();
            if (this.gdt != null && this.gdt.size() > 9) {
                for (int size = this.gdt.size() - 1; size >= 9; size--) {
                    this.gdt.removeAt(size);
                }
            }
            this.gdT.setData(avVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gdT.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gdO = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.gdW = z;
    }

    public void setHeadText(String str) {
        if (!au.isEmpty(str)) {
            gdH = str;
        }
    }

    public void aI(boolean z) {
        this.gdX = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdT.setDefaultReasonArray(strArr);
    }

    public void bKl() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gdP != null) {
            this.gdP.dismiss();
            this.gdP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.geb);
        bKl();
    }

    private void TP() {
        if (this.gdU && this.gdJ.size() != 0) {
            this.gdJ.clear();
            bKn();
        }
    }

    private void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.gdQ, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKo() {
        if (this.gdI != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject P = P(arrayList);
            if (this.gdW) {
                if (!StringUtils.isNull(this.gdI.getType())) {
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
            bKl();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            String string = this.mContext.getResources().getString(R.string.reduce_related_thread_recommend);
            if (P != null && "7".equals(P.optString("dislike_ids"))) {
                string = this.mContext.getResources().getString(R.string.forbidden_forum_success);
            }
            cVar.showSuccessToast(string);
            if (this.gdO != null) {
                this.gdO.onNEGFeedbackConfirm(arrayList, bKm(), this.gdI);
            }
        }
    }
}
