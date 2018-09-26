package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e;
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
    bb awf;
    private NavigationBarCoverTip cOr;
    private View cOs;
    private TextView cOt;
    private TextView cOu;
    private com.baidu.tbadk.core.view.d cOv;
    private boolean cOw = false;
    private boolean cOx = false;
    private final com.baidu.adp.framework.listener.a cOy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.agD();
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
        this.cOr = navigationBarCoverTip;
        this.cOy.setTag(tbPageContext.getUniqueId());
        this.cOy.getHttpMessageListener().setSelfListener(true);
        this.cOy.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cOy);
    }

    public void fd(boolean z) {
        this.cOw = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cOr != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cOx = false;
                if (this.cOs == null) {
                    this.cOs = View.inflate(this.mActivity, e.h.write_thread_share_guide, null);
                    this.cOt = (TextView) this.cOs.findViewById(e.g.write_thread_success_tips);
                    this.cOu = (TextView) this.cOs.findViewById(e.g.share_icon);
                }
                al.h(this.cOt, e.d.cp_cont_i);
                al.h(this.cOu, e.d.cp_cont_i);
                al.i(this.cOu, e.f.share_now_bg);
                al.j(this.cOr, e.d.cp_link_tip_a_alpha95);
                this.cOu.setOnClickListener(this);
                this.cOr.a(this.mActivity, this.cOs, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cOv == null) {
            this.cOv = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.cOv.aZ(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agD() {
        if (this.cOv != null) {
            this.cOv.aZ(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cOx) {
            this.cOx = true;
            if (!j.kK()) {
                this.mPageContext.showToast(e.j.neterror);
                this.cOr.hideTip();
                return;
            }
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = aq.Az().AB() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cOr.hideTip();
            BV();
        }
    }

    private void BV() {
        am amVar = new am("c12386");
        amVar.g("tid", this.threadId);
        amVar.al("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.w("obj_locate", 7);
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.al(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        this.awf = new bb();
        this.awf.a(getMyPostResIdl.data.thread_info);
        BW();
    }

    private void BW() {
        if (this.awf != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.awf.getFid());
            String ws = this.awf.ws();
            String title = this.awf.getTitle();
            String tid = this.awf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.awf);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.awf.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aJs = str2;
            dVar.linkUrl = str;
            dVar.amC = 5;
            dVar.aJm = this.cOw;
            dVar.extData = tid;
            dVar.aJv = 3;
            dVar.fid = valueOf;
            dVar.aJo = ws;
            dVar.tid = tid;
            dVar.aJk = true;
            dVar.aJu = getShareObjSource();
            dVar.aJw = c(this.awf);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.awf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aJv);
            bundle.putInt("obj_type", dVar.aJw);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.amC);
            dVar.f(bundle);
            e.amB().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.wx() == null) {
            return null;
        }
        ArrayList<MediaData> wx = bbVar.wx();
        int size = wx.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = wx.get(i);
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

    private int c(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.wo()) {
                return 4;
            }
            if (bbVar.wj() == 1) {
                return 3;
            }
            return bbVar.xr() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cOr != null) {
            this.cOr.onDestroy();
        }
    }
}
