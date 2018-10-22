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
    private TalkBallFragment eaW;
    private i eaX;
    private d eaY;
    private com.baidu.tieba.frs.entelechy.a.d eaZ;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.eaW = talkBallFragment;
        this.dHV = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.eaX = new i(this.eaW.getPageContext(), bb.aoS, this.eaW.getUniqueId());
        this.eaY = new d(this.eaW.getPageContext(), f.ebh, this.eaW.getUniqueId());
        this.dIf = new e(this.eaW.getPageContext(), bb.apb, this.eaW.getUniqueId());
        this.dGP = new p(this.eaW.getPageContext(), bb.aoV, this.eaW.getUniqueId());
        this.eaZ = new com.baidu.tieba.frs.entelechy.a.d(this.eaW.getPageContext(), bb.apa, this.eaW.getUniqueId());
        this.dHi = new i(this.eaW.getPageContext(), bb.aoU, this.eaW.getUniqueId());
        this.eaX.setVoiceManager(this.eaW.getVoiceManager());
        this.dHi.setVoiceManager(this.eaW.getVoiceManager());
        this.mAdapters.add(new l(this.eaW.getPageContext(), com.baidu.tieba.frs.m.dCR));
        this.mAdapters.add(this.eaX);
        this.mAdapters.add(this.eaY);
        this.mAdapters.add(this.dGP);
        this.mAdapters.add(this.dIf);
        this.mAdapters.add(this.eaZ);
        this.mAdapters.add(this.dHi);
        this.dHV.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aHb();
        this.eaY.setForumId(this.eaW.getForumId());
        this.dHV.setData(arrayList);
    }

    private void aHb() {
        c.a(this.eaW.getForumId(), 1, this.eaX, this.dGP, this.dIf, this.dHi, this.eaZ);
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
