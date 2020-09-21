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
/* loaded from: classes20.dex */
public class c {
    private static String foA;
    private int foD;
    private int foE;
    private int foF;
    private PopupWindow foH;
    private TextView foI;
    private TextView foJ;
    private b foK;
    private boolean foL;
    private NEGFeedBackView foM;
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
    private ar foB = null;
    private SparseArray<String> foo = null;
    private List<b.a> foC = new ArrayList();
    private NEGFeedBackView.a foG = null;
    private int mSkinType = 3;
    private boolean foN = true;
    private boolean foO = false;
    private CompoundButton.OnCheckedChangeListener fos = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.foG != null) {
                c.this.foG.onCheckedChanged(c.this.foB, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.foC.contains(aVar)) {
                        c.this.foC.add(aVar);
                    }
                } else {
                    c.this.foC.remove(aVar);
                }
            }
            c.this.bBu();
        }
    };
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.foB != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject V = c.this.V(arrayList);
                if (c.this.foN) {
                    if (!StringUtils.isNull(c.this.foB.getType())) {
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
                c.this.bBs();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.toastTime = 1500L;
                cVar.showSuccessToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.foG != null) {
                    c.this.foG.onNEGFeedbackConfirm(arrayList, c.this.bBt(), c.this.foB);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener foQ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.foM != null) {
                c.this.foM.setACRotateAnimation();
                c.this.foM = null;
            }
            if (c.this.foH != null) {
                c.this.foH.dismiss();
                c.this.foH = null;
            }
        }
    };
    private CustomMessageListener foR = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bBs();
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
        this.foF = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.foE = l.getDimens(this.mContext, R.dimen.tbds160);
        this.foK = new b(this.mPageContext);
        this.foK.a(this.fos);
        this.mPageContext.registerListener(this.foR);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.foR != null) {
                this.foR.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.foR);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.foO || (this.foo != null && this.foo.size() != 0)) {
                this.foM = (NEGFeedBackView) view;
                this.foM.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.foE, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.foQ);
                resetState();
                this.foH = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.foH.setAttachedInDecor(false);
                }
                this.foH.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.foG != null) {
                        this.foG.onNEGFeedbackWindowShow(this.foB);
                    }
                    this.foL = true;
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
            this.foI = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!at.isEmpty(foA)) {
                this.foI.setText(foA);
            }
            this.foJ = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.foJ.setOnClickListener(this.foP);
            this.mContentView.setPadding(this.foF, this.mMargin, this.foF, this.foF + this.mArrowHeight);
            if (this.foO) {
                this.foI.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.foJ.setLayoutParams(layoutParams);
            }
        }
        blA();
        View view = this.foK.getView();
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
        this.foD = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.foD;
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
            this.mContentView.setPadding(this.foF, this.mMargin, this.foF, this.foF + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.foF, this.mMargin + this.mArrowHeight, this.foF, this.foF);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject V(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.foB == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.foC)) {
            for (b.a aVar : this.foC) {
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
            jSONObject.put("tid", this.foB.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.foB.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.foB.getType())) {
                jSONObject.put("type", this.foB.getType());
            }
            if (this.foB.bdX() != 0) {
                jSONObject.put("topic_id", this.foB.bdX());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bBt() {
        if (y.isEmpty(this.foC)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.foC) {
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
    public void bBu() {
        int size = this.foC.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)));
            if (this.foI != null) {
                this.foI.setText(spannableString);
            }
            if (this.foJ != null) {
                this.foJ.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.foI != null) {
            if (!at.isEmpty(foA)) {
                this.foI.setText(foA);
            } else {
                this.foI.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.foJ != null) {
            this.foJ.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.foB = arVar;
            this.foo = arVar.getFeedBackReasonMap();
            if (this.foo != null && this.foo.size() > 9) {
                for (int size = this.foo.size() - 1; size >= 9; size--) {
                    this.foo.removeAt(size);
                }
            }
            this.foK.setData(arVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.foK.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.foG = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.foN = z;
    }

    public void setHeadText(String str) {
        if (!at.isEmpty(str)) {
            foA = str;
        }
    }

    public void aJ(boolean z) {
        this.foO = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.foK.setDefaultReasonArray(strArr);
    }

    public void bBs() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.foH != null) {
            this.foH.dismiss();
            this.foH = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.foR);
        bBs();
    }

    private void resetState() {
        if (this.foL && this.foC.size() != 0) {
            this.foC.clear();
            bBu();
        }
    }

    private void blA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.foI, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.foJ, R.color.cp_cont_a, 1);
            ap.setBackgroundResource(this.foJ, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
