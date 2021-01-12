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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long brk;
    private long gmc;
    private long hpW;
    private c hvN;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hvO;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hvP = new ArrayList();
    private final c.a hvQ = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hvO != null) {
                b.this.hvO.bQy();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void cdi() {
            if (b.this.hvO != null) {
                b.this.hvO.refresh();
            }
        }
    };
    private final a.InterfaceC0657a hvR = new a.InterfaceC0657a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0657a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hvP = list;
            if (b.this.hvN != null) {
                b.this.hvN.completePullRefresh();
                b.this.hvN.NC();
                if (ListUtils.isEmpty(list)) {
                    b.this.hvN.cB(false);
                    b.this.hvN.bQY();
                    return;
                }
                if (z) {
                    b.this.hvN.bQN();
                } else {
                    b.this.hvN.bQM();
                }
                b.this.hvN.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0657a
        public void h(int i, String str, boolean z) {
            if (b.this.hvN != null) {
                b.this.hvN.completePullRefresh();
                b.this.hvN.NC();
                b.this.hvN.bQY();
                if (!ListUtils.isEmpty(b.this.hvP)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hvN.cB(false);
                } else {
                    b.this.hvN.cB(true);
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
        this.hvN = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hvN.a(this.hvQ);
        this.hvO = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hvO.a(this.hvR);
    }

    public void e(long j, long j2, long j3) {
        this.hpW = j;
        this.brk = j2;
        this.gmc = j3;
        this.hvN.c(this.hpW, this.brk, this.gmc);
        this.hvO.c(this.hpW, this.brk, this.gmc);
        this.hvO.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hvN.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Im() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short In() {
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
        if (this.hvO != null) {
            this.hvO.onDestroy();
        }
        if (this.hvN != null) {
            this.hvN.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
