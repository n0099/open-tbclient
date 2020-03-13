package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String fwb;
    private ArrayList<b> fwc = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.fwc.add(bVar);
    }

    public b qN(int i) {
        return (b) v.getItem(this.fwc, i);
    }

    public String bso() {
        return this.fwb;
    }

    public void zF(String str) {
        this.fwb = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
