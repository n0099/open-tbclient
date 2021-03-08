package com.baidu.tieba.ala.d;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.g.d;
import java.util.List;
/* loaded from: classes10.dex */
public class c {
    private boolean bOS;
    private long bwn;
    private com.baidu.tieba.ala.g.d gSA;
    private com.baidu.tieba.ala.view.b gSB;
    private com.baidu.live.personmanager.e gSw;
    private long gqI;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gSx = new e.a() { // from class: com.baidu.tieba.ala.d.c.1
        @Override // com.baidu.live.personmanager.e.a
        public void Pj() {
            BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            c.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.gSB.cpy() != null && c.this.mUserId > 0) {
                c.this.gSw.aF(String.valueOf(c.this.mUserId), c.this.gSB.cpy().Ve());
            }
        }
    };
    private final d.a gSC = new d.a() { // from class: com.baidu.tieba.ala.d.c.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void aj(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = c.this.gSA.Vj();
            }
            if (!ListUtils.isEmpty(list)) {
                c.this.gSB.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Vj = c.this.gSA.Vj();
            if (!ListUtils.isEmpty(Vj)) {
                c.this.gSB.setData(Vj);
            }
        }
    };

    public c(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bwn = j;
        this.gqI = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bOS = z2;
        this.gSA = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gSC);
        this.gSA.b(this.bwn, this.gqI, this.mUserId, this.mIsHost, this.bOS);
        this.gSB = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gSB.b(this.bwn, this.gqI, this.mUserId, this.mIsHost, this.bOS);
        this.gSA.Vi();
        this.gSw = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gSw.a(this.gSx);
    }

    public View getView() {
        return this.gSB.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gSA.onDestroy();
        this.gSw.onDestroy();
        this.gSB.onDestroy();
    }
}
