package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.Country;
/* loaded from: classes2.dex */
public class c {
    private List<d> dFN;
    private String mBtnTitle;
    private long mTime;
    private String mType;

    public void a(Competition competition) {
        if (competition != null) {
            this.dFN = new ArrayList();
            List<Country> list = competition.country;
            if (list != null) {
                for (Country country : list) {
                    d dVar = new d();
                    dVar.a(country);
                    this.dFN.add(dVar);
                }
            }
            this.mTime = competition.time.longValue() * 1000;
            this.mType = competition.type;
            this.mBtnTitle = competition.btn_title;
        }
    }

    public boolean aAm() {
        return this.dFN.size() == 2 && this.dFN.get(0).aAm() && this.dFN.get(1).aAm() && !ao.isEmpty(this.mType) && this.mTime > 0 && !ao.isEmpty(this.mBtnTitle);
    }

    public List<d> aAn() {
        return this.dFN;
    }

    public long getTime() {
        return this.mTime;
    }

    public String getType() {
        return this.mType;
    }

    public String aAo() {
        return this.mBtnTitle;
    }
}
