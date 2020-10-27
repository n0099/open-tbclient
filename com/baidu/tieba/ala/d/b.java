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
    private long bmB;
    private boolean bzY;
    private long fSB;
    private com.baidu.live.personmanager.e gsu;
    private com.baidu.tieba.ala.g.d gsy;
    private com.baidu.tieba.ala.view.b gsz;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gsv = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Ol() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gsz.ciT() != null && b.this.mUserId > 0) {
                b.this.gsu.aE(String.valueOf(b.this.mUserId), b.this.gsz.ciT().RL());
            }
        }
    };
    private final d.a gsA = new d.a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void aa(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.gsy.RQ();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.gsz.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> RQ = b.this.gsy.RQ();
            if (!ListUtils.isEmpty(RQ)) {
                b.this.gsz.setData(RQ);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bmB = j;
        this.fSB = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bzY = z2;
        this.gsy = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gsA);
        this.gsy.b(this.bmB, this.fSB, this.mUserId, this.mIsHost, this.bzY);
        this.gsz = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gsz.b(this.bmB, this.fSB, this.mUserId, this.mIsHost, this.bzY);
        this.gsy.RP();
        this.gsu = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gsu.a(this.gsv);
    }

    public View getView() {
        return this.gsz.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gsy.onDestroy();
        this.gsu.onDestroy();
        this.gsz.onDestroy();
    }
}
