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
    private List<com.baidu.live.liveroom.d.d> aGc = new LinkedList();
    private AlaLiveRoomPanelTabHost aGf;
    private BdUniqueId gwz;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.gwz = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.gwz = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aGf = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bRu();
    }

    private void bRu() {
        this.aGc.add(new d(this.mPageContext, 0, this.mUserId, this.gwz));
        this.aGc.add(new d(this.mPageContext, 1, this.mUserId, this.gwz));
        this.aGf.setData(this.aGc);
    }

    public void a(a.InterfaceC0694a interfaceC0694a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0694a);
            }
        }
    }

    public void ws(int i) {
        if (this.aGc != null && this.aGf != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aGc.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aGc.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aGf.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void aC(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).aC(str, z);
            }
        }
    }

    public View getView() {
        return this.aGf;
    }

    public void enterForeground() {
        this.aGf.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aGc) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aGf.onChangeSkinType(i);
    }
}
