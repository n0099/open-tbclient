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
    private EditorTools TU;
    private int TV;
    private int cdL;
    private EditText ctU;
    private PbNewLocationInfoView ctV;
    private LinearLayout ctW;
    private ImageView ctX;
    private LinearLayout ctY;
    private i ctZ;
    private boolean cts;
    private boolean ctt;
    private boolean ctu;
    private int ctv;
    private SpannableStringBuilder cua;
    private String cub;
    private boolean cuc;
    private boolean[] cud;
    private int[] cue;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int cuf = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cts = false;
        this.ctt = true;
        this.ctu = true;
        this.ctv = -1;
        this.cuc = true;
        this.cud = new boolean[]{false, false, false, false, false};
        this.cue = new int[]{0, 0};
        this.cdL = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cM(context);
        this.ctY = new LinearLayout(getContext());
        this.ctY.setOrientation(0);
        this.ctY.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds120));
        addView(this.ctY, new LinearLayout.LayoutParams(-1, -2));
        cO(context);
        cN(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cM(Context context) {
        this.ctW = new LinearLayout(getContext());
        this.ctW.setGravity(16);
        this.ctW.setOrientation(0);
        this.ctW.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.g(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds30), com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds12));
        this.ctW.setLayoutParams(layoutParams);
        this.ctW.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.ctV = new PbNewLocationInfoView(context);
        this.ctW.addView(this.ctV, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.ctX = new ImageView(context);
        this.ctX.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.ctW.addView(this.ctX, layoutParams3);
        addView(this.ctW);
        this.ctW.setVisibility(8);
        this.ctX.setOnClickListener(this);
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
        this.ctY.addView(linearLayout, layoutParams);
    }

    private void cO(Context context) {
        this.ctU = new EditText(context);
        this.ctU.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ctU.setMaxLines(4);
        this.ctU.setGravity(16);
        this.ctU.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ctU.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.ctU.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.ctU.setBackgroundResource(R.color.common_color_10022);
        e(this.ctU, R.drawable.edittext_cursor);
        this.ctU.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.ctU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ctU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.ctu) {
                    PbNewInputContainer.this.ctu = true;
                    if (PbNewInputContainer.this.ctv != -1) {
                        PbNewInputContainer.this.ctU.setSelection(PbNewInputContainer.this.ctv);
                        PbNewInputContainer.this.ctv = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.cua)) {
                        if (PbNewInputContainer.this.ctZ == null) {
                            PbNewInputContainer.this.ctZ = new i();
                        }
                        PbNewInputContainer.this.ctZ.cuB = PbNewInputContainer.this.cua.toString();
                        PbNewInputContainer.this.ctZ.mContent = PbNewInputContainer.this.ctU.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ctZ));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.ctU.getText().toString()));
                }
            }
        });
        this.ctU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.ctU.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), 0, 0, 0);
        this.ctY.addView(this.ctU, layoutParams);
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
                    this.ctU.getText().insert(this.ctU.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void ql(String str) {
        if (!StringUtils.isNull(str)) {
            this.ctU.getText().insert(this.ctU.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).amu() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).amu() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.amu() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.ctU.getText().toString();
            if (this.ctt && com.baidu.tieba.face.a.wb(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ahW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ctU);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cts || pVar.amu() == EmotionGroupType.LOCAL) {
            String obj = this.ctU.getText().toString();
            if (this.ctt && com.baidu.tieba.face.a.wb(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ahW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ctU);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cts = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        if (this.ctU != null && this.ctY.getVisibility() == 0) {
            this.ctU.setFocusable(true);
            this.ctU.setFocusableInTouchMode(true);
            this.ctU.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ctU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.d(this.ctU, R.color.cp_cont_b, 2, i);
        am.l(this.mBottomLine, R.color.cp_bg_line_c);
        am.l(this, R.color.cp_bg_line_d);
        am.k(this.ctW, R.drawable.pb_new_locatin_view_selector);
        am.c(this.ctX, (int) R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.ctU, R.drawable.edittext_cursor);
            this.ctU.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.ctU, R.drawable.edittext_cursor_1);
            this.ctU.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.f(this.mSendView, R.color.cp_btn_a, 1);
        am.k(this.mSendView, R.drawable.bg_comment_send);
        this.ctV.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ctU.getSelectionStart() > 0) {
                        String substring = this.ctU.getText().toString().substring(0, this.ctU.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fcz.matcher(substring);
                        if (matcher.find()) {
                            this.ctU.getText().delete(this.ctU.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ctU.getSelectionStart());
                            break;
                        } else {
                            this.ctU.getText().delete(this.ctU.getSelectionStart() - 1, this.ctU.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ctU.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ctU.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.ctU.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.ctU.setSelection(PbNewInputContainer.this.ctU.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.cua = null;
                        if (this.cub != null) {
                            this.ctU.setHint(this.cub);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cuB) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.ctU.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cuB)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cuB, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.cua = spannableStringBuilder;
                                        PbNewInputContainer.this.ctU.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.ctU.setText("");
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
                                        PbNewInputContainer.this.ctU.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.ctU.setSelection(PbNewInputContainer.this.ctU.getText().length());
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
                        this.cud[0] = false;
                        break;
                    } else {
                        this.cud[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ctZ = null;
                        this.cua = null;
                        this.ctU.setText((CharSequence) null);
                    }
                    this.cud[0] = false;
                    this.cud[1] = false;
                    this.cud[2] = false;
                    this.cud[3] = false;
                    this.cud[4] = false;
                    this.cue[0] = 0;
                    this.cue[1] = 0;
                    break;
                case 10:
                    this.cud[2] = true;
                    break;
                case 11:
                    this.cud[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.csT != null) {
                            if (aVar2.csT.getChosedFiles() != null) {
                                this.cue[0] = aVar2.csT.getChosedFiles().size();
                            } else {
                                this.cue[0] = 0;
                            }
                        }
                        if (this.cue[0] > 0) {
                            this.cud[1] = true;
                            break;
                        } else {
                            this.cud[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cue;
                    iArr[0] = iArr[0] - 1;
                    if (this.cue[0] > 0) {
                        this.cud[1] = true;
                        break;
                    } else {
                        this.cud[1] = false;
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
                        this.ctW.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.ctW.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.ctV.setState(aVar3.state, null);
                                break;
                            } else {
                                this.ctV.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.ctW.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.ctW.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.cud[3] = true;
                    break;
                case 29:
                    this.cud[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            ql((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof i) && ((i) aVar.data).mContent != null) {
                            ql(((i) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            kx(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kx(int i) {
        if (i == ALL) {
            if (this.cud[0] || this.cud[1] || this.cud[2] || this.cud[3] || this.cud[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == cuf) {
            if (this.cud[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.cuc = z;
    }

    public void setHint(int i) {
        if (this.ctU != null) {
            this.ctU.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ctU != null) {
            this.ctU.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.cub = str;
    }

    public EditText getInputView() {
        return this.ctU;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.ctV;
    }

    public LinearLayout getInputLayout() {
        return this.ctY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ctW) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.ctX) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
