package com.baidu.tieba.frs.videomiddlepage;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import d.a.j0.q0.i1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoMiddleModel extends BdBaseModel {
    public static final String TYPE_CALL_FROM_FRS = "client_frs";
    public static final String TYPE_CALL_FROM_INDEX = "client_index";
    public static final String TYPE_CALL_FROM_OTHER = "client_other";

    /* renamed from: e  reason: collision with root package name */
    public int f16558e;

    /* renamed from: f  reason: collision with root package name */
    public String f16559f;

    /* renamed from: g  reason: collision with root package name */
    public String f16560g;

    /* renamed from: h  reason: collision with root package name */
    public String f16561h;

    /* renamed from: i  reason: collision with root package name */
    public VideoSerializeVideoThreadInfo f16562i;
    public boolean j;
    public b k;
    public String l;
    public String m;
    public final HttpMessageListener n;

    /* loaded from: classes4.dex */
    public static class VideoMiddleDataResponseMessage extends JsonHttpResponsedMessage {
        public List<BaseCardInfo> mDataList;
        public boolean mHasMore;

        public VideoMiddleDataResponseMessage(int i2) {
            super(i2);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i2, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mHasMore = jSONObject.optInt("has_more") == 1;
                String optString = jSONObject.optString("list");
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                this.mDataList = new ArrayList();
                JSONArray jSONArray = new JSONArray(optString);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    g gVar = new g();
                    gVar.t(jSONArray.optString(i3));
                    if (gVar.z != null) {
                        this.mDataList.add(gVar);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoMiddleDataResponseMessage)) {
                if (VideoMiddleModel.this.k != null) {
                    VideoMiddleModel.this.k.a("error");
                    return;
                }
                return;
            }
            VideoMiddleModel.this.j = false;
            if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                TbSingleton.getInstance().clearVideoRecord();
                if (VideoMiddleModel.this.k != null) {
                    VideoMiddleDataResponseMessage videoMiddleDataResponseMessage = (VideoMiddleDataResponseMessage) httpResponsedMessage;
                    VideoMiddleModel.this.k.b(videoMiddleDataResponseMessage.mDataList, videoMiddleDataResponseMessage.mHasMore);
                    return;
                }
                return;
            }
            VideoMiddleModel.u(VideoMiddleModel.this);
            String errorString = httpResponsedMessage.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
            }
            if (VideoMiddleModel.this.k != null) {
                VideoMiddleModel.this.k.a(errorString);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str);

        void b(List<BaseCardInfo> list, boolean z);
    }

    public VideoMiddleModel(TbPageContext tbPageContext, b bVar) {
        super(tbPageContext);
        this.m = "client_other";
        this.n = new a(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        this.k = bVar;
        registerTask();
        this.n.setTag(getUniqueId());
        this.n.setSelfListener(true);
        registerListener(this.n);
    }

    public static /* synthetic */ int u(VideoMiddleModel videoMiddleModel) {
        int i2 = videoMiddleModel.f16558e;
        videoMiddleModel.f16558e = i2 - 1;
        return i2;
    }

    public void A(VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        this.f16562i = videoSerializeVideoThreadInfo;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        BaijiahaoData baijiahaoData;
        if (this.j) {
            return false;
        }
        this.j = true;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        httpMessage.addParam("tid", this.f16559f);
        httpMessage.addParam("st_type", this.f16560g);
        httpMessage.addParam("yuelaou_locate", this.f16561h);
        int i2 = this.f16558e + 1;
        this.f16558e = i2;
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        httpMessage.addParam("user_view_data", v());
        if ("frs".equals(this.l)) {
            this.m = "client_frs";
        } else if ("index".equals(this.l)) {
            this.m = "client_index";
        } else {
            this.m = "client_other";
        }
        httpMessage.addParam(IntentConfig.CALL_FROM, this.m);
        this.m = "client_index";
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = this.f16562i;
        if (videoSerializeVideoThreadInfo != null && (baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData) != null) {
            httpMessage.addParam("ori_ugc_nid", baijiahaoData.oriUgcNid);
            httpMessage.addParam(TiebaStatic.Params.UGC_TYPE, this.f16562i.mBaijiahaoData.oriUgcType);
            httpMessage.addParam("ori_ugc_vid", this.f16562i.mBaijiahaoData.oriUgcVid);
            httpMessage.addParam("ori_ugc_tid", this.f16562i.mBaijiahaoData.oriUgcTid);
        }
        sendMessage(httpMessage);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
        tbHttpMessageTask.setResponsedClass(VideoMiddleDataResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void setFrom(String str) {
        this.l = str;
    }

    public final String v() {
        JSONArray jSONArray = new JSONArray();
        LinkedList<d.a.i0.g.a> videoRecordList = TbSingleton.getInstance().getVideoRecordList();
        if (videoRecordList != null) {
            try {
                if (videoRecordList.size() > 0) {
                    Iterator<d.a.i0.g.a> it = videoRecordList.iterator();
                    while (it.hasNext()) {
                        d.a.i0.g.a next = it.next();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("tid", next.a());
                        jSONObject.put("duration", next.b());
                        jSONArray.put(jSONObject);
                    }
                }
            } catch (JSONException e2) {
                BdLog.e(e2);
            }
        }
        return jSONArray.toString();
    }

    public int w() {
        return this.f16558e;
    }

    public void x(String str) {
        this.f16559f = str;
    }

    public void y(String str) {
        this.f16561h = str;
    }

    public void z(String str) {
        this.f16560g = str;
    }
}
