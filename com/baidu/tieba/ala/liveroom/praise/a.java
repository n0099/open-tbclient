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
    private DetailPraiseView hBu;
    private b hBv;
    private boolean hBw;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hBx = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void ckn() {
            if (a.this.hBv != null) {
                a.this.hBv.s(a.this.hBu, 12);
            }
        }
    };
    private CustomMessageListener gDG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gDG.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gDG);
    }

    public void b(b bVar) {
        this.hBv = bVar;
    }

    public void oe(boolean z) {
        if (this.hBw && z) {
            z = false;
        }
        if (this.hBu != null) {
            this.hBu.setShowPraise(z);
        }
    }

    public void of(boolean z) {
        this.hBw = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hBw && z) {
            z = false;
        }
        if (this.hBu != null) {
            this.hBu.setPraiseEnable(z);
        }
    }

    public void aA(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hBu == null) {
                this.hBu = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hBu.setOnDoubleClickListener(this.hBx);
            if (this.hBu.getParent() != null) {
                ((ViewGroup) this.hBu.getParent()).removeView(this.hBu);
            }
            viewGroup.addView(this.hBu, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bWQ() {
        if (this.hBu != null) {
            this.hBu.bWQ();
        }
    }

    public void IB() {
        MessageManager.getInstance().unRegisterListener(this.gDG);
    }

    public View getView() {
        return this.hBu;
    }
}
