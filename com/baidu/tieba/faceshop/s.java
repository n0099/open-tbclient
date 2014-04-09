package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends BdAsyncTask<List<String>, Integer, Boolean> {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Boolean a(List<String>... listArr) {
        List<String> list = listArr[0];
        if (list == null || list.isEmpty()) {
            return false;
        }
        int i = 0;
        for (String str : list) {
            MyEmotionGroupData myEmotionGroupData = new MyEmotionGroupData();
            myEmotionGroupData.setGroupId(str);
            myEmotionGroupData.setUid(TbadkApplication.E());
            d.a();
            if (d.a(myEmotionGroupData)) {
                com.baidu.adp.lib.util.f.e("delete my emotion:" + myEmotionGroupData.getId());
                i++;
            }
        }
        return i > 0;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        Boolean bool2 = bool;
        super.a((s) bool2);
        if (bool2.booleanValue()) {
            com.baidu.tbadk.editortool.ac.a().b();
            this.a.p = true;
            this.a.a(true);
        }
    }

    private s(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ s(EmotionManageActivity emotionManageActivity, byte b) {
        this(emotionManageActivity);
    }
}
