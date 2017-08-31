package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer azu;
    private String azv;

    public void a(ActivitySponsor activitySponsor) {
        this.azu = activitySponsor.is_sponsor;
        this.azv = activitySponsor.sponsor_url;
    }
}
