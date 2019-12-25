package com.baidu.tieba.ala.liveroom.praise;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.operation.b;
import com.baidu.tieba.ala.liveroom.praise.DetailPraiseView;
/* loaded from: classes2.dex */
public class a {
    private DetailPraiseView fdd;
    private b fde;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a fdf = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bnv() {
            if (a.this.fde != null) {
                a.this.fde.m(a.this.fdd, 12);
            }
        }
    };
    private CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.eqn);
    }

    public void b(b bVar) {
        this.fde = bVar;
    }

    public void jx(boolean z) {
        if (this.fdd != null) {
            this.fdd.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fdd != null) {
            this.fdd.setPraiseEnable(z);
        }
    }

    public void ag(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fdd == null) {
                this.fdd = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fdd.setOnDoubleClickListener(this.fdf);
            if (this.fdd.getParent() != null) {
                ((ViewGroup) this.fdd.getParent()).removeView(this.fdd);
            }
            viewGroup.addView(this.fdd, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bdn() {
        if (this.fdd != null) {
            this.fdd.bdn();
        }
    }
}
