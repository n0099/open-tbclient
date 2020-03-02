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
    private boolean dxZ;
    private EditText dyD;
    private PbNewLocationInfoView dyE;
    private LinearLayout dyF;
    private ImageView dyG;
    private LinearLayout dyH;
    private j dyI;
    private SpannableStringBuilder dyJ;
    private String dyK;
    private boolean dyL;
    private int[] dyM;
    private boolean dya;
    private boolean dyb;
    private int dyc;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int dyN = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxZ = false;
        this.dya = true;
        this.dyb = true;
        this.dyc = -1;
        this.dyL = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dyM = new int[]{0, 0};
        this.Ni = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dX(context);
        this.dyH = new LinearLayout(getContext());
        this.dyH.setOrientation(0);
        this.dyH.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.dyH, new LinearLayout.LayoutParams(-1, -2));
        dZ(context);
        dY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dX(Context context) {
        this.dyF = new LinearLayout(getContext());
        this.dyF.setGravity(16);
        this.dyF.setOrientation(0);
        this.dyF.setPadding(l.getDimens(context, R.dimen.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(context, R.dimen.ds48));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.dyF.setLayoutParams(layoutParams);
        this.dyF.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.dyE = new PbNewLocationInfoView(context);
        this.dyF.addView(this.dyE, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ds24);
        this.dyG = new ImageView(context);
        this.dyG.setPadding(l.getDimens(context, R.dimen.ds24), 0, l.getDimens(context, R.dimen.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.dyF.addView(this.dyG, layoutParams3);
        addView(this.dyF);
        this.dyF.setVisibility(8);
        this.dyG.setOnClickListener(this);
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
        this.dyH.addView(linearLayout, layoutParams);
    }

    private void dZ(Context context) {
        this.dyD = new EditText(context);
        this.dyD.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyD.setMaxLines(4);
        this.dyD.setGravity(16);
        this.dyD.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyD.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dyD.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dyD.setBackgroundResource(R.color.common_color_10022);
        e(this.dyD, R.drawable.edittext_cursor);
        this.dyD.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyD.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyD.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.dyb) {
                    PbNewInputContainer.this.dyb = true;
                    if (PbNewInputContainer.this.dyc != -1) {
                        PbNewInputContainer.this.dyD.setSelection(PbNewInputContainer.this.dyc);
                        PbNewInputContainer.this.dyc = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.dyJ)) {
                        if (PbNewInputContainer.this.dyI == null) {
                            PbNewInputContainer.this.dyI = new j();
                        }
                        PbNewInputContainer.this.dyI.dzg = PbNewInputContainer.this.dyJ.toString();
                        PbNewInputContainer.this.dyI.mContent = PbNewInputContainer.this.dyD.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dyI));
                        return;
                    }
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.dyD.getText().toString()));
                }
            }
        });
        this.dyD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.dyD.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.dyH.addView(this.dyD, layoutParams);
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
                    this.dyD.getText().insert(this.dyD.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void vh(String str) {
        if (!StringUtils.isNull(str)) {
            this.dyD.getText().insert(this.dyD.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).aJw() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).aJw() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.aJw() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyD.getText().toString();
            if (this.dya && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyD);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dxZ || qVar.aJw() == EmotionGroupType.LOCAL) {
            String obj = this.dyD.getText().toString();
            if (this.dya && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyD);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dxZ = z;
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
        if (this.dyD != null && this.dyH.getVisibility() == 0) {
            this.dyD.setFocusable(true);
            this.dyD.setFocusableInTouchMode(true);
            this.dyD.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyD);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dyD, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_h);
        am.c(this.dyF, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26), R.color.cp_bg_line_j, R.color.cp_bg_line_j_alpha50);
        am.setImageResource(this.dyG, R.drawable.icon_edit_close_n);
        if (i == 0) {
            e(this.dyD, R.drawable.edittext_cursor);
            this.dyD.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dyD, R.drawable.edittext_cursor_1);
            this.dyD.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setViewTextColor(this.mSendView, R.color.cp_cont_a, 1);
        am.setBackgroundResource(this.mSendView, R.drawable.bg_comment_send);
        this.dyE.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dyD.getSelectionStart() > 0) {
                        String substring = this.dyD.getText().toString().substring(0, this.dyD.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gau.matcher(substring);
                        if (matcher.find()) {
                            this.dyD.getText().delete(this.dyD.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyD.getSelectionStart());
                            break;
                        } else {
                            this.dyD.getText().delete(this.dyD.getSelectionStart() - 1, this.dyD.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dyD.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyD.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.dyD.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.dyD.setSelection(PbNewInputContainer.this.dyD.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.dyJ = null;
                        if (this.dyK != null) {
                            this.dyD.setHint(this.dyK);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).dzg) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.dyD.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.dzg)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.dzg, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.dyJ = spannableStringBuilder;
                                        PbNewInputContainer.this.dyD.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.dyD.setText("");
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
                                        PbNewInputContainer.this.dyD.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.dyD.setSelection(PbNewInputContainer.this.dyD.getText().length());
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
                        this.dyI = null;
                        this.dyJ = null;
                        this.dyD.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dyM[0] = 0;
                    this.dyM[1] = 0;
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
                        if (aVar2.dxA != null) {
                            if (aVar2.dxA.getChosedFiles() != null) {
                                this.dyM[0] = aVar2.dxA.getChosedFiles().size();
                            } else {
                                this.dyM[0] = 0;
                            }
                        }
                        if (this.dyM[0] > 0) {
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
                    int[] iArr = this.dyM;
                    iArr[0] = iArr[0] - 1;
                    if (this.dyM[0] > 0) {
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
                        this.dyF.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.dyF.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.dyE.setState(aVar3.state, null);
                                break;
                            } else {
                                this.dyE.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.dyF.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.dyF.setVisibility(8);
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
        } else if (i == dyN) {
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
        this.dyL = z;
    }

    public void setHint(int i) {
        if (this.dyD != null) {
            this.dyD.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dyD != null) {
            this.dyD.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.dyK = str;
    }

    public EditText getInputView() {
        return this.dyD;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.dyE;
    }

    public LinearLayout getInputLayout() {
        return this.dyH;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dyF) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.dyG) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
