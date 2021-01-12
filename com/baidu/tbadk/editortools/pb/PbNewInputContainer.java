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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
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
    private EditorTools acX;
    private int acY;
    private int akf;
    private TextView eFr;
    private boolean fAF;
    private boolean fAG;
    private boolean fAH;
    private int fAI;
    private SpanGroupEditText fBL;
    private TBSpecificationBtn fBM;
    private TBSpecificationBtn fBN;
    private LinearLayout fBO;
    private j fBP;
    private SpannableStringBuilder fBQ;
    private String fBR;
    private boolean fBS;
    private boolean[] fBT;
    private int[] fBU;
    private Runnable fBW;
    private View mBottomLine;
    private int mType;
    public static int fBV = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAF = false;
        this.fAG = true;
        this.fAH = true;
        this.fAI = -1;
        this.fBS = true;
        this.fBT = new boolean[]{false, false, false, false, false};
        this.fBU = new int[]{0, 0};
        this.akf = 0;
        this.mType = ALL;
        this.fBW = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fBL != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fBL.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bBR();
        fm(context);
        this.fBO = new LinearLayout(getContext());
        this.fBO.setOrientation(0);
        this.fBO.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fBO, new LinearLayout.LayoutParams(-1, -2));
        fo(context);
        fn(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bBR() {
        this.eFr = new EMTextView(getContext());
        this.eFr.setId(R.id.comment_content);
        this.eFr.setVisibility(8);
        this.eFr.setMaxLines(1);
        this.eFr.setEllipsize(TextUtils.TruncateAt.END);
        this.eFr.setPadding(l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X005), l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X003));
        this.eFr.setTextSize(0, l.getDimens(getContext(), R.dimen.T_X08));
        addView(this.eFr, new LinearLayout.LayoutParams(-1, -2));
    }

    private void fm(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.pI(R.color.CAM_X0110);
        bVar.pL(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.ba(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.pK(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X003));
        this.fBN = new TBSpecificationBtn(getContext());
        this.fBN.setLayoutParams(layoutParams);
        this.fBN.setOnClickListener(this);
        this.fBN.setConfig(bVar);
        this.fBN.setTextSize(R.dimen.T_X09);
        this.fBN.setOnClickListener(this);
        this.fBN.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fBN);
    }

    private void fn(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
        this.fBM = new TBSpecificationBtn(context);
        this.fBM.setConfig(bVar);
        this.fBM.setEnabled(false);
        this.fBM.setTextSize(R.dimen.T_X08);
        this.fBM.setText(context.getString(R.string.pb_send_post));
        this.fBM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds150), l.getDimens(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        linearLayout.addView(this.fBM, layoutParams2);
        this.fBO.addView(linearLayout, layoutParams);
    }

    private void fo(Context context) {
        this.fBL = new SpanGroupEditText(context);
        this.fBL.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.fBL.setMaxLines(4);
        this.fBL.setMinLines(2);
        this.fBL.setGravity(48);
        this.fBL.setIncludeFontPadding(false);
        this.fBL.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.fBL.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.fBL.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        com.baidu.tieba.write.j.h(this.fBL, R.drawable.edittext_cursor);
        this.fBL.setLineSpacing(l.getDimens(context, R.dimen.M_T_X002), 1.0f);
        this.fBL.setPadding(l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004));
        this.fBL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fBL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fAH) {
                    PbNewInputContainer.this.fAH = true;
                    if (PbNewInputContainer.this.fAI != -1) {
                        PbNewInputContainer.this.fBL.setSelection(PbNewInputContainer.this.fAI);
                        PbNewInputContainer.this.fAI = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fBQ)) {
                        if (PbNewInputContainer.this.fBP == null) {
                            PbNewInputContainer.this.fBP = new j();
                        }
                        PbNewInputContainer.this.fBP.fCp = PbNewInputContainer.this.fBQ.toString();
                        PbNewInputContainer.this.fBP.mContent = PbNewInputContainer.this.fBL.getText().toString();
                        PbNewInputContainer.this.fBP.mSpanGroupManager = PbNewInputContainer.this.fBL.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fBP));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(PbNewInputContainer.this.fBW);
                    com.baidu.adp.lib.f.e.mB().post(PbNewInputContainer.this.fBW);
                }
            }
        });
        this.fBL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fBL.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X002), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X002));
        this.fBO.addView(this.fBL, layoutParams);
    }

    private void H(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.fBL.getText().insert(this.fBL.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void CB(String str) {
        if (!StringUtils.isNull(str)) {
            this.fBL.getText().insert(this.fBL.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bwd() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bwd() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bwd() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fBL.getText().toString();
            if (this.fAG && com.baidu.tieba.face.a.IH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brF().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fBL);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fAF || uVar.bwd() == EmotionGroupType.LOCAL) {
            String obj = this.fBL.getText().toString();
            if (this.fAG && com.baidu.tieba.face.a.IH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brF().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fBL);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fAF = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.fBL != null && this.fBO.getVisibility() == 0) {
            this.fBL.setFocusable(true);
            this.fBL.setFocusableInTouchMode(true);
            this.fBL.requestFocus();
            l.showSoftKeyPad(getContext(), this.fBL);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.fBL.setTextColor(ao.getColor(R.color.CAM_X0105));
        ao.setViewTextColor(this.fBL, R.color.CAM_X0105, 2, i);
        com.baidu.tbadk.core.util.f.a.btb().aQ(R.color.CAM_X0209, i).oJ(0).ae(l.getDimens(getContext(), R.dimen.tbds21)).bz(this.fBL);
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207, i);
        ao.setBackgroundColor(this, R.color.CAM_X0207, i);
        if (i == 0) {
            com.baidu.tieba.write.j.h(this.fBL, R.drawable.edittext_cursor);
            this.fBL.setHintTextColor(ao.getColor(i, R.color.CAM_X0109));
        } else {
            com.baidu.tieba.write.j.h(this.fBL, R.drawable.edittext_cursor_1);
            this.fBL.setHintTextColor(ao.getColor(i, R.color.CAM_X0109));
        }
        this.fBM.changeSkinType(i);
        this.fBN.changeSkinType(i);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eFr).nV(R.color.CAM_X0109);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fBL.getSelectionStart() > 0) {
                        String substring = this.fBL.getText().toString().substring(0, this.fBL.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iMD.matcher(substring);
                        if (matcher.find()) {
                            this.fBL.getText().delete(this.fBL.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fBL.getSelectionStart());
                            break;
                        } else {
                            this.fBL.getText().delete(this.fBL.getSelectionStart() - 1, this.fBL.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fBL.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fBL.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fBL.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fBL.setSelection(PbNewInputContainer.this.fBL.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fBQ = null;
                        if (this.fBR != null) {
                            this.fBL.setHint(this.fBR);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fCp) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fBL.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fCp)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fCp, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void d(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fBQ = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fBL.setText("");
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
                                        PbNewInputContainer.this.fBL.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fBL.setSelection(PbNewInputContainer.this.fBL.getText().length());
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
                        this.fBT[0] = false;
                        break;
                    } else {
                        this.fBT[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fBP = null;
                        this.fBQ = null;
                        this.fBL.setText((CharSequence) null);
                    }
                    this.fBT[0] = false;
                    this.fBT[1] = false;
                    this.fBT[2] = false;
                    this.fBT[3] = false;
                    this.fBT[4] = false;
                    this.fBU[0] = 0;
                    this.fBU[1] = 0;
                    break;
                case 10:
                    this.fBT[2] = true;
                    break;
                case 11:
                    this.fBT[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fAg != null) {
                            if (aVar2.fAg.getChosedFiles() != null) {
                                this.fBU[0] = aVar2.fAg.getChosedFiles().size();
                            } else {
                                this.fBU[0] = 0;
                            }
                        }
                        if (this.fBU[0] > 0) {
                            this.fBT[1] = true;
                            break;
                        } else {
                            this.fBT[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fBU;
                    iArr[0] = iArr[0] - 1;
                    if (this.fBU[0] > 0) {
                        this.fBT[1] = true;
                        break;
                    } else {
                        this.fBT[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        H((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        kX(false);
                        break;
                    } else {
                        kX(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fBN.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fBN.setText(aVar3.addr);
                            break;
                        } else {
                            this.fBN.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    kX(true);
                    this.fBN.setText(getContext().getString(R.string.location_where_are_you));
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.fBT[3] = true;
                    break;
                case 29:
                    this.fBT[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            CB((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            CB(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.eFr.setVisibility(8);
                            break;
                        } else {
                            this.eFr.setVisibility(0);
                            this.eFr.setText(str);
                            break;
                        }
                    } else {
                        this.eFr.setVisibility(8);
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
            if (this.fBT[0] || this.fBT[1] || this.fBT[2] || this.fBT[3] || this.fBT[4]) {
                this.fBM.setEnabled(true);
            } else {
                this.fBM.setEnabled(false);
            }
        } else if (i == fBV) {
            if (this.fBT[1]) {
                this.fBM.setEnabled(true);
            } else {
                this.fBM.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fBS = z;
    }

    public void setHint(int i) {
        if (this.fBL != null) {
            this.fBL.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fBL != null) {
            this.fBL.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fBR = str;
    }

    public EditText getInputView() {
        return this.fBL;
    }

    public TBSpecificationBtn getSendView() {
        return this.fBM;
    }

    public LinearLayout getInputLayout() {
        return this.fBO;
    }

    public TextView getTitleView() {
        return this.eFr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBN) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fBL != null) {
            this.fBL.setTransLink(z);
        }
    }

    public void kX(boolean z) {
        if (this.fBN != null) {
            this.fBN.setVisibility(z ? 0 : 8);
        }
    }
}
