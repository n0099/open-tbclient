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
/* loaded from: classes11.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long buN;
    private long goL;
    private long hug;
    private c hzX;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hzY;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hzZ = new ArrayList();
    private final c.a hAa = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hzY != null) {
                b.this.hzY.bRc();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void ced() {
            if (b.this.hzY != null) {
                b.this.hzY.refresh();
            }
        }
    };
    private final a.InterfaceC0659a hAb = new a.InterfaceC0659a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0659a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hzZ = list;
            if (b.this.hzX != null) {
                b.this.hzX.completePullRefresh();
                b.this.hzX.Pb();
                if (ListUtils.isEmpty(list)) {
                    b.this.hzX.cK(false);
                    b.this.hzX.bRC();
                    return;
                }
                if (z) {
                    b.this.hzX.bRr();
                } else {
                    b.this.hzX.bRq();
                }
                b.this.hzX.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0659a
        public void g(int i, String str, boolean z) {
            if (b.this.hzX != null) {
                b.this.hzX.completePullRefresh();
                b.this.hzX.Pb();
                b.this.hzX.bRC();
                if (!ListUtils.isEmpty(b.this.hzZ)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hzX.cK(false);
                } else {
                    b.this.hzX.cK(true);
                }
            }
        }
    };

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.hzX = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hzX.a(this.hAa);
        this.hzY = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hzY.a(this.hAb);
    }

    public void e(long j, long j2, long j3) {
        this.hug = j;
        this.buN = j2;
        this.goL = j3;
        this.hzX.c(this.hug, this.buN, this.goL);
        this.hzY.c(this.hug, this.buN, this.goL);
        this.hzY.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hzX.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JK() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JL() {
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
        if (this.hzY != null) {
            this.hzY.onDestroy();
        }
        if (this.hzX != null) {
            this.hzX.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
