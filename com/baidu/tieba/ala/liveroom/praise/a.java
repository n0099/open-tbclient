package com.baidu.tieba.ala.liveroom.praise;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.operation.b;
import com.baidu.tieba.ala.liveroom.praise.DetailPraiseView;
/* loaded from: classes3.dex */
public class a {
    private b fjA;
    private DetailPraiseView fjz;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a fjB = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bqk() {
            if (a.this.fjA != null) {
                a.this.fjA.m(a.this.fjz, 12);
            }
        }
    };
    private CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.evL);
    }

    public void b(b bVar) {
        this.fjA = bVar;
    }

    public void jK(boolean z) {
        if (this.fjz != null) {
            this.fjz.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fjz != null) {
            this.fjz.setPraiseEnable(z);
        }
    }

    public void al(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fjz == null) {
                this.fjz = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fjz.setOnDoubleClickListener(this.fjB);
            if (this.fjz.getParent() != null) {
                ((ViewGroup) this.fjz.getParent()).removeView(this.fjz);
            }
            viewGroup.addView(this.fjz, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bfU() {
        if (this.fjz != null) {
            this.fjz.bfU();
        }
    }
}
