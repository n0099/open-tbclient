package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a {
    private String fqc;
    private ArrayList<b> fqd = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.fqd.add(bVar);
    }

    public b qB(int i) {
        return (b) v.getItem(this.fqd, i);
    }

    public String bpG() {
        return this.fqc;
    }

    public void ze(String str) {
        this.fqc = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
