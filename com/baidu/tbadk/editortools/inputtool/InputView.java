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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements y {
    private static final Pattern aAv = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    private static final Pattern aAw = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int Kf;
    private j Kg;
    private int aAA;
    private boolean aAu;
    private TextWatcher aAx;
    private boolean aAy;
    private boolean aAz;

    public InputView(Context context, boolean z) {
        super(context);
        this.Kf = 0;
        this.aAu = false;
        this.aAx = null;
        this.aAy = true;
        this.aAz = true;
        this.aAA = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(w.f.ds80));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(w.l.pb_reply_hint));
        }
        setTextSize(0, getResources().getDimensionPixelSize(w.f.ds28));
        setTextColor(getResources().getColor(w.e.cp_cont_b));
        setHintTextColor(getResources().getColor(w.e.cp_cont_e));
        setBackgroundResource(w.g.foot_bar_input);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(w.f.ds20);
        setPadding(dimensionPixelSize, context.getResources().getDimensionPixelSize(w.f.ds4), dimensionPixelSize, context.getResources().getDimensionPixelSize(w.f.ds6));
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
                        Matcher matcher = aAw.matcher(substring);
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
                        setText(fn((String) aVar.data));
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
                    if (aVar.data != null && (aVar.data instanceof l)) {
                        l lVar = (l) aVar.data;
                        if ((!this.aAu || lVar.xM() == EmotionGroupType.LOCAL) && lVar.getName() != null) {
                            String editable = getText().toString();
                            if (this.aAy && fp(editable) >= 10 && getContext() != null) {
                                com.baidu.tbadk.core.util.e.ud().showToast(w.l.too_many_face);
                                return;
                            }
                            String name = lVar.getName();
                            EmotionGroupType xM = lVar.xM();
                            if (xM == EmotionGroupType.LOCAL) {
                                if (name != null) {
                                    com.baidu.adp.lib.f.c.fM().a(name, 20, new d(this, new SpannableStringBuilder(name), xM), 0, 0, BdUniqueId.gen(), null, name, false, null);
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
                case 44:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fo((String) aVar.data);
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
        Bitmap kR = aVar.kR();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kR);
        int width = kR.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        inputView.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder fn(String str) {
        CustomResponsedMessage runTask;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = aAv.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                com.baidu.adp.lib.f.c.fM().a(group, 20, new e(this, spannableStringBuilder, start, end), 0, 0, BdUniqueId.gen(), null, group, false, null);
            }
        }
        return spannableStringBuilder;
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

    private void fo(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private static int fp(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = aAv.matcher(str);
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
        this.aAu = z;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        aq.d(this, w.g.foot_bar_input, i);
        aq.b(this, w.e.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(w.e.cp_cont_e));
        } else {
            setHintTextColor(aq.getColor(i, w.e.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        if (this.aAx != textWatcher) {
            this.aAx = textWatcher;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aAy = z;
    }
}
