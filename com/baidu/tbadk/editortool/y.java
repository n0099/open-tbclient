package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.Map;
/* loaded from: classes.dex */
public class y extends ae {
    public y() {
        init();
    }

    private void init() {
        super.dp(7);
        super.dq(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m255getInst().getApp().getResources(), com.baidu.tieba.v.icon_face_original_s), false);
        super.c(aVar);
        super.b(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String dl(int i) {
        int i2;
        if (i < 0 || i >= v.YM.size()) {
            i2 = 0;
        } else {
            i2 = v.YM.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : v.YN.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean dR(String str) {
        return v.YN.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dS(String str) {
        Bitmap b;
        Integer num = v.YN.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.c.eR().b(TbadkCoreApplication.m255getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getEmotionsCount() {
        return v.YM.size();
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dT(String str) {
        return dS(str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType vf() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String getGroupId() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String getGroupName() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getWidth() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getHeight() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean vg() {
        return true;
    }
}
