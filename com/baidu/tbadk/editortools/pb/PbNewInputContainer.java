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
    private EditorTools Zd;
    private int Ze;
    private int afW;
    private TextView bbQ;
    private EditText dYP;
    private PbNewLocationInfoView dYQ;
    private LinearLayout dYR;
    private ImageView dYS;
    private LinearLayout dYT;
    private j dYU;
    private SpannableStringBuilder dYV;
    private String dYW;
    private boolean dYX;
    private int[] dYY;
    private boolean dYl;
    private boolean dYm;
    private boolean dYn;
    private int dYo;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int dYZ = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYl = false;
        this.dYm = true;
        this.dYn = true;
        this.dYo = -1;
        this.dYX = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dYY = new int[]{0, 0};
        this.afW = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dy(context);
        this.dYT = new LinearLayout(getContext());
        this.dYT.setOrientation(0);
        this.dYT.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.dYT, new LinearLayout.LayoutParams(-1, -2));
        dA(context);
        dz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dy(Context context) {
        this.dYR = new LinearLayout(getContext());
        this.dYR.setGravity(16);
        this.dYR.setOrientation(0);
        this.dYR.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.dYR.setLayoutParams(layoutParams);
        this.dYR.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dYQ = new PbNewLocationInfoView(context);
        this.dYR.addView(this.dYQ, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.dYS = new ImageView(context);
        this.dYS.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.dYR.addView(this.dYS, layoutParams3);
        addView(this.dYR);
        this.dYR.setVisibility(8);
        this.dYS.setOnClickListener(this);
    }

    private void dz(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.bbQ = new TextView(context);
        this.bbQ.setGravity(17);
        this.bbQ.setIncludeFontPadding(false);
        this.bbQ.setEnabled(false);
        this.bbQ.setAlpha(0.5f);
        this.bbQ.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.bbQ.setText(R.string.pb_send_post);
        this.bbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds136), l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.bbQ, layoutParams2);
        this.dYT.addView(linearLayout, layoutParams);
    }

    private void dA(Context context) {
        this.dYP = new EditText(context);
        this.dYP.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYP.setMaxLines(4);
        this.dYP.setGravity(16);
        this.dYP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYP.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dYP.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dYP.setBackgroundResource(R.color.common_color_10022);
        e(this.dYP, R.drawable.edittext_cursor);
        this.dYP.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dYP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dYP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dYn) {
                    PbNewInputContainer.this.dYn = true;
                    if (PbNewInputContainer.this.dYo != -1) {
                        PbNewInputContainer.this.dYP.setSelection(PbNewInputContainer.this.dYo);
                        PbNewInputContainer.this.dYo = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.dYV)) {
                        if (PbNewInputContainer.this.dYU == null) {
                            PbNewInputContainer.this.dYU = new j();
                        }
                        PbNewInputContainer.this.dYU.dZs = PbNewInputContainer.this.dYV.toString();
                        PbNewInputContainer.this.dYU.mContent = PbNewInputContainer.this.dYP.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dYU));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dYP.getText().toString()));
                }
            }
        });
        this.dYP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.dYP.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.dYT.addView(this.dYP, layoutParams);
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
                    this.dYP.getText().insert(this.dYP.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void wy(String str) {
        if (!StringUtils.isNull(str)) {
            this.dYP.getText().insert(this.dYP.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).aRV() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).aRV() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.aRV() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dYP.getText().toString();
            if (this.dYm && com.baidu.tieba.face.a.Ch(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOb().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dYP);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dYl || qVar.aRV() == EmotionGroupType.LOCAL) {
            String obj = this.dYP.getText().toString();
            if (this.dYm && com.baidu.tieba.face.a.Ch(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOb().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dYP);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dYl = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dYP != null && this.dYT.getVisibility() == 0) {
            this.dYP.setFocusable(true);
            this.dYP.setFocusableInTouchMode(true);
            this.dYP.requestFocus();
            l.showSoftKeyPad(getContext(), this.dYP);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dYP, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.dYR, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.dYS, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.dYP, R.drawable.edittext_cursor);
            this.dYP.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dYP, R.drawable.edittext_cursor_1);
            this.dYP.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.bbQ, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.bbQ, R.drawable.bg_comment_send);
        this.dYQ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dYP.getSelectionStart() > 0) {
                        String substring = this.dYP.getText().toString().substring(0, this.dYP.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gKE.matcher(substring);
                        if (matcher.find()) {
                            this.dYP.getText().delete(this.dYP.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dYP.getSelectionStart());
                            break;
                        } else {
                            this.dYP.getText().delete(this.dYP.getSelectionStart() - 1, this.dYP.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dYP.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dYP.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.dYP.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.dYP.setSelection(PbNewInputContainer.this.dYP.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.dYV = null;
                        if (this.dYW != null) {
                            this.dYP.setHint(this.dYW);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).dZs) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.dYP.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.dZs)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.dZs, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dYV = spannableStringBuilder;
                                        PbNewInputContainer.this.dYP.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.dYP.setText("");
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
                                        PbNewInputContainer.this.dYP.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.dYP.setSelection(PbNewInputContainer.this.dYP.getText().length());
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
                        this.dYU = null;
                        this.dYV = null;
                        this.dYP.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dYY[0] = 0;
                    this.dYY[1] = 0;
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
                        if (aVar2.dXM != null) {
                            if (aVar2.dXM.getChosedFiles() != null) {
                                this.dYY[0] = aVar2.dXM.getChosedFiles().size();
                            } else {
                                this.dYY[0] = 0;
                            }
                        }
                        if (this.dYY[0] > 0) {
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
                    int[] iArr = this.dYY;
                    iArr[0] = iArr[0] - 1;
                    if (this.dYY[0] > 0) {
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
                        this.dYR.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.dYR.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dYQ.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dYQ.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.dYR.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.dYR.setVisibility(8);
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
                            wy((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            wy(((j) aVar.data).mContent);
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
                this.bbQ.setEnabled(true);
                this.bbQ.setAlpha(1.0f);
                return;
            }
            this.bbQ.setEnabled(false);
            this.bbQ.setAlpha(0.5f);
        } else if (i == dYZ) {
            if (this.flags[1]) {
                this.bbQ.setEnabled(true);
                this.bbQ.setAlpha(1.0f);
                return;
            }
            this.bbQ.setEnabled(false);
            this.bbQ.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.dYX = z;
    }

    public void setHint(int i) {
        if (this.dYP != null) {
            this.dYP.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dYP != null) {
            this.dYP.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.dYW = str;
    }

    public EditText getInputView() {
        return this.dYP;
    }

    public TextView getSendView() {
        return this.bbQ;
    }

    public TextView getLocationInfoView() {
        return this.dYQ;
    }

    public LinearLayout getInputLayout() {
        return this.dYT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dYR) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.dYS) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
