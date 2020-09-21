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
/* loaded from: classes21.dex */
public class c {
    private NewWriteModel ePk;
    private final BaseFragmentActivity hEa;
    private final ForumWriteData imW;
    private final SerializableItemInfo imY;
    private WriteData inl;
    private a inm;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a eXp = null;
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.hEa.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dF("tid", postWriteCallBackData.getThreadId()).dF("fid", c.this.imW.forumId).dF("fname", c.this.imW.forumName).dF("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.hEa.setResult(-1, intent);
                c.this.hEa.finish();
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.hEa = baseFragmentActivity;
        this.imW = forumWriteData;
        this.imY = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.eXp = new com.baidu.tbadk.core.view.a(this.hEa);
    }

    private void initData() {
        this.ePk = new NewWriteModel();
        this.inl = new WriteData();
        this.ePk.b(this.ePy);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hEa, R.string.neterror);
        }
        if (this.imY != null) {
            this.inl.setItem_id(String.valueOf(this.imY.id));
        }
        this.inl.setForumName(forumWriteData.forumName);
        this.inl.setContent(str);
        this.inl.setComment_head(str2);
        this.inl.setForumId(forumWriteData.forumId);
        this.inl.setTitle("");
        this.inl.setIsNoTitle(true);
        if (this.inm != null) {
            this.inm.a(this.mInputManager);
        }
        ctt();
    }

    private void ctt() {
        this.ePk.e(this.inl);
        this.ePk.dBQ();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.eXp.setCancelListener(null);
        this.eXp.setTipString(R.string.sending);
        this.eXp.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eXp.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.inm = aVar;
    }
}
