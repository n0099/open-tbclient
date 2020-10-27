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
import com.baidu.live.data.bx;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.a.a {
    private w alaLiveShowData;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a gno;
    private com.baidu.tieba.ala.anchortask.b.b gnp;
    private String gnq;
    private int gns;
    private int gnt;
    private Handler handler = new Handler();
    private boolean gnr = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bNH();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener fcr = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gnq)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gnq));
            }
            a.this.bNH();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener gnu = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gno != null) {
                a.this.gnp = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gnp;
                if (a.this.gnp != null && a.this.gnp.gnO != null) {
                    a.this.gnq = a.this.gnp.gnq;
                    a.this.bNI();
                    a.this.gno.a(a.this.gnp.gnO);
                    if (a.this.gnp.gnO.gnC == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gno = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gno.getView().setId(a.g.ala_main_anthor_task_entry_id);
        if (this.gno.getView() != null) {
            this.gno.getView().setOnClickListener(this.fcr);
        }
    }

    @Override // com.baidu.live.a.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bx bxVar = com.baidu.live.z.a.Pq().bsy.aOK;
        if (bxVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (bxVar.aPB != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                if (bxVar.aPC != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (bxVar.aPD != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (bxVar.aPE != 1) {
                z = false;
            }
            if (z) {
                if (this.gno != null) {
                    viewGroup.addView(this.gno.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.a.a
    public void a(w wVar) {
        this.alaLiveShowData = wVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.gnu);
    }

    public void bNH() {
        if (this.alaLiveShowData != null) {
            long j = this.alaLiveShowData.mLiveInfo.live_id;
            long j2 = this.alaLiveShowData.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.setAnchorId(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNI() {
        if (this.gnp != null && this.gnp.gnO != null) {
            if (!this.gnr) {
                this.gnr = true;
                this.gns = this.gnp.gnO.gnA;
                this.gnt = this.gnp.gnO.gnB;
            }
            int i = this.gnp.gnO.gnC;
            int i2 = this.gnp.gnO.gnD;
            int i3 = this.gnp.gnO.gnE;
            String str = null;
            if (this.gns == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.gns == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gns == 1 && i == 1) {
                if (i2 > this.gnt) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gnt) {
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
            this.gns = i;
            this.gnt = i2;
        }
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gno != null) {
            this.gno.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.a.a
    public void refreshUI() {
        if (this.gno != null) {
            this.gno.refreshUI();
        }
    }

    @Override // com.baidu.live.a.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gnu);
        if (this.gno != null) {
            this.gno.onDestroy();
        }
    }
}
