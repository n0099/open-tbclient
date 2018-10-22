package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> ebd;
    private String ebe;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.ebd = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.ebd.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.ebe = competition.btn_title;
        }
    }

    public boolean aHe() {
        return this.ebd.size() == 2 && this.ebd.get(0).aHe() && this.ebd.get(1).aHe() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.ebe);
    }

    public List<d> aHf() {
        return this.ebd;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aHg() {
        return this.ebe;
    }
}
