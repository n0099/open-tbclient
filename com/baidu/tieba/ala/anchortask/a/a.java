package com.baidu.tieba.ala.anchortask.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.data.at;
import com.baidu.live.data.l;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.b.a {
    private l WE;
    private Context context;
    private String eqA;
    private int eqC;
    private int eqD;
    private com.baidu.tieba.ala.anchortask.c.a eqy;
    private com.baidu.tieba.ala.anchortask.b.b eqz;
    private Handler handler = new Handler();
    private boolean eqB = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bbn();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.eqA != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.eqA));
            }
            a.this.bbn();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener eqE = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.eqy != null) {
                a.this.eqz = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).eqz;
                if (a.this.eqz != null && a.this.eqz.erc != null) {
                    a.this.eqA = a.this.eqz.eqA;
                    a.this.bbo();
                    a.this.eqy.a(a.this.eqz.erc);
                    if (a.this.eqz.erc.eqQ == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.eqy = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.eqy.getView() != null) {
            this.eqy.getView().setOnClickListener(this.dmY);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        at atVar = com.baidu.live.s.a.wR().atk.abf;
        if (atVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (atVar.aby != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (atVar.abz != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (atVar.abA != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (atVar.abB != 1) {
                z = false;
            }
            if (z) {
                if (this.eqy != null) {
                    viewGroup.addView(this.eqy.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(l lVar) {
        this.WE = lVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.eqE);
    }

    public void bbn() {
        if (this.WE != null) {
            long j = this.WE.mLiveInfo.live_id;
            long j2 = this.WE.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.cz(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbo() {
        if (this.eqz != null && this.eqz.erc != null) {
            if (!this.eqB) {
                this.eqB = true;
                this.eqC = this.eqz.erc.eqO;
                this.eqD = this.eqz.erc.eqP;
            }
            int i = this.eqz.erc.eqQ;
            int i2 = this.eqz.erc.eqR;
            int i3 = this.eqz.erc.eqS;
            String str = null;
            if (this.eqC == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.eqC == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.eqC == 1 && i == 1) {
                if (i2 > this.eqD) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.eqD) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913143, str));
            }
            this.eqC = i;
            this.eqD = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.eqE);
        if (this.eqy != null) {
            this.eqy.onDestroy();
        }
    }
}
