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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class PbNewInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools Tj;
    private int Tk;
    private int aMk;
    private EditText baX;
    private PbNewLocationInfoView baY;
    private LinearLayout baZ;
    private boolean bav;
    private boolean baw;
    private boolean bax;
    private int bay;
    private ImageView bba;
    private LinearLayout bbb;
    private boolean bbc;
    private boolean[] bbd;
    private int[] bbe;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bbf = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bav = false;
        this.baw = true;
        this.bax = true;
        this.bay = -1;
        this.bbc = true;
        this.bbd = new boolean[]{false, false, false, false, false};
        this.bbe = new int[]{0, 0};
        this.aMk = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds90));
        bO(context);
        this.bbb = new LinearLayout(getContext());
        this.bbb.setOrientation(0);
        this.bbb.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds90));
        addView(this.bbb, new LinearLayout.LayoutParams(-1, -2));
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds1)));
        addView(this.mBottomLine);
    }

    private void bO(Context context) {
        this.baZ = new LinearLayout(getContext());
        this.baZ.setGravity(16);
        this.baZ.setOrientation(0);
        this.baZ.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds12));
        this.baZ.setLayoutParams(layoutParams);
        this.baZ.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.baY = new PbNewLocationInfoView(context);
        this.baZ.addView(this.baY, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.bba = new ImageView(context);
        this.bba.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.baZ.addView(this.bba, layoutParams3);
        addView(this.baZ);
        this.baZ.setVisibility(8);
        this.bba.setOnClickListener(this);
    }

    private void bP(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0210e.fontsize32));
        this.mSendView.setText(e.j.send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), 0);
        this.bbb.addView(this.mSendView, layoutParams);
    }

    private void bQ(Context context) {
        this.baX = new EditText(context);
        this.baX.setMinHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.baX.setMaxLines(4);
        this.baX.setGravity(16);
        this.baX.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.baX.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.baX.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.baX.setBackgroundResource(e.d.common_color_10022);
        a(this.baX, e.f.edittext_cursor);
        this.baX.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24));
        this.baX.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.baX.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.bax) {
                    PbNewInputContainer.this.bax = true;
                    if (PbNewInputContainer.this.bay != -1) {
                        PbNewInputContainer.this.baX.setSelection(PbNewInputContainer.this.bay);
                        PbNewInputContainer.this.bay = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.baX.getText().toString()));
                }
            }
        });
        this.baX.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.baX.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), 0, 0, 0);
        this.bbb.addView(this.baX, layoutParams);
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
                    this.baX.getText().insert(this.baX.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hY(String str) {
        if (!StringUtils.isNull(str)) {
            this.baX.getText().insert(this.baX.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p)) {
            p pVar = (p) aVar.data;
            if (pVar.Ha() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.baX.getText().toString();
            if (this.baw && com.baidu.tieba.face.a.nz(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CQ().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.baX);
            }
        }
    }

    private void b(p pVar) {
        if (!this.bav || pVar.Ha() == EmotionGroupType.LOCAL) {
            String obj = this.baX.getText().toString();
            if (this.baw && com.baidu.tieba.face.a.nz(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CQ().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.baX);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.bav = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        if (this.baX != null && this.bbb.getVisibility() == 0) {
            this.baX.setFocusable(true);
            this.baX.setFocusableInTouchMode(true);
            this.baX.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.baX);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.baX, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.baZ, e.f.pb_new_locatin_view_selector);
        al.c(this.bba, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.baX, e.f.edittext_cursor);
            this.baX.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.baX, e.f.edittext_cursor_1);
            this.baX.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.baY.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.baX.getSelectionStart() > 0) {
                        String substring = this.baX.getText().toString().substring(0, this.baX.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.duo.matcher(substring);
                        if (matcher.find()) {
                            this.baX.getText().delete(this.baX.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.baX.getSelectionStart());
                            break;
                        } else {
                            this.baX.getText().delete(this.baX.getSelectionStart() - 1, this.baX.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.baX.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.baX.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.baX.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.baX.setSelection(PbNewInputContainer.this.baX.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bbd[0] = false;
                        break;
                    } else {
                        this.bbd[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.baX.setText((CharSequence) null);
                    }
                    this.bbd[0] = false;
                    this.bbd[1] = false;
                    this.bbd[2] = false;
                    this.bbd[3] = false;
                    this.bbd[4] = false;
                    this.bbe[0] = 0;
                    this.bbe[1] = 0;
                    break;
                case 10:
                    this.bbd[2] = true;
                    break;
                case 11:
                    this.bbd[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aZV != null) {
                            if (aVar2.aZV.getChosedFiles() != null) {
                                this.bbe[0] = aVar2.aZV.getChosedFiles().size();
                            } else {
                                this.bbe[0] = 0;
                            }
                        }
                        if (this.bbe[0] > 0) {
                            this.bbd[1] = true;
                            break;
                        } else {
                            this.bbd[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bbe;
                    iArr[0] = iArr[0] - 1;
                    if (this.bbe[0] > 0) {
                        this.bbd[1] = true;
                        break;
                    } else {
                        this.bbd[1] = false;
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
                        this.baZ.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.baZ.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.baY.setState(aVar3.state, null);
                                break;
                            } else {
                                this.baY.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.baZ.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.baZ.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bbd[3] = true;
                    break;
                case 29:
                    this.bbd[3] = false;
                    break;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        hY((String) aVar.data);
                        break;
                    }
                    break;
            }
            fT(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fT(int i) {
        if (i == ALL) {
            if (this.bbd[0] || this.bbd[1] || this.bbd[2] || this.bbd[3] || this.bbd[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == bbf) {
            if (this.bbd[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.bbc = z;
    }

    public void setHint(int i) {
        if (this.baX != null) {
            this.baX.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.baX != null) {
            this.baX.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.baX;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.baY;
    }

    public LinearLayout getInputLayout() {
        return this.bbb;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baZ) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.bba) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
