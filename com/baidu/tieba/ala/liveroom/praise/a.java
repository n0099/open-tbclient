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
/* loaded from: classes3.dex */
public class a {
    private DetailPraiseView gpS;
    private b gpT;
    private boolean gpU;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a gpV = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bIZ() {
            if (a.this.gpT != null) {
                a.this.gpT.l(a.this.gpS, 12);
            }
        }
    };
    private CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.fzr.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fzr);
    }

    public void b(b bVar) {
        this.gpT = bVar;
    }

    public void lt(boolean z) {
        if (this.gpU && z) {
            z = false;
        }
        if (this.gpS != null) {
            this.gpS.setShowPraise(z);
        }
    }

    public void lu(boolean z) {
        this.gpU = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.gpU && z) {
            z = false;
        }
        if (this.gpS != null) {
            this.gpS.setPraiseEnable(z);
        }
    }

    public void ax(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gpS == null) {
                this.gpS = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.gpS.setOnDoubleClickListener(this.gpV);
            if (this.gpS.getParent() != null) {
                ((ViewGroup) this.gpS.getParent()).removeView(this.gpS);
            }
            viewGroup.addView(this.gpS, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void byd() {
        if (this.gpS != null) {
            this.gpS.byd();
        }
    }

    public void yW() {
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }

    public View getView() {
        return this.gpS;
    }
}
