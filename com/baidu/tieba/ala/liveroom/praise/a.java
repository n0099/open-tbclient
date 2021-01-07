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
/* loaded from: classes11.dex */
public class a {
    private DetailPraiseView hNv;
    private b hNw;
    private boolean hNx;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hNy = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void cnc() {
            if (a.this.hNw != null) {
                a.this.hNw.v(a.this.hNv, 12);
            }
        }
    };
    private CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gPs.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gPs);
    }

    public void b(b bVar) {
        this.hNw = bVar;
    }

    public void oD(boolean z) {
        if (this.hNx && z) {
            z = false;
        }
        if (this.hNv != null) {
            this.hNv.setShowPraise(z);
        }
    }

    public void oE(boolean z) {
        this.hNx = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hNx && z) {
            z = false;
        }
        if (this.hNv != null) {
            this.hNv.setPraiseEnable(z);
        }
    }

    public void aM(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hNv == null) {
                this.hNv = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hNv.setOnDoubleClickListener(this.hNy);
            if (this.hNv.getParent() != null) {
                ((ViewGroup) this.hNv.getParent()).removeView(this.hNv);
            }
            viewGroup.addView(this.hNv, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bZw() {
        if (this.hNv != null) {
            this.hNv.bZw();
        }
    }

    public void Id() {
        MessageManager.getInstance().unRegisterListener(this.gPs);
    }

    public View getView() {
        return this.hNv;
    }
}
