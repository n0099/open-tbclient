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
import com.baidu.live.data.bi;
import com.baidu.live.data.q;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.b.a {
    private q axW;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a fxb;
    private com.baidu.tieba.ala.anchortask.b.b fxc;
    private String fxd;
    private int fxf;
    private int fxg;
    private Handler handler = new Handler();
    private boolean fxe = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.buW();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fxd != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.fxd));
            }
            a.this.buW();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener fxh = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.fxb != null) {
                a.this.fxc = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).fxc;
                if (a.this.fxc != null && a.this.fxc.fxF != null) {
                    a.this.fxd = a.this.fxc.fxd;
                    a.this.buX();
                    a.this.fxb.a(a.this.fxc.fxF);
                    if (a.this.fxc.fxF.fxt == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.fxb = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.fxb.getView() != null) {
            this.fxb.getView().setOnClickListener(this.eoP);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bi biVar = com.baidu.live.v.a.Hm().bdV.aDd;
        if (biVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (biVar.aDE != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (biVar.aDF != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (biVar.aDG != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (biVar.aDH != 1) {
                z = false;
            }
            if (z) {
                if (this.fxb != null) {
                    viewGroup.addView(this.fxb.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(q qVar) {
        this.axW = qVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.fxh);
    }

    public void buW() {
        if (this.axW != null) {
            long j = this.axW.mLiveInfo.live_id;
            long j2 = this.axW.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.af(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buX() {
        if (this.fxc != null && this.fxc.fxF != null) {
            if (!this.fxe) {
                this.fxe = true;
                this.fxf = this.fxc.fxF.fxr;
                this.fxg = this.fxc.fxF.fxs;
            }
            int i = this.fxc.fxF.fxt;
            int i2 = this.fxc.fxF.fxu;
            int i3 = this.fxc.fxF.fxv;
            String str = null;
            if (this.fxf == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.fxf == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.fxf == 1 && i == 1) {
                if (i2 > this.fxg) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.fxg) {
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
            this.fxf = i;
            this.fxg = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void setCanVisible(boolean z) {
        if (this.fxb != null) {
            this.fxb.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.b.a
    public void refreshUI() {
        if (this.fxb != null) {
            this.fxb.refreshUI();
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fxh);
        if (this.fxb != null) {
            this.fxb.onDestroy();
        }
    }
}
