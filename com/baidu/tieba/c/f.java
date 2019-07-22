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
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
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
public class f implements View.OnClickListener {
    bg We;
    private NavigationBarCoverTip eMo;
    private View eMp;
    private TextView eMq;
    private TextView eMr;
    private com.baidu.tbadk.core.view.b eMs;
    private boolean eMt = false;
    private boolean eMu = false;
    private final com.baidu.adp.framework.listener.a eMv = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_GET_MY_POST, 303111) { // from class: com.baidu.tieba.c.f.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            f.this.aUz();
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
        this.eMo = navigationBarCoverTip;
        this.eMv.setTag(tbPageContext.getUniqueId());
        this.eMv.getHttpMessageListener().setSelfListener(true);
        this.eMv.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.eMv);
    }

    public void iS(boolean z) {
        this.eMt = z;
    }

    public void b(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData != null && this.eMo != null) {
            this.postId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getPostId(), 0L);
            this.threadId = com.baidu.adp.lib.g.b.c(postWriteCallBackData.getThreadId(), 0L);
            if (this.postId != 0 && this.threadId != 0) {
                this.eMu = false;
                if (this.eMp == null) {
                    this.eMp = View.inflate(this.mActivity, R.layout.write_thread_share_guide, null);
                    this.eMq = (TextView) this.eMp.findViewById(R.id.write_thread_success_tips);
                    this.eMr = (TextView) this.eMp.findViewById(R.id.share_icon);
                }
                am.j(this.eMq, R.color.cp_btn_a);
                am.j(this.eMr, R.color.cp_btn_a);
                am.k(this.eMr, R.drawable.share_now_bg);
                am.l(this.eMo, R.color.cp_link_tip_a_alpha95);
                this.eMr.setOnClickListener(this);
                this.eMo.a(this.mActivity, this.eMp, UIMsg.m_AppUI.MSG_APP_GPS);
            }
        }
    }

    private void showLoadingDialog() {
        if (this.eMs == null) {
            this.eMs = new com.baidu.tbadk.core.view.b(this.mPageContext);
        }
        this.eMs.ej(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUz() {
        if (this.eMs != null) {
            this.eMs.ej(false);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.eMu) {
            this.eMu = true;
            if (!j.kc()) {
                this.mPageContext.showToast(R.string.neterror);
                this.eMo.hideTip();
                return;
            }
            int af = l.af(TbadkCoreApplication.getInst());
            int ah = l.ah(TbadkCoreApplication.getInst());
            float f = this.mActivity.getResources().getDisplayMetrics().density;
            int i = as.ajo().ajq() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(this.mPageContext.getUniqueId());
            requestGetMyPostNetMessage.setParams(this.threadId, this.postId, 0L, af, ah, f, i);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
            showLoadingDialog();
            this.eMo.hideTip();
            akW();
        }
    }

    private void akW() {
        an anVar = new an("c12386");
        anVar.l("tid", this.threadId);
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.P("obj_locate", 7);
        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            anVar.bT(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, GetMyPostResIdl getMyPostResIdl) {
        if (i != 0 || getMyPostResIdl == null || getMyPostResIdl.data == null || getMyPostResIdl.data.thread_info == null) {
            this.mPageContext.showToast(R.string.neterror);
            return;
        }
        this.We = new bg();
        this.We.a(getMyPostResIdl.data.thread_info);
        akY();
    }

    private void akY() {
        if (this.We != null && this.mActivity != null) {
            String valueOf = String.valueOf(this.We.getFid());
            String aeC = this.We.aeC();
            String title = this.We.getTitle();
            if (TextUtils.isEmpty(title)) {
                title = this.We.getAbstract();
            }
            String tid = this.We.getTid();
            String str = "http://tieba.baidu.com/p/" + tid + "?share=9105&fr=share";
            String r = r(this.We);
            Uri parse = r == null ? null : Uri.parse(r);
            String str2 = this.We.getAbstract();
            String format = MessageFormat.format(this.mActivity.getResources().getString(R.string.share_content_tpl), title, str2);
            com.baidu.tbadk.coreExtra.c.e eVar = new com.baidu.tbadk.coreExtra.c.e();
            eVar.title = title;
            eVar.content = format;
            eVar.ckI = str2;
            eVar.linkUrl = str;
            eVar.bMt = 5;
            eVar.ckz = this.eMt;
            eVar.extData = tid;
            eVar.ckL = 3;
            eVar.fid = valueOf;
            eVar.ckC = aeC;
            eVar.tid = tid;
            eVar.ckv = true;
            eVar.ckK = getShareObjSource();
            eVar.ckP = s(this.We);
            if (parse != null) {
                eVar.imageUri = parse;
            }
            eVar.originalThreadInfo = OriginalThreadInfo.parseFromThreadData(this.We);
            TbadkCoreApplication.getInst().setShareItem(eVar);
            eVar.ckZ = this.We.getShareImageUrl();
            Bundle bundle = new Bundle();
            bundle.putInt("obj_param1", eVar.ckL);
            bundle.putInt("obj_type", eVar.ckP);
            bundle.putString("fid", eVar.fid);
            bundle.putString("tid", eVar.tid);
            bundle.putInt(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, eVar.bMt);
            eVar.E(bundle);
            e.bbB().a(new ShareDialogConfig((Context) this.mActivity, eVar, true, true));
        }
    }

    private int getShareObjSource() {
        return 7;
    }

    private String r(bg bgVar) {
        if (bgVar == null || bgVar.aeH() == null) {
            return null;
        }
        ArrayList<MediaData> aeH = bgVar.aeH();
        int size = aeH.size();
        for (int i = 0; i < size; i++) {
            MediaData mediaData = aeH.get(i);
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

    private int s(bg bgVar) {
        if (bgVar != null) {
            if (bgVar.aez()) {
                return 4;
            }
            if (bgVar.aeu() == 1) {
                return 3;
            }
            return bgVar.afJ() ? 2 : 1;
        }
        return 0;
    }

    public void onDestroy() {
        if (this.eMo != null) {
            this.eMo.onDestroy();
        }
    }
}
