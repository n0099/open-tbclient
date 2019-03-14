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
    private EditorTools VN;
    private int VO;
    private int bUK;
    private boolean cjT;
    private boolean cjU;
    private boolean cjV;
    private int cjW;
    private boolean ckD;
    private boolean[] ckE;
    private int[] ckF;
    private EditText ckv;
    private LinearLayout ckz;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int ckG = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjT = false;
        this.cjU = true;
        this.cjV = true;
        this.cjW = -1;
        this.ckD = true;
        this.ckE = new boolean[]{false, false, false, false, false};
        this.ckF = new int[]{0, 0};
        this.bUK = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(d.e.ds90));
        this.ckz = new LinearLayout(getContext());
        this.ckz.setOrientation(0);
        this.ckz.setMinimumHeight(com.baidu.adp.lib.util.l.h(context, d.e.ds90));
        addView(this.ckz, new LinearLayout.LayoutParams(-1, -2));
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
        this.ckz.addView(this.mSendView, layoutParams);
    }

    private void dh(Context context) {
        this.ckv = new EditText(context);
        this.ckv.setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds32));
        this.ckv.setMaxLines(4);
        this.ckv.setGravity(16);
        this.ckv.setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        this.ckv.setTextColor(getResources().getColor(d.C0277d.cp_cont_b));
        this.ckv.setHintTextColor(getResources().getColor(d.C0277d.cp_cont_e));
        this.ckv.setBackgroundResource(d.C0277d.common_color_10022);
        e(this.ckv, d.f.edittext_cursor);
        this.ckv.setPadding(0, com.baidu.adp.lib.util.l.h(context, d.e.ds24), com.baidu.adp.lib.util.l.h(context, d.e.ds54), com.baidu.adp.lib.util.l.h(context, d.e.ds24));
        this.ckv.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ckv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.cjV) {
                    TopicDetaiInputContainer.this.cjV = true;
                    if (TopicDetaiInputContainer.this.cjW != -1) {
                        TopicDetaiInputContainer.this.ckv.setSelection(TopicDetaiInputContainer.this.cjW);
                        TopicDetaiInputContainer.this.cjW = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.ckv.getText().toString()));
                }
            }
        });
        this.ckv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.ckv.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.h(context, d.e.ds14), 0, 0, 0);
        this.ckz.addView(this.ckv, layoutParams);
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
            if (pVar.agt() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.ckv.getText().toString();
            if (this.cjU && com.baidu.tieba.face.a.ue(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aca().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ckv);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cjT || pVar.agt() == EmotionGroupType.LOCAL) {
            String obj = this.ckv.getText().toString();
            if (this.cjU && com.baidu.tieba.face.a.ue(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aca().showToast(d.j.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ckv);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cjT = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        if (this.ckv != null && this.ckz.getVisibility() == 0) {
            this.ckv.setFocusable(true);
            this.ckv.setFocusableInTouchMode(true);
            this.ckv.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ckv);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.ckv, d.C0277d.cp_cont_b, 2, i);
        al.l(this.mBottomLine, d.C0277d.cp_bg_line_c);
        al.l(this, d.C0277d.cp_bg_line_d);
        if (i == 0) {
            e(this.ckv, d.f.edittext_cursor);
            this.ckv.setHintTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_e));
        } else {
            e(this.ckv, d.f.edittext_cursor_1);
            this.ckv.setHintTextColor(al.getColor(i, d.C0277d.cp_cont_e));
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
                    if (this.ckv.getSelectionStart() > 0) {
                        String substring = this.ckv.getText().toString().substring(0, this.ckv.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eHB.matcher(substring);
                        if (matcher.find()) {
                            this.ckv.getText().delete(this.ckv.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ckv.getSelectionStart());
                            break;
                        } else {
                            this.ckv.getText().delete(this.ckv.getSelectionStart() - 1, this.ckv.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ckv.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ckv.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.ckv.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.ckv.setSelection(TopicDetaiInputContainer.this.ckv.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.ckE[0] = false;
                        break;
                    } else {
                        this.ckE[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ckv.setText((CharSequence) null);
                    }
                    this.ckE[0] = false;
                    this.ckE[1] = false;
                    this.ckE[2] = false;
                    this.ckE[3] = false;
                    this.ckE[4] = false;
                    this.ckF[0] = 0;
                    this.ckF[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cju != null) {
                            if (aVar2.cju.getChosedFiles() != null) {
                                this.ckF[0] = aVar2.cju.getChosedFiles().size();
                            } else {
                                this.ckF[0] = 0;
                            }
                        }
                        if (this.ckF[0] > 0) {
                            this.ckE[1] = true;
                            break;
                        } else {
                            this.ckE[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckF;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckF[0] > 0) {
                        this.ckE[1] = true;
                        break;
                    } else {
                        this.ckE[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            jE(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jE(int i) {
        if (i == ALL) {
            if (this.ckE[0] || this.ckE[1] || this.ckE[2] || this.ckE[3] || this.ckE[4]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        } else if (i == ckG) {
            if (this.ckE[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.ckD = z;
    }

    public void setHint(int i) {
        if (this.ckv != null) {
            this.ckv.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ckv != null) {
            this.ckv.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.ckv;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.ckz;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
