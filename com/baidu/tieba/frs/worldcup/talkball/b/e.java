package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ap;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String dLS;
    private List<c> dLX;
    private List<String> dLY;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.dLX = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aBC()) {
                        this.dLX.add(cVar);
                    }
                }
            }
            this.dLS = guessingCompetition.ahead_url;
            this.dLY = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ap.isEmpty(str)) {
                        this.dLY.add(str);
                    }
                }
            }
        }
    }

    public List<c> aBF() {
        return this.dLX;
    }

    public String aBG() {
        return this.dLS;
    }

    public List<String> aBH() {
        return this.dLY;
    }
}
