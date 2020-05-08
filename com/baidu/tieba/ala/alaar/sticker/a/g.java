package com.baidu.tieba.ala.alaar.sticker.a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.tieba.ala.alaar.sticker.model.DuFileFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import java.io.File;
/* loaded from: classes3.dex */
public class g {

    /* loaded from: classes3.dex */
    public interface a<T> {
        void a(T t, int i, int i2, String str);

        void aq(T t);

        void ar(T t);
    }

    public static final void a(FuFaceItem fuFaceItem, a<FuFaceItem> aVar) {
        if (fuFaceItem instanceof DuFileFaceItem) {
            a((DuFileFaceItem) fuFaceItem, aVar);
        } else {
            fuFaceItem.download(aVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.baidu.tieba.ala.alaar.sticker.a.g$1] */
    private static final void a(final DuFileFaceItem duFileFaceItem, final a<FuFaceItem> aVar) {
        try {
            String loadingFile = duFileFaceItem.getLoadingFile();
            if (!TextUtils.isEmpty(loadingFile)) {
                final File file = new File(loadingFile);
                if (file.exists()) {
                    if (aVar != null) {
                        aVar.aq(duFileFaceItem);
                    }
                    new Thread() { // from class: com.baidu.tieba.ala.alaar.sticker.a.g.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            final boolean z = false;
                            try {
                                if (!DuFileFaceItem.this.onResLoaded(file.getAbsolutePath())) {
                                    new Throwable("unzip failed");
                                }
                                z = true;
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            if (aVar != null) {
                                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.a.g.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (z) {
                                            aVar.ar(DuFileFaceItem.this);
                                        } else {
                                            aVar.a(DuFileFaceItem.this, 0, 0, "本地贴纸独立文件解压导出失败");
                                        }
                                    }
                                });
                            }
                        }
                    }.start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
