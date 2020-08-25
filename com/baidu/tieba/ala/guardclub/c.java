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
/* loaded from: classes7.dex */
public class c implements com.baidu.live.guardclub.j {
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c fZF;
    private ViewGroup fZu;
    public String otherParams;
    private String fZG = "";
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.fZu != null && c.this.fZu.indexOfChild(c.this.fZF.getView()) >= 0) {
                c.this.fZu.removeView(c.this.fZF.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.fZG));
            }
        }
    };
    CustomMessageListener fPP = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.fPP);
    }

    protected boolean aj(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fZF == null) {
            this.fZF = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.eFC);
        }
        if (this.fZu != null && this.fZu.indexOfChild(this.fZF.getView()) >= 0) {
            this.fZu.removeView(this.fZF.getView());
        }
        this.fZu = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.fZF == null) {
            return null;
        }
        return this.fZF.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && aj(viewGroup)) {
            this.fZu.addView(this.fZF.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fZu != null && c.this.fZu.indexOfChild(c.this.fZF.getView()) >= 0) {
                        c.this.fZu.removeView(c.this.fZF.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Iq() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.fZu != null && this.fZF != null && this.fZu.indexOfChild(this.fZF.getView()) >= 0) {
            this.fZu.removeView(this.fZF.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fPP);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
