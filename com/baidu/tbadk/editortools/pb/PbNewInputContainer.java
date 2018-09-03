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
import com.baidu.tieba.f;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools Qg;
    private int Qh;
    private boolean aNA;
    private boolean aNB;
    private boolean aNC;
    private int aND;
    private EditText aOc;
    private PbNewLocationInfoView aOd;
    private LinearLayout aOe;
    private ImageView aOf;
    private LinearLayout aOg;
    private boolean aOh;
    private boolean[] aOi;
    private int[] aOj;
    private int azF;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aOk = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNA = false;
        this.aNB = true;
        this.aNC = true;
        this.aND = -1;
        this.aOh = true;
        this.aOi = new boolean[]{false, false, false, false, false};
        this.aOj = new int[]{0, 0};
        this.azF = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(f.e.ds90));
        ba(context);
        this.aOg = new LinearLayout(getContext());
        this.aOg.setOrientation(0);
        this.aOg.setMinimumHeight(com.baidu.adp.lib.util.l.f(context, f.e.ds90));
        addView(this.aOg, new LinearLayout.LayoutParams(-1, -2));
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.f(getContext(), f.e.ds1)));
        addView(this.mBottomLine);
    }

    private void ba(Context context) {
        this.aOe = new LinearLayout(getContext());
        this.aOe.setGravity(16);
        this.aOe.setOrientation(0);
        this.aOe.setPadding(com.baidu.adp.lib.util.l.f(context, f.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.f(context, f.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, f.e.ds34), com.baidu.adp.lib.util.l.f(context, f.e.ds30), com.baidu.adp.lib.util.l.f(context, f.e.ds34), com.baidu.adp.lib.util.l.f(context, f.e.ds12));
        this.aOe.setLayoutParams(layoutParams);
        this.aOe.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aOd = new PbNewLocationInfoView(context);
        this.aOe.addView(this.aOd, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(f.e.ds24);
        this.aOf = new ImageView(context);
        this.aOf.setPadding(com.baidu.adp.lib.util.l.f(context, f.e.ds24), 0, com.baidu.adp.lib.util.l.f(context, f.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aOe.addView(this.aOf, layoutParams3);
        addView(this.aOe);
        this.aOe.setVisibility(8);
        this.aOf.setOnClickListener(this);
    }

    private void bb(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(f.e.fontsize32));
        this.mSendView.setText(f.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.f(context, f.e.ds34), 0);
        this.aOg.addView(this.mSendView, layoutParams);
    }

    private void bc(Context context) {
        this.aOc = new EditText(context);
        this.aOc.setMinHeight(context.getResources().getDimensionPixelSize(f.e.ds32));
        this.aOc.setMaxLines(4);
        this.aOc.setGravity(16);
        this.aOc.setTextSize(0, getResources().getDimensionPixelSize(f.e.ds32));
        this.aOc.setTextColor(getResources().getColor(f.d.cp_cont_b));
        this.aOc.setHintTextColor(getResources().getColor(f.d.cp_cont_e));
        this.aOc.setBackgroundResource(f.d.common_color_10022);
        a(this.aOc, f.C0146f.edittext_cursor);
        this.aOc.setPadding(0, com.baidu.adp.lib.util.l.f(context, f.e.ds24), com.baidu.adp.lib.util.l.f(context, f.e.ds54), com.baidu.adp.lib.util.l.f(context, f.e.ds24));
        this.aOc.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aOc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aNC) {
                    PbNewInputContainer.this.aNC = true;
                    if (PbNewInputContainer.this.aND != -1) {
                        PbNewInputContainer.this.aOc.setSelection(PbNewInputContainer.this.aND);
                        PbNewInputContainer.this.aND = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aOc.getText().toString()));
                }
            }
        });
        this.aOc.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aOc.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.f(context, f.e.ds34), 0, 0, 0);
        this.aOg.addView(this.aOc, layoutParams);
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
                    this.aOc.getText().insert(this.aOc.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            this.aOc.getText().insert(this.aOc.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Ci() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aOc.getText().toString();
            if (this.aNB && com.baidu.tieba.face.a.lC(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.yd().showToast(f.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aOc);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aNA || nVar.Ci() == EmotionGroupType.LOCAL) {
            String obj = this.aOc.getText().toString();
            if (this.aNB && com.baidu.tieba.face.a.lC(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.yd().showToast(f.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aOc);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aNA = z;
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
    public void oC() {
        if (this.aOc != null && this.aOg.getVisibility() == 0) {
            this.aOc.setFocusable(true);
            this.aOc.setFocusableInTouchMode(true);
            this.aOc.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aOc);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.b(this.aOc, f.d.cp_cont_b, 2, i);
        am.j(this.mBottomLine, f.d.cp_bg_line_c);
        am.j(this, f.d.cp_bg_line_d);
        am.i(this.aOe, f.C0146f.pb_new_locatin_view_selector);
        am.c(this.aOf, f.C0146f.icon_edit_close_n);
        if (i == 0) {
            a(this.aOc, f.C0146f.edittext_cursor);
            this.aOc.setHintTextColor(getContext().getResources().getColor(f.d.cp_cont_e));
        } else {
            a(this.aOc, f.C0146f.edittext_cursor_1);
            this.aOc.setHintTextColor(am.getColor(i, f.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            am.b(this.mSendView, f.d.cp_link_tip_a, 1, i);
        } else {
            am.c(this.mSendView, f.d.cp_cont_e, 1);
        }
        this.aOd.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aOc.getSelectionStart() > 0) {
                        String substring = this.aOc.getText().toString().substring(0, this.aOc.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cVf.matcher(substring);
                        if (matcher.find()) {
                            this.aOc.getText().delete(this.aOc.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aOc.getSelectionStart());
                            break;
                        } else {
                            this.aOc.getText().delete(this.aOc.getSelectionStart() - 1, this.aOc.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aOc.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aOc.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aOc.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aOc.setSelection(PbNewInputContainer.this.aOc.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aOi[0] = false;
                        break;
                    } else {
                        this.aOi[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aOc.setText((CharSequence) null);
                    }
                    this.aOi[0] = false;
                    this.aOi[1] = false;
                    this.aOi[2] = false;
                    this.aOi[3] = false;
                    this.aOi[4] = false;
                    this.aOj[0] = 0;
                    this.aOj[1] = 0;
                    break;
                case 10:
                    this.aOi[2] = true;
                    break;
                case 11:
                    this.aOi[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aNb != null) {
                            if (aVar2.aNb.getChosedFiles() != null) {
                                this.aOj[0] = aVar2.aNb.getChosedFiles().size();
                            } else {
                                this.aOj[0] = 0;
                            }
                        }
                        if (this.aOj[0] > 0) {
                            this.aOi[1] = true;
                            break;
                        } else {
                            this.aOi[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aOj;
                    iArr[0] = iArr[0] - 1;
                    if (this.aOj[0] > 0) {
                        this.aOi[1] = true;
                        break;
                    } else {
                        this.aOi[1] = false;
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
                        this.aOe.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.aOe.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aOd.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aOd.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aOe.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aOe.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aOi[3] = true;
                    break;
                case 29:
                    this.aOi[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gG((String) aVar.data);
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
            if (this.aOi[0] || this.aOi[1] || this.aOi[2] || this.aOi[3] || this.aOi[4]) {
                this.mSendView.setEnabled(true);
                am.b(this.mSendView, f.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            am.c(this.mSendView, f.d.cp_cont_d, 1);
        } else if (i == aOk) {
            if (this.aOi[1]) {
                this.mSendView.setEnabled(true);
                am.b(this.mSendView, f.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            am.c(this.mSendView, f.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aOh = z;
    }

    public void setHint(int i) {
        if (this.aOc != null) {
            this.aOc.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aOc != null) {
            this.aOc.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aOc;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aOd;
    }

    public LinearLayout getInputLayout() {
        return this.aOg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aOe) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aOf) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
