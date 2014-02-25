package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FacePurchasePackageData extends com.baidu.tieba.util.au implements Serializable {
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

    @Override // com.baidu.tieba.util.au, com.baidu.tieba.util.aw
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        if (this.coverUrl != null) {
            linkedList.add(this.coverUrl);
        }
        return linkedList;
    }
}
