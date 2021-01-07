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
    private NewWriteModel fGa;
    private final BaseFragmentActivity iJr;
    private WriteData jsI;
    private a jsJ;
    private final ForumWriteData jst;
    private final SerializableItemInfo jsv;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fOA = null;
    private final NewWriteModel.d fGo = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.iJr.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dX("tid", postWriteCallBackData.getThreadId()).dX("fid", c.this.jst.forumId).dX("fname", c.this.jst.forumName).dX("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.iJr.setResult(-1, intent);
                c.this.iJr.finish();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.iJr = baseFragmentActivity;
        this.jst = forumWriteData;
        this.jsv = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fOA = new com.baidu.tbadk.core.view.a(this.iJr);
    }

    private void initData() {
        this.fGa = new NewWriteModel();
        this.jsI = new WriteData();
        this.fGa.b(this.fGo);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.iJr, R.string.neterror);
        }
        if (this.jsv != null) {
            this.jsI.setItem_id(String.valueOf(this.jsv.id));
        }
        this.jsI.setForumName(forumWriteData.forumName);
        this.jsI.setContent(str);
        this.jsI.setComment_head(str2);
        this.jsI.setForumId(forumWriteData.forumId);
        this.jsI.setTitle("");
        this.jsI.setIsNoTitle(true);
        if (this.jsJ != null) {
            this.jsJ.a(this.mInputManager);
        }
        cJw();
    }

    private void cJw() {
        this.fGa.f(this.jsI);
        this.fGa.dQC();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fOA.setCancelListener(null);
        this.fOA.setTipString(R.string.sending);
        this.fOA.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fOA.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.jsJ = aVar;
    }
}
