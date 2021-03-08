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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.av;
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
    cb aiB;
    private TextView iFA;
    private TextView iFB;
    private TBSpecificationBtn iFC;
    private com.baidu.tbadk.core.view.a iFD;
    private boolean iFE = false;
    private boolean iFF = false;
    private final com.baidu.adp.framework.listener.a iFG = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.ckD();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private NavigationBarCoverTip iFy;
    private ShadowLinearLayout iFz;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.iFy = navigationBarCoverTip;
        this.iFG.setTag(tbPageContext.getUniqueId());
        this.iFG.getHttpMessageListener().setSelfListener(true);
        this.iFG.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.iFG);
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.iFy != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.iFF = false;
                if (this.iFz == null) {
                    this.iFz = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.iFA = (TextView) this.iFz.findViewById(R.id.tb_top_toast_title);
                    this.iFB = (TextView) this.iFz.findViewById(R.id.tb_top_toast_content);
                    this.iFC = (TBSpecificationBtn) this.iFz.findViewById(R.id.tb_top_toast_btn);
                    this.iFA.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.iFB.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.iFC.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.iFC.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.iFA, R.color.CAM_X0302);
                ap.setViewTextColor(this.iFB, R.color.CAM_X0302);
                this.iFC.bus();
                this.iFz.onChangeSkinType();
                this.iFC.setOnClickListener(this);
                this.iFy.setBackgroundColor(0);
                this.iFy.a(this.mActivity, this.iFz, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.iFD == null) {
            this.iFD = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.iFD.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckD() {
        if (this.iFD != null) {
            this.iFD.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.iFF) {
            this.iFF = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.iFy.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = av.bsV().bsW() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.iFy.hideTip();
            buG();
        }
    }

    private void buG() {
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.v("tid", this.threadId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.aq("obj_locate", 7);
        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.aiB = new cb();
        this.aiB.a(getMyPostResIdl.data.thread_info);
        buI();
    }

    private void buI() {
        if (this.aiB != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aiB.getFid());
            String bnW = this.aiB.bnW();
            String title = this.aiB.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aiB.getAbstract();
            }
            String tid = this.aiB.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.aiB);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.aiB.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fwu = str2;
            shareItem.linkUrl = str;
            shareItem.eVJ = 5;
            shareItem.fwp = this.iFE;
            shareItem.extData = tid;
            shareItem.fwx = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bnW;
            shareItem.tid = tid;
            shareItem.fwj = true;
            shareItem.fww = getShareObjSource();
            shareItem.fwB = getStateThreadType(this.aiB);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fwE = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aiB);
            shareItem.fwF = ShareItem.ForwardInfo.generateForwardInfo(this.aiB);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fwL = this.aiB.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fwx);
            bundle.putInt("obj_type", shareItem.fwB);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eVJ);
            shareItem.ae(bundle);
            f.ctM().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(cb cbVar) {
        if (cbVar == null || cbVar.bob() == null) {
            return null;
        }
        ArrayList<MediaData> bob = cbVar.bob();
        int size = bob.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = bob.get(i);
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

    private int getStateThreadType(cb cbVar) {
        if (cbVar != null) {
            if (cbVar.bnU()) {
                return 4;
            }
            if (cbVar.bnP() == 1) {
                return 3;
            }
            return cbVar.bpm() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.iFy != null) {
            this.iFy.onDestroy();
        }
    }
}
