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
/* loaded from: classes21.dex */
public class a {
    private l<byte[]> hVr;
    private InterfaceC0679a ioA;

    /* renamed from: com.baidu.tieba.frs.game.strategy.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC0679a {
        void b(List<e> list, List<q> list2, boolean z);
    }

    public a() {
        this.hVr = null;
        this.hVr = BdCacheService.lY().b("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void IX(final String str) {
        if (this.hVr != null && str != null) {
            ae.a(new ad<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: ctx */
                public GameForumGuideTabResIdl doInBackground() {
                    Wire wire = new Wire(new Class[0]);
                    byte[] bArr = (byte[]) a.this.hVr.get(TbadkCoreApplication.getCurrentAccount() + str);
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
                        List<e> cP = com.baidu.tieba.frs.game.strategy.message.a.cP(gameForumGuideTabResIdl.data.sub_tab_list);
                        List<q> cQ = com.baidu.tieba.frs.game.strategy.message.a.cQ(gameForumGuideTabResIdl.data.thread_list);
                        boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
                        if (a.this.ioA != null) {
                            a.this.ioA.b(cP, cQ, z);
                        }
                    }
                }
            });
        }
    }

    public void b(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.hVr.set(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
                return;
            }
            this.hVr.asyncSet(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
        }
    }

    public void a(InterfaceC0679a interfaceC0679a) {
        this.ioA = interfaceC0679a;
    }
}
