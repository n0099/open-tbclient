package com.baidu.tieba.ala.personcenter.privilege.achievementmark.a;

import com.baidu.tbadk.core.util.v;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private String ezs;
    private ArrayList<b> ezt = new ArrayList<>();
    private int type;

    public void b(b bVar) {
        this.ezt.add(bVar);
    }

    public b oj(int i) {
        return (b) v.getItem(this.ezt, i);
    }

    public String aXL() {
        return this.ezs;
    }

    public void ul(String str) {
        this.ezs = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
