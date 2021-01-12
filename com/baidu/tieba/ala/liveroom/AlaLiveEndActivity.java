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
import com.baidu.live.data.x;
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
/* loaded from: classes10.dex */
public class AlaLiveEndActivity extends BaseActivity<AlaLiveEndActivity> {
    private x buq;
    private AlaLiveRecorderPerfData hka;
    private View hkb;
    private b hkc;
    private AlaLiveUserInfoData hkd;
    private c hkf;
    private long hkg;
    private TbImageView hkh;
    private com.baidu.live.liveroom.middleware.a.a hki;
    private String hkk;
    private String mCoverUrl;
    private AlaLiveInfoData mLiveInfo;
    private String mPortrait;
    private RelativeLayout mRootView;
    private String nickName;
    private int gMm = 0;
    private String hke = null;
    private RelativeLayout.LayoutParams hkj = new RelativeLayout.LayoutParams(-1, -1);
    private HttpMessageListener hkl = new HttpMessageListener(1021036) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            com.baidu.tieba.ala.liveroom.data.b chP;
            if ((httpResponsedMessage instanceof AlaCloseLiveHttpResonpnseMessage) && (chP = ((AlaCloseLiveHttpResonpnseMessage) httpResponsedMessage).chP()) != null && chP.mLiveInfo != null) {
                String str = "";
                if (chP.aFH != null) {
                    str = chP.aFH.nickName;
                }
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(AlaLiveEndActivity.this.nickName)) {
                    str = AlaLiveEndActivity.this.nickName;
                }
                if (AlaLiveEndActivity.this.buq != null) {
                    if (chP.mLiveInfo != null) {
                        AlaLiveEndActivity.this.buq.mLiveInfo = chP.mLiveInfo;
                    }
                    if (chP.aFH != null) {
                        AlaLiveEndActivity.this.buq.aFH = chP.aFH;
                    }
                }
                String str2 = chP.mLiveInfo.cover;
                if (!StringUtils.isNull(str2) && !str2.equals(AlaLiveEndActivity.this.mCoverUrl)) {
                    AlaLiveEndActivity.this.mCoverUrl = str2;
                    AlaLiveEndActivity.this.hkh.startLoad(str2, 39, false);
                }
                if (AlaLiveEndActivity.this.hki != null) {
                    AlaLiveEndActivity.this.hki.a(AlaLiveEndActivity.this.buq, str);
                } else if (AlaLiveEndActivity.this.hkc != null && AlaLiveEndActivity.this.hkc.a(AlaLiveEndActivity.this.buq, str) != null) {
                    AlaLiveEndActivity.this.hkb = AlaLiveEndActivity.this.hkc.a(AlaLiveEndActivity.this.buq, str);
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.hkh) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.hkh, 0, AlaLiveEndActivity.this.hkj);
                    }
                    if (AlaLiveEndActivity.this.mRootView.indexOfChild(AlaLiveEndActivity.this.hkb) < 0) {
                        AlaLiveEndActivity.this.mRootView.addView(AlaLiveEndActivity.this.hkb, AlaLiveEndActivity.this.hkj);
                    }
                }
            }
        }
    };
    HttpMessageListener hkm = new HttpMessageListener(1021037) { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.2
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
    private e hkn = new e() { // from class: com.baidu.tieba.ala.liveroom.AlaLiveEndActivity.3
        @Override // com.baidu.live.liveroom.middleware.a.e
        public void Lo() {
            AlaLiveEndActivity.this.closeActivity();
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
        @Override // com.baidu.live.liveroom.middleware.a.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void gN(String str) {
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
                this.hki = d.Ll().Lm();
                this.hki.q(getPageContext().getPageActivity());
            }
            initData(bundle);
            initListener();
            this.mRootView = new RelativeLayout(getPageContext().getPageActivity());
            this.hkh = new TbImageView(getPageContext().getPageActivity());
            this.hkh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            setContentView(this.mRootView);
            initView();
            MessageManager.getInstance().registerListener(this.hkl);
        }
    }

    private void initView() {
        if (this.hki != null) {
            this.hkb = this.hki.a(this.buq, this.hkn, this.gMm, this.hke, this.mPortrait, this.nickName);
        }
        if (this.hkb == null) {
            this.hkc = new b();
            this.hkc.q(getPageContext().getPageActivity());
            this.hkb = this.hkc.a(this.buq, this.hkn, this.gMm, this.hke, this.mPortrait, this.nickName);
        }
        if (!StringUtils.isNull(this.mCoverUrl)) {
            this.hkh.startLoad(this.mCoverUrl, 39, false);
            if (this.hkh.getParent() != null) {
                ((ViewGroup) this.hkh.getParent()).removeView(this.hkh);
            }
            this.mRootView.addView(this.hkh, this.hkj);
        }
        if (this.hkb != null) {
            if (this.hkb.getParent() != null) {
                ((ViewGroup) this.hkb.getParent()).removeView(this.hkb);
            }
            this.mRootView.addView(this.hkb, this.hkj);
        }
    }

    private void initData(Bundle bundle) {
        if (getIntent() != null) {
            AlaLiveInfoData alaLiveInfoData = new AlaLiveInfoData();
            alaLiveInfoData.parserJson(getIntent().getStringExtra("liveInfoData"));
            AlaLiveUserInfoData alaLiveUserInfoData = new AlaLiveUserInfoData();
            alaLiveUserInfoData.parserJson(getIntent().getStringExtra("liveUserData"));
            this.mLiveInfo = alaLiveInfoData;
            this.hkd = alaLiveUserInfoData;
            this.gMm = getIntent().getIntExtra("fromType", 0);
            if (this.gMm > 2 || this.gMm < 0) {
                this.gMm = 0;
            }
            this.hke = getIntent().getStringExtra("authen_msg");
            this.hkk = getIntent().getStringExtra("live_back_scheme");
            this.mCoverUrl = this.mLiveInfo.cover;
            this.mPortrait = getIntent().getStringExtra("host_portrait");
            this.nickName = getIntent().getStringExtra("user_nickname");
            AlaLiveRecorderPerfData alaLiveRecorderPerfData = new AlaLiveRecorderPerfData();
            alaLiveRecorderPerfData.parseJson(getIntent().getStringExtra("live_perf_data"));
            this.hka = alaLiveRecorderPerfData;
            if (this.hka != null) {
                this.hka.endViewShowTime = System.currentTimeMillis();
                if (this.mLiveInfo != null) {
                    this.hka.liveID = Long.toString(this.mLiveInfo.live_id);
                }
            }
        }
        if (this.buq == null) {
            this.buq = new x();
        }
        if (this.mLiveInfo == null) {
            this.mLiveInfo = new AlaLiveInfoData();
        }
        if (this.hkd == null) {
            this.hkd = new AlaLiveUserInfoData();
        }
        if (this.buq != null) {
            this.buq.mLiveInfo = this.mLiveInfo;
            this.buq.aFH = this.hkd;
        }
    }

    private void initListener() {
        bXV();
        registerListener(this.hkm);
    }

    private void bXV() {
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
        if (this.hka != null) {
            this.hka.endViewShowTime = System.currentTimeMillis() - this.hka.endViewShowTime;
        }
        this.hkf = new c();
        this.hkf.a(this.hka);
        if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.STAYTIME_MASTER_CLOSE_LIVE_END);
            alaStaticItem.addParams("end_time", System.currentTimeMillis() + "");
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        super.onDestroy();
        MessageManager.getInstance().unRegisterListener(this.hkm);
        MessageManager.getInstance().unRegisterListener(this.hkl);
        if (this.hkf != null) {
            this.hkf.release();
        }
        if (this.hki != null) {
            this.hki.cw(false);
        }
        bXW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis() - this.hkg;
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_STAYTIME);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            alaStaticItem.addParams("time", currentTimeMillis / 1000);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hki != null) {
            this.hki.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hkg = System.currentTimeMillis();
        if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(QMStaticKeys.QM_STATIC_LIVE_CLOSE_ACCESS);
            if (this.mLiveInfo != null) {
                alaStaticItem.addParams("live_id", this.mLiveInfo.live_id + "");
                alaStaticItem.addParams("room_id", this.mLiveInfo.room_id + "");
            }
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
        if (this.hki != null) {
            this.hki.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hki != null) {
            this.hki.onActivityResult(i, i2, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.hki != null) {
            this.hki.onStop();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.hki != null) {
            this.hki.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.hki != null) {
            this.hki.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        UbcStatisticManager.getInstance().clear();
    }

    public void bXW() {
        if (!TextUtils.isEmpty(this.hkk)) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                BrowserHelper.startInternalWebActivity(getPageContext().getPageActivity(), this.hkk);
                this.hkk = null;
            }
        }
    }
}
