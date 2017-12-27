package com.baidu.tieba.d;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    be aXV;
    private c bbW;
    private NavigationBarCoverTip cYN;
    private View cYO;
    private TextView cYP;
    private TextView cYQ;
    private com.baidu.tbadk.core.view.b cYR;
    private boolean cYS = false;
    private boolean cYT = false;
    private final com.baidu.adp.framework.listener.a cYU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.this.afk();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                d.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                d.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public d(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.cYN = navigationBarCoverTip;
        this.cYU.setTag(tbPageContext.getUniqueId());
        this.cYU.getHttpMessageListener().setSelfListener(true);
        this.cYU.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cYU);
        this.bbW = new c(this.mPageContext);
    }

    public void eO(boolean z) {
        this.cYS = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cYN != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cYT = false;
                if (this.cYO == null) {
                    this.cYN.removeAllViews();
                    this.cYO = this.mActivity.getLayoutInflater().inflate(d.h.write_thread_share_guide, (ViewGroup) this.cYN, true);
                    this.cYP = (TextView) this.cYO.findViewById(d.g.write_thread_success_tips);
                    this.cYQ = (TextView) this.cYO.findViewById(d.g.share_icon);
                }
                aj.r(this.cYP, d.C0108d.cp_cont_i);
                aj.r(this.cYQ, d.C0108d.cp_cont_i);
                aj.s(this.cYQ, d.f.share_now_bg);
                this.cYQ.setOnClickListener(this);
                this.cYN.j(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cYR == null) {
            this.cYR = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.cYR.bm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afk() {
        if (this.cYR != null) {
            this.cYR.bm(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cYT) {
            this.cYT = true;
            if (!j.oI()) {
                this.mPageContext.showToast(d.j.neterror);
                this.cYN.hideTip();
                return;
            }
            int ao = l.ao(TbadkCoreApplication.getInst());
            int aq = l.aq(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = an.CS().CU() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ao, aq, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cYN.hideTip();
            Ee();
        }
    }

    private void Ee() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.aXV = new be();
        this.aXV.a(getMyPostResIdl.data.thread_info);
        Ef();
    }

    private void Ef() {
        if (this.aXV != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aXV.getFid());
            String zd = this.aXV.zd();
            String title = this.aXV.getTitle();
            String tid = this.aXV.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aXV);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aXV.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.biQ = str2;
            dVar.linkUrl = str;
            dVar.aPf = 5;
            dVar.biJ = this.cYS;
            dVar.extData = tid;
            dVar.biT = 3;
            dVar.fid = valueOf;
            dVar.biL = zd;
            dVar.tid = tid;
            dVar.biI = true;
            dVar.biS = getShareObjSource();
            dVar.biU = b(this.aXV);
            if (parse != null) {
                dVar.biN = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aXV);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.biT);
            bundle.putInt("obj_type", dVar.biU);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPf);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            if (this.bbW == null) {
                this.bbW = new c(this.mPageContext);
            }
            this.bbW.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(be beVar) {
        if (beVar == null || beVar.zi() == null) {
            return null;
        }
        ArrayList<MediaData> zi = beVar.zi();
        int size = zi.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zi.get(i);
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

    private int b(be beVar) {
        if (beVar != null) {
            if (beVar.za()) {
                return 4;
            }
            if (beVar.yU() == 1) {
                return 3;
            }
            return beVar.Ae() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cYN != null) {
            this.cYN.onDestroy();
        }
    }
}
