package com.baidu.tbadk.mutiprocess.share;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.mutiprocess.b;
/* loaded from: classes2.dex */
public class a implements b<ShareEvent> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mutiprocess.b
    public boolean a(ShareEvent shareEvent) {
        if (TbadkCoreApplication.getInst().isMainProcess(true) && shareEvent.status == 1) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921406, shareEvent));
            String str = shareEvent.tid;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921417, str));
            return true;
        }
        return false;
    }
}
