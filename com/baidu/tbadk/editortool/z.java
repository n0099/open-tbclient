package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.Map;
/* loaded from: classes.dex */
public class z extends ag {
    public z() {
        b();
    }

    private void b() {
        super.b(7);
        super.c(3);
        com.baidu.adp.widget.a.a aVar = new com.baidu.adp.widget.a.a(BitmapFactory.decodeResource(TbadkApplication.m252getInst().getApp().getResources(), com.baidu.tieba.q.icon_face_original_s), false);
        super.b(aVar);
        super.a(aVar);
    }

    @Override // com.baidu.tbadk.editortool.ag
    public String a(int i) {
        int i2;
        if (i < 0 || i >= w.b.size()) {
            i2 = 0;
        } else {
            i2 = w.b.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : w.c.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public boolean a(String str) {
        return w.c.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public com.baidu.adp.widget.a.a b(String str) {
        Bitmap a;
        Integer num = w.c.get(str);
        if (num != null && (a = com.baidu.adp.lib.util.b.a().a(TbadkApplication.m252getInst().getApp(), num.intValue())) != null) {
            return new com.baidu.adp.widget.a.a(a, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public int d() {
        return w.b.size();
    }

    @Override // com.baidu.tbadk.editortool.ag
    public com.baidu.adp.widget.a.a c(String str) {
        return b(str);
    }

    @Override // com.baidu.tbadk.editortool.ag
    public EmotionGroupType c() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public String e() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ag
    public String f() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.ag
    public int g() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public int h() {
        return 0;
    }
}
