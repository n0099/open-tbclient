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
        super.dA(7);
        super.dB(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m411getInst().getApp().getResources(), com.baidu.tieba.u.icon_face_original_s), false);
        super.c(aVar);
        super.b(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String dz(int i) {
        int i2;
        if (i < 0 || i >= t.ajb.size()) {
            i2 = 0;
        } else {
            i2 = t.ajb.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : t.ajc.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean ed(String str) {
        return t.ajc.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a ee(String str) {
        Bitmap b;
        Integer num = t.ajc.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.e.it().b(TbadkCoreApplication.m411getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getEmotionsCount() {
        return t.ajb.size();
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a ef(String str) {
        return ee(str);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public EmotionGroupType yI() {
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
    public boolean yJ() {
        return true;
    }
}
