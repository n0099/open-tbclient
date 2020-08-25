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
/* loaded from: classes2.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools aay;
    private int aaz;
    private int aiB;
    private TextView dSz;
    private SpanGroupEditText eMH;
    private TBSpecificationBtn eMI;
    private TBSpecificationBtn eMJ;
    private LinearLayout eMK;
    private j eML;
    private SpannableStringBuilder eMM;
    private String eMN;
    private boolean eMO;
    private int[] eMP;
    private Runnable eMR;
    private boolean eMc;
    private boolean eMd;
    private boolean eMe;
    private int eMf;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int eMQ = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMc = false;
        this.eMd = true;
        this.eMe = true;
        this.eMf = -1;
        this.eMO = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eMP = new int[]{0, 0};
        this.aiB = 0;
        this.mType = ALL;
        this.eMR = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.eMH != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.eMH.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bsr();
        ee(context);
        this.eMK = new LinearLayout(getContext());
        this.eMK.setOrientation(0);
        this.eMK.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.eMK, new LinearLayout.LayoutParams(-1, -2));
        eg(context);
        ef(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bsr() {
        this.dSz = new TextView(getContext());
        this.dSz.setId(R.id.comment_content);
        this.dSz.setVisibility(8);
        this.dSz.setMaxLines(1);
        this.dSz.setEllipsize(TextUtils.TruncateAt.END);
        this.dSz.setIncludeFontPadding(false);
        this.dSz.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.dSz.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.dSz, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void ee(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pd(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.oY(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds28), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.eMJ = new TBSpecificationBtn(getContext());
        this.eMJ.setLayoutParams(layoutParams);
        this.eMJ.setOnClickListener(this);
        this.eMJ.setConfig(bVar);
        this.eMJ.setTextSize(R.dimen.tbds32);
        this.eMJ.setOnClickListener(this);
        this.eMJ.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.eMJ);
    }

    private void ef(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.eMI = new TBSpecificationBtn(context);
        this.eMI.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        this.eMI.setEnabled(false);
        this.eMI.setTextSize(R.dimen.tbds34);
        this.eMI.setText(context.getString(R.string.pb_send_post));
        this.eMI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds152), l.getDimens(context, R.dimen.tbds76));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds16);
        linearLayout.addView(this.eMI, layoutParams2);
        this.eMK.addView(linearLayout, layoutParams);
    }

    private void eg(Context context) {
        this.eMH = new SpanGroupEditText(context);
        this.eMH.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.eMH.setMaxLines(4);
        this.eMH.setMinLines(2);
        this.eMH.setGravity(48);
        this.eMH.setIncludeFontPadding(false);
        this.eMH.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.eMH.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.eMH.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        e(this.eMH, R.drawable.edittext_cursor);
        this.eMH.setLineSpacing(l.getDimens(context, R.dimen.tbds11), 1.0f);
        this.eMH.setPadding(l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds29), l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds31));
        this.eMH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eMH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.eMe) {
                    PbNewInputContainer.this.eMe = true;
                    if (PbNewInputContainer.this.eMf != -1) {
                        PbNewInputContainer.this.eMH.setSelection(PbNewInputContainer.this.eMf);
                        PbNewInputContainer.this.eMf = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.eMM)) {
                        if (PbNewInputContainer.this.eML == null) {
                            PbNewInputContainer.this.eML = new j();
                        }
                        PbNewInputContainer.this.eML.eNk = PbNewInputContainer.this.eMM.toString();
                        PbNewInputContainer.this.eML.mContent = PbNewInputContainer.this.eMH.getText().toString();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.eML));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mS().removeCallbacks(PbNewInputContainer.this.eMR);
                    com.baidu.adp.lib.f.e.mS().post(PbNewInputContainer.this.eMR);
                }
            }
        });
        this.eMH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.eMH.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds24), l.getDimens(context, R.dimen.tbds42), l.getDimens(context, R.dimen.tbds16));
        this.eMK.addView(this.eMH, layoutParams);
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
                    this.eMH.getText().insert(this.eMH.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void BT(String str) {
        if (!StringUtils.isNull(str)) {
            this.eMH.getText().insert(this.eMH.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
            String obj = this.eMH.getText().toString();
            if (this.eMd && com.baidu.tieba.face.a.HD(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), tVar, this.eMH);
            }
        }
    }

    private void b(t tVar) {
        if (!this.eMc || tVar.bmP() == EmotionGroupType.LOCAL) {
            String obj = this.eMH.getText().toString();
            if (this.eMd && com.baidu.tieba.face.a.HD(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), tVar, this.eMH);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eMc = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.eMH != null && this.eMK.getVisibility() == 0) {
            this.eMH.setFocusable(true);
            this.eMH.setFocusableInTouchMode(true);
            this.eMH.requestFocus();
            l.showSoftKeyPad(getContext(), this.eMH);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.eMH, R.color.cp_cont_b, 2, i);
        com.baidu.tbadk.core.util.e.a.bjQ().aQ(R.color.cp_bg_line_j, i).oe(0).V(l.getDimens(getContext(), R.dimen.tbds21)).aZ(this.eMH);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_h, i);
        this.eMJ.changeSkinType(i);
        if (i == 0) {
            e(this.eMH, R.drawable.edittext_cursor);
            this.eMH.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        } else {
            e(this.eMH, R.drawable.edittext_cursor_1);
            this.eMH.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        this.eMI.changeSkinType(i);
        ap.setViewTextColor(this.dSz, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eMH.getSelectionStart() > 0) {
                        String substring = this.eMH.getText().toString().substring(0, this.eMH.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hEP.matcher(substring);
                        if (matcher.find()) {
                            this.eMH.getText().delete(this.eMH.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eMH.getSelectionStart());
                            break;
                        } else {
                            this.eMH.getText().delete(this.eMH.getSelectionStart() - 1, this.eMH.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.eMH.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eMH.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.eMH.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.eMH.setSelection(PbNewInputContainer.this.eMH.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.eMM = null;
                        if (this.eMN != null) {
                            this.eMH.setHint(this.eMN);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).eNk) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.eMH.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.eNk)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.eNk, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.eMM = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.eMH.setText("");
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
                                        PbNewInputContainer.this.eMH.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.eMH.setSelection(PbNewInputContainer.this.eMH.getText().length());
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
                        this.eML = null;
                        this.eMM = null;
                        this.eMH.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eMP[0] = 0;
                    this.eMP[1] = 0;
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
                        if (aVar2.eLD != null) {
                            if (aVar2.eLD.getChosedFiles() != null) {
                                this.eMP[0] = aVar2.eLD.getChosedFiles().size();
                            } else {
                                this.eMP[0] = 0;
                            }
                        }
                        if (this.eMP[0] > 0) {
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
                    int[] iArr = this.eMP;
                    iArr[0] = iArr[0] - 1;
                    if (this.eMP[0] > 0) {
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
                        this.eMJ.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.eMJ.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.eMJ.setText(aVar3.addr);
                            break;
                        } else {
                            this.eMJ.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    this.eMJ.setText(getContext().getString(R.string.location_where_are_you));
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
                            BT((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            BT(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.dSz.setVisibility(8);
                            break;
                        } else {
                            this.dSz.setVisibility(0);
                            this.dSz.setText(str);
                            break;
                        }
                    } else {
                        this.dSz.setVisibility(8);
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
                this.eMI.setEnabled(true);
            } else {
                this.eMI.setEnabled(false);
            }
        } else if (i == eMQ) {
            if (this.flags[1]) {
                this.eMI.setEnabled(true);
            } else {
                this.eMI.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.eMO = z;
    }

    public void setHint(int i) {
        if (this.eMH != null) {
            this.eMH.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.eMH != null) {
            this.eMH.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.eMN = str;
    }

    public EditText getInputView() {
        return this.eMH;
    }

    public TBSpecificationBtn getSendView() {
        return this.eMI;
    }

    public LinearLayout getInputLayout() {
        return this.eMK;
    }

    public TextView getTitleView() {
        return this.dSz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eMJ) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.eMH != null) {
            this.eMH.setTransLink(z);
        }
    }

    public void jq(boolean z) {
        if (this.eMJ != null) {
            this.eMJ.setVisibility(z ? 0 : 8);
        }
    }
}
