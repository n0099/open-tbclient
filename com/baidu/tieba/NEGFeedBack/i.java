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
    private PopupWindow fWB;
    private com.baidu.tieba.NEGFeedBack.b fWF;
    private boolean fWG;
    private int fWw;
    private EMTextView fXg;
    private EMTextView fXh;
    private EMTextView fXi;
    private EMTextView fXj;
    private EMTextView fXk;
    private LinearLayout fXl;
    private a fXm;
    private b fXn;
    private h fXo;
    private int fXr;
    private ClickableSpan fXs;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private at fWu = null;
    private SparseArray<String> fWf = null;
    private List<b.a> fWv = new ArrayList();
    private NEGFeedBackView.a fWA = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fEW = null;
    private int mSkinType = 3;
    private boolean fXp = true;
    private boolean fXq = false;
    private CompoundButton.OnCheckedChangeListener fWj = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.fWA != null) {
                i.this.fWA.onCheckedChanged(i.this.fWu, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.fWv.contains(aVar)) {
                        i.this.fWv.add(aVar);
                        if (i.this.fXp && i.this.fXh != null) {
                            i.this.fXh.setClickable(true);
                            ap.k(i.this.fXh, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.fWv.remove(aVar);
                if (i.this.fXp && i.this.fXh != null) {
                    i.this.fXh.setClickable(false);
                    ap.k(i.this.fXh, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener fWM = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.fWB != null) {
                i.this.fWB.dismiss();
                i.this.fWB = null;
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
        this.fXo = hVar;
        this.mUserData = userData;
        bLC();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.fWF = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.fWF.a(this.fWj);
        this.fWF.lz(true);
        if (this.fXq) {
            this.fWF.uh(5);
        }
    }

    private void bLC() {
        if (this.fXo != null) {
            if (this.fXo.bLy() == 1) {
                this.fXp = false;
            } else {
                this.fXp = true;
            }
            if (this.fXo.bLx() == 1) {
                this.fXq = false;
            } else {
                this.fXq = true;
            }
        }
        if (this.fXq && this.mUserData != null) {
            this.fXr = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.fWw = this.mContentView.getMeasuredHeight();
        return this.fWw;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.fWu = atVar;
            this.fWf = atVar.getFeedBackReasonMap();
            if (this.fWf != null && this.fWf.size() > 8) {
                for (int size = this.fWf.size() - 1; size >= 8; size--) {
                    this.fWf.removeAt(size);
                }
            }
            this.fWF.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.fWF.setDefaultReasonArray(strArr);
    }

    public void bLp() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.fWB != null) {
            this.fWB.dismiss();
            this.fWB = null;
        }
    }

    private void UW() {
        if (this.fWG && this.fWv.size() != 0) {
            this.fWv.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bvt() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.fXi, R.color.CAM_X0105, 1);
            ap.k(this.fXg, R.color.CAM_X0105);
            if (this.fXp) {
                ap.k(this.fXh, R.color.CAM_X0108);
                this.fXh.setClickable(false);
            } else {
                ap.k(this.fXh, R.color.CAM_X0302);
            }
            ap.setViewTextColor(this.fXj, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.fXk, R.color.CAM_X0105, 1);
            this.fXk.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
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
            this.fXi = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fXi).pu(R.string.F_X02).ps(R.color.CAM_X0105);
            this.fXj = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.fXj).pt(R.dimen.T_X08);
            this.fXg = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.fXg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.fWB != null) {
                        i.this.fWB.dismiss();
                        i.this.fWB = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.fXm != null) {
                        i.this.fXm.onClick();
                    }
                }
            });
            this.fXh = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.fXh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bLu = i.this.bLu();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bLp();
                    } else if (bLu != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bLu);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.fXl = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.fWF.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.fXl.addView(rootView);
        }
        this.fXk = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.fXk.setHighlightColor(com.baidu.tbadk.core.util.e.c.a.getResources().getColor(17170445));
        if (this.fXq) {
            this.fXk.setVisibility(0);
            if (1 == this.fXr) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.fXs = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.fXo.getForumId(), i.this.fXo.getForumName(), i.this.fXo.bLA(), i.this.fXo.bLB(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.fWB != null) {
                            i.this.fWB.dismiss();
                            i.this.fWB = null;
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
                spannableStringBuilder.setSpan(this.fXs, 13, 17, 18);
                this.fXk.setText(spannableStringBuilder);
                this.fXk.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.fXk.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.fXk.setVisibility(8);
        }
        this.fXk.setClickable(false);
        this.fXk.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
        bvt();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.fXn = bVar;
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
                this.mPopupWindow.setOnDismissListener(this.fWM);
                UW();
                this.fWB = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.fWB.setAttachedInDecor(false);
                }
                this.fWB.showAtLocation(this.mAnchor, 0, 0, 0);
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.fWA != null) {
                    this.fWA.onNEGFeedbackWindowShow(this.fWu);
                }
                this.fWG = true;
                MessageManager.getInstance().registerListener(this.eOd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bLu() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.fWu == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.fWv)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.fWv.size(); i2++) {
                b.a aVar = this.fWv.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dY("obj_source", this.mFrom).al("obj_type", i));
        if (this.fXn != null) {
            this.fXn.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.fWu.bnn());
            jSONObject.put("type", this.fWu.bnm());
            jSONObject.put("forum_id", this.fWu.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
