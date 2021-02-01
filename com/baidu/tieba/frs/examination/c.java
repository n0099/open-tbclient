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
    private NewWriteModel fDH;
    private final BaseFragmentActivity iKt;
    private WriteData jtI;
    private a jtJ;
    private final ForumWriteData jtt;
    private final SerializableItemInfo jtv;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fMe = null;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.iKt.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ar("c13723").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", c.this.jtt.forumId).dR("fname", c.this.jtt.forumName).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.iKt.setResult(-1, intent);
                c.this.iKt.finish();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.iKt = baseFragmentActivity;
        this.jtt = forumWriteData;
        this.jtv = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fMe = new com.baidu.tbadk.core.view.a(this.iKt);
    }

    private void initData() {
        this.fDH = new NewWriteModel();
        this.jtI = new WriteData();
        this.fDH.b(this.fDW);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.iKt, R.string.neterror);
        }
        if (this.jtv != null) {
            this.jtI.setItem_id(String.valueOf(this.jtv.id));
        }
        this.jtI.setForumName(forumWriteData.forumName);
        this.jtI.setContent(str);
        this.jtI.setComment_head(str2);
        this.jtI.setForumId(forumWriteData.forumId);
        this.jtI.setTitle("");
        this.jtI.setIsNoTitle(true);
        if (this.jtJ != null) {
            this.jtJ.a(this.mInputManager);
        }
        cGR();
    }

    private void cGR() {
        this.fDH.f(this.jtI);
        this.fDH.dOV();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fMe.setCancelListener(null);
        this.fMe.setTipString(R.string.sending);
        this.fMe.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fMe.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.jtJ = aVar;
    }
}
