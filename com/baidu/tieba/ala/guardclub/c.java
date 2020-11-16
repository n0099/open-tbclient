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
public class c implements com.baidu.live.guardclub.j {
    private ViewGroup bIc;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c gEN;
    public String otherParams;
    private String gEO = "";
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bIc != null && c.this.bIc.indexOfChild(c.this.gEN.getView()) >= 0) {
                c.this.bIc.removeView(c.this.gEN.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.gEO));
            }
        }
    };
    CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.guV);
    }

    protected boolean ak(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gEN == null) {
            this.gEN = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.fhp);
        }
        if (this.bIc != null && this.bIc.indexOfChild(this.gEN.getView()) >= 0) {
            this.bIc.removeView(this.gEN.getView());
        }
        this.bIc = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.gEN == null) {
            return null;
        }
        return this.gEN.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ak(viewGroup)) {
            this.bIc.addView(this.gEN.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bIc != null && c.this.bIc.indexOfChild(c.this.gEN.getView()) >= 0) {
                        c.this.bIc.removeView(c.this.gEN.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Ka() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.bIc != null && this.gEN != null && this.bIc.indexOfChild(this.gEN.getView()) >= 0) {
            this.bIc.removeView(this.gEN.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.guV);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
