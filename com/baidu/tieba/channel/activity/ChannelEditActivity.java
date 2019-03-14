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
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.tieba.channel.config.ChannelEditActivityConfig;
import com.baidu.tieba.channel.data.ChannelInfo;
import com.baidu.tieba.channel.message.ChannelUpdateInfoHttpResponsedMessage;
import com.baidu.tieba.channel.model.ChannelEditModel;
import com.baidu.tieba.channel.view.c;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class ChannelEditActivity extends BaseActivity<ChannelEditActivity> {
    public static boolean isChanged = false;
    private c emO;
    private ChannelEditModel emP;
    private ChannelInfo emQ;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private HttpMessageListener emR = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_UPDATE_INFO) { // from class: com.baidu.tieba.channel.activity.ChannelEditActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && (httpResponsedMessage instanceof ChannelUpdateInfoHttpResponsedMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    String errorString = httpResponsedMessage.getErrorString();
                    String string = ChannelEditActivity.this.getResources().getString(d.j.neterror);
                    if (!StringUtils.isNull(errorString)) {
                        string = errorString;
                    }
                    ChannelEditActivity.this.getPageContext().showToast(string);
                    return;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016512, ChannelEditActivity.this.emQ));
                ChannelEditActivity.isChanged = false;
                ChannelEditActivity.this.getPageContext().showToast(ChannelEditActivity.this.getPageContext().getString(d.j.success));
                ChannelEditActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.emQ = (ChannelInfo) getIntent().getSerializableExtra(ChannelEditActivityConfig.CHANNEL_INFO);
        isChanged = false;
        this.emO = new c(this);
        this.emP = new ChannelEditModel(this);
        aRk();
        this.emO.c(this.emQ);
    }

    private void aRk() {
        registerListener(this.emR);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.emO.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.emO.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.emO.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.emO.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 25006:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            a(intent, 25010, 1.0f);
                            return;
                        } else {
                            a(intent, 25011, 4, 1.0f);
                            return;
                        }
                    }
                    return;
                case 25007:
                    if (intent != null) {
                        if (intent.getBooleanExtra(AlbumActivityConfig.CAMERA_RESULT, false)) {
                            a(intent, 25008, 0.3f);
                            return;
                        } else {
                            a(intent, 25009, 5, 0.3f);
                            return;
                        }
                    }
                    return;
                case 25008:
                case 25009:
                    isChanged = true;
                    PhotoUrlData photoUrlData = (PhotoUrlData) intent.getSerializableExtra("pic_info");
                    this.emQ.setChannelCover(photoUrlData.getBigurl());
                    this.emQ.setChannelSmallCover(photoUrlData.getBigurl());
                    this.emO.c(this.emQ);
                    return;
                case 25010:
                case 25011:
                    isChanged = true;
                    this.emQ.setChannelAvatar(((PhotoUrlData) intent.getSerializableExtra("pic_info")).getBigurl());
                    this.emO.c(this.emQ);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(Intent intent, int i, float f) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12001, i, null, TbadkCoreApplication.getCurrentAccountObj(), f)));
    }

    private void a(Intent intent, int i, int i2, float f) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.T(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_FACE_CHECK, i, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), i2, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void aRl() {
        if (!j.kY()) {
            showToast(d.j.neterror);
            return;
        }
        this.emQ.setDescription(this.emO.getDescription());
        this.emP.b(this.emQ);
    }

    public ChannelInfo aRm() {
        return this.emQ;
    }
}
