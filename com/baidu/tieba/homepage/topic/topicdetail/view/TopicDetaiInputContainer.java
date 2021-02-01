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
/* loaded from: classes2.dex */
public class TopicDetaiInputContainer extends LinearLayout implements View.OnClickListener, n {
    private EditorTools acR;
    private int acS;
    private int ajU;
    private TextView bUX;
    private boolean fCU;
    private boolean fCV;
    private boolean fCW;
    private int fCX;
    private EditText fDZ;
    private LinearLayout fEd;
    private boolean fEh;
    private int[] fEi;
    private boolean[] flags;
    private View mBottomLine;
    private int mType;
    public static int PICTURE = 1;
    public static int ALL = 0;

    public TopicDetaiInputContainer(Context context) {
        this(context, null);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TopicDetaiInputContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCU = false;
        this.fCV = true;
        this.fCW = true;
        this.fCX = -1;
        this.fEh = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fEi = new int[]{0, 0};
        this.ajU = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fEd = new LinearLayout(getContext());
        this.fEd.setOrientation(0);
        this.fEd.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fEd, new LinearLayout.LayoutParams(-1, -2));
        fn(context);
        fm(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void fm(Context context) {
        this.bUX = new TextView(context);
        this.bUX.setGravity(17);
        this.bUX.setIncludeFontPadding(false);
        this.bUX.setEnabled(false);
        this.bUX.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bUX.setText(R.string.pb_send_post);
        this.bUX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fEd.addView(this.bUX, layoutParams);
    }

    private void fn(Context context) {
        this.fDZ = new EditText(context);
        this.fDZ.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fDZ.setMaxLines(4);
        this.fDZ.setGravity(16);
        this.fDZ.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fDZ.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fDZ.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.fDZ.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fDZ, R.drawable.edittext_cursor);
        this.fDZ.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fDZ.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fDZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fCW) {
                    TopicDetaiInputContainer.this.fCW = true;
                    if (TopicDetaiInputContainer.this.fCX != -1) {
                        TopicDetaiInputContainer.this.fDZ.setSelection(TopicDetaiInputContainer.this.fCX);
                        TopicDetaiInputContainer.this.fCX = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fDZ.getText().toString()));
                }
            }
        });
        this.fDZ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fDZ.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fEd.addView(this.fDZ, layoutParams);
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u)) {
            u uVar = (u) aVar.data;
            if (uVar.bwv() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fDZ.getText().toString();
            if (this.fCV && com.baidu.tieba.face.a.Js(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fDZ);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fCU || uVar.bwv() == EmotionGroupType.LOCAL) {
            String obj = this.fDZ.getText().toString();
            if (this.fCV && com.baidu.tieba.face.a.Js(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brY().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fDZ);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fCU = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acR = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acR != null) {
            this.acR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acS = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acS;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fDZ != null && this.fEd.getVisibility() == 0) {
            this.fDZ.setFocusable(true);
            this.fDZ.setFocusableInTouchMode(true);
            this.fDZ.requestFocus();
            l.showSoftKeyPad(getContext(), this.fDZ);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fDZ, R.color.CAM_X0105, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fDZ, R.drawable.edittext_cursor);
            this.fDZ.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            j.h(this.fDZ, R.drawable.edittext_cursor_1);
            this.fDZ.setHintTextColor(ap.getColor(i, R.color.CAM_X0110));
        }
        ap.setBackgroundResource(this.bUX, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bUX.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            ap.setViewTextColor(this.bUX, R.color.CAM_X0101, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fDZ.getSelectionStart() > 0) {
                        String substring = this.fDZ.getText().toString().substring(0, this.fDZ.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iSk.matcher(substring);
                        if (matcher.find()) {
                            this.fDZ.getText().delete(this.fDZ.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fDZ.getSelectionStart());
                            break;
                        } else {
                            this.fDZ.getText().delete(this.fDZ.getSelectionStart() - 1, this.fDZ.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fDZ.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fDZ.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fDZ.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fDZ.setSelection(TopicDetaiInputContainer.this.fDZ.getText().length());
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
                        this.fDZ.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fEi[0] = 0;
                    this.fEi[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fCv != null) {
                            if (aVar2.fCv.getChosedFiles() != null) {
                                this.fEi[0] = aVar2.fCv.getChosedFiles().size();
                            } else {
                                this.fEi[0] = 0;
                            }
                        }
                        if (this.fEi[0] > 0) {
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
                    int[] iArr = this.fEi;
                    iArr[0] = iArr[0] - 1;
                    if (this.fEi[0] > 0) {
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
            rg(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rg(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bUX.setEnabled(true);
            } else {
                this.bUX.setEnabled(false);
            }
        } else if (i == PICTURE) {
            if (this.flags[1]) {
                this.bUX.setEnabled(true);
            } else {
                this.bUX.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fEh = z;
    }

    public void setHint(int i) {
        if (this.fDZ != null) {
            this.fDZ.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fDZ != null) {
            this.fDZ.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fDZ;
    }

    public TextView getSendView() {
        return this.bUX;
    }

    public LinearLayout getInputLayout() {
        return this.fEd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
