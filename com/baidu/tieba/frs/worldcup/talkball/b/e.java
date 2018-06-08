package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes2.dex */
public class e {
    private String dFK;
    private List<c> dFO;
    private List<String> dFP;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.dFO = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aAm()) {
                        this.dFO.add(cVar);
                    }
                }
            }
            this.dFK = guessingCompetition.ahead_url;
            this.dFP = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.dFP.add(str);
                    }
                }
            }
        }
    }

    public List<c> aAp() {
        return this.dFO;
    }

    public String aAq() {
        return this.dFK;
    }

    public List<String> aAr() {
        return this.dFP;
    }
}
