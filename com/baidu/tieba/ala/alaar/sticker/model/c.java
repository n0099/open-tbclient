package com.baidu.tieba.ala.alaar.sticker.model;

import com.baidu.tieba.ala.alaar.sticker.a.h;
import java.io.File;
/* loaded from: classes3.dex */
public class c extends b {
    private static File eXw = h.getPrivateCaptureRootChildDir("duSo");

    public c(a aVar) {
        super(aVar, eXw);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    public boolean isLoaded() {
        return bpV() && super.isLoaded();
    }

    public boolean bpV() {
        File localFile = getLocalFile();
        com.baidu.minivideo.arface.b.LP();
        if (localFile != null && localFile.exists()) {
            File[] listFiles = localFile.listFiles();
            for (File file : listFiles) {
                if (!new File(com.baidu.minivideo.arface.b.LP(), file.getName()).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    protected boolean AN(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            File LP = com.baidu.minivideo.arface.b.LP();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "clearAll lib:" + LP + ", def:" + eXw);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + getLocalFile().getAbsolutePath() + ", sk:" + bpS());
            File file2 = new File(getLocalFile() + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.k(file, file2);
            if (file2.exists() && com.baidu.tieba.ala.alaar.sticker.b.c.a(file2.listFiles(), LP)) {
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
