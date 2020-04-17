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
    bj adG;
    private NavigationBarCoverTip gvu;
    private View gvv;
    private TextView gvw;
    private TextView gvx;
    private com.baidu.tbadk.core.view.a gvy;
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;
    private boolean gvz = false;
    private boolean gvA = false;
    private final com.baidu.adp.framework.listener.a gvB = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bzU();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                g.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                g.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };

    public g(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.gvu = navigationBarCoverTip;
        this.gvB.setTag(tbPageContext.getUniqueId());
        this.gvB.getHttpMessageListener().setSelfListener(true);
        this.gvB.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gvB);
    }

    public void lF(boolean z) {
        this.gvz = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.gvu != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.gvA = false;
                if (this.gvv == null) {
                    this.gvv = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.gvw = (TextView) this.gvv.findViewById(R.id.write_thread_success_tips);
                    this.gvx = (TextView) this.gvv.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.gvw, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.gvx, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.gvx, R.drawable.share_now_bg);
                am.setBackgroundColor(this.gvu, R.color.cp_link_tip_a_alpha95);
                this.gvx.setOnClickListener(this);
                this.gvu.a(this.mActivity, this.gvv, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.gvy == null) {
            this.gvy = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.gvy.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzU() {
        if (this.gvy != null) {
            this.gvy.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.gvA) {
            this.gvA = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.gvu.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aOV().aOW() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.gvu.hideTip();
            aQB();
        }
    }

    private void aQB() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.t("tid", this.threadId);
        anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.af("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.adG = new bj();
        this.adG.a(getMyPostResIdl.data.thread_info);
        aQD();
    }

    private void aQD() {
        if (this.adG != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.adG.getFid());
            String aKJ = this.adG.aKJ();
            String title = this.adG.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.adG.getAbstract();
            }
            String tid = this.adG.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String z = z(this.adG);
            Uri parse = z == null ? null : Uri.parse(z);
            String str2 = this.adG.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.dQv = str2;
            shareItem.linkUrl = str;
            shareItem.dua = 5;
            shareItem.dQq = this.gvz;
            shareItem.extData = tid;
            shareItem.dQy = 3;
            shareItem.fid = valueOf;
            shareItem.fName = aKJ;
            shareItem.tid = tid;
            shareItem.dQl = true;
            shareItem.dQx = getShareObjSource();
            shareItem.dQC = A(this.adG);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dQF = OriginalThreadInfo.ShareInfo.generateShareInfo(this.adG);
            shareItem.dQG = ShareItem.ForwardInfo.generateForwardInfo(this.adG);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dQM = this.adG.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dQy);
            bundle.putInt("obj_type", shareItem.dQC);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.dua);
            shareItem.Y(bundle);
            e.bGe().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String z(bj bjVar) {
        if (bjVar == null || bjVar.aKO() == null) {
            return null;
        }
        ArrayList<MediaData> aKO = bjVar.aKO();
        int size = aKO.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aKO.get(i);
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

    private int A(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.aKG()) {
                return 4;
            }
            if (bjVar.aKB() == 1) {
                return 3;
            }
            return bjVar.aLT() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.gvu != null) {
            this.gvu.onDestroy();
        }
    }
}
