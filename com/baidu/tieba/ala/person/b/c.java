package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    private List<com.baidu.live.liveroom.c.d> NB = new LinkedList();
    private AlaLiveRoomPanelTabHost NE;
    private BdUniqueId dFZ;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.dFZ = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.dFZ = bdUniqueId;
        initView();
    }

    public void initView() {
        this.NE = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        aKA();
    }

    private void aKA() {
        this.NB.add(new d(this.mPageContext, 0, this.mUserId, this.dFZ));
        this.NB.add(new d(this.mPageContext, 1, this.mUserId, this.dFZ));
        this.NE.setData(this.NB);
    }

    public void a(a.InterfaceC0378a interfaceC0378a) {
        for (com.baidu.live.liveroom.c.d dVar : this.NB) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0378a);
            }
        }
    }

    public void og(int i) {
        if (this.NB != null && this.NE != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.NB.size()) {
                    com.baidu.live.liveroom.c.d dVar = this.NB.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.NE.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void V(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.NB) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).V(str, z);
            }
        }
    }

    public View getView() {
        return this.NE;
    }

    public void enterForeground() {
        this.NE.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.NB) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.NE.onChangeSkinType(i);
    }
}
