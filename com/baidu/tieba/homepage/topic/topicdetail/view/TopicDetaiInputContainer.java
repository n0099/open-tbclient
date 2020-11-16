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
/* loaded from: classes21.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools abp;
    private int abq;
    private int ajv;
    private TextView bLq;
    private boolean[] flags;
    private boolean fod;
    private boolean foe;
    private boolean fof;
    private int fog;
    private EditText fpg;
    private LinearLayout fpk;
    private boolean fpo;
    private int[] fpp;
    private View mBottomLine;
    private int mType;
    public static int fpq = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fod = false;
        this.foe = true;
        this.fof = true;
        this.fog = -1;
        this.fpo = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fpp = new int[]{0, 0};
        this.ajv = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fpk = new LinearLayout(getContext());
        this.fpk.setOrientation(0);
        this.fpk.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fpk, new LinearLayout.LayoutParams(-1, -2));
        ep(context);
        eo(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void eo(Context context) {
        this.bLq = new TextView(context);
        this.bLq.setGravity(17);
        this.bLq.setIncludeFontPadding(false);
        this.bLq.setEnabled(false);
        this.bLq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bLq.setText(R.string.pb_send_post);
        this.bLq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fpk.addView(this.bLq, layoutParams);
    }

    private void ep(Context context) {
        this.fpg = new EditText(context);
        this.fpg.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpg.setMaxLines(4);
        this.fpg.setGravity(16);
        this.fpg.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fpg.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fpg.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.fpg.setBackgroundResource(R.color.common_color_10022);
        g(this.fpg, R.drawable.edittext_cursor);
        this.fpg.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fpg.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fpg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fof) {
                    TopicDetaiInputContainer.this.fof = true;
                    if (TopicDetaiInputContainer.this.fog != -1) {
                        TopicDetaiInputContainer.this.fpg.setSelection(TopicDetaiInputContainer.this.fog);
                        TopicDetaiInputContainer.this.fog = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fpg.getText().toString()));
                }
            }
        });
        this.fpg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fpg.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fpk.addView(this.fpg, layoutParams);
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
            if (uVar.buc() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fpg.getText().toString();
            if (this.foe && com.baidu.tieba.face.a.Jf(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bpC().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fpg);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fod || uVar.buc() == EmotionGroupType.LOCAL) {
            String obj = this.fpg.getText().toString();
            if (this.foe && com.baidu.tieba.face.a.Jf(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bpC().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fpg);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fod = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.abp = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.abp != null) {
            this.abp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.abq = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.abq;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fpg != null && this.fpk.getVisibility() == 0) {
            this.fpg.setFocusable(true);
            this.fpg.setFocusableInTouchMode(true);
            this.fpg.requestFocus();
            l.showSoftKeyPad(getContext(), this.fpg);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fpg, R.color.CAM_X0105, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            g(this.fpg, R.drawable.edittext_cursor);
            this.fpg.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            g(this.fpg, R.drawable.edittext_cursor_1);
            this.fpg.setHintTextColor(ap.getColor(i, R.color.CAM_X0110));
        }
        ap.setBackgroundResource(this.bLq, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bLq.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            ap.setViewTextColor(this.bLq, R.color.CAM_X0101, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fpg.getSelectionStart() > 0) {
                        String substring = this.fpg.getText().toString().substring(0, this.fpg.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iue.matcher(substring);
                        if (matcher.find()) {
                            this.fpg.getText().delete(this.fpg.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fpg.getSelectionStart());
                            break;
                        } else {
                            this.fpg.getText().delete(this.fpg.getSelectionStart() - 1, this.fpg.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fpg.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fpg.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fpg.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fpg.setSelection(TopicDetaiInputContainer.this.fpg.getText().length());
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
                        this.fpg.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fpp[0] = 0;
                    this.fpp[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fnE != null) {
                            if (aVar2.fnE.getChosedFiles() != null) {
                                this.fpp[0] = aVar2.fnE.getChosedFiles().size();
                            } else {
                                this.fpp[0] = 0;
                            }
                        }
                        if (this.fpp[0] > 0) {
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
                    int[] iArr = this.fpp;
                    iArr[0] = iArr[0] - 1;
                    if (this.fpp[0] > 0) {
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
            rU(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rU(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bLq.setEnabled(true);
            } else {
                this.bLq.setEnabled(false);
            }
        } else if (i == fpq) {
            if (this.flags[1]) {
                this.bLq.setEnabled(true);
            } else {
                this.bLq.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fpo = z;
    }

    public void setHint(int i) {
        if (this.fpg != null) {
            this.fpg.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fpg != null) {
            this.fpg.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fpg;
    }

    public TextView getSendView() {
        return this.bLq;
    }

    public LinearLayout getInputLayout() {
        return this.fpk;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
