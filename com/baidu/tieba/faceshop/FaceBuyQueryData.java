package com.baidu.tieba.faceshop;

import java.io.Serializable;
/* loaded from: classes.dex */
public class FaceBuyQueryData extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
    private static final long serialVersionUID = 0;
    public BuyResult buy_result;
    public int ctime;
    public String errmsg;
    public int errno;
    public int error_code;
    public String error_msg;
    public long logid;
    public int time;
    public String usermsg;

    /* loaded from: classes.dex */
    public class BuyResult extends com.baidu.adp.lib.a.b.a.a.i implements Serializable {
        private static final long serialVersionUID = -34451984893L;
        public String pack_url;
        public int status;
    }
}
