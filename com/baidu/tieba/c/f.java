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
    bb aFf;
    private NavigationBarCoverTip deA;
    private View deB;
    private TextView deC;
    private TextView deD;
    private com.baidu.tbadk.core.view.d deE;
    private boolean deF = false;
    private boolean deG = false;
    private final com.baidu.adp.framework.listener.a deH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.akP();
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
        this.deA = navigationBarCoverTip;
        this.deH.setTag(tbPageContext.getUniqueId());
        this.deH.getHttpMessageListener().setSelfListener(true);
        this.deH.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.deH);
    }

    public void fH(boolean z) {
        this.deF = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.deA != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.deG = false;
                if (this.deB == null) {
                    this.deB = View.inflate(this.mActivity, e.h.write_thread_share_guide, null);
                    this.deC = (TextView) this.deB.findViewById(e.g.write_thread_success_tips);
                    this.deD = (TextView) this.deB.findViewById(e.g.share_icon);
                }
                al.h(this.deC, e.d.cp_cont_i);
                al.h(this.deD, e.d.cp_cont_i);
                al.i(this.deD, e.f.share_now_bg);
                al.j(this.deA, e.d.cp_link_tip_a_alpha95);
                this.deD.setOnClickListener(this);
                this.deA.a(this.mActivity, this.deB, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.deE == null) {
            this.deE = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.deE.bA(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akP() {
        if (this.deE != null) {
            this.deE.bA(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.deG) {
            this.deG = true;
            if (!j.kV()) {
                this.mPageContext.showToast(e.j.neterror);
                this.deA.hideTip();
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
            this.deA.hideTip();
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
        this.aFf = new bb();
        this.aFf.a(getMyPostResIdl.data.thread_info);
        Fp();
    }

    private void Fp() {
        if (this.aFf != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aFf.getFid());
            String zM = this.aFf.zM();
            String title = this.aFf.getTitle();
            String tid = this.aFf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFf);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFf.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSj = str2;
            dVar.linkUrl = str;
            dVar.avK = 5;
            dVar.aSd = this.deF;
            dVar.extData = tid;
            dVar.aSm = 3;
            dVar.fid = valueOf;
            dVar.aSf = zM;
            dVar.tid = tid;
            dVar.aSb = true;
            dVar.aSl = getShareObjSource();
            dVar.aSn = c(this.aFf);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSm);
            bundle.putInt("obj_type", dVar.aSn);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.avK);
            dVar.k(bundle);
            e.aro().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
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
        if (this.deA != null) {
            this.deA.onDestroy();
        }
    }
}
