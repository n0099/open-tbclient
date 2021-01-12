package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
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
import com.baidu.tieba.view.ShadowLinearLayout;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    bz ahu;
    private NavigationBarCoverTip ixR;
    private ShadowLinearLayout ixS;
    private TextView ixT;
    private TextView ixU;
    private TBSpecificationBtn ixV;
    private com.baidu.tbadk.core.view.a ixW;
    private boolean ixX = false;
    private boolean ixY = false;
    private final com.baidu.adp.framework.listener.a ixZ = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.cjr();
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
        this.ixR = navigationBarCoverTip;
        this.ixZ.setTag(tbPageContext.getUniqueId());
        this.ixZ.getHttpMessageListener().setSelfListener(true);
        this.ixZ.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ixZ);
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.ixR != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.ixY = false;
                if (this.ixS == null) {
                    this.ixS = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.ixT = (TextView) this.ixS.findViewById(R.id.tb_top_toast_title);
                    this.ixU = (TextView) this.ixS.findViewById(R.id.tb_top_toast_content);
                    this.ixV = (TBSpecificationBtn) this.ixS.findViewById(R.id.tb_top_toast_btn);
                    this.ixT.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.ixU.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.ixV.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.ixV.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ao.setViewTextColor(this.ixT, R.color.CAM_X0302);
                ao.setViewTextColor(this.ixU, R.color.CAM_X0302);
                this.ixV.btV();
                this.ixS.onChangeSkinType();
                this.ixV.setOnClickListener(this);
                this.ixR.setBackgroundColor(0);
                this.ixR.a(this.mActivity, this.ixS, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.ixW == null) {
            this.ixW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.ixW.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjr() {
        if (this.ixW != null) {
            this.ixW.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.ixY) {
            this.ixY = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.ixR.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = au.bsy().bsz() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.ixR.hideTip();
            buj();
        }
    }

    private void buj() {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("tid", this.threadId);
        aqVar.dW("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.an("obj_locate", 7);
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dW("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.ahu = new bz();
        this.ahu.a(getMyPostResIdl.data.thread_info);
        bul();
    }

    private void bul() {
        if (this.ahu != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.ahu.getFid());
            String bnB = this.ahu.bnB();
            String title = this.ahu.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.ahu.getAbstract();
            }
            String tid = this.ahu.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.ahu);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.ahu.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fsD = str2;
            shareItem.linkUrl = str;
            shareItem.eRW = 5;
            shareItem.fsy = this.ixX;
            shareItem.extData = tid;
            shareItem.fsG = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bnB;
            shareItem.tid = tid;
            shareItem.fss = true;
            shareItem.fsF = getShareObjSource();
            shareItem.fsK = getStateThreadType(this.ahu);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fsN = OriginalThreadInfo.ShareInfo.generateShareInfo(this.ahu);
            shareItem.fsO = ShareItem.ForwardInfo.generateForwardInfo(this.ahu);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fsU = this.ahu.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fsG);
            bundle.putInt("obj_type", shareItem.fsK);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eRW);
            shareItem.ae(bundle);
            f.csn().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bz bzVar) {
        if (bzVar == null || bzVar.bnG() == null) {
            return null;
        }
        ArrayList<MediaData> bnG = bzVar.bnG();
        int size = bnG.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bnG.get(i);
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

    private int getStateThreadType(bz bzVar) {
        if (bzVar != null) {
            if (bzVar.bnz()) {
                return 4;
            }
            if (bzVar.bnu() == 1) {
                return 3;
            }
            return bzVar.boS() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.ixR != null) {
            this.ixR.onDestroy();
        }
    }
}
