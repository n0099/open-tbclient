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
    private com.baidu.tbadk.editortools.i axP;
    private int axQ;
    private int bfL;
    private boolean btV;
    private boolean btW;
    private boolean btX;
    private int btY;
    private PbNewLocationInfoView buA;
    private LinearLayout buB;
    private ImageView buC;
    private LinearLayout buD;
    private boolean buE;
    private boolean[] buF;
    private int[] buG;
    private EditText buz;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int buH = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btV = false;
        this.btW = true;
        this.btX = true;
        this.btY = -1;
        this.buE = true;
        this.buF = new boolean[]{false, false, false, false, false};
        this.buG = new int[]{0, 0};
        this.bfL = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        bf(context);
        this.buD = new LinearLayout(getContext());
        this.buD.setOrientation(0);
        this.buD.setMinimumHeight(l.t(context, d.e.ds90));
        addView(this.buD, new LinearLayout.LayoutParams(-1, -2));
        bh(context);
        bg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.t(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void bf(Context context) {
        this.buB = new LinearLayout(getContext());
        this.buB.setGravity(16);
        this.buB.setOrientation(0);
        this.buB.setPadding(l.t(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.t(context, d.e.ds48));
        layoutParams.setMargins(l.t(context, d.e.ds34), l.t(context, d.e.ds30), l.t(context, d.e.ds34), l.t(context, d.e.ds12));
        this.buB.setLayoutParams(layoutParams);
        this.buB.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.buA = new PbNewLocationInfoView(context);
        this.buB.addView(this.buA, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.buC = new ImageView(context);
        this.buC.setPadding(l.t(context, d.e.ds24), 0, l.t(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.buB.addView(this.buC, layoutParams3);
        addView(this.buB);
        this.buB.setVisibility(8);
        this.buC.setOnClickListener(this);
    }

    private void bg(Context context) {
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
        layoutParams.setMargins(0, 0, l.t(context, d.e.ds34), 0);
        this.buD.addView(this.mSendView, layoutParams);
    }

    private void bh(Context context) {
        this.buz = new EditText(context);
        this.buz.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.buz.setMaxLines(4);
        this.buz.setGravity(16);
        this.buz.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.buz.setTextColor(getResources().getColor(d.C0140d.cp_cont_b));
        this.buz.setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        this.buz.setBackgroundResource(d.C0140d.common_color_10022);
        a(this.buz, d.f.edittext_cursor);
        this.buz.setPadding(0, l.t(context, d.e.ds24), l.t(context, d.e.ds54), l.t(context, d.e.ds24));
        this.buz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.buz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.btX) {
                    f.this.btX = true;
                    if (f.this.btY != -1) {
                        f.this.buz.setSelection(f.this.btY);
                        f.this.btY = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.buz.getText().toString()));
                }
            }
        });
        this.buz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.buz.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.t(context, d.e.ds34), 0, 0, 0);
        this.buD.addView(this.buz, layoutParams);
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

    private void q(ArrayList<String> arrayList) {
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
                    this.buz.getText().insert(this.buz.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            this.buz.getText().insert(this.buz.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.FP() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.buz.getText().toString();
            if (this.btW && com.baidu.tieba.face.a.kT(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.BR().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.buz);
            }
        }
    }

    private void b(n nVar) {
        if (!this.btV || nVar.FP() == EmotionGroupType.LOCAL) {
            String obj = this.buz.getText().toString();
            if (this.btW && com.baidu.tieba.face.a.kT(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.BR().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.buz);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.btV = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.buz != null && this.buD.getVisibility() == 0) {
            this.buz.setFocusable(true);
            this.buz.setFocusableInTouchMode(true);
            this.buz.requestFocus();
            l.b(getContext(), this.buz);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.buz, d.C0140d.cp_cont_b, 2, i);
        aj.t(this.mBottomLine, d.C0140d.cp_bg_line_c);
        aj.t(this, d.C0140d.cp_bg_line_d);
        aj.s(this.buB, d.f.pb_new_locatin_view_selector);
        aj.c(this.buC, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.buz, d.f.edittext_cursor);
            this.buz.setHintTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_e));
        } else {
            a(this.buz, d.f.edittext_cursor_1);
            this.buz.setHintTextColor(aj.getColor(i, d.C0140d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this.mSendView, d.C0140d.cp_cont_e, 1);
        }
        this.buA.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.buz.getSelectionStart() > 0) {
                        String substring = this.buz.getText().toString().substring(0, this.buz.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.drA.matcher(substring);
                        if (matcher.find()) {
                            this.buz.getText().delete(this.buz.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.buz.getSelectionStart());
                            break;
                        } else {
                            this.buz.getText().delete(this.buz.getSelectionStart() - 1, this.buz.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.buz.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.buz.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.buz.setText(spannableStringBuilder);
                                    f.this.buz.setSelection(f.this.buz.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.buF[0] = false;
                        break;
                    } else {
                        this.buF[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.buz.setText((CharSequence) null);
                    }
                    this.buF[0] = false;
                    this.buF[1] = false;
                    this.buF[2] = false;
                    this.buF[3] = false;
                    this.buF[4] = false;
                    this.buG[0] = 0;
                    this.buG[1] = 0;
                    break;
                case 10:
                    this.buF[2] = true;
                    break;
                case 11:
                    this.buF[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.btw != null) {
                            if (aVar2.btw.getChosedFiles() != null) {
                                this.buG[0] = aVar2.btw.getChosedFiles().size();
                            } else {
                                this.buG[0] = 0;
                            }
                        }
                        if (this.buG[0] > 0) {
                            this.buF[1] = true;
                            break;
                        } else {
                            this.buF[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.buG;
                    iArr[0] = iArr[0] - 1;
                    if (this.buG[0] > 0) {
                        this.buF[1] = true;
                        break;
                    } else {
                        this.buF[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        q((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.buB.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.bua) {
                            this.buB.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.buA.j(aVar3.state, null);
                                break;
                            } else {
                                this.buA.j(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.buB.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.buB.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.buF[3] = true;
                    break;
                case 29:
                    this.buF[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gq((String) aVar.data);
                        break;
                    }
                    break;
            }
            hQ(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void hQ(int i) {
        if (i == ALL) {
            if (this.buF[0] || this.buF[1] || this.buF[2] || this.buF[3] || this.buF[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, this.bfL);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0140d.cp_cont_d, 1);
        } else if (i == buH) {
            if (this.buF[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0140d.cp_link_tip_a, 1, this.bfL);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0140d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.buE = z;
    }

    public void setHint(int i) {
        if (this.buz != null) {
            this.buz.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.buz != null) {
            this.buz.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.buz;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.buA;
    }

    public LinearLayout getInputLayout() {
        return this.buD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.buB) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.buC) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
