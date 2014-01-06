package com.baidu.tieba.data.emotions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.baidu.tieba.util.z;
import com.slidingmenu.lib.R;
import java.util.Map;
/* loaded from: classes.dex */
public class k extends WritableEmotionGroup {
    public k() {
        b();
    }

    private void b() {
        super.b(7);
        super.c(3);
        com.baidu.adp.widget.ImageView.d dVar = new com.baidu.adp.widget.ImageView.d(BitmapFactory.decodeResource(TiebaApplication.g().getResources(), R.drawable.icon_face_original_s), false);
        super.b(dVar);
        super.a(dVar);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String a(int i) {
        int i2;
        if (i < 0 || i >= z.a.size()) {
            i2 = 0;
        } else {
            i2 = z.a.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : z.b.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public boolean a(String str) {
        return z.b.get(str) != null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d b(String str) {
        Bitmap a;
        Integer num = z.b.get(str);
        if (num != null && (a = com.baidu.adp.lib.h.a.a().a(TiebaApplication.g(), num.intValue())) != null) {
            return new com.baidu.adp.widget.ImageView.d(a, false, str);
        }
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public int d() {
        return z.a.size();
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d c(String str) {
        return b(str);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public WritableEmotionGroup.EmotionGroupType c() {
        return WritableEmotionGroup.EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String e() {
        return "_local";
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String f() {
        return "_local";
    }
}
