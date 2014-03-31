package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class d extends af {
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
        ab.a();
        Bitmap c = ab.c(this.a, "panel.png");
        ab.a();
        Bitmap c2 = ab.c(this.a, "panel_momo.png");
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

    @Override // com.baidu.tbadk.editortool.af
    public final String a(int i) {
        if (i >= this.e.size()) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // com.baidu.tbadk.editortool.af
    public final boolean a(String str) {
        return this.e.contains(str);
    }

    @Override // com.baidu.tbadk.editortool.af
    public final EmotionGroupType c() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b b(String str) {
        ab.a();
        String a = ab.a(str, false);
        ab.a();
        Bitmap c = ab.c(this.a, a);
        if (c == null) {
            return null;
        }
        return new com.baidu.adp.widget.ImageView.b(c, false, str);
    }

    @Override // com.baidu.tbadk.editortool.af
    public final com.baidu.adp.widget.ImageView.b c(String str) {
        ab.a();
        return ab.a().d(this.a, ab.a(str, true));
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int d() {
        return this.e.size();
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final String f() {
        return this.b;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int g() {
        return this.c;
    }

    @Override // com.baidu.tbadk.editortool.af
    public final int h() {
        return this.d;
    }
}
