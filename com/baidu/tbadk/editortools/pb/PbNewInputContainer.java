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
import com.baidu.tbadk.core.util.ak;
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
    private EditorTools JO;
    private int JP;
    private EditText aEO;
    private PbNewLocationInfoView aEP;
    private LinearLayout aEQ;
    private ImageView aER;
    private LinearLayout aES;
    private boolean aET;
    private boolean[] aEU;
    private int[] aEV;
    private boolean aEl;
    private boolean aEm;
    private boolean aEn;
    private int aEo;
    private int aqQ;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aEW = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aEl = false;
        this.aEm = true;
        this.aEn = true;
        this.aEo = -1;
        this.aET = true;
        this.aEU = new boolean[]{false, false, false, false, false};
        this.aEV = new int[]{0, 0};
        this.aqQ = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        aQ(context);
        this.aES = new LinearLayout(getContext());
        this.aES.setOrientation(0);
        this.aES.setMinimumHeight(com.baidu.adp.lib.util.l.e(context, d.e.ds90));
        addView(this.aES, new LinearLayout.LayoutParams(-1, -2));
        aS(context);
        aR(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void aQ(Context context) {
        this.aEQ = new LinearLayout(getContext());
        this.aEQ.setGravity(16);
        this.aEQ.setOrientation(0);
        this.aEQ.setPadding(com.baidu.adp.lib.util.l.e(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.e(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds34), com.baidu.adp.lib.util.l.e(context, d.e.ds30), com.baidu.adp.lib.util.l.e(context, d.e.ds34), com.baidu.adp.lib.util.l.e(context, d.e.ds12));
        this.aEQ.setLayoutParams(layoutParams);
        this.aEQ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aEP = new PbNewLocationInfoView(context);
        this.aEQ.addView(this.aEP, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aER = new ImageView(context);
        this.aER.setPadding(com.baidu.adp.lib.util.l.e(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aEQ.addView(this.aER, layoutParams3);
        addView(this.aEQ);
        this.aEQ.setVisibility(8);
        this.aER.setOnClickListener(this);
    }

    private void aR(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.k.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.e(context, d.e.ds34), 0);
        this.aES.addView(this.mSendView, layoutParams);
    }

    private void aS(Context context) {
        this.aEO = new EditText(context);
        this.aEO.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aEO.setMaxLines(4);
        this.aEO.setGravity(16);
        this.aEO.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aEO.setTextColor(getResources().getColor(d.C0126d.cp_cont_b));
        this.aEO.setHintTextColor(getResources().getColor(d.C0126d.cp_cont_e));
        this.aEO.setBackgroundResource(d.C0126d.common_color_10022);
        a(this.aEO, d.f.edittext_cursor);
        this.aEO.setPadding(0, com.baidu.adp.lib.util.l.e(context, d.e.ds24), com.baidu.adp.lib.util.l.e(context, d.e.ds54), com.baidu.adp.lib.util.l.e(context, d.e.ds24));
        this.aEO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aEO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aEn) {
                    PbNewInputContainer.this.aEn = true;
                    if (PbNewInputContainer.this.aEo != -1) {
                        PbNewInputContainer.this.aEO.setSelection(PbNewInputContainer.this.aEo);
                        PbNewInputContainer.this.aEo = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aEO.getText().toString()));
                }
            }
        });
        this.aEO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aEO.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds34), 0, 0, 0);
        this.aES.addView(this.aEO, layoutParams);
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

    private void p(ArrayList<String> arrayList) {
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
                    this.aEO.getText().insert(this.aEO.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gh(String str) {
        if (!StringUtils.isNull(str)) {
            this.aEO.getText().insert(this.aEO.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.yB() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aEO.getText().toString();
            if (this.aEm && com.baidu.tieba.face.a.kZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.uA().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aEO);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aEl || nVar.yB() == EmotionGroupType.LOCAL) {
            String obj = this.aEO.getText().toString();
            if (this.aEm && com.baidu.tieba.face.a.kZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.uA().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aEO);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aEl = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lM() {
        if (this.aEO != null && this.aES.getVisibility() == 0) {
            this.aEO.setFocusable(true);
            this.aEO.setFocusableInTouchMode(true);
            this.aEO.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aEO);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        ak.b(this.aEO, d.C0126d.cp_cont_b, 2, i);
        ak.j(this.mBottomLine, d.C0126d.cp_bg_line_c);
        ak.j(this, d.C0126d.cp_bg_line_d);
        ak.i(this.aEQ, d.f.pb_new_locatin_view_selector);
        ak.c(this.aER, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aEO, d.f.edittext_cursor);
            this.aEO.setHintTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_e));
        } else {
            a(this.aEO, d.f.edittext_cursor_1);
            this.aEO.setHintTextColor(ak.getColor(i, d.C0126d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            ak.b(this.mSendView, d.C0126d.cp_link_tip_a, 1, i);
        } else {
            ak.c(this.mSendView, d.C0126d.cp_cont_e, 1);
        }
        this.aEP.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aEO.getSelectionStart() > 0) {
                        String substring = this.aEO.getText().toString().substring(0, this.aEO.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cLo.matcher(substring);
                        if (matcher.find()) {
                            this.aEO.getText().delete(this.aEO.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aEO.getSelectionStart());
                            break;
                        } else {
                            this.aEO.getText().delete(this.aEO.getSelectionStart() - 1, this.aEO.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aEO.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aEO.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aEO.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aEO.setSelection(PbNewInputContainer.this.aEO.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aEU[0] = false;
                        break;
                    } else {
                        this.aEU[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aEO.setText((CharSequence) null);
                    }
                    this.aEU[0] = false;
                    this.aEU[1] = false;
                    this.aEU[2] = false;
                    this.aEU[3] = false;
                    this.aEU[4] = false;
                    this.aEV[0] = 0;
                    this.aEV[1] = 0;
                    break;
                case 10:
                    this.aEU[2] = true;
                    break;
                case 11:
                    this.aEU[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aDM != null) {
                            if (aVar2.aDM.getChosedFiles() != null) {
                                this.aEV[0] = aVar2.aDM.getChosedFiles().size();
                            } else {
                                this.aEV[0] = 0;
                            }
                        }
                        if (this.aEV[0] > 0) {
                            this.aEU[1] = true;
                            break;
                        } else {
                            this.aEU[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEV;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEV[0] > 0) {
                        this.aEU[1] = true;
                        break;
                    } else {
                        this.aEU[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        p((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.aEQ.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.aEq) {
                            this.aEQ.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aEP.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aEP.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aEQ.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aEQ.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aEU[3] = true;
                    break;
                case 29:
                    this.aEU[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gh((String) aVar.data);
                        break;
                    }
                    break;
            }
            eQ(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eQ(int i) {
        if (i == ALL) {
            if (this.aEU[0] || this.aEU[1] || this.aEU[2] || this.aEU[3] || this.aEU[4]) {
                this.mSendView.setEnabled(true);
                ak.b(this.mSendView, d.C0126d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            ak.c(this.mSendView, d.C0126d.cp_cont_d, 1);
        } else if (i == aEW) {
            if (this.aEU[1]) {
                this.mSendView.setEnabled(true);
                ak.b(this.mSendView, d.C0126d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            ak.c(this.mSendView, d.C0126d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aET = z;
    }

    public void setHint(int i) {
        if (this.aEO != null) {
            this.aEO.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aEO != null) {
            this.aEO.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aEO;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aEP;
    }

    public LinearLayout getInputLayout() {
        return this.aES;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (view2 == this.aEQ) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view2 == this.aER) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
