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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools Qg;
    private int Qh;
    private boolean aND;
    private boolean aNE;
    private boolean aNF;
    private int aNG;
    private EditText aOf;
    private PbNewLocationInfoView aOg;
    private LinearLayout aOh;
    private ImageView aOi;
    private LinearLayout aOj;
    private boolean aOk;
    private boolean[] aOl;
    private int[] aOm;
    private int azI;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aOn = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aND = false;
        this.aNE = true;
        this.aNF = true;
        this.aNG = -1;
        this.aOk = true;
        this.aOl = new boolean[]{false, false, false, false, false};
        this.aOm = new int[]{0, 0};
        this.azI = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        bb(context);
        this.aOj = new LinearLayout(getContext());
        this.aOj.setOrientation(0);
        this.aOj.setMinimumHeight(com.baidu.adp.lib.util.l.f(context, d.e.ds90));
        addView(this.aOj, new LinearLayout.LayoutParams(-1, -2));
        bd(context);
        bc(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void bb(Context context) {
        this.aOh = new LinearLayout(getContext());
        this.aOh.setGravity(16);
        this.aOh.setOrientation(0);
        this.aOh.setPadding(com.baidu.adp.lib.util.l.f(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds34), com.baidu.adp.lib.util.l.f(context, d.e.ds30), com.baidu.adp.lib.util.l.f(context, d.e.ds34), com.baidu.adp.lib.util.l.f(context, d.e.ds12));
        this.aOh.setLayoutParams(layoutParams);
        this.aOh.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aOg = new PbNewLocationInfoView(context);
        this.aOh.addView(this.aOg, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aOi = new ImageView(context);
        this.aOi.setPadding(com.baidu.adp.lib.util.l.f(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.f(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aOh.addView(this.aOi, layoutParams3);
        addView(this.aOh);
        this.aOh.setVisibility(8);
        this.aOi.setOnClickListener(this);
    }

    private void bc(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.f(context, d.e.ds34), 0);
        this.aOj.addView(this.mSendView, layoutParams);
    }

    private void bd(Context context) {
        this.aOf = new EditText(context);
        this.aOf.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aOf.setMaxLines(4);
        this.aOf.setGravity(16);
        this.aOf.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aOf.setTextColor(getResources().getColor(d.C0140d.cp_cont_b));
        this.aOf.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        this.aOf.setBackgroundResource(d.C0140d.common_color_10022);
        a(this.aOf, d.f.edittext_cursor);
        this.aOf.setPadding(0, com.baidu.adp.lib.util.l.f(context, d.e.ds24), com.baidu.adp.lib.util.l.f(context, d.e.ds54), com.baidu.adp.lib.util.l.f(context, d.e.ds24));
        this.aOf.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aOf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aNF) {
                    PbNewInputContainer.this.aNF = true;
                    if (PbNewInputContainer.this.aNG != -1) {
                        PbNewInputContainer.this.aOf.setSelection(PbNewInputContainer.this.aNG);
                        PbNewInputContainer.this.aNG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aOf.getText().toString()));
                }
            }
        });
        this.aOf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aOf.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, d.e.ds34), 0, 0, 0);
        this.aOj.addView(this.aOf, layoutParams);
    }

    private void a(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void t(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.aOf.getText().insert(this.aOf.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            this.aOf.getText().insert(this.aOf.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Cl() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aOf.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lA(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ye().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aOf);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aND || nVar.Cl() == EmotionGroupType.LOCAL) {
            String obj = this.aOf.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lA(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ye().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aOf);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aND = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oF() {
        if (this.aOf != null && this.aOj.getVisibility() == 0) {
            this.aOf.setFocusable(true);
            this.aOf.setFocusableInTouchMode(true);
            this.aOf.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aOf);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.b(this.aOf, d.C0140d.cp_cont_b, 2, i);
        am.j(this.mBottomLine, d.C0140d.cp_bg_line_c);
        am.j(this, d.C0140d.cp_bg_line_d);
        am.i(this.aOh, d.f.pb_new_locatin_view_selector);
        am.c(this.aOi, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aOf, d.f.edittext_cursor);
            this.aOf.setHintTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_e));
        } else {
            a(this.aOf, d.f.edittext_cursor_1);
            this.aOf.setHintTextColor(am.getColor(i, d.C0140d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            am.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, i);
        } else {
            am.c(this.mSendView, d.C0140d.cp_cont_e, 1);
        }
        this.aOg.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aOf.getSelectionStart() > 0) {
                        String substring = this.aOf.getText().toString().substring(0, this.aOf.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cVj.matcher(substring);
                        if (matcher.find()) {
                            this.aOf.getText().delete(this.aOf.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aOf.getSelectionStart());
                            break;
                        } else {
                            this.aOf.getText().delete(this.aOf.getSelectionStart() - 1, this.aOf.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aOf.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aOf.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aOf.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aOf.setSelection(PbNewInputContainer.this.aOf.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aOl[0] = false;
                        break;
                    } else {
                        this.aOl[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aOf.setText((CharSequence) null);
                    }
                    this.aOl[0] = false;
                    this.aOl[1] = false;
                    this.aOl[2] = false;
                    this.aOl[3] = false;
                    this.aOl[4] = false;
                    this.aOm[0] = 0;
                    this.aOm[1] = 0;
                    break;
                case 10:
                    this.aOl[2] = true;
                    break;
                case 11:
                    this.aOl[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aNe != null) {
                            if (aVar2.aNe.getChosedFiles() != null) {
                                this.aOm[0] = aVar2.aNe.getChosedFiles().size();
                            } else {
                                this.aOm[0] = 0;
                            }
                        }
                        if (this.aOm[0] > 0) {
                            this.aOl[1] = true;
                            break;
                        } else {
                            this.aOl[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aOm;
                    iArr[0] = iArr[0] - 1;
                    if (this.aOm[0] > 0) {
                        this.aOl[1] = true;
                        break;
                    } else {
                        this.aOl[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        t((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.aOh.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.aOh.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aOg.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aOg.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aOh.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aOh.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aOl[3] = true;
                    break;
                case 29:
                    this.aOl[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gG((String) aVar.data);
                        break;
                    }
                    break;
            }
            eW(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eW(int i) {
        if (i == ALL) {
            if (this.aOl[0] || this.aOl[1] || this.aOl[2] || this.aOl[3] || this.aOl[4]) {
                this.mSendView.setEnabled(true);
                am.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            am.c(this.mSendView, d.C0140d.cp_cont_d, 1);
        } else if (i == aOn) {
            if (this.aOl[1]) {
                this.mSendView.setEnabled(true);
                am.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            am.c(this.mSendView, d.C0140d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aOk = z;
    }

    public void setHint(int i) {
        if (this.aOf != null) {
            this.aOf.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aOf != null) {
            this.aOf.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aOf;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aOg;
    }

    public LinearLayout getInputLayout() {
        return this.aOj;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aOh) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aOi) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
