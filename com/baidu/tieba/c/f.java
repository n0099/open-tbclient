package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    bh Wd;
    private NavigationBarCoverTip eOc;
    private View eOd;
    private TextView eOe;
    private TextView eOf;
    private com.baidu.tbadk.core.view.b eOg;
    private boolean eOh = false;
    private boolean eOi = false;
    private final com.baidu.adp.framework.listener.a eOj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aVf();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                f.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                f.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public f(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.eOc = navigationBarCoverTip;
        this.eOj.setTag(tbPageContext.getUniqueId());
        this.eOj.getHttpMessageListener().setSelfListener(true);
        this.eOj.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eOj);
    }

    public void iV(boolean z) {
        this.eOh = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.eOc != null) {
            this.postId = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.e(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.eOi = false;
                if (this.eOd == null) {
                    this.eOd = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.eOe = (TextView) this.eOd.findViewById(R.id.write_thread_success_tips);
                    this.eOf = (TextView) this.eOd.findViewById(R.id.share_icon);
                }
                am.j(this.eOe, R.color.cp_cont_a);
                am.j(this.eOf, R.color.cp_cont_a);
                am.k(this.eOf, R.drawable.share_now_bg);
                am.l(this.eOc, R.color.cp_link_tip_a_alpha95);
                this.eOf.setOnClickListener(this);
                this.eOc.a(this.mActivity, this.eOd, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.eOg == null) {
            this.eOg = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.eOg.em(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVf() {
        if (this.eOg != null) {
            this.eOg.em(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.eOi) {
            this.eOi = true;
            if (!j.kc()) {
                this.mPageContext.showToast(R.string.neterror);
                this.eOc.hideTip();
                return;
            }
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.ajw().ajy() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.eOc.hideTip();
            alk();
        }
    }

    private void alk() {
        an anVar = new an("c12386");
        anVar.n("tid", this.threadId);
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.P("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.Wd = new bh();
        this.Wd.a(getMyPostResIdl.data.thread_info);
        alm();
    }

    private void alm() {
        if (this.Wd != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.Wd.getFid());
            String aeH = this.Wd.aeH();
            String title = this.Wd.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Wd.getAbstract();
            }
            String tid = this.Wd.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String t = t(this.Wd);
            Uri parse = t == null ? null : Uri.parse(t);
            String str2 = this.Wd.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.clK = str2;
            eVar.linkUrl = str;
            eVar.bMX = 5;
            eVar.clB = this.eOh;
            eVar.extData = tid;
            eVar.clN = 3;
            eVar.fid = valueOf;
            eVar.clE = aeH;
            eVar.tid = tid;
            eVar.clx = true;
            eVar.clM = getShareObjSource();
            eVar.clR = u(this.Wd);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.Wd);
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.cmb = this.Wd.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.clN);
            bundle.putInt("obj_type", eVar.clR);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMX);
            eVar.E(bundle);
            e.bch().a(new ShareDialogConfig((Context) this.mActivity, eVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String t(bh bhVar) {
        if (bhVar == null || bhVar.aeM() == null) {
            return null;
        }
        ArrayList<MediaData> aeM = bhVar.aeM();
        int size = aeM.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aeM.get(i);
            if (mediaData != null && mediaData.getType() == 3) {
                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                    return mediaData.getThumbnails_url();
                }
                if (!StringUtils.isNull(mediaData.getPicUrl())) {
                    return mediaData.getPicUrl();
                }
            }
        }
        return null;
    }

    private int u(bh bhVar) {
        if (bhVar != null) {
            if (bhVar.aeE()) {
                return 4;
            }
            if (bhVar.aez() == 1) {
                return 3;
            }
            return bhVar.afO() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.eOc != null) {
            this.eOc.onDestroy();
        }
    }
}
