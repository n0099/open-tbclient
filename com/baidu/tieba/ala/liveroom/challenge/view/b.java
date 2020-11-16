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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long bmk;
    private long fXY;
    private long gYW;
    private c heO;
    private com.baidu.tieba.ala.liveroom.challenge.b.a heP;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> heQ = new ArrayList();
    private final c.a heR = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.heP != null) {
                b.this.heP.bOb();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void can() {
            if (b.this.heP != null) {
                b.this.heP.refresh();
            }
        }
    };
    private final a.InterfaceC0669a heS = new a.InterfaceC0669a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0669a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.heQ = list;
            if (b.this.heO != null) {
                b.this.heO.completePullRefresh();
                b.this.heO.Oa();
                if (ListUtils.isEmpty(list)) {
                    b.this.heO.co(false);
                    b.this.heO.bOB();
                    return;
                }
                if (z) {
                    b.this.heO.bOq();
                } else {
                    b.this.heO.bOp();
                }
                b.this.heO.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0669a
        public void h(int i, String str, boolean z) {
            if (b.this.heO != null) {
                b.this.heO.completePullRefresh();
                b.this.heO.Oa();
                b.this.heO.bOB();
                if (!ListUtils.isEmpty(b.this.heQ)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.heO.co(false);
                } else {
                    b.this.heO.co(true);
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
        this.heO = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.heO.a(this.heR);
        this.heP = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.heP.a(this.heS);
    }

    public void e(long j, long j2, long j3) {
        this.gYW = j;
        this.bmk = j2;
        this.fXY = j3;
        this.heO.c(this.gYW, this.bmk, this.fXY);
        this.heP.c(this.gYW, this.bmk, this.fXY);
        this.heP.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.heO.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.h.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String KI() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short KJ() {
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
        if (this.heP != null) {
            this.heP.onDestroy();
        }
        if (this.heO != null) {
            this.heO.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
