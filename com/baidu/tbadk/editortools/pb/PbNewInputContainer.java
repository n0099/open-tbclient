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
    private EditorTools acZ;
    private int ada;
    private int akW;
    private TextView eKc;
    private boolean fFn;
    private boolean fFo;
    private boolean fFp;
    private int fFq;
    private boolean[] fGA;
    private int[] fGB;
    private Runnable fGD;
    private SpanGroupEditText fGs;
    private TBSpecificationBtn fGt;
    private TBSpecificationBtn fGu;
    private LinearLayout fGv;
    private j fGw;
    private SpannableStringBuilder fGx;
    private String fGy;
    private boolean fGz;
    private View mBottomLine;
    private int mType;
    public static int fGC = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFn = false;
        this.fFo = true;
        this.fFp = true;
        this.fFq = -1;
        this.fGz = true;
        this.fGA = new boolean[]{false, false, false, false, false};
        this.fGB = new int[]{0, 0};
        this.akW = 0;
        this.mType = ALL;
        this.fGD = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fGs != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fGs.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bFK();
        fo(context);
        this.fGv = new LinearLayout(getContext());
        this.fGv.setOrientation(0);
        this.fGv.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fGv, new LinearLayout.LayoutParams(-1, -2));
        fq(context);
        fp(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bFK() {
        this.eKc = new EMTextView(getContext());
        this.eKc.setId(R.id.comment_content);
        this.eKc.setVisibility(8);
        this.eKc.setMaxLines(1);
        this.eKc.setEllipsize(TextUtils.TruncateAt.END);
        this.eKc.setPadding(l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X005), l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X003));
        this.eKc.setTextSize(0, l.getDimens(getContext(), R.dimen.T_X08));
        addView(this.eKc, new LinearLayout.LayoutParams(-1, -2));
    }

    private void fo(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.ro(R.color.CAM_X0110);
        bVar.rr(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.ba(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.rq(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X003));
        this.fGu = new TBSpecificationBtn(getContext());
        this.fGu.setLayoutParams(layoutParams);
        this.fGu.setOnClickListener(this);
        this.fGu.setConfig(bVar);
        this.fGu.setTextSize(R.dimen.T_X09);
        this.fGu.setOnClickListener(this);
        this.fGu.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fGu);
    }

    private void fp(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.bb(R.color.CAM_X0302, R.color.CAM_X0101);
        this.fGt = new TBSpecificationBtn(context);
        this.fGt.setConfig(bVar);
        this.fGt.setEnabled(false);
        this.fGt.setTextSize(R.dimen.T_X08);
        this.fGt.setText(context.getString(R.string.pb_send_post));
        this.fGt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds150), l.getDimens(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        linearLayout.addView(this.fGt, layoutParams2);
        this.fGv.addView(linearLayout, layoutParams);
    }

    private void fq(Context context) {
        this.fGs = new SpanGroupEditText(context);
        this.fGs.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.fGs.setMaxLines(4);
        this.fGs.setMinLines(2);
        this.fGs.setGravity(48);
        this.fGs.setIncludeFontPadding(false);
        this.fGs.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.fGs.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.fGs.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        com.baidu.tieba.write.j.h(this.fGs, R.drawable.edittext_cursor);
        this.fGs.setLineSpacing(l.getDimens(context, R.dimen.M_T_X002), 1.0f);
        this.fGs.setPadding(l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004));
        this.fGs.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fGs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fFp) {
                    PbNewInputContainer.this.fFp = true;
                    if (PbNewInputContainer.this.fFq != -1) {
                        PbNewInputContainer.this.fGs.setSelection(PbNewInputContainer.this.fFq);
                        PbNewInputContainer.this.fFq = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fGx)) {
                        if (PbNewInputContainer.this.fGw == null) {
                            PbNewInputContainer.this.fGw = new j();
                        }
                        PbNewInputContainer.this.fGw.fGW = PbNewInputContainer.this.fGx.toString();
                        PbNewInputContainer.this.fGw.mContent = PbNewInputContainer.this.fGs.getText().toString();
                        PbNewInputContainer.this.fGw.mSpanGroupManager = PbNewInputContainer.this.fGs.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fGw));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mB().removeCallbacks(PbNewInputContainer.this.fGD);
                    com.baidu.adp.lib.f.e.mB().post(PbNewInputContainer.this.fGD);
                }
            }
        });
        this.fGs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fGs.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X002), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X002));
        this.fGv.addView(this.fGs, layoutParams);
    }

    private void M(ArrayList<String> arrayList) {
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
                    this.fGs.getText().insert(this.fGs.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void DM(String str) {
        if (!StringUtils.isNull(str)) {
            this.fGs.getText().insert(this.fGs.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bzX() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bzX() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bzX() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fGs.getText().toString();
            if (this.fFo && com.baidu.tieba.face.a.JS(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bvz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fGs);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fFn || uVar.bzX() == EmotionGroupType.LOCAL) {
            String obj = this.fGs.getText().toString();
            if (this.fFo && com.baidu.tieba.face.a.JS(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bvz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fGs);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fFn = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.fGs != null && this.fGv.getVisibility() == 0) {
            this.fGs.setFocusable(true);
            this.fGs.setFocusableInTouchMode(true);
            this.fGs.requestFocus();
            l.showSoftKeyPad(getContext(), this.fGs);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.fGs.setTextColor(ao.getColor(R.color.CAM_X0105));
        ao.setViewTextColor(this.fGs, R.color.CAM_X0105, 2, i);
        com.baidu.tbadk.core.util.f.a.bwV().aQ(R.color.CAM_X0209, i).qq(0).ae(l.getDimens(getContext(), R.dimen.tbds21)).bz(this.fGs);
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207, i);
        ao.setBackgroundColor(this, R.color.CAM_X0207, i);
        if (i == 0) {
            com.baidu.tieba.write.j.h(this.fGs, R.drawable.edittext_cursor);
            this.fGs.setHintTextColor(ao.getColor(i, R.color.CAM_X0109));
        } else {
            com.baidu.tieba.write.j.h(this.fGs, R.drawable.edittext_cursor_1);
            this.fGs.setHintTextColor(ao.getColor(i, R.color.CAM_X0109));
        }
        this.fGt.changeSkinType(i);
        this.fGu.changeSkinType(i);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.eKc).pC(R.color.CAM_X0109);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fGs.getSelectionStart() > 0) {
                        String substring = this.fGs.getText().toString().substring(0, this.fGs.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iRk.matcher(substring);
                        if (matcher.find()) {
                            this.fGs.getText().delete(this.fGs.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fGs.getSelectionStart());
                            break;
                        } else {
                            this.fGs.getText().delete(this.fGs.getSelectionStart() - 1, this.fGs.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fGs.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fGs.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fGs.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fGs.setSelection(PbNewInputContainer.this.fGs.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fGx = null;
                        if (this.fGy != null) {
                            this.fGs.setHint(this.fGy);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fGW) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fGs.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fGW)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fGW, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void d(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fGx = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fGs.setText("");
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
                                        PbNewInputContainer.this.fGs.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fGs.setSelection(PbNewInputContainer.this.fGs.getText().length());
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
                        this.fGA[0] = false;
                        break;
                    } else {
                        this.fGA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fGw = null;
                        this.fGx = null;
                        this.fGs.setText((CharSequence) null);
                    }
                    this.fGA[0] = false;
                    this.fGA[1] = false;
                    this.fGA[2] = false;
                    this.fGA[3] = false;
                    this.fGA[4] = false;
                    this.fGB[0] = 0;
                    this.fGB[1] = 0;
                    break;
                case 10:
                    this.fGA[2] = true;
                    break;
                case 11:
                    this.fGA[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fEO != null) {
                            if (aVar2.fEO.getChosedFiles() != null) {
                                this.fGB[0] = aVar2.fEO.getChosedFiles().size();
                            } else {
                                this.fGB[0] = 0;
                            }
                        }
                        if (this.fGB[0] > 0) {
                            this.fGA[1] = true;
                            break;
                        } else {
                            this.fGA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fGB;
                    iArr[0] = iArr[0] - 1;
                    if (this.fGB[0] > 0) {
                        this.fGA[1] = true;
                        break;
                    } else {
                        this.fGA[1] = false;
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
                        lb(false);
                        break;
                    } else {
                        lb(true);
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.state == 1) {
                            this.fGu.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fGu.setText(aVar3.addr);
                            break;
                        } else {
                            this.fGu.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    lb(true);
                    this.fGu.setText(getContext().getString(R.string.location_where_are_you));
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.fGA[3] = true;
                    break;
                case 29:
                    this.fGA[3] = false;
                    break;
                case 44:
                    if (aVar.data != null) {
                        if (aVar.data instanceof String) {
                            DM((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            DM(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.eKc.setVisibility(8);
                            break;
                        } else {
                            this.eKc.setVisibility(0);
                            this.eKc.setText(str);
                            break;
                        }
                    } else {
                        this.eKc.setVisibility(8);
                        break;
                    }
            }
            sH(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void sH(int i) {
        if (i == ALL) {
            if (this.fGA[0] || this.fGA[1] || this.fGA[2] || this.fGA[3] || this.fGA[4]) {
                this.fGt.setEnabled(true);
            } else {
                this.fGt.setEnabled(false);
            }
        } else if (i == fGC) {
            if (this.fGA[1]) {
                this.fGt.setEnabled(true);
            } else {
                this.fGt.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fGz = z;
    }

    public void setHint(int i) {
        if (this.fGs != null) {
            this.fGs.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fGs != null) {
            this.fGs.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fGy = str;
    }

    public EditText getInputView() {
        return this.fGs;
    }

    public TBSpecificationBtn getSendView() {
        return this.fGt;
    }

    public LinearLayout getInputLayout() {
        return this.fGv;
    }

    public TextView getTitleView() {
        return this.eKc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGu) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fGs != null) {
            this.fGs.setTransLink(z);
        }
    }

    public void lb(boolean z) {
        if (this.fGu != null) {
            this.fGu.setVisibility(z ? 0 : 8);
        }
    }
}
