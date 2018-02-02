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
    private com.baidu.tbadk.editortools.i axQ;
    private int axR;
    private int bdS;
    private boolean brH;
    private boolean brI;
    private boolean brJ;
    private int brK;
    private EditText bsm;
    private PbNewLocationInfoView bsn;
    private LinearLayout bso;
    private ImageView bsp;
    private LinearLayout bsq;
    private boolean bsr;
    private boolean[] bss;
    private int[] bst;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bsu = 1;
    public static int ALL = 0;

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.brH = false;
        this.brI = true;
        this.brJ = true;
        this.brK = -1;
        this.bsr = true;
        this.bss = new boolean[]{false, false, false, false, false};
        this.bst = new int[]{0, 0};
        this.bdS = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        bg(context);
        this.bsq = new LinearLayout(getContext());
        this.bsq.setOrientation(0);
        this.bsq.setMinimumHeight(l.s(context, d.e.ds90));
        addView(this.bsq, new LinearLayout.LayoutParams(-1, -2));
        bi(context);
        bh(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.s(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void bg(Context context) {
        this.bso = new LinearLayout(getContext());
        this.bso.setGravity(16);
        this.bso.setOrientation(0);
        this.bso.setPadding(l.s(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.s(context, d.e.ds48));
        layoutParams.setMargins(l.s(context, d.e.ds34), l.s(context, d.e.ds30), l.s(context, d.e.ds34), l.s(context, d.e.ds12));
        this.bso.setLayoutParams(layoutParams);
        this.bso.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bsn = new PbNewLocationInfoView(context);
        this.bso.addView(this.bsn, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.bsp = new ImageView(context);
        this.bsp.setPadding(l.s(context, d.e.ds24), 0, l.s(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.bso.addView(this.bsp, layoutParams3);
        addView(this.bso);
        this.bso.setVisibility(8);
        this.bsp.setOnClickListener(this);
    }

    private void bh(Context context) {
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
        this.bsq.addView(this.mSendView, layoutParams);
    }

    private void bi(Context context) {
        this.bsm = new EditText(context);
        this.bsm.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.bsm.setMaxLines(4);
        this.bsm.setGravity(16);
        this.bsm.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.bsm.setTextColor(getResources().getColor(d.C0108d.cp_cont_b));
        this.bsm.setHintTextColor(getResources().getColor(d.C0108d.cp_cont_e));
        this.bsm.setBackgroundResource(d.C0108d.common_color_10022);
        a(this.bsm, d.f.edittext_cursor);
        this.bsm.setPadding(0, l.s(context, d.e.ds24), l.s(context, d.e.ds54), l.s(context, d.e.ds24));
        this.bsm.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.bsm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.f.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!f.this.brJ) {
                    f.this.brJ = true;
                    if (f.this.brK != -1) {
                        f.this.bsm.setSelection(f.this.brK);
                        f.this.brK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    f.this.b(new com.baidu.tbadk.editortools.a(4, -1, f.this.bsm.getText().toString()));
                }
            }
        });
        this.bsm.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.f.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    f.this.bsm.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.s(context, d.e.ds34), 0, 0, 0);
        this.bsq.addView(this.bsm, layoutParams);
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
                    this.bsm.getText().insert(this.bsm.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gh(String str) {
        if (!StringUtils.isNull(str)) {
            this.bsm.getText().insert(this.bsm.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Ft() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.bsm.getText().toString();
            if (this.brI && com.baidu.tieba.face.a.kM(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.By().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.bsm);
            }
        }
    }

    private void b(n nVar) {
        if (!this.brH || nVar.Ft() == EmotionGroupType.LOCAL) {
            String obj = this.bsm.getText().toString();
            if (this.brI && com.baidu.tieba.face.a.kM(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.By().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.bsm);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.brH = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(com.baidu.tbadk.editortools.i iVar) {
        this.axQ = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axQ != null) {
            this.axQ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axR;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void ti() {
        if (this.bsm != null && this.bsq.getVisibility() == 0) {
            this.bsm.setFocusable(true);
            this.bsm.setFocusableInTouchMode(true);
            this.bsm.requestFocus();
            l.b(getContext(), this.bsm);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this.bsm, d.C0108d.cp_cont_b, 2, i);
        aj.t(this.mBottomLine, d.C0108d.cp_bg_line_c);
        aj.t(this, d.C0108d.cp_bg_line_d);
        aj.s(this.bso, d.f.pb_new_locatin_view_selector);
        aj.c(this.bsp, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.bsm, d.f.edittext_cursor);
            this.bsm.setHintTextColor(getContext().getResources().getColor(d.C0108d.cp_cont_e));
        } else {
            a(this.bsm, d.f.edittext_cursor_1);
            this.bsm.setHintTextColor(aj.getColor(i, d.C0108d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            aj.b(this.mSendView, d.C0108d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this.mSendView, d.C0108d.cp_cont_e, 1);
        }
        this.bsn.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.bsm.getSelectionStart() > 0) {
                        String substring = this.bsm.getText().toString().substring(0, this.bsm.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.doH.matcher(substring);
                        if (matcher.find()) {
                            this.bsm.getText().delete(this.bsm.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bsm.getSelectionStart());
                            break;
                        } else {
                            this.bsm.getText().delete(this.bsm.getSelectionStart() - 1, this.bsm.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.bsm.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.bsm.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.f.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    f.this.bsm.setText(spannableStringBuilder);
                                    f.this.bsm.setSelection(f.this.bsm.getText().length());
                                    f.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    f.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bss[0] = false;
                        break;
                    } else {
                        this.bss[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.bsm.setText((CharSequence) null);
                    }
                    this.bss[0] = false;
                    this.bss[1] = false;
                    this.bss[2] = false;
                    this.bss[3] = false;
                    this.bss[4] = false;
                    this.bst[0] = 0;
                    this.bst[1] = 0;
                    break;
                case 10:
                    this.bss[2] = true;
                    break;
                case 11:
                    this.bss[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.bri != null) {
                            if (aVar2.bri.getChosedFiles() != null) {
                                this.bst[0] = aVar2.bri.getChosedFiles().size();
                            } else {
                                this.bst[0] = 0;
                            }
                        }
                        if (this.bst[0] > 0) {
                            this.bss[1] = true;
                            break;
                        } else {
                            this.bss[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bst;
                    iArr[0] = iArr[0] - 1;
                    if (this.bst[0] > 0) {
                        this.bss[1] = true;
                        break;
                    } else {
                        this.bss[1] = false;
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
                        this.bso.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.brM) {
                            this.bso.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.bsn.j(aVar3.state, null);
                                break;
                            } else {
                                this.bsn.j(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.bso.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.bso.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bss[3] = true;
                    break;
                case 29:
                    this.bss[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gh((String) aVar.data);
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
            if (this.bss[0] || this.bss[1] || this.bss[2] || this.bss[3] || this.bss[4]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0108d.cp_link_tip_a, 1, this.bdS);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0108d.cp_cont_d, 1);
        } else if (i == bsu) {
            if (this.bss[1]) {
                this.mSendView.setEnabled(true);
                aj.b(this.mSendView, d.C0108d.cp_link_tip_a, 1, this.bdS);
                return;
            }
            this.mSendView.setEnabled(false);
            aj.e(this.mSendView, d.C0108d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.bsr = z;
    }

    public void setHint(int i) {
        if (this.bsm != null) {
            this.bsm.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.bsm != null) {
            this.bsm.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.bsm;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.bsn;
    }

    public LinearLayout getInputLayout() {
        return this.bsq;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bso) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bsp) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
