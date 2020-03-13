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
    protected com.baidu.tieba.ala.guardclub.view.c eEn;
    private ViewGroup ewr;
    public String otherParams;
    private String eEo = "";
    private View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ewr != null && c.this.ewr.indexOfChild(c.this.eEn.getView()) >= 0) {
                c.this.ewr.removeView(c.this.eEn.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.eEo));
            }
        }
    };
    CustomMessageListener evY = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.evY);
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eEn == null) {
            this.eEn = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.drw);
        }
        if (this.ewr != null && this.ewr.indexOfChild(this.eEn.getView()) >= 0) {
            this.ewr.removeView(this.eEn.getView());
        }
        this.ewr = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.eEn == null) {
            return null;
        }
        return this.eEn.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
            this.ewr.addView(this.eEn.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ewr != null && c.this.ewr.indexOfChild(c.this.eEn.getView()) >= 0) {
                        c.this.ewr.removeView(c.this.eEn.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void vL() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.ewr != null && this.eEn != null && this.ewr.indexOfChild(this.eEn.getView()) >= 0) {
            this.ewr.removeView(this.eEn.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.evY);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
