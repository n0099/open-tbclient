package com.baidu.tieba.ala.alaar.sticker.model;

import com.baidu.tieba.ala.alaar.sticker.a.i;
import java.io.File;
/* loaded from: classes4.dex */
public class d extends b {
    private static File gcY = i.getPrivateCaptureRootChildDir("duSo");

    public d(a aVar) {
        super(aVar, gcY);
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    public boolean isLoaded() {
        return bNM() && super.isLoaded();
    }

    public boolean bNM() {
        File localFile = getLocalFile();
        com.baidu.minivideo.arface.b.aaa();
        if (localFile != null && localFile.exists()) {
            File[] listFiles = localFile.listFiles();
            for (File file : listFiles) {
                if (!new File(com.baidu.minivideo.arface.b.aaa(), file.getName()).exists()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.baidu.tieba.ala.alaar.sticker.model.b
    protected boolean Gh(String str) {
        boolean z = false;
        try {
            File file = new File(str);
            File aaa = com.baidu.minivideo.arface.b.aaa();
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "clearAll lib:" + aaa + ", def:" + gcY);
            com.baidu.tieba.ala.alaar.sticker.b.a.e("AR_DuAbilityModel", "onCompleted-unzip:" + str + "\nto " + getLocalFile().getAbsolutePath() + ", sk:" + bNJ());
            File file2 = new File(getLocalFile() + ".ziping");
            if (file2.exists()) {
                com.baidu.tieba.ala.alaar.sticker.b.c.deleteFileOrDir(file2);
            }
            com.baidu.tieba.ala.alaar.sticker.b.c.d(file, file2);
            if (file2.exists() && com.baidu.tieba.ala.alaar.sticker.b.c.a(file2.listFiles(), aaa)) {
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
