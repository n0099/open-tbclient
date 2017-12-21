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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class f extends LinearLayout implements View.OnClickListener, s {
    private com.baidu.tbadk.editortools.i IS;
    private int IT;
    private boolean aDv;
    private boolean aDw;
    private boolean aDx;
    private int aDy;
    private EditText aEa;
    private PbNewLocationInfoView aEb;
    private LinearLayout aEc;
    private ImageView aEd;
    private LinearLayout aEe;
    private boolean aEf;
    private boolean[] aEg;
    private int[] aEh;
    private int apG;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aEi = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDv = false;
        this.aDw = true;
        this.aDx = true;
        this.aDy = -1;
        this.aEf = true;
        this.aEg = new boolean[]{false, false, false, false, false};
        this.aEh = new int[]{0, 0};
        this.apG = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        aX(context);
        this.aEe = new LinearLayout(getContext());
        this.aEe.setOrientation(0);
        this.aEe.setMinimumHeight(l.f(context, d.e.ds90));
        addView(this.aEe, new LinearLayout.LayoutParams(-1, -2));
        aZ(context);
        aY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void aX(Context context) {
        this.aEc = new LinearLayout(getContext());
        this.aEc.setGravity(16);
        this.aEc.setOrientation(0);
        this.aEc.setPadding(l.f(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.ds48));
        layoutParams.setMargins(l.f(context, d.e.ds34), l.f(context, d.e.ds30), l.f(context, d.e.ds34), l.f(context, d.e.ds12));
        this.aEc.setLayoutParams(layoutParams);
        this.aEc.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aEb = new PbNewLocationInfoView(context);
        this.aEc.addView(this.aEb, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aEd = new ImageView(context);
        this.aEd.setPadding(l.f(context, d.e.ds24), 0, l.f(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aEc.addView(this.aEd, layoutParams3);
        addView(this.aEc);
        this.aEc.setVisibility(8);
        this.aEd.setOnClickListener(this);
    }

    private void aY(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.f(context, d.e.ds34), 0);
        this.aEe.addView(this.mSendView, layoutParams);
    }

    private void aZ(Context context) {
        this.aEa = new EditText(context);
        this.aEa.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aEa.setMaxLines(4);
        this.aEa.setGravity(16);
        this.aEa.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aEa.setTextColor(getResources().getColor(d.C0095d.cp_cont_b));
        this.aEa.setHintTextColor(getResources().getColor(d.C0095d.cp_cont_e));
        this.aEa.setBackgroundResource(d.C0095d.common_color_10022);
        a(this.aEa, d.f.edittext_cursor);
        this.aEa.setPadding(0, l.f(context, d.e.ds24), l.f(context, d.e.ds54), l.f(context, d.e.ds24));
        this.aEa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aEa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.aDx) {
                    f.this.aDx = true;
                    if (f.this.aDy != -1) {
                        f.this.aEa.setSelection(f.this.aDy);
                        f.this.aDy = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.aEa.getText().toString()));
                }
            }
        });
        this.aEa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.aEa.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.f(context, d.e.ds34), 0, 0, 0);
        this.aEe.addView(this.aEa, layoutParams);
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
                    this.aEa.getText().insert(this.aEa.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void fR(String str) {
        if (!StringUtils.isNull(str)) {
            this.aEa.getText().insert(this.aEa.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.yb() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aEa.getText().toString();
            if (this.aDw && com.baidu.tieba.face.a.kq(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.uf().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aEa);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aDv || nVar.yb() == EmotionGroupType.LOCAL) {
            String obj = this.aEa.getText().toString();
            if (this.aDw && com.baidu.tieba.face.a.kq(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.uf().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aEa);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aDv = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.IS = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.aEa != null && this.aEe.getVisibility() == 0) {
            this.aEa.setFocusable(true);
            this.aEa.setFocusableInTouchMode(true);
            this.aEa.requestFocus();
            l.b(getContext(), this.aEa);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.aEa, d.C0095d.cp_cont_b, 2, i);
        aj.k(this.mBottomLine, d.C0095d.cp_bg_line_c);
        aj.k(this, d.C0095d.cp_bg_line_d);
        aj.j(this.aEc, d.f.pb_new_locatin_view_selector);
        aj.c(this.aEd, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aEa, d.f.edittext_cursor);
            this.aEa.setHintTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_e));
        } else {
            a(this.aEa, d.f.edittext_cursor_1);
            this.aEa.setHintTextColor(aj.getColor(i, d.C0095d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0095d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this.mSendView, d.C0095d.cp_cont_e, 1);
        }
        this.aEb.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aEa.getSelectionStart() > 0) {
                        String substring = this.aEa.getText().toString().substring(0, this.aEa.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cvp.matcher(substring);
                        if (matcher.find()) {
                            this.aEa.getText().delete(this.aEa.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aEa.getSelectionStart());
                            break;
                        } else {
                            this.aEa.getText().delete(this.aEa.getSelectionStart() - 1, this.aEa.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aEa.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aEa.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.aEa.setText(spannableStringBuilder);
                                    f.this.aEa.setSelection(f.this.aEa.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aEg[0] = false;
                        break;
                    } else {
                        this.aEg[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aEa.setText((CharSequence) null);
                    }
                    this.aEg[0] = false;
                    this.aEg[1] = false;
                    this.aEg[2] = false;
                    this.aEg[3] = false;
                    this.aEg[4] = false;
                    this.aEh[0] = 0;
                    this.aEh[1] = 0;
                    break;
                case 10:
                    this.aEg[2] = true;
                    break;
                case 11:
                    this.aEg[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCV != null) {
                            if (aVar2.aCV.getChosedFiles() != null) {
                                this.aEh[0] = aVar2.aCV.getChosedFiles().size();
                            } else {
                                this.aEh[0] = 0;
                            }
                        }
                        if (this.aEh[0] > 0) {
                            this.aEg[1] = true;
                            break;
                        } else {
                            this.aEg[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEh;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEh[0] > 0) {
                        this.aEg[1] = true;
                        break;
                    } else {
                        this.aEg[1] = false;
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
                        this.aEc.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.aDA) {
                            this.aEc.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aEb.k(aVar3.state, null);
                                break;
                            } else {
                                this.aEb.k(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aEc.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aEc.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aEg[3] = true;
                    break;
                case 29:
                    this.aEg[3] = false;
                    break;
                case d.l.View_minWidth /* 44 */:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fR((String) aVar.data);
                        break;
                    }
                    break;
            }
            eY(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eY(int i) {
        if (i == ALL) {
            if (this.aEg[0] || this.aEg[1] || this.aEg[2] || this.aEg[3] || this.aEg[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0095d.cp_link_tip_a, 1, this.apG);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.c(this.mSendView, d.C0095d.cp_cont_d, 1);
        } else if (i == aEi) {
            if (this.aEg[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0095d.cp_link_tip_a, 1, this.apG);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.c(this.mSendView, d.C0095d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aEf = z;
    }

    public void setHint(int i) {
        if (this.aEa != null) {
            this.aEa.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aEa != null) {
            this.aEa.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aEa;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aEb;
    }

    public LinearLayout getInputLayout() {
        return this.aEe;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aEc) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aEd) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
