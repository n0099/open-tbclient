package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.h;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements ab {
    private static final Pattern aqZ = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    private static final Pattern ara = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int BU;
    private l BV;
    private boolean aqY;
    private TextWatcher arb;
    private boolean arc;
    private boolean ard;
    private int are;

    public InputView(Context context, boolean z) {
        super(context);
        this.BU = 0;
        this.aqY = false;
        this.arb = null;
        this.arc = true;
        this.ard = true;
        this.are = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(t.e.ds80));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(t.j.pb_reply_hint));
        }
        setTextSize(0, getResources().getDimensionPixelSize(t.e.pb_editor_edittext_textsize));
        setTextColor(getResources().getColor(t.d.cp_cont_b));
        setHintTextColor(getResources().getColor(t.d.cp_cont_e));
        setBackgroundResource(t.f.foot_bar_input);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(t.e.ds20);
        setPadding(dimensionPixelSize, context.getResources().getDimensionPixelSize(t.e.ds4), dimensionPixelSize, context.getResources().getDimensionPixelSize(t.e.ds6));
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
                        Matcher matcher = ara.matcher(substring);
                        if (matcher.find()) {
                            getText().delete(getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), getSelectionStart());
                            return;
                        } else {
                            getText().delete(getSelectionStart() - 1, getSelectionStart());
                            return;
                        }
                    }
                    return;
                case 6:
                    if (aVar.data == null) {
                        setText((CharSequence) null);
                        return;
                    } else if (aVar.data instanceof String) {
                        setText(fq((String) aVar.data));
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
                        o((ArrayList) aVar.data);
                        return;
                    }
                    return;
                case 24:
                    if (aVar.data != null && (aVar.data instanceof h)) {
                        h hVar = (h) aVar.data;
                        if ((!this.aqY || hVar.wy() == EmotionGroupType.LOCAL) && hVar.getName() != null) {
                            String editable = getText().toString();
                            if (this.arc && fr(editable) >= 10 && getContext() != null) {
                                f.sX().showToast(t.j.too_many_face);
                                return;
                            }
                            String name = hVar.getName();
                            EmotionGroupType wy = hVar.wy();
                            if (wy == EmotionGroupType.LOCAL) {
                                if (name != null) {
                                    com.baidu.adp.lib.g.c.dF().a(name, 20, new d(this, new SpannableStringBuilder(name), wy), 0, 0, BdUniqueId.gen(), null, name, false, null);
                                    return;
                                }
                                return;
                            }
                            getText().insert(getSelectionStart(), name);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap iY = aVar.iY();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(iY);
        int width = iY.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        inputView.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder fq(String str) {
        CustomResponsedMessage runTask;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = aqZ.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                com.baidu.adp.lib.g.c.dF().a(group, 20, new e(this, spannableStringBuilder, start, end), 0, 0, BdUniqueId.gen(), null, group, false, null);
            }
        }
        return spannableStringBuilder;
    }

    private void o(ArrayList<String> arrayList) {
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

    private static int fr(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = aqZ.matcher(str);
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
        this.aqY = z;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BV = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        at.d(this, t.f.foot_bar_input, i);
        at.b(this, t.d.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(t.d.cp_cont_e));
        } else {
            setHintTextColor(at.getColor(t.d.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        if (this.arb != textWatcher) {
            this.arb = textWatcher;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.arc = z;
    }
}
