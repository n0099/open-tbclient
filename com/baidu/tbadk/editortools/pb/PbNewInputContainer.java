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
    private EditText dyQ;
    private PbNewLocationInfoView dyR;
    private LinearLayout dyS;
    private ImageView dyT;
    private LinearLayout dyU;
    private j dyV;
    private SpannableStringBuilder dyW;
    private String dyX;
    private boolean dyY;
    private int[] dyZ;
    private boolean dym;
    private boolean dyn;
    private boolean dyo;
    private int dyp;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int dza = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dym = false;
        this.dyn = true;
        this.dyo = true;
        this.dyp = -1;
        this.dyY = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dyZ = new int[]{0, 0};
        this.Ni = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dX(context);
        this.dyU = new LinearLayout(getContext());
        this.dyU.setOrientation(0);
        this.dyU.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.dyU, new LinearLayout.LayoutParams(-1, -2));
        dZ(context);
        dY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dX(Context context) {
        this.dyS = new LinearLayout(getContext());
        this.dyS.setGravity(16);
        this.dyS.setOrientation(0);
        this.dyS.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.dyS.setLayoutParams(layoutParams);
        this.dyS.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dyR = new PbNewLocationInfoView(context);
        this.dyS.addView(this.dyR, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.dyT = new ImageView(context);
        this.dyT.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.dyS.addView(this.dyT, layoutParams3);
        addView(this.dyS);
        this.dyS.setVisibility(8);
        this.dyT.setOnClickListener(this);
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
        this.dyU.addView(linearLayout, layoutParams);
    }

    private void dZ(Context context) {
        this.dyQ = new EditText(context);
        this.dyQ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyQ.setMaxLines(4);
        this.dyQ.setGravity(16);
        this.dyQ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyQ.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dyQ.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dyQ.setBackgroundResource(R.color.common_color_10022);
        e(this.dyQ, R.drawable.edittext_cursor);
        this.dyQ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dyo) {
                    PbNewInputContainer.this.dyo = true;
                    if (PbNewInputContainer.this.dyp != -1) {
                        PbNewInputContainer.this.dyQ.setSelection(PbNewInputContainer.this.dyp);
                        PbNewInputContainer.this.dyp = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.dyW)) {
                        if (PbNewInputContainer.this.dyV == null) {
                            PbNewInputContainer.this.dyV = new j();
                        }
                        PbNewInputContainer.this.dyV.dzt = PbNewInputContainer.this.dyW.toString();
                        PbNewInputContainer.this.dyV.mContent = PbNewInputContainer.this.dyQ.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dyV));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dyQ.getText().toString()));
                }
            }
        });
        this.dyQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.dyQ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.dyU.addView(this.dyQ, layoutParams);
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
                    this.dyQ.getText().insert(this.dyQ.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void vi(String str) {
        if (!StringUtils.isNull(str)) {
            this.dyQ.getText().insert(this.dyQ.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).aJx() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).aJx() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.aJx() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyQ.getText().toString();
            if (this.dyn && com.baidu.tieba.face.a.As(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyQ);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dym || qVar.aJx() == EmotionGroupType.LOCAL) {
            String obj = this.dyQ.getText().toString();
            if (this.dyn && com.baidu.tieba.face.a.As(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyQ);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dym = z;
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
        if (this.dyQ != null && this.dyU.getVisibility() == 0) {
            this.dyQ.setFocusable(true);
            this.dyQ.setFocusableInTouchMode(true);
            this.dyQ.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyQ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dyQ, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.dyS, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.dyT, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.dyQ, R.drawable.edittext_cursor);
            this.dyQ.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dyQ, R.drawable.edittext_cursor_1);
            this.dyQ.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.mSendView, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.mSendView, R.drawable.bg_comment_send);
        this.dyR.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dyQ.getSelectionStart() > 0) {
                        String substring = this.dyQ.getText().toString().substring(0, this.dyQ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gaH.matcher(substring);
                        if (matcher.find()) {
                            this.dyQ.getText().delete(this.dyQ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyQ.getSelectionStart());
                            break;
                        } else {
                            this.dyQ.getText().delete(this.dyQ.getSelectionStart() - 1, this.dyQ.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dyQ.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyQ.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.dyQ.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.dyQ.setSelection(PbNewInputContainer.this.dyQ.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.dyW = null;
                        if (this.dyX != null) {
                            this.dyQ.setHint(this.dyX);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).dzt) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.dyQ.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.dzt)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.dzt, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dyW = spannableStringBuilder;
                                        PbNewInputContainer.this.dyQ.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.dyQ.setText("");
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
                                        PbNewInputContainer.this.dyQ.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.dyQ.setSelection(PbNewInputContainer.this.dyQ.getText().length());
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
                        this.dyV = null;
                        this.dyW = null;
                        this.dyQ.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dyZ[0] = 0;
                    this.dyZ[1] = 0;
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
                        if (aVar2.dxN != null) {
                            if (aVar2.dxN.getChosedFiles() != null) {
                                this.dyZ[0] = aVar2.dxN.getChosedFiles().size();
                            } else {
                                this.dyZ[0] = 0;
                            }
                        }
                        if (this.dyZ[0] > 0) {
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
                    int[] iArr = this.dyZ;
                    iArr[0] = iArr[0] - 1;
                    if (this.dyZ[0] > 0) {
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
                        this.dyS.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.dyS.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dyR.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dyR.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.dyS.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.dyS.setVisibility(8);
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
                            vi((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            vi(((j) aVar.data).mContent);
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
        } else if (i == dza) {
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
        this.dyY = z;
    }

    public void setHint(int i) {
        if (this.dyQ != null) {
            this.dyQ.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dyQ != null) {
            this.dyQ.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.dyX = str;
    }

    public EditText getInputView() {
        return this.dyQ;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.dyR;
    }

    public LinearLayout getInputLayout() {
        return this.dyU;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyS) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.dyT) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
