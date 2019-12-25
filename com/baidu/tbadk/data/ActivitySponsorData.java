package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer dqF;
    private String dqG;

    public void a(ActivitySponsor activitySponsor) {
        this.dqF = activitySponsor.is_sponsor;
        this.dqG = activitySponsor.sponsor_url;
    }
}
