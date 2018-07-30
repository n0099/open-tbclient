package com.baidu.tieba.frs.worldcup.talkball.a;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bb;
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
/* loaded from: classes3.dex */
public class b {
    private TalkBallFragment dLO;
    private i dLP;
    private d dLQ;
    private com.baidu.tieba.frs.entelechy.a.d dLR;
    private i dsD;
    private p dsF;
    private e dtC;
    private m dts;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.dLO = talkBallFragment;
        this.dts = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dLP = new i(this.dLO.getPageContext(), bb.ahx, this.dLO.getUniqueId());
        this.dLQ = new d(this.dLO.getPageContext(), f.dLZ, this.dLO.getUniqueId());
        this.dtC = new e(this.dLO.getPageContext(), bb.ahG, this.dLO.getUniqueId());
        this.dsF = new p(this.dLO.getPageContext(), bb.ahA, this.dLO.getUniqueId());
        this.dLR = new com.baidu.tieba.frs.entelechy.a.d(this.dLO.getPageContext(), bb.ahF, this.dLO.getUniqueId());
        this.dsD = new i(this.dLO.getPageContext(), bb.ahz, this.dLO.getUniqueId());
        this.dLP.setVoiceManager(this.dLO.getVoiceManager());
        this.dsD.setVoiceManager(this.dLO.getVoiceManager());
        this.mAdapters.add(new l(this.dLO.getPageContext(), com.baidu.tieba.frs.m.doV));
        this.mAdapters.add(this.dLP);
        this.mAdapters.add(this.dLQ);
        this.mAdapters.add(this.dsF);
        this.mAdapters.add(this.dtC);
        this.mAdapters.add(this.dLR);
        this.mAdapters.add(this.dsD);
        this.dts.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aBz();
        this.dLQ.setForumId(this.dLO.getForumId());
        this.dts.setData(arrayList);
    }

    private void aBz() {
        c.a(this.dLO.getForumId(), 1, this.dLP, this.dsF, this.dtC, this.dsD, this.dLR);
    }

    public void notifyDataSetChanged() {
        if (this.dts.getListAdapter() != null) {
            this.dts.getListAdapter().notifyDataSetChanged();
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
