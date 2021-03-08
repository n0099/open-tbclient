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
/* loaded from: classes10.dex */
public class d implements com.baidu.live.guardclub.j {
    private ViewGroup bSB;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c gZB;
    public String otherParams;
    private String gZC = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bSB != null && d.this.bSB.indexOfChild(d.this.gZB.getView()) >= 0) {
                d.this.bSB.removeView(d.this.gZB.getView());
            }
            if (ViewHelper.checkUpIsLogin(d.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, d.this.gZC));
            }
        }
    };
    CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
        MessageManager.getInstance().registerListener(this.gPp);
    }

    protected boolean au(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gZB == null) {
            this.gZB = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.onClickListener);
        }
        if (this.bSB != null && this.bSB.indexOfChild(this.gZB.getView()) >= 0) {
            this.bSB.removeView(this.gZB.getView());
        }
        this.bSB = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.gZB == null) {
            return null;
        }
        return this.gZB.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && au(viewGroup)) {
            this.bSB.addView(this.gZB.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bSB != null && d.this.bSB.indexOfChild(d.this.gZB.getView()) >= 0) {
                        d.this.bSB.removeView(d.this.gZB.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void xk() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.bSB != null && this.gZB != null && this.bSB.indexOfChild(this.gZB.getView()) >= 0) {
            this.bSB.removeView(this.gZB.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gPp);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
