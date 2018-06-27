package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.os.Build;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {
    private View aIx;
    private LinearLayout biD;
    private a biE;
    private b biF;
    private TextView biG;
    private TextView biH;
    private TextView biI;
    private TextView biJ;
    private View biK;
    private int bio;
    private int bip;
    private PopupWindow bis;
    private com.baidu.tieba.NEGFeedBack.b biv;
    private boolean biw;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private int mWindowHeight;
    private int mXOffset;
    private PopupWindow bil = null;
    private ai bim = null;
    private SparseArray<String> bhW = null;
    private List<b.a> bin = new ArrayList();
    private NEGFeedBackView.a bir = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a aVW = null;
    private CompoundButton.OnCheckedChangeListener bhZ = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.e.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (e.this.bir != null) {
                e.this.bir.a(e.this.bim, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!e.this.bin.contains(aVar)) {
                        e.this.bin.add(aVar);
                        return;
                    }
                    return;
                }
                e.this.bin.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener biy = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.e.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (e.this.bis != null) {
                e.this.bis.dismiss();
                e.this.bis = null;
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void f(JSONArray jSONArray);
    }

    public e(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.e(this.mContext, d.e.tbds32);
        this.bio = l.ah(this.mContext) - (this.mXOffset * 2);
        this.biv = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.biv.a(this.bhZ);
        this.biv.cr(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.bip = this.mContentView.getMeasuredHeight() + l.e(this.mContext, d.e.ds12);
        return this.bip;
    }

    public void setData(ai aiVar) {
        if (aiVar != null) {
            this.bim = aiVar;
            this.bhW = aiVar.uv();
            if (this.bhW != null && this.bhW.size() > 8) {
                for (int size = this.bhW.size() - 1; size >= 8; size--) {
                    this.bhW.removeAt(size);
                }
            }
            this.biv.setData(aiVar);
        }
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

    private void Pr() {
        if (this.biw && this.bin.size() != 0) {
            this.bin.clear();
        }
    }

    private void AP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            am.c(this.biH, d.C0142d.cp_cont_f, 1);
            am.c(this.biG, d.C0142d.cp_cont_f, 1);
            am.j(this.aIx, d.C0142d.cp_bg_line_b);
            am.j(this.biK, d.C0142d.cp_bg_line_b);
            am.c(this.biI, d.C0142d.cp_cont_f, 1);
            am.c(this.biJ, d.C0142d.cp_cont_d, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(d.i.neg_dt_head_popupwindow, (ViewGroup) null);
            this.biI = (TextView) this.mContentView.findViewById(d.g.head_text);
            this.biJ = (TextView) this.mContentView.findViewById(d.g.sub_head_text);
        }
        View rootView = this.biv.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int e = l.e(this.mContext, d.e.ds40);
            rootView.setPadding(e, 0, e, 0);
            this.mContentView.addView(rootView);
        }
        if (this.biD == null) {
            this.biD = (LinearLayout) LayoutInflater.from(this.mContext).inflate(d.i.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.biH = (TextView) this.biD.findViewById(d.g.dialog_bottom_cancel_button);
            this.biG = (TextView) this.biD.findViewById(d.g.dialog_bottom_certain_button);
            this.aIx = this.biD.findViewById(d.g.top_line);
            this.biK = this.biD.findViewById(d.g.middle_line);
            this.mContentView.addView(this.biD);
            this.biH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (e.this.bis != null) {
                        e.this.bis.dismiss();
                        e.this.bis = null;
                    }
                    if (e.this.bil != null) {
                        e.this.bil.dismiss();
                        e.this.bil = null;
                    }
                    if (e.this.biE != null) {
                        e.this.biE.onClick();
                    }
                }
            });
            if (this.biG != null) {
                this.biG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.e.4
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject Pt = e.this.Pt();
                        if (e.this.mFrom == "3" || e.this.mFrom == "4" || e.this.mFrom == "1") {
                            e.this.Pp();
                        } else if (Pt != null) {
                            e.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, e.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, Pt);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            AP();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.biF = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.aVW == null) {
            this.aVW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.aVW.dd(d.k.loading);
        this.aVW.aO(true);
    }

    public void Ps() {
        if (this.aVW != null) {
            this.aVW.aO(false);
        }
    }

    public void ib(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            AP();
            this.mWindowHeight = getWindowMeasuredHeight() - l.e(this.mContext, d.e.ds12);
            this.bil = new PopupWindow(view, this.bio, this.mWindowHeight);
            this.bil.setFocusable(true);
            this.bil.setTouchable(true);
            this.bil.setOnDismissListener(this.biy);
            Pr();
            this.bis = new PopupWindow(LayoutInflater.from(this.mContext).inflate(d.i.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.bis.setAttachedInDecor(false);
            }
            this.bis.showAtLocation(this.mAnchor, 0, 0, 0);
            am.a(this.bil, d.f.bg_dailog);
            this.bil.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.bir != null) {
                this.bir.a(this.bim);
            }
            this.biw = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject Pt() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.bim == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (w.A(this.bin)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.bin.size(); i2++) {
                b.a aVar = this.bin.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new an("c13123").ah(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.mFrom).r("obj_type", i));
        if (this.biF != null) {
            this.biF.f(jSONArray);
        }
        try {
            jSONObject.put("reason", jSONArray);
            jSONObject.put("thread_ids", this.bim.ux());
            jSONObject.put("type", this.bim.uw());
            jSONObject.put("forum_id", this.bim.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
