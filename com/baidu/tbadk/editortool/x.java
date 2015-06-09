package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.Map;
/* loaded from: classes.dex */
public class x extends ad {
    public x() {
        init();
    }

    private void init() {
        super.dJ(7);
        super.dK(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m411getInst().getApp().getResources(), com.baidu.tieba.p.icon_face_original_s), false);
        super.c(aVar);
        super.b(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String dI(int i) {
        int i2;
        if (i < 0 || i >= t.aki.size()) {
            i2 = 0;
        } else {
            i2 = t.aki.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : t.akj.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean ex(String str) {
        return t.akj.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a ey(String str) {
        Bitmap b;
        Integer num = t.akj.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.e.iK().b(TbadkCoreApplication.m411getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getEmotionsCount() {
        return t.aki.size();
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a ez(String str) {
        return ey(str);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public EmotionGroupType zC() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String getGroupId() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String getGroupName() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean zD() {
        return true;
    }
}
