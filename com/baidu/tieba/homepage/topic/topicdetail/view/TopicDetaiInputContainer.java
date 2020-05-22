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
    private EditorTools Zt;
    private int Zu;
    private int agt;
    private TextView bjq;
    private EditText emY;
    private boolean emu;
    private boolean emv;
    private boolean emw;
    private int emx;
    private LinearLayout enc;
    private boolean enh;
    private int[] eni;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int enj = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.emu = false;
        this.emv = true;
        this.emw = true;
        this.emx = -1;
        this.enh = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eni = new int[]{0, 0};
        this.agt = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.enc = new LinearLayout(getContext());
        this.enc.setOrientation(0);
        this.enc.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.enc, new LinearLayout.LayoutParams(-1, -2));
        dR(context);
        dQ(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dQ(Context context) {
        this.bjq = new TextView(context);
        this.bjq.setGravity(17);
        this.bjq.setIncludeFontPadding(false);
        this.bjq.setEnabled(false);
        this.bjq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bjq.setText(R.string.pb_send_post);
        this.bjq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.enc.addView(this.bjq, layoutParams);
    }

    private void dR(Context context) {
        this.emY = new EditText(context);
        this.emY.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.emY.setMaxLines(4);
        this.emY.setGravity(16);
        this.emY.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.emY.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.emY.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.emY.setBackgroundResource(R.color.common_color_10022);
        e(this.emY, R.drawable.edittext_cursor);
        this.emY.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.emY.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.emY.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.emw) {
                    TopicDetaiInputContainer.this.emw = true;
                    if (TopicDetaiInputContainer.this.emx != -1) {
                        TopicDetaiInputContainer.this.emY.setSelection(TopicDetaiInputContainer.this.emx);
                        TopicDetaiInputContainer.this.emx = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.emY.getText().toString()));
                }
            }
        });
        this.emY.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.emY.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.enc.addView(this.emY, layoutParams);
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
            if (qVar.aYc() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.emY.getText().toString();
            if (this.emv && com.baidu.tieba.face.a.DQ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aUf().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.emY);
            }
        }
    }

    private void b(q qVar) {
        if (!this.emu || qVar.aYc() == EmotionGroupType.LOCAL) {
            String obj = this.emY.getText().toString();
            if (this.emv && com.baidu.tieba.face.a.DQ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aUf().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.emY);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.emu = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zt = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zt != null) {
            this.Zt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Zu = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Zu;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.emY != null && this.enc.getVisibility() == 0) {
            this.emY.setFocusable(true);
            this.emY.setFocusableInTouchMode(true);
            this.emY.requestFocus();
            l.showSoftKeyPad(getContext(), this.emY);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.emY, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.emY, R.drawable.edittext_cursor);
            this.emY.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.emY, R.drawable.edittext_cursor_1);
            this.emY.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setBackgroundResource(this.bjq, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bjq.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            am.setViewTextColor(this.bjq, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.emY.getSelectionStart() > 0) {
                        String substring = this.emY.getText().toString().substring(0, this.emY.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gZq.matcher(substring);
                        if (matcher.find()) {
                            this.emY.getText().delete(this.emY.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.emY.getSelectionStart());
                            break;
                        } else {
                            this.emY.getText().delete(this.emY.getSelectionStart() - 1, this.emY.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.emY.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.emY.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.emY.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.emY.setSelection(TopicDetaiInputContainer.this.emY.getText().length());
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
                        this.emY.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eni[0] = 0;
                    this.eni[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.elV != null) {
                            if (aVar2.elV.getChosedFiles() != null) {
                                this.eni[0] = aVar2.elV.getChosedFiles().size();
                            } else {
                                this.eni[0] = 0;
                            }
                        }
                        if (this.eni[0] > 0) {
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
                    int[] iArr = this.eni;
                    iArr[0] = iArr[0] - 1;
                    if (this.eni[0] > 0) {
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
            nn(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void nn(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bjq.setEnabled(true);
            } else {
                this.bjq.setEnabled(false);
            }
        } else if (i == enj) {
            if (this.flags[1]) {
                this.bjq.setEnabled(true);
            } else {
                this.bjq.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.enh = z;
    }

    public void setHint(int i) {
        if (this.emY != null) {
            this.emY.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.emY != null) {
            this.emY.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.emY;
    }

    public TextView getSendView() {
        return this.bjq;
    }

    public LinearLayout getInputLayout() {
        return this.enc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
