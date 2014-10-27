package com.baidu.tieba.game.a;

import android.view.View;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tieba.game.GameListBaseItem;
import com.baidu.tieba.game.ab;
import com.baidu.tieba.game.an;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static int aJX = 1;
    private static a aJY;

    public static a Ij() {
        if (aJY == null) {
            synchronized (a.class) {
                if (aJY == null) {
                    aJY = new a();
                }
            }
        }
        return aJY;
    }

    public void K(List<com.baidu.tieba.game.a> list) {
        int i;
        if (list != null && !list.isEmpty()) {
            int i2 = 0;
            int size = list.size();
            while (i2 < size) {
                com.baidu.tieba.game.a aVar = list.get(i2);
                if (i2 >= 5 || aVar == null || StringUtils.isNull(aVar.Hc())) {
                    list.remove(i2);
                    i2--;
                    i = size - 1;
                } else {
                    i = size;
                }
                i2++;
                size = i;
            }
        }
    }

    public void d(an anVar) {
        if (anVar != null) {
            K(anVar.getAdLists());
            L(anVar.getGameList());
        }
    }

    private void L(List<GameInfoData> list) {
        if (list != null && !list.isEmpty()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                GameInfoData gameInfoData = list.get(size);
                if (gameInfoData == null || StringUtils.isNull(gameInfoData.getGameId()) || StringUtils.isNull(gameInfoData.getGameName()) || gameInfoData.getMark() == aJX || ab.Hs().fq(gameInfoData.getPackageName())) {
                    list.remove(gameInfoData);
                }
            }
        }
    }

    public void M(List<GameInfoData> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<GameInfoData> it = list.iterator();
            while (it.hasNext()) {
                GameInfoData next = it.next();
                if (next == null || StringUtils.isNull(next.getGameId()) || StringUtils.isNull(next.getGameName()) || next.getMark() == aJX) {
                    it.remove();
                }
            }
        }
    }

    public void a(byte[] bArr, String str) {
        t<byte[]> bc;
        if (str != null && bArr != null && bArr.length != 0 && (bc = com.baidu.tbadk.core.a.a.kS().bc("tb.game_center_list")) != null) {
            bc.b(str, bArr);
        }
    }

    public void a(View view, GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            com.baidu.tbadk.core.sharedPref.b.lk().putBoolean(gameInfoData.getGameId(), true);
            if (gameInfoData.getMark() == 2) {
                gameInfoData.setMark(0);
                if (view instanceof GameListBaseItem) {
                    ((GameListBaseItem) view).setData(gameInfoData);
                }
            }
        }
    }
}
