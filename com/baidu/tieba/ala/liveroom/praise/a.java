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
    private DetailPraiseView gLw;
    private b gLx;
    private boolean gLy;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a gLz = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bXS() {
            if (a.this.gLx != null) {
                a.this.gLx.n(a.this.gLw, 12);
            }
        }
    };
    private CustomMessageListener fTe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.fTe.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fTe);
    }

    public void b(b bVar) {
        this.gLx = bVar;
    }

    public void mG(boolean z) {
        if (this.gLy && z) {
            z = false;
        }
        if (this.gLw != null) {
            this.gLw.setShowPraise(z);
        }
    }

    public void mH(boolean z) {
        this.gLy = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.gLy && z) {
            z = false;
        }
        if (this.gLw != null) {
            this.gLw.setPraiseEnable(z);
        }
    }

    public void aA(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gLw == null) {
                this.gLw = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.gLw.setOnDoubleClickListener(this.gLz);
            if (this.gLw.getParent() != null) {
                ((ViewGroup) this.gLw.getParent()).removeView(this.gLw);
            }
            viewGroup.addView(this.gLw, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bLY() {
        if (this.gLw != null) {
            this.gLw.bLY();
        }
    }

    public void FB() {
        MessageManager.getInstance().unRegisterListener(this.fTe);
    }

    public View getView() {
        return this.gLw;
    }
}
