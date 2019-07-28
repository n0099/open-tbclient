package com.baidu.tieba.frs.game.strategy.a;

import com.baidu.adp.lib.cache.BdCacheService;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.frs.game.strategy.tab.e;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.util.List;
import tbclient.GameForumGuideTab.GameForumGuideTabResIdl;
/* loaded from: classes4.dex */
public class a {
    private l<byte[]> dsK;
    private InterfaceC0311a fFi;

    /* renamed from: com.baidu.tieba.frs.game.strategy.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0311a {
        void e(List<e> list, List<m> list2, boolean z);
    }

    public a() {
        this.dsK = null;
        this.dsK = BdCacheService.hA().b("tb.frs.game.strategy.protobuf", BdCacheService.CacheStorage.SQLite_CACHE_All_IN_ONE_TABLE, BdCacheService.CacheEvictPolicy.LRU_ON_INSERT, 20);
    }

    public void xg(final String str) {
        if (this.dsK != null && str != null) {
            aa.a(new z<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: bpw */
                public GameForumGuideTabResIdl doInBackground() {
                    Wire wire = new Wire(new Class[0]);
                    byte[] bArr = (byte[]) a.this.dsK.get(TbadkCoreApplication.getCurrentAccount() + str);
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
            }, new k<GameForumGuideTabResIdl>() { // from class: com.baidu.tieba.frs.game.strategy.a.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(GameForumGuideTabResIdl gameForumGuideTabResIdl) {
                    if (gameForumGuideTabResIdl != null) {
                        List<e> ce = com.baidu.tieba.frs.game.strategy.message.a.ce(gameForumGuideTabResIdl.data.sub_tab_list);
                        List<m> cf = com.baidu.tieba.frs.game.strategy.message.a.cf(gameForumGuideTabResIdl.data.thread_list);
                        boolean z = gameForumGuideTabResIdl.data.has_more.intValue() == 1;
                        if (a.this.fFi != null) {
                            a.this.fFi.e(ce, cf, z);
                        }
                    }
                }
            });
        }
    }

    public void b(String str, byte[] bArr, boolean z) {
        if (str != null && str.length() > 0) {
            if (z) {
                this.dsK.a(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
                return;
            }
            this.dsK.b(TbadkCoreApplication.getCurrentAccount() + str, bArr, 604800000L);
        }
    }

    public void a(InterfaceC0311a interfaceC0311a) {
        this.fFi = interfaceC0311a;
    }
}
