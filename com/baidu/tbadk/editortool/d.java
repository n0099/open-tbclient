package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class d extends ag {
    private String a;
    private String b;
    private int c;
    private int d;
    private ArrayList<String> e = new ArrayList<>();

    public d(EmotionGroupData emotionGroupData) {
        this.a = emotionGroupData.getGroupId();
        this.b = emotionGroupData.getGroupName();
        this.c = emotionGroupData.getWidth();
        this.d = emotionGroupData.getHeight();
        b();
    }

    private void b() {
        c(2);
        b(4);
        ac.a();
        Bitmap c = ac.c(this.a, "panel.png");
        ac.a();
        Bitmap c2 = ac.c(this.a, "panel_momo.png");
        if (c != null) {
            a(new com.baidu.adp.widget.ImageView.b(c, false));
        }
        if (c2 != null) {
            b(new com.baidu.adp.widget.ImageView.b(c2, false));
        }
        this.e.clear();
        for (EmotionData emotionData : v.a().b(this.a)) {
            this.e.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final String a(int i) {
        if (i >= this.e.size()) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final boolean a(String str) {
        return this.e.contains(str);
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final EmotionGroupType c() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final com.baidu.adp.widget.ImageView.b b(String str) {
        ac.a();
        String a = ac.a(str, false);
        ac.a();
        Bitmap c = ac.c(this.a, a);
        if (c == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.b(c, false, str);
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final com.baidu.adp.widget.ImageView.b c(String str) {
        ac.a();
        return ac.a().d(this.a, ac.a(str, true));
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final int d() {
        return this.e.size();
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final String e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final String f() {
        return this.b;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final int g() {
        return this.c;
    }

    @Override // com.baidu.tbadk.editortool.ag
    public final int h() {
        return this.d;
    }
}
