package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> ebc;
    private String ebd;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.ebc = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.ebc.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.ebd = competition.btn_title;
        }
    }

    public boolean aHe() {
        return this.ebc.size() == 2 && this.ebc.get(0).aHe() && this.ebc.get(1).aHe() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.ebd);
    }

    public List<d> aHf() {
        return this.ebc;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aHg() {
        return this.ebd;
    }
}
