package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer cqg;
    private String cqh;

    public void a(ActivitySponsor activitySponsor) {
        this.cqg = activitySponsor.is_sponsor;
        this.cqh = activitySponsor.sponsor_url;
    }
}
