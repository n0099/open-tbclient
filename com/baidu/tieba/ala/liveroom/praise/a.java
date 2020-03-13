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
    private DetailPraiseView fjM;
    private b fjN;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a fjO = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bql() {
            if (a.this.fjN != null) {
                a.this.fjN.m(a.this.fjM, 12);
            }
        }
    };
    private CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.evY);
    }

    public void b(b bVar) {
        this.fjN = bVar;
    }

    public void jK(boolean z) {
        if (this.fjM != null) {
            this.fjM.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fjM != null) {
            this.fjM.setPraiseEnable(z);
        }
    }

    public void al(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fjM == null) {
                this.fjM = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fjM.setOnDoubleClickListener(this.fjO);
            if (this.fjM.getParent() != null) {
                ((ViewGroup) this.fjM.getParent()).removeView(this.fjM);
            }
            viewGroup.addView(this.fjM, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bfV() {
        if (this.fjM != null) {
            this.fjM.bfV();
        }
    }
}
