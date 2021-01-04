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
    private i iwA;
    private k iyk;
    private final String juI;
    private final String juJ;
    private final String juK;
    private ForumRulesEditActivity juL;
    private View juM;
    private View juN;
    private View juO;
    private RelativeLayout juP;
    private RelativeLayout juQ;
    private RelativeLayout juR;
    private ImageView juS;
    private ImageView juT;
    private ImageView juU;
    private ImageView juV;
    private ImageView juW;
    private EMTextView juX;
    private EMTextView juY;
    private EMTextView juZ;
    private com.baidu.tieba.frs.forumRule.a.b jux;
    private EMTextView jva;
    private EMTextView jvb;
    private EMTextView jvc;
    private EMTextView jvd;
    private EditText jve;
    private EditText jvf;
    private LinearLayout jvg;
    private LinearLayout jvh;
    private LinearLayout jvi;
    private ForumRuleDafultItemView jvj;
    private TextView jvk;
    private TextView jvl;
    private TextView jvm;
    private e jvn;
    private EditorScrollView jvo;
    private BdTopToast jvr;
    private int jvt;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jvp = new ArrayList();
    private ForumRuleBaseData jvq = new ForumRuleBaseData();
    private boolean jvs = true;
    private boolean jvu = false;
    private k.b jvv = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cJV();
        }
    };
    private k.b jvw = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.12
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cKa();
            if (a.this.juL != null) {
                a.this.juL.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.a.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.juI = str;
        this.juJ = str2;
        this.juK = str4;
        this.jvt = i;
        this.juL = forumRulesEditActivity;
        this.jux = bVar;
        h(view, str3);
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jvg = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jvo = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.juS = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.juP = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.juT = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.juX = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.juM = view.findViewById(R.id.forum_to_copy_divider);
        this.jve = (EditText) view.findViewById(R.id.et_big_title);
        this.juY = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.juZ = (EMTextView) view.findViewById(R.id.title_number);
        this.juN = view.findViewById(R.id.forum_title_divider);
        this.jva = (EMTextView) view.findViewById(R.id.preface_title);
        this.juQ = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.juU = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jvf = (EditText) view.findViewById(R.id.preface_content);
        this.jvb = (EMTextView) view.findViewById(R.id.preface_number);
        this.juO = view.findViewById(R.id.preface_divider);
        this.jvh = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jvj = (ForumRuleDafultItemView) view.findViewById(R.id.ll_default_rule);
        this.juR = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jvc = (EMTextView) view.findViewById(R.id.create_rule);
        this.juV = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jvi = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jvd = (EMTextView) view.findViewById(R.id.add_preface);
        this.juW = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jvm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jvm.setId(R.id.negative_feedback_view);
        this.jvm.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jvk = new EMTextView(this.mPageContext.getPageActivity());
        this.jvk.setText(this.mPageContext.getString(R.string.video_preview));
        this.jvk.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jvk.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jvk.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jvk, this);
        this.jvl = new EMTextView(this.mPageContext.getPageActivity());
        this.jvl.setText(this.mPageContext.getString(R.string.push_commit));
        this.jvl.setEnabled(false);
        this.jvl.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jvl.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jvl.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jvl, this);
        initListener();
        cJR();
        a(false, null, false);
    }

    private void initListener() {
        this.juP.setOnClickListener(this);
        this.juY.setOnClickListener(this);
        this.jvi.setOnClickListener(this);
        this.juR.setOnClickListener(this);
        this.juU.setOnClickListener(this);
        this.jvg.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.juZ, 0, 30);
        b(this.jvb, 0, 200);
        this.jvo.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cJS();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jve);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jvf);
            }
        });
        this.jve.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.AV(length);
                a.b(a.this.juZ, length, 30);
                a.this.cJW();
            }
        });
        this.jvf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.AW(length);
                a.b(a.this.jvb, length, 200);
                a.this.cJW();
                if (a.this.jvf.getLineCount() > 6) {
                    a.this.jvf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.1
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
                    a.this.jvf.setOnTouchListener(null);
                }
            }
        });
    }

    private void cJR() {
        if (this.jvn == null && this.juP != null) {
            this.jvn = new e(this.mPageContext, this.juP);
            this.jvn.fP(R.drawable.bg_tip_blue_up_left);
            this.jvn.fO(16);
            this.jvn.pD(true);
            this.jvn.setUseDirectOffset(true);
            this.jvn.fQ(3000);
            this.jvn.yH(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jvn.aK(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJS() {
        if (this.jvn != null) {
            this.jvn.VL();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jvh != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cKg().getText().toString().length() != 0 || bVar.cKh().getText().toString().length() != 0) {
                        a.this.D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.this.jvp.size() == 1) {
                                    a.this.jvo.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                                }
                                a.this.jvh.removeView(bVar.getRootView());
                                a.this.jvp.remove(bVar);
                                a.this.cJY();
                                a.this.cJX();
                                a.this.cJW();
                            }
                        });
                        return;
                    }
                    if (a.this.jvp.size() == 1) {
                        a.this.jvo.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                    a.this.jvh.removeView(bVar.getRootView());
                    a.this.jvp.remove(bVar);
                    a.this.cJY();
                    a.this.cJX();
                    a.this.cJW();
                }
            });
            bVar.a(new b.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                @Override // com.baidu.tieba.frs.forumRule.view.b.a
                public void cKf() {
                    a.this.cJW();
                }
            });
            this.jvh.addView(bVar.getRootView());
            this.jvp.add(bVar);
            if (this.jvp.indexOf(bVar) != -1) {
                bVar.AX(this.jvp.indexOf(bVar));
            }
            cJW();
            cJY();
            if (forumRuleItemPbData != null) {
                bVar.cKh().setText(forumRuleItemPbData.title);
                bVar.cKh().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cKg = bVar.cKg();
                                tbLinkSpanGroup.a(cKg.getText(), cKg.getSelectionEnd(), cKg.getSelectionEnd(), (int) cKg.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.CE(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cKg.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cKg().p(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cKg().p("\r\n");
                            }
                        }
                    }
                }
                bVar.cKg().setSelection(bVar.cKg().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cKh().setTextColor(ao.getColor(R.color.CAM_X0301));
                    bVar.cKg().setTextColor(ao.getColor(R.color.CAM_X0301));
                    bVar.rd(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jvo.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AV(int i) {
        if (i > 0) {
            this.juY.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jve.getLayoutParams();
            layoutParams.width = -1;
            this.jve.setLayoutParams(layoutParams);
            return;
        }
        this.juY.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jve.getLayoutParams();
        layoutParams2.width = -2;
        this.jve.setLayoutParams(layoutParams2);
    }

    private void cJT() {
        if (this.jve == null || this.jve.getText().toString().length() <= 30) {
            if (this.jvp != null && this.jvp.size() > 0) {
                for (int i = 0; i < this.jvp.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jvp.get(i);
                    EditText cKh = bVar.cKh();
                    SpanGroupEditText cKg = bVar.cKg();
                    if (cKh == null || cKh.getText().toString().trim().length() <= 30) {
                        if (cKg != null && cKg.getText().toString().length() > 300) {
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.AU(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.AU(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jvf == null || this.jvf.getText().toString().length() <= 200) {
                cKc();
                this.jux.a(this.jvq, false);
                return;
            }
            Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void Le(String str) {
        if (this.jvr == null || !this.jvr.isShown()) {
            this.jvr = new BdTopToast(this.mPageContext.getPageActivity(), 2000).yW(false).UY(str);
            this.jvr.aR((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cJU() {
        if (this.jvl == null || this.jve == null || this.jve.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jvp != null && this.jvp.size() > 0) {
            for (int i = 0; i < this.jvp.size(); i++) {
                b bVar = this.jvp.get(i);
                EditText cKh = bVar.cKh();
                SpanGroupEditText cKg = bVar.cKg();
                if (cKh == null || cKh.getText().toString().trim().length() <= 0 || cKg == null || cKg.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re(boolean z) {
        if (z) {
            this.jvf.setText("");
            this.juQ.setVisibility(0);
            this.jvi.setVisibility(8);
            return;
        }
        this.jvf.setText("");
        this.juQ.setVisibility(8);
        this.jvi.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jvf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJV() {
        cKc();
        if (this.jvq != null) {
            if (this.jvq.getTitle().length() > 50) {
                cKa();
                Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jvq.getList() != null) {
                for (int i = 0; i < this.jvq.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jvq.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cKa();
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cKa();
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jvq.getPreface().length() > 600) {
                cKa();
                Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jux.a(this.jvq, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJW() {
        if (this.jvl != null) {
            if (cJU()) {
                this.jvl.setEnabled(true);
            } else {
                this.jvl.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJX() {
        if (this.jvp != null && this.jvp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jvp.size()) {
                    this.jvp.get(i2).AX(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJY() {
        if (this.jvp != null) {
            if (this.jvp.size() >= 16) {
                this.jvc.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.juR.setEnabled(false);
                this.jvc.setEnabled(false);
                this.jvs = false;
                this.juV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0105), ao.fdi), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.bv(this.juR).pM(R.color.CAM_X0902).pN(R.dimen.L_X02).pK(R.string.J_X07).pO(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jvc.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jvp.size())));
            this.juR.setEnabled(true);
            this.jvc.setEnabled(true);
            this.jvs = true;
            this.juV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juR).pM(R.color.CAM_X0902).pN(R.dimen.L_X02).pK(R.string.J_X07).pO(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public static void b(TextView textView, int i, int i2) {
        textView.setText(i + "/" + i2);
        if (i > i2) {
            com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0301);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bv(textView).pC(R.color.CAM_X0111);
        }
    }

    public void cJZ() {
        if (this.iwA == null) {
            this.iyk = new k(this.mPageContext.getPageActivity());
            this.iyk.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.iwA = new i(this.mPageContext, this.iyk);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.iyk);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jvv);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.iyk);
            gVar2.a(this.jvw);
            arrayList.add(gVar2);
            this.iyk.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cKa();
                }
            });
            this.iyk.bB(arrayList);
        }
        cKb();
    }

    public void cKa() {
        if (this.iwA != null && this.iwA.isShowing()) {
            this.iwA.dismiss();
        }
    }

    public void cKb() {
        if (this.iwA != null && this.juL != null && !this.juL.isFinishing()) {
            this.iwA.SY();
        }
    }

    private void cKc() {
        if (this.jvq == null) {
            this.jvq = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jvp != null && this.jvp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jvp.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jvp.get(i2);
                EditText cKh = bVar.cKh();
                SpanGroupEditText cKg = bVar.cKg();
                if (cKh != null) {
                    forumRuleItemData.setTitle(cKh.getText().toString());
                }
                if (cKg != null) {
                    forumRuleItemData.setContent(cKg.getSpanGroupManager().byB());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jvq.setTitle(this.jve.getText().toString());
        this.jvq.setPreface(this.jvf.getText().toString());
        this.jvq.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jvm) {
            cJZ();
        } else if (view == this.jvl) {
            cJT();
        } else if (view == this.jvk) {
            cKc();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.juI, this.juJ, this.jvq, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.juK, this.jvt)));
        } else if (view == this.juP) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.juJ, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.juY) {
            cKe();
        } else if (view == this.jvi) {
            re(true);
        } else if (view == this.juR) {
            a(true, null, false);
        } else if (view == this.juU) {
            cKd();
        } else if (view == this.jvg || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jve);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jvf);
        }
    }

    private void cKd() {
        if (TextUtils.isEmpty(this.jvf.getText().toString())) {
            re(false);
        } else {
            D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.re(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final View.OnClickListener onClickListener) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.pd(2);
        aVar.jI(false);
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
        aVar.b(this.mPageContext).btX();
    }

    private void cKe() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.juJ, at.getDateStringMouth(new Date()));
        this.jve.setText(format);
        this.jve.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jve.getLayoutParams();
        layoutParams.width = -1;
        this.jve.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvg).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juX).pC(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juM).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juN).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juO).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juZ).pC(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvb).pC(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juY).pC(R.color.CAM_X0304).pE(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jva).pC(R.color.CAM_X0107).pE(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvd).pC(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvm).pH(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvk).pH(R.color.CAM_X0302).pD(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvl).pD(R.dimen.T_X05);
            this.jvl.setTextColor(ao.aP(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jvc.setTextColor(ao.aP(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jve.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            this.jve.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.jvf.setHintTextColor(ao.getColor(R.color.CAM_X0111));
            this.jvf.setTextColor(ao.getColor(R.color.CAM_X0105));
            this.juS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.juT.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.juU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ao.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.juW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jvs) {
                this.juV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ao.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.juV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0304), ao.fdh), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.iyk != null) {
                this.iyk.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jve, R.drawable.edittext_cursor);
                j.h(this.jvf, R.drawable.edittext_cursor);
            } else {
                j.h(this.jve, R.drawable.edittext_cursor_1);
                j.h(this.jvf, R.drawable.edittext_cursor_1);
            }
            this.jvj.changeSkin(i);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.juR).pM(R.color.CAM_X0902).pN(R.dimen.L_X02).pK(R.string.J_X07).pO(this.jvs ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.jvi).pM(R.color.CAM_X0902).pN(R.dimen.L_X02).pK(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void b(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.mRootView != null && forumRuleBaseData != null) {
            this.jve.setText(forumRuleBaseData.getTitle());
            this.jve.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jvf.setText(forumRuleBaseData.getPreface());
            this.jvf.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jvp.get(0);
                this.jvh.removeView(bVar.getRootView());
                this.jvp.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jvp.size() > 0) {
                b bVar2 = this.jvp.get(0);
                this.jvh.removeView(bVar2.getRootView());
                this.jvp.remove(bVar2);
                cJY();
                cJX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AW(int i) {
        if (i == 0 && !this.jvu) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.jvf);
                this.jvu = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.jvf);
                this.jvu = true;
            }
        } else if (this.jvu) {
            this.jvu = false;
            com.baidu.tieba.frs.forumRule.d.a.a(0, 0, this.jvf);
        }
    }

    public void onDestory() {
        this.jvr = null;
        this.jvq = null;
        this.jux = null;
        this.juL = null;
        cKa();
        this.iwA = null;
        this.iyk = null;
    }
}
