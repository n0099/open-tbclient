package com.baidu.tieba.ala.liveroom.praise;

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
    private DetailPraiseView fOD;
    private b fOE;
    private DetailPraiseView.a fOF = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bzL() {
            if (a.this.fOE != null) {
                a.this.fOE.l(a.this.fOD, 12);
            }
        }
    };
    private CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
    private TbPageContext mTbPageContext;
    private String otherParams;

    public a(TbPageContext tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.fal.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.fal);
    }

    public void b(b bVar) {
        this.fOE = bVar;
    }

    public void kQ(boolean z) {
        if (this.fOD != null) {
            this.fOD.setShowPraise(z);
        }
    }

    public void setPraiseEnable(boolean z) {
        if (this.fOD != null) {
            this.fOD.setPraiseEnable(z);
        }
    }

    public void an(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.fOD == null) {
                this.fOD = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.fOD.setOnDoubleClickListener(this.fOF);
            if (this.fOD.getParent() != null) {
                ((ViewGroup) this.fOD.getParent()).removeView(this.fOD);
            }
            viewGroup.addView(this.fOD, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bpr() {
        if (this.fOD != null) {
            this.fOD.bpr();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.fal);
    }
}
