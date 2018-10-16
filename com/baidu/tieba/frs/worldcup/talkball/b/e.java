package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String eaZ;
    private List<c> ebe;
    private List<String> ebf;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.ebe = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aHe()) {
                        this.ebe.add(cVar);
                    }
                }
            }
            this.eaZ = guessingCompetition.ahead_url;
            this.ebf = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.ebf.add(str);
                    }
                }
            }
        }
    }

    public List<c> aHh() {
        return this.ebe;
    }

    public String aHi() {
        return this.eaZ;
    }

    public List<String> aHj() {
        return this.ebf;
    }
}
