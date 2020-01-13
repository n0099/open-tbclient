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
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes7.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, m {
    private EditorTools Fv;
    private int Fw;
    private int MH;
    private boolean dtS;
    private boolean dtT;
    private boolean dtU;
    private int dtV;
    private LinearLayout duA;
    private boolean duE;
    private int[] duF;
    private EditText duw;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int duG = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dtS = false;
        this.dtT = true;
        this.dtU = true;
        this.dtV = -1;
        this.duE = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.duF = new int[]{0, 0};
        this.MH = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.duA = new LinearLayout(getContext());
        this.duA.setOrientation(0);
        this.duA.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.duA, new LinearLayout.LayoutParams(-1, -2));
        dV(context);
        dU(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dU(Context context) {
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
        this.duA.addView(this.mSendView, layoutParams);
    }

    private void dV(Context context) {
        this.duw = new EditText(context);
        this.duw.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.duw.setMaxLines(4);
        this.duw.setGravity(16);
        this.duw.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.duw.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.duw.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.duw.setBackgroundResource(R.color.common_color_10022);
        e(this.duw, R.drawable.edittext_cursor);
        this.duw.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.duw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.duw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.dtU) {
                    TopicDetaiInputContainer.this.dtU = true;
                    if (TopicDetaiInputContainer.this.dtV != -1) {
                        TopicDetaiInputContainer.this.duw.setSelection(TopicDetaiInputContainer.this.dtV);
                        TopicDetaiInputContainer.this.dtV = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.duw.getText().toString()));
                }
            }
        });
        this.duw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.duw.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.duA.addView(this.duw, layoutParams);
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
            if (pVar.aHc() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.duw.getText().toString();
            if (this.dtT && com.baidu.tieba.face.a.Ab(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aDz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.duw);
            }
        }
    }

    private void b(p pVar) {
        if (!this.dtS || pVar.aHc() == EmotionGroupType.LOCAL) {
            String obj = this.duw.getText().toString();
            if (this.dtT && com.baidu.tieba.face.a.Ab(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aDz().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.duw);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dtS = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fv = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fv != null) {
            this.Fv.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fw = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fw;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.duw != null && this.duA.getVisibility() == 0) {
            this.duw.setFocusable(true);
            this.duw.setFocusableInTouchMode(true);
            this.duw.requestFocus();
            l.showSoftKeyPad(getContext(), this.duw);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.duw, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.duw, R.drawable.edittext_cursor);
            this.duw.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.duw, R.drawable.edittext_cursor_1);
            this.duw.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
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
                    if (this.duw.getSelectionStart() > 0) {
                        String substring = this.duw.getText().toString().substring(0, this.duw.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fYs.matcher(substring);
                        if (matcher.find()) {
                            this.duw.getText().delete(this.duw.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.duw.getSelectionStart());
                            break;
                        } else {
                            this.duw.getText().delete(this.duw.getSelectionStart() - 1, this.duw.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.duw.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.duw.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.duw.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.duw.setSelection(TopicDetaiInputContainer.this.duw.getText().length());
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
                        this.duw.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.duF[0] = 0;
                    this.duF[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dtt != null) {
                            if (aVar2.dtt.getChosedFiles() != null) {
                                this.duF[0] = aVar2.dtt.getChosedFiles().size();
                            } else {
                                this.duF[0] = 0;
                            }
                        }
                        if (this.duF[0] > 0) {
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
                    int[] iArr = this.duF;
                    iArr[0] = iArr[0] - 1;
                    if (this.duF[0] > 0) {
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
            mf(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mf(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        } else if (i == duG) {
            if (this.flags[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.duE = z;
    }

    public void setHint(int i) {
        if (this.duw != null) {
            this.duw.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.duw != null) {
            this.duw.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.duw;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.duA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
