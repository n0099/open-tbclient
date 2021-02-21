package com.baidu.tieba.ala.person.b;

import android.view.View;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.bottompanel.AlaLiveRoomPanelTabHost;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.person.b.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private List<com.baidu.live.liveroom.d.d> aEo = new LinkedList();
    private AlaLiveRoomPanelTabHost aEr;
    private BdUniqueId gOQ;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gOQ = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gOQ = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aEr = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bTV();
    }

    private void bTV() {
        this.aEo.add(new d(this.mPageContext, 0, this.mUserId, this.gOQ));
        this.aEo.add(new d(this.mPageContext, 1, this.mUserId, this.gOQ));
        this.aEr.setData(this.aEo);
    }

    public void a(a.InterfaceC0683a interfaceC0683a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0683a);
            }
        }
    }

    public void wn(int i) {
        if (this.aEo != null && this.aEr != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aEo.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aEo.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aEr.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aD(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aD(str, z);
            }
        }
    }

    public View getView() {
        return this.aEr;
    }

    public void enterForeground() {
        this.aEr.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aEo) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aEr.onChangeSkinType(i);
    }
}
