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
import com.baidu.live.data.bs;
import com.baidu.live.data.u;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.a.a {
    private u alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a fQS;
    private com.baidu.tieba.ala.anchortask.b.b fQT;
    private String fQU;
    private int fQW;
    private int fQX;
    private Handler handler = new Handler();
    private boolean fQV = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bIv();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.fQU)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.fQU));
            }
            a.this.bIv();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener fQY = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.fQS != null) {
                a.this.fQT = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).fQT;
                if (a.this.fQT != null && a.this.fQT.fRs != null) {
                    a.this.fQU = a.this.fQT.fQU;
                    a.this.bIw();
                    a.this.fQS.a(a.this.fQT.fRs);
                    if (a.this.fQT.fRs.fRg == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.fQS = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.fQS.getView() != null) {
            this.fQS.getView().setOnClickListener(this.eHN);
        }
    }

    @Override // com.baidu.live.a.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bs bsVar = com.baidu.live.x.a.NN().bmW.aLa;
        if (bsVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (bsVar.aLN != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (bsVar.aLO != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (bsVar.aLP != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (bsVar.aLQ != 1) {
                z = false;
            }
            if (z) {
                if (this.fQS != null) {
                    viewGroup.addView(this.fQS.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.a.a
    public void a(u uVar) {
        this.alaLiveShowData = uVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fQY);
    }

    public void bIv() {
        if (this.alaLiveShowData != null) {
            long j = this.alaLiveShowData.mLiveInfo.live_id;
            long j2 = this.alaLiveShowData.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.af(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIw() {
        if (this.fQT != null && this.fQT.fRs != null) {
            if (!this.fQV) {
                this.fQV = true;
                this.fQW = this.fQT.fRs.fRe;
                this.fQX = this.fQT.fRs.fRf;
            }
            int i = this.fQT.fRs.fRg;
            int i2 = this.fQT.fRs.fRh;
            int i3 = this.fQT.fRs.fRi;
            String str = null;
            if (this.fQW == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.fQW == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.fQW == 1 && i == 1) {
                if (i2 > this.fQX) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.fQX) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
                }
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("text", str);
                    jSONObject.put("content_type", "custom_anchor_identity_update");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913143, jSONObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.fQW = i;
            this.fQX = i2;
        }
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.fQS != null) {
            this.fQS.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.a.a
    public void refreshUI() {
        if (this.fQS != null) {
            this.fQS.refreshUI();
        }
    }

    @Override // com.baidu.live.a.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fQY);
        if (this.fQS != null) {
            this.fQS.onDestroy();
        }
    }
}
