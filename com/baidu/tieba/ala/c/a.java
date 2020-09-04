package com.baidu.tieba.ala.c;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes7.dex */
public class a {
    private long bey;
    private com.baidu.tieba.ala.view.a fSO;
    private com.baidu.live.o.b fSP;
    private long fuN;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fSQ = new b.a() { // from class: com.baidu.tieba.ala.c.a.1
        @Override // com.baidu.live.o.b.a
        public void Mf() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.o.b.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fSO.cam().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.fSP.az(String.valueOf(a.this.mUserId), a.this.fSO.cam());
            }
        }
    };
    private final a.InterfaceC0661a fSR = new a.InterfaceC0661a() { // from class: com.baidu.tieba.ala.c.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0661a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bey = j;
        this.fuN = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.fSO = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.fSR);
        this.fSO.b(this.bey, this.fuN, this.mUserId, this.mIsHost);
        this.fSP = new com.baidu.live.o.b(this.mTbPageContext);
        this.fSP.a(this.fSQ);
    }

    public View getView() {
        return this.fSO.getView();
    }

    public void onDestroy() {
        this.fSP.onDestroy();
        this.fSO.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fSO != null) {
            this.fSO.onKeyboardVisibilityChanged(z);
        }
    }
}
