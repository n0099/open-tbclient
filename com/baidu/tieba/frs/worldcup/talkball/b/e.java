package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private List<String> emA;
    private String emu;
    private List<c> emz;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.emz = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aJB()) {
                        this.emz.add(cVar);
                    }
                }
            }
            this.emu = guessingCompetition.ahead_url;
            this.emA = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.emA.add(str);
                    }
                }
            }
        }
    }

    public List<c> aJE() {
        return this.emz;
    }

    public String aJF() {
        return this.emu;
    }

    public List<String> aJG() {
        return this.emA;
    }
}
