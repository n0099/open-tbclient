package com.baidu.tieba.faceshop;

import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class FacePackageData extends com.baidu.tbadk.core.util.a implements Serializable {
    private static final long serialVersionUID = 0;
    public String banner_url;
    public int buy_status;
    public int can_download;
    public String cover_url;
    public ArrayList<String> face_dynamic_list;
    public ArrayList<String> face_list;
    public ArrayList<String> face_name_list;
    public String icon_url;
    public String new_icon;
    public String pack_url;
    public String pdesc;
    public int pid;
    public String pname;
    public String price;
    public String recmd_url;
    public int size_height;
    public int size_width;
    public String tag_url;
    public int downloaded = 0;
    public int downloading = 0;
    public long downloadTotal = 0;
    public long downloadNow = 0;
    public String orderId = "";

    @Override // com.baidu.tbadk.core.util.a
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!com.baidu.tbadk.core.util.az.aA(this.banner_url)) {
            arrayList.add(this.banner_url);
        }
        if (!com.baidu.tbadk.core.util.az.aA(this.new_icon)) {
            arrayList.add(this.new_icon);
        }
        if (!com.baidu.tbadk.core.util.az.aA(this.tag_url)) {
            arrayList.add(this.tag_url);
        }
        return arrayList;
    }
}
