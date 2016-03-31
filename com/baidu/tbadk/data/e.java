package com.baidu.tbadk.data;

import com.baidu.adp.lib.util.BdLog;
import tbclient.Lbs;
/* loaded from: classes.dex */
public class e {
    private String lat;
    private String lng;
    private String name = null;

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
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
            } catch (Exception e) {
                BdLog.detailException(e);
            }
        }
    }
}
