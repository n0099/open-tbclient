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
    private EditorTools Zt;
    private int Zu;
    private int agt;
    private TextView bjq;
    private EditText emY;
    private PbNewLocationInfoView emZ;
    private boolean emu;
    private boolean emv;
    private boolean emw;
    private int emx;
    private LinearLayout ena;
    private ImageView enb;
    private LinearLayout enc;
    private j ene;
    private SpannableStringBuilder enf;
    private String eng;
    private boolean enh;
    private int[] eni;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int enj = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emu = false;
        this.emv = true;
        this.emw = true;
        this.emx = -1;
        this.enh = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eni = new int[]{0, 0};
        this.agt = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dP(context);
        this.enc = new LinearLayout(getContext());
        this.enc.setOrientation(0);
        this.enc.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.enc, new LinearLayout.LayoutParams(-1, -2));
        dR(context);
        dQ(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dP(Context context) {
        this.ena = new LinearLayout(getContext());
        this.ena.setGravity(16);
        this.ena.setOrientation(0);
        this.ena.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.ena.setLayoutParams(layoutParams);
        this.ena.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.emZ = new PbNewLocationInfoView(context);
        this.ena.addView(this.emZ, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.enb = new ImageView(context);
        this.enb.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.ena.addView(this.enb, layoutParams3);
        addView(this.ena);
        this.ena.setVisibility(8);
        this.enb.setOnClickListener(this);
    }

    private void dQ(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.bjq = new TextView(context);
        this.bjq.setGravity(17);
        this.bjq.setIncludeFontPadding(false);
        this.bjq.setEnabled(false);
        this.bjq.setAlpha(0.5f);
        this.bjq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bjq.setText(R.string.pb_send_post);
        this.bjq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds136), l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.bjq, layoutParams2);
        this.enc.addView(linearLayout, layoutParams);
    }

    private void dR(Context context) {
        this.emY = new EditText(context);
        this.emY.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.emY.setMaxLines(4);
        this.emY.setGravity(16);
        this.emY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.emY.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.emY.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.emY.setBackgroundResource(R.color.common_color_10022);
        e(this.emY, R.drawable.edittext_cursor);
        this.emY.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.emY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.emY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.emw) {
                    PbNewInputContainer.this.emw = true;
                    if (PbNewInputContainer.this.emx != -1) {
                        PbNewInputContainer.this.emY.setSelection(PbNewInputContainer.this.emx);
                        PbNewInputContainer.this.emx = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.enf)) {
                        if (PbNewInputContainer.this.ene == null) {
                            PbNewInputContainer.this.ene = new j();
                        }
                        PbNewInputContainer.this.ene.enD = PbNewInputContainer.this.enf.toString();
                        PbNewInputContainer.this.ene.mContent = PbNewInputContainer.this.emY.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ene));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.emY.getText().toString()));
                }
            }
        });
        this.emY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.emY.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.enc.addView(this.emY, layoutParams);
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
                    this.emY.getText().insert(this.emY.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void ye(String str) {
        if (!StringUtils.isNull(str)) {
            this.emY.getText().insert(this.emY.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).aYd() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).aYd() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.aYd() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.emY.getText().toString();
            if (this.emv && com.baidu.tieba.face.a.DQ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aUf().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.emY);
            }
        }
    }

    private void b(q qVar) {
        if (!this.emu || qVar.aYd() == EmotionGroupType.LOCAL) {
            String obj = this.emY.getText().toString();
            if (this.emv && com.baidu.tieba.face.a.DQ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aUf().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.emY);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.emu = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.emY != null && this.enc.getVisibility() == 0) {
            this.emY.setFocusable(true);
            this.emY.setFocusableInTouchMode(true);
            this.emY.requestFocus();
            l.showSoftKeyPad(getContext(), this.emY);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.emY, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.ena, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.enb, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.emY, R.drawable.edittext_cursor);
            this.emY.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.emY, R.drawable.edittext_cursor_1);
            this.emY.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.bjq, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.bjq, R.drawable.bg_comment_send);
        this.emZ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.emY.getSelectionStart() > 0) {
                        String substring = this.emY.getText().toString().substring(0, this.emY.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gZB.matcher(substring);
                        if (matcher.find()) {
                            this.emY.getText().delete(this.emY.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.emY.getSelectionStart());
                            break;
                        } else {
                            this.emY.getText().delete(this.emY.getSelectionStart() - 1, this.emY.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.emY.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.emY.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.emY.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.emY.setSelection(PbNewInputContainer.this.emY.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.enf = null;
                        if (this.eng != null) {
                            this.emY.setHint(this.eng);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).enD) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.emY.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.enD)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.enD, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.enf = spannableStringBuilder;
                                        PbNewInputContainer.this.emY.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.emY.setText("");
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
                                        PbNewInputContainer.this.emY.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.emY.setSelection(PbNewInputContainer.this.emY.getText().length());
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
                        this.ene = null;
                        this.enf = null;
                        this.emY.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eni[0] = 0;
                    this.eni[1] = 0;
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
                        if (aVar2.elV != null) {
                            if (aVar2.elV.getChosedFiles() != null) {
                                this.eni[0] = aVar2.elV.getChosedFiles().size();
                            } else {
                                this.eni[0] = 0;
                            }
                        }
                        if (this.eni[0] > 0) {
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
                    int[] iArr = this.eni;
                    iArr[0] = iArr[0] - 1;
                    if (this.eni[0] > 0) {
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
                        this.ena.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.ena.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.emZ.setState(aVar3.state, null);
                                break;
                            } else {
                                this.emZ.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.ena.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.ena.setVisibility(8);
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
                            ye((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            ye(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            np(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void np(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bjq.setEnabled(true);
                this.bjq.setAlpha(1.0f);
                return;
            }
            this.bjq.setEnabled(false);
            this.bjq.setAlpha(0.5f);
        } else if (i == enj) {
            if (this.flags[1]) {
                this.bjq.setEnabled(true);
                this.bjq.setAlpha(1.0f);
                return;
            }
            this.bjq.setEnabled(false);
            this.bjq.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.enh = z;
    }

    public void setHint(int i) {
        if (this.emY != null) {
            this.emY.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.emY != null) {
            this.emY.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.eng = str;
    }

    public EditText getInputView() {
        return this.emY;
    }

    public TextView getSendView() {
        return this.bjq;
    }

    public TextView getLocationInfoView() {
        return this.emZ;
    }

    public LinearLayout getInputLayout() {
        return this.enc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ena) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.enb) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
