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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools abj;
    private int abk;
    private int ajp;
    private TextView egP;
    private boolean faF;
    private boolean faG;
    private boolean faH;
    private int faI;
    private SpanGroupEditText fbJ;
    private TBSpecificationBtn fbK;
    private TBSpecificationBtn fbL;
    private LinearLayout fbM;
    private j fbN;
    private SpannableStringBuilder fbO;
    private String fbP;
    private boolean fbQ;
    private int[] fbR;
    private Runnable fbT;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int fbS = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.faF = false;
        this.faG = true;
        this.faH = true;
        this.faI = -1;
        this.fbQ = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fbR = new int[]{0, 0};
        this.ajp = 0;
        this.mType = ALL;
        this.fbT = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fbJ != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fbJ.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bwg();
        en(context);
        this.fbM = new LinearLayout(getContext());
        this.fbM.setOrientation(0);
        this.fbM.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fbM, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bwg() {
        this.egP = new TextView(getContext());
        this.egP.setId(R.id.comment_content);
        this.egP.setVisibility(8);
        this.egP.setMaxLines(1);
        this.egP.setEllipsize(TextUtils.TruncateAt.END);
        this.egP.setIncludeFontPadding(false);
        this.egP.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.egP.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.egP, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void en(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pP(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pJ(R.color.cp_cont_e);
        bVar.aZ(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds28), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.fbL = new TBSpecificationBtn(getContext());
        this.fbL.setLayoutParams(layoutParams);
        this.fbL.setOnClickListener(this);
        this.fbL.setConfig(bVar);
        this.fbL.setTextSize(R.dimen.tbds32);
        this.fbL.setOnClickListener(this);
        this.fbL.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fbL);
    }

    private void eo(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.fbK = new TBSpecificationBtn(context);
        this.fbK.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        this.fbK.setEnabled(false);
        this.fbK.setTextSize(R.dimen.tbds34);
        this.fbK.setText(context.getString(R.string.pb_send_post));
        this.fbK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds152), l.getDimens(context, R.dimen.tbds76));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds16);
        linearLayout.addView(this.fbK, layoutParams2);
        this.fbM.addView(linearLayout, layoutParams);
    }

    private void ep(Context context) {
        this.fbJ = new SpanGroupEditText(context);
        this.fbJ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.fbJ.setMaxLines(4);
        this.fbJ.setMinLines(2);
        this.fbJ.setGravity(48);
        this.fbJ.setIncludeFontPadding(false);
        this.fbJ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.fbJ.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.fbJ.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        g(this.fbJ, R.drawable.edittext_cursor);
        this.fbJ.setLineSpacing(l.getDimens(context, R.dimen.tbds11), 1.0f);
        this.fbJ.setPadding(l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds29), l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds31));
        this.fbJ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fbJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.faH) {
                    PbNewInputContainer.this.faH = true;
                    if (PbNewInputContainer.this.faI != -1) {
                        PbNewInputContainer.this.fbJ.setSelection(PbNewInputContainer.this.faI);
                        PbNewInputContainer.this.faI = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fbO)) {
                        if (PbNewInputContainer.this.fbN == null) {
                            PbNewInputContainer.this.fbN = new j();
                        }
                        PbNewInputContainer.this.fbN.fcm = PbNewInputContainer.this.fbO.toString();
                        PbNewInputContainer.this.fbN.mContent = PbNewInputContainer.this.fbJ.getText().toString();
                        PbNewInputContainer.this.fbN.mSpanGroupManager = PbNewInputContainer.this.fbJ.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fbN));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(PbNewInputContainer.this.fbT);
                    com.baidu.adp.lib.f.e.mY().post(PbNewInputContainer.this.fbT);
                }
            }
        });
        this.fbJ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fbJ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds24), l.getDimens(context, R.dimen.tbds42), l.getDimens(context, R.dimen.tbds16));
        this.fbM.addView(this.fbJ, layoutParams);
    }

    private void g(EditText editText, int i) {
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
                    this.fbJ.getText().insert(this.fbJ.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void Dc(String str) {
        if (!StringUtils.isNull(str)) {
            this.fbJ.getText().insert(this.fbJ.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bqt() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bqt() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bqt() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fbJ.getText().toString();
            if (this.faG && com.baidu.tieba.face.a.IO(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.blW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fbJ);
            }
        }
    }

    private void b(u uVar) {
        if (!this.faF || uVar.bqt() == EmotionGroupType.LOCAL) {
            String obj = this.fbJ.getText().toString();
            if (this.faG && com.baidu.tieba.face.a.IO(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.blW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fbJ);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.faF = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abk;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fbJ != null && this.fbM.getVisibility() == 0) {
            this.fbJ.setFocusable(true);
            this.fbJ.setFocusableInTouchMode(true);
            this.fbJ.requestFocus();
            l.showSoftKeyPad(getContext(), this.fbJ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fbJ, R.color.cp_cont_b, 2, i);
        com.baidu.tbadk.core.util.e.a.bnv().aP(R.color.cp_bg_line_j, i).oO(0).X(l.getDimens(getContext(), R.dimen.tbds21)).bf(this.fbJ);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_h, i);
        this.fbL.changeSkinType(i);
        if (i == 0) {
            g(this.fbJ, R.drawable.edittext_cursor);
            this.fbJ.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        } else {
            g(this.fbJ, R.drawable.edittext_cursor_1);
            this.fbJ.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        this.fbK.changeSkinType(i);
        ap.setViewTextColor(this.egP, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fbJ.getSelectionStart() > 0) {
                        String substring = this.fbJ.getText().toString().substring(0, this.fbJ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iaR.matcher(substring);
                        if (matcher.find()) {
                            this.fbJ.getText().delete(this.fbJ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fbJ.getSelectionStart());
                            break;
                        } else {
                            this.fbJ.getText().delete(this.fbJ.getSelectionStart() - 1, this.fbJ.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fbJ.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fbJ.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fbJ.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fbJ.setSelection(PbNewInputContainer.this.fbJ.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fbO = null;
                        if (this.fbP != null) {
                            this.fbJ.setHint(this.fbP);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fcm) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fbJ.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fcm)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fcm, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fbO = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fbJ.setText("");
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
                                        PbNewInputContainer.this.fbJ.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fbJ.setSelection(PbNewInputContainer.this.fbJ.getText().length());
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
                        this.fbN = null;
                        this.fbO = null;
                        this.fbJ.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fbR[0] = 0;
                    this.fbR[1] = 0;
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
                        if (aVar2.fag != null) {
                            if (aVar2.fag.getChosedFiles() != null) {
                                this.fbR[0] = aVar2.fag.getChosedFiles().size();
                            } else {
                                this.fbR[0] = 0;
                            }
                        }
                        if (this.fbR[0] > 0) {
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
                    int[] iArr = this.fbR;
                    iArr[0] = iArr[0] - 1;
                    if (this.fbR[0] > 0) {
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
                        jR(false);
                        break;
                    } else {
                        jR(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fbL.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fbL.setText(aVar3.addr);
                            break;
                        } else {
                            this.fbL.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    jR(true);
                    this.fbL.setText(getContext().getString(R.string.location_where_are_you));
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
                            Dc((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            Dc(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.egP.setVisibility(8);
                            break;
                        } else {
                            this.egP.setVisibility(0);
                            this.egP.setText(str);
                            break;
                        }
                    } else {
                        this.egP.setVisibility(8);
                        break;
                    }
            }
            rb(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rb(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.fbK.setEnabled(true);
            } else {
                this.fbK.setEnabled(false);
            }
        } else if (i == fbS) {
            if (this.flags[1]) {
                this.fbK.setEnabled(true);
            } else {
                this.fbK.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fbQ = z;
    }

    public void setHint(int i) {
        if (this.fbJ != null) {
            this.fbJ.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fbJ != null) {
            this.fbJ.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fbP = str;
    }

    public EditText getInputView() {
        return this.fbJ;
    }

    public TBSpecificationBtn getSendView() {
        return this.fbK;
    }

    public LinearLayout getInputLayout() {
        return this.fbM;
    }

    public TextView getTitleView() {
        return this.egP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbL) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fbJ != null) {
            this.fbJ.setTransLink(z);
        }
    }

    public void jR(boolean z) {
        if (this.fbL != null) {
            this.fbL.setVisibility(z ? 0 : 8);
        }
    }
}
