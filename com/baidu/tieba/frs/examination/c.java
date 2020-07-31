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
    private final ForumWriteData hRF;
    private final SerializableItemInfo hRH;
    private WriteData hRU;
    private a hRV;
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
                TiebaStatic.log(new ap("c13723").dn("tid", postWriteCallBackData.getThreadId()).dn("fid", c.this.hRF.forumId).dn("fname", c.this.hRF.forumName).dn("uid", TbadkCoreApplication.getCurrentAccount()));
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
        this.hRF = forumWriteData;
        this.hRH = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.eJP = new com.baidu.tbadk.core.view.a(this.hjZ);
    }

    private void initData() {
        this.eBQ = new NewWriteModel();
        this.hRU = new WriteData();
        this.eBQ.b(this.eCe);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hjZ, R.string.neterror);
        }
        if (this.hRH != null) {
            this.hRU.setItem_id(String.valueOf(this.hRH.id));
        }
        this.hRU.setForumName(forumWriteData.forumName);
        this.hRU.setContent(str);
        this.hRU.setComment_head(str2);
        this.hRU.setForumId(forumWriteData.forumId);
        this.hRU.setTitle("");
        this.hRU.setIsNoTitle(true);
        if (this.hRV != null) {
            this.hRV.a(this.mInputManager);
        }
        cfA();
    }

    private void cfA() {
        this.eBQ.d(this.hRU);
        this.eBQ.dmw();
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
        this.hRV = aVar;
    }
}
