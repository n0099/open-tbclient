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
    private long blh;
    private long fKh;
    private long gHv;
    private c gNp;
    private com.baidu.tieba.ala.liveroom.challenge.b.a gNq;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gNr = new ArrayList();
    private final c.a gNs = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.gNq != null) {
                b.this.gNq.bJG();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bVt() {
            if (b.this.gNq != null) {
                b.this.gNq.refresh();
            }
        }
    };
    private final a.InterfaceC0639a gNt = new a.InterfaceC0639a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0639a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gNr = list;
            if (b.this.gNp != null) {
                b.this.gNp.completePullRefresh();
                b.this.gNp.NM();
                if (ListUtils.isEmpty(list)) {
                    b.this.gNp.cj(false);
                    b.this.gNp.bKg();
                    return;
                }
                if (z) {
                    b.this.gNp.bJV();
                } else {
                    b.this.gNp.bJU();
                }
                b.this.gNp.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0639a
        public void h(int i, String str, boolean z) {
            if (b.this.gNp != null) {
                b.this.gNp.completePullRefresh();
                b.this.gNp.NM();
                b.this.gNp.bKg();
                if (!ListUtils.isEmpty(b.this.gNr)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.gNp.cj(false);
                } else {
                    b.this.gNp.cj(true);
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
        this.gNp = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.gNp.a(this.gNs);
        this.gNq = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.gNq.a(this.gNt);
    }

    public void e(long j, long j2, long j3) {
        this.gHv = j;
        this.blh = j2;
        this.fKh = j3;
        this.gNp.c(this.gHv, this.blh, this.fKh);
        this.gNq.c(this.gHv, this.blh, this.fKh);
        this.gNq.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gNp.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Kx() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Ky() {
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
        if (this.gNq != null) {
            this.gNq.onDestroy();
        }
        if (this.gNp != null) {
            this.gNp.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
