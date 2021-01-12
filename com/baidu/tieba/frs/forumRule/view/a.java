package com.baidu.tieba.frs.forumRule.view;

import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.upload.action.pb.IMPushPb;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumRulesShowActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.data.ForumRuleBaseData;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.TbLinkSpanGroup;
import com.baidu.tieba.R;
import com.baidu.tieba.c.e;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.frs.forumRule.view.b;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.j;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private i irT;
    private k itD;
    private com.baidu.tieba.frs.forumRule.a.b jpR;
    private LinearLayout jqA;
    private LinearLayout jqB;
    private LinearLayout jqC;
    private ForumRuleDafultItemView jqD;
    private TextView jqE;
    private TextView jqF;
    private TextView jqG;
    private e jqH;
    private EditorScrollView jqI;
    private BdTopToast jqL;
    private int jqN;
    private final String jqc;
    private final String jqd;
    private final String jqe;
    private ForumRulesEditActivity jqf;
    private View jqg;
    private View jqh;
    private View jqi;
    private RelativeLayout jqj;
    private RelativeLayout jqk;
    private RelativeLayout jql;
    private ImageView jqm;
    private ImageView jqn;
    private ImageView jqo;
    private ImageView jqp;
    private ImageView jqq;
    private EMTextView jqr;
    private EMTextView jqs;
    private EMTextView jqt;
    private EMTextView jqu;
    private EMTextView jqv;
    private EMTextView jqw;
    private EMTextView jqx;
    private EditText jqy;
    private EditText jqz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jqJ = new ArrayList();
    private ForumRuleBaseData jqK = new ForumRuleBaseData();
    private boolean jqM = true;
    private boolean jqO = false;
    private k.b jqP = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cGe();
        }
    };
    private k.b jqQ = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.12
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cGj();
            if (a.this.jqf != null) {
                a.this.jqf.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.a.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.jqc = str;
        this.jqd = str2;
        this.jqe = str4;
        this.jqN = i;
        this.jqf = forumRulesEditActivity;
        this.jpR = bVar;
        h(view, str3);
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jqA = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jqI = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.jqm = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.jqj = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.jqn = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.jqr = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.jqg = view.findViewById(R.id.forum_to_copy_divider);
        this.jqy = (EditText) view.findViewById(R.id.et_big_title);
        this.jqs = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.jqt = (EMTextView) view.findViewById(R.id.title_number);
        this.jqh = view.findViewById(R.id.forum_title_divider);
        this.jqu = (EMTextView) view.findViewById(R.id.preface_title);
        this.jqk = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.jqo = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jqz = (EditText) view.findViewById(R.id.preface_content);
        this.jqv = (EMTextView) view.findViewById(R.id.preface_number);
        this.jqi = view.findViewById(R.id.preface_divider);
        this.jqB = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jqD = (ForumRuleDafultItemView) view.findViewById(R.id.ll_default_rule);
        this.jql = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jqw = (EMTextView) view.findViewById(R.id.create_rule);
        this.jqp = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jqC = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jqx = (EMTextView) view.findViewById(R.id.add_preface);
        this.jqq = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jqG = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jqG.setId(R.id.negative_feedback_view);
        this.jqG.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jqE = new EMTextView(this.mPageContext.getPageActivity());
        this.jqE.setText(this.mPageContext.getString(R.string.video_preview));
        this.jqE.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jqE.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jqE.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jqE, this);
        this.jqF = new EMTextView(this.mPageContext.getPageActivity());
        this.jqF.setText(this.mPageContext.getString(R.string.push_commit));
        this.jqF.setEnabled(false);
        this.jqF.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jqF.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jqF.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jqF, this);
        initListener();
        cGa();
        a(false, null, false);
    }

    private void initListener() {
        this.jqj.setOnClickListener(this);
        this.jqs.setOnClickListener(this);
        this.jqC.setOnClickListener(this);
        this.jql.setOnClickListener(this);
        this.jqo.setOnClickListener(this);
        this.jqA.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.jqt, 0, 30);
        b(this.jqv, 0, 200);
        this.jqI.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cGb();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jqy);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jqz);
            }
        });
        this.jqy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.zp(length);
                a.b(a.this.jqt, length, 30);
                a.this.cGf();
            }
        });
        this.jqz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.zq(length);
                a.b(a.this.jqv, length, 200);
                a.this.cGf();
                if (a.this.jqz.getLineCount() > 6) {
                    a.this.jqz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.1
                        @Override // android.view.View.OnTouchListener
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                view.getParent().requestDisallowInterceptTouchEvent(true);
                            } else if (motionEvent.getAction() == 1) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            } else if (motionEvent.getAction() == 3) {
                                view.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                            return false;
                        }
                    });
                } else {
                    a.this.jqz.setOnTouchListener(null);
                }
            }
        });
    }

    private void cGa() {
        if (this.jqH == null && this.jqj != null) {
            this.jqH = new e(this.mPageContext, this.jqj);
            this.jqH.ej(R.drawable.bg_tip_blue_up_left);
            this.jqH.ei(16);
            this.jqH.pz(true);
            this.jqH.setUseDirectOffset(true);
            this.jqH.ek(3000);
            this.jqH.xb(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jqH.aJ(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGb() {
        if (this.jqH != null) {
            this.jqH.RS();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jqB != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cGp().getText().toString().length() != 0 || bVar.cGq().getText().toString().length() != 0) {
                        a.this.D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.this.jqJ.size() == 1) {
                                    a.this.jqI.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                                }
                                a.this.jqB.removeView(bVar.getRootView());
                                a.this.jqJ.remove(bVar);
                                a.this.cGh();
                                a.this.cGg();
                                a.this.cGf();
                            }
                        });
                        return;
                    }
                    if (a.this.jqJ.size() == 1) {
                        a.this.jqI.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                    a.this.jqB.removeView(bVar.getRootView());
                    a.this.jqJ.remove(bVar);
                    a.this.cGh();
                    a.this.cGg();
                    a.this.cGf();
                }
            });
            bVar.a(new b.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                @Override // com.baidu.tieba.frs.forumRule.view.b.a
                public void cGo() {
                    a.this.cGf();
                }
            });
            this.jqB.addView(bVar.getRootView());
            this.jqJ.add(bVar);
            if (this.jqJ.indexOf(bVar) != -1) {
                bVar.zr(this.jqJ.indexOf(bVar));
            }
            cGf();
            cGh();
            if (forumRuleItemPbData != null) {
                bVar.cGq().setText(forumRuleItemPbData.title);
                bVar.cGq().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cGp = bVar.cGp();
                                tbLinkSpanGroup.a(cGp.getText(), cGp.getSelectionEnd(), cGp.getSelectionEnd(), (int) cGp.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.Bs(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cGp.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cGp().p(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cGp().p("\r\n");
                            }
                        }
                    }
                }
                bVar.cGp().setSelection(bVar.cGp().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cGq().setTextColor(ao.getColor(R.color.CAM_X0301));
                    bVar.cGp().setTextColor(ao.getColor(R.color.CAM_X0301));
                    bVar.qZ(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jqI.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zp(int i) {
        if (i > 0) {
            this.jqs.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jqy.getLayoutParams();
            layoutParams.width = -1;
            this.jqy.setLayoutParams(layoutParams);
            return;
        }
        this.jqs.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jqy.getLayoutParams();
        layoutParams2.width = -2;
        this.jqy.setLayoutParams(layoutParams2);
    }

    private void cGc() {
        if (this.jqy == null || this.jqy.getText().toString().length() <= 30) {
            if (this.jqJ != null && this.jqJ.size() > 0) {
                for (int i = 0; i < this.jqJ.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jqJ.get(i);
                    EditText cGq = bVar.cGq();
                    SpanGroupEditText cGp = bVar.cGp();
                    if (cGq == null || cGq.getText().toString().trim().length() <= 30) {
                        if (cGp != null && cGp.getText().toString().length() > 300) {
                            JT(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zo(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        JT(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zo(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jqz == null || this.jqz.getText().toString().length() <= 200) {
                cGl();
                this.jpR.a(this.jqK, false);
                return;
            }
            JT(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        JT(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void JT(String str) {
        if (this.jqL == null || !this.jqL.isShown()) {
            this.jqL = new BdTopToast(this.mPageContext.getPageActivity(), 2000).yS(false).TP(str);
            this.jqL.aR((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cGd() {
        if (this.jqF == null || this.jqy == null || this.jqy.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jqJ != null && this.jqJ.size() > 0) {
            for (int i = 0; i < this.jqJ.size(); i++) {
                b bVar = this.jqJ.get(i);
                EditText cGq = bVar.cGq();
                SpanGroupEditText cGp = bVar.cGp();
                if (cGq == null || cGq.getText().toString().trim().length() <= 0 || cGp == null || cGp.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ra(boolean z) {
        if (z) {
            this.jqz.setText("");
            this.jqk.setVisibility(0);
            this.jqC.setVisibility(8);
            return;
        }
        this.jqz.setText("");
        this.jqk.setVisibility(8);
        this.jqC.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jqz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGe() {
        cGl();
        if (this.jqK != null) {
            if (this.jqK.getTitle().length() > 50) {
                cGj();
                JT(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jqK.getList() != null) {
                for (int i = 0; i < this.jqK.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jqK.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cGj();
                            JT(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cGj();
                            JT(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jqK.getPreface().length() > 600) {
                cGj();
                JT(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jpR.a(this.jqK, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGf() {
        if (this.jqF != null) {
            if (cGd()) {
                this.jqF.setEnabled(true);
            } else {
                this.jqF.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGg() {
        if (this.jqJ != null && this.jqJ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jqJ.size()) {
                    this.jqJ.get(i2).zr(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGh() {
        if (this.jqJ != null) {
            if (this.jqJ.size() >= 16) {
                this.jqw.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.jql.setEnabled(false);
                this.jqw.setEnabled(false);
                this.jqM = false;
                this.jqp.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0105), ao.eYz), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.bv(this.jql).of(R.color.CAM_X0902).og(R.dimen.L_X02).od(R.string.J_X07).oh(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jqw.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jqJ.size())));
            this.jql.setEnabled(true);
            this.jqw.setEnabled(true);
            this.jqM = true;
            this.jqp.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jql).of(R.color.CAM_X0902).og(R.dimen.L_X02).od(R.string.J_X07).oh(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public static void b(TextView textView, int i, int i2) {
        textView.setText(i + "/" + i2);
        if (i > i2) {
            com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0301);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bv(textView).nV(R.color.CAM_X0111);
        }
    }

    public void cGi() {
        if (this.irT == null) {
            this.itD = new k(this.mPageContext.getPageActivity());
            this.itD.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.irT = new i(this.mPageContext, this.itD);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.itD);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jqP);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.itD);
            gVar2.a(this.jqQ);
            arrayList.add(gVar2);
            this.itD.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cGj();
                }
            });
            this.itD.bB(arrayList);
        }
        cGk();
    }

    public void cGj() {
        if (this.irT != null && this.irT.isShowing()) {
            this.irT.dismiss();
        }
    }

    public void cGk() {
        if (this.irT != null && this.jqf != null && !this.jqf.isFinishing()) {
            this.irT.Pd();
        }
    }

    private void cGl() {
        if (this.jqK == null) {
            this.jqK = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jqJ != null && this.jqJ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jqJ.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jqJ.get(i2);
                EditText cGq = bVar.cGq();
                SpanGroupEditText cGp = bVar.cGp();
                if (cGq != null) {
                    forumRuleItemData.setTitle(cGq.getText().toString());
                }
                if (cGp != null) {
                    forumRuleItemData.setContent(cGp.getSpanGroupManager().buI());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jqK.setTitle(this.jqy.getText().toString());
        this.jqK.setPreface(this.jqz.getText().toString());
        this.jqK.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jqG) {
            cGi();
        } else if (view == this.jqF) {
            cGc();
        } else if (view == this.jqE) {
            cGl();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.jqc, this.jqd, this.jqK, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.jqe, this.jqN)));
        } else if (view == this.jqj) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.jqd, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.jqs) {
            cGn();
        } else if (view == this.jqC) {
            ra(true);
        } else if (view == this.jql) {
            a(true, null, false);
        } else if (view == this.jqo) {
            cGm();
        } else if (view == this.jqA || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jqy);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jqz);
        }
    }

    private void cGm() {
        if (TextUtils.isEmpty(this.jqz.getText().toString())) {
            ra(false);
        } else {
            D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.ra(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final View.OnClickListener onClickListener) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nx(2);
        aVar.jE(false);
        ForumRuleDelItemDialogView forumRuleDelItemDialogView = new ForumRuleDelItemDialogView(this.mPageContext.getPageActivity());
        forumRuleDelItemDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        forumRuleDelItemDialogView.setpostButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                onClickListener.onClick(view);
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.br(forumRuleDelItemDialogView);
        aVar.b(this.mPageContext).bqe();
    }

    private void cGn() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.jqd, at.getDateStringMouth(new Date()));
        this.jqy.setText(format);
        this.jqy.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jqy.getLayoutParams();
        layoutParams.width = -1;
        this.jqy.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqA).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqr).nV(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqg).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqh).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqi).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqt).nV(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqv).nV(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqs).nV(R.color.CAM_X0304).nX(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqu).nV(R.color.CAM_X0107).nX(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqx).nV(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqG).oa(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqE).oa(R.color.CAM_X0302).nW(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqF).nW(R.dimen.T_X05);
            this.jqF.setTextColor(ao.aP(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jqw.setTextColor(ao.aP(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jqy.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            this.jqy.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jqz.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            this.jqz.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jqm.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jqn.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jqo.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jqq.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jqM) {
                this.jqp.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.jqp.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0304), ao.eYy), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.itD != null) {
                this.itD.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jqy, R.drawable.edittext_cursor);
                j.h(this.jqz, R.drawable.edittext_cursor);
            } else {
                j.h(this.jqy, R.drawable.edittext_cursor_1);
                j.h(this.jqz, R.drawable.edittext_cursor_1);
            }
            this.jqD.changeSkin(i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jql).of(R.color.CAM_X0902).og(R.dimen.L_X02).od(R.string.J_X07).oh(this.jqM ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jqC).of(R.color.CAM_X0902).og(R.dimen.L_X02).od(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void b(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.mRootView != null && forumRuleBaseData != null) {
            this.jqy.setText(forumRuleBaseData.getTitle());
            this.jqy.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jqz.setText(forumRuleBaseData.getPreface());
            this.jqz.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jqJ.get(0);
                this.jqB.removeView(bVar.getRootView());
                this.jqJ.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jqJ.size() > 0) {
                b bVar2 = this.jqJ.get(0);
                this.jqB.removeView(bVar2.getRootView());
                this.jqJ.remove(bVar2);
                cGh();
                cGg();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(int i) {
        if (i == 0 && !this.jqO) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.jqz);
                this.jqO = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.jqz);
                this.jqO = true;
            }
        } else if (this.jqO) {
            this.jqO = false;
            com.baidu.tieba.frs.forumRule.d.a.a(0, 0, this.jqz);
        }
    }

    public void onDestory() {
        this.jqL = null;
        this.jqK = null;
        this.jpR = null;
        this.jqf = null;
        cGj();
        this.irT = null;
        this.itD = null;
    }
}
