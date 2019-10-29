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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools Dl;
    private int Dm;
    private TextView ati;
    private boolean cGE;
    private boolean cGF;
    private boolean cGG;
    private int cGH;
    private EditText cHi;
    private PbNewLocationInfoView cHj;
    private LinearLayout cHk;
    private ImageView cHl;
    private LinearLayout cHm;
    private i cHn;
    private SpannableStringBuilder cHo;
    private String cHp;
    private boolean cHq;
    private boolean[] cHr;
    private int[] cHs;
    private int csX;
    private View mBottomLine;
    private int mType;
    public static int cHt = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGE = false;
        this.cGF = true;
        this.cGG = true;
        this.cGH = -1;
        this.cHq = true;
        this.cHr = new boolean[]{false, false, false, false, false};
        this.cHs = new int[]{0, 0};
        this.csX = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cy(context);
        this.cHm = new LinearLayout(getContext());
        this.cHm.setOrientation(0);
        this.cHm.setMinimumHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds120));
        addView(this.cHm, new LinearLayout.LayoutParams(-1, -2));
        cA(context);
        cz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cy(Context context) {
        this.cHk = new LinearLayout(getContext());
        this.cHk.setGravity(16);
        this.cHk.setOrientation(0);
        this.cHk.setPadding(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds34), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds30), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds34), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds12));
        this.cHk.setLayoutParams(layoutParams);
        this.cHk.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cHj = new PbNewLocationInfoView(context);
        this.cHk.addView(this.cHj, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.cHl = new ImageView(context);
        this.cHl.setPadding(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.cHk.addView(this.cHl, layoutParams3);
        addView(this.cHk);
        this.cHk.setVisibility(8);
        this.cHl.setOnClickListener(this);
    }

    private void cz(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.ati = new TextView(context);
        this.ati.setGravity(17);
        this.ati.setIncludeFontPadding(false);
        this.ati.setEnabled(false);
        this.ati.setAlpha(0.5f);
        this.ati.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.ati.setText(R.string.pb_send_post);
        this.ati.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.ati, layoutParams2);
        this.cHm.addView(linearLayout, layoutParams);
    }

    private void cA(Context context) {
        this.cHi = new EditText(context);
        this.cHi.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cHi.setMaxLines(4);
        this.cHi.setGravity(16);
        this.cHi.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cHi.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.cHi.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.cHi.setBackgroundResource(R.color.common_color_10022);
        e(this.cHi, R.drawable.edittext_cursor);
        this.cHi.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds54), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24));
        this.cHi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cHi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.cGG) {
                    PbNewInputContainer.this.cGG = true;
                    if (PbNewInputContainer.this.cGH != -1) {
                        PbNewInputContainer.this.cHi.setSelection(PbNewInputContainer.this.cGH);
                        PbNewInputContainer.this.cGH = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.cHo)) {
                        if (PbNewInputContainer.this.cHn == null) {
                            PbNewInputContainer.this.cHn = new i();
                        }
                        PbNewInputContainer.this.cHn.cHO = PbNewInputContainer.this.cHo.toString();
                        PbNewInputContainer.this.cHn.mContent = PbNewInputContainer.this.cHi.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cHn));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cHi.getText().toString()));
                }
            }
        });
        this.cHi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.cHi.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.cHm.addView(this.cHi, layoutParams);
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

    private void A(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(HanziToPinyin.Token.SEPARATOR);
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.cHi.getText().insert(this.cHi.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void pF(String str) {
        if (!StringUtils.isNull(str)) {
            this.cHi.getText().insert(this.cHi.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).apm() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).apm() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.apm() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cHi.getText().toString();
            if (this.cGF && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cHi);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cGE || pVar.apm() == EmotionGroupType.LOCAL) {
            String obj = this.cHi.getText().toString();
            if (this.cGF && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cHi);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cGE = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.cHi != null && this.cHm.getVisibility() == 0) {
            this.cHi.setFocusable(true);
            this.cHi.setFocusableInTouchMode(true);
            this.cHi.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), this.cHi);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.cHi, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.e(this.cHk, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.cHl, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.cHi, R.drawable.edittext_cursor);
            this.cHi.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.cHi, R.drawable.edittext_cursor_1);
            this.cHi.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.ati, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.ati, R.drawable.bg_comment_send);
        this.cHj.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cHi.getSelectionStart() > 0) {
                        String substring = this.cHi.getText().toString().substring(0, this.cHi.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fhw.matcher(substring);
                        if (matcher.find()) {
                            this.cHi.getText().delete(this.cHi.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cHi.getSelectionStart());
                            break;
                        } else {
                            this.cHi.getText().delete(this.cHi.getSelectionStart() - 1, this.cHi.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cHi.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cHi.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.cHi.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.cHi.setSelection(PbNewInputContainer.this.cHi.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.cHo = null;
                        if (this.cHp != null) {
                            this.cHi.setHint(this.cHp);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cHO) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.cHi.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cHO)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cHO, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.cHo = spannableStringBuilder;
                                        PbNewInputContainer.this.cHi.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.cHi.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(iVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.cHi.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.cHi.setSelection(PbNewInputContainer.this.cHi.getText().length());
                                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                        PbNewInputContainer.this.requestFocus();
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 4:
                    if (aVar.data == null || (((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data)) || ((aVar.data instanceof i) && TextUtils.isEmpty(((i) aVar.data).mContent)))) {
                        this.cHr[0] = false;
                        break;
                    } else {
                        this.cHr[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cHn = null;
                        this.cHo = null;
                        this.cHi.setText((CharSequence) null);
                    }
                    this.cHr[0] = false;
                    this.cHr[1] = false;
                    this.cHr[2] = false;
                    this.cHr[3] = false;
                    this.cHr[4] = false;
                    this.cHs[0] = 0;
                    this.cHs[1] = 0;
                    break;
                case 10:
                    this.cHr[2] = true;
                    break;
                case 11:
                    this.cHr[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cGf != null) {
                            if (aVar2.cGf.getChosedFiles() != null) {
                                this.cHs[0] = aVar2.cGf.getChosedFiles().size();
                            } else {
                                this.cHs[0] = 0;
                            }
                        }
                        if (this.cHs[0] > 0) {
                            this.cHr[1] = true;
                            break;
                        } else {
                            this.cHr[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cHs;
                    iArr[0] = iArr[0] - 1;
                    if (this.cHs[0] > 0) {
                        this.cHr[1] = true;
                        break;
                    } else {
                        this.cHr[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        A((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.cHk.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.cGJ) {
                            this.cHk.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.cHj.setState(aVar3.state, null);
                                break;
                            } else {
                                this.cHj.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.cHk.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.cHk.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.cHr[3] = true;
                    break;
                case 29:
                    this.cHr[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            pF((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            pF(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            jT(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jT(int i) {
        if (i == ALL) {
            if (this.cHr[0] || this.cHr[1] || this.cHr[2] || this.cHr[3] || this.cHr[4]) {
                this.ati.setEnabled(true);
                this.ati.setAlpha(1.0f);
                return;
            }
            this.ati.setEnabled(false);
            this.ati.setAlpha(0.5f);
        } else if (i == cHt) {
            if (this.cHr[1]) {
                this.ati.setEnabled(true);
                this.ati.setAlpha(1.0f);
                return;
            }
            this.ati.setEnabled(false);
            this.ati.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.cHq = z;
    }

    public void setHint(int i) {
        if (this.cHi != null) {
            this.cHi.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cHi != null) {
            this.cHi.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.cHp = str;
    }

    public EditText getInputView() {
        return this.cHi;
    }

    public TextView getSendView() {
        return this.ati;
    }

    public TextView getLocationInfoView() {
        return this.cHj;
    }

    public LinearLayout getInputLayout() {
        return this.cHm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cHk) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.cHl) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
