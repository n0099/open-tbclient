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
    private i dOE;
    private p dOG;
    private m dPC;
    private e dPM;
    private TalkBallFragment eiT;
    private i eiU;
    private d eiV;
    private com.baidu.tieba.frs.entelechy.a.d eiW;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.eiT = talkBallFragment;
        this.dPC = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.eiU = new i(this.eiT.getPageContext(), bb.atg, this.eiT.getUniqueId());
        this.eiV = new d(this.eiT.getPageContext(), f.eje, this.eiT.getUniqueId());
        this.dPM = new e(this.eiT.getPageContext(), bb.atp, this.eiT.getUniqueId());
        this.dOG = new p(this.eiT.getPageContext(), bb.atj, this.eiT.getUniqueId());
        this.eiW = new com.baidu.tieba.frs.entelechy.a.d(this.eiT.getPageContext(), bb.ato, this.eiT.getUniqueId());
        this.dOE = new i(this.eiT.getPageContext(), bb.ati, this.eiT.getUniqueId());
        this.eiU.setVoiceManager(this.eiT.getVoiceManager());
        this.dOE.setVoiceManager(this.eiT.getVoiceManager());
        this.mAdapters.add(new l(this.eiT.getPageContext(), com.baidu.tieba.frs.m.dKG));
        this.mAdapters.add(this.eiU);
        this.mAdapters.add(this.eiV);
        this.mAdapters.add(this.dOG);
        this.mAdapters.add(this.dPM);
        this.mAdapters.add(this.eiW);
        this.mAdapters.add(this.dOE);
        this.dPC.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aIl();
        this.eiV.setForumId(this.eiT.getForumId());
        this.dPC.setData(arrayList);
    }

    private void aIl() {
        c.a(this.eiT.getForumId(), 1, this.eiU, this.dOG, this.dPM, this.dOE, this.eiW);
    }

    public void notifyDataSetChanged() {
        if (this.dPC.getListAdapter() != null) {
            this.dPC.getListAdapter().notifyDataSetChanged();
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
