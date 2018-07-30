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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
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
    bb atD;
    private NavigationBarCoverTip cID;
    private View cIE;
    private TextView cIF;
    private TextView cIG;
    private com.baidu.tbadk.core.view.a cIH;
    private boolean cII = false;
    private boolean cIJ = false;
    private final com.baidu.adp.framework.listener.a cIK = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aeP();
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
        this.cID = navigationBarCoverTip;
        this.cIK.setTag(tbPageContext.getUniqueId());
        this.cIK.getHttpMessageListener().setSelfListener(true);
        this.cIK.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cIK);
    }

    public void eM(boolean z) {
        this.cII = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cID != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cIJ = false;
                if (this.cIE == null) {
                    this.cIE = View.inflate(this.mActivity, d.h.write_thread_share_guide, null);
                    this.cIF = (TextView) this.cIE.findViewById(d.g.write_thread_success_tips);
                    this.cIG = (TextView) this.cIE.findViewById(d.g.share_icon);
                }
                am.h(this.cIF, d.C0140d.cp_cont_i);
                am.h(this.cIG, d.C0140d.cp_cont_i);
                am.i(this.cIG, d.f.share_now_bg);
                am.j(this.cID, d.C0140d.cp_link_tip_a_alpha95);
                this.cIG.setOnClickListener(this);
                this.cID.a(this.mActivity, this.cIE, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cIH == null) {
            this.cIH = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cIH.aM(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeP() {
        if (this.cIH != null) {
            this.cIH.aM(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cIJ) {
            this.cIJ = true;
            if (!j.jE()) {
                this.mPageContext.showToast(d.j.neterror);
                this.cID.hideTip();
                return;
            }
            int ah = l.ah(TbadkCoreApplication.getInst());
            int aj = l.aj(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.zw().zy() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ah, aj, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cID.hideTip();
            AL();
        }
    }

    private void AL() {
        TiebaStatic.log(new an("c12386").f("tid", this.threadId).af("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.atD = new bb();
        this.atD.a(getMyPostResIdl.data.thread_info);
        AM();
    }

    private void AM() {
        if (this.atD != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.atD.getFid());
            String vq = this.atD.vq();
            String title = this.atD.getTitle();
            String tid = this.atD.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.atD);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.atD.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aGf = str2;
            dVar.linkUrl = str;
            dVar.ajX = 5;
            dVar.aFZ = this.cII;
            dVar.extData = tid;
            dVar.aGi = 3;
            dVar.fid = valueOf;
            dVar.aGb = vq;
            dVar.tid = tid;
            dVar.aFX = true;
            dVar.aGh = getShareObjSource();
            dVar.aGj = b(this.atD);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atD);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            e.akO().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bb bbVar) {
        if (bbVar == null || bbVar.vv() == null) {
            return null;
        }
        ArrayList<MediaData> vv = bbVar.vv();
        int size = vv.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vv.get(i);
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

    private int b(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.vm()) {
                return 4;
            }
            if (bbVar.vh() == 1) {
                return 3;
            }
            return bbVar.wn() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cID != null) {
            this.cID.onDestroy();
        }
    }
}
