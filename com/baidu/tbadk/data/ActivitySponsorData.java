package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aAj;
    private String aAk;

    public void a(ActivitySponsor activitySponsor) {
        this.aAj = activitySponsor.is_sponsor;
        this.aAk = activitySponsor.sponsor_url;
    }
}
