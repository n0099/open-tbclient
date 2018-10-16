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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.o;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools SY;
    private int SZ;
    private int aHp;
    private EditText aVV;
    private PbNewLocationInfoView aVW;
    private LinearLayout aVX;
    private ImageView aVY;
    private LinearLayout aVZ;
    private boolean aVt;
    private boolean aVu;
    private boolean aVv;
    private int aVw;
    private boolean aWa;
    private boolean[] aWb;
    private int[] aWc;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int aWd = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aVt = false;
        this.aVu = true;
        this.aVv = true;
        this.aVw = -1;
        this.aWa = true;
        this.aWb = new boolean[]{false, false, false, false, false};
        this.aWc = new int[]{0, 0};
        this.aHp = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0175e.ds90));
        bO(context);
        this.aVZ = new LinearLayout(getContext());
        this.aVZ.setOrientation(0);
        this.aVZ.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds90));
        addView(this.aVZ, new LinearLayout.LayoutParams(-1, -2));
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0175e.ds1)));
        addView(this.mBottomLine);
    }

    private void bO(Context context) {
        this.aVX = new LinearLayout(getContext());
        this.aVX.setGravity(16);
        this.aVX.setOrientation(0);
        this.aVX.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0175e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds12));
        this.aVX.setLayoutParams(layoutParams);
        this.aVX.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.aVW = new PbNewLocationInfoView(context);
        this.aVX.addView(this.aVW, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0175e.ds24);
        this.aVY = new ImageView(context);
        this.aVY.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0175e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.aVX.addView(this.aVY, layoutParams3);
        addView(this.aVX);
        this.aVX.setVisibility(8);
        this.aVY.setOnClickListener(this);
    }

    private void bP(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0175e.fontsize32));
        this.mSendView.setText(e.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0175e.ds34), 0);
        this.aVZ.addView(this.mSendView, layoutParams);
    }

    private void bQ(Context context) {
        this.aVV = new EditText(context);
        this.aVV.setMinHeight(context.getResources().getDimensionPixelSize(e.C0175e.ds32));
        this.aVV.setMaxLines(4);
        this.aVV.setGravity(16);
        this.aVV.setTextSize(0, getResources().getDimensionPixelSize(e.C0175e.ds32));
        this.aVV.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.aVV.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.aVV.setBackgroundResource(e.d.common_color_10022);
        a(this.aVV, e.f.edittext_cursor);
        this.aVV.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0175e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0175e.ds24));
        this.aVV.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.aVV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.aVv) {
                    PbNewInputContainer.this.aVv = true;
                    if (PbNewInputContainer.this.aVw != -1) {
                        PbNewInputContainer.this.aVV.setSelection(PbNewInputContainer.this.aVw);
                        PbNewInputContainer.this.aVw = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.aVV.getText().toString()));
                }
            }
        });
        this.aVV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.aVV.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0175e.ds34), 0, 0, 0);
        this.aVZ.addView(this.aVV, layoutParams);
    }

    private void a(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void t(ArrayList<String> arrayList) {
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
                    this.aVV.getText().insert(this.aVV.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hq(String str) {
        if (!StringUtils.isNull(str)) {
            this.aVV.getText().insert(this.aVV.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof o)) {
            o oVar = (o) aVar.data;
            if (oVar.Fw() == EmotionGroupType.NET_SUG) {
                a(oVar);
            } else {
                b(oVar);
            }
        }
    }

    private void a(o oVar) {
        if (oVar != null && !TextUtils.isEmpty(oVar.getName()) && !TextUtils.isEmpty(oVar.getUrl())) {
            String obj = this.aVV.getText().toString();
            if (this.aVu && com.baidu.tieba.face.a.mG(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bs().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), oVar, this.aVV);
            }
        }
    }

    private void b(o oVar) {
        if (!this.aVt || oVar.Fw() == EmotionGroupType.LOCAL) {
            String obj = this.aVV.getText().toString();
            if (this.aVu && com.baidu.tieba.face.a.mG(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.Bs().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), oVar, this.aVV);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aVt = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        if (this.aVV != null && this.aVZ.getVisibility() == 0) {
            this.aVV.setFocusable(true);
            this.aVV.setFocusableInTouchMode(true);
            this.aVV.requestFocus();
            com.baidu.adp.lib.util.l.b(getContext(), this.aVV);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.aVV, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.aVX, e.f.pb_new_locatin_view_selector);
        al.c(this.aVY, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.aVV, e.f.edittext_cursor);
            this.aVV.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.aVV, e.f.edittext_cursor_1);
            this.aVV.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.aVW.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.aVV.getSelectionStart() > 0) {
                        String substring = this.aVV.getText().toString().substring(0, this.aVV.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.djj.matcher(substring);
                        if (matcher.find()) {
                            this.aVV.getText().delete(this.aVV.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.aVV.getSelectionStart());
                            break;
                        } else {
                            this.aVV.getText().delete(this.aVV.getSelectionStart() - 1, this.aVV.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.aVV.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.aVV.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.aVV.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.aVV.setSelection(PbNewInputContainer.this.aVV.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aWb[0] = false;
                        break;
                    } else {
                        this.aWb[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.aVV.setText((CharSequence) null);
                    }
                    this.aWb[0] = false;
                    this.aWb[1] = false;
                    this.aWb[2] = false;
                    this.aWb[3] = false;
                    this.aWb[4] = false;
                    this.aWc[0] = 0;
                    this.aWc[1] = 0;
                    break;
                case 10:
                    this.aWb[2] = true;
                    break;
                case 11:
                    this.aWb[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aUU != null) {
                            if (aVar2.aUU.getChosedFiles() != null) {
                                this.aWc[0] = aVar2.aUU.getChosedFiles().size();
                            } else {
                                this.aWc[0] = 0;
                            }
                        }
                        if (this.aWc[0] > 0) {
                            this.aWb[1] = true;
                            break;
                        } else {
                            this.aWb[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aWc;
                    iArr[0] = iArr[0] - 1;
                    if (this.aWc[0] > 0) {
                        this.aWb[1] = true;
                        break;
                    } else {
                        this.aWb[1] = false;
                        break;
                    }
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        t((ArrayList) aVar.data);
                        break;
                    }
                    break;
                case 19:
                    if (aVar.data == null) {
                        this.aVX.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.aVX.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.aVW.setState(aVar3.state, null);
                                break;
                            } else {
                                this.aVW.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.aVX.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.aVX.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.aWb[3] = true;
                    break;
                case 29:
                    this.aWb[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        hq((String) aVar.data);
                        break;
                    }
                    break;
            }
            fq(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fq(int i) {
        if (i == ALL) {
            if (this.aWb[0] || this.aWb[1] || this.aWb[2] || this.aWb[3] || this.aWb[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == aWd) {
            if (this.aWb[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.aWa = z;
    }

    public void setHint(int i) {
        if (this.aVV != null) {
            this.aVV.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.aVV != null) {
            this.aVV.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.aVV;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.aVW;
    }

    public LinearLayout getInputLayout() {
        return this.aVZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aVX) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.aVY) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
