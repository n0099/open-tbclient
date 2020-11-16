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
import com.baidu.live.data.by;
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
    private com.baidu.tieba.ala.anchortask.c.a gsI;
    private com.baidu.tieba.ala.anchortask.b.b gsJ;
    private String gsK;
    private int gsM;
    private int gsN;
    private Handler handler = new Handler();
    private boolean gsL = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.bPA();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!TextUtils.isEmpty(a.this.gsK)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.gsK));
            }
            a.this.bPA();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener gsO = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.gsI != null) {
                a.this.gsJ = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).gsJ;
                if (a.this.gsJ != null && a.this.gsJ.gti != null) {
                    a.this.gsK = a.this.gsJ.gsK;
                    a.this.bPB();
                    a.this.gsI.a(a.this.gsJ.gti);
                    if (a.this.gsJ.gti.gsW == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.gsI = new com.baidu.tieba.ala.anchortask.c.a(context);
        this.gsI.getView().setId(a.f.ala_main_anthor_task_entry_id);
        if (this.gsI.getView() != null) {
            this.gsI.getView().setOnClickListener(this.fhp);
        }
    }

    @Override // com.baidu.live.a.a
    public void b(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        by byVar = com.baidu.live.aa.a.Ph().bsh.aNW;
        if (byVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (byVar.aON != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                if (byVar.aOO != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (byVar.aOP != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (byVar.aOQ != 1) {
                z = false;
            }
            if (z) {
                if (this.gsI != null) {
                    viewGroup.addView(this.gsI.getView(), layoutParams);
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
        MessageManager.getInstance().registerListener(this.gsO);
    }

    public void bPA() {
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
    public void bPB() {
        if (this.gsJ != null && this.gsJ.gti != null) {
            if (!this.gsL) {
                this.gsL = true;
                this.gsM = this.gsJ.gti.gsU;
                this.gsN = this.gsJ.gti.gsV;
            }
            int i = this.gsJ.gti.gsW;
            int i2 = this.gsJ.gti.gsX;
            int i3 = this.gsJ.gti.gsY;
            String str = null;
            if (this.gsM == 1 && i == 2) {
                str = this.context.getString(a.h.txt_im_identity_is_mcn);
            } else if (this.gsM == 2 && i == 1) {
                str = String.format(this.context.getString(a.h.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.gsM == 1 && i == 1) {
                if (i2 > this.gsN) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.gsN) {
                    str = String.format(this.context.getString(a.h.txt_im_identity_reduce), Integer.valueOf(i3)) + "%";
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
            this.gsM = i;
            this.gsN = i2;
        }
    }

    @Override // com.baidu.live.a.a
    public void setCanVisible(boolean z) {
        if (this.gsI != null) {
            this.gsI.setCanVisible(z);
        }
    }

    @Override // com.baidu.live.a.a
    public void refreshUI() {
        if (this.gsI != null) {
            this.gsI.refreshUI();
        }
    }

    @Override // com.baidu.live.a.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gsO);
        if (this.gsI != null) {
            this.gsI.onDestroy();
        }
    }
}
