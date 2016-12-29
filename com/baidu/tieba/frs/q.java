package com.baidu.tieba.frs;

import com.baidu.tbadk.util.e;
/* loaded from: classes.dex */
class q implements e<Boolean> {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.e
    /* renamed from: e */
    public void F(Boolean bool) {
        if (bool != null && this.bzl.byg != null) {
            this.bzl.byg.XF();
        }
    }
}
