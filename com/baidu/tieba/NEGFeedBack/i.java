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
    private int gdP;
    private PopupWindow gdU;
    private com.baidu.tieba.NEGFeedBack.b gdY;
    private boolean gdZ;
    private EMTextView geA;
    private EMTextView geB;
    private EMTextView geC;
    private EMTextView geD;
    private EMTextView geE;
    private LinearLayout geF;
    private a geG;
    private b geH;
    private h geI;
    private int geL;
    private ClickableSpan geM;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private av gdN = null;
    private SparseArray<String> gdy = null;
    private List<b.a> gdO = new ArrayList();
    private NEGFeedBackView.a gdT = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fMe = null;
    private int mSkinType = 3;
    private boolean geJ = true;
    private boolean geK = false;
    private CompoundButton.OnCheckedChangeListener gdC = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.gdT != null) {
                i.this.gdT.onCheckedChanged(i.this.gdN, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.gdO.contains(aVar)) {
                        i.this.gdO.add(aVar);
                        if (i.this.geJ && i.this.geB != null) {
                            i.this.geB.setClickable(true);
                            ap.n(i.this.geB, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.gdO.remove(aVar);
                if (i.this.geJ && i.this.geB != null) {
                    i.this.geB.setClickable(false);
                    ap.n(i.this.geB, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener gef = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.gdU != null) {
                i.this.gdU.dismiss();
                i.this.gdU = null;
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
        this.geI = hVar;
        this.mUserData = userData;
        bKD();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gdY = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gdY.a(this.gdC);
        this.gdY.lW(true);
        if (this.geK) {
            this.gdY.sS(5);
        }
    }

    private void bKD() {
        if (this.geI != null) {
            if (this.geI.bKz() == 1) {
                this.geJ = false;
            } else {
                this.geJ = true;
            }
            if (this.geI.bKy() == 1) {
                this.geK = false;
            } else {
                this.geK = true;
            }
        }
        if (this.geK && this.mUserData != null) {
            this.geL = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gdP = this.mContentView.getMeasuredHeight();
        return this.gdP;
    }

    public void setData(av avVar) {
        if (avVar != null) {
            this.gdN = avVar;
            this.gdy = avVar.getFeedBackReasonMap();
            if (this.gdy != null && this.gdy.size() > 8) {
                for (int size = this.gdy.size() - 1; size >= 8; size--) {
                    this.gdy.removeAt(size);
                }
            }
            this.gdY.setData(avVar);
        }
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.gdY.setDefaultReasonArray(strArr);
    }

    public void bKq() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
        if (this.gdU != null) {
            this.gdU.dismiss();
            this.gdU = null;
        }
    }

    private void TP() {
        if (this.gdZ && this.gdO.size() != 0) {
            this.gdO.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            ap.setViewTextColor(this.geC, R.color.CAM_X0105, 1);
            ap.n(this.geA, R.color.CAM_X0105);
            if (this.geJ) {
                ap.n(this.geB, R.color.CAM_X0108);
                this.geB.setClickable(false);
            } else {
                ap.n(this.geB, R.color.CAM_X0302);
            }
            ap.setViewTextColor(this.geD, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.geE, R.color.CAM_X0105, 1);
            this.geE.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
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
            this.geC = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.br(this.geC).oa(R.string.F_X02).nY(R.color.CAM_X0105);
            this.geD = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.br(this.geD).nZ(R.dimen.T_X08);
            this.geA = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.geA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.gdU != null) {
                        i.this.gdU.dismiss();
                        i.this.gdU = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.geG != null) {
                        i.this.geG.onClick();
                    }
                }
            });
            this.geB = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.geB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bKv = i.this.bKv();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bKq();
                    } else if (bKv != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bKv);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.geF = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.gdY.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.geF.addView(rootView);
        }
        this.geE = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.geE.setHighlightColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(17170445));
        if (this.geK) {
            this.geE.setVisibility(0);
            if (1 == this.geL) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.geM = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.geI.getForumId(), i.this.geI.getForumName(), i.this.geI.bKB(), i.this.geI.bKC(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.gdU != null) {
                            i.this.gdU.dismiss();
                            i.this.gdU = null;
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
                spannableStringBuilder.setSpan(this.geM, 13, 17, 18);
                this.geE.setText(spannableStringBuilder);
                this.geE.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.geE.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.geE.setVisibility(8);
        }
        this.geE.setClickable(false);
        this.geE.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
        bup();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.geH = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fMe == null) {
            this.fMe = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fMe.setTipString(R.string.loading);
        this.fMe.setDialogVisiable(true);
    }

    public void Er(String str) {
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
                this.mPopupWindow.setOnDismissListener(this.gef);
                TP();
                this.gdU = new PopupWindow(LayoutInflater.from(this.mContext).inflate(R.layout.view_negative_feedback_bottom, (ViewGroup) null), -1, -1);
                if (Build.VERSION.SDK_INT >= 22) {
                    this.gdU.setAttachedInDecor(false);
                }
                this.gdU.showAtLocation(this.mAnchor, 0, 0, 0);
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.gdT != null) {
                    this.gdT.onNEGFeedbackWindowShow(this.gdN);
                }
                this.gdZ = true;
                MessageManager.getInstance().registerListener(this.eVF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject bKv() {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (this.gdN == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (y.isEmpty(this.gdO)) {
            i = 0;
        } else {
            i = 0;
            for (int i2 = 0; i2 < this.gdO.size(); i2++) {
                b.a aVar = this.gdO.get(i2);
                if (aVar != null) {
                    jSONArray.put(String.valueOf(aVar.id));
                    i = aVar.index + 1;
                }
            }
        }
        TiebaStatic.log(new ar("c13123").dR("obj_source", this.mFrom).ap("obj_type", i));
        if (this.geH != null) {
            this.geH.W(jSONArray);
        }
        try {
            jSONObject.put(TiebaInitialize.LogFields.REASON, jSONArray);
            jSONObject.put("thread_ids", this.gdN.bmm());
            jSONObject.put("type", this.gdN.bml());
            jSONObject.put("forum_id", this.gdN.getFid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
