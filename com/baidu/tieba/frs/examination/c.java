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
    private final BaseFragmentActivity iKH;
    private final ForumWriteData jtH;
    private final SerializableItemInfo jtJ;
    private WriteData jtW;
    private a jtX;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fMe = null;
    private final NewWriteModel.d fDW = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.iKH.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ar("c13723").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", c.this.jtH.forumId).dR("fname", c.this.jtH.forumName).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.iKH.setResult(-1, intent);
                c.this.iKH.finish();
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.iKH = baseFragmentActivity;
        this.jtH = forumWriteData;
        this.jtJ = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fMe = new com.baidu.tbadk.core.view.a(this.iKH);
    }

    private void initData() {
        this.fDH = new NewWriteModel();
        this.jtW = new WriteData();
        this.fDH.b(this.fDW);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.iKH, R.string.neterror);
        }
        if (this.jtJ != null) {
            this.jtW.setItem_id(String.valueOf(this.jtJ.id));
        }
        this.jtW.setForumName(forumWriteData.forumName);
        this.jtW.setContent(str);
        this.jtW.setComment_head(str2);
        this.jtW.setForumId(forumWriteData.forumId);
        this.jtW.setTitle("");
        this.jtW.setIsNoTitle(true);
        if (this.jtX != null) {
            this.jtX.a(this.mInputManager);
        }
        cGY();
    }

    private void cGY() {
        this.fDH.f(this.jtW);
        this.fDH.dPd();
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
        this.jtX = aVar;
    }
}
