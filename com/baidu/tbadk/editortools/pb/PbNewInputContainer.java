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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools Qh;
    private int Qi;
    private boolean aMH;
    private boolean aMI;
    private boolean aMJ;
    private int aMK;
    private EditText aNk;
    private PbNewLocationInfoView aNl;
    private LinearLayout aNm;
    private ImageView aNn;
    private LinearLayout aNo;
    private boolean aNp;
    private boolean[] aNq;
    private int[] aNr;
    private int ayX;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aNs = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aMH = false;
        this.aMI = true;
        this.aMJ = true;
        this.aMK = -1;
        this.aNp = true;
        this.aNq = new boolean[]{false, false, false, false, false};
        this.aNr = new int[]{0, 0};
        this.ayX = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        ba(context);
        this.aNo = new LinearLayout(getContext());
        this.aNo.setOrientation(0);
        this.aNo.setMinimumHeight(com.baidu.adp.lib.util.l.e(context, d.e.ds90));
        addView(this.aNo, new LinearLayout.LayoutParams(-1, -2));
        bc(context);
        bb(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.e(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void ba(Context context) {
        this.aNm = new LinearLayout(getContext());
        this.aNm.setGravity(16);
        this.aNm.setOrientation(0);
        this.aNm.setPadding(com.baidu.adp.lib.util.l.e(context, d.e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.e(context, d.e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds34), com.baidu.adp.lib.util.l.e(context, d.e.ds30), com.baidu.adp.lib.util.l.e(context, d.e.ds34), com.baidu.adp.lib.util.l.e(context, d.e.ds12));
        this.aNm.setLayoutParams(layoutParams);
        this.aNm.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aNl = new PbNewLocationInfoView(context);
        this.aNm.addView(this.aNl, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds24);
        this.aNn = new ImageView(context);
        this.aNn.setPadding(com.baidu.adp.lib.util.l.e(context, d.e.ds24), 0, com.baidu.adp.lib.util.l.e(context, d.e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aNm.addView(this.aNn, layoutParams3);
        addView(this.aNm);
        this.aNm.setVisibility(8);
        this.aNn.setOnClickListener(this);
    }

    private void bb(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize32));
        this.mSendView.setText(d.k.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.e(context, d.e.ds34), 0);
        this.aNo.addView(this.mSendView, layoutParams);
    }

    private void bc(Context context) {
        this.aNk = new EditText(context);
        this.aNk.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.aNk.setMaxLines(4);
        this.aNk.setGravity(16);
        this.aNk.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.aNk.setTextColor(getResources().getColor(d.C0141d.cp_cont_b));
        this.aNk.setHintTextColor(getResources().getColor(d.C0141d.cp_cont_e));
        this.aNk.setBackgroundResource(d.C0141d.common_color_10022);
        a(this.aNk, d.f.edittext_cursor);
        this.aNk.setPadding(0, com.baidu.adp.lib.util.l.e(context, d.e.ds24), com.baidu.adp.lib.util.l.e(context, d.e.ds54), com.baidu.adp.lib.util.l.e(context, d.e.ds24));
        this.aNk.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aNk.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aMJ) {
                    PbNewInputContainer.this.aMJ = true;
                    if (PbNewInputContainer.this.aMK != -1) {
                        PbNewInputContainer.this.aNk.setSelection(PbNewInputContainer.this.aMK);
                        PbNewInputContainer.this.aMK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aNk.getText().toString()));
                }
            }
        });
        this.aNk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aNk.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.e(context, d.e.ds34), 0, 0, 0);
        this.aNo.addView(this.aNk, layoutParams);
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
                    this.aNk.getText().insert(this.aNk.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            this.aNk.getText().insert(this.aNk.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Cb() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = this.aNk.getText().toString();
            if (this.aMI && com.baidu.tieba.face.a.lF(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.xZ().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), nVar, this.aNk);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aMH || nVar.Cb() == EmotionGroupType.LOCAL) {
            String obj = this.aNk.getText().toString();
            if (this.aMI && com.baidu.tieba.face.a.lF(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.xZ().showToast(d.k.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), nVar, this.aNk);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aMH = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        if (this.aNk != null && this.aNo.getVisibility() == 0) {
            this.aNk.setFocusable(true);
            this.aNk.setFocusableInTouchMode(true);
            this.aNk.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aNk);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.aNk, d.C0141d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, d.C0141d.cp_bg_line_c);
        al.j(this, d.C0141d.cp_bg_line_d);
        al.i(this.aNm, d.f.pb_new_locatin_view_selector);
        al.c(this.aNn, d.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aNk, d.f.edittext_cursor);
            this.aNk.setHintTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_e));
        } else {
            a(this.aNk, d.f.edittext_cursor_1);
            this.aNk.setHintTextColor(al.getColor(i, d.C0141d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, d.C0141d.cp_cont_e, 1);
        }
        this.aNl.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aNk.getSelectionStart() > 0) {
                        String substring = this.aNk.getText().toString().substring(0, this.aNk.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cUu.matcher(substring);
                        if (matcher.find()) {
                            this.aNk.getText().delete(this.aNk.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aNk.getSelectionStart());
                            break;
                        } else {
                            this.aNk.getText().delete(this.aNk.getSelectionStart() - 1, this.aNk.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aNk.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aNk.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aNk.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aNk.setSelection(PbNewInputContainer.this.aNk.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aNq[0] = false;
                        break;
                    } else {
                        this.aNq[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aNk.setText((CharSequence) null);
                    }
                    this.aNq[0] = false;
                    this.aNq[1] = false;
                    this.aNq[2] = false;
                    this.aNq[3] = false;
                    this.aNq[4] = false;
                    this.aNr[0] = 0;
                    this.aNr[1] = 0;
                    break;
                case 10:
                    this.aNq[2] = true;
                    break;
                case 11:
                    this.aNq[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aMi != null) {
                            if (aVar2.aMi.getChosedFiles() != null) {
                                this.aNr[0] = aVar2.aMi.getChosedFiles().size();
                            } else {
                                this.aNr[0] = 0;
                            }
                        }
                        if (this.aNr[0] > 0) {
                            this.aNq[1] = true;
                            break;
                        } else {
                            this.aNq[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aNr;
                    iArr[0] = iArr[0] - 1;
                    if (this.aNr[0] > 0) {
                        this.aNq[1] = true;
                        break;
                    } else {
                        this.aNq[1] = false;
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
                        this.aNm.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.aMM) {
                            this.aNm.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aNl.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aNl.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aNm.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aNm.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aNq[3] = true;
                    break;
                case 29:
                    this.aNq[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gG((String) aVar.data);
                        break;
                    }
                    break;
            }
            eU(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eU(int i) {
        if (i == ALL) {
            if (this.aNq[0] || this.aNq[1] || this.aNq[2] || this.aNq[3] || this.aNq[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, d.C0141d.cp_cont_d, 1);
        } else if (i == aNs) {
            if (this.aNq[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, d.C0141d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, d.C0141d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aNp = z;
    }

    public void setHint(int i) {
        if (this.aNk != null) {
            this.aNk.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aNk != null) {
            this.aNk.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aNk;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aNl;
    }

    public LinearLayout getInputLayout() {
        return this.aNo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aNm) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aNn) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
