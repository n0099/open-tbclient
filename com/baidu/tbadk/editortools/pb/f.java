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
    private com.baidu.tbadk.editortools.i IR;
    private int IS;
    private EditText aDX;
    private PbNewLocationInfoView aDY;
    private LinearLayout aDZ;
    private boolean aDs;
    private boolean aDt;
    private boolean aDu;
    private int aDv;
    private ImageView aEa;
    private LinearLayout aEb;
    private boolean aEc;
    private boolean[] aEd;
    private int[] aEe;
    private int apD;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aEf = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDs = false;
        this.aDt = true;
        this.aDu = true;
        this.aDv = -1;
        this.aEc = true;
        this.aEd = new boolean[]{false, false, false, false, false};
        this.aEe = new int[]{0, 0};
        this.apD = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        aX(context);
        this.aEb = new LinearLayout(getContext());
        this.aEb.setOrientation(0);
        this.aEb.setMinimumHeight(l.f(context, d.e.ds90));
        addView(this.aEb, new LinearLayout.LayoutParams(-1, -2));
        aZ(context);
        aY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void aX(Context context) {
        this.aDZ = new LinearLayout(getContext());
        this.aDZ.setGravity(16);
        this.aDZ.setOrientation(0);
        this.aDZ.setPadding(l.f(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.ds48));
        layoutParams.setMargins(l.f(context, d.e.ds34), l.f(context, d.e.ds30), l.f(context, d.e.ds34), l.f(context, d.e.ds12));
        this.aDZ.setLayoutParams(layoutParams);
        this.aDZ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aDY = new PbNewLocationInfoView(context);
        this.aDZ.addView(this.aDY, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aEa = new ImageView(context);
        this.aEa.setPadding(l.f(context, d.e.ds24), 0, l.f(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aDZ.addView(this.aEa, layoutParams3);
        addView(this.aDZ);
        this.aDZ.setVisibility(8);
        this.aEa.setOnClickListener(this);
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
        this.aEb.addView(this.mSendView, layoutParams);
    }

    private void aZ(Context context) {
        this.aDX = new EditText(context);
        this.aDX.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aDX.setMaxLines(4);
        this.aDX.setGravity(16);
        this.aDX.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aDX.setTextColor(getResources().getColor(d.C0096d.cp_cont_b));
        this.aDX.setHintTextColor(getResources().getColor(d.C0096d.cp_cont_e));
        this.aDX.setBackgroundResource(d.C0096d.common_color_10022);
        a(this.aDX, d.f.edittext_cursor);
        this.aDX.setPadding(0, l.f(context, d.e.ds24), l.f(context, d.e.ds54), l.f(context, d.e.ds24));
        this.aDX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aDX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.aDu) {
                    f.this.aDu = true;
                    if (f.this.aDv != -1) {
                        f.this.aDX.setSelection(f.this.aDv);
                        f.this.aDv = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.aDX.getText().toString()));
                }
            }
        });
        this.aDX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.aDX.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.f(context, d.e.ds34), 0, 0, 0);
        this.aEb.addView(this.aDX, layoutParams);
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
                    this.aDX.getText().insert(this.aDX.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void fR(String str) {
        if (!StringUtils.isNull(str)) {
            this.aDX.getText().insert(this.aDX.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
            String obj = this.aDX.getText().toString();
            if (this.aDt && com.baidu.tieba.face.a.kq(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.uf().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aDX);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aDs || nVar.yb() == EmotionGroupType.LOCAL) {
            String obj = this.aDX.getText().toString();
            if (this.aDt && com.baidu.tieba.face.a.kq(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.uf().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aDX);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aDs = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.IR = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IS;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.aDX != null && this.aEb.getVisibility() == 0) {
            this.aDX.setFocusable(true);
            this.aDX.setFocusableInTouchMode(true);
            this.aDX.requestFocus();
            l.b(getContext(), this.aDX);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.aDX, d.C0096d.cp_cont_b, 2, i);
        aj.k(this.mBottomLine, d.C0096d.cp_bg_line_c);
        aj.k(this, d.C0096d.cp_bg_line_d);
        aj.j(this.aDZ, d.f.pb_new_locatin_view_selector);
        aj.c(this.aEa, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aDX, d.f.edittext_cursor);
            this.aDX.setHintTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_e));
        } else {
            a(this.aDX, d.f.edittext_cursor_1);
            this.aDX.setHintTextColor(aj.getColor(i, d.C0096d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0096d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this.mSendView, d.C0096d.cp_cont_e, 1);
        }
        this.aDY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aDX.getSelectionStart() > 0) {
                        String substring = this.aDX.getText().toString().substring(0, this.aDX.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cvl.matcher(substring);
                        if (matcher.find()) {
                            this.aDX.getText().delete(this.aDX.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aDX.getSelectionStart());
                            break;
                        } else {
                            this.aDX.getText().delete(this.aDX.getSelectionStart() - 1, this.aDX.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aDX.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aDX.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.aDX.setText(spannableStringBuilder);
                                    f.this.aDX.setSelection(f.this.aDX.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aEd[0] = false;
                        break;
                    } else {
                        this.aEd[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aDX.setText((CharSequence) null);
                    }
                    this.aEd[0] = false;
                    this.aEd[1] = false;
                    this.aEd[2] = false;
                    this.aEd[3] = false;
                    this.aEd[4] = false;
                    this.aEe[0] = 0;
                    this.aEe[1] = 0;
                    break;
                case 10:
                    this.aEd[2] = true;
                    break;
                case 11:
                    this.aEd[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCS != null) {
                            if (aVar2.aCS.getChosedFiles() != null) {
                                this.aEe[0] = aVar2.aCS.getChosedFiles().size();
                            } else {
                                this.aEe[0] = 0;
                            }
                        }
                        if (this.aEe[0] > 0) {
                            this.aEd[1] = true;
                            break;
                        } else {
                            this.aEd[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEe;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEe[0] > 0) {
                        this.aEd[1] = true;
                        break;
                    } else {
                        this.aEd[1] = false;
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
                        this.aDZ.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.aDx) {
                            this.aDZ.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aDY.k(aVar3.state, null);
                                break;
                            } else {
                                this.aDY.k(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aDZ.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aDZ.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aEd[3] = true;
                    break;
                case 29:
                    this.aEd[3] = false;
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
            if (this.aEd[0] || this.aEd[1] || this.aEd[2] || this.aEd[3] || this.aEd[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0096d.cp_link_tip_a, 1, this.apD);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.c(this.mSendView, d.C0096d.cp_cont_d, 1);
        } else if (i == aEf) {
            if (this.aEd[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0096d.cp_link_tip_a, 1, this.apD);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.c(this.mSendView, d.C0096d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aEc = z;
    }

    public void setHint(int i) {
        if (this.aDX != null) {
            this.aDX.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aDX != null) {
            this.aDX.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aDX;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aDY;
    }

    public LinearLayout getInputLayout() {
        return this.aEb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aDZ) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aEa) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
