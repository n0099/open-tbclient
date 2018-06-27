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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {
    private int bio;
    private int bip;
    private int biq;
    private PopupWindow bis;
    private TextView bit;
    private TextView biu;
    private b biv;
    private boolean biw;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private int mYOffset;
    private PopupWindow bil = null;
    private ai bim = null;
    private SparseArray<String> bhW = null;
    private List<b.a> bin = new ArrayList();
    private NEGFeedBackView.a bir = null;
    private int mSkinType = 3;
    private CompoundButton.OnCheckedChangeListener bhZ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (c.this.bir != null) {
                c.this.bir.a(c.this.bim, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!c.this.bin.contains(aVar)) {
                        c.this.bin.add(aVar);
                    }
                } else {
                    c.this.bin.remove(aVar);
                }
            }
            c.this.Pq();
        }
    };
    private View.OnClickListener bix = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bim != null && c.this.bil != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                JSONObject B = c.this.B(arrayList);
                if (!StringUtils.isNull(c.this.bim.getType())) {
                    CustomMessage customMessage = new CustomMessage(2921324, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921324, B);
                    customResponsedMessage.setOrginalMessage(customMessage);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                } else {
                    CustomMessage customMessage2 = new CustomMessage(2016488, c.this.mPageContext.getUniqueId());
                    CustomResponsedMessage customResponsedMessage2 = new CustomResponsedMessage(2016488, B);
                    customResponsedMessage2.setOrginalMessage(customMessage2);
                    MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage2);
                }
                c.this.Pp();
                com.baidu.tbadk.core.view.d dVar = new com.baidu.tbadk.core.view.d();
                dVar.avm = 1500L;
                dVar.j(c.this.mContext.getResources().getString(d.k.reduce_related_thread_recommend));
                if (c.this.bir != null) {
                    c.this.bir.a(arrayList, c.this.bim);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener biy = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.c.3
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (c.this.bis != null) {
                c.this.bis.dismiss();
                c.this.bis = null;
            }
        }
    };
    private CustomMessageListener biz = new CustomMessageListener(2016524) { // from class: com.baidu.tieba.NEGFeedBack.c.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            c.this.Pp();
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
        this.bio = l.ah(this.mContext) - (this.mXOffset * 2);
        this.biq = l.e(this.mContext, d.e.ds120);
        this.biv = new b(this.mPageContext);
        this.biv.a(this.bhZ);
        this.mPageContext.registerListener(this.biz);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            if (this.biz != null) {
                this.biz.setTag(bdUniqueId);
            }
            MessageManager.getInstance().registerListener(this.biz);
        }
    }

    public void Po() {
        if (this.mContext != null && this.bhW != null && this.bhW.size() != 0) {
            View contentView = getContentView();
            this.mWindowHeight = getWindowMeasuredHeight();
            this.bil = new PopupWindow(contentView, this.bio, this.mWindowHeight);
            this.bil.setFocusable(true);
            this.bil.setTouchable(true);
            this.bil.setOnDismissListener(this.biy);
            Pr();
            this.bis = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bis.setAttachedInDecor(false);
            }
            this.bis.showAtLocation(this.mAnchor, 0, 0, 0);
            int[] iArr = new int[2];
            boolean a = a(this.mContext, this.mAnchor, this.mWindowHeight, this.bio, this.biq, this.mYOffset, iArr);
            if (iArr[0] != 0 || iArr[1] != 0) {
                if (a) {
                    this.bil.setAnimationStyle(d.l.scale_rb2lt_anim);
                    am.a(this.bil, d.f.bg_home_feedback_under);
                } else {
                    this.bil.setAnimationStyle(d.l.scale_rt2lb_anim);
                    am.a(this.bil, d.f.bg_home_feedback_top);
                }
                this.bil.showAtLocation(this.mAnchor, 0, iArr[0] - this.mXOffset, iArr[1]);
                if (this.bir != null) {
                    this.bir.a(this.bim);
                }
                this.biw = true;
            }
        }
    }

    private View getContentView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.neg_feedback_popupwindow, (ViewGroup) null);
            this.bit = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.biu = (TextView) this.mContentView.findViewById(d.g.uninterested_text);
            this.biu.setOnClickListener(this.bix);
            int e = l.e(this.mContext, d.e.ds40);
            this.mContentView.setPadding(e, 0, e, e);
        }
        AP();
        View view = this.biv.getView();
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
        this.bip = this.mContentView.getMeasuredHeight() + l.e(this.mContext, d.e.ds12);
        return this.bip;
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
    public JSONObject B(ArrayList<Integer> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (this.bim == null || arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (!w.A(this.bin)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.bin.size()) {
                    b.a aVar = this.bin.get(i2);
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
            jSONObject.put("tid", this.bim.getTid());
            if (sb.length() != 0) {
                jSONObject.put("dislike_ids", sb.toString());
            }
            jSONObject.put(ImageViewerConfig.FORUM_ID, this.bim.getFid());
            jSONObject.put("click_time", System.currentTimeMillis());
            if (!StringUtils.isNull(this.bim.getType())) {
                jSONObject.put("type", this.bim.getType());
            }
            return jSONObject;
        }
        jSONObject.put("tid", this.bim.getTid());
        if (sb.length() != 0) {
        }
        jSONObject.put(ImageViewerConfig.FORUM_ID, this.bim.getFid());
        jSONObject.put("click_time", System.currentTimeMillis());
        if (!StringUtils.isNull(this.bim.getType())) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pq() {
        int size = this.bin.size();
        if (size > 0) {
            String string = this.mContext.getResources().getString(d.k.feedback_selected_reason, Integer.valueOf(size));
            SpannableString spannableString = new SpannableString(string);
            UtilHelper.setSpan(spannableString, string, String.valueOf(size), new ForegroundColorSpan(am.getColor(d.C0142d.cp_link_tip_a)));
            if (this.bit != null) {
                this.bit.setText(spannableString);
            }
            if (this.biu != null) {
                this.biu.setText(this.mContext.getResources().getString(d.k.confirm));
                return;
            }
            return;
        }
        if (this.bit != null) {
            this.bit.setText(this.mContext.getResources().getString(d.k.tell_us_reason));
        }
        if (this.biu != null) {
            this.biu.setText(this.mContext.getResources().getString(d.k.not_interested));
        }
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bim = aiVar;
            this.bhW = aiVar.uv();
            if (this.bhW != null && this.bhW.size() > 9) {
                for (int size = this.bhW.size() - 1; size >= 9; size--) {
                    this.bhW.removeAt(size);
                }
            }
            this.biv.setData(aiVar);
        }
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.biv.setFirstRowSingleColumn(z);
    }

    public void setEventCallback(NEGFeedBackView.a aVar) {
        this.bir = aVar;
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.biv.setDefaultReasonArray(strArr);
    }

    public void Pp() {
        if (this.bil != null) {
            this.bil.dismiss();
            this.bil = null;
        }
        if (this.bis != null) {
            this.bis.dismiss();
            this.bis = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        MessageManager.getInstance().unRegisterListener(this.biz);
        Pp();
    }

    private void Pr() {
        if (this.biw && this.bin.size() != 0) {
            this.bin.clear();
            Pq();
        }
    }

    private void AP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.c(this.bit, d.C0142d.cp_cont_j, 1);
            am.c(this.biu, d.C0142d.cp_cont_i, 1);
            am.i(this.biu, d.f.bg_blue_rec_n);
            this.mSkinType = skinType;
        }
    }
}
