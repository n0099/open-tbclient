package com.baidu.tieba.editortool;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.BubbleListData;
/* loaded from: classes.dex */
public class a extends an {
    private com.baidu.tieba.model.h aje;
    private com.baidu.tieba.model.i ajf;
    private com.baidu.tieba.bubble.s ajg;
    private com.baidu.tieba.bubble.s ajh;
    public CustomMessageListener aji;
    private com.baidu.tieba.model.e aqf;
    private BubbleListData aqg;
    private int aqh;
    private String aqi;
    private boolean aqj;
    private View.OnClickListener aqk;
    private Context mContext;

    public a(at atVar) {
        super(atVar);
        this.aqh = 0;
        this.aqj = false;
        this.aje = new b(this);
        this.ajf = new c(this);
        this.aji = new d(this, 2010040);
        this.aqk = new e(this);
        this.ajg = new f(this);
        this.ajh = new g(this);
    }

    @Override // com.baidu.tieba.editortool.an
    public void init(Context context) {
        if (this.aqj) {
            if (Cw() != null) {
                Cw().b(this);
                return;
            }
            return;
        }
        this.aqj = true;
        this.mContext = context;
        ap apVar = new ap();
        apVar.arN = com.baidu.tieba.u.icon_bubble;
        apVar.arO = 0;
        setVerticalSpacing(TbadkApplication.m251getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds26));
        setHorizontalSpacing(TbadkApplication.m251getInst().getResources().getDimensionPixelSize(com.baidu.tieba.t.ds30));
        a(apVar);
        es(2);
        et(2);
        a(new h(this, context));
        this.aqi = TbadkApplication.m251getInst().getDefaultBubble();
        if (this.aqf == null) {
            this.aqf = new com.baidu.tieba.model.e(this.mContext);
        }
        this.aqf.a(this.aje);
        this.aqf.a(this.ajf);
        this.aqf.a(this.aji);
        this.aqf.Ti();
        this.aqf.Tj();
        if (Cw() != null) {
            Cw().Cz();
        }
        this.aqf.h(0, 50, com.baidu.adp.lib.util.m.n(this.mContext), com.baidu.adp.lib.util.m.o(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU(int i) {
        this.aqf.p(i, com.baidu.adp.lib.util.m.n(this.mContext), com.baidu.adp.lib.util.m.o(this.mContext));
        this.aqf.gy(i);
        if (Cw() != null) {
            Cw().Cz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bb() {
        int i = 0;
        if (this.aqg != null && this.aqg.getB_info() != null && this.aqg.getB_info().size() > 0) {
            BubbleListData.BubbleData bubbleData = new BubbleListData.BubbleData();
            bubbleData.setBcode(0);
            if (this.aqg.getB_info().get(0).getBcode() != 0) {
                this.aqg.getB_info().add(0, bubbleData);
            }
            this.aqh = 0;
            while (true) {
                if (i >= this.aqg.getB_info().size()) {
                    break;
                } else if (!this.aqg.getB_info().get(i).isDef()) {
                    i++;
                } else {
                    this.aqh = i;
                    break;
                }
            }
        }
        if (Cx() != null) {
            if (this.aqh == 0 || TextUtils.isEmpty(this.aqi)) {
                Cx().handleAction(47, null);
            } else {
                Cx().handleAction(46, this.aqi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BubbleListData.BubbleData dW(int i) {
        if (i < 0 || i >= getCount() || this.aqg == null) {
            return null;
        }
        return this.aqg.getB_info().get(i);
    }

    @Override // com.baidu.tieba.editortool.an
    public int getCount() {
        if (this.aqg == null || this.aqg.getB_info() == null) {
            return 0;
        }
        return this.aqg.getB_info().size();
    }

    @Override // com.baidu.tieba.editortool.an
    public void exit() {
        if (this.aqf != null) {
            this.aqf.unRegisterListener();
            this.aqf.b(this.aji);
            this.aqf = null;
            this.aqj = false;
        }
    }
}
