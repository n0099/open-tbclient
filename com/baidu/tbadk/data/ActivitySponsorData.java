package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer ejH;
    private String ejI;

    public void a(ActivitySponsor activitySponsor) {
        this.ejH = activitySponsor.is_sponsor;
        this.ejI = activitySponsor.sponsor_url;
    }
}
