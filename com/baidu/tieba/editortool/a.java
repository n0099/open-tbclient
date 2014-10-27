package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class a extends an {
    private com.baidu.tieba.model.h aiV;
    private com.baidu.tieba.model.i aiW;
    private com.baidu.tieba.bubble.s aiX;
    private com.baidu.tieba.bubble.s aiY;
    public CustomMessageListener aiZ;
    private com.baidu.tieba.model.e apW;
    private BubbleListData apX;
    private int apY;
    private String apZ;
    private boolean aqa;
    private View.OnClickListener aqb;
    private Context mContext;

    public a(at atVar) {
        super(atVar);
        this.apY = 0;
        this.aqa = false;
        this.aiV = new b(this);
        this.aiW = new c(this);
        this.aiZ = new d(this, 2010040);
        this.aqb = new e(this);
        this.aiX = new f(this);
        this.aiY = new g(this);
    }

    @Override // com.baidu.tieba.editortool.an
    public void init(Context context) {
        if (this.aqa) {
            if (Cu() != null) {
                Cu().b(this);
                return;
            }
            return;
        }
        this.aqa = true;
        this.mContext = context;
        ap apVar = new ap();
        apVar.arE = com.baidu.tieba.u.icon_bubble;
        apVar.arF = 0;
        setVerticalSpacing(TbadkApplication.m251getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26));
        setHorizontalSpacing(TbadkApplication.m251getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
        a(apVar);
        es(2);
        et(2);
        a(new h(this, context));
        this.apZ = TbadkApplication.m251getInst().getDefaultBubble();
        if (this.apW == null) {
            this.apW = new com.baidu.tieba.model.e(this.mContext);
        }
        this.apW.a(this.aiV);
        this.apW.a(this.aiW);
        this.apW.a(this.aiZ);
        this.apW.Tf();
        this.apW.Tg();
        if (Cu() != null) {
            Cu().Cx();
        }
        this.apW.h(0, 50, com.baidu.adp.lib.util.m.n(this.mContext), com.baidu.adp.lib.util.m.o(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(int i) {
        this.apW.p(i, com.baidu.adp.lib.util.m.n(this.mContext), com.baidu.adp.lib.util.m.o(this.mContext));
        this.apW.gy(i);
        if (Cu() != null) {
            Cu().Cx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AZ() {
        int i = 0;
        if (this.apX != null && this.apX.getB_info() != null && this.apX.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.apX.getB_info().get(0).getBcode() != 0) {
                this.apX.getB_info().add(0, bubbleData);
            }
            this.apY = 0;
            while (true) {
                if (i >= this.apX.getB_info().size()) {
                    break;
                } else if (!this.apX.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.apY = i;
                    break;
                }
            }
        }
        if (Cv() != null) {
            if (this.apY == 0 || TextUtils.isEmpty(this.apZ)) {
                Cv().handleAction(47, null);
            } else {
                Cv().handleAction(46, this.apZ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData dW(int i) {
        if (i < 0 || i >= getCount() || this.apX == null) {
            return null;
        }
        return this.apX.getB_info().get(i);
    }

    @Override // com.baidu.tieba.editortool.an
    public int getCount() {
        if (this.apX == null || this.apX.getB_info() == null) {
            return 0;
        }
        return this.apX.getB_info().size();
    }

    @Override // com.baidu.tieba.editortool.an
    public void exit() {
        if (this.apW != null) {
            this.apW.unRegisterListener();
            this.apW.b(this.aiZ);
            this.apW = null;
            this.aqa = false;
        }
    }
}
