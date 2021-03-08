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
    private EditorTools ael;
    private int aem;
    private int aln;
    private TextView eIY;
    private boolean fEt;
    private boolean fEu;
    private boolean fEv;
    private int fEw;
    private TBSpecificationBtn fFA;
    private TBSpecificationBtn fFB;
    private LinearLayout fFC;
    private j fFD;
    private SpannableStringBuilder fFE;
    private String fFF;
    private boolean fFG;
    private int[] fFH;
    private Runnable fFI;
    private SpanGroupEditText fFz;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int PICTURE = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fEt = false;
        this.fEu = true;
        this.fEv = true;
        this.fEw = -1;
        this.fFG = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fFH = new int[]{0, 0};
        this.aln = 0;
        this.mType = ALL;
        this.fFI = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fFz != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fFz.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bCm();
        fk(context);
        this.fFC = new LinearLayout(getContext());
        this.fFC.setOrientation(0);
        this.fFC.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fFC, new LinearLayout.LayoutParams(-1, -2));
        fm(context);
        fl(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bCm() {
        this.eIY = new EMTextView(getContext());
        this.eIY.setId(R.id.comment_content);
        this.eIY.setVisibility(8);
        this.eIY.setMaxLines(1);
        this.eIY.setEllipsize(TextUtils.TruncateAt.END);
        this.eIY.setPadding(l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X005), l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X003));
        this.eIY.setTextSize(0, l.getDimens(getContext(), R.dimen.T_X08));
        addView(this.eIY, new LinearLayout.LayoutParams(-1, -2));
    }

    private void fk(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.pO(R.color.CAM_X0110);
        bVar.pR(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.aX(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.pQ(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X003));
        this.fFB = new TBSpecificationBtn(getContext());
        this.fFB.setLayoutParams(layoutParams);
        this.fFB.setOnClickListener(this);
        this.fFB.setConfig(bVar);
        this.fFB.setTextSize(R.dimen.T_X09);
        this.fFB.setOnClickListener(this);
        this.fFB.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fFB);
    }

    private void fl(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
        this.fFA = new TBSpecificationBtn(context);
        this.fFA.setConfig(bVar);
        this.fFA.setEnabled(false);
        this.fFA.setTextSize(R.dimen.T_X08);
        this.fFA.setText(context.getString(R.string.pb_send_post));
        this.fFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds150), l.getDimens(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        linearLayout.addView(this.fFA, layoutParams2);
        this.fFC.addView(linearLayout, layoutParams);
    }

    private void fm(Context context) {
        this.fFz = new SpanGroupEditText(context);
        this.fFz.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.fFz.setMaxLines(4);
        this.fFz.setMinLines(2);
        this.fFz.setGravity(48);
        this.fFz.setIncludeFontPadding(false);
        this.fFz.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.fFz.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.fFz.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        com.baidu.tieba.write.j.h(this.fFz, R.drawable.edittext_cursor);
        this.fFz.setLineSpacing(l.getDimens(context, R.dimen.M_T_X002), 1.0f);
        this.fFz.setPadding(l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004));
        this.fFz.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fFz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fEv) {
                    PbNewInputContainer.this.fEv = true;
                    if (PbNewInputContainer.this.fEw != -1) {
                        PbNewInputContainer.this.fFz.setSelection(PbNewInputContainer.this.fEw);
                        PbNewInputContainer.this.fEw = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fFE)) {
                        if (PbNewInputContainer.this.fFD == null) {
                            PbNewInputContainer.this.fFD = new j();
                        }
                        PbNewInputContainer.this.fFD.fGb = PbNewInputContainer.this.fFE.toString();
                        PbNewInputContainer.this.fFD.mContent = PbNewInputContainer.this.fFz.getText().toString();
                        PbNewInputContainer.this.fFD.mSpanGroupManager = PbNewInputContainer.this.fFz.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fFD));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(PbNewInputContainer.this.fFI);
                    com.baidu.adp.lib.f.e.mA().post(PbNewInputContainer.this.fFI);
                }
            }
        });
        this.fFz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fFz.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X002), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X002));
        this.fFC.addView(this.fFz, layoutParams);
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
                    this.fFz.getText().insert(this.fFz.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void CX(String str) {
        if (!StringUtils.isNull(str)) {
            this.fFz.getText().insert(this.fFz.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bwy() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bwy() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bwy() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fFz.getText().toString();
            if (this.fEu && com.baidu.tieba.face.a.JC(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brZ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fFz);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fEt || uVar.bwy() == EmotionGroupType.LOCAL) {
            String obj = this.fFz.getText().toString();
            if (this.fEu && com.baidu.tieba.face.a.JC(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brZ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fFz);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fEt = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fFz != null && this.fFC.getVisibility() == 0) {
            this.fFz.setFocusable(true);
            this.fFz.setFocusableInTouchMode(true);
            this.fFz.requestFocus();
            l.showSoftKeyPad(getContext(), this.fFz);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.fFz.setTextColor(ap.getColor(R.color.CAM_X0105));
        ap.setViewTextColor(this.fFz, R.color.CAM_X0105, 2, i);
        com.baidu.tbadk.core.util.f.a.bty().aN(R.color.CAM_X0209, i).oP(0).aj(l.getDimens(getContext(), R.dimen.tbds21)).bv(this.fFz);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207, i);
        ap.setBackgroundColor(this, R.color.CAM_X0207, i);
        if (i == 0) {
            com.baidu.tieba.write.j.h(this.fFz, R.drawable.edittext_cursor);
            this.fFz.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        } else {
            com.baidu.tieba.write.j.h(this.fFz, R.drawable.edittext_cursor_1);
            this.fFz.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        this.fFA.changeSkinType(i);
        this.fFB.changeSkinType(i);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eIY).nZ(R.color.CAM_X0109);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fFz.getSelectionStart() > 0) {
                        String substring = this.fFz.getText().toString().substring(0, this.fFz.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iUh.matcher(substring);
                        if (matcher.find()) {
                            this.fFz.getText().delete(this.fFz.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fFz.getSelectionStart());
                            break;
                        } else {
                            this.fFz.getText().delete(this.fFz.getSelectionStart() - 1, this.fFz.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fFz.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fFz.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fFz.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fFz.setSelection(PbNewInputContainer.this.fFz.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fFE = null;
                        if (this.fFF != null) {
                            this.fFz.setHint(this.fFF);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fGb) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fFz.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fGb)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fGb, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void d(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fFE = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fFz.setText("");
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
                                        PbNewInputContainer.this.fFz.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fFz.setSelection(PbNewInputContainer.this.fFz.getText().length());
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
                        this.fFD = null;
                        this.fFE = null;
                        this.fFz.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fFH[0] = 0;
                    this.fFH[1] = 0;
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
                        if (aVar2.fDU != null) {
                            if (aVar2.fDU.getChosedFiles() != null) {
                                this.fFH[0] = aVar2.fDU.getChosedFiles().size();
                            } else {
                                this.fFH[0] = 0;
                            }
                        }
                        if (this.fFH[0] > 0) {
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
                    int[] iArr = this.fFH;
                    iArr[0] = iArr[0] - 1;
                    if (this.fFH[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
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
                        la(false);
                        break;
                    } else {
                        la(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fFB.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fFB.setText(aVar3.addr);
                            break;
                        } else {
                            this.fFB.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    la(true);
                    this.fFB.setText(getContext().getString(R.string.location_where_are_you));
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
                            CX((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            CX(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.eIY.setVisibility(8);
                            break;
                        } else {
                            this.eIY.setVisibility(0);
                            this.eIY.setText(str);
                            break;
                        }
                    } else {
                        this.eIY.setVisibility(8);
                        break;
                    }
            }
            rh(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rh(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.fFA.setEnabled(true);
            } else {
                this.fFA.setEnabled(false);
            }
        } else if (i == PICTURE) {
            if (this.flags[1]) {
                this.fFA.setEnabled(true);
            } else {
                this.fFA.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fFG = z;
    }

    public void setHint(int i) {
        if (this.fFz != null) {
            this.fFz.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fFz != null) {
            this.fFz.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fFF = str;
    }

    public EditText getInputView() {
        return this.fFz;
    }

    public TBSpecificationBtn getSendView() {
        return this.fFA;
    }

    public LinearLayout getInputLayout() {
        return this.fFC;
    }

    public TextView getTitleView() {
        return this.eIY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fFB) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fFz != null) {
            this.fFz.setTransLink(z);
        }
    }

    public void la(boolean z) {
        if (this.fFB != null) {
            this.fFB.setVisibility(z ? 0 : 8);
        }
    }
}
