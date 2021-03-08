package com.baidu.tieba.ala.liveroom.performancewatchtask;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.HttpMessageTask;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private TextView hOv;
    private TextView hOw;
    private Runnable hOx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.a.1
        @Override // java.lang.Runnable
        public void run() {
            a.this.hide();
        }
    };
    HttpMessageListener hOy = new HttpMessageListener(1021221) { // from class: com.baidu.tieba.ala.liveroom.performancewatchtask.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021221 && (httpResponsedMessage instanceof WatchFinishHttpResponseMessage) && !httpResponsedMessage.hasError()) {
                c ckj = ((WatchFinishHttpResponseMessage) httpResponsedMessage).ckj();
                if (ckj.isSuccess() && !TextUtils.isEmpty(ckj.taskId)) {
                    if (a.this.hOy != null) {
                        MessageManager.getInstance().unRegisterListener(a.this.hOy);
                    }
                    a.this.a(UbcStatisticLiveKey.KEY_ID_1396, "click", "task_succ", ckj.taskId, ckj.hOR);
                }
            }
        }
    };
    private Context mContext;
    private Dialog mDialog;
    private AlaLiveInfoData mLiveInfo;
    private View mRootView;
    private int mType;
    private long mUserId;

    public a(Context context) {
        this.mContext = context;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_watch_time_task, (ViewGroup) null);
        this.hOv = (TextView) this.mRootView.findViewById(a.f.ala_content);
        this.hOw = (TextView) this.mRootView.findViewById(a.f.jump);
        if (this.hOy != null) {
            MessageManager.getInstance().registerListener(this.hOy);
        }
    }

    static {
        bZz();
    }

    public void aIv() {
        if (this.mDialog == null) {
            this.mDialog = new Dialog(this.mContext, a.i.PlayLevelDialog);
            Hi();
            this.mDialog.setContentView(this.mRootView);
        }
        if (!this.mDialog.isShowing()) {
            this.mDialog.show();
            a(UbcStatisticLiveKey.KEY_ID_1394, "display", "taskcomp_show", (String) null, -1);
        }
    }

    private void Hi() {
        this.mDialog.setCancelable(true);
        this.mDialog.setCanceledOnTouchOutside(true);
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.addFlags(32);
            window.setLayout(-1, -2);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
    }

    public void wd(int i) {
        aIv();
        try {
            this.hOv.postDelayed(this.hOx, i * 1000);
        } catch (Exception e) {
        }
    }

    public void setClickListener(View.OnClickListener onClickListener) {
        if (this.hOw != null) {
            this.hOw.setOnClickListener(onClickListener);
        }
    }

    public void a(String str, int i, long j, String str2, AlaLiveInfoData alaLiveInfoData) {
        this.mType = i;
        this.mUserId = j;
        this.mLiveInfo = alaLiveInfoData;
        if (this.hOv != null) {
            this.hOv.setText(str);
        }
        if (this.hOw != null) {
            this.hOw.setText(str2);
        }
    }

    public void hide() {
        try {
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
                y(this.mUserId, this.mType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void y(long j, int i) {
        HttpMessage httpMessage = new HttpMessage(1021221);
        httpMessage.addParam("user_id", j);
        httpMessage.addParam("type", i);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    private static void bZz() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021221, TbConfig.SERVER_QUANMIN_ADDRESS + "pubshow/task/Jumplivequizticket");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        tbHttpMessageTask.setResponsedClass(WatchFinishHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str4)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("task_id", str4);
                jSONObject2.put("ticket_num", i);
                jSONObject.put("ext", jSONObject2);
            }
            jSONObject.putOpt("live_id", Long.valueOf(this.mLiveInfo.live_id));
            jSONObject.putOpt("vid", this.mLiveInfo.feed_id);
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_SID, ExtraParamsManager.getBaiduSid());
            jSONObject.putOpt(UbcStatConstant.KEY_CONTENT_EXT_LIVESDK, TbConfig.SDK_VERSION);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(str, str2, "liveroom", str3).setContentExt(null, UbcStatConstant.SubPage.POPUP, jSONObject));
    }
}
