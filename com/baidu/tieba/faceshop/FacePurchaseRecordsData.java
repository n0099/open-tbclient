package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class FacePurchaseRecordsData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 0;
    public ArrayList<FacePurchasePackageData> buy_his;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public long logid;
    public int time;
    public String usermsg;
}
