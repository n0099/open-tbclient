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
import com.baidu.tbadk.core.util.an;
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
public class d implements View.OnClickListener {
    bd aXU;
    private c bbW;
    private NavigationBarCoverTip ddr;
    private View dds;
    private TextView ddt;
    private TextView ddv;
    private com.baidu.tbadk.core.view.b ddw;
    private boolean ddx = false;
    private boolean ddy = false;
    private final com.baidu.adp.framework.listener.a ddz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.d.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            d.this.aeY();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                d.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                d.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public d(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.ddr = navigationBarCoverTip;
        this.ddz.setTag(tbPageContext.getUniqueId());
        this.ddz.getHttpMessageListener().setSelfListener(true);
        this.ddz.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ddz);
        this.bbW = new c(this.mPageContext);
    }

    public void eS(boolean z) {
        this.ddx = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.ddr != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.ddy = false;
                if (this.dds == null) {
                    this.ddr.removeAllViews();
                    this.dds = this.mActivity.getLayoutInflater().inflate(d.h.write_thread_share_guide, (ViewGroup) this.ddr, true);
                    this.ddt = (TextView) this.dds.findViewById(d.g.write_thread_success_tips);
                    this.ddv = (TextView) this.dds.findViewById(d.g.share_icon);
                }
                aj.r(this.ddt, d.C0107d.cp_cont_i);
                aj.r(this.ddv, d.C0107d.cp_cont_i);
                aj.s(this.ddv, d.f.share_now_bg);
                this.ddv.setOnClickListener(this);
                this.ddr.j(this.mActivity, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.ddw == null) {
            this.ddw = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.ddw.bm(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aeY() {
        if (this.ddw != null) {
            this.ddw.bm(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.ddy) {
            this.ddy = true;
            if (!j.oI()) {
                this.mPageContext.showToast(d.j.neterror);
                this.ddr.hideTip();
                return;
            }
            int ao = l.ao(TbadkCoreApplication.getInst());
            int aq = l.aq(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = an.CJ().CL() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, ao, aq, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.ddr.hideTip();
            DV();
        }
    }

    private void DV() {
        TiebaStatic.log(new ak("c12386").f("tid", this.threadId).ab("uid", TbadkCoreApplication.getCurrentAccount()).s("obj_locate", 7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(d.j.neterror);
            return;
        }
        this.aXU = new bd();
        this.aXU.a(getMyPostResIdl.data.thread_info);
        DW();
    }

    private void DW() {
        if (this.aXU != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aXU.getFid());
            String yY = this.aXU.yY();
            String title = this.aXU.getTitle();
            String tid = this.aXU.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String a = a(this.aXU);
            Uri parse = a == null ? null : Uri.parse(a);
            String str2 = this.aXU.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(d.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.bjh = str2;
            dVar.linkUrl = str;
            dVar.aPe = 5;
            dVar.bja = this.ddx;
            dVar.extData = tid;
            dVar.bjk = 3;
            dVar.fid = valueOf;
            dVar.bjc = yY;
            dVar.tid = tid;
            dVar.biZ = true;
            dVar.bjj = getShareObjSource();
            dVar.bjl = b(this.aXU);
            if (parse != null) {
                dVar.bje = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aXU);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.bjk);
            bundle.putInt("obj_type", dVar.bjl);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.aPe);
            dVar.h(bundle);
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.mActivity, dVar, true, true);
            if (this.bbW == null) {
                this.bbW = new c(this.mPageContext);
            }
            this.bbW.a(shareDialogConfig);
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String a(bd bdVar) {
        if (bdVar == null || bdVar.zd() == null) {
            return null;
        }
        ArrayList<MediaData> zd = bdVar.zd();
        int size = zd.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = zd.get(i);
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
            if (bdVar.yV()) {
                return 4;
            }
            if (bdVar.yP() == 1) {
                return 3;
            }
            return bdVar.zW() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.ddr != null) {
            this.ddr.onDestroy();
        }
    }
}
