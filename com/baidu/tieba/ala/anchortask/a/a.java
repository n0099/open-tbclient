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
import com.baidu.live.data.ap;
import com.baidu.live.data.k;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
/* loaded from: classes2.dex */
public class a implements com.baidu.live.b.a {
    private Context context;
    private k epl;
    private com.baidu.tieba.ala.anchortask.c.a epm;
    private com.baidu.tieba.ala.anchortask.b.b epn;
    private String epo;
    private int epq;
    private int epr;
    private Handler handler = new Handler();
    private boolean epp = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.baS();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.epo != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.epo));
            }
            a.this.baS();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener eps = new HttpMessageListener(1021167) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.epm != null) {
                a.this.epn = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).epn;
                if (a.this.epn != null && a.this.epn.epQ != null) {
                    a.this.epo = a.this.epn.epo;
                    a.this.baT();
                    a.this.epm.a(a.this.epn.epQ);
                    if (a.this.epn.epQ.epE == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.epm = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.epm.getView() != null) {
            this.epm.getView().setOnClickListener(this.dmK);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        ap apVar = com.baidu.live.r.a.wA().asy.aaR;
        if (apVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (apVar.abm != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (apVar.abn != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (apVar.abo != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (apVar.abp != 1) {
                z = false;
            }
            if (z) {
                if (this.epm != null) {
                    viewGroup.addView(this.epm.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(k kVar) {
        this.epl = kVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021167, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.eps);
    }

    public void baS() {
        if (this.epl != null) {
            long j = this.epl.mLiveInfo.live_id;
            long j2 = this.epl.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.cu(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baT() {
        if (this.epn != null && this.epn.epQ != null) {
            if (!this.epp) {
                this.epp = true;
                this.epq = this.epn.epQ.epC;
                this.epr = this.epn.epQ.epD;
            }
            int i = this.epn.epQ.epE;
            int i2 = this.epn.epQ.epF;
            int i3 = this.epn.epQ.epG;
            String str = null;
            if (this.epq == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.epq == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.epq == 1 && i == 1) {
                if (i2 > this.epr) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.epr) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913143, str));
            }
            this.epq = i;
            this.epr = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.eps);
        if (this.epm != null) {
            this.epm.onDestroy();
        }
    }
}
