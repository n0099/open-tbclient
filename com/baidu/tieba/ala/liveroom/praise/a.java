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
    private DetailPraiseView hPk;
    private b hPl;
    private boolean hPm;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hPn = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void ckw() {
            if (a.this.hPl != null) {
                a.this.hPl.v(a.this.hPk, 12);
            }
        }
    };
    private CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gPp.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gPp);
    }

    public void b(b bVar) {
        this.hPl = bVar;
    }

    public void oJ(boolean z) {
        if (this.hPm && z) {
            z = false;
        }
        if (this.hPk != null) {
            this.hPk.setShowPraise(z);
        }
    }

    public void oK(boolean z) {
        this.hPm = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hPm && z) {
            z = false;
        }
        if (this.hPk != null) {
            this.hPk.setPraiseEnable(z);
        }
    }

    public void aM(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hPk == null) {
                this.hPk = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hPk.setOnDoubleClickListener(this.hPn);
            if (this.hPk.getParent() != null) {
                ((ViewGroup) this.hPk.getParent()).removeView(this.hPk);
            }
            viewGroup.addView(this.hPk, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bWv() {
        if (this.hPk != null) {
            this.hPk.bWv();
        }
    }

    public void FB() {
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }

    public View getView() {
        return this.hPk;
    }
}
