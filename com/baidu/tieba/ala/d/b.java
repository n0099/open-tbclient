package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes10.dex */
public class b {
    private long brk;
    private com.baidu.tieba.ala.view.a gNS;
    private com.baidu.live.personmanager.e gNT;
    private long gmc;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gNU = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void NE() {
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
            if (b.this.gNS.TA().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gNT.aF(String.valueOf(b.this.mUserId), b.this.gNS.TA());
            }
        }
    };
    private final a.InterfaceC0695a gNV = new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0695a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.brk = j;
        this.gmc = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gNS = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gNV);
        this.gNS.b(this.brk, this.gmc, this.mUserId, this.mIsHost);
        this.gNT = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gNT.a(this.gNU);
    }

    public View getView() {
        return this.gNS.getView();
    }

    public void onDestroy() {
        this.gNT.onDestroy();
        this.gNS.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gNS != null) {
            this.gNS.onKeyboardVisibilityChanged(z);
        }
    }
}
