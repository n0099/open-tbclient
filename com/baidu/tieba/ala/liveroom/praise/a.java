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
    private DetailPraiseView gcN;
    private b gcO;
    private boolean gcP;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a gcQ = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bFS() {
            if (a.this.gcO != null) {
                a.this.gcO.l(a.this.gcN, 12);
            }
        }
    };
    private CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.fnT.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fnT);
    }

    public void b(b bVar) {
        this.gcO = bVar;
    }

    public void ll(boolean z) {
        if (this.gcP && z) {
            z = false;
        }
        if (this.gcN != null) {
            this.gcN.setShowPraise(z);
        }
    }

    public void lm(boolean z) {
        this.gcP = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.gcP && z) {
            z = false;
        }
        if (this.gcN != null) {
            this.gcN.setPraiseEnable(z);
        }
    }

    public void au(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gcN == null) {
                this.gcN = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.gcN.setOnDoubleClickListener(this.gcQ);
            if (this.gcN.getParent() != null) {
                ((ViewGroup) this.gcN.getParent()).removeView(this.gcN);
            }
            viewGroup.addView(this.gcN, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bvg() {
        if (this.gcN != null) {
            this.gcN.bvg();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    public View getView() {
        return this.gcN;
    }
}
