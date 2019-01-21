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
    private i dSc;
    private p dSe;
    private m dTa;
    private e dTk;
    private TalkBallFragment emq;
    private i emr;
    private d ems;
    private com.baidu.tieba.frs.entelechy.a.d emt;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.emq = talkBallFragment;
        this.dTa = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.emr = new i(this.emq.getPageContext(), bb.atJ, this.emq.getUniqueId());
        this.ems = new d(this.emq.getPageContext(), f.emB, this.emq.getUniqueId());
        this.dTk = new e(this.emq.getPageContext(), bb.atS, this.emq.getUniqueId());
        this.dSe = new p(this.emq.getPageContext(), bb.atM, this.emq.getUniqueId());
        this.emt = new com.baidu.tieba.frs.entelechy.a.d(this.emq.getPageContext(), bb.atR, this.emq.getUniqueId());
        this.dSc = new i(this.emq.getPageContext(), bb.atL, this.emq.getUniqueId());
        this.emr.setVoiceManager(this.emq.getVoiceManager());
        this.dSc.setVoiceManager(this.emq.getVoiceManager());
        this.mAdapters.add(new l(this.emq.getPageContext(), com.baidu.tieba.frs.m.dOe));
        this.mAdapters.add(this.emr);
        this.mAdapters.add(this.ems);
        this.mAdapters.add(this.dSe);
        this.mAdapters.add(this.dTk);
        this.mAdapters.add(this.emt);
        this.mAdapters.add(this.dSc);
        this.dTa.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aJy();
        this.ems.setForumId(this.emq.getForumId());
        this.dTa.setData(arrayList);
    }

    private void aJy() {
        c.a(this.emq.getForumId(), 1, this.emr, this.dSe, this.dTk, this.dSc, this.emt);
    }

    public void notifyDataSetChanged() {
        if (this.dTa.getListAdapter() != null) {
            this.dTa.getListAdapter().notifyDataSetChanged();
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
