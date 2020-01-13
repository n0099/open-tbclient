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
    private DetailPraiseView fgj;
    private b fgk;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a fgl = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bov() {
            if (a.this.fgk != null) {
                a.this.fgk.m(a.this.fgj, 12);
            }
        }
    };
    private CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.erA);
    }

    public void b(b bVar) {
        this.fgk = bVar;
    }

    public void jI(boolean z) {
        if (this.fgj != null) {
            this.fgj.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fgj != null) {
            this.fgj.setPraiseEnable(z);
        }
    }

    public void ak(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fgj == null) {
                this.fgj = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fgj.setOnDoubleClickListener(this.fgl);
            if (this.fgj.getParent() != null) {
                ((ViewGroup) this.fgj.getParent()).removeView(this.fgj);
            }
            viewGroup.addView(this.fgj, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bdI() {
        if (this.fgj != null) {
            this.fgj.bdI();
        }
    }
}
