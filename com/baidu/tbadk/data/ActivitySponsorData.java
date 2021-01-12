package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer fxw;
    private String fxx;

    public void a(ActivitySponsor activitySponsor) {
        this.fxw = activitySponsor.is_sponsor;
        this.fxx = activitySponsor.sponsor_url;
    }
}
