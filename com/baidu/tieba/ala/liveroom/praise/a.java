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
    private DetailPraiseView guT;
    private b guU;
    private boolean guV;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a guW = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bMf() {
            if (a.this.guU != null) {
                a.this.guU.m(a.this.guT, 12);
            }
        }
    };
    private CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.fEy.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fEy);
    }

    public void b(b bVar) {
        this.guU = bVar;
    }

    public void lW(boolean z) {
        if (this.guV && z) {
            z = false;
        }
        if (this.guT != null) {
            this.guT.setShowPraise(z);
        }
    }

    public void lX(boolean z) {
        this.guV = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.guV && z) {
            z = false;
        }
        if (this.guT != null) {
            this.guT.setPraiseEnable(z);
        }
    }

    public void ay(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.guT == null) {
                this.guT = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.guT.setOnDoubleClickListener(this.guW);
            if (this.guT.getParent() != null) {
                ((ViewGroup) this.guT.getParent()).removeView(this.guT);
            }
            viewGroup.addView(this.guT, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bBt() {
        if (this.guT != null) {
            this.guT.bBt();
        }
    }

    public void zy() {
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }

    public View getView() {
        return this.guT;
    }
}
