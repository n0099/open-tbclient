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
    private int cdS;
    private boolean ctA;
    private boolean ctB;
    private int ctC;
    private boolean ctz;
    private EditText cub;
    private PbNewLocationInfoView cuc;
    private LinearLayout cud;
    private ImageView cue;
    private LinearLayout cuf;
    private i cug;
    private SpannableStringBuilder cuh;
    private String cui;
    private boolean cuj;
    private boolean[] cuk;
    private int[] cul;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int cum = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ctz = false;
        this.ctA = true;
        this.ctB = true;
        this.ctC = -1;
        this.cuj = true;
        this.cuk = new boolean[]{false, false, false, false, false};
        this.cul = new int[]{0, 0};
        this.cdS = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        cM(context);
        this.cuf = new LinearLayout(getContext());
        this.cuf.setOrientation(0);
        this.cuf.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.tbds120));
        addView(this.cuf, new LinearLayout.LayoutParams(-1, -2));
        cO(context);
        cN(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cM(Context context) {
        this.cud = new LinearLayout(getContext());
        this.cud.setGravity(16);
        this.cud.setOrientation(0);
        this.cud.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.g(context, R.dimen.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds30), com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), com.baidu.adp.lib.util.l.g(context, R.dimen.ds12));
        this.cud.setLayoutParams(layoutParams);
        this.cud.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.cuc = new PbNewLocationInfoView(context);
        this.cud.addView(this.cuc, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.cue = new ImageView(context);
        this.cue.setPadding(com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), 0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.cud.addView(this.cue, layoutParams3);
        addView(this.cud);
        this.cud.setVisibility(8);
        this.cue.setOnClickListener(this);
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
        this.cuf.addView(linearLayout, layoutParams);
    }

    private void cO(Context context) {
        this.cub = new EditText(context);
        this.cub.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cub.setMaxLines(4);
        this.cub.setGravity(16);
        this.cub.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cub.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.cub.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.cub.setBackgroundResource(R.color.common_color_10022);
        e(this.cub, R.drawable.edittext_cursor);
        this.cub.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.cub.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cub.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.ctB) {
                    PbNewInputContainer.this.ctB = true;
                    if (PbNewInputContainer.this.ctC != -1) {
                        PbNewInputContainer.this.cub.setSelection(PbNewInputContainer.this.ctC);
                        PbNewInputContainer.this.ctC = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.cuh)) {
                        if (PbNewInputContainer.this.cug == null) {
                            PbNewInputContainer.this.cug = new i();
                        }
                        PbNewInputContainer.this.cug.cuI = PbNewInputContainer.this.cuh.toString();
                        PbNewInputContainer.this.cug.mContent = PbNewInputContainer.this.cub.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cug));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.cub.getText().toString()));
                }
            }
        });
        this.cub.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.cub.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds34), 0, 0, 0);
        this.cuf.addView(this.cub, layoutParams);
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
                    this.cub.getText().insert(this.cub.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void ql(String str) {
        if (!StringUtils.isNull(str)) {
            this.cub.getText().insert(this.cub.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p) && ((p) aVar.data).amw() != EmotionGroupType.BIG_EMOTION && ((p) aVar.data).amw() != EmotionGroupType.USER_COLLECT) {
            p pVar = (p) aVar.data;
            if (pVar.amw() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cub.getText().toString();
            if (this.ctA && com.baidu.tieba.face.a.wc(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ahY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cub);
            }
        }
    }

    private void b(p pVar) {
        if (!this.ctz || pVar.amw() == EmotionGroupType.LOCAL) {
            String obj = this.cub.getText().toString();
            if (this.ctA && com.baidu.tieba.face.a.wc(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ahY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cub);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.ctz = z;
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
        if (this.cub != null && this.cuf.getVisibility() == 0) {
            this.cub.setFocusable(true);
            this.cub.setFocusableInTouchMode(true);
            this.cub.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.cub);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.d(this.cub, R.color.cp_cont_b, 2, i);
        am.l(this.mBottomLine, R.color.cp_bg_line_c);
        am.l(this, R.color.cp_bg_line_d);
        am.k(this.cud, R.drawable.pb_new_locatin_view_selector);
        am.c(this.cue, (int) R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.cub, R.drawable.edittext_cursor);
            this.cub.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.cub, R.drawable.edittext_cursor_1);
            this.cub.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.f(this.mSendView, R.color.cp_btn_a, 1);
        am.k(this.mSendView, R.drawable.bg_comment_send);
        this.cuc.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cub.getSelectionStart() > 0) {
                        String substring = this.cub.getText().toString().substring(0, this.cub.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fcZ.matcher(substring);
                        if (matcher.find()) {
                            this.cub.getText().delete(this.cub.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cub.getSelectionStart());
                            break;
                        } else {
                            this.cub.getText().delete(this.cub.getSelectionStart() - 1, this.cub.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cub.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cub.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.cub.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.cub.setSelection(PbNewInputContainer.this.cub.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof i) {
                        this.cuh = null;
                        if (this.cui != null) {
                            this.cub.setHint(this.cui);
                        }
                        final i iVar = (i) aVar.data;
                        if (TextUtils.isEmpty(((i) aVar.data).cuI) && TextUtils.isEmpty(((i) aVar.data).mContent)) {
                            this.cub.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(iVar.cuI)) {
                                com.baidu.tieba.face.b.a(getContext(), iVar.cuI, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.cuh = spannableStringBuilder;
                                        PbNewInputContainer.this.cub.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(iVar.mContent)) {
                                            PbNewInputContainer.this.cub.setText("");
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
                                        PbNewInputContainer.this.cub.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.cub.setSelection(PbNewInputContainer.this.cub.getText().length());
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
                        this.cuk[0] = false;
                        break;
                    } else {
                        this.cuk[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cug = null;
                        this.cuh = null;
                        this.cub.setText((CharSequence) null);
                    }
                    this.cuk[0] = false;
                    this.cuk[1] = false;
                    this.cuk[2] = false;
                    this.cuk[3] = false;
                    this.cuk[4] = false;
                    this.cul[0] = 0;
                    this.cul[1] = 0;
                    break;
                case 10:
                    this.cuk[2] = true;
                    break;
                case 11:
                    this.cuk[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cta != null) {
                            if (aVar2.cta.getChosedFiles() != null) {
                                this.cul[0] = aVar2.cta.getChosedFiles().size();
                            } else {
                                this.cul[0] = 0;
                            }
                        }
                        if (this.cul[0] > 0) {
                            this.cuk[1] = true;
                            break;
                        } else {
                            this.cuk[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cul;
                    iArr[0] = iArr[0] - 1;
                    if (this.cul[0] > 0) {
                        this.cuk[1] = true;
                        break;
                    } else {
                        this.cuk[1] = false;
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
                        this.cud.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.cud.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.cuc.setState(aVar3.state, null);
                                break;
                            } else {
                                this.cuc.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.cud.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.cud.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.cuk[3] = true;
                    break;
                case 29:
                    this.cuk[3] = false;
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
            ky(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void ky(int i) {
        if (i == ALL) {
            if (this.cuk[0] || this.cuk[1] || this.cuk[2] || this.cuk[3] || this.cuk[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == cum) {
            if (this.cuk[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.cuj = z;
    }

    public void setHint(int i) {
        if (this.cub != null) {
            this.cub.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cub != null) {
            this.cub.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.cui = str;
    }

    public EditText getInputView() {
        return this.cub;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.cuc;
    }

    public LinearLayout getInputLayout() {
        return this.cuf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.cud) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.cue) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
