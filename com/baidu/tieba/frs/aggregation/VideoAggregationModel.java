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
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class VideoAggregationModel extends BdBaseModel {
    private a fCI;
    private final HttpMessageListener fCJ;
    private final HttpMessageListener fCK;
    private String mFrom;
    private String mId;
    private boolean mIsLoading;
    private TbPageContext mPageContext;
    private int mPn;
    private String st_type;
    private String yuelaou_locate;

    /* loaded from: classes4.dex */
    public interface a {
        void e(List<g> list, boolean z, boolean z2);

        void xC(String str);
    }

    static /* synthetic */ int b(VideoAggregationModel videoAggregationModel) {
        int i = videoAggregationModel.mPn;
        videoAggregationModel.mPn = i - 1;
        return i;
    }

    public VideoAggregationModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.fCJ = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_AGGREGATION) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003360 || !(httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                    VideoAggregationModel.this.fCI.xC("error");
                    return;
                }
                VideoAggregationModel.this.mIsLoading = false;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    VideoAggregationModel.this.fCI.e(((VideoAggregationResponseMessage) httpResponsedMessage).mDataList, VideoAggregationModel.this.mPn == 1, ((VideoAggregationResponseMessage) httpResponsedMessage).mHasMore);
                    return;
                }
                VideoAggregationModel.b(VideoAggregationModel.this);
                String errorString = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
                }
                VideoAggregationModel.this.fCI.xC(errorString);
            }
        };
        this.fCK = new HttpMessageListener(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION) { // from class: com.baidu.tieba.frs.aggregation.VideoAggregationModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003378 || !(httpResponsedMessage instanceof VideoAggregationResponseMessage)) {
                    VideoAggregationModel.this.fCI.xC("error");
                    return;
                }
                VideoAggregationModel.this.mIsLoading = false;
                if (!httpResponsedMessage.hasError() && httpResponsedMessage.getError() == 0) {
                    VideoAggregationModel.this.fCI.e(((VideoAggregationResponseMessage) httpResponsedMessage).mDataList, VideoAggregationModel.this.mPn == 1, ((VideoAggregationResponseMessage) httpResponsedMessage).mHasMore);
                    return;
                }
                VideoAggregationModel.b(VideoAggregationModel.this);
                String errorString = httpResponsedMessage.getErrorString();
                if (TextUtils.isEmpty(errorString)) {
                    errorString = TbadkCoreApplication.getInst().getResources().getString(R.string.error_unkown_try_again);
                }
                VideoAggregationModel.this.fCI.xC(errorString);
            }
        };
        this.mPageContext = tbPageContext;
        this.fCI = aVar;
        registerTask();
        this.fCJ.setTag(getUniqueId());
        this.fCJ.setSelfListener(true);
        this.fCK.setTag(getUniqueId());
        this.fCK.setSelfListener(true);
        registerListener(this.fCJ);
        registerListener(this.fCK);
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public void xB(String str) {
        this.st_type = str;
    }

    public void setLocation(String str) {
        this.yuelaou_locate = str;
    }

    private void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/frstab");
        tbHttpMessageTask.setResponsedClass(VideoAggregationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION, TbConfig.SERVER_ADDRESS + "c/f/video/getVideoMidPage");
        tbHttpMessageTask2.setResponsedClass(VideoAggregationResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    /* loaded from: classes4.dex */
    public static class VideoAggregationResponseMessage extends JsonHttpResponsedMessage {
        public List<g> mDataList;
        public boolean mHasMore;

        public VideoAggregationResponseMessage(int i) {
            super(i);
        }

        @Override // com.baidu.tbadk.message.http.JsonHttpResponsedMessage
        public void decodeLogicInBackGround(int i, JSONObject jSONObject) throws Exception {
            int statusCode = getStatusCode();
            int error = getError();
            if (statusCode == 200 && error == 0 && jSONObject != null) {
                this.mHasMore = jSONObject.optInt("has_more") == 1;
                String optString = jSONObject.optString(IntentConfig.LIST);
                if (!TextUtils.isEmpty(optString)) {
                    this.mDataList = new ArrayList();
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        g gVar = new g();
                        gVar.parseJson(jSONArray.optString(i2));
                        if (gVar.fCr != null) {
                            this.mDataList.add(gVar);
                        }
                    }
                }
            }
        }
    }

    public void bpp() {
        this.mPn = 0;
        LoadData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        HttpMessage httpMessage;
        if (TextUtils.isEmpty(this.mId) || this.mIsLoading) {
            return false;
        }
        this.mIsLoading = true;
        if (VideoAggregationActivityConfig.TYPE_FROM_FRS.equals(this.mFrom)) {
            httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
            httpMessage.addParam("fid", this.mId);
        } else {
            httpMessage = new HttpMessage(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
            httpMessage.addParam("tid", this.mId);
            httpMessage.addParam("st_type", this.st_type);
            httpMessage.addParam("yuelaou_locate", this.yuelaou_locate);
        }
        int i = this.mPn + 1;
        this.mPn = i;
        httpMessage.addParam(Config.PACKAGE_NAME, i);
        sendMessage(httpMessage);
        return true;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_AGGREGATION);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_VIDEO_MIDDLE_AGGREGATION);
        return false;
    }
}
