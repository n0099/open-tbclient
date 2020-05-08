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
    private EditorTools Zd;
    private int Ze;
    private int afW;
    private TextView bbQ;
    private EditText dYP;
    private LinearLayout dYT;
    private boolean dYX;
    private int[] dYY;
    private boolean dYl;
    private boolean dYm;
    private boolean dYn;
    private int dYo;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int dYZ = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dYl = false;
        this.dYm = true;
        this.dYn = true;
        this.dYo = -1;
        this.dYX = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.dYY = new int[]{0, 0};
        this.afW = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.dYT = new LinearLayout(getContext());
        this.dYT.setOrientation(0);
        this.dYT.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.dYT, new LinearLayout.LayoutParams(-1, -2));
        dA(context);
        dz(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void dz(Context context) {
        this.bbQ = new TextView(context);
        this.bbQ.setGravity(17);
        this.bbQ.setIncludeFontPadding(false);
        this.bbQ.setEnabled(false);
        this.bbQ.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bbQ.setText(R.string.pb_send_post);
        this.bbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.dYT.addView(this.bbQ, layoutParams);
    }

    private void dA(Context context) {
        this.dYP = new EditText(context);
        this.dYP.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYP.setMaxLines(4);
        this.dYP.setGravity(16);
        this.dYP.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.dYP.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.dYP.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.dYP.setBackgroundResource(R.color.common_color_10022);
        e(this.dYP, R.drawable.edittext_cursor);
        this.dYP.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.dYP.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.dYP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.dYn) {
                    TopicDetaiInputContainer.this.dYn = true;
                    if (TopicDetaiInputContainer.this.dYo != -1) {
                        TopicDetaiInputContainer.this.dYP.setSelection(TopicDetaiInputContainer.this.dYo);
                        TopicDetaiInputContainer.this.dYo = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.dYP.getText().toString()));
                }
            }
        });
        this.dYP.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.dYP.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.dYT.addView(this.dYP, layoutParams);
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
            if (qVar.aRV() == EmotionGroupType.NET_SUG) {
                a(qVar);
            } else {
                b(qVar);
            }
        }
    }

    private void a(q qVar) {
        if (qVar != null && !TextUtils.isEmpty(qVar.getName()) && !TextUtils.isEmpty(qVar.getUrl())) {
            String obj = this.dYP.getText().toString();
            if (this.dYm && com.baidu.tieba.face.a.Ch(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOb().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), qVar, this.dYP);
            }
        }
    }

    private void b(q qVar) {
        if (!this.dYl || qVar.aRV() == EmotionGroupType.LOCAL) {
            String obj = this.dYP.getText().toString();
            if (this.dYm && com.baidu.tieba.face.a.Ch(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.aOb().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), qVar, this.dYP);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.dYl = z;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Zd != null) {
            this.Zd.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Ze = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Ze;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.m
    public void display() {
        if (this.dYP != null && this.dYT.getVisibility() == 0) {
            this.dYP.setFocusable(true);
            this.dYP.setFocusableInTouchMode(true);
            this.dYP.requestFocus();
            l.showSoftKeyPad(getContext(), this.dYP);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        am.setViewTextColor(this.dYP, R.color.cp_cont_b, 2, i);
        am.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        am.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.dYP, R.drawable.edittext_cursor);
            this.dYP.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.dYP, R.drawable.edittext_cursor_1);
            this.dYP.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.setBackgroundResource(this.bbQ, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bbQ.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            am.setViewTextColor(this.bbQ, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.dYP.getSelectionStart() > 0) {
                        String substring = this.dYP.getText().toString().substring(0, this.dYP.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.gKE.matcher(substring);
                        if (matcher.find()) {
                            this.dYP.getText().delete(this.dYP.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.dYP.getSelectionStart());
                            break;
                        } else {
                            this.dYP.getText().delete(this.dYP.getSelectionStart() - 1, this.dYP.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.dYP.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.dYP.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.dYP.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.dYP.setSelection(TopicDetaiInputContainer.this.dYP.getText().length());
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
                        this.dYP.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.dYY[0] = 0;
                    this.dYY[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dXM != null) {
                            if (aVar2.dXM.getChosedFiles() != null) {
                                this.dYY[0] = aVar2.dXM.getChosedFiles().size();
                            } else {
                                this.dYY[0] = 0;
                            }
                        }
                        if (this.dYY[0] > 0) {
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
                    int[] iArr = this.dYY;
                    iArr[0] = iArr[0] - 1;
                    if (this.dYY[0] > 0) {
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
                this.bbQ.setEnabled(true);
            } else {
                this.bbQ.setEnabled(false);
            }
        } else if (i == dYZ) {
            if (this.flags[1]) {
                this.bbQ.setEnabled(true);
            } else {
                this.bbQ.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.dYX = z;
    }

    public void setHint(int i) {
        if (this.dYP != null) {
            this.dYP.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.dYP != null) {
            this.dYP.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.dYP;
    }

    public TextView getSendView() {
        return this.bbQ;
    }

    public LinearLayout getInputLayout() {
        return this.dYT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
