package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> elQ;
    private String elR;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.elQ = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.elQ.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.elR = competition.btn_title;
        }
    }

    public boolean aJd() {
        return this.elQ.size() == 2 && this.elQ.get(0).aJd() && this.elQ.get(1).aJd() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.elR);
    }

    public List<d> aJe() {
        return this.elQ;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aJf() {
        return this.elR;
    }
}
