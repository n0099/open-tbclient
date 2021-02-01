package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class FaceShopData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 0;
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
        if (faceShopData != null && faceShopData.pack_list != null && faceShopData.pack_list.size() != 0) {
            this.has_more = faceShopData.has_more;
            if (this.pack_list != null) {
                this.pack_list.addAll(faceShopData.pack_list);
            } else {
                this.pack_list = faceShopData.pack_list;
            }
        }
    }
}
