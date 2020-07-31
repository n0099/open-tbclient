package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer eyM;
    private String eyN;

    public void a(ActivitySponsor activitySponsor) {
        this.eyM = activitySponsor.is_sponsor;
        this.eyN = activitySponsor.sponsor_url;
    }
}
