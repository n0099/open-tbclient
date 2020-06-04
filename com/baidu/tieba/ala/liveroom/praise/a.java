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
    private DetailPraiseView gcY;
    private b gcZ;
    private boolean gda;
    private TbPageContext mTbPageContext;
    private String otherParams;
    private DetailPraiseView.a gdb = new DetailPraiseView.a() { // from class: com.baidu.tieba.ala.liveroom.praise.a.1
        @Override // com.baidu.tieba.ala.liveroom.praise.DetailPraiseView.a
        public void bFU() {
            if (a.this.gcZ != null) {
                a.this.gcZ.l(a.this.gcY, 12);
            }
        }
    };
    private CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.praise.a.2
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
        this.foe.setTag(this.mTbPageContext.getUniqueId());
        MessageManager.getInstance().registerListener(this.foe);
    }

    public void b(b bVar) {
        this.gcZ = bVar;
    }

    public void ll(boolean z) {
        if (this.gda && z) {
            z = false;
        }
        if (this.gcY != null) {
            this.gcY.setShowPraise(z);
        }
    }

    public void lm(boolean z) {
        this.gda = z;
    }

    public void setPraiseEnable(boolean z) {
        if (this.gda && z) {
            z = false;
        }
        if (this.gcY != null) {
            this.gcY.setPraiseEnable(z);
        }
    }

    public void au(ViewGroup viewGroup) {
        if (viewGroup != null && this.mTbPageContext != null) {
            if (this.gcY == null) {
                this.gcY = new DetailPraiseView(this.mTbPageContext.getPageActivity());
            }
            this.gcY.setOnDoubleClickListener(this.gdb);
            if (this.gcY.getParent() != null) {
                ((ViewGroup) this.gcY.getParent()).removeView(this.gcY);
            }
            viewGroup.addView(this.gcY, 0, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public void bvi() {
        if (this.gcY != null) {
            this.gcY.bvi();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.foe);
    }

    public View getView() {
        return this.gcY;
    }
}
