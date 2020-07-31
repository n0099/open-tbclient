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
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c fNH;
    private ViewGroup fNw;
    public String otherParams;
    private String fNI = "";
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.fNw != null && c.this.fNw.indexOfChild(c.this.fNH.getView()) >= 0) {
                c.this.fNw.removeView(c.this.fNH.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.fNI));
            }
        }
    };
    CustomMessageListener fEy = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.fEy);
    }

    protected boolean ai(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fNH == null) {
            this.fNH = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.eve);
        }
        if (this.fNw != null && this.fNw.indexOfChild(this.fNH.getView()) >= 0) {
            this.fNw.removeView(this.fNH.getView());
        }
        this.fNw = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.fNH == null) {
            return null;
        }
        return this.fNH.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ai(viewGroup)) {
            this.fNw.addView(this.fNH.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fNw != null && c.this.fNw.indexOfChild(c.this.fNH.getView()) >= 0) {
                        c.this.fNw.removeView(c.this.fNH.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void CN() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.fNw != null && this.fNH != null && this.fNw.indexOfChild(this.fNH.getView()) >= 0) {
            this.fNw.removeView(this.fNH.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fEy);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
