package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import com.baidu.tieba.util.bm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FacePackageData extends com.baidu.tieba.util.ap implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("banner_url")
    public String bannerUrl;
    @SerializedName("buy_status")
    public int buyStatus;
    @SerializedName("can_download")
    public int canDownload;
    @SerializedName("cover_url")
    public String coverUrl;
    @SerializedName("face_list")
    public ArrayList<String> faceList;
    @SerializedName("icon_url")
    public String iconUrl;
    @SerializedName("new_icon")
    public String newIcon;
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
    @SerializedName("recmd_url")
    public String recmdUrl;
    @SerializedName("size_height")
    public int sizeHeight;
    @SerializedName("size_width")
    public int sizeWidth;
    public int downloaded = 0;
    public int downloading = 0;
    public long downloadTotal = 0;
    public long downloadNow = 0;
    public String orderId = "";

    @Override // com.baidu.tieba.util.ap, com.baidu.tieba.util.ar
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        if (!bm.c(this.bannerUrl)) {
            linkedList.add(this.bannerUrl);
        }
        if (!bm.c(this.newIcon)) {
            linkedList.add(this.newIcon);
        }
        return linkedList;
    }
}
