package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
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
import androidx.annotation.NonNull;
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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.NEGFeedBack.b;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i {
    private EMTextView ggO;
    private EMTextView ggP;
    private EMTextView ggQ;
    private EMTextView ggR;
    private EMTextView ggS;
    private LinearLayout ggT;
    private a ggU;
    private b ggV;
    private h ggW;
    private int ggZ;
    private int gge;
    private PopupWindow ggj;
    private com.baidu.tieba.NEGFeedBack.b ggn;
    private boolean ggo;
    private ClickableSpan gha;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private at ggc = null;
    private SparseArray<String> gfN = null;
    private List<b.a> ggd = new ArrayList();
    private NEGFeedBackView.a ggi = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fOA = null;
    private int mSkinType = 3;
    private boolean ggX = true;
    private boolean ggY = false;
    private CompoundButton.OnCheckedChangeListener gfR = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.ggi != null) {
                i.this.ggi.onCheckedChanged(i.this.ggc, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.ggd.contains(aVar)) {
                        i.this.ggd.add(aVar);
                        if (i.this.ggX && i.this.ggP != null) {
                            i.this.ggP.setClickable(true);
                            ao.n(i.this.ggP, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.ggd.remove(aVar);
                if (i.this.ggX && i.this.ggP != null) {
                    i.this.ggP.setClickable(false);
                    ao.n(i.this.ggP, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener ggu = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.ggj != null) {
                i.this.ggj.dismiss();
                i.this.ggj = null;
                MessageManager.getInstance().unRegisterListener(i.this.eYa);
            }
        }
    };
    private CustomMessageListener eYa = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.bxP();
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void onClick();
    }

    /* loaded from: classes.dex */
    public interface b {
        void X(JSONArray jSONArray);
    }

    public i(TbPageContext tbPageContext, View view, h hVar, UserData userData) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        this.ggW = hVar;
        this.mUserData = userData;
        bNW();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.ggn = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.ggn.a(this.gfR);
        this.ggn.lW(true);
        if (this.ggY) {
            this.ggn.ut(5);
        }
    }

    private void bNW() {
        if (this.ggW != null) {
            if (this.ggW.bNS() == 1) {
                this.ggX = false;
            } else {
                this.ggX = true;
            }
            if (this.ggW.bNR() == 1) {
                this.ggY = false;
            } else {
                this.ggY = true;
            }
        }
        if (this.ggY && this.mUserData != null) {
            this.ggZ = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gge = this.mContentView.getMeasuredHeight();
        return this.gge;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.ggc = atVar;
            this.gfN = atVar.getFeedBackReasonMap();
            if (this.gfN != null && this.gfN.size() > 8) {
                for (int size = this.gfN.size() - 1; size >= 8; size--) {
                    this.gfN.removeAt(size);
                }
            }
            this.ggn.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.ggn.setDefaultReasonArray(strArr);
    }

    public void bNJ() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.ggj != null) {
            this.ggj.dismiss();
            this.ggj = null;
        }
    }

    private void Wb() {
        if (this.ggo && this.ggd.size() != 0) {
            this.ggd.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxP() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setViewTextColor(this.ggQ, R.color.CAM_X0105, 1);
            ao.n(this.ggO, R.color.CAM_X0105);
            if (this.ggX) {
                ao.n(this.ggP, R.color.CAM_X0108);
                this.ggP.setClickable(false);
            } else {
                ao.n(this.ggP, R.color.CAM_X0302);
            }
            ao.setViewTextColor(this.ggR, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.ggS, R.color.CAM_X0105, 1);
            this.ggS.setBackgroundDrawable(ao.getDrawable(R.drawable.pic_popup_guide));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0205));
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
            this.ggQ = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.ggQ).pE(R.string.F_X02).pC(R.color.CAM_X0105);
            this.ggR = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.ggR).pD(R.dimen.T_X08);
            this.ggO = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.ggO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.ggj != null) {
                        i.this.ggj.dismiss();
                        i.this.ggj = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.ggU != null) {
                        i.this.ggU.onClick();
                    }
                }
            });
            this.ggP = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.ggP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bNO = i.this.bNO();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bNJ();
                    } else if (bNO != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bNO);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.ggT = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.ggn.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.ggT.addView(rootView);
        }
        this.ggS = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.ggS.setHighlightColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(17170445));
        if (this.ggY) {
            this.ggS.setVisibility(0);
            if (1 == this.ggZ) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.gha = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.ggW.getForumId(), i.this.ggW.getForumName(), i.this.ggW.bNU(), i.this.ggW.bNV(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.ggj != null) {
                            i.this.ggj.dismiss();
                            i.this.ggj = null;
                        }
                        if (i.this.mPopupWindow != null) {
                            i.this.mPopupWindow.dismiss();
                            i.this.mPopupWindow = null;
                        }
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(@NonNull TextPaint textPaint) {
                        super.updateDrawState(textPaint);
                        textPaint.setColor(ao.getColor(R.color.CAM_X0304));
                        textPaint.setUnderlineText(false);
                    }
                };
                spannableStringBuilder.setSpan(this.gha, 13, 17, 18);
                this.ggS.setText(spannableStringBuilder);
                this.ggS.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.ggS.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.ggS.setVisibility(8);
        }
        this.ggS.setClickable(false);
        this.ggS.setBackgroundDrawable(ao.getDrawable(R.drawable.pic_popup_guide));
        bxP();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.ggV = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fOA == null) {
            this.fOA = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fOA.setTipString(R.string.loading);
        this.fOA.setDialogVisiable(true);
    }

    public void Fg(String str) {
        if (this.mContext != null) {
            this.mFrom = str;
            View view = getView();
            if (view != null && view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (view != null) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setColor(ao.getColor(R.color.CAM_X0205));
                gradientDrawable.setCornerRadius(l.getDimens(this.mContext, R.dimen.tbds31));
                view.setBackgroundDrawable(gradientDrawable);
                bxP();
                this.mWindowHeight = getWindowMeasuredHeight();
                this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.ggu);
                Wb();
                this.ggj = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.ggj.setAttachedInDecor(false);
                }
                this.ggj.showAtLocation(this.mAnchor, 0, 0, 0);
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.ggi != null) {
                    this.ggi.onNEGFeedbackWindowShow(this.ggc);
                }
                this.ggo = true;
                MessageManager.getInstance().registerListener(this.eYa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bNO() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.ggc == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (x.isEmpty(this.ggd)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.ggd.size(); i2++) {
                b.a aVar = this.ggd.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dX("obj_source", this.mFrom).an("obj_type", i));
        if (this.ggV != null) {
            this.ggV.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.ggc.bpN());
            jSONObject.put("type", this.ggc.bpM());
            jSONObject.put("forum_id", this.ggc.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
