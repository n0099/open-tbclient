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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.av;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private TextView bUN;
    private com.baidu.tieba.NEGFeedBack.b gfC;
    private boolean gfD;
    private LinearLayout gfQ;
    private a gfR;
    private b gfS;
    private TextView gfT;
    private TextView gfU;
    private TextView gfV;
    private View gfW;
    private int gft;
    private PopupWindow gfy;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private View mTopLine;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private PopupWindow mPopupWindow = null;
    private av gfr = null;
    private SparseArray<String> gfc = null;
    private List<b.a> gfs = new ArrayList();
    private NEGFeedBackView.a gfx = null;
    private int mSkinType = 3;
    private com.baidu.tbadk.core.view.a fNE = null;
    private CompoundButton.OnCheckedChangeListener gfg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.f.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (f.this.gfx != null) {
                f.this.gfx.onCheckedChanged(f.this.gfr, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!f.this.gfs.contains(aVar)) {
                        f.this.gfs.add(aVar);
                        return;
                    }
                    return;
                }
                f.this.gfs.remove(aVar);
            }
        }
    };
    private PopupWindow.OnDismissListener gfJ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.f.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (f.this.gfy != null) {
                f.this.gfy.dismiss();
                f.this.gfy = null;
                MessageManager.getInstance().unRegisterListener(f.this.eXe);
            }
        }
    };
    private CustomMessageListener eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.f.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                f.this.bus();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface b {
        void W(JSONArray jSONArray);
    }

    public f(TbPageContext tbPageContext, View view) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.tbds32);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gfC = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gfC.a(this.gfg);
        this.gfC.lW(true);
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gft = this.mContentView.getMeasuredHeight() + l.getDimens(this.mContext, R.dimen.ds12);
        return this.gft;
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gfr = avVar;
            this.gfc = avVar.getFeedBackReasonMap();
            if (this.gfc != null && this.gfc.size() > 8) {
                for (int size = this.gfc.size() - 1; size >= 8; size--) {
                    this.gfc.removeAt(size);
                }
            }
            this.gfC.setData(avVar);
        }
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

    private void TS() {
        if (this.gfD && this.gfs.size() != 0) {
            this.gfs.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bus() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setBackgroundColor(this.mContentView, R.color.CAM_X0205);
            ap.setViewTextColor(this.bUN, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.gfT, R.color.CAM_X0106, 1);
            ap.setBackgroundColor(this.mTopLine, R.color.CAM_X0204);
            ap.setBackgroundColor(this.gfW, R.color.CAM_X0204);
            ap.setViewTextColor(this.gfU, R.color.CAM_X0106, 1);
            ap.setViewTextColor(this.gfV, R.color.CAM_X0109, 1);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_head_popupwindow, (ViewGroup) null);
            this.gfU = (TextView) this.mContentView.findViewById(R.id.head_text);
            this.gfV = (TextView) this.mContentView.findViewById(R.id.sub_head_text);
        }
        View rootView = this.gfC.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.ds40);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.mContentView.addView(rootView);
        }
        if (this.gfQ == null) {
            this.gfQ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.neg_dt_bottom_popupwindow, (ViewGroup) null);
            this.bUN = (TextView) this.gfQ.findViewById(R.id.dialog_bottom_cancel_button);
            this.gfT = (TextView) this.gfQ.findViewById(R.id.dialog_bottom_certain_button);
            this.mTopLine = this.gfQ.findViewById(R.id.top_line);
            this.gfW = this.gfQ.findViewById(R.id.middle_line);
            this.mContentView.addView(this.gfQ);
            this.bUN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (f.this.gfy != null) {
                        f.this.gfy.dismiss();
                        f.this.gfy = null;
                    }
                    if (f.this.mPopupWindow != null) {
                        f.this.mPopupWindow.dismiss();
                        f.this.mPopupWindow = null;
                    }
                    if (f.this.gfR != null) {
                        f.this.gfR.onClick();
                    }
                }
            });
            if (this.gfT != null) {
                this.gfT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.f.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        JSONObject bKz = f.this.bKz();
                        if (f.this.mFrom == "3" || f.this.mFrom == "4" || f.this.mFrom == "1") {
                            f.this.bKu();
                        } else if (bKz != null) {
                            f.this.showLoadingView();
                            CustomMessage customMessage = new CustomMessage(2016489, f.this.mPageContext.getUniqueId());
                            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bKz);
                            customResponsedMessage.setOrginalMessage(customMessage);
                            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                        }
                    }
                });
            }
            bus();
        }
        return this.mContentView;
    }

    public void a(b bVar) {
        this.gfS = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fNE == null) {
            this.fNE = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fNE.setTipString(R.string.loading);
        this.fNE.setDialogVisiable(true);
    }

    public void bKy() {
        if (this.fNE != null) {
            this.fNE.setDialogVisiable(false);
        }
    }

    public void Ey(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            bus();
            this.mWindowHeight = getWindowMeasuredHeight() - l.getDimens(this.mContext, R.dimen.ds12);
            this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
            this.mPopupWindow.setFocusable(true);
            this.mPopupWindow.setTouchable(true);
            this.mPopupWindow.setOnDismissListener(this.gfJ);
            TS();
            this.gfy = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
            if (Build.VERSION.SDK_INT >= 22) {
                this.gfy.setAttachedInDecor(false);
            }
            this.gfy.showAtLocation(this.mAnchor, 0, 0, 0);
            ap.setBackgroundDrawable(this.mPopupWindow, R.drawable.bg_dailog);
            this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
            if (this.gfx != null) {
                this.gfx.onNEGFeedbackWindowShow(this.gfr);
            }
            this.gfD = true;
            this.mPageContext.registerListener(this.eXe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKz() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.gfr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.gfs)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.gfs.size(); i2++) {
                b.a aVar = this.gfs.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dR("obj_source", this.mFrom).aq("obj_type", i));
        if (this.gfS != null) {
            this.gfS.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.gfr.bmo());
            jSONObject.put("type", this.gfr.bmn());
            jSONObject.put("forum_id", this.gfr.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
