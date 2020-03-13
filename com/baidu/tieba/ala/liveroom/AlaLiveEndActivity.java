package com.baidu.tieba.ala.liveroom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.m;
import com.baidu.live.liveroom.middleware.a.d;
import com.baidu.live.liveroom.middleware.a.e;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.data.ShareEntity;
import com.baidu.live.tbadk.data.ShareEntityWrapperData;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaDeleteRecordResponseMessage;
import com.baidu.tieba.ala.liveroom.views.b;
import java.io.File;
/* loaded from: classes3.dex */
public class AlaLiveEndActivity extends BaseActivity<AlaLiveEndActivity> {
    private AlaLiveRecorderPerfData eOB;
    private View eOC;
    private b eOD;
    private AlaLiveUserInfoData eOE;
    private m eOF;
    private com.baidu.tieba.ala.liveroom.m.b eOH;
    private long eOI;
    private TbImageView eOJ;
    private com.baidu.live.liveroom.middleware.a.a eOK;
    private String eOM;
    private String mCoverUrl;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private RelativeLayout mRootView;
    private String nickName;
    private int mFromType = 0;
    private String eOG = null;
    private RelativeLayout.LayoutParams eOL = new RelativeLayout.LayoutParams(-1, -1);
    private HttpMessageListener eON = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.liveroom.data.b bpd;
            if ((httpResponsedMessage instanceof AlaCloseLiveHttpResonpnseMessage) && (bpd = ((AlaCloseLiveHttpResonpnseMessage) httpResponsedMessage).bpd()) != null && bpd.mLiveInfo != null) {
                String str = "";
                if (bpd.XQ != null) {
                    str = bpd.XQ.nickName;
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(AlaLiveEndActivity.this.nickName)) {
                    str = AlaLiveEndActivity.this.nickName;
                }
                if (AlaLiveEndActivity.this.eOF != null) {
                    if (bpd.mLiveInfo != null) {
                        AlaLiveEndActivity.this.eOF.mLiveInfo = bpd.mLiveInfo;
                    }
                    if (bpd.XQ != null) {
                        AlaLiveEndActivity.this.eOF.XQ = bpd.XQ;
                    }
                }
                String str2 = bpd.mLiveInfo.cover;
                if (!StringUtils.isNull(str2) && !str2.equals(AlaLiveEndActivity.this.mCoverUrl)) {
                    AlaLiveEndActivity.this.mCoverUrl = str2;
                    AlaLiveEndActivity.this.eOJ.startLoad(str2, 39, false);
                }
                if (AlaLiveEndActivity.this.eOK != null) {
                    AlaLiveEndActivity.this.eOK.b(AlaLiveEndActivity.this.eOF, str);
                } else if (AlaLiveEndActivity.this.eOD != null && AlaLiveEndActivity.this.eOD.b(AlaLiveEndActivity.this.eOF, str) != null) {
                    AlaLiveEndActivity.this.eOC = AlaLiveEndActivity.this.eOD.b(AlaLiveEndActivity.this.eOF, str);
                    AlaLiveEndActivity.this.mRootView.removeAllViews();
                    AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.eOJ, AlaLiveEndActivity.this.eOL);
                    AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.eOC, AlaLiveEndActivity.this.eOL);
                }
            }
        }
    };
    HttpMessageListener eOO = new HttpMessageListener(1021037) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof AlaDeleteRecordResponseMessage)) {
                AlaDeleteRecordResponseMessage alaDeleteRecordResponseMessage = (AlaDeleteRecordResponseMessage) httpResponsedMessage;
                if (alaDeleteRecordResponseMessage.isSuccess()) {
                    AlaLiveEndActivity.this.closeActivity();
                } else {
                    AlaLiveEndActivity.this.showToast(alaDeleteRecordResponseMessage.getErrorString());
                }
            }
        }
    };
    private e eOP = new e() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.3
        @Override // com.baidu.live.liveroom.middleware.a.e
        public void yF() {
            AlaLiveEndActivity.this.closeActivity();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.liveroom.middleware.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void dT(String str) {
            File file;
            Exception e;
            if (AlaLiveEndActivity.this.mLiveInfo != null && !TextUtils.isEmpty(str)) {
                try {
                    file = new File(str);
                } catch (Exception e2) {
                    file = null;
                    e = e2;
                }
                if (file != null) {
                    try {
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        if (!TbadkCoreApplication.IS_SDK) {
                        }
                    }
                    if (file.exists()) {
                        if (!file.isFile()) {
                            return;
                        }
                        if (!TbadkCoreApplication.IS_SDK) {
                            ShareEntity shareEntity = new ShareEntity();
                            String nameShow = AlaLiveEndActivity.this.mLiveInfo.getNameShow();
                            if (nameShow == null) {
                                nameShow = "";
                            }
                            shareEntity.userId = AlaLiveEndActivity.this.mLiveInfo.user_id;
                            shareEntity.userName = nameShow;
                            shareEntity.title = StringUtils.isNull(nameShow) ? "" : nameShow + "的直播";
                            shareEntity.content = String.format("这是一张来自 %s 的成绩单，速来围观吧，你们努努力也可以的。", nameShow);
                            shareEntity.imageUrl = Uri.fromFile(file).toString();
                            if (TbadkCoreApplication.getInst().isHaokan()) {
                                shareEntity.linkUrl = "https://haokan.baidu.com/download?pkg=1022344m";
                            } else if (!TbadkCoreApplication.getInst().isQuanmin()) {
                                shareEntity.linkUrl = AlaLiveEndActivity.this.mLiveInfo.share_url;
                            } else {
                                shareEntity.linkUrl = "https://quanmin.baidu.com/?channel=1023063c&tab=share&tag=zbgb&source=act-1023051s-0 ";
                            }
                            shareEntity.type = "2";
                            ShareEntityWrapperData shareEntityWrapperData = new ShareEntityWrapperData();
                            shareEntityWrapperData.activity = AlaLiveEndActivity.this.getPageContext().getPageActivity();
                            shareEntityWrapperData.shareEntity = shareEntity;
                            MessageManager.getInstance().sendMessage(new CustomMessage(2913077, shareEntityWrapperData));
                        }
                    }
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        if (TbadkCoreApplication.getInst().isOther()) {
            this.eOK = d.yC().yD();
            this.eOK.u(getPageContext().getPageActivity());
        }
        initData(bundle);
        initListener();
        this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
        this.eOJ = new TbImageView(getPageContext().getPageActivity());
        this.eOJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        setContentView(this.mRootView);
        initView();
        MessageManager.getInstance().registerListener(this.eON);
    }

    private void initView() {
        if (this.eOK != null) {
            this.eOC = this.eOK.a(this.eOF, this.eOP, this.mFromType, this.eOG, this.mPortrait, this.nickName);
        }
        if (this.eOC == null) {
            this.eOD = new b();
            this.eOD.u(getPageContext().getPageActivity());
            this.eOC = this.eOD.a(this.eOF, this.eOP, this.mFromType, this.eOG, this.mPortrait, this.nickName);
        }
        if (!StringUtils.isNull(this.mCoverUrl)) {
            this.eOJ.startLoad(this.mCoverUrl, 39, false);
            if (this.eOJ.getParent() != null) {
                ((ViewGroup) this.eOJ.getParent()).removeView(this.eOJ);
            }
            this.mRootView.addView(this.eOJ, this.eOL);
        }
        if (this.eOC != null) {
            if (this.eOC.getParent() != null) {
                ((ViewGroup) this.eOC.getParent()).removeView(this.eOC);
            }
            this.mRootView.addView(this.eOC, this.eOL);
        }
    }

    private void initData(Bundle bundle) {
        if (getIntent() != null) {
            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
            alaLiveInfoData.parserJson(getIntent().getStringExtra("liveInfoData"));
            AlaLiveUserInfoData alaLiveUserInfoData = new AlaLiveUserInfoData();
            alaLiveUserInfoData.parserJson(getIntent().getStringExtra("liveUserData"));
            this.mLiveInfo = alaLiveInfoData;
            this.eOE = alaLiveUserInfoData;
            this.mFromType = getIntent().getIntExtra("fromType", 0);
            if (this.mFromType > 2 || this.mFromType < 0) {
                this.mFromType = 0;
            }
            this.eOG = getIntent().getStringExtra("authen_msg");
            this.eOM = getIntent().getStringExtra("live_back_scheme");
            this.mCoverUrl = this.mLiveInfo.cover;
            this.mPortrait = getIntent().getStringExtra("host_portrait");
            this.nickName = getIntent().getStringExtra("user_nickname");
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = new AlaLiveRecorderPerfData();
            alaLiveRecorderPerfData.parseJson(getIntent().getStringExtra("live_perf_data"));
            this.eOB = alaLiveRecorderPerfData;
            if (this.eOB != null) {
                this.eOB.endViewShowTime = System.currentTimeMillis();
                if (this.mLiveInfo != null) {
                    this.eOB.liveID = Long.toString(this.mLiveInfo.live_id);
                }
            }
        }
        if (this.eOF == null) {
            this.eOF = new m();
        }
        if (this.mLiveInfo == null) {
            this.mLiveInfo = new AlaLiveInfoData();
        }
        if (this.eOE == null) {
            this.eOE = new AlaLiveUserInfoData();
        }
        if (this.eOF != null) {
            this.eOF.mLiveInfo = this.mLiveInfo;
            this.eOF.XQ = this.eOE;
        }
    }

    private void initListener() {
        bhc();
        registerListener(this.eOO);
    }

    private void bhc() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021037, TbConfig.SERVER_ADDRESS + "ala/live/delRecord");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDeleteRecordResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        if (this.eOB != null) {
            this.eOB.endViewShowTime = System.currentTimeMillis() - this.eOB.endViewShowTime;
        }
        this.eOH = new com.baidu.tieba.ala.liveroom.m.b();
        this.eOH.a(this.eOB);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.eOO);
        MessageManager.getInstance().unRegisterListener(this.eON);
        if (this.eOH != null) {
            this.eOH.release();
        }
        if (this.eOK != null) {
            this.eOK.be(false);
        }
        bhd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis() - this.eOI;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_STAYTIME);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", currentTimeMillis / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.eOK != null) {
            this.eOK.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eOI = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_ACCESS);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.eOK != null) {
            this.eOK.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eOK != null) {
            this.eOK.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.eOK != null) {
            this.eOK.onStop();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.eOK != null) {
            this.eOK.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.eOK != null) {
            this.eOK.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void bhd() {
        if (!TextUtils.isEmpty(this.eOM)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.eOM);
                this.eOM = null;
            }
        }
    }
}
