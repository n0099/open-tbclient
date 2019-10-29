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
    private EditorTools Dl;
    private int Dm;
    private TextView ati;
    private boolean cGE;
    private boolean cGF;
    private boolean cGG;
    private int cGH;
    private EditText cHi;
    private LinearLayout cHm;
    private boolean cHq;
    private boolean[] cHr;
    private int[] cHs;
    private int csX;
    private View mBottomLine;
    private int mType;
    public static int cHt = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cGE = false;
        this.cGF = true;
        this.cGG = true;
        this.cGH = -1;
        this.cHq = true;
        this.cHr = new boolean[]{false, false, false, false, false};
        this.cHs = new int[]{0, 0};
        this.csX = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.cHm = new LinearLayout(getContext());
        this.cHm.setOrientation(0);
        this.cHm.setMinimumHeight(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds90));
        addView(this.cHm, new LinearLayout.LayoutParams(-1, -2));
        cA(context);
        cz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cz(Context context) {
        this.ati = new TextView(context);
        this.ati.setGravity(17);
        this.ati.setIncludeFontPadding(false);
        this.ati.setEnabled(false);
        this.ati.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.ati.setText(R.string.pb_send_post);
        this.ati.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds14), 0);
        this.cHm.addView(this.ati, layoutParams);
    }

    private void cA(Context context) {
        this.cHi = new EditText(context);
        this.cHi.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cHi.setMaxLines(4);
        this.cHi.setGravity(16);
        this.cHi.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.cHi.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.cHi.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.cHi.setBackgroundResource(R.color.common_color_10022);
        e(this.cHi, R.drawable.edittext_cursor);
        this.cHi.setPadding(0, com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds54), com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds24));
        this.cHi.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.cHi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.cGG) {
                    TopicDetaiInputContainer.this.cGG = true;
                    if (TopicDetaiInputContainer.this.cGH != -1) {
                        TopicDetaiInputContainer.this.cHi.setSelection(TopicDetaiInputContainer.this.cGH);
                        TopicDetaiInputContainer.this.cGH = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.cHi.getText().toString()));
                }
            }
        });
        this.cHi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.cHi.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.cHm.addView(this.cHi, layoutParams);
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
            if (pVar.apm() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.cHi.getText().toString();
            if (this.cGF && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.cHi);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cGE || pVar.apm() == EmotionGroupType.LOCAL) {
            String obj = this.cHi.getText().toString();
            if (this.cGF && com.baidu.tieba.face.a.uZ(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.alW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.cHi);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cGE = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Dl = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Dl != null) {
            this.Dl.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Dm = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Dm;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        if (this.cHi != null && this.cHm.getVisibility() == 0) {
            this.cHi.setFocusable(true);
            this.cHi.setFocusableInTouchMode(true);
            this.cHi.requestFocus();
            com.baidu.adp.lib.util.l.showSoftKeyPad(getContext(), this.cHi);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.cHi, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.cHi, R.drawable.edittext_cursor);
            this.cHi.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.cHi, R.drawable.edittext_cursor_1);
            this.cHi.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setBackgroundResource(this.ati, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.ati.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            am.setViewTextColor(this.ati, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.cHi.getSelectionStart() > 0) {
                        String substring = this.cHi.getText().toString().substring(0, this.cHi.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fhw.matcher(substring);
                        if (matcher.find()) {
                            this.cHi.getText().delete(this.cHi.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.cHi.getSelectionStart());
                            break;
                        } else {
                            this.cHi.getText().delete(this.cHi.getSelectionStart() - 1, this.cHi.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.cHi.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.cHi.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.cHi.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.cHi.setSelection(TopicDetaiInputContainer.this.cHi.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.cHr[0] = false;
                        break;
                    } else {
                        this.cHr[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.cHi.setText((CharSequence) null);
                    }
                    this.cHr[0] = false;
                    this.cHr[1] = false;
                    this.cHr[2] = false;
                    this.cHr[3] = false;
                    this.cHr[4] = false;
                    this.cHs[0] = 0;
                    this.cHs[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cGf != null) {
                            if (aVar2.cGf.getChosedFiles() != null) {
                                this.cHs[0] = aVar2.cGf.getChosedFiles().size();
                            } else {
                                this.cHs[0] = 0;
                            }
                        }
                        if (this.cHs[0] > 0) {
                            this.cHr[1] = true;
                            break;
                        } else {
                            this.cHr[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cHs;
                    iArr[0] = iArr[0] - 1;
                    if (this.cHs[0] > 0) {
                        this.cHr[1] = true;
                        break;
                    } else {
                        this.cHr[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            jT(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jT(int i) {
        if (i == ALL) {
            if (this.cHr[0] || this.cHr[1] || this.cHr[2] || this.cHr[3] || this.cHr[4]) {
                this.ati.setEnabled(true);
            } else {
                this.ati.setEnabled(false);
            }
        } else if (i == cHt) {
            if (this.cHr[1]) {
                this.ati.setEnabled(true);
            } else {
                this.ati.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.cHq = z;
    }

    public void setHint(int i) {
        if (this.cHi != null) {
            this.cHi.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.cHi != null) {
            this.cHi.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.cHi;
    }

    public TextView getSendView() {
        return this.ati;
    }

    public LinearLayout getInputLayout() {
        return this.cHm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
