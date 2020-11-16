package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String hFr;
    private ArrayList<b> hFs = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hFs.add(bVar);
    }

    public b wV(int i) {
        return (b) y.getItem(this.hFs, i);
    }

    public String cjc() {
        return this.hFr;
    }

    public void Ii(String str) {
        this.hFr = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
