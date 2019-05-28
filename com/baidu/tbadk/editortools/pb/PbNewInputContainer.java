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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools TB;
    private int TC;
    private int ccI;
    private EditText csG;
    private PbNewLocationInfoView csH;
    private LinearLayout csI;
    private ImageView csJ;
    private LinearLayout csK;
    private i csL;
    private SpannableStringBuilder csM;
    private String csN;
    private boolean csO;
    private boolean[] csP;
    private int[] csQ;
    private boolean cse;
    private boolean csf;
    private boolean csg;
    private int csh;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int csR = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cse = false;
        this.csf = true;
        this.csg = true;
        this.csh = -1;
        this.csO = true;
        this.csP = new boolean[]{false, false, false, false, false};
        this.csQ = new int[]{0, 0};
        this.ccI = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cL(context);
        this.csK = new LinearLayout(getContext());
        this.csK.setOrientation(0);
        this.csK.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds120));
        addView(this.csK, new LinearLayout.LayoutParams(-1, -2));
        cN(context);
        cM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cL(Context context) {
        this.csI = new LinearLayout(getContext());
        this.csI.setGravity(16);
        this.csI.setOrientation(0);
        this.csI.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.g(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds30), com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds12));
        this.csI.setLayoutParams(layoutParams);
        this.csI.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.csH = new PbNewLocationInfoView(context);
        this.csI.addView(this.csH, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.csJ = new ImageView(context);
        this.csJ.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.csI.addView(this.csJ, layoutParams3);
        addView(this.csI);
        this.csI.setVisibility(8);
        this.csJ.setOnClickListener(this);
    }

    private void cM(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setAlpha(0.5f);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.mSendView.setText(R.string.pb_send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds136), com.baidu.adp.lib.util.l.g(context, R.dimen.tbds78));
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.g(context, R.dimen.tbds21);
        linearLayout.addView(this.mSendView, layoutParams2);
        this.csK.addView(linearLayout, layoutParams);
    }

    private void cN(Context context) {
        this.csG = new EditText(context);
        this.csG.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csG.setMaxLines(4);
        this.csG.setGravity(16);
        this.csG.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csG.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.csG.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.csG.setBackgroundResource(R.color.common_color_10022);
        e(this.csG, R.drawable.edittext_cursor);
        this.csG.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.csG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.csG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.csg) {
                    PbNewInputContainer.this.csg = true;
                    if (PbNewInputContainer.this.csh != -1) {
                        PbNewInputContainer.this.csG.setSelection(PbNewInputContainer.this.csh);
                        PbNewInputContainer.this.csh = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.csM)) {
                        if (PbNewInputContainer.this.csL == null) {
                            PbNewInputContainer.this.csL = new i();
                        }
                        PbNewInputContainer.this.csL.ctm = PbNewInputContainer.this.csM.toString();
                        PbNewInputContainer.this.csL.mContent = PbNewInputContainer.this.csG.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.csL));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.csG.getText().toString()));
                }
            }
        });
        this.csG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.csG.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), 0, 0, 0);
        this.csK.addView(this.csG, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void y(ArrayList<String> arrayList) {
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
                    this.csG.getText().insert(this.csG.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void pV(String str) {
        if (!StringUtils.isNull(str)) {
            this.csG.getText().insert(this.csG.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).alp() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).alp() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.alp() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.csG.getText().toString();
            if (this.csf && com.baidu.tieba.face.a.vx(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.csG);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cse || pVar.alp() == EmotionGroupType.LOCAL) {
            String obj = this.csG.getText().toString();
            if (this.csf && com.baidu.tieba.face.a.vx(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.csG);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cse = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.csG != null && this.csK.getVisibility() == 0) {
            this.csG.setFocusable(true);
            this.csG.setFocusableInTouchMode(true);
            this.csG.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.csG);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.csG, R.color.cp_cont_b, 2, i);
        al.l(this.mBottomLine, R.color.cp_bg_line_c);
        al.l(this, R.color.cp_bg_line_d);
        al.k(this.csI, R.drawable.pb_new_locatin_view_selector);
        al.c(this.csJ, (int) R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.csG, R.drawable.edittext_cursor);
            this.csG.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.csG, R.drawable.edittext_cursor_1);
            this.csG.setHintTextColor(al.getColor(i, R.color.cp_cont_e));
        }
        al.f(this.mSendView, R.color.cp_btn_a, 1);
        al.k(this.mSendView, R.drawable.bg_comment_send);
        this.csH.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.csG.getSelectionStart() > 0) {
                        String substring = this.csG.getText().toString().substring(0, this.csG.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eXy.matcher(substring);
                        if (matcher.find()) {
                            this.csG.getText().delete(this.csG.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.csG.getSelectionStart());
                            break;
                        } else {
                            this.csG.getText().delete(this.csG.getSelectionStart() - 1, this.csG.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.csG.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.csG.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.csG.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.csG.setSelection(PbNewInputContainer.this.csG.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.csM = null;
                        if (this.csN != null) {
                            this.csG.setHint(this.csN);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).ctm) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.csG.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.ctm)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.ctm, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.csM = spannableStringBuilder;
                                        PbNewInputContainer.this.csG.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.csG.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(iVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.csG.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.csG.setSelection(PbNewInputContainer.this.csG.getText().length());
                                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                        PbNewInputContainer.this.requestFocus();
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 4:
                    if (aVar.data == null || (((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data)) || ((aVar.data instanceof i) && TextUtils.isEmpty(((i) aVar.data).mContent)))) {
                        this.csP[0] = false;
                        break;
                    } else {
                        this.csP[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.csL = null;
                        this.csM = null;
                        this.csG.setText((CharSequence) null);
                    }
                    this.csP[0] = false;
                    this.csP[1] = false;
                    this.csP[2] = false;
                    this.csP[3] = false;
                    this.csP[4] = false;
                    this.csQ[0] = 0;
                    this.csQ[1] = 0;
                    break;
                case 10:
                    this.csP[2] = true;
                    break;
                case 11:
                    this.csP[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.crF != null) {
                            if (aVar2.crF.getChosedFiles() != null) {
                                this.csQ[0] = aVar2.crF.getChosedFiles().size();
                            } else {
                                this.csQ[0] = 0;
                            }
                        }
                        if (this.csQ[0] > 0) {
                            this.csP[1] = true;
                            break;
                        } else {
                            this.csP[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.csQ;
                    iArr[0] = iArr[0] - 1;
                    if (this.csQ[0] > 0) {
                        this.csP[1] = true;
                        break;
                    } else {
                        this.csP[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        y((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.csI.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.csI.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.csH.setState(aVar3.state, null);
                                break;
                            } else {
                                this.csH.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.csI.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.csI.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.csP[3] = true;
                    break;
                case 29:
                    this.csP[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            pV((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            pV(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            kr(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kr(int i) {
        if (i == ALL) {
            if (this.csP[0] || this.csP[1] || this.csP[2] || this.csP[3] || this.csP[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == csR) {
            if (this.csP[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.csO = z;
    }

    public void setHint(int i) {
        if (this.csG != null) {
            this.csG.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.csG != null) {
            this.csG.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.csN = str;
    }

    public EditText getInputView() {
        return this.csG;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.csH;
    }

    public LinearLayout getInputLayout() {
        return this.csK;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csI) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.csJ) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
