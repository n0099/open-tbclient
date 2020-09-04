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
import com.baidu.tbadk.coreExtra.data.t;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
/* loaded from: classes16.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools aaA;
    private int aaB;
    private int aiD;
    private TextView buE;
    private EditText eMK;
    private LinearLayout eMO;
    private boolean eMS;
    private int[] eMT;
    private boolean eMg;
    private boolean eMh;
    private boolean eMi;
    private int eMj;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int eMU = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMg = false;
        this.eMh = true;
        this.eMi = true;
        this.eMj = -1;
        this.eMS = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eMT = new int[]{0, 0};
        this.aiD = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.eMO = new LinearLayout(getContext());
        this.eMO.setOrientation(0);
        this.eMO.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.eMO, new LinearLayout.LayoutParams(-1, -2));
        eg(context);
        ef(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void ef(Context context) {
        this.buE = new TextView(context);
        this.buE.setGravity(17);
        this.buE.setIncludeFontPadding(false);
        this.buE.setEnabled(false);
        this.buE.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.buE.setText(R.string.pb_send_post);
        this.buE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.eMO.addView(this.buE, layoutParams);
    }

    private void eg(Context context) {
        this.eMK = new EditText(context);
        this.eMK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMK.setMaxLines(4);
        this.eMK.setGravity(16);
        this.eMK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMK.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.eMK.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.eMK.setBackgroundResource(R.color.common_color_10022);
        e(this.eMK, R.drawable.edittext_cursor);
        this.eMK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.eMK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eMK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.eMi) {
                    TopicDetaiInputContainer.this.eMi = true;
                    if (TopicDetaiInputContainer.this.eMj != -1) {
                        TopicDetaiInputContainer.this.eMK.setSelection(TopicDetaiInputContainer.this.eMj);
                        TopicDetaiInputContainer.this.eMj = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.eMK.getText().toString()));
                }
            }
        });
        this.eMK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.eMK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.eMO.addView(this.eMK, layoutParams);
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
        if (aVar != null && aVar.data != null && (aVar.data instanceof t)) {
            t tVar = (t) aVar.data;
            if (tVar.bmP() == EmotionGroupType.NET_SUG) {
                a(tVar);
            } else {
                b(tVar);
            }
        }
    }

    private void a(t tVar) {
        if (tVar != null && !TextUtils.isEmpty(tVar.getName()) && !TextUtils.isEmpty(tVar.getUrl())) {
            String obj = this.eMK.getText().toString();
            if (this.eMh && com.baidu.tieba.face.a.HE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), tVar, this.eMK);
            }
        }
    }

    private void b(t tVar) {
        if (!this.eMg || tVar.bmP() == EmotionGroupType.LOCAL) {
            String obj = this.eMK.getText().toString();
            if (this.eMh && com.baidu.tieba.face.a.HE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), tVar, this.eMK);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eMg = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aaA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aaA != null) {
            this.aaA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaB = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaB;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.eMK != null && this.eMO.getVisibility() == 0) {
            this.eMK.setFocusable(true);
            this.eMK.setFocusableInTouchMode(true);
            this.eMK.requestFocus();
            l.showSoftKeyPad(getContext(), this.eMK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.eMK, R.color.cp_cont_b, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.eMK, R.drawable.edittext_cursor);
            this.eMK.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.eMK, R.drawable.edittext_cursor_1);
            this.eMK.setHintTextColor(ap.getColor(i, R.color.cp_cont_e));
        }
        ap.setBackgroundResource(this.buE, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.buE.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ap.setViewTextColor(this.buE, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eMK.getSelectionStart() > 0) {
                        String substring = this.eMK.getText().toString().substring(0, this.eMK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hEV.matcher(substring);
                        if (matcher.find()) {
                            this.eMK.getText().delete(this.eMK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eMK.getSelectionStart());
                            break;
                        } else {
                            this.eMK.getText().delete(this.eMK.getSelectionStart() - 1, this.eMK.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.eMK.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eMK.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.eMK.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.eMK.setSelection(TopicDetaiInputContainer.this.eMK.getText().length());
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
                        this.eMK.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eMT[0] = 0;
                    this.eMT[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.eLH != null) {
                            if (aVar2.eLH.getChosedFiles() != null) {
                                this.eMT[0] = aVar2.eLH.getChosedFiles().size();
                            } else {
                                this.eMT[0] = 0;
                            }
                        }
                        if (this.eMT[0] > 0) {
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
                    int[] iArr = this.eMT;
                    iArr[0] = iArr[0] - 1;
                    if (this.eMT[0] > 0) {
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
            qm(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void qm(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.buE.setEnabled(true);
            } else {
                this.buE.setEnabled(false);
            }
        } else if (i == eMU) {
            if (this.flags[1]) {
                this.buE.setEnabled(true);
            } else {
                this.buE.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.eMS = z;
    }

    public void setHint(int i) {
        if (this.eMK != null) {
            this.eMK.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.eMK != null) {
            this.eMK.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.eMK;
    }

    public TextView getSendView() {
        return this.buE;
    }

    public LinearLayout getInputLayout() {
        return this.eMO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
