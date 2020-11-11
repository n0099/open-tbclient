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
    private ViewGroup bJN;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c gFg;
    public String otherParams;
    private String gFh = "";
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bJN != null && c.this.bJN.indexOfChild(c.this.gFg.getView()) >= 0) {
                c.this.bJN.removeView(c.this.gFg.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.gFh));
            }
        }
    };
    CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.gvo);
    }

    protected boolean ao(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gFg == null) {
            this.gFg = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.fii);
        }
        if (this.bJN != null && this.bJN.indexOfChild(this.gFg.getView()) >= 0) {
            this.bJN.removeView(this.gFg.getView());
        }
        this.bJN = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.gFg == null) {
            return null;
        }
        return this.gFg.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ao(viewGroup)) {
            this.bJN.addView(this.gFg.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bJN != null && c.this.bJN.indexOfChild(c.this.gFg.getView()) >= 0) {
                        c.this.bJN.removeView(c.this.gFg.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void KJ() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.bJN != null && this.gFg != null && this.bJN.indexOfChild(this.gFg.getView()) >= 0) {
            this.bJN.removeView(this.gFg.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gvo);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
