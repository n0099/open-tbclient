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
        super.dh(7);
        super.di(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkCoreApplication.m255getInst().getApp().getResources(), com.baidu.tieba.v.icon_face_original_s), false);
        super.c(aVar);
        super.b(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String de(int i) {
        int i2;
        if (i < 0 || i >= v.Yj.size()) {
            i2 = 0;
        } else {
            i2 = v.Yj.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : v.Yk.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean dU(String str) {
        return v.Yk.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dV(String str) {
        Bitmap b;
        Integer num = v.Yk.get(str);
        if (num != null && (b = com.baidu.adp.lib.util.c.eS().b(TbadkCoreApplication.m255getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(b, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int getEmotionsCount() {
        return v.Yj.size();
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a dW(String str) {
        return dV(str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType uU() {
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
    public boolean uV() {
        return true;
    }
}
