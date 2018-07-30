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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class InputView extends EditText implements l {
    private EditorTools Qg;
    private int Qh;
    private boolean aND;
    private boolean aNE;
    private boolean aNF;
    private int aNG;

    public InputView(Context context, boolean z) {
        super(context);
        this.Qh = 0;
        this.aND = false;
        this.aNE = true;
        this.aNF = true;
        this.aNG = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds64));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(d.j.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        setTextColor(getResources().getColor(d.C0140d.cp_cont_f));
        setHintTextColor(getResources().getColor(d.C0140d.cp_cont_e));
        setBackgroundResource(d.C0140d.common_color_10022);
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
                if (!InputView.this.aNF) {
                    InputView.this.aNF = true;
                    if (InputView.this.aNG != -1) {
                        InputView.this.setSelection(InputView.this.aNG);
                        InputView.this.aNG = -1;
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
                        Matcher matcher = com.baidu.tieba.face.a.cVj.matcher(substring);
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
                                public void a(SpannableStringBuilder spannableStringBuilder) {
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
                        t((ArrayList) aVar.data);
                        return;
                    }
                    return;
                case 24:
                    d(aVar);
                    return;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        gG((String) aVar.data);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void d(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null && aVar.data != null && (aVar.data instanceof n)) {
            n nVar = (n) aVar.data;
            if (nVar.Cl() == EmotionGroupType.NET_SUG) {
                a(nVar);
            } else {
                b(nVar);
            }
        }
    }

    private void a(n nVar) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl())) {
            String obj = getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lA(obj) >= 10 && getContext() != null) {
                e.ye().showToast(d.j.too_many_face);
            } else {
                b.a(getContext(), nVar, this);
            }
        }
    }

    private void b(n nVar) {
        if (!this.aND || nVar.Cl() == EmotionGroupType.LOCAL) {
            String obj = getText().toString();
            if (this.aNE && com.baidu.tieba.face.a.lA(obj) >= 10 && getContext() != null) {
                e.ye().showToast(d.j.too_many_face);
            } else {
                b.b(getContext(), nVar, this);
            }
        }
    }

    private void t(ArrayList<String> arrayList) {
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

    private void gG(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aND = z;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
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

    @Override // com.baidu.tbadk.editortools.l
    public void oF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        am.b(this, d.C0140d.cp_cont_b, 2, i);
        if (i == 0) {
            setCursorColor(d.f.edittext_cursor);
            setHintTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_e));
            return;
        }
        setCursorColor(d.f.edittext_cursor_1);
        setHintTextColor(am.getColor(i, d.C0140d.cp_cont_e));
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aNE = z;
    }
}
