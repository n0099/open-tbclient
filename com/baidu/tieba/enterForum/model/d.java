package com.baidu.tieba.enterForum.model;

import com.baidu.tieba.tbadkCore.u;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Comparator<u> {
    final /* synthetic */ EnterForumModel bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EnterForumModel enterForumModel) {
        this.bHG = enterForumModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(u uVar, u uVar2) {
        if (uVar == null || uVar2 == null) {
            return 0;
        }
        return uVar2.getLevel() - uVar.getLevel();
    }
}
