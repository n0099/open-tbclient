package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private List<String> ecA;
    private String ecu;
    private List<c> ecz;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.ecz = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aGC()) {
                        this.ecz.add(cVar);
                    }
                }
            }
            this.ecu = guessingCompetition.ahead_url;
            this.ecA = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.ecA.add(str);
                    }
                }
            }
        }
    }

    public List<c> aGF() {
        return this.ecz;
    }

    public String aGG() {
        return this.ecu;
    }

    public List<String> aGH() {
        return this.ecA;
    }
}
