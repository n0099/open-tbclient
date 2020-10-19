package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.y;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String hnS;
    private ArrayList<b> hnT = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.hnT.add(bVar);
    }

    public b vQ(int i) {
        return (b) y.getItem(this.hnT, i);
    }

    public String cef() {
        return this.hnS;
    }

    public void HR(String str) {
        this.hnS = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
