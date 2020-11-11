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
/* loaded from: classes21.dex */
public class c {
    private static String fOZ;
    private int fPc;
    private int fPd;
    private int fPe;
    private PopupWindow fPg;
    private TextView fPh;
    private TextView fPi;
    private b fPj;
    private boolean fPk;
    private NEGFeedBackView fPl;
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
    private ar fPa = null;
    private SparseArray<String> fON = null;
    private List<b.a> fPb = new ArrayList();
    private NEGFeedBackView.a fPf = null;
    private int mSkinType = 3;
    private boolean fPm = true;
    private boolean fPn = false;
    private CompoundButton.OnCheckedChangeListener fOR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.fPf != null) {
                c.this.fPf.onCheckedChanged(c.this.fPa, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.fPb.contains(aVar)) {
                        c.this.fPb.add(aVar);
                    }
                } else {
                    c.this.fPb.remove(aVar);
                }
            }
            c.this.bIy();
        }
    };
    private View.OnClickListener fPo = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.fPa != null && c.this.mPopupWindow != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject V = c.this.V(arrayList);
                if (c.this.fPm) {
                    if (!StringUtils.isNull(c.this.fPa.getType())) {
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
                c.this.bIw();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.toastTime = 1500L;
                cVar.showSuccessToast(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.fPf != null) {
                    c.this.fPf.onNEGFeedbackConfirm(arrayList, c.this.bIx(), c.this.fPa);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener fPp = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.fPl != null) {
                c.this.fPl.setACRotateAnimation();
                c.this.fPl = null;
            }
            if (c.this.fPg != null) {
                c.this.fPg.dismiss();
                c.this.fPg = null;
            }
        }
    };
    private CustomMessageListener fPq = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bIw();
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
        this.fPe = l.getDimens(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.getDimens(this.mContext, R.dimen.tbds39);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fPd = l.getDimens(this.mContext, R.dimen.tbds160);
        this.fPj = new b(this.mPageContext);
        this.fPj.a(this.fOR);
        this.mPageContext.registerListener(this.fPq);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.fPq != null) {
                this.fPq.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.fPq);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.fPn || (this.fON != null && this.fON.size() != 0)) {
                this.fPl = (NEGFeedBackView) view;
                this.fPl.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.fPd, this.mYOffset, iArr);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.fPp);
                resetState();
                this.fPg = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fPg.setAttachedInDecor(false);
                }
                this.fPg.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                        ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_down);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                        ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_tost_feedback_up);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.fPf != null) {
                        this.fPf.onNEGFeedbackWindowShow(this.fPa);
                    }
                    this.fPk = true;
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
            this.fPh = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!at.isEmpty(fOZ)) {
                this.fPh.setText(fOZ);
            }
            this.fPi = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.fPi.setOnClickListener(this.fPo);
            this.mContentView.setPadding(this.fPe, this.mMargin, this.fPe, this.fPe + this.mArrowHeight);
            if (this.fPn) {
                this.fPh.setPadding(0, l.getDimens(this.mContext, R.dimen.tbds17), 0, 0);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, l.getDimens(this.mContext, R.dimen.tbds74));
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.tbds0);
                layoutParams.addRule(11);
                this.fPi.setLayoutParams(layoutParams);
            }
        }
        bsD();
        View view = this.fPj.getView();
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
        this.fPc = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.fPc;
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
            this.mContentView.setPadding(this.fPe, this.mMargin, this.fPe, this.fPe + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.fPe, this.mMargin + this.mArrowHeight, this.fPe, this.fPe);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject V(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.fPa == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.fPb)) {
            for (b.a aVar : this.fPb) {
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
            jSONObject.put("tid", this.fPa.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.fPa.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.fPa.getType())) {
                jSONObject.put("type", this.fPa.getType());
            }
            if (this.fPa.bkZ() != 0) {
                jSONObject.put("topic_id", this.fPa.bkZ());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bIx() {
        if (y.isEmpty(this.fPb)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.fPb) {
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
    public void bIy() {
        int size = this.fPb.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.cp_link_tip_a)));
            if (this.fPh != null) {
                this.fPh.setText(spannableString);
            }
            if (this.fPi != null) {
                this.fPi.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.fPh != null) {
            if (!at.isEmpty(fOZ)) {
                this.fPh.setText(fOZ);
            } else {
                this.fPh.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.fPi != null) {
            this.fPi.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(ar arVar) {
        if (arVar != null) {
            this.fPa = arVar;
            this.fON = arVar.getFeedBackReasonMap();
            if (this.fON != null && this.fON.size() > 9) {
                for (int size = this.fON.size() - 1; size >= 9; size--) {
                    this.fON.removeAt(size);
                }
            }
            this.fPj.setData(arVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.fPj.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.fPf = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.fPm = z;
    }

    public void setHeadText(String str) {
        if (!at.isEmpty(str)) {
            fOZ = str;
        }
    }

    public void aJ(boolean z) {
        this.fPn = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fPj.setDefaultReasonArray(strArr);
    }

    public void bIw() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fPg != null) {
            this.fPg.dismiss();
            this.fPg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.fPq);
        bIw();
    }

    private void resetState() {
        if (this.fPk && this.fPb.size() != 0) {
            this.fPb.clear();
            bIy();
        }
    }

    private void bsD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fPh, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.fPi, R.color.cp_cont_a, 1);
            ap.setBackgroundResource(this.fPi, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
