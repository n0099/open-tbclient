package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.tbadk.util.m<Void> {
    final /* synthetic */ x aIA;
    private final /* synthetic */ com.baidu.tieba.im.data.b aIs;
    private final /* synthetic */ long aIu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, long j, com.baidu.tieba.im.data.b bVar) {
        this.aIA = xVar;
        this.aIu = j;
        this.aIs = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        com.baidu.tieba.im.data.b ak;
        if (0 != this.aIu && (ak = aw.Hr().ak(this.aIu)) != null) {
            this.aIs.setContent(ak.getContent());
            this.aIs.setName(ak.getName());
            this.aIs.setPortrait(ak.getPortrait());
            aw.Hr().g(this.aIs);
        }
        return null;
    }
}
