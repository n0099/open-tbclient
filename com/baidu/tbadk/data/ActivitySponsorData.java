package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer bop;
    private String boq;

    public void a(ActivitySponsor activitySponsor) {
        this.bop = activitySponsor.is_sponsor;
        this.boq = activitySponsor.sponsor_url;
    }
}
