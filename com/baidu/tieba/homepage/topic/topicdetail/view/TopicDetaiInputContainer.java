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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes21.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools aaS;
    private int aaT;
    private int aiX;
    private TextView bxT;
    private boolean eOA;
    private int eOB;
    private boolean eOy;
    private boolean eOz;
    private EditText ePB;
    private LinearLayout ePF;
    private boolean ePJ;
    private int[] ePK;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int ePL = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eOy = false;
        this.eOz = true;
        this.eOA = true;
        this.eOB = -1;
        this.ePJ = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.ePK = new int[]{0, 0};
        this.aiX = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.ePF = new LinearLayout(getContext());
        this.ePF.setOrientation(0);
        this.ePF.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.ePF, new LinearLayout.LayoutParams(-1, -2));
        ei(context);
        eh(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void eh(Context context) {
        this.bxT = new TextView(context);
        this.bxT.setGravity(17);
        this.bxT.setIncludeFontPadding(false);
        this.bxT.setEnabled(false);
        this.bxT.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bxT.setText(R.string.pb_send_post);
        this.bxT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.ePF.addView(this.bxT, layoutParams);
    }

    private void ei(Context context) {
        this.ePB = new EditText(context);
        this.ePB.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ePB.setMaxLines(4);
        this.ePB.setGravity(16);
        this.ePB.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ePB.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.ePB.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.ePB.setBackgroundResource(R.color.common_color_10022);
        g(this.ePB, R.drawable.edittext_cursor);
        this.ePB.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.ePB.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ePB.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.eOA) {
                    TopicDetaiInputContainer.this.eOA = true;
                    if (TopicDetaiInputContainer.this.eOB != -1) {
                        TopicDetaiInputContainer.this.ePB.setSelection(TopicDetaiInputContainer.this.eOB);
                        TopicDetaiInputContainer.this.eOB = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.ePB.getText().toString()));
                }
            }
        });
        this.ePB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.ePB.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.ePF.addView(this.ePB, layoutParams);
    }

    private void g(EditText editText, int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(editText, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u)) {
            u uVar = (u) aVar.data;
            if (uVar.bnJ() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.ePB.getText().toString();
            if (this.eOz && com.baidu.tieba.face.a.Ib(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bjn().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.ePB);
            }
        }
    }

    private void b(u uVar) {
        if (!this.eOy || uVar.bnJ() == EmotionGroupType.LOCAL) {
            String obj = this.ePB.getText().toString();
            if (this.eOz && com.baidu.tieba.face.a.Ib(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bjn().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.ePB);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eOy = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaS != null) {
            this.aaS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaT = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaT;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.ePB != null && this.ePF.getVisibility() == 0) {
            this.ePB.setFocusable(true);
            this.ePB.setFocusableInTouchMode(true);
            this.ePB.requestFocus();
            l.showSoftKeyPad(getContext(), this.ePB);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.ePB, R.color.cp_cont_b, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.ePB, R.drawable.edittext_cursor);
            this.ePB.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            g(this.ePB, R.drawable.edittext_cursor_1);
            this.ePB.setHintTextColor(ap.getColor(i, R.color.cp_cont_e));
        }
        ap.setBackgroundResource(this.bxT, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bxT.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ap.setViewTextColor(this.bxT, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ePB.getSelectionStart() > 0) {
                        String substring = this.ePB.getText().toString().substring(0, this.ePB.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hLW.matcher(substring);
                        if (matcher.find()) {
                            this.ePB.getText().delete(this.ePB.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ePB.getSelectionStart());
                            break;
                        } else {
                            this.ePB.getText().delete(this.ePB.getSelectionStart() - 1, this.ePB.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ePB.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ePB.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.ePB.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.ePB.setSelection(TopicDetaiInputContainer.this.ePB.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.flags[0] = false;
                        break;
                    } else {
                        this.flags[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ePB.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.ePK[0] = 0;
                    this.ePK[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.eNZ != null) {
                            if (aVar2.eNZ.getChosedFiles() != null) {
                                this.ePK[0] = aVar2.eNZ.getChosedFiles().size();
                            } else {
                                this.ePK[0] = 0;
                            }
                        }
                        if (this.ePK[0] > 0) {
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
                    int[] iArr = this.ePK;
                    iArr[0] = iArr[0] - 1;
                    if (this.ePK[0] > 0) {
                        this.flags[1] = true;
                        break;
                    } else {
                        this.flags[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            qD(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void qD(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bxT.setEnabled(true);
            } else {
                this.bxT.setEnabled(false);
            }
        } else if (i == ePL) {
            if (this.flags[1]) {
                this.bxT.setEnabled(true);
            } else {
                this.bxT.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.ePJ = z;
    }

    public void setHint(int i) {
        if (this.ePB != null) {
            this.ePB.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ePB != null) {
            this.ePB.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.ePB;
    }

    public TextView getSendView() {
        return this.bxT;
    }

    public LinearLayout getInputLayout() {
        return this.ePF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
