package com.baidu.tieba.homepage.topic.topicdetail.view;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools VO;
    private int VP;
    private int bUN;
    private boolean cjW;
    private boolean cjX;
    private boolean cjY;
    private int cjZ;
    private LinearLayout ckC;
    private boolean ckG;
    private boolean[] ckH;
    private int[] ckI;
    private EditText cky;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int ckJ = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjW = false;
        this.cjX = true;
        this.cjY = true;
        this.cjZ = -1;
        this.ckG = true;
        this.ckH = new boolean[]{false, false, false, false, false};
        this.ckI = new int[]{0, 0};
        this.bUN = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        this.ckC = new LinearLayout(getContext());
        this.ckC.setOrientation(0);
        this.ckC.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.ds90));
        addView(this.ckC, new LinearLayout.LayoutParams(-1, -2));
        dh(context);
        dg(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.h(getContext(), d.e.ds1)));
        addView(this.mBottomLine);
    }

    private void dg(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.tbds42));
        this.mSendView.setText(d.j.pb_send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.h(context, d.e.tbds14), 0);
        this.ckC.addView(this.mSendView, layoutParams);
    }

    private void dh(Context context) {
        this.cky = new EditText(context);
        this.cky.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.cky.setMaxLines(4);
        this.cky.setGravity(16);
        this.cky.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.cky.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        this.cky.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        this.cky.setBackgroundResource(d.C0277d.common_color_10022);
        e(this.cky, d.f.edittext_cursor);
        this.cky.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.cky.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cky.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.cjY) {
                    TopicDetaiInputContainer.this.cjY = true;
                    if (TopicDetaiInputContainer.this.cjZ != -1) {
                        TopicDetaiInputContainer.this.cky.setSelection(TopicDetaiInputContainer.this.cjZ);
                        TopicDetaiInputContainer.this.cjZ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.cky.getText().toString()));
                }
            }
        });
        this.cky.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.cky.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds14), 0, 0, 0);
        this.ckC.addView(this.cky, layoutParams);
    }

    private void e(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof p)) {
            p pVar = (p) aVar.data;
            if (pVar.agq() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cky.getText().toString();
            if (this.cjX && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cky);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjW || pVar.agq() == EmotionGroupType.LOCAL) {
            String obj = this.cky.getText().toString();
            if (this.cjX && com.baidu.tieba.face.a.ud(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.abX().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cky);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cjW = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.cky != null && this.ckC.getVisibility() == 0) {
            this.cky.setFocusable(true);
            this.cky.setFocusableInTouchMode(true);
            this.cky.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.cky);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.cky, d.C0277d.cp_cont_b, 2, i);
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        al.l(this, d.C0277d.cp_bg_line_d);
        if (i == 0) {
            e(this.cky, d.f.edittext_cursor);
            this.cky.setHintTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_e));
        } else {
            e(this.cky, d.f.edittext_cursor_1);
            this.cky.setHintTextColor(al.getColor(i, d.C0277d.cp_cont_e));
        }
        al.k(this.mSendView, d.f.topic_discuss_send_bg);
        if (i == 1) {
            this.mSendView.setTextColor(getResources().getColor(d.C0277d.cp_btn_a));
        } else {
            al.d(this.mSendView, d.C0277d.cp_btn_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cky.getSelectionStart() > 0) {
                        String substring = this.cky.getText().toString().substring(0, this.cky.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHo.matcher(substring);
                        if (matcher.find()) {
                            this.cky.getText().delete(this.cky.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cky.getSelectionStart());
                            break;
                        } else {
                            this.cky.getText().delete(this.cky.getSelectionStart() - 1, this.cky.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cky.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cky.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.cky.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.cky.setSelection(TopicDetaiInputContainer.this.cky.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.ckH[0] = false;
                        break;
                    } else {
                        this.ckH[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cky.setText((CharSequence) null);
                    }
                    this.ckH[0] = false;
                    this.ckH[1] = false;
                    this.ckH[2] = false;
                    this.ckH[3] = false;
                    this.ckH[4] = false;
                    this.ckI[0] = 0;
                    this.ckI[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cjx != null) {
                            if (aVar2.cjx.getChosedFiles() != null) {
                                this.ckI[0] = aVar2.cjx.getChosedFiles().size();
                            } else {
                                this.ckI[0] = 0;
                            }
                        }
                        if (this.ckI[0] > 0) {
                            this.ckH[1] = true;
                            break;
                        } else {
                            this.ckH[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckI;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckI[0] > 0) {
                        this.ckH[1] = true;
                        break;
                    } else {
                        this.ckH[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            jD(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jD(int i) {
        if (i == ALL) {
            if (this.ckH[0] || this.ckH[1] || this.ckH[2] || this.ckH[3] || this.ckH[4]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        } else if (i == ckJ) {
            if (this.ckH[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.ckG = z;
    }

    public void setHint(int i) {
        if (this.cky != null) {
            this.cky.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cky != null) {
            this.cky.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.cky;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.ckC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
