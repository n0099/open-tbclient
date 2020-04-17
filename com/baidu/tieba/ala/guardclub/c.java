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
    private ViewGroup faQ;
    protected com.baidu.tieba.ala.guardclub.view.c fje;
    public String otherParams;
    private String fjf = "";
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.faQ != null && c.this.faQ.indexOfChild(c.this.fje.getView()) >= 0) {
                c.this.faQ.removeView(c.this.fje.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.fjf));
            }
        }
    };
    CustomMessageListener fal = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.fal);
    }

    protected boolean Y(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fje == null) {
            this.fje = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.dRF);
        }
        if (this.faQ != null && this.faQ.indexOfChild(this.fje.getView()) >= 0) {
            this.faQ.removeView(this.fje.getView());
        }
        this.faQ = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.fje == null) {
            return null;
        }
        return this.fje.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && Y(viewGroup)) {
            this.faQ.addView(this.fje.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.faQ != null && c.this.faQ.indexOfChild(c.this.fje.getView()) >= 0) {
                        c.this.faQ.removeView(c.this.fje.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Aw() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.faQ != null && this.fje != null && this.faQ.indexOfChild(this.fje.getView()) >= 0) {
            this.faQ.removeView(this.fje.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fal);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
