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
import com.baidu.tbadk.core.data.bc;
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
    bc atZ;
    private NavigationBarCoverTip cFW;
    private View cFX;
    private TextView cFY;
    private TextView cFZ;
    private com.baidu.tbadk.core.view.a cGa;
    private boolean cGb = false;
    private boolean cGc = false;
    private final com.baidu.adp.framework.listener.a cGd = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aeB();
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
        this.cFW = navigationBarCoverTip;
        this.cGd.setTag(tbPageContext.getUniqueId());
        this.cGd.getHttpMessageListener().setSelfListener(true);
        this.cGd.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cGd);
    }

    public void eL(boolean z) {
        this.cGb = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cFW != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cGc = false;
                if (this.cFX == null) {
                    this.cFX = View.inflate(this.mActivity, d.i.write_thread_share_guide, null);
                    this.cFY = (TextView) this.cFX.findViewById(d.g.write_thread_success_tips);
                    this.cFZ = (TextView) this.cFX.findViewById(d.g.share_icon);
                }
                am.h(this.cFY, d.C0142d.cp_cont_i);
                am.h(this.cFZ, d.C0142d.cp_cont_i);
                am.i(this.cFZ, d.f.share_now_bg);
                am.j(this.cFW, d.C0142d.cp_link_tip_a_alpha95);
                this.cFZ.setOnClickListener(this);
                this.cFW.a(this.mActivity, this.cFX, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cGa == null) {
            this.cGa = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cGa.aO(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeB() {
        if (this.cGa != null) {
            this.cGa.aO(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.cGc) {
            this.cGc = true;
            if (!j.jD()) {
                this.mPageContext.showToast(d.k.neterror);
                this.cFW.hideTip();
                return;
            }
            int ah = l.ah(TbadkCoreApplication.getInst());
            int aj = l.aj(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.zF().zH() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ah, aj, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cFW.hideTip();
            AU();
        }
    }

    private void AU() {
        TiebaStatic.log(new an("c12386").f("tid", this.threadId).ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.k.neterror);
            return;
        }
        this.atZ = new bc();
        this.atZ.a(getMyPostResIdl.data.thread_info);
        AV();
    }

    private void AV() {
        if (this.atZ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.atZ.getFid());
            String vB = this.atZ.vB();
            String title = this.atZ.getTitle();
            String tid = this.atZ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.atZ);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.atZ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.k.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aGf = str2;
            dVar.linkUrl = str;
            dVar.aky = 5;
            dVar.aFZ = this.cGb;
            dVar.extData = tid;
            dVar.aGi = 3;
            dVar.fid = valueOf;
            dVar.aGb = vB;
            dVar.tid = tid;
            dVar.aFX = true;
            dVar.aGh = getShareObjSource();
            dVar.aGj = b(this.atZ);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.atZ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aGi);
            bundle.putInt("obj_type", dVar.aGj);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aky);
            dVar.f(bundle);
            e.akp().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bc bcVar) {
        if (bcVar == null || bcVar.vG() == null) {
            return null;
        }
        ArrayList<MediaData> vG = bcVar.vG();
        int size = vG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = vG.get(i);
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

    private int b(bc bcVar) {
        if (bcVar != null) {
            if (bcVar.vy()) {
                return 4;
            }
            if (bcVar.vt() == 1) {
                return 3;
            }
            return bcVar.wy() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cFW != null) {
            this.cFW.onDestroy();
        }
    }
}
