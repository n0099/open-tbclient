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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private int bgW;
    private int bgX;
    private int bgY;
    private PopupWindow bha;
    private TextView bhb;
    private TextView bhc;
    private b bhd;
    private boolean bhe;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow bgT = null;
    private ai bgU = null;
    private SparseArray<String> bgJ = null;
    private List<b.a> bgV = new ArrayList();
    private NEGFeedBackView.a bgZ = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bgM = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.bgZ != null) {
                c.this.bgZ.a(c.this.bgU, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.bgV.contains(aVar)) {
                        c.this.bgV.add(aVar);
                    }
                } else {
                    c.this.bgV.remove(aVar);
                }
            }
            c.this.OV();
        }
    };
    private View.OnClickListener bhf = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bgU != null && c.this.bgT != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject x = c.this.x(arrayList);
                if (!StringUtils.isNull(c.this.bgU.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, x);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, x);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.OU();
                com.baidu.tbadk.core.view.c cVar = new com.baidu.tbadk.core.view.c();
                cVar.auA = 1500L;
                cVar.j(c.this.mContext.getResources().getString(d.k.reduce_related_thread_recommend));
                if (c.this.bgZ != null) {
                    c.this.bgZ.a(arrayList, c.this.bgU);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener bhg = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.bha != null) {
                c.this.bha.dismiss();
                c.this.bha = null;
            }
        }
    };
    private CustomMessageListener bhh = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.OU();
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
        this.mXOffset = l.e(this.mContext, d.e.tbds32);
        this.mYOffset = l.e(this.mContext, d.e.ds6);
        this.bgW = l.ah(this.mContext) - (this.mXOffset * 2);
        this.bgY = l.e(this.mContext, d.e.ds120);
        this.bhd = new b(this.mPageContext);
        this.bhd.a(this.bgM);
        this.mPageContext.registerListener(this.bhh);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.bhh != null) {
                this.bhh.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.bhh);
        }
    }

    public void OT() {
        if (this.mContext != null && this.bgJ != null && this.bgJ.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bgT = new PopupWindow(contentView, this.bgW, this.mWindowHeight);
            this.bgT.setFocusable(true);
            this.bgT.setTouchable(true);
            this.bgT.setOnDismissListener(this.bhg);
            OW();
            this.bha = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bha.setAttachedInDecor(false);
            }
            this.bha.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.bgW, this.bgY, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bgT.setAnimationStyle(d.l.scale_rb2lt_anim);
                    al.a(this.bgT, d.f.bg_home_feedback_under);
                } else {
                    this.bgT.setAnimationStyle(d.l.scale_rt2lb_anim);
                    al.a(this.bgT, d.f.bg_home_feedback_top);
                }
                this.bgT.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.bgZ != null) {
                    this.bgZ.a(this.bgU);
                }
                this.bhe = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.neg_feedback_popupwindow, (ViewGroup) null);
            this.bhb = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.bhc = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.bhc.setOnClickListener(this.bhf);
        }
        Ay();
        View view = this.bhd.getView();
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
        this.bgX = this.mContentView.getMeasuredHeight() + l.e(this.mContext, d.e.ds12);
        return this.bgX;
    }

    private boolean a(Context context, View view, int i, int i2, int i3, int i4, int[] iArr) {
        if (context == null || view == null || iArr == null || iArr.length != 2) {
            return false;
        }
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int aj = l.aj(context);
        int ah = l.ah(context);
        boolean z = ((aj - iArr2[1]) - height) - i3 < i;
        iArr[0] = ah - i2;
        if (z) {
            iArr[1] = (iArr2[1] - i) - i4;
            iArr[1] = Math.max(UtilHelper.getStatusBarHeight(), iArr[1]);
            return z;
        }
        iArr[1] = iArr2[1] + height + i4;
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(9:4|(8:6|(2:7|(3:9|(2:11|(2:13|14)(1:16))(1:17)|15)(0))|19|(1:21)|22|(1:24)|26|27)(0)|18|19|(0)|22|(0)|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x009d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009e, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062 A[Catch: Exception -> 0x009d, TryCatch #0 {Exception -> 0x009d, blocks: (B:18:0x0050, B:20:0x0062, B:21:0x006c, B:23:0x008e), top: B:27:0x0050 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[Catch: Exception -> 0x009d, TRY_LEAVE, TryCatch #0 {Exception -> 0x009d, blocks: (B:18:0x0050, B:20:0x0062, B:21:0x006c, B:23:0x008e), top: B:27:0x0050 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject x(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.bgU == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.z(this.bgV)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bgV.size()) {
                    b.a aVar = this.bgV.get(i2);
                    if (aVar != null) {
                        arrayList.add(Integer.valueOf(aVar.id));
                        if (sb.length() != 0) {
                            sb.append(",");
                        }
                    }
                    sb.append(String.valueOf(aVar.id));
                    i = i2 + 1;
                }
            }
            jSONObject.put("tid", this.bgU.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bgU.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bgU.getType())) {
                jSONObject.put("type", this.bgU.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bgU.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bgU.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bgU.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OV() {
        int size = this.bgV.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.k.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(al.getColor(d.C0141d.cp_link_tip_a)));
            this.bhb.setText(spannableString);
            this.bhc.setText(this.mContext.getResources().getString(d.k.confirm));
            return;
        }
        this.bhb.setText(this.mContext.getResources().getString(d.k.tell_us_reason));
        this.bhc.setText(this.mContext.getResources().getString(d.k.not_interested));
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bgU = aiVar;
            this.bgJ = aiVar.up();
            if (this.bgJ != null && this.bgJ.size() > 9) {
                for (int size = this.bgJ.size() - 1; size >= 9; size--) {
                    this.bgJ.removeAt(size);
                }
            }
            this.bhd.setData(aiVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.bhd.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bgZ = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.bhd.setDefaultReasonArray(strArr);
    }

    public void OU() {
        if (this.bgT != null) {
            this.bgT.dismiss();
            this.bgT = null;
        }
        if (this.bha != null) {
            this.bha.dismiss();
            this.bha = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.bhh);
        OU();
    }

    private void OW() {
        if (this.bhe && this.bgV.size() != 0) {
            this.bgV.clear();
            OV();
        }
    }

    private void Ay() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            al.c(this.bhb, d.C0141d.cp_cont_j, 1);
            al.c(this.bhc, d.C0141d.cp_cont_i, 1);
            al.i(this.bhc, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
