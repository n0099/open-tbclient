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
import com.baidu.tieba.view.ShadowLinearLayout;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    bw agw;
    private NavigationBarCoverTip hLV;
    private ShadowLinearLayout hLW;
    private TextView hLX;
    private TextView hLY;
    private TBSpecificationBtn hLZ;
    private com.baidu.tbadk.core.view.a hMa;
    private boolean hMb = false;
    private boolean hMc = false;
    private final com.baidu.adp.framework.listener.a hMd = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.cbz();
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
        this.hLV = navigationBarCoverTip;
        this.hMd.setTag(tbPageContext.getUniqueId());
        this.hMd.getHttpMessageListener().setSelfListener(true);
        this.hMd.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hMd);
    }

    public void oi(boolean z) {
        this.hMb = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.hLV != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.hMc = false;
                if (this.hLW == null) {
                    this.hLW = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.hLX = (TextView) this.hLW.findViewById(R.id.tb_top_toast_title);
                    this.hLY = (TextView) this.hLW.findViewById(R.id.tb_top_toast_content);
                    this.hLZ = (TBSpecificationBtn) this.hLW.findViewById(R.id.tb_top_toast_btn);
                    this.hLX.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.hLY.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.hLZ.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.hLZ.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.hLX, R.color.cp_link_tip_a);
                ap.setViewTextColor(this.hLY, R.color.cp_link_tip_a);
                this.hLZ.bok();
                this.hLW.onChangeSkinType();
                this.hLZ.setOnClickListener(this);
                this.hLV.setBackgroundColor(0);
                this.hLV.a(this.mActivity, this.hLW, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.hMa == null) {
            this.hMa = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.hMa.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbz() {
        if (this.hMa != null) {
            this.hMa.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.hMc) {
            this.hMc = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.hLV.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = au.bmV().bmW() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.hLV.hideTip();
            boy();
        }
    }

    private void boy() {
        aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aqVar.u("tid", this.threadId);
        aqVar.dK("uid", TbadkCoreApplication.getCurrentAccount());
        aqVar.aj("obj_locate", 7);
        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aqVar.dK("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.agw = new bw();
        this.agw.a(getMyPostResIdl.data.thread_info);
        boA();
    }

    private void boA() {
        if (this.agw != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.agw.getFid());
            String bil = this.agw.bil();
            String title = this.agw.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agw.getAbstract();
            }
            String tid = this.agw.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agw);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agw.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.eSH = str2;
            shareItem.linkUrl = str;
            shareItem.esZ = 5;
            shareItem.eSC = this.hMb;
            shareItem.extData = tid;
            shareItem.eSK = 3;
            shareItem.fid = valueOf;
            shareItem.fName = bil;
            shareItem.tid = tid;
            shareItem.eSw = true;
            shareItem.eSJ = getShareObjSource();
            shareItem.eSO = getStateThreadType(this.agw);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.eSR = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agw);
            shareItem.eSS = ShareItem.ForwardInfo.generateForwardInfo(this.agw);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.eSY = this.agw.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.eSK);
            bundle.putInt("obj_type", shareItem.eSO);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.esZ);
            shareItem.ae(bundle);
            f.cjN().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bw bwVar) {
        if (bwVar == null || bwVar.biq() == null) {
            return null;
        }
        ArrayList<MediaData> biq = bwVar.biq();
        int size = biq.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = biq.get(i);
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
            if (bwVar.bij()) {
                return 4;
            }
            if (bwVar.bie() == 1) {
                return 3;
            }
            return bwVar.bjz() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.hLV != null) {
            this.hLV.onDestroy();
        }
    }
}
