package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes4.dex */
public class a {
    private long bnV;
    private long fYr;
    private com.baidu.tieba.ala.view.a gyh;
    private com.baidu.live.personmanager.e gyi;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gyj = new e.a() { // from class: com.baidu.tieba.ala.d.a.1
        @Override // com.baidu.live.personmanager.e.a
        public void OL() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gyh.Uz().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.gyi.aF(String.valueOf(a.this.mUserId), a.this.gyh.Uz());
            }
        }
    };
    private final a.InterfaceC0706a gyk = new a.InterfaceC0706a() { // from class: com.baidu.tieba.ala.d.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0706a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bnV = j;
        this.fYr = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gyh = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gyk);
        this.gyh.b(this.bnV, this.fYr, this.mUserId, this.mIsHost);
        this.gyi = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gyi.a(this.gyj);
    }

    public View getView() {
        return this.gyh.getView();
    }

    public void onDestroy() {
        this.gyi.onDestroy();
        this.gyh.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gyh != null) {
            this.gyh.onKeyboardVisibilityChanged(z);
        }
    }
}
