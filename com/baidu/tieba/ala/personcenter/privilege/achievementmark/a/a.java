package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String gVk;
    private ArrayList<b> gVl = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gVl.add(bVar);
    }

    public b uR(int i) {
        return (b) y.getItem(this.gVl, i);
    }

    public String bYL() {
        return this.gVk;
    }

    public void GK(String str) {
        this.gVk = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
