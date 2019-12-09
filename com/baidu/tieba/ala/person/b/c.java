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
    private List<com.baidu.live.liveroom.c.d> Na = new LinkedList();
    private AlaLiveRoomPanelTabHost Nd;
    private BdUniqueId dFi;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.dFi = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.dFi = bdUniqueId;
        initView();
    }

    public void initView() {
        this.Nd = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        aKy();
    }

    private void aKy() {
        this.Na.add(new d(this.mPageContext, 0, this.mUserId, this.dFi));
        this.Na.add(new d(this.mPageContext, 1, this.mUserId, this.dFi));
        this.Nd.setData(this.Na);
    }

    public void a(a.InterfaceC0373a interfaceC0373a) {
        for (com.baidu.live.liveroom.c.d dVar : this.Na) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0373a);
            }
        }
    }

    public void of(int i) {
        if (this.Na != null && this.Nd != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.Na.size()) {
                    com.baidu.live.liveroom.c.d dVar = this.Na.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.Nd.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void V(String str, boolean z) {
        for (com.baidu.live.liveroom.c.d dVar : this.Na) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).V(str, z);
            }
        }
    }

    public View getView() {
        return this.Nd;
    }

    public void enterForeground() {
        this.Nd.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.c.d dVar : this.Na) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.Nd.onChangeSkinType(i);
    }
}
