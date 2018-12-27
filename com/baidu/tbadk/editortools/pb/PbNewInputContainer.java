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
    private int aLH;
    private boolean aZJ;
    private boolean aZK;
    private boolean aZL;
    private int aZM;
    private EditText bal;
    private PbNewLocationInfoView bam;
    private LinearLayout ban;
    private ImageView bao;
    private LinearLayout bap;
    private boolean baq;
    private boolean[] bas;
    private int[] bat;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bau = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aZJ = false;
        this.aZK = true;
        this.aZL = true;
        this.aZM = -1;
        this.baq = true;
        this.bas = new boolean[]{false, false, false, false, false};
        this.bat = new int[]{0, 0};
        this.aLH = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds90));
        bO(context);
        this.bap = new LinearLayout(getContext());
        this.bap.setOrientation(0);
        this.bap.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds90));
        addView(this.bap, new LinearLayout.LayoutParams(-1, -2));
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds1)));
        addView(this.mBottomLine);
    }

    private void bO(Context context) {
        this.ban = new LinearLayout(getContext());
        this.ban.setGravity(16);
        this.ban.setOrientation(0);
        this.ban.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds12));
        this.ban.setLayoutParams(layoutParams);
        this.ban.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.bam = new PbNewLocationInfoView(context);
        this.ban.addView(this.bam, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.bao = new ImageView(context);
        this.bao.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.ban.addView(this.bao, layoutParams3);
        addView(this.ban);
        this.ban.setVisibility(8);
        this.bao.setOnClickListener(this);
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
        this.bap.addView(this.mSendView, layoutParams);
    }

    private void bQ(Context context) {
        this.bal = new EditText(context);
        this.bal.setMinHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.bal.setMaxLines(4);
        this.bal.setGravity(16);
        this.bal.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.bal.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.bal.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.bal.setBackgroundResource(e.d.common_color_10022);
        a(this.bal, e.f.edittext_cursor);
        this.bal.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24));
        this.bal.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.bal.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aZL) {
                    PbNewInputContainer.this.aZL = true;
                    if (PbNewInputContainer.this.aZM != -1) {
                        PbNewInputContainer.this.bal.setSelection(PbNewInputContainer.this.aZM);
                        PbNewInputContainer.this.aZM = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.bal.getText().toString()));
                }
            }
        });
        this.bal.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.bal.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), 0, 0, 0);
        this.bap.addView(this.bal, layoutParams);
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
                    this.bal.getText().insert(this.bal.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hK(String str) {
        if (!StringUtils.isNull(str)) {
            this.bal.getText().insert(this.bal.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p)) {
            p pVar = (p) aVar.data;
            if (pVar.GN() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.bal.getText().toString();
            if (this.aZK && com.baidu.tieba.face.a.nj(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CD().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.bal);
            }
        }
    }

    private void b(p pVar) {
        if (!this.aZJ || pVar.GN() == EmotionGroupType.LOCAL) {
            String obj = this.bal.getText().toString();
            if (this.aZK && com.baidu.tieba.face.a.nj(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CD().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.bal);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aZJ = z;
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
        if (this.bal != null && this.bap.getVisibility() == 0) {
            this.bal.setFocusable(true);
            this.bal.setFocusableInTouchMode(true);
            this.bal.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.bal);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.bal, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.ban, e.f.pb_new_locatin_view_selector);
        al.c(this.bao, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.bal, e.f.edittext_cursor);
            this.bal.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.bal, e.f.edittext_cursor_1);
            this.bal.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.bam.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.bal.getSelectionStart() > 0) {
                        String substring = this.bal.getText().toString().substring(0, this.bal.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dtE.matcher(substring);
                        if (matcher.find()) {
                            this.bal.getText().delete(this.bal.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.bal.getSelectionStart());
                            break;
                        } else {
                            this.bal.getText().delete(this.bal.getSelectionStart() - 1, this.bal.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.bal.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.bal.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.bal.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.bal.setSelection(PbNewInputContainer.this.bal.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bas[0] = false;
                        break;
                    } else {
                        this.bas[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.bal.setText((CharSequence) null);
                    }
                    this.bas[0] = false;
                    this.bas[1] = false;
                    this.bas[2] = false;
                    this.bas[3] = false;
                    this.bas[4] = false;
                    this.bat[0] = 0;
                    this.bat[1] = 0;
                    break;
                case 10:
                    this.bas[2] = true;
                    break;
                case 11:
                    this.bas[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aZk != null) {
                            if (aVar2.aZk.getChosedFiles() != null) {
                                this.bat[0] = aVar2.aZk.getChosedFiles().size();
                            } else {
                                this.bat[0] = 0;
                            }
                        }
                        if (this.bat[0] > 0) {
                            this.bas[1] = true;
                            break;
                        } else {
                            this.bas[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bat;
                    iArr[0] = iArr[0] - 1;
                    if (this.bat[0] > 0) {
                        this.bas[1] = true;
                        break;
                    } else {
                        this.bas[1] = false;
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
                        this.ban.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.ban.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.bam.setState(aVar3.state, null);
                                break;
                            } else {
                                this.bam.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.ban.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.ban.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bas[3] = true;
                    break;
                case 29:
                    this.bas[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        hK((String) aVar.data);
                        break;
                    }
                    break;
            }
            fT(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fT(int i) {
        if (i == ALL) {
            if (this.bas[0] || this.bas[1] || this.bas[2] || this.bas[3] || this.bas[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == bau) {
            if (this.bas[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.baq = z;
    }

    public void setHint(int i) {
        if (this.bal != null) {
            this.bal.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.bal != null) {
            this.bal.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.bal;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.bam;
    }

    public LinearLayout getInputLayout() {
        return this.bap;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ban) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bao) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
