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
    private EditorTools VO;
    private int VP;
    private int bUN;
    private boolean cjW;
    private boolean cjX;
    private boolean cjY;
    private int cjZ;
    private LinearLayout ckA;
    private ImageView ckB;
    private LinearLayout ckC;
    private i ckD;
    private SpannableStringBuilder ckE;
    private String ckF;
    private boolean ckG;
    private boolean[] ckH;
    private int[] ckI;
    private EditText cky;
    private PbNewLocationInfoView ckz;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int ckJ = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjW = false;
        this.cjX = true;
        this.cjY = true;
        this.cjZ = -1;
        this.ckG = true;
        this.ckH = new boolean[]{false, false, false, false, false};
        this.ckI = new int[]{0, 0};
        this.bUN = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        df(context);
        this.ckC = new LinearLayout(getContext());
        this.ckC.setOrientation(0);
        this.ckC.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.tbds120));
        addView(this.ckC, new LinearLayout.LayoutParams(-1, -2));
        dh(context);
        dg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void df(Context context) {
        this.ckA = new LinearLayout(getContext());
        this.ckA.setGravity(16);
        this.ckA.setOrientation(0);
        this.ckA.setPadding(com.baidu.adp.lib.util.l.h(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds34), com.baidu.adp.lib.util.l.h(context, d.e.ds30), com.baidu.adp.lib.util.l.h(context, d.e.ds34), com.baidu.adp.lib.util.l.h(context, d.e.ds12));
        this.ckA.setLayoutParams(layoutParams);
        this.ckA.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ckz = new PbNewLocationInfoView(context);
        this.ckA.addView(this.ckz, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.ckB = new ImageView(context);
        this.ckB.setPadding(com.baidu.adp.lib.util.l.h(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.ckA.addView(this.ckB, layoutParams3);
        addView(this.ckA);
        this.ckA.setVisibility(8);
        this.ckB.setOnClickListener(this);
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
        this.ckC.addView(linearLayout, layoutParams);
    }

    private void dh(Context context) {
        this.cky = new EditText(context);
        this.cky.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.cky.setMaxLines(4);
        this.cky.setGravity(16);
        this.cky.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.cky.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        this.cky.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        this.cky.setBackgroundResource(d.C0277d.common_color_10022);
        e(this.cky, d.f.edittext_cursor);
        this.cky.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.cky.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cky.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.cjY) {
                    PbNewInputContainer.this.cjY = true;
                    if (PbNewInputContainer.this.cjZ != -1) {
                        PbNewInputContainer.this.cky.setSelection(PbNewInputContainer.this.cjZ);
                        PbNewInputContainer.this.cjZ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.ckE)) {
                        if (PbNewInputContainer.this.ckD == null) {
                            PbNewInputContainer.this.ckD = new i();
                        }
                        PbNewInputContainer.this.ckD.cle = PbNewInputContainer.this.ckE.toString();
                        PbNewInputContainer.this.ckD.mContent = PbNewInputContainer.this.cky.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ckD));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cky.getText().toString()));
                }
            }
        });
        this.cky.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.cky.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds34), 0, 0, 0);
        this.ckC.addView(this.cky, layoutParams);
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
                    this.cky.getText().insert(this.cky.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void oN(String str) {
        if (!StringUtils.isNull(str)) {
            this.cky.getText().insert(this.cky.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).agq() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).agq() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.agq() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cky.getText().toString();
            if (this.cjX && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cky);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjW || pVar.agq() == EmotionGroupType.LOCAL) {
            String obj = this.cky.getText().toString();
            if (this.cjX && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cky);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cjW = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.cky != null && this.ckC.getVisibility() == 0) {
            this.cky.setFocusable(true);
            this.cky.setFocusableInTouchMode(true);
            this.cky.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.cky);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.cky, d.C0277d.cp_cont_b, 2, i);
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        al.l(this, d.C0277d.cp_bg_line_d);
        al.k(this.ckA, d.f.pb_new_locatin_view_selector);
        al.c(this.ckB, d.f.icon_edit_close_n);
        if (i == 0) {
            e(this.cky, d.f.edittext_cursor);
            this.cky.setHintTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_e));
        } else {
            e(this.cky, d.f.edittext_cursor_1);
            this.cky.setHintTextColor(al.getColor(i, d.C0277d.cp_cont_e));
        }
        al.d(this.mSendView, d.C0277d.cp_btn_a, 1);
        al.k(this.mSendView, d.f.bg_comment_send);
        this.ckz.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cky.getSelectionStart() > 0) {
                        String substring = this.cky.getText().toString().substring(0, this.cky.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHo.matcher(substring);
                        if (matcher.find()) {
                            this.cky.getText().delete(this.cky.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cky.getSelectionStart());
                            break;
                        } else {
                            this.cky.getText().delete(this.cky.getSelectionStart() - 1, this.cky.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cky.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cky.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.cky.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.cky.setSelection(PbNewInputContainer.this.cky.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.ckE = null;
                        if (this.ckF != null) {
                            this.cky.setHint(this.ckF);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cle) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.cky.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cle)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cle, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.ckE = spannableStringBuilder;
                                        PbNewInputContainer.this.cky.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.cky.setText("");
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
                                        PbNewInputContainer.this.cky.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.cky.setSelection(PbNewInputContainer.this.cky.getText().length());
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
                        this.ckH[0] = false;
                        break;
                    } else {
                        this.ckH[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ckD = null;
                        this.ckE = null;
                        this.cky.setText((CharSequence) null);
                    }
                    this.ckH[0] = false;
                    this.ckH[1] = false;
                    this.ckH[2] = false;
                    this.ckH[3] = false;
                    this.ckH[4] = false;
                    this.ckI[0] = 0;
                    this.ckI[1] = 0;
                    break;
                case 10:
                    this.ckH[2] = true;
                    break;
                case 11:
                    this.ckH[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cjx != null) {
                            if (aVar2.cjx.getChosedFiles() != null) {
                                this.ckI[0] = aVar2.cjx.getChosedFiles().size();
                            } else {
                                this.ckI[0] = 0;
                            }
                        }
                        if (this.ckI[0] > 0) {
                            this.ckH[1] = true;
                            break;
                        } else {
                            this.ckH[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckI;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckI[0] > 0) {
                        this.ckH[1] = true;
                        break;
                    } else {
                        this.ckH[1] = false;
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
                        this.ckA.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.ckA.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.ckz.setState(aVar3.state, null);
                                break;
                            } else {
                                this.ckz.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.ckA.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.ckA.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.ckH[3] = true;
                    break;
                case 29:
                    this.ckH[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            oN((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            oN(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            jD(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jD(int i) {
        if (i == ALL) {
            if (this.ckH[0] || this.ckH[1] || this.ckH[2] || this.ckH[3] || this.ckH[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == ckJ) {
            if (this.ckH[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.ckG = z;
    }

    public void setHint(int i) {
        if (this.cky != null) {
            this.cky.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cky != null) {
            this.cky.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.ckF = str;
    }

    public EditText getInputView() {
        return this.cky;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.ckz;
    }

    public LinearLayout getInputLayout() {
        return this.ckC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ckA) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.ckB) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
