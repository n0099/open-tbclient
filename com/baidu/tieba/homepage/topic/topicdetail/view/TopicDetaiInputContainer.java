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
    private TextView bNa;
    private boolean[] flags;
    private boolean foV;
    private boolean foW;
    private boolean foX;
    private int foY;
    private EditText fpZ;
    private LinearLayout fqd;
    private boolean fqh;
    private int[] fqi;
    private View mBottomLine;
    private int mType;
    public static int fqj = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.foV = false;
        this.foW = true;
        this.foX = true;
        this.foY = -1;
        this.fqh = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fqi = new int[]{0, 0};
        this.ajq = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fqd = new LinearLayout(getContext());
        this.fqd.setOrientation(0);
        this.fqd.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fqd, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void eo(Context context) {
        this.bNa = new TextView(context);
        this.bNa.setGravity(17);
        this.bNa.setIncludeFontPadding(false);
        this.bNa.setEnabled(false);
        this.bNa.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bNa.setText(R.string.pb_send_post);
        this.bNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fqd.addView(this.bNa, layoutParams);
    }

    private void ep(Context context) {
        this.fpZ = new EditText(context);
        this.fpZ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpZ.setMaxLines(4);
        this.fpZ.setGravity(16);
        this.fpZ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpZ.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.fpZ.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.fpZ.setBackgroundResource(R.color.common_color_10022);
        g(this.fpZ, R.drawable.edittext_cursor);
        this.fpZ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fpZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fpZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.foX) {
                    TopicDetaiInputContainer.this.foX = true;
                    if (TopicDetaiInputContainer.this.foY != -1) {
                        TopicDetaiInputContainer.this.fpZ.setSelection(TopicDetaiInputContainer.this.foY);
                        TopicDetaiInputContainer.this.foY = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fpZ.getText().toString()));
                }
            }
        });
        this.fpZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fpZ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fqd.addView(this.fpZ, layoutParams);
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
            if (uVar.buM() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fpZ.getText().toString();
            if (this.foW && com.baidu.tieba.face.a.JE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bqp().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fpZ);
            }
        }
    }

    private void b(u uVar) {
        if (!this.foV || uVar.buM() == EmotionGroupType.LOCAL) {
            String obj = this.fpZ.getText().toString();
            if (this.foW && com.baidu.tieba.face.a.JE(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bqp().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fpZ);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.foV = z;
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
        if (this.fpZ != null && this.fqd.getVisibility() == 0) {
            this.fpZ.setFocusable(true);
            this.fpZ.setFocusableInTouchMode(true);
            this.fpZ.requestFocus();
            l.showSoftKeyPad(getContext(), this.fpZ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fpZ, R.color.cp_cont_b, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            g(this.fpZ, R.drawable.edittext_cursor);
            this.fpZ.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            g(this.fpZ, R.drawable.edittext_cursor_1);
            this.fpZ.setHintTextColor(ap.getColor(i, R.color.cp_cont_e));
        }
        ap.setBackgroundResource(this.bNa, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bNa.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ap.setViewTextColor(this.bNa, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fpZ.getSelectionStart() > 0) {
                        String substring = this.fpZ.getText().toString().substring(0, this.fpZ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.itq.matcher(substring);
                        if (matcher.find()) {
                            this.fpZ.getText().delete(this.fpZ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fpZ.getSelectionStart());
                            break;
                        } else {
                            this.fpZ.getText().delete(this.fpZ.getSelectionStart() - 1, this.fpZ.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fpZ.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fpZ.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fpZ.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fpZ.setSelection(TopicDetaiInputContainer.this.fpZ.getText().length());
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
                        this.fpZ.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fqi[0] = 0;
                    this.fqi[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fow != null) {
                            if (aVar2.fow.getChosedFiles() != null) {
                                this.fqi[0] = aVar2.fow.getChosedFiles().size();
                            } else {
                                this.fqi[0] = 0;
                            }
                        }
                        if (this.fqi[0] > 0) {
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
                    int[] iArr = this.fqi;
                    iArr[0] = iArr[0] - 1;
                    if (this.fqi[0] > 0) {
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
            rw(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rw(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bNa.setEnabled(true);
            } else {
                this.bNa.setEnabled(false);
            }
        } else if (i == fqj) {
            if (this.flags[1]) {
                this.bNa.setEnabled(true);
            } else {
                this.bNa.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fqh = z;
    }

    public void setHint(int i) {
        if (this.fpZ != null) {
            this.fpZ.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fpZ != null) {
            this.fpZ.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fpZ;
    }

    public TextView getSendView() {
        return this.bNa;
    }

    public LinearLayout getInputLayout() {
        return this.fqd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
