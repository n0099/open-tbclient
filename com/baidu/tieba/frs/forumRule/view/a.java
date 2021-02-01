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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
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
    private i ixB;
    private k izn;
    private final String jvI;
    private final String jvJ;
    private final String jvK;
    private ForumRulesEditActivity jvL;
    private View jvM;
    private View jvN;
    private View jvO;
    private RelativeLayout jvP;
    private RelativeLayout jvQ;
    private RelativeLayout jvR;
    private ImageView jvS;
    private ImageView jvT;
    private ImageView jvU;
    private ImageView jvV;
    private ImageView jvW;
    private EMTextView jvX;
    private EMTextView jvY;
    private EMTextView jvZ;
    private com.baidu.tieba.frs.forumRule.a.b jvx;
    private EMTextView jwa;
    private EMTextView jwb;
    private EMTextView jwc;
    private EMTextView jwd;
    private EditText jwe;
    private EditText jwf;
    private LinearLayout jwg;
    private LinearLayout jwh;
    private LinearLayout jwi;
    private ForumRuleDafultItemView jwj;
    private TextView jwk;
    private TextView jwl;
    private TextView jwm;
    private e jwn;
    private EditorScrollView jwo;
    private BdTopToast jwr;
    private int jwt;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jwp = new ArrayList();
    private ForumRuleBaseData jwq = new ForumRuleBaseData();
    private boolean jws = true;
    private boolean jwu = false;
    private k.b jwv = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHr();
        }
    };
    private k.b jww = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.12
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHw();
            if (a.this.jvL != null) {
                a.this.jvL.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.a.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.jvI = str;
        this.jvJ = str2;
        this.jvK = str4;
        this.jwt = i;
        this.jvL = forumRulesEditActivity;
        this.jvx = bVar;
        i(view, str3);
    }

    private void i(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jwg = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jwo = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.jvS = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.jvP = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.jvT = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.jvX = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.jvM = view.findViewById(R.id.forum_to_copy_divider);
        this.jwe = (EditText) view.findViewById(R.id.et_big_title);
        this.jvY = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.jvZ = (EMTextView) view.findViewById(R.id.title_number);
        this.jvN = view.findViewById(R.id.forum_title_divider);
        this.jwa = (EMTextView) view.findViewById(R.id.preface_title);
        this.jvQ = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.jvU = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jwf = (EditText) view.findViewById(R.id.preface_content);
        this.jwb = (EMTextView) view.findViewById(R.id.preface_number);
        this.jvO = view.findViewById(R.id.preface_divider);
        this.jwh = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jwj = (ForumRuleDafultItemView) view.findViewById(R.id.ll_default_rule);
        this.jvR = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jwc = (EMTextView) view.findViewById(R.id.create_rule);
        this.jvV = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jwi = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jwd = (EMTextView) view.findViewById(R.id.add_preface);
        this.jvW = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jwm = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jwm.setId(R.id.negative_feedback_view);
        this.jwm.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jwk = new EMTextView(this.mPageContext.getPageActivity());
        this.jwk.setText(this.mPageContext.getString(R.string.video_preview));
        this.jwk.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jwk.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jwk.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jwk, this);
        this.jwl = new EMTextView(this.mPageContext.getPageActivity());
        this.jwl.setText(this.mPageContext.getString(R.string.push_commit));
        this.jwl.setEnabled(false);
        this.jwl.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jwl.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jwl.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jwl, this);
        initListener();
        cHn();
        a(false, null, false);
    }

    private void initListener() {
        this.jvP.setOnClickListener(this);
        this.jvY.setOnClickListener(this);
        this.jwi.setOnClickListener(this);
        this.jvR.setOnClickListener(this);
        this.jvU.setOnClickListener(this);
        this.jwg.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.jvZ, 0, 30);
        b(this.jwb, 0, 200);
        this.jwo.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cHo();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jwe);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jwf);
            }
        });
        this.jwe.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.zz(length);
                a.b(a.this.jvZ, length, 30);
                a.this.cHs();
            }
        });
        this.jwf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.zA(length);
                a.b(a.this.jwb, length, 200);
                a.this.cHs();
                if (a.this.jwf.getLineCount() > 6) {
                    a.this.jwf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.1
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
                    a.this.jwf.setOnTouchListener(null);
                }
            }
        });
    }

    private void cHn() {
        if (this.jwn == null && this.jvP != null) {
            this.jwn = new e(this.mPageContext, this.jvP);
            this.jwn.en(R.drawable.bg_tip_blue_up_left);
            this.jwn.em(16);
            this.jwn.pJ(true);
            this.jwn.setUseDirectOffset(true);
            this.jwn.eo(3000);
            this.jwn.xl(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jwn.aJ(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHo() {
        if (this.jwn != null) {
            this.jwn.Tz();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jwh != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cHC().getText().toString().length() != 0 || bVar.cHD().getText().toString().length() != 0) {
                        a.this.D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.this.jwp.size() == 1) {
                                    a.this.jwo.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                                }
                                a.this.jwh.removeView(bVar.getRootView());
                                a.this.jwp.remove(bVar);
                                a.this.cHu();
                                a.this.cHt();
                                a.this.cHs();
                            }
                        });
                        return;
                    }
                    if (a.this.jwp.size() == 1) {
                        a.this.jwo.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                    a.this.jwh.removeView(bVar.getRootView());
                    a.this.jwp.remove(bVar);
                    a.this.cHu();
                    a.this.cHt();
                    a.this.cHs();
                }
            });
            bVar.a(new b.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                @Override // com.baidu.tieba.frs.forumRule.view.b.a
                public void cHB() {
                    a.this.cHs();
                }
            });
            this.jwh.addView(bVar.getRootView());
            this.jwp.add(bVar);
            if (this.jwp.indexOf(bVar) != -1) {
                bVar.zB(this.jwp.indexOf(bVar));
            }
            cHs();
            cHu();
            if (forumRuleItemPbData != null) {
                bVar.cHD().setText(forumRuleItemPbData.title);
                bVar.cHD().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cHC = bVar.cHC();
                                tbLinkSpanGroup.a(cHC.getText(), cHC.getSelectionEnd(), cHC.getSelectionEnd(), (int) cHC.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.BJ(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cHC.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHC().o(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHC().o("\r\n");
                            }
                        }
                    }
                }
                bVar.cHC().setSelection(bVar.cHC().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cHD().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.cHC().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.rj(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jwo.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz(int i) {
        if (i > 0) {
            this.jvY.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jwe.getLayoutParams();
            layoutParams.width = -1;
            this.jwe.setLayoutParams(layoutParams);
            return;
        }
        this.jvY.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jwe.getLayoutParams();
        layoutParams2.width = -2;
        this.jwe.setLayoutParams(layoutParams2);
    }

    private void cHp() {
        if (this.jwe == null || this.jwe.getText().toString().length() <= 30) {
            if (this.jwp != null && this.jwp.size() > 0) {
                for (int i = 0; i < this.jwp.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jwp.get(i);
                    EditText cHD = bVar.cHD();
                    SpanGroupEditText cHC = bVar.cHC();
                    if (cHD == null || cHD.getText().toString().trim().length() <= 30) {
                        if (cHC != null && cHC.getText().toString().length() > 300) {
                            KE(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zy(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        KE(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zy(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jwf == null || this.jwf.getText().toString().length() <= 200) {
                cHy();
                this.jvx.a(this.jwq, false);
                return;
            }
            KE(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        KE(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void KE(String str) {
        if (this.jwr == null || !this.jwr.isShown()) {
            this.jwr = new BdTopToast(this.mPageContext.getPageActivity(), 2000).zn(false).UN(str);
            this.jwr.aR((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cHq() {
        if (this.jwl == null || this.jwe == null || this.jwe.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jwp != null && this.jwp.size() > 0) {
            for (int i = 0; i < this.jwp.size(); i++) {
                b bVar = this.jwp.get(i);
                EditText cHD = bVar.cHD();
                SpanGroupEditText cHC = bVar.cHC();
                if (cHD == null || cHD.getText().toString().trim().length() <= 0 || cHC == null || cHC.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        if (z) {
            this.jwf.setText("");
            this.jvQ.setVisibility(0);
            this.jwi.setVisibility(8);
            return;
        }
        this.jwf.setText("");
        this.jvQ.setVisibility(8);
        this.jwi.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jwf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHr() {
        cHy();
        if (this.jwq != null) {
            if (this.jwq.getTitle().length() > 50) {
                cHw();
                KE(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jwq.getList() != null) {
                for (int i = 0; i < this.jwq.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jwq.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cHw();
                            KE(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cHw();
                            KE(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jwq.getPreface().length() > 600) {
                cHw();
                KE(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jvx.a(this.jwq, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHs() {
        if (this.jwl != null) {
            if (cHq()) {
                this.jwl.setEnabled(true);
            } else {
                this.jwl.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHt() {
        if (this.jwp != null && this.jwp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jwp.size()) {
                    this.jwp.get(i2).zB(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHu() {
        if (this.jwp != null) {
            if (this.jwp.size() >= 16) {
                this.jwc.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.jvR.setEnabled(false);
                this.jwc.setEnabled(false);
                this.jws = false;
                this.jvV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0105), ap.faO), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.br(this.jvR).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).ol(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jwc.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jwp.size())));
            this.jvR.setEnabled(true);
            this.jwc.setEnabled(true);
            this.jws = true;
            this.jvV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvR).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).ol(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public static void b(TextView textView, int i, int i2) {
        textView.setText(i + "/" + i2);
        if (i > i2) {
            com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0301);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(textView).nY(R.color.CAM_X0111);
        }
    }

    public void cHv() {
        if (this.ixB == null) {
            this.izn = new k(this.mPageContext.getPageActivity());
            this.izn.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.ixB = new i(this.mPageContext, this.izn);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.izn);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jwv);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.izn);
            gVar2.a(this.jww);
            arrayList.add(gVar2);
            this.izn.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cHw();
                }
            });
            this.izn.bw(arrayList);
        }
        cHx();
    }

    public void cHw() {
        if (this.ixB != null && this.ixB.isShowing()) {
            this.ixB.dismiss();
        }
    }

    public void cHx() {
        if (this.ixB != null && this.jvL != null && !this.jvL.isFinishing()) {
            this.ixB.QE();
        }
    }

    private void cHy() {
        if (this.jwq == null) {
            this.jwq = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jwp != null && this.jwp.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jwp.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jwp.get(i2);
                EditText cHD = bVar.cHD();
                SpanGroupEditText cHC = bVar.cHC();
                if (cHD != null) {
                    forumRuleItemData.setTitle(cHD.getText().toString());
                }
                if (cHC != null) {
                    forumRuleItemData.setContent(cHC.getSpanGroupManager().bvc());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jwq.setTitle(this.jwe.getText().toString());
        this.jwq.setPreface(this.jwf.getText().toString());
        this.jwq.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jwm) {
            cHv();
        } else if (view == this.jwl) {
            cHp();
        } else if (view == this.jwk) {
            cHy();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.jvI, this.jvJ, this.jwq, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.jvK, this.jwt)));
        } else if (view == this.jvP) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.jvJ, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.jvY) {
            cHA();
        } else if (view == this.jwi) {
            rk(true);
        } else if (view == this.jvR) {
            a(true, null, false);
        } else if (view == this.jvU) {
            cHz();
        } else if (view == this.jwg || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jwe);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jwf);
        }
    }

    private void cHz() {
        if (TextUtils.isEmpty(this.jwf.getText().toString())) {
            rk(false);
        } else {
            D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rk(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(final View.OnClickListener onClickListener) {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.nA(2);
        aVar.jG(false);
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
        aVar.bn(forumRuleDelItemDialogView);
        aVar.b(this.mPageContext).bqx();
    }

    private void cHA() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.jvJ, au.getDateStringMouth(new Date()));
        this.jwe.setText(format);
        this.jwe.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jwe.getLayoutParams();
        layoutParams.width = -1;
        this.jwe.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwg).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvX).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvM).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvN).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvO).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvZ).nY(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwb).nY(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvY).nY(R.color.CAM_X0304).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwa).nY(R.color.CAM_X0107).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwd).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwm).od(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwk).od(R.color.CAM_X0302).nZ(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwl).nZ(R.dimen.T_X05);
            this.jwl.setTextColor(ap.aM(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jwc.setTextColor(ap.aM(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jwe.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jwe.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwf.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jwf.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jvS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jvT.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jvU.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jvW.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jws) {
                this.jvV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.jvV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0304), ap.faN), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.izn != null) {
                this.izn.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jwe, R.drawable.edittext_cursor);
                j.h(this.jwf, R.drawable.edittext_cursor);
            } else {
                j.h(this.jwe, R.drawable.edittext_cursor_1);
                j.h(this.jwf, R.drawable.edittext_cursor_1);
            }
            this.jwj.changeSkin(i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jvR).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).ol(this.jws ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwi).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void b(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.mRootView != null && forumRuleBaseData != null) {
            this.jwe.setText(forumRuleBaseData.getTitle());
            this.jwe.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jwf.setText(forumRuleBaseData.getPreface());
            this.jwf.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jwp.get(0);
                this.jwh.removeView(bVar.getRootView());
                this.jwp.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jwp.size() > 0) {
                b bVar2 = this.jwp.get(0);
                this.jwh.removeView(bVar2.getRootView());
                this.jwp.remove(bVar2);
                cHu();
                cHt();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        if (i == 0 && !this.jwu) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.jwf);
                this.jwu = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.jwf);
                this.jwu = true;
            }
        } else if (this.jwu) {
            this.jwu = false;
            com.baidu.tieba.frs.forumRule.d.a.a(0, 0, this.jwf);
        }
    }

    public void onDestory() {
        this.jwr = null;
        this.jwq = null;
        this.jvx = null;
        this.jvL = null;
        cHw();
        this.ixB = null;
        this.izn = null;
    }
}
