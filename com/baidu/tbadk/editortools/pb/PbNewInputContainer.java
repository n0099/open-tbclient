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
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.am;
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
    private EditorTools CJ;
    private int CK;
    private TextView asQ;
    private boolean cFN;
    private boolean cFO;
    private boolean cFP;
    private int cFQ;
    private boolean[] cGA;
    private int[] cGB;
    private EditText cGr;
    private PbNewLocationInfoView cGs;
    private LinearLayout cGt;
    private ImageView cGu;
    private LinearLayout cGv;
    private i cGw;
    private SpannableStringBuilder cGx;
    private String cGy;
    private boolean cGz;
    private int csg;
    private View mBottomLine;
    private int mType;
    public static int cGC = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFN = false;
        this.cFO = true;
        this.cFP = true;
        this.cFQ = -1;
        this.cGz = true;
        this.cGA = new boolean[]{false, false, false, false, false};
        this.cGB = new int[]{0, 0};
        this.csg = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cy(context);
        this.cGv = new LinearLayout(getContext());
        this.cGv.setOrientation(0);
        this.cGv.setMinimumHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds120));
        addView(this.cGv, new LinearLayout.LayoutParams(-1, -2));
        cA(context);
        cz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cy(Context context) {
        this.cGt = new LinearLayout(getContext());
        this.cGt.setGravity(16);
        this.cGt.setOrientation(0);
        this.cGt.setPadding(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds34), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds30), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds34), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds12));
        this.cGt.setLayoutParams(layoutParams);
        this.cGt.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cGs = new PbNewLocationInfoView(context);
        this.cGt.addView(this.cGs, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.cGu = new ImageView(context);
        this.cGu.setPadding(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.cGt.addView(this.cGu, layoutParams3);
        addView(this.cGt);
        this.cGt.setVisibility(8);
        this.cGu.setOnClickListener(this);
    }

    private void cz(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.asQ = new TextView(context);
        this.asQ.setGravity(17);
        this.asQ.setIncludeFontPadding(false);
        this.asQ.setEnabled(false);
        this.asQ.setAlpha(0.5f);
        this.asQ.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbfontsize42));
        this.asQ.setText(R.string.pb_send_post);
        this.asQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds136), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.asQ, layoutParams2);
        this.cGv.addView(linearLayout, layoutParams);
    }

    private void cA(Context context) {
        this.cGr = new EditText(context);
        this.cGr.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cGr.setMaxLines(4);
        this.cGr.setGravity(16);
        this.cGr.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cGr.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.cGr.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.cGr.setBackgroundResource(R.color.common_color_10022);
        e(this.cGr, R.drawable.edittext_cursor);
        this.cGr.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds54), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24));
        this.cGr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cGr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.cFP) {
                    PbNewInputContainer.this.cFP = true;
                    if (PbNewInputContainer.this.cFQ != -1) {
                        PbNewInputContainer.this.cGr.setSelection(PbNewInputContainer.this.cFQ);
                        PbNewInputContainer.this.cFQ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.cGx)) {
                        if (PbNewInputContainer.this.cGw == null) {
                            PbNewInputContainer.this.cGw = new i();
                        }
                        PbNewInputContainer.this.cGw.cGX = PbNewInputContainer.this.cGx.toString();
                        PbNewInputContainer.this.cGw.mContent = PbNewInputContainer.this.cGr.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cGw));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cGr.getText().toString()));
                }
            }
        });
        this.cGr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.cGr.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.cGv.addView(this.cGr, layoutParams);
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

    private void A(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(HanziToPinyin.Token.SEPARATOR);
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.cGr.getText().insert(this.cGr.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void pF(String str) {
        if (!StringUtils.isNull(str)) {
            this.cGr.getText().insert(this.cGr.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).apk() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).apk() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.apk() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cGr.getText().toString();
            if (this.cFO && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cGr);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cFN || pVar.apk() == EmotionGroupType.LOCAL) {
            String obj = this.cGr.getText().toString();
            if (this.cFO && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cGr);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cFN = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.cGr != null && this.cGv.getVisibility() == 0) {
            this.cGr.setFocusable(true);
            this.cGr.setFocusableInTouchMode(true);
            this.cGr.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), this.cGr);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.cGr, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.e(this.cGt, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.cGu, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.cGr, R.drawable.edittext_cursor);
            this.cGr.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.cGr, R.drawable.edittext_cursor_1);
            this.cGr.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.asQ, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.asQ, R.drawable.bg_comment_send);
        this.cGs.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cGr.getSelectionStart() > 0) {
                        String substring = this.cGr.getText().toString().substring(0, this.cGr.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fgF.matcher(substring);
                        if (matcher.find()) {
                            this.cGr.getText().delete(this.cGr.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cGr.getSelectionStart());
                            break;
                        } else {
                            this.cGr.getText().delete(this.cGr.getSelectionStart() - 1, this.cGr.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cGr.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cGr.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.cGr.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.cGr.setSelection(PbNewInputContainer.this.cGr.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.cGx = null;
                        if (this.cGy != null) {
                            this.cGr.setHint(this.cGy);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cGX) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.cGr.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cGX)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cGX, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.cGx = spannableStringBuilder;
                                        PbNewInputContainer.this.cGr.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.cGr.setText("");
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
                                        PbNewInputContainer.this.cGr.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.cGr.setSelection(PbNewInputContainer.this.cGr.getText().length());
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
                        this.cGA[0] = false;
                        break;
                    } else {
                        this.cGA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cGw = null;
                        this.cGx = null;
                        this.cGr.setText((CharSequence) null);
                    }
                    this.cGA[0] = false;
                    this.cGA[1] = false;
                    this.cGA[2] = false;
                    this.cGA[3] = false;
                    this.cGA[4] = false;
                    this.cGB[0] = 0;
                    this.cGB[1] = 0;
                    break;
                case 10:
                    this.cGA[2] = true;
                    break;
                case 11:
                    this.cGA[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cFo != null) {
                            if (aVar2.cFo.getChosedFiles() != null) {
                                this.cGB[0] = aVar2.cFo.getChosedFiles().size();
                            } else {
                                this.cGB[0] = 0;
                            }
                        }
                        if (this.cGB[0] > 0) {
                            this.cGA[1] = true;
                            break;
                        } else {
                            this.cGA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cGB;
                    iArr[0] = iArr[0] - 1;
                    if (this.cGB[0] > 0) {
                        this.cGA[1] = true;
                        break;
                    } else {
                        this.cGA[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        A((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.cGt.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.cFS) {
                            this.cGt.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.cGs.setState(aVar3.state, null);
                                break;
                            } else {
                                this.cGs.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.cGt.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.cGt.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.cGA[3] = true;
                    break;
                case 29:
                    this.cGA[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            pF((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            pF(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            jS(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jS(int i) {
        if (i == ALL) {
            if (this.cGA[0] || this.cGA[1] || this.cGA[2] || this.cGA[3] || this.cGA[4]) {
                this.asQ.setEnabled(true);
                this.asQ.setAlpha(1.0f);
                return;
            }
            this.asQ.setEnabled(false);
            this.asQ.setAlpha(0.5f);
        } else if (i == cGC) {
            if (this.cGA[1]) {
                this.asQ.setEnabled(true);
                this.asQ.setAlpha(1.0f);
                return;
            }
            this.asQ.setEnabled(false);
            this.asQ.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.cGz = z;
    }

    public void setHint(int i) {
        if (this.cGr != null) {
            this.cGr.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cGr != null) {
            this.cGr.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.cGy = str;
    }

    public EditText getInputView() {
        return this.cGr;
    }

    public TextView getSendView() {
        return this.asQ;
    }

    public TextView getLocationInfoView() {
        return this.cGs;
    }

    public LinearLayout getInputLayout() {
        return this.cGv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cGt) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.cGu) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
