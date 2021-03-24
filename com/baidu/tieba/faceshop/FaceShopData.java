package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class FaceShopData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 0;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public long logid;
    public ArrayList<FacePackageData> pack_list;
    public long time;
    public String usermsg;
    public int total_num = 0;
    public int has_more = 0;

    public void add(FaceShopData faceShopData) {
        ArrayList<FacePackageData> arrayList;
        if (faceShopData == null || (arrayList = faceShopData.pack_list) == null || arrayList.size() == 0) {
            return;
        }
        this.has_more = faceShopData.has_more;
        ArrayList<FacePackageData> arrayList2 = this.pack_list;
        if (arrayList2 != null) {
            arrayList2.addAll(faceShopData.pack_list);
        } else {
            this.pack_list = faceShopData.pack_list;
        }
    }
}
