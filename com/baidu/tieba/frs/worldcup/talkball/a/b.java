package com.baidu.tieba.frs.worldcup.talkball.a;

import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.frs.entelechy.a.e;
import com.baidu.tieba.frs.entelechy.a.i;
import com.baidu.tieba.frs.entelechy.a.p;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.worldcup.c;
import com.baidu.tieba.frs.worldcup.talkball.activity.TalkBallFragment;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
import com.baidu.tieba.frs.worldcup.videotopic.insertcard.d;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private TalkBallFragment dFG;
    private i dFH;
    private d dFI;
    private com.baidu.tieba.frs.entelechy.a.d dFJ;
    private i dmD;
    private p dmF;
    private j dmH;
    private e dnG;
    private m dnw;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new LinkedList();

    public b(TalkBallFragment talkBallFragment, m mVar) {
        this.dFG = talkBallFragment;
        this.dnw = mVar;
        initAdapters();
    }

    private void initAdapters() {
        this.dFH = new i(this.dFG.getPageContext(), bd.ahJ, this.dFG.getUniqueId());
        this.dmH = new j(this.dFG.getPageContext(), k.djW);
        this.dFI = new d(this.dFG.getPageContext(), f.dFQ, this.dFG.getUniqueId());
        this.dnG = new e(this.dFG.getPageContext(), bd.ahS, this.dFG.getUniqueId());
        this.dmF = new p(this.dFG.getPageContext(), bd.ahM, this.dFG.getUniqueId());
        this.dFJ = new com.baidu.tieba.frs.entelechy.a.d(this.dFG.getPageContext(), bd.ahR, this.dFG.getUniqueId());
        this.dmD = new i(this.dFG.getPageContext(), bd.ahL, this.dFG.getUniqueId());
        this.dFH.setVoiceManager(this.dFG.getVoiceManager());
        this.dmD.setVoiceManager(this.dFG.getVoiceManager());
        this.mAdapters.add(this.dmH);
        this.mAdapters.add(this.dFH);
        this.mAdapters.add(this.dFI);
        this.mAdapters.add(this.dmF);
        this.mAdapters.add(this.dnG);
        this.mAdapters.add(this.dFJ);
        this.mAdapters.add(this.dmD);
        this.dnw.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        aAj();
        this.dFI.setForumId(this.dFG.getForumId());
        this.dnw.setData(arrayList);
    }

    private void aAj() {
        c.a(this.dFG.getForumId(), 1, this.dFH, this.dmF, this.dnG, this.dmD, this.dFJ);
    }

    public void notifyDataSetChanged() {
        if (this.dnw.getListAdapter() != null) {
            this.dnw.getListAdapter().notifyDataSetChanged();
        }
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.f) {
                ((com.baidu.tieba.frs.f) aVar).release();
            }
        }
    }
}
