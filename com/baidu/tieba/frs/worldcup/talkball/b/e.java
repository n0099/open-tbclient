package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes2.dex */
public class e {
    private String dJd;
    private List<c> dJh;
    private List<String> dJi;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.dJh = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aAT()) {
                        this.dJh.add(cVar);
                    }
                }
            }
            this.dJd = guessingCompetition.ahead_url;
            this.dJi = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ap.isEmpty(str)) {
                        this.dJi.add(str);
                    }
                }
            }
        }
    }

    public List<c> aAW() {
        return this.dJh;
    }

    public String aAX() {
        return this.dJd;
    }

    public List<String> aAY() {
        return this.dJi;
    }
}
