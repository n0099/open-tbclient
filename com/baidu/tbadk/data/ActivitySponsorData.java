package com.baidu.tbadk.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import tbclient.ActivitySponsor;
/* loaded from: classes.dex */
public class ActivitySponsorData extends OrmObject {
    private Integer fzM;
    private String fzN;

    public void a(ActivitySponsor activitySponsor) {
        this.fzM = activitySponsor.is_sponsor;
        this.fzN = activitySponsor.sponsor_url;
    }
}
