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
/* loaded from: classes2.dex */
public class c {
    private NewWriteModel fFg;
    private final BaseFragmentActivity iMq;
    private WriteData jvF;
    private a jvG;
    private final ForumWriteData jvq;
    private final SerializableItemInfo jvs;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fNE = null;
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.iMq.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ar("c13723").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", c.this.jvq.forumId).dR("fname", c.this.jvq.forumName).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.iMq.setResult(-1, intent);
                c.this.iMq.finish();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.iMq = baseFragmentActivity;
        this.jvq = forumWriteData;
        this.jvs = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fNE = new com.baidu.tbadk.core.view.a(this.iMq);
    }

    private void initData() {
        this.fFg = new NewWriteModel();
        this.jvF = new WriteData();
        this.fFg.b(this.fFv);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.iMq, R.string.neterror);
        }
        if (this.jvs != null) {
            this.jvF.setItem_id(String.valueOf(this.jvs.id));
        }
        this.jvF.setForumName(forumWriteData.forumName);
        this.jvF.setContent(str);
        this.jvF.setComment_head(str2);
        this.jvF.setForumId(forumWriteData.forumId);
        this.jvF.setTitle("");
        this.jvF.setIsNoTitle(true);
        if (this.jvG != null) {
            this.jvG.a(this.mInputManager);
        }
        cHe();
    }

    private void cHe() {
        this.fFg.f(this.jvF);
        this.fFg.dPm();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fNE.setCancelListener(null);
        this.fNE.setTipString(R.string.sending);
        this.fNE.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fNE.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.jvG = aVar;
    }
}
