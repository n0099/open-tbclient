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
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools SG;
    private int SH;
    private int aCJ;
    private boolean aQS;
    private boolean aQT;
    private boolean aQU;
    private int aQV;
    private boolean[] aRA;
    private int[] aRB;
    private EditText aRu;
    private PbNewLocationInfoView aRv;
    private LinearLayout aRw;
    private ImageView aRx;
    private LinearLayout aRy;
    private boolean aRz;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aRC = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aQS = false;
        this.aQT = true;
        this.aQU = true;
        this.aQV = -1;
        this.aRz = true;
        this.aRA = new boolean[]{false, false, false, false, false};
        this.aRB = new int[]{0, 0};
        this.aCJ = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0141e.ds90));
        bG(context);
        this.aRy = new LinearLayout(getContext());
        this.aRy.setOrientation(0);
        this.aRy.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds90));
        addView(this.aRy, new LinearLayout.LayoutParams(-1, -2));
        bI(context);
        bH(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0141e.ds1)));
        addView(this.mBottomLine);
    }

    private void bG(Context context) {
        this.aRw = new LinearLayout(getContext());
        this.aRw.setGravity(16);
        this.aRw.setOrientation(0);
        this.aRw.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0141e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds12));
        this.aRw.setLayoutParams(layoutParams);
        this.aRw.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aRv = new PbNewLocationInfoView(context);
        this.aRw.addView(this.aRv, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0141e.ds24);
        this.aRx = new ImageView(context);
        this.aRx.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0141e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aRw.addView(this.aRx, layoutParams3);
        addView(this.aRw);
        this.aRw.setVisibility(8);
        this.aRx.setOnClickListener(this);
    }

    private void bH(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0141e.fontsize32));
        this.mSendView.setText(e.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0141e.ds34), 0);
        this.aRy.addView(this.mSendView, layoutParams);
    }

    private void bI(Context context) {
        this.aRu = new EditText(context);
        this.aRu.setMinHeight(context.getResources().getDimensionPixelSize(e.C0141e.ds32));
        this.aRu.setMaxLines(4);
        this.aRu.setGravity(16);
        this.aRu.setTextSize(0, getResources().getDimensionPixelSize(e.C0141e.ds32));
        this.aRu.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.aRu.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.aRu.setBackgroundResource(e.d.common_color_10022);
        a(this.aRu, e.f.edittext_cursor);
        this.aRu.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0141e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0141e.ds24));
        this.aRu.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aRu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aQU) {
                    PbNewInputContainer.this.aQU = true;
                    if (PbNewInputContainer.this.aQV != -1) {
                        PbNewInputContainer.this.aRu.setSelection(PbNewInputContainer.this.aQV);
                        PbNewInputContainer.this.aQV = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aRu.getText().toString()));
                }
            }
        });
        this.aRu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aRu.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0141e.ds34), 0, 0, 0);
        this.aRy.addView(this.aRu, layoutParams);
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
                    this.aRu.getText().insert(this.aRu.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hc(String str) {
        if (!StringUtils.isNull(str)) {
            this.aRu.getText().insert(this.aRu.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof o)) {
            o oVar = (o) aVar.data;
            if (oVar.Dv() == EmotionGroupType.NET_SUG) {
                a(oVar);
            } else {
                b(oVar);
            }
        }
    }

    private void a(o oVar) {
        if (oVar != null && !TextUtils.isEmpty(oVar.getName()) && !TextUtils.isEmpty(oVar.getUrl())) {
            String obj = this.aRu.getText().toString();
            if (this.aQT && com.baidu.tieba.face.a.me(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.zk().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), oVar, this.aRu);
            }
        }
    }

    private void b(o oVar) {
        if (!this.aQS || oVar.Dv() == EmotionGroupType.LOCAL) {
            String obj = this.aRu.getText().toString();
            if (this.aQT && com.baidu.tieba.face.a.me(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.zk().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), oVar, this.aRu);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aQS = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        if (this.aRu != null && this.aRy.getVisibility() == 0) {
            this.aRu.setFocusable(true);
            this.aRu.setFocusableInTouchMode(true);
            this.aRu.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aRu);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.aRu, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.aRw, e.f.pb_new_locatin_view_selector);
        al.c(this.aRx, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aRu, e.f.edittext_cursor);
            this.aRu.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.aRu, e.f.edittext_cursor_1);
            this.aRu.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.aRv.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aRu.getSelectionStart() > 0) {
                        String substring = this.aRu.getText().toString().substring(0, this.aRu.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.daY.matcher(substring);
                        if (matcher.find()) {
                            this.aRu.getText().delete(this.aRu.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aRu.getSelectionStart());
                            break;
                        } else {
                            this.aRu.getText().delete(this.aRu.getSelectionStart() - 1, this.aRu.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aRu.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aRu.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aRu.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aRu.setSelection(PbNewInputContainer.this.aRu.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aRA[0] = false;
                        break;
                    } else {
                        this.aRA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aRu.setText((CharSequence) null);
                    }
                    this.aRA[0] = false;
                    this.aRA[1] = false;
                    this.aRA[2] = false;
                    this.aRA[3] = false;
                    this.aRA[4] = false;
                    this.aRB[0] = 0;
                    this.aRB[1] = 0;
                    break;
                case 10:
                    this.aRA[2] = true;
                    break;
                case 11:
                    this.aRA[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aQt != null) {
                            if (aVar2.aQt.getChosedFiles() != null) {
                                this.aRB[0] = aVar2.aQt.getChosedFiles().size();
                            } else {
                                this.aRB[0] = 0;
                            }
                        }
                        if (this.aRB[0] > 0) {
                            this.aRA[1] = true;
                            break;
                        } else {
                            this.aRA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aRB;
                    iArr[0] = iArr[0] - 1;
                    if (this.aRB[0] > 0) {
                        this.aRA[1] = true;
                        break;
                    } else {
                        this.aRA[1] = false;
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
                        this.aRw.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.aRw.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aRv.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aRv.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aRw.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aRw.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aRA[3] = true;
                    break;
                case 29:
                    this.aRA[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        hc((String) aVar.data);
                        break;
                    }
                    break;
            }
            fh(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fh(int i) {
        if (i == ALL) {
            if (this.aRA[0] || this.aRA[1] || this.aRA[2] || this.aRA[3] || this.aRA[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == aRC) {
            if (this.aRA[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aRz = z;
    }

    public void setHint(int i) {
        if (this.aRu != null) {
            this.aRu.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aRu != null) {
            this.aRu.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aRu;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aRv;
    }

    public LinearLayout getInputLayout() {
        return this.aRy;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aRw) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aRx) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
