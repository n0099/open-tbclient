package com.baidu.tbadk.editortools.emotiontool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.i;
import java.util.Map;
/* loaded from: classes.dex */
public class p extends t {
    public p() {
        init();
    }

    private void init() {
        super.ej(7);
        super.ek(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m411getInst().getApp().getResources(), i.e.icon_face_original_s), false);
        super.d(aVar);
        super.c(aVar);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public String ei(int i) {
        int i2;
        if (i < 0 || i >= n.aqE.size()) {
            i2 = 0;
        } else {
            i2 = n.aqE.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : n.aqF.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public boolean eP(String str) {
        return n.aqF.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public com.baidu.adp.widget.a.a eQ(String str) {
        Bitmap b;
        Integer num = n.aqF.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.d.iu().b(TbadkCoreApplication.m411getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public int getEmotionsCount() {
        return n.aqE.size();
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public com.baidu.adp.widget.a.a eR(String str) {
        return eQ(str);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public EmotionGroupType AW() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public String getGroupId() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public String getGroupName() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.t
    public boolean AX() {
        return true;
    }
}
