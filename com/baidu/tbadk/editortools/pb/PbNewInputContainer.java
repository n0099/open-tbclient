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
    private EditorTools VN;
    private int VO;
    private int bUM;
    private boolean cjV;
    private boolean cjW;
    private boolean cjX;
    private int cjY;
    private ImageView ckA;
    private LinearLayout ckB;
    private i ckC;
    private SpannableStringBuilder ckD;
    private String ckE;
    private boolean ckF;
    private boolean[] ckG;
    private int[] ckH;
    private EditText ckx;
    private PbNewLocationInfoView cky;
    private LinearLayout ckz;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int ckI = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjV = false;
        this.cjW = true;
        this.cjX = true;
        this.cjY = -1;
        this.ckF = true;
        this.ckG = new boolean[]{false, false, false, false, false};
        this.ckH = new int[]{0, 0};
        this.bUM = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        df(context);
        this.ckB = new LinearLayout(getContext());
        this.ckB.setOrientation(0);
        this.ckB.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.tbds120));
        addView(this.ckB, new LinearLayout.LayoutParams(-1, -2));
        dh(context);
        dg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void df(Context context) {
        this.ckz = new LinearLayout(getContext());
        this.ckz.setGravity(16);
        this.ckz.setOrientation(0);
        this.ckz.setPadding(com.baidu.adp.lib.util.l.h(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds34), com.baidu.adp.lib.util.l.h(context, d.e.ds30), com.baidu.adp.lib.util.l.h(context, d.e.ds34), com.baidu.adp.lib.util.l.h(context, d.e.ds12));
        this.ckz.setLayoutParams(layoutParams);
        this.ckz.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cky = new PbNewLocationInfoView(context);
        this.ckz.addView(this.cky, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.ckA = new ImageView(context);
        this.ckA.setPadding(com.baidu.adp.lib.util.l.h(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.h(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.ckz.addView(this.ckA, layoutParams3);
        addView(this.ckz);
        this.ckz.setVisibility(8);
        this.ckA.setOnClickListener(this);
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
        this.ckB.addView(linearLayout, layoutParams);
    }

    private void dh(Context context) {
        this.ckx = new EditText(context);
        this.ckx.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.ckx.setMaxLines(4);
        this.ckx.setGravity(16);
        this.ckx.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.ckx.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        this.ckx.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        this.ckx.setBackgroundResource(d.C0277d.common_color_10022);
        e(this.ckx, d.f.edittext_cursor);
        this.ckx.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.ckx.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ckx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.cjX) {
                    PbNewInputContainer.this.cjX = true;
                    if (PbNewInputContainer.this.cjY != -1) {
                        PbNewInputContainer.this.ckx.setSelection(PbNewInputContainer.this.cjY);
                        PbNewInputContainer.this.cjY = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.ckD)) {
                        if (PbNewInputContainer.this.ckC == null) {
                            PbNewInputContainer.this.ckC = new i();
                        }
                        PbNewInputContainer.this.ckC.cld = PbNewInputContainer.this.ckD.toString();
                        PbNewInputContainer.this.ckC.mContent = PbNewInputContainer.this.ckx.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ckC));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ckx.getText().toString()));
                }
            }
        });
        this.ckx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.ckx.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds34), 0, 0, 0);
        this.ckB.addView(this.ckx, layoutParams);
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
                    this.ckx.getText().insert(this.ckx.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void oN(String str) {
        if (!StringUtils.isNull(str)) {
            this.ckx.getText().insert(this.ckx.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
            String obj = this.ckx.getText().toString();
            if (this.cjW && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ckx);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjV || pVar.agq() == EmotionGroupType.LOCAL) {
            String obj = this.ckx.getText().toString();
            if (this.cjW && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ckx);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cjV = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.ckx != null && this.ckB.getVisibility() == 0) {
            this.ckx.setFocusable(true);
            this.ckx.setFocusableInTouchMode(true);
            this.ckx.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ckx);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.ckx, d.C0277d.cp_cont_b, 2, i);
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        al.l(this, d.C0277d.cp_bg_line_d);
        al.k(this.ckz, d.f.pb_new_locatin_view_selector);
        al.c(this.ckA, d.f.icon_edit_close_n);
        if (i == 0) {
            e(this.ckx, d.f.edittext_cursor);
            this.ckx.setHintTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_e));
        } else {
            e(this.ckx, d.f.edittext_cursor_1);
            this.ckx.setHintTextColor(al.getColor(i, d.C0277d.cp_cont_e));
        }
        al.d(this.mSendView, d.C0277d.cp_btn_a, 1);
        al.k(this.mSendView, d.f.bg_comment_send);
        this.cky.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ckx.getSelectionStart() > 0) {
                        String substring = this.ckx.getText().toString().substring(0, this.ckx.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHn.matcher(substring);
                        if (matcher.find()) {
                            this.ckx.getText().delete(this.ckx.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ckx.getSelectionStart());
                            break;
                        } else {
                            this.ckx.getText().delete(this.ckx.getSelectionStart() - 1, this.ckx.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ckx.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ckx.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.ckx.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.ckx.setSelection(PbNewInputContainer.this.ckx.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.ckD = null;
                        if (this.ckE != null) {
                            this.ckx.setHint(this.ckE);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cld) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.ckx.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cld)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cld, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.ckD = spannableStringBuilder;
                                        PbNewInputContainer.this.ckx.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.ckx.setText("");
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
                                        PbNewInputContainer.this.ckx.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.ckx.setSelection(PbNewInputContainer.this.ckx.getText().length());
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
                        this.ckG[0] = false;
                        break;
                    } else {
                        this.ckG[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ckC = null;
                        this.ckD = null;
                        this.ckx.setText((CharSequence) null);
                    }
                    this.ckG[0] = false;
                    this.ckG[1] = false;
                    this.ckG[2] = false;
                    this.ckG[3] = false;
                    this.ckG[4] = false;
                    this.ckH[0] = 0;
                    this.ckH[1] = 0;
                    break;
                case 10:
                    this.ckG[2] = true;
                    break;
                case 11:
                    this.ckG[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cjw != null) {
                            if (aVar2.cjw.getChosedFiles() != null) {
                                this.ckH[0] = aVar2.cjw.getChosedFiles().size();
                            } else {
                                this.ckH[0] = 0;
                            }
                        }
                        if (this.ckH[0] > 0) {
                            this.ckG[1] = true;
                            break;
                        } else {
                            this.ckG[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckH;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckH[0] > 0) {
                        this.ckG[1] = true;
                        break;
                    } else {
                        this.ckG[1] = false;
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
                        this.ckz.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.ckz.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.cky.setState(aVar3.state, null);
                                break;
                            } else {
                                this.cky.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.ckz.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.ckz.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.ckG[3] = true;
                    break;
                case 29:
                    this.ckG[3] = false;
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
            if (this.ckG[0] || this.ckG[1] || this.ckG[2] || this.ckG[3] || this.ckG[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == ckI) {
            if (this.ckG[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.ckF = z;
    }

    public void setHint(int i) {
        if (this.ckx != null) {
            this.ckx.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ckx != null) {
            this.ckx.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.ckE = str;
    }

    public EditText getInputView() {
        return this.ckx;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.cky;
    }

    public LinearLayout getInputLayout() {
        return this.ckB;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ckz) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.ckA) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
