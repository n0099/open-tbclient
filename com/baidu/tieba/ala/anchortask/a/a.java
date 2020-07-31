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
import com.baidu.live.data.bj;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a implements com.baidu.live.b.a {
    private q azj;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a fCi;
    private com.baidu.tieba.ala.anchortask.b.b fCj;
    private String fCk;
    private int fCm;
    private int fCn;
    private Handler handler = new Handler();
    private boolean fCl = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.byf();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.fCk)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.fCk));
            }
            a.this.byf();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener fCo = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.fCi != null) {
                a.this.fCj = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).fCj;
                if (a.this.fCj != null && a.this.fCj.fCM != null) {
                    a.this.fCk = a.this.fCj.fCk;
                    a.this.byg();
                    a.this.fCi.a(a.this.fCj.fCM);
                    if (a.this.fCj.fCM.fCA == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.fCi = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.fCi.getView() != null) {
            this.fCi.getView().setOnClickListener(this.eve);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bj bjVar = com.baidu.live.v.a.Hs().beo.aEy;
        if (bjVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (bjVar.aEY != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (bjVar.aEZ != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (bjVar.aFa != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (bjVar.aFb != 1) {
                z = false;
            }
            if (z) {
                if (this.fCi != null) {
                    viewGroup.addView(this.fCi.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(q qVar) {
        this.azj = qVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fCo);
    }

    public void byf() {
        if (this.azj != null) {
            long j = this.azj.mLiveInfo.live_id;
            long j2 = this.azj.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.af(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byg() {
        if (this.fCj != null && this.fCj.fCM != null) {
            if (!this.fCl) {
                this.fCl = true;
                this.fCm = this.fCj.fCM.fCy;
                this.fCn = this.fCj.fCM.fCz;
            }
            int i = this.fCj.fCM.fCA;
            int i2 = this.fCj.fCM.fCB;
            int i3 = this.fCj.fCM.fCC;
            String str = null;
            if (this.fCm == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.fCm == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.fCm == 1 && i == 1) {
                if (i2 > this.fCn) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.fCn) {
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
            this.fCm = i;
            this.fCn = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.fCi != null) {
            this.fCi.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.fCi != null) {
            this.fCi.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fCo);
        if (this.fCi != null) {
            this.fCi.onDestroy();
        }
    }
}
