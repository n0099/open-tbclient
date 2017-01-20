package com.baidu.tieba.account.appeal;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import java.io.Serializable;
/* loaded from: classes.dex */
public class AppealData extends OrmObject implements Serializable {
    private static final long serialVersionUID = 8636034753470244254L;
    public int errNo = 0;
    public String errMsg = "";
    public int task_id = 0;
}
