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
    bj Ki;
    private NavigationBarCoverTip fKl;
    private View fKm;
    private TextView fKn;
    private TextView fKo;
    private com.baidu.tbadk.core.view.a fKp;
    private boolean fKq = false;
    private boolean fKr = false;
    private final com.baidu.adp.framework.listener.a fKs = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.c.g.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            g.this.bnJ();
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
        this.fKl = navigationBarCoverTip;
        this.fKs.setTag(tbPageContext.getUniqueId());
        this.fKs.getHttpMessageListener().setSelfListener(true);
        this.fKs.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.fKs);
    }

    public void kk(boolean z) {
        this.fKq = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.fKl != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.fKr = false;
                if (this.fKm == null) {
                    this.fKm = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.fKn = (TextView) this.fKm.findViewById(R.id.write_thread_success_tips);
                    this.fKo = (TextView) this.fKm.findViewById(R.id.share_icon);
                }
                am.setViewTextColor(this.fKn, (int) R.color.cp_cont_a);
                am.setViewTextColor(this.fKo, (int) R.color.cp_cont_a);
                am.setBackgroundResource(this.fKo, R.drawable.share_now_bg);
                am.setBackgroundColor(this.fKl, R.color.cp_link_tip_a_alpha95);
                this.fKo.setOnClickListener(this);
                this.fKl.a(this.mActivity, this.fKm, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.fKp == null) {
            this.fKp = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.fKp.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bnJ() {
        if (this.fKp != null) {
            this.fKp.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.fKr) {
            this.fKr = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.fKl.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = ar.aDX().aDY() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.fKl.hideTip();
            aFq();
        }
    }

    private void aFq() {
        an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        anVar.s("tid", this.threadId);
        anVar.cp("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.Z("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.cp("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.Ki = new bj();
        this.Ki.a(getMyPostResIdl.data.thread_info);
        aFs();
    }

    private void aFs() {
        if (this.Ki != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.Ki.getFid());
            String azJ = this.Ki.azJ();
            String title = this.Ki.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.Ki.getAbstract();
            }
            String tid = this.Ki.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String x = x(this.Ki);
            Uri parse = x == null ? null : Uri.parse(x);
            String str2 = this.Ki.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.dlC = str2;
            shareItem.linkUrl = str;
            shareItem.cQo = 5;
            shareItem.dlx = this.fKq;
            shareItem.extData = tid;
            shareItem.dlF = 3;
            shareItem.fid = valueOf;
            shareItem.fName = azJ;
            shareItem.tid = tid;
            shareItem.dlt = true;
            shareItem.dlE = getShareObjSource();
            shareItem.dlJ = y(this.Ki);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.dlM = OriginalThreadInfo.ShareInfo.generateShareInfo(this.Ki);
            shareItem.dlN = ShareItem.ForwardInfo.generateForwardInfo(this.Ki);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.dlT = this.Ki.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.dlF);
            bundle.putInt("obj_type", shareItem.dlJ);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.cQo);
            shareItem.Y(bundle);
            e.btE().a(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String x(bj bjVar) {
        if (bjVar == null || bjVar.azO() == null) {
            return null;
        }
        ArrayList<MediaData> azO = bjVar.azO();
        int size = azO.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = azO.get(i);
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

    private int y(bj bjVar) {
        if (bjVar != null) {
            if (bjVar.azG()) {
                return 4;
            }
            if (bjVar.azB() == 1) {
                return 3;
            }
            return bjVar.aAT() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.fKl != null) {
            this.fKl.onDestroy();
        }
    }
}
