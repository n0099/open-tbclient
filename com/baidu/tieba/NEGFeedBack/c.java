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
    private static String gfq;
    private TBSpecificationBtn gfA;
    private com.baidu.tbadk.core.view.commonBtn.b gfB;
    private b gfC;
    private boolean gfD;
    private NEGFeedBackView gfE;
    private int gft;
    private int gfu;
    private int gfv;
    private int gfw;
    private PopupWindow gfy;
    private TextView gfz;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow mPopupWindow = null;
    private av gfr = null;
    private SparseArray<String> gfc = null;
    private List<b.a> gfs = new ArrayList();
    private NEGFeedBackView.a gfx = null;
    private int mSkinType = 3;
    private boolean gfF = true;
    private boolean gfG = false;
    private CompoundButton.OnCheckedChangeListener gfg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.gfx != null) {
                c.this.gfx.onCheckedChanged(c.this.gfr, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.gfs.contains(aVar)) {
                        c.this.gfs.add(aVar);
                    }
                } else {
                    c.this.gfs.remove(aVar);
                }
            }
            if (c.this.gfE != null && !y.isEmpty(c.this.gfs)) {
                c.this.gfE.removeCallbacks(c.this.gfH);
                c.this.gfE.postDelayed(c.this.gfH, 500L);
            }
        }
    };
    private Runnable gfH = new Runnable() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // java.lang.Runnable
        public void run() {
            c.this.bKx();
        }
    };
    private View.OnClickListener gfI = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.bKx();
        }
    };
    private PopupWindow.OnDismissListener gfJ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.gfE != null) {
                c.this.gfE.setACRotateAnimation();
                c.this.gfE.removeCallbacks(c.this.gfH);
                c.this.gfE = null;
            }
            if (c.this.gfy != null) {
                c.this.gfy.dismiss();
                c.this.gfy = null;
            }
        }
    };
    private CustomMessageListener gfK = new CustomMessageListener(CmdConfigCustom.CMD_HIDE_NEGATIVE_FEED_BACK_WIN) { // from class: com.baidu.tieba.NEGFeedBack.c.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.bKu();
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
        this.gfv = l.getDimens(this.mContext, R.dimen.M_W_X005);
        this.gfw = l.getDimens(this.mContext, R.dimen.M_H_X007);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gfu = l.getDimens(this.mContext, R.dimen.tbds160);
        this.gfC = new b(this.mPageContext);
        this.gfC.lW(true);
        this.gfC.lX(false);
        this.gfC.a(this.gfg);
        this.mPageContext.registerListener(this.gfK);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.gfK != null) {
                this.gfK.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.gfK);
        }
    }

    public void O(View view) {
        if (this.mContext != null) {
            if (this.gfG || (this.gfc != null && this.gfc.size() != 0)) {
                this.gfE = (NEGFeedBackView) view;
                this.gfE.setCWRotateAnimation();
                View contentView = getContentView();
                this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
                this.mWindowHeight = getWindowMeasuredHeight();
                int[] iArr = new int[2];
                boolean a2 = a(this.mContext, this.mAnchor, this.mWindowHeight, this.mWindowWidth, this.gfu, this.mYOffset, iArr);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0204));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                contentView.setBackgroundDrawable(gradientDrawable);
                this.mPopupWindow = new PopupWindow(contentView, this.mWindowWidth, getWindowMeasuredHeight());
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.gfJ);
                TS();
                this.gfy = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gfy.setAttachedInDecor(false);
                }
                this.gfy.showAtLocation(this.mAnchor, 0, 0, 0);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.mPopupWindow.setBackgroundDrawable(new ColorDrawable(0));
                    if (a2) {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rb2lt_anim);
                    } else {
                        this.mPopupWindow.setAnimationStyle(R.style.scale_rt2lb_anim);
                    }
                    this.mPopupWindow.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                    if (this.gfx != null) {
                        this.gfx.onNEGFeedbackWindowShow(this.gfr);
                    }
                    this.gfD = true;
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
            this.gfz = (TextView) this.mContentView.findViewById(R.id.head_text);
            if (!au.isEmpty(gfq)) {
                this.gfz.setText(gfq);
            }
            this.gfA = (TBSpecificationBtn) this.mContentView.findViewById(R.id.uninterested_btn);
            this.gfB = new com.baidu.tbadk.core.view.commonBtn.b();
            this.gfB.pS(R.color.CAM_X0304);
            this.gfA.setConfig(this.gfB);
            this.gfA.setOnClickListener(this.gfI);
            this.gfA.setText(this.mContext.getResources().getString(R.string.not_interested));
            this.gfA.setTextSize(R.dimen.T_X08);
            this.mContentView.setPadding(this.gfv, 0, this.gfv, this.gfG ? 0 : this.gfw);
        }
        bus();
        View view = this.gfC.getView();
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
        this.gft = this.mContentView.getMeasuredHeight();
        return this.gft;
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
        if (this.gfr == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!y.isEmpty(this.gfs)) {
            for (b.a aVar : this.gfs) {
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
            jSONObject.put("tid", this.gfr.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.gfr.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.gfr.getType())) {
                jSONObject.put("type", this.gfr.getType());
            }
            if (this.gfr.bmp() != 0) {
                jSONObject.put("topic_id", this.gfr.bmp());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private String bKv() {
        if (y.isEmpty(this.gfs)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.gfs) {
            if (aVar != null) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(aVar.reason);
            }
        }
        return sb.toString();
    }

    private void bKw() {
        int size = this.gfs.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(ap.getColor(R.color.CAM_X0302)));
            if (this.gfz != null) {
                this.gfz.setText(spannableString);
            }
            if (this.gfA != null) {
                this.gfA.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.gfz != null) {
            if (!au.isEmpty(gfq)) {
                this.gfz.setText(gfq);
            } else {
                this.gfz.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
            }
        }
        if (this.gfA != null) {
            this.gfA.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gfr = avVar;
            this.gfc = avVar.getFeedBackReasonMap();
            if (this.gfc != null && this.gfc.size() > 9) {
                for (int size = this.gfc.size() - 1; size >= 9; size--) {
                    this.gfc.removeAt(size);
                }
            }
            this.gfC.setData(avVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.gfC.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.gfx = aVar;
    }

    public void setAutoProcess(boolean z) {
        this.gfF = z;
    }

    public void setHeadText(String str) {
        if (!au.isEmpty(str)) {
            gfq = str;
        }
    }

    public void aI(boolean z) {
        this.gfG = z;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gfC.setDefaultReasonArray(strArr);
    }

    public void bKu() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gfy != null) {
            this.gfy.dismiss();
            this.gfy = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.gfK);
        bKu();
    }

    private void TS() {
        if (this.gfD && this.gfs.size() != 0) {
            this.gfs.clear();
            bKw();
        }
    }

    private void bus() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.gfz, R.color.CAM_X0105, 1);
            this.mSkinType = skinType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKx() {
        if (this.gfr != null && this.mPopupWindow != null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            JSONObject P = P(arrayList);
            if (this.gfF) {
                if (!StringUtils.isNull(this.gfr.getType())) {
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
            bKu();
            com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
            cVar.toastTime = 1500L;
            String string = this.mContext.getResources().getString(R.string.reduce_related_thread_recommend);
            if (P != null && "7".equals(P.optString("dislike_ids"))) {
                string = this.mContext.getResources().getString(R.string.forbidden_forum_success);
            }
            cVar.showSuccessToast(string);
            if (this.gfx != null) {
                this.gfx.onNEGFeedbackConfirm(arrayList, bKv(), this.gfr);
            }
        }
    }
}
