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
    private p dGP;
    private m dHV;
    private i dHi;
    private e dIf;
    private TalkBallFragment eaV;
    private i eaW;
    private d eaX;
    private com.baidu.tieba.frs.entelechy.a.d eaY;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.eaV = talkBallFragment;
        this.dHV = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.eaW = new i(this.eaV.getPageContext(), bb.aoS, this.eaV.getUniqueId());
        this.eaX = new d(this.eaV.getPageContext(), f.ebg, this.eaV.getUniqueId());
        this.dIf = new e(this.eaV.getPageContext(), bb.apb, this.eaV.getUniqueId());
        this.dGP = new p(this.eaV.getPageContext(), bb.aoV, this.eaV.getUniqueId());
        this.eaY = new com.baidu.tieba.frs.entelechy.a.d(this.eaV.getPageContext(), bb.apa, this.eaV.getUniqueId());
        this.dHi = new i(this.eaV.getPageContext(), bb.aoU, this.eaV.getUniqueId());
        this.eaW.setVoiceManager(this.eaV.getVoiceManager());
        this.dHi.setVoiceManager(this.eaV.getVoiceManager());
        this.mAdapters.add(new l(this.eaV.getPageContext(), com.baidu.tieba.frs.m.dCR));
        this.mAdapters.add(this.eaW);
        this.mAdapters.add(this.eaX);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dIf);
        this.mAdapters.add(this.eaY);
        this.mAdapters.add(this.dHi);
        this.dHV.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aHb();
        this.eaX.setForumId(this.eaV.getForumId());
        this.dHV.setData(arrayList);
    }

    private void aHb() {
        c.a(this.eaV.getForumId(), 1, this.eaW, this.dGP, this.dIf, this.dHi, this.eaY);
    }

    public void notifyDataSetChanged() {
        if (this.dHV.getListAdapter() != null) {
            this.dHV.getListAdapter().notifyDataSetChanged();
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
