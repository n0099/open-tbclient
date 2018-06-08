package com.baidu.tieba.c;

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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
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
public class f implements View.OnClickListener {
    bd atn;
    private NavigationBarCoverTip cIc;
    private View cId;
    private TextView cIe;
    private TextView cIf;
    private com.baidu.tbadk.core.view.a cIg;
    private boolean cIh = false;
    private boolean cIi = false;
    private final com.baidu.adp.framework.listener.a cIj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.adT();
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
        this.cIc = navigationBarCoverTip;
        this.cIj.setTag(tbPageContext.getUniqueId());
        this.cIj.getHttpMessageListener().setSelfListener(true);
        this.cIj.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cIj);
    }

    public void eL(boolean z) {
        this.cIh = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cIc != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cIi = false;
                if (this.cId == null) {
                    this.cIc.removeAllViews();
                    this.cId = this.mActivity.getLayoutInflater().inflate(d.i.write_thread_share_guide, (ViewGroup) this.cIc, true);
                    this.cIe = (TextView) this.cId.findViewById(d.g.write_thread_success_tips);
                    this.cIf = (TextView) this.cId.findViewById(d.g.share_icon);
                }
                al.h(this.cIe, d.C0141d.cp_cont_i);
                al.h(this.cIf, d.C0141d.cp_cont_i);
                al.i(this.cIf, d.f.share_now_bg);
                this.cIf.setOnClickListener(this);
                this.cIc.h(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cIg == null) {
            this.cIg = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cIg.aM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adT() {
        if (this.cIg != null) {
            this.cIg.aM(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cIi) {
            this.cIi = true;
            if (!j.jD()) {
                this.mPageContext.showToast(d.k.neterror);
                this.cIc.hideTip();
                return;
            }
            int ah = l.ah(TbadkCoreApplication.getInst());
            int aj = l.aj(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = aq.zq().zs() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ah, aj, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cIc.hideTip();
            AC();
        }
    }

    private void AC() {
        TiebaStatic.log(new am("c12386").f("tid", this.threadId).ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.k.neterror);
            return;
        }
        this.atn = new bd();
        this.atn.a(getMyPostResIdl.data.thread_info);
        AD();
    }

    private void AD() {
        if (this.atn != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.atn.getFid());
            String vr = this.atn.vr();
            String title = this.atn.getTitle();
            String tid = this.atn.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.atn);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.atn.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.k.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aFm = str2;
            dVar.linkUrl = str;
            dVar.ajZ = 5;
            dVar.aFf = this.cIh;
            dVar.extData = tid;
            dVar.aFp = 3;
            dVar.fid = valueOf;
            dVar.aFh = vr;
            dVar.tid = tid;
            dVar.aFd = true;
            dVar.aFo = getShareObjSource();
            dVar.aFq = b(this.atn);
            if (parse != null) {
                dVar.aFj = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atn);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aFp);
            bundle.putInt("obj_type", dVar.aFq);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajZ);
            dVar.f(bundle);
            e.akV().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.vw() == null) {
            return null;
        }
        ArrayList<MediaData> vw = bdVar.vw();
        int size = vw.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vw.get(i);
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
            if (bdVar.vo()) {
                return 4;
            }
            if (bdVar.vj() == 1) {
                return 3;
            }
            return bdVar.wo() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cIc != null) {
            this.cIc.onDestroy();
        }
    }
}
