package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    private String idf;
    private ArrayList<b> idg = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.idg.add(bVar);
    }

    public b wt(int i) {
        return (b) y.getItem(this.idg, i);
    }

    public String cnj() {
        return this.idf;
    }

    public void Ix(String str) {
        this.idf = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
