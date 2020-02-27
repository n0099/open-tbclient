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
    protected com.baidu.tieba.ala.guardclub.view.c eDZ;
    private ViewGroup ewd;
    public String otherParams;
    private String eEa = "";
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.ewd != null && c.this.ewd.indexOfChild(c.this.eDZ.getView()) >= 0) {
                c.this.ewd.removeView(c.this.eDZ.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.eEa));
            }
        }
    };
    CustomMessageListener evK = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.evK);
    }

    protected boolean X(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.eDZ == null) {
            this.eDZ = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.drh);
        }
        if (this.ewd != null && this.ewd.indexOfChild(this.eDZ.getView()) >= 0) {
            this.ewd.removeView(this.eDZ.getView());
        }
        this.ewd = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.eDZ == null) {
            return null;
        }
        return this.eDZ.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && X(viewGroup)) {
            this.ewd.addView(this.eDZ.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.ewd != null && c.this.ewd.indexOfChild(c.this.eDZ.getView()) >= 0) {
                        c.this.ewd.removeView(c.this.eDZ.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void vL() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.ewd != null && this.eDZ != null && this.ewd.indexOfChild(this.eDZ.getView()) >= 0) {
            this.ewd.removeView(this.eDZ.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.evK);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
