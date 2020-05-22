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
import com.baidu.live.data.bd;
import com.baidu.live.data.q;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.anchortask.message.GetAnchorTaskInfoHttpResponseMessage;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a implements com.baidu.live.b.a {
    private q avQ;
    private Context context;
    private com.baidu.tieba.ala.anchortask.c.a flD;
    private com.baidu.tieba.ala.anchortask.b.b flE;
    private String flF;
    private int flH;
    private int flI;
    private Handler handler = new Handler();
    private boolean flG = false;
    private Runnable runnable = new Runnable() { // from class: com.baidu.tieba.ala.anchortask.a.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.brX();
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.ala.anchortask.a.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.flF != null) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913141, a.this.flF));
            }
            a.this.brX();
            a.this.handler.removeCallbacksAndMessages(null);
            a.this.handler.postDelayed(a.this.runnable, 60000L);
        }
    };
    private HttpMessageListener flJ = new HttpMessageListener(1021172) { // from class: com.baidu.tieba.ala.anchortask.a.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof GetAnchorTaskInfoHttpResponseMessage) && a.this.flD != null) {
                a.this.flE = ((GetAnchorTaskInfoHttpResponseMessage) httpResponsedMessage).flE;
                if (a.this.flE != null && a.this.flE.fmh != null) {
                    a.this.flF = a.this.flE.flF;
                    a.this.brY();
                    a.this.flD.a(a.this.flE.fmh);
                    if (a.this.flE.fmh.flV == 2) {
                        a.this.handler.removeCallbacksAndMessages(null);
                    }
                }
            }
        }
    };

    public a(Context context) {
        this.context = context;
        initTasks();
        this.flD = new com.baidu.tieba.ala.anchortask.c.a(context);
        if (this.flD.getView() != null) {
            this.flD.getView().setOnClickListener(this.ege);
        }
    }

    @Override // com.baidu.live.b.a
    public void a(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        boolean z = true;
        bd bdVar = com.baidu.live.v.a.Ge().aYP.aAS;
        if (bdVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan()) {
                if (bdVar.aBt != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                if (bdVar.aBu != 1) {
                    z = false;
                }
            } else if (TbadkCoreApplication.getInst().isTieba()) {
                if (bdVar.aBv != 1) {
                    z = false;
                }
            } else if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                z = false;
            } else if (bdVar.aBw != 1) {
                z = false;
            }
            if (z) {
                if (this.flD != null) {
                    viewGroup.addView(this.flD.getView(), layoutParams);
                }
                this.handler.postDelayed(this.runnable, 10000L);
            }
        }
    }

    @Override // com.baidu.live.b.a
    public void a(q qVar) {
        this.avQ = qVar;
    }

    private void initTasks() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021172, TbConfig.SERVER_HOST + "liveserver/anchortask/getanchortaskinfo");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(GetAnchorTaskInfoHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        MessageManager.getInstance().registerListener(this.flJ);
    }

    public void brX() {
        if (this.avQ != null) {
            long j = this.avQ.mLiveInfo.live_id;
            long j2 = this.avQ.mLiveInfo.user_id;
            com.baidu.tieba.ala.anchortask.message.a aVar = new com.baidu.tieba.ala.anchortask.message.a();
            aVar.af(j2);
            aVar.setLiveId(j);
            aVar.setParams();
            MessageManager.getInstance().sendMessage(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brY() {
        if (this.flE != null && this.flE.fmh != null) {
            if (!this.flG) {
                this.flG = true;
                this.flH = this.flE.fmh.flT;
                this.flI = this.flE.fmh.flU;
            }
            int i = this.flE.fmh.flV;
            int i2 = this.flE.fmh.flW;
            int i3 = this.flE.fmh.flX;
            String str = null;
            if (this.flH == 1 && i == 2) {
                str = this.context.getString(a.i.txt_im_identity_is_mcn);
            } else if (this.flH == 2 && i == 1) {
                str = String.format(this.context.getString(a.i.txt_im_identity_is_ugc), Integer.valueOf(i3)) + "%";
            } else if (this.flH == 1 && i == 1) {
                if (i2 > this.flI) {
                    str = String.format(this.context.getString(a.i.txt_im_identity_advance), Integer.valueOf(i3)) + "%";
                } else if (i2 < this.flI) {
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
            this.flH = i;
            this.flI = i2;
        }
    }

    @Override // com.baidu.live.b.a
    public void onDestory() {
        this.handler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.flJ);
        if (this.flD != null) {
            this.flD.onDestroy();
        }
    }
}
