package com.baidu.tieba.addresslist.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ long ayf;
    final /* synthetic */ u ayk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar, long j) {
        this.ayk = uVar;
        this.ayf = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: EX */
    public Void doInBackground() {
        if (0 != this.ayf) {
            ba.Fd().I(this.ayf);
            com.baidu.tieba.im.db.n.Qm().gt(String.valueOf(this.ayf));
        }
        return null;
    }
}
