package com.baidu.tieba.ala.alaar.sticker.model;

import com.baidu.tieba.ala.alaar.sticker.a.i;
import java.io.File;
/* loaded from: classes11.dex */
public class d extends b {
    private static File gtH = i.getPrivateCaptureRootChildDir("duSo");

    public d(a aVar) {
        super(aVar, gtH);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    public boolean isLoaded() {
        return bQj() && super.isLoaded();
    }

    public boolean bQj() {
        File localFile = getLocalFile();
        com.baidu.minivideo.arface.b.abG();
        if (localFile != null && localFile.exists()) {
            File[] listFiles = localFile.listFiles();
            for (File file : listFiles) {
                if (!new File(com.baidu.minivideo.arface.b.abG(), file.getName()).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    protected boolean jh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            File abG = com.baidu.minivideo.arface.b.abG();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "clearAll lib:" + abG + ", def:" + gtH);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + getLocalFile().getAbsolutePath() + ", sk:" + bQh());
            File file2 = new File(getLocalFile() + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.c(file, file2);
            if (file2.exists() && com.baidu.tieba.ala.alaar.sticker.b.c.a(file2.listFiles(), abG)) {
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
