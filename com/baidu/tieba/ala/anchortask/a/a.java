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
    private com.baidu.tieba.ala.anchortask.c.a gdk;
    private com.baidu.tieba.ala.anchortask.b.b gdl;
    private String gdm;
    private int gdo;
    private int gdp;
    private Handler handler = new Handler();
    private boolean gdn = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bLf();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gdm)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gdm));
            }
            a.this.bLf();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener gdq = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gdk != null) {
                a.this.gdl = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gdl;
                if (a.this.gdl != null && a.this.gdl.gdK != null) {
                    a.this.gdm = a.this.gdl.gdm;
                    a.this.bLg();
                    a.this.gdk.a(a.this.gdl.gdK);
                    if (a.this.gdl.gdK.gdy == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gdk = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.gdk.getView() != null) {
            this.gdk.getView().setOnClickListener(this.eTU);
        }
    }

    @Override // com.baidu.live.a.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bs bsVar = com.baidu.live.x.a.OS().bqJ.aOf;
        if (bsVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (bsVar.aOS != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                if (bsVar.aOT != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (bsVar.aOU != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (bsVar.aOV != 1) {
                z = false;
            }
            if (z) {
                if (this.gdk != null) {
                    viewGroup.addView(this.gdk.getView(), layoutParams);
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
        MessageManager.getInstance().registerListener(this.gdq);
    }

    public void bLf() {
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
    public void bLg() {
        if (this.gdl != null && this.gdl.gdK != null) {
            if (!this.gdn) {
                this.gdn = true;
                this.gdo = this.gdl.gdK.gdw;
                this.gdp = this.gdl.gdK.gdx;
            }
            int i = this.gdl.gdK.gdy;
            int i2 = this.gdl.gdK.gdz;
            int i3 = this.gdl.gdK.gdA;
            String str = null;
            if (this.gdo == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.gdo == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gdo == 1 && i == 1) {
                if (i2 > this.gdp) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gdp) {
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
            this.gdo = i;
            this.gdp = i2;
        }
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gdk != null) {
            this.gdk.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.a.a
    public void refreshUI() {
        if (this.gdk != null) {
            this.gdk.refreshUI();
        }
    }

    @Override // com.baidu.live.a.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gdq);
        if (this.gdk != null) {
            this.gdk.onDestroy();
        }
    }
}
