package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> dLV;
    private String dLW;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.dLV = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.dLV.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.dLW = competition.btn_title;
        }
    }

    public boolean aBC() {
        return this.dLV.size() == 2 && this.dLV.get(0).aBC() && this.dLV.get(1).aBC() && !ap.isEmpty(this.mType) && this.mTime > 0 && !ap.isEmpty(this.dLW);
    }

    public List<d> aBD() {
        return this.dLV;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aBE() {
        return this.dLW;
    }
}
