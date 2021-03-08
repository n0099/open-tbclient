package com.baidu.tieba.faceshop;

import com.baidu.tbadk.core.util.AbstractImageProvider;
import com.baidu.tbadk.core.util.au;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class FacePackageData extends AbstractImageProvider implements Serializable {
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

    @Override // com.baidu.tbadk.core.util.AbstractImageProvider
    public ArrayList<String> getImageUrl() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (!au.isEmpty(this.banner_url)) {
            arrayList.add(this.banner_url);
        }
        if (!au.isEmpty(this.new_icon)) {
            arrayList.add(this.new_icon);
        }
        if (!au.isEmpty(this.tag_url)) {
            arrayList.add(this.tag_url);
        }
        return arrayList;
    }
}
