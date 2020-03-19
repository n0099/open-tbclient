package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class a {
    private String fwH;
    private ArrayList<b> fwI = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.fwI.add(bVar);
    }

    public b qP(int i) {
        return (b) v.getItem(this.fwI, i);
    }

    public String bsu() {
        return this.fwH;
    }

    public void zH(String str) {
        this.fwH = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
