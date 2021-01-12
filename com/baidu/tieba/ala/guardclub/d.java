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
    private ViewGroup bNl;
    protected Context context;
    protected com.baidu.tieba.ala.guardclub.view.c gUU;
    public String otherParams;
    private String gUV = "";
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.this.bNl != null && d.this.bNl.indexOfChild(d.this.gUU.getView()) >= 0) {
                d.this.bNl.removeView(d.this.gUU.getView());
            }
            if (ViewHelper.checkUpIsLogin(d.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, d.this.gUV));
            }
        }
    };
    CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.d.3
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
        MessageManager.getInstance().registerListener(this.gKM);
    }

    protected boolean aw(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.gUU == null) {
            this.gUU = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.onClickListener);
        }
        if (this.bNl != null && this.bNl.indexOfChild(this.gUU.getView()) >= 0) {
            this.bNl.removeView(this.gUU.getView());
        }
        this.bNl = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.gUU == null) {
            return null;
        }
        return this.gUU.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && aw(viewGroup)) {
            this.bNl.addView(this.gUU.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.bNl != null && d.this.bNl.indexOfChild(d.this.gUU.getView()) >= 0) {
                        d.this.bNl.removeView(d.this.gUU.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void xk() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.bNl != null && this.gUU != null && this.bNl.indexOfChild(this.gUU.getView()) >= 0) {
            this.bNl.removeView(this.gUU.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gKM);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
