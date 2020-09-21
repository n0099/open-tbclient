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
    private long bhr;
    private long fxY;
    private long gta;
    private c gyW;
    private com.baidu.tieba.ala.liveroom.challenge.b.a gyX;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gyY = new ArrayList();
    private final c.a gyZ = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.gyX != null) {
                b.this.gyX.bGU();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bRZ() {
            if (b.this.gyX != null) {
                b.this.gyX.refresh();
            }
        }
    };
    private final a.InterfaceC0621a gza = new a.InterfaceC0621a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0621a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gyY = list;
            if (b.this.gyW != null) {
                b.this.gyW.completePullRefresh();
                b.this.gyW.MH();
                if (ListUtils.isEmpty(list)) {
                    b.this.gyW.cg(false);
                    b.this.gyW.bSa();
                    return;
                }
                if (z) {
                    b.this.gyW.bHj();
                } else {
                    b.this.gyW.bHi();
                }
                b.this.gyW.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0621a
        public void f(int i, String str, boolean z) {
            if (b.this.gyW != null) {
                b.this.gyW.completePullRefresh();
                b.this.gyW.MH();
                b.this.gyW.bSa();
                if (!ListUtils.isEmpty(b.this.gyY)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.gyW.cg(false);
                } else {
                    b.this.gyW.cg(true);
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
        this.gyW = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.gyW.a(this.gyZ);
        this.gyX = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.gyX.a(this.gza);
    }

    public void e(long j, long j2, long j3) {
        this.gta = j;
        this.bhr = j2;
        this.fxY = j3;
        this.gyW.c(this.gta, this.bhr, this.fxY);
        this.gyX.c(this.gta, this.bhr, this.fxY);
        this.gyX.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gyW.getView();
    }

    @Override // com.baidu.live.liveroom.d.d
    public String getTitle() {
        return this.mType == 2 ? this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_reval) : this.mTbPageContext.getResources().getString(a.i.ala_challenge_jinzhu_anchor);
    }

    @Override // com.baidu.live.liveroom.d.d
    public String Jq() {
        return null;
    }

    @Override // com.baidu.live.liveroom.d.d
    public short Jr() {
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
        if (this.gyX != null) {
            this.gyX.onDestroy();
        }
        if (this.gyW != null) {
            this.gyW.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
