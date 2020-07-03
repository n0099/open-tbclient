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
    private ViewGroup fIb;
    protected com.baidu.tieba.ala.guardclub.view.c fIm;
    public String otherParams;
    private String fIn = "";
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.fIb != null && c.this.fIb.indexOfChild(c.this.fIm.getView()) >= 0) {
                c.this.fIb.removeView(c.this.fIm.getView());
            }
            if (ViewHelper.checkUpIsLogin(c.this.context)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913106, c.this.fIn));
            }
        }
    };
    CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.guardclub.c.3
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
        MessageManager.getInstance().registerListener(this.fzr);
    }

    protected boolean ah(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        if (this.fIm == null) {
            this.fIm = new com.baidu.tieba.ala.guardclub.view.c(this.context, this.eoP);
        }
        if (this.fIb != null && this.fIb.indexOfChild(this.fIm.getView()) >= 0) {
            this.fIb.removeView(this.fIm.getView());
        }
        this.fIb = viewGroup;
        return true;
    }

    @Override // com.baidu.live.guardclub.j
    public View getView() {
        if (this.fIm == null) {
            return null;
        }
        return this.fIm.getView();
    }

    @Override // com.baidu.live.guardclub.j
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if ((TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isPopupWindowUnabled()) && ah(viewGroup)) {
            this.fIb.addView(this.fIm.getView(), layoutParams);
            this.handler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.guardclub.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.fIb != null && c.this.fIb.indexOfChild(c.this.fIm.getView()) >= 0) {
                        c.this.fIb.removeView(c.this.fIm.getView());
                    }
                }
            }, 10000L);
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void Cl() {
        this.handler.removeCallbacksAndMessages(null);
        if (this.fIb != null && this.fIm != null && this.fIb.indexOfChild(this.fIm.getView()) >= 0) {
            this.fIb.removeView(this.fIm.getView());
        }
    }

    @Override // com.baidu.live.guardclub.j
    public void onDestroy() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fzr);
    }

    @Override // com.baidu.live.guardclub.j
    public void setOtherParams(String str) {
        this.otherParams = str;
    }
}
