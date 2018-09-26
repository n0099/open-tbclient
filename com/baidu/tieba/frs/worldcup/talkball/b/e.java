package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String dTg;
    private List<c> dTl;
    private List<String> dTm;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.dTl = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aDM()) {
                        this.dTl.add(cVar);
                    }
                }
            }
            this.dTg = guessingCompetition.ahead_url;
            this.dTm = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.dTm.add(str);
                    }
                }
            }
        }
    }

    public List<c> aDP() {
        return this.dTl;
    }

    public String aDQ() {
        return this.dTg;
    }

    public List<String> aDR() {
        return this.dTm;
    }
}
