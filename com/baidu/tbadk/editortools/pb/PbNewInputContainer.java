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
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.am;
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
    private EditorTools Za;
    private int Zb;
    private int afT;
    private TextView bbL;
    private EditText dYK;
    private PbNewLocationInfoView dYL;
    private LinearLayout dYM;
    private ImageView dYN;
    private LinearLayout dYO;
    private j dYP;
    private SpannableStringBuilder dYQ;
    private String dYR;
    private boolean dYS;
    private int[] dYT;
    private boolean dYg;
    private boolean dYh;
    private boolean dYi;
    private int dYj;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int dYU = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYg = false;
        this.dYh = true;
        this.dYi = true;
        this.dYj = -1;
        this.dYS = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dYT = new int[]{0, 0};
        this.afT = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dK(context);
        this.dYO = new LinearLayout(getContext());
        this.dYO.setOrientation(0);
        this.dYO.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.dYO, new LinearLayout.LayoutParams(-1, -2));
        dM(context);
        dL(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dK(Context context) {
        this.dYM = new LinearLayout(getContext());
        this.dYM.setGravity(16);
        this.dYM.setOrientation(0);
        this.dYM.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.dYM.setLayoutParams(layoutParams);
        this.dYM.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dYL = new PbNewLocationInfoView(context);
        this.dYM.addView(this.dYL, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.dYN = new ImageView(context);
        this.dYN.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.dYM.addView(this.dYN, layoutParams3);
        addView(this.dYM);
        this.dYM.setVisibility(8);
        this.dYN.setOnClickListener(this);
    }

    private void dL(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.bbL = new TextView(context);
        this.bbL.setGravity(17);
        this.bbL.setIncludeFontPadding(false);
        this.bbL.setEnabled(false);
        this.bbL.setAlpha(0.5f);
        this.bbL.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bbL.setText(R.string.pb_send_post);
        this.bbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds136), l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.bbL, layoutParams2);
        this.dYO.addView(linearLayout, layoutParams);
    }

    private void dM(Context context) {
        this.dYK = new EditText(context);
        this.dYK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYK.setMaxLines(4);
        this.dYK.setGravity(16);
        this.dYK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYK.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dYK.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dYK.setBackgroundResource(R.color.common_color_10022);
        e(this.dYK, R.drawable.edittext_cursor);
        this.dYK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dYK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dYK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dYi) {
                    PbNewInputContainer.this.dYi = true;
                    if (PbNewInputContainer.this.dYj != -1) {
                        PbNewInputContainer.this.dYK.setSelection(PbNewInputContainer.this.dYj);
                        PbNewInputContainer.this.dYj = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.dYQ)) {
                        if (PbNewInputContainer.this.dYP == null) {
                            PbNewInputContainer.this.dYP = new j();
                        }
                        PbNewInputContainer.this.dYP.dZn = PbNewInputContainer.this.dYQ.toString();
                        PbNewInputContainer.this.dYP.mContent = PbNewInputContainer.this.dYK.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dYP));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dYK.getText().toString()));
                }
            }
        });
        this.dYK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.dYK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.dYO.addView(this.dYK, layoutParams);
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

    private void F(ArrayList<String> arrayList) {
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
                    this.dYK.getText().insert(this.dYK.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void wv(String str) {
        if (!StringUtils.isNull(str)) {
            this.dYK.getText().insert(this.dYK.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).aRY() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).aRY() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.aRY() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dYK.getText().toString();
            if (this.dYh && com.baidu.tieba.face.a.Ce(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOd().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dYK);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dYg || qVar.aRY() == EmotionGroupType.LOCAL) {
            String obj = this.dYK.getText().toString();
            if (this.dYh && com.baidu.tieba.face.a.Ce(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOd().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dYK);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dYg = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zb;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dYK != null && this.dYO.getVisibility() == 0) {
            this.dYK.setFocusable(true);
            this.dYK.setFocusableInTouchMode(true);
            this.dYK.requestFocus();
            l.showSoftKeyPad(getContext(), this.dYK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dYK, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.dYM, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.dYN, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.dYK, R.drawable.edittext_cursor);
            this.dYK.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dYK, R.drawable.edittext_cursor_1);
            this.dYK.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.bbL, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.bbL, R.drawable.bg_comment_send);
        this.dYL.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dYK.getSelectionStart() > 0) {
                        String substring = this.dYK.getText().toString().substring(0, this.dYK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gKy.matcher(substring);
                        if (matcher.find()) {
                            this.dYK.getText().delete(this.dYK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dYK.getSelectionStart());
                            break;
                        } else {
                            this.dYK.getText().delete(this.dYK.getSelectionStart() - 1, this.dYK.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dYK.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dYK.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.dYK.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.dYK.setSelection(PbNewInputContainer.this.dYK.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.dYQ = null;
                        if (this.dYR != null) {
                            this.dYK.setHint(this.dYR);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).dZn) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.dYK.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.dZn)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.dZn, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dYQ = spannableStringBuilder;
                                        PbNewInputContainer.this.dYK.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.dYK.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(jVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dYK.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.dYK.setSelection(PbNewInputContainer.this.dYK.getText().length());
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
                        this.dYP = null;
                        this.dYQ = null;
                        this.dYK.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dYT[0] = 0;
                    this.dYT[1] = 0;
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
                        if (aVar2.dXH != null) {
                            if (aVar2.dXH.getChosedFiles() != null) {
                                this.dYT[0] = aVar2.dXH.getChosedFiles().size();
                            } else {
                                this.dYT[0] = 0;
                            }
                        }
                        if (this.dYT[0] > 0) {
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
                    int[] iArr = this.dYT;
                    iArr[0] = iArr[0] - 1;
                    if (this.dYT[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        F((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.dYM.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.dYM.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dYL.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dYL.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.dYM.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.dYM.setVisibility(8);
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
                            wv((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            wv(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            mL(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mL(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bbL.setEnabled(true);
                this.bbL.setAlpha(1.0f);
                return;
            }
            this.bbL.setEnabled(false);
            this.bbL.setAlpha(0.5f);
        } else if (i == dYU) {
            if (this.flags[1]) {
                this.bbL.setEnabled(true);
                this.bbL.setAlpha(1.0f);
                return;
            }
            this.bbL.setEnabled(false);
            this.bbL.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.dYS = z;
    }

    public void setHint(int i) {
        if (this.dYK != null) {
            this.dYK.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dYK != null) {
            this.dYK.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.dYR = str;
    }

    public EditText getInputView() {
        return this.dYK;
    }

    public TextView getSendView() {
        return this.bbL;
    }

    public TextView getLocationInfoView() {
        return this.dYL;
    }

    public LinearLayout getInputLayout() {
        return this.dYO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dYM) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.dYN) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
