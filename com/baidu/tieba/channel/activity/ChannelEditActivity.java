package com.baidu.tieba.channel.activity;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.channel.config.ChannelEditActivityConfig;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.message.ChannelUpdateInfoHttpResponsedMessage;
import com.baidu.tieba.channel.model.ChannelEditModel;
import com.baidu.tieba.channel.view.c;
/* loaded from: classes6.dex */
public class ChannelEditActivity extends BaseActivity<ChannelEditActivity> {
    public static boolean isChanged = false;
    private c eRE;
    private ChannelEditModel eRF;
    private ChannelInfo eRG;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private HttpMessageListener eRH = new HttpMessageListener(1003315) { // from class: com.baidu.tieba.channel.activity.ChannelEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdateInfoHttpResponsedMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    String string = ChannelEditActivity.this.getResources().getString(R.string.neterror);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    ChannelEditActivity.this.getPageContext().showToast(string);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANNEL_HOME_INFO_UPDATE, ChannelEditActivity.this.eRG));
                ChannelEditActivity.isChanged = false;
                ChannelEditActivity.this.getPageContext().showToast(ChannelEditActivity.this.getPageContext().getString(R.string.success));
                ChannelEditActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eRG = (ChannelInfo) getIntent().getSerializableExtra(ChannelEditActivityConfig.CHANNEL_INFO);
        isChanged = false;
        this.eRE = new c(this);
        this.eRF = new ChannelEditModel(this);
        bbb();
        this.eRE.c(this.eRG);
    }

    private void bbb() {
        registerListener(this.eRH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eRE.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eRE.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eRE.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eRE.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_CHANNEL_AVATAR /* 25006 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            a(intent, RequestResponseCode.REQUEST_CHANNEL_AVATAR_CAMERA_VIEW, 1.0f);
                            return;
                        } else {
                            a(intent, RequestResponseCode.REQUEST_CHANNEL_AVATAR_ALBUM_VIEW, 4, 1.0f);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_CHANNEL_COVER /* 25007 */:
                    if (intent != null) {
                        if (intent.getBooleanExtra("camera_result", false)) {
                            a(intent, RequestResponseCode.REQUEST_CHANNEL_COVER_CAMERA_VIEW, 0.3f);
                            return;
                        } else {
                            a(intent, RequestResponseCode.REQUEST_CHANNEL_COVER_ALBUM_VIEW, 5, 0.3f);
                            return;
                        }
                    }
                    return;
                case RequestResponseCode.REQUEST_CHANNEL_COVER_CAMERA_VIEW /* 25008 */:
                case RequestResponseCode.REQUEST_CHANNEL_COVER_ALBUM_VIEW /* 25009 */:
                    isChanged = true;
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra("pic_info");
                    this.eRG.setChannelCover(photoUrlData.getBigurl());
                    this.eRG.setChannelSmallCover(photoUrlData.getBigurl());
                    this.eRE.c(this.eRG);
                    return;
                case RequestResponseCode.REQUEST_CHANNEL_AVATAR_CAMERA_VIEW /* 25010 */:
                case RequestResponseCode.REQUEST_CHANNEL_AVATAR_ALBUM_VIEW /* 25011 */:
                    isChanged = true;
                    this.eRG.setChannelAvatar(((PhotoUrlData) intent.getSerializableExtra("pic_info")).getBigurl());
                    this.eRE.c(this.eRG);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(Intent intent, int i, float f) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, i, null, TbadkCoreApplication.getCurrentAccountObj(), f)));
    }

    private void a(Intent intent, int i, int i2, float f) {
        String stringExtra = intent.getStringExtra("album_result");
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.isEmpty(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) RequestResponseCode.REQUEST_ALBUM_IMAGE, i, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), i2, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bbc() {
        if (!j.isNetWorkAvailable()) {
            showToast(R.string.neterror);
            return;
        }
        this.eRG.setDescription(this.eRE.getDescription());
        this.eRF.b(this.eRG);
    }

    public ChannelInfo bbd() {
        return this.eRG;
    }
}
