package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes2.dex */
public class c {
    private List<d> dJg;
    private String mBtnTitle;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.dJg = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.dJg.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.mBtnTitle = competition.btn_title;
        }
    }

    public boolean aAT() {
        return this.dJg.size() == 2 && this.dJg.get(0).aAT() && this.dJg.get(1).aAT() && !ap.isEmpty(this.mType) && this.mTime > 0 && !ap.isEmpty(this.mBtnTitle);
    }

    public List<d> aAU() {
        return this.dJg;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aAV() {
        return this.mBtnTitle;
    }
}
