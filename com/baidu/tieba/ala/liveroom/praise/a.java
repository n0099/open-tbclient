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
    private DetailPraiseView hsh;
    private b hsi;
    private boolean hsj;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a hsk = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void cgZ() {
            if (a.this.hsi != null) {
                a.this.hsi.p(a.this.hsh, 12);
            }
        }
    };
    private CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.gvo.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.gvo);
    }

    public void b(b bVar) {
        this.hsi = bVar;
    }

    public void nI(boolean z) {
        if (this.hsj && z) {
            z = false;
        }
        if (this.hsh != null) {
            this.hsh.setShowPraise(z);
        }
    }

    public void nJ(boolean z) {
        this.hsj = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.hsj && z) {
            z = false;
        }
        if (this.hsh != null) {
            this.hsh.setPraiseEnable(z);
        }
    }

    public void aE(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.hsh == null) {
                this.hsh = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.hsh.setOnDoubleClickListener(this.hsk);
            if (this.hsh.getParent() != null) {
                ((ViewGroup) this.hsh.getParent()).removeView(this.hsh);
            }
            viewGroup.addView(this.hsh, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bTM() {
        if (this.hsh != null) {
            this.hsh.bTM();
        }
    }

    public void Ht() {
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }

    public View getView() {
        return this.hsh;
    }
}
