package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> ati = new LinkedList();
    private AlaLiveRoomPanelTabHost atl;
    private BdUniqueId fpc;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fpc = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fpc = bdUniqueId;
        initView();
    }

    private void initView() {
        this.atl = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        btl();
    }

    private void btl() {
        this.ati.add(new d(this.mPageContext, 0, this.mUserId, this.fpc));
        this.ati.add(new d(this.mPageContext, 1, this.mUserId, this.fpc));
        this.atl.setData(this.ati);
    }

    public void a(a.InterfaceC0581a interfaceC0581a) {
        for (com.baidu.live.liveroom.d.d dVar : this.ati) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0581a);
            }
        }
    }

    public void rG(int i) {
        if (this.ati != null && this.atl != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.ati.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.ati.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.atl.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void as(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.ati) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).as(str, z);
            }
        }
    }

    public View getView() {
        return this.atl;
    }

    public void enterForeground() {
        this.atl.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.ati) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.atl.onChangeSkinType(i);
    }
}
