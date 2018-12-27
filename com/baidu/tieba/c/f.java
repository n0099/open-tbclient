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
import com.baidu.mapapi.UIMsg;
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
    bb aFg;
    private NavigationBarCoverTip dhq;
    private View dhr;
    private TextView dhs;
    private TextView dht;
    private com.baidu.tbadk.core.view.d dhu;
    private boolean dhv = false;
    private boolean dhw = false;
    private final com.baidu.adp.framework.listener.a dhx = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aln();
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
        this.dhq = navigationBarCoverTip;
        this.dhx.setTag(tbPageContext.getUniqueId());
        this.dhx.getHttpMessageListener().setSelfListener(true);
        this.dhx.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dhx);
    }

    public void fJ(boolean z) {
        this.dhv = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.dhq != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.dhw = false;
                if (this.dhr == null) {
                    this.dhr = View.inflate(this.mActivity, e.h.write_thread_share_guide, null);
                    this.dhs = (TextView) this.dhr.findViewById(e.g.write_thread_success_tips);
                    this.dht = (TextView) this.dhr.findViewById(e.g.share_icon);
                }
                al.h(this.dhs, e.d.cp_cont_i);
                al.h(this.dht, e.d.cp_cont_i);
                al.i(this.dht, e.f.share_now_bg);
                al.j(this.dhq, e.d.cp_link_tip_a_alpha95);
                this.dht.setOnClickListener(this);
                this.dhq.a(this.mActivity, this.dhr, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.dhu == null) {
            this.dhu = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.dhu.bA(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aln() {
        if (this.dhu != null) {
            this.dhu.bA(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.dhw) {
            this.dhw = true;
            if (!j.kV()) {
                this.mPageContext.showToast(e.j.neterror);
                this.dhq.hideTip();
                return;
            }
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = aq.DR().DT() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.dhq.hideTip();
            Fo();
        }
    }

    private void Fo() {
        am amVar = new am("c12386");
        amVar.i("tid", this.threadId);
        amVar.aA("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.x("obj_locate", 7);
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aA(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        this.aFg = new bb();
        this.aFg.a(getMyPostResIdl.data.thread_info);
        Fq();
    }

    private void Fq() {
        if (this.aFg != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aFg.getFid());
            String zM = this.aFg.zM();
            String title = this.aFg.getTitle();
            String tid = this.aFg.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFg);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFg.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSl = str2;
            dVar.linkUrl = str;
            dVar.avL = 5;
            dVar.aSf = this.dhv;
            dVar.extData = tid;
            dVar.aSo = 3;
            dVar.fid = valueOf;
            dVar.aSh = zM;
            dVar.tid = tid;
            dVar.aSd = true;
            dVar.aSn = getShareObjSource();
            dVar.aSp = c(this.aFg);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFg);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSo);
            bundle.putInt("obj_type", dVar.aSp);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avL);
            dVar.k(bundle);
            e.asd().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.zR() == null) {
            return null;
        }
        ArrayList<MediaData> zR = bbVar.zR();
        int size = zR.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zR.get(i);
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
            if (bbVar.zI()) {
                return 4;
            }
            if (bbVar.zD() == 1) {
                return 3;
            }
            return bbVar.AL() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.dhq != null) {
            this.dhq.onDestroy();
        }
    }
}
