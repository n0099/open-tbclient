package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer dvm;
    private String dvn;

    public void a(ActivitySponsor activitySponsor) {
        this.dvm = activitySponsor.is_sponsor;
        this.dvn = activitySponsor.sponsor_url;
    }
}
