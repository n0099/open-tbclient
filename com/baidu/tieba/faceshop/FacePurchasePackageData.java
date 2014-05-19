package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FacePurchasePackageData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("cover_url")
    public String coverUrl;
    @SerializedName("pack_url")
    public String packUrl;
    @SerializedName("pdesc")
    public String pdesc;
    @SerializedName("pid")
    public int pid;
    @SerializedName("pname")
    public String pname;
    @SerializedName("price")
    public String price;
    @SerializedName("puy_time")
    public long puyTime;

    @Override // com.baidu.tbadk.core.util.a, com.baidu.tbadk.core.util.ad
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        if (this.coverUrl != null) {
            linkedList.add(this.coverUrl);
        }
        return linkedList;
    }
}
