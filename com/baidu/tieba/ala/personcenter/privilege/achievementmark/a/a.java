package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    private String ibi;
    private ArrayList<b> ibj = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.ibj.add(bVar);
    }

    public b ws(int i) {
        return (b) y.getItem(this.ibj, i);
    }

    public String cmW() {
        return this.ibi;
    }

    public void In(String str) {
        this.ibi = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
