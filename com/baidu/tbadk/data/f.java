package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class f {
    private String eLD;
    private String lat;
    private String lng;
    private String name = null;

    public String getDistance() {
        return this.eLD;
    }

    public String getName() {
        return this.name;
    }

    public void a(Lbs lbs) {
        if (lbs != null) {
            try {
                this.name = lbs.name;
                this.lat = lbs.lat;
                this.lng = lbs.lng;
                this.eLD = lbs.distance;
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
