package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
/* loaded from: classes10.dex */
public class a {
    private String ibv;
    private ArrayList<b> ibw = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.ibw.add(bVar);
    }

    public b xN(int i) {
        return (b) x.getItem(this.ibw, i);
    }

    public String cpQ() {
        return this.ibv;
    }

    public void IU(String str) {
        this.ibv = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
