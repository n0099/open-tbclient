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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, m {
    private EditorTools Fv;
    private int Fw;
    private int MH;
    private boolean dtS;
    private boolean dtT;
    private boolean dtU;
    private int dtV;
    private LinearLayout duA;
    private j duB;
    private SpannableStringBuilder duC;
    private String duD;
    private boolean duE;
    private int[] duF;
    private EditText duw;
    private PbNewLocationInfoView dux;
    private LinearLayout duy;
    private ImageView duz;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int duG = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtS = false;
        this.dtT = true;
        this.dtU = true;
        this.dtV = -1;
        this.duE = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.duF = new int[]{0, 0};
        this.MH = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dT(context);
        this.duA = new LinearLayout(getContext());
        this.duA.setOrientation(0);
        this.duA.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.duA, new LinearLayout.LayoutParams(-1, -2));
        dV(context);
        dU(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dT(Context context) {
        this.duy = new LinearLayout(getContext());
        this.duy.setGravity(16);
        this.duy.setOrientation(0);
        this.duy.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.duy.setLayoutParams(layoutParams);
        this.duy.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dux = new PbNewLocationInfoView(context);
        this.duy.addView(this.dux, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.duz = new ImageView(context);
        this.duz.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.duy.addView(this.duz, layoutParams3);
        addView(this.duy);
        this.duy.setVisibility(8);
        this.duz.setOnClickListener(this);
    }

    private void dU(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setAlpha(0.5f);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.mSendView.setText(R.string.pb_send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds136), l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.mSendView, layoutParams2);
        this.duA.addView(linearLayout, layoutParams);
    }

    private void dV(Context context) {
        this.duw = new EditText(context);
        this.duw.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.duw.setMaxLines(4);
        this.duw.setGravity(16);
        this.duw.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.duw.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.duw.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.duw.setBackgroundResource(R.color.common_color_10022);
        e(this.duw, R.drawable.edittext_cursor);
        this.duw.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.duw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.duw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dtU) {
                    PbNewInputContainer.this.dtU = true;
                    if (PbNewInputContainer.this.dtV != -1) {
                        PbNewInputContainer.this.duw.setSelection(PbNewInputContainer.this.dtV);
                        PbNewInputContainer.this.dtV = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.duC)) {
                        if (PbNewInputContainer.this.duB == null) {
                            PbNewInputContainer.this.duB = new j();
                        }
                        PbNewInputContainer.this.duB.duZ = PbNewInputContainer.this.duC.toString();
                        PbNewInputContainer.this.duB.mContent = PbNewInputContainer.this.duw.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.duB));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.duw.getText().toString()));
                }
            }
        });
        this.duw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.duw.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.duA.addView(this.duw, layoutParams);
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

    private void D(ArrayList<String> arrayList) {
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
                    this.duw.getText().insert(this.duw.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void uQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.duw.getText().insert(this.duw.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).aHc() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).aHc() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.aHc() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.duw.getText().toString();
            if (this.dtT && com.baidu.tieba.face.a.Ab(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aDz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.duw);
            }
        }
    }

    private void b(p pVar) {
        if (!this.dtS || pVar.aHc() == EmotionGroupType.LOCAL) {
            String obj = this.duw.getText().toString();
            if (this.dtT && com.baidu.tieba.face.a.Ab(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aDz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.duw);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dtS = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.duw != null && this.duA.getVisibility() == 0) {
            this.duw.setFocusable(true);
            this.duw.setFocusableInTouchMode(true);
            this.duw.requestFocus();
            l.showSoftKeyPad(getContext(), this.duw);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.duw, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.duy, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.duz, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.duw, R.drawable.edittext_cursor);
            this.duw.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.duw, R.drawable.edittext_cursor_1);
            this.duw.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.mSendView, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.mSendView, R.drawable.bg_comment_send);
        this.dux.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.duw.getSelectionStart() > 0) {
                        String substring = this.duw.getText().toString().substring(0, this.duw.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fYs.matcher(substring);
                        if (matcher.find()) {
                            this.duw.getText().delete(this.duw.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.duw.getSelectionStart());
                            break;
                        } else {
                            this.duw.getText().delete(this.duw.getSelectionStart() - 1, this.duw.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.duw.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.duw.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.duw.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.duw.setSelection(PbNewInputContainer.this.duw.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.duC = null;
                        if (this.duD != null) {
                            this.duw.setHint(this.duD);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).duZ) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.duw.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.duZ)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.duZ, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.duC = spannableStringBuilder;
                                        PbNewInputContainer.this.duw.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.duw.setText("");
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
                                        PbNewInputContainer.this.duw.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.duw.setSelection(PbNewInputContainer.this.duw.getText().length());
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
                        this.duB = null;
                        this.duC = null;
                        this.duw.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.duF[0] = 0;
                    this.duF[1] = 0;
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
                        if (aVar2.dtt != null) {
                            if (aVar2.dtt.getChosedFiles() != null) {
                                this.duF[0] = aVar2.dtt.getChosedFiles().size();
                            } else {
                                this.duF[0] = 0;
                            }
                        }
                        if (this.duF[0] > 0) {
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
                    int[] iArr = this.duF;
                    iArr[0] = iArr[0] - 1;
                    if (this.duF[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        D((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.duy.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.duy.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dux.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dux.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.duy.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.duy.setVisibility(8);
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
                            uQ((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            uQ(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            mf(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mf(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == duG) {
            if (this.flags[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.duE = z;
    }

    public void setHint(int i) {
        if (this.duw != null) {
            this.duw.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.duw != null) {
            this.duw.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.duD = str;
    }

    public EditText getInputView() {
        return this.duw;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.dux;
    }

    public LinearLayout getInputLayout() {
        return this.duA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.duy) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.duz) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
