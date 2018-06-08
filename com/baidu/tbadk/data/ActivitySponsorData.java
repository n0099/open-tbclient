package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer aJx;
    private String aJy;

    public void a(ActivitySponsor activitySponsor) {
        this.aJx = activitySponsor.is_sponsor;
        this.aJy = activitySponsor.sponsor_url;
    }
}
