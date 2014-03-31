package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.Map;
/* loaded from: classes.dex */
public final class z extends af {
    public z() {
        super.b(7);
        super.c(3);
        com.baidu.adp.widget.ImageView.b bVar = new com.baidu.adp.widget.ImageView.b(BitmapFactory.decodeResource(TbadkApplication.j().b().getResources(), com.baidu.tbadk.i.icon_face_original_s), false);
        super.b(bVar);
        super.a(bVar);
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String a(int i) {
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

    @Override // com.baidu.tbadk.editortool.af
    public final boolean a(String str) {
        return w.c.get(str) != null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b b(String str) {
        Integer num = w.c.get(str);
        if (num == null) {
            return null;
        }
        com.baidu.adp.lib.util.b.a();
        Bitmap a = com.baidu.adp.lib.util.b.a(TbadkApplication.j().b(), num.intValue());
        if (a != null) {
            return new com.baidu.adp.widget.ImageView.b(a, false, str);
        }
        return null;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int d() {
        return w.b.size();
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b c(String str) {
        return b(str);
    }

    @Override // com.baidu.tbadk.editortool.af
    public final EmotionGroupType c() {
        return EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String e() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String f() {
        return "_local";
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int g() {
        return 0;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int h() {
        return 0;
    }
}
