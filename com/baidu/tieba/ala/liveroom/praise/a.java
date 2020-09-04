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
    private DetailPraiseView gHV;
    private b gHW;
    private boolean gHX;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a gHY = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bWi() {
            if (a.this.gHW != null) {
                a.this.gHW.m(a.this.gHV, 12);
            }
        }
    };
    private CustomMessageListener fPT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.fPT.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fPT);
    }

    public void b(b bVar) {
        this.gHW = bVar;
    }

    public void mC(boolean z) {
        if (this.gHX && z) {
            z = false;
        }
        if (this.gHV != null) {
            this.gHV.setShowPraise(z);
        }
    }

    public void mD(boolean z) {
        this.gHX = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.gHX && z) {
            z = false;
        }
        if (this.gHV != null) {
            this.gHV.setPraiseEnable(z);
        }
    }

    public void az(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gHV == null) {
                this.gHV = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.gHV.setOnDoubleClickListener(this.gHY);
            if (this.gHV.getParent() != null) {
                ((ViewGroup) this.gHV.getParent()).removeView(this.gHV);
            }
            viewGroup.addView(this.gHV, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bKO() {
        if (this.gHV != null) {
            this.gHV.bKO();
        }
    }

    public void Fb() {
        MessageManager.getInstance().unRegisterListener(this.fPT);
    }

    public View getView() {
        return this.gHV;
    }
}
