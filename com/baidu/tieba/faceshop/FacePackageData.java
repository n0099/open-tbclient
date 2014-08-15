package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class FacePackageData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("banner_url")
    public String bannerUrl;
    @SerializedName("buy_status")
    public int buyStatus;
    @SerializedName("can_download")
    public int canDownload;
    @SerializedName("cover_url")
    public String coverUrl;
    @SerializedName("face_dynamic_list")
    public ArrayList<String> faceDynamicList;
    @SerializedName("face_list")
    public ArrayList<String> faceList;
    @SerializedName("face_name_list")
    public ArrayList<String> faceNameList;
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
    @SerializedName("tag_url")
    public String tagUrl;
    public int downloaded = 0;
    public int downloading = 0;
    public long downloadTotal = 0;
    public long downloadNow = 0;
    public String orderId = "";

    @Override // com.baidu.tbadk.core.util.a
    public LinkedList<String> getImageUrl() {
        LinkedList<String> linkedList = new LinkedList<>();
        if (!com.baidu.tbadk.core.util.ba.c(this.bannerUrl)) {
            linkedList.add(this.bannerUrl);
        }
        if (!com.baidu.tbadk.core.util.ba.c(this.newIcon)) {
            linkedList.add(this.newIcon);
        }
        if (!com.baidu.tbadk.core.util.ba.c(this.tagUrl)) {
            linkedList.add(this.tagUrl);
        }
        return linkedList;
    }
}
