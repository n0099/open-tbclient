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
    private m dSZ;
    private i dSb;
    private p dSd;
    private e dTj;
    private TalkBallFragment emp;
    private i emq;
    private d emr;
    private com.baidu.tieba.frs.entelechy.a.d ems;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.emp = talkBallFragment;
        this.dSZ = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.emq = new i(this.emp.getPageContext(), bb.atI, this.emp.getUniqueId());
        this.emr = new d(this.emp.getPageContext(), f.emA, this.emp.getUniqueId());
        this.dTj = new e(this.emp.getPageContext(), bb.atR, this.emp.getUniqueId());
        this.dSd = new p(this.emp.getPageContext(), bb.atL, this.emp.getUniqueId());
        this.ems = new com.baidu.tieba.frs.entelechy.a.d(this.emp.getPageContext(), bb.atQ, this.emp.getUniqueId());
        this.dSb = new i(this.emp.getPageContext(), bb.atK, this.emp.getUniqueId());
        this.emq.setVoiceManager(this.emp.getVoiceManager());
        this.dSb.setVoiceManager(this.emp.getVoiceManager());
        this.mAdapters.add(new l(this.emp.getPageContext(), com.baidu.tieba.frs.m.dOd));
        this.mAdapters.add(this.emq);
        this.mAdapters.add(this.emr);
        this.mAdapters.add(this.dSd);
        this.mAdapters.add(this.dTj);
        this.mAdapters.add(this.ems);
        this.mAdapters.add(this.dSb);
        this.dSZ.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aJy();
        this.emr.setForumId(this.emp.getForumId());
        this.dSZ.setData(arrayList);
    }

    private void aJy() {
        c.a(this.emp.getForumId(), 1, this.emq, this.dSd, this.dTj, this.dSb, this.ems);
    }

    public void notifyDataSetChanged() {
        if (this.dSZ.getListAdapter() != null) {
            this.dSZ.getListAdapter().notifyDataSetChanged();
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
