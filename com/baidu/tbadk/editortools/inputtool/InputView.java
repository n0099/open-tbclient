package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.l;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements s {
    private static final Pattern aDC = Pattern.compile("#\\([a-zA-Z0-9_~！\\u4E00-\\u9FA5]+\\)");
    private static final Pattern aDD = Pattern.compile("#\\([^#\\)\\(]+\\)$");
    private int Ls;
    private i Lt;
    private boolean aDB;
    private TextWatcher aDE;
    private boolean aDF;
    private boolean aDG;
    private int aDH;

    public InputView(Context context, boolean z) {
        super(context);
        this.Ls = 0;
        this.aDB = false;
        this.aDE = null;
        this.aDF = true;
        this.aDG = true;
        this.aDH = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(d.f.ds80));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(d.l.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(d.f.ds28));
        setTextColor(getResources().getColor(d.e.cp_cont_b));
        setHintTextColor(getResources().getColor(d.e.cp_cont_e));
        setBackgroundResource(d.g.foot_bar_input);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.f.ds20);
        setPadding(dimensionPixelSize, context.getResources().getDimensionPixelSize(d.f.ds4), dimensionPixelSize, context.getResources().getDimensionPixelSize(d.f.ds6));
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        addTextChangedListener(new TextWatcher() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (InputView.this.aDE != null) {
                    InputView.this.aDE.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (InputView.this.aDE != null) {
                    InputView.this.aDE.onTextChanged(charSequence, i, i2, i3);
                }
                if (!InputView.this.aDG) {
                    InputView.this.aDG = true;
                    if (InputView.this.aDH != -1) {
                        InputView.this.setSelection(InputView.this.aDH);
                        InputView.this.aDH = -1;
                    }
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (InputView.this.aDE != null) {
                    InputView.this.aDE.afterTextChanged(editable);
                }
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
                        Matcher matcher = aDD.matcher(substring);
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
                        setText(fT((String) aVar.data));
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
                        if ((!this.aDB || lVar.yp() == EmotionGroupType.LOCAL) && lVar.getName() != null) {
                            String obj = getText().toString();
                            if (this.aDF && fV(obj) >= 10 && getContext() != null) {
                                e.uH().showToast(d.l.too_many_face);
                                return;
                            }
                            String name = lVar.getName();
                            final EmotionGroupType yp = lVar.yp();
                            if (yp == EmotionGroupType.LOCAL || yp == EmotionGroupType.USER_COLLECT || name.startsWith("#(")) {
                                if (name != null) {
                                    final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
                                    c.fU().a(name, 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.3
                                        /* JADX DEBUG: Method merged with bridge method */
                                        /* JADX INFO: Access modifiers changed from: protected */
                                        @Override // com.baidu.adp.lib.f.b
                                        public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str, int i) {
                                            super.onLoaded((AnonymousClass3) aVar2, str, i);
                                            if (aVar2 != null) {
                                                int selectionStart = InputView.this.getSelectionStart();
                                                if (selectionStart < 0) {
                                                    selectionStart = 0;
                                                }
                                                InputView.this.a(InputView.this, spannableStringBuilder, selectionStart, aVar2, yp);
                                            }
                                        }
                                    }, 0, 0, BdUniqueId.gen(), null, name, false, null);
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
                case d.n.View_minWidth /* 44 */:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fU((String) aVar.data);
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
        Bitmap kW = aVar.kW();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kW);
        int width = kW.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i2 = (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith("#(")) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.f.ds80);
            int width2 = (int) (kW.getWidth() * ((dimensionPixelSize * 1.0d) / kW.getHeight()));
            if (width2 > getMeasuredWidth()) {
                width2 = (int) (kW.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        inputView.getText().insert(i, spannableStringBuilder);
    }

    private SpannableStringBuilder fT(String str) {
        CustomResponsedMessage runTask;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = aDC.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            final int start = matcher.start();
            final int end = matcher.end();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                c.fU().a(group, 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.4
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                        super.onLoaded((AnonymousClass4) aVar, str2, i);
                        if (aVar != null) {
                            Bitmap kW = aVar.kW();
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(kW);
                            int width = (int) (0.5d * kW.getWidth());
                            bitmapDrawable.setBounds(0, 0, width, width);
                            bitmapDrawable.setGravity(119);
                            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), start, end, 33);
                        }
                    }
                }, 0, 0, BdUniqueId.gen(), null, group, false, null);
            }
        }
        Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
        while (matcher2.find()) {
            String group2 = matcher2.group();
            String[] split = group2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split != null && split.length == 5) {
                final int start2 = matcher2.start();
                final int end2 = matcher2.end();
                c.fU().a(group2, 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.5
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar, String str2, int i) {
                        super.onLoaded((AnonymousClass5) aVar, str2, i);
                        if (aVar != null) {
                            Bitmap kW = aVar.kW();
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(kW);
                            int dimensionPixelSize = InputView.this.getResources().getDimensionPixelSize(d.f.ds80);
                            int width = (int) (kW.getWidth() * ((dimensionPixelSize * 1.0d) / kW.getHeight()));
                            if (width > k.ag(InputView.this.getContext()) * 0.6d) {
                                width = (int) (kW.getWidth() * 0.5d);
                            }
                            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                            bitmapDrawable.setGravity(119);
                            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), start2, end2, 33);
                        }
                    }
                }, 0, 0, BdUniqueId.gen(), null, group2, false, null);
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

    private void fU(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private static int fV(String str) {
        int i;
        CustomResponsedMessage runTask;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = aDC.matcher(str);
        while (true) {
            i = i2;
            if (!matcher.find()) {
                break;
            }
            String group = matcher.group();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_VALID) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_VALID, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                i++;
            }
            i2 = i;
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
        this.aDB = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lt = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lt != null) {
            this.Lt.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ls = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ls;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lS() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        ai.d(this, d.g.foot_bar_input, i);
        ai.b(this, d.e.cp_cont_b, 2, i);
        if (i == 0) {
            setHintTextColor(getContext().getResources().getColor(d.e.cp_cont_e));
        } else {
            setHintTextColor(ai.getColor(i, d.e.cp_cont_e));
        }
    }

    public void setOutTextWather(TextWatcher textWatcher) {
        if (this.aDE != textWatcher) {
            this.aDE = textWatcher;
        }
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aDF = z;
    }
}
