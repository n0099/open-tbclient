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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes9.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, m {
    private EditorTools Za;
    private int Zb;
    private int afT;
    private TextView bbL;
    private EditText dYK;
    private LinearLayout dYO;
    private boolean dYS;
    private int[] dYT;
    private boolean dYg;
    private boolean dYh;
    private boolean dYi;
    private int dYj;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int dYU = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYg = false;
        this.dYh = true;
        this.dYi = true;
        this.dYj = -1;
        this.dYS = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dYT = new int[]{0, 0};
        this.afT = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.dYO = new LinearLayout(getContext());
        this.dYO.setOrientation(0);
        this.dYO.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dYO, new LinearLayout.LayoutParams(-1, -2));
        dM(context);
        dL(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dL(Context context) {
        this.bbL = new TextView(context);
        this.bbL.setGravity(17);
        this.bbL.setIncludeFontPadding(false);
        this.bbL.setEnabled(false);
        this.bbL.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bbL.setText(R.string.pb_send_post);
        this.bbL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.dYO.addView(this.bbL, layoutParams);
    }

    private void dM(Context context) {
        this.dYK = new EditText(context);
        this.dYK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYK.setMaxLines(4);
        this.dYK.setGravity(16);
        this.dYK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYK.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dYK.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dYK.setBackgroundResource(R.color.common_color_10022);
        e(this.dYK, R.drawable.edittext_cursor);
        this.dYK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dYK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dYK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.dYi) {
                    TopicDetaiInputContainer.this.dYi = true;
                    if (TopicDetaiInputContainer.this.dYj != -1) {
                        TopicDetaiInputContainer.this.dYK.setSelection(TopicDetaiInputContainer.this.dYj);
                        TopicDetaiInputContainer.this.dYj = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.dYK.getText().toString()));
                }
            }
        });
        this.dYK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.dYK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.dYO.addView(this.dYK, layoutParams);
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
        if (aVar != null && aVar.data != null && (aVar.data instanceof q)) {
            q qVar = (q) aVar.data;
            if (qVar.aRY() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dYK.getText().toString();
            if (this.dYh && com.baidu.tieba.face.a.Ce(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOd().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dYK);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dYg || qVar.aRY() == EmotionGroupType.LOCAL) {
            String obj = this.dYK.getText().toString();
            if (this.dYh && com.baidu.tieba.face.a.Ce(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOd().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dYK);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dYg = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Za != null) {
            this.Za.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zb = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zb;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dYK != null && this.dYO.getVisibility() == 0) {
            this.dYK.setFocusable(true);
            this.dYK.setFocusableInTouchMode(true);
            this.dYK.requestFocus();
            l.showSoftKeyPad(getContext(), this.dYK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dYK, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dYK, R.drawable.edittext_cursor);
            this.dYK.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dYK, R.drawable.edittext_cursor_1);
            this.dYK.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setBackgroundResource(this.bbL, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bbL.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            am.setViewTextColor(this.bbL, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dYK.getSelectionStart() > 0) {
                        String substring = this.dYK.getText().toString().substring(0, this.dYK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gKy.matcher(substring);
                        if (matcher.find()) {
                            this.dYK.getText().delete(this.dYK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dYK.getSelectionStart());
                            break;
                        } else {
                            this.dYK.getText().delete(this.dYK.getSelectionStart() - 1, this.dYK.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dYK.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dYK.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.dYK.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.dYK.setSelection(TopicDetaiInputContainer.this.dYK.getText().length());
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
                        this.dYK.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dYT[0] = 0;
                    this.dYT[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dXH != null) {
                            if (aVar2.dXH.getChosedFiles() != null) {
                                this.dYT[0] = aVar2.dXH.getChosedFiles().size();
                            } else {
                                this.dYT[0] = 0;
                            }
                        }
                        if (this.dYT[0] > 0) {
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
                    int[] iArr = this.dYT;
                    iArr[0] = iArr[0] - 1;
                    if (this.dYT[0] > 0) {
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
            mL(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mL(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bbL.setEnabled(true);
            } else {
                this.bbL.setEnabled(false);
            }
        } else if (i == dYU) {
            if (this.flags[1]) {
                this.bbL.setEnabled(true);
            } else {
                this.bbL.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.dYS = z;
    }

    public void setHint(int i) {
        if (this.dYK != null) {
            this.dYK.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dYK != null) {
            this.dYK.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.dYK;
    }

    public TextView getSendView() {
        return this.bbL;
    }

    public LinearLayout getInputLayout() {
        return this.dYO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
