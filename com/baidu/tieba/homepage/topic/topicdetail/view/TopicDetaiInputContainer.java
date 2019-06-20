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
import com.baidu.tbadk.core.util.al;
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
    private EditorTools TA;
    private int TB;
    private int ccJ;
    private EditText csH;
    private LinearLayout csL;
    private boolean csP;
    private boolean[] csQ;
    private int[] csR;
    private boolean csf;
    private boolean csg;
    private boolean csh;
    private int csi;
    private View mBottomLine;
    private TextView mSendView;
    private int mType;
    public static int csS = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.csf = false;
        this.csg = true;
        this.csh = true;
        this.csi = -1;
        this.csP = true;
        this.csQ = new boolean[]{false, false, false, false, false};
        this.csR = new int[]{0, 0};
        this.ccJ = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.csL = new LinearLayout(getContext());
        this.csL.setOrientation(0);
        this.csL.setMinimumHeight(com.baidu.adp.lib.util.l.g(context, R.dimen.ds90));
        addView(this.csL, new LinearLayout.LayoutParams(-1, -2));
        cN(context);
        cM(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.g(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void cM(Context context) {
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
        this.csL.addView(this.mSendView, layoutParams);
    }

    private void cN(Context context) {
        this.csH = new EditText(context);
        this.csH.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csH.setMaxLines(4);
        this.csH.setGravity(16);
        this.csH.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.csH.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.csH.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.csH.setBackgroundResource(R.color.common_color_10022);
        e(this.csH, R.drawable.edittext_cursor);
        this.csH.setPadding(0, com.baidu.adp.lib.util.l.g(context, R.dimen.ds24), com.baidu.adp.lib.util.l.g(context, R.dimen.ds54), com.baidu.adp.lib.util.l.g(context, R.dimen.ds24));
        this.csH.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.csH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.csh) {
                    TopicDetaiInputContainer.this.csh = true;
                    if (TopicDetaiInputContainer.this.csi != -1) {
                        TopicDetaiInputContainer.this.csH.setSelection(TopicDetaiInputContainer.this.csi);
                        TopicDetaiInputContainer.this.csi = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.csH.getText().toString()));
                }
            }
        });
        this.csH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.csH.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(com.baidu.adp.lib.util.l.g(context, R.dimen.ds14), 0, 0, 0);
        this.csL.addView(this.csH, layoutParams);
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
            if (pVar.alp() == EmotionGroupType.NET_SUG) {
                a(pVar);
            } else {
                b(pVar);
            }
        }
    }

    private void a(p pVar) {
        if (pVar != null && !TextUtils.isEmpty(pVar.getName()) && !TextUtils.isEmpty(pVar.getUrl())) {
            String obj = this.csH.getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), pVar, this.csH);
            }
        }
    }

    private void b(p pVar) {
        if (!this.csf || pVar.alp() == EmotionGroupType.LOCAL) {
            String obj = this.csH.getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.agU().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), pVar, this.csH);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.csf = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        if (this.csH != null && this.csL.getVisibility() == 0) {
            this.csH.setFocusable(true);
            this.csH.setFocusableInTouchMode(true);
            this.csH.requestFocus();
            com.baidu.adp.lib.util.l.c(getContext(), this.csH);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this.csH, R.color.cp_cont_b, 2, i);
        al.l(this.mBottomLine, R.color.cp_bg_line_c);
        al.l(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.csH, R.drawable.edittext_cursor);
            this.csH.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.csH, R.drawable.edittext_cursor_1);
            this.csH.setHintTextColor(al.getColor(i, R.color.cp_cont_e));
        }
        al.k(this.mSendView, R.drawable.topic_discuss_send_bg);
        if (i == 1) {
            this.mSendView.setTextColor(getResources().getColor(R.color.cp_btn_a));
        } else {
            al.f(this.mSendView, R.color.cp_btn_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.csH.getSelectionStart() > 0) {
                        String substring = this.csH.getText().toString().substring(0, this.csH.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.eXy.matcher(substring);
                        if (matcher.find()) {
                            this.csH.getText().delete(this.csH.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.csH.getSelectionStart());
                            break;
                        } else {
                            this.csH.getText().delete(this.csH.getSelectionStart() - 1, this.csH.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.csH.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.csH.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.csH.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.csH.setSelection(TopicDetaiInputContainer.this.csH.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.csQ[0] = false;
                        break;
                    } else {
                        this.csQ[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.csH.setText((CharSequence) null);
                    }
                    this.csQ[0] = false;
                    this.csQ[1] = false;
                    this.csQ[2] = false;
                    this.csQ[3] = false;
                    this.csQ[4] = false;
                    this.csR[0] = 0;
                    this.csR[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.crG != null) {
                            if (aVar2.crG.getChosedFiles() != null) {
                                this.csR[0] = aVar2.crG.getChosedFiles().size();
                            } else {
                                this.csR[0] = 0;
                            }
                        }
                        if (this.csR[0] > 0) {
                            this.csQ[1] = true;
                            break;
                        } else {
                            this.csQ[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.csR;
                    iArr[0] = iArr[0] - 1;
                    if (this.csR[0] > 0) {
                        this.csQ[1] = true;
                        break;
                    } else {
                        this.csQ[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            kr(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kr(int i) {
        if (i == ALL) {
            if (this.csQ[0] || this.csQ[1] || this.csQ[2] || this.csQ[3] || this.csQ[4]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        } else if (i == csS) {
            if (this.csQ[1]) {
                this.mSendView.setEnabled(true);
            } else {
                this.mSendView.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.csP = z;
    }

    public void setHint(int i) {
        if (this.csH != null) {
            this.csH.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.csH != null) {
            this.csH.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.csH;
    }

    public TextView getSendView() {
        return this.mSendView;
    }

    public LinearLayout getInputLayout() {
        return this.csL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
