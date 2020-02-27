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
    private DetailPraiseView fjy;
    private b fjz;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a fjA = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bqi() {
            if (a.this.fjz != null) {
                a.this.fjz.m(a.this.fjy, 12);
            }
        }
    };
    private CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.evK);
    }

    public void b(b bVar) {
        this.fjz = bVar;
    }

    public void jK(boolean z) {
        if (this.fjy != null) {
            this.fjy.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fjy != null) {
            this.fjy.setPraiseEnable(z);
        }
    }

    public void al(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fjy == null) {
                this.fjy = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fjy.setOnDoubleClickListener(this.fjA);
            if (this.fjy.getParent() != null) {
                ((ViewGroup) this.fjy.getParent()).removeView(this.fjy);
            }
            viewGroup.addView(this.fjy, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bfS() {
        if (this.fjy != null) {
            this.fjy.bfS();
        }
    }
}
