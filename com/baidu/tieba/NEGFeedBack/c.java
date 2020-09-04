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
import android.widget.RelativeLayout;
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
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c {
    private static String flH;
    private int flK;
    private int flL;
    private int flM;
    private PopupWindow flO;
    private TextView flP;
    private TextView flQ;
    private b flR;
    private boolean flS;
    private NEGFeedBackView flT;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private ar flI = null;
    private SparseArray<String> flv = null;
    private List<b.a> flJ = new ArrayList();
    private NEGFeedBackView.a flN = null;
    private int mSkinType = 3;
    private boolean flU = true;
    private boolean flV = false;
    private CompoundButton.OnCheckedChangeListener flz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.flN != null) {
                c.this.flN.onCheckedChanged(c.this.flI, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.flJ.contains(aVar)) {
                        c.this.flJ.add(aVar);
                    }
                } else {
                    c.this.flJ.remove(aVar);
                }
            }
            c.this.bAl();
        }
    };
    private View.OnClickListener flW = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.flI != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject V = c.this.V(arrayList);
                if (c.this.flU) {
                    if (!StringUtils.isNull(c.this.flI.getType())) {
                        CustomMessage customMessage = new CustomMessage((int) CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_BUSINESS_NEG_FEED_BACK_DELETE, V);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    } else {
                        CustomMessage customMessage2 = new CustomMessage((int) CmdConfigCustom.NEG_FEED_BACK_DELETE, c.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(CmdConfigCustom.NEG_FEED_BACK_DELETE, V);
                        customResponsedMessage2.setOrginalMessage(customMessage2);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                    }
                }
                c.this.bAj();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.toastTime = 1500L;
                cVar.showSuccessToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.flN != null) {
                    c.this.flN.onNEGFeedbackConfirm(arrayList, c.this.bAk(), c.this.flI);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener flX = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.flT != null) {
                c.this.flT.setACRotateAnimation();
                c.this.flT = null;
            }
            if (c.this.flO != null) {
                c.this.flO.dismiss();
                c.this.flO = null;
            }
        }
    };
    private CustomMessageListener flY = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bAj();
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
        this.mXOffset = l.getDimens(this.mContext, R.dimen.tbds44);
        this.mYOffset = l.getDimens(this.mContext, R.dimen.tbds28);
        this.mMargin = l.getDimens(this.mContext, R.dimen.tbds44);
        this.flM = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.flL = l.getDimens(this.mContext, R.dimen.tbds160);
        this.flR = new b(this.mPageContext);
        this.flR.a(this.flz);
        this.mPageContext.registerListener(this.flY);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.flY != null) {
                this.flY.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.flY);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.flV || (this.flv != null && this.flv.size() != 0)) {
                this.flT = (NEGFeedBackView) view;
                this.flT.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.flL, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.flX);
                resetState();
                this.flO = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.flO.setAttachedInDecor(false);
                }
                this.flO.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.flN != null) {
                        this.flN.onNEGFeedbackWindowShow(this.flI);
                    }
                    this.flS = true;
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
            this.flP = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!at.isEmpty(flH)) {
                this.flP.setText(flH);
            }
            this.flQ = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.flQ.setOnClickListener(this.flW);
            this.mContentView.setPadding(this.flM, this.mMargin, this.flM, this.flM + this.mArrowHeight);
            if (this.flV) {
                this.flP.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.flQ.setLayoutParams(layoutParams);
            }
        }
        bkF();
        View view = this.flR.getView();
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
        this.flK = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.flK;
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
            this.mContentView.setPadding(this.flM, this.mMargin, this.flM, this.flM + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.flM, this.mMargin + this.mArrowHeight, this.flM, this.flM);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject V(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.flI == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.flJ)) {
            for (b.a aVar : this.flJ) {
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
            jSONObject.put("tid", this.flI.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.flI.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.flI.getType())) {
                jSONObject.put("type", this.flI.getType());
            }
            if (this.flI.bdd() != 0) {
                jSONObject.put("topic_id", this.flI.bdd());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bAk() {
        if (y.isEmpty(this.flJ)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.flJ) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAl() {
        int size = this.flJ.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)));
            if (this.flP != null) {
                this.flP.setText(spannableString);
            }
            if (this.flQ != null) {
                this.flQ.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.flP != null) {
            if (!at.isEmpty(flH)) {
                this.flP.setText(flH);
            } else {
                this.flP.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.flQ != null) {
            this.flQ.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.flI = arVar;
            this.flv = arVar.getFeedBackReasonMap();
            if (this.flv != null && this.flv.size() > 9) {
                for (int size = this.flv.size() - 1; size >= 9; size--) {
                    this.flv.removeAt(size);
                }
            }
            this.flR.setData(arVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.flR.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.flN = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.flU = z;
    }

    public void setHeadText(String str) {
        if (!at.isEmpty(str)) {
            flH = str;
        }
    }

    public void aJ(boolean z) {
        this.flV = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.flR.setDefaultReasonArray(strArr);
    }

    public void bAj() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.flO != null) {
            this.flO.dismiss();
            this.flO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.flY);
        bAj();
    }

    private void resetState() {
        if (this.flS && this.flJ.size() != 0) {
            this.flJ.clear();
            bAl();
        }
    }

    private void bkF() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.flP, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.flQ, R.color.cp_cont_a, 1);
            ap.setBackgroundResource(this.flQ, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
