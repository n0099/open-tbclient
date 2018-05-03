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
    private NavigationBarCoverTip cyi;
    private View cyj;
    private TextView cyk;
    private TextView cyl;
    private com.baidu.tbadk.core.view.a cym;
    private boolean cyn = false;
    private boolean cyo = false;
    private final com.baidu.adp.framework.listener.a cyp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e.this.aas();
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
        this.cyi = navigationBarCoverTip;
        this.cyp.setTag(tbPageContext.getUniqueId());
        this.cyp.getHttpMessageListener().setSelfListener(true);
        this.cyp.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.cyp);
    }

    public void eG(boolean z) {
        this.cyn = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.cyi != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.cyo = false;
                if (this.cyj == null) {
                    this.cyi.removeAllViews();
                    this.cyj = this.mActivity.getLayoutInflater().inflate(d.i.write_thread_share_guide, (ViewGroup) this.cyi, true);
                    this.cyk = (TextView) this.cyj.findViewById(d.g.write_thread_success_tips);
                    this.cyl = (TextView) this.cyj.findViewById(d.g.share_icon);
                }
                ak.h(this.cyk, d.C0126d.cp_cont_i);
                ak.h(this.cyl, d.C0126d.cp_cont_i);
                ak.i(this.cyl, d.f.share_now_bg);
                this.cyl.setOnClickListener(this);
                this.cyi.h(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.cym == null) {
            this.cym = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.cym.aI(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aas() {
        if (this.cym != null) {
            this.cym.aI(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (!this.cyo) {
            this.cyo = true;
            if (!j.gP()) {
                this.mPageContext.showToast(d.k.neterror);
                this.cyi.hideTip();
                return;
            }
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ap.vQ().vS() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.cyi.hideTip();
            xc();
        }
    }

    private void xc() {
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
        xd();
    }

    private void xd() {
        if (this.alf != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.alf.getFid());
            String rV = this.alf.rV();
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
            dVar.awY = str2;
            dVar.linkUrl = str;
            dVar.abU = 5;
            dVar.awR = this.cyn;
            dVar.extData = tid;
            dVar.axb = 3;
            dVar.fid = valueOf;
            dVar.awT = rV;
            dVar.tid = tid;
            dVar.awQ = true;
            dVar.axa = getShareObjSource();
            dVar.axc = b(this.alf);
            if (parse != null) {
                dVar.awV = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.alf);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.axb);
            bundle.putInt("obj_type", dVar.axc);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.abU);
            dVar.f(bundle);
            d.ahh().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.sa() == null) {
            return null;
        }
        ArrayList<MediaData> sa = bdVar.sa();
        int size = sa.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = sa.get(i);
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
            if (bdVar.rS()) {
                return 4;
            }
            if (bdVar.rN() == 1) {
                return 3;
            }
            return bdVar.sS() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.cyi != null) {
            this.cyi.onDestroy();
        }
    }
}
