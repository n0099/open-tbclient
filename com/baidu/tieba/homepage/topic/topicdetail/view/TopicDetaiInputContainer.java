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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.q;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes16.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, m {
    private EditorTools ZS;
    private int ZT;
    private int aho;
    private TextView boO;
    private boolean eBD;
    private boolean eBE;
    private boolean eBF;
    private int eBG;
    private EditText eCh;
    private LinearLayout eCl;
    private boolean eCp;
    private int[] eCq;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int eCr = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eBD = false;
        this.eBE = true;
        this.eBF = true;
        this.eBG = -1;
        this.eCp = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eCq = new int[]{0, 0};
        this.aho = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.eCl = new LinearLayout(getContext());
        this.eCl.setOrientation(0);
        this.eCl.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.eCl, new LinearLayout.LayoutParams(-1, -2));
        dX(context);
        dW(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dW(Context context) {
        this.boO = new TextView(context);
        this.boO.setGravity(17);
        this.boO.setIncludeFontPadding(false);
        this.boO.setEnabled(false);
        this.boO.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.boO.setText(R.string.pb_send_post);
        this.boO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.eCl.addView(this.boO, layoutParams);
    }

    private void dX(Context context) {
        this.eCh = new EditText(context);
        this.eCh.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eCh.setMaxLines(4);
        this.eCh.setGravity(16);
        this.eCh.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eCh.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.eCh.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.eCh.setBackgroundResource(R.color.common_color_10022);
        e(this.eCh, R.drawable.edittext_cursor);
        this.eCh.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.eCh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eCh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.eBF) {
                    TopicDetaiInputContainer.this.eBF = true;
                    if (TopicDetaiInputContainer.this.eBG != -1) {
                        TopicDetaiInputContainer.this.eCh.setSelection(TopicDetaiInputContainer.this.eBG);
                        TopicDetaiInputContainer.this.eBG = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.eCh.getText().toString()));
                }
            }
        });
        this.eCh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.eCh.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.eCl.addView(this.eCh, layoutParams);
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
            if (qVar.bef() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.eCh.getText().toString();
            if (this.eBE && com.baidu.tieba.face.a.Fc(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aZX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.eCh);
            }
        }
    }

    private void b(q qVar) {
        if (!this.eBD || qVar.bef() == EmotionGroupType.LOCAL) {
            String obj = this.eCh.getText().toString();
            if (this.eBE && com.baidu.tieba.face.a.Fc(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aZX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.eCh);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eBD = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZS = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZS != null) {
            this.ZS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZT = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZT;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.eCh != null && this.eCl.getVisibility() == 0) {
            this.eCh.setFocusable(true);
            this.eCh.setFocusableInTouchMode(true);
            this.eCh.requestFocus();
            l.showSoftKeyPad(getContext(), this.eCh);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.eCh, R.color.cp_cont_b, 2, i);
        ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.eCh, R.drawable.edittext_cursor);
            this.eCh.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.eCh, R.drawable.edittext_cursor_1);
            this.eCh.setHintTextColor(ao.getColor(i, R.color.cp_cont_e));
        }
        ao.setBackgroundResource(this.boO, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.boO.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ao.setViewTextColor(this.boO, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eCh.getSelectionStart() > 0) {
                        String substring = this.eCh.getText().toString().substring(0, this.eCh.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hrz.matcher(substring);
                        if (matcher.find()) {
                            this.eCh.getText().delete(this.eCh.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eCh.getSelectionStart());
                            break;
                        } else {
                            this.eCh.getText().delete(this.eCh.getSelectionStart() - 1, this.eCh.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.eCh.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eCh.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.eCh.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.eCh.setSelection(TopicDetaiInputContainer.this.eCh.getText().length());
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
                        this.eCh.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eCq[0] = 0;
                    this.eCq[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.eBe != null) {
                            if (aVar2.eBe.getChosedFiles() != null) {
                                this.eCq[0] = aVar2.eBe.getChosedFiles().size();
                            } else {
                                this.eCq[0] = 0;
                            }
                        }
                        if (this.eCq[0] > 0) {
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
                    int[] iArr = this.eCq;
                    iArr[0] = iArr[0] - 1;
                    if (this.eCq[0] > 0) {
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
            ob(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void ob(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.boO.setEnabled(true);
            } else {
                this.boO.setEnabled(false);
            }
        } else if (i == eCr) {
            if (this.flags[1]) {
                this.boO.setEnabled(true);
            } else {
                this.boO.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.eCp = z;
    }

    public void setHint(int i) {
        if (this.eCh != null) {
            this.eCh.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.eCh != null) {
            this.eCh.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.eCh;
    }

    public TextView getSendView() {
        return this.boO;
    }

    public LinearLayout getInputLayout() {
        return this.eCl;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
