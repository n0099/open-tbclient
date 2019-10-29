package com.baidu.tieba.ala.liveroom.praise;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.operation.b;
import com.baidu.tieba.ala.liveroom.praise.DetailPraiseView;
/* loaded from: classes6.dex */
public class a {
    private b enA;
    private DetailPraiseView enz;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a enB = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void aVF() {
            if (a.this.enA != null) {
                a.this.enA.n(a.this.enz, 12);
            }
        }
    };
    private CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        MessageManager.getInstance().registerListener(this.dFq);
    }

    public void b(b bVar) {
        this.enA = bVar;
    }

    public void ig(boolean z) {
        if (this.enz != null) {
            this.enz.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.enz != null) {
            this.enz.setPraiseEnable(z);
        }
    }

    public void ah(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null && this.enz == null) {
            this.enz = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            this.enz.setOnDoubleClickListener(this.enB);
            viewGroup.addView(this.enz, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void aMg() {
        if (this.enz != null) {
            this.enz.aMg();
        }
    }
}
