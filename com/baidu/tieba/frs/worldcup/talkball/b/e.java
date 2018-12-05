package com.baidu.tieba.frs.worldcup.talkball.b;

import com.baidu.tbadk.core.util.ao;
import java.util.ArrayList;
import java.util.List;
import tbclient.TalkBall.Competition;
import tbclient.TalkBall.GuessingCompetition;
/* loaded from: classes3.dex */
public class e {
    private String eiX;
    private List<c> ejc;
    private List<String> ejd;

    public void a(GuessingCompetition guessingCompetition) {
        if (guessingCompetition != null) {
            this.ejc = new ArrayList();
            List<Competition> list = guessingCompetition.competition;
            if (list != null) {
                for (Competition competition : list) {
                    c cVar = new c();
                    cVar.a(competition);
                    if (cVar.aIo()) {
                        this.ejc.add(cVar);
                    }
                }
            }
            this.eiX = guessingCompetition.ahead_url;
            this.ejd = new ArrayList();
            if (guessingCompetition.winning_message != null) {
                for (String str : guessingCompetition.winning_message) {
                    if (!ao.isEmpty(str)) {
                        this.ejd.add(str);
                    }
                }
            }
        }
    }

    public List<c> aIr() {
        return this.ejc;
    }

    public String aIs() {
        return this.eiX;
    }

    public List<String> aIt() {
        return this.ejd;
    }
}
