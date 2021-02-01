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
import com.baidu.tbadk.core.data.av;
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
/* loaded from: classes.dex */
public class i {
    private int gdK;
    private PopupWindow gdP;
    private com.baidu.tieba.NEGFeedBack.b gdT;
    private boolean gdU;
    private LinearLayout geA;
    private a geB;
    private b geC;
    private h geD;
    private int geG;
    private ClickableSpan geH;
    private EMTextView gev;
    private EMTextView gew;
    private EMTextView gex;
    private EMTextView gey;
    private EMTextView gez;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private av gdI = null;
    private SparseArray<String> gdt = null;
    private List<b.a> gdJ = new ArrayList();
    private NEGFeedBackView.a gdO = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fMe = null;
    private int mSkinType = 3;
    private boolean geE = true;
    private boolean geF = false;
    private CompoundButton.OnCheckedChangeListener gdx = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.gdO != null) {
                i.this.gdO.onCheckedChanged(i.this.gdI, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.gdJ.contains(aVar)) {
                        i.this.gdJ.add(aVar);
                        if (i.this.geE && i.this.gew != null) {
                            i.this.gew.setClickable(true);
                            ap.n(i.this.gew, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.gdJ.remove(aVar);
                if (i.this.geE && i.this.gew != null) {
                    i.this.gew.setClickable(false);
                    ap.n(i.this.gew, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener gea = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.gdP != null) {
                i.this.gdP.dismiss();
                i.this.gdP = null;
                MessageManager.getInstance().unRegisterListener(i.this.eVF);
            }
        }
    };
    private CustomMessageListener eVF = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.bup();
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

    public i(TbPageContext tbPageContext, View view, h hVar, UserData userData) {
        this.mContext = null;
        this.mContext = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.mAnchor = view;
        this.geD = hVar;
        this.mUserData = userData;
        bKy();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gdT = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gdT.a(this.gdx);
        this.gdT.lW(true);
        if (this.geF) {
            this.gdT.sS(5);
        }
    }

    private void bKy() {
        if (this.geD != null) {
            if (this.geD.bKu() == 1) {
                this.geE = false;
            } else {
                this.geE = true;
            }
            if (this.geD.bKt() == 1) {
                this.geF = false;
            } else {
                this.geF = true;
            }
        }
        if (this.geF && this.mUserData != null) {
            this.geG = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gdK = this.mContentView.getMeasuredHeight();
        return this.gdK;
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gdI = avVar;
            this.gdt = avVar.getFeedBackReasonMap();
            if (this.gdt != null && this.gdt.size() > 8) {
                for (int size = this.gdt.size() - 1; size >= 8; size--) {
                    this.gdt.removeAt(size);
                }
            }
            this.gdT.setData(avVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdT.setDefaultReasonArray(strArr);
    }

    public void bKl() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gdP != null) {
            this.gdP.dismiss();
            this.gdP = null;
        }
    }

    private void TP() {
        if (this.gdU && this.gdJ.size() != 0) {
            this.gdJ.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.gex, R.color.CAM_X0105, 1);
            ap.n(this.gev, R.color.CAM_X0105);
            if (this.geE) {
                ap.n(this.gew, R.color.CAM_X0108);
                this.gew.setClickable(false);
            } else {
                ap.n(this.gew, R.color.CAM_X0302);
            }
            ap.setViewTextColor(this.gey, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.gez, R.color.CAM_X0105, 1);
            this.gez.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
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
            this.gex = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.br(this.gex).oa(R.string.F_X02).nY(R.color.CAM_X0105);
            this.gey = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.br(this.gey).nZ(R.dimen.T_X08);
            this.gev = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.gev.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.gdP != null) {
                        i.this.gdP.dismiss();
                        i.this.gdP = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.geB != null) {
                        i.this.geB.onClick();
                    }
                }
            });
            this.gew = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.gew.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bKq = i.this.bKq();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bKl();
                    } else if (bKq != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bKq);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.geA = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.gdT.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.geA.addView(rootView);
        }
        this.gez = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.gez.setHighlightColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(17170445));
        if (this.geF) {
            this.gez.setVisibility(0);
            if (1 == this.geG) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.geH = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.geD.getForumId(), i.this.geD.getForumName(), i.this.geD.bKw(), i.this.geD.bKx(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.gdP != null) {
                            i.this.gdP.dismiss();
                            i.this.gdP = null;
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
                spannableStringBuilder.setSpan(this.geH, 13, 17, 18);
                this.gez.setText(spannableStringBuilder);
                this.gez.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.gez.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.gez.setVisibility(8);
        }
        this.gez.setClickable(false);
        this.gez.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
        bup();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.geC = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fMe == null) {
            this.fMe = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fMe.setTipString(R.string.loading);
        this.fMe.setDialogVisiable(true);
    }

    public void Et(String str) {
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
                bup();
                this.mWindowHeight = getWindowMeasuredHeight();
                this.mPopupWindow = new PopupWindow(view, this.mWindowWidth, this.mWindowHeight);
                this.mPopupWindow.setFocusable(true);
                this.mPopupWindow.setTouchable(true);
                this.mPopupWindow.setOnDismissListener(this.gea);
                TP();
                this.gdP = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gdP.setAttachedInDecor(false);
                }
                this.gdP.showAtLocation(this.mAnchor, 0, 0, 0);
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.gdO != null) {
                    this.gdO.onNEGFeedbackWindowShow(this.gdI);
                }
                this.gdU = true;
                MessageManager.getInstance().registerListener(this.eVF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKq() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.gdI == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.gdJ)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.gdJ.size(); i2++) {
                b.a aVar = this.gdJ.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dR("obj_source", this.mFrom).ap("obj_type", i));
        if (this.geC != null) {
            this.geC.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.gdI.bmm());
            jSONObject.put("type", this.gdI.bml());
            jSONObject.put("forum_id", this.gdI.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
