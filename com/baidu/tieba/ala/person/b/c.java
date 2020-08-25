package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aBr = new LinkedList();
    private AlaLiveRoomPanelTabHost aBu;
    private BdUniqueId fRa;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fRa = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fRa = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aBu = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bIz();
    }

    private void bIz() {
        this.aBr.add(new d(this.mPageContext, 0, this.mUserId, this.fRa));
        this.aBr.add(new d(this.mPageContext, 1, this.mUserId, this.fRa));
        this.aBu.setData(this.aBr);
    }

    public void a(a.InterfaceC0649a interfaceC0649a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBr) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0649a);
            }
        }
    }

    public void uM(int i) {
        if (this.aBr != null && this.aBu != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aBr.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aBr.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aBu.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aw(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aBr) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aw(str, z);
            }
        }
    }

    public View getView() {
        return this.aBu;
    }

    public void enterForeground() {
        this.aBu.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aBr) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aBu.onChangeSkinType(i);
    }
}
