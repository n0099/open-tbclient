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
    private PopupWindow gbA;
    private com.baidu.tieba.NEGFeedBack.b gbE;
    private boolean gbF;
    private int gbv;
    private EMTextView gcf;
    private EMTextView gcg;
    private EMTextView gch;
    private EMTextView gci;
    private EMTextView gcj;
    private LinearLayout gck;
    private a gcl;
    private b gcm;
    private h gcn;
    private int gcq;
    private ClickableSpan gcr;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private at gbt = null;
    private SparseArray<String> gbe = null;
    private List<b.a> gbu = new ArrayList();
    private NEGFeedBackView.a gbz = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fJT = null;
    private int mSkinType = 3;
    private boolean gco = true;
    private boolean gcp = false;
    private CompoundButton.OnCheckedChangeListener gbi = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.gbz != null) {
                i.this.gbz.onCheckedChanged(i.this.gbt, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.gbu.contains(aVar)) {
                        i.this.gbu.add(aVar);
                        if (i.this.gco && i.this.gcg != null) {
                            i.this.gcg.setClickable(true);
                            ao.n(i.this.gcg, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.gbu.remove(aVar);
                if (i.this.gco && i.this.gcg != null) {
                    i.this.gcg.setClickable(false);
                    ao.n(i.this.gcg, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener gbL = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.gbA != null) {
                i.this.gbA.dismiss();
                i.this.gbA = null;
                MessageManager.getInstance().unRegisterListener(i.this.eTp);
            }
        }
    };
    private CustomMessageListener eTp = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.btV();
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
        this.gcn = hVar;
        this.mUserData = userData;
        bKe();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gbE = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gbE.a(this.gbi);
        this.gbE.lS(true);
        if (this.gcp) {
            this.gbE.sN(5);
        }
    }

    private void bKe() {
        if (this.gcn != null) {
            if (this.gcn.bKa() == 1) {
                this.gco = false;
            } else {
                this.gco = true;
            }
            if (this.gcn.bJZ() == 1) {
                this.gcp = false;
            } else {
                this.gcp = true;
            }
        }
        if (this.gcp && this.mUserData != null) {
            this.gcq = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gbv = this.mContentView.getMeasuredHeight();
        return this.gbv;
    }

    public void setData(at atVar) {
        if (atVar != null) {
            this.gbt = atVar;
            this.gbe = atVar.getFeedBackReasonMap();
            if (this.gbe != null && this.gbe.size() > 8) {
                for (int size = this.gbe.size() - 1; size >= 8; size--) {
                    this.gbe.removeAt(size);
                }
            }
            this.gbE.setData(atVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gbE.setDefaultReasonArray(strArr);
    }

    public void bJR() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gbA != null) {
            this.gbA.dismiss();
            this.gbA = null;
        }
    }

    private void Si() {
        if (this.gbF && this.gbu.size() != 0) {
            this.gbu.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btV() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ao.setViewTextColor(this.gch, R.color.CAM_X0105, 1);
            ao.n(this.gcf, R.color.CAM_X0105);
            if (this.gco) {
                ao.n(this.gcg, R.color.CAM_X0108);
                this.gcg.setClickable(false);
            } else {
                ao.n(this.gcg, R.color.CAM_X0302);
            }
            ao.setViewTextColor(this.gci, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.gcj, R.color.CAM_X0105, 1);
            this.gcj.setBackgroundDrawable(ao.getDrawable(R.drawable.pic_popup_guide));
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
            this.gch = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.gch).nX(R.string.F_X02).nV(R.color.CAM_X0105);
            this.gci = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.gci).nW(R.dimen.T_X08);
            this.gcf = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.gcf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.gbA != null) {
                        i.this.gbA.dismiss();
                        i.this.gbA = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.gcl != null) {
                        i.this.gcl.onClick();
                    }
                }
            });
            this.gcg = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.gcg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bJW = i.this.bJW();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bJR();
                    } else if (bJW != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bJW);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.gck = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.gbE.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.gck.addView(rootView);
        }
        this.gcj = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.gcj.setHighlightColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(17170445));
        if (this.gcp) {
            this.gcj.setVisibility(0);
            if (1 == this.gcq) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.gcr = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.gcn.getForumId(), i.this.gcn.getForumName(), i.this.gcn.bKc(), i.this.gcn.bKd(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.gbA != null) {
                            i.this.gbA.dismiss();
                            i.this.gbA = null;
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
                spannableStringBuilder.setSpan(this.gcr, 13, 17, 18);
                this.gcj.setText(spannableStringBuilder);
                this.gcj.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.gcj.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.gcj.setVisibility(8);
        }
        this.gcj.setClickable(false);
        this.gcj.setBackgroundDrawable(ao.getDrawable(R.drawable.pic_popup_guide));
        btV();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.gcm = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fJT == null) {
            this.fJT = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fJT.setTipString(R.string.loading);
        this.fJT.setDialogVisiable(true);
    }

    public void DV(String str) {
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
                btV();
                this.mWindowHeight = getWindowMeasuredHeight();
                this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.gbL);
                Si();
                this.gbA = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gbA.setAttachedInDecor(false);
                }
                this.gbA.showAtLocation(this.mAnchor, 0, 0, 0);
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.gbz != null) {
                    this.gbz.onNEGFeedbackWindowShow(this.gbt);
                }
                this.gbF = true;
                MessageManager.getInstance().registerListener(this.eTp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bJW() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.gbt == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (x.isEmpty(this.gbu)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.gbu.size(); i2++) {
                b.a aVar = this.gbu.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new aq("c13123").dW("obj_source", this.mFrom).an("obj_type", i));
        if (this.gcm != null) {
            this.gcm.X(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.gbt.blT());
            jSONObject.put("type", this.gbt.blS());
            jSONObject.put("forum_id", this.gbt.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
