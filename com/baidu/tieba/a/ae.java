package com.baidu.tieba.a;

import com.baidu.mapapi.GeoPoint;
import com.baidu.tieba.nearby.MapOverlayItem;
import java.io.Serializable;
/* loaded from: classes.dex */
public class ae implements Serializable {
    private String a = null;
    private String b = null;
    private String c = null;
    private ai d = null;
    private int e;
    private int f;

    public ae(int i, int i2) {
        this.e = 0;
        this.f = 0;
        this.e = i;
        this.f = i2;
    }

    public void a(ai aiVar) {
        this.d = aiVar;
    }

    public ai a() {
        return this.d;
    }

    public String b() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String c() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String d() {
        return this.c;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }

    public MapOverlayItem g() {
        MapOverlayItem mapOverlayItem = new MapOverlayItem(new GeoPoint(e(), f()), c(), d());
        mapOverlayItem.a(this);
        return mapOverlayItem;
    }
}
