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
    private TextView epn;
    private boolean fje;
    private boolean fjf;
    private boolean fjg;
    private int fjh;
    private SpanGroupEditText fki;
    private TBSpecificationBtn fkj;
    private TBSpecificationBtn fkk;
    private LinearLayout fkl;
    private j fkm;
    private SpannableStringBuilder fkn;
    private String fko;
    private boolean fkp;
    private int[] fkq;
    private Runnable fks;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int fkr = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fje = false;
        this.fjf = true;
        this.fjg = true;
        this.fjh = -1;
        this.fkp = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fkq = new int[]{0, 0};
        this.ajq = 0;
        this.mType = ALL;
        this.fks = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fki != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fki.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bxZ();
        en(context);
        this.fkl = new LinearLayout(getContext());
        this.fkl.setOrientation(0);
        this.fkl.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fkl, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bxZ() {
        this.epn = new TextView(getContext());
        this.epn.setId(R.id.comment_content);
        this.epn.setVisibility(8);
        this.epn.setMaxLines(1);
        this.epn.setEllipsize(TextUtils.TruncateAt.END);
        this.epn.setIncludeFontPadding(false);
        this.epn.setPadding(l.getDimens(getContext(), R.dimen.tbds44), l.getDimens(getContext(), R.dimen.tbds42), l.getDimens(getContext(), R.dimen.tbds44), 0);
        this.epn.setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        addView(this.epn, new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds118)));
    }

    private void en(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qa(R.color.cp_cont_b);
        bVar.a(R.drawable.ic_icon_pure_post_location16_svg, 0, TBSpecificationButtonConfig.IconType.SVG);
        bVar.pU(R.color.cp_cont_e);
        bVar.ba(l.getDimens(getContext(), R.dimen.tbds22), l.getDimens(getContext(), R.dimen.tbds28));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds63));
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds28), l.getDimens(context, R.dimen.ds34), l.getDimens(context, R.dimen.ds12));
        this.fkk = new TBSpecificationBtn(getContext());
        this.fkk.setLayoutParams(layoutParams);
        this.fkk.setOnClickListener(this);
        this.fkk.setConfig(bVar);
        this.fkk.setTextSize(R.dimen.tbds32);
        this.fkk.setOnClickListener(this);
        this.fkk.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fkk);
    }

    private void eo(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        this.fkj = new TBSpecificationBtn(context);
        this.fkj.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
        this.fkj.setEnabled(false);
        this.fkj.setTextSize(R.dimen.tbds34);
        this.fkj.setText(context.getString(R.string.pb_send_post));
        this.fkj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds152), l.getDimens(context, R.dimen.tbds76));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.tbds44);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.tbds16);
        linearLayout.addView(this.fkj, layoutParams2);
        this.fkl.addView(linearLayout, layoutParams);
    }

    private void ep(Context context) {
        this.fki = new SpanGroupEditText(context);
        this.fki.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.fki.setMaxLines(4);
        this.fki.setMinLines(2);
        this.fki.setGravity(48);
        this.fki.setIncludeFontPadding(false);
        this.fki.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.fki.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.fki.setHintTextColor(getResources().getColor(R.color.cp_cont_d));
        g(this.fki, R.drawable.edittext_cursor);
        this.fki.setLineSpacing(l.getDimens(context, R.dimen.tbds11), 1.0f);
        this.fki.setPadding(l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds29), l.getDimens(context, R.dimen.tbds31), l.getDimens(context, R.dimen.tbds31));
        this.fki.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fki.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fjg) {
                    PbNewInputContainer.this.fjg = true;
                    if (PbNewInputContainer.this.fjh != -1) {
                        PbNewInputContainer.this.fki.setSelection(PbNewInputContainer.this.fjh);
                        PbNewInputContainer.this.fjh = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fkn)) {
                        if (PbNewInputContainer.this.fkm == null) {
                            PbNewInputContainer.this.fkm = new j();
                        }
                        PbNewInputContainer.this.fkm.fkL = PbNewInputContainer.this.fkn.toString();
                        PbNewInputContainer.this.fkm.mContent = PbNewInputContainer.this.fki.getText().toString();
                        PbNewInputContainer.this.fkm.mSpanGroupManager = PbNewInputContainer.this.fki.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fkm));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(PbNewInputContainer.this.fks);
                    com.baidu.adp.lib.f.e.mY().post(PbNewInputContainer.this.fks);
                }
            }
        });
        this.fki.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fki.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.tbds44), l.getDimens(context, R.dimen.tbds24), l.getDimens(context, R.dimen.tbds42), l.getDimens(context, R.dimen.tbds16));
        this.fkl.addView(this.fki, layoutParams);
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
                    this.fki.getText().insert(this.fki.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void Dv(String str) {
        if (!StringUtils.isNull(str)) {
            this.fki.getText().insert(this.fki.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bsm() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bsm() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bsm() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fki.getText().toString();
            if (this.fjf && com.baidu.tieba.face.a.Jn(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bnP().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fki);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fje || uVar.bsm() == EmotionGroupType.LOCAL) {
            String obj = this.fki.getText().toString();
            if (this.fjf && com.baidu.tieba.face.a.Jn(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bnP().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fki);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fje = z;
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
        if (this.fki != null && this.fkl.getVisibility() == 0) {
            this.fki.setFocusable(true);
            this.fki.setFocusableInTouchMode(true);
            this.fki.requestFocus();
            l.showSoftKeyPad(getContext(), this.fki);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fki, R.color.cp_cont_b, 2, i);
        com.baidu.tbadk.core.util.e.a.bpo().aQ(R.color.cp_bg_line_j, i).oZ(0).Z(l.getDimens(getContext(), R.dimen.tbds21)).bg(this.fki);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h, i);
        ap.setBackgroundColor(this, R.color.cp_bg_line_h, i);
        this.fkk.changeSkinType(i);
        if (i == 0) {
            g(this.fki, R.drawable.edittext_cursor);
            this.fki.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        } else {
            g(this.fki, R.drawable.edittext_cursor_1);
            this.fki.setHintTextColor(ap.getColor(i, R.color.cp_cont_d));
        }
        this.fkj.changeSkinType(i);
        ap.setViewTextColor(this.epn, R.color.cp_cont_d, 1, i);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fki.getSelectionStart() > 0) {
                        String substring = this.fki.getText().toString().substring(0, this.fki.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.f3int.matcher(substring);
                        if (matcher.find()) {
                            this.fki.getText().delete(this.fki.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fki.getSelectionStart());
                            break;
                        } else {
                            this.fki.getText().delete(this.fki.getSelectionStart() - 1, this.fki.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fki.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fki.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fki.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fki.setSelection(PbNewInputContainer.this.fki.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fkn = null;
                        if (this.fko != null) {
                            this.fki.setHint(this.fko);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fkL) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fki.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fkL)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fkL, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fkn = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fki.setText("");
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
                                        PbNewInputContainer.this.fki.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fki.setSelection(PbNewInputContainer.this.fki.getText().length());
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
                        this.fkm = null;
                        this.fkn = null;
                        this.fki.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fkq[0] = 0;
                    this.fkq[1] = 0;
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
                        if (aVar2.fiF != null) {
                            if (aVar2.fiF.getChosedFiles() != null) {
                                this.fkq[0] = aVar2.fiF.getChosedFiles().size();
                            } else {
                                this.fkq[0] = 0;
                            }
                        }
                        if (this.fkq[0] > 0) {
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
                    int[] iArr = this.fkq;
                    iArr[0] = iArr[0] - 1;
                    if (this.fkq[0] > 0) {
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
                        ke(false);
                        break;
                    } else {
                        ke(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fkk.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fkk.setText(aVar3.addr);
                            break;
                        } else {
                            this.fkk.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    ke(true);
                    this.fkk.setText(getContext().getString(R.string.location_where_are_you));
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
                            Dv((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            Dv(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.epn.setVisibility(8);
                            break;
                        } else {
                            this.epn.setVisibility(0);
                            this.epn.setText(str);
                            break;
                        }
                    } else {
                        this.epn.setVisibility(8);
                        break;
                    }
            }
            rm(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rm(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.fkj.setEnabled(true);
            } else {
                this.fkj.setEnabled(false);
            }
        } else if (i == fkr) {
            if (this.flags[1]) {
                this.fkj.setEnabled(true);
            } else {
                this.fkj.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fkp = z;
    }

    public void setHint(int i) {
        if (this.fki != null) {
            this.fki.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fki != null) {
            this.fki.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fko = str;
    }

    public EditText getInputView() {
        return this.fki;
    }

    public TBSpecificationBtn getSendView() {
        return this.fkj;
    }

    public LinearLayout getInputLayout() {
        return this.fkl;
    }

    public TextView getTitleView() {
        return this.epn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fkk) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fki != null) {
            this.fki.setTransLink(z);
        }
    }

    public void ke(boolean z) {
        if (this.fkk != null) {
            this.fkk.setVisibility(z ? 0 : 8);
        }
    }
}
