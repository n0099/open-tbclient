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
    private NewWriteModel fpI;
    private final ForumWriteData iUj;
    private final SerializableItemInfo iUl;
    private WriteData iUy;
    private a iUz;
    private final BaseFragmentActivity ilu;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fxS = null;
    private final NewWriteModel.d fpW = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.ilu.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", c.this.iUj.forumId).dR("fname", c.this.iUj.forumName).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.ilu.setResult(-1, intent);
                c.this.ilu.finish();
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.ilu = baseFragmentActivity;
        this.iUj = forumWriteData;
        this.iUl = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fxS = new com.baidu.tbadk.core.view.a(this.ilu);
    }

    private void initData() {
        this.fpI = new NewWriteModel();
        this.iUy = new WriteData();
        this.fpI.b(this.fpW);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.ilu, R.string.neterror);
        }
        if (this.iUl != null) {
            this.iUy.setItem_id(String.valueOf(this.iUl.id));
        }
        this.iUy.setForumName(forumWriteData.forumName);
        this.iUy.setContent(str);
        this.iUy.setComment_head(str2);
        this.iUy.setForumId(forumWriteData.forumId);
        this.iUy.setTitle("");
        this.iUy.setIsNoTitle(true);
        if (this.iUz != null) {
            this.iUz.a(this.mInputManager);
        }
        cCy();
    }

    private void cCy() {
        this.fpI.e(this.iUy);
        this.fpI.dLm();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fxS.setCancelListener(null);
        this.fxS.setTipString(R.string.sending);
        this.fxS.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fxS.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.iUz = aVar;
    }
}
