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
    final /* synthetic */ a aqc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.aqc = aVar;
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
            this.aqc.Cu().Cy();
            return;
        }
        this.aqc.apZ = setBubbleResultData.getB_info().getB_url();
        TbadkApplication m251getInst = TbadkApplication.m251getInst();
        str = this.aqc.apZ;
        m251getInst.setDefaultBubble(str);
        eVar = this.aqc.apW;
        int Td = eVar.Td();
        if (Td == 0) {
            TbadkApplication.m251getInst().setDefaultBubble("");
            bubbleListData11 = this.aqc.apX;
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
            bubbleListData10 = this.aqc.apX;
            for (BubbleListData.BubbleData bubbleData2 : bubbleListData10.getB_info()) {
                if (bubbleData2.getBcode() == Td) {
                    bubbleData2.setIs_def(1);
                } else if (bubbleData2.isDef()) {
                    bubbleData2.setIs_def(0);
                }
                if (bubbleData2.getBcode() == Td) {
                    bubbleData2.setCan_use(1);
                }
            }
        } else {
            context = this.aqc.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.y.bubble_setdefualt_error);
            bubbleListData = this.aqc.apX;
            if (bubbleListData != null) {
                bubbleListData2 = this.aqc.apX;
                if (bubbleListData2.getB_info() != null) {
                    bubbleListData3 = this.aqc.apX;
                    if (bubbleListData3.getB_info().size() > 0) {
                        bubbleListData4 = this.aqc.apX;
                        if (bubbleListData4.getB_info().get(0).getBcode() == 0) {
                            this.aqc.apY = 0;
                            int i2 = 0;
                            while (true) {
                                bubbleListData5 = this.aqc.apX;
                                if (i2 >= bubbleListData5.getB_info().size()) {
                                    break;
                                }
                                bubbleListData8 = this.aqc.apX;
                                if (bubbleListData8.getB_info().get(i2).isDef()) {
                                    this.aqc.apY = i2;
                                    break;
                                }
                                i2++;
                            }
                            bubbleListData6 = this.aqc.apX;
                            List<BubbleListData.BubbleData> b_info = bubbleListData6.getB_info();
                            i = this.aqc.apY;
                            b_info.get(i).setIs_def(0);
                            bubbleListData7 = this.aqc.apX;
                            bubbleListData7.getB_info().get(0).setIs_def(1);
                        } else {
                            BubbleListData.BubbleData bubbleData3 = new BubbleListData.BubbleData();
                            bubbleData3.setBcode(0);
                            bubbleListData9 = this.aqc.apX;
                            bubbleListData9.getB_info().add(0, bubbleData3);
                        }
                    }
                }
            }
        }
        this.aqc.AZ();
        this.aqc.Cu().b(this.aqc);
    }

    @Override // com.baidu.tieba.model.i
    public void b(SetBubbleResultData setBubbleResultData) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        if (setBubbleResultData == null) {
            context = this.aqc.mContext;
            UtilHelper.showToast(context, com.baidu.tieba.y.neterror);
        } else if (setBubbleResultData.getError_code().equals("0")) {
            context2 = this.aqc.mContext;
            UtilHelper.showToast(context2, com.baidu.tieba.y.neterror);
        } else if (!TextUtils.isEmpty(setBubbleResultData.getError_msg())) {
            context4 = this.aqc.mContext;
            UtilHelper.showToast(context4, setBubbleResultData.getError_msg());
        } else {
            context3 = this.aqc.mContext;
            UtilHelper.showToast(context3, com.baidu.tieba.y.neterror);
        }
        if (this.aqc.Cu() != null) {
            this.aqc.Cu().Cy();
        }
    }
}
