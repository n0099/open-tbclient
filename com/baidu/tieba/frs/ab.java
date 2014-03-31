package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.person.PersonInfoActivity;
/* loaded from: classes.dex */
final class ab implements com.baidu.adp.framework.task.a<com.baidu.tbadk.core.b.l> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<com.baidu.tbadk.core.b.l> aVar) {
        if (aVar != null && aVar.a() != null) {
            if (TbadkApplication.j().m(aVar.a().d().getStringExtra(PersonInfoActivity.TAG_NAME))) {
                aVar.a().d().putExtra("add_search", 0);
                aVar.a().d().setClass(aVar.a().c(), FrsImageActivity.class);
            } else {
                aVar.a().d().setClass(aVar.a().c(), FrsActivity.class);
            }
            aVar.a().f();
        }
        return null;
    }
}
