package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String gqr;
    private ArrayList<b> gqs = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gqs.add(bVar);
    }

    public b rN(int i) {
        return (b) v.getItem(this.gqs, i);
    }

    public String bIw() {
        return this.gqr;
    }

    public void CY(String str) {
        this.gqr = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
