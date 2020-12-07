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
    private i ikd;
    private k ilN;
    private com.baidu.tieba.frs.forumRule.b.b jhV;
    private EMTextView jiA;
    private EMTextView jiB;
    private EMTextView jiC;
    private EditText jiD;
    private EditText jiE;
    private LinearLayout jiF;
    private LinearLayout jiG;
    private LinearLayout jiH;
    private LinearLayout jiI;
    private TextView jiJ;
    private TextView jiK;
    private TextView jiL;
    private e jiM;
    private EditorScrollView jiN;
    private BdTopToast jiQ;
    private int jiS;
    private final String jih;
    private final String jii;
    private final String jij;
    private ForumRulesEditActivity jik;
    private View jil;
    private View jim;
    private View jin;
    private RelativeLayout jio;
    private RelativeLayout jip;
    private RelativeLayout jiq;
    private ImageView jir;
    private ImageView jis;
    private ImageView jit;
    private ImageView jiu;
    private ImageView jiv;
    private EMTextView jiw;
    private EMTextView jix;
    private EMTextView jiy;
    private EMTextView jiz;
    private NavigationBar mNavigationBar;
    private final TbPageContext<?> mPageContext;
    private View mRootView;
    private List<b> jiO = new ArrayList();
    private ForumRuleBaseData jiP = new ForumRuleBaseData();
    private boolean jiR = true;
    private boolean jiT = false;
    private k.b jiU = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.10
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cGV();
        }
    };
    private k.b jiV = new k.b() { // from class: com.baidu.tieba.frs.forumRule.view.a.11
        @Override // com.baidu.tbadk.core.dialog.k.b
        public void onClick() {
            a.this.cHa();
            if (a.this.jik != null) {
                a.this.jik.finish();
            }
        }
    };

    public a(TbPageContext<?> tbPageContext, com.baidu.tieba.frs.forumRule.b.b bVar, View view, String str, String str2, String str3, String str4, int i, ForumRulesEditActivity forumRulesEditActivity) {
        this.mPageContext = tbPageContext;
        this.jih = str;
        this.jii = str2;
        this.jij = str4;
        this.jiS = i;
        this.jik = forumRulesEditActivity;
        this.jhV = bVar;
        h(view, str3);
    }

    private void h(View view, String str) {
        this.mRootView = view;
        this.mNavigationBar = (NavigationBar) view.findViewById(R.id.navi_forumrule_title);
        this.jiF = (LinearLayout) view.findViewById(R.id.rule_main_content);
        this.jiN = (EditorScrollView) view.findViewById(R.id.scrool_main);
        this.jir = (ImageView) view.findViewById(R.id.forum_copy_icon);
        this.jio = (RelativeLayout) view.findViewById(R.id.forum_to_copy_rl);
        this.jis = (ImageView) view.findViewById(R.id.forum_copy_arrow);
        this.jiw = (EMTextView) view.findViewById(R.id.forum_copy_title);
        this.jil = view.findViewById(R.id.forum_to_copy_divider);
        this.jiD = (EditText) view.findViewById(R.id.et_big_title);
        this.jix = (EMTextView) view.findViewById(R.id.tv_used_example);
        this.jiy = (EMTextView) view.findViewById(R.id.title_number);
        this.jim = view.findViewById(R.id.forum_title_divider);
        this.jiz = (EMTextView) view.findViewById(R.id.preface_title);
        this.jip = (RelativeLayout) view.findViewById(R.id.preface_bg);
        this.jit = (ImageView) view.findViewById(R.id.preface_del_icon);
        this.jiE = (EditText) view.findViewById(R.id.preface_content);
        this.jiA = (EMTextView) view.findViewById(R.id.preface_number);
        this.jin = view.findViewById(R.id.preface_divider);
        this.jiH = (LinearLayout) view.findViewById(R.id.ll_add_rule);
        this.jiG = (LinearLayout) view.findViewById(R.id.ll_default_rule);
        this.jiq = (RelativeLayout) view.findViewById(R.id.create_rule_btn);
        this.jiB = (EMTextView) view.findViewById(R.id.create_rule);
        this.jiu = (ImageView) view.findViewById(R.id.create_rule_icon);
        this.jiI = (LinearLayout) view.findViewById(R.id.add_preface_btn);
        this.jiC = (EMTextView) view.findViewById(R.id.add_preface);
        this.jiv = (ImageView) view.findViewById(R.id.add_preface_icon);
        this.jiL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, this.mPageContext.getString(R.string.dialog_cancel), null);
        this.jiL.setId(R.id.negative_feedback_view);
        this.jiL.setOnClickListener(this);
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getString(R.string.forum_rule_defalt_title_setting));
        this.jiJ = new EMTextView(this.mPageContext.getPageActivity());
        this.jiJ.setText(this.mPageContext.getString(R.string.video_preview));
        this.jiJ.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        this.jiJ.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0);
        this.jiJ.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiJ, this);
        this.jiK = new EMTextView(this.mPageContext.getPageActivity());
        this.jiK.setText(this.mPageContext.getString(R.string.push_commit));
        this.jiK.setEnabled(false);
        this.jiK.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams2.rightMargin = UtilHelper.getDimenPixelSize(R.dimen.M_W_X007);
        this.jiK.setPadding(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), 0, 0, 0);
        this.jiK.setLayoutParams(layoutParams2);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.jiK, this);
        cGQ();
        initListener();
        cGR();
        a(false, null, false);
    }

    private void initListener() {
        this.jio.setOnClickListener(this);
        this.jix.setOnClickListener(this);
        this.jiI.setOnClickListener(this);
        this.jiq.setOnClickListener(this);
        this.jit.setOnClickListener(this);
        this.jiF.setOnClickListener(this);
        this.mNavigationBar.setOnClickListener(this);
        b(this.jiy, 0, 30);
        b(this.jiA, 0, 200);
        this.jiN.setListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                a.this.cGS();
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jiD);
                l.hideSoftKeyPad(a.this.mPageContext.getPageActivity(), a.this.jiE);
            }
        });
        this.jiD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.4
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
                a.b(a.this.jiy, length, 30);
                a.this.cGW();
            }
        });
        this.jiE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.forumRule.view.a.5
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
                a.b(a.this.jiA, length, 200);
                a.this.cGW();
                if (a.this.jiE.getLineCount() > 6) {
                    a.this.jiE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.5.1
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
                    a.this.jiE.setOnTouchListener(null);
                }
            }
        });
    }

    private void cGQ() {
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_one_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_one_content));
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_two_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_two_content));
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_three_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_three_content));
        eY(this.mPageContext.getResources().getString(R.string.forum_rule_defalt_four_title), this.mPageContext.getResources().getString(R.string.forum_rule_defalt_four_content));
    }

    private void eY(String str, String str2) {
        EMTextView eMTextView = new EMTextView(this.mPageContext.getContext());
        eMTextView.setText(str);
        if (this.jiG != null) {
            this.jiG.addView(eMTextView);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) eMTextView.getLayoutParams();
        marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X008);
        eMTextView.setLayoutParams(marginLayoutParams);
        EMTextView eMTextView2 = new EMTextView(this.mPageContext.getContext());
        eMTextView2.setText(str2);
        if (this.jiG != null) {
            this.jiG.addView(eMTextView2);
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) eMTextView2.getLayoutParams();
        marginLayoutParams2.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X005);
        eMTextView2.setLayoutParams(marginLayoutParams2);
    }

    private void cGR() {
        if (this.jiM == null && this.jio != null) {
            this.jiM = new e(this.mPageContext, this.jio);
            this.jiM.fO(R.drawable.bg_tip_blue_up_left);
            this.jiM.fN(16);
            this.jiM.pf(true);
            this.jiM.setUseDirectOffset(true);
            this.jiM.fP(3000);
            this.jiM.yt(UtilHelper.getDimenPixelSize(R.dimen.tbds20));
            this.jiM.aP(this.mPageContext.getString(R.string.forum_rule_defalt_tocopy_tip), "key_forum_rule_first_edit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGS() {
        if (this.jiM != null) {
            this.jiM.UG();
        }
    }

    private void a(boolean z, ForumRuleBaseData.ForumRuleItemPbData forumRuleItemPbData, boolean z2) {
        if (this.jiH != null) {
            final b bVar = new b(this.mPageContext.getPageActivity());
            bVar.setClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.forumRule.view.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (bVar.cHg().getText().toString().length() == 0 && bVar.cHh().getText().toString().length() == 0) {
                        if (a.this.jiO.size() == 1) {
                            a.this.jiN.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                        }
                        a.this.jiH.removeView(bVar.getRootView());
                        a.this.jiO.remove(bVar);
                        a.this.cGY();
                        a.this.cGX();
                        a.this.cGW();
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
                            if (a.this.jiO.size() == 1) {
                                a.this.jiN.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                            }
                            a.this.jiH.removeView(bVar.getRootView());
                            a.this.jiO.remove(bVar);
                            a.this.cGY();
                            a.this.cGX();
                            a.this.cGW();
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
                public void cHf() {
                    a.this.cGW();
                }
            });
            this.jiH.addView(bVar.getRootView());
            this.jiO.add(bVar);
            if (this.jiO.indexOf(bVar) != -1) {
                bVar.AK(this.jiO.indexOf(bVar));
            }
            cGW();
            cGY();
            if (forumRuleItemPbData != null) {
                bVar.cHh().setText(forumRuleItemPbData.title);
                bVar.cHh().setSelection(forumRuleItemPbData.title != null ? forumRuleItemPbData.title.length() : 0);
                if (forumRuleItemPbData.mContent != null) {
                    for (int i = 0; i < forumRuleItemPbData.mContent.size(); i++) {
                        ForumRuleBaseData.ForumRuleItemPbContentData forumRuleItemPbContentData = forumRuleItemPbData.mContent.get(i);
                        if (forumRuleItemPbContentData != null) {
                            if ("a".equals(forumRuleItemPbContentData.tag)) {
                                TbLinkSpanGroup tbLinkSpanGroup = new TbLinkSpanGroup(TbLinkSpanGroup.LINK_TYPE.PARSED_EXTERNAL_LINK);
                                SpanGroupEditText cHg = bVar.cHg();
                                tbLinkSpanGroup.a(cHg.getText(), cHg.getSelectionEnd(), cHg.getSelectionEnd(), (int) cHg.getTextSize());
                                tbLinkSpanGroup.setUrl(forumRuleItemPbContentData.href);
                                tbLinkSpanGroup.CG(forumRuleItemPbContentData.value);
                                tbLinkSpanGroup.build();
                                cHg.getSpanGroupManager().a(tbLinkSpanGroup);
                            } else if ("plainText".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHg().p(forumRuleItemPbContentData.value);
                            } else if ("br".equals(forumRuleItemPbContentData.tag)) {
                                bVar.cHg().p("\r\n");
                            }
                        }
                    }
                }
                bVar.cHg().setSelection(bVar.cHg().getText().toString().length());
                if (z2 && "1".equals(forumRuleItemPbData.status)) {
                    bVar.cHh().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.cHg().setTextColor(ap.getColor(R.color.CAM_X0301));
                    bVar.qF(true);
                }
            }
            if (z) {
                com.baidu.adp.lib.f.e.mY().post(new Runnable() { // from class: com.baidu.tieba.frs.forumRule.view.a.8
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.jiN.fullScroll(IMPushPb.PushImClient.SDK_NAME_FIELD_NUMBER);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AI(int i) {
        if (i > 0) {
            this.jix.setVisibility(8);
            ViewGroup.LayoutParams layoutParams = this.jiD.getLayoutParams();
            layoutParams.width = -1;
            this.jiD.setLayoutParams(layoutParams);
            return;
        }
        this.jix.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = this.jiD.getLayoutParams();
        layoutParams2.width = -2;
        this.jiD.setLayoutParams(layoutParams2);
    }

    private void cGT() {
        if (this.jiD == null || this.jiD.getText().toString().length() <= 30) {
            if (this.jiO != null && this.jiO.size() > 0) {
                for (int i = 0; i < this.jiO.size(); i++) {
                    new ForumRuleBaseData.ForumRuleItemData();
                    b bVar = this.jiO.get(i);
                    EditText cHh = bVar.cHh();
                    SpanGroupEditText cHg = bVar.cHg();
                    if (cHh == null || cHh.getText().toString().trim().length() <= 30) {
                        if (cHg != null && cHg.getText().toString().length() > 300) {
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), bVar.AM(i + 5), this.mPageContext.getString(R.string.forum_rule_content))));
                            return;
                        }
                    } else {
                        Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), String.format(this.mPageContext.getString(R.string.forum_rule_defalt_has_forum_rule), bVar.AM(i + 5), this.mPageContext.getString(R.string.forum_rule_title))));
                        return;
                    }
                }
            }
            if (this.jiE == null || this.jiE.getText().toString().length() <= 200) {
                cHc();
                this.jhV.a(this.jiP, false);
                return;
            }
            Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title)));
            return;
        }
        Le(String.format(this.mPageContext.getString(R.string.forum_rule_commit_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title)));
    }

    private void Le(String str) {
        if (this.jiQ == null || !this.jiQ.isShown()) {
            this.jiQ = new BdTopToast(this.mPageContext.getPageActivity(), 2000).yW(false).Vt(str);
            this.jiQ.aF((ViewGroup) this.mRootView.findViewById(R.id.ll_forum_rule_all));
        }
    }

    private boolean cGU() {
        if (this.jiK == null || this.jiD == null || this.jiD.getText().toString().trim().length() <= 0) {
            return false;
        }
        if (this.jiO != null && this.jiO.size() > 0) {
            for (int i = 0; i < this.jiO.size(); i++) {
                b bVar = this.jiO.get(i);
                EditText cHh = bVar.cHh();
                SpanGroupEditText cHg = bVar.cHg();
                if (cHh == null || cHh.getText().toString().trim().length() <= 0 || cHg == null || cHg.getText().toString().trim().length() <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qG(boolean z) {
        if (z) {
            this.jiE.setText("");
            this.jip.setVisibility(0);
            this.jiI.setVisibility(8);
            return;
        }
        this.jiE.setText("");
        this.jip.setVisibility(8);
        this.jiI.setVisibility(0);
        l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jiE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGV() {
        cHc();
        if (this.jiP != null) {
            if (this.jiP.getTitle().length() > 50) {
                cHa();
                Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_main_title), 50));
                return;
            }
            if (this.jiP.getList() != null) {
                for (int i = 0; i < this.jiP.getList().size(); i++) {
                    ForumRuleBaseData.ForumRuleItemData forumRuleItemData = this.jiP.getList().get(i);
                    if (forumRuleItemData != null) {
                        if (forumRuleItemData.getTitle().length() > 50) {
                            cHa();
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_title), 50));
                            return;
                        } else if (forumRuleItemData.getContent().length() > 600) {
                            cHa();
                            Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_item_content), 600));
                            return;
                        }
                    }
                }
            }
            if (this.jiP.getPreface().length() > 600) {
                cHa();
                Le(String.format(this.mPageContext.getString(R.string.forum_rule_draft_error_toast), this.mPageContext.getString(R.string.forum_rule_defalt_preface_title), 600));
                return;
            }
        }
        this.jhV.a(this.jiP, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGW() {
        if (this.jiK != null) {
            if (cGU()) {
                this.jiK.setEnabled(true);
            } else {
                this.jiK.setEnabled(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGX() {
        if (this.jiO != null && this.jiO.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.jiO.size()) {
                    this.jiO.get(i2).AK(i2);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGY() {
        if (this.jiO != null) {
            if (this.jiO.size() >= 16) {
                this.jiB.setText(this.mPageContext.getString(R.string.forum_rule_item_number_max));
                this.jiq.setEnabled(false);
                this.jiB.setEnabled(false);
                this.jiR = false;
                this.jiu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0105), ap.eTL), WebPManager.ResourceStateType.NORMAL_PRESS));
                com.baidu.tbadk.core.elementsMaven.c.bm(this.jiq).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).pE(R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
                return;
            }
            this.jiB.setText(String.format(this.mPageContext.getString(R.string.forum_rule_item_add_number), Integer.valueOf(16 - this.jiO.size())));
            this.jiq.setEnabled(true);
            this.jiB.setEnabled(true);
            this.jiR = true;
            this.jiu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiq).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).pE(R.string.A_X01).setBackGroundColor(R.color.CAM_X0201);
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

    public void cGZ() {
        if (this.ikd == null) {
            this.ilN = new k(this.mPageContext.getPageActivity());
            this.ilN.setTitleText(this.mPageContext.getString(R.string.forum_rule_draft_title));
            this.ikd = new i(this.mPageContext, this.ilN);
            ArrayList arrayList = new ArrayList();
            g gVar = new g(this.mPageContext.getString(R.string.save), this.ilN);
            gVar.setTextColor(R.color.CAM_X0302);
            gVar.a(this.jiU);
            arrayList.add(gVar);
            g gVar2 = new g(this.mPageContext.getString(R.string.not_save), this.ilN);
            gVar2.a(this.jiV);
            arrayList.add(gVar2);
            this.ilN.a(new k.a() { // from class: com.baidu.tieba.frs.forumRule.view.a.9
                @Override // com.baidu.tbadk.core.dialog.k.a
                public void onClick() {
                    a.this.cHa();
                }
            });
            this.ilN.bu(arrayList);
        }
        cHb();
    }

    public void cHa() {
        if (this.ikd != null && this.ikd.isShowing()) {
            this.ikd.dismiss();
        }
    }

    public void cHb() {
        if (this.ikd != null && this.jik != null && !this.jik.isFinishing()) {
            this.ikd.RU();
        }
    }

    private void cHc() {
        if (this.jiP == null) {
            this.jiP = new ForumRuleBaseData();
        }
        ArrayList arrayList = new ArrayList();
        if (this.jiO != null && this.jiO.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jiO.size()) {
                    break;
                }
                ForumRuleBaseData.ForumRuleItemData forumRuleItemData = new ForumRuleBaseData.ForumRuleItemData();
                b bVar = this.jiO.get(i2);
                EditText cHh = bVar.cHh();
                SpanGroupEditText cHg = bVar.cHg();
                if (cHh != null) {
                    forumRuleItemData.setTitle(cHh.getText().toString());
                }
                if (cHg != null) {
                    forumRuleItemData.setContent(cHg.getSpanGroupManager().bwi());
                }
                forumRuleItemData.setStatus(i2 + "");
                arrayList.add(forumRuleItemData);
                i = i2 + 1;
            }
        }
        this.jiP.setTitle(this.jiD.getText().toString());
        this.jiP.setPreface(this.jiE.getText().toString());
        this.jiP.setList(arrayList);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiL) {
            cGZ();
        } else if (view == this.jiK) {
            cGT();
        } else if (view == this.jiJ) {
            cHc();
            this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumRulesShowActivityConfig(this.mPageContext.getPageActivity(), this.jih, this.jii, this.jiP, ForumRulesShowActivityConfig.FORUM_RULE_EDIT_FROM_SHOW, this.jij, this.jiS)));
        } else if (view == this.jio) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new FrsActivityConfig(this.mPageContext.getPageActivity()).createNormalCfg(this.jii, FrsActivityConfig.FRS_FROM_FORUM_RULE_EDIT)));
        } else if (view == this.jix) {
            cHe();
        } else if (view == this.jiI) {
            qG(true);
        } else if (view == this.jiq) {
            a(true, null, false);
        } else if (view == this.jit) {
            cHd();
        } else if (view == this.jiF || view == this.mNavigationBar) {
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jiD);
            l.hideSoftKeyPad(this.mPageContext.getPageActivity(), this.jiE);
        }
    }

    private void cHd() {
        if (TextUtils.isEmpty(this.jiE.getText().toString())) {
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

    private void cHe() {
        String format = String.format(this.mPageContext.getString(R.string.forum_rule_defalt_title_demo), this.jii, au.getDateStringMouth(new Date()));
        this.jiD.setText(format);
        this.jiD.setSelection(format.length());
        ViewGroup.LayoutParams layoutParams = this.jiD.getLayoutParams();
        layoutParams.width = -1;
        this.jiD.setLayoutParams(layoutParams);
    }

    public void changeSkinType(int i) {
        if (this.mRootView != null) {
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiF).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiw).ps(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jil).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jim).setBackGroundColor(R.color.CAM_X0210);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jin).setBackGroundColor(R.color.CAM_X0204);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiy).ps(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiA).ps(R.color.CAM_X0111);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jix).ps(R.color.CAM_X0304).pu(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiz).ps(R.color.CAM_X0107).pu(R.string.F_X02);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiC).ps(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiL).px(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiJ).px(R.color.CAM_X0302).pt(R.dimen.T_X05);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiK).pt(R.dimen.T_X05);
            this.jiK.setTextColor(ap.aS(R.color.CAM_X0302, TbadkCoreApplication.getInst().getSkinType()));
            this.jiB.setTextColor(ap.aS(R.color.CAM_X0105, TbadkCoreApplication.getInst().getSkinType()));
            this.jiD.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jiD.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jiE.setHintTextColor(ap.getColor(R.color.CAM_X0111));
            this.jiE.setTextColor(ap.getColor(R.color.CAM_X0105));
            this.jir.setImageDrawable(WebPManager.a(R.drawable.icon_pure_frs_recommend_copy18, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jis.setImageDrawable(WebPManager.a(R.drawable.icon_pure_list_arrow16_right, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jit.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_delete16, ap.getColor(R.color.CAM_X0107), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.jiv.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            if (this.jiR) {
                this.jiu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, ap.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            } else {
                this.jiu.setImageDrawable(WebPManager.a(R.drawable.icon_pure_edit_add12, com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0304), ap.eTK), WebPManager.ResourceStateType.NORMAL_PRESS));
            }
            if (this.mNavigationBar != null) {
                this.mNavigationBar.onChangeSkinType(this.mPageContext, i);
            }
            if (this.ilN != null) {
                this.ilN.onChangeSkinType();
            }
            if (i == 0) {
                j.h(this.jiD, R.drawable.edittext_cursor);
                j.h(this.jiE, R.drawable.edittext_cursor);
            } else {
                j.h(this.jiD, R.drawable.edittext_cursor_1);
                j.h(this.jiE, R.drawable.edittext_cursor_1);
            }
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiq).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).pE(this.jiR ? R.string.A_X01 : R.string.A_X09).setBackGroundColor(R.color.CAM_X0201);
            com.baidu.tbadk.core.elementsMaven.c.bm(this.jiI).pC(R.color.CAM_X0902).pD(R.dimen.L_X02).pA(R.string.J_X07).setBackGroundColor(R.color.CAM_X0201);
            if (this.jiG != null && this.jiG.getChildCount() > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < this.jiG.getChildCount()) {
                        EMTextView eMTextView = (EMTextView) this.jiG.getChildAt(i3);
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
            this.jiD.setText(forumRuleBaseData.getTitle());
            this.jiD.setSelection(forumRuleBaseData.getTitle() != null ? forumRuleBaseData.getTitle().length() : 0);
            this.jiE.setText(forumRuleBaseData.getPreface());
            this.jiE.setSelection(forumRuleBaseData.getPreface() != null ? forumRuleBaseData.getPreface().length() : 0);
            if (forumRuleBaseData.getPbDataList() != null && forumRuleBaseData.getPbDataList().size() > 0) {
                b bVar = this.jiO.get(0);
                this.jiH.removeView(bVar.getRootView());
                this.jiO.remove(bVar);
                for (int i = 0; i < forumRuleBaseData.getPbDataList().size(); i++) {
                    a(false, forumRuleBaseData.getPbDataList().get(i), !z);
                }
            } else if (this.jiO.size() > 0) {
                b bVar2 = this.jiO.get(0);
                this.jiH.removeView(bVar2.getRootView());
                this.jiO.remove(bVar2);
                cGY();
                cGX();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ(int i) {
        if (i == 0 && !this.jiT) {
            if ("Meizu".equalsIgnoreCase(Build.BRAND)) {
                cv(UtilHelper.getDimenPixelSize(R.dimen.tbds6), UtilHelper.getDimenPixelSize(R.dimen.tbds20));
                this.jiT = true;
            } else if ("Xiaomi".equalsIgnoreCase(Build.BRAND)) {
                cv(0, UtilHelper.getDimenPixelSize(R.dimen.tbds_20));
                this.jiT = true;
            }
        } else if (this.jiT) {
            this.jiT = false;
            cv(0, 0);
        }
    }

    private void cv(int i, int i2) {
        try {
            Method declaredMethod = TextView.class.getDeclaredMethod("createEditorIfNeeded", new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this.jiE, new Object[0]);
            Field declaredField = TextView.class.getDeclaredField("mEditor");
            Field declaredField2 = Class.forName("android.widget.Editor").getDeclaredField("mCursorDrawable");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(declaredField.get(this.jiE));
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
        this.jiQ = null;
        this.jiP = null;
        this.jhV = null;
        this.jik = null;
        cHa();
        this.ikd = null;
        this.ilN = null;
    }
}
