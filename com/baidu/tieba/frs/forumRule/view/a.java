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
    private i ixP;
    private k izB;
    private com.baidu.tieba.frs.forumRule.a.b jvL;
    private final String jvW;
    private final String jvX;
    private final String jvY;
    private ForumRulesEditActivity jvZ;
    private TextView jwA;
    private e jwB;
    private EditorScrollView jwC;
    private BdTopToast jwF;
    private int jwH;
    private View jwa;
    private View jwb;
    private View jwc;
    private RelativeLayout jwd;
    private RelativeLayout jwe;
    private RelativeLayout jwf;
    private ImageView jwg;
    private ImageView jwh;
    private ImageView jwi;
    private ImageView jwj;
    private ImageView jwk;
    private EMTextView jwl;
    private EMTextView jwm;
    private EMTextView jwn;
    private EMTextView jwo;
    private EMTextView jwp;
    private EMTextView jwq;
    private EMTextView jwr;
    private EditText jws;
    private EditText jwt;
    private LinearLayout jwu;
    private LinearLayout jwv;
    private LinearLayout jww;
    private ForumRuleDafultItemView jwx;
    private TextView jwy;
    private TextView jwz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jwD = new ArrayList();
    private ForumRuleBaseData jwE = new ForumRuleBaseData();
    private boolean jwG = true;
    private boolean jwI = false;
    private k.b jwJ = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHy();
        }
    };
    private k.b jwK = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.12
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHD();
            if (a.this.jvZ != null) {
                a.this.jvZ.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.a.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.jvW = str;
        this.jvX = str2;
        this.jvY = str4;
        this.jwH = i;
        this.jvZ = forumRulesEditActivity;
        this.jvL = bVar;
        i(view, str3);
    }

    private void i(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jwu = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jwC = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.jwg = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.jwd = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.jwh = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.jwl = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.jwa = view.findViewById(R.id.forum_to_copy_divider);
        this.jws = (EditText) view.findViewById(R.id.et_big_title);
        this.jwm = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.jwn = (EMTextView) view.findViewById(R.id.title_number);
        this.jwb = view.findViewById(R.id.forum_title_divider);
        this.jwo = (EMTextView) view.findViewById(R.id.preface_title);
        this.jwe = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.jwi = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jwt = (EditText) view.findViewById(R.id.preface_content);
        this.jwp = (EMTextView) view.findViewById(R.id.preface_number);
        this.jwc = view.findViewById(R.id.preface_divider);
        this.jwv = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jwx = (ForumRuleDafultItemView) view.findViewById(R.id.ll_default_rule);
        this.jwf = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jwq = (EMTextView) view.findViewById(R.id.create_rule);
        this.jwj = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jww = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jwr = (EMTextView) view.findViewById(R.id.add_preface);
        this.jwk = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jwA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jwA.setId(R.id.negative_feedback_view);
        this.jwA.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jwy = new EMTextView(this.mPageContext.getPageActivity());
        this.jwy.setText(this.mPageContext.getString(R.string.video_preview));
        this.jwy.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jwy.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jwy.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jwy, this);
        this.jwz = new EMTextView(this.mPageContext.getPageActivity());
        this.jwz.setText(this.mPageContext.getString(R.string.push_commit));
        this.jwz.setEnabled(false);
        this.jwz.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jwz.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jwz.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jwz, this);
        initListener();
        cHu();
        a(false, null, false);
    }

    private void initListener() {
        this.jwd.setOnClickListener(this);
        this.jwm.setOnClickListener(this);
        this.jww.setOnClickListener(this);
        this.jwf.setOnClickListener(this);
        this.jwi.setOnClickListener(this);
        this.jwu.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.jwn, 0, 30);
        b(this.jwp, 0, 200);
        this.jwC.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cHv();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jws);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jwt);
            }
        });
        this.jws.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
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
                a.b(a.this.jwn, length, 30);
                a.this.cHz();
            }
        });
        this.jwt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
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
                a.b(a.this.jwp, length, 200);
                a.this.cHz();
                if (a.this.jwt.getLineCount() > 6) {
                    a.this.jwt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.1
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
                    a.this.jwt.setOnTouchListener(null);
                }
            }
        });
    }

    private void cHu() {
        if (this.jwB == null && this.jwd != null) {
            this.jwB = new e(this.mPageContext, this.jwd);
            this.jwB.en(R.drawable.bg_tip_blue_up_left);
            this.jwB.em(16);
            this.jwB.pJ(true);
            this.jwB.setUseDirectOffset(true);
            this.jwB.eo(3000);
            this.jwB.xl(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jwB.aJ(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHv() {
        if (this.jwB != null) {
            this.jwB.Tz();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jwv != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cHJ().getText().toString().length() != 0 || bVar.cHK().getText().toString().length() != 0) {
                        a.this.D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.this.jwD.size() == 1) {
                                    a.this.jwC.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                                }
                                a.this.jwv.removeView(bVar.getRootView());
                                a.this.jwD.remove(bVar);
                                a.this.cHB();
                                a.this.cHA();
                                a.this.cHz();
                            }
                        });
                        return;
                    }
                    if (a.this.jwD.size() == 1) {
                        a.this.jwC.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                    a.this.jwv.removeView(bVar.getRootView());
                    a.this.jwD.remove(bVar);
                    a.this.cHB();
                    a.this.cHA();
                    a.this.cHz();
                }
            });
            bVar.a(new b.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                @Override // com.baidu.tieba.frs.forumRule.view.b.a
                public void cHI() {
                    a.this.cHz();
                }
            });
            this.jwv.addView(bVar.getRootView());
            this.jwD.add(bVar);
            if (this.jwD.indexOf(bVar) != -1) {
                bVar.zB(this.jwD.indexOf(bVar));
            }
            cHz();
            cHB();
            if (forumRuleItemPbData != null) {
                bVar.cHK().setText(forumRuleItemPbData.title);
                bVar.cHK().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cHJ = bVar.cHJ();
                                tbLinkSpanGroup.a(cHJ.getText(), cHJ.getSelectionEnd(), cHJ.getSelectionEnd(), (int) cHJ.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.BJ(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cHJ.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHJ().o(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHJ().o("\r\n");
                            }
                        }
                    }
                }
                bVar.cHJ().setSelection(bVar.cHJ().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cHK().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.cHJ().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.rj(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jwC.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz(int i) {
        if (i > 0) {
            this.jwm.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jws.getLayoutParams();
            layoutParams.width = -1;
            this.jws.setLayoutParams(layoutParams);
            return;
        }
        this.jwm.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jws.getLayoutParams();
        layoutParams2.width = -2;
        this.jws.setLayoutParams(layoutParams2);
    }

    private void cHw() {
        if (this.jws == null || this.jws.getText().toString().length() <= 30) {
            if (this.jwD != null && this.jwD.size() > 0) {
                for (int i = 0; i < this.jwD.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jwD.get(i);
                    EditText cHK = bVar.cHK();
                    SpanGroupEditText cHJ = bVar.cHJ();
                    if (cHK == null || cHK.getText().toString().trim().length() <= 30) {
                        if (cHJ != null && cHJ.getText().toString().length() > 300) {
                            KF(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zy(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        KF(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zy(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jwt == null || this.jwt.getText().toString().length() <= 200) {
                cHF();
                this.jvL.a(this.jwE, false);
                return;
            }
            KF(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        KF(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void KF(String str) {
        if (this.jwF == null || !this.jwF.isShown()) {
            this.jwF = new BdTopToast(this.mPageContext.getPageActivity(), 2000).zn(false).UZ(str);
            this.jwF.aR((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cHx() {
        if (this.jwz == null || this.jws == null || this.jws.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jwD != null && this.jwD.size() > 0) {
            for (int i = 0; i < this.jwD.size(); i++) {
                b bVar = this.jwD.get(i);
                EditText cHK = bVar.cHK();
                SpanGroupEditText cHJ = bVar.cHJ();
                if (cHK == null || cHK.getText().toString().trim().length() <= 0 || cHJ == null || cHJ.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        if (z) {
            this.jwt.setText("");
            this.jwe.setVisibility(0);
            this.jww.setVisibility(8);
            return;
        }
        this.jwt.setText("");
        this.jwe.setVisibility(8);
        this.jww.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jwt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHy() {
        cHF();
        if (this.jwE != null) {
            if (this.jwE.getTitle().length() > 50) {
                cHD();
                KF(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jwE.getList() != null) {
                for (int i = 0; i < this.jwE.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jwE.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cHD();
                            KF(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cHD();
                            KF(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jwE.getPreface().length() > 600) {
                cHD();
                KF(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jvL.a(this.jwE, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHz() {
        if (this.jwz != null) {
            if (cHx()) {
                this.jwz.setEnabled(true);
            } else {
                this.jwz.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHA() {
        if (this.jwD != null && this.jwD.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jwD.size()) {
                    this.jwD.get(i2).zB(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHB() {
        if (this.jwD != null) {
            if (this.jwD.size() >= 16) {
                this.jwq.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.jwf.setEnabled(false);
                this.jwq.setEnabled(false);
                this.jwG = false;
                this.jwj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0105), ap.faO), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.br(this.jwf).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).ol(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jwq.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jwD.size())));
            this.jwf.setEnabled(true);
            this.jwq.setEnabled(true);
            this.jwG = true;
            this.jwj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwf).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).ol(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
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

    public void cHC() {
        if (this.ixP == null) {
            this.izB = new k(this.mPageContext.getPageActivity());
            this.izB.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.ixP = new i(this.mPageContext, this.izB);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.izB);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jwJ);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.izB);
            gVar2.a(this.jwK);
            arrayList.add(gVar2);
            this.izB.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cHD();
                }
            });
            this.izB.bw(arrayList);
        }
        cHE();
    }

    public void cHD() {
        if (this.ixP != null && this.ixP.isShowing()) {
            this.ixP.dismiss();
        }
    }

    public void cHE() {
        if (this.ixP != null && this.jvZ != null && !this.jvZ.isFinishing()) {
            this.ixP.QE();
        }
    }

    private void cHF() {
        if (this.jwE == null) {
            this.jwE = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jwD != null && this.jwD.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jwD.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jwD.get(i2);
                EditText cHK = bVar.cHK();
                SpanGroupEditText cHJ = bVar.cHJ();
                if (cHK != null) {
                    forumRuleItemData.setTitle(cHK.getText().toString());
                }
                if (cHJ != null) {
                    forumRuleItemData.setContent(cHJ.getSpanGroupManager().bvc());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jwE.setTitle(this.jws.getText().toString());
        this.jwE.setPreface(this.jwt.getText().toString());
        this.jwE.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jwA) {
            cHC();
        } else if (view == this.jwz) {
            cHw();
        } else if (view == this.jwy) {
            cHF();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.jvW, this.jvX, this.jwE, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.jvY, this.jwH)));
        } else if (view == this.jwd) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.jvX, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.jwm) {
            cHH();
        } else if (view == this.jww) {
            rk(true);
        } else if (view == this.jwf) {
            a(true, null, false);
        } else if (view == this.jwi) {
            cHG();
        } else if (view == this.jwu || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jws);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jwt);
        }
    }

    private void cHG() {
        if (TextUtils.isEmpty(this.jwt.getText().toString())) {
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

    private void cHH() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.jvX, au.getDateStringMouth(new Date()));
        this.jws.setText(format);
        this.jws.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jws.getLayoutParams();
        layoutParams.width = -1;
        this.jws.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwu).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwl).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwa).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwb).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwc).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwn).nY(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwp).nY(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwm).nY(R.color.CAM_X0304).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwo).nY(R.color.CAM_X0107).oa(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwr).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwA).od(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwy).od(R.color.CAM_X0302).nZ(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwz).nZ(R.dimen.T_X05);
            this.jwz.setTextColor(ap.aM(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jwq.setTextColor(ap.aM(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jws.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jws.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwt.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jwt.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jwg.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jwh.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jwi.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jwk.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jwG) {
                this.jwj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.jwj.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0304), ap.faN), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.izB != null) {
                this.izB.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jws, R.drawable.edittext_cursor);
                j.h(this.jwt, R.drawable.edittext_cursor);
            } else {
                j.h(this.jws, R.drawable.edittext_cursor_1);
                j.h(this.jwt, R.drawable.edittext_cursor_1);
            }
            this.jwx.changeSkin(i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jwf).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).ol(this.jwG ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jww).oj(R.color.CAM_X0902).ok(R.dimen.L_X02).og(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void b(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.mRootView != null && forumRuleBaseData != null) {
            this.jws.setText(forumRuleBaseData.getTitle());
            this.jws.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jwt.setText(forumRuleBaseData.getPreface());
            this.jwt.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jwD.get(0);
                this.jwv.removeView(bVar.getRootView());
                this.jwD.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jwD.size() > 0) {
                b bVar2 = this.jwD.get(0);
                this.jwv.removeView(bVar2.getRootView());
                this.jwD.remove(bVar2);
                cHB();
                cHA();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        if (i == 0 && !this.jwI) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.jwt);
                this.jwI = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.jwt);
                this.jwI = true;
            }
        } else if (this.jwI) {
            this.jwI = false;
            com.baidu.tieba.frs.forumRule.d.a.a(0, 0, this.jwt);
        }
    }

    public void onDestory() {
        this.jwF = null;
        this.jwE = null;
        this.jvL = null;
        this.jvZ = null;
        cHD();
        this.ixP = null;
        this.izB = null;
    }
}
