package com.baidu.tieba.frs.worldcup.talkball.a;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tieba.frs.entelechy.a.e;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.worldcup.c;
import com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
import com.baidu.tieba.frs.worldcup.videotopic.b.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private TalkBallFragment dIZ;
    private i dJa;
    private d dJb;
    private com.baidu.tieba.frs.entelechy.a.d dJc;
    private i dpQ;
    private p dpS;
    private m dqF;
    private e dqP;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.dIZ = talkBallFragment;
        this.dqF = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dJa = new i(this.dIZ.getPageContext(), bc.aib, this.dIZ.getUniqueId());
        this.dJb = new d(this.dIZ.getPageContext(), f.dJj, this.dIZ.getUniqueId());
        this.dqP = new e(this.dIZ.getPageContext(), bc.aik, this.dIZ.getUniqueId());
        this.dpS = new p(this.dIZ.getPageContext(), bc.aie, this.dIZ.getUniqueId());
        this.dJc = new com.baidu.tieba.frs.entelechy.a.d(this.dIZ.getPageContext(), bc.aij, this.dIZ.getUniqueId());
        this.dpQ = new i(this.dIZ.getPageContext(), bc.aid, this.dIZ.getUniqueId());
        this.dJa.setVoiceManager(this.dIZ.getVoiceManager());
        this.dpQ.setVoiceManager(this.dIZ.getVoiceManager());
        this.mAdapters.add(new l(this.dIZ.getPageContext(), com.baidu.tieba.frs.m.dmd));
        this.mAdapters.add(this.dJa);
        this.mAdapters.add(this.dJb);
        this.mAdapters.add(this.dpS);
        this.mAdapters.add(this.dqP);
        this.mAdapters.add(this.dJc);
        this.mAdapters.add(this.dpQ);
        this.dqF.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aAQ();
        this.dJb.setForumId(this.dIZ.getForumId());
        this.dqF.setData(arrayList);
    }

    private void aAQ() {
        c.a(this.dIZ.getForumId(), 1, this.dJa, this.dpS, this.dqP, this.dpQ, this.dJc);
    }

    public void notifyDataSetChanged() {
        if (this.dqF.getListAdapter() != null) {
            this.dqF.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }
}
