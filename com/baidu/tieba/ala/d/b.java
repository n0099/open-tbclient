package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes11.dex */
public class b {
    private long buN;
    private com.baidu.tieba.ala.view.a gQM;
    private com.baidu.live.personmanager.e gQN;
    private long goZ;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gQO = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Pg() {
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
            if (b.this.gQM.Vh().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gQN.aF(String.valueOf(b.this.mUserId), b.this.gQM.Vh());
            }
        }
    };
    private final a.InterfaceC0696a gQP = new a.InterfaceC0696a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0696a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.buN = j;
        this.goZ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gQM = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gQP);
        this.gQM.b(this.buN, this.goZ, this.mUserId, this.mIsHost);
        this.gQN = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gQN.a(this.gQO);
    }

    public View getView() {
        return this.gQM.getView();
    }

    public void onDestroy() {
        this.gQN.onDestroy();
        this.gQM.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gQM != null) {
            this.gQM.onKeyboardVisibilityChanged(z);
        }
    }
}
