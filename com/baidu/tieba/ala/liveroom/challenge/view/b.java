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
/* loaded from: classes7.dex */
public class b implements com.baidu.live.liveroom.d.d {
    private long bey;
    private long fuN;
    private long gpM;
    private c gvL;
    private com.baidu.tieba.ala.liveroom.challenge.b.a gvM;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gvN = new ArrayList();
    private final c.a gvO = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.gvM != null) {
                b.this.gvM.bFE();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bQD() {
            if (b.this.gvM != null) {
                b.this.gvM.refresh();
            }
        }
    };
    private final a.InterfaceC0625a gvP = new a.InterfaceC0625a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0625a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gvN = list;
            if (b.this.gvL != null) {
                b.this.gvL.completePullRefresh();
                b.this.gvL.Me();
                if (ListUtils.isEmpty(list)) {
                    b.this.gvL.cf(false);
                    b.this.gvL.bQE();
                    return;
                }
                if (z) {
                    b.this.gvL.bFT();
                } else {
                    b.this.gvL.bFS();
                }
                b.this.gvL.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0625a
        public void f(int i, String str, boolean z) {
            if (b.this.gvL != null) {
                b.this.gvL.completePullRefresh();
                b.this.gvL.Me();
                b.this.gvL.bQE();
                if (!ListUtils.isEmpty(b.this.gvN)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.gvL.cf(false);
                } else {
                    b.this.gvL.cf(true);
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
        this.gvL = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.gvL.a(this.gvO);
        this.gvM = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.gvM.a(this.gvP);
    }

    public void e(long j, long j2, long j3) {
        this.gpM = j;
        this.bey = j2;
        this.fuN = j3;
        this.gvL.c(this.gpM, this.bey, this.fuN);
        this.gvM.c(this.gpM, this.bey, this.fuN);
        this.gvM.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gvL.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String IM() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short IN() {
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
        if (this.gvM != null) {
            this.gvM.onDestroy();
        }
        if (this.gvL != null) {
            this.gvL.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
