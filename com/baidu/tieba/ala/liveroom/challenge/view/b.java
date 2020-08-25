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
    private long bew;
    private long fuJ;
    private long gpI;
    private c gvH;
    private com.baidu.tieba.ala.liveroom.challenge.b.a gvI;
    private List<com.baidu.tieba.ala.liveroom.challenge.a.a> gvJ = new ArrayList();
    private final c.a gvK = new c.a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.1
        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void onScrollToBottom() {
            if (b.this.gvI != null) {
                b.this.gvI.bFD();
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.view.c.a
        public void bQC() {
            if (b.this.gvI != null) {
                b.this.gvI.refresh();
            }
        }
    };
    private final a.InterfaceC0625a gvL = new a.InterfaceC0625a() { // from class: com.baidu.tieba.ala.liveroom.challenge.view.b.2
        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0625a
        public void f(boolean z, List<com.baidu.tieba.ala.liveroom.challenge.a.a> list) {
            b.this.gvJ = list;
            if (b.this.gvH != null) {
                b.this.gvH.completePullRefresh();
                b.this.gvH.Me();
                if (ListUtils.isEmpty(list)) {
                    b.this.gvH.cf(false);
                    b.this.gvH.bQD();
                    return;
                }
                if (z) {
                    b.this.gvH.bFS();
                } else {
                    b.this.gvH.bFR();
                }
                b.this.gvH.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.challenge.b.a.InterfaceC0625a
        public void f(int i, String str, boolean z) {
            if (b.this.gvH != null) {
                b.this.gvH.completePullRefresh();
                b.this.gvH.Me();
                b.this.gvH.bQD();
                if (!ListUtils.isEmpty(b.this.gvJ)) {
                    BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), str);
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    b.this.gvH.cf(false);
                } else {
                    b.this.gvH.cf(true);
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
        this.gvH = new c(this.mTbPageContext, this.mType, this.mIsHost);
        this.gvH.a(this.gvK);
        this.gvI = new com.baidu.tieba.ala.liveroom.challenge.b.a(this.mTbPageContext, this.mType, this.mIsHost);
        this.gvI.a(this.gvL);
    }

    public void e(long j, long j2, long j3) {
        this.gpI = j;
        this.bew = j2;
        this.fuJ = j3;
        this.gvH.c(this.gpI, this.bew, this.fuJ);
        this.gvI.c(this.gpI, this.bew, this.fuJ);
        this.gvI.refresh();
    }

    @Override // com.baidu.live.liveroom.d.d
    public View getPanelView() {
        return this.gvH.getView();
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
        if (this.gvI != null) {
            this.gvI.onDestroy();
        }
        if (this.gvH != null) {
            this.gvH.onDestroy();
        }
    }

    @Override // com.baidu.live.liveroom.d.d
    public void onChangeSkinType(int i) {
    }
}
