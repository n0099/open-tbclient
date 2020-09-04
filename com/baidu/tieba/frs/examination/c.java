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
    private NewWriteModel eMt;
    private final BaseFragmentActivity hwW;
    private final ForumWriteData ifV;
    private final SerializableItemInfo ifX;
    private WriteData igk;
    private a igl;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a eUz = null;
    private final NewWriteModel.d eMH = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ag agVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.hwW.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new aq("c13723").dD("tid", postWriteCallBackData.getThreadId()).dD("fid", c.this.ifV.forumId).dD("fname", c.this.ifV.forumName).dD("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.hwW.setResult(-1, intent);
                c.this.hwW.finish();
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.hwW = baseFragmentActivity;
        this.ifV = forumWriteData;
        this.ifX = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.eUz = new com.baidu.tbadk.core.view.a(this.hwW);
    }

    private void initData() {
        this.eMt = new NewWriteModel();
        this.igk = new WriteData();
        this.eMt.b(this.eMH);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hwW, R.string.neterror);
        }
        if (this.ifX != null) {
            this.igk.setItem_id(String.valueOf(this.ifX.id));
        }
        this.igk.setForumName(forumWriteData.forumName);
        this.igk.setContent(str);
        this.igk.setComment_head(str2);
        this.igk.setForumId(forumWriteData.forumId);
        this.igk.setTitle("");
        this.igk.setIsNoTitle(true);
        if (this.igl != null) {
            this.igl.a(this.mInputManager);
        }
        cqg();
    }

    private void cqg() {
        this.eMt.d(this.igk);
        this.eMt.dxX();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.eUz.setCancelListener(null);
        this.eUz.setTipString(R.string.sending);
        this.eUz.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eUz.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.igl = aVar;
    }
}
