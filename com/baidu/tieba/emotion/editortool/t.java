package com.baidu.tieba.emotion.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.i;
import java.util.Map;
/* loaded from: classes.dex */
public class t extends com.baidu.tbadk.editortools.emotiontool.c {
    public t() {
        init();
    }

    private void init() {
        super.dY(7);
        super.dZ(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m411getInst().getApp().getResources(), i.e.icon_face_original_s), false);
        super.d(aVar);
        super.c(aVar);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public String dX(int i) {
        int i2;
        if (i < 0 || i >= com.baidu.tbadk.editortools.emotiontool.b.apz.size()) {
            i2 = 0;
        } else {
            i2 = com.baidu.tbadk.editortools.emotiontool.b.apz.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : com.baidu.tbadk.editortools.emotiontool.b.apA.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public boolean eP(String str) {
        return com.baidu.tbadk.editortools.emotiontool.b.apA.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.a.a eQ(String str) {
        Bitmap b;
        Integer num = com.baidu.tbadk.editortools.emotiontool.b.apA.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.d.iv().b(TbadkCoreApplication.m411getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public int getEmotionsCount() {
        return com.baidu.tbadk.editortools.emotiontool.b.apz.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public com.baidu.adp.widget.a.a eR(String str) {
        return eQ(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.c
    public EmotionGroupType AP() {
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
    public boolean AO() {
        return true;
    }
}
