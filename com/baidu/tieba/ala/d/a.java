package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes4.dex */
public class a {
    private long bhr;
    private com.baidu.tieba.ala.view.a fVY;
    private com.baidu.live.personmanager.b fVZ;
    private long fxY;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fWa = new b.a() { // from class: com.baidu.tieba.ala.d.a.1
        @Override // com.baidu.live.personmanager.b.a
        public void MI() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.b.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fVY.ccw().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.fVZ.az(String.valueOf(a.this.mUserId), a.this.fVY.ccw());
            }
        }
    };
    private final a.InterfaceC0658a fWb = new a.InterfaceC0658a() { // from class: com.baidu.tieba.ala.d.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0658a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bhr = j;
        this.fxY = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.fVY = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.fWb);
        this.fVY.b(this.bhr, this.fxY, this.mUserId, this.mIsHost);
        this.fVZ = new com.baidu.live.personmanager.b(this.mTbPageContext);
        this.fVZ.a(this.fWa);
    }

    public View getView() {
        return this.fVY.getView();
    }

    public void onDestroy() {
        this.fVZ.onDestroy();
        this.fVY.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fVY != null) {
            this.fVY.onKeyboardVisibilityChanged(z);
        }
    }
}
