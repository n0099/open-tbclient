package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRuleEditActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
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
/* loaded from: classes21.dex */
public class i {
    private PopupWindow fWD;
    private com.baidu.tieba.NEGFeedBack.b fWH;
    private boolean fWI;
    private int fWy;
    private EMTextView fXi;
    private EMTextView fXj;
    private EMTextView fXk;
    private EMTextView fXl;
    private EMTextView fXm;
    private LinearLayout fXn;
    private a fXo;
    private b fXp;
    private h fXq;
    private int fXt;
    private ClickableSpan fXu;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private at fWw = null;
    private SparseArray<String> fWh = null;
    private List<b.a> fWx = new ArrayList();
    private NEGFeedBackView.a fWC = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fEW = null;
    private int mSkinType = 3;
    private boolean fXr = true;
    private boolean fXs = false;
    private CompoundButton.OnCheckedChangeListener fWl = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.fWC != null) {
                i.this.fWC.onCheckedChanged(i.this.fWw, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.fWx.contains(aVar)) {
                        i.this.fWx.add(aVar);
                        if (i.this.fXr && i.this.fXj != null) {
                            i.this.fXj.setClickable(true);
                            ap.k(i.this.fXj, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.fWx.remove(aVar);
                if (i.this.fXr && i.this.fXj != null) {
                    i.this.fXj.setClickable(false);
                    ap.k(i.this.fXj, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener fWO = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.fWD != null) {
                i.this.fWD.dismiss();
                i.this.fWD = null;
                MessageManager.getInstance().unRegisterListener(i.this.eOd);
            }
        }
    };
    private CustomMessageListener eOd = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.bvt();
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes21.dex */
    public interface b {
        void X(JSONArray jSONArray);
    }

    public i(TbPageContext tbPageContext, View view, h hVar, UserData userData) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        this.fXq = hVar;
        this.mUserData = userData;
        bLD();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fWH = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fWH.a(this.fWl);
        this.fWH.lz(true);
        if (this.fXs) {
            this.fWH.uh(5);
        }
    }

    private void bLD() {
        if (this.fXq != null) {
            if (this.fXq.bLz() == 1) {
                this.fXr = false;
            } else {
                this.fXr = true;
            }
            if (this.fXq.bLy() == 1) {
                this.fXs = false;
            } else {
                this.fXs = true;
            }
        }
        if (this.fXs && this.mUserData != null) {
            this.fXt = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fWy = this.mContentView.getMeasuredHeight();
        return this.fWy;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.fWw = atVar;
            this.fWh = atVar.getFeedBackReasonMap();
            if (this.fWh != null && this.fWh.size() > 8) {
                for (int size = this.fWh.size() - 1; size >= 8; size--) {
                    this.fWh.removeAt(size);
                }
            }
            this.fWH.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWH.setDefaultReasonArray(strArr);
    }

    public void bLq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWD != null) {
            this.fWD.dismiss();
            this.fWD = null;
        }
    }

    private void UW() {
        if (this.fWI && this.fWx.size() != 0) {
            this.fWx.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fXk, R.color.CAM_X0105, 1);
            ap.k(this.fXi, R.color.CAM_X0105);
            if (this.fXr) {
                ap.k(this.fXj, R.color.CAM_X0108);
                this.fXj.setClickable(false);
            } else {
                ap.k(this.fXj, R.color.CAM_X0302);
            }
            ap.setViewTextColor(this.fXl, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.fXm, R.color.CAM_X0105, 1);
            this.fXm.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0205));
            gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
            this.mContentView.setBackgroundDrawable(gradientDrawable);
            this.mSkinType = skinType;
        }
    }

    private View getView() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mContentView == null) {
            this.mContentView = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ueg_new_delete_thread_view, (ViewGroup) null);
            this.fXk = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fXk).pu(R.string.F_X02).ps(R.color.CAM_X0105);
            this.fXl = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fXl).pt(R.dimen.T_X08);
            this.fXi = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.fXi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.fWD != null) {
                        i.this.fWD.dismiss();
                        i.this.fWD = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.fXo != null) {
                        i.this.fXo.onClick();
                    }
                }
            });
            this.fXj = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.fXj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bLv = i.this.bLv();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bLq();
                    } else if (bLv != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bLv);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.fXn = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.fWH.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.fXn.addView(rootView);
        }
        this.fXm = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.fXm.setHighlightColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(17170445));
        if (this.fXs) {
            this.fXm.setVisibility(0);
            if (1 == this.fXt) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.fXu = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.fXq.getForumId(), i.this.fXq.getForumName(), i.this.fXq.bLB(), i.this.fXq.bLC(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.fWD != null) {
                            i.this.fWD.dismiss();
                            i.this.fWD = null;
                        }
                        if (i.this.mPopupWindow != null) {
                            i.this.mPopupWindow.dismiss();
                            i.this.mPopupWindow = null;
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(ap.getColor(R.color.CAM_X0304));
                        textPaint.setUnderlineText(false);
                    }
                };
                spannableStringBuilder.setSpan(this.fXu, 13, 17, 18);
                this.fXm.setText(spannableStringBuilder);
                this.fXm.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.fXm.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.fXm.setVisibility(8);
        }
        this.fXm.setClickable(false);
        this.fXm.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
        bvt();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fXp = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fEW == null) {
            this.fEW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fEW.setTipString(R.string.loading);
        this.fEW.setDialogVisiable(true);
    }

    public void Fj(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (view != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ap.getColor(R.color.CAM_X0205));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                view.setBackgroundDrawable(gradientDrawable);
                bvt();
                this.mWindowHeight = getWindowMeasuredHeight();
                this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.fWO);
                UW();
                this.fWD = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fWD.setAttachedInDecor(false);
                }
                this.fWD.showAtLocation(this.mAnchor, 0, 0, 0);
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.fWC != null) {
                    this.fWC.onNEGFeedbackWindowShow(this.fWw);
                }
                this.fWI = true;
                MessageManager.getInstance().registerListener(this.eOd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bLv() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fWw == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fWx)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fWx.size(); i2++) {
                b.a aVar = this.fWx.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dY("obj_source", this.mFrom).al("obj_type", i));
        if (this.fXp != null) {
            this.fXp.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fWw.bnn());
            jSONObject.put("type", this.fWw.bnm());
            jSONObject.put("forum_id", this.fWw.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
