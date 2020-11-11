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
import com.baidu.tieba.ala.liveroom.q.c;
import com.baidu.tieba.ala.liveroom.views.b;
import java.io.File;
/* loaded from: classes4.dex */
public class AlaLiveEndActivity extends BaseActivity<AlaLiveEndActivity> {
    private w bqS;
    private AlaLiveRecorderPerfData gTY;
    private View gTZ;
    private b gUa;
    private AlaLiveUserInfoData gUb;
    private c gUd;
    private long gUe;
    private TbImageView gUf;
    private com.baidu.live.liveroom.middleware.a.a gUg;
    private String gUi;
    private String mCoverUrl;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private RelativeLayout mRootView;
    private String nickName;
    private int gwN = 0;
    private String gUc = null;
    private RelativeLayout.LayoutParams gUh = new RelativeLayout.LayoutParams(-1, -1);
    private HttpMessageListener gUj = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.liveroom.data.b cfG;
            if ((httpResponsedMessage instanceof AlaCloseLiveHttpResonpnseMessage) && (cfG = ((AlaCloseLiveHttpResonpnseMessage) httpResponsedMessage).cfG()) != null && cfG.mLiveInfo != null) {
                String str = "";
                if (cfG.aIV != null) {
                    str = cfG.aIV.nickName;
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(AlaLiveEndActivity.this.nickName)) {
                    str = AlaLiveEndActivity.this.nickName;
                }
                if (AlaLiveEndActivity.this.bqS != null) {
                    if (cfG.mLiveInfo != null) {
                        AlaLiveEndActivity.this.bqS.mLiveInfo = cfG.mLiveInfo;
                    }
                    if (cfG.aIV != null) {
                        AlaLiveEndActivity.this.bqS.aIV = cfG.aIV;
                    }
                }
                String str2 = cfG.mLiveInfo.cover;
                if (!StringUtils.isNull(str2) && !str2.equals(AlaLiveEndActivity.this.mCoverUrl)) {
                    AlaLiveEndActivity.this.mCoverUrl = str2;
                    AlaLiveEndActivity.this.gUf.startLoad(str2, 39, false);
                }
                if (AlaLiveEndActivity.this.gUg != null) {
                    AlaLiveEndActivity.this.gUg.a(AlaLiveEndActivity.this.bqS, str);
                } else if (AlaLiveEndActivity.this.gUa != null && AlaLiveEndActivity.this.gUa.a(AlaLiveEndActivity.this.bqS, str) != null) {
                    AlaLiveEndActivity.this.gTZ = AlaLiveEndActivity.this.gUa.a(AlaLiveEndActivity.this.bqS, str);
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.gUf) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.gUf, 0, AlaLiveEndActivity.this.gUh);
                    }
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.gTZ) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.gTZ, AlaLiveEndActivity.this.gUh);
                    }
                }
            }
        }
    };
    HttpMessageListener gUk = new HttpMessageListener(1021037) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.2
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
    private e gUl = new e() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.3
        @Override // com.baidu.live.liveroom.middleware.a.e
        public void NM() {
            AlaLiveEndActivity.this.closeActivity();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.liveroom.middleware.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void hP(String str) {
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
                this.gUg = d.NJ().NK();
                this.gUg.s(getPageContext().getPageActivity());
            }
            initData(bundle);
            initListener();
            this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
            this.gUf = new TbImageView(getPageContext().getPageActivity());
            this.gUf.setScaleType(ImageView.ScaleType.CENTER_CROP);
            setContentView(this.mRootView);
            initView();
            MessageManager.getInstance().registerListener(this.gUj);
        }
    }

    private void initView() {
        if (this.gUg != null) {
            this.gTZ = this.gUg.a(this.bqS, this.gUl, this.gwN, this.gUc, this.mPortrait, this.nickName);
        }
        if (this.gTZ == null) {
            this.gUa = new b();
            this.gUa.s(getPageContext().getPageActivity());
            this.gTZ = this.gUa.a(this.bqS, this.gUl, this.gwN, this.gUc, this.mPortrait, this.nickName);
        }
        if (!StringUtils.isNull(this.mCoverUrl)) {
            this.gUf.startLoad(this.mCoverUrl, 39, false);
            if (this.gUf.getParent() != null) {
                ((ViewGroup) this.gUf.getParent()).removeView(this.gUf);
            }
            this.mRootView.addView(this.gUf, this.gUh);
        }
        if (this.gTZ != null) {
            if (this.gTZ.getParent() != null) {
                ((ViewGroup) this.gTZ.getParent()).removeView(this.gTZ);
            }
            this.mRootView.addView(this.gTZ, this.gUh);
        }
    }

    private void initData(Bundle bundle) {
        if (getIntent() != null) {
            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
            alaLiveInfoData.parserJson(getIntent().getStringExtra("liveInfoData"));
            AlaLiveUserInfoData alaLiveUserInfoData = new AlaLiveUserInfoData();
            alaLiveUserInfoData.parserJson(getIntent().getStringExtra("liveUserData"));
            this.mLiveInfo = alaLiveInfoData;
            this.gUb = alaLiveUserInfoData;
            this.gwN = getIntent().getIntExtra("fromType", 0);
            if (this.gwN > 2 || this.gwN < 0) {
                this.gwN = 0;
            }
            this.gUc = getIntent().getStringExtra("authen_msg");
            this.gUi = getIntent().getStringExtra("live_back_scheme");
            this.mCoverUrl = this.mLiveInfo.cover;
            this.mPortrait = getIntent().getStringExtra("host_portrait");
            this.nickName = getIntent().getStringExtra("user_nickname");
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = new AlaLiveRecorderPerfData();
            alaLiveRecorderPerfData.parseJson(getIntent().getStringExtra("live_perf_data"));
            this.gTY = alaLiveRecorderPerfData;
            if (this.gTY != null) {
                this.gTY.endViewShowTime = System.currentTimeMillis();
                if (this.mLiveInfo != null) {
                    this.gTY.liveID = Long.toString(this.mLiveInfo.live_id);
                }
            }
        }
        if (this.bqS == null) {
            this.bqS = new w();
        }
        if (this.mLiveInfo == null) {
            this.mLiveInfo = new AlaLiveInfoData();
        }
        if (this.gUb == null) {
            this.gUb = new AlaLiveUserInfoData();
        }
        if (this.bqS != null) {
            this.bqS.mLiveInfo = this.mLiveInfo;
            this.bqS.aIV = this.gUb;
        }
    }

    private void initListener() {
        bWb();
        registerListener(this.gUk);
    }

    private void bWb() {
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
        if (this.gTY != null) {
            this.gTY.endViewShowTime = System.currentTimeMillis() - this.gTY.endViewShowTime;
        }
        this.gUd = new c();
        this.gUd.a(this.gTY);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.gUk);
        MessageManager.getInstance().unRegisterListener(this.gUj);
        if (this.gUd != null) {
            this.gUd.release();
        }
        if (this.gUg != null) {
            this.gUg.ch(false);
        }
        bWc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis() - this.gUe;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_STAYTIME);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", currentTimeMillis / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gUg != null) {
            this.gUg.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gUe = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_ACCESS);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.gUg != null) {
            this.gUg.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.gUg != null) {
            this.gUg.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.gUg != null) {
            this.gUg.onStop();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.gUg != null) {
            this.gUg.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.gUg != null) {
            this.gUg.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        UbcStatisticManager.getInstance().clear();
    }

    public void bWc() {
        if (!TextUtils.isEmpty(this.gUi)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.gUi);
                this.gUi = null;
            }
        }
    }
}
