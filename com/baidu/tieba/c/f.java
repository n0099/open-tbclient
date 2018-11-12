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
    bb aBF;
    private NavigationBarCoverTip cXO;
    private View cXP;
    private TextView cXQ;
    private TextView cXR;
    private com.baidu.tbadk.core.view.d cXS;
    private boolean cXT = false;
    private boolean cXU = false;
    private final com.baidu.adp.framework.listener.a cXV = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.ajH();
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
        this.cXO = navigationBarCoverTip;
        this.cXV.setTag(tbPageContext.getUniqueId());
        this.cXV.getHttpMessageListener().setSelfListener(true);
        this.cXV.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cXV);
    }

    public void fG(boolean z) {
        this.cXT = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cXO != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cXU = false;
                if (this.cXP == null) {
                    this.cXP = View.inflate(this.mActivity, e.h.write_thread_share_guide, null);
                    this.cXQ = (TextView) this.cXP.findViewById(e.g.write_thread_success_tips);
                    this.cXR = (TextView) this.cXP.findViewById(e.g.share_icon);
                }
                al.h(this.cXQ, e.d.cp_cont_i);
                al.h(this.cXR, e.d.cp_cont_i);
                al.i(this.cXR, e.f.share_now_bg);
                al.j(this.cXO, e.d.cp_link_tip_a_alpha95);
                this.cXR.setOnClickListener(this);
                this.cXO.a(this.mActivity, this.cXP, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cXS == null) {
            this.cXS = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.cXS.bz(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajH() {
        if (this.cXS != null) {
            this.cXS.bz(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cXU) {
            this.cXU = true;
            if (!j.kV()) {
                this.mPageContext.showToast(e.j.neterror);
                this.cXO.hideTip();
                return;
            }
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = aq.CN().CP() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cXO.hideTip();
            Ek();
        }
    }

    private void Ek() {
        am amVar = new am("c12386");
        amVar.h("tid", this.threadId);
        amVar.ax("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.x("obj_locate", 7);
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.ax(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        this.aBF = new bb();
        this.aBF.a(getMyPostResIdl.data.thread_info);
        El();
    }

    private void El() {
        if (this.aBF != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aBF.getFid());
            String yI = this.aBF.yI();
            String title = this.aBF.getTitle();
            String tid = this.aBF.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aBF);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aBF.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aOK = str2;
            dVar.linkUrl = str;
            dVar.ask = 5;
            dVar.aOE = this.cXT;
            dVar.extData = tid;
            dVar.aON = 3;
            dVar.fid = valueOf;
            dVar.aOG = yI;
            dVar.tid = tid;
            dVar.aOC = true;
            dVar.aOM = getShareObjSource();
            dVar.aOO = c(this.aBF);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aBF);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aON);
            bundle.putInt("obj_type", dVar.aOO);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ask);
            dVar.i(bundle);
            e.apC().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.yN() == null) {
            return null;
        }
        ArrayList<MediaData> yN = bbVar.yN();
        int size = yN.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = yN.get(i);
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
            if (bbVar.yE()) {
                return 4;
            }
            if (bbVar.yz() == 1) {
                return 3;
            }
            return bbVar.zH() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cXO != null) {
            this.cXO.onDestroy();
        }
    }
}
