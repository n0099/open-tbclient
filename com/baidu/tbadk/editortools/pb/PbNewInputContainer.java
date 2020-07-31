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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, m {
    private EditorTools ZS;
    private int ZT;
    private int aho;
    private TextView dJr;
    private boolean eBD;
    private boolean eBE;
    private boolean eBF;
    private int eBG;
    private SpanGroupEditText eCi;
    private TBSpecificationBtn eCj;
    private TBSpecificationBtn eCk;
    private LinearLayout eCl;
    private j eCm;
    private SpannableStringBuilder eCn;
    private String eCo;
    private boolean eCp;
    private int[] eCq;
    private Runnable eCs;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int eCr = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBD = false;
        this.eBE = true;
        this.eBF = true;
        this.eBG = -1;
        this.eCp = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eCq = new int[]{0, 0};
        this.aho = 0;
        this.mType = ALL;
        this.eCs = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.eCi != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.eCi.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bjF();
        dV(context);
        this.eCl = new LinearLayout(getContext());
        this.eCl.setOrientation(0);
        this.eCl.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.eCl, new LinearLayout.LayoutParams(-1, -2));
        dX(context);
        dW(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bjF() {
        this.dJr = new TextView(getContext());
        this.dJr.setId(R.id.comment_content);
        this.dJr.setVisibility(8);
        this.dJr.setMaxLines(1);
        this.dJr.setEllipsize(TextUtils.TruncateAt.END);
        this.dJr.setIncludeFontPadding(false);
        this.dJr.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.dJr.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.dJr, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void dV(Context context) {
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mX(R.color.cp_cont_b);
        cVar.k(R.drawable.ic_icon_pure_post_location16_svg, 0, true);
        cVar.mS(R.color.cp_cont_e);
        cVar.aS(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.eCk = new TBSpecificationBtn(getContext());
        this.eCk.setLayoutParams(layoutParams);
        this.eCk.setOnClickListener(this);
        this.eCk.setConfig(cVar);
        this.eCk.setTextSize(R.dimen.tbds32);
        this.eCk.setOnClickListener(this);
        this.eCk.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.eCk);
    }

    private void dW(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.eCj = new TBSpecificationBtn(context);
        this.eCj.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.eCj.setEnabled(false);
        this.eCj.setTextSize(R.dimen.tbds42);
        this.eCj.setText(context.getString(R.string.pb_send_post));
        this.eCj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds168), l.getDimens(context, R.dimen.tbds94));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds17);
        linearLayout.addView(this.eCj, layoutParams2);
        this.eCl.addView(linearLayout, layoutParams);
    }

    private void dX(Context context) {
        this.eCi = new SpanGroupEditText(context);
        this.eCi.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.eCi.setMaxLines(4);
        this.eCi.setGravity(16);
        this.eCi.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.eCi.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.eCi.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.eCi.setBackgroundResource(R.color.common_color_10022);
        e(this.eCi, R.drawable.edittext_cursor);
        this.eCi.setPadding(0, l.getDimens(context, R.dimen.tbds26), 0, l.getDimens(context, R.dimen.tbds26));
        this.eCi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eCi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.eBF) {
                    PbNewInputContainer.this.eBF = true;
                    if (PbNewInputContainer.this.eBG != -1) {
                        PbNewInputContainer.this.eCi.setSelection(PbNewInputContainer.this.eBG);
                        PbNewInputContainer.this.eBG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.eCn)) {
                        if (PbNewInputContainer.this.eCm == null) {
                            PbNewInputContainer.this.eCm = new j();
                        }
                        PbNewInputContainer.this.eCm.eCL = PbNewInputContainer.this.eCn.toString();
                        PbNewInputContainer.this.eCm.mContent = PbNewInputContainer.this.eCi.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.eCm));
                        return;
                    }
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(PbNewInputContainer.this.eCs);
                    com.baidu.adp.lib.f.e.lt().post(PbNewInputContainer.this.eCs);
                }
            }
        });
        this.eCi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.eCi.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds18), l.getDimens(context, R.dimen.tbds52), l.getDimens(context, R.dimen.tbds16));
        this.eCl.addView(this.eCi, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void G(ArrayList<String> arrayList) {
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
                    this.eCi.getText().insert(this.eCi.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void zD(String str) {
        if (!StringUtils.isNull(str)) {
            this.eCi.getText().insert(this.eCi.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).bef() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).bef() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.bef() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.eCi.getText().toString();
            if (this.eBE && com.baidu.tieba.face.a.Fc(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aZX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.eCi);
            }
        }
    }

    private void b(q qVar) {
        if (!this.eBD || qVar.bef() == EmotionGroupType.LOCAL) {
            String obj = this.eCi.getText().toString();
            if (this.eBE && com.baidu.tieba.face.a.Fc(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aZX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.eCi);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eBD = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.eCi != null && this.eCl.getVisibility() == 0) {
            this.eCi.setFocusable(true);
            this.eCi.setFocusableInTouchMode(true);
            this.eCi.requestFocus();
            l.showSoftKeyPad(getContext(), this.eCi);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.eCi, R.color.cp_cont_b, 2, i);
        ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ao.setBackgroundColor(this, R.color.cp_bg_line_h);
        this.eCk.bci();
        if (i == 0) {
            e(this.eCi, R.drawable.edittext_cursor);
            this.eCi.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.eCi, R.drawable.edittext_cursor_1);
            this.eCi.setHintTextColor(ao.getColor(i, R.color.cp_cont_e));
        }
        this.eCj.bci();
        ao.setViewTextColor(this.dJr, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eCi.getSelectionStart() > 0) {
                        String substring = this.eCi.getText().toString().substring(0, this.eCi.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hrz.matcher(substring);
                        if (matcher.find()) {
                            this.eCi.getText().delete(this.eCi.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eCi.getSelectionStart());
                            break;
                        } else {
                            this.eCi.getText().delete(this.eCi.getSelectionStart() - 1, this.eCi.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.eCi.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eCi.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.eCi.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.eCi.setSelection(PbNewInputContainer.this.eCi.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.eCn = null;
                        if (this.eCo != null) {
                            this.eCi.setHint(this.eCo);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).eCL) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.eCi.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.eCL)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.eCL, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.eCn = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.eCi.setText("");
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
                                        PbNewInputContainer.this.eCi.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.eCi.setSelection(PbNewInputContainer.this.eCi.getText().length());
                                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                        PbNewInputContainer.this.requestFocus();
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 4:
                    if (aVar.data == null || (((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data)) || ((aVar.data instanceof j) && TextUtils.isEmpty(((j) aVar.data).mContent)))) {
                        this.flags[0] = false;
                        break;
                    } else {
                        this.flags[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.eCm = null;
                        this.eCn = null;
                        this.eCi.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eCq[0] = 0;
                    this.eCq[1] = 0;
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
                        if (aVar2.eBe != null) {
                            if (aVar2.eBe.getChosedFiles() != null) {
                                this.eCq[0] = aVar2.eBe.getChosedFiles().size();
                            } else {
                                this.eCq[0] = 0;
                            }
                        }
                        if (this.eCq[0] > 0) {
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
                    int[] iArr = this.eCq;
                    iArr[0] = iArr[0] - 1;
                    if (this.eCq[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        G((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.eCk.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.eCk.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.eCk.setText(aVar3.addr);
                            break;
                        } else {
                            this.eCk.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    this.eCk.setText(getContext().getString(R.string.location_where_are_you));
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
                            zD((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            zD(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.dJr.setVisibility(8);
                            break;
                        } else {
                            this.dJr.setVisibility(0);
                            this.dJr.setText(str);
                            break;
                        }
                    } else {
                        this.dJr.setVisibility(8);
                        break;
                    }
            }
            ob(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void ob(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.eCj.setEnabled(true);
            } else {
                this.eCj.setEnabled(false);
            }
        } else if (i == eCr) {
            if (this.flags[1]) {
                this.eCj.setEnabled(true);
            } else {
                this.eCj.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.eCp = z;
    }

    public void setHint(int i) {
        if (this.eCi != null) {
            this.eCi.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.eCi != null) {
            this.eCi.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.eCo = str;
    }

    public EditText getInputView() {
        return this.eCi;
    }

    public TBSpecificationBtn getSendView() {
        return this.eCj;
    }

    public LinearLayout getInputLayout() {
        return this.eCl;
    }

    public TextView getTitleView() {
        return this.dJr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eCk) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.eCi != null) {
            this.eCi.setTransLink(z);
        }
    }

    public void iS(boolean z) {
        if (this.eCk != null) {
            this.eCk.setVisibility(z ? 0 : 8);
        }
    }
}
