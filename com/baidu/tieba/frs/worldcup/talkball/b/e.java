package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String eba;
    private List<c> ebf;
    private List<String> ebg;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.ebf = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aHe()) {
                        this.ebf.add(cVar);
                    }
                }
            }
            this.eba = guessingCompetition.ahead_url;
            this.ebg = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.ebg.add(str);
                    }
                }
            }
        }
    }

    public List<c> aHh() {
        return this.ebf;
    }

    public String aHi() {
        return this.eba;
    }

    public List<String> aHj() {
        return this.ebg;
    }
}
