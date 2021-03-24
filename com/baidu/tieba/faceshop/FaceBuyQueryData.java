package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes4.dex */
public class FaceBuyQueryData extends OrmObject implements Serializable {
    public static final long serialVersionUID = 0;
    public BuyResult buy_result;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public String error_msg;
    public long logid;
    public int time;
    public String usermsg;

    /* loaded from: classes4.dex */
    public static class BuyResult extends OrmObject implements Serializable {
        public static final long serialVersionUID = -34451984893L;
        public String pack_url;
        public int status;
    }
}
