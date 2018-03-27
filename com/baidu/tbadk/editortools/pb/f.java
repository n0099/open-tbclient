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
    private com.baidu.tbadk.editortools.i axH;
    private int axI;
    private int bfC;
    private boolean btL;
    private boolean btM;
    private boolean btN;
    private int btO;
    private EditText bup;
    private PbNewLocationInfoView buq;
    private LinearLayout bur;
    private ImageView bus;
    private LinearLayout but;
    private boolean buu;
    private boolean[] buv;
    private int[] buw;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bux = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.btL = false;
        this.btM = true;
        this.btN = true;
        this.btO = -1;
        this.buu = true;
        this.buv = new boolean[]{false, false, false, false, false};
        this.buw = new int[]{0, 0};
        this.bfC = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        bf(context);
        this.but = new LinearLayout(getContext());
        this.but.setOrientation(0);
        this.but.setMinimumHeight(l.t(context, d.e.ds90));
        addView(this.but, new LinearLayout.LayoutParams(-1, -2));
        bh(context);
        bg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.t(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void bf(Context context) {
        this.bur = new LinearLayout(getContext());
        this.bur.setGravity(16);
        this.bur.setOrientation(0);
        this.bur.setPadding(l.t(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.t(context, d.e.ds48));
        layoutParams.setMargins(l.t(context, d.e.ds34), l.t(context, d.e.ds30), l.t(context, d.e.ds34), l.t(context, d.e.ds12));
        this.bur.setLayoutParams(layoutParams);
        this.bur.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.buq = new PbNewLocationInfoView(context);
        this.bur.addView(this.buq, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.bus = new ImageView(context);
        this.bus.setPadding(l.t(context, d.e.ds24), 0, l.t(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.bur.addView(this.bus, layoutParams3);
        addView(this.bur);
        this.bur.setVisibility(8);
        this.bus.setOnClickListener(this);
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
        this.but.addView(this.mSendView, layoutParams);
    }

    private void bh(Context context) {
        this.bup = new EditText(context);
        this.bup.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.bup.setMaxLines(4);
        this.bup.setGravity(16);
        this.bup.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.bup.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
        this.bup.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        this.bup.setBackgroundResource(d.C0141d.common_color_10022);
        a(this.bup, d.f.edittext_cursor);
        this.bup.setPadding(0, l.t(context, d.e.ds24), l.t(context, d.e.ds54), l.t(context, d.e.ds24));
        this.bup.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.bup.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.btN) {
                    f.this.btN = true;
                    if (f.this.btO != -1) {
                        f.this.bup.setSelection(f.this.btO);
                        f.this.btO = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.bup.getText().toString()));
                }
            }
        });
        this.bup.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.bup.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.t(context, d.e.ds34), 0, 0, 0);
        this.but.addView(this.bup, layoutParams);
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
                    this.bup.getText().insert(this.bup.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gq(String str) {
        if (!StringUtils.isNull(str)) {
            this.bup.getText().insert(this.bup.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
            String obj = this.bup.getText().toString();
            if (this.btM && com.baidu.tieba.face.a.kT(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.BR().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.bup);
            }
        }
    }

    private void b(n nVar) {
        if (!this.btL || nVar.FP() == EmotionGroupType.LOCAL) {
            String obj = this.bup.getText().toString();
            if (this.btM && com.baidu.tieba.face.a.kT(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.BR().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.bup);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.btL = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.bup != null && this.but.getVisibility() == 0) {
            this.bup.setFocusable(true);
            this.bup.setFocusableInTouchMode(true);
            this.bup.requestFocus();
            l.b(getContext(), this.bup);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.bup, d.C0141d.cp_cont_b, 2, i);
        aj.t(this.mBottomLine, d.C0141d.cp_bg_line_c);
        aj.t(this, d.C0141d.cp_bg_line_d);
        aj.s(this.bur, d.f.pb_new_locatin_view_selector);
        aj.c(this.bus, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.bup, d.f.edittext_cursor);
            this.bup.setHintTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_e));
        } else {
            a(this.bup, d.f.edittext_cursor_1);
            this.bup.setHintTextColor(aj.getColor(i, d.C0141d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this.mSendView, d.C0141d.cp_cont_e, 1);
        }
        this.buq.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.bup.getSelectionStart() > 0) {
                        String substring = this.bup.getText().toString().substring(0, this.bup.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.drr.matcher(substring);
                        if (matcher.find()) {
                            this.bup.getText().delete(this.bup.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bup.getSelectionStart());
                            break;
                        } else {
                            this.bup.getText().delete(this.bup.getSelectionStart() - 1, this.bup.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.bup.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.bup.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.bup.setText(spannableStringBuilder);
                                    f.this.bup.setSelection(f.this.bup.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.buv[0] = false;
                        break;
                    } else {
                        this.buv[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.bup.setText((CharSequence) null);
                    }
                    this.buv[0] = false;
                    this.buv[1] = false;
                    this.buv[2] = false;
                    this.buv[3] = false;
                    this.buv[4] = false;
                    this.buw[0] = 0;
                    this.buw[1] = 0;
                    break;
                case 10:
                    this.buv[2] = true;
                    break;
                case 11:
                    this.buv[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.btl != null) {
                            if (aVar2.btl.getChosedFiles() != null) {
                                this.buw[0] = aVar2.btl.getChosedFiles().size();
                            } else {
                                this.buw[0] = 0;
                            }
                        }
                        if (this.buw[0] > 0) {
                            this.buv[1] = true;
                            break;
                        } else {
                            this.buv[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.buw;
                    iArr[0] = iArr[0] - 1;
                    if (this.buw[0] > 0) {
                        this.buv[1] = true;
                        break;
                    } else {
                        this.buv[1] = false;
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
                        this.bur.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.btQ) {
                            this.bur.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.buq.j(aVar3.state, null);
                                break;
                            } else {
                                this.buq.j(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.bur.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.bur.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.buv[3] = true;
                    break;
                case 29:
                    this.buv[3] = false;
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
            if (this.buv[0] || this.buv[1] || this.buv[2] || this.buv[3] || this.buv[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, this.bfC);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0141d.cp_cont_d, 1);
        } else if (i == bux) {
            if (this.buv[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, this.bfC);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0141d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.buu = z;
    }

    public void setHint(int i) {
        if (this.bup != null) {
            this.bup.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.bup != null) {
            this.bup.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.bup;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.buq;
    }

    public LinearLayout getInputLayout() {
        return this.but;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bur) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bus) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
