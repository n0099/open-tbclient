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
    private DetailPraiseView hNB;
    private b hNC;
    private boolean hND;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hNE = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void ckq() {
            if (a.this.hNC != null) {
                a.this.hNC.v(a.this.hNB, 12);
            }
        }
    };
    private CustomMessageListener gNG = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gNG.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gNG);
    }

    public void b(b bVar) {
        this.hNC = bVar;
    }

    public void oJ(boolean z) {
        if (this.hND && z) {
            z = false;
        }
        if (this.hNB != null) {
            this.hNB.setShowPraise(z);
        }
    }

    public void oK(boolean z) {
        this.hND = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hND && z) {
            z = false;
        }
        if (this.hNB != null) {
            this.hNB.setPraiseEnable(z);
        }
    }

    public void aM(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hNB == null) {
                this.hNB = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hNB.setOnDoubleClickListener(this.hNE);
            if (this.hNB.getParent() != null) {
                ((ViewGroup) this.hNB.getParent()).removeView(this.hNB);
            }
            viewGroup.addView(this.hNB, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bWp() {
        if (this.hNB != null) {
            this.hNB.bWp();
        }
    }

    public void Fy() {
        MessageManager.getInstance().unRegisterListener(this.gNG);
    }

    public View getView() {
        return this.hNB;
    }
}
