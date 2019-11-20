package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cCP;
    private String cCQ;

    public void a(ActivitySponsor activitySponsor) {
        this.cCP = activitySponsor.is_sponsor;
        this.cCQ = activitySponsor.sponsor_url;
    }
}
