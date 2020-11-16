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
    private List<com.baidu.live.liveroom.d.d> aEr = new LinkedList();
    private AlaLiveRoomPanelTabHost aEu;
    private BdUniqueId gwg;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gwg = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gwg = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aEu = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bQN();
    }

    private void bQN() {
        this.aEr.add(new d(this.mPageContext, 0, this.mUserId, this.gwg));
        this.aEr.add(new d(this.mPageContext, 1, this.mUserId, this.gwg));
        this.aEu.setData(this.aEr);
    }

    public void a(a.InterfaceC0694a interfaceC0694a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0694a);
            }
        }
    }

    public void wQ(int i) {
        if (this.aEr != null && this.aEu != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aEr.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aEr.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aEu.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aC(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aC(str, z);
            }
        }
    }

    public View getView() {
        return this.aEu;
    }

    public void enterForeground() {
        this.aEu.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEr) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aEu.onChangeSkinType(i);
    }
}
