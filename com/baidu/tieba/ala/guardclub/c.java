package com.baidu.tieba.ala.guardclub;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
/* loaded from: classes3.dex */
public class c implements com.baidu.live.guardclub.j {
    protected Context context;
    private ViewGroup fox;
    protected com.baidu.tieba.ala.guardclub.view.c fwQ;
    public String otherParams;
    private String fwR = "";
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.fox != null && c.this.fox.indexOfChild(c.this.fwQ.getView()) >= 0) {
                c.this.fox.removeView(c.this.fwQ.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.fwR));
            }
        }
    };
    CustomMessageListener fnT = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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

    public c(Context context) {
        this.context = context;
        MessageManager.getInstance().registerListener(this.fnT);
    }

    protected boolean af(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fwQ == null) {
            this.fwQ = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.ege);
        }
        if (this.fox != null && this.fox.indexOfChild(this.fwQ.getView()) >= 0) {
            this.fox.removeView(this.fwQ.getView());
        }
        this.fox = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.fwQ == null) {
            return null;
        }
        return this.fwQ.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && af(viewGroup)) {
            this.fox.addView(this.fwQ.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fox != null && c.this.fox.indexOfChild(c.this.fwQ.getView()) >= 0) {
                        c.this.fox.removeView(c.this.fwQ.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void BL() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.fox != null && this.fwQ != null && this.fox.indexOfChild(this.fwQ.getView()) >= 0) {
            this.fox.removeView(this.fwQ.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fnT);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
