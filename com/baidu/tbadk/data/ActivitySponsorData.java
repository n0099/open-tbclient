package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer bog;
    private String boh;

    public void a(ActivitySponsor activitySponsor) {
        this.bog = activitySponsor.is_sponsor;
        this.boh = activitySponsor.sponsor_url;
    }
}
