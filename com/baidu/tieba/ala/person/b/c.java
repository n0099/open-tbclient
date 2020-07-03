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
    private List<com.baidu.live.liveroom.d.d> avk = new LinkedList();
    private AlaLiveRoomPanelTabHost avn;
    private BdUniqueId fAz;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fAz = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fAz = bdUniqueId;
        initView();
    }

    private void initView() {
        this.avn = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bwh();
    }

    private void bwh() {
        this.avk.add(new d(this.mPageContext, 0, this.mUserId, this.fAz));
        this.avk.add(new d(this.mPageContext, 1, this.mUserId, this.fAz));
        this.avn.setData(this.avk);
    }

    public void a(a.InterfaceC0590a interfaceC0590a) {
        for (com.baidu.live.liveroom.d.d dVar : this.avk) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0590a);
            }
        }
    }

    public void sg(int i) {
        if (this.avk != null && this.avn != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.avk.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.avk.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.avn.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void au(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.avk) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).au(str, z);
            }
        }
    }

    public View getView() {
        return this.avn;
    }

    public void enterForeground() {
        this.avn.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.avk) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.avn.onChangeSkinType(i);
    }
}
