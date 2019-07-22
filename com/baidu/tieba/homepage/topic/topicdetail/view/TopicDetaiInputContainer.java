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
    private EditorTools TU;
    private int TV;
    private int cdL;
    private EditText ctU;
    private LinearLayout ctY;
    private boolean cts;
    private boolean ctt;
    private boolean ctu;
    private int ctv;
    private boolean cuc;
    private boolean[] cud;
    private int[] cue;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int cuf = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cts = false;
        this.ctt = true;
        this.ctu = true;
        this.ctv = -1;
        this.cuc = true;
        this.cud = new boolean[]{false, false, false, false, false};
        this.cue = new int[]{0, 0};
        this.cdL = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.ctY = new LinearLayout(getContext());
        this.ctY.setOrientation(0);
        this.ctY.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.ds90));
        addView(this.ctY, new LinearLayout.LayoutParams(-1, -2));
        cO(context);
        cN(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cN(Context context) {
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
        layoutParams.setMargins(0, 0, com.baidu.adp.lib.util.l.g(context, R.dimen.tbds14), 0);
        this.ctY.addView(this.mSendView, layoutParams);
    }

    private void cO(Context context) {
        this.ctU = new EditText(context);
        this.ctU.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ctU.setMaxLines(4);
        this.ctU.setGravity(16);
        this.ctU.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.ctU.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.ctU.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.ctU.setBackgroundResource(R.color.common_color_10022);
        e(this.ctU, R.drawable.edittext_cursor);
        this.ctU.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.ctU.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.ctU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.ctu) {
                    TopicDetaiInputContainer.this.ctu = true;
                    if (TopicDetaiInputContainer.this.ctv != -1) {
                        TopicDetaiInputContainer.this.ctU.setSelection(TopicDetaiInputContainer.this.ctv);
                        TopicDetaiInputContainer.this.ctv = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.ctU.getText().toString()));
                }
            }
        });
        this.ctU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.ctU.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds14), 0, 0, 0);
        this.ctY.addView(this.ctU, layoutParams);
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
            if (pVar.amu() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.ctU.getText().toString();
            if (this.ctt && com.baidu.tieba.face.a.wb(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ahW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.ctU);
            }
        }
    }

    private void b(p pVar) {
        if (!this.cts || pVar.amu() == EmotionGroupType.LOCAL) {
            String obj = this.ctU.getText().toString();
            if (this.ctt && com.baidu.tieba.face.a.wb(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.ahW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.ctU);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.cts = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        if (this.ctU != null && this.ctY.getVisibility() == 0) {
            this.ctU.setFocusable(true);
            this.ctU.setFocusableInTouchMode(true);
            this.ctU.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.ctU);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.d(this.ctU, R.color.cp_cont_b, 2, i);
        am.l(this.mBottomLine, R.color.cp_bg_line_c);
        am.l(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.ctU, R.drawable.edittext_cursor);
            this.ctU.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.ctU, R.drawable.edittext_cursor_1);
            this.ctU.setHintTextColor(am.getColor(i, R.color.cp_cont_e));
        }
        am.k(this.mSendView, R.drawable.topic_discuss_send_bg);
        if (i == 1) {
            this.mSendView.setTextColor(getResources().getColor(R.color.cp_btn_a));
        } else {
            am.f(this.mSendView, R.color.cp_btn_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.ctU.getSelectionStart() > 0) {
                        String substring = this.ctU.getText().toString().substring(0, this.ctU.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.fcz.matcher(substring);
                        if (matcher.find()) {
                            this.ctU.getText().delete(this.ctU.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ctU.getSelectionStart());
                            break;
                        } else {
                            this.ctU.getText().delete(this.ctU.getSelectionStart() - 1, this.ctU.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.ctU.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.ctU.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.ctU.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.ctU.setSelection(TopicDetaiInputContainer.this.ctU.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.cud[0] = false;
                        break;
                    } else {
                        this.cud[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.ctU.setText((CharSequence) null);
                    }
                    this.cud[0] = false;
                    this.cud[1] = false;
                    this.cud[2] = false;
                    this.cud[3] = false;
                    this.cud[4] = false;
                    this.cue[0] = 0;
                    this.cue[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.csT != null) {
                            if (aVar2.csT.getChosedFiles() != null) {
                                this.cue[0] = aVar2.csT.getChosedFiles().size();
                            } else {
                                this.cue[0] = 0;
                            }
                        }
                        if (this.cue[0] > 0) {
                            this.cud[1] = true;
                            break;
                        } else {
                            this.cud[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cue;
                    iArr[0] = iArr[0] - 1;
                    if (this.cue[0] > 0) {
                        this.cud[1] = true;
                        break;
                    } else {
                        this.cud[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            kx(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kx(int i) {
        if (i == ALL) {
            if (this.cud[0] || this.cud[1] || this.cud[2] || this.cud[3] || this.cud[4]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        } else if (i == cuf) {
            if (this.cud[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.cuc = z;
    }

    public void setHint(int i) {
        if (this.ctU != null) {
            this.ctU.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.ctU != null) {
            this.ctU.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.ctU;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.ctY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
