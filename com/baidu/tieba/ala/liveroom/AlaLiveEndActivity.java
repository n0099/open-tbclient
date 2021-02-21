package com.baidu.tieba.ala.liveroom;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.data.ab;
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
import com.baidu.tieba.ala.liveroom.n.c;
import com.baidu.tieba.ala.liveroom.views.b;
import java.io.File;
/* loaded from: classes11.dex */
public class AlaLiveEndActivity extends BaseActivity<AlaLiveEndActivity> {
    private ab bxN;
    private AlaLiveRecorderPerfData hoG;
    private View hoH;
    private b hoI;
    private AlaLiveUserInfoData hoJ;
    private c hoL;
    private long hoM;
    private TbImageView hoN;
    private com.baidu.live.liveroom.middleware.a.a hoO;
    private String hoQ;
    private String mCoverUrl;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private RelativeLayout mRootView;
    private String nickName;
    private int gPg = 0;
    private String hoK = null;
    private RelativeLayout.LayoutParams hoP = new RelativeLayout.LayoutParams(-1, -1);
    private HttpMessageListener hoR = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.liveroom.data.b ciP;
            if ((httpResponsedMessage instanceof AlaCloseLiveHttpResonpnseMessage) && (ciP = ((AlaCloseLiveHttpResonpnseMessage) httpResponsedMessage).ciP()) != null && ciP.mLiveInfo != null) {
                String str = "";
                if (ciP.aId != null) {
                    str = ciP.aId.nickName;
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(AlaLiveEndActivity.this.nickName)) {
                    str = AlaLiveEndActivity.this.nickName;
                }
                if (AlaLiveEndActivity.this.bxN != null) {
                    if (ciP.mLiveInfo != null) {
                        AlaLiveEndActivity.this.bxN.mLiveInfo = ciP.mLiveInfo;
                    }
                    if (ciP.aId != null) {
                        AlaLiveEndActivity.this.bxN.aId = ciP.aId;
                    }
                }
                String str2 = ciP.mLiveInfo.cover;
                if (!StringUtils.isNull(str2) && !str2.equals(AlaLiveEndActivity.this.mCoverUrl)) {
                    AlaLiveEndActivity.this.mCoverUrl = str2;
                    AlaLiveEndActivity.this.hoN.startLoad(str2, 39, false);
                }
                if (AlaLiveEndActivity.this.hoO != null) {
                    AlaLiveEndActivity.this.hoO.a(AlaLiveEndActivity.this.bxN, str);
                } else if (AlaLiveEndActivity.this.hoI != null && AlaLiveEndActivity.this.hoI.a(AlaLiveEndActivity.this.bxN, str) != null) {
                    AlaLiveEndActivity.this.hoH = AlaLiveEndActivity.this.hoI.a(AlaLiveEndActivity.this.bxN, str);
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.hoN) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.hoN, 0, AlaLiveEndActivity.this.hoP);
                    }
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.hoH) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.hoH, AlaLiveEndActivity.this.hoP);
                    }
                }
            }
        }
    };
    HttpMessageListener hoS = new HttpMessageListener(1021037) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.2
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
    private e hoT = new e() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.3
        @Override // com.baidu.live.liveroom.middleware.a.e
        public void MM() {
            AlaLiveEndActivity.this.closeActivity();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.liveroom.middleware.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void hm(String str) {
            File file;
            if (AlaLiveEndActivity.this.mLiveInfo != null && !TextUtils.isEmpty(str)) {
                try {
                    file = new File(str);
                } catch (Exception e) {
                    e = e;
                    file = null;
                }
                if (file != null) {
                    try {
                    } catch (Exception e2) {
                        e = e2;
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
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (TbadkCoreApplication.getInst().isOther()) {
                this.hoO = d.MJ().MK();
                this.hoO.q(getPageContext().getPageActivity());
            }
            initData(bundle);
            initListener();
            this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
            this.hoN = new TbImageView(getPageContext().getPageActivity());
            this.hoN.setScaleType(ImageView.ScaleType.CENTER_CROP);
            setContentView(this.mRootView);
            initView();
            MessageManager.getInstance().registerListener(this.hoR);
        }
    }

    private void initView() {
        if (this.hoO != null) {
            this.hoH = this.hoO.a(this.bxN, this.hoT, this.gPg, this.hoK, this.mPortrait, this.nickName);
        }
        if (this.hoH == null) {
            this.hoI = new b();
            this.hoI.q(getPageContext().getPageActivity());
            this.hoH = this.hoI.a(this.bxN, this.hoT, this.gPg, this.hoK, this.mPortrait, this.nickName);
        }
        if (!StringUtils.isNull(this.mCoverUrl)) {
            this.hoN.startLoad(this.mCoverUrl, 39, false);
            if (this.hoN.getParent() != null) {
                ((ViewGroup) this.hoN.getParent()).removeView(this.hoN);
            }
            this.mRootView.addView(this.hoN, this.hoP);
        }
        if (this.hoH != null) {
            if (this.hoH.getParent() != null) {
                ((ViewGroup) this.hoH.getParent()).removeView(this.hoH);
            }
            this.mRootView.addView(this.hoH, this.hoP);
        }
    }

    private void initData(Bundle bundle) {
        if (getIntent() != null) {
            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
            alaLiveInfoData.parserJson(getIntent().getStringExtra("liveInfoData"));
            AlaLiveUserInfoData alaLiveUserInfoData = new AlaLiveUserInfoData();
            alaLiveUserInfoData.parserJson(getIntent().getStringExtra("liveUserData"));
            this.mLiveInfo = alaLiveInfoData;
            this.hoJ = alaLiveUserInfoData;
            this.gPg = getIntent().getIntExtra("fromType", 0);
            if (this.gPg > 2 || this.gPg < 0) {
                this.gPg = 0;
            }
            this.hoK = getIntent().getStringExtra("authen_msg");
            this.hoQ = getIntent().getStringExtra("live_back_scheme");
            this.mCoverUrl = this.mLiveInfo.cover;
            this.mPortrait = getIntent().getStringExtra("host_portrait");
            this.nickName = getIntent().getStringExtra("user_nickname");
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = new AlaLiveRecorderPerfData();
            alaLiveRecorderPerfData.parseJson(getIntent().getStringExtra("live_perf_data"));
            this.hoG = alaLiveRecorderPerfData;
            if (this.hoG != null) {
                this.hoG.endViewShowTime = System.currentTimeMillis();
                if (this.mLiveInfo != null) {
                    this.hoG.liveID = Long.toString(this.mLiveInfo.live_id);
                }
            }
        }
        if (this.bxN == null) {
            this.bxN = new ab();
        }
        if (this.mLiveInfo == null) {
            this.mLiveInfo = new AlaLiveInfoData();
        }
        if (this.hoJ == null) {
            this.hoJ = new AlaLiveUserInfoData();
        }
        if (this.bxN != null) {
            this.bxN.mLiveInfo = this.mLiveInfo;
            this.bxN.aId = this.hoJ;
        }
    }

    private void initListener() {
        bZa();
        registerListener(this.hoS);
    }

    private void bZa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021037, TbConfig.SERVER_ADDRESS + "ala/live/delRecord");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsUseCurrentBDUSS(true);
        tbHttpMessageTask.setResponsedClass(AlaDeleteRecordResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.hoG != null) {
            this.hoG.endViewShowTime = System.currentTimeMillis() - this.hoG.endViewShowTime;
        }
        this.hoL = new c();
        this.hoL.a(this.hoG);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hoS);
        MessageManager.getInstance().unRegisterListener(this.hoR);
        if (this.hoL != null) {
            this.hoL.release();
        }
        if (this.hoO != null) {
            this.hoO.cF(false);
        }
        bZb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis() - this.hoM;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_STAYTIME);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", currentTimeMillis / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hoO != null) {
            this.hoO.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hoM = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_ACCESS);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hoO != null) {
            this.hoO.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hoO != null) {
            this.hoO.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hoO != null) {
            this.hoO.onStop();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.hoO != null) {
            this.hoO.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hoO != null) {
            this.hoO.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        UbcStatisticManager.getInstance().clear();
    }

    public void bZb() {
        if (!TextUtils.isEmpty(this.hoQ)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hoQ);
                this.hoQ = null;
            }
        }
    }
}
