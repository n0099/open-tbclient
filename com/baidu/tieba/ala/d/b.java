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
/* loaded from: classes4.dex */
public class b {
    private boolean bEy;
    private long bmk;
    private long fXY;
    private com.baidu.live.personmanager.e gxP;
    private com.baidu.tieba.ala.g.d gxT;
    private com.baidu.tieba.ala.view.b gxU;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gxQ = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Oc() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gxU.ckO() != null && b.this.mUserId > 0) {
                b.this.gxP.aE(String.valueOf(b.this.mUserId), b.this.gxU.ckO().TK());
            }
        }
    };
    private final d.a gxV = new d.a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void af(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.gxT.TP();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.gxU.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> TP = b.this.gxT.TP();
            if (!ListUtils.isEmpty(TP)) {
                b.this.gxU.setData(TP);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bmk = j;
        this.fXY = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bEy = z2;
        this.gxT = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gxV);
        this.gxT.b(this.bmk, this.fXY, this.mUserId, this.mIsHost, this.bEy);
        this.gxU = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gxU.b(this.bmk, this.fXY, this.mUserId, this.mIsHost, this.bEy);
        this.gxT.TO();
        this.gxP = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gxP.a(this.gxQ);
    }

    public View getView() {
        return this.gxU.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gxT.onDestroy();
        this.gxP.onDestroy();
        this.gxU.onDestroy();
    }
}
