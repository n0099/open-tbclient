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
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    bw afL;
    private NavigationBarCoverTip hpW;
    private View hpX;
    private TextView hpY;
    private TBSpecificationBtn hpZ;
    private com.baidu.tbadk.core.view.a hqa;
    private boolean hqb = false;
    private boolean hqc = false;
    private final com.baidu.adp.framework.listener.a hqd = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.bWr();
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
        this.hpW = navigationBarCoverTip;
        this.hqd.setTag(tbPageContext.getUniqueId());
        this.hqd.getHttpMessageListener().setSelfListener(true);
        this.hqd.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hqd);
    }

    public void nx(boolean z) {
        this.hqb = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.hpW != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.hqc = false;
                if (this.hpX == null) {
                    this.hpX = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.hpY = (TextView) this.hpX.findViewById(R.id.write_thread_success_tips);
                    this.hpZ = (TBSpecificationBtn) this.hpX.findViewById(R.id.share_icon);
                    this.hpZ.setTextSize(R.dimen.tbds34);
                    this.hpZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
                    cVar.blp();
                    this.hpZ.setConfig(cVar);
                }
                ap.setViewTextColor(this.hpY, R.color.cp_cont_a);
                this.hpZ.bkF();
                ap.setBackgroundColor(this.hpW, R.color.cp_link_tip_a_alpha95);
                this.hpZ.setOnClickListener(this);
                this.hpW.a(this.mActivity, this.hpX, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.hqa == null) {
            this.hqa = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.hqa.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWr() {
        if (this.hqa != null) {
            this.hqa.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.hqc) {
            this.hqc = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.hpW.hideTip();
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
            this.hpW.hideTip();
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
        this.afL = new bw();
        this.afL.a(getMyPostResIdl.data.thread_info);
        bkV();
    }

    private void bkV() {
        if (this.afL != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.afL.getFid());
            String beI = this.afL.beI();
            String title = this.afL.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.afL.getAbstract();
            }
            String tid = this.afL.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.afL);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.afL.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.eEu = str2;
            shareItem.linkUrl = str;
            shareItem.eeF = 5;
            shareItem.eEp = this.hqb;
            shareItem.extData = tid;
            shareItem.eEx = 3;
            shareItem.fid = valueOf;
            shareItem.fName = beI;
            shareItem.tid = tid;
            shareItem.eEj = true;
            shareItem.eEw = getShareObjSource();
            shareItem.eEB = getStateThreadType(this.afL);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eEE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.afL);
            shareItem.eEF = ShareItem.ForwardInfo.generateForwardInfo(this.afL);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eEL = this.afL.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eEx);
            bundle.putInt("obj_type", shareItem.eEB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eeF);
            shareItem.ae(bundle);
            f.cdc().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
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
        if (this.hpW != null) {
            this.hpW.onDestroy();
        }
    }
}
