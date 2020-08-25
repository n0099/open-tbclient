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
    private EditorTools aay;
    private int aaz;
    private int aiB;
    private TextView buB;
    private EditText eMG;
    private LinearLayout eMK;
    private boolean eMO;
    private int[] eMP;
    private boolean eMc;
    private boolean eMd;
    private boolean eMe;
    private int eMf;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int eMQ = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eMc = false;
        this.eMd = true;
        this.eMe = true;
        this.eMf = -1;
        this.eMO = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.eMP = new int[]{0, 0};
        this.aiB = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.eMK = new LinearLayout(getContext());
        this.eMK.setOrientation(0);
        this.eMK.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.eMK, new LinearLayout.LayoutParams(-1, -2));
        eg(context);
        ef(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void ef(Context context) {
        this.buB = new TextView(context);
        this.buB.setGravity(17);
        this.buB.setIncludeFontPadding(false);
        this.buB.setEnabled(false);
        this.buB.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.buB.setText(R.string.pb_send_post);
        this.buB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.eMK.addView(this.buB, layoutParams);
    }

    private void eg(Context context) {
        this.eMG = new EditText(context);
        this.eMG.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMG.setMaxLines(4);
        this.eMG.setGravity(16);
        this.eMG.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.eMG.setTextColor(getResources().getColor(R.color.cp_cont_b));
        this.eMG.setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        this.eMG.setBackgroundResource(R.color.common_color_10022);
        e(this.eMG, R.drawable.edittext_cursor);
        this.eMG.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.eMG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.eMG.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.eMe) {
                    TopicDetaiInputContainer.this.eMe = true;
                    if (TopicDetaiInputContainer.this.eMf != -1) {
                        TopicDetaiInputContainer.this.eMG.setSelection(TopicDetaiInputContainer.this.eMf);
                        TopicDetaiInputContainer.this.eMf = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.eMG.getText().toString()));
                }
            }
        });
        this.eMG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.eMG.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.eMK.addView(this.eMG, layoutParams);
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
            String obj = this.eMG.getText().toString();
            if (this.eMd && com.baidu.tieba.face.a.HD(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), tVar, this.eMG);
            }
        }
    }

    private void b(t tVar) {
        if (!this.eMc || tVar.bmP() == EmotionGroupType.LOCAL) {
            String obj = this.eMG.getText().toString();
            if (this.eMd && com.baidu.tieba.face.a.HD(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bis().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), tVar, this.eMG);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.eMc = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.aay = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.aay != null) {
            this.aay.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aaz = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aaz;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.eMG != null && this.eMK.getVisibility() == 0) {
            this.eMG.setFocusable(true);
            this.eMG.setFocusableInTouchMode(true);
            this.eMG.requestFocus();
            l.showSoftKeyPad(getContext(), this.eMG);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.eMG, R.color.cp_cont_b, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_h);
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        if (i == 0) {
            e(this.eMG, R.drawable.edittext_cursor);
            this.eMG.setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        } else {
            e(this.eMG, R.drawable.edittext_cursor_1);
            this.eMG.setHintTextColor(ap.getColor(i, R.color.cp_cont_e));
        }
        ap.setBackgroundResource(this.buB, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.buB.setTextColor(getResources().getColor(R.color.cp_cont_a));
        } else {
            ap.setViewTextColor(this.buB, R.color.cp_cont_a, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.eMG.getSelectionStart() > 0) {
                        String substring = this.eMG.getText().toString().substring(0, this.eMG.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.hEP.matcher(substring);
                        if (matcher.find()) {
                            this.eMG.getText().delete(this.eMG.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.eMG.getSelectionStart());
                            break;
                        } else {
                            this.eMG.getText().delete(this.eMG.getSelectionStart() - 1, this.eMG.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.eMG.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.eMG.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.eMG.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.eMG.setSelection(TopicDetaiInputContainer.this.eMG.getText().length());
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
                        this.eMG.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.eMP[0] = 0;
                    this.eMP[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.eLD != null) {
                            if (aVar2.eLD.getChosedFiles() != null) {
                                this.eMP[0] = aVar2.eLD.getChosedFiles().size();
                            } else {
                                this.eMP[0] = 0;
                            }
                        }
                        if (this.eMP[0] > 0) {
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
                    int[] iArr = this.eMP;
                    iArr[0] = iArr[0] - 1;
                    if (this.eMP[0] > 0) {
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
                this.buB.setEnabled(true);
            } else {
                this.buB.setEnabled(false);
            }
        } else if (i == eMQ) {
            if (this.flags[1]) {
                this.buB.setEnabled(true);
            } else {
                this.buB.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.eMO = z;
    }

    public void setHint(int i) {
        if (this.eMG != null) {
            this.eMG.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.eMG != null) {
            this.eMG.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.eMG;
    }

    public TextView getSendView() {
        return this.buB;
    }

    public LinearLayout getInputLayout() {
        return this.eMK;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
