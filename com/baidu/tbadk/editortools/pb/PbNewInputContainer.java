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
import com.baidu.adp.lib.util.l;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, m {
    private EditorTools FO;
    private int FP;
    private int Ni;
    private boolean dxY;
    private boolean dxZ;
    private EditText dyC;
    private PbNewLocationInfoView dyD;
    private LinearLayout dyE;
    private ImageView dyF;
    private LinearLayout dyG;
    private j dyH;
    private SpannableStringBuilder dyI;
    private String dyJ;
    private boolean dyK;
    private int[] dyL;
    private boolean dya;
    private int dyb;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int dyM = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxY = false;
        this.dxZ = true;
        this.dya = true;
        this.dyb = -1;
        this.dyK = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dyL = new int[]{0, 0};
        this.Ni = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dX(context);
        this.dyG = new LinearLayout(getContext());
        this.dyG.setOrientation(0);
        this.dyG.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.dyG, new LinearLayout.LayoutParams(-1, -2));
        dZ(context);
        dY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dX(Context context) {
        this.dyE = new LinearLayout(getContext());
        this.dyE.setGravity(16);
        this.dyE.setOrientation(0);
        this.dyE.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.dyE.setLayoutParams(layoutParams);
        this.dyE.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dyD = new PbNewLocationInfoView(context);
        this.dyE.addView(this.dyD, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.dyF = new ImageView(context);
        this.dyF.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.dyE.addView(this.dyF, layoutParams3);
        addView(this.dyE);
        this.dyE.setVisibility(8);
        this.dyF.setOnClickListener(this);
    }

    private void dY(Context context) {
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
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds136), l.getDimens(context, R.dimen.tbds78));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds21);
        linearLayout.addView(this.mSendView, layoutParams2);
        this.dyG.addView(linearLayout, layoutParams);
    }

    private void dZ(Context context) {
        this.dyC = new EditText(context);
        this.dyC.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyC.setMaxLines(4);
        this.dyC.setGravity(16);
        this.dyC.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyC.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dyC.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dyC.setBackgroundResource(R.color.common_color_10022);
        e(this.dyC, R.drawable.edittext_cursor);
        this.dyC.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dya) {
                    PbNewInputContainer.this.dya = true;
                    if (PbNewInputContainer.this.dyb != -1) {
                        PbNewInputContainer.this.dyC.setSelection(PbNewInputContainer.this.dyb);
                        PbNewInputContainer.this.dyb = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.dyI)) {
                        if (PbNewInputContainer.this.dyH == null) {
                            PbNewInputContainer.this.dyH = new j();
                        }
                        PbNewInputContainer.this.dyH.dzf = PbNewInputContainer.this.dyI.toString();
                        PbNewInputContainer.this.dyH.mContent = PbNewInputContainer.this.dyC.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dyH));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dyC.getText().toString()));
                }
            }
        });
        this.dyC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.dyC.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.dyG.addView(this.dyC, layoutParams);
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

    private void F(ArrayList<String> arrayList) {
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
                    this.dyC.getText().insert(this.dyC.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            this.dyC.getText().insert(this.dyC.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).aJu() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).aJu() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.aJu() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyC.getText().toString();
            if (this.dxZ && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFJ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyC);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dxY || qVar.aJu() == EmotionGroupType.LOCAL) {
            String obj = this.dyC.getText().toString();
            if (this.dxZ && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFJ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyC);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dxY = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dyC != null && this.dyG.getVisibility() == 0) {
            this.dyC.setFocusable(true);
            this.dyC.setFocusableInTouchMode(true);
            this.dyC.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyC);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dyC, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.dyE, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.dyF, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.dyC, R.drawable.edittext_cursor);
            this.dyC.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dyC, R.drawable.edittext_cursor_1);
            this.dyC.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.mSendView, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.mSendView, R.drawable.bg_comment_send);
        this.dyD.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dyC.getSelectionStart() > 0) {
                        String substring = this.dyC.getText().toString().substring(0, this.dyC.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gas.matcher(substring);
                        if (matcher.find()) {
                            this.dyC.getText().delete(this.dyC.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyC.getSelectionStart());
                            break;
                        } else {
                            this.dyC.getText().delete(this.dyC.getSelectionStart() - 1, this.dyC.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dyC.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyC.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.dyC.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.dyC.setSelection(PbNewInputContainer.this.dyC.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.dyI = null;
                        if (this.dyJ != null) {
                            this.dyC.setHint(this.dyJ);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).dzf) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.dyC.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.dzf)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.dzf, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dyI = spannableStringBuilder;
                                        PbNewInputContainer.this.dyC.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.dyC.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(jVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dyC.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.dyC.setSelection(PbNewInputContainer.this.dyC.getText().length());
                                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                        PbNewInputContainer.this.requestFocus();
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 4:
                    if (aVar.data == null || (((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data)) || ((aVar.data instanceof j) && TextUtils.isEmpty(((j) aVar.data).mContent)))) {
                        this.flags[0] = false;
                        break;
                    } else {
                        this.flags[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.dyH = null;
                        this.dyI = null;
                        this.dyC.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dyL[0] = 0;
                    this.dyL[1] = 0;
                    break;
                case 10:
                    this.flags[2] = true;
                    break;
                case 11:
                    this.flags[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dxz != null) {
                            if (aVar2.dxz.getChosedFiles() != null) {
                                this.dyL[0] = aVar2.dxz.getChosedFiles().size();
                            } else {
                                this.dyL[0] = 0;
                            }
                        }
                        if (this.dyL[0] > 0) {
                            this.flags[1] = true;
                            break;
                        } else {
                            this.flags[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.dyL;
                    iArr[0] = iArr[0] - 1;
                    if (this.dyL[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        F((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.dyE.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.dyE.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dyD.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dyD.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.dyE.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.dyE.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.flags[3] = true;
                    break;
                case 29:
                    this.flags[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            vh((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            vh(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            mx(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mx(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        } else if (i == dyM) {
            if (this.flags[1]) {
                this.mSendView.setEnabled(true);
                this.mSendView.setAlpha(1.0f);
                return;
            }
            this.mSendView.setEnabled(false);
            this.mSendView.setAlpha(0.5f);
        }
    }

    public void setHasHint(boolean z) {
        this.dyK = z;
    }

    public void setHint(int i) {
        if (this.dyC != null) {
            this.dyC.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dyC != null) {
            this.dyC.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.dyJ = str;
    }

    public EditText getInputView() {
        return this.dyC;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.dyD;
    }

    public LinearLayout getInputLayout() {
        return this.dyG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyE) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.dyF) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
