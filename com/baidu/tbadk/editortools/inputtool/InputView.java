package com.baidu.tbadk.editortools.inputtool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.b;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.e;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.m;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class InputView extends EditText implements s {
    private int Ja;
    private i Jb;
    private boolean aCK;
    private boolean aCL;
    private boolean aCM;
    private int aCN;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface a {
        void b(SpannableStringBuilder spannableStringBuilder);
    }

    public InputView(Context context, boolean z) {
        super(context);
        this.Ja = 0;
        this.aCK = false;
        this.aCL = true;
        this.aCM = true;
        this.aCN = -1;
        setMinHeight(context.getResources().getDimensionPixelSize(d.e.ds64));
        setMaxLines(4);
        if (z) {
            setHint(context.getString(d.j.say_your_point));
        }
        setTextSize(0, getResources().getDimensionPixelSize(d.e.ds32));
        setTextColor(getResources().getColor(d.C0080d.cp_cont_f));
        setHintTextColor(getResources().getColor(d.C0080d.cp_cont_e));
        setBackgroundResource(d.C0080d.common_color_10022);
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
                if (!InputView.this.aCM) {
                    InputView.this.aCM = true;
                    if (InputView.this.aCN != -1) {
                        InputView.this.setSelection(InputView.this.aCN);
                        InputView.this.aCN = -1;
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
                        Matcher matcher = com.baidu.tieba.face.a.cmy.matcher(substring);
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
                        a((String) aVar.data, new a() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.3
                            @Override // com.baidu.tbadk.editortools.inputtool.InputView.a
                            public void b(SpannableStringBuilder spannableStringBuilder) {
                                InputView.this.setText(spannableStringBuilder);
                                InputView.this.setSelection(InputView.this.getText().length());
                                InputView.this.b(new com.baidu.tbadk.editortools.a(5, -1, null));
                                InputView.this.requestFocus();
                            }
                        });
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
                    d(aVar);
                    return;
                case d.l.View_minWidth /* 44 */:
                    if (aVar.data != null && (aVar.data instanceof String)) {
                        fO((String) aVar.data);
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
            if (mVar.xZ() == EmotionGroupType.NET_SUG) {
                a(mVar);
            } else {
                b(mVar);
            }
        }
    }

    private void a(final m mVar) {
        if (mVar != null && !TextUtils.isEmpty(mVar.getName()) && !TextUtils.isEmpty(mVar.getUrl())) {
            String obj = getText().toString();
            if (this.aCL && fP(obj) >= 10 && getContext() != null) {
                e.uf().showToast(d.j.too_many_face);
                return;
            }
            c.fJ().a(mVar.getUrl(), 10, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                    if (aVar != null) {
                        int selectionStart = InputView.this.getSelectionStart();
                        if (selectionStart < 0) {
                            selectionStart = 0;
                        }
                        InputView.this.a(InputView.this, new SpannableStringBuilder(mVar.getName()), selectionStart, aVar, mVar.xZ());
                    }
                }
            }, 0, 0, BdUniqueId.gen(), new Object[0]);
        }
    }

    private void b(m mVar) {
        if ((!this.aCK || mVar.xZ() == EmotionGroupType.LOCAL) && mVar.getName() != null) {
            String obj = getText().toString();
            if (this.aCL && fP(obj) >= 10 && getContext() != null) {
                e.uf().showToast(d.j.too_many_face);
                return;
            }
            String name = mVar.getName();
            final EmotionGroupType xZ = mVar.xZ();
            if (xZ == EmotionGroupType.LOCAL || xZ == EmotionGroupType.USER_COLLECT || name.startsWith("#(")) {
                if (name != null) {
                    final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
                    c.fJ().a(name, 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.a.a aVar, String str, int i) {
                            super.onLoaded((AnonymousClass5) aVar, str, i);
                            if (aVar != null) {
                                int selectionStart = InputView.this.getSelectionStart();
                                if (selectionStart < 0) {
                                    selectionStart = 0;
                                }
                                InputView.this.a(InputView.this, spannableStringBuilder, selectionStart, aVar, xZ);
                            }
                        }
                    }, 0, 0, BdUniqueId.gen(), null, name, false, null);
                    return;
                }
                return;
            }
            getText().insert(getSelectionStart(), name);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(InputView inputView, SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.a.a aVar, EmotionGroupType emotionGroupType) {
        Bitmap kK = aVar.kK();
        BitmapDrawable bitmapDrawable = new BitmapDrawable(kK);
        int width = kK.getWidth();
        if (emotionGroupType == EmotionGroupType.LOCAL) {
            int i2 = (int) (width * 0.5d);
            bitmapDrawable.setBounds(0, 0, i2, i2);
        } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith("#(")) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(d.e.ds80);
            int width2 = (int) (kK.getWidth() * ((dimensionPixelSize * 1.0d) / kK.getHeight()));
            if (width2 > getMeasuredWidth()) {
                width2 = (int) (kK.getWidth() * 0.5d);
            }
            bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
        }
        bitmapDrawable.setGravity(119);
        spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
        inputView.getText().insert(i, spannableStringBuilder);
    }

    private void a(String str, final a aVar) {
        CustomResponsedMessage runTask;
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        final int[] iArr = {fP(str)};
        if (iArr[0] <= 0) {
            if (aVar != null) {
                aVar.b(spannableStringBuilder);
                return;
            }
            return;
        }
        Matcher matcher = com.baidu.tieba.face.a.cmx.matcher(spannableStringBuilder);
        while (matcher.find()) {
            String group = matcher.group();
            final int start = matcher.start();
            final int end = matcher.end();
            if (MessageManager.getInstance().findTask(CmdConfigCustom.EMOTION_IS_LOCAL) != null && (runTask = MessageManager.getInstance().runTask(CmdConfigCustom.EMOTION_IS_LOCAL, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                c.fJ().a(group, 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.6
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str2, int i) {
                        Bitmap kK;
                        super.onLoaded((AnonymousClass6) aVar2, str2, i);
                        if (aVar2 != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar2.kK());
                            int width = (int) (0.5d * kK.getWidth());
                            bitmapDrawable.setBounds(0, 0, width, width);
                            bitmapDrawable.setGravity(119);
                            spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), start, end, 33);
                            int[] iArr2 = iArr;
                            int i2 = iArr2[0] - 1;
                            iArr2[0] = i2;
                            if (i2 == 0 && aVar != null) {
                                aVar.b(spannableStringBuilder);
                                return;
                            }
                            return;
                        }
                        spannableStringBuilder.setSpan("", start, end, 33);
                        int[] iArr3 = iArr;
                        int i3 = iArr3[0] - 1;
                        iArr3[0] = i3;
                        if (i3 == 0 && aVar != null) {
                            aVar.b(spannableStringBuilder);
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
                c.fJ().a(group2, 20, new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.7
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str2, int i) {
                        Bitmap kK;
                        super.onLoaded((AnonymousClass7) aVar2, str2, i);
                        if (aVar2 != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar2.kK());
                            int dimensionPixelSize = InputView.this.getResources().getDimensionPixelSize(d.e.ds80);
                            int width = (int) (kK.getWidth() * ((dimensionPixelSize * 1.0d) / kK.getHeight()));
                            if (width > l.ac(InputView.this.getContext()) * 0.6d) {
                                width = (int) (kK.getWidth() * 0.5d);
                            }
                            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                            bitmapDrawable.setGravity(119);
                            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), start2, end2, 33);
                            int[] iArr2 = iArr;
                            int i2 = iArr2[0] - 1;
                            iArr2[0] = i2;
                            if (i2 == 0 && aVar != null) {
                                aVar.b(spannableStringBuilder);
                                return;
                            }
                            return;
                        }
                        spannableStringBuilder.setSpan("", start2, end2, 33);
                        int[] iArr3 = iArr;
                        int i3 = iArr3[0] - 1;
                        iArr3[0] = i3;
                        if (i3 == 0 && aVar != null) {
                            aVar.b(spannableStringBuilder);
                        }
                    }
                }, 0, 0, BdUniqueId.gen(), null, group2, false, null);
            }
        }
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split2 != null && split2.length == 6) {
                final int start3 = matcher3.start();
                final int end3 = matcher3.end();
                b<com.baidu.adp.widget.a.a> bVar = new b<com.baidu.adp.widget.a.a>() { // from class: com.baidu.tbadk.editortools.inputtool.InputView.8
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.adp.lib.f.b
                    public void onLoaded(com.baidu.adp.widget.a.a aVar2, String str2, int i) {
                        Bitmap kK;
                        super.onLoaded((AnonymousClass8) aVar2, str2, i);
                        if (aVar2 != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar2.kK());
                            int dimensionPixelSize = InputView.this.getResources().getDimensionPixelSize(d.e.ds80);
                            int width = (int) (kK.getWidth() * ((dimensionPixelSize * 1.0d) / kK.getHeight()));
                            if (width > l.ac(InputView.this.getContext()) * 0.6d) {
                                width = (int) (kK.getWidth() * 0.5d);
                            }
                            bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                            bitmapDrawable.setGravity(119);
                            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), start3, end3, 33);
                            int[] iArr2 = iArr;
                            int i2 = iArr2[0] - 1;
                            iArr2[0] = i2;
                            if (i2 == 0 && aVar != null) {
                                aVar.b(spannableStringBuilder);
                                return;
                            }
                            return;
                        }
                        spannableStringBuilder.setSpan("", start3, end3, 33);
                        int[] iArr3 = iArr;
                        int i3 = iArr3[0] - 1;
                        iArr3[0] = i3;
                        if (i3 == 0 && aVar != null) {
                            aVar.b(spannableStringBuilder);
                        }
                    }
                };
                if (!TextUtils.isEmpty(split2[1])) {
                    c.fJ().a(Uri.decode(split2[1].replace("net_", "")), 10, bVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                }
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

    private void fO(String str) {
        if (!StringUtils.isNull(str)) {
            getText().insert(getSelectionStart(), HotSelectActivityConfig.HOT_TOPIC_SING + str);
        }
    }

    private static int fP(String str) {
        int i;
        CustomResponsedMessage runTask;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            return 0;
        }
        Matcher matcher = com.baidu.tieba.face.a.cmx.matcher(str);
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
        Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(str);
        while (matcher3.find()) {
            String[] split2 = matcher3.group().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split2 != null && split2.length == 6) {
                i++;
            }
        }
        return i;
    }

    public void setIsOnlyLocalEmotion(boolean z) {
        this.aCK = z;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
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
    public void lG() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        aj.b(this, d.C0080d.cp_cont_b, 2, i);
        if (i == 0) {
            setCursorColor(d.f.edittext_cursor);
            setHintTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_e));
            return;
        }
        setCursorColor(d.f.edittext_cursor_1);
        setHintTextColor(aj.getColor(i, d.C0080d.cp_cont_e));
    }

    public void setNeedFaceMaxCount(boolean z) {
        this.aCL = z;
    }
}
