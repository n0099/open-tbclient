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
    private EditorTools Fq;
    private int Fr;
    private int MA;
    private boolean dtH;
    private boolean dtI;
    private boolean dtJ;
    private int dtK;
    private EditText dul;
    private PbNewLocationInfoView dum;
    private LinearLayout dun;
    private ImageView duo;
    private LinearLayout dup;
    private j duq;
    private SpannableStringBuilder dur;
    private String dus;
    private boolean dut;
    private boolean[] duu;
    private int[] duv;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int duw = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtH = false;
        this.dtI = true;
        this.dtJ = true;
        this.dtK = -1;
        this.dut = true;
        this.duu = new boolean[]{false, false, false, false, false};
        this.duv = new int[]{0, 0};
        this.MA = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dT(context);
        this.dup = new LinearLayout(getContext());
        this.dup.setOrientation(0);
        this.dup.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.dup, new LinearLayout.LayoutParams(-1, -2));
        dV(context);
        dU(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dT(Context context) {
        this.dun = new LinearLayout(getContext());
        this.dun.setGravity(16);
        this.dun.setOrientation(0);
        this.dun.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.dun.setLayoutParams(layoutParams);
        this.dun.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dum = new PbNewLocationInfoView(context);
        this.dun.addView(this.dum, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.duo = new ImageView(context);
        this.duo.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.dun.addView(this.duo, layoutParams3);
        addView(this.dun);
        this.dun.setVisibility(8);
        this.duo.setOnClickListener(this);
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
        this.dup.addView(linearLayout, layoutParams);
    }

    private void dV(Context context) {
        this.dul = new EditText(context);
        this.dul.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dul.setMaxLines(4);
        this.dul.setGravity(16);
        this.dul.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dul.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dul.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dul.setBackgroundResource(R.color.common_color_10022);
        e(this.dul, R.drawable.edittext_cursor);
        this.dul.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dul.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dul.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dtJ) {
                    PbNewInputContainer.this.dtJ = true;
                    if (PbNewInputContainer.this.dtK != -1) {
                        PbNewInputContainer.this.dul.setSelection(PbNewInputContainer.this.dtK);
                        PbNewInputContainer.this.dtK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.dur)) {
                        if (PbNewInputContainer.this.duq == null) {
                            PbNewInputContainer.this.duq = new j();
                        }
                        PbNewInputContainer.this.duq.duP = PbNewInputContainer.this.dur.toString();
                        PbNewInputContainer.this.duq.mContent = PbNewInputContainer.this.dul.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.duq));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dul.getText().toString()));
                }
            }
        });
        this.dul.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.dul.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.dup.addView(this.dul, layoutParams);
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
                    this.dul.getText().insert(this.dul.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void uL(String str) {
        if (!StringUtils.isNull(str)) {
            this.dul.getText().insert(this.dul.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).aGJ() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).aGJ() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.aGJ() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.dul.getText().toString();
            if (this.dtI && com.baidu.tieba.face.a.zR(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aDg().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.dul);
            }
        }
    }

    private void b(p pVar) {
        if (!this.dtH || pVar.aGJ() == EmotionGroupType.LOCAL) {
            String obj = this.dul.getText().toString();
            if (this.dtI && com.baidu.tieba.face.a.zR(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aDg().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.dul);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dtH = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fq != null) {
            this.Fq.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fr = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fr;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void lw() {
        if (this.dul != null && this.dup.getVisibility() == 0) {
            this.dul.setFocusable(true);
            this.dul.setFocusableInTouchMode(true);
            this.dul.requestFocus();
            l.showSoftKeyPad(getContext(), this.dul);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dul, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.dun, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.duo, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.dul, R.drawable.edittext_cursor);
            this.dul.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dul, R.drawable.edittext_cursor_1);
            this.dul.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.mSendView, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.mSendView, R.drawable.bg_comment_send);
        this.dum.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dul.getSelectionStart() > 0) {
                        String substring = this.dul.getText().toString().substring(0, this.dul.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fVj.matcher(substring);
                        if (matcher.find()) {
                            this.dul.getText().delete(this.dul.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dul.getSelectionStart());
                            break;
                        } else {
                            this.dul.getText().delete(this.dul.getSelectionStart() - 1, this.dul.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dul.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dul.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.dul.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.dul.setSelection(PbNewInputContainer.this.dul.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.dur = null;
                        if (this.dus != null) {
                            this.dul.setHint(this.dus);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).duP) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.dul.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.duP)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.duP, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dur = spannableStringBuilder;
                                        PbNewInputContainer.this.dul.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.dul.setText("");
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
                                        PbNewInputContainer.this.dul.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.dul.setSelection(PbNewInputContainer.this.dul.getText().length());
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
                        this.duu[0] = false;
                        break;
                    } else {
                        this.duu[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.duq = null;
                        this.dur = null;
                        this.dul.setText((CharSequence) null);
                    }
                    this.duu[0] = false;
                    this.duu[1] = false;
                    this.duu[2] = false;
                    this.duu[3] = false;
                    this.duu[4] = false;
                    this.duv[0] = 0;
                    this.duv[1] = 0;
                    break;
                case 10:
                    this.duu[2] = true;
                    break;
                case 11:
                    this.duu[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dti != null) {
                            if (aVar2.dti.getChosedFiles() != null) {
                                this.duv[0] = aVar2.dti.getChosedFiles().size();
                            } else {
                                this.duv[0] = 0;
                            }
                        }
                        if (this.duv[0] > 0) {
                            this.duu[1] = true;
                            break;
                        } else {
                            this.duu[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.duv;
                    iArr[0] = iArr[0] - 1;
                    if (this.duv[0] > 0) {
                        this.duu[1] = true;
                        break;
                    } else {
                        this.duu[1] = false;
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
                        this.dun.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.dun.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dum.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dum.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.dun.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.dun.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.duu[3] = true;
                    break;
                case 29:
                    this.duu[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            uL((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            uL(((j) aVar.data).mContent);
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
            if (this.duu[0] || this.duu[1] || this.duu[2] || this.duu[3] || this.duu[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == duw) {
            if (this.duu[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.dut = z;
    }

    public void setHint(int i) {
        if (this.dul != null) {
            this.dul.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dul != null) {
            this.dul.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.dus = str;
    }

    public EditText getInputView() {
        return this.dul;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.dum;
    }

    public LinearLayout getInputLayout() {
        return this.dup;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dun) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.duo) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
