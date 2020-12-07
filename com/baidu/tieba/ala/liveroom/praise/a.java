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
    private DetailPraiseView hBs;
    private b hBt;
    private boolean hBu;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hBv = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void ckm() {
            if (a.this.hBt != null) {
                a.this.hBt.s(a.this.hBs, 12);
            }
        }
    };
    private CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gDE.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gDE);
    }

    public void b(b bVar) {
        this.hBt = bVar;
    }

    public void oe(boolean z) {
        if (this.hBu && z) {
            z = false;
        }
        if (this.hBs != null) {
            this.hBs.setShowPraise(z);
        }
    }

    public void of(boolean z) {
        this.hBu = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hBu && z) {
            z = false;
        }
        if (this.hBs != null) {
            this.hBs.setPraiseEnable(z);
        }
    }

    public void aA(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hBs == null) {
                this.hBs = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hBs.setOnDoubleClickListener(this.hBv);
            if (this.hBs.getParent() != null) {
                ((ViewGroup) this.hBs.getParent()).removeView(this.hBs);
            }
            viewGroup.addView(this.hBs, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bWP() {
        if (this.hBs != null) {
            this.hBs.bWP();
        }
    }

    public void IB() {
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }

    public View getView() {
        return this.hBs;
    }
}
