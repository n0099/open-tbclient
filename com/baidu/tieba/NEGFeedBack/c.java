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
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class c {
    private static String fOF;
    private int fOI;
    private int fOJ;
    private int fOK;
    private int fOL;
    private PopupWindow fON;
    private TextView fOO;
    private TBSpecificationBtn fOP;
    private com.baidu.tbadk.core.view.commonBtn.b fOQ;
    private b fOR;
    private boolean fOS;
    private NEGFeedBackView fOT;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private as fOG = null;
    private SparseArray<String> fOt = null;
    private List<b.a> fOH = new ArrayList();
    private NEGFeedBackView.a fOM = null;
    private int mSkinType = 3;
    private boolean fOU = true;
    private boolean fOV = false;
    private CompoundButton.OnCheckedChangeListener fOx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.fOM != null) {
                c.this.fOM.onCheckedChanged(c.this.fOG, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.fOH.contains(aVar)) {
                        c.this.fOH.add(aVar);
                    }
                } else {
                    c.this.fOH.remove(aVar);
                }
            }
            if (compoundButton != null) {
                compoundButton.postDelayed(new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.bHS();
                    }
                }, 500L);
            }
        }
    };
    private View.OnClickListener fOW = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bHS();
        }
    };
    private PopupWindow.OnDismissListener fOX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.fOT != null) {
                c.this.fOT.setACRotateAnimation();
                c.this.fOT = null;
            }
            if (c.this.fON != null) {
                c.this.fON.dismiss();
                c.this.fON = null;
            }
        }
    };
    private CustomMessageListener fOY = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bHP();
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
        this.mXOffset = com.baidu.tbadk.a.d.bhw() ? l.getDimens(this.mContext, R.dimen.M_W_X007) : l.getDimens(this.mContext, R.dimen.M_W_X004);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.tbds14);
        this.fOK = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.fOL = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fOJ = l.getDimens(this.mContext, R.dimen.tbds160);
        this.fOR = new b(this.mPageContext);
        this.fOR.a(this.fOx);
        this.mPageContext.registerListener(this.fOY);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.fOY != null) {
                this.fOY.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fOY);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.fOV || (this.fOt != null && this.fOt.size() != 0)) {
                this.fOT = (NEGFeedBackView) view;
                this.fOT.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.fOJ, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.fOX);
                resetState();
                this.fON = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fON.setAttachedInDecor(false);
                }
                this.fON.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.fOM != null) {
                        this.fOM.onNEGFeedbackWindowShow(this.fOG);
                    }
                    this.fOS = true;
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
            this.fOO = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!au.isEmpty(fOF)) {
                this.fOO.setText(fOF);
            }
            this.fOP = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.fOQ = new com.baidu.tbadk.core.view.commonBtn.b();
            this.fOQ.qG(R.color.CAM_X0304);
            this.fOP.setConfig(this.fOQ);
            this.fOP.setOnClickListener(this.fOW);
            this.fOP.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.fOP.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.fOK, 0, this.fOK, this.fOV ? 0 : this.fOL);
        }
        brT();
        View view = this.fOR.getView();
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
        this.fOI = this.mContentView.getMeasuredHeight();
        return this.fOI;
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
        if (this.fOG == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.fOH)) {
            for (b.a aVar : this.fOH) {
                if (aVar != null) {
                    arrayList.add(Integer.valueOf(aVar.id));
                    if (sb.length() != 0) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb.append(String.valueOf(aVar.id));
                    if (sb2.length() != 0) {
                        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    sb2.append(aVar.extra);
                }
            }
        }
        try {
            jSONObject.put("tid", this.fOG.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.fOG.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.fOG.getType())) {
                jSONObject.put("type", this.fOG.getType());
            }
            if (this.fOG.bkb() != 0) {
                jSONObject.put("topic_id", this.fOG.bkb());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bHQ() {
        if (y.isEmpty(this.fOH)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.fOH) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bHR() {
        int size = this.fOH.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)));
            if (this.fOO != null) {
                this.fOO.setText(spannableString);
            }
            if (this.fOP != null) {
                this.fOP.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.fOO != null) {
            if (!au.isEmpty(fOF)) {
                this.fOO.setText(fOF);
            } else {
                this.fOO.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.fOP != null) {
            this.fOP.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(as asVar) {
        if (asVar != null) {
            this.fOG = asVar;
            this.fOt = asVar.getFeedBackReasonMap();
            if (this.fOt != null && this.fOt.size() > 9) {
                for (int size = this.fOt.size() - 1; size >= 9; size--) {
                    this.fOt.removeAt(size);
                }
            }
            this.fOR.setData(asVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fOR.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fOM = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.fOU = z;
    }

    public void setHeadText(String str) {
        if (!au.isEmpty(str)) {
            fOF = str;
        }
    }

    public void aK(boolean z) {
        this.fOV = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fOR.setDefaultReasonArray(strArr);
    }

    public void bHP() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fON != null) {
            this.fON.dismiss();
            this.fON = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fOY);
        bHP();
    }

    private void resetState() {
        if (this.fOS && this.fOH.size() != 0) {
            this.fOH.clear();
            bHR();
        }
    }

    private void brT() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fOO, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHS() {
        if (this.fOG != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject V = V(arrayList);
            if (this.fOU) {
                if (!StringUtils.isNull(this.fOG.getType())) {
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
            bHP();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            cVar.showSuccessToast(this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
            if (this.fOM != null) {
                this.fOM.onNEGFeedbackConfirm(arrayList, bHQ(), this.fOG);
            }
        }
    }
}
