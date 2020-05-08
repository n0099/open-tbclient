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
    private ViewGroup faV;
    protected com.baidu.tieba.ala.guardclub.view.c fjj;
    public String otherParams;
    private String fjk = "";
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.faV != null && c.this.faV.indexOfChild(c.this.fjj.getView()) >= 0) {
                c.this.faV.removeView(c.this.fjj.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.fjk));
            }
        }
    };
    CustomMessageListener faq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.faq);
    }

    protected boolean Y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fjj == null) {
            this.fjj = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.dRK);
        }
        if (this.faV != null && this.faV.indexOfChild(this.fjj.getView()) >= 0) {
            this.faV.removeView(this.fjj.getView());
        }
        this.faV = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.fjj == null) {
            return null;
        }
        return this.fjj.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && Y(viewGroup)) {
            this.faV.addView(this.fjj.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.faV != null && c.this.faV.indexOfChild(c.this.fjj.getView()) >= 0) {
                        c.this.faV.removeView(c.this.fjj.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Av() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.faV != null && this.fjj != null && this.faV.indexOfChild(this.fjj.getView()) >= 0) {
            this.faV.removeView(this.fjj.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.faq);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
