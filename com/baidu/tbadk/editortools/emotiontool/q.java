package com.baidu.tbadk.editortools.emotiontool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.i;
import java.util.Map;
/* loaded from: classes.dex */
public class q extends v {
    public q() {
        init();
    }

    private void init() {
        super.ei(7);
        super.ej(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m411getInst().getApp().getResources(), i.e.icon_face_original_s), false);
        super.c(aVar);
        super.b(aVar);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public String eh(int i) {
        int i2;
        if (i < 0 || i >= n.asd.size()) {
            i2 = 0;
        } else {
            i2 = n.asd.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : n.ase.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public boolean eK(String str) {
        return n.ase.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public com.baidu.adp.widget.a.a eL(String str) {
        Bitmap b;
        Integer num = n.ase.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.d.it().b(TbadkCoreApplication.m411getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public int getEmotionsCount() {
        return n.asd.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public com.baidu.adp.widget.a.a eM(String str) {
        return eL(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public EmotionGroupType Bm() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public String getGroupId() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public String getGroupName() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.v
    public boolean Bn() {
        return true;
    }
}
