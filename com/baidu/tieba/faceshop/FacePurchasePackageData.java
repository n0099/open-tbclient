package com.baidu.tieba.faceshop;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FacePurchasePackageData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = 0;
    public String cover_url;
    public String pack_url;
    public String pdesc;
    public int pid;
    public String pname;
    public String price;
    public long puy_time;

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.cover_url != null) {
            arrayList.add(this.cover_url);
        }
        return arrayList;
    }
}
