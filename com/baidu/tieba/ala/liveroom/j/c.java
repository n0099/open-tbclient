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
/* loaded from: classes2.dex */
public class c {
    protected d eWa;
    private ViewGroup eqG;
    protected TbPageContext mTbPageContext;
    public String otherParams;
    private String ezj = "";
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.j.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.eqG != null && c.this.eqG.indexOfChild(c.this.eWa.getView()) >= 0) {
                c.this.eqG.removeView(c.this.eWa.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.ezj));
            }
        }
    };
    CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.j.c.3
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
        MessageManager.getInstance().registerListener(this.eqn);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean ab(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eWa == null) {
            this.eWa = new d(getPageContext(), this.dmK);
        }
        if (this.eqG != null && this.eqG.indexOfChild(this.eWa.getView()) >= 0) {
            this.eqG.removeView(this.eWa.getView());
        }
        this.eqG = viewGroup;
        return true;
    }

    public View getView() {
        if (this.eWa == null) {
            return null;
        }
        return this.eWa.getView();
    }

    public void e(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ab(viewGroup)) {
            this.eqG.addView(this.eWa.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.eqG != null && c.this.eqG.indexOfChild(c.this.eWa.getView()) >= 0) {
                        c.this.eqG.removeView(c.this.eWa.getView());
                    }
                }
            }, 10000L);
        }
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.eqn);
    }
}
