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
    private DetailPraiseView fkl;
    private b fkm;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a fkn = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bqq() {
            if (a.this.fkm != null) {
                a.this.fkm.m(a.this.fkl, 12);
            }
        }
    };
    private CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.ewu);
    }

    public void b(b bVar) {
        this.fkm = bVar;
    }

    public void jM(boolean z) {
        if (this.fkl != null) {
            this.fkl.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fkl != null) {
            this.fkl.setPraiseEnable(z);
        }
    }

    public void am(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fkl == null) {
                this.fkl = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fkl.setOnDoubleClickListener(this.fkn);
            if (this.fkl.getParent() != null) {
                ((ViewGroup) this.fkl.getParent()).removeView(this.fkl);
            }
            viewGroup.addView(this.fkl, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bga() {
        if (this.fkl != null) {
            this.fkl.bga();
        }
    }
}
