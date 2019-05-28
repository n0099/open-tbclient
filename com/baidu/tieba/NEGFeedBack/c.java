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
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    private int cRc;
    private int cRd;
    private int cRe;
    private int cRf;
    private PopupWindow cRh;
    private TextView cRi;
    private TextView cRj;
    private b cRk;
    private boolean cRl;
    private NEGFeedBackView cRm;
    private View mAnchor;
    private int mArrowHeight;
    private ViewGroup mContentView;
    private Context mContext;
    private int mMargin;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow aOK = null;
    private aj cRa = null;
    private SparseArray<String> cQM = null;
    private List<b.a> cRb = new ArrayList();
    private NEGFeedBackView.a cRg = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener cQP = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.cRg != null) {
                c.this.cRg.a(c.this.cRa, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.cRb.contains(aVar)) {
                        c.this.cRb.add(aVar);
                    }
                } else {
                    c.this.cRb.remove(aVar);
                }
            }
            c.this.aAc();
        }
    };
    private View.OnClickListener cRn = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.cRa != null && c.this.aOK != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject H = c.this.H(arrayList);
                if (!StringUtils.isNull(c.this.cRa.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, H);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, H);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.azZ();
                com.baidu.tbadk.core.view.e eVar = new com.baidu.tbadk.core.view.e();
                eVar.bXF = 1500L;
                eVar.j(c.this.mContext.getResources().getString(R.string.reduce_related_thread_recommend));
                if (c.this.cRg != null) {
                    c.this.cRg.a(arrayList, c.this.aAb(), c.this.cRa);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener cRo = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.cRm != null) {
                c.this.cRm.setACRotateAnimation();
                c.this.cRm = null;
            }
            if (c.this.cRh != null) {
                c.this.cRh.dismiss();
                c.this.cRh = null;
            }
        }
    };
    private CustomMessageListener cRp = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.azZ();
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
        this.mXOffset = l.g(this.mContext, R.dimen.tbds44);
        this.mYOffset = l.g(this.mContext, R.dimen.tbds28);
        this.mMargin = l.g(this.mContext, R.dimen.tbds44);
        this.cRf = l.g(this.mContext, R.dimen.tbds14);
        this.mArrowHeight = l.g(this.mContext, R.dimen.tbds39);
        this.cRc = l.af(this.mContext) - (this.mXOffset * 2);
        this.cRe = l.g(this.mContext, R.dimen.tbds160);
        this.cRk = new b(this.mPageContext);
        this.cRk.a(this.cQP);
        this.mPageContext.registerListener(this.cRp);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.cRp != null) {
                this.cRp.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.cRp);
        }
    }

    public void bm(View view) {
        if (this.mContext != null && this.cQM != null && this.cQM.size() != 0) {
            this.cRm = (NEGFeedBackView) view;
            this.cRm.setCWRotateAnimation();
            View contentView = getContentView();
            this.cRc = l.af(this.mContext) - (this.mXOffset * 2);
            this.mWindowHeight = getWindowMeasuredHeight();
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.cRc, this.cRe, this.mYOffset, iArr);
            this.aOK = new PopupWindow(contentView, this.cRc, getWindowMeasuredHeight());
            this.aOK.setFocusable(true);
            this.aOK.setTouchable(true);
            this.aOK.setOnDismissListener(this.cRo);
            aAd();
            this.cRh = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.cRh.setAttachedInDecor(false);
            }
            this.cRh.showAtLocation(this.mAnchor, 0, 0, 0);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.aOK.setAnimationStyle(R.style.scale_rb2lt_anim);
                    al.a(this.aOK, (int) R.drawable.bg_tost_feedback_down);
                } else {
                    this.aOK.setAnimationStyle(R.style.scale_rt2lb_anim);
                    al.a(this.aOK, (int) R.drawable.bg_tost_feedback_up);
                }
                this.aOK.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.cRg != null) {
                    this.cRg.b(this.cRa);
                }
                this.cRl = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_feedback_popupwindow, (ViewGroup) null);
            this.cRi = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.cRj = (TextView) this.mContentView.findViewById(R.id.uninterested_text);
            this.cRj.setOnClickListener(this.cRn);
            this.mContentView.setPadding(this.cRf, this.mMargin, this.cRf, this.cRf + this.mArrowHeight);
        }
        ajG();
        View view = this.cRk.getView();
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
        this.cRd = this.mContentView.getMeasuredHeight() + this.mArrowHeight;
        return this.cRd;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int ah = l.ah(context);
        int af = l.af(context);
        boolean z = ((ah - iArr2[1]) - height) - i3 < i;
        iArr[0] = af - i2;
        if (z) {
            this.mContentView.setPadding(this.cRf, this.mMargin, this.cRf, this.cRf + this.mArrowHeight);
            iArr[1] = (iArr2[1] - i) + i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        this.mContentView.setPadding(this.cRf, this.mMargin + this.mArrowHeight, this.cRf, this.cRf);
        iArr[1] = (iArr2[1] + height) - i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject H(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.cRa == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        if (!v.aa(this.cRb)) {
            for (b.a aVar : this.cRb) {
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
            jSONObject.put("tid", this.cRa.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put("fid", this.cRa.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.cRa.getType())) {
                jSONObject.put("type", this.cRa.getType());
            }
            if (this.cRa.ach() != 0) {
                jSONObject.put("topic_id", this.cRa.ach());
            }
            jSONObject.put("extra", sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aAb() {
        if (v.aa(this.cRb)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (b.a aVar : this.cRb) {
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
    public void aAc() {
        int size = this.cRb.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(R.string.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(al.getColor(R.color.cp_link_tip_a)));
            if (this.cRi != null) {
                this.cRi.setText(spannableString);
            }
            if (this.cRj != null) {
                this.cRj.setText(this.mContext.getResources().getString(R.string.confirm));
                return;
            }
            return;
        }
        if (this.cRi != null) {
            this.cRi.setText(this.mContext.getResources().getString(R.string.tell_us_reason));
        }
        if (this.cRj != null) {
            this.cRj.setText(this.mContext.getResources().getString(R.string.not_interested));
        }
    }

    public void setData(aj ajVar) {
        if (ajVar != null) {
            this.cRa = ajVar;
            this.cQM = ajVar.ace();
            if (this.cQM != null && this.cQM.size() > 9) {
                for (int size = this.cQM.size() - 1; size >= 9; size--) {
                    this.cQM.removeAt(size);
                }
            }
            this.cRk.setData(ajVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.cRk.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.cRg = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.cRk.setDefaultReasonArray(strArr);
    }

    public void azZ() {
        if (this.aOK != null) {
            this.aOK.dismiss();
            this.aOK = null;
        }
        if (this.cRh != null) {
            this.cRh.dismiss();
            this.cRh = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.cRp);
        azZ();
    }

    private void aAd() {
        if (this.cRl && this.cRb.size() != 0) {
            this.cRb.clear();
            aAc();
        }
    }

    private void ajG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.f(this.cRi, R.color.cp_cont_b, 1);
            al.f(this.cRj, R.color.cp_btn_a, 1);
            al.k(this.cRj, R.drawable.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
