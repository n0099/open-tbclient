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
    private k iBk;
    private i izy;
    private final String jxF;
    private final String jxG;
    private final String jxH;
    private ForumRulesEditActivity jxI;
    private View jxJ;
    private View jxK;
    private View jxL;
    private RelativeLayout jxM;
    private RelativeLayout jxN;
    private RelativeLayout jxO;
    private ImageView jxP;
    private ImageView jxQ;
    private ImageView jxR;
    private ImageView jxS;
    private ImageView jxT;
    private EMTextView jxU;
    private EMTextView jxV;
    private EMTextView jxW;
    private EMTextView jxX;
    private EMTextView jxY;
    private EMTextView jxZ;
    private com.baidu.tieba.frs.forumRule.a.b jxu;
    private EMTextView jya;
    private EditText jyb;
    private EditText jyc;
    private LinearLayout jyd;
    private LinearLayout jye;
    private LinearLayout jyf;
    private ForumRuleDafultItemView jyg;
    private TextView jyh;
    private TextView jyi;
    private TextView jyj;
    private e jyk;
    private EditorScrollView jyl;
    private BdTopToast jyo;
    private int jyq;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jym = new ArrayList();
    private ForumRuleBaseData jyn = new ForumRuleBaseData();
    private boolean jyp = true;
    private boolean jyr = false;
    private k.b jys = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHE();
        }
    };
    private k.b jyt = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.12
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHJ();
            if (a.this.jxI != null) {
                a.this.jxI.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.a.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.jxF = str;
        this.jxG = str2;
        this.jxH = str4;
        this.jyq = i;
        this.jxI = forumRulesEditActivity;
        this.jxu = bVar;
        i(view, str3);
    }

    private void i(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jyd = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jyl = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.jxP = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.jxM = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.jxQ = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.jxU = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.jxJ = view.findViewById(R.id.forum_to_copy_divider);
        this.jyb = (EditText) view.findViewById(R.id.et_big_title);
        this.jxV = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.jxW = (EMTextView) view.findViewById(R.id.title_number);
        this.jxK = view.findViewById(R.id.forum_title_divider);
        this.jxX = (EMTextView) view.findViewById(R.id.preface_title);
        this.jxN = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.jxR = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jyc = (EditText) view.findViewById(R.id.preface_content);
        this.jxY = (EMTextView) view.findViewById(R.id.preface_number);
        this.jxL = view.findViewById(R.id.preface_divider);
        this.jye = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jyg = (ForumRuleDafultItemView) view.findViewById(R.id.ll_default_rule);
        this.jxO = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jxZ = (EMTextView) view.findViewById(R.id.create_rule);
        this.jxS = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jyf = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jya = (EMTextView) view.findViewById(R.id.add_preface);
        this.jxT = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jyj = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jyj.setId(R.id.negative_feedback_view);
        this.jyj.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jyh = new EMTextView(this.mPageContext.getPageActivity());
        this.jyh.setText(this.mPageContext.getString(R.string.video_preview));
        this.jyh.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jyh.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jyh.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jyh, this);
        this.jyi = new EMTextView(this.mPageContext.getPageActivity());
        this.jyi.setText(this.mPageContext.getString(R.string.push_commit));
        this.jyi.setEnabled(false);
        this.jyi.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jyi.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jyi.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jyi, this);
        initListener();
        cHA();
        a(false, null, false);
    }

    private void initListener() {
        this.jxM.setOnClickListener(this);
        this.jxV.setOnClickListener(this);
        this.jyf.setOnClickListener(this);
        this.jxO.setOnClickListener(this);
        this.jxR.setOnClickListener(this);
        this.jyd.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.jxW, 0, 30);
        b(this.jxY, 0, 200);
        this.jyl.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cHB();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jyb);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jyc);
            }
        });
        this.jyb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
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
                a.b(a.this.jxW, length, 30);
                a.this.cHF();
            }
        });
        this.jyc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.zB(length);
                a.b(a.this.jxY, length, 200);
                a.this.cHF();
                if (a.this.jyc.getLineCount() > 6) {
                    a.this.jyc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.1
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
                    a.this.jyc.setOnTouchListener(null);
                }
            }
        });
    }

    private void cHA() {
        if (this.jyk == null && this.jxM != null) {
            this.jyk = new e(this.mPageContext, this.jxM);
            this.jyk.eo(R.drawable.bg_tip_blue_up_left);
            this.jyk.en(16);
            this.jyk.pJ(true);
            this.jyk.setUseDirectOffset(true);
            this.jyk.ep(3000);
            this.jyk.xm(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jyk.aJ(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHB() {
        if (this.jyk != null) {
            this.jyk.TC();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jye != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cHP().getText().toString().length() != 0 || bVar.cHQ().getText().toString().length() != 0) {
                        a.this.D(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.7.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                if (a.this.jym.size() == 1) {
                                    a.this.jyl.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                                }
                                a.this.jye.removeView(bVar.getRootView());
                                a.this.jym.remove(bVar);
                                a.this.cHH();
                                a.this.cHG();
                                a.this.cHF();
                            }
                        });
                        return;
                    }
                    if (a.this.jym.size() == 1) {
                        a.this.jyl.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                    a.this.jye.removeView(bVar.getRootView());
                    a.this.jym.remove(bVar);
                    a.this.cHH();
                    a.this.cHG();
                    a.this.cHF();
                }
            });
            bVar.a(new b.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                @Override // com.baidu.tieba.frs.forumRule.view.b.a
                public void cHO() {
                    a.this.cHF();
                }
            });
            this.jye.addView(bVar.getRootView());
            this.jym.add(bVar);
            if (this.jym.indexOf(bVar) != -1) {
                bVar.zC(this.jym.indexOf(bVar));
            }
            cHF();
            cHH();
            if (forumRuleItemPbData != null) {
                bVar.cHQ().setText(forumRuleItemPbData.title);
                bVar.cHQ().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cHP = bVar.cHP();
                                tbLinkSpanGroup.a(cHP.getText(), cHP.getSelectionEnd(), cHP.getSelectionEnd(), (int) cHP.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.BQ(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cHP.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHP().o(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHP().o("\r\n");
                            }
                        }
                    }
                }
                bVar.cHP().setSelection(bVar.cHP().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cHQ().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.cHP().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.rj(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jyl.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        if (i > 0) {
            this.jxV.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jyb.getLayoutParams();
            layoutParams.width = -1;
            this.jyb.setLayoutParams(layoutParams);
            return;
        }
        this.jxV.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jyb.getLayoutParams();
        layoutParams2.width = -2;
        this.jyb.setLayoutParams(layoutParams2);
    }

    private void cHC() {
        if (this.jyb == null || this.jyb.getText().toString().length() <= 30) {
            if (this.jym != null && this.jym.size() > 0) {
                for (int i = 0; i < this.jym.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jym.get(i);
                    EditText cHQ = bVar.cHQ();
                    SpanGroupEditText cHP = bVar.cHP();
                    if (cHQ == null || cHQ.getText().toString().trim().length() <= 30) {
                        if (cHP != null && cHP.getText().toString().length() > 300) {
                            KO(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zz(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        KO(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), com.baidu.tieba.frs.forumRule.d.a.zz(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jyc == null || this.jyc.getText().toString().length() <= 200) {
                cHL();
                this.jxu.a(this.jyn, false);
                return;
            }
            KO(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        KO(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void KO(String str) {
        if (this.jyo == null || !this.jyo.isShown()) {
            this.jyo = new BdTopToast(this.mPageContext.getPageActivity(), 2000).zm(false).Vg(str);
            this.jyo.aR((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cHD() {
        if (this.jyi == null || this.jyb == null || this.jyb.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jym != null && this.jym.size() > 0) {
            for (int i = 0; i < this.jym.size(); i++) {
                b bVar = this.jym.get(i);
                EditText cHQ = bVar.cHQ();
                SpanGroupEditText cHP = bVar.cHP();
                if (cHQ == null || cHQ.getText().toString().trim().length() <= 0 || cHP == null || cHP.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk(boolean z) {
        if (z) {
            this.jyc.setText("");
            this.jxN.setVisibility(0);
            this.jyf.setVisibility(8);
            return;
        }
        this.jyc.setText("");
        this.jxN.setVisibility(8);
        this.jyf.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jyc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHE() {
        cHL();
        if (this.jyn != null) {
            if (this.jyn.getTitle().length() > 50) {
                cHJ();
                KO(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jyn.getList() != null) {
                for (int i = 0; i < this.jyn.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jyn.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cHJ();
                            KO(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cHJ();
                            KO(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jyn.getPreface().length() > 600) {
                cHJ();
                KO(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jxu.a(this.jyn, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHF() {
        if (this.jyi != null) {
            if (cHD()) {
                this.jyi.setEnabled(true);
            } else {
                this.jyi.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHG() {
        if (this.jym != null && this.jym.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jym.size()) {
                    this.jym.get(i2).zC(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHH() {
        if (this.jym != null) {
            if (this.jym.size() >= 16) {
                this.jxZ.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.jxO.setEnabled(false);
                this.jxZ.setEnabled(false);
                this.jyp = false;
                this.jxS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0105), ap.fcn), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.br(this.jxO).ok(R.color.CAM_X0902).ol(R.dimen.L_X02).oh(R.string.J_X07).om(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jxZ.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jym.size())));
            this.jxO.setEnabled(true);
            this.jxZ.setEnabled(true);
            this.jyp = true;
            this.jxS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxO).ok(R.color.CAM_X0902).ol(R.dimen.L_X02).oh(R.string.J_X07).om(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public static void b(TextView textView, int i, int i2) {
        textView.setText(i + "/" + i2);
        if (i > i2) {
            com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0301);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.br(textView).nZ(R.color.CAM_X0111);
        }
    }

    public void cHI() {
        if (this.izy == null) {
            this.iBk = new k(this.mPageContext.getPageActivity());
            this.iBk.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.izy = new i(this.mPageContext, this.iBk);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.iBk);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jys);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.iBk);
            gVar2.a(this.jyt);
            arrayList.add(gVar2);
            this.iBk.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cHJ();
                }
            });
            this.iBk.bw(arrayList);
        }
        cHK();
    }

    public void cHJ() {
        if (this.izy != null && this.izy.isShowing()) {
            this.izy.dismiss();
        }
    }

    public void cHK() {
        if (this.izy != null && this.jxI != null && !this.jxI.isFinishing()) {
            this.izy.QH();
        }
    }

    private void cHL() {
        if (this.jyn == null) {
            this.jyn = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jym != null && this.jym.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jym.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jym.get(i2);
                EditText cHQ = bVar.cHQ();
                SpanGroupEditText cHP = bVar.cHP();
                if (cHQ != null) {
                    forumRuleItemData.setTitle(cHQ.getText().toString());
                }
                if (cHP != null) {
                    forumRuleItemData.setContent(cHP.getSpanGroupManager().bvf());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jyn.setTitle(this.jyb.getText().toString());
        this.jyn.setPreface(this.jyc.getText().toString());
        this.jyn.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jyj) {
            cHI();
        } else if (view == this.jyi) {
            cHC();
        } else if (view == this.jyh) {
            cHL();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.jxF, this.jxG, this.jyn, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.jxH, this.jyq)));
        } else if (view == this.jxM) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.jxG, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.jxV) {
            cHN();
        } else if (view == this.jyf) {
            rk(true);
        } else if (view == this.jxO) {
            a(true, null, false);
        } else if (view == this.jxR) {
            cHM();
        } else if (view == this.jyd || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jyb);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jyc);
        }
    }

    private void cHM() {
        if (TextUtils.isEmpty(this.jyc.getText().toString())) {
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
        aVar.nB(2);
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
        aVar.b(this.mPageContext).bqz();
    }

    private void cHN() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.jxG, au.getDateStringMouth(new Date()));
        this.jyb.setText(format);
        this.jyb.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jyb.getLayoutParams();
        layoutParams.width = -1;
        this.jyb.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyd).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxU).nZ(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxJ).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxK).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxL).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxW).nZ(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxY).nZ(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxV).nZ(R.color.CAM_X0304).ob(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxX).nZ(R.color.CAM_X0107).ob(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jya).nZ(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyj).oe(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyh).oe(R.color.CAM_X0302).oa(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyi).oa(R.dimen.T_X05);
            this.jyi.setTextColor(ap.aM(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jxZ.setTextColor(ap.aM(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jyb.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jyb.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jyc.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jyc.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jxP.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jxQ.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jxR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jxT.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jyp) {
                this.jxS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.jxS.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0304), ap.fcm), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.iBk != null) {
                this.iBk.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jyb, R.drawable.edittext_cursor);
                j.h(this.jyc, R.drawable.edittext_cursor);
            } else {
                j.h(this.jyb, R.drawable.edittext_cursor_1);
                j.h(this.jyc, R.drawable.edittext_cursor_1);
            }
            this.jyg.changeSkin(i);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jxO).ok(R.color.CAM_X0902).ol(R.dimen.L_X02).oh(R.string.J_X07).om(this.jyp ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jyf).ok(R.color.CAM_X0902).ol(R.dimen.L_X02).oh(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public void b(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.mRootView != null && forumRuleBaseData != null) {
            this.jyb.setText(forumRuleBaseData.getTitle());
            this.jyb.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jyc.setText(forumRuleBaseData.getPreface());
            this.jyc.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jym.get(0);
                this.jye.removeView(bVar.getRootView());
                this.jym.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jym.size() > 0) {
                b bVar2 = this.jym.get(0);
                this.jye.removeView(bVar2.getRootView());
                this.jym.remove(bVar2);
                cHH();
                cHG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zB(int i) {
        if (i == 0 && !this.jyr) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20), this.jyc);
                this.jyr = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                com.baidu.tieba.frs.forumRule.d.a.a(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20), this.jyc);
                this.jyr = true;
            }
        } else if (this.jyr) {
            this.jyr = false;
            com.baidu.tieba.frs.forumRule.d.a.a(0, 0, this.jyc);
        }
    }

    public void onDestory() {
        this.jyo = null;
        this.jyn = null;
        this.jxu = null;
        this.jxI = null;
        cHJ();
        this.izy = null;
        this.iBk = null;
    }
}
