package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String fvO;
    private ArrayList<b> fvP = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.fvP.add(bVar);
    }

    public b qN(int i) {
        return (b) v.getItem(this.fvP, i);
    }

    public String bsn() {
        return this.fvO;
    }

    public void zE(String str) {
        this.fvO = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
