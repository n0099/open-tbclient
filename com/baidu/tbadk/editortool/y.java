package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.Map;
/* loaded from: classes.dex */
public class y extends ad {
    public y() {
        init();
    }

    private void init() {
        super.cJ(7);
        super.cK(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkApplication.m251getInst().getApp().getResources(), com.baidu.tieba.u.icon_face_original_s), false);
        super.c(aVar);
        super.b(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public String cG(int i) {
        int i2;
        if (i < 0 || i >= v.Sn.size()) {
            i2 = 0;
        } else {
            i2 = v.Sn.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : v.So.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public boolean cY(String str) {
        return v.So.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a cZ(String str) {
        Bitmap a;
        Integer num = v.So.get(str);
        if (num != null && (a = com.baidu.adp.lib.util.c.eS().a(TbadkApplication.m251getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(a, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ad
    public int getEmotionsCount() {
        return v.Sn.size();
    }

    @Override // com.baidu.tbadk.editortool.ad
    public com.baidu.adp.widget.a.a da(String str) {
        return cZ(str);
    }

    @Override // com.baidu.tbadk.editortool.ad
    public EmotionGroupType rt() {
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
    public boolean ru() {
        return true;
    }
}
