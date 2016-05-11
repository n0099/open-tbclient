package com.baidu.tieba.frs;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import tbclient.FrsPage.FrsPageResIdl;
/* loaded from: classes.dex */
class bb extends BdAsyncTask<Void, Void, Void> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.util.x.a(com.baidu.tieba.tbadkCore.m.WIRE, FrsPageResIdl.class);
        return null;
    }
}
