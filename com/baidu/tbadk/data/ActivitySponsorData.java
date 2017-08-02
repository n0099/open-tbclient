package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer ayQ;
    private String ayR;

    public void a(ActivitySponsor activitySponsor) {
        this.ayQ = activitySponsor.is_sponsor;
        this.ayR = activitySponsor.sponsor_url;
    }
}
