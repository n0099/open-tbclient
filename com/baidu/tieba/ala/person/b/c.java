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
    private List<com.baidu.live.liveroom.d.d> aFe = new LinkedList();
    private AlaLiveRoomPanelTabHost aFh;
    private BdUniqueId ggI;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.ggI = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.ggI = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aFh = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bMs();
    }

    private void bMs() {
        this.aFe.add(new d(this.mPageContext, 0, this.mUserId, this.ggI));
        this.aFe.add(new d(this.mPageContext, 1, this.mUserId, this.ggI));
        this.aFh.setData(this.aFe);
    }

    public void a(a.InterfaceC0664a interfaceC0664a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFe) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0664a);
            }
        }
    }

    public void vL(int i) {
        if (this.aFe != null && this.aFh != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aFe.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aFe.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aFh.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aA(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aFe) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aA(str, z);
            }
        }
    }

    public View getView() {
        return this.aFh;
    }

    public void enterForeground() {
        this.aFh.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aFe) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aFh.onChangeSkinType(i);
    }
}
