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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.ao;
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
    bd aZC;
    private TextView dgA;
    private com.baidu.tbadk.core.view.b dgB;
    private boolean dgC = false;
    private boolean dgD = false;
    private final com.baidu.adp.framework.listener.a dgE = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            e.this.agg();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                e.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                e.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private NavigationBarCoverTip dgx;
    private View dgy;
    private TextView dgz;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public e(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.dgx = navigationBarCoverTip;
        this.dgE.setTag(tbPageContext.getUniqueId());
        this.dgE.getHttpMessageListener().setSelfListener(true);
        this.dgE.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dgE);
    }

    public void fb(boolean z) {
        this.dgC = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.dgx != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.dgD = false;
                if (this.dgy == null) {
                    this.dgx.removeAllViews();
                    this.dgy = this.mActivity.getLayoutInflater().inflate(d.h.write_thread_share_guide, (ViewGroup) this.dgx, true);
                    this.dgz = (TextView) this.dgy.findViewById(d.g.write_thread_success_tips);
                    this.dgA = (TextView) this.dgy.findViewById(d.g.share_icon);
                }
                aj.r(this.dgz, d.C0141d.cp_cont_i);
                aj.r(this.dgA, d.C0141d.cp_cont_i);
                aj.s(this.dgA, d.f.share_now_bg);
                this.dgA.setOnClickListener(this);
                this.dgx.h(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.dgB == null) {
            this.dgB = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.dgB.bq(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void agg() {
        if (this.dgB != null) {
            this.dgB.bq(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.dgD) {
            this.dgD = true;
            if (!j.oJ()) {
                this.mPageContext.showToast(d.j.neterror);
                this.dgx.hideTip();
                return;
            }
            int ao = l.ao(TbadkCoreApplication.getInst());
            int aq = l.aq(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ao.De().Dg() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ao, aq, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.dgx.hideTip();
            Er();
        }
    }

    private void Er() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.aZC = new bd();
        this.aZC.a(getMyPostResIdl.data.thread_info);
        Es();
    }

    private void Es() {
        if (this.aZC != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aZC.getFid());
            String zt = this.aZC.zt();
            String title = this.aZC.getTitle();
            String tid = this.aZC.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aZC);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aZC.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.blu = str2;
            dVar.linkUrl = str;
            dVar.aQu = 5;
            dVar.bln = this.dgC;
            dVar.extData = tid;
            dVar.blx = 3;
            dVar.fid = valueOf;
            dVar.blp = zt;
            dVar.tid = tid;
            dVar.blm = true;
            dVar.blw = getShareObjSource();
            dVar.bly = b(this.aZC);
            if (parse != null) {
                dVar.blr = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aZC);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.blx);
            bundle.putInt("obj_type", dVar.bly);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aQu);
            dVar.i(bundle);
            d.anj().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.zy() == null) {
            return null;
        }
        ArrayList<MediaData> zy = bdVar.zy();
        int size = zy.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zy.get(i);
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
            if (bdVar.zq()) {
                return 4;
            }
            if (bdVar.zk() == 1) {
                return 3;
            }
            return bdVar.Aq() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.dgx != null) {
            this.dgx.onDestroy();
        }
    }
}
