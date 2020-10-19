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
    private DetailPraiseView hat;
    private b hau;
    private boolean hav;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a haw = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void cbs() {
            if (a.this.hau != null) {
                a.this.hau.o(a.this.hat, 12);
            }
        }
    };
    private CustomMessageListener gfx = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gfx.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gfx);
    }

    public void b(b bVar) {
        this.hau = bVar;
    }

    public void nj(boolean z) {
        if (this.hav && z) {
            z = false;
        }
        if (this.hat != null) {
            this.hat.setShowPraise(z);
        }
    }

    public void nk(boolean z) {
        this.hav = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hav && z) {
            z = false;
        }
        if (this.hat != null) {
            this.hat.setPraiseEnable(z);
        }
    }

    public void aC(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hat == null) {
                this.hat = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hat.setOnDoubleClickListener(this.haw);
            if (this.hat.getParent() != null) {
                ((ViewGroup) this.hat.getParent()).removeView(this.hat);
            }
            viewGroup.addView(this.hat, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bOI() {
        if (this.hat != null) {
            this.hat.bOI();
        }
    }

    public void Gx() {
        MessageManager.getInstance().unRegisterListener(this.gfx);
    }

    public View getView() {
        return this.hat;
    }
}
