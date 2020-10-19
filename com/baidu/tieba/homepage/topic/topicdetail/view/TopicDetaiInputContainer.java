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
/* loaded from: classes22.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools abj;
    private int abk;
    private int ajp;
    private TextView bEw;
    private boolean faF;
    private boolean faG;
    private boolean faH;
    private int faI;
    private EditText fbI;
    private LinearLayout fbM;
    private boolean fbQ;
    private int[] fbR;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int fbS = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.faF = false;
        this.faG = true;
        this.faH = true;
        this.faI = -1;
        this.fbQ = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fbR = new int[]{0, 0};
        this.ajp = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fbM = new LinearLayout(getContext());
        this.fbM.setOrientation(0);
        this.fbM.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fbM, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void eo(Context context) {
        this.bEw = new TextView(context);
        this.bEw.setGravity(17);
        this.bEw.setIncludeFontPadding(false);
        this.bEw.setEnabled(false);
        this.bEw.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bEw.setText(R.string.pb_send_post);
        this.bEw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fbM.addView(this.bEw, layoutParams);
    }

    private void ep(Context context) {
        this.fbI = new EditText(context);
        this.fbI.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fbI.setMaxLines(4);
        this.fbI.setGravity(16);
        this.fbI.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fbI.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.fbI.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.fbI.setBackgroundResource(R.color.common_color_10022);
        g(this.fbI, R.drawable.edittext_cursor);
        this.fbI.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fbI.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fbI.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.faH) {
                    TopicDetaiInputContainer.this.faH = true;
                    if (TopicDetaiInputContainer.this.faI != -1) {
                        TopicDetaiInputContainer.this.fbI.setSelection(TopicDetaiInputContainer.this.faI);
                        TopicDetaiInputContainer.this.faI = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fbI.getText().toString()));
                }
            }
        });
        this.fbI.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fbI.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fbM.addView(this.fbI, layoutParams);
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
            if (uVar.bqt() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fbI.getText().toString();
            if (this.faG && com.baidu.tieba.face.a.IO(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.blW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fbI);
            }
        }
    }

    private void b(u uVar) {
        if (!this.faF || uVar.bqt() == EmotionGroupType.LOCAL) {
            String obj = this.fbI.getText().toString();
            if (this.faG && com.baidu.tieba.face.a.IO(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.blW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fbI);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.faF = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abj != null) {
            this.abj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abk = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abk;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fbI != null && this.fbM.getVisibility() == 0) {
            this.fbI.setFocusable(true);
            this.fbI.setFocusableInTouchMode(true);
            this.fbI.requestFocus();
            l.showSoftKeyPad(getContext(), this.fbI);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fbI, R.color.cp_cont_b, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.fbI, R.drawable.edittext_cursor);
            this.fbI.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            g(this.fbI, R.drawable.edittext_cursor_1);
            this.fbI.setHintTextColor(ap.getColor(i, R.color.cp_cont_e));
        }
        ap.setBackgroundResource(this.bEw, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bEw.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ap.setViewTextColor(this.bEw, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fbI.getSelectionStart() > 0) {
                        String substring = this.fbI.getText().toString().substring(0, this.fbI.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iaR.matcher(substring);
                        if (matcher.find()) {
                            this.fbI.getText().delete(this.fbI.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fbI.getSelectionStart());
                            break;
                        } else {
                            this.fbI.getText().delete(this.fbI.getSelectionStart() - 1, this.fbI.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fbI.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fbI.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fbI.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fbI.setSelection(TopicDetaiInputContainer.this.fbI.getText().length());
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
                        this.fbI.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fbR[0] = 0;
                    this.fbR[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fag != null) {
                            if (aVar2.fag.getChosedFiles() != null) {
                                this.fbR[0] = aVar2.fag.getChosedFiles().size();
                            } else {
                                this.fbR[0] = 0;
                            }
                        }
                        if (this.fbR[0] > 0) {
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
                    int[] iArr = this.fbR;
                    iArr[0] = iArr[0] - 1;
                    if (this.fbR[0] > 0) {
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
            rb(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rb(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bEw.setEnabled(true);
            } else {
                this.bEw.setEnabled(false);
            }
        } else if (i == fbS) {
            if (this.flags[1]) {
                this.bEw.setEnabled(true);
            } else {
                this.bEw.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fbQ = z;
    }

    public void setHint(int i) {
        if (this.fbI != null) {
            this.fbI.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fbI != null) {
            this.fbI.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fbI;
    }

    public TextView getSendView() {
        return this.bEw;
    }

    public LinearLayout getInputLayout() {
        return this.fbM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
