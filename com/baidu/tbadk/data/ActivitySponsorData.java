package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer boy;
    private String boz;

    public void a(ActivitySponsor activitySponsor) {
        this.boy = activitySponsor.is_sponsor;
        this.boz = activitySponsor.sponsor_url;
    }
}
