package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String gbm;
    private ArrayList<b> gbn = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gbn.add(bVar);
    }

    public b ri(int i) {
        return (b) v.getItem(this.gbn, i);
    }

    public String bCa() {
        return this.gbm;
    }

    public void Bp(String str) {
        this.gbm = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
