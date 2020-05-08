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
    private DetailPraiseView fOI;
    private b fOJ;
    private DetailPraiseView.a fOK = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bzJ() {
            if (a.this.fOJ != null) {
                a.this.fOJ.l(a.this.fOI, 12);
            }
        }
    };
    private CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.faq.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.faq);
    }

    public void b(b bVar) {
        this.fOJ = bVar;
    }

    public void kQ(boolean z) {
        if (this.fOI != null) {
            this.fOI.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fOI != null) {
            this.fOI.setPraiseEnable(z);
        }
    }

    public void an(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fOI == null) {
                this.fOI = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fOI.setOnDoubleClickListener(this.fOK);
            if (this.fOI.getParent() != null) {
                ((ViewGroup) this.fOI.getParent()).removeView(this.fOI);
            }
            viewGroup.addView(this.fOI, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bpp() {
        if (this.fOI != null) {
            this.fOI.bpp();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.faq);
    }
}
