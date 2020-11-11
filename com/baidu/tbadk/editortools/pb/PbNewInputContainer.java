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
    private EditorTools abk;
    private int abl;
    private int ajq;
    private TextView evg;
    private boolean[] flags;
    private boolean foV;
    private boolean foW;
    private boolean foX;
    private int foY;
    private SpanGroupEditText fqa;
    private TBSpecificationBtn fqb;
    private TBSpecificationBtn fqc;
    private LinearLayout fqd;
    private j fqe;
    private SpannableStringBuilder fqf;
    private String fqg;
    private boolean fqh;
    private int[] fqi;
    private Runnable fqk;
    private View mBottomLine;
    private int mType;
    public static int fqj = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foV = false;
        this.foW = true;
        this.foX = true;
        this.foY = -1;
        this.fqh = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fqi = new int[]{0, 0};
        this.ajq = 0;
        this.mType = ALL;
        this.fqk = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fqa != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fqa.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bAy();
        en(context);
        this.fqd = new LinearLayout(getContext());
        this.fqd.setOrientation(0);
        this.fqd.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fqd, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bAy() {
        this.evg = new TextView(getContext());
        this.evg.setId(R.id.comment_content);
        this.evg.setVisibility(8);
        this.evg.setMaxLines(1);
        this.evg.setEllipsize(TextUtils.TruncateAt.END);
        this.evg.setIncludeFontPadding(false);
        this.evg.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.evg.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.evg, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void en(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qk(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.qe(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds28), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.fqc = new TBSpecificationBtn(getContext());
        this.fqc.setLayoutParams(layoutParams);
        this.fqc.setOnClickListener(this);
        this.fqc.setConfig(bVar);
        this.fqc.setTextSize(R.dimen.tbds32);
        this.fqc.setOnClickListener(this);
        this.fqc.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fqc);
    }

    private void eo(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.fqb = new TBSpecificationBtn(context);
        this.fqb.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        this.fqb.setEnabled(false);
        this.fqb.setTextSize(R.dimen.tbds34);
        this.fqb.setText(context.getString(R.string.pb_send_post));
        this.fqb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds152), l.getDimens(context, R.dimen.tbds76));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds16);
        linearLayout.addView(this.fqb, layoutParams2);
        this.fqd.addView(linearLayout, layoutParams);
    }

    private void ep(Context context) {
        this.fqa = new SpanGroupEditText(context);
        this.fqa.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.fqa.setMaxLines(4);
        this.fqa.setMinLines(2);
        this.fqa.setGravity(48);
        this.fqa.setIncludeFontPadding(false);
        this.fqa.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.fqa.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.fqa.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        g(this.fqa, R.drawable.edittext_cursor);
        this.fqa.setLineSpacing(l.getDimens(context, R.dimen.tbds11), 1.0f);
        this.fqa.setPadding(l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds29), l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds31));
        this.fqa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fqa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.foX) {
                    PbNewInputContainer.this.foX = true;
                    if (PbNewInputContainer.this.foY != -1) {
                        PbNewInputContainer.this.fqa.setSelection(PbNewInputContainer.this.foY);
                        PbNewInputContainer.this.foY = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fqf)) {
                        if (PbNewInputContainer.this.fqe == null) {
                            PbNewInputContainer.this.fqe = new j();
                        }
                        PbNewInputContainer.this.fqe.fqD = PbNewInputContainer.this.fqf.toString();
                        PbNewInputContainer.this.fqe.mContent = PbNewInputContainer.this.fqa.getText().toString();
                        PbNewInputContainer.this.fqe.mSpanGroupManager = PbNewInputContainer.this.fqa.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fqe));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(PbNewInputContainer.this.fqk);
                    com.baidu.adp.lib.f.e.mY().post(PbNewInputContainer.this.fqk);
                }
            }
        });
        this.fqa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fqa.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds24), l.getDimens(context, R.dimen.tbds42), l.getDimens(context, R.dimen.tbds16));
        this.fqd.addView(this.fqa, layoutParams);
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
                    this.fqa.getText().insert(this.fqa.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void DJ(String str) {
        if (!StringUtils.isNull(str)) {
            this.fqa.getText().insert(this.fqa.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).buM() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).buM() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.buM() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fqa.getText().toString();
            if (this.foW && com.baidu.tieba.face.a.JE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bqp().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fqa);
            }
        }
    }

    private void b(u uVar) {
        if (!this.foV || uVar.buM() == EmotionGroupType.LOCAL) {
            String obj = this.fqa.getText().toString();
            if (this.foW && com.baidu.tieba.face.a.JE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bqp().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fqa);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.foV = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fqa != null && this.fqd.getVisibility() == 0) {
            this.fqa.setFocusable(true);
            this.fqa.setFocusableInTouchMode(true);
            this.fqa.requestFocus();
            l.showSoftKeyPad(getContext(), this.fqa);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fqa, R.color.cp_cont_b, 2, i);
        com.baidu.tbadk.core.util.e.a.brO().aQ(R.color.cp_bg_line_j, i).pj(0).ab(l.getDimens(getContext(), R.dimen.tbds21)).bk(this.fqa);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_h, i);
        this.fqc.changeSkinType(i);
        if (i == 0) {
            g(this.fqa, R.drawable.edittext_cursor);
            this.fqa.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        } else {
            g(this.fqa, R.drawable.edittext_cursor_1);
            this.fqa.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        this.fqb.changeSkinType(i);
        ap.setViewTextColor(this.evg, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fqa.getSelectionStart() > 0) {
                        String substring = this.fqa.getText().toString().substring(0, this.fqa.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.itq.matcher(substring);
                        if (matcher.find()) {
                            this.fqa.getText().delete(this.fqa.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fqa.getSelectionStart());
                            break;
                        } else {
                            this.fqa.getText().delete(this.fqa.getSelectionStart() - 1, this.fqa.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fqa.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fqa.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fqa.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fqa.setSelection(PbNewInputContainer.this.fqa.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fqf = null;
                        if (this.fqg != null) {
                            this.fqa.setHint(this.fqg);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fqD) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fqa.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fqD)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fqD, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fqf = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fqa.setText("");
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
                                        PbNewInputContainer.this.fqa.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fqa.setSelection(PbNewInputContainer.this.fqa.getText().length());
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
                        this.fqe = null;
                        this.fqf = null;
                        this.fqa.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fqi[0] = 0;
                    this.fqi[1] = 0;
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
                        if (aVar2.fow != null) {
                            if (aVar2.fow.getChosedFiles() != null) {
                                this.fqi[0] = aVar2.fow.getChosedFiles().size();
                            } else {
                                this.fqi[0] = 0;
                            }
                        }
                        if (this.fqi[0] > 0) {
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
                    int[] iArr = this.fqi;
                    iArr[0] = iArr[0] - 1;
                    if (this.fqi[0] > 0) {
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
                        kn(false);
                        break;
                    } else {
                        kn(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fqc.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fqc.setText(aVar3.addr);
                            break;
                        } else {
                            this.fqc.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    kn(true);
                    this.fqc.setText(getContext().getString(R.string.location_where_are_you));
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
                            DJ((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            DJ(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.evg.setVisibility(8);
                            break;
                        } else {
                            this.evg.setVisibility(0);
                            this.evg.setText(str);
                            break;
                        }
                    } else {
                        this.evg.setVisibility(8);
                        break;
                    }
            }
            rw(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rw(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.fqb.setEnabled(true);
            } else {
                this.fqb.setEnabled(false);
            }
        } else if (i == fqj) {
            if (this.flags[1]) {
                this.fqb.setEnabled(true);
            } else {
                this.fqb.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fqh = z;
    }

    public void setHint(int i) {
        if (this.fqa != null) {
            this.fqa.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fqa != null) {
            this.fqa.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fqg = str;
    }

    public EditText getInputView() {
        return this.fqa;
    }

    public TBSpecificationBtn getSendView() {
        return this.fqb;
    }

    public LinearLayout getInputLayout() {
        return this.fqd;
    }

    public TextView getTitleView() {
        return this.evg;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqc) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fqa != null) {
            this.fqa.setTransLink(z);
        }
    }

    public void kn(boolean z) {
        if (this.fqc != null) {
            this.fqc.setVisibility(z ? 0 : 8);
        }
    }
}
