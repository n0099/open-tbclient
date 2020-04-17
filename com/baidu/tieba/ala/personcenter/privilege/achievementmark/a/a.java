package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String gbh;
    private ArrayList<b> gbi = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gbi.add(bVar);
    }

    public b ri(int i) {
        return (b) v.getItem(this.gbi, i);
    }

    public String bCc() {
        return this.gbh;
    }

    public void Bm(String str) {
        this.gbh = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
