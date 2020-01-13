package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer dqQ;
    private String dqR;

    public void a(ActivitySponsor activitySponsor) {
        this.dqQ = activitySponsor.is_sponsor;
        this.dqR = activitySponsor.sponsor_url;
    }
}
