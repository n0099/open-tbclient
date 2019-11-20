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
    private ViewGroup dYe;
    protected d egh;
    protected TbPageContext mTbPageContext;
    public String otherParams;
    private String dKT = "";
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.dYe != null && c.this.dYe.indexOfChild(c.this.egh.getView()) >= 0) {
                c.this.dYe.removeView(c.this.egh.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.dKT));
            }
        }
    };
    CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.c.3
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
        MessageManager.getInstance().registerListener(this.dEz);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ac(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.egh == null) {
            this.egh = new d(getPageContext(), this.cze);
        }
        if (this.dYe != null && this.dYe.indexOfChild(this.egh.getView()) >= 0) {
            this.dYe.removeView(this.egh.getView());
        }
        this.dYe = viewGroup;
        return true;
    }

    public View getView() {
        if (this.egh == null) {
            return null;
        }
        return this.egh.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ac(viewGroup)) {
            this.dYe.addView(this.egh.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.dYe != null && c.this.dYe.indexOfChild(c.this.egh.getView()) >= 0) {
                        c.this.dYe.removeView(c.this.egh.getView());
                    }
                }
            }, 10000L);
        }
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.dEz);
    }
}
