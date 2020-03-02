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
    private List<com.baidu.live.liveroom.d.d> VW = new LinkedList();
    private AlaLiveRoomPanelTabHost VZ;
    private BdUniqueId ewI;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.ewI = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.ewI = bdUniqueId;
        initView();
    }

    private void initView() {
        this.VZ = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bea();
    }

    private void bea() {
        this.VW.add(new d(this.mPageContext, 0, this.mUserId, this.ewI));
        this.VW.add(new d(this.mPageContext, 1, this.mUserId, this.ewI));
        this.VZ.setData(this.VW);
    }

    public void a(a.InterfaceC0474a interfaceC0474a) {
        for (com.baidu.live.liveroom.d.d dVar : this.VW) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0474a);
            }
        }
    }

    public void qJ(int i) {
        if (this.VW != null && this.VZ != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.VW.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.VW.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.VZ.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void Z(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.VW) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).Z(str, z);
            }
        }
    }

    public View getView() {
        return this.VZ;
    }

    public void enterForeground() {
        this.VZ.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.VW) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.VZ.onChangeSkinType(i);
    }
}
