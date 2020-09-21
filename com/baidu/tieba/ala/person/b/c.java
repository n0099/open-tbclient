package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aBZ = new LinkedList();
    private AlaLiveRoomPanelTabHost aCc;
    private BdUniqueId fUp;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fUp = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fUp = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aCc = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bJI();
    }

    private void bJI() {
        this.aBZ.add(new d(this.mPageContext, 0, this.mUserId, this.fUp));
        this.aBZ.add(new d(this.mPageContext, 1, this.mUserId, this.fUp));
        this.aCc.setData(this.aBZ);
    }

    public void a(a.InterfaceC0646a interfaceC0646a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBZ) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0646a);
            }
        }
    }

    public void vf(int i) {
        if (this.aBZ != null && this.aCc != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aBZ.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aBZ.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aCc.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aw(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBZ) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aw(str, z);
            }
        }
    }

    public View getView() {
        return this.aCc;
    }

    public void enterForeground() {
        this.aCc.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aBZ) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aCc.onChangeSkinType(i);
    }
}
