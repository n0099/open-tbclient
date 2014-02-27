package com.baidu.tieba.data.emotions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import com.baidu.tieba.util.ad;
import com.slidingmenu.lib.R;
import java.util.Map;
/* loaded from: classes.dex */
public final class k extends WritableEmotionGroup {
    public k() {
        super.b(7);
        super.c(3);
        com.baidu.adp.widget.ImageView.b bVar = new com.baidu.adp.widget.ImageView.b(BitmapFactory.decodeResource(TiebaApplication.g().b().getResources(), R.drawable.icon_face_original_s), false);
        super.b(bVar);
        super.a(bVar);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final String a(int i) {
        int i2;
        if (i < 0 || i >= ad.a.size()) {
            i2 = 0;
        } else {
            i2 = ad.a.get(i).intValue();
        }
        for (Map.Entry<String, Integer> entry : ad.b.entrySet()) {
            if (entry.getValue().intValue() == i2) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final boolean a(String str) {
        return ad.b.get(str) != null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final com.baidu.adp.widget.ImageView.b b(String str) {
        Integer num = ad.b.get(str);
        if (num == null) {
            return null;
        }
        com.baidu.adp.lib.util.a.a();
        Bitmap a = com.baidu.adp.lib.util.a.a(TiebaApplication.g().b(), num.intValue());
        if (a != null) {
            return new com.baidu.adp.widget.ImageView.b(a, false, str);
        }
        return null;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final int d() {
        return ad.a.size();
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final com.baidu.adp.widget.ImageView.b c(String str) {
        return b(str);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final WritableEmotionGroup.EmotionGroupType c() {
        return WritableEmotionGroup.EmotionGroupType.LOCAL;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final String e() {
        return "_local";
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final String f() {
        return "_local";
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final int g() {
        return 0;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public final int h() {
        return 0;
    }
}
