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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
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
/* loaded from: classes2.dex */
public class h implements View.OnClickListener {
    bw afJ;
    private NavigationBarCoverTip hpS;
    private View hpT;
    private TextView hpU;
    private TBSpecificationBtn hpV;
    private com.baidu.tbadk.core.view.a hpW;
    private boolean hpX = false;
    private boolean hpY = false;
    private final com.baidu.adp.framework.listener.a hpZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.bWq();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.hpS = navigationBarCoverTip;
        this.hpZ.setTag(tbPageContext.getUniqueId());
        this.hpZ.getHttpMessageListener().setSelfListener(true);
        this.hpZ.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hpZ);
    }

    public void nv(boolean z) {
        this.hpX = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.hpS != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.hpY = false;
                if (this.hpT == null) {
                    this.hpT = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.hpU = (TextView) this.hpT.findViewById(R.id.write_thread_success_tips);
                    this.hpV = (TBSpecificationBtn) this.hpT.findViewById(R.id.share_icon);
                    this.hpV.setTextSize(R.dimen.tbds34);
                    this.hpV.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                    cVar.blp();
                    this.hpV.setConfig(cVar);
                }
                ap.setViewTextColor(this.hpU, R.color.cp_cont_a);
                this.hpV.bkF();
                ap.setBackgroundColor(this.hpS, R.color.cp_link_tip_a_alpha95);
                this.hpV.setOnClickListener(this);
                this.hpS.a(this.mActivity, this.hpT, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.hpW == null) {
            this.hpW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.hpW.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWq() {
        if (this.hpW != null) {
            this.hpW.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.hpY) {
            this.hpY = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.hpS.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = au.bjr().bjs() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.hpS.hideTip();
            bkT();
        }
    }

    private void bkT() {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("tid", this.threadId);
        aqVar.dD("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.ai("obj_locate", 7);
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dD("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.afJ = new bw();
        this.afJ.a(getMyPostResIdl.data.thread_info);
        bkV();
    }

    private void bkV() {
        if (this.afJ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.afJ.getFid());
            String beI = this.afJ.beI();
            String title = this.afJ.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.afJ.getAbstract();
            }
            String tid = this.afJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.afJ);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.afJ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.eEq = str2;
            shareItem.linkUrl = str;
            shareItem.eeB = 5;
            shareItem.eEl = this.hpX;
            shareItem.extData = tid;
            shareItem.eEt = 3;
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.eEf = true;
            shareItem.eEs = getShareObjSource();
            shareItem.eEx = getStateThreadType(this.afJ);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eEA = OriginalThreadInfo.ShareInfo.generateShareInfo(this.afJ);
            shareItem.eEB = ShareItem.ForwardInfo.generateForwardInfo(this.afJ);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eEH = this.afJ.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEt);
            bundle.putInt("obj_type", shareItem.eEx);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeB);
            shareItem.ae(bundle);
            f.cdb().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.beN() == null) {
            return null;
        }
        ArrayList<MediaData> beN = bwVar.beN();
        int size = beN.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = beN.get(i);
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

    private int getStateThreadType(bw bwVar) {
        if (bwVar != null) {
            if (bwVar.beG()) {
                return 4;
            }
            if (bwVar.beB() == 1) {
                return 3;
            }
            return bwVar.bfW() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hpS != null) {
            this.hpS.onDestroy();
        }
    }
}
