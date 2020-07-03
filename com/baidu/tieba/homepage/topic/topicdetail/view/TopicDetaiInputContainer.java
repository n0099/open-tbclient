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
import com.baidu.tbadk.core.util.an;
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
    private EditorTools ZX;
    private int ZY;
    private int ahx;
    private TextView bot;
    private EditText evO;
    private LinearLayout evS;
    private boolean evW;
    private int[] evX;
    private boolean evk;
    private boolean evl;
    private boolean evm;
    private int evn;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int evY = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.evk = false;
        this.evl = true;
        this.evm = true;
        this.evn = -1;
        this.evW = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.evX = new int[]{0, 0};
        this.ahx = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.evS = new LinearLayout(getContext());
        this.evS.setOrientation(0);
        this.evS.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.evS, new LinearLayout.LayoutParams(-1, -2));
        dS(context);
        dR(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dR(Context context) {
        this.bot = new TextView(context);
        this.bot.setGravity(17);
        this.bot.setIncludeFontPadding(false);
        this.bot.setEnabled(false);
        this.bot.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bot.setText(R.string.pb_send_post);
        this.bot.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.evS.addView(this.bot, layoutParams);
    }

    private void dS(Context context) {
        this.evO = new EditText(context);
        this.evO.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.evO.setMaxLines(4);
        this.evO.setGravity(16);
        this.evO.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.evO.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.evO.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.evO.setBackgroundResource(R.color.common_color_10022);
        e(this.evO, R.drawable.edittext_cursor);
        this.evO.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.evO.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.evO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.evm) {
                    TopicDetaiInputContainer.this.evm = true;
                    if (TopicDetaiInputContainer.this.evn != -1) {
                        TopicDetaiInputContainer.this.evO.setSelection(TopicDetaiInputContainer.this.evn);
                        TopicDetaiInputContainer.this.evn = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.evO.getText().toString()));
                }
            }
        });
        this.evO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.evO.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.evS.addView(this.evO, layoutParams);
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
            if (qVar.bai() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.evO.getText().toString();
            if (this.evl && com.baidu.tieba.face.a.Er(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aVX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.evO);
            }
        }
    }

    private void b(q qVar) {
        if (!this.evk || qVar.bai() == EmotionGroupType.LOCAL) {
            String obj = this.evO.getText().toString();
            if (this.evl && com.baidu.tieba.face.a.Er(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aVX().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.evO);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.evk = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.ZX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ZX != null) {
            this.ZX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.ZY = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.ZY;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.evO != null && this.evS.getVisibility() == 0) {
            this.evO.setFocusable(true);
            this.evO.setFocusableInTouchMode(true);
            this.evO.requestFocus();
            l.showSoftKeyPad(getContext(), this.evO);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        an.setViewTextColor(this.evO, R.color.cp_cont_b, 2, i);
        an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.evO, R.drawable.edittext_cursor);
            this.evO.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.evO, R.drawable.edittext_cursor_1);
            this.evO.setHintTextColor(an.getColor(i, R.color.cp_cont_e));
        }
        an.setBackgroundResource(this.bot, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bot.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            an.setViewTextColor(this.bot, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.evO.getSelectionStart() > 0) {
                        String substring = this.evO.getText().toString().substring(0, this.evO.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hlN.matcher(substring);
                        if (matcher.find()) {
                            this.evO.getText().delete(this.evO.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.evO.getSelectionStart());
                            break;
                        } else {
                            this.evO.getText().delete(this.evO.getSelectionStart() - 1, this.evO.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.evO.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.evO.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.evO.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.evO.setSelection(TopicDetaiInputContainer.this.evO.getText().length());
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
                        this.evO.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.evX[0] = 0;
                    this.evX[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.euL != null) {
                            if (aVar2.euL.getChosedFiles() != null) {
                                this.evX[0] = aVar2.euL.getChosedFiles().size();
                            } else {
                                this.evX[0] = 0;
                            }
                        }
                        if (this.evX[0] > 0) {
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
                    int[] iArr = this.evX;
                    iArr[0] = iArr[0] - 1;
                    if (this.evX[0] > 0) {
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
            nJ(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void nJ(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bot.setEnabled(true);
            } else {
                this.bot.setEnabled(false);
            }
        } else if (i == evY) {
            if (this.flags[1]) {
                this.bot.setEnabled(true);
            } else {
                this.bot.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.evW = z;
    }

    public void setHint(int i) {
        if (this.evO != null) {
            this.evO.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.evO != null) {
            this.evO.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.evO;
    }

    public TextView getSendView() {
        return this.bot;
    }

    public LinearLayout getInputLayout() {
        return this.evS;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
