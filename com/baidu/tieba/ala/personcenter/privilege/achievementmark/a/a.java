package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.w;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String gDg;
    private ArrayList<b> gDh = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gDh.add(bVar);
    }

    public b sl(int i) {
        return (b) w.getItem(this.gDh, i);
    }

    public String bLB() {
        return this.gDg;
    }

    public void Dz(String str) {
        this.gDg = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
