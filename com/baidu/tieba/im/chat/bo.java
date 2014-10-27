package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ bm aOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.aOs = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.z.Pb().av(TbadkApplication.getCurrentAccount(), this.aOs.getGroupId()));
    }
}
