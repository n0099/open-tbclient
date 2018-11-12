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
    private m dIZ;
    private i dIf;
    private p dIh;
    private e dJj;
    private TalkBallFragment ecq;
    private i ecr;
    private d ecs;
    private com.baidu.tieba.frs.entelechy.a.d ect;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.ecq = talkBallFragment;
        this.dIZ = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.ecr = new i(this.ecq.getPageContext(), bb.apG, this.ecq.getUniqueId());
        this.ecs = new d(this.ecq.getPageContext(), f.ecB, this.ecq.getUniqueId());
        this.dJj = new e(this.ecq.getPageContext(), bb.apP, this.ecq.getUniqueId());
        this.dIh = new p(this.ecq.getPageContext(), bb.apJ, this.ecq.getUniqueId());
        this.ect = new com.baidu.tieba.frs.entelechy.a.d(this.ecq.getPageContext(), bb.apO, this.ecq.getUniqueId());
        this.dIf = new i(this.ecq.getPageContext(), bb.apI, this.ecq.getUniqueId());
        this.ecr.setVoiceManager(this.ecq.getVoiceManager());
        this.dIf.setVoiceManager(this.ecq.getVoiceManager());
        this.mAdapters.add(new l(this.ecq.getPageContext(), com.baidu.tieba.frs.m.dEh));
        this.mAdapters.add(this.ecr);
        this.mAdapters.add(this.ecs);
        this.mAdapters.add(this.dIh);
        this.mAdapters.add(this.dJj);
        this.mAdapters.add(this.ect);
        this.mAdapters.add(this.dIf);
        this.dIZ.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aGz();
        this.ecs.setForumId(this.ecq.getForumId());
        this.dIZ.setData(arrayList);
    }

    private void aGz() {
        c.a(this.ecq.getForumId(), 1, this.ecr, this.dIh, this.dJj, this.dIf, this.ect);
    }

    public void notifyDataSetChanged() {
        if (this.dIZ.getListAdapter() != null) {
            this.dIZ.getListAdapter().notifyDataSetChanged();
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
