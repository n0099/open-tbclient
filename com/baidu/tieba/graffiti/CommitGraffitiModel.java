package com.baidu.tieba.graffiti;

import android.content.Context;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class CommitGraffitiModel extends BdBaseModel {
    private t cnp;
    private String cnq;
    private final HttpMessageListener cnr;
    private String forumId;
    private int height;
    private Context mContext;
    private String picId;
    private String threadId;
    private int width;

    public CommitGraffitiModel(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.cnr = new a(this, CmdConfigHttp.CMD_COMMIT_GRAFFITI);
        this.mContext = baseActivity.getActivity();
        registerListener();
    }

    private void registerListener() {
        this.cnr.setTag(getUniqueId());
        this.cnr.setSelfListener(true);
        registerListener(this.cnr);
    }

    public void a(t tVar) {
        this.cnp = tVar;
    }

    public void a(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6) {
        this.forumId = str2;
        this.threadId = str;
        this.picId = str3;
        this.width = i;
        this.height = i2;
        this.cnq = str4;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_COMMIT_GRAFFITI);
        httpMessage.addParam("tid", str);
        httpMessage.addParam("fid", str2);
        httpMessage.addParam(GraffitiVcodeActivityConfig.PIC_ID, str3);
        httpMessage.addParam("graffiti_check", str4);
        httpMessage.addParam("width", i);
        httpMessage.addParam("height", i2);
        if (!StringUtils.isNull(str5)) {
            httpMessage.addParam("vcode", str5);
        }
        if (!StringUtils.isNull(str6)) {
            httpMessage.addParam(GraffitiVcodeActivityConfig.VCODE_MD5, str6);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }
}
