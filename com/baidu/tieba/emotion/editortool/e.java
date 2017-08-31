package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.d;
import java.util.Map;
/* loaded from: classes.dex */
public class e extends com.baidu.tbadk.editortools.emotiontool.c {
    public e() {
        init();
    }

    private void init() {
        super.eI(7);
        super.eJ(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), d.g.icon_face_original_s), false);
        super.d(aVar);
        super.c(aVar);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String eH(int i) {
        int i2;
        if (i < 0 || i >= com.baidu.tbadk.editortools.emotiontool.b.aCj.size()) {
            i2 = 0;
        } else {
            i2 = com.baidu.tbadk.editortools.emotiontool.b.aCj.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : com.baidu.tbadk.editortools.emotiontool.b.aCk.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean fJ(String str) {
        return com.baidu.tbadk.editortools.emotiontool.b.aCk.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.a.a fK(String str) {
        Bitmap resBitmap;
        Integer num = com.baidu.tbadk.editortools.emotiontool.b.aCk.get(str);
        if (num != null && (resBitmap = com.baidu.adp.lib.util.d.gQ().getResBitmap(TbadkCoreApplication.getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(resBitmap, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return com.baidu.tbadk.editortools.emotiontool.b.aCj.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.a.a fL(String str) {
        return fK(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType Dk() {
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
    public boolean Dj() {
        return true;
    }
}
