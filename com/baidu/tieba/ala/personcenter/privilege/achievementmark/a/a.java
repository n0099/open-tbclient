package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class a {
    private String hWO;
    private ArrayList<b> hWP = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hWP.add(bVar);
    }

    public b wh(int i) {
        return (b) x.getItem(this.hWP, i);
    }

    public String clY() {
        return this.hWO;
    }

    public void HJ(String str) {
        this.hWO = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
