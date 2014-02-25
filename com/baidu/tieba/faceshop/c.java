package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.emotions.MyEmotionGroupData;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<List<String>, Integer, Boolean> {
    final /* synthetic */ EmotionManageActivity a;

    private c(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c(EmotionManageActivity emotionManageActivity, c cVar) {
        this(emotionManageActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Boolean a(List<String>... listArr) {
        List<String> list = listArr[0];
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        for (String str : list) {
            MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
            myEmotionGroupData.setGroupId(str);
            myEmotionGroupData.setUid(TiebaApplication.A());
            if (com.baidu.tieba.data.emotions.j.a().a(myEmotionGroupData)) {
                com.baidu.adp.lib.util.f.e("delete my emotion:" + myEmotionGroupData.getId());
                i++;
            }
        }
        if (i > 0) {
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
