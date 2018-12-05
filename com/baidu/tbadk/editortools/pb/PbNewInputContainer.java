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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools Ta;
    private int Tb;
    private int aLF;
    private boolean aZG;
    private boolean aZH;
    private boolean aZI;
    private int aZJ;
    private EditText bai;
    private PbNewLocationInfoView baj;
    private LinearLayout bak;
    private ImageView bal;
    private LinearLayout bam;
    private boolean ban;
    private boolean[] bao;
    private int[] bap;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int baq = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZG = false;
        this.aZH = true;
        this.aZI = true;
        this.aZJ = -1;
        this.ban = true;
        this.bao = new boolean[]{false, false, false, false, false};
        this.bap = new int[]{0, 0};
        this.aLF = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds90));
        bO(context);
        this.bam = new LinearLayout(getContext());
        this.bam.setOrientation(0);
        this.bam.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds90));
        addView(this.bam, new LinearLayout.LayoutParams(-1, -2));
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds1)));
        addView(this.mBottomLine);
    }

    private void bO(Context context) {
        this.bak = new LinearLayout(getContext());
        this.bak.setGravity(16);
        this.bak.setOrientation(0);
        this.bak.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds12));
        this.bak.setLayoutParams(layoutParams);
        this.bak.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.baj = new PbNewLocationInfoView(context);
        this.bak.addView(this.baj, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.bal = new ImageView(context);
        this.bal.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.bak.addView(this.bal, layoutParams3);
        addView(this.bak);
        this.bak.setVisibility(8);
        this.bal.setOnClickListener(this);
    }

    private void bP(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0210e.fontsize32));
        this.mSendView.setText(e.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), 0);
        this.bam.addView(this.mSendView, layoutParams);
    }

    private void bQ(Context context) {
        this.bai = new EditText(context);
        this.bai.setMinHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.bai.setMaxLines(4);
        this.bai.setGravity(16);
        this.bai.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.bai.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.bai.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.bai.setBackgroundResource(e.d.common_color_10022);
        a(this.bai, e.f.edittext_cursor);
        this.bai.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24));
        this.bai.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.bai.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aZI) {
                    PbNewInputContainer.this.aZI = true;
                    if (PbNewInputContainer.this.aZJ != -1) {
                        PbNewInputContainer.this.bai.setSelection(PbNewInputContainer.this.aZJ);
                        PbNewInputContainer.this.aZJ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.bai.getText().toString()));
                }
            }
        });
        this.bai.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.bai.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), 0, 0, 0);
        this.bam.addView(this.bai, layoutParams);
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

    private void t(ArrayList<String> arrayList) {
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
                    this.bai.getText().insert(this.bai.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.bai.getText().insert(this.bai.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p)) {
            p pVar = (p) aVar.data;
            if (pVar.GM() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.bai.getText().toString();
            if (this.aZH && com.baidu.tieba.face.a.ng(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CD().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.bai);
            }
        }
    }

    private void b(p pVar) {
        if (!this.aZG || pVar.GM() == EmotionGroupType.LOCAL) {
            String obj = this.bai.getText().toString();
            if (this.aZH && com.baidu.tieba.face.a.ng(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CD().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.bai);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aZG = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        if (this.bai != null && this.bam.getVisibility() == 0) {
            this.bai.setFocusable(true);
            this.bai.setFocusableInTouchMode(true);
            this.bai.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.bai);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.bai, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.bak, e.f.pb_new_locatin_view_selector);
        al.c(this.bal, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.bai, e.f.edittext_cursor);
            this.bai.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.bai, e.f.edittext_cursor_1);
            this.bai.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.baj.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.bai.getSelectionStart() > 0) {
                        String substring = this.bai.getText().toString().substring(0, this.bai.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dqQ.matcher(substring);
                        if (matcher.find()) {
                            this.bai.getText().delete(this.bai.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bai.getSelectionStart());
                            break;
                        } else {
                            this.bai.getText().delete(this.bai.getSelectionStart() - 1, this.bai.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.bai.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.bai.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.bai.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.bai.setSelection(PbNewInputContainer.this.bai.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bao[0] = false;
                        break;
                    } else {
                        this.bao[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.bai.setText((CharSequence) null);
                    }
                    this.bao[0] = false;
                    this.bao[1] = false;
                    this.bao[2] = false;
                    this.bao[3] = false;
                    this.bao[4] = false;
                    this.bap[0] = 0;
                    this.bap[1] = 0;
                    break;
                case 10:
                    this.bao[2] = true;
                    break;
                case 11:
                    this.bao[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aZh != null) {
                            if (aVar2.aZh.getChosedFiles() != null) {
                                this.bap[0] = aVar2.aZh.getChosedFiles().size();
                            } else {
                                this.bap[0] = 0;
                            }
                        }
                        if (this.bap[0] > 0) {
                            this.bao[1] = true;
                            break;
                        } else {
                            this.bao[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bap;
                    iArr[0] = iArr[0] - 1;
                    if (this.bap[0] > 0) {
                        this.bao[1] = true;
                        break;
                    } else {
                        this.bao[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        t((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.bak.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.bak.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.baj.setState(aVar3.state, null);
                                break;
                            } else {
                                this.baj.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.bak.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.bak.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bao[3] = true;
                    break;
                case 29:
                    this.bao[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        hJ((String) aVar.data);
                        break;
                    }
                    break;
            }
            fS(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fS(int i) {
        if (i == ALL) {
            if (this.bao[0] || this.bao[1] || this.bao[2] || this.bao[3] || this.bao[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == baq) {
            if (this.bao[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.ban = z;
    }

    public void setHint(int i) {
        if (this.bai != null) {
            this.bai.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.bai != null) {
            this.bai.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.bai;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.baj;
    }

    public LinearLayout getInputLayout() {
        return this.bam;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bak) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bal) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
