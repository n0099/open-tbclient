package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String emt;
    private List<c> emy;
    private List<String> emz;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.emy = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aJB()) {
                        this.emy.add(cVar);
                    }
                }
            }
            this.emt = guessingCompetition.ahead_url;
            this.emz = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.emz.add(str);
                    }
                }
            }
        }
    }

    public List<c> aJE() {
        return this.emy;
    }

    public String aJF() {
        return this.emt;
    }

    public List<String> aJG() {
        return this.emz;
    }
}
