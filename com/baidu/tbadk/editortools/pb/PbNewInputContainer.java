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
    private int aMj;
    private EditText baW;
    private PbNewLocationInfoView baX;
    private LinearLayout baY;
    private ImageView baZ;
    private boolean bau;
    private boolean bav;
    private boolean baw;
    private int bax;
    private LinearLayout bba;
    private boolean bbb;
    private boolean[] bbc;
    private int[] bbd;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int bbe = 1;
    public static int ALL = 0;

    public PbNewInputContainer(Context context) {
        this(context, null);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PbNewInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bau = false;
        this.bav = true;
        this.baw = true;
        this.bax = -1;
        this.bbb = true;
        this.bbc = new boolean[]{false, false, false, false, false};
        this.bbd = new int[]{0, 0};
        this.aMj = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds90));
        bO(context);
        this.bba = new LinearLayout(getContext());
        this.bba.setOrientation(0);
        this.bba.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds90));
        addView(this.bba, new LinearLayout.LayoutParams(-1, -2));
        bQ(context);
        bP(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), e.C0210e.ds1)));
        addView(this.mBottomLine);
    }

    private void bO(Context context) {
        this.baY = new LinearLayout(getContext());
        this.baY.setGravity(16);
        this.baY.setOrientation(0);
        this.baY.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0, 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds48));
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds30), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds12));
        this.baY.setLayoutParams(layoutParams);
        this.baY.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.baX = new PbNewLocationInfoView(context);
        this.baY.addView(this.baX, layoutParams2);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.C0210e.ds24);
        this.baZ = new ImageView(context);
        this.baZ.setPadding(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), 0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds20), 0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimensionPixelSize * 3, dimensionPixelSize);
        layoutParams3.gravity = 17;
        this.baY.addView(this.baZ, layoutParams3);
        addView(this.baY);
        this.baY.setVisibility(8);
        this.baZ.setOnClickListener(this);
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
        this.bba.addView(this.mSendView, layoutParams);
    }

    private void bQ(Context context) {
        this.baW = new EditText(context);
        this.baW.setMinHeight(context.getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.baW.setMaxLines(4);
        this.baW.setGravity(16);
        this.baW.setTextSize(0, getResources().getDimensionPixelSize(e.C0210e.ds32));
        this.baW.setTextColor(getResources().getColor(e.d.cp_cont_b));
        this.baW.setHintTextColor(getResources().getColor(e.d.cp_cont_e));
        this.baW.setBackgroundResource(e.d.common_color_10022);
        a(this.baW, e.f.edittext_cursor);
        this.baW.setPadding(0, com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds54), com.baidu.adp.lib.util.l.h(context, e.C0210e.ds24));
        this.baW.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.baW.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!PbNewInputContainer.this.baw) {
                    PbNewInputContainer.this.baw = true;
                    if (PbNewInputContainer.this.bax != -1) {
                        PbNewInputContainer.this.baW.setSelection(PbNewInputContainer.this.bax);
                        PbNewInputContainer.this.bax = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, PbNewInputContainer.this.baW.getText().toString()));
                }
            }
        });
        this.baW.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    PbNewInputContainer.this.baW.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, e.C0210e.ds34), 0, 0, 0);
        this.bba.addView(this.baW, layoutParams);
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
                    this.baW.getText().insert(this.baW.getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void hY(String str) {
        if (!StringUtils.isNull(str)) {
            this.baW.getText().insert(this.baW.getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
            String obj = this.baW.getText().toString();
            if (this.bav && com.baidu.tieba.face.a.nz(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CQ().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.baW);
            }
        }
    }

    private void b(p pVar) {
        if (!this.bau || pVar.Ha() == EmotionGroupType.LOCAL) {
            String obj = this.baW.getText().toString();
            if (this.bav && com.baidu.tieba.face.a.nz(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.CQ().showToast(e.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.baW);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.bau = z;
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
        if (this.baW != null && this.bba.getVisibility() == 0) {
            this.baW.setFocusable(true);
            this.baW.setFocusableInTouchMode(true);
            this.baW.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.baW);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.b(this.baW, e.d.cp_cont_b, 2, i);
        al.j(this.mBottomLine, e.d.cp_bg_line_c);
        al.j(this, e.d.cp_bg_line_d);
        al.i(this.baY, e.f.pb_new_locatin_view_selector);
        al.c(this.baZ, e.f.icon_edit_close_n);
        if (i == 0) {
            a(this.baW, e.f.edittext_cursor);
            this.baW.setHintTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        } else {
            a(this.baW, e.f.edittext_cursor_1);
            this.baW.setHintTextColor(al.getColor(i, e.d.cp_cont_e));
        }
        if (this.mSendView.isEnabled()) {
            al.b(this.mSendView, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this.mSendView, e.d.cp_cont_e, 1);
        }
        this.baX.onChangeSkinType();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.baW.getSelectionStart() > 0) {
                        String substring = this.baW.getText().toString().substring(0, this.baW.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.dun.matcher(substring);
                        if (matcher.find()) {
                            this.baW.getText().delete(this.baW.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.baW.getSelectionStart());
                            break;
                        } else {
                            this.baW.getText().delete(this.baW.getSelectionStart() - 1, this.baW.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.baW.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.baW.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.pb.PbNewInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void a(SpannableStringBuilder spannableStringBuilder) {
                                    PbNewInputContainer.this.baW.setText(spannableStringBuilder);
                                    PbNewInputContainer.this.baW.setSelection(PbNewInputContainer.this.baW.getText().length());
                                    PbNewInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    PbNewInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.bbc[0] = false;
                        break;
                    } else {
                        this.bbc[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.baW.setText((CharSequence) null);
                    }
                    this.bbc[0] = false;
                    this.bbc[1] = false;
                    this.bbc[2] = false;
                    this.bbc[3] = false;
                    this.bbc[4] = false;
                    this.bbd[0] = 0;
                    this.bbd[1] = 0;
                    break;
                case 10:
                    this.bbc[2] = true;
                    break;
                case 11:
                    this.bbc[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aZU != null) {
                            if (aVar2.aZU.getChosedFiles() != null) {
                                this.bbd[0] = aVar2.aZU.getChosedFiles().size();
                            } else {
                                this.bbd[0] = 0;
                            }
                        }
                        if (this.bbd[0] > 0) {
                            this.bbc[1] = true;
                            break;
                        } else {
                            this.bbc[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bbd;
                    iArr[0] = iArr[0] - 1;
                    if (this.bbd[0] > 0) {
                        this.bbc[1] = true;
                        break;
                    } else {
                        this.bbc[1] = false;
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
                        this.baY.setVisibility(8);
                        break;
                    } else {
                        com.baidu.tbadk.editortools.d.a aVar3 = (com.baidu.tbadk.editortools.d.a) aVar.data;
                        if (aVar3.isShow) {
                            this.baY.setVisibility(0);
                            if (TextUtils.isEmpty(aVar3.addr)) {
                                this.baX.setState(aVar3.state, null);
                                break;
                            } else {
                                this.baX.setState(aVar3.state, aVar3.addr);
                                break;
                            }
                        } else {
                            this.baY.setVisibility(8);
                            break;
                        }
                    }
                case 20:
                    this.baY.setVisibility(8);
                    break;
                case 24:
                    d(aVar);
                    break;
                case 28:
                case 39:
                    this.bbc[3] = true;
                    break;
                case 29:
                    this.bbc[3] = false;
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
            if (this.bbc[0] || this.bbc[1] || this.bbc[2] || this.bbc[3] || this.bbc[4]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        } else if (i == bbe) {
            if (this.bbc[1]) {
                this.mSendView.setEnabled(true);
                al.b(this.mSendView, e.d.cp_link_tip_a, 1, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            this.mSendView.setEnabled(false);
            al.c(this.mSendView, e.d.cp_cont_d, 1);
        }
    }

    public void setHasHint(boolean z) {
        this.bbb = z;
    }

    public void setHint(int i) {
        if (this.baW != null) {
            this.baW.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.baW != null) {
            this.baW.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.baW;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public TextView getLocationInfoView() {
        return this.baX;
    }

    public LinearLayout getInputLayout() {
        return this.bba;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baY) {
            b(new com.baidu.tbadk.editortools.a(18, -1, null));
        } else if (view == this.baZ) {
            b(new com.baidu.tbadk.editortools.a(20, -1, null));
        }
    }
}
