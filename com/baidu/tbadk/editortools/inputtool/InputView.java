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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.w;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements y {
    private static final Pattern aBk = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    private static final Pattern aBl = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int JS;
    private j JT;
    private boolean aBj;
    private TextWatcher aBm;
    private boolean aBn;
    private boolean aBo;
    private int aBp;

    public InputView(Context context, boolean z) {
        super(context);
        this.JS = 0;
        this.aBj = false;
        this.aBm = null;
        this.aBn = true;
        this.aBo = true;
        this.aBp = -1;
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
                        Matcher matcher = aBl.matcher(substring);
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
                        setText(fF((String) aVar.data));
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
                        if ((!this.aBj || lVar.xW() == EmotionGroupType.LOCAL) && lVar.getName() != null) {
                            String editable = getText().toString();
                            if (this.aBn && fH(editable) >= 10 && getContext() != null) {
                                com.baidu.tbadk.core.util.e.uq().showToast(w.l.too_many_face);
                                return;
                            }
                            String name = lVar.getName();
                            EmotionGroupType xW = lVar.xW();
                            if (xW == EmotionGroupType.LOCAL || xW == EmotionGroupType.USER_COLLECT || name.startsWith("#(")) {
                                if (name != null) {
                                    com.baidu.adp.lib.f.c.fL().a(name, 20, new d(this, new SpannableStringBuilder(name), xW), 0, 0, BdUniqueId.gen(), null, name, false, null);
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
                case w.n.View_minWidth /* 44 */:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fG((String) aVar.data);
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
        Bitmap kP = aVar.kP();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kP);
        int width = kP.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i2 = (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith("#(")) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(w.f.ds80);
            int width2 = (int) (kP.getWidth() * ((dimensionPixelSize * 1.0d) / kP.getHeight()));
            if (width2 > getMeasuredWidth()) {
                width2 = (int) (kP.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        inputView.getText().insert(i, spannableStringBuilder);
    }

    private SpannableStringBuilder fF(String str) {
        CustomResponsedMessage runTask;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = aBk.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                com.baidu.adp.lib.f.c.fL().a(group, 20, new e(this, spannableStringBuilder, start, end), 0, 0, BdUniqueId.gen(), null, group, false, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5) {
                com.baidu.adp.lib.f.c.fL().a(group2, 20, new f(this, spannableStringBuilder, matcher2.start(), matcher2.end()), 0, 0, BdUniqueId.gen(), null, group2, false, null);
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

    private void fG(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private static int fH(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = aBk.matcher(str);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_VALID) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_VALID, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(str);
        while (matcher2.find()) {
            String[] split = matcher2.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5) {
                i++;
            }
        }
        return i;
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aBj = z;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        as.d(this, w.g.foot_bar_input, i);
        as.b(this, w.e.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(w.e.cp_cont_e));
        } else {
            setHintTextColor(as.getColor(i, w.e.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        if (this.aBm != textWatcher) {
            this.aBm = textWatcher;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aBn = z;
    }
}
