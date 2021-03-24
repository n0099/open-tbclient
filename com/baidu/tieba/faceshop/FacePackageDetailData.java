package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class FacePackageDetailData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 0;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public FacePackageData faces_list;
    public long logid;
    public int time;
    public String usermsg;
}
