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
import com.baidu.tbadk.core.data.bd;
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
    bd aYc;
    private c bce;
    private NavigationBarCoverTip ddN;
    private View ddO;
    private TextView ddP;
    private TextView ddQ;
    private com.baidu.tbadk.core.view.b ddR;
    private boolean ddS = false;
    private boolean ddT = false;
    private final com.baidu.adp.framework.listener.a ddU = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.this.afb();
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
        this.ddN = navigationBarCoverTip;
        this.ddU.setTag(tbPageContext.getUniqueId());
        this.ddU.getHttpMessageListener().setSelfListener(true);
        this.ddU.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ddU);
        this.bce = new c(this.mPageContext);
    }

    public void eU(boolean z) {
        this.ddS = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.ddN != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.ddT = false;
                if (this.ddO == null) {
                    this.ddN.removeAllViews();
                    this.ddO = this.mActivity.getLayoutInflater().inflate(d.h.write_thread_share_guide, (ViewGroup) this.ddN, true);
                    this.ddP = (TextView) this.ddO.findViewById(d.g.write_thread_success_tips);
                    this.ddQ = (TextView) this.ddO.findViewById(d.g.share_icon);
                }
                aj.r(this.ddP, d.C0108d.cp_cont_i);
                aj.r(this.ddQ, d.C0108d.cp_cont_i);
                aj.s(this.ddQ, d.f.share_now_bg);
                this.ddQ.setOnClickListener(this);
                this.ddN.h(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.ddR == null) {
            this.ddR = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.ddR.bn(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afb() {
        if (this.ddR != null) {
            this.ddR.bn(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.ddT) {
            this.ddT = true;
            if (!j.oJ()) {
                this.mPageContext.showToast(d.j.neterror);
                this.ddN.hideTip();
                return;
            }
            int ao = l.ao(TbadkCoreApplication.getInst());
            int aq = l.aq(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = an.CK().CM() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ao, aq, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.ddN.hideTip();
            DX();
        }
    }

    private void DX() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).aa("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.aYc = new bd();
        this.aYc.a(getMyPostResIdl.data.thread_info);
        DY();
    }

    private void DY() {
        if (this.aYc != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aYc.getFid());
            String yZ = this.aYc.yZ();
            String title = this.aYc.getTitle();
            String tid = this.aYc.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aYc);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aYc.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.bjp = str2;
            dVar.linkUrl = str;
            dVar.aPh = 5;
            dVar.bji = this.ddS;
            dVar.extData = tid;
            dVar.bjs = 3;
            dVar.fid = valueOf;
            dVar.bjk = yZ;
            dVar.tid = tid;
            dVar.bjh = true;
            dVar.bjr = getShareObjSource();
            dVar.bjt = b(this.aYc);
            if (parse != null) {
                dVar.bjm = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aYc);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.bjs);
            bundle.putInt("obj_type", dVar.bjt);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPh);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            if (this.bce == null) {
                this.bce = new c(this.mPageContext);
            }
            this.bce.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.ze() == null) {
            return null;
        }
        ArrayList<MediaData> ze = bdVar.ze();
        int size = ze.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = ze.get(i);
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

    private int b(bd bdVar) {
        if (bdVar != null) {
            if (bdVar.yW()) {
                return 4;
            }
            if (bdVar.yQ() == 1) {
                return 3;
            }
            return bdVar.zX() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.ddN != null) {
            this.ddN.onDestroy();
        }
    }
}
