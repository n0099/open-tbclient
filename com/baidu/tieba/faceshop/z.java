package com.baidu.tieba.faceshop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.gif.NSGif;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes9.dex */
public class z extends com.baidu.tbadk.editortools.emotiontool.c {
    private ArrayList<String> iRT = new ArrayList<>();
    private Set<String> iVQ = new HashSet();

    public z() {
        init();
    }

    private void init() {
        sA(2);
        sz(4);
        com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
        super.d(aVar);
        super.c(aVar);
        OH();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a bFf() {
        return super.bFe();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String sy(int i) {
        if (i >= this.iRT.size()) {
            return null;
        }
        return this.iRT.get(i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean DJ(String str) {
        return this.iVQ.contains(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType bFd() {
        return EmotionGroupType.USER_COLLECT;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a DK(String str) {
        if (com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(str)) {
            return new com.baidu.adp.widget.ImageView.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
        }
        Bitmap image = com.baidu.tbadk.core.util.n.getImage(Kp(str).getAbsolutePath());
        if (image == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.a(image, false, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [118=4] */
    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a DL(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        FileInputStream fileInputStream;
        File file = new File(Kp(str).getAbsolutePath().replace("_s.jpg", "_b.gif"));
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e) {
            e = e;
            byteArrayOutputStream = null;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
            byteArrayOutputStream = null;
            fileInputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read == -1) {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(NSGif.g(byteArray, 0, byteArray.length));
                            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                            return aVar;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                    com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
                com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream = null;
            com.baidu.adp.lib.f.a.close((InputStream) fileInputStream);
            com.baidu.adp.lib.f.a.close((OutputStream) byteArrayOutputStream);
            throw th;
        }
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        if (this.iRT == null || this.iRT.size() == 0) {
            return 1;
        }
        return this.iRT.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupId() {
        return com.baidu.tbadk.imageManager.d.getCollectGroupId();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupName() {
        return "用户收藏表情";
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean bFc() {
        return true;
    }

    public File Kp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replace = str.replace("#(meme,", "");
        String replace2 = replace.substring(0, replace.indexOf(",")).replace("collect_", "");
        if (replace2.contains(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS)) {
            replace2 = replace2.substring(replace2.indexOf(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS) + 1);
        }
        return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + replace2 + "_s.jpg");
    }

    public void OH() {
        List<CollectEmotionData> Kf = i.cBl().Kf(TbadkCoreApplication.getCurrentAccount());
        this.iRT.clear();
        this.iVQ.clear();
        for (CollectEmotionData collectEmotionData : Kf) {
            this.iRT.add(collectEmotionData.sharpText);
            this.iVQ.add(collectEmotionData.sharpText);
        }
    }

    public boolean Kq(String str) {
        if (this.iRT == null || TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = this.iRT.iterator();
        while (it.hasNext()) {
            if (it.next().contains(str)) {
                return true;
            }
        }
        return false;
    }
}
