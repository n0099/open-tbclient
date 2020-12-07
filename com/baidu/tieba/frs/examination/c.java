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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes22.dex */
public class c {
    private com.baidu.tbadk.core.view.a fEW = null;
    private final NewWriteModel.d fwI = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.ixc.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ar("c13723").dY("tid", postWriteCallBackData.getThreadId()).dY("fid", c.this.jfR.forumId).dY("fname", c.this.jfR.forumName).dY("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.ixc.setResult(-1, intent);
                c.this.ixc.finish();
            }
        }
    };
    private NewWriteModel fwu;
    private final BaseFragmentActivity ixc;
    private final ForumWriteData jfR;
    private final SerializableItemInfo jfT;
    private WriteData jgg;
    private a jgh;
    private InputMethodManager mInputManager;

    /* loaded from: classes22.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.ixc = baseFragmentActivity;
        this.jfR = forumWriteData;
        this.jfT = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fEW = new com.baidu.tbadk.core.view.a(this.ixc);
    }

    private void initData() {
        this.fwu = new NewWriteModel();
        this.jgg = new WriteData();
        this.fwu.b(this.fwI);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.ixc, R.string.neterror);
        }
        if (this.jfT != null) {
            this.jgg.setItem_id(String.valueOf(this.jfT.id));
        }
        this.jgg.setForumName(forumWriteData.forumName);
        this.jgg.setContent(str);
        this.jgg.setComment_head(str2);
        this.jgg.setForumId(forumWriteData.forumId);
        this.jgg.setTitle("");
        this.jgg.setIsNoTitle(true);
        if (this.jgh != null) {
            this.jgh.a(this.mInputManager);
        }
        cGv();
    }

    private void cGv() {
        this.fwu.e(this.jgg);
        this.fwu.dQD();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fEW.setCancelListener(null);
        this.fEW.setTipString(R.string.sending);
        this.fEW.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fEW.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.jgh = aVar;
    }
}
