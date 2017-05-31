package com.baidu.tieba.frs.entelechy.view;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import tbclient.FrsPage.AgreeBanner;
/* loaded from: classes.dex */
class bb implements View.OnClickListener {
    final /* synthetic */ FrsHeaderPraiseView cah;
    private final /* synthetic */ AgreeBanner cai;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FrsHeaderPraiseView frsHeaderPraiseView, AgreeBanner agreeBanner) {
        this.cah = frsHeaderPraiseView;
        this.cai = agreeBanner;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!TextUtils.isEmpty(this.cai.url)) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(this.cah.getContext(), null, this.cai.url, true)));
        }
    }
}
