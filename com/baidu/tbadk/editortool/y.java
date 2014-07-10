package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.Map;
/* loaded from: classes.dex */
public class y extends ae {
    public y() {
        b();
    }

    private void b() {
        super.b(7);
        super.c(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkApplication.m252getInst().getApp().getResources(), com.baidu.tieba.u.icon_face_original_s), false);
        super.b(aVar);
        super.a(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String a(int i) {
        int i2;
        if (i < 0 || i >= v.b.size()) {
            i2 = 0;
        } else {
            i2 = v.b.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : v.c.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean a(String str) {
        return v.c.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a b(String str) {
        Bitmap a;
        Integer num = v.c.get(str);
        if (num != null && (a = com.baidu.adp.lib.util.b.a().a(TbadkApplication.m252getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(a, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int d() {
        return v.b.size();
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a c(String str) {
        return b(str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType c() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String e() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String f() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int g() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int h() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean i() {
        return true;
    }
}
