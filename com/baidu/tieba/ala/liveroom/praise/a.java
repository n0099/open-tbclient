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
    private DetailPraiseView hmj;
    private b hmk;
    private boolean hml;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hmm = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void cew() {
            if (a.this.hmk != null) {
                a.this.hmk.p(a.this.hmj, 12);
            }
        }
    };
    private CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gpA.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gpA);
    }

    public void b(b bVar) {
        this.hmk = bVar;
    }

    public void nz(boolean z) {
        if (this.hml && z) {
            z = false;
        }
        if (this.hmj != null) {
            this.hmj.setShowPraise(z);
        }
    }

    public void nA(boolean z) {
        this.hml = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hml && z) {
            z = false;
        }
        if (this.hmj != null) {
            this.hmj.setPraiseEnable(z);
        }
    }

    public void aC(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hmj == null) {
                this.hmj = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hmj.setOnDoubleClickListener(this.hmm);
            if (this.hmj.getParent() != null) {
                ((ViewGroup) this.hmj.getParent()).removeView(this.hmj);
            }
            viewGroup.addView(this.hmj, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bRn() {
        if (this.hmj != null) {
            this.hmj.bRn();
        }
    }

    public void GS() {
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    public View getView() {
        return this.hmj;
    }
}
