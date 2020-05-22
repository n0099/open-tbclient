package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String gqg;
    private ArrayList<b> gqh = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gqh.add(bVar);
    }

    public b rL(int i) {
        return (b) v.getItem(this.gqh, i);
    }

    public String bIu() {
        return this.gqg;
    }

    public void CY(String str) {
        this.gqg = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
