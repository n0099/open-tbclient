package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aFO = new LinkedList();
    private AlaLiveRoomPanelTabHost aFR;
    private BdUniqueId gQz;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gQz = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gQz = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aFR = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bUb();
    }

    private void bUb() {
        this.aFO.add(new d(this.mPageContext, 0, this.mUserId, this.gQz));
        this.aFO.add(new d(this.mPageContext, 1, this.mUserId, this.gQz));
        this.aFR.setData(this.aFO);
    }

    public void a(a.InterfaceC0689a interfaceC0689a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0689a);
            }
        }
    }

    public void wo(int i) {
        if (this.aFO != null && this.aFR != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aFO.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aFO.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aFR.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aD(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aD(str, z);
            }
        }
    }

    public View getView() {
        return this.aFR;
    }

    public void enterForeground() {
        this.aFR.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFO) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aFR.onChangeSkinType(i);
    }
}
