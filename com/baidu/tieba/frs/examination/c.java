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
/* loaded from: classes21.dex */
public class c {
    private NewWriteModel foP;
    private final ForumWriteData iUV;
    private final SerializableItemInfo iUX;
    private WriteData iVk;
    private a iVl;
    private final BaseFragmentActivity imj;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a fxh = null;
    private final NewWriteModel.d fpd = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.imj.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ar("c13723").dR("tid", postWriteCallBackData.getThreadId()).dR("fid", c.this.iUV.forumId).dR("fname", c.this.iUV.forumName).dR("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.imj.setResult(-1, intent);
                c.this.imj.finish();
            }
        }
    };

    /* loaded from: classes21.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.imj = baseFragmentActivity;
        this.iUV = forumWriteData;
        this.iUX = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.fxh = new com.baidu.tbadk.core.view.a(this.imj);
    }

    private void initData() {
        this.foP = new NewWriteModel();
        this.iVk = new WriteData();
        this.foP.b(this.fpd);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.imj, R.string.neterror);
        }
        if (this.iUX != null) {
            this.iVk.setItem_id(String.valueOf(this.iUX.id));
        }
        this.iVk.setForumName(forumWriteData.forumName);
        this.iVk.setContent(str);
        this.iVk.setComment_head(str2);
        this.iVk.setForumId(forumWriteData.forumId);
        this.iVk.setTitle("");
        this.iVk.setIsNoTitle(true);
        if (this.iVl != null) {
            this.iVl.a(this.mInputManager);
        }
        cCc();
    }

    private void cCc() {
        this.foP.e(this.iVk);
        this.foP.dLl();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.fxh.setCancelListener(null);
        this.fxh.setTipString(R.string.sending);
        this.fxh.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.fxh.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.iVl = aVar;
    }
}
