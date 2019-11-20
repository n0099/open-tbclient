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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes4.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, l {
    private EditorTools CJ;
    private int CK;
    private TextView asQ;
    private boolean cFN;
    private boolean cFO;
    private boolean cFP;
    private int cFQ;
    private boolean[] cGA;
    private int[] cGB;
    private EditText cGr;
    private LinearLayout cGv;
    private boolean cGz;
    private int csg;
    private View mBottomLine;
    private int mType;
    public static int cGC = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFN = false;
        this.cFO = true;
        this.cFP = true;
        this.cFQ = -1;
        this.cGz = true;
        this.cGA = new boolean[]{false, false, false, false, false};
        this.cGB = new int[]{0, 0};
        this.csg = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.cGv = new LinearLayout(getContext());
        this.cGv.setOrientation(0);
        this.cGv.setMinimumHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds90));
        addView(this.cGv, new LinearLayout.LayoutParams(-1, -2));
        cA(context);
        cz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cz(Context context) {
        this.asQ = new TextView(context);
        this.asQ.setGravity(17);
        this.asQ.setIncludeFontPadding(false);
        this.asQ.setEnabled(false);
        this.asQ.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.asQ.setText(R.string.pb_send_post);
        this.asQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds14), 0);
        this.cGv.addView(this.asQ, layoutParams);
    }

    private void cA(Context context) {
        this.cGr = new EditText(context);
        this.cGr.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cGr.setMaxLines(4);
        this.cGr.setGravity(16);
        this.cGr.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cGr.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.cGr.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.cGr.setBackgroundResource(R.color.common_color_10022);
        e(this.cGr, R.drawable.edittext_cursor);
        this.cGr.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds54), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24));
        this.cGr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cGr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.cFP) {
                    TopicDetaiInputContainer.this.cFP = true;
                    if (TopicDetaiInputContainer.this.cFQ != -1) {
                        TopicDetaiInputContainer.this.cGr.setSelection(TopicDetaiInputContainer.this.cFQ);
                        TopicDetaiInputContainer.this.cFQ = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.cGr.getText().toString()));
                }
            }
        });
        this.cGr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.cGr.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.cGv.addView(this.cGr, layoutParams);
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
            if (pVar.apk() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cGr.getText().toString();
            if (this.cFO && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cGr);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cFN || pVar.apk() == EmotionGroupType.LOCAL) {
            String obj = this.cGr.getText().toString();
            if (this.cFO && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cGr);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cFN = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.cGr != null && this.cGv.getVisibility() == 0) {
            this.cGr.setFocusable(true);
            this.cGr.setFocusableInTouchMode(true);
            this.cGr.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), this.cGr);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.cGr, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.cGr, R.drawable.edittext_cursor);
            this.cGr.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.cGr, R.drawable.edittext_cursor_1);
            this.cGr.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setBackgroundResource(this.asQ, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.asQ.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            am.setViewTextColor(this.asQ, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cGr.getSelectionStart() > 0) {
                        String substring = this.cGr.getText().toString().substring(0, this.cGr.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fgF.matcher(substring);
                        if (matcher.find()) {
                            this.cGr.getText().delete(this.cGr.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cGr.getSelectionStart());
                            break;
                        } else {
                            this.cGr.getText().delete(this.cGr.getSelectionStart() - 1, this.cGr.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cGr.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cGr.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.cGr.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.cGr.setSelection(TopicDetaiInputContainer.this.cGr.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.cGA[0] = false;
                        break;
                    } else {
                        this.cGA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cGr.setText((CharSequence) null);
                    }
                    this.cGA[0] = false;
                    this.cGA[1] = false;
                    this.cGA[2] = false;
                    this.cGA[3] = false;
                    this.cGA[4] = false;
                    this.cGB[0] = 0;
                    this.cGB[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cFo != null) {
                            if (aVar2.cFo.getChosedFiles() != null) {
                                this.cGB[0] = aVar2.cFo.getChosedFiles().size();
                            } else {
                                this.cGB[0] = 0;
                            }
                        }
                        if (this.cGB[0] > 0) {
                            this.cGA[1] = true;
                            break;
                        } else {
                            this.cGA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cGB;
                    iArr[0] = iArr[0] - 1;
                    if (this.cGB[0] > 0) {
                        this.cGA[1] = true;
                        break;
                    } else {
                        this.cGA[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            jS(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jS(int i) {
        if (i == ALL) {
            if (this.cGA[0] || this.cGA[1] || this.cGA[2] || this.cGA[3] || this.cGA[4]) {
                this.asQ.setEnabled(true);
            } else {
                this.asQ.setEnabled(false);
            }
        } else if (i == cGC) {
            if (this.cGA[1]) {
                this.asQ.setEnabled(true);
            } else {
                this.asQ.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.cGz = z;
    }

    public void setHint(int i) {
        if (this.cGr != null) {
            this.cGr.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cGr != null) {
            this.cGr.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.cGr;
    }

    public TextView getSendView() {
        return this.asQ;
    }

    public LinearLayout getInputLayout() {
        return this.cGv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
