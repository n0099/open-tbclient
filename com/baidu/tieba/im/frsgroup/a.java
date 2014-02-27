package com.baidu.tieba.im.frsgroup;
/* loaded from: classes.dex */
final class a implements com.baidu.adp.framework.task.a<com.baidu.tieba.a.a> {
    @Override // com.baidu.adp.framework.task.a
    public final com.baidu.adp.framework.message.b<com.baidu.tieba.a.a> a(com.baidu.adp.framework.message.a<com.baidu.tieba.a.a> aVar) {
        if (aVar != null && aVar.a() != null) {
            aVar.a().d().setClass(aVar.a().c(), FrsGroupActivity.class);
            aVar.a().e();
        }
        return null;
    }
}
