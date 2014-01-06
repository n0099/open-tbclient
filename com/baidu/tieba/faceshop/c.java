package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.MyEmotionGroupData;
import com.baidu.tieba.util.bo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<List<String>, Integer, Boolean> {
    final /* synthetic */ EmotionManageActivity a;

    private c(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(EmotionManageActivity emotionManageActivity, a aVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(List<String>... listArr) {
        int i;
        List<String> list = listArr[0];
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i2 = 0;
        for (String str : list) {
            MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
            myEmotionGroupData.setGroupId(str);
            myEmotionGroupData.setUid(TiebaApplication.A());
            if (com.baidu.tieba.data.emotions.j.a().a(myEmotionGroupData)) {
                bo.c("delete my emotion:" + myEmotionGroupData.getId());
                i = i2 + 1;
            } else {
                i = i2;
            }
            i2 = i;
        }
        if (i2 > 0) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Boolean bool) {
        super.a((c) bool);
        if (bool.booleanValue()) {
            com.baidu.tieba.data.emotions.l.a().b();
            this.a.p = true;
            this.a.a(true);
        }
    }
}
