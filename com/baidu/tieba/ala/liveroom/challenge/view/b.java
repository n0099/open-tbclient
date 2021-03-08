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
    private long bwn;
    private long gqI;
    private c hBU;
    private com.baidu.tieba.ala.liveroom.challenge.b.a hBV;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> hBW = new ArrayList();
    private final c.a hBX = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.hBV != null) {
                b.this.hBV.bRp();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void ceq() {
            if (b.this.hBV != null) {
                b.this.hBV.refresh();
            }
        }
    };
    private final a.InterfaceC0666a hBY = new a.InterfaceC0666a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0666a
        public void g(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.hBW = list;
            if (b.this.hBU != null) {
                b.this.hBU.completePullRefresh();
                b.this.hBU.Pe();
                if (ListUtils.isEmpty(list)) {
                    b.this.hBU.cK(false);
                    b.this.hBU.bRP();
                    return;
                }
                if (z) {
                    b.this.hBU.bRE();
                } else {
                    b.this.hBU.bRD();
                }
                b.this.hBU.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0666a
        public void g(int i, String str, boolean z) {
            if (b.this.hBU != null) {
                b.this.hBU.completePullRefresh();
                b.this.hBU.Pe();
                b.this.hBU.bRP();
                if (!ListUtils.isEmpty(b.this.hBW)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.hBU.cK(false);
                } else {
                    b.this.hBU.cK(true);
                }
            }
        }
    };
    private long hwd;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private int mType;

    public b(TbPageContext tbPageContext, int i, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.mType = i;
        this.mIsHost = z;
        this.hBU = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.hBU.a(this.hBX);
        this.hBV = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.hBV.a(this.hBY);
    }

    public void f(long j, long j2, long j3) {
        this.hwd = j;
        this.bwn = j2;
        this.gqI = j3;
        this.hBU.d(this.hwd, this.bwn, this.gqI);
        this.hBV.d(this.hwd, this.bwn, this.gqI);
        this.hBV.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.hBU.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String JN() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short JO() {
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
        if (this.hBV != null) {
            this.hBV.onDestroy();
        }
        if (this.hBU != null) {
            this.hBU.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
