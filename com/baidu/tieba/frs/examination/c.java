package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes16.dex */
public class c {
    private NewWriteModel eBQ;
    private final ForumWriteData hRH;
    private final SerializableItemInfo hRJ;
    private WriteData hRW;
    private a hRX;
    private final BaseFragmentActivity hjZ;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a eJP = null;
    private final NewWriteModel.d eCe = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.hjZ.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ap("c13723").dn("tid", postWriteCallBackData.getThreadId()).dn("fid", c.this.hRH.forumId).dn("fname", c.this.hRH.forumName).dn("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.hjZ.setResult(-1, intent);
                c.this.hjZ.finish();
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.hjZ = baseFragmentActivity;
        this.hRH = forumWriteData;
        this.hRJ = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.eJP = new com.baidu.tbadk.core.view.a(this.hjZ);
    }

    private void initData() {
        this.eBQ = new NewWriteModel();
        this.hRW = new WriteData();
        this.eBQ.b(this.eCe);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hjZ, R.string.neterror);
        }
        if (this.hRJ != null) {
            this.hRW.setItem_id(String.valueOf(this.hRJ.id));
        }
        this.hRW.setForumName(forumWriteData.forumName);
        this.hRW.setContent(str);
        this.hRW.setComment_head(str2);
        this.hRW.setForumId(forumWriteData.forumId);
        this.hRW.setTitle("");
        this.hRW.setIsNoTitle(true);
        if (this.hRX != null) {
            this.hRX.a(this.mInputManager);
        }
        cfA();
    }

    private void cfA() {
        this.eBQ.d(this.hRW);
        this.eBQ.dmx();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.eJP.setCancelListener(null);
        this.eJP.setTipString(R.string.sending);
        this.eJP.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eJP.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.hRX = aVar;
    }
}
