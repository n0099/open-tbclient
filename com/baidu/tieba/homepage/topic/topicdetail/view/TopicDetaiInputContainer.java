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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import com.baidu.tieba.write.j;
import java.util.regex.Matcher;
/* loaded from: classes22.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools acn;
    private int aco;
    private int aku;
    private TextView bQv;
    private boolean fvH;
    private boolean fvI;
    private boolean fvJ;
    private int fvK;
    private EditText fwL;
    private LinearLayout fwP;
    private boolean fwT;
    private boolean[] fwU;
    private int[] fwV;
    private View mBottomLine;
    private int mType;
    public static int fwW = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fvH = false;
        this.fvI = true;
        this.fvJ = true;
        this.fvK = -1;
        this.fwT = true;
        this.fwU = new boolean[]{false, false, false, false, false};
        this.fwV = new int[]{0, 0};
        this.aku = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fwP = new LinearLayout(getContext());
        this.fwP.setOrientation(0);
        this.fwP.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fwP, new LinearLayout.LayoutParams(-1, -2));
        eU(context);
        eT(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void eT(Context context) {
        this.bQv = new TextView(context);
        this.bQv.setGravity(17);
        this.bQv.setIncludeFontPadding(false);
        this.bQv.setEnabled(false);
        this.bQv.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bQv.setText(R.string.pb_send_post);
        this.bQv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fwP.addView(this.bQv, layoutParams);
    }

    private void eU(Context context) {
        this.fwL = new EditText(context);
        this.fwL.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fwL.setMaxLines(4);
        this.fwL.setGravity(16);
        this.fwL.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fwL.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fwL.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.fwL.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fwL, R.drawable.edittext_cursor);
        this.fwL.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fwL.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fwL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fvJ) {
                    TopicDetaiInputContainer.this.fvJ = true;
                    if (TopicDetaiInputContainer.this.fvK != -1) {
                        TopicDetaiInputContainer.this.fwL.setSelection(TopicDetaiInputContainer.this.fvK);
                        TopicDetaiInputContainer.this.fvK = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fwL.getText().toString()));
                }
            }
        });
        this.fwL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fwL.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fwP.addView(this.fwL, layoutParams);
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u)) {
            u uVar = (u) aVar.data;
            if (uVar.bxC() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fwL.getText().toString();
            if (this.fvI && com.baidu.tieba.face.a.JV(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bsW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fwL);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fvH || uVar.bxC() == EmotionGroupType.LOCAL) {
            String obj = this.fwL.getText().toString();
            if (this.fvI && com.baidu.tieba.face.a.JV(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.bsW().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fwL);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fvH = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        if (this.fwL != null && this.fwP.getVisibility() == 0) {
            this.fwL.setFocusable(true);
            this.fwL.setFocusableInTouchMode(true);
            this.fwL.requestFocus();
            l.showSoftKeyPad(getContext(), this.fwL);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fwL, R.color.CAM_X0105, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fwL, R.drawable.edittext_cursor);
            this.fwL.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            j.h(this.fwL, R.drawable.edittext_cursor_1);
            this.fwL.setHintTextColor(ap.getColor(i, R.color.CAM_X0110));
        }
        ap.setBackgroundResource(this.bQv, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bQv.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            ap.setViewTextColor(this.bQv, R.color.CAM_X0101, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fwL.getSelectionStart() > 0) {
                        String substring = this.fwL.getText().toString().substring(0, this.fwL.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iEW.matcher(substring);
                        if (matcher.find()) {
                            this.fwL.getText().delete(this.fwL.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fwL.getSelectionStart());
                            break;
                        } else {
                            this.fwL.getText().delete(this.fwL.getSelectionStart() - 1, this.fwL.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fwL.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fwL.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fwL.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fwL.setSelection(TopicDetaiInputContainer.this.fwL.getText().length());
                                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    TopicDetaiInputContainer.this.requestFocus();
                                }
                            });
                        }
                    }
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.fwU[0] = false;
                        break;
                    } else {
                        this.fwU[0] = true;
                        break;
                    }
                    break;
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        this.fwL.setText((CharSequence) null);
                    }
                    this.fwU[0] = false;
                    this.fwU[1] = false;
                    this.fwU[2] = false;
                    this.fwU[3] = false;
                    this.fwU[4] = false;
                    this.fwV[0] = 0;
                    this.fwV[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fvi != null) {
                            if (aVar2.fvi.getChosedFiles() != null) {
                                this.fwV[0] = aVar2.fvi.getChosedFiles().size();
                            } else {
                                this.fwV[0] = 0;
                            }
                        }
                        if (this.fwV[0] > 0) {
                            this.fwU[1] = true;
                            break;
                        } else {
                            this.fwU[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fwV;
                    iArr[0] = iArr[0] - 1;
                    if (this.fwV[0] > 0) {
                        this.fwU[1] = true;
                        break;
                    } else {
                        this.fwU[1] = false;
                        break;
                    }
                case 24:
                    d(aVar);
                    break;
            }
            sv(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void sv(int i) {
        if (i == ALL) {
            if (this.fwU[0] || this.fwU[1] || this.fwU[2] || this.fwU[3] || this.fwU[4]) {
                this.bQv.setEnabled(true);
            } else {
                this.bQv.setEnabled(false);
            }
        } else if (i == fwW) {
            if (this.fwU[1]) {
                this.bQv.setEnabled(true);
            } else {
                this.bQv.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fwT = z;
    }

    public void setHint(int i) {
        if (this.fwL != null) {
            this.fwL.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fwL != null) {
            this.fwL.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fwL;
    }

    public TextView getSendView() {
        return this.bQv;
    }

    public LinearLayout getInputLayout() {
        return this.fwP;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
