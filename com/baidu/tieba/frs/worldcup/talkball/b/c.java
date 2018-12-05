package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> eja;
    private String ejb;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.eja = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.eja.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.ejb = competition.btn_title;
        }
    }

    public boolean aIo() {
        return this.eja.size() == 2 && this.eja.get(0).aIo() && this.eja.get(1).aIo() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.ejb);
    }

    public List<d> aIp() {
        return this.eja;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aIq() {
        return this.ejb;
    }
}
