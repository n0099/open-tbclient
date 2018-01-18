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
    private com.baidu.tbadk.editortools.i axN;
    private int axO;
    private int bdK;
    private boolean brA;
    private int brB;
    private boolean bry;
    private boolean brz;
    private EditText bsd;
    private PbNewLocationInfoView bse;
    private LinearLayout bsf;
    private ImageView bsg;
    private LinearLayout bsh;
    private boolean bsi;
    private boolean[] bsj;
    private int[] bsk;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bsl = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bry = false;
        this.brz = true;
        this.brA = true;
        this.brB = -1;
        this.bsi = true;
        this.bsj = new boolean[]{false, false, false, false, false};
        this.bsk = new int[]{0, 0};
        this.bdK = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        bj(context);
        this.bsh = new LinearLayout(getContext());
        this.bsh.setOrientation(0);
        this.bsh.setMinimumHeight(l.s(context, d.e.ds90));
        addView(this.bsh, new LinearLayout.LayoutParams(-1, -2));
        bl(context);
        bk(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.s(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void bj(Context context) {
        this.bsf = new LinearLayout(getContext());
        this.bsf.setGravity(16);
        this.bsf.setOrientation(0);
        this.bsf.setPadding(l.s(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.s(context, d.e.ds48));
        layoutParams.setMargins(l.s(context, d.e.ds34), l.s(context, d.e.ds30), l.s(context, d.e.ds34), l.s(context, d.e.ds12));
        this.bsf.setLayoutParams(layoutParams);
        this.bsf.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bse = new PbNewLocationInfoView(context);
        this.bsf.addView(this.bse, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.bsg = new ImageView(context);
        this.bsg.setPadding(l.s(context, d.e.ds24), 0, l.s(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.bsf.addView(this.bsg, layoutParams3);
        addView(this.bsf);
        this.bsf.setVisibility(8);
        this.bsg.setOnClickListener(this);
    }

    private void bk(Context context) {
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
        layoutParams.setMargins(0, 0, l.s(context, d.e.ds34), 0);
        this.bsh.addView(this.mSendView, layoutParams);
    }

    private void bl(Context context) {
        this.bsd = new EditText(context);
        this.bsd.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.bsd.setMaxLines(4);
        this.bsd.setGravity(16);
        this.bsd.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.bsd.setTextColor(getResources().getColor(d.C0107d.cp_cont_b));
        this.bsd.setHintTextColor(getResources().getColor(d.C0107d.cp_cont_e));
        this.bsd.setBackgroundResource(d.C0107d.common_color_10022);
        a(this.bsd, d.f.edittext_cursor);
        this.bsd.setPadding(0, l.s(context, d.e.ds24), l.s(context, d.e.ds54), l.s(context, d.e.ds24));
        this.bsd.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.bsd.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.brA) {
                    f.this.brA = true;
                    if (f.this.brB != -1) {
                        f.this.bsd.setSelection(f.this.brB);
                        f.this.brB = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.bsd.getText().toString()));
                }
            }
        });
        this.bsd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.bsd.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.s(context, d.e.ds34), 0, 0, 0);
        this.bsh.addView(this.bsd, layoutParams);
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
                    this.bsd.getText().insert(this.bsd.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void fZ(String str) {
        if (!StringUtils.isNull(str)) {
            this.bsd.getText().insert(this.bsd.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Fr() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.bsd.getText().toString();
            if (this.brz && com.baidu.tieba.face.a.kE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bx().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.bsd);
            }
        }
    }

    private void b(n nVar) {
        if (!this.bry || nVar.Fr() == EmotionGroupType.LOCAL) {
            String obj = this.bsd.getText().toString();
            if (this.brz && com.baidu.tieba.face.a.kE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bx().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.bsd);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.bry = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axN = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axO;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.bsd != null && this.bsh.getVisibility() == 0) {
            this.bsd.setFocusable(true);
            this.bsd.setFocusableInTouchMode(true);
            this.bsd.requestFocus();
            l.b(getContext(), this.bsd);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.bsd, d.C0107d.cp_cont_b, 2, i);
        aj.t(this.mBottomLine, d.C0107d.cp_bg_line_c);
        aj.t(this, d.C0107d.cp_bg_line_d);
        aj.s(this.bsf, d.f.pb_new_locatin_view_selector);
        aj.c(this.bsg, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.bsd, d.f.edittext_cursor);
            this.bsd.setHintTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_e));
        } else {
            a(this.bsd, d.f.edittext_cursor_1);
            this.bsd.setHintTextColor(aj.getColor(i, d.C0107d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0107d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this.mSendView, d.C0107d.cp_cont_e, 1);
        }
        this.bse.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.bsd.getSelectionStart() > 0) {
                        String substring = this.bsd.getText().toString().substring(0, this.bsd.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dom.matcher(substring);
                        if (matcher.find()) {
                            this.bsd.getText().delete(this.bsd.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bsd.getSelectionStart());
                            break;
                        } else {
                            this.bsd.getText().delete(this.bsd.getSelectionStart() - 1, this.bsd.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.bsd.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.bsd.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.bsd.setText(spannableStringBuilder);
                                    f.this.bsd.setSelection(f.this.bsd.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bsj[0] = false;
                        break;
                    } else {
                        this.bsj[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.bsd.setText((CharSequence) null);
                    }
                    this.bsj[0] = false;
                    this.bsj[1] = false;
                    this.bsj[2] = false;
                    this.bsj[3] = false;
                    this.bsj[4] = false;
                    this.bsk[0] = 0;
                    this.bsk[1] = 0;
                    break;
                case 10:
                    this.bsj[2] = true;
                    break;
                case 11:
                    this.bsj[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.bqZ != null) {
                            if (aVar2.bqZ.getChosedFiles() != null) {
                                this.bsk[0] = aVar2.bqZ.getChosedFiles().size();
                            } else {
                                this.bsk[0] = 0;
                            }
                        }
                        if (this.bsk[0] > 0) {
                            this.bsj[1] = true;
                            break;
                        } else {
                            this.bsj[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bsk;
                    iArr[0] = iArr[0] - 1;
                    if (this.bsk[0] > 0) {
                        this.bsj[1] = true;
                        break;
                    } else {
                        this.bsj[1] = false;
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
                        this.bsf.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.brD) {
                            this.bsf.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.bse.j(aVar3.state, null);
                                break;
                            } else {
                                this.bse.j(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.bsf.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.bsf.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bsj[3] = true;
                    break;
                case 29:
                    this.bsj[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fZ((String) aVar.data);
                        break;
                    }
                    break;
            }
            hS(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void hS(int i) {
        if (i == ALL) {
            if (this.bsj[0] || this.bsj[1] || this.bsj[2] || this.bsj[3] || this.bsj[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0107d.cp_link_tip_a, 1, this.bdK);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0107d.cp_cont_d, 1);
        } else if (i == bsl) {
            if (this.bsj[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0107d.cp_link_tip_a, 1, this.bdK);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0107d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.bsi = z;
    }

    public void setHint(int i) {
        if (this.bsd != null) {
            this.bsd.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.bsd != null) {
            this.bsd.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.bsd;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.bse;
    }

    public LinearLayout getInputLayout() {
        return this.bsh;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bsf) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bsg) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
