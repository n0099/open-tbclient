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
    private EditorTools ael;
    private int aem;
    private int aln;
    private TextView bWx;
    private boolean fEt;
    private boolean fEu;
    private boolean fEv;
    private int fEw;
    private LinearLayout fFC;
    private boolean fFG;
    private int[] fFH;
    private EditText fFy;
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
        this.fEt = false;
        this.fEu = true;
        this.fEv = true;
        this.fEw = -1;
        this.fFG = true;
        this.flags = new boolean[]{false, false, false, false, false};
        this.fFH = new int[]{0, 0};
        this.aln = 0;
        this.mType = ALL;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(1);
        setGravity(48);
        setMinimumHeight(context.getResources().getDimensionPixelSize(R.dimen.ds90));
        this.fFC = new LinearLayout(getContext());
        this.fFC.setOrientation(0);
        this.fFC.setMinimumHeight(l.getDimens(context, R.dimen.ds90));
        addView(this.fFC, new LinearLayout.LayoutParams(-1, -2));
        fm(context);
        fl(context);
        this.mBottomLine = new View(getContext());
        this.mBottomLine.setLayoutParams(new LinearLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.ds1)));
        addView(this.mBottomLine);
    }

    private void fl(Context context) {
        this.bWx = new TextView(context);
        this.bWx.setGravity(17);
        this.bWx.setIncludeFontPadding(false);
        this.bWx.setEnabled(false);
        this.bWx.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.tbds42));
        this.bWx.setText(R.string.pb_send_post);
        this.bWx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, l.getDimens(context, R.dimen.tbds14), 0);
        this.fFC.addView(this.bWx, layoutParams);
    }

    private void fm(Context context) {
        this.fFy = new EditText(context);
        this.fFy.setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fFy.setMaxLines(4);
        this.fFy.setGravity(16);
        this.fFy.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        this.fFy.setTextColor(getResources().getColor(R.color.CAM_X0105));
        this.fFy.setHintTextColor(getResources().getColor(R.color.CAM_X0110));
        this.fFy.setBackgroundResource(R.color.common_color_10022);
        j.h(this.fFy, R.drawable.edittext_cursor);
        this.fFy.setPadding(0, l.getDimens(context, R.dimen.ds24), l.getDimens(context, R.dimen.ds54), l.getDimens(context, R.dimen.ds24));
        this.fFy.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        this.fFy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!TopicDetaiInputContainer.this.fEv) {
                    TopicDetaiInputContainer.this.fEv = true;
                    if (TopicDetaiInputContainer.this.fEw != -1) {
                        TopicDetaiInputContainer.this.fFy.setSelection(TopicDetaiInputContainer.this.fEw);
                        TopicDetaiInputContainer.this.fEw = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(4, -1, TopicDetaiInputContainer.this.fFy.getText().toString()));
                }
            }
        });
        this.fFy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    TopicDetaiInputContainer.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    TopicDetaiInputContainer.this.fFy.requestFocus();
                }
                return false;
            }
        });
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        layoutParams.setMargins(l.getDimens(context, R.dimen.ds14), 0, 0, 0);
        this.fFC.addView(this.fFy, layoutParams);
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof u)) {
            u uVar = (u) aVar.data;
            if (uVar.bwy() == EmotionGroupType.NET_SUG) {
                a(uVar);
            } else {
                b(uVar);
            }
        }
    }

    private void a(u uVar) {
        if (uVar != null && !TextUtils.isEmpty(uVar.getName()) && !TextUtils.isEmpty(uVar.getUrl())) {
            String obj = this.fFy.getText().toString();
            if (this.fEu && com.baidu.tieba.face.a.JC(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brZ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.a(getContext(), uVar, this.fFy);
            }
        }
    }

    private void b(u uVar) {
        if (!this.fEt || uVar.bwy() == EmotionGroupType.LOCAL) {
            String obj = this.fFy.getText().toString();
            if (this.fEu && com.baidu.tieba.face.a.JC(obj) >= 10 && getContext() != null) {
                com.baidu.tbadk.core.util.e.brZ().showToast(R.string.too_many_face);
            } else {
                com.baidu.tieba.face.b.b(getContext(), uVar, this.fFy);
            }
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.fEt = z;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.ael != null) {
            this.ael.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aem = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aem;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.n
    public void display() {
        if (this.fFy != null && this.fFC.getVisibility() == 0) {
            this.fFy.setFocusable(true);
            this.fFy.setFocusableInTouchMode(true);
            this.fFy.requestFocus();
            l.showSoftKeyPad(getContext(), this.fFy);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        ap.setViewTextColor(this.fFy, R.color.CAM_X0105, 2, i);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0207);
        ap.setBackgroundColor(this, R.color.CAM_X0201);
        if (i == 0) {
            j.h(this.fFy, R.drawable.edittext_cursor);
            this.fFy.setHintTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
        } else {
            j.h(this.fFy, R.drawable.edittext_cursor_1);
            this.fFy.setHintTextColor(ap.getColor(i, R.color.CAM_X0110));
        }
        ap.setBackgroundResource(this.bWx, R.drawable.topic_discuss_send_bg);
        if (i == 1 || i == 4) {
            this.bWx.setTextColor(getResources().getColor(R.color.CAM_X0101));
        } else {
            ap.setViewTextColor(this.bWx, R.color.CAM_X0101, 1);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (this.fFy.getSelectionStart() > 0) {
                        String substring = this.fFy.getText().toString().substring(0, this.fFy.getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.iUh.matcher(substring);
                        if (matcher.find()) {
                            this.fFy.getText().delete(this.fFy.getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.fFy.getSelectionStart());
                            break;
                        } else {
                            this.fFy.getText().delete(this.fFy.getSelectionStart() - 1, this.fFy.getSelectionStart());
                            break;
                        }
                    }
                    break;
                case 6:
                    if (aVar.data == null) {
                        this.fFy.setText((CharSequence) null);
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            this.fFy.setText((CharSequence) null);
                        } else {
                            com.baidu.tieba.face.b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer.4
                                @Override // com.baidu.tieba.face.b.a
                                public void d(SpannableStringBuilder spannableStringBuilder) {
                                    TopicDetaiInputContainer.this.fFy.setText(spannableStringBuilder);
                                    TopicDetaiInputContainer.this.fFy.setSelection(TopicDetaiInputContainer.this.fFy.getText().length());
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
                        this.fFy.setText((CharSequence) null);
                    }
                    this.flags[0] = false;
                    this.flags[1] = false;
                    this.flags[2] = false;
                    this.flags[3] = false;
                    this.flags[4] = false;
                    this.fFH[0] = 0;
                    this.fFH[1] = 0;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fDU != null) {
                            if (aVar2.fDU.getChosedFiles() != null) {
                                this.fFH[0] = aVar2.fDU.getChosedFiles().size();
                            } else {
                                this.fFH[0] = 0;
                            }
                        }
                        if (this.fFH[0] > 0) {
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
                    int[] iArr = this.fFH;
                    iArr[0] = iArr[0] - 1;
                    if (this.fFH[0] > 0) {
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
            rh(this.mType);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rh(int i) {
        if (i == ALL) {
            if (this.flags[0] || this.flags[1] || this.flags[2] || this.flags[3] || this.flags[4]) {
                this.bWx.setEnabled(true);
            } else {
                this.bWx.setEnabled(false);
            }
        } else if (i == PICTURE) {
            if (this.flags[1]) {
                this.bWx.setEnabled(true);
            } else {
                this.bWx.setEnabled(false);
            }
        }
    }

    public void setHasHint(boolean z) {
        this.fFG = z;
    }

    public void setHint(int i) {
        if (this.fFy != null) {
            this.fFy.setHint(getContext().getString(i));
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.fFy != null) {
            this.fFy.setHint(charSequence);
        }
    }

    public EditText getInputView() {
        return this.fFy;
    }

    public TextView getSendView() {
        return this.bWx;
    }

    public LinearLayout getInputLayout() {
        return this.fFC;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
