package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes8.dex */
public class FaceBuyData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 0;
    public BuyInfo buy_info;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public long logid;
    public int time;
    public String usermsg;

    /* loaded from: classes8.dex */
    public static class BuyInfo extends OrmObject implements Serializable {
        private static final long serialVersionUID = -634843997435L;
        public int buy_status;
        public String buy_url;
        public String order_id;
        public String return_url;
    }
}
