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
    private EditorTools TA;
    private int TB;
    private int ccJ;
    private EditText csH;
    private PbNewLocationInfoView csI;
    private LinearLayout csJ;
    private ImageView csK;
    private LinearLayout csL;
    private i csM;
    private SpannableStringBuilder csN;
    private String csO;
    private boolean csP;
    private boolean[] csQ;
    private int[] csR;
    private boolean csf;
    private boolean csg;
    private boolean csh;
    private int csi;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int csS = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csf = false;
        this.csg = true;
        this.csh = true;
        this.csi = -1;
        this.csP = true;
        this.csQ = new boolean[]{false, false, false, false, false};
        this.csR = new int[]{0, 0};
        this.ccJ = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cL(context);
        this.csL = new LinearLayout(getContext());
        this.csL.setOrientation(0);
        this.csL.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds120));
        addView(this.csL, new LinearLayout.LayoutParams(-1, -2));
        cN(context);
        cM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cL(Context context) {
        this.csJ = new LinearLayout(getContext());
        this.csJ.setGravity(16);
        this.csJ.setOrientation(0);
        this.csJ.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.g(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds30), com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds12));
        this.csJ.setLayoutParams(layoutParams);
        this.csJ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.csI = new PbNewLocationInfoView(context);
        this.csJ.addView(this.csI, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.csK = new ImageView(context);
        this.csK.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.csJ.addView(this.csK, layoutParams3);
        addView(this.csJ);
        this.csJ.setVisibility(8);
        this.csK.setOnClickListener(this);
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
        this.csL.addView(linearLayout, layoutParams);
    }

    private void cN(Context context) {
        this.csH = new EditText(context);
        this.csH.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csH.setMaxLines(4);
        this.csH.setGravity(16);
        this.csH.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csH.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.csH.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.csH.setBackgroundResource(R.color.common_color_10022);
        e(this.csH, R.drawable.edittext_cursor);
        this.csH.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.csH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.csH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.csh) {
                    PbNewInputContainer.this.csh = true;
                    if (PbNewInputContainer.this.csi != -1) {
                        PbNewInputContainer.this.csH.setSelection(PbNewInputContainer.this.csi);
                        PbNewInputContainer.this.csi = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.csN)) {
                        if (PbNewInputContainer.this.csM == null) {
                            PbNewInputContainer.this.csM = new i();
                        }
                        PbNewInputContainer.this.csM.ctn = PbNewInputContainer.this.csN.toString();
                        PbNewInputContainer.this.csM.mContent = PbNewInputContainer.this.csH.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.csM));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.csH.getText().toString()));
                }
            }
        });
        this.csH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.csH.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), 0, 0, 0);
        this.csL.addView(this.csH, layoutParams);
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
                    this.csH.getText().insert(this.csH.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void pU(String str) {
        if (!StringUtils.isNull(str)) {
            this.csH.getText().insert(this.csH.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
            String obj = this.csH.getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.csH);
            }
        }
    }

    private void b(p pVar) {
        if (!this.csf || pVar.alp() == EmotionGroupType.LOCAL) {
            String obj = this.csH.getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.csH);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.csf = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.csH != null && this.csL.getVisibility() == 0) {
            this.csH.setFocusable(true);
            this.csH.setFocusableInTouchMode(true);
            this.csH.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.csH);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.csH, R.color.cp_cont_b, 2, i);
        al.l(this.mBottomLine, R.color.cp_bg_line_c);
        al.l(this, R.color.cp_bg_line_d);
        al.k(this.csJ, R.drawable.pb_new_locatin_view_selector);
        al.c(this.csK, (int) R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.csH, R.drawable.edittext_cursor);
            this.csH.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.csH, R.drawable.edittext_cursor_1);
            this.csH.setHintTextColor(al.getColor(i, R.color.cp_cont_e));
        }
        al.f(this.mSendView, R.color.cp_btn_a, 1);
        al.k(this.mSendView, R.drawable.bg_comment_send);
        this.csI.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.csH.getSelectionStart() > 0) {
                        String substring = this.csH.getText().toString().substring(0, this.csH.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eXy.matcher(substring);
                        if (matcher.find()) {
                            this.csH.getText().delete(this.csH.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.csH.getSelectionStart());
                            break;
                        } else {
                            this.csH.getText().delete(this.csH.getSelectionStart() - 1, this.csH.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.csH.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.csH.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.csH.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.csH.setSelection(PbNewInputContainer.this.csH.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.csN = null;
                        if (this.csO != null) {
                            this.csH.setHint(this.csO);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).ctn) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.csH.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.ctn)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.ctn, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.csN = spannableStringBuilder;
                                        PbNewInputContainer.this.csH.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.csH.setText("");
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
                                        PbNewInputContainer.this.csH.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.csH.setSelection(PbNewInputContainer.this.csH.getText().length());
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
                        this.csQ[0] = false;
                        break;
                    } else {
                        this.csQ[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.csM = null;
                        this.csN = null;
                        this.csH.setText((CharSequence) null);
                    }
                    this.csQ[0] = false;
                    this.csQ[1] = false;
                    this.csQ[2] = false;
                    this.csQ[3] = false;
                    this.csQ[4] = false;
                    this.csR[0] = 0;
                    this.csR[1] = 0;
                    break;
                case 10:
                    this.csQ[2] = true;
                    break;
                case 11:
                    this.csQ[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.crG != null) {
                            if (aVar2.crG.getChosedFiles() != null) {
                                this.csR[0] = aVar2.crG.getChosedFiles().size();
                            } else {
                                this.csR[0] = 0;
                            }
                        }
                        if (this.csR[0] > 0) {
                            this.csQ[1] = true;
                            break;
                        } else {
                            this.csQ[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.csR;
                    iArr[0] = iArr[0] - 1;
                    if (this.csR[0] > 0) {
                        this.csQ[1] = true;
                        break;
                    } else {
                        this.csQ[1] = false;
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
                        this.csJ.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.csJ.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.csI.setState(aVar3.state, null);
                                break;
                            } else {
                                this.csI.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.csJ.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.csJ.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.csQ[3] = true;
                    break;
                case 29:
                    this.csQ[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            pU((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            pU(((i) aVar.data).mContent);
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
            if (this.csQ[0] || this.csQ[1] || this.csQ[2] || this.csQ[3] || this.csQ[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == csS) {
            if (this.csQ[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.csP = z;
    }

    public void setHint(int i) {
        if (this.csH != null) {
            this.csH.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.csH != null) {
            this.csH.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.csO = str;
    }

    public EditText getInputView() {
        return this.csH;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.csI;
    }

    public LinearLayout getInputLayout() {
        return this.csL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.csJ) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.csK) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
