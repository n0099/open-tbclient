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
/* loaded from: classes10.dex */
public class a {
    private DetailPraiseView hIP;
    private b hIQ;
    private boolean hIR;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hIS = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void cjk() {
            if (a.this.hIQ != null) {
                a.this.hIQ.v(a.this.hIP, 12);
            }
        }
    };
    private CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gKM.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gKM);
    }

    public void b(b bVar) {
        this.hIQ = bVar;
    }

    public void oz(boolean z) {
        if (this.hIR && z) {
            z = false;
        }
        if (this.hIP != null) {
            this.hIP.setShowPraise(z);
        }
    }

    public void oA(boolean z) {
        this.hIR = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hIR && z) {
            z = false;
        }
        if (this.hIP != null) {
            this.hIP.setPraiseEnable(z);
        }
    }

    public void aM(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hIP == null) {
                this.hIP = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hIP.setOnDoubleClickListener(this.hIS);
            if (this.hIP.getParent() != null) {
                ((ViewGroup) this.hIP.getParent()).removeView(this.hIP);
            }
            viewGroup.addView(this.hIP, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bVE() {
        if (this.hIP != null) {
            this.hIP.bVE();
        }
    }

    public void Ei() {
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }

    public View getView() {
        return this.hIP;
    }
}
