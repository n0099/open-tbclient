package com.baidu.tieba.faceshop;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FacePurchasePackageData extends AbstractImageProvider implements Serializable {
    public static final long serialVersionUID = 0;
    public String cover_url;
    public String pack_url;
    public String pdesc;
    public int pid;
    public String pname;
    public String price;
    public long puy_time;

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider, com.baidu.tbadk.core.util.ImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        String str = this.cover_url;
        if (str != null) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
