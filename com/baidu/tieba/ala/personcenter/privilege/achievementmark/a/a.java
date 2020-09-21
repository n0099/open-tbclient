package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String gYR;
    private ArrayList<b> gYS = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gYS.add(bVar);
    }

    public b vk(int i) {
        return (b) y.getItem(this.gYS, i);
    }

    public String caH() {
        return this.gYR;
    }

    public void Hd(String str) {
        this.gYR = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
