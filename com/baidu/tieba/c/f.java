package com.baidu.tieba.c;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NavigationBarCoverTip;
import java.text.MessageFormat;
import java.util.ArrayList;
import tbclient.GetMyPost.GetMyPostResIdl;
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    bb aFJ;
    private NavigationBarCoverTip did;
    private View die;
    private TextView dif;
    private TextView dig;
    private com.baidu.tbadk.core.view.d dih;
    private boolean dii = false;
    private boolean dij = false;
    private final com.baidu.adp.framework.listener.a dik = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.alK();
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                f.this.a(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                f.this.a(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    };
    private Activity mActivity;
    private TbPageContext mPageContext;
    private long postId;
    private long threadId;

    public f(TbPageContext tbPageContext, NavigationBarCoverTip navigationBarCoverTip) {
        this.mActivity = tbPageContext.getPageActivity();
        this.mPageContext = tbPageContext;
        this.did = navigationBarCoverTip;
        this.dik.setTag(tbPageContext.getUniqueId());
        this.dik.getHttpMessageListener().setSelfListener(true);
        this.dik.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.dik);
    }

    public void fM(boolean z) {
        this.dii = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.did != null) {
            this.postId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.d(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.dij = false;
                if (this.die == null) {
                    this.die = View.inflate(this.mActivity, e.h.write_thread_share_guide, null);
                    this.dif = (TextView) this.die.findViewById(e.g.write_thread_success_tips);
                    this.dig = (TextView) this.die.findViewById(e.g.share_icon);
                }
                al.h(this.dif, e.d.cp_cont_i);
                al.h(this.dig, e.d.cp_cont_i);
                al.i(this.dig, e.f.share_now_bg);
                al.j(this.did, e.d.cp_link_tip_a_alpha95);
                this.dig.setOnClickListener(this);
                this.did.a(this.mActivity, this.die, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.dih == null) {
            this.dih = new com.baidu.tbadk.core.view.d(this.mPageContext);
        }
        this.dih.bB(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alK() {
        if (this.dih != null) {
            this.dih.bB(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.dij) {
            this.dij = true;
            if (!j.kV()) {
                this.mPageContext.showToast(e.j.neterror);
                this.did.hideTip();
                return;
            }
            int aO = l.aO(TbadkCoreApplication.getInst());
            int aQ = l.aQ(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = aq.Ee().Eg() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, aO, aQ, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.did.hideTip();
            FB();
        }
    }

    private void FB() {
        am amVar = new am("c12386");
        amVar.i("tid", this.threadId);
        amVar.aB("uid", TbadkCoreApplication.getCurrentAccount());
        amVar.y("obj_locate", 7);
        if (!ao.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            amVar.aB(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(amVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(e.j.neterror);
            return;
        }
        this.aFJ = new bb();
        this.aFJ.a(getMyPostResIdl.data.thread_info);
        FD();
    }

    private void FD() {
        if (this.aFJ != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.aFJ.getFid());
            String zZ = this.aFJ.zZ();
            String title = this.aFJ.getTitle();
            String tid = this.aFJ.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String b = b(this.aFJ);
            Uri parse = b == null ? null : Uri.parse(b);
            String str2 = this.aFJ.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(e.j.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.d dVar = new com.baidu.tbadk.coreExtra.c.d();
            dVar.title = title;
            dVar.content = format;
            dVar.aSR = str2;
            dVar.linkUrl = str;
            dVar.awo = 5;
            dVar.aSK = this.dii;
            dVar.extData = tid;
            dVar.aSU = 3;
            dVar.fid = valueOf;
            dVar.aSM = zZ;
            dVar.tid = tid;
            dVar.aSI = true;
            dVar.aST = getShareObjSource();
            dVar.aSV = c(this.aFJ);
            if (parse != null) {
                dVar.imageUri = parse;
            }
            dVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.aFJ);
            TbadkCoreApplication.getInst().setShareItem(dVar);
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", dVar.aSU);
            bundle.putInt("obj_type", dVar.aSV);
            bundle.putString(ImageViewerConfig.FORUM_ID, dVar.fid);
            bundle.putString("tid", dVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, dVar.awo);
            dVar.k(bundle);
            e.asB().a(new ShareDialogConfig((Context) this.mActivity, dVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String b(bb bbVar) {
        if (bbVar == null || bbVar.Ae() == null) {
            return null;
        }
        ArrayList<MediaData> Ae = bbVar.Ae();
        int size = Ae.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = Ae.get(i);
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

    private int c(bb bbVar) {
        if (bbVar != null) {
            if (bbVar.zV()) {
                return 4;
            }
            if (bbVar.zQ() == 1) {
                return 3;
            }
            return bbVar.AY() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.did != null) {
            this.did.onDestroy();
        }
    }
}
