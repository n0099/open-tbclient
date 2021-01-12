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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes2.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools acX;
    private int acY;
    private int akf;
    private TextView bRq;
    private boolean fAF;
    private boolean fAG;
    private boolean fAH;
    private int fAI;
    private EditText fBK;
    private LinearLayout fBO;
    private boolean fBS;
    private boolean[] fBT;
    private int[] fBU;
    private View mBottomLine;
    private int mType;
    public static int fBV = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fAF = false;
        this.fAG = true;
        this.fAH = true;
        this.fAI = -1;
        this.fBS = true;
        this.fBT = new boolean[]{false, false, false, false, false};
        this.fBU = new int[]{0, 0};
        this.akf = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fBO = new LinearLayout(getContext());
        this.fBO.setOrientation(0);
        this.fBO.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fBO, new LinearLayout.LayoutParams(-1, -2));
        fo(context);
        fn(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void fn(Context context) {
        this.bRq = new TextView(context);
        this.bRq.setGravity(17);
        this.bRq.setIncludeFontPadding(false);
        this.bRq.setEnabled(false);
        this.bRq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bRq.setText(R.string.pb_send_post);
        this.bRq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fBO.addView(this.bRq, layoutParams);
    }

    private void fo(Context context) {
        this.fBK = new EditText(context);
        this.fBK.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fBK.setMaxLines(4);
        this.fBK.setGravity(16);
        this.fBK.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fBK.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fBK.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.fBK.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fBK, R.drawable.edittext_cursor);
        this.fBK.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fBK.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fBK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fAH) {
                    TopicDetaiInputContainer.this.fAH = true;
                    if (TopicDetaiInputContainer.this.fAI != -1) {
                        TopicDetaiInputContainer.this.fBK.setSelection(TopicDetaiInputContainer.this.fAI);
                        TopicDetaiInputContainer.this.fAI = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fBK.getText().toString()));
                }
            }
        });
        this.fBK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fBK.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fBO.addView(this.fBK, layoutParams);
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u)) {
            u uVar = (u) aVar.data;
            if (uVar.bwd() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fBK.getText().toString();
            if (this.fAG && com.baidu.tieba.face.a.IH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brF().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fBK);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fAF || uVar.bwd() == EmotionGroupType.LOCAL) {
            String obj = this.fBK.getText().toString();
            if (this.fAG && com.baidu.tieba.face.a.IH(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brF().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fBK);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fAF = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.fBK != null && this.fBO.getVisibility() == 0) {
            this.fBK.setFocusable(true);
            this.fBK.setFocusableInTouchMode(true);
            this.fBK.requestFocus();
            l.showSoftKeyPad(getContext(), this.fBK);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.fBK, R.color.CAM_X0105, 2, i);
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fBK, R.drawable.edittext_cursor);
            this.fBK.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            j.h(this.fBK, R.drawable.edittext_cursor_1);
            this.fBK.setHintTextColor(ao.getColor(i, R.color.CAM_X0110));
        }
        ao.setBackgroundResource(this.bRq, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bRq.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            ao.setViewTextColor(this.bRq, R.color.CAM_X0101, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fBK.getSelectionStart() > 0) {
                        String substring = this.fBK.getText().toString().substring(0, this.fBK.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iMD.matcher(substring);
                        if (matcher.find()) {
                            this.fBK.getText().delete(this.fBK.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fBK.getSelectionStart());
                            break;
                        } else {
                            this.fBK.getText().delete(this.fBK.getSelectionStart() - 1, this.fBK.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fBK.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fBK.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fBK.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fBK.setSelection(TopicDetaiInputContainer.this.fBK.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.fBT[0] = false;
                        break;
                    } else {
                        this.fBT[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fBK.setText((CharSequence) null);
                    }
                    this.fBT[0] = false;
                    this.fBT[1] = false;
                    this.fBT[2] = false;
                    this.fBT[3] = false;
                    this.fBT[4] = false;
                    this.fBU[0] = 0;
                    this.fBU[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fAg != null) {
                            if (aVar2.fAg.getChosedFiles() != null) {
                                this.fBU[0] = aVar2.fAg.getChosedFiles().size();
                            } else {
                                this.fBU[0] = 0;
                            }
                        }
                        if (this.fBU[0] > 0) {
                            this.fBT[1] = true;
                            break;
                        } else {
                            this.fBT[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fBU;
                    iArr[0] = iArr[0] - 1;
                    if (this.fBU[0] > 0) {
                        this.fBT[1] = true;
                        break;
                    } else {
                        this.fBT[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            rb(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rb(int i) {
        if (i == ALL) {
            if (this.fBT[0] || this.fBT[1] || this.fBT[2] || this.fBT[3] || this.fBT[4]) {
                this.bRq.setEnabled(true);
            } else {
                this.bRq.setEnabled(false);
            }
        } else if (i == fBV) {
            if (this.fBT[1]) {
                this.bRq.setEnabled(true);
            } else {
                this.bRq.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fBS = z;
    }

    public void setHint(int i) {
        if (this.fBK != null) {
            this.fBK.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fBK != null) {
            this.fBK.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fBK;
    }

    public TextView getSendView() {
        return this.bRq;
    }

    public LinearLayout getInputLayout() {
        return this.fBO;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
