package com.baidu.tieba.ala.alaar.sticker.model;

import com.baidu.tieba.ala.alaar.sticker.a.h;
import java.io.File;
/* loaded from: classes3.dex */
public class c extends b {
    private static File fhT = h.getPrivateCaptureRootChildDir("duSo");

    public c(a aVar) {
        super(aVar, fhT);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    public boolean isLoaded() {
        return bsF() && super.isLoaded();
    }

    public boolean bsF() {
        File localFile = getLocalFile();
        com.baidu.minivideo.arface.b.MY();
        if (localFile != null && localFile.exists()) {
            File[] listFiles = localFile.listFiles();
            for (File file : listFiles) {
                if (!new File(com.baidu.minivideo.arface.b.MY(), file.getName()).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    protected boolean Bg(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            File MY = com.baidu.minivideo.arface.b.MY();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "clearAll lib:" + MY + ", def:" + fhT);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + getLocalFile().getAbsolutePath() + ", sk:" + bsC());
            File file2 = new File(getLocalFile() + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.k(file, file2);
            if (file2.exists() && com.baidu.tieba.ala.alaar.sticker.b.c.a(file2.listFiles(), MY)) {
                file2.renameTo(getLocalFile());
            }
            z = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.tieba.ala.alaar.sticker.b.c.deleteFile(str);
        f(null);
        return z;
    }
}
