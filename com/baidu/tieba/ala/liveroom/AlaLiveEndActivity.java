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
import com.baidu.live.data.w;
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
import com.baidu.tieba.ala.liveroom.messages.AlaCloseLiveHttpResonpnseMessage;
import com.baidu.tieba.ala.liveroom.messages.AlaDeleteRecordResponseMessage;
import com.baidu.tieba.ala.liveroom.p.c;
import com.baidu.tieba.ala.liveroom.views.b;
import java.io.File;
/* loaded from: classes4.dex */
public class AlaLiveEndActivity extends BaseActivity<AlaLiveEndActivity> {
    private w bur;
    private AlaLiveRecorderPerfData hcU;
    private View hcV;
    private b hcW;
    private AlaLiveUserInfoData hcX;
    private c hcZ;
    private long hda;
    private TbImageView hdb;
    private com.baidu.live.liveroom.middleware.a.a hdc;
    private String hde;
    private String mCoverUrl;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private RelativeLayout mRootView;
    private String nickName;
    private int gFh = 0;
    private String hcY = null;
    private RelativeLayout.LayoutParams hdd = new RelativeLayout.LayoutParams(-1, -1);
    private HttpMessageListener hdf = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.liveroom.data.b ciU;
            if ((httpResponsedMessage instanceof AlaCloseLiveHttpResonpnseMessage) && (ciU = ((AlaCloseLiveHttpResonpnseMessage) httpResponsedMessage).ciU()) != null && ciU.mLiveInfo != null) {
                String str = "";
                if (ciU.aJV != null) {
                    str = ciU.aJV.nickName;
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(AlaLiveEndActivity.this.nickName)) {
                    str = AlaLiveEndActivity.this.nickName;
                }
                if (AlaLiveEndActivity.this.bur != null) {
                    if (ciU.mLiveInfo != null) {
                        AlaLiveEndActivity.this.bur.mLiveInfo = ciU.mLiveInfo;
                    }
                    if (ciU.aJV != null) {
                        AlaLiveEndActivity.this.bur.aJV = ciU.aJV;
                    }
                }
                String str2 = ciU.mLiveInfo.cover;
                if (!StringUtils.isNull(str2) && !str2.equals(AlaLiveEndActivity.this.mCoverUrl)) {
                    AlaLiveEndActivity.this.mCoverUrl = str2;
                    AlaLiveEndActivity.this.hdb.startLoad(str2, 39, false);
                }
                if (AlaLiveEndActivity.this.hdc != null) {
                    AlaLiveEndActivity.this.hdc.a(AlaLiveEndActivity.this.bur, str);
                } else if (AlaLiveEndActivity.this.hcW != null && AlaLiveEndActivity.this.hcW.a(AlaLiveEndActivity.this.bur, str) != null) {
                    AlaLiveEndActivity.this.hcV = AlaLiveEndActivity.this.hcW.a(AlaLiveEndActivity.this.bur, str);
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.hdb) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.hdb, 0, AlaLiveEndActivity.this.hdd);
                    }
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.hcV) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.hcV, AlaLiveEndActivity.this.hdd);
                    }
                }
            }
        }
    };
    HttpMessageListener hdg = new HttpMessageListener(1021037) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.2
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
    private e hdh = new e() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.3
        @Override // com.baidu.live.liveroom.middleware.a.e
        public void Pv() {
            AlaLiveEndActivity.this.closeActivity();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.liveroom.middleware.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void im(String str) {
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
                            } else if (TbadkCoreApplication.getInst().isQuanmin()) {
                                shareEntity.linkUrl = "https://quanmin.baidu.com/?channel=1023063c&tab=share&tag=zbgb&source=act-1023051s-0 ";
                            } else if (!TbadkCoreApplication.getInst().isYinbo()) {
                                shareEntity.linkUrl = AlaLiveEndActivity.this.mLiveInfo.share_url;
                            } else {
                                shareEntity.linkUrl = "https://yinbo.baidu.com/yinboui/system/drawboard";
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hdc = d.Ps().Pt();
                this.hdc.r(getPageContext().getPageActivity());
            }
            initData(bundle);
            initListener();
            this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
            this.hdb = new TbImageView(getPageContext().getPageActivity());
            this.hdb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            setContentView(this.mRootView);
            initView();
            MessageManager.getInstance().registerListener(this.hdf);
        }
    }

    private void initView() {
        if (this.hdc != null) {
            this.hcV = this.hdc.a(this.bur, this.hdh, this.gFh, this.hcY, this.mPortrait, this.nickName);
        }
        if (this.hcV == null) {
            this.hcW = new b();
            this.hcW.r(getPageContext().getPageActivity());
            this.hcV = this.hcW.a(this.bur, this.hdh, this.gFh, this.hcY, this.mPortrait, this.nickName);
        }
        if (!StringUtils.isNull(this.mCoverUrl)) {
            this.hdb.startLoad(this.mCoverUrl, 39, false);
            if (this.hdb.getParent() != null) {
                ((ViewGroup) this.hdb.getParent()).removeView(this.hdb);
            }
            this.mRootView.addView(this.hdb, this.hdd);
        }
        if (this.hcV != null) {
            if (this.hcV.getParent() != null) {
                ((ViewGroup) this.hcV.getParent()).removeView(this.hcV);
            }
            this.mRootView.addView(this.hcV, this.hdd);
        }
    }

    private void initData(Bundle bundle) {
        if (getIntent() != null) {
            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
            alaLiveInfoData.parserJson(getIntent().getStringExtra("liveInfoData"));
            AlaLiveUserInfoData alaLiveUserInfoData = new AlaLiveUserInfoData();
            alaLiveUserInfoData.parserJson(getIntent().getStringExtra("liveUserData"));
            this.mLiveInfo = alaLiveInfoData;
            this.hcX = alaLiveUserInfoData;
            this.gFh = getIntent().getIntExtra("fromType", 0);
            if (this.gFh > 2 || this.gFh < 0) {
                this.gFh = 0;
            }
            this.hcY = getIntent().getStringExtra("authen_msg");
            this.hde = getIntent().getStringExtra("live_back_scheme");
            this.mCoverUrl = this.mLiveInfo.cover;
            this.mPortrait = getIntent().getStringExtra("host_portrait");
            this.nickName = getIntent().getStringExtra("user_nickname");
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = new AlaLiveRecorderPerfData();
            alaLiveRecorderPerfData.parseJson(getIntent().getStringExtra("live_perf_data"));
            this.hcU = alaLiveRecorderPerfData;
            if (this.hcU != null) {
                this.hcU.endViewShowTime = System.currentTimeMillis();
                if (this.mLiveInfo != null) {
                    this.hcU.liveID = Long.toString(this.mLiveInfo.live_id);
                }
            }
        }
        if (this.bur == null) {
            this.bur = new w();
        }
        if (this.mLiveInfo == null) {
            this.mLiveInfo = new AlaLiveInfoData();
        }
        if (this.hcX == null) {
            this.hcX = new AlaLiveUserInfoData();
        }
        if (this.bur != null) {
            this.bur.mLiveInfo = this.mLiveInfo;
            this.bur.aJV = this.hcX;
        }
    }

    private void initListener() {
        bZf();
        registerListener(this.hdg);
    }

    private void bZf() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021037, TbConfig.SERVER_ADDRESS + "ala/live/delRecord");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDeleteRecordResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.hcU != null) {
            this.hcU.endViewShowTime = System.currentTimeMillis() - this.hcU.endViewShowTime;
        }
        this.hcZ = new c();
        this.hcZ.a(this.hcU);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hdg);
        MessageManager.getInstance().unRegisterListener(this.hdf);
        if (this.hcZ != null) {
            this.hcZ.release();
        }
        if (this.hdc != null) {
            this.hdc.cx(false);
        }
        bZg();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis() - this.hda;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_STAYTIME);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", currentTimeMillis / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hdc != null) {
            this.hdc.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hda = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_ACCESS);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hdc != null) {
            this.hdc.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hdc != null) {
            this.hdc.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hdc != null) {
            this.hdc.onStop();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.hdc != null) {
            this.hdc.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hdc != null) {
            this.hdc.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        UbcStatisticManager.getInstance().clear();
    }

    public void bZg() {
        if (!TextUtils.isEmpty(this.hde)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hde);
                this.hde = null;
            }
        }
    }
}
