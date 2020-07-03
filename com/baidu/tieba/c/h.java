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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.as;
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
    bu aeK;
    private NavigationBarCoverTip gXt;
    private View gXu;
    private TextView gXv;
    private TBSpecificationBtn gXw;
    private com.baidu.tbadk.core.view.a gXx;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;
    private boolean gXy = false;
    private boolean gXz = false;
    private final com.baidu.adp.framework.listener.a gXA = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.bJm();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                h.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                h.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };

    public h(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.gXt = navigationBarCoverTip;
        this.gXA.setTag(tbPageContext.getUniqueId());
        this.gXA.getHttpMessageListener().setSelfListener(true);
        this.gXA.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gXA);
    }

    public void mm(boolean z) {
        this.gXy = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.gXt != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.gXz = false;
                if (this.gXu == null) {
                    this.gXu = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.gXv = (TextView) this.gXu.findViewById(R.id.write_thread_success_tips);
                    this.gXw = (TBSpecificationBtn) this.gXu.findViewById(R.id.share_icon);
                    this.gXw.setTextSize(R.dimen.tbds34);
                    this.gXw.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    com.baidu.tbadk.core.view.commonBtn.d dVar = new com.baidu.tbadk.core.view.commonBtn.d();
                    dVar.aYV();
                    this.gXw.setConfig(dVar);
                }
                an.setViewTextColor(this.gXv, (int) R.color.cp_cont_a);
                this.gXw.aYj();
                an.setBackgroundColor(this.gXt, R.color.cp_link_tip_a_alpha95);
                this.gXw.setOnClickListener(this);
                this.gXt.a(this.mActivity, this.gXu, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.gXx == null) {
            this.gXx = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.gXx.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJm() {
        if (this.gXx != null) {
            this.gXx.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gXz) {
            this.gXz = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.gXt.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = as.aWR().aWS() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.gXt.hideTip();
            aYz();
        }
    }

    private void aYz() {
        ao aoVar = new ao(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        aoVar.s("tid", this.threadId);
        aoVar.dk("uid", TbadkCoreApplication.getCurrentAccount());
        aoVar.ag("obj_locate", 7);
        if (!ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            aoVar.dk("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.aeK = new bu();
        this.aeK.a(getMyPostResIdl.data.thread_info);
        aYB();
    }

    private void aYB() {
        if (this.aeK != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aeK.getFid());
            String aSt = this.aeK.aSt();
            String title = this.aeK.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.aeK.getAbstract();
            }
            String tid = this.aeK.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String A = A(this.aeK);
            Uri parse = A == null ? null : Uri.parse(A);
            String str2 = this.aeK.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.enE = str2;
            shareItem.linkUrl = str;
            shareItem.dOP = 5;
            shareItem.enz = this.gXy;
            shareItem.extData = tid;
            shareItem.enH = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aSt;
            shareItem.tid = tid;
            shareItem.enu = true;
            shareItem.enG = getShareObjSource();
            shareItem.enL = B(this.aeK);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.enO = OriginalThreadInfo.ShareInfo.generateShareInfo(this.aeK);
            shareItem.enP = ShareItem.ForwardInfo.generateForwardInfo(this.aeK);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.enV = this.aeK.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.enH);
            bundle.putInt("obj_type", shareItem.enL);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dOP);
            shareItem.ae(bundle);
            f.bPD().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String A(bu buVar) {
        if (buVar == null || buVar.aSy() == null) {
            return null;
        }
        ArrayList<MediaData> aSy = buVar.aSy();
        int size = aSy.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aSy.get(i);
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

    private int B(bu buVar) {
        if (buVar != null) {
            if (buVar.aSr()) {
                return 4;
            }
            if (buVar.aSm() == 1) {
                return 3;
            }
            return buVar.aTH() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gXt != null) {
            this.gXt.onDestroy();
        }
    }
}
