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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationButtonConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupEditText;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools aaA;
    private int aaB;
    private int aiD;
    private TextView dSD;
    private SpanGroupEditText eML;
    private TBSpecificationBtn eMM;
    private TBSpecificationBtn eMN;
    private LinearLayout eMO;
    private j eMP;
    private SpannableStringBuilder eMQ;
    private String eMR;
    private boolean eMS;
    private int[] eMT;
    private Runnable eMV;
    private boolean eMg;
    private boolean eMh;
    private boolean eMi;
    private int eMj;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int eMU = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMg = false;
        this.eMh = true;
        this.eMi = true;
        this.eMj = -1;
        this.eMS = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eMT = new int[]{0, 0};
        this.aiD = 0;
        this.mType = ALL;
        this.eMV = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.eML != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.eML.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bss();
        ee(context);
        this.eMO = new LinearLayout(getContext());
        this.eMO.setOrientation(0);
        this.eMO.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.eMO, new LinearLayout.LayoutParams(-1, -2));
        eg(context);
        ef(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bss() {
        this.dSD = new TextView(getContext());
        this.dSD.setId(R.id.comment_content);
        this.dSD.setVisibility(8);
        this.dSD.setMaxLines(1);
        this.dSD.setEllipsize(TextUtils.TruncateAt.END);
        this.dSD.setIncludeFontPadding(false);
        this.dSD.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.dSD.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.dSD, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void ee(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pd(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.oY(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds28), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.eMN = new TBSpecificationBtn(getContext());
        this.eMN.setLayoutParams(layoutParams);
        this.eMN.setOnClickListener(this);
        this.eMN.setConfig(bVar);
        this.eMN.setTextSize(R.dimen.tbds32);
        this.eMN.setOnClickListener(this);
        this.eMN.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.eMN);
    }

    private void ef(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.eMM = new TBSpecificationBtn(context);
        this.eMM.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        this.eMM.setEnabled(false);
        this.eMM.setTextSize(R.dimen.tbds34);
        this.eMM.setText(context.getString(R.string.pb_send_post));
        this.eMM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds152), l.getDimens(context, R.dimen.tbds76));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds16);
        linearLayout.addView(this.eMM, layoutParams2);
        this.eMO.addView(linearLayout, layoutParams);
    }

    private void eg(Context context) {
        this.eML = new SpanGroupEditText(context);
        this.eML.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.eML.setMaxLines(4);
        this.eML.setMinLines(2);
        this.eML.setGravity(48);
        this.eML.setIncludeFontPadding(false);
        this.eML.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.eML.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.eML.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        e(this.eML, R.drawable.edittext_cursor);
        this.eML.setLineSpacing(l.getDimens(context, R.dimen.tbds11), 1.0f);
        this.eML.setPadding(l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds29), l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds31));
        this.eML.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eML.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.eMi) {
                    PbNewInputContainer.this.eMi = true;
                    if (PbNewInputContainer.this.eMj != -1) {
                        PbNewInputContainer.this.eML.setSelection(PbNewInputContainer.this.eMj);
                        PbNewInputContainer.this.eMj = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.eMQ)) {
                        if (PbNewInputContainer.this.eMP == null) {
                            PbNewInputContainer.this.eMP = new j();
                        }
                        PbNewInputContainer.this.eMP.eNo = PbNewInputContainer.this.eMQ.toString();
                        PbNewInputContainer.this.eMP.mContent = PbNewInputContainer.this.eML.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.eMP));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(PbNewInputContainer.this.eMV);
                    com.baidu.adp.lib.f.e.mS().post(PbNewInputContainer.this.eMV);
                }
            }
        });
        this.eML.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.eML.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds24), l.getDimens(context, R.dimen.tbds42), l.getDimens(context, R.dimen.tbds16));
        this.eMO.addView(this.eML, layoutParams);
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

    private void M(ArrayList<String> arrayList) {
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
                    this.eML.getText().insert(this.eML.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void BU(String str) {
        if (!StringUtils.isNull(str)) {
            this.eML.getText().insert(this.eML.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof t) && ((t) aVar.data).bmP() != EmotionGroupType.BIG_EMOTION && ((t) aVar.data).bmP() != EmotionGroupType.USER_COLLECT) {
            t tVar = (t) aVar.data;
            if (tVar.bmP() == EmotionGroupType.NET_SUG) {
                a(tVar);
            } else {
                b(tVar);
            }
        }
    }

    private void a(t tVar) {
        if (tVar != null && !TextUtils.isEmpty(tVar.getName()) && !TextUtils.isEmpty(tVar.getUrl())) {
            String obj = this.eML.getText().toString();
            if (this.eMh && com.baidu.tieba.face.a.HE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), tVar, this.eML);
            }
        }
    }

    private void b(t tVar) {
        if (!this.eMg || tVar.bmP() == EmotionGroupType.LOCAL) {
            String obj = this.eML.getText().toString();
            if (this.eMh && com.baidu.tieba.face.a.HE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), tVar, this.eML);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eMg = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaB;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.eML != null && this.eMO.getVisibility() == 0) {
            this.eML.setFocusable(true);
            this.eML.setFocusableInTouchMode(true);
            this.eML.requestFocus();
            l.showSoftKeyPad(getContext(), this.eML);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.eML, R.color.cp_cont_b, 2, i);
        com.baidu.tbadk.core.util.e.a.bjQ().aQ(R.color.cp_bg_line_j, i).oe(0).V(l.getDimens(getContext(), R.dimen.tbds21)).aZ(this.eML);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_h, i);
        this.eMN.changeSkinType(i);
        if (i == 0) {
            e(this.eML, R.drawable.edittext_cursor);
            this.eML.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        } else {
            e(this.eML, R.drawable.edittext_cursor_1);
            this.eML.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        this.eMM.changeSkinType(i);
        ap.setViewTextColor(this.dSD, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eML.getSelectionStart() > 0) {
                        String substring = this.eML.getText().toString().substring(0, this.eML.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hEV.matcher(substring);
                        if (matcher.find()) {
                            this.eML.getText().delete(this.eML.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eML.getSelectionStart());
                            break;
                        } else {
                            this.eML.getText().delete(this.eML.getSelectionStart() - 1, this.eML.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.eML.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eML.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.eML.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.eML.setSelection(PbNewInputContainer.this.eML.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.eMQ = null;
                        if (this.eMR != null) {
                            this.eML.setHint(this.eMR);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).eNo) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.eML.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.eNo)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.eNo, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.eMQ = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.eML.setText("");
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
                                        PbNewInputContainer.this.eML.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.eML.setSelection(PbNewInputContainer.this.eML.getText().length());
                                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                        PbNewInputContainer.this.requestFocus();
                                    }
                                });
                            }
                        }
                    }
                    break;
                case 4:
                    if (aVar.data == null || (((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data)) || (((aVar.data instanceof j) && TextUtils.isEmpty(((j) aVar.data).mContent)) || ((aVar.data instanceof SpanGroupManager) && ((SpanGroupManager) aVar.data).isEmpty())))) {
                        this.flags[0] = false;
                        break;
                    } else {
                        this.flags[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.eMP = null;
                        this.eMQ = null;
                        this.eML.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eMT[0] = 0;
                    this.eMT[1] = 0;
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
                        if (aVar2.eLH != null) {
                            if (aVar2.eLH.getChosedFiles() != null) {
                                this.eMT[0] = aVar2.eLH.getChosedFiles().size();
                            } else {
                                this.eMT[0] = 0;
                            }
                        }
                        if (this.eMT[0] > 0) {
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
                    int[] iArr = this.eMT;
                    iArr[0] = iArr[0] - 1;
                    if (this.eMT[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        M((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        js(false);
                        break;
                    } else {
                        js(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.eMN.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.eMN.setText(aVar3.addr);
                            break;
                        } else {
                            this.eMN.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    js(true);
                    this.eMN.setText(getContext().getString(R.string.location_where_are_you));
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
                            BU((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            BU(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.dSD.setVisibility(8);
                            break;
                        } else {
                            this.dSD.setVisibility(0);
                            this.dSD.setText(str);
                            break;
                        }
                    } else {
                        this.dSD.setVisibility(8);
                        break;
                    }
            }
            qm(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void qm(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.eMM.setEnabled(true);
            } else {
                this.eMM.setEnabled(false);
            }
        } else if (i == eMU) {
            if (this.flags[1]) {
                this.eMM.setEnabled(true);
            } else {
                this.eMM.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.eMS = z;
    }

    public void setHint(int i) {
        if (this.eML != null) {
            this.eML.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.eML != null) {
            this.eML.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.eMR = str;
    }

    public EditText getInputView() {
        return this.eML;
    }

    public TBSpecificationBtn getSendView() {
        return this.eMM;
    }

    public LinearLayout getInputLayout() {
        return this.eMO;
    }

    public TextView getTitleView() {
        return this.dSD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eMN) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.eML != null) {
            this.eML.setTransLink(z);
        }
    }

    public void js(boolean z) {
        if (this.eMN != null) {
            this.eMN.setVisibility(z ? 0 : 8);
        }
    }
}
