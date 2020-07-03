package com.baidu.tieba.ala.liveroom.challenge.view;

import android.view.View;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.liveroom.challenge.b.a;
import com.baidu.tieba.ala.liveroom.challenge.view.c;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long aZe;
    private long fTw;
    private long fYs;
    private c get;
    private com.baidu.tieba.ala.liveroom.challenge.b.a geu;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gev = new ArrayList();
    private final c.a gew = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.geu != null) {
                b.this.geu.btu();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bDM() {
            if (b.this.geu != null) {
                b.this.geu.refresh();
            }
        }
    };
    private final a.InterfaceC0568a gex = new a.InterfaceC0568a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0568a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gev = list;
            if (b.this.get != null) {
                b.this.get.completePullRefresh();
                b.this.get.Gw();
                if (ListUtils.isEmpty(list)) {
                    b.this.get.bW(false);
                    b.this.get.bDN();
                    return;
                }
                if (z) {
                    b.this.get.btJ();
                } else {
                    b.this.get.btI();
                }
                b.this.get.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0568a
        public void g(int i, String str, boolean z) {
            if (b.this.get != null) {
                b.this.get.completePullRefresh();
                b.this.get.Gw();
                b.this.get.bDN();
                if (!ListUtils.isEmpty(b.this.gev)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.get.bW(false);
                } else {
                    b.this.get.bW(true);
                }
            }
        }
    };
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.get = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.get.a(this.gew);
        this.geu = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.geu.a(this.gex);
    }

    public void e(long j, long j2, long j3) {
        this.fYs = j;
        this.aZe = j2;
        this.fTw = j3;
        this.get.c(this.fYs, this.aZe, this.fTw);
        this.geu.c(this.fYs, this.aZe, this.fTw);
        this.geu.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.get.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String CI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short CJ() {
        return (short) 0;
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterBackground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void enterForeground() {
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onDestroy() {
        if (this.geu != null) {
            this.geu.onDestroy();
        }
        if (this.get != null) {
            this.get.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
