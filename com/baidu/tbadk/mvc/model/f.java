package com.baidu.tbadk.mvc.model;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private static /* synthetic */ int[] aei;
    final /* synthetic */ NetModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(NetModel netModel) {
        this.this$0 = netModel;
    }

    static /* synthetic */ int[] xD() {
        int[] iArr = aei;
        if (iArr == null) {
            iArr = new int[NetModel.NetModelType.valuesCustom().length];
            try {
                iArr[NetModel.NetModelType.TYPE_AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[NetModel.NetModelType.TYPE_HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[NetModel.NetModelType.TYPE_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[NetModel.NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            aei = iArr;
        }
        return iArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        NetModel.NetModelType netModelType;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        TbPageContext tbPageContext3;
        int[] xD = xD();
        netModelType = this.this$0.adZ;
        switch (xD[netModelType.ordinal()]) {
            case 1:
            case 4:
                NetModel netModel = this.this$0;
                tbPageContext = this.this$0.mPageContext;
                netModel.s(-1, tbPageContext.getString(z.neterror));
                return;
            case 2:
                NetModel netModel2 = this.this$0;
                tbPageContext2 = this.this$0.mPageContext;
                netModel2.t(-1, tbPageContext2.getString(z.neterror));
                return;
            case 3:
                NetModel netModel3 = this.this$0;
                tbPageContext3 = this.this$0.mPageContext;
                netModel3.r(-1, tbPageContext3.getString(z.neterror));
                return;
            default:
                return;
        }
    }
}
