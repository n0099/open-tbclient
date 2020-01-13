package com.baidu.tieba.ala.liveroom.l;

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
    protected d eYA;
    private ViewGroup erT;
    protected TbPageContext mTbPageContext;
    public String otherParams;
    private String eAu = "";
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.l.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.erT != null && c.this.erT.indexOfChild(c.this.eYA.getView()) >= 0) {
                c.this.erT.removeView(c.this.eYA.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.mTbPageContext.getPageActivity())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.eAu));
            }
        }
    };
    CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.l.c.3
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
        MessageManager.getInstance().registerListener(this.erA);
    }

    private TbPageContext getPageContext() {
        return this.mTbPageContext;
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eYA == null) {
            this.eYA = new d(getPageContext(), this.dmY);
        }
        if (this.erT != null && this.erT.indexOfChild(this.eYA.getView()) >= 0) {
            this.erT.removeView(this.eYA.getView());
        }
        this.erT = viewGroup;
        return true;
    }

    public View getView() {
        if (this.eYA == null) {
            return null;
        }
        return this.eYA.getView();
    }

    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && af(viewGroup)) {
            this.erT.addView(this.eYA.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.l.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.erT != null && c.this.erT.indexOfChild(c.this.eYA.getView()) >= 0) {
                        c.this.erT.removeView(c.this.eYA.getView());
                    }
                }
            }, 10000L);
        }
    }

    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.erA);
    }
}
