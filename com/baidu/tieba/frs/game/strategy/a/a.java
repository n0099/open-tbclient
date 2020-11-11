package com.baidu.tieba.frs.game.strategy.a;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes22.dex */
public class a {
    private l<byte[]> iCL;
    private InterfaceC0727a iVM;

    /* renamed from: com.baidu.tieba.frs.game.strategy.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC0727a {
        void b(List<e> list, List<q> list2, boolean z);
    }

    public a() {
        this.iCL = null;
        this.iCL = BdCacheService.lZ().b("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void KA(final String str) {
        if (this.iCL != null && str != null) {
            ae.a(new ad<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: cCC */
                public GameForumGuideTabResIdl doInBackground() {
                    Wire wire = new Wire(new Class[0]);
                    byte[] bArr = (byte[]) a.this.iCL.get(TbadkCoreApplication.getCurrentAccount() + str);
                    if (bArr == null || bArr.length == 0) {
                        return null;
                    }
                    try {
                        return (GameForumGuideTabResIdl) wire.parseFrom(bArr, GameForumGuideTabResIdl.class);
                    } catch (IOException e) {
                        BdLog.e(e);
                        return null;
                    }
                }
            }, new m<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(GameForumGuideTabResIdl gameForumGuideTabResIdl) {
                    if (gameForumGuideTabResIdl != null) {
                        List<e> dj = com.baidu.tieba.frs.game.strategy.message.a.dj(gameForumGuideTabResIdl.data.sub_tab_list);
                        List<q> dk = com.baidu.tieba.frs.game.strategy.message.a.dk(gameForumGuideTabResIdl.data.thread_list);
                        boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
                        if (a.this.iVM != null) {
                            a.this.iVM.b(dj, dk, z);
                        }
                    }
                }
            });
        }
    }

    public void b(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.iCL.set(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
                return;
            }
            this.iCL.asyncSet(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
        }
    }

    public void a(InterfaceC0727a interfaceC0727a) {
        this.iVM = interfaceC0727a;
    }
}
