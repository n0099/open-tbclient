package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.data.LiveCardData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private LiveCardData a;
    private List<g> b = new ArrayList();
    private int c;

    public LiveCardData a() {
        return this.a;
    }

    public void a(LiveCardData liveCardData) {
        this.a = liveCardData;
    }

    public List<g> b() {
        return this.b;
    }

    public void a(List<g> list) {
        this.b = list;
    }

    public void a(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.c == 1;
    }
}
