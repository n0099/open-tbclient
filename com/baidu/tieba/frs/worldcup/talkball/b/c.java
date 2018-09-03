package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> dLR;
    private String dLS;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.dLR = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.dLR.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.dLS = competition.btn_title;
        }
    }

    public boolean aBz() {
        return this.dLR.size() == 2 && this.dLR.get(0).aBz() && this.dLR.get(1).aBz() && !ap.isEmpty(this.mType) && this.mTime > 0 && !ap.isEmpty(this.dLS);
    }

    public List<d> aBA() {
        return this.dLR;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aBB() {
        return this.dLS;
    }
}
