package com.baidu.tieba.frs.forumRule.view;

import android.graphics.drawable.ShapeDrawable;
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
import com.baidu.tieba.d.e;
import com.baidu.tieba.frs.forumRule.ForumRulesEditActivity;
import com.baidu.tieba.frs.forumRule.view.b;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.tieba.write.j;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes22.dex */
public class a implements View.OnClickListener {
    private i ikf;
    private k ilP;
    private com.baidu.tieba.frs.forumRule.b.b jhX;
    private EMTextView jiA;
    private EMTextView jiB;
    private EMTextView jiC;
    private EMTextView jiD;
    private EMTextView jiE;
    private EditText jiF;
    private EditText jiG;
    private LinearLayout jiH;
    private LinearLayout jiI;
    private LinearLayout jiJ;
    private LinearLayout jiK;
    private TextView jiL;
    private TextView jiM;
    private TextView jiN;
    private e jiO;
    private EditorScrollView jiP;
    private BdTopToast jiS;
    private int jiU;
    private final String jij;
    private final String jik;
    private final String jil;
    private ForumRulesEditActivity jim;
    private View jin;
    private View jio;
    private View jip;
    private RelativeLayout jiq;
    private RelativeLayout jir;
    private RelativeLayout jis;
    private ImageView jit;
    private ImageView jiu;
    private ImageView jiv;
    private ImageView jiw;
    private ImageView jix;
    private EMTextView jiy;
    private EMTextView jiz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jiQ = new ArrayList();
    private ForumRuleBaseData jiR = new ForumRuleBaseData();
    private boolean jiT = true;
    private boolean jiV = false;
    private k.b jiW = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cGW();
        }
    };
    private k.b jiX = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHb();
            if (a.this.jim != null) {
                a.this.jim.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.b.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.jij = str;
        this.jik = str2;
        this.jil = str4;
        this.jiU = i;
        this.jim = forumRulesEditActivity;
        this.jhX = bVar;
        h(view, str3);
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jiH = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jiP = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.jit = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.jiq = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.jiu = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.jiy = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.jin = view.findViewById(R.id.forum_to_copy_divider);
        this.jiF = (EditText) view.findViewById(R.id.et_big_title);
        this.jiz = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.jiA = (EMTextView) view.findViewById(R.id.title_number);
        this.jio = view.findViewById(R.id.forum_title_divider);
        this.jiB = (EMTextView) view.findViewById(R.id.preface_title);
        this.jir = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.jiv = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jiG = (EditText) view.findViewById(R.id.preface_content);
        this.jiC = (EMTextView) view.findViewById(R.id.preface_number);
        this.jip = view.findViewById(R.id.preface_divider);
        this.jiJ = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jiI = (LinearLayout) view.findViewById(R.id.ll_default_rule);
        this.jis = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jiD = (EMTextView) view.findViewById(R.id.create_rule);
        this.jiw = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jiK = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jiE = (EMTextView) view.findViewById(R.id.add_preface);
        this.jix = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jiN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jiN.setId(R.id.negative_feedback_view);
        this.jiN.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jiL = new EMTextView(this.mPageContext.getPageActivity());
        this.jiL.setText(this.mPageContext.getString(R.string.video_preview));
        this.jiL.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jiL.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jiL.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiL, this);
        this.jiM = new EMTextView(this.mPageContext.getPageActivity());
        this.jiM.setText(this.mPageContext.getString(R.string.push_commit));
        this.jiM.setEnabled(false);
        this.jiM.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jiM.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jiM.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiM, this);
        cGR();
        initListener();
        cGS();
        a(false, null, false);
    }

    private void initListener() {
        this.jiq.setOnClickListener(this);
        this.jiz.setOnClickListener(this);
        this.jiK.setOnClickListener(this);
        this.jis.setOnClickListener(this);
        this.jiv.setOnClickListener(this);
        this.jiH.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.jiA, 0, 30);
        b(this.jiC, 0, 200);
        this.jiP.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cGT();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jiF);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jiG);
            }
        });
        this.jiF.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.AI(length);
                a.b(a.this.jiA, length, 30);
                a.this.cGX();
            }
        });
        this.jiG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.toString().length();
                a.this.AJ(length);
                a.b(a.this.jiC, length, 200);
                a.this.cGX();
                if (a.this.jiG.getLineCount() > 6) {
                    a.this.jiG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.5.1
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
                    a.this.jiG.setOnTouchListener(null);
                }
            }
        });
    }

    private void cGR() {
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_one_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_one_content));
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_two_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_two_content));
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_three_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_three_content));
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_four_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_four_content));
    }

    private void eY(String str, String str2) {
        EMTextView eMTextView = new EMTextView(this.mPageContext.getContext());
        eMTextView.setText(str);
        if (this.jiI != null) {
            this.jiI.addView(eMTextView);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eMTextView.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X008);
        eMTextView.setLayoutParams(marginLayoutParams);
        EMTextView eMTextView2 = new EMTextView(this.mPageContext.getContext());
        eMTextView2.setText(str2);
        if (this.jiI != null) {
            this.jiI.addView(eMTextView2);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) eMTextView2.getLayoutParams();
        marginLayoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        eMTextView2.setLayoutParams(marginLayoutParams2);
    }

    private void cGS() {
        if (this.jiO == null && this.jiq != null) {
            this.jiO = new e(this.mPageContext, this.jiq);
            this.jiO.fO(R.drawable.bg_tip_blue_up_left);
            this.jiO.fN(16);
            this.jiO.pf(true);
            this.jiO.setUseDirectOffset(true);
            this.jiO.fP(3000);
            this.jiO.yt(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jiO.aP(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGT() {
        if (this.jiO != null) {
            this.jiO.UG();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jiJ != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cHh().getText().toString().length() == 0 && bVar.cHi().getText().toString().length() == 0) {
                        if (a.this.jiQ.size() == 1) {
                            a.this.jiP.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                        }
                        a.this.jiJ.removeView(bVar.getRootView());
                        a.this.jiQ.remove(bVar);
                        a.this.cGZ();
                        a.this.cGY();
                        a.this.cGX();
                        return;
                    }
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(a.this.mPageContext.getPageActivity());
                    aVar.oT(2);
                    aVar.jm(false);
                    ForumRuleDelItemDialogView forumRuleDelItemDialogView = new ForumRuleDelItemDialogView(a.this.mPageContext.getPageActivity());
                    forumRuleDelItemDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (aVar != null) {
                                aVar.dismiss();
                            }
                        }
                    });
                    forumRuleDelItemDialogView.setpostButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            if (a.this.jiQ.size() == 1) {
                                a.this.jiP.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                            }
                            a.this.jiJ.removeView(bVar.getRootView());
                            a.this.jiQ.remove(bVar);
                            a.this.cGZ();
                            a.this.cGY();
                            a.this.cGX();
                            if (aVar != null) {
                                aVar.dismiss();
                            }
                        }
                    });
                    aVar.bi(forumRuleDelItemDialogView);
                    aVar.b(a.this.mPageContext).brv();
                }
            });
            bVar.a(new b.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.7
                @Override // com.baidu.tieba.frs.forumRule.view.b.a
                public void cHg() {
                    a.this.cGX();
                }
            });
            this.jiJ.addView(bVar.getRootView());
            this.jiQ.add(bVar);
            if (this.jiQ.indexOf(bVar) != -1) {
                bVar.AK(this.jiQ.indexOf(bVar));
            }
            cGX();
            cGZ();
            if (forumRuleItemPbData != null) {
                bVar.cHi().setText(forumRuleItemPbData.title);
                bVar.cHi().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cHh = bVar.cHh();
                                tbLinkSpanGroup.a(cHh.getText(), cHh.getSelectionEnd(), cHh.getSelectionEnd(), (int) cHh.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.CG(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cHh.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHh().p(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHh().p("\r\n");
                            }
                        }
                    }
                }
                bVar.cHh().setSelection(bVar.cHh().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cHi().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.cHh().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.qF(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jiP.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(int i) {
        if (i > 0) {
            this.jiz.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jiF.getLayoutParams();
            layoutParams.width = -1;
            this.jiF.setLayoutParams(layoutParams);
            return;
        }
        this.jiz.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jiF.getLayoutParams();
        layoutParams2.width = -2;
        this.jiF.setLayoutParams(layoutParams2);
    }

    private void cGU() {
        if (this.jiF == null || this.jiF.getText().toString().length() <= 30) {
            if (this.jiQ != null && this.jiQ.size() > 0) {
                for (int i = 0; i < this.jiQ.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jiQ.get(i);
                    EditText cHi = bVar.cHi();
                    SpanGroupEditText cHh = bVar.cHh();
                    if (cHi == null || cHi.getText().toString().trim().length() <= 30) {
                        if (cHh != null && cHh.getText().toString().length() > 300) {
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), bVar.AM(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), bVar.AM(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jiG == null || this.jiG.getText().toString().length() <= 200) {
                cHd();
                this.jhX.a(this.jiR, false);
                return;
            }
            Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void Le(String str) {
        if (this.jiS == null || !this.jiS.isShown()) {
            this.jiS = new BdTopToast(this.mPageContext.getPageActivity(), 2000).yW(false).Vt(str);
            this.jiS.aF((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cGV() {
        if (this.jiM == null || this.jiF == null || this.jiF.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jiQ != null && this.jiQ.size() > 0) {
            for (int i = 0; i < this.jiQ.size(); i++) {
                b bVar = this.jiQ.get(i);
                EditText cHi = bVar.cHi();
                SpanGroupEditText cHh = bVar.cHh();
                if (cHi == null || cHi.getText().toString().trim().length() <= 0 || cHh == null || cHh.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (z) {
            this.jiG.setText("");
            this.jir.setVisibility(0);
            this.jiK.setVisibility(8);
            return;
        }
        this.jiG.setText("");
        this.jir.setVisibility(8);
        this.jiK.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jiG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGW() {
        cHd();
        if (this.jiR != null) {
            if (this.jiR.getTitle().length() > 50) {
                cHb();
                Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jiR.getList() != null) {
                for (int i = 0; i < this.jiR.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jiR.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cHb();
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cHb();
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jiR.getPreface().length() > 600) {
                cHb();
                Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jhX.a(this.jiR, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGX() {
        if (this.jiM != null) {
            if (cGV()) {
                this.jiM.setEnabled(true);
            } else {
                this.jiM.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGY() {
        if (this.jiQ != null && this.jiQ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jiQ.size()) {
                    this.jiQ.get(i2).AK(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGZ() {
        if (this.jiQ != null) {
            if (this.jiQ.size() >= 16) {
                this.jiD.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.jis.setEnabled(false);
                this.jiD.setEnabled(false);
                this.jiT = false;
                this.jiw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0105), ap.eTL), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.bm(this.jis).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).pE(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jiD.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jiQ.size())));
            this.jis.setEnabled(true);
            this.jiD.setEnabled(true);
            this.jiT = true;
            this.jiw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jis).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).pE(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
        }
    }

    public static void b(TextView textView, int i, int i2) {
        textView.setText(i + "/" + i2);
        if (i > i2) {
            com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0301);
        } else {
            com.baidu.tbadk.core.elementsMaven.c.bm(textView).ps(R.color.CAM_X0111);
        }
    }

    public void cHa() {
        if (this.ikf == null) {
            this.ilP = new k(this.mPageContext.getPageActivity());
            this.ilP.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.ikf = new i(this.mPageContext, this.ilP);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.ilP);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jiW);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.ilP);
            gVar2.a(this.jiX);
            arrayList.add(gVar2);
            this.ilP.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cHb();
                }
            });
            this.ilP.bu(arrayList);
        }
        cHc();
    }

    public void cHb() {
        if (this.ikf != null && this.ikf.isShowing()) {
            this.ikf.dismiss();
        }
    }

    public void cHc() {
        if (this.ikf != null && this.jim != null && !this.jim.isFinishing()) {
            this.ikf.RU();
        }
    }

    private void cHd() {
        if (this.jiR == null) {
            this.jiR = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jiQ != null && this.jiQ.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jiQ.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jiQ.get(i2);
                EditText cHi = bVar.cHi();
                SpanGroupEditText cHh = bVar.cHh();
                if (cHi != null) {
                    forumRuleItemData.setTitle(cHi.getText().toString());
                }
                if (cHh != null) {
                    forumRuleItemData.setContent(cHh.getSpanGroupManager().bwi());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jiR.setTitle(this.jiF.getText().toString());
        this.jiR.setPreface(this.jiG.getText().toString());
        this.jiR.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiN) {
            cHa();
        } else if (view == this.jiM) {
            cGU();
        } else if (view == this.jiL) {
            cHd();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.jij, this.jik, this.jiR, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.jil, this.jiU)));
        } else if (view == this.jiq) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.jik, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.jiz) {
            cHf();
        } else if (view == this.jiK) {
            qG(true);
        } else if (view == this.jis) {
            a(true, null, false);
        } else if (view == this.jiv) {
            cHe();
        } else if (view == this.jiH || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jiF);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jiG);
        }
    }

    private void cHe() {
        if (TextUtils.isEmpty(this.jiG.getText().toString())) {
            qG(false);
            return;
        }
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mPageContext.getPageActivity());
        aVar.oT(2);
        aVar.jm(false);
        ForumRuleDelItemDialogView forumRuleDelItemDialogView = new ForumRuleDelItemDialogView(this.mPageContext.getPageActivity());
        forumRuleDelItemDialogView.setConfirmButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        forumRuleDelItemDialogView.setpostButtonListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.qG(false);
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.bi(forumRuleDelItemDialogView);
        aVar.b(this.mPageContext).brv();
    }

    private void cHf() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.jik, au.getDateStringMouth(new Date()));
        this.jiF.setText(format);
        this.jiF.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jiF.getLayoutParams();
        layoutParams.width = -1;
        this.jiF.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiH).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiy).ps(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jin).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jio).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jip).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiA).ps(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiC).ps(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiz).ps(R.color.CAM_X0304).pu(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiB).ps(R.color.CAM_X0107).pu(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiE).ps(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiN).px(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiL).px(R.color.CAM_X0302).pt(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiM).pt(R.dimen.T_X05);
            this.jiM.setTextColor(ap.aS(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jiD.setTextColor(ap.aS(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jiF.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jiF.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jiG.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jiG.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jit.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jiu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jiv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jix.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jiT) {
                this.jiw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.jiw.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0304), ap.eTK), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.ilP != null) {
                this.ilP.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jiF, R.drawable.edittext_cursor);
                j.h(this.jiG, R.drawable.edittext_cursor);
            } else {
                j.h(this.jiF, R.drawable.edittext_cursor_1);
                j.h(this.jiG, R.drawable.edittext_cursor_1);
            }
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jis).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).pE(this.jiT ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiK).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
            if (this.jiI != null && this.jiI.getChildCount() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < this.jiI.getChildCount()) {
                        EMTextView eMTextView = (EMTextView) this.jiI.getChildAt(i3);
                        if (i3 % 2 != 0) {
                            com.baidu.tbadk.core.elementsMaven.c.bm(eMTextView).ps(R.color.CAM_X0107).pv(R.dimen.M_T_X003);
                        } else {
                            com.baidu.tbadk.core.elementsMaven.c.bm(eMTextView).ps(R.color.CAM_X0107).pu(R.string.F_X02);
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void b(ForumRuleBaseData forumRuleBaseData, boolean z) {
        if (this.mRootView != null && forumRuleBaseData != null) {
            this.jiF.setText(forumRuleBaseData.getTitle());
            this.jiF.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jiG.setText(forumRuleBaseData.getPreface());
            this.jiG.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jiQ.get(0);
                this.jiJ.removeView(bVar.getRootView());
                this.jiQ.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jiQ.size() > 0) {
                b bVar2 = this.jiQ.get(0);
                this.jiJ.removeView(bVar2.getRootView());
                this.jiQ.remove(bVar2);
                cGZ();
                cGY();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(int i) {
        if (i == 0 && !this.jiV) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                cv(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20));
                this.jiV = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                cv(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20));
                this.jiV = true;
            }
        } else if (this.jiV) {
            this.jiV = false;
            cv(0, 0);
        }
    }

    private void cv(int i, int i2) {
        try {
            Method declaredMethod = TextView.class.getDeclaredMethod("createEditorIfNeeded", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.jiG, new Object[0]);
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mCursorDrawable");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(declaredField.get(this.jiG));
            Array.set(obj, 0, new C0743a(ap.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i, i2));
            Array.set(obj, 1, new C0743a(ap.getColor(R.color.CAM_X0302), UtilHelper.getDimenPixelSize(R.dimen.tbds5), i, i2));
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.frs.forumRule.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C0743a extends ShapeDrawable {
        private int mBottomOffset;
        private int mTopOffset;

        public C0743a(int i, int i2, int i3, int i4) {
            this.mTopOffset = i3;
            this.mBottomOffset = i4;
            setDither(false);
            getPaint().setColor(i);
            setIntrinsicWidth(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, this.mTopOffset + i2, i3, this.mBottomOffset + i4);
        }
    }

    public void onDestory() {
        this.jiS = null;
        this.jiR = null;
        this.jhX = null;
        this.jim = null;
        cHb();
        this.ikf = null;
        this.ilP = null;
    }
}
