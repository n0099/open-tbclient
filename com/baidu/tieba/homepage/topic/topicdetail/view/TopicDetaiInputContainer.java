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
    private EditorTools FO;
    private int FP;
    private int Ni;
    private boolean dxY;
    private boolean dxZ;
    private EditText dyC;
    private LinearLayout dyG;
    private boolean dyK;
    private int[] dyL;
    private boolean dya;
    private int dyb;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int dyM = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dxY = false;
        this.dxZ = true;
        this.dya = true;
        this.dyb = -1;
        this.dyK = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dyL = new int[]{0, 0};
        this.Ni = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.dyG = new LinearLayout(getContext());
        this.dyG.setOrientation(0);
        this.dyG.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dyG, new LinearLayout.LayoutParams(-1, -2));
        dZ(context);
        dY(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dY(Context context) {
        this.mSendView = new TextView(context);
        this.mSendView.setGravity(17);
        this.mSendView.setIncludeFontPadding(false);
        this.mSendView.setEnabled(false);
        this.mSendView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.mSendView.setText(R.string.pb_send_post);
        this.mSendView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.dyG.addView(this.mSendView, layoutParams);
    }

    private void dZ(Context context) {
        this.dyC = new EditText(context);
        this.dyC.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyC.setMaxLines(4);
        this.dyC.setGravity(16);
        this.dyC.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyC.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dyC.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dyC.setBackgroundResource(R.color.common_color_10022);
        e(this.dyC, R.drawable.edittext_cursor);
        this.dyC.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyC.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.dya) {
                    TopicDetaiInputContainer.this.dya = true;
                    if (TopicDetaiInputContainer.this.dyb != -1) {
                        TopicDetaiInputContainer.this.dyC.setSelection(TopicDetaiInputContainer.this.dyb);
                        TopicDetaiInputContainer.this.dyb = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.dyC.getText().toString()));
                }
            }
        });
        this.dyC.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.dyC.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.dyG.addView(this.dyC, layoutParams);
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
            if (qVar.aJu() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyC.getText().toString();
            if (this.dxZ && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFJ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyC);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dxY || qVar.aJu() == EmotionGroupType.LOCAL) {
            String obj = this.dyC.getText().toString();
            if (this.dxZ && com.baidu.tieba.face.a.Ar(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFJ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyC);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dxY = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.FO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.FO != null) {
            this.FO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.FP = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.FP;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dyC != null && this.dyG.getVisibility() == 0) {
            this.dyC.setFocusable(true);
            this.dyC.setFocusableInTouchMode(true);
            this.dyC.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyC);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dyC, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dyC, R.drawable.edittext_cursor);
            this.dyC.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dyC, R.drawable.edittext_cursor_1);
            this.dyC.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setBackgroundResource(this.mSendView, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.mSendView.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            am.setViewTextColor(this.mSendView, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dyC.getSelectionStart() > 0) {
                        String substring = this.dyC.getText().toString().substring(0, this.dyC.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gas.matcher(substring);
                        if (matcher.find()) {
                            this.dyC.getText().delete(this.dyC.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyC.getSelectionStart());
                            break;
                        } else {
                            this.dyC.getText().delete(this.dyC.getSelectionStart() - 1, this.dyC.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dyC.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyC.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.dyC.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.dyC.setSelection(TopicDetaiInputContainer.this.dyC.getText().length());
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
                        this.dyC.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dyL[0] = 0;
                    this.dyL[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dxz != null) {
                            if (aVar2.dxz.getChosedFiles() != null) {
                                this.dyL[0] = aVar2.dxz.getChosedFiles().size();
                            } else {
                                this.dyL[0] = 0;
                            }
                        }
                        if (this.dyL[0] > 0) {
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
                    int[] iArr = this.dyL;
                    iArr[0] = iArr[0] - 1;
                    if (this.dyL[0] > 0) {
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
            mx(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mx(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        } else if (i == dyM) {
            if (this.flags[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.dyK = z;
    }

    public void setHint(int i) {
        if (this.dyC != null) {
            this.dyC.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dyC != null) {
            this.dyC.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.dyC;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.dyG;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
