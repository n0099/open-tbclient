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
                    c.this.ixe.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ar("c13723").dY("tid", postWriteCallBackData.getThreadId()).dY("fid", c.this.jfT.forumId).dY("fname", c.this.jfT.forumName).dY("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.ixe.setResult(-1, intent);
                c.this.ixe.finish();
            }
        }
    };
    private NewWriteModel fwu;
    private final BaseFragmentActivity ixe;
    private final ForumWriteData jfT;
    private final SerializableItemInfo jfV;
    private WriteData jgi;
    private a jgj;
    private InputMethodManager mInputManager;

    /* loaded from: classes22.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.ixe = baseFragmentActivity;
        this.jfT = forumWriteData;
        this.jfV = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fEW = new com.baidu.tbadk.core.view.a(this.ixe);
    }

    private void initData() {
        this.fwu = new NewWriteModel();
        this.jgi = new WriteData();
        this.fwu.b(this.fwI);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.ixe, R.string.neterror);
        }
        if (this.jfV != null) {
            this.jgi.setItem_id(String.valueOf(this.jfV.id));
        }
        this.jgi.setForumName(forumWriteData.forumName);
        this.jgi.setContent(str);
        this.jgi.setComment_head(str2);
        this.jgi.setForumId(forumWriteData.forumId);
        this.jgi.setTitle("");
        this.jgi.setIsNoTitle(true);
        if (this.jgj != null) {
            this.jgj.a(this.mInputManager);
        }
        cGw();
    }

    private void cGw() {
        this.fwu.e(this.jgi);
        this.fwu.dQE();
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
        this.jgj = aVar;
    }
}
