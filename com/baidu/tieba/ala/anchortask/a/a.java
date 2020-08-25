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
import com.baidu.live.data.bl;
import com.baidu.live.data.r;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a implements com.baidu.live.b.a {
    private r aEt;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a fNA;
    private com.baidu.tieba.ala.anchortask.b.b fNB;
    private String fNC;
    private int fNE;
    private int fNF;
    private Handler handler = new Handler();
    private boolean fND = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bHe();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.fNC)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.fNC));
            }
            a.this.bHe();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener fNG = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.fNA != null) {
                a.this.fNB = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).fNB;
                if (a.this.fNB != null && a.this.fNB.fOd != null) {
                    a.this.fNC = a.this.fNB.fNC;
                    a.this.bHf();
                    a.this.fNA.a(a.this.fNB.fOd);
                    if (a.this.fNB.fOd.fNR == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.fNA = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.fNA.getView() != null) {
            this.fNA.getView().setOnClickListener(this.eFC);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bl blVar = com.baidu.live.w.a.Nk().bka.aJI;
        if (blVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (blVar.aKi != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (blVar.aKj != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (blVar.aKk != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (blVar.aKl != 1) {
                z = false;
            }
            if (z) {
                if (this.fNA != null) {
                    viewGroup.addView(this.fNA.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(r rVar) {
        this.aEt = rVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fNG);
    }

    public void bHe() {
        if (this.aEt != null) {
            long j = this.aEt.mLiveInfo.live_id;
            long j2 = this.aEt.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.ag(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHf() {
        if (this.fNB != null && this.fNB.fOd != null) {
            if (!this.fND) {
                this.fND = true;
                this.fNE = this.fNB.fOd.fNP;
                this.fNF = this.fNB.fOd.fNQ;
            }
            int i = this.fNB.fOd.fNR;
            int i2 = this.fNB.fOd.fNS;
            int i3 = this.fNB.fOd.fNT;
            String str = null;
            if (this.fNE == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.fNE == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.fNE == 1 && i == 1) {
                if (i2 > this.fNF) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.fNF) {
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
            this.fNE = i;
            this.fNF = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.fNA != null) {
            this.fNA.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.fNA != null) {
            this.fNA.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fNG);
        if (this.fNA != null) {
            this.fNA.onDestroy();
        }
    }
}
