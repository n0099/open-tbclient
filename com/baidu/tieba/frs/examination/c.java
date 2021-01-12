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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes2.dex */
public class c {
    private NewWriteModel fBs;
    private final BaseFragmentActivity iEK;
    private final ForumWriteData jnN;
    private final SerializableItemInfo jnP;
    private WriteData joc;
    private a jod;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fJT = null;
    private final NewWriteModel.d fBH = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.iEK.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dW("tid", postWriteCallBackData.getThreadId()).dW("fid", c.this.jnN.forumId).dW("fname", c.this.jnN.forumName).dW("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.iEK.setResult(-1, intent);
                c.this.iEK.finish();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.iEK = baseFragmentActivity;
        this.jnN = forumWriteData;
        this.jnP = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fJT = new com.baidu.tbadk.core.view.a(this.iEK);
    }

    private void initData() {
        this.fBs = new NewWriteModel();
        this.joc = new WriteData();
        this.fBs.b(this.fBH);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.iEK, R.string.neterror);
        }
        if (this.jnP != null) {
            this.joc.setItem_id(String.valueOf(this.jnP.id));
        }
        this.joc.setForumName(forumWriteData.forumName);
        this.joc.setContent(str);
        this.joc.setComment_head(str2);
        this.joc.setForumId(forumWriteData.forumId);
        this.joc.setTitle("");
        this.joc.setIsNoTitle(true);
        if (this.jod != null) {
            this.jod.a(this.mInputManager);
        }
        cFE();
    }

    private void cFE() {
        this.fBs.f(this.joc);
        this.fBs.dMK();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fJT.setCancelListener(null);
        this.fJT.setTipString(R.string.sending);
        this.fJT.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fJT.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.jod = aVar;
    }
}
