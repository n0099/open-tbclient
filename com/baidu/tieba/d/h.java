package com.baidu.tieba.d;

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
import com.baidu.tbadk.core.data.bx;
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
    bx agB;
    private NavigationBarCoverTip ifi;
    private ShadowLinearLayout ifj;
    private TextView ifk;
    private TextView ifl;
    private TBSpecificationBtn ifm;
    private com.baidu.tbadk.core.view.a ifn;
    private boolean ifo = false;
    private boolean ifp = false;
    private final com.baidu.adp.framework.listener.a ifq = new com.baidu.adp.framework.listener.a(1003010, CmdConfigSocket.CMD_GET_MY_POST) { // from class: com.baidu.tieba.d.h.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            h.this.cgz();
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
        this.ifi = navigationBarCoverTip;
        this.ifq.setTag(tbPageContext.getUniqueId());
        this.ifq.getHttpMessageListener().setSelfListener(true);
        this.ifq.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.ifq);
    }

    public void oM(boolean z) {
        this.ifo = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.ifi != null) {
            this.postId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.f.b.toLong(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.ifp = false;
                if (this.ifj == null) {
                    this.ifj = (ShadowLinearLayout) LayoutInflater.from(this.mActivity).inflate(R.layout.tb_top_toast_layout, (ViewGroup) null, false).findViewById(R.id.tb_top_toast_group);
                    this.ifk = (TextView) this.ifj.findViewById(R.id.tb_top_toast_title);
                    this.ifl = (TextView) this.ifj.findViewById(R.id.tb_top_toast_content);
                    this.ifm = (TBSpecificationBtn) this.ifj.findViewById(R.id.tb_top_toast_btn);
                    this.ifk.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_title));
                    this.ifl.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.write_thread_success_content));
                    this.ifm.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.share_at_once));
                    this.ifm.setConfig(new com.baidu.tbadk.core.view.commonBtn.a());
                }
                ap.setViewTextColor(this.ifk, R.color.CAM_X0302);
                ap.setViewTextColor(this.ifl, R.color.CAM_X0302);
                this.ifm.brT();
                this.ifj.onChangeSkinType();
                this.ifm.setOnClickListener(this);
                this.ifi.setBackgroundColor(0);
                this.ifi.a(this.mActivity, this.ifj, 5000);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.ifn == null) {
            this.ifn = new com.baidu.tbadk.core.view.a(this.mPageContext);
        }
        this.ifn.setDialogVisiable(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgz() {
        if (this.ifn != null) {
            this.ifn.setDialogVisiable(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.ifp) {
            this.ifp = true;
            if (!j.isNetWorkAvailable()) {
                this.mPageContext.showToast(R.string.neterror);
                this.ifi.hideTip();
                return;
            }
            int equipmentWidth = l.getEquipmentWidth(TbadkCoreApplication.getInst());
            int equipmentHeight = l.getEquipmentHeight(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = av.bqC().bqD() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, equipmentWidth, equipmentHeight, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.ifi.hideTip();
            bsh();
        }
    }

    private void bsh() {
        ar arVar = new ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
        arVar.w("tid", this.threadId);
        arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.ak("obj_locate", 7);
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
        this.agB = new bx();
        this.agB.a(getMyPostResIdl.data.thread_info);
        bsj();
    }

    private void bsj() {
        if (this.agB != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.agB.getFid());
            String blG = this.agB.blG();
            String title = this.agB.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.agB.getAbstract();
            }
            String tid = this.agB.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String shareImageUrl = getShareImageUrl(this.agB);
            Uri parse = shareImageUrl == null ? null : Uri.parse(shareImageUrl);
            String str2 = this.agB.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            ShareItem shareItem = new ShareItem();
            shareItem.title = title;
            shareItem.content = format;
            shareItem.readCount = 0L;
            shareItem.fgc = str2;
            shareItem.linkUrl = str;
            shareItem.eFG = 5;
            shareItem.ffX = this.ifo;
            shareItem.extData = tid;
            shareItem.fgf = 3;
            shareItem.fid = valueOf;
            shareItem.fName = blG;
            shareItem.tid = tid;
            shareItem.ffR = true;
            shareItem.fge = getShareObjSource();
            shareItem.fgj = getStateThreadType(this.agB);
            if (parse != null) {
                shareItem.imageUri = parse;
            }
            shareItem.fgm = OriginalThreadInfo.ShareInfo.generateShareInfo(this.agB);
            shareItem.fgn = ShareItem.ForwardInfo.generateForwardInfo(this.agB);
            TbadkCoreApplication.getInst().setShareItem(shareItem);
            shareItem.fgt = this.agB.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", shareItem.fgf);
            bundle.putInt("obj_type", shareItem.fgj);
            bundle.putString("fid", shareItem.fid);
            bundle.putString("tid", shareItem.tid);
            bundle.putInt("obj_source", shareItem.eFG);
            shareItem.ae(bundle);
            f.coW().b(new ShareDialogConfig((Context) this.mActivity, shareItem, true, true));
        }
    }

    private int getShareObjSource() {
        return 15;
    }

    private String getShareImageUrl(bx bxVar) {
        if (bxVar == null || bxVar.blL() == null) {
            return null;
        }
        ArrayList<MediaData> blL = bxVar.blL();
        int size = blL.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = blL.get(i);
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

    private int getStateThreadType(bx bxVar) {
        if (bxVar != null) {
            if (bxVar.blE()) {
                return 4;
            }
            if (bxVar.blz() == 1) {
                return 3;
            }
            return bxVar.bmW() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.ifi != null) {
            this.ifi.onDestroy();
        }
    }
}
