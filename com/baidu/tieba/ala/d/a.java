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
    private long bmk;
    private long fXY;
    private com.baidu.tieba.ala.view.a gxO;
    private com.baidu.live.personmanager.e gxP;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gxQ = new e.a() { // from class: com.baidu.tieba.ala.d.a.1
        @Override // com.baidu.live.personmanager.e.a
        public void Oc() {
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
            if (a.this.gxO.TQ().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.gxP.aE(String.valueOf(a.this.mUserId), a.this.gxO.TQ());
            }
        }
    };
    private final a.InterfaceC0706a gxR = new a.InterfaceC0706a() { // from class: com.baidu.tieba.ala.d.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0706a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bmk = j;
        this.fXY = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gxO = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gxR);
        this.gxO.b(this.bmk, this.fXY, this.mUserId, this.mIsHost);
        this.gxP = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gxP.a(this.gxQ);
    }

    public View getView() {
        return this.gxO.getView();
    }

    public void onDestroy() {
        this.gxP.onDestroy();
        this.gxO.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gxO != null) {
            this.gxO.onKeyboardVisibilityChanged(z);
        }
    }
}
