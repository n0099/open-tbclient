package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> emx;
    private String emy;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.emx = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.emx.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.emy = competition.btn_title;
        }
    }

    public boolean aJB() {
        return this.emx.size() == 2 && this.emx.get(0).aJB() && this.emx.get(1).aJB() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.emy);
    }

    public List<d> aJC() {
        return this.emx;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aJD() {
        return this.emy;
    }
}
