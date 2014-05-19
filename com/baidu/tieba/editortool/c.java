package com.baidu.tieba.editortool;

import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.data.SetBubbleResultData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.model.j {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.model.j
    public void a(SetBubbleResultData setBubbleResultData) {
        if (setBubbleResultData == null || setBubbleResultData.getB_info() == null) {
            this.a.i().b();
            return;
        }
        this.a.f = setBubbleResultData.getB_info().getB_url();
        TbadkApplication.m252getInst().setDefaultBubble(this.a.f);
        int a = this.a.a.a();
        if (a == 0) {
            TbadkApplication.m252getInst().setDefaultBubble("");
            for (BubbleListData.BubbleData bubbleData : this.a.b.getB_info()) {
                if (bubbleData.getBcode() != 0) {
                    if (bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                } else {
                    bubbleData.setIs_def(1);
                }
            }
        } else if (setBubbleResultData.getB_info().canUser()) {
            for (BubbleListData.BubbleData bubbleData2 : this.a.b.getB_info()) {
                if (bubbleData2.getBcode() == a) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
            }
        } else {
            UtilHelper.showToast(this.a.d, com.baidu.tieba.u.bubble_setdefualt_error);
        }
        this.a.k();
        this.a.i().a(this.a);
    }

    @Override // com.baidu.tieba.model.j
    public void b(SetBubbleResultData setBubbleResultData) {
        if (setBubbleResultData != null) {
            if (!setBubbleResultData.getError_code().equals("0")) {
                if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
                    UtilHelper.showToast(this.a.d, setBubbleResultData.getError_msg());
                } else {
                    UtilHelper.showToast(this.a.d, com.baidu.tieba.u.neterror);
                }
            } else {
                UtilHelper.showToast(this.a.d, com.baidu.tieba.u.neterror);
            }
        } else {
            UtilHelper.showToast(this.a.d, com.baidu.tieba.u.neterror);
        }
        if (this.a.i() != null) {
            this.a.i().b();
        }
    }
}
