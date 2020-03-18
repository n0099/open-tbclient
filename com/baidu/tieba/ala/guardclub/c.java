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
    protected com.baidu.tieba.ala.guardclub.view.c eEJ;
    private ViewGroup ewN;
    public String otherParams;
    private String eEK = "";
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ewN != null && c.this.ewN.indexOfChild(c.this.eEJ.getView()) >= 0) {
                c.this.ewN.removeView(c.this.eEJ.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.eEK));
            }
        }
    };
    CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.ewu);
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eEJ == null) {
            this.eEJ = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.drJ);
        }
        if (this.ewN != null && this.ewN.indexOfChild(this.eEJ.getView()) >= 0) {
            this.ewN.removeView(this.eEJ.getView());
        }
        this.ewN = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.eEJ == null) {
            return null;
        }
        return this.eEJ.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
            this.ewN.addView(this.eEJ.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ewN != null && c.this.ewN.indexOfChild(c.this.eEJ.getView()) >= 0) {
                        c.this.ewN.removeView(c.this.eEJ.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void vQ() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.ewN != null && this.eEJ != null && this.ewN.indexOfChild(this.eEJ.getView()) >= 0) {
            this.ewN.removeView(this.eEJ.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.ewu);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
