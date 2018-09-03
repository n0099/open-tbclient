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
    private TalkBallFragment dLK;
    private i dLL;
    private d dLM;
    private com.baidu.tieba.frs.entelechy.a.d dLN;
    private i dsA;
    private p dsC;
    private m dtp;
    private e dtz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.dLK = talkBallFragment;
        this.dtp = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dLL = new i(this.dLK.getPageContext(), bb.ahx, this.dLK.getUniqueId());
        this.dLM = new d(this.dLK.getPageContext(), f.dLV, this.dLK.getUniqueId());
        this.dtz = new e(this.dLK.getPageContext(), bb.ahG, this.dLK.getUniqueId());
        this.dsC = new p(this.dLK.getPageContext(), bb.ahA, this.dLK.getUniqueId());
        this.dLN = new com.baidu.tieba.frs.entelechy.a.d(this.dLK.getPageContext(), bb.ahF, this.dLK.getUniqueId());
        this.dsA = new i(this.dLK.getPageContext(), bb.ahz, this.dLK.getUniqueId());
        this.dLL.setVoiceManager(this.dLK.getVoiceManager());
        this.dsA.setVoiceManager(this.dLK.getVoiceManager());
        this.mAdapters.add(new l(this.dLK.getPageContext(), com.baidu.tieba.frs.m.doT));
        this.mAdapters.add(this.dLL);
        this.mAdapters.add(this.dLM);
        this.mAdapters.add(this.dsC);
        this.mAdapters.add(this.dtz);
        this.mAdapters.add(this.dLN);
        this.mAdapters.add(this.dsA);
        this.dtp.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aBw();
        this.dLM.setForumId(this.dLK.getForumId());
        this.dtp.setData(arrayList);
    }

    private void aBw() {
        c.a(this.dLK.getForumId(), 1, this.dLL, this.dsC, this.dtz, this.dsA, this.dLN);
    }

    public void notifyDataSetChanged() {
        if (this.dtp.getListAdapter() != null) {
            this.dtp.getListAdapter().notifyDataSetChanged();
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
