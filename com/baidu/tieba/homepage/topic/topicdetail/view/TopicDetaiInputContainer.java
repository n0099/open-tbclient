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
    private EditorTools acZ;
    private int ada;
    private int akW;
    private TextView bWc;
    private boolean fFn;
    private boolean fFo;
    private boolean fFp;
    private int fFq;
    private boolean[] fGA;
    private int[] fGB;
    private EditText fGr;
    private LinearLayout fGv;
    private boolean fGz;
    private View mBottomLine;
    private int mType;
    public static int fGC = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fFn = false;
        this.fFo = true;
        this.fFp = true;
        this.fFq = -1;
        this.fGz = true;
        this.fGA = new boolean[]{false, false, false, false, false};
        this.fGB = new int[]{0, 0};
        this.akW = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fGv = new LinearLayout(getContext());
        this.fGv.setOrientation(0);
        this.fGv.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fGv, new LinearLayout.LayoutParams(-1, -2));
        fq(context);
        fp(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void fp(Context context) {
        this.bWc = new TextView(context);
        this.bWc.setGravity(17);
        this.bWc.setIncludeFontPadding(false);
        this.bWc.setEnabled(false);
        this.bWc.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bWc.setText(R.string.pb_send_post);
        this.bWc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fGv.addView(this.bWc, layoutParams);
    }

    private void fq(Context context) {
        this.fGr = new EditText(context);
        this.fGr.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fGr.setMaxLines(4);
        this.fGr.setGravity(16);
        this.fGr.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fGr.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fGr.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.fGr.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fGr, R.drawable.edittext_cursor);
        this.fGr.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fGr.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fGr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fFp) {
                    TopicDetaiInputContainer.this.fFp = true;
                    if (TopicDetaiInputContainer.this.fFq != -1) {
                        TopicDetaiInputContainer.this.fGr.setSelection(TopicDetaiInputContainer.this.fFq);
                        TopicDetaiInputContainer.this.fFq = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fGr.getText().toString()));
                }
            }
        });
        this.fGr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fGr.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fGv.addView(this.fGr, layoutParams);
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u)) {
            u uVar = (u) aVar.data;
            if (uVar.bzW() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fGr.getText().toString();
            if (this.fFo && com.baidu.tieba.face.a.JT(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bvy().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fGr);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fFn || uVar.bzW() == EmotionGroupType.LOCAL) {
            String obj = this.fGr.getText().toString();
            if (this.fFo && com.baidu.tieba.face.a.JT(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bvy().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fGr);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fFn = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acZ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acZ != null) {
            this.acZ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.ada = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.ada;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        if (this.fGr != null && this.fGv.getVisibility() == 0) {
            this.fGr.setFocusable(true);
            this.fGr.setFocusableInTouchMode(true);
            this.fGr.requestFocus();
            l.showSoftKeyPad(getContext(), this.fGr);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ao.setViewTextColor(this.fGr, R.color.CAM_X0105, 2, i);
        ao.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207);
        ao.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fGr, R.drawable.edittext_cursor);
            this.fGr.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            j.h(this.fGr, R.drawable.edittext_cursor_1);
            this.fGr.setHintTextColor(ao.getColor(i, R.color.CAM_X0110));
        }
        ao.setBackgroundResource(this.bWc, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bWc.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            ao.setViewTextColor(this.bWc, R.color.CAM_X0101, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fGr.getSelectionStart() > 0) {
                        String substring = this.fGr.getText().toString().substring(0, this.fGr.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iRk.matcher(substring);
                        if (matcher.find()) {
                            this.fGr.getText().delete(this.fGr.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fGr.getSelectionStart());
                            break;
                        } else {
                            this.fGr.getText().delete(this.fGr.getSelectionStart() - 1, this.fGr.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fGr.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fGr.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fGr.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fGr.setSelection(TopicDetaiInputContainer.this.fGr.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.fGA[0] = false;
                        break;
                    } else {
                        this.fGA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fGr.setText((CharSequence) null);
                    }
                    this.fGA[0] = false;
                    this.fGA[1] = false;
                    this.fGA[2] = false;
                    this.fGA[3] = false;
                    this.fGA[4] = false;
                    this.fGB[0] = 0;
                    this.fGB[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fEO != null) {
                            if (aVar2.fEO.getChosedFiles() != null) {
                                this.fGB[0] = aVar2.fEO.getChosedFiles().size();
                            } else {
                                this.fGB[0] = 0;
                            }
                        }
                        if (this.fGB[0] > 0) {
                            this.fGA[1] = true;
                            break;
                        } else {
                            this.fGA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fGB;
                    iArr[0] = iArr[0] - 1;
                    if (this.fGB[0] > 0) {
                        this.fGA[1] = true;
                        break;
                    } else {
                        this.fGA[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            sH(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void sH(int i) {
        if (i == ALL) {
            if (this.fGA[0] || this.fGA[1] || this.fGA[2] || this.fGA[3] || this.fGA[4]) {
                this.bWc.setEnabled(true);
            } else {
                this.bWc.setEnabled(false);
            }
        } else if (i == fGC) {
            if (this.fGA[1]) {
                this.bWc.setEnabled(true);
            } else {
                this.bWc.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fGz = z;
    }

    public void setHint(int i) {
        if (this.fGr != null) {
            this.fGr.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fGr != null) {
            this.fGr.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fGr;
    }

    public TextView getSendView() {
        return this.bWc;
    }

    public LinearLayout getInputLayout() {
        return this.fGv;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
