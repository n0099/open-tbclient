package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> ecx;
    private String ecy;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.ecx = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.ecx.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.ecy = competition.btn_title;
        }
    }

    public boolean aGC() {
        return this.ecx.size() == 2 && this.ecx.get(0).aGC() && this.ecx.get(1).aGC() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.ecy);
    }

    public List<d> aGD() {
        return this.ecx;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aGE() {
        return this.ecy;
    }
}
