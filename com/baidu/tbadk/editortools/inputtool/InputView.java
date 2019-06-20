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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.p;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.face.b;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
/* loaded from: classes.dex */
public class InputView extends EditText implements l {
    private EditorTools TA;
    private int TB;
    private boolean csf;
    private boolean csg;
    private boolean csh;
    private int csi;

    public InputView(Context context, boolean z) {
        super(context);
        this.TB = 0;
        this.csf = false;
        this.csg = true;
        this.csh = true;
        this.csi = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(R.dimen.ds64));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(R.string.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(R.dimen.ds32));
        setTextColor(getResources().getColor(R.color.cp_cont_f));
        setHintTextColor(getResources().getColor(R.color.cp_cont_e));
        setBackgroundResource(R.color.common_color_10022);
        setCursorColor(R.drawable.edittext_cursor);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.ds4);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (!InputView.this.csh) {
                    InputView.this.csh = true;
                    if (InputView.this.csi != -1) {
                        InputView.this.setSelection(InputView.this.csi);
                        InputView.this.csi = -1;
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
                        Matcher matcher = com.baidu.tieba.face.a.eXy.matcher(substring);
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
                        y((ArrayList) aVar.data);
                        return;
                    }
                    return;
                case 24:
                    d(aVar);
                    return;
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        pU((String) aVar.data);
                        return;
                    }
                    return;
                default:
                    return;
            }
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
            String obj = getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                e.agU().showToast(R.string.too_many_face);
            } else {
                b.a(getContext(), pVar, this);
            }
        }
    }

    private void b(p pVar) {
        if (!this.csf || pVar.alp() == EmotionGroupType.LOCAL) {
            String obj = getText().toString();
            if (this.csg && com.baidu.tieba.face.a.vw(obj) >= 10 && getContext() != null) {
                e.agU().showToast(R.string.too_many_face);
            } else {
                b.b(getContext(), pVar, this);
            }
        }
    }

    private void y(ArrayList<String> arrayList) {
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

    private void pU(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
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
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        al.c(this, R.color.cp_cont_b, 2, i);
        if (i == 0) {
            setCursorColor(R.drawable.edittext_cursor);
            setHintTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
            return;
        }
        setCursorColor(R.drawable.edittext_cursor_1);
        setHintTextColor(al.getColor(i, R.color.cp_cont_e));
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.csg = z;
    }
}
