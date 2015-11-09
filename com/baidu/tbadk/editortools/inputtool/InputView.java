package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.g;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.f;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements x {
    private static final Pattern aqh = Pattern.compile("#\\([a-zA-Z0-9_\\u4E00-\\u9FA5]+\\)");
    private static final Pattern aqi = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int KA;
    private j KB;
    private boolean aqg;
    private TextWatcher aqj;
    private boolean aqk;

    public InputView(Context context, boolean z) {
        super(context);
        this.KA = 0;
        this.aqg = false;
        this.aqj = null;
        this.aqk = true;
        setMinHeight(context.getResources().getDimensionPixelSize(i.d.ds80));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(i.h.pb_reply_hint));
        }
        setTextSize(0, getResources().getDimensionPixelSize(i.d.pb_editor_edittext_textsize));
        setTextColor(getResources().getColor(i.c.cp_cont_b));
        setHintTextColor(getResources().getColor(i.c.cp_cont_e));
        setBackgroundResource(i.e.foot_bar_input);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i.d.ds20);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
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
                        Matcher matcher = aqi.matcher(substring);
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
                        p((ArrayList) aVar.data);
                        return;
                    }
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof f)) {
                        f fVar = (f) aVar.data;
                        if ((!this.aqg || fVar.wm() == EmotionGroupType.LOCAL) && fVar.getName() != null) {
                            String editable = getText().toString();
                            if (this.aqk && eV(editable) >= 10 && getContext() != null) {
                                g.tA().showToast(i.h.too_many_face);
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

    private static int eV(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = aqh.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_VALID) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_VALID, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aqg = z;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(j jVar) {
        this.KB = jVar;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.KA = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.KA;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        an.c(this, i.e.foot_bar_input, i);
        an.a(this, i.c.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(i.c.cp_cont_e));
        } else {
            setHintTextColor(an.getColor(i.c.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        this.aqj = textWatcher;
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aqk = z;
    }
}
