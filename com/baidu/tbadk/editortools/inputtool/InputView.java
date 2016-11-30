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
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.f;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements ab {
    private static final Pattern awi = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    private static final Pattern awj = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int EK;
    private l EL;
    private boolean awh;
    private TextWatcher awk;
    private boolean awl;
    private boolean awm;
    private int awn;

    public InputView(Context context, boolean z) {
        super(context);
        this.EK = 0;
        this.awh = false;
        this.awk = null;
        this.awl = true;
        this.awm = true;
        this.awn = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(r.e.ds80));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(r.j.pb_reply_hint));
        }
        setTextSize(0, getResources().getDimensionPixelSize(r.e.ds28));
        setTextColor(getResources().getColor(r.d.cp_cont_b));
        setHintTextColor(getResources().getColor(r.d.cp_cont_e));
        setBackgroundResource(r.f.foot_bar_input);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(r.e.ds20);
        setPadding(dimensionPixelSize, context.getResources().getDimensionPixelSize(r.e.ds4), dimensionPixelSize, context.getResources().getDimensionPixelSize(r.e.ds6));
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
                        Matcher matcher = awj.matcher(substring);
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
                        setText(fC((String) aVar.data));
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
                    if (aVar.data != null && (aVar.data instanceof com.baidu.tbadk.coreExtra.data.l)) {
                        com.baidu.tbadk.coreExtra.data.l lVar = (com.baidu.tbadk.coreExtra.data.l) aVar.data;
                        if ((!this.awh || lVar.xU() == EmotionGroupType.LOCAL) && lVar.getName() != null) {
                            String editable = getText().toString();
                            if (this.awl && fE(editable) >= 10 && getContext() != null) {
                                f.us().showToast(r.j.too_many_face);
                                return;
                            }
                            String name = lVar.getName();
                            EmotionGroupType xU = lVar.xU();
                            if (xU == EmotionGroupType.LOCAL) {
                                if (name != null) {
                                    com.baidu.adp.lib.g.c.eA().a(name, 20, new d(this, new SpannableStringBuilder(name), xU), 0, 0, BdUniqueId.gen(), null, name, false, null);
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
                        fD((String) aVar.data);
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
        Bitmap jV = aVar.jV();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(jV);
        int width = jV.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            width = (int) (0.5d * width);
        }
        bitmapDrawable.setBounds(0, 0, width, width);
        bitmapDrawable.setGravity(SocialAPIErrorCodes.ERROR_INVALID_SECRET_KEY);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        inputView.getText().insert(i, spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SpannableStringBuilder fC(String str) {
        CustomResponsedMessage runTask;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = awi.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                com.baidu.adp.lib.g.c.eA().a(group, 20, new e(this, spannableStringBuilder, start, end), 0, 0, BdUniqueId.gen(), null, group, false, null);
            }
        }
        return spannableStringBuilder;
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

    private void fD(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private static int fE(String str) {
        CustomResponsedMessage runTask;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = awi.matcher(str);
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
        this.awh = z;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EL = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        at.d(this, r.f.foot_bar_input, i);
        at.b(this, r.d.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(r.d.cp_cont_e));
        } else {
            setHintTextColor(at.getColor(i, r.d.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        if (this.awk != textWatcher) {
            this.awk = textWatcher;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.awl = z;
    }
}
