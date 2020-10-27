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
    private ViewGroup bEg;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c gzs;
    public String otherParams;
    private String gzt = "";
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.bEg != null && c.this.bEg.indexOfChild(c.this.gzs.getView()) >= 0) {
                c.this.bEg.removeView(c.this.gzs.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.gzt));
            }
        }
    };
    CustomMessageListener gpA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.gpA);
    }

    protected boolean am(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gzs == null) {
            this.gzs = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.fcr);
        }
        if (this.bEg != null && this.bEg.indexOfChild(this.gzs.getView()) >= 0) {
            this.bEg.removeView(this.gzs.getView());
        }
        this.bEg = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.gzs == null) {
            return null;
        }
        return this.gzs.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && am(viewGroup)) {
            this.bEg.addView(this.gzs.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.bEg != null && c.this.bEg.indexOfChild(c.this.gzs.getView()) >= 0) {
                        c.this.bEg.removeView(c.this.gzs.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Kj() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.bEg != null && this.gzs != null && this.bEg.indexOfChild(this.gzs.getView()) >= 0) {
            this.bEg.removeView(this.gzs.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gpA);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
