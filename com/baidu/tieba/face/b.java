package com.baidu.tieba.face;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.widget.EditText;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.c;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.n;
import com.baidu.tieba.d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class b {
    private static final KeyEvent cSx = new KeyEvent(0, 67);

    /* loaded from: classes.dex */
    public interface a {
        void a(SpannableStringBuilder spannableStringBuilder);
    }

    public static void a(final Context context, final n nVar, final EditText editText) {
        if (nVar != null && !TextUtils.isEmpty(nVar.getName()) && !TextUtils.isEmpty(nVar.getUrl()) && editText != null) {
            editText.getText().toString();
            c.ig().a(nVar.getUrl(), 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.b.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                    if (aVar != null) {
                        int selectionStart = editText.getSelectionStart();
                        if (selectionStart < 0) {
                            selectionStart = 0;
                        }
                        b.a(context, editText, new SpannableStringBuilder(nVar.getName()), selectionStart, aVar, nVar.Ct());
                    }
                }
            }, 0, 0, BdUniqueId.gen(), new Object[0]);
        }
    }

    public static void b(final Context context, n nVar, final EditText editText) {
        if (nVar != null && editText != null && nVar.getName() != null) {
            String name = nVar.getName();
            final EmotionGroupType Ct = nVar.Ct();
            if (Ct == EmotionGroupType.LOCAL || Ct == EmotionGroupType.USER_COLLECT || name.startsWith("#(")) {
                if (name != null) {
                    final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(name);
                    c.ig().a(name, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.b.2
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
                            super.onLoaded((AnonymousClass2) aVar, str, i);
                            if (aVar != null) {
                                int selectionStart = editText.getSelectionStart();
                                if (selectionStart < 0) {
                                    selectionStart = 0;
                                }
                                b.a(context, editText, spannableStringBuilder, selectionStart, aVar, Ct);
                            }
                        }
                    }, 0, 0, BdUniqueId.gen(), null, name, false, null);
                    return;
                }
                return;
            }
            editText.getText().insert(editText.getSelectionStart(), name);
        }
    }

    public static void a(Context context, EditText editText, SpannableStringBuilder spannableStringBuilder, int i, com.baidu.adp.widget.ImageView.a aVar, EmotionGroupType emotionGroupType) {
        if (context != null && editText != null && !TextUtils.isEmpty(spannableStringBuilder) && aVar != null) {
            Bitmap mZ = aVar.mZ();
            BitmapDrawable bitmapDrawable = new BitmapDrawable(mZ);
            int width = mZ.getWidth();
            if (emotionGroupType == EmotionGroupType.LOCAL) {
                int i2 = (int) (width * 0.5d);
                bitmapDrawable.setBounds(0, 0, i2, i2);
            } else if (emotionGroupType == EmotionGroupType.USER_COLLECT || spannableStringBuilder.toString().startsWith("#(")) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.ds80);
                int width2 = (int) (mZ.getWidth() * ((dimensionPixelSize * 1.0d) / mZ.getHeight()));
                if (width2 > editText.getMeasuredWidth()) {
                    width2 = (int) (mZ.getWidth() * 0.5d);
                }
                bitmapDrawable.setBounds(0, 0, width2, dimensionPixelSize);
            }
            bitmapDrawable.setGravity(119);
            spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), 0, spannableStringBuilder.length(), 33);
            editText.getText().insert(i, spannableStringBuilder);
        }
    }

    public static void a(final Context context, String str, final a aVar) {
        CustomResponsedMessage runTask;
        if (context != null && !TextUtils.isEmpty(str) && aVar != null) {
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            final int[] iArr = {com.baidu.tieba.face.a.lB(str)};
            if (iArr[0] <= 0) {
                if (aVar != null) {
                    aVar.a(spannableStringBuilder);
                    return;
                }
                return;
            }
            Matcher matcher = com.baidu.tieba.face.a.cSv.matcher(spannableStringBuilder);
            while (matcher.find()) {
                String group = matcher.group();
                final int start = matcher.start();
                final int end = matcher.end();
                if (MessageManager.getInstance().findTask(2004609) != null && (runTask = MessageManager.getInstance().runTask(2004609, Boolean.class, group)) != null && (runTask.getData() instanceof Boolean) && ((Boolean) runTask.getData()).booleanValue()) {
                    c.ig().a(group, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.b.3
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            Bitmap mZ;
                            super.onLoaded((AnonymousClass3) aVar2, str2, i);
                            if (aVar2 != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar2.mZ());
                                int width = (int) (0.5d * mZ.getWidth());
                                bitmapDrawable.setBounds(0, 0, width, width);
                                bitmapDrawable.setGravity(119);
                                spannableStringBuilder.setSpan(new com.baidu.adp.widget.b(bitmapDrawable, 1), start, end, 33);
                                int[] iArr2 = iArr;
                                int i2 = iArr2[0] - 1;
                                iArr2[0] = i2;
                                if (i2 == 0 && aVar != null) {
                                    aVar.a(spannableStringBuilder);
                                    return;
                                }
                                return;
                            }
                            spannableStringBuilder.setSpan("", start, end, 33);
                            int[] iArr3 = iArr;
                            int i3 = iArr3[0] - 1;
                            iArr3[0] = i3;
                            if (i3 == 0 && aVar != null) {
                                aVar.a(spannableStringBuilder);
                            }
                        }
                    }, 0, 0, BdUniqueId.gen(), null, group, false, null);
                }
            }
            Matcher matcher2 = Pattern.compile("#\\(meme,[collect_]?[a-zA-Z0-9_,]+\\)").matcher(spannableStringBuilder);
            while (matcher2.find()) {
                String group2 = matcher2.group();
                String[] split = group2.split(",");
                if (split != null && split.length == 5) {
                    final int start2 = matcher2.start();
                    final int end2 = matcher2.end();
                    c.ig().a(group2, 20, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.b.4
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            Bitmap mZ;
                            super.onLoaded((AnonymousClass4) aVar2, str2, i);
                            if (aVar2 != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar2.mZ());
                                int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.ds80);
                                int width = (int) (mZ.getWidth() * ((dimensionPixelSize * 1.0d) / mZ.getHeight()));
                                if (width > l.ah(context) * 0.6d) {
                                    width = (int) (mZ.getWidth() * 0.5d);
                                }
                                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                                bitmapDrawable.setGravity(119);
                                spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), start2, end2, 33);
                                int[] iArr2 = iArr;
                                int i2 = iArr2[0] - 1;
                                iArr2[0] = i2;
                                if (i2 == 0 && aVar != null) {
                                    aVar.a(spannableStringBuilder);
                                    return;
                                }
                                return;
                            }
                            spannableStringBuilder.setSpan("", start2, end2, 33);
                            int[] iArr3 = iArr;
                            int i3 = iArr3[0] - 1;
                            iArr3[0] = i3;
                            if (i3 == 0 && aVar != null) {
                                aVar.a(spannableStringBuilder);
                            }
                        }
                    }, 0, 0, BdUniqueId.gen(), null, group2, false, null);
                }
            }
            Matcher matcher3 = Pattern.compile("#\\(meme,net_[a-zA-Z0-9_\\-\\.\\%,]+\\)").matcher(spannableStringBuilder);
            while (matcher3.find()) {
                String[] split2 = matcher3.group().split(",");
                if (split2 != null && split2.length == 6) {
                    final int start3 = matcher3.start();
                    final int end3 = matcher3.end();
                    com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> bVar = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.face.b.5
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.baidu.adp.lib.f.b
                        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar2, String str2, int i) {
                            Bitmap mZ;
                            super.onLoaded((AnonymousClass5) aVar2, str2, i);
                            if (aVar2 != null) {
                                BitmapDrawable bitmapDrawable = new BitmapDrawable(aVar2.mZ());
                                int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.ds80);
                                int width = (int) (mZ.getWidth() * ((dimensionPixelSize * 1.0d) / mZ.getHeight()));
                                if (width > l.ah(context) * 0.6d) {
                                    width = (int) (mZ.getWidth() * 0.5d);
                                }
                                bitmapDrawable.setBounds(0, 0, width, dimensionPixelSize);
                                bitmapDrawable.setGravity(119);
                                spannableStringBuilder.setSpan(new ImageSpan(bitmapDrawable, 0), start3, end3, 33);
                                int[] iArr2 = iArr;
                                int i2 = iArr2[0] - 1;
                                iArr2[0] = i2;
                                if (i2 == 0 && aVar != null) {
                                    aVar.a(spannableStringBuilder);
                                    return;
                                }
                                return;
                            }
                            spannableStringBuilder.setSpan("", start3, end3, 33);
                            int[] iArr3 = iArr;
                            int i3 = iArr3[0] - 1;
                            iArr3[0] = i3;
                            if (i3 == 0 && aVar != null) {
                                aVar.a(spannableStringBuilder);
                            }
                        }
                    };
                    if (!TextUtils.isEmpty(split2[1])) {
                        c.ig().a(Uri.decode(split2[1].replace("net_", "")), 10, bVar, 0, 0, BdUniqueId.gen(), new Object[0]);
                    }
                }
            }
        }
    }

    public static void b(EditText editText) {
        Editable text;
        if (editText != null && (text = editText.getText()) != null) {
            int selectionStart = editText.getSelectionStart();
            if (selectionStart - 1 > 0 && selectionStart - 1 < text.length() && text.charAt(selectionStart - 1) == 0) {
                editText.onKeyDown(67, cSx);
            }
            editText.onKeyDown(67, cSx);
            int selectionStart2 = editText.getSelectionStart();
            if (text != null) {
                editText.setSelection(selectionStart2);
            }
        }
    }
}
