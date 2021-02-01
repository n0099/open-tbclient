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
    private EditorTools acR;
    private int acS;
    private int ajU;
    private TextView eHx;
    private boolean fCU;
    private boolean fCV;
    private boolean fCW;
    private int fCX;
    private SpanGroupEditText fEa;
    private TBSpecificationBtn fEb;
    private TBSpecificationBtn fEc;
    private LinearLayout fEd;
    private j fEe;
    private SpannableStringBuilder fEf;
    private String fEg;
    private boolean fEh;
    private int[] fEi;
    private Runnable fEj;
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
        this.fCU = false;
        this.fCV = true;
        this.fCW = true;
        this.fCX = -1;
        this.fEh = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fEi = new int[]{0, 0};
        this.ajU = 0;
        this.mType = ALL;
        this.fEj = new Runnable() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (PbNewInputContainer.this.fEa != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fEa.getSpanGroupManager()));
                }
            }
        };
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        bCj();
        fl(context);
        this.fEd = new LinearLayout(getContext());
        this.fEd.setOrientation(0);
        this.fEd.setMinimumHeight(l.getDimens(context, R.dimen.tbds128));
        addView(this.fEd, new LinearLayout.LayoutParams(-1, -2));
        fn(context);
        fm(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void bCj() {
        this.eHx = new EMTextView(getContext());
        this.eHx.setId(R.id.comment_content);
        this.eHx.setVisibility(8);
        this.eHx.setMaxLines(1);
        this.eHx.setEllipsize(TextUtils.TruncateAt.END);
        this.eHx.setPadding(l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X005), l.getDimens(getContext(), R.dimen.M_W_X009), l.getDimens(getContext(), R.dimen.M_H_X003));
        this.eHx.setTextSize(0, l.getDimens(getContext(), R.dimen.T_X08));
        addView(this.eHx, new LinearLayout.LayoutParams(-1, -2));
    }

    private void fl(Context context) {
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0209, R.color.CAM_X0105);
        bVar.a(R.drawable.ic_icon_pure_post_location12, 0, TBSpecificationButtonConfig.IconType.WEBP);
        bVar.pN(R.color.CAM_X0110);
        bVar.pQ(UtilHelper.getDimenPixelSize(R.dimen.M_W_X002));
        bVar.aX(l.getDimens(getContext(), R.dimen.M_W_X004), l.getDimens(getContext(), R.dimen.M_W_X004));
        bVar.pP(l.getDimens(getContext(), R.dimen.M_H_X002));
        bVar.setIconSize(UtilHelper.getDimenPixelSize(R.dimen.tbds31));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.getDimens(getContext(), R.dimen.tbds62));
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X003));
        this.fEc = new TBSpecificationBtn(getContext());
        this.fEc.setLayoutParams(layoutParams);
        this.fEc.setOnClickListener(this);
        this.fEc.setConfig(bVar);
        this.fEc.setTextSize(R.dimen.T_X09);
        this.fEc.setOnClickListener(this);
        this.fEc.setText(getContext().getString(R.string.location_where_are_you));
        addView(this.fEc);
    }

    private void fm(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(80);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.aY(R.color.CAM_X0302, R.color.CAM_X0101);
        this.fEb = new TBSpecificationBtn(context);
        this.fEb.setConfig(bVar);
        this.fEb.setEnabled(false);
        this.fEb.setTextSize(R.dimen.T_X08);
        this.fEb.setText(context.getString(R.string.pb_send_post));
        this.fEb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(context, R.dimen.tbds150), l.getDimens(context, R.dimen.tbds75));
        layoutParams2.rightMargin = l.getDimens(context, R.dimen.M_W_X007);
        layoutParams2.bottomMargin = l.getDimens(context, R.dimen.M_H_X002);
        linearLayout.addView(this.fEb, layoutParams2);
        this.fEd.addView(linearLayout, layoutParams);
    }

    private void fn(Context context) {
        this.fEa = new SpanGroupEditText(context);
        this.fEa.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
        this.fEa.setMaxLines(4);
        this.fEa.setMinLines(2);
        this.fEa.setGravity(48);
        this.fEa.setIncludeFontPadding(false);
        this.fEa.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.T_X06));
        this.fEa.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.fEa.setHintTextColor(getResources().getColor(R.color.CAM_X0109));
        com.baidu.tieba.write.j.h(this.fEa, R.drawable.edittext_cursor);
        this.fEa.setLineSpacing(l.getDimens(context, R.dimen.M_T_X002), 1.0f);
        this.fEa.setPadding(l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X004));
        this.fEa.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fEa.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.fCW) {
                    PbNewInputContainer.this.fCW = true;
                    if (PbNewInputContainer.this.fCX != -1) {
                        PbNewInputContainer.this.fEa.setSelection(PbNewInputContainer.this.fCX);
                        PbNewInputContainer.this.fCX = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    if (!TextUtils.isEmpty(PbNewInputContainer.this.fEf)) {
                        if (PbNewInputContainer.this.fEe == null) {
                            PbNewInputContainer.this.fEe = new j();
                        }
                        PbNewInputContainer.this.fEe.fEC = PbNewInputContainer.this.fEf.toString();
                        PbNewInputContainer.this.fEe.mContent = PbNewInputContainer.this.fEa.getText().toString();
                        PbNewInputContainer.this.fEe.mSpanGroupManager = PbNewInputContainer.this.fEa.getSpanGroupManager();
                        PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.fEe));
                        return;
                    }
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(PbNewInputContainer.this.fEj);
                    com.baidu.adp.lib.f.e.mA().post(PbNewInputContainer.this.fEj);
                }
            }
        });
        this.fEa.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.fEa.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.M_W_X007), l.getDimens(context, R.dimen.M_H_X002), l.getDimens(context, R.dimen.M_W_X006), l.getDimens(context, R.dimen.M_H_X002));
        this.fEd.addView(this.fEa, layoutParams);
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
                    this.fEa.getText().insert(this.fEa.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void CS(String str) {
        if (!StringUtils.isNull(str)) {
            this.fEa.getText().insert(this.fEa.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u) && ((u) aVar.data).bwv() != EmotionGroupType.BIG_EMOTION && ((u) aVar.data).bwv() != EmotionGroupType.USER_COLLECT) {
            u uVar = (u) aVar.data;
            if (uVar.bwv() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fEa.getText().toString();
            if (this.fCV && com.baidu.tieba.face.a.Js(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fEa);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fCU || uVar.bwv() == EmotionGroupType.LOCAL) {
            String obj = this.fEa.getText().toString();
            if (this.fCV && com.baidu.tieba.face.a.Js(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fEa);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fCU = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fEa != null && this.fEd.getVisibility() == 0) {
            this.fEa.setFocusable(true);
            this.fEa.setFocusableInTouchMode(true);
            this.fEa.requestFocus();
            l.showSoftKeyPad(getContext(), this.fEa);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.fEa.setTextColor(ap.getColor(R.color.CAM_X0105));
        ap.setViewTextColor(this.fEa, R.color.CAM_X0105, 2, i);
        com.baidu.tbadk.core.util.f.a.btv().aN(R.color.CAM_X0209, i).oO(0).af(l.getDimens(getContext(), R.dimen.tbds21)).bv(this.fEa);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207, i);
        ap.setBackgroundColor(this, R.color.CAM_X0207, i);
        if (i == 0) {
            com.baidu.tieba.write.j.h(this.fEa, R.drawable.edittext_cursor);
            this.fEa.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        } else {
            com.baidu.tieba.write.j.h(this.fEa, R.drawable.edittext_cursor_1);
            this.fEa.setHintTextColor(ap.getColor(i, R.color.CAM_X0109));
        }
        this.fEb.changeSkinType(i);
        this.fEc.changeSkinType(i);
        com.baidu.tbadk.core.elementsMaven.c.br(this.eHx).nY(R.color.CAM_X0109);
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fEa.getSelectionStart() > 0) {
                        String substring = this.fEa.getText().toString().substring(0, this.fEa.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iSk.matcher(substring);
                        if (matcher.find()) {
                            this.fEa.getText().delete(this.fEa.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fEa.getSelectionStart());
                            break;
                        } else {
                            this.fEa.getText().delete(this.fEa.getSelectionStart() - 1, this.fEa.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fEa.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fEa.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.5
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.fEa.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.fEa.setSelection(PbNewInputContainer.this.fEa.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    } else if (aVar.data instanceof j) {
                        this.fEf = null;
                        if (this.fEg != null) {
                            this.fEa.setHint(this.fEg);
                        }
                        final j jVar = (j) aVar.data;
                        if (TextUtils.isEmpty(((j) aVar.data).fEC) && TextUtils.isEmpty(((j) aVar.data).mContent)) {
                            this.fEa.setText((CharSequence) null);
                        } else {
                            if (!TextUtils.isEmpty(jVar.fEC)) {
                                com.baidu.tieba.face.b.a(getContext(), jVar.fEC, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.6
                                    @Override // com.baidu.tieba.face.b.a
                                    public void d(SpannableStringBuilder spannableStringBuilder) {
                                        PbNewInputContainer.this.fEf = spannableStringBuilder;
                                        if (TextUtils.isEmpty(jVar.mContent)) {
                                            PbNewInputContainer.this.fEa.setText("");
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
                                        PbNewInputContainer.this.fEa.setText(spannableStringBuilder);
                                        PbNewInputContainer.this.fEa.setSelection(PbNewInputContainer.this.fEa.getText().length());
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
                        this.fEe = null;
                        this.fEf = null;
                        this.fEa.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fEi[0] = 0;
                    this.fEi[1] = 0;
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
                        if (aVar2.fCv != null) {
                            if (aVar2.fCv.getChosedFiles() != null) {
                                this.fEi[0] = aVar2.fCv.getChosedFiles().size();
                            } else {
                                this.fEi[0] = 0;
                            }
                        }
                        if (this.fEi[0] > 0) {
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
                    int[] iArr = this.fEi;
                    iArr[0] = iArr[0] - 1;
                    if (this.fEi[0] > 0) {
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
                            this.fEc.setText(getContext().getString(R.string.location_loading));
                            break;
                        } else if (!TextUtils.isEmpty(aVar3.addr)) {
                            this.fEc.setText(aVar3.addr);
                            break;
                        } else {
                            this.fEc.setText(getContext().getString(R.string.location_where_are_you));
                            break;
                        }
                    }
                case 20:
                    la(true);
                    this.fEc.setText(getContext().getString(R.string.location_where_are_you));
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
                            CS((String) aVar.data);
                            break;
                        } else if ((aVar.data instanceof j) && ((j) aVar.data).mContent != null) {
                            CS(((j) aVar.data).mContent);
                            break;
                        }
                    }
                    break;
                case 45:
                    if (aVar.data instanceof String) {
                        String str = (String) aVar.data;
                        if (StringUtils.isNull(str)) {
                            this.eHx.setVisibility(8);
                            break;
                        } else {
                            this.eHx.setVisibility(0);
                            this.eHx.setText(str);
                            break;
                        }
                    } else {
                        this.eHx.setVisibility(8);
                        break;
                    }
            }
            rg(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rg(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.fEb.setEnabled(true);
            } else {
                this.fEb.setEnabled(false);
            }
        } else if (i == PICTURE) {
            if (this.flags[1]) {
                this.fEb.setEnabled(true);
            } else {
                this.fEb.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fEh = z;
    }

    public void setHint(int i) {
        if (this.fEa != null) {
            this.fEa.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fEa != null) {
            this.fEa.setHint(charSequence);
        }
    }

    public void setDefaultHint(String str) {
        this.fEg = str;
    }

    public EditText getInputView() {
        return this.fEa;
    }

    public TBSpecificationBtn getSendView() {
        return this.fEb;
    }

    public LinearLayout getInputLayout() {
        return this.fEd;
    }

    public TextView getTitleView() {
        return this.eHx;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fEc) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        }
    }

    public void setTransLink(boolean z) {
        if (this.fEa != null) {
            this.fEa.setTransLink(z);
        }
    }

    public void la(boolean z) {
        if (this.fEc != null) {
            this.fEc.setVisibility(z ? 0 : 8);
        }
    }
}
