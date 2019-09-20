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
    private EditorTools TT;
    private int TU;
    private int ceL;
    private EditText cuY;
    private PbNewLocationInfoView cuZ;
    private boolean cuw;
    private boolean cux;
    private boolean cuy;
    private int cuz;
    private LinearLayout cva;
    private ImageView cvb;
    private LinearLayout cvc;
    private i cvd;
    private SpannableStringBuilder cve;
    private String cvf;
    private boolean cvg;
    private boolean[] cvh;
    private int[] cvi;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int cvj = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cuw = false;
        this.cux = true;
        this.cuy = true;
        this.cuz = -1;
        this.cvg = true;
        this.cvh = new boolean[]{false, false, false, false, false};
        this.cvi = new int[]{0, 0};
        this.ceL = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cM(context);
        this.cvc = new LinearLayout(getContext());
        this.cvc.setOrientation(0);
        this.cvc.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds120));
        addView(this.cvc, new LinearLayout.LayoutParams(-1, -2));
        cO(context);
        cN(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cM(Context context) {
        this.cva = new LinearLayout(getContext());
        this.cva.setGravity(16);
        this.cva.setOrientation(0);
        this.cva.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.g(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds30), com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds12));
        this.cva.setLayoutParams(layoutParams);
        this.cva.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cuZ = new PbNewLocationInfoView(context);
        this.cva.addView(this.cuZ, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.cvb = new ImageView(context);
        this.cvb.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.cva.addView(this.cvb, layoutParams3);
        addView(this.cva);
        this.cva.setVisibility(8);
        this.cvb.setOnClickListener(this);
    }

    private void cN(Context context) {
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
        this.cvc.addView(linearLayout, layoutParams);
    }

    private void cO(Context context) {
        this.cuY = new EditText(context);
        this.cuY.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cuY.setMaxLines(4);
        this.cuY.setGravity(16);
        this.cuY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cuY.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.cuY.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.cuY.setBackgroundResource(R.color.common_color_10022);
        e(this.cuY, R.drawable.edittext_cursor);
        this.cuY.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.cuY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cuY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.cuy) {
                    PbNewInputContainer.this.cuy = true;
                    if (PbNewInputContainer.this.cuz != -1) {
                        PbNewInputContainer.this.cuY.setSelection(PbNewInputContainer.this.cuz);
                        PbNewInputContainer.this.cuz = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.cve)) {
                        if (PbNewInputContainer.this.cvd == null) {
                            PbNewInputContainer.this.cvd = new i();
                        }
                        PbNewInputContainer.this.cvd.cvE = PbNewInputContainer.this.cve.toString();
                        PbNewInputContainer.this.cvd.mContent = PbNewInputContainer.this.cuY.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cvd));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cuY.getText().toString()));
                }
            }
        });
        this.cuY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.cuY.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), 0, 0, 0);
        this.cvc.addView(this.cuY, layoutParams);
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
                    this.cuY.getText().insert(this.cuY.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void qw(String str) {
        if (!StringUtils.isNull(str)) {
            this.cuY.getText().insert(this.cuY.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).amI() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).amI() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.amI() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cuY.getText().toString();
            if (this.cux && com.baidu.tieba.face.a.wB(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aic().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cuY);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cuw || pVar.amI() == EmotionGroupType.LOCAL) {
            String obj = this.cuY.getText().toString();
            if (this.cux && com.baidu.tieba.face.a.wB(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aic().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cuY);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cuw = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        if (this.cuY != null && this.cvc.getVisibility() == 0) {
            this.cuY.setFocusable(true);
            this.cuY.setFocusableInTouchMode(true);
            this.cuY.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.cuY);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.d(this.cuY, R.color.cp_cont_b, 2, i);
        am.l(this.mBottomLine, R.color.cp_bg_line_h);
        am.l(this, R.color.cp_bg_line_h);
        am.g(this.cva, com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.c(this.cvb, (int) R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.cuY, R.drawable.edittext_cursor);
            this.cuY.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.cuY, R.drawable.edittext_cursor_1);
            this.cuY.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.f(this.mSendView, R.color.cp_cont_a, 1);
        am.k(this.mSendView, R.drawable.bg_comment_send);
        this.cuZ.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cuY.getSelectionStart() > 0) {
                        String substring = this.cuY.getText().toString().substring(0, this.cuY.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.feM.matcher(substring);
                        if (matcher.find()) {
                            this.cuY.getText().delete(this.cuY.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cuY.getSelectionStart());
                            break;
                        } else {
                            this.cuY.getText().delete(this.cuY.getSelectionStart() - 1, this.cuY.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cuY.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cuY.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.cuY.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.cuY.setSelection(PbNewInputContainer.this.cuY.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.cve = null;
                        if (this.cvf != null) {
                            this.cuY.setHint(this.cvf);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cvE) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.cuY.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cvE)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cvE, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.cve = spannableStringBuilder;
                                        PbNewInputContainer.this.cuY.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.cuY.setText("");
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
                                        PbNewInputContainer.this.cuY.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.cuY.setSelection(PbNewInputContainer.this.cuY.getText().length());
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
                        this.cvh[0] = false;
                        break;
                    } else {
                        this.cvh[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cvd = null;
                        this.cve = null;
                        this.cuY.setText((CharSequence) null);
                    }
                    this.cvh[0] = false;
                    this.cvh[1] = false;
                    this.cvh[2] = false;
                    this.cvh[3] = false;
                    this.cvh[4] = false;
                    this.cvi[0] = 0;
                    this.cvi[1] = 0;
                    break;
                case 10:
                    this.cvh[2] = true;
                    break;
                case 11:
                    this.cvh[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ctW != null) {
                            if (aVar2.ctW.getChosedFiles() != null) {
                                this.cvi[0] = aVar2.ctW.getChosedFiles().size();
                            } else {
                                this.cvi[0] = 0;
                            }
                        }
                        if (this.cvi[0] > 0) {
                            this.cvh[1] = true;
                            break;
                        } else {
                            this.cvh[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cvi;
                    iArr[0] = iArr[0] - 1;
                    if (this.cvi[0] > 0) {
                        this.cvh[1] = true;
                        break;
                    } else {
                        this.cvh[1] = false;
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
                        this.cva.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.cva.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.cuZ.setState(aVar3.state, null);
                                break;
                            } else {
                                this.cuZ.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.cva.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.cva.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.cvh[3] = true;
                    break;
                case 29:
                    this.cvh[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            qw((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            qw(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            kB(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kB(int i) {
        if (i == ALL) {
            if (this.cvh[0] || this.cvh[1] || this.cvh[2] || this.cvh[3] || this.cvh[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == cvj) {
            if (this.cvh[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.cvg = z;
    }

    public void setHint(int i) {
        if (this.cuY != null) {
            this.cuY.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cuY != null) {
            this.cuY.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.cvf = str;
    }

    public EditText getInputView() {
        return this.cuY;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.cuZ;
    }

    public LinearLayout getInputLayout() {
        return this.cvc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cva) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.cvb) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
