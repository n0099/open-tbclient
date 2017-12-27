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
    private com.baidu.tbadk.editortools.i axO;
    private int axP;
    private int bdE;
    private EditText brU;
    private PbNewLocationInfoView brV;
    private LinearLayout brW;
    private ImageView brX;
    private LinearLayout brY;
    private boolean brZ;
    private boolean brp;
    private boolean brq;
    private boolean brr;
    private int brs;
    private boolean[] bsa;
    private int[] bsb;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bsc = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brp = false;
        this.brq = true;
        this.brr = true;
        this.brs = -1;
        this.brZ = true;
        this.bsa = new boolean[]{false, false, false, false, false};
        this.bsb = new int[]{0, 0};
        this.bdE = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        bj(context);
        this.brY = new LinearLayout(getContext());
        this.brY.setOrientation(0);
        this.brY.setMinimumHeight(l.s(context, d.e.ds90));
        addView(this.brY, new LinearLayout.LayoutParams(-1, -2));
        bl(context);
        bk(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.s(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void bj(Context context) {
        this.brW = new LinearLayout(getContext());
        this.brW.setGravity(16);
        this.brW.setOrientation(0);
        this.brW.setPadding(l.s(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.s(context, d.e.ds48));
        layoutParams.setMargins(l.s(context, d.e.ds34), l.s(context, d.e.ds30), l.s(context, d.e.ds34), l.s(context, d.e.ds12));
        this.brW.setLayoutParams(layoutParams);
        this.brW.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.brV = new PbNewLocationInfoView(context);
        this.brW.addView(this.brV, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.brX = new ImageView(context);
        this.brX.setPadding(l.s(context, d.e.ds24), 0, l.s(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.brW.addView(this.brX, layoutParams3);
        addView(this.brW);
        this.brW.setVisibility(8);
        this.brX.setOnClickListener(this);
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
        this.brY.addView(this.mSendView, layoutParams);
    }

    private void bl(Context context) {
        this.brU = new EditText(context);
        this.brU.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.brU.setMaxLines(4);
        this.brU.setGravity(16);
        this.brU.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.brU.setTextColor(getResources().getColor(d.C0108d.cp_cont_b));
        this.brU.setHintTextColor(getResources().getColor(d.C0108d.cp_cont_e));
        this.brU.setBackgroundResource(d.C0108d.common_color_10022);
        a(this.brU, d.f.edittext_cursor);
        this.brU.setPadding(0, l.s(context, d.e.ds24), l.s(context, d.e.ds54), l.s(context, d.e.ds24));
        this.brU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.brU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.brr) {
                    f.this.brr = true;
                    if (f.this.brs != -1) {
                        f.this.brU.setSelection(f.this.brs);
                        f.this.brs = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.brU.getText().toString()));
                }
            }
        });
        this.brU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.brU.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.s(context, d.e.ds34), 0, 0, 0);
        this.brY.addView(this.brU, layoutParams);
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
                    this.brU.getText().insert(this.brU.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void fY(String str) {
        if (!StringUtils.isNull(str)) {
            this.brU.getText().insert(this.brU.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.FA() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.brU.getText().toString();
            if (this.brq && com.baidu.tieba.face.a.kw(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.BF().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.brU);
            }
        }
    }

    private void b(n nVar) {
        if (!this.brp || nVar.FA() == EmotionGroupType.LOCAL) {
            String obj = this.brU.getText().toString();
            if (this.brq && com.baidu.tieba.face.a.kw(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.BF().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.brU);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.brp = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axO = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axO != null) {
            this.axO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axP = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axP;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        if (this.brU != null && this.brY.getVisibility() == 0) {
            this.brU.setFocusable(true);
            this.brU.setFocusableInTouchMode(true);
            this.brU.requestFocus();
            l.b(getContext(), this.brU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.brU, d.C0108d.cp_cont_b, 2, i);
        aj.t(this.mBottomLine, d.C0108d.cp_bg_line_c);
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.s(this.brW, d.f.pb_new_locatin_view_selector);
        aj.c(this.brX, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.brU, d.f.edittext_cursor);
            this.brU.setHintTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_e));
        } else {
            a(this.brU, d.f.edittext_cursor_1);
            this.brU.setHintTextColor(aj.getColor(i, d.C0108d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0108d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this.mSendView, d.C0108d.cp_cont_e, 1);
        }
        this.brV.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.brU.getSelectionStart() > 0) {
                        String substring = this.brU.getText().toString().substring(0, this.brU.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.djL.matcher(substring);
                        if (matcher.find()) {
                            this.brU.getText().delete(this.brU.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.brU.getSelectionStart());
                            break;
                        } else {
                            this.brU.getText().delete(this.brU.getSelectionStart() - 1, this.brU.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.brU.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.brU.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.brU.setText(spannableStringBuilder);
                                    f.this.brU.setSelection(f.this.brU.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bsa[0] = false;
                        break;
                    } else {
                        this.bsa[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.brU.setText((CharSequence) null);
                    }
                    this.bsa[0] = false;
                    this.bsa[1] = false;
                    this.bsa[2] = false;
                    this.bsa[3] = false;
                    this.bsa[4] = false;
                    this.bsb[0] = 0;
                    this.bsb[1] = 0;
                    break;
                case 10:
                    this.bsa[2] = true;
                    break;
                case 11:
                    this.bsa[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.bqQ != null) {
                            if (aVar2.bqQ.getChosedFiles() != null) {
                                this.bsb[0] = aVar2.bqQ.getChosedFiles().size();
                            } else {
                                this.bsb[0] = 0;
                            }
                        }
                        if (this.bsb[0] > 0) {
                            this.bsa[1] = true;
                            break;
                        } else {
                            this.bsa[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bsb;
                    iArr[0] = iArr[0] - 1;
                    if (this.bsb[0] > 0) {
                        this.bsa[1] = true;
                        break;
                    } else {
                        this.bsa[1] = false;
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
                        this.brW.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.bru) {
                            this.brW.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.brV.j(aVar3.state, null);
                                break;
                            } else {
                                this.brV.j(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.brW.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.brW.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bsa[3] = true;
                    break;
                case 29:
                    this.bsa[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fY((String) aVar.data);
                        break;
                    }
                    break;
            }
            hW(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void hW(int i) {
        if (i == ALL) {
            if (this.bsa[0] || this.bsa[1] || this.bsa[2] || this.bsa[3] || this.bsa[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0108d.cp_link_tip_a, 1, this.bdE);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0108d.cp_cont_d, 1);
        } else if (i == bsc) {
            if (this.bsa[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0108d.cp_link_tip_a, 1, this.bdE);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0108d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.brZ = z;
    }

    public void setHint(int i) {
        if (this.brU != null) {
            this.brU.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.brU != null) {
            this.brU.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.brU;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.brV;
    }

    public LinearLayout getInputLayout() {
        return this.brY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.brW) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.brX) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
