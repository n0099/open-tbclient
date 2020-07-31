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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.at;
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
    bv aeA;
    private NavigationBarCoverTip hcY;
    private View hcZ;
    private TextView hda;
    private TBSpecificationBtn hdb;
    private com.baidu.tbadk.core.view.a hdc;
    private boolean hdd = false;
    private boolean hde = false;
    private final com.baidu.adp.framework.listener.a hdf = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.bMt();
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
        this.hcY = navigationBarCoverTip;
        this.hdf.setTag(tbPageContext.getUniqueId());
        this.hdf.getHttpMessageListener().setSelfListener(true);
        this.hdf.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hdf);
    }

    public void mR(boolean z) {
        this.hdd = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.hcY != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.hde = false;
                if (this.hcZ == null) {
                    this.hcZ = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.hda = (TextView) this.hcZ.findViewById(R.id.write_thread_success_tips);
                    this.hdb = (TBSpecificationBtn) this.hcZ.findViewById(R.id.share_icon);
                    this.hdb.setTextSize(R.dimen.tbds34);
                    this.hdb.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.bcS();
                    this.hdb.setConfig(dVar);
                }
                ao.setViewTextColor(this.hda, R.color.cp_cont_a);
                this.hdb.bci();
                ao.setBackgroundColor(this.hcY, R.color.cp_link_tip_a_alpha95);
                this.hdb.setOnClickListener(this);
                this.hcY.a(this.mActivity, this.hcZ, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.hdc == null) {
            this.hdc = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.hdc.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMt() {
        if (this.hdc != null) {
            this.hdc.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.hde) {
            this.hde = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.hcY.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = at.baS().baT() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.hcY.hideTip();
            bcw();
        }
    }

    private void bcw() {
        ap apVar = new ap(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        apVar.t("tid", this.threadId);
        apVar.dn("uid", TbadkCoreApplication.getCurrentAccount());
        apVar.ah("obj_locate", 7);
        if (!as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            apVar.dn("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.aeA = new bv();
        this.aeA.a(getMyPostResIdl.data.thread_info);
        bcy();
    }

    private void bcy() {
        if (this.aeA != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aeA.getFid());
            String aWp = this.aeA.aWp();
            String title = this.aeA.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aeA.getAbstract();
            }
            String tid = this.aeA.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.aeA);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.aeA.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.etQ = str2;
            shareItem.linkUrl = str;
            shareItem.dVb = 5;
            shareItem.etL = this.hdd;
            shareItem.extData = tid;
            shareItem.etT = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aWp;
            shareItem.tid = tid;
            shareItem.etH = true;
            shareItem.etS = getShareObjSource();
            shareItem.etX = getStateThreadType(this.aeA);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eua = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aeA);
            shareItem.eub = ShareItem.ForwardInfo.generateForwardInfo(this.aeA);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.euh = this.aeA.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.etT);
            bundle.putInt("obj_type", shareItem.etX);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dVb);
            shareItem.af(bundle);
            f.bSP().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bv bvVar) {
        if (bvVar == null || bvVar.aWu() == null) {
            return null;
        }
        ArrayList<MediaData> aWu = bvVar.aWu();
        int size = aWu.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aWu.get(i);
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

    private int getStateThreadType(bv bvVar) {
        if (bvVar != null) {
            if (bvVar.aWn()) {
                return 4;
            }
            if (bvVar.aWi() == 1) {
                return 3;
            }
            return bvVar.aXD() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hcY != null) {
            this.hcY.onDestroy();
        }
    }
}
