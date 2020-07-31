package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.x;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class a {
    private String gID;
    private ArrayList<b> gIE = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.gIE.add(bVar);
    }

    public b sD(int i) {
        return (b) x.getItem(this.gIE, i);
    }

    public String bOK() {
        return this.gID;
    }

    public void Ek(String str) {
        this.gID = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
