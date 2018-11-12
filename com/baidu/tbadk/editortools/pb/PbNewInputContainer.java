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
    private int aIf;
    private EditText aWL;
    private PbNewLocationInfoView aWM;
    private LinearLayout aWN;
    private ImageView aWO;
    private LinearLayout aWP;
    private boolean aWQ;
    private boolean[] aWR;
    private int[] aWS;
    private boolean aWj;
    private boolean aWk;
    private boolean aWl;
    private int aWm;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aWT = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aWj = false;
        this.aWk = true;
        this.aWl = true;
        this.aWm = -1;
        this.aWQ = true;
        this.aWR = new boolean[]{false, false, false, false, false};
        this.aWS = new int[]{0, 0};
        this.aIf = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0200e.ds90));
        bL(context);
        this.aWP = new LinearLayout(getContext());
        this.aWP.setOrientation(0);
        this.aWP.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds90));
        addView(this.aWP, new LinearLayout.LayoutParams(-1, -2));
        bN(context);
        bM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0200e.ds1)));
        addView(this.mBottomLine);
    }

    private void bL(Context context) {
        this.aWN = new LinearLayout(getContext());
        this.aWN.setGravity(16);
        this.aWN.setOrientation(0);
        this.aWN.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0200e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds12));
        this.aWN.setLayoutParams(layoutParams);
        this.aWN.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aWM = new PbNewLocationInfoView(context);
        this.aWN.addView(this.aWM, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0200e.ds24);
        this.aWO = new ImageView(context);
        this.aWO.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0200e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aWN.addView(this.aWO, layoutParams3);
        addView(this.aWN);
        this.aWN.setVisibility(8);
        this.aWO.setOnClickListener(this);
    }

    private void bM(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0200e.fontsize32));
        this.mSendView.setText(e.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0200e.ds34), 0);
        this.aWP.addView(this.mSendView, layoutParams);
    }

    private void bN(Context context) {
        this.aWL = new EditText(context);
        this.aWL.setMinHeight(context.getResources().getDimensionPixelSize(e.C0200e.ds32));
        this.aWL.setMaxLines(4);
        this.aWL.setGravity(16);
        this.aWL.setTextSize(0, getResources().getDimensionPixelSize(e.C0200e.ds32));
        this.aWL.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.aWL.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.aWL.setBackgroundResource(e.d.common_color_10022);
        a(this.aWL, e.f.edittext_cursor);
        this.aWL.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0200e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0200e.ds24));
        this.aWL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aWL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aWl) {
                    PbNewInputContainer.this.aWl = true;
                    if (PbNewInputContainer.this.aWm != -1) {
                        PbNewInputContainer.this.aWL.setSelection(PbNewInputContainer.this.aWm);
                        PbNewInputContainer.this.aWm = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aWL.getText().toString()));
                }
            }
        });
        this.aWL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aWL.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0200e.ds34), 0, 0, 0);
        this.aWP.addView(this.aWL, layoutParams);
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
                    this.aWL.getText().insert(this.aWL.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hr(String str) {
        if (!StringUtils.isNull(str)) {
            this.aWL.getText().insert(this.aWL.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p)) {
            p pVar = (p) aVar.data;
            if (pVar.FI() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.aWL.getText().toString();
            if (this.aWk && com.baidu.tieba.face.a.mH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bz().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.aWL);
            }
        }
    }

    private void b(p pVar) {
        if (!this.aWj || pVar.FI() == EmotionGroupType.LOCAL) {
            String obj = this.aWL.getText().toString();
            if (this.aWk && com.baidu.tieba.face.a.mH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bz().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.aWL);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aWj = z;
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
    public void pO() {
        if (this.aWL != null && this.aWP.getVisibility() == 0) {
            this.aWL.setFocusable(true);
            this.aWL.setFocusableInTouchMode(true);
            this.aWL.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.aWL);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.aWL, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.aWN, e.f.pb_new_locatin_view_selector);
        al.c(this.aWO, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aWL, e.f.edittext_cursor);
            this.aWL.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.aWL, e.f.edittext_cursor_1);
            this.aWL.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.aWM.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aWL.getSelectionStart() > 0) {
                        String substring = this.aWL.getText().toString().substring(0, this.aWL.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dko.matcher(substring);
                        if (matcher.find()) {
                            this.aWL.getText().delete(this.aWL.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aWL.getSelectionStart());
                            break;
                        } else {
                            this.aWL.getText().delete(this.aWL.getSelectionStart() - 1, this.aWL.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aWL.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aWL.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aWL.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aWL.setSelection(PbNewInputContainer.this.aWL.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aWR[0] = false;
                        break;
                    } else {
                        this.aWR[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aWL.setText((CharSequence) null);
                    }
                    this.aWR[0] = false;
                    this.aWR[1] = false;
                    this.aWR[2] = false;
                    this.aWR[3] = false;
                    this.aWR[4] = false;
                    this.aWS[0] = 0;
                    this.aWS[1] = 0;
                    break;
                case 10:
                    this.aWR[2] = true;
                    break;
                case 11:
                    this.aWR[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aVK != null) {
                            if (aVar2.aVK.getChosedFiles() != null) {
                                this.aWS[0] = aVar2.aVK.getChosedFiles().size();
                            } else {
                                this.aWS[0] = 0;
                            }
                        }
                        if (this.aWS[0] > 0) {
                            this.aWR[1] = true;
                            break;
                        } else {
                            this.aWR[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aWS;
                    iArr[0] = iArr[0] - 1;
                    if (this.aWS[0] > 0) {
                        this.aWR[1] = true;
                        break;
                    } else {
                        this.aWR[1] = false;
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
                        this.aWN.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.aWN.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aWM.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aWM.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aWN.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aWN.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aWR[3] = true;
                    break;
                case 29:
                    this.aWR[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        hr((String) aVar.data);
                        break;
                    }
                    break;
            }
            fE(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fE(int i) {
        if (i == ALL) {
            if (this.aWR[0] || this.aWR[1] || this.aWR[2] || this.aWR[3] || this.aWR[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == aWT) {
            if (this.aWR[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aWQ = z;
    }

    public void setHint(int i) {
        if (this.aWL != null) {
            this.aWL.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aWL != null) {
            this.aWL.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aWL;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aWM;
    }

    public LinearLayout getInputLayout() {
        return this.aWP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aWN) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aWO) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
