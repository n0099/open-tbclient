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
/* loaded from: classes4.dex */
public class d implements com.baidu.live.guardclub.j {
    private ViewGroup bNk;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c gNL;
    public String otherParams;
    private String gNM = "";
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bNk != null && d.this.bNk.indexOfChild(d.this.gNL.getView()) >= 0) {
                d.this.bNk.removeView(d.this.gNL.getView());
            }
            if (ViewHelper.checkUpIsLogin(d.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, d.this.gNM));
            }
        }
    };
    CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                d.this.otherParams = str;
            }
        }
    };
    private Handler handler = new Handler();

    public d(Context context) {
        this.context = context;
        MessageManager.getInstance().registerListener(this.gDE);
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gNL == null) {
            this.gNL = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.foP);
        }
        if (this.bNk != null && this.bNk.indexOfChild(this.gNL.getView()) >= 0) {
            this.bNk.removeView(this.gNL.getView());
        }
        this.bNk = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.gNL == null) {
            return null;
        }
        return this.gNL.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ak(viewGroup)) {
            this.bNk.addView(this.gNL.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bNk != null && d.this.bNk.indexOfChild(d.this.gNL.getView()) >= 0) {
                        d.this.bNk.removeView(d.this.gNL.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Do() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.bNk != null && this.gNL != null && this.bNk.indexOfChild(this.gNL.getView()) >= 0) {
            this.bNk.removeView(this.gNL.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gDE);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
