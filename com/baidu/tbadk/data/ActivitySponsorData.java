package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer eJo;
    private String eJp;

    public void a(ActivitySponsor activitySponsor) {
        this.eJo = activitySponsor.is_sponsor;
        this.eJp = activitySponsor.sponsor_url;
    }
}
