package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.f;
import com.baidu.tbadk.editortools.emotiontool.t;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements w {
    private static final Pattern aru = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private static final Pattern arv = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int Ky;
    private j Kz;
    private boolean art;
    private TextWatcher arw;
    private boolean arx;

    public InputView(Context context, boolean z) {
        super(context);
        this.Ky = 0;
        this.art = false;
        this.arw = null;
        this.arx = true;
        setMinHeight(context.getResources().getDimensionPixelSize(i.d.ds80));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(i.C0057i.pb_reply_hint));
        }
        setTextSize(0, getResources().getDimensionPixelSize(i.d.pb_editor_edittext_textsize));
        setTextColor(getResources().getColor(i.c.cp_cont_b));
        setHintTextColor(getResources().getColor(i.c.cp_cont_e));
        setBackgroundResource(i.e.foot_bar_input);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i.d.ds20);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(TbConfig.READ_IMAGE_CACHE_TIMEOUT_NOT_WIFI)});
        addTextChangedListener(new b(this));
        setOnTouchListener(new c(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 3:
                    if (getSelectionStart() > 0) {
                        String substring = getText().toString().substring(0, getSelectionStart());
                        Matcher matcher = arv.matcher(substring);
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
                        setText((String) aVar.data);
                        setSelection(getText().length());
                        b(new com.baidu.tbadk.editortools.a(5, -1, null));
                        requestFocus();
                        return;
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
                        q((ArrayList) aVar.data);
                        return;
                    }
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof f)) {
                        f fVar = (f) aVar.data;
                        if ((!this.art || fVar.wu() == EmotionGroupType.LOCAL) && fVar.getName() != null) {
                            String editable = getText().toString();
                            if (this.arx && eH(editable) >= 10 && getContext() != null) {
                                g.tx().showToast(i.C0057i.too_many_face);
                                return;
                            }
                            getText().insert(getSelectionStart(), fVar.getName());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void q(ArrayList<String> arrayList) {
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

    private static int eH(String str) {
        int i = 0;
        if (str != null && str.length() != 0) {
            Matcher matcher = aru.matcher(str);
            while (matcher.find()) {
                if (t.Bc().eC(matcher.group())) {
                    i++;
                }
            }
        }
        return i;
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.art = z;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void oy() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        al.c(this, i.e.foot_bar_input, i);
        al.a(this, i.c.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(i.c.cp_cont_e));
        } else {
            setHintTextColor(al.getColor(i.c.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        this.arw = textWatcher;
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.arx = z;
    }
}
