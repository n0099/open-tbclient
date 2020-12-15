package com.baidu.tieba.ala.alaar.sticker.model;

import com.baidu.tieba.ala.alaar.sticker.a.i;
import java.io.File;
/* loaded from: classes4.dex */
public class d extends b {
    private static File gkS = i.getPrivateCaptureRootChildDir("duSo");

    public d(a aVar) {
        super(aVar, gkS);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    public boolean isLoaded() {
        return bQR() && super.isLoaded();
    }

    public boolean bQR() {
        File localFile = getLocalFile();
        com.baidu.minivideo.arface.b.abX();
        if (localFile != null && localFile.exists()) {
            File[] listFiles = localFile.listFiles();
            for (File file : listFiles) {
                if (!new File(com.baidu.minivideo.arface.b.abX(), file.getName()).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    protected boolean Gx(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            File abX = com.baidu.minivideo.arface.b.abX();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "clearAll lib:" + abX + ", def:" + gkS);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + getLocalFile().getAbsolutePath() + ", sk:" + bQO());
            File file2 = new File(getLocalFile() + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            if (file2.exists() && com.baidu.tieba.ala.alaar.sticker.b.c.a(file2.listFiles(), abX)) {
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
