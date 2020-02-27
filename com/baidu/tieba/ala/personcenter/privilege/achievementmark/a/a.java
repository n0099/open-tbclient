package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String fvN;
    private ArrayList<b> fvO = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.fvO.add(bVar);
    }

    public b qN(int i) {
        return (b) v.getItem(this.fvO, i);
    }

    public String bsl() {
        return this.fvN;
    }

    public void zE(String str) {
        this.fvN = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
