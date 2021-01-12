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
    private List<com.baidu.live.liveroom.d.d> aCB = new LinkedList();
    private AlaLiveRoomPanelTabHost aCE;
    private BdUniqueId gLW;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gLW = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gLW = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aCE = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bTl();
    }

    private void bTl() {
        this.aCB.add(new d(this.mPageContext, 0, this.mUserId, this.gLW));
        this.aCB.add(new d(this.mPageContext, 1, this.mUserId, this.gLW));
        this.aCE.setData(this.aCB);
    }

    public void a(a.InterfaceC0682a interfaceC0682a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0682a);
            }
        }
    }

    public void wc(int i) {
        if (this.aCB != null && this.aCE != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aCB.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aCB.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aCE.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aE(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aE(str, z);
            }
        }
    }

    public View getView() {
        return this.aCE;
    }

    public void enterForeground() {
        this.aCE.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aCB) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aCE.onChangeSkinType(i);
    }
}
