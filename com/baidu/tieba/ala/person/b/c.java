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
    private List<com.baidu.live.liveroom.d.d> aFm = new LinkedList();
    private AlaLiveRoomPanelTabHost aFp;
    private BdUniqueId gqL;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gqL = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gqL = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aFp = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bOU();
    }

    private void bOU() {
        this.aFm.add(new d(this.mPageContext, 0, this.mUserId, this.gqL));
        this.aFm.add(new d(this.mPageContext, 1, this.mUserId, this.gqL));
        this.aFp.setData(this.aFm);
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0680a);
            }
        }
    }

    public void wf(int i) {
        if (this.aFm != null && this.aFp != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aFm.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aFm.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aFp.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aC(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aC(str, z);
            }
        }
    }

    public View getView() {
        return this.aFp;
    }

    public void enterForeground() {
        this.aFp.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFm) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aFp.onChangeSkinType(i);
    }
}
