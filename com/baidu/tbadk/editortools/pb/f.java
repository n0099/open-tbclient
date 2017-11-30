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
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class f extends LinearLayout implements View.OnClickListener, s {
    private com.baidu.tbadk.editortools.i IT;
    private int IU;
    private EditText aDS;
    private PbNewLocationInfoView aDT;
    private LinearLayout aDU;
    private ImageView aDV;
    private LinearLayout aDW;
    private boolean aDX;
    private boolean[] aDY;
    private int[] aDZ;
    private boolean aDn;
    private boolean aDo;
    private boolean aDp;
    private int aDq;
    private int apA;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aEa = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aDn = false;
        this.aDo = true;
        this.aDp = true;
        this.aDq = -1;
        this.aDX = true;
        this.aDY = new boolean[]{false, false, false, false, false};
        this.aDZ = new int[]{0, 0};
        this.apA = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        ba(context);
        this.aDW = new LinearLayout(getContext());
        this.aDW.setOrientation(0);
        this.aDW.setMinimumHeight(l.f(context, d.e.ds90));
        addView(this.aDW, new LinearLayout.LayoutParams(-1, -2));
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.f(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void ba(Context context) {
        this.aDU = new LinearLayout(getContext());
        this.aDU.setGravity(16);
        this.aDU.setOrientation(0);
        this.aDU.setPadding(l.f(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.ds48));
        layoutParams.setMargins(l.f(context, d.e.ds34), l.f(context, d.e.ds30), l.f(context, d.e.ds34), l.f(context, d.e.ds12));
        this.aDU.setLayoutParams(layoutParams);
        this.aDU.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aDT = new PbNewLocationInfoView(context);
        this.aDU.addView(this.aDT, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aDV = new ImageView(context);
        this.aDV.setPadding(l.f(context, d.e.ds24), 0, l.f(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aDU.addView(this.aDV, layoutParams3);
        addView(this.aDU);
        this.aDU.setVisibility(8);
        this.aDV.setOnClickListener(this);
    }

    private void bb(Context context) {
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
        this.aDW.addView(this.mSendView, layoutParams);
    }

    private void bc(Context context) {
        this.aDS = new EditText(context);
        this.aDS.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aDS.setMaxLines(4);
        this.aDS.setGravity(16);
        this.aDS.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aDS.setTextColor(getResources().getColor(d.C0082d.cp_cont_b));
        this.aDS.setHintTextColor(getResources().getColor(d.C0082d.cp_cont_e));
        this.aDS.setBackgroundResource(d.C0082d.common_color_10022);
        a(this.aDS, d.f.edittext_cursor);
        this.aDS.setPadding(0, l.f(context, d.e.ds24), l.f(context, d.e.ds54), l.f(context, d.e.ds24));
        this.aDS.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aDS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.aDp) {
                    f.this.aDp = true;
                    if (f.this.aDq != -1) {
                        f.this.aDS.setSelection(f.this.aDq);
                        f.this.aDq = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.aDS.getText().toString()));
                }
            }
        });
        this.aDS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.aDS.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.f(context, d.e.ds34), 0, 0, 0);
        this.aDW.addView(this.aDS, layoutParams);
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
                    this.aDS.getText().insert(this.aDS.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void fS(String str) {
        if (!StringUtils.isNull(str)) {
            this.aDS.getText().insert(this.aDS.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof m)) {
            m mVar = (m) aVar.data;
            if (mVar.ya() == EmotionGroupType.NET_SUG) {
                a(mVar);
            } else {
                b(mVar);
            }
        }
    }

    private void a(m mVar) {
        if (mVar != null && !TextUtils.isEmpty(mVar.getName()) && !TextUtils.isEmpty(mVar.getUrl())) {
            String obj = this.aDS.getText().toString();
            if (this.aDo && com.baidu.tieba.face.a.ks(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ui().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), mVar, this.aDS);
            }
        }
    }

    private void b(m mVar) {
        if (!this.aDn || mVar.ya() == EmotionGroupType.LOCAL) {
            String obj = this.aDS.getText().toString();
            if (this.aDo && com.baidu.tieba.face.a.ks(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ui().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), mVar, this.aDS);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aDn = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        if (this.aDS != null && this.aDW.getVisibility() == 0) {
            this.aDS.setFocusable(true);
            this.aDS.setFocusableInTouchMode(true);
            this.aDS.requestFocus();
            l.b(getContext(), this.aDS);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.aDS, d.C0082d.cp_cont_b, 2, i);
        aj.k(this.mBottomLine, d.C0082d.cp_bg_line_c);
        aj.k(this, d.C0082d.cp_bg_line_d);
        aj.j(this.aDU, d.f.pb_new_locatin_view_selector);
        aj.c(this.aDV, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aDS, d.f.edittext_cursor);
            this.aDS.setHintTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_e));
        } else {
            a(this.aDS, d.f.edittext_cursor_1);
            this.aDS.setHintTextColor(aj.getColor(i, d.C0082d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0082d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this.mSendView, d.C0082d.cp_cont_e, 1);
        }
        this.aDT.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aDS.getSelectionStart() > 0) {
                        String substring = this.aDS.getText().toString().substring(0, this.aDS.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cvc.matcher(substring);
                        if (matcher.find()) {
                            this.aDS.getText().delete(this.aDS.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aDS.getSelectionStart());
                            break;
                        } else {
                            this.aDS.getText().delete(this.aDS.getSelectionStart() - 1, this.aDS.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aDS.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aDS.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.aDS.setText(spannableStringBuilder);
                                    f.this.aDS.setSelection(f.this.aDS.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aDY[0] = false;
                        break;
                    } else {
                        this.aDY[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aDS.setText((CharSequence) null);
                    }
                    this.aDY[0] = false;
                    this.aDY[1] = false;
                    this.aDY[2] = false;
                    this.aDY[3] = false;
                    this.aDY[4] = false;
                    this.aDZ[0] = 0;
                    this.aDZ[1] = 0;
                    break;
                case 10:
                    this.aDY[2] = true;
                    break;
                case 11:
                    this.aDY[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCN != null) {
                            if (aVar2.aCN.getChosedFiles() != null) {
                                this.aDZ[0] = aVar2.aCN.getChosedFiles().size();
                            } else {
                                this.aDZ[0] = 0;
                            }
                        }
                        if (this.aDZ[0] > 0) {
                            this.aDY[1] = true;
                            break;
                        } else {
                            this.aDY[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aDZ;
                    iArr[0] = iArr[0] - 1;
                    if (this.aDZ[0] > 0) {
                        this.aDY[1] = true;
                        break;
                    } else {
                        this.aDY[1] = false;
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
                        this.aDU.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.aDs) {
                            this.aDU.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aDT.k(aVar3.state, null);
                                break;
                            } else {
                                this.aDT.k(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aDU.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aDU.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aDY[3] = true;
                    break;
                case 29:
                    this.aDY[3] = false;
                    break;
                case d.l.View_minWidth /* 44 */:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fS((String) aVar.data);
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
            if (this.aDY[0] || this.aDY[1] || this.aDY[2] || this.aDY[3] || this.aDY[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0082d.cp_link_tip_a, 1, this.apA);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.c(this.mSendView, d.C0082d.cp_cont_d, 1);
        } else if (i == aEa) {
            if (this.aDY[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0082d.cp_link_tip_a, 1, this.apA);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.c(this.mSendView, d.C0082d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aDX = z;
    }

    public void setHint(int i) {
        if (this.aDS != null) {
            this.aDS.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aDS != null) {
            this.aDS.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aDS;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aDT;
    }

    public LinearLayout getInputLayout() {
        return this.aDW;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aDU) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aDV) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
