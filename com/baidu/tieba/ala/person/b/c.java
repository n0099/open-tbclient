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
    private List<com.baidu.live.liveroom.d.d> aoo = new LinkedList();
    private AlaLiveRoomPanelTabHost aor;
    private BdUniqueId fbA;
    private TbPageContext mPageContext;
    private String mUserId;

    public c(TbPageContext tbPageContext, String str, BdUniqueId bdUniqueId) {
        this.fbA = null;
        this.mPageContext = tbPageContext;
        this.mUserId = str;
        this.fbA = bdUniqueId;
        initView();
    }

    private void initView() {
        this.aor = new AlaLiveRoomPanelTabHost(this.mPageContext.getPageActivity());
        bnt();
    }

    private void bnt() {
        this.aoo.add(new d(this.mPageContext, 0, this.mUserId, this.fbA));
        this.aoo.add(new d(this.mPageContext, 1, this.mUserId, this.fbA));
        this.aor.setData(this.aoo);
    }

    public void a(a.InterfaceC0531a interfaceC0531a) {
        for (com.baidu.live.liveroom.d.d dVar : this.aoo) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).a(interfaceC0531a);
            }
        }
    }

    public void re(int i) {
        if (this.aoo != null && this.aor != null) {
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < this.aoo.size()) {
                    com.baidu.live.liveroom.d.d dVar = this.aoo.get(i3);
                    if (dVar == null || !(dVar instanceof d) || ((d) dVar).getTabType() != i) {
                        i2 = i3 + 1;
                    } else {
                        this.aor.setCurrentIndex(i3);
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void af(String str, boolean z) {
        for (com.baidu.live.liveroom.d.d dVar : this.aoo) {
            if (dVar != null && (dVar instanceof d)) {
                ((d) dVar).af(str, z);
            }
        }
    }

    public View getView() {
        return this.aor;
    }

    public void enterForeground() {
        this.aor.enterForeground();
    }

    public void onDestory() {
        for (com.baidu.live.liveroom.d.d dVar : this.aoo) {
            if (dVar != null) {
                dVar.onDestroy();
            }
        }
    }

    public void onChangeSkinType(int i) {
        this.aor.onChangeSkinType(i);
    }
}
