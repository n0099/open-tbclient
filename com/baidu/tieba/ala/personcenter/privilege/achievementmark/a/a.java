package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String hzN;
    private ArrayList<b> hzO = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hzO.add(bVar);
    }

    public b wk(int i) {
        return (b) y.getItem(this.hzO, i);
    }

    public String chh() {
        return this.hzN;
    }

    public void Iq(String str) {
        this.hzN = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
