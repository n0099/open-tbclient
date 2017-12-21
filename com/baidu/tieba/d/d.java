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
    bd ajM;
    private c anY;
    private NavigationBarCoverTip ckj;
    private View ckk;
    private TextView ckl;
    private TextView ckm;
    private com.baidu.tbadk.core.view.b ckn;
    private boolean cko = false;
    private boolean ckp = false;
    private final com.baidu.adp.framework.listener.a ckq = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.this.XC();
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
        this.ckj = navigationBarCoverTip;
        this.ckq.setTag(tbPageContext.getUniqueId());
        this.ckq.getHttpMessageListener().setSelfListener(true);
        this.ckq.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ckq);
        this.anY = new c(this.mPageContext);
    }

    public void eh(boolean z) {
        this.cko = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.ckj != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.ckp = false;
                if (this.ckk == null) {
                    this.ckj.removeAllViews();
                    this.ckk = this.mActivity.getLayoutInflater().inflate(d.h.write_thread_share_guide, (ViewGroup) this.ckj, true);
                    this.ckl = (TextView) this.ckk.findViewById(d.g.write_thread_success_tips);
                    this.ckm = (TextView) this.ckk.findViewById(d.g.share_icon);
                }
                aj.i(this.ckl, d.C0095d.cp_cont_i);
                aj.i(this.ckm, d.C0095d.cp_cont_i);
                aj.j(this.ckm, d.f.share_now_bg);
                this.ckm.setOnClickListener(this);
                this.ckj.j(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.ckn == null) {
            this.ckn = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.ckn.aE(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XC() {
        if (this.ckn != null) {
            this.ckn.aE(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.ckp) {
            this.ckp = true;
            if (!j.hh()) {
                this.mPageContext.showToast(d.j.neterror);
                this.ckj.hideTip();
                return;
            }
            int ac = l.ac(TbadkCoreApplication.getInst());
            int ae = l.ae(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = an.vs().vu() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ac, ae, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.ckj.hideTip();
            wG();
        }
    }

    private void wG() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.ajM = new bd();
        this.ajM.a(getMyPostResIdl.data.thread_info);
        wH();
    }

    private void wH() {
        if (this.ajM != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.ajM.getFid());
            String rB = this.ajM.rB();
            String title = this.ajM.getTitle();
            String tid = this.ajM.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.ajM);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.ajM.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.auK = str2;
            dVar.linkUrl = str;
            dVar.aaJ = 5;
            dVar.auD = this.cko;
            dVar.extData = tid;
            dVar.auN = 3;
            dVar.fid = valueOf;
            dVar.auF = rB;
            dVar.tid = tid;
            dVar.auC = true;
            dVar.auM = getShareObjSource();
            dVar.auO = b(this.ajM);
            if (parse != null) {
                dVar.auH = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.ajM);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.auN);
            bundle.putInt("obj_type", dVar.auO);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aaJ);
            dVar.e(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            if (this.anY == null) {
                this.anY = new c(this.mPageContext);
            }
            this.anY.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.rG() == null) {
            return null;
        }
        ArrayList<MediaData> rG = bdVar.rG();
        int size = rG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rG.get(i);
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
            if (bdVar.ry()) {
                return 4;
            }
            if (bdVar.rs() == 1) {
                return 3;
            }
            return bdVar.sC() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.ckj != null) {
            this.ckj.onDestory();
        }
    }
}
