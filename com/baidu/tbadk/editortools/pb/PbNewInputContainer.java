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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools VM;
    private int VN;
    private int bUJ;
    private boolean cjT;
    private boolean cjU;
    private boolean cjV;
    private int cjW;
    private i ckA;
    private SpannableStringBuilder ckB;
    private String ckC;
    private boolean ckD;
    private boolean[] ckE;
    private int[] ckF;
    private EditText ckv;
    private PbNewLocationInfoView ckw;
    private LinearLayout ckx;
    private ImageView cky;
    private LinearLayout ckz;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int ckG = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjT = false;
        this.cjU = true;
        this.cjV = true;
        this.cjW = -1;
        this.ckD = true;
        this.ckE = new boolean[]{false, false, false, false, false};
        this.ckF = new int[]{0, 0};
        this.bUJ = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        df(context);
        this.ckz = new LinearLayout(getContext());
        this.ckz.setOrientation(0);
        this.ckz.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.tbds120));
        addView(this.ckz, new LinearLayout.LayoutParams(-1, -2));
        dh(context);
        dg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void df(Context context) {
        this.ckx = new LinearLayout(getContext());
        this.ckx.setGravity(16);
        this.ckx.setOrientation(0);
        this.ckx.setPadding(com.baidu.adp.lib.util.l.h(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds34), com.baidu.adp.lib.util.l.h(context, d.e.ds30), com.baidu.adp.lib.util.l.h(context, d.e.ds34), com.baidu.adp.lib.util.l.h(context, d.e.ds12));
        this.ckx.setLayoutParams(layoutParams);
        this.ckx.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ckw = new PbNewLocationInfoView(context);
        this.ckx.addView(this.ckw, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.cky = new ImageView(context);
        this.cky.setPadding(com.baidu.adp.lib.util.l.h(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.ckx.addView(this.cky, layoutParams3);
        addView(this.ckx);
        this.ckx.setVisibility(8);
        this.cky.setOnClickListener(this);
    }

    private void dg(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setAlpha(0.5f);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.tbfontsize42));
        this.mSendView.setText(d.j.pb_send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.h(context, d.e.tbds136), com.baidu.adp.lib.util.l.h(context, d.e.tbds78));
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds44);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.h(context, d.e.tbds21);
        linearLayout.addView(this.mSendView, layoutParams2);
        this.ckz.addView(linearLayout, layoutParams);
    }

    private void dh(Context context) {
        this.ckv = new EditText(context);
        this.ckv.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.ckv.setMaxLines(4);
        this.ckv.setGravity(16);
        this.ckv.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.ckv.setTextColor(getResources().getColor(d.C0236d.cp_cont_b));
        this.ckv.setHintTextColor(getResources().getColor(d.C0236d.cp_cont_e));
        this.ckv.setBackgroundResource(d.C0236d.common_color_10022);
        e(this.ckv, d.f.edittext_cursor);
        this.ckv.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.ckv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ckv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.cjV) {
                    PbNewInputContainer.this.cjV = true;
                    if (PbNewInputContainer.this.cjW != -1) {
                        PbNewInputContainer.this.ckv.setSelection(PbNewInputContainer.this.cjW);
                        PbNewInputContainer.this.cjW = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.ckB)) {
                        if (PbNewInputContainer.this.ckA == null) {
                            PbNewInputContainer.this.ckA = new i();
                        }
                        PbNewInputContainer.this.ckA.clb = PbNewInputContainer.this.ckB.toString();
                        PbNewInputContainer.this.ckA.mContent = PbNewInputContainer.this.ckv.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ckA));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ckv.getText().toString()));
                }
            }
        });
        this.ckv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.ckv.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds34), 0, 0, 0);
        this.ckz.addView(this.ckv, layoutParams);
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

    private void v(ArrayList<String> arrayList) {
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
                    this.ckv.getText().insert(this.ckv.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void oM(String str) {
        if (!StringUtils.isNull(str)) {
            this.ckv.getText().insert(this.ckv.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).agt() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).agt() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.agt() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.ckv.getText().toString();
            if (this.cjU && com.baidu.tieba.face.a.uf(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aca().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ckv);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjT || pVar.agt() == EmotionGroupType.LOCAL) {
            String obj = this.ckv.getText().toString();
            if (this.cjU && com.baidu.tieba.face.a.uf(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aca().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ckv);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cjT = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VM = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VM != null) {
            this.VM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VN = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VN;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.ckv != null && this.ckz.getVisibility() == 0) {
            this.ckv.setFocusable(true);
            this.ckv.setFocusableInTouchMode(true);
            this.ckv.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ckv);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.ckv, d.C0236d.cp_cont_b, 2, i);
        al.l(this.mBottomLine, d.C0236d.cp_bg_line_c);
        al.l(this, d.C0236d.cp_bg_line_d);
        al.k(this.ckx, d.f.pb_new_locatin_view_selector);
        al.c(this.cky, d.f.icon_edit_close_n);
        if (i == 0) {
            e(this.ckv, d.f.edittext_cursor);
            this.ckv.setHintTextColor(getContext().getResources().getColor(d.C0236d.cp_cont_e));
        } else {
            e(this.ckv, d.f.edittext_cursor_1);
            this.ckv.setHintTextColor(al.getColor(i, d.C0236d.cp_cont_e));
        }
        al.d(this.mSendView, d.C0236d.cp_btn_a, 1);
        al.k(this.mSendView, d.f.bg_comment_send);
        this.ckw.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ckv.getSelectionStart() > 0) {
                        String substring = this.ckv.getText().toString().substring(0, this.ckv.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHF.matcher(substring);
                        if (matcher.find()) {
                            this.ckv.getText().delete(this.ckv.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ckv.getSelectionStart());
                            break;
                        } else {
                            this.ckv.getText().delete(this.ckv.getSelectionStart() - 1, this.ckv.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ckv.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ckv.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.ckv.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.ckv.setSelection(PbNewInputContainer.this.ckv.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.ckB = null;
                        if (this.ckC != null) {
                            this.ckv.setHint(this.ckC);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).clb) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.ckv.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.clb)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.clb, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.ckB = spannableStringBuilder;
                                        PbNewInputContainer.this.ckv.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.ckv.setText("");
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
                                        PbNewInputContainer.this.ckv.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.ckv.setSelection(PbNewInputContainer.this.ckv.getText().length());
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
                        this.ckE[0] = false;
                        break;
                    } else {
                        this.ckE[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ckA = null;
                        this.ckB = null;
                        this.ckv.setText((CharSequence) null);
                    }
                    this.ckE[0] = false;
                    this.ckE[1] = false;
                    this.ckE[2] = false;
                    this.ckE[3] = false;
                    this.ckE[4] = false;
                    this.ckF[0] = 0;
                    this.ckF[1] = 0;
                    break;
                case 10:
                    this.ckE[2] = true;
                    break;
                case 11:
                    this.ckE[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cju != null) {
                            if (aVar2.cju.getChosedFiles() != null) {
                                this.ckF[0] = aVar2.cju.getChosedFiles().size();
                            } else {
                                this.ckF[0] = 0;
                            }
                        }
                        if (this.ckF[0] > 0) {
                            this.ckE[1] = true;
                            break;
                        } else {
                            this.ckE[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckF;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckF[0] > 0) {
                        this.ckE[1] = true;
                        break;
                    } else {
                        this.ckE[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        v((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.ckx.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.ckx.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.ckw.setState(aVar3.state, null);
                                break;
                            } else {
                                this.ckw.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.ckx.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.ckx.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.ckE[3] = true;
                    break;
                case 29:
                    this.ckE[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            oM((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            oM(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            jE(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jE(int i) {
        if (i == ALL) {
            if (this.ckE[0] || this.ckE[1] || this.ckE[2] || this.ckE[3] || this.ckE[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == ckG) {
            if (this.ckE[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.ckD = z;
    }

    public void setHint(int i) {
        if (this.ckv != null) {
            this.ckv.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ckv != null) {
            this.ckv.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.ckC = str;
    }

    public EditText getInputView() {
        return this.ckv;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.ckw;
    }

    public LinearLayout getInputLayout() {
        return this.ckz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ckx) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.cky) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
