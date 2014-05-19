package com.baidu.tieba.im.data;

import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private int a;
    private int b;
    private List<UserData> c = new ArrayList();

    public void a(int i) {
        this.a = i;
    }

    public int a() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public List<UserData> b() {
        return this.c;
    }

    public void a(List<UserData> list) {
        this.c = list;
    }

    public boolean c() {
        return this.a == 1;
    }
}
