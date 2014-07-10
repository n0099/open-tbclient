package com.baidu.tbadk.editortool;

import android.graphics.Bitmap;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends ae {
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
        Bitmap c = ab.a().c(this.a, "panel.png");
        Bitmap c2 = ab.a().c(this.a, "panel_momo.png");
        if (c != null) {
            a(new com.baidu.adp.widget.a.a(c, false));
        }
        if (c2 != null) {
            b(new com.baidu.adp.widget.a.a(c2, false));
        }
        this.e.clear();
        for (EmotionData emotionData : u.a().b(this.a)) {
            this.e.add(emotionData.getSharpText());
        }
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String a(int i) {
        if (i >= this.e.size()) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean a(String str) {
        return this.e.contains(str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public EmotionGroupType c() {
        return EmotionGroupType.BIG_EMOTION;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a b(String str) {
        Bitmap c = ab.a().c(this.a, ab.a().a(str, false));
        if (c == null) {
            return null;
        }
        return new com.baidu.adp.widget.a.a(c, false, str);
    }

    @Override // com.baidu.tbadk.editortool.ae
    public com.baidu.adp.widget.a.a c(String str) {
        return ab.a().d(this.a, ab.a().a(str, true));
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int d() {
        return this.e.size();
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String e() {
        return this.a;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public String f() {
        return this.b;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int g() {
        return this.c;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public int h() {
        return this.d;
    }

    @Override // com.baidu.tbadk.editortool.ae
    public boolean i() {
        return false;
    }
}
