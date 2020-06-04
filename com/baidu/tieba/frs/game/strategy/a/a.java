package com.baidu.tieba.frs.game.strategy.a;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes9.dex */
public class a {
    private InterfaceC0613a hAb;
    private l<byte[]> hjb;

    /* renamed from: com.baidu.tieba.frs.game.strategy.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0613a {
        void b(List<e> list, List<o> list2, boolean z);
    }

    public a() {
        this.hjb = null;
        this.hjb = BdCacheService.kf().b("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void EK(final String str) {
        if (this.hjb != null && str != null) {
            ad.a(new ac<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bYP */
                public GameForumGuideTabResIdl doInBackground() {
                    Wire wire = new Wire(new Class[0]);
                    byte[] bArr = (byte[]) a.this.hjb.get(TbadkCoreApplication.getCurrentAccount() + str);
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
            }, new com.baidu.tbadk.util.l<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(GameForumGuideTabResIdl gameForumGuideTabResIdl) {
                    if (gameForumGuideTabResIdl != null) {
                        List<e> cs = com.baidu.tieba.frs.game.strategy.message.a.cs(gameForumGuideTabResIdl.data.sub_tab_list);
                        List<o> ct = com.baidu.tieba.frs.game.strategy.message.a.ct(gameForumGuideTabResIdl.data.thread_list);
                        boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
                        if (a.this.hAb != null) {
                            a.this.hAb.b(cs, ct, z);
                        }
                    }
                }
            });
        }
    }

    public void b(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.hjb.set(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
                return;
            }
            this.hjb.asyncSet(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
        }
    }

    public void a(InterfaceC0613a interfaceC0613a) {
        this.hAb = interfaceC0613a;
    }
}
