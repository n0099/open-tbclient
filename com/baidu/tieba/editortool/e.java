package com.baidu.tieba.editortool;

import android.view.View;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.TbWebViewActivity;
import com.baidu.tieba.data.BubbleListData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof com.baidu.tieba.view.a) {
            BubbleListData.BubbleData bubbleData = this.a.b.getB_info().get(((Integer) view.getTag()).intValue());
            if (bubbleData != null) {
                if (bubbleData.getBcode() == 0 || bubbleData.canUse() || bubbleData.isFree()) {
                    if (!bubbleData.isDef()) {
                        this.a.a.a(bubbleData.getBcode(), com.baidu.adp.lib.util.h.b(this.a.d), com.baidu.adp.lib.util.h.c(this.a.d));
                        this.a.a.a(bubbleData.getBcode());
                        if (this.a.i() != null) {
                            this.a.i().a();
                            return;
                        }
                        return;
                    }
                    return;
                }
                this.a.a.b(bubbleData.getBcode());
                TbWebViewActivity.a(this.a.d, TbadkApplication.m252getInst().getString(com.baidu.tieba.u.web_title_bubble_purchase), String.valueOf(com.baidu.tieba.data.d.a) + "mo/q/tbeantshow?_client_version=" + TbConfig.getVersion());
            }
        }
    }
}
