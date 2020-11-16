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
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
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
    private EditorTools abp;
    private int abq;
    private int ajv;
    private TextView etx;
    private boolean[] flags;
    private boolean fod;
    private boolean foe;
    private boolean fof;
    private int fog;
    private SpanGroupEditText fph;
    private TBSpecificationBtn fpi;
    private TBSpecificationBtn fpj;
    private LinearLayout fpk;
    private j fpl;
    private SpannableStringBuilder fpm;
    private String fpn;
    private boolean fpo;
    private int[] fpp;
    private Runnable fpr;
    private View mBottomLine;
    private int mType;
    public static int fpq = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fod = false;
        this.foe = true;
        this.fof = true;
        this.fog = -1;
        this.fpo = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fpp = new int[]{0, 0};
        this.ajv = 0;
        this.mType = ALL;
        this.fpr = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fph != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fph.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bzO();
        en(context);
        this.fpk = new LinearLayout(getContext());
        this.fpk.setOrientation(0);
        this.fpk.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fpk, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bzO() {
        this.etx = new EMTextView(getContext());
        this.etx.setId(R.id.comment_content);
        this.etx.setVisibility(8);
        this.etx.setMaxLines(1);
        this.etx.setEllipsize(TextUtils.TruncateAt.END);
        this.etx.setPadding(l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X005), l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X003));
        this.etx.setTextSize(0, l.getDimens(getContext(), R.dimen.T_X08));
        addView(this.etx, new LinearLayout.LayoutParams(-1, -2));
    }

    private void en(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.qC(R.color.CAM_X0110);
        bVar.qF(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.ba(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.qE(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.qB(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X003));
        this.fpj = new TBSpecificationBtn(getContext());
        this.fpj.setLayoutParams(layoutParams);
        this.fpj.setOnClickListener(this);
        this.fpj.setConfig(bVar);
        this.fpj.setTextSize(R.dimen.T_X09);
        this.fpj.setOnClickListener(this);
        this.fpj.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fpj);
    }

    private void eo(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
        this.fpi = new TBSpecificationBtn(context);
        this.fpi.setConfig(bVar);
        this.fpi.setEnabled(false);
        this.fpi.setTextSize(R.dimen.T_X08);
        this.fpi.setText(context.getString(R.string.pb_send_post));
        this.fpi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds150), l.getDimens(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        linearLayout.addView(this.fpi, layoutParams2);
        this.fpk.addView(linearLayout, layoutParams);
    }

    private void ep(Context context) {
        this.fph = new SpanGroupEditText(context);
        this.fph.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.fph.setMaxLines(4);
        this.fph.setMinLines(2);
        this.fph.setGravity(48);
        this.fph.setIncludeFontPadding(false);
        this.fph.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.fph.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fph.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        g(this.fph, R.drawable.edittext_cursor);
        this.fph.setLineSpacing(l.getDimens(context, R.dimen.M_T_X002), 1.0f);
        this.fph.setPadding(l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004));
        this.fph.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fph.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fof) {
                    PbNewInputContainer.this.fof = true;
                    if (PbNewInputContainer.this.fog != -1) {
                        PbNewInputContainer.this.fph.setSelection(PbNewInputContainer.this.fog);
                        PbNewInputContainer.this.fog = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fpm)) {
                        if (PbNewInputContainer.this.fpl == null) {
                            PbNewInputContainer.this.fpl = new j();
                        }
                        PbNewInputContainer.this.fpl.fpL = PbNewInputContainer.this.fpm.toString();
                        PbNewInputContainer.this.fpl.mContent = PbNewInputContainer.this.fph.getText().toString();
                        PbNewInputContainer.this.fpl.mSpanGroupManager = PbNewInputContainer.this.fph.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fpl));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(PbNewInputContainer.this.fpr);
                    com.baidu.adp.lib.f.e.mY().post(PbNewInputContainer.this.fpr);
                }
            }
        });
        this.fph.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fph.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X002), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X002));
        this.fpk.addView(this.fph, layoutParams);
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
                    this.fph.getText().insert(this.fph.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void Di(String str) {
        if (!StringUtils.isNull(str)) {
            this.fph.getText().insert(this.fph.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).buc() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).buc() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.buc() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fph.getText().toString();
            if (this.foe && com.baidu.tieba.face.a.Jf(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bpC().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fph);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fod || uVar.buc() == EmotionGroupType.LOCAL) {
            String obj = this.fph.getText().toString();
            if (this.foe && com.baidu.tieba.face.a.Jf(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bpC().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fph);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fod = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abq;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fph != null && this.fpk.getVisibility() == 0) {
            this.fph.setFocusable(true);
            this.fph.setFocusableInTouchMode(true);
            this.fph.requestFocus();
            l.showSoftKeyPad(getContext(), this.fph);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fph, R.color.CAM_X0105, 2, i);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.fph).pb(R.string.J_X05).setBackGroundColor(R.color.CAM_X0209);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.mBottomLine).setBackGroundColor(R.color.CAM_X0207);
        com.baidu.tbadk.core.elementsMaven.c.bj(this).setBackGroundColor(R.color.CAM_X0207);
        if (i == 0) {
            g(this.fph, R.drawable.edittext_cursor);
            this.fph.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        } else {
            g(this.fph, R.drawable.edittext_cursor_1);
            this.fph.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        this.fpi.changeSkinType(i);
        this.fpj.brT();
        com.baidu.tbadk.core.elementsMaven.c.bj(this.etx).oT(R.color.CAM_X0109);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fph.getSelectionStart() > 0) {
                        String substring = this.fph.getText().toString().substring(0, this.fph.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iue.matcher(substring);
                        if (matcher.find()) {
                            this.fph.getText().delete(this.fph.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fph.getSelectionStart());
                            break;
                        } else {
                            this.fph.getText().delete(this.fph.getSelectionStart() - 1, this.fph.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fph.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fph.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fph.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fph.setSelection(PbNewInputContainer.this.fph.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fpm = null;
                        if (this.fpn != null) {
                            this.fph.setHint(this.fpn);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fpL) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fph.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fpL)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fpL, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void b(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fpm = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fph.setText("");
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
                                        PbNewInputContainer.this.fph.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fph.setSelection(PbNewInputContainer.this.fph.getText().length());
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
                        this.fpl = null;
                        this.fpm = null;
                        this.fph.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fpp[0] = 0;
                    this.fpp[1] = 0;
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
                        if (aVar2.fnE != null) {
                            if (aVar2.fnE.getChosedFiles() != null) {
                                this.fpp[0] = aVar2.fnE.getChosedFiles().size();
                            } else {
                                this.fpp[0] = 0;
                            }
                        }
                        if (this.fpp[0] > 0) {
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
                    int[] iArr = this.fpp;
                    iArr[0] = iArr[0] - 1;
                    if (this.fpp[0] > 0) {
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
                        ko(false);
                        break;
                    } else {
                        ko(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fpj.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fpj.setText(aVar3.addr);
                            break;
                        } else {
                            this.fpj.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    ko(true);
                    this.fpj.setText(getContext().getString(R.string.location_where_are_you));
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
                            Di((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            Di(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.etx.setVisibility(8);
                            break;
                        } else {
                            this.etx.setVisibility(0);
                            this.etx.setText(str);
                            break;
                        }
                    } else {
                        this.etx.setVisibility(8);
                        break;
                    }
            }
            rU(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rU(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.fpi.setEnabled(true);
            } else {
                this.fpi.setEnabled(false);
            }
        } else if (i == fpq) {
            if (this.flags[1]) {
                this.fpi.setEnabled(true);
            } else {
                this.fpi.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fpo = z;
    }

    public void setHint(int i) {
        if (this.fph != null) {
            this.fph.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fph != null) {
            this.fph.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fpn = str;
    }

    public EditText getInputView() {
        return this.fph;
    }

    public TBSpecificationBtn getSendView() {
        return this.fpi;
    }

    public LinearLayout getInputLayout() {
        return this.fpk;
    }

    public TextView getTitleView() {
        return this.etx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fpj) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fph != null) {
            this.fph.setTransLink(z);
        }
    }

    public void ko(boolean z) {
        if (this.fpj != null) {
            this.fpj.setVisibility(z ? 0 : 8);
        }
    }
}
