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
    private EditText dyQ;
    private LinearLayout dyU;
    private boolean dyY;
    private int[] dyZ;
    private boolean dym;
    private boolean dyn;
    private boolean dyo;
    private int dyp;
    private boolean[] flags;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int dza = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dym = false;
        this.dyn = true;
        this.dyo = true;
        this.dyp = -1;
        this.dyY = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dyZ = new int[]{0, 0};
        this.Ni = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.dyU = new LinearLayout(getContext());
        this.dyU.setOrientation(0);
        this.dyU.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dyU, new LinearLayout.LayoutParams(-1, -2));
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
        this.dyU.addView(this.mSendView, layoutParams);
    }

    private void dZ(Context context) {
        this.dyQ = new EditText(context);
        this.dyQ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyQ.setMaxLines(4);
        this.dyQ.setGravity(16);
        this.dyQ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dyQ.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dyQ.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dyQ.setBackgroundResource(R.color.common_color_10022);
        e(this.dyQ, R.drawable.edittext_cursor);
        this.dyQ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dyQ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dyQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.dyo) {
                    TopicDetaiInputContainer.this.dyo = true;
                    if (TopicDetaiInputContainer.this.dyp != -1) {
                        TopicDetaiInputContainer.this.dyQ.setSelection(TopicDetaiInputContainer.this.dyp);
                        TopicDetaiInputContainer.this.dyp = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.dyQ.getText().toString()));
                }
            }
        });
        this.dyQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.dyQ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.dyU.addView(this.dyQ, layoutParams);
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
            if (qVar.aJx() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dyQ.getText().toString();
            if (this.dyn && com.baidu.tieba.face.a.As(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dyQ);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dym || qVar.aJx() == EmotionGroupType.LOCAL) {
            String obj = this.dyQ.getText().toString();
            if (this.dyn && com.baidu.tieba.face.a.As(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aFL().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dyQ);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dym = z;
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
        if (this.dyQ != null && this.dyU.getVisibility() == 0) {
            this.dyQ.setFocusable(true);
            this.dyQ.setFocusableInTouchMode(true);
            this.dyQ.requestFocus();
            l.showSoftKeyPad(getContext(), this.dyQ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dyQ, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dyQ, R.drawable.edittext_cursor);
            this.dyQ.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dyQ, R.drawable.edittext_cursor_1);
            this.dyQ.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
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
                    if (this.dyQ.getSelectionStart() > 0) {
                        String substring = this.dyQ.getText().toString().substring(0, this.dyQ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gaH.matcher(substring);
                        if (matcher.find()) {
                            this.dyQ.getText().delete(this.dyQ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dyQ.getSelectionStart());
                            break;
                        } else {
                            this.dyQ.getText().delete(this.dyQ.getSelectionStart() - 1, this.dyQ.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dyQ.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dyQ.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.dyQ.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.dyQ.setSelection(TopicDetaiInputContainer.this.dyQ.getText().length());
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
                        this.dyQ.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dyZ[0] = 0;
                    this.dyZ[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dxN != null) {
                            if (aVar2.dxN.getChosedFiles() != null) {
                                this.dyZ[0] = aVar2.dxN.getChosedFiles().size();
                            } else {
                                this.dyZ[0] = 0;
                            }
                        }
                        if (this.dyZ[0] > 0) {
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
                    int[] iArr = this.dyZ;
                    iArr[0] = iArr[0] - 1;
                    if (this.dyZ[0] > 0) {
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
        } else if (i == dza) {
            if (this.flags[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.dyY = z;
    }

    public void setHint(int i) {
        if (this.dyQ != null) {
            this.dyQ.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dyQ != null) {
            this.dyQ.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.dyQ;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.dyU;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
