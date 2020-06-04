package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import java.util.Map;
/* loaded from: classes6.dex */
public class c extends com.baidu.tbadk.editortools.emotiontool.c {
    public c() {
        init();
    }

    private void init() {
        super.nl(7);
        super.nm(3);
        com.baidu.adp.widget.ImageView.a aVar = new com.baidu.adp.widget.ImageView.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_face_original_s), false);
        super.d(aVar);
        super.c(aVar);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String nk(int i) {
        int i2;
        if (i < 0 || i >= com.baidu.tbadk.editortools.emotiontool.b.elQ.size()) {
            i2 = 0;
        } else {
            i2 = com.baidu.tbadk.editortools.emotiontool.b.elQ.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : com.baidu.tbadk.editortools.emotiontool.b.elR.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean yb(String str) {
        return com.baidu.tbadk.editortools.emotiontool.b.elR.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a yc(String str) {
        Bitmap resBitmap;
        Integer num = com.baidu.tbadk.editortools.emotiontool.b.elR.get(str);
        if (num != null && (resBitmap = com.baidu.adp.lib.util.d.mm().getResBitmap(TbadkCoreApplication.getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.ImageView.a(resBitmap, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return com.baidu.tbadk.editortools.emotiontool.b.elQ.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.ImageView.a yd(String str) {
        return yc(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType bdm() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupId() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String getGroupName() {
        return "_local";
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
    public boolean bdl() {
        return true;
    }
}
