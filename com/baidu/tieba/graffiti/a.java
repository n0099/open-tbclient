package com.baidu.tieba.graffiti;

import android.content.Context;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GraffitiVcodeActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.base.e {
    private String ciA;
    private final HttpMessageListener ciB;
    private v ciz;
    private String forumId;
    private int height;
    private Context mContext;
    private String picId;
    private String threadId;
    private int width;

    public a(BaseActivity baseActivity) {
        super(baseActivity.getPageContext());
        this.ciB = new b(this, CmdConfigHttp.CMD_COMMIT_GRAFFITI);
        this.mContext = baseActivity.getActivity();
        registerListener();
    }

    private void registerListener() {
        this.ciB.setTag(getUniqueId());
        this.ciB.setSelfListener(true);
        registerListener(this.ciB);
    }

    public void a(v vVar) {
        this.ciz = vVar;
    }

    public void a(String str, String str2, String str3, int i, int i2, String str4, String str5, String str6) {
        this.forumId = str2;
        this.threadId = str;
        this.picId = str3;
        this.width = i;
        this.height = i2;
        this.ciA = str4;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_COMMIT_GRAFFITI);
        httpMessage.addParam("tid", str);
        httpMessage.addParam("fid", str2);
        httpMessage.addParam(GraffitiVcodeActivityConfig.PIC_ID, str3);
        httpMessage.addParam("graffiti_check", str4);
        httpMessage.addParam(GraffitiVcodeActivityConfig.WIDTH, i);
        httpMessage.addParam(GraffitiVcodeActivityConfig.HEIGHT, i2);
        if (!StringUtils.isNull(str5)) {
            httpMessage.addParam("vcode", str5);
        }
        if (!StringUtils.isNull(str6)) {
            httpMessage.addParam(GraffitiVcodeActivityConfig.VCODE_MD5, str6);
        }
        sendMessage(httpMessage);
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }
}
