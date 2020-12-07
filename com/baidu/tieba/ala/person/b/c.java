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
    private List<com.baidu.live.liveroom.d.d> aGX = new LinkedList();
    private AlaLiveRoomPanelTabHost aHa;
    private BdUniqueId gEP;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gEP = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gEP = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aHa = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bUx();
    }

    private void bUx() {
        this.aGX.add(new d(this.mPageContext, 0, this.mUserId, this.gEP));
        this.aGX.add(new d(this.mPageContext, 1, this.mUserId, this.gEP));
        this.aHa.setData(this.aGX);
    }

    public void a(a.InterfaceC0707a interfaceC0707a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0707a);
            }
        }
    }

    public void xv(int i) {
        if (this.aGX != null && this.aHa != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aGX.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aGX.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aHa.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aD(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aD(str, z);
            }
        }
    }

    public View getView() {
        return this.aHa;
    }

    public void enterForeground() {
        this.aHa.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aGX) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aHa.onChangeSkinType(i);
    }
}
