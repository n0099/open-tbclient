package com.baidu.tieba.ala.liveroom.praise;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.operation.b;
import com.baidu.tieba.ala.liveroom.praise.DetailPraiseView;
/* loaded from: classes4.dex */
public class a {
    private DetailPraiseView hrO;
    private b hrP;
    private boolean hrQ;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hrR = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void cgs() {
            if (a.this.hrP != null) {
                a.this.hrP.s(a.this.hrO, 12);
            }
        }
    };
    private CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                a.this.otherParams = str;
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.guV.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.guV);
    }

    public void b(b bVar) {
        this.hrP = bVar;
    }

    public void nJ(boolean z) {
        if (this.hrQ && z) {
            z = false;
        }
        if (this.hrO != null) {
            this.hrO.setShowPraise(z);
        }
    }

    public void nK(boolean z) {
        this.hrQ = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hrQ && z) {
            z = false;
        }
        if (this.hrO != null) {
            this.hrO.setPraiseEnable(z);
        }
    }

    public void aA(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hrO == null) {
                this.hrO = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hrO.setOnDoubleClickListener(this.hrR);
            if (this.hrO.getParent() != null) {
                ((ViewGroup) this.hrO.getParent()).removeView(this.hrO);
            }
            viewGroup.addView(this.hrO, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bTf() {
        if (this.hrO != null) {
            this.hrO.bTf();
        }
    }

    public void GK() {
        MessageManager.getInstance().unRegisterListener(this.guV);
    }

    public View getView() {
        return this.hrO;
    }
}
