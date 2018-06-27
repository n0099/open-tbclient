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
    private EditorTools Qj;
    private int Qk;
    private boolean aND;
    private boolean aNE;
    private boolean aNF;
    private int aNG;
    private EditText aOg;
    private PbNewLocationInfoView aOh;
    private LinearLayout aOi;
    private ImageView aOj;
    private LinearLayout aOk;
    private boolean aOl;
    private boolean[] aOm;
    private int[] aOn;
    private int azP;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aOo = 1;
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
        this.aOl = true;
        this.aOm = new boolean[]{false, false, false, false, false};
        this.aOn = new int[]{0, 0};
        this.azP = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        ba(context);
        this.aOk = new LinearLayout(getContext());
        this.aOk.setOrientation(0);
        this.aOk.setMinimumHeight(com.baidu.adp.lib.util.l.e(context, d.e.ds90));
        addView(this.aOk, new LinearLayout.LayoutParams(-1, -2));
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void ba(Context context) {
        this.aOi = new LinearLayout(getContext());
        this.aOi.setGravity(16);
        this.aOi.setOrientation(0);
        this.aOi.setPadding(com.baidu.adp.lib.util.l.e(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.e(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds34), com.baidu.adp.lib.util.l.e(context, d.e.ds30), com.baidu.adp.lib.util.l.e(context, d.e.ds34), com.baidu.adp.lib.util.l.e(context, d.e.ds12));
        this.aOi.setLayoutParams(layoutParams);
        this.aOi.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aOh = new PbNewLocationInfoView(context);
        this.aOi.addView(this.aOh, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aOj = new ImageView(context);
        this.aOj.setPadding(com.baidu.adp.lib.util.l.e(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aOi.addView(this.aOj, layoutParams3);
        addView(this.aOi);
        this.aOi.setVisibility(8);
        this.aOj.setOnClickListener(this);
    }

    private void bb(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.k.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.e(context, d.e.ds34), 0);
        this.aOk.addView(this.mSendView, layoutParams);
    }

    private void bc(Context context) {
        this.aOg = new EditText(context);
        this.aOg.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aOg.setMaxLines(4);
        this.aOg.setGravity(16);
        this.aOg.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aOg.setTextColor(getResources().getColor(d.C0142d.cp_cont_b));
        this.aOg.setHintTextColor(getResources().getColor(d.C0142d.cp_cont_e));
        this.aOg.setBackgroundResource(d.C0142d.common_color_10022);
        a(this.aOg, d.f.edittext_cursor);
        this.aOg.setPadding(0, com.baidu.adp.lib.util.l.e(context, d.e.ds24), com.baidu.adp.lib.util.l.e(context, d.e.ds54), com.baidu.adp.lib.util.l.e(context, d.e.ds24));
        this.aOg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aOg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aNF) {
                    PbNewInputContainer.this.aNF = true;
                    if (PbNewInputContainer.this.aNG != -1) {
                        PbNewInputContainer.this.aOg.setSelection(PbNewInputContainer.this.aNG);
                        PbNewInputContainer.this.aNG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aOg.getText().toString()));
                }
            }
        });
        this.aOg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aOg.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds34), 0, 0, 0);
        this.aOk.addView(this.aOg, layoutParams);
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
                    this.aOg.getText().insert(this.aOg.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gK(String str) {
        if (!StringUtils.isNull(str)) {
            this.aOg.getText().insert(this.aOg.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Ct() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aOg.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lB(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ym().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aOg);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aND || nVar.Ct() == EmotionGroupType.LOCAL) {
            String obj = this.aOg.getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lB(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ym().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aOg);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aND = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.aOg != null && this.aOk.getVisibility() == 0) {
            this.aOg.setFocusable(true);
            this.aOg.setFocusableInTouchMode(true);
            this.aOg.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aOg);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.b(this.aOg, d.C0142d.cp_cont_b, 2, i);
        am.j(this.mBottomLine, d.C0142d.cp_bg_line_c);
        am.j(this, d.C0142d.cp_bg_line_d);
        am.i(this.aOi, d.f.pb_new_locatin_view_selector);
        am.c(this.aOj, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aOg, d.f.edittext_cursor);
            this.aOg.setHintTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_e));
        } else {
            a(this.aOg, d.f.edittext_cursor_1);
            this.aOg.setHintTextColor(am.getColor(i, d.C0142d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            am.b(this.mSendView, d.C0142d.cp_link_tip_a, 1, i);
        } else {
            am.c(this.mSendView, d.C0142d.cp_cont_e, 1);
        }
        this.aOh.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aOg.getSelectionStart() > 0) {
                        String substring = this.aOg.getText().toString().substring(0, this.aOg.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cSw.matcher(substring);
                        if (matcher.find()) {
                            this.aOg.getText().delete(this.aOg.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aOg.getSelectionStart());
                            break;
                        } else {
                            this.aOg.getText().delete(this.aOg.getSelectionStart() - 1, this.aOg.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aOg.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aOg.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aOg.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aOg.setSelection(PbNewInputContainer.this.aOg.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aOm[0] = false;
                        break;
                    } else {
                        this.aOm[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aOg.setText((CharSequence) null);
                    }
                    this.aOm[0] = false;
                    this.aOm[1] = false;
                    this.aOm[2] = false;
                    this.aOm[3] = false;
                    this.aOm[4] = false;
                    this.aOn[0] = 0;
                    this.aOn[1] = 0;
                    break;
                case 10:
                    this.aOm[2] = true;
                    break;
                case 11:
                    this.aOm[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aNe != null) {
                            if (aVar2.aNe.getChosedFiles() != null) {
                                this.aOn[0] = aVar2.aNe.getChosedFiles().size();
                            } else {
                                this.aOn[0] = 0;
                            }
                        }
                        if (this.aOn[0] > 0) {
                            this.aOm[1] = true;
                            break;
                        } else {
                            this.aOm[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aOn;
                    iArr[0] = iArr[0] - 1;
                    if (this.aOn[0] > 0) {
                        this.aOm[1] = true;
                        break;
                    } else {
                        this.aOm[1] = false;
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
                        this.aOi.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.aNI) {
                            this.aOi.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aOh.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aOh.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aOi.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aOi.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aOm[3] = true;
                    break;
                case 29:
                    this.aOm[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gK((String) aVar.data);
                        break;
                    }
                    break;
            }
            eV(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eV(int i) {
        if (i == ALL) {
            if (this.aOm[0] || this.aOm[1] || this.aOm[2] || this.aOm[3] || this.aOm[4]) {
                this.mSendView.setEnabled(true);
                am.b(this.mSendView, d.C0142d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            am.c(this.mSendView, d.C0142d.cp_cont_d, 1);
        } else if (i == aOo) {
            if (this.aOm[1]) {
                this.mSendView.setEnabled(true);
                am.b(this.mSendView, d.C0142d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            am.c(this.mSendView, d.C0142d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aOl = z;
    }

    public void setHint(int i) {
        if (this.aOg != null) {
            this.aOg.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aOg != null) {
            this.aOg.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aOg;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aOh;
    }

    public LinearLayout getInputLayout() {
        return this.aOk;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aOi) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aOj) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
