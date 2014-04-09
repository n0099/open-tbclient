package com.baidu.tieba.faceshop;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.editortool.EmotionGroupData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v extends BdAsyncTask<String, Integer, List<u>> {
    final /* synthetic */ EmotionManageActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ List<u> a(String... strArr) {
        List<MyEmotionGroupData> a = d.a().a(TbadkApplication.E());
        List<EmotionGroupData> a2 = com.baidu.tbadk.editortool.v.a().a(1);
        LinkedList linkedList = new LinkedList();
        for (MyEmotionGroupData myEmotionGroupData : a) {
            Iterator<EmotionGroupData> it = a2.iterator();
            while (true) {
                if (it.hasNext()) {
                    EmotionGroupData next = it.next();
                    if (myEmotionGroupData.getGroupId().equals(next.getGroupId()) && e.a(next.getGroupId())) {
                        u uVar = new u(this.a, (byte) 0);
                        uVar.a = next.getGroupId();
                        uVar.b = next.getGroupName();
                        com.baidu.tbadk.editortool.ac.a();
                        uVar.d = com.baidu.tbadk.editortool.ac.c(uVar.a, "list.png");
                        linkedList.add(uVar);
                        break;
                    }
                }
            }
        }
        a.clear();
        a2.clear();
        return linkedList;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(List<u> list) {
        List<u> list2 = list;
        super.a((v) list2);
        if (list2 == null) {
            list2 = new LinkedList<>();
        }
        this.a.a = list2;
        this.a.a(false);
        this.a.hideProgressBar();
        this.a.a();
    }

    private v(EmotionManageActivity emotionManageActivity) {
        this.a = emotionManageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ v(EmotionManageActivity emotionManageActivity, byte b) {
        this(emotionManageActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
        this.a.showProgressBar();
    }
}
