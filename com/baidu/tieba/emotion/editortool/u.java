package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.u;
import java.util.Map;
/* loaded from: classes.dex */
public class u extends com.baidu.tbadk.editortools.emotiontool.c {
    public u() {
        init();
    }

    private void init() {
        super.ep(7);
        super.eq(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m9getInst().getApp().getResources(), u.f.icon_face_original_s), false);
        super.d(aVar);
        super.c(aVar);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String eo(int i) {
        int i2;
        if (i < 0 || i >= com.baidu.tbadk.editortools.emotiontool.b.ari.size()) {
            i2 = 0;
        } else {
            i2 = com.baidu.tbadk.editortools.emotiontool.b.ari.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : com.baidu.tbadk.editortools.emotiontool.b.arj.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean fr(String str) {
        return com.baidu.tbadk.editortools.emotiontool.b.arj.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.a.a fs(String str) {
        Bitmap resBitmap;
        Integer num = com.baidu.tbadk.editortools.emotiontool.b.arj.get(str);
        if (num != null && (resBitmap = com.baidu.adp.lib.util.d.eZ().getResBitmap(TbadkCoreApplication.m9getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(resBitmap, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return com.baidu.tbadk.editortools.emotiontool.b.ari.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.a.a ft(String str) {
        return fs(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType BF() {
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
    public boolean BE() {
        return true;
    }
}
