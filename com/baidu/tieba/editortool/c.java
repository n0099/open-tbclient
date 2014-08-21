package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.data.BubbleListData;
import com.baidu.tieba.data.SetBubbleResultData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.model.i {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.model.i
    public void a(SetBubbleResultData setBubbleResultData) {
        String str;
        com.baidu.tieba.model.e eVar;
        Context context;
        BubbleListData bubbleListData;
        BubbleListData bubbleListData2;
        BubbleListData bubbleListData3;
        BubbleListData bubbleListData4;
        BubbleListData bubbleListData5;
        BubbleListData bubbleListData6;
        int i;
        BubbleListData bubbleListData7;
        BubbleListData bubbleListData8;
        BubbleListData bubbleListData9;
        BubbleListData bubbleListData10;
        BubbleListData bubbleListData11;
        if (setBubbleResultData == null || setBubbleResultData.getB_info() == null) {
            this.a.i().b();
            return;
        }
        this.a.f = setBubbleResultData.getB_info().getB_url();
        TbadkApplication m252getInst = TbadkApplication.m252getInst();
        str = this.a.f;
        m252getInst.setDefaultBubble(str);
        eVar = this.a.b;
        int a = eVar.a();
        if (a == 0) {
            TbadkApplication.m252getInst().setDefaultBubble("");
            bubbleListData11 = this.a.c;
            for (BubbleListData.BubbleData bubbleData : bubbleListData11.getB_info()) {
                if (bubbleData.getBcode() != 0) {
                    if (bubbleData.isDef()) {
                        bubbleData.setIs_def(0);
                    }
                } else {
                    bubbleData.setIs_def(1);
                }
            }
        } else if (setBubbleResultData.getB_info().canUser()) {
            bubbleListData10 = this.a.c;
            for (BubbleListData.BubbleData bubbleData2 : bubbleListData10.getB_info()) {
                if (bubbleData2.getBcode() == a) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
                if (bubbleData2.getBcode() == a) {
                    bubbleData2.setCan_use(1);
                }
            }
        } else {
            context = this.a.d;
            UtilHelper.showToast(context, com.baidu.tieba.x.bubble_setdefualt_error);
            bubbleListData = this.a.c;
            if (bubbleListData != null) {
                bubbleListData2 = this.a.c;
                if (bubbleListData2.getB_info() != null) {
                    bubbleListData3 = this.a.c;
                    if (bubbleListData3.getB_info().size() > 0) {
                        bubbleListData4 = this.a.c;
                        if (bubbleListData4.getB_info().get(0).getBcode() == 0) {
                            this.a.e = 0;
                            int i2 = 0;
                            while (true) {
                                bubbleListData5 = this.a.c;
                                if (i2 >= bubbleListData5.getB_info().size()) {
                                    break;
                                }
                                bubbleListData8 = this.a.c;
                                if (bubbleListData8.getB_info().get(i2).isDef()) {
                                    this.a.e = i2;
                                    break;
                                }
                                i2++;
                            }
                            bubbleListData6 = this.a.c;
                            List<BubbleListData.BubbleData> b_info = bubbleListData6.getB_info();
                            i = this.a.e;
                            b_info.get(i).setIs_def(0);
                            bubbleListData7 = this.a.c;
                            bubbleListData7.getB_info().get(0).setIs_def(1);
                        } else {
                            BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                            bubbleData3.setBcode(0);
                            bubbleListData9 = this.a.c;
                            bubbleListData9.getB_info().add(0, bubbleData3);
                        }
                    }
                }
            }
        }
        this.a.k();
        this.a.i().a(this.a);
    }

    @Override // com.baidu.tieba.model.i
    public void b(SetBubbleResultData setBubbleResultData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (setBubbleResultData == null) {
            context = this.a.d;
            UtilHelper.showToast(context, com.baidu.tieba.x.neterror);
        } else if (setBubbleResultData.getError_code().equals("0")) {
            context2 = this.a.d;
            UtilHelper.showToast(context2, com.baidu.tieba.x.neterror);
        } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
            context4 = this.a.d;
            UtilHelper.showToast(context4, setBubbleResultData.getError_msg());
        } else {
            context3 = this.a.d;
            UtilHelper.showToast(context3, com.baidu.tieba.x.neterror);
        }
        if (this.a.i() != null) {
            this.a.i().b();
        }
    }
}
