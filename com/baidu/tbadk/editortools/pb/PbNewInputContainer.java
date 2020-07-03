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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
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
    private EditorTools ZX;
    private int ZY;
    private int ahx;
    private SpanGroupEditText evP;
    private TBSpecificationBtn evQ;
    private TBSpecificationBtn evR;
    private LinearLayout evS;
    private j evT;
    private SpannableStringBuilder evU;
    private String evV;
    private boolean evW;
    private int[] evX;
    private Runnable evZ;
    private boolean evk;
    private boolean evl;
    private boolean evm;
    private int evn;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int evY = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evk = false;
        this.evl = true;
        this.evm = true;
        this.evn = -1;
        this.evW = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.evX = new int[]{0, 0};
        this.ahx = 0;
        this.mType = ALL;
        this.evZ = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.evP != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.evP.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        dQ(context);
        this.evS = new LinearLayout(getContext());
        this.evS.setOrientation(0);
        this.evS.setMinimumHeight(l.getDimens(context, R.dimen.tbds120));
        addView(this.evS, new LinearLayout.LayoutParams(-1, -2));
        dS(context);
        dR(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dQ(Context context) {
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mE(R.color.cp_cont_b);
        cVar.k(R.drawable.ic_icon_pure_post_location16_svg, 0, true);
        cVar.mz(R.color.cp_cont_e);
        cVar.aR(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds30), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.evR = new TBSpecificationBtn(getContext());
        this.evR.setLayoutParams(layoutParams);
        this.evR.setOnClickListener(this);
        this.evR.setConfig(cVar);
        this.evR.setTextSize(R.dimen.tbds32);
        this.evR.setOnClickListener(this);
        this.evR.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.evR);
    }

    private void dR(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.evQ = new TBSpecificationBtn(context);
        this.evQ.setConfig(new com.baidu.tbadk.core.view.commonBtn.b());
        this.evQ.setEnabled(false);
        this.evQ.setTextSize(R.dimen.tbds36);
        this.evQ.setText(context.getString(R.string.pb_send_post));
        this.evQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds168), l.getDimens(context, R.dimen.tbds94));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds17);
        linearLayout.addView(this.evQ, layoutParams2);
        this.evS.addView(linearLayout, layoutParams);
    }

    private void dS(Context context) {
        this.evP = new SpanGroupEditText(context);
        this.evP.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.evP.setMaxLines(4);
        this.evP.setGravity(16);
        this.evP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.evP.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.evP.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.evP.setBackgroundResource(R.color.common_color_10022);
        e(this.evP, R.drawable.edittext_cursor);
        this.evP.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.evP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.evP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.evm) {
                    PbNewInputContainer.this.evm = true;
                    if (PbNewInputContainer.this.evn != -1) {
                        PbNewInputContainer.this.evP.setSelection(PbNewInputContainer.this.evn);
                        PbNewInputContainer.this.evn = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.evU)) {
                        if (PbNewInputContainer.this.evT == null) {
                            PbNewInputContainer.this.evT = new j();
                        }
                        PbNewInputContainer.this.evT.ews = PbNewInputContainer.this.evU.toString();
                        PbNewInputContainer.this.evT.mContent = PbNewInputContainer.this.evP.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.evT));
                        return;
                    }
                    com.baidu.adp.lib.f.e.lt().removeCallbacks(PbNewInputContainer.this.evZ);
                    com.baidu.adp.lib.f.e.lt().post(PbNewInputContainer.this.evZ);
                }
            }
        });
        this.evP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.evP.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds34), 0, 0, 0);
        this.evS.addView(this.evP, layoutParams);
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
                    sb.append(UgcConstant.AT_RULE_TAG);
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.evP.getText().insert(this.evP.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void yx(String str) {
        if (!StringUtils.isNull(str)) {
            this.evP.getText().insert(this.evP.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof q) && ((q) aVar.data).bai() != EmotionGroupType.BIG_EMOTION && ((q) aVar.data).bai() != EmotionGroupType.USER_COLLECT) {
            q qVar = (q) aVar.data;
            if (qVar.bai() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.evP.getText().toString();
            if (this.evl && com.baidu.tieba.face.a.Er(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aVX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.evP);
            }
        }
    }

    private void b(q qVar) {
        if (!this.evk || qVar.bai() == EmotionGroupType.LOCAL) {
            String obj = this.evP.getText().toString();
            if (this.evl && com.baidu.tieba.face.a.Er(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aVX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.evP);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.evk = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.evP != null && this.evS.getVisibility() == 0) {
            this.evP.setFocusable(true);
            this.evP.setFocusableInTouchMode(true);
            this.evP.requestFocus();
            l.showSoftKeyPad(getContext(), this.evP);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        an.setViewTextColor(this.evP, R.color.cp_cont_b, 2, i);
        an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        an.setBackgroundColor(this, R.color.cp_bg_line_h);
        this.evR.aYj();
        if (i == 0) {
            e(this.evP, R.drawable.edittext_cursor);
            this.evP.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.evP, R.drawable.edittext_cursor_1);
            this.evP.setHintTextColor(an.getColor(i, R.color.cp_cont_e));
        }
        this.evQ.aYj();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.evP.getSelectionStart() > 0) {
                        String substring = this.evP.getText().toString().substring(0, this.evP.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hlN.matcher(substring);
                        if (matcher.find()) {
                            this.evP.getText().delete(this.evP.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.evP.getSelectionStart());
                            break;
                        } else {
                            this.evP.getText().delete(this.evP.getSelectionStart() - 1, this.evP.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.evP.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.evP.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.evP.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.evP.setSelection(PbNewInputContainer.this.evP.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.evU = null;
                        if (this.evV != null) {
                            this.evP.setHint(this.evV);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).ews) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.evP.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.ews)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.ews, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.evU = spannableStringBuilder;
                                        PbNewInputContainer.this.evP.setHint(spannableStringBuilder);
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.evP.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(jVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.7
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.evP.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.evP.setSelection(PbNewInputContainer.this.evP.getText().length());
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
                        this.evT = null;
                        this.evU = null;
                        this.evP.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.evX[0] = 0;
                    this.evX[1] = 0;
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
                        if (aVar2.euL != null) {
                            if (aVar2.euL.getChosedFiles() != null) {
                                this.evX[0] = aVar2.euL.getChosedFiles().size();
                            } else {
                                this.evX[0] = 0;
                            }
                        }
                        if (this.evX[0] > 0) {
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
                    int[] iArr = this.evX;
                    iArr[0] = iArr[0] - 1;
                    if (this.evX[0] > 0) {
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
                        this.evR.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.evR.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.evR.setText(aVar3.addr);
                            break;
                        } else {
                            this.evR.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    this.evR.setText(getContext().getString(R.string.location_where_are_you));
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
                            yx((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            yx(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
            }
            nJ(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void nJ(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.evQ.setEnabled(true);
            } else {
                this.evQ.setEnabled(false);
            }
        } else if (i == evY) {
            if (this.flags[1]) {
                this.evQ.setEnabled(true);
            } else {
                this.evQ.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.evW = z;
    }

    public void setHint(int i) {
        if (this.evP != null) {
            this.evP.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.evP != null) {
            this.evP.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.evV = str;
    }

    public EditText getInputView() {
        return this.evP;
    }

    public TBSpecificationBtn getSendView() {
        return this.evQ;
    }

    public LinearLayout getInputLayout() {
        return this.evS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evR) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.evP != null) {
            this.evP.setTransLink(z);
        }
    }
}
