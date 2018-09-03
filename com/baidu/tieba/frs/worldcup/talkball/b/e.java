package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String dLO;
    private List<c> dLT;
    private List<String> dLU;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.dLT = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aBz()) {
                        this.dLT.add(cVar);
                    }
                }
            }
            this.dLO = guessingCompetition.ahead_url;
            this.dLU = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ap.isEmpty(str)) {
                        this.dLU.add(str);
                    }
                }
            }
        }
    }

    public List<c> aBC() {
        return this.dLT;
    }

    public String aBD() {
        return this.dLO;
    }

    public List<String> aBE() {
        return this.dLU;
    }
}
