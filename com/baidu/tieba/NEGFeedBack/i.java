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
    private com.baidu.tieba.NEGFeedBack.b gfC;
    private boolean gfD;
    private int gft;
    private PopupWindow gfy;
    private EMTextView ggd;
    private EMTextView gge;
    private EMTextView ggf;
    private EMTextView ggg;
    private EMTextView ggh;
    private LinearLayout ggi;
    private a ggj;
    private b ggk;
    private h ggl;
    private int ggo;
    private ClickableSpan ggp;
    private View mAnchor;
    private ViewGroup mContentView;
    private Context mContext;
    private String mFrom;
    private TbPageContext mPageContext;
    private UserData mUserData;
    private int mWindowHeight;
    private int mWindowWidth;
    private int mXOffset;
    private av gfr = null;
    private SparseArray<String> gfc = null;
    private List<b.a> gfs = new ArrayList();
    private NEGFeedBackView.a gfx = null;
    private PopupWindow mPopupWindow = null;
    private com.baidu.tbadk.core.view.a fNE = null;
    private int mSkinType = 3;
    private boolean ggm = true;
    private boolean ggn = false;
    private CompoundButton.OnCheckedChangeListener gfg = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.NEGFeedBack.i.1
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (i.this.gfx != null) {
                i.this.gfx.onCheckedChanged(i.this.gfr, compoundButton, z);
            }
            if (compoundButton.getTag() instanceof b.a) {
                b.a aVar = (b.a) compoundButton.getTag();
                if (z) {
                    if (!i.this.gfs.contains(aVar)) {
                        i.this.gfs.add(aVar);
                        if (i.this.ggm && i.this.gge != null) {
                            i.this.gge.setClickable(true);
                            ap.n(i.this.gge, R.color.CAM_X0302);
                            return;
                        }
                        return;
                    }
                    return;
                }
                i.this.gfs.remove(aVar);
                if (i.this.ggm && i.this.gge != null) {
                    i.this.gge.setClickable(false);
                    ap.n(i.this.gge, R.color.CAM_X0108);
                }
            }
        }
    };
    private PopupWindow.OnDismissListener gfJ = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.NEGFeedBack.i.2
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (i.this.gfy != null) {
                i.this.gfy.dismiss();
                i.this.gfy = null;
                MessageManager.getInstance().unRegisterListener(i.this.eXe);
            }
        }
    };
    private CustomMessageListener eXe = new CustomMessageListener(CmdConfigCustom.CMD_SKIN_TYPE_CHANGE) { // from class: com.baidu.tieba.NEGFeedBack.i.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001304 && (customResponsedMessage.getData() instanceof Integer)) {
                i.this.bus();
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
        this.ggl = hVar;
        this.mUserData = userData;
        bKH();
        init();
    }

    private void init() {
        this.mXOffset = l.getDimens(this.mContext, R.dimen.M_W_X009);
        this.mWindowWidth = l.getEquipmentWidth(this.mContext) - (this.mXOffset * 2);
        this.gfC = new com.baidu.tieba.NEGFeedBack.b(this.mPageContext);
        this.gfC.a(this.gfg);
        this.gfC.lW(true);
        if (this.ggn) {
            this.gfC.sU(5);
        }
    }

    private void bKH() {
        if (this.ggl != null) {
            if (this.ggl.bKD() == 1) {
                this.ggm = false;
            } else {
                this.ggm = true;
            }
            if (this.ggl.bKC() == 1) {
                this.ggn = false;
            } else {
                this.ggn = true;
            }
        }
        if (this.ggn && this.mUserData != null) {
            this.ggo = this.mUserData.getIs_manager();
        }
    }

    private int getWindowMeasuredHeight() {
        if (this.mContentView == null) {
            return 0;
        }
        this.mContentView.measure(0, 0);
        this.gft = this.mContentView.getMeasuredHeight();
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
            ap.setViewTextColor(this.ggf, R.color.CAM_X0105, 1);
            ap.n(this.ggd, R.color.CAM_X0105);
            if (this.ggm) {
                ap.n(this.gge, R.color.CAM_X0108);
                this.gge.setClickable(false);
            } else {
                ap.n(this.gge, R.color.CAM_X0302);
            }
            ap.setViewTextColor(this.ggg, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ggh, R.color.CAM_X0105, 1);
            this.ggh.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
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
            this.ggf = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_title_view);
            com.baidu.tbadk.core.elementsMaven.c.br(this.ggf).ob(R.string.F_X02).nZ(R.color.CAM_X0105);
            this.ggg = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_describe_view);
            com.baidu.tbadk.core.elementsMaven.c.br(this.ggg).oa(R.dimen.T_X08);
            this.ggd = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_cancel_view);
            this.ggd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (i.this.gfy != null) {
                        i.this.gfy.dismiss();
                        i.this.gfy = null;
                    }
                    if (i.this.mPopupWindow != null) {
                        i.this.mPopupWindow.dismiss();
                        i.this.mPopupWindow = null;
                    }
                    if (i.this.ggj != null) {
                        i.this.ggj.onClick();
                    }
                }
            });
            this.gge = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_certain_view);
            this.gge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.i.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    JSONObject bKz = i.this.bKz();
                    if (i.this.mFrom == "3" || i.this.mFrom == "4" || i.this.mFrom == "1") {
                        i.this.bKu();
                    } else if (bKz != null) {
                        i.this.showLoadingView();
                        CustomMessage customMessage = new CustomMessage(2016489, i.this.mPageContext.getUniqueId());
                        CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2016489, bKz);
                        customResponsedMessage.setOrginalMessage(customMessage);
                        MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                    }
                }
            });
        }
        this.ggi = (LinearLayout) this.mContentView.findViewById(R.id.ueg_new_delete_thread_reason_view_container);
        View rootView = this.gfC.getRootView();
        if (rootView != null && rootView.getParent() == null) {
            int dimens = l.getDimens(this.mContext, R.dimen.M_W_X009);
            rootView.setPadding(dimens, 0, dimens, 0);
            this.ggi.addView(rootView);
        }
        this.ggh = (EMTextView) this.mContentView.findViewById(R.id.ueg_new_delete_thread_tip_view);
        this.ggh.setHighlightColor(com.baidu.tbadk.core.util.f.c.a.getResources().getColor(17170445));
        if (this.ggn) {
            this.ggh.setVisibility(0);
            if (1 == this.ggo) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                spannableStringBuilder.append((CharSequence) this.mContext.getString(R.string.set_forum_rule_tip_manager));
                this.ggp = new ClickableSpan() { // from class: com.baidu.tieba.NEGFeedBack.i.6
                    @Override // android.text.style.ClickableSpan
                    public void onClick(@NonNull View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRuleEditActivityConfig(i.this.mContext, i.this.ggl.getForumId(), i.this.ggl.getForumName(), i.this.ggl.bKF(), i.this.ggl.bKG(), ForumRuleEditActivityConfig.FORUM_RULE_EDIT_FROM_FRS)));
                        if (i.this.gfy != null) {
                            i.this.gfy.dismiss();
                            i.this.gfy = null;
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
                spannableStringBuilder.setSpan(this.ggp, 13, 17, 18);
                this.ggh.setText(spannableStringBuilder);
                this.ggh.setMovementMethod(LinkMovementMethod.getInstance());
            } else {
                this.ggh.setText(this.mContext.getString(R.string.set_forum_rule_tip_assist));
            }
        } else {
            this.ggh.setVisibility(8);
        }
        this.ggh.setClickable(false);
        this.ggh.setBackgroundDrawable(ap.getDrawable(R.drawable.pic_popup_guide));
        bus();
        return this.mContentView;
    }

    public void a(b bVar) {
        this.ggk = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoadingView() {
        if (this.fNE == null) {
            this.fNE = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fNE.setTipString(R.string.loading);
        this.fNE.setDialogVisiable(true);
    }

    public void Ey(String str) {
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
                bus();
                this.mWindowHeight = getWindowMeasuredHeight();
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
                this.mPopupWindow.showAtLocation(this.mAnchor, 17, 0, 0);
                if (this.gfx != null) {
                    this.gfx.onNEGFeedbackWindowShow(this.gfr);
                }
                this.gfD = true;
                MessageManager.getInstance().registerListener(this.eXe);
            }
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
        if (this.ggk != null) {
            this.ggk.W(jSONArray);
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
