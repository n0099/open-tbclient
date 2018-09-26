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
    private e dAf;
    private TalkBallFragment dTc;
    private i dTd;
    private d dTe;
    private com.baidu.tieba.frs.entelechy.a.d dTf;
    private p dyP;
    private m dzV;
    private i dzi;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.dTc = talkBallFragment;
        this.dzV = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dTd = new i(this.dTc.getPageContext(), bb.ajX, this.dTc.getUniqueId());
        this.dTe = new d(this.dTc.getPageContext(), f.dTn, this.dTc.getUniqueId());
        this.dAf = new e(this.dTc.getPageContext(), bb.akg, this.dTc.getUniqueId());
        this.dyP = new p(this.dTc.getPageContext(), bb.aka, this.dTc.getUniqueId());
        this.dTf = new com.baidu.tieba.frs.entelechy.a.d(this.dTc.getPageContext(), bb.akf, this.dTc.getUniqueId());
        this.dzi = new i(this.dTc.getPageContext(), bb.ajZ, this.dTc.getUniqueId());
        this.dTd.setVoiceManager(this.dTc.getVoiceManager());
        this.dzi.setVoiceManager(this.dTc.getVoiceManager());
        this.mAdapters.add(new l(this.dTc.getPageContext(), com.baidu.tieba.frs.m.duQ));
        this.mAdapters.add(this.dTd);
        this.mAdapters.add(this.dTe);
        this.mAdapters.add(this.dyP);
        this.mAdapters.add(this.dAf);
        this.mAdapters.add(this.dTf);
        this.mAdapters.add(this.dzi);
        this.dzV.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aDJ();
        this.dTe.setForumId(this.dTc.getForumId());
        this.dzV.setData(arrayList);
    }

    private void aDJ() {
        c.a(this.dTc.getForumId(), 1, this.dTd, this.dyP, this.dAf, this.dzi, this.dTf);
    }

    public void notifyDataSetChanged() {
        if (this.dzV.getListAdapter() != null) {
            this.dzV.getListAdapter().notifyDataSetChanged();
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
