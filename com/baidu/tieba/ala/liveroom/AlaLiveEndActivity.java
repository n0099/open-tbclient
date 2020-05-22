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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.q;
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
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.liveroom.data.AlaLiveRecorderPerfData;
import com.baidu.tieba.ala.liveroom.m.b;
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaDeleteRecordResponseMessage;
import java.io.File;
/* loaded from: classes3.dex */
public class AlaLiveEndActivity extends BaseActivity<AlaLiveEndActivity> {
    private b fHB;
    private long fHC;
    private TbImageView fHD;
    private com.baidu.live.liveroom.middleware.a.a fHE;
    private String fHG;
    private AlaLiveRecorderPerfData fHv;
    private View fHw;
    private com.baidu.tieba.ala.liveroom.views.b fHx;
    private AlaLiveUserInfoData fHy;
    private q fHz;
    private String mCoverUrl;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private RelativeLayout mRootView;
    private String nickName;
    private int fpq = 0;
    private String fHA = null;
    private RelativeLayout.LayoutParams fHF = new RelativeLayout.LayoutParams(-1, -1);
    private HttpMessageListener fHH = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.liveroom.data.b bED;
            if ((httpResponsedMessage instanceof AlaCloseLiveHttpResonpnseMessage) && (bED = ((AlaCloseLiveHttpResonpnseMessage) httpResponsedMessage).bED()) != null && bED.mLiveInfo != null) {
                String str = "";
                if (bED.avj != null) {
                    str = bED.avj.nickName;
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(AlaLiveEndActivity.this.nickName)) {
                    str = AlaLiveEndActivity.this.nickName;
                }
                if (AlaLiveEndActivity.this.fHz != null) {
                    if (bED.mLiveInfo != null) {
                        AlaLiveEndActivity.this.fHz.mLiveInfo = bED.mLiveInfo;
                    }
                    if (bED.avj != null) {
                        AlaLiveEndActivity.this.fHz.avj = bED.avj;
                    }
                }
                String str2 = bED.mLiveInfo.cover;
                if (!StringUtils.isNull(str2) && !str2.equals(AlaLiveEndActivity.this.mCoverUrl)) {
                    AlaLiveEndActivity.this.mCoverUrl = str2;
                    AlaLiveEndActivity.this.fHD.startLoad(str2, 39, false);
                }
                if (AlaLiveEndActivity.this.fHE != null) {
                    AlaLiveEndActivity.this.fHE.b(AlaLiveEndActivity.this.fHz, str);
                } else if (AlaLiveEndActivity.this.fHx != null && AlaLiveEndActivity.this.fHx.b(AlaLiveEndActivity.this.fHz, str) != null) {
                    AlaLiveEndActivity.this.fHw = AlaLiveEndActivity.this.fHx.b(AlaLiveEndActivity.this.fHz, str);
                    AlaLiveEndActivity.this.mRootView.removeAllViews();
                    AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.fHD, AlaLiveEndActivity.this.fHF);
                    AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.fHw, AlaLiveEndActivity.this.fHF);
                }
            }
        }
    };
    HttpMessageListener fHI = new HttpMessageListener(1021037) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.2
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
    private e fHJ = new e() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.3
        @Override // com.baidu.live.liveroom.middleware.a.e
        public void Fb() {
            AlaLiveEndActivity.this.closeActivity();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.liveroom.middleware.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void fx(String str) {
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
                            shareEntity.liveId = AlaLiveEndActivity.this.mLiveInfo.live_id;
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
        if (!isFinishing()) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.fHE = d.EY().EZ();
                this.fHE.q(getPageContext().getPageActivity());
            }
            initData(bundle);
            initListener();
            this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
            this.fHD = new TbImageView(getPageContext().getPageActivity());
            this.fHD.setScaleType(ImageView.ScaleType.CENTER_CROP);
            setContentView(this.mRootView);
            initView();
            MessageManager.getInstance().registerListener(this.fHH);
        }
    }

    private void initView() {
        if (this.fHE != null) {
            this.fHw = this.fHE.a(this.fHz, this.fHJ, this.fpq, this.fHA, this.mPortrait, this.nickName);
        }
        if (this.fHw == null) {
            this.fHx = new com.baidu.tieba.ala.liveroom.views.b();
            this.fHx.q(getPageContext().getPageActivity());
            this.fHw = this.fHx.a(this.fHz, this.fHJ, this.fpq, this.fHA, this.mPortrait, this.nickName);
        }
        if (!StringUtils.isNull(this.mCoverUrl)) {
            this.fHD.startLoad(this.mCoverUrl, 39, false);
            if (this.fHD.getParent() != null) {
                ((ViewGroup) this.fHD.getParent()).removeView(this.fHD);
            }
            this.mRootView.addView(this.fHD, this.fHF);
        }
        if (this.fHw != null) {
            if (this.fHw.getParent() != null) {
                ((ViewGroup) this.fHw.getParent()).removeView(this.fHw);
            }
            this.mRootView.addView(this.fHw, this.fHF);
        }
    }

    private void initData(Bundle bundle) {
        if (getIntent() != null) {
            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
            alaLiveInfoData.parserJson(getIntent().getStringExtra("liveInfoData"));
            AlaLiveUserInfoData alaLiveUserInfoData = new AlaLiveUserInfoData();
            alaLiveUserInfoData.parserJson(getIntent().getStringExtra("liveUserData"));
            this.mLiveInfo = alaLiveInfoData;
            this.fHy = alaLiveUserInfoData;
            this.fpq = getIntent().getIntExtra("fromType", 0);
            if (this.fpq > 2 || this.fpq < 0) {
                this.fpq = 0;
            }
            this.fHA = getIntent().getStringExtra("authen_msg");
            this.fHG = getIntent().getStringExtra("live_back_scheme");
            this.mCoverUrl = this.mLiveInfo.cover;
            this.mPortrait = getIntent().getStringExtra("host_portrait");
            this.nickName = getIntent().getStringExtra("user_nickname");
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = new AlaLiveRecorderPerfData();
            alaLiveRecorderPerfData.parseJson(getIntent().getStringExtra("live_perf_data"));
            this.fHv = alaLiveRecorderPerfData;
            if (this.fHv != null) {
                this.fHv.endViewShowTime = System.currentTimeMillis();
                if (this.mLiveInfo != null) {
                    this.fHv.liveID = Long.toString(this.mLiveInfo.live_id);
                }
            }
        }
        if (this.fHz == null) {
            this.fHz = new q();
        }
        if (this.mLiveInfo == null) {
            this.mLiveInfo = new AlaLiveInfoData();
        }
        if (this.fHy == null) {
            this.fHy = new AlaLiveUserInfoData();
        }
        if (this.fHz != null) {
            this.fHz.mLiveInfo = this.mLiveInfo;
            this.fHz.avj = this.fHy;
        }
    }

    private void initListener() {
        bwo();
        registerListener(this.fHI);
    }

    private void bwo() {
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
        if (this.fHv != null) {
            this.fHv.endViewShowTime = System.currentTimeMillis() - this.fHv.endViewShowTime;
        }
        this.fHB = new b();
        this.fHB.a(this.fHv);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.fHI);
        MessageManager.getInstance().unRegisterListener(this.fHH);
        if (this.fHB != null) {
            this.fHB.release();
        }
        if (this.fHE != null) {
            this.fHE.bR(false);
        }
        bwp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis() - this.fHC;
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_STAYTIME);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", currentTimeMillis / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fHE != null) {
            this.fHE.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fHC = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().isQuanmin()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_ACCESS);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.fHE != null) {
            this.fHE.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fHE != null) {
            this.fHE.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.fHE != null) {
            this.fHE.onStop();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.fHE != null) {
            this.fHE.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.fHE != null) {
            this.fHE.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        UbcStatisticManager.getInstance().clear();
    }

    public void bwp() {
        if (!TextUtils.isEmpty(this.fHG)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.fHG);
                this.fHG = null;
            }
        }
    }
}
