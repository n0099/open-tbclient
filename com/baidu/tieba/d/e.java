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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
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
public class e implements View.OnClickListener {
    bd alf;
    private NavigationBarCoverTip czr;
    private View czs;
    private TextView czt;
    private TextView czu;
    private com.baidu.tbadk.core.view.a czv;
    private boolean czw = false;
    private boolean czx = false;
    private final com.baidu.adp.framework.listener.a czy = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e.this.aav();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                e.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                e.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public e(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.czr = navigationBarCoverTip;
        this.czy.setTag(tbPageContext.getUniqueId());
        this.czy.getHttpMessageListener().setSelfListener(true);
        this.czy.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.czy);
    }

    public void eH(boolean z) {
        this.czw = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.czr != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.czx = false;
                if (this.czs == null) {
                    this.czr.removeAllViews();
                    this.czs = this.mActivity.getLayoutInflater().inflate(d.i.write_thread_share_guide, (ViewGroup) this.czr, true);
                    this.czt = (TextView) this.czs.findViewById(d.g.write_thread_success_tips);
                    this.czu = (TextView) this.czs.findViewById(d.g.share_icon);
                }
                ak.h(this.czt, d.C0126d.cp_cont_i);
                ak.h(this.czu, d.C0126d.cp_cont_i);
                ak.i(this.czu, d.f.share_now_bg);
                this.czu.setOnClickListener(this);
                this.czr.h(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.czv == null) {
            this.czv = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.czv.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aav() {
        if (this.czv != null) {
            this.czv.aI(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!this.czx) {
            this.czx = true;
            if (!j.gP()) {
                this.mPageContext.showToast(d.k.neterror);
                this.czr.hideTip();
                return;
            }
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ap.vP().vR() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.czr.hideTip();
            xb();
        }
    }

    private void xb() {
        TiebaStatic.log(new al("c12386").f("tid", this.threadId).ac("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.k.neterror);
            return;
        }
        this.alf = new bd();
        this.alf.a(getMyPostResIdl.data.thread_info);
        xc();
    }

    private void xc() {
        if (this.alf != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.alf.getFid());
            String rU = this.alf.rU();
            String title = this.alf.getTitle();
            String tid = this.alf.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.alf);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.alf.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.k.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.awZ = str2;
            dVar.linkUrl = str;
            dVar.abV = 5;
            dVar.awS = this.czw;
            dVar.extData = tid;
            dVar.axc = 3;
            dVar.fid = valueOf;
            dVar.awU = rU;
            dVar.tid = tid;
            dVar.awR = true;
            dVar.axb = getShareObjSource();
            dVar.axd = b(this.alf);
            if (parse != null) {
                dVar.awW = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.alf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axc);
            bundle.putInt("obj_type", dVar.axd);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abV);
            dVar.f(bundle);
            d.ahh().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.rZ() == null) {
            return null;
        }
        ArrayList<MediaData> rZ = bdVar.rZ();
        int size = rZ.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = rZ.get(i);
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
            if (bdVar.rR()) {
                return 4;
            }
            if (bdVar.rM() == 1) {
                return 3;
            }
            return bdVar.sR() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.czr != null) {
            this.czr.onDestroy();
        }
    }
}
