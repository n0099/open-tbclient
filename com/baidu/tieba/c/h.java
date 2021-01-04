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
    bz aim;
    private TextView iCA;
    private TextView iCB;
    private TBSpecificationBtn iCC;
    private com.baidu.tbadk.core.view.a iCD;
    private boolean iCE = false;
    private boolean iCF = false;
    private final com.baidu.adp.framework.listener.a iCG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.cni();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private NavigationBarCoverTip iCy;
    private ShadowLinearLayout iCz;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.iCy = navigationBarCoverTip;
        this.iCG.setTag(tbPageContext.getUniqueId());
        this.iCG.getHttpMessageListener().setSelfListener(true);
        this.iCG.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iCG);
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.iCy != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.iCF = false;
                if (this.iCz == null) {
                    this.iCz = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.iCA = (TextView) this.iCz.findViewById(R.id.tb_top_toast_title);
                    this.iCB = (TextView) this.iCz.findViewById(R.id.tb_top_toast_content);
                    this.iCC = (TBSpecificationBtn) this.iCz.findViewById(R.id.tb_top_toast_btn);
                    this.iCA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.iCB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.iCC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.iCC.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ao.setViewTextColor(this.iCA, R.color.CAM_X0302);
                ao.setViewTextColor(this.iCB, R.color.CAM_X0302);
                this.iCC.bxO();
                this.iCz.onChangeSkinType();
                this.iCC.setOnClickListener(this);
                this.iCy.setBackgroundColor(0);
                this.iCy.a(this.mActivity, this.iCz, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.iCD == null) {
            this.iCD = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.iCD.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cni() {
        if (this.iCD != null) {
            this.iCD.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.iCF) {
            this.iCF = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.iCy.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = au.bwr().bws() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.iCy.hideTip();
            byc();
        }
    }

    private void byc() {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.w("tid", this.threadId);
        aqVar.dX("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.an("obj_locate", 7);
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dX("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.aim = new bz();
        this.aim.a(getMyPostResIdl.data.thread_info);
        bye();
    }

    private void bye() {
        if (this.aim != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aim.getFid());
            String bru = this.aim.bru();
            String title = this.aim.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aim.getAbstract();
            }
            String tid = this.aim.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.aim);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.aim.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fxm = str2;
            shareItem.linkUrl = str;
            shareItem.eWH = 5;
            shareItem.fxh = this.iCE;
            shareItem.extData = tid;
            shareItem.fxp = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bru;
            shareItem.tid = tid;
            shareItem.fxb = true;
            shareItem.fxo = getShareObjSource();
            shareItem.fxt = getStateThreadType(this.aim);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fxw = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aim);
            shareItem.fxx = ShareItem.ForwardInfo.generateForwardInfo(this.aim);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fxD = this.aim.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fxp);
            bundle.putInt("obj_type", shareItem.fxt);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eWH);
            shareItem.ae(bundle);
            f.cwe().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bz bzVar) {
        if (bzVar == null || bzVar.brz() == null) {
            return null;
        }
        ArrayList<MediaData> brz = bzVar.brz();
        int size = brz.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = brz.get(i);
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
            if (bzVar.brs()) {
                return 4;
            }
            if (bzVar.brn() == 1) {
                return 3;
            }
            return bzVar.bsL() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.iCy != null) {
            this.iCy.onDestroy();
        }
    }
}
