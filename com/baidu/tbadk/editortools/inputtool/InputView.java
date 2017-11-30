package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class InputView extends EditText implements s {
    private i IT;
    private int IU;
    private boolean aDn;
    private boolean aDo;
    private boolean aDp;
    private int aDq;

    public InputView(Context context, boolean z) {
        super(context);
        this.IU = 0;
        this.aDn = false;
        this.aDo = true;
        this.aDp = true;
        this.aDq = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds64));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(d.j.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        setTextColor(getResources().getColor(d.C0082d.cp_cont_f));
        setHintTextColor(getResources().getColor(d.C0082d.cp_cont_e));
        setBackgroundResource(d.C0082d.common_color_10022);
        setCursorColor(d.f.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.ds4);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!InputView.this.aDp) {
                    InputView.this.aDp = true;
                    if (InputView.this.aDq != -1) {
                        InputView.this.setSelection(InputView.this.aDq);
                        InputView.this.aDq = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null && editable.toString().trim() != null) {
                    InputView.this.b(new com.baidu.tbadk.editortools.a(4, -1, InputView.this.getText().toString()));
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    InputView.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                    InputView.this.requestFocus();
                }
                return false;
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (getSelectionStart() > 0) {
                        String substring = getText().toString().substring(0, getSelectionStart());
                        Matcher matcher = com.baidu.tieba.face.a.cvc.matcher(substring);
                        if (matcher.find()) {
                            getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                            return;
                        }
                        getText().delete(getSelectionStart() - 1, getSelectionStart());
                        return;
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        if (TextUtils.isEmpty((String) aVar.data)) {
                            setText((CharSequence) null);
                            return;
                        } else {
                            b.a(getContext(), (String) aVar.data, new b.a() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.3
                                @Override // com.baidu.tieba.face.b.a
                                public void b(SpannableStringBuilder spannableStringBuilder) {
                                    InputView.this.setText(spannableStringBuilder);
                                    InputView.this.setSelection(InputView.this.getText().length());
                                    InputView.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                    InputView.this.requestFocus();
                                }
                            });
                            return;
                        }
                    } else {
                        return;
                    }
                case 9:
                    if (((Boolean) aVar.data).booleanValue()) {
                        setText((CharSequence) null);
                        return;
                    }
                    return;
                case 17:
                    if (aVar.data != null && (aVar.data instanceof ArrayList)) {
                        p((ArrayList) aVar.data);
                        return;
                    }
                    return;
                case 24:
                    d(aVar);
                    return;
                case d.l.View_minWidth /* 44 */:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fS((String) aVar.data);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof m)) {
            m mVar = (m) aVar.data;
            if (mVar.ya() == EmotionGroupType.NET_SUG) {
                a(mVar);
            } else {
                b(mVar);
            }
        }
    }

    private void a(m mVar) {
        if (mVar != null && !TextUtils.isEmpty(mVar.getName()) && !TextUtils.isEmpty(mVar.getUrl())) {
            String obj = getText().toString();
            if (this.aDo && com.baidu.tieba.face.a.ks(obj) >= 10 && getContext() != null) {
                e.ui().showToast(d.j.too_many_face);
            } else {
                b.a(getContext(), mVar, this);
            }
        }
    }

    private void b(m mVar) {
        if (!this.aDn || mVar.ya() == EmotionGroupType.LOCAL) {
            String obj = getText().toString();
            if (this.aDo && com.baidu.tieba.face.a.ks(obj) >= 10 && getContext() != null) {
                e.ui().showToast(d.j.too_many_face);
            } else {
                b.b(getContext(), mVar, this);
            }
        }
    }

    private void p(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    getText().insert(getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    private void fS(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aDn = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    private void setCursorColor(int i) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            declaredField.set(this, Integer.valueOf(i));
        } catch (Exception e) {
            BdLog.e(e);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this, d.C0082d.cp_cont_b, 2, i);
        if (i == 0) {
            setCursorColor(d.f.edittext_cursor);
            setHintTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_e));
            return;
        }
        setCursorColor(d.f.edittext_cursor_1);
        setHintTextColor(aj.getColor(i, d.C0082d.cp_cont_e));
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aDo = z;
    }
}
