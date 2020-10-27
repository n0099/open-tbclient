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
/* loaded from: classes22.dex */
public class c {
    private NewWriteModel fjQ;
    private WriteData iOB;
    private a iOC;
    private final ForumWriteData iOm;
    private final SerializableItemInfo iOo;
    private final BaseFragmentActivity ifx;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fsa = null;
    private final NewWriteModel.d fke = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.ifx.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", c.this.iOm.forumId).dR("fname", c.this.iOm.forumName).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.ifx.setResult(-1, intent);
                c.this.ifx.finish();
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.ifx = baseFragmentActivity;
        this.iOm = forumWriteData;
        this.iOo = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fsa = new com.baidu.tbadk.core.view.a(this.ifx);
    }

    private void initData() {
        this.fjQ = new NewWriteModel();
        this.iOB = new WriteData();
        this.fjQ.b(this.fke);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.ifx, R.string.neterror);
        }
        if (this.iOo != null) {
            this.iOB.setItem_id(String.valueOf(this.iOo.id));
        }
        this.iOB.setForumName(forumWriteData.forumName);
        this.iOB.setContent(str);
        this.iOB.setComment_head(str2);
        this.iOB.setForumId(forumWriteData.forumId);
        this.iOB.setTitle("");
        this.iOB.setIsNoTitle(true);
        if (this.iOC != null) {
            this.iOC.a(this.mInputManager);
        }
        czX();
    }

    private void czX() {
        this.fjQ.e(this.iOB);
        this.fjQ.dIK();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fsa.setCancelListener(null);
        this.fsa.setTipString(R.string.sending);
        this.fsa.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fsa.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.iOC = aVar;
    }
}
