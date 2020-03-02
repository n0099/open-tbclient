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
import com.baidu.live.data.av;
import com.baidu.live.data.m;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.b.a {
    private m Yq;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a euK;
    private com.baidu.tieba.ala.anchortask.b.b euL;
    private String euM;
    private int euO;
    private int euP;
    private Handler handler = new Handler();
    private boolean euN = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bdE();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.euM != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.euM));
            }
            a.this.bdE();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener euQ = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.euK != null) {
                a.this.euL = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).euL;
                if (a.this.euL != null && a.this.euL.evo != null) {
                    a.this.euM = a.this.euL.euM;
                    a.this.bdF();
                    a.this.euK.a(a.this.euL.evo);
                    if (a.this.euL.evo.evc == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.euK = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.euK.getView() != null) {
            this.euK.getView().setOnClickListener(this.dri);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        av avVar = com.baidu.live.v.a.zl().axC.adc;
        if (avVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (avVar.adD != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (avVar.adE != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (avVar.adF != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (avVar.adG != 1) {
                z = false;
            }
            if (z) {
                if (this.euK != null) {
                    viewGroup.addView(this.euK.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(m mVar) {
        this.Yq = mVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.euQ);
    }

    public void bdE() {
        if (this.Yq != null) {
            long j = this.Yq.mLiveInfo.live_id;
            long j2 = this.Yq.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.D(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bdF() {
        if (this.euL != null && this.euL.evo != null) {
            if (!this.euN) {
                this.euN = true;
                this.euO = this.euL.evo.eva;
                this.euP = this.euL.evo.evb;
            }
            int i = this.euL.evo.evc;
            int i2 = this.euL.evo.evd;
            int i3 = this.euL.evo.eve;
            String str = null;
            if (this.euO == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.euO == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.euO == 1 && i == 1) {
                if (i2 > this.euP) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.euP) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913143, str));
            }
            this.euO = i;
            this.euP = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.euQ);
        if (this.euK != null) {
            this.euK.onDestroy();
        }
    }
}
