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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.f;
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
    bb atE;
    private NavigationBarCoverTip cIA;
    private View cIB;
    private TextView cIC;
    private TextView cID;
    private com.baidu.tbadk.core.view.a cIE;
    private boolean cIF = false;
    private boolean cIG = false;
    private final com.baidu.adp.framework.listener.a cIH = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aeR();
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
        this.cIA = navigationBarCoverTip;
        this.cIH.setTag(tbPageContext.getUniqueId());
        this.cIH.getHttpMessageListener().setSelfListener(true);
        this.cIH.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cIH);
    }

    public void eM(boolean z) {
        this.cIF = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cIA != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cIG = false;
                if (this.cIB == null) {
                    this.cIB = View.inflate(this.mActivity, f.h.write_thread_share_guide, null);
                    this.cIC = (TextView) this.cIB.findViewById(f.g.write_thread_success_tips);
                    this.cID = (TextView) this.cIB.findViewById(f.g.share_icon);
                }
                am.h(this.cIC, f.d.cp_cont_i);
                am.h(this.cID, f.d.cp_cont_i);
                am.i(this.cID, f.C0146f.share_now_bg);
                am.j(this.cIA, f.d.cp_link_tip_a_alpha95);
                this.cID.setOnClickListener(this);
                this.cIA.a(this.mActivity, this.cIB, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cIE == null) {
            this.cIE = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cIE.aN(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeR() {
        if (this.cIE != null) {
            this.cIE.aN(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cIG) {
            this.cIG = true;
            if (!j.jE()) {
                this.mPageContext.showToast(f.j.neterror);
                this.cIA.hideTip();
                return;
            }
            int ah = l.ah(TbadkCoreApplication.getInst());
            int aj = l.aj(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.zu().zw() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ah, aj, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cIA.hideTip();
            AI();
        }
    }

    private void AI() {
        an anVar = new an("c12386");
        anVar.f("tid", this.threadId);
        anVar.ae("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.r("obj_locate", 7);
        if (!ap.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.ae(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(f.j.neterror);
            return;
        }
        this.atE = new bb();
        this.atE.a(getMyPostResIdl.data.thread_info);
        AJ();
    }

    private void AJ() {
        if (this.atE != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.atE.getFid());
            String vp = this.atE.vp();
            String title = this.atE.getTitle();
            String tid = this.atE.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.atE);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.atE.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(f.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aGe = str2;
            dVar.linkUrl = str;
            dVar.ajX = 5;
            dVar.aFY = this.cIF;
            dVar.extData = tid;
            dVar.aGh = 3;
            dVar.fid = valueOf;
            dVar.aGa = vp;
            dVar.tid = tid;
            dVar.aFW = true;
            dVar.aGg = getShareObjSource();
            dVar.aGi = b(this.atE);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atE);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGh);
            bundle.putInt("obj_type", dVar.aGi);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.ajX);
            dVar.f(bundle);
            e.akQ().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bb bbVar) {
        if (bbVar == null || bbVar.vu() == null) {
            return null;
        }
        ArrayList<MediaData> vu = bbVar.vu();
        int size = vu.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vu.get(i);
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
            if (bbVar.vl()) {
                return 4;
            }
            if (bbVar.vg() == 1) {
                return 3;
            }
            return bbVar.wm() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cIA != null) {
            this.cIA.onDestroy();
        }
    }
}
