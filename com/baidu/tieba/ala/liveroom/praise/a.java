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
    private DetailPraiseView hNn;
    private b hNo;
    private boolean hNp;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hNq = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void ckj() {
            if (a.this.hNo != null) {
                a.this.hNo.v(a.this.hNn, 12);
            }
        }
    };
    private CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gNs.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gNs);
    }

    public void b(b bVar) {
        this.hNo = bVar;
    }

    public void oJ(boolean z) {
        if (this.hNp && z) {
            z = false;
        }
        if (this.hNn != null) {
            this.hNn.setShowPraise(z);
        }
    }

    public void oK(boolean z) {
        this.hNp = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hNp && z) {
            z = false;
        }
        if (this.hNn != null) {
            this.hNn.setPraiseEnable(z);
        }
    }

    public void aM(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hNn == null) {
                this.hNn = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hNn.setOnDoubleClickListener(this.hNq);
            if (this.hNn.getParent() != null) {
                ((ViewGroup) this.hNn.getParent()).removeView(this.hNn);
            }
            viewGroup.addView(this.hNn, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bWi() {
        if (this.hNn != null) {
            this.hNn.bWi();
        }
    }

    public void Fy() {
        MessageManager.getInstance().unRegisterListener(this.gNs);
    }

    public View getView() {
        return this.hNn;
    }
}
