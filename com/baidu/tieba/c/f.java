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
    bb aAQ;
    private NavigationBarCoverTip cWI;
    private View cWJ;
    private TextView cWK;
    private TextView cWL;
    private com.baidu.tbadk.core.view.d cWM;
    private boolean cWN = false;
    private boolean cWO = false;
    private final com.baidu.adp.framework.listener.a cWP = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.akj();
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
        this.cWI = navigationBarCoverTip;
        this.cWP.setTag(tbPageContext.getUniqueId());
        this.cWP.getHttpMessageListener().setSelfListener(true);
        this.cWP.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cWP);
    }

    public void fv(boolean z) {
        this.cWN = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cWI != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cWO = false;
                if (this.cWJ == null) {
                    this.cWJ = View.inflate(this.mActivity, e.h.write_thread_share_guide, null);
                    this.cWK = (TextView) this.cWJ.findViewById(e.g.write_thread_success_tips);
                    this.cWL = (TextView) this.cWJ.findViewById(e.g.share_icon);
                }
                al.h(this.cWK, e.d.cp_cont_i);
                al.h(this.cWL, e.d.cp_cont_i);
                al.i(this.cWL, e.f.share_now_bg);
                al.j(this.cWI, e.d.cp_link_tip_a_alpha95);
                this.cWL.setOnClickListener(this);
                this.cWI.a(this.mActivity, this.cWJ, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cWM == null) {
            this.cWM = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.cWM.bj(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akj() {
        if (this.cWM != null) {
            this.cWM.bj(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cWO) {
            this.cWO = true;
            if (!j.kX()) {
                this.mPageContext.showToast(e.j.neterror);
                this.cWI.hideTip();
                return;
            }
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = aq.CG().CI() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cWI.hideTip();
            Ea();
        }
    }

    private void Ea() {
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
        this.aAQ = new bb();
        this.aAQ.a(getMyPostResIdl.data.thread_info);
        Eb();
    }

    private void Eb() {
        if (this.aAQ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aAQ.getFid());
            String yB = this.aAQ.yB();
            String title = this.aAQ.getTitle();
            String tid = this.aAQ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aAQ);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aAQ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aNU = str2;
            dVar.linkUrl = str;
            dVar.arx = 5;
            dVar.aNO = this.cWN;
            dVar.extData = tid;
            dVar.aNX = 3;
            dVar.fid = valueOf;
            dVar.aNQ = yB;
            dVar.tid = tid;
            dVar.aNM = true;
            dVar.aNW = getShareObjSource();
            dVar.aNY = c(this.aAQ);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aAQ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aNX);
            bundle.putInt("obj_type", dVar.aNY);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.arx);
            dVar.f(bundle);
            e.aqa().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.yG() == null) {
            return null;
        }
        ArrayList<MediaData> yG = bbVar.yG();
        int size = yG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = yG.get(i);
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
            if (bbVar.yx()) {
                return 4;
            }
            if (bbVar.ys() == 1) {
                return 3;
            }
            return bbVar.zA() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cWI != null) {
            this.cWI.onDestroy();
        }
    }
}
