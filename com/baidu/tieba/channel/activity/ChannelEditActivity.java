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
import com.baidu.sapi2.utils.SapiGIDEvent;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.EditHeadActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
    private c eIZ;
    private ChannelEditModel eJa;
    private ChannelInfo eJb;
    private final WriteImagesInfo writeImagesInfo = new WriteImagesInfo(1);
    private HttpMessageListener eJc = new HttpMessageListener(CmdConfigHttp.CMD_CHANNEL_UPDATE_INFO) { // from class: com.baidu.tieba.channel.activity.ChannelEditActivity.1
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
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016512, ChannelEditActivity.this.eJb));
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
        this.eJb = (ChannelInfo) getIntent().getSerializableExtra(ChannelEditActivityConfig.CHANNEL_INFO);
        isChanged = false;
        this.eIZ = new c(this);
        this.eJa = new ChannelEditModel(this);
        baZ();
        this.eIZ.c(this.eJb);
    }

    private void baZ() {
        registerListener(this.eJc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eIZ.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.eIZ.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.eIZ.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eIZ.onChangeSkinType(i);
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
                    this.eJb.setChannelCover(photoUrlData.getBigurl());
                    this.eJb.setChannelSmallCover(photoUrlData.getBigurl());
                    this.eIZ.c(this.eJb);
                    return;
                case 25010:
                case 25011:
                    isChanged = true;
                    this.eJb.setChannelAvatar(((PhotoUrlData) intent.getSerializableExtra("pic_info")).getBigurl());
                    this.eIZ.c(this.eJb);
                    return;
                default:
                    return;
            }
        }
    }

    private void a(Intent intent, int i, float f) {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), SapiGIDEvent.TIME_FREQ, i, null, TbadkCoreApplication.getCurrentAccountObj(), f)));
    }

    private void a(Intent intent, int i, int i2, float f) {
        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
        if (stringExtra != null) {
            this.writeImagesInfo.parseJson(stringExtra);
            this.writeImagesInfo.updateQuality();
            if (!v.aa(this.writeImagesInfo.getChosedFiles())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new EditHeadActivityConfig(getPageContext().getPageActivity(), 12002, i, intent.getData(), TbadkCoreApplication.getCurrentAccountObj(), i2, this.writeImagesInfo.getChosedFiles().get(0).getFilePath(), f)));
            }
            this.writeImagesInfo.clear();
        }
    }

    public void bba() {
        if (!j.kc()) {
            showToast(R.string.neterror);
            return;
        }
        this.eJb.setDescription(this.eIZ.getDescription());
        this.eJa.b(this.eJb);
    }

    public ChannelInfo bbb() {
        return this.eJb;
    }
}
