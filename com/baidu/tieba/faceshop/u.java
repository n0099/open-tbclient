package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.ImageUploadResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public class u {

    /* loaded from: classes9.dex */
    interface a {
        void czx();

        void da(List<String> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public interface b {
        void b(ImageUploadResult imageUploadResult);
    }

    public void a(ArrayList<ImageFileInfo> arrayList, final a aVar) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            final AtomicInteger atomicInteger = new AtomicInteger();
            atomicInteger.set(arrayList.size());
            final ArrayList arrayList2 = new ArrayList();
            Iterator<ImageFileInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                a(it.next(), new b() { // from class: com.baidu.tieba.faceshop.u.1
                    @Override // com.baidu.tieba.faceshop.u.b
                    public void b(ImageUploadResult imageUploadResult) {
                        atomicInteger.decrementAndGet();
                        if (imageUploadResult != null && imageUploadResult.picInfo != null && imageUploadResult.picInfo.bigPic != null && !TextUtils.isEmpty(imageUploadResult.picInfo.bigPic.picUrl)) {
                            arrayList2.add(imageUploadResult.picInfo.bigPic.picUrl);
                        }
                        if (atomicInteger.get() == 0) {
                            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList2)) {
                                aVar.da(arrayList2);
                            } else {
                                aVar.czx();
                            }
                        }
                    }
                });
            }
        }
    }

    private void a(final ImageFileInfo imageFileInfo, final b bVar) {
        com.baidu.tieba.newfaceshop.a.dij().execute(new Runnable() { // from class: com.baidu.tieba.faceshop.u.2
            @Override // java.lang.Runnable
            public void run() {
                String filePath = imageFileInfo.getFilePath();
                com.baidu.tbadk.img.f fVar = new com.baidu.tbadk.img.f("from_user_collect");
                if (imageFileInfo.isGif()) {
                    bVar.b(fVar.f(filePath, true, false));
                    return;
                }
                Bitmap c = com.baidu.tieba.newfaceshop.facemake.b.c(imageFileInfo);
                if (c == null) {
                    bVar.b(null);
                    return;
                }
                String saveFile = com.baidu.tbadk.core.util.o.saveFile(TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath(), "face_" + Math.abs(filePath.hashCode()), c, 60);
                c.recycle();
                if (TextUtils.isEmpty(saveFile)) {
                    bVar.b(null);
                    return;
                }
                ImageUploadResult f = fVar.f(saveFile, false, false);
                com.baidu.tbadk.core.util.o.deleteFile(new File(saveFile));
                bVar.b(f);
            }
        });
    }
}
