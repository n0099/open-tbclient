package com.baidu.tieba.ala.liveroom.j;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
/* loaded from: classes6.dex */
public class c {
    private ViewGroup dYV;
    protected d egY;
    protected TbPageContext mTbPageContext;
    public String otherParams;
    private String dLK = "";
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dYV != null && c.this.dYV.indexOfChild(c.this.egY.getView()) >= 0) {
                c.this.dYV.removeView(c.this.egY.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.dLK));
            }
        }
    };
    CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.c.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                c.this.otherParams = str;
            }
        }
    };
    private Handler handler = new Handler();

    public c(TbPageContext tbPageContext, String str) {
        this.mTbPageContext = tbPageContext;
        this.otherParams = str;
        MessageManager.getInstance().registerListener(this.dFq);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ac(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.egY == null) {
            this.egY = new d(getPageContext(), this.czV);
        }
        if (this.dYV != null && this.dYV.indexOfChild(this.egY.getView()) >= 0) {
            this.dYV.removeView(this.egY.getView());
        }
        this.dYV = viewGroup;
        return true;
    }

    public View getView() {
        if (this.egY == null) {
            return null;
        }
        return this.egY.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ac(viewGroup)) {
            this.dYV.addView(this.egY.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.dYV != null && c.this.dYV.indexOfChild(c.this.egY.getView()) >= 0) {
                        c.this.dYV.removeView(c.this.egY.getView());
                    }
                }
            }, 10000L);
        }
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.dFq);
    }
}
