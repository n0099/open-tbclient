package com.baidu.tieba.data.emotions;

import android.graphics.Bitmap;
import com.baidu.tieba.data.emotions.WritableEmotionGroup;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class e extends WritableEmotionGroup {
    private String a;
    private String b;
    private ArrayList<String> c = new ArrayList<>();

    public e(EmotionGroupData emotionGroupData) {
        this.a = emotionGroupData.groupId;
        this.b = emotionGroupData.groupName;
        b();
    }

    private void b() {
        c(2);
        b(4);
        Bitmap a = d.a(this.a, "panel.png");
        Bitmap a2 = d.a(this.a, "panel_momo.png");
        if (a != null) {
            a(new com.baidu.adp.widget.ImageView.d(a, false));
        }
        if (a2 != null) {
            b(new com.baidu.adp.widget.ImageView.d(a2, false));
        }
        this.c.clear();
        for (EmotionData emotionData : j.a().b(this.a)) {
            this.c.add(emotionData.sharpText);
        }
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String a(int i) {
        if (i >= this.c.size()) {
            return null;
        }
        return this.c.get(i);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public boolean a(String str) {
        return this.c.contains(str);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public WritableEmotionGroup.EmotionGroupType c() {
        return WritableEmotionGroup.EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d b(String str) {
        Bitmap a = d.a(this.a, d.a(str, false));
        if (a == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.d(a, false, str);
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public com.baidu.adp.widget.ImageView.d c(String str) {
        return d.b(this.a, d.a(str, true));
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public int d() {
        return this.c.size();
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String e() {
        return this.a;
    }

    @Override // com.baidu.tieba.data.emotions.WritableEmotionGroup
    public String f() {
        return this.b;
    }
}
