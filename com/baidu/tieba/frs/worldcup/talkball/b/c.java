package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes3.dex */
public class c {
    private List<d> dTj;
    private String dTk;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.dTj = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.dTj.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.dTk = competition.btn_title;
        }
    }

    public boolean aDM() {
        return this.dTj.size() == 2 && this.dTj.get(0).aDM() && this.dTj.get(1).aDM() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.dTk);
    }

    public List<d> aDN() {
        return this.dTj;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aDO() {
        return this.dTk;
    }
}
