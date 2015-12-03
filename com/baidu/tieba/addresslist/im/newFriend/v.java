package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tbadk.util.m<Void> {
    private final /* synthetic */ long aIu;
    final /* synthetic */ u aIz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, long j) {
        this.aIz = uVar;
        this.aIu = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        if (0 != this.aIu) {
            aw.Hr().ai(this.aIu);
            com.baidu.tieba.im.db.l.Xr().ie(String.valueOf(this.aIu));
        }
        return null;
    }
}
