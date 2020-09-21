package com.baidu.tbadk.editortools.pb;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools aaS;
    private int aaT;
    private int aiX;
    private TextView dUN;
    private boolean eOA;
    private int eOB;
    private boolean eOy;
    private boolean eOz;
    private SpanGroupEditText ePC;
    private TBSpecificationBtn ePD;
    private TBSpecificationBtn ePE;
    private LinearLayout ePF;
    private j ePG;
    private SpannableStringBuilder ePH;
    private String ePI;
    private boolean ePJ;
    private int[] ePK;
    private Runnable ePM;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int ePL = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOy = false;
        this.eOz = true;
        this.eOA = true;
        this.eOB = -1;
        this.ePJ = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.ePK = new int[]{0, 0};
        this.aiX = 0;
        this.mType = ALL;
        this.ePM = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.ePC != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ePC.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        btw();
        eg(context);
        this.ePF = new LinearLayout(getContext());
        this.ePF.setOrientation(0);
        this.ePF.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.ePF, new LinearLayout.LayoutParams(-1, -2));
        ei(context);
        eh(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void btw() {
        this.dUN = new TextView(getContext());
        this.dUN.setId(R.id.comment_content);
        this.dUN.setVisibility(8);
        this.dUN.setMaxLines(1);
        this.dUN.setEllipsize(TextUtils.TruncateAt.END);
        this.dUN.setIncludeFontPadding(false);
        this.dUN.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.dUN.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.dUN, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void eg(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pr(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pk(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds28), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.ePE = new TBSpecificationBtn(getContext());
        this.ePE.setLayoutParams(layoutParams);
        this.ePE.setOnClickListener(this);
        this.ePE.setConfig(bVar);
        this.ePE.setTextSize(R.dimen.tbds32);
        this.ePE.setOnClickListener(this);
        this.ePE.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.ePE);
    }

    private void eh(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.ePD = new TBSpecificationBtn(context);
        this.ePD.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        this.ePD.setEnabled(false);
        this.ePD.setTextSize(R.dimen.tbds34);
        this.ePD.setText(context.getString(R.string.pb_send_post));
        this.ePD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds152), l.getDimens(context, R.dimen.tbds76));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds16);
        linearLayout.addView(this.ePD, layoutParams2);
        this.ePF.addView(linearLayout, layoutParams);
    }

    private void ei(Context context) {
        this.ePC = new SpanGroupEditText(context);
        this.ePC.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.ePC.setMaxLines(4);
        this.ePC.setMinLines(2);
        this.ePC.setGravity(48);
        this.ePC.setIncludeFontPadding(false);
        this.ePC.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.ePC.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.ePC.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        g(this.ePC, R.drawable.edittext_cursor);
        this.ePC.setLineSpacing(l.getDimens(context, R.dimen.tbds11), 1.0f);
        this.ePC.setPadding(l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds29), l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds31));
        this.ePC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ePC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.eOA) {
                    PbNewInputContainer.this.eOA = true;
                    if (PbNewInputContainer.this.eOB != -1) {
                        PbNewInputContainer.this.ePC.setSelection(PbNewInputContainer.this.eOB);
                        PbNewInputContainer.this.eOB = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.ePH)) {
                        if (PbNewInputContainer.this.ePG == null) {
                            PbNewInputContainer.this.ePG = new j();
                        }
                        PbNewInputContainer.this.ePG.eQf = PbNewInputContainer.this.ePH.toString();
                        PbNewInputContainer.this.ePG.mContent = PbNewInputContainer.this.ePC.getText().toString();
                        PbNewInputContainer.this.ePG.mSpanGroupManager = PbNewInputContainer.this.ePC.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ePG));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(PbNewInputContainer.this.ePM);
                    com.baidu.adp.lib.f.e.mX().post(PbNewInputContainer.this.ePM);
                }
            }
        });
        this.ePC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.ePC.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds24), l.getDimens(context, R.dimen.tbds42), l.getDimens(context, R.dimen.tbds16));
        this.ePF.addView(this.ePC, layoutParams);
    }

    private void g(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void M(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append(UgcConstant.AT_RULE_TAG);
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.ePC.getText().insert(this.ePC.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void Cq(String str) {
        if (!StringUtils.isNull(str)) {
            this.ePC.getText().insert(this.ePC.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bnJ() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bnJ() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bnJ() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.ePC.getText().toString();
            if (this.eOz && com.baidu.tieba.face.a.Ib(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bjn().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.ePC);
            }
        }
    }

    private void b(u uVar) {
        if (!this.eOy || uVar.bnJ() == EmotionGroupType.LOCAL) {
            String obj = this.ePC.getText().toString();
            if (this.eOz && com.baidu.tieba.face.a.Ib(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bjn().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.ePC);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eOy = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.ePC != null && this.ePF.getVisibility() == 0) {
            this.ePC.setFocusable(true);
            this.ePC.setFocusableInTouchMode(true);
            this.ePC.requestFocus();
            l.showSoftKeyPad(getContext(), this.ePC);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.ePC, R.color.cp_cont_b, 2, i);
        com.baidu.tbadk.core.util.e.a.bkL().aQ(R.color.cp_bg_line_j, i).oq(0).V(l.getDimens(getContext(), R.dimen.tbds21)).bb(this.ePC);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_h, i);
        this.ePE.changeSkinType(i);
        if (i == 0) {
            g(this.ePC, R.drawable.edittext_cursor);
            this.ePC.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        } else {
            g(this.ePC, R.drawable.edittext_cursor_1);
            this.ePC.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        this.ePD.changeSkinType(i);
        ap.setViewTextColor(this.dUN, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ePC.getSelectionStart() > 0) {
                        String substring = this.ePC.getText().toString().substring(0, this.ePC.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hLW.matcher(substring);
                        if (matcher.find()) {
                            this.ePC.getText().delete(this.ePC.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ePC.getSelectionStart());
                            break;
                        } else {
                            this.ePC.getText().delete(this.ePC.getSelectionStart() - 1, this.ePC.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ePC.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ePC.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.ePC.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.ePC.setSelection(PbNewInputContainer.this.ePC.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.ePH = null;
                        if (this.ePI != null) {
                            this.ePC.setHint(this.ePI);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).eQf) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.ePC.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.eQf)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.eQf, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.ePH = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.ePC.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(jVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.7
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.ePC.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.ePC.setSelection(PbNewInputContainer.this.ePC.getText().length());
                                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                        PbNewInputContainer.this.requestFocus();
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 4:
                    if (aVar.data == null || (((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data)) || (((aVar.data instanceof j) && TextUtils.isEmpty(((j) aVar.data).mContent)) || ((aVar.data instanceof SpanGroupManager) && ((SpanGroupManager) aVar.data).isEmpty())))) {
                        this.flags[0] = false;
                        break;
                    } else {
                        this.flags[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ePG = null;
                        this.ePH = null;
                        this.ePC.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.ePK[0] = 0;
                    this.ePK[1] = 0;
                    break;
                case 10:
                    this.flags[2] = true;
                    break;
                case 11:
                    this.flags[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.eNZ != null) {
                            if (aVar2.eNZ.getChosedFiles() != null) {
                                this.ePK[0] = aVar2.eNZ.getChosedFiles().size();
                            } else {
                                this.ePK[0] = 0;
                            }
                        }
                        if (this.ePK[0] > 0) {
                            this.flags[1] = true;
                            break;
                        } else {
                            this.flags[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ePK;
                    iArr[0] = iArr[0] - 1;
                    if (this.ePK[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        M((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        jt(false);
                        break;
                    } else {
                        jt(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.ePE.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.ePE.setText(aVar3.addr);
                            break;
                        } else {
                            this.ePE.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    jt(true);
                    this.ePE.setText(getContext().getString(R.string.location_where_are_you));
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.flags[3] = true;
                    break;
                case 29:
                    this.flags[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            Cq((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            Cq(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.dUN.setVisibility(8);
                            break;
                        } else {
                            this.dUN.setVisibility(0);
                            this.dUN.setText(str);
                            break;
                        }
                    } else {
                        this.dUN.setVisibility(8);
                        break;
                    }
            }
            qD(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void qD(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.ePD.setEnabled(true);
            } else {
                this.ePD.setEnabled(false);
            }
        } else if (i == ePL) {
            if (this.flags[1]) {
                this.ePD.setEnabled(true);
            } else {
                this.ePD.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.ePJ = z;
    }

    public void setHint(int i) {
        if (this.ePC != null) {
            this.ePC.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ePC != null) {
            this.ePC.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.ePI = str;
    }

    public EditText getInputView() {
        return this.ePC;
    }

    public TBSpecificationBtn getSendView() {
        return this.ePD;
    }

    public LinearLayout getInputLayout() {
        return this.ePF;
    }

    public TextView getTitleView() {
        return this.dUN;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ePE) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.ePC != null) {
            this.ePC.setTransLink(z);
        }
    }

    public void jt(boolean z) {
        if (this.ePE != null) {
            this.ePE.setVisibility(z ? 0 : 8);
        }
    }
}
