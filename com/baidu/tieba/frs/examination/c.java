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
import com.baidu.tbadk.coreExtra.data.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes16.dex */
public class c {
    private NewWriteModel eMp;
    private final BaseFragmentActivity hwQ;
    private final ForumWriteData ifP;
    private final SerializableItemInfo ifR;
    private WriteData ige;
    private a igf;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a eUv = null;
    private final NewWriteModel.d eMD = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.hwQ.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dD("tid", postWriteCallBackData.getThreadId()).dD("fid", c.this.ifP.forumId).dD("fname", c.this.ifP.forumName).dD("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.hwQ.setResult(-1, intent);
                c.this.hwQ.finish();
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.hwQ = baseFragmentActivity;
        this.ifP = forumWriteData;
        this.ifR = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.eUv = new com.baidu.tbadk.core.view.a(this.hwQ);
    }

    private void initData() {
        this.eMp = new NewWriteModel();
        this.ige = new WriteData();
        this.eMp.b(this.eMD);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hwQ, R.string.neterror);
        }
        if (this.ifR != null) {
            this.ige.setItem_id(String.valueOf(this.ifR.id));
        }
        this.ige.setForumName(forumWriteData.forumName);
        this.ige.setContent(str);
        this.ige.setComment_head(str2);
        this.ige.setForumId(forumWriteData.forumId);
        this.ige.setTitle("");
        this.ige.setIsNoTitle(true);
        if (this.igf != null) {
            this.igf.a(this.mInputManager);
        }
        cqf();
    }

    private void cqf() {
        this.eMp.d(this.ige);
        this.eMp.dxS();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.eUv.setCancelListener(null);
        this.eUv.setTipString(R.string.sending);
        this.eUv.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eUv.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.igf = aVar;
    }
}
