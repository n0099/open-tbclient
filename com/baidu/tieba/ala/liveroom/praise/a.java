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
/* loaded from: classes7.dex */
public class a {
    private DetailPraiseView gHR;
    private b gHS;
    private boolean gHT;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a gHU = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bWh() {
            if (a.this.gHS != null) {
                a.this.gHS.m(a.this.gHR, 12);
            }
        }
    };
    private CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.fPP.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fPP);
    }

    public void b(b bVar) {
        this.gHS = bVar;
    }

    public void mA(boolean z) {
        if (this.gHT && z) {
            z = false;
        }
        if (this.gHR != null) {
            this.gHR.setShowPraise(z);
        }
    }

    public void mB(boolean z) {
        this.gHT = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.gHT && z) {
            z = false;
        }
        if (this.gHR != null) {
            this.gHR.setPraiseEnable(z);
        }
    }

    public void az(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gHR == null) {
                this.gHR = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.gHR.setOnDoubleClickListener(this.gHU);
            if (this.gHR.getParent() != null) {
                ((ViewGroup) this.gHR.getParent()).removeView(this.gHR);
            }
            viewGroup.addView(this.gHR, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bKN() {
        if (this.gHR != null) {
            this.gHR.bKN();
        }
    }

    public void Fb() {
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }

    public View getView() {
        return this.gHR;
    }
}
