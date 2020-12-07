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
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools acn;
    private int aco;
    private int aku;
    private TextView eAz;
    private boolean fvH;
    private boolean fvI;
    private boolean fvJ;
    private int fvK;
    private SpanGroupEditText fwM;
    private TBSpecificationBtn fwN;
    private TBSpecificationBtn fwO;
    private LinearLayout fwP;
    private j fwQ;
    private SpannableStringBuilder fwR;
    private String fwS;
    private boolean fwT;
    private boolean[] fwU;
    private int[] fwV;
    private Runnable fwX;
    private View mBottomLine;
    private int mType;
    public static int fwW = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvH = false;
        this.fvI = true;
        this.fvJ = true;
        this.fvK = -1;
        this.fwT = true;
        this.fwU = new boolean[]{false, false, false, false, false};
        this.fwV = new int[]{0, 0};
        this.aku = 0;
        this.mType = ALL;
        this.fwX = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fwM != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fwM.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bDo();
        eS(context);
        this.fwP = new LinearLayout(getContext());
        this.fwP.setOrientation(0);
        this.fwP.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fwP, new LinearLayout.LayoutParams(-1, -2));
        eU(context);
        eT(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bDo() {
        this.eAz = new EMTextView(getContext());
        this.eAz.setId(R.id.comment_content);
        this.eAz.setVisibility(8);
        this.eAz.setMaxLines(1);
        this.eAz.setEllipsize(TextUtils.TruncateAt.END);
        this.eAz.setPadding(l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X005), l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X003));
        this.eAz.setTextSize(0, l.getDimens(getContext(), R.dimen.T_X08));
        addView(this.eAz, new LinearLayout.LayoutParams(-1, -2));
    }

    private void eS(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.rd(R.color.CAM_X0110);
        bVar.rg(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.bc(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rf(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.rc(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X003));
        this.fwO = new TBSpecificationBtn(getContext());
        this.fwO.setLayoutParams(layoutParams);
        this.fwO.setOnClickListener(this);
        this.fwO.setConfig(bVar);
        this.fwO.setTextSize(R.dimen.T_X09);
        this.fwO.setOnClickListener(this);
        this.fwO.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fwO);
    }

    private void eT(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bd(R.color.CAM_X0302, R.color.CAM_X0101);
        this.fwN = new TBSpecificationBtn(context);
        this.fwN.setConfig(bVar);
        this.fwN.setEnabled(false);
        this.fwN.setTextSize(R.dimen.T_X08);
        this.fwN.setText(context.getString(R.string.pb_send_post));
        this.fwN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds150), l.getDimens(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        linearLayout.addView(this.fwN, layoutParams2);
        this.fwP.addView(linearLayout, layoutParams);
    }

    private void eU(Context context) {
        this.fwM = new SpanGroupEditText(context);
        this.fwM.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.fwM.setMaxLines(4);
        this.fwM.setMinLines(2);
        this.fwM.setGravity(48);
        this.fwM.setIncludeFontPadding(false);
        this.fwM.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.fwM.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.fwM.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        com.baidu.tieba.write.j.h(this.fwM, R.drawable.edittext_cursor);
        this.fwM.setLineSpacing(l.getDimens(context, R.dimen.M_T_X002), 1.0f);
        this.fwM.setPadding(l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004));
        this.fwM.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fwM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fvJ) {
                    PbNewInputContainer.this.fvJ = true;
                    if (PbNewInputContainer.this.fvK != -1) {
                        PbNewInputContainer.this.fwM.setSelection(PbNewInputContainer.this.fvK);
                        PbNewInputContainer.this.fvK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fwR)) {
                        if (PbNewInputContainer.this.fwQ == null) {
                            PbNewInputContainer.this.fwQ = new j();
                        }
                        PbNewInputContainer.this.fwQ.fxq = PbNewInputContainer.this.fwR.toString();
                        PbNewInputContainer.this.fwQ.mContent = PbNewInputContainer.this.fwM.getText().toString();
                        PbNewInputContainer.this.fwQ.mSpanGroupManager = PbNewInputContainer.this.fwM.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fwQ));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mY().removeCallbacks(PbNewInputContainer.this.fwX);
                    com.baidu.adp.lib.f.e.mY().post(PbNewInputContainer.this.fwX);
                }
            }
        });
        this.fwM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fwM.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X002), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X002));
        this.fwP.addView(this.fwM, layoutParams);
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
                    this.fwM.getText().insert(this.fwM.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void DQ(String str) {
        if (!StringUtils.isNull(str)) {
            this.fwM.getText().insert(this.fwM.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bxC() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bxC() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bxC() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fwM.getText().toString();
            if (this.fvI && com.baidu.tieba.face.a.JV(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bsW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fwM);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fvH || uVar.bxC() == EmotionGroupType.LOCAL) {
            String obj = this.fwM.getText().toString();
            if (this.fvI && com.baidu.tieba.face.a.JV(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bsW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fwM);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fvH = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        if (this.fwM != null && this.fwP.getVisibility() == 0) {
            this.fwM.setFocusable(true);
            this.fwM.setFocusableInTouchMode(true);
            this.fwM.requestFocus();
            l.showSoftKeyPad(getContext(), this.fwM);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.fwM.setTextColor(ap.getColor(R.color.CAM_X0105));
        com.baidu.tbadk.core.elementsMaven.c.bm(this.fwM).pA(R.string.J_X05).setBackGroundColor(R.color.CAM_X0209);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.mBottomLine).setBackGroundColor(R.color.CAM_X0207);
        com.baidu.tbadk.core.elementsMaven.c.bm(this).setBackGroundColor(R.color.CAM_X0207);
        if (i == 0) {
            com.baidu.tieba.write.j.h(this.fwM, R.drawable.edittext_cursor);
            this.fwM.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        } else {
            com.baidu.tieba.write.j.h(this.fwM, R.drawable.edittext_cursor_1);
            this.fwM.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        this.fwN.changeSkinType(i);
        this.fwO.bvt();
        com.baidu.tbadk.core.elementsMaven.c.bm(this.eAz).ps(R.color.CAM_X0109);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fwM.getSelectionStart() > 0) {
                        String substring = this.fwM.getText().toString().substring(0, this.fwM.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iEW.matcher(substring);
                        if (matcher.find()) {
                            this.fwM.getText().delete(this.fwM.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fwM.getSelectionStart());
                            break;
                        } else {
                            this.fwM.getText().delete(this.fwM.getSelectionStart() - 1, this.fwM.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fwM.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fwM.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fwM.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fwM.setSelection(PbNewInputContainer.this.fwM.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fwR = null;
                        if (this.fwS != null) {
                            this.fwM.setHint(this.fwS);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fxq) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fwM.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fxq)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fxq, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void d(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fwR = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fwM.setText("");
                                            PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                            PbNewInputContainer.this.requestFocus();
                                        }
                                    }
                                });
                            }
                            if (!TextUtils.isEmpty(jVar.mContent)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.mContent, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.7
                                    @Override // com.baidu.tieba.face.b.a
                                    public void d(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fwM.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fwM.setSelection(PbNewInputContainer.this.fwM.getText().length());
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
                        this.fwU[0] = false;
                        break;
                    } else {
                        this.fwU[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fwQ = null;
                        this.fwR = null;
                        this.fwM.setText((CharSequence) null);
                    }
                    this.fwU[0] = false;
                    this.fwU[1] = false;
                    this.fwU[2] = false;
                    this.fwU[3] = false;
                    this.fwU[4] = false;
                    this.fwV[0] = 0;
                    this.fwV[1] = 0;
                    break;
                case 10:
                    this.fwU[2] = true;
                    break;
                case 11:
                    this.fwU[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fvi != null) {
                            if (aVar2.fvi.getChosedFiles() != null) {
                                this.fwV[0] = aVar2.fvi.getChosedFiles().size();
                            } else {
                                this.fwV[0] = 0;
                            }
                        }
                        if (this.fwV[0] > 0) {
                            this.fwU[1] = true;
                            break;
                        } else {
                            this.fwU[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fwV;
                    iArr[0] = iArr[0] - 1;
                    if (this.fwV[0] > 0) {
                        this.fwU[1] = true;
                        break;
                    } else {
                        this.fwU[1] = false;
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
                        kF(false);
                        break;
                    } else {
                        kF(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fwO.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fwO.setText(aVar3.addr);
                            break;
                        } else {
                            this.fwO.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    kF(true);
                    this.fwO.setText(getContext().getString(R.string.location_where_are_you));
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.fwU[3] = true;
                    break;
                case 29:
                    this.fwU[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            DQ((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            DQ(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.eAz.setVisibility(8);
                            break;
                        } else {
                            this.eAz.setVisibility(0);
                            this.eAz.setText(str);
                            break;
                        }
                    } else {
                        this.eAz.setVisibility(8);
                        break;
                    }
            }
            sv(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void sv(int i) {
        if (i == ALL) {
            if (this.fwU[0] || this.fwU[1] || this.fwU[2] || this.fwU[3] || this.fwU[4]) {
                this.fwN.setEnabled(true);
            } else {
                this.fwN.setEnabled(false);
            }
        } else if (i == fwW) {
            if (this.fwU[1]) {
                this.fwN.setEnabled(true);
            } else {
                this.fwN.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fwT = z;
    }

    public void setHint(int i) {
        if (this.fwM != null) {
            this.fwM.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fwM != null) {
            this.fwM.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fwS = str;
    }

    public EditText getInputView() {
        return this.fwM;
    }

    public TBSpecificationBtn getSendView() {
        return this.fwN;
    }

    public LinearLayout getInputLayout() {
        return this.fwP;
    }

    public TextView getTitleView() {
        return this.eAz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fwO) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fwM != null) {
            this.fwM.setTransLink(z);
        }
    }

    public void kF(boolean z) {
        if (this.fwO != null) {
            this.fwO.setVisibility(z ? 0 : 8);
        }
    }
}
