package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private int a;
    private List<LiveCardData> b = new ArrayList();
    private List<LiveCardData> c = new ArrayList();

    public boolean a() {
        return this.a == 1;
    }

    public void a(int i) {
        this.a = i;
    }

    public List<LiveCardData> b() {
        return this.b;
    }

    public void a(List<LiveCardData> list) {
        this.b = list;
    }

    public List<LiveCardData> c() {
        return this.c;
    }

    public void b(List<LiveCardData> list) {
        this.c = list;
    }
}
