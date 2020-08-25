package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String gVg;
    private ArrayList<b> gVh = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gVh.add(bVar);
    }

    public b uR(int i) {
        return (b) y.getItem(this.gVh, i);
    }

    public String bYK() {
        return this.gVg;
    }

    public void GJ(String str) {
        this.gVg = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
