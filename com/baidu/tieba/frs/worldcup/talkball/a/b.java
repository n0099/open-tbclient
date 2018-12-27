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
    private i dRs;
    private p dRu;
    private e dSA;
    private m dSq;
    private TalkBallFragment elJ;
    private i elK;
    private d elL;
    private com.baidu.tieba.frs.entelechy.a.d elM;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.elJ = talkBallFragment;
        this.dSq = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.elK = new i(this.elJ.getPageContext(), bb.atg, this.elJ.getUniqueId());
        this.elL = new d(this.elJ.getPageContext(), f.elU, this.elJ.getUniqueId());
        this.dSA = new e(this.elJ.getPageContext(), bb.atp, this.elJ.getUniqueId());
        this.dRu = new p(this.elJ.getPageContext(), bb.atj, this.elJ.getUniqueId());
        this.elM = new com.baidu.tieba.frs.entelechy.a.d(this.elJ.getPageContext(), bb.ato, this.elJ.getUniqueId());
        this.dRs = new i(this.elJ.getPageContext(), bb.ati, this.elJ.getUniqueId());
        this.elK.setVoiceManager(this.elJ.getVoiceManager());
        this.dRs.setVoiceManager(this.elJ.getVoiceManager());
        this.mAdapters.add(new l(this.elJ.getPageContext(), com.baidu.tieba.frs.m.dNu));
        this.mAdapters.add(this.elK);
        this.mAdapters.add(this.elL);
        this.mAdapters.add(this.dRu);
        this.mAdapters.add(this.dSA);
        this.mAdapters.add(this.elM);
        this.mAdapters.add(this.dRs);
        this.dSq.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aJa();
        this.elL.setForumId(this.elJ.getForumId());
        this.dSq.setData(arrayList);
    }

    private void aJa() {
        c.a(this.elJ.getForumId(), 1, this.elK, this.dRu, this.dSA, this.dRs, this.elM);
    }

    public void notifyDataSetChanged() {
        if (this.dSq.getListAdapter() != null) {
            this.dSq.getListAdapter().notifyDataSetChanged();
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
