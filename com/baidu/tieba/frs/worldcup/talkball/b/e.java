package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String elN;
    private List<c> elS;
    private List<String> elT;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.elS = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aJd()) {
                        this.elS.add(cVar);
                    }
                }
            }
            this.elN = guessingCompetition.ahead_url;
            this.elT = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.elT.add(str);
                    }
                }
            }
        }
    }

    public List<c> aJg() {
        return this.elS;
    }

    public String aJh() {
        return this.elN;
    }

    public List<String> aJi() {
        return this.elT;
    }
}
