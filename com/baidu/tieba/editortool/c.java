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
    final /* synthetic */ a aql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aql = aVar;
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
            this.aql.Cw().CA();
            return;
        }
        this.aql.aqi = setBubbleResultData.getB_info().getB_url();
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        str = this.aql.aqi;
        m251getInst.setDefaultBubble(str);
        eVar = this.aql.aqf;
        int Tg = eVar.Tg();
        if (Tg == 0) {
            TbadkApplication.m251getInst().setDefaultBubble("");
            bubbleListData11 = this.aql.aqg;
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
            bubbleListData10 = this.aql.aqg;
            for (BubbleListData.BubbleData bubbleData2 : bubbleListData10.getB_info()) {
                if (bubbleData2.getBcode() == Tg) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
                if (bubbleData2.getBcode() == Tg) {
                    bubbleData2.setCan_use(1);
                }
            }
        } else {
            context = this.aql.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.y.bubble_setdefualt_error);
            bubbleListData = this.aql.aqg;
            if (bubbleListData != null) {
                bubbleListData2 = this.aql.aqg;
                if (bubbleListData2.getB_info() != null) {
                    bubbleListData3 = this.aql.aqg;
                    if (bubbleListData3.getB_info().size() > 0) {
                        bubbleListData4 = this.aql.aqg;
                        if (bubbleListData4.getB_info().get(0).getBcode() == 0) {
                            this.aql.aqh = 0;
                            int i2 = 0;
                            while (true) {
                                bubbleListData5 = this.aql.aqg;
                                if (i2 >= bubbleListData5.getB_info().size()) {
                                    break;
                                }
                                bubbleListData8 = this.aql.aqg;
                                if (bubbleListData8.getB_info().get(i2).isDef()) {
                                    this.aql.aqh = i2;
                                    break;
                                }
                                i2++;
                            }
                            bubbleListData6 = this.aql.aqg;
                            List<BubbleListData.BubbleData> b_info = bubbleListData6.getB_info();
                            i = this.aql.aqh;
                            b_info.get(i).setIs_def(0);
                            bubbleListData7 = this.aql.aqg;
                            bubbleListData7.getB_info().get(0).setIs_def(1);
                        } else {
                            BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                            bubbleData3.setBcode(0);
                            bubbleListData9 = this.aql.aqg;
                            bubbleListData9.getB_info().add(0, bubbleData3);
                        }
                    }
                }
            }
        }
        this.aql.Bb();
        this.aql.Cw().b(this.aql);
    }

    @Override // com.baidu.tieba.model.i
    public void b(SetBubbleResultData setBubbleResultData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (setBubbleResultData == null) {
            context = this.aql.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.y.neterror);
        } else if (setBubbleResultData.getError_code().equals("0")) {
            context2 = this.aql.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.y.neterror);
        } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
            context4 = this.aql.mContext;
            UtilHelper.showToast(context4, setBubbleResultData.getError_msg());
        } else {
            context3 = this.aql.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.y.neterror);
        }
        if (this.aql.Cw() != null) {
            this.aql.Cw().CA();
        }
    }
}
