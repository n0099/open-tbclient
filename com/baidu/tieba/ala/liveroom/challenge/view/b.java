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
    private long aZc;
    private long fjn;
    private long gdz;
    private c gjB;
    private com.baidu.tieba.ala.liveroom.challenge.b.a gjC;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gjD = new ArrayList();
    private final c.a gjE = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.gjC != null) {
                b.this.gjC.bwE();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bGY() {
            if (b.this.gjC != null) {
                b.this.gjC.refresh();
            }
        }
    };
    private final a.InterfaceC0578a gjF = new a.InterfaceC0578a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0578a
        public void e(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gjD = list;
            if (b.this.gjB != null) {
                b.this.gjB.completePullRefresh();
                b.this.gjB.Gq();
                if (ListUtils.isEmpty(list)) {
                    b.this.gjB.bX(false);
                    b.this.gjB.bGZ();
                    return;
                }
                if (z) {
                    b.this.gjB.bwT();
                } else {
                    b.this.gjB.bwS();
                }
                b.this.gjB.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0578a
        public void g(int i, String str, boolean z) {
            if (b.this.gjB != null) {
                b.this.gjB.completePullRefresh();
                b.this.gjB.Gq();
                b.this.gjB.bGZ();
                if (!ListUtils.isEmpty(b.this.gjD)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.gjB.bX(false);
                } else {
                    b.this.gjB.bX(true);
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
        this.gjB = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.gjB.a(this.gjE);
        this.gjC = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.gjC.a(this.gjF);
    }

    public void e(long j, long j2, long j3) {
        this.gdz = j;
        this.aZc = j2;
        this.fjn = j3;
        this.gjB.c(this.gdz, this.aZc, this.fjn);
        this.gjC.c(this.gdz, this.aZc, this.fjn);
        this.gjC.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gjB.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Dj() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Dk() {
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
        if (this.gjC != null) {
            this.gjC.onDestroy();
        }
        if (this.gjB != null) {
            this.gjB.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
