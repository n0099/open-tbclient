package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    bj KJ;
    private NavigationBarCoverTip fPP;
    private View fPQ;
    private TextView fPR;
    private TextView fPS;
    private com.baidu.tbadk.core.view.a fPT;
    private boolean fPU = false;
    private boolean fPV = false;
    private final com.baidu.adp.framework.listener.a fPW = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bqp();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                g.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                g.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public g(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.fPP = navigationBarCoverTip;
        this.fPW.setTag(tbPageContext.getUniqueId());
        this.fPW.getHttpMessageListener().setSelfListener(true);
        this.fPW.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fPW);
    }

    public void kx(boolean z) {
        this.fPU = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.fPP != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.fPV = false;
                if (this.fPQ == null) {
                    this.fPQ = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.fPR = (TextView) this.fPQ.findViewById(R.id.write_thread_success_tips);
                    this.fPS = (TextView) this.fPQ.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.fPR, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.fPS, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fPS, R.drawable.share_now_bg);
                am.setBackgroundColor(this.fPP, R.color.cp_link_tip_a_alpha95);
                this.fPS.setOnClickListener(this);
                this.fPP.a(this.mActivity, this.fPQ, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.fPT == null) {
            this.fPT = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fPT.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqp() {
        if (this.fPT != null) {
            this.fPT.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fPV) {
            this.fPV = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.fPP.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aGB().aGC() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.fPP.hideTip();
            aHY();
        }
    }

    private void aHY() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("tid", this.threadId);
        anVar.cy("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.X("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cy("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.KJ = new bj();
        this.KJ.a(getMyPostResIdl.data.thread_info);
        aIa();
    }

    private void aIa() {
        if (this.KJ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.KJ.getFid());
            String aCr = this.KJ.aCr();
            String title = this.KJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.KJ.getAbstract();
            }
            String tid = this.KJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String y = y(this.KJ);
            Uri parse = y == null ? null : Uri.parse(y);
            String str2 = this.KJ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.dqb = str2;
            shareItem.linkUrl = str;
            shareItem.cUA = 5;
            shareItem.dpW = this.fPU;
            shareItem.extData = tid;
            shareItem.dqe = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aCr;
            shareItem.tid = tid;
            shareItem.dpR = true;
            shareItem.dqd = getShareObjSource();
            shareItem.dqi = z(this.KJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dql = OriginalThreadInfo.ShareInfo.generateShareInfo(this.KJ);
            shareItem.dqm = ShareItem.ForwardInfo.generateForwardInfo(this.KJ);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dqs = this.KJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dqe);
            bundle.putInt("obj_type", shareItem.dqi);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cUA);
            shareItem.Y(bundle);
            e.bwk().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String y(bj bjVar) {
        if (bjVar == null || bjVar.aCw() == null) {
            return null;
        }
        ArrayList<MediaData> aCw = bjVar.aCw();
        int size = aCw.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aCw.get(i);
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

    private int z(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aCo()) {
                return 4;
            }
            if (bjVar.aCj() == 1) {
                return 3;
            }
            return bjVar.aDz() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fPP != null) {
            this.fPP.onDestroy();
        }
    }
}
