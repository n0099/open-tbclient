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
    private EditorTools abk;
    private int abl;
    private int ajq;
    private TextView bHv;
    private boolean fje;
    private boolean fjf;
    private boolean fjg;
    private int fjh;
    private EditText fkh;
    private LinearLayout fkl;
    private boolean fkp;
    private int[] fkq;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int fkr = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fje = false;
        this.fjf = true;
        this.fjg = true;
        this.fjh = -1;
        this.fkp = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fkq = new int[]{0, 0};
        this.ajq = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fkl = new LinearLayout(getContext());
        this.fkl.setOrientation(0);
        this.fkl.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fkl, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void eo(Context context) {
        this.bHv = new TextView(context);
        this.bHv.setGravity(17);
        this.bHv.setIncludeFontPadding(false);
        this.bHv.setEnabled(false);
        this.bHv.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bHv.setText(R.string.pb_send_post);
        this.bHv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fkl.addView(this.bHv, layoutParams);
    }

    private void ep(Context context) {
        this.fkh = new EditText(context);
        this.fkh.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fkh.setMaxLines(4);
        this.fkh.setGravity(16);
        this.fkh.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fkh.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.fkh.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.fkh.setBackgroundResource(R.color.common_color_10022);
        g(this.fkh, R.drawable.edittext_cursor);
        this.fkh.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fkh.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fkh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fjg) {
                    TopicDetaiInputContainer.this.fjg = true;
                    if (TopicDetaiInputContainer.this.fjh != -1) {
                        TopicDetaiInputContainer.this.fkh.setSelection(TopicDetaiInputContainer.this.fjh);
                        TopicDetaiInputContainer.this.fjh = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fkh.getText().toString()));
                }
            }
        });
        this.fkh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fkh.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fkl.addView(this.fkh, layoutParams);
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
            if (uVar.bsm() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fkh.getText().toString();
            if (this.fjf && com.baidu.tieba.face.a.Jn(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bnP().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fkh);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fje || uVar.bsm() == EmotionGroupType.LOCAL) {
            String obj = this.fkh.getText().toString();
            if (this.fjf && com.baidu.tieba.face.a.Jn(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bnP().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fkh);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fje = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abk = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abk != null) {
            this.abk.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abl = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abl;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fkh != null && this.fkl.getVisibility() == 0) {
            this.fkh.setFocusable(true);
            this.fkh.setFocusableInTouchMode(true);
            this.fkh.requestFocus();
            l.showSoftKeyPad(getContext(), this.fkh);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fkh, R.color.cp_cont_b, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.fkh, R.drawable.edittext_cursor);
            this.fkh.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            g(this.fkh, R.drawable.edittext_cursor_1);
            this.fkh.setHintTextColor(ap.getColor(i, R.color.cp_cont_e));
        }
        ap.setBackgroundResource(this.bHv, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bHv.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ap.setViewTextColor(this.bHv, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fkh.getSelectionStart() > 0) {
                        String substring = this.fkh.getText().toString().substring(0, this.fkh.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.f3int.matcher(substring);
                        if (matcher.find()) {
                            this.fkh.getText().delete(this.fkh.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fkh.getSelectionStart());
                            break;
                        } else {
                            this.fkh.getText().delete(this.fkh.getSelectionStart() - 1, this.fkh.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fkh.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fkh.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fkh.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fkh.setSelection(TopicDetaiInputContainer.this.fkh.getText().length());
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
                        this.fkh.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fkq[0] = 0;
                    this.fkq[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fiF != null) {
                            if (aVar2.fiF.getChosedFiles() != null) {
                                this.fkq[0] = aVar2.fiF.getChosedFiles().size();
                            } else {
                                this.fkq[0] = 0;
                            }
                        }
                        if (this.fkq[0] > 0) {
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
                    int[] iArr = this.fkq;
                    iArr[0] = iArr[0] - 1;
                    if (this.fkq[0] > 0) {
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
            rm(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rm(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bHv.setEnabled(true);
            } else {
                this.bHv.setEnabled(false);
            }
        } else if (i == fkr) {
            if (this.flags[1]) {
                this.bHv.setEnabled(true);
            } else {
                this.bHv.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fkp = z;
    }

    public void setHint(int i) {
        if (this.fkh != null) {
            this.fkh.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fkh != null) {
            this.fkh.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fkh;
    }

    public TextView getSendView() {
        return this.bHv;
    }

    public LinearLayout getInputLayout() {
        return this.fkl;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
