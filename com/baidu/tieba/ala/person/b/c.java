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
    private List<com.baidu.live.liveroom.d.d> aoi = new LinkedList();
    private AlaLiveRoomPanelTabHost aol;
    private BdUniqueId fbv;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fbv = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fbv = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aol = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bnv();
    }

    private void bnv() {
        this.aoi.add(new d(this.mPageContext, 0, this.mUserId, this.fbv));
        this.aoi.add(new d(this.mPageContext, 1, this.mUserId, this.fbv));
        this.aol.setData(this.aoi);
    }

    public void a(a.InterfaceC0510a interfaceC0510a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aoi) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0510a);
            }
        }
    }

    public void re(int i) {
        if (this.aoi != null && this.aol != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aoi.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aoi.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aol.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void af(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aoi) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).af(str, z);
            }
        }
    }

    public View getView() {
        return this.aol;
    }

    public void enterForeground() {
        this.aol.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aoi) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aol.onChangeSkinType(i);
    }
}
