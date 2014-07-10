package com.baidu.tieba.faceshop;

import com.baidu.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FaceShopData implements Serializable {
    private static final long serialVersionUID = 0;
    @SerializedName("ctime")
    public int ctime;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno;
    @SerializedName("error_code")
    public int errorCode;
    @SerializedName("logid")
    public long logid;
    @SerializedName("pack_list")
    public ArrayList<FacePackageData> packList;
    @SerializedName("time")
    public long time;
    @SerializedName("usermsg")
    public String usermsg;
    @SerializedName("total_num")
    public int totalNum = 0;
    @SerializedName("has_more")
    public int hasMore = 0;

    public void add(FaceShopData faceShopData) {
        if (faceShopData != null && faceShopData.packList != null && faceShopData.packList.size() != 0) {
            this.hasMore = faceShopData.hasMore;
            if (this.packList != null) {
                this.packList.addAll(faceShopData.packList);
            } else {
                this.packList = faceShopData.packList;
            }
        }
    }
}
