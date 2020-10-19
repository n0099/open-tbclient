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
    private NewWriteModel fbr;
    private final BaseFragmentActivity hSW;
    private final ForumWriteData iBQ;
    private final SerializableItemInfo iBS;
    private WriteData iCf;
    private a iCg;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fjB = null;
    private final NewWriteModel.d fbF = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.hSW.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dK("tid", postWriteCallBackData.getThreadId()).dK("fid", c.this.iBQ.forumId).dK("fname", c.this.iBQ.forumName).dK("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.hSW.setResult(-1, intent);
                c.this.hSW.finish();
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.hSW = baseFragmentActivity;
        this.iBQ = forumWriteData;
        this.iBS = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fjB = new com.baidu.tbadk.core.view.a(this.hSW);
    }

    private void initData() {
        this.fbr = new NewWriteModel();
        this.iCf = new WriteData();
        this.fbr.b(this.fbF);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hSW, R.string.neterror);
        }
        if (this.iBS != null) {
            this.iCf.setItem_id(String.valueOf(this.iBS.id));
        }
        this.iCf.setForumName(forumWriteData.forumName);
        this.iCf.setContent(str);
        this.iCf.setComment_head(str2);
        this.iCf.setForumId(forumWriteData.forumId);
        this.iCf.setTitle("");
        this.iCf.setIsNoTitle(true);
        if (this.iCg != null) {
            this.iCg.a(this.mInputManager);
        }
        cwQ();
    }

    private void cwQ() {
        this.fbr.e(this.iCf);
        this.fbr.dFC();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fjB.setCancelListener(null);
        this.fjB.setTipString(R.string.sending);
        this.fjB.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fjB.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.iCg = aVar;
    }
}
