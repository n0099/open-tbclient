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
    private long bwn;
    private com.baidu.tieba.ala.view.a gSv;
    private com.baidu.live.personmanager.e gSw;
    private long gqI;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gSx = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Pj() {
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
            if (b.this.gSv.Vk().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gSw.aF(String.valueOf(b.this.mUserId), b.this.gSv.Vk());
            }
        }
    };
    private final a.InterfaceC0702a gSy = new a.InterfaceC0702a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0702a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bwn = j;
        this.gqI = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gSv = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gSy);
        this.gSv.b(this.bwn, this.gqI, this.mUserId, this.mIsHost);
        this.gSw = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gSw.a(this.gSx);
    }

    public View getView() {
        return this.gSv.getView();
    }

    public void onDestroy() {
        this.gSw.onDestroy();
        this.gSv.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gSv != null) {
            this.gSv.onKeyboardVisibilityChanged(z);
        }
    }
}
