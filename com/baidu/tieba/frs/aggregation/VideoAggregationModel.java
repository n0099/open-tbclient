package com.baidu.tieba.frs.aggregation;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoAggregationActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.o0.r0.i1.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoAggregationModel extends BdBaseModel {

    /* renamed from: e  reason: collision with root package name */
    public int f15374e;

    /* renamed from: f  reason: collision with root package name */
    public String f15375f;

    /* renamed from: g  reason: collision with root package name */
    public String f15376g;

    /* renamed from: h  reason: collision with root package name */
    public String f15377h;

    /* renamed from: i  reason: collision with root package name */
    public String f15378i;
    public boolean j;
    public c k;
    public final HttpMessageListener l;
    public final HttpMessageListener m;

    /* loaded from: classes4.dex */
    public static class VideoAggregationResponseMessage extends JsonHttpResponsedMessage {
        public List<g> mDataList;
        public boolean mHasMore;

        public VideoAggregationResponseMessage(int i2) {
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
                    gVar.p(jSONArray.optString(i3));
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
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003360 || !(httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                VideoAggregationModel.this.k.a("error");
                return;
            }
            VideoAggregationModel.this.j = false;
            if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                VideoAggregationResponseMessage videoAggregationResponseMessage = (VideoAggregationResponseMessage) httpResponsedMessage;
                VideoAggregationModel.this.k.b(videoAggregationResponseMessage.mDataList, VideoAggregationModel.this.f15374e == 1, videoAggregationResponseMessage.mHasMore);
                return;
            }
            VideoAggregationModel.z(VideoAggregationModel.this);
            String errorString = httpResponsedMessage.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
            }
            VideoAggregationModel.this.k.a(errorString);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends HttpMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                VideoAggregationModel.this.k.a("error");
                return;
            }
            VideoAggregationModel.this.j = false;
            if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                VideoAggregationResponseMessage videoAggregationResponseMessage = (VideoAggregationResponseMessage) httpResponsedMessage;
                VideoAggregationModel.this.k.b(videoAggregationResponseMessage.mDataList, VideoAggregationModel.this.f15374e == 1, videoAggregationResponseMessage.mHasMore);
                return;
            }
            VideoAggregationModel.z(VideoAggregationModel.this);
            String errorString = httpResponsedMessage.getErrorString();
            if (TextUtils.isEmpty(errorString)) {
                errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
            }
            VideoAggregationModel.this.k.a(errorString);
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(String str);

        void b(List<g> list, boolean z, boolean z2);
    }

    public VideoAggregationModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        this.l = new a(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
        this.m = new b(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        this.k = cVar;
        registerTask();
        this.l.setTag(getUniqueId());
        this.l.setSelfListener(true);
        this.m.setTag(getUniqueId());
        this.m.setSelfListener(true);
        registerListener(this.l);
        registerListener(this.m);
    }

    public static /* synthetic */ int z(VideoAggregationModel videoAggregationModel) {
        int i2 = videoAggregationModel.f15374e;
        videoAggregationModel.f15374e = i2 - 1;
        return i2;
    }

    public void A() {
        this.f15374e = 0;
        LoadData();
    }

    public void B(String str) {
        this.f15375f = str;
    }

    public void C(String str) {
        this.f15378i = str;
    }

    public void D(String str) {
        this.f15377h = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        HttpMessage httpMessage;
        if (TextUtils.isEmpty(this.f15375f) || this.j) {
            return false;
        }
        this.j = true;
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.f15376g)) {
            httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
            httpMessage.addParam("fid", this.f15375f);
        } else {
            httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
            httpMessage.addParam("tid", this.f15375f);
            httpMessage.addParam("st_type", this.f15377h);
            httpMessage.addParam("yuelaou_locate", this.f15378i);
        }
        int i2 = this.f15374e + 1;
        this.f15374e = i2;
        httpMessage.addParam(Config.PACKAGE_NAME, i2);
        sendMessage(httpMessage);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        return false;
    }

    public final void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/frstab");
        tbHttpMessageTask.setResponsedClass(VideoAggregationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
        tbHttpMessageTask2.setResponsedClass(VideoAggregationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public void setFrom(String str) {
        this.f15376g = str;
    }
}
