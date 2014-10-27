package com.baidu.tieba.game;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.game.GameInfoData;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class ab {
    private static ab aHJ;
    private static Context mContext;

    private ab() {
    }

    public static synchronized ab Hs() {
        ab abVar;
        synchronized (ab.class) {
            if (aHJ == null) {
                aHJ = new ab();
                mContext = TbadkApplication.m251getInst().getContext();
            }
            abVar = aHJ;
        }
        return abVar;
    }

    public boolean a(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hd().fm(gameInfoData.getGameId());
    }

    public File fo(String str) {
        return c.Hd().fn(str);
    }

    public boolean b(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hd().fj(gameInfoData.getGameId());
    }

    public float c(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return -1.0f;
        }
        return c.Hd().fk(gameInfoData.getGameId());
    }

    public boolean d(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hd().fl(gameInfoData.getGameId());
    }

    public void e(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            c.Hd().af(gameInfoData.getPackageLink(), gameInfoData.getGameId());
        }
    }

    public void f(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            if (TextUtils.isEmpty(gameInfoData.getPackageLink())) {
                UtilHelper.showToast(mContext, com.baidu.tieba.y.donwload_url_error);
                return;
            }
            TiebaStatic.eventStat(mContext, "dl_game", "click", 1, "dev_id", gameInfoData.getGameId(), "ref_id", gameInfoData.getRefId());
            c.Hd().d(gameInfoData.getGameId(), gameInfoData.getPackageLink(), gameInfoData.getGameName(), gameInfoData.getRefId());
        }
    }

    public void g(GameInfoData gameInfoData) {
        if (gameInfoData != null && !TextUtils.isEmpty(gameInfoData.getPackageName()) && !TextUtils.isEmpty(gameInfoData.getLauncherActivity())) {
            UtilHelper.startApk(mContext, gameInfoData.getPackageName(), gameInfoData.getLauncherActivity());
        }
    }

    public void h(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            String gameId = gameInfoData.getGameId();
            if (!TextUtils.isEmpty(gameId)) {
                fp(gameId);
            }
        }
    }

    public void fp(String str) {
        File br;
        if (!TextUtils.isEmpty(str) && (br = com.baidu.tbadk.core.util.s.br(String.valueOf(str) + ".apk")) != null) {
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(br), "application/vnd.android.package-archive");
            mContext.startActivity(intent);
        }
    }

    public boolean i(GameInfoData gameInfoData) {
        if (gameInfoData == null || gameInfoData.getPackageName() == null) {
            return false;
        }
        return UtilHelper.isInstallApk(mContext, gameInfoData.getPackageName());
    }

    public boolean fq(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return UtilHelper.isInstallApk(mContext, str);
    }

    public boolean j(GameInfoData gameInfoData) {
        if (gameInfoData == null || gameInfoData.getPackageName() == null) {
            return false;
        }
        int installApkVersion = UtilHelper.getInstallApkVersion(mContext, gameInfoData.getPackageName());
        return installApkVersion > 0 && installApkVersion < com.baidu.adp.lib.g.c.f(gameInfoData.getVersion(), 0);
    }

    public boolean k(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hd().ag(gameInfoData.getGameId(), gameInfoData.getGameName());
    }

    public long l(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return -1L;
        }
        return c.Hd().ah(gameInfoData.getGameId(), gameInfoData.getGameName());
    }

    public void m(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            bf.HG().p(gameInfoData);
        }
    }

    public GameInfoData fr(String str) {
        return bf.HG().fv(str);
    }

    public List<GameInfoData> Ht() {
        List<GameInfoData> HH = bf.HG().HH();
        if (HH == null) {
            return null;
        }
        Iterator<GameInfoData> it = HH.iterator();
        while (it.hasNext()) {
            GameInfoData next = it.next();
            if (next.getGameType() == 1) {
                if (i(next)) {
                    next.setOrderTime(next.getInstallTime());
                } else if (a(next)) {
                    next.setOrderTime(next.getDownloadTime());
                } else {
                    it.remove();
                    bf.HG().fu(next.getGameId());
                }
            } else {
                next.setOrderTime(next.getInstallTime());
            }
        }
        Collections.sort(HH, new ac(this));
        return HH;
    }

    public int n(GameInfoData gameInfoData) {
        if (i(gameInfoData)) {
            if (j(gameInfoData)) {
                return 7;
            }
            return 6;
        } else if (a(gameInfoData)) {
            return 5;
        } else {
            if (d(gameInfoData)) {
                return 3;
            }
            if (b(gameInfoData)) {
                return 2;
            }
            if (!k(gameInfoData)) {
                return 1;
            }
            return 4;
        }
    }

    public List<GameInfoData> G(List<GameInfoData> list) {
        List<GameInfoData> Ht = Ht();
        if (list == null) {
            return Ht;
        }
        for (GameInfoData gameInfoData : list) {
            if (i(gameInfoData) || a(gameInfoData)) {
                if (!a(Ht, gameInfoData)) {
                    m(gameInfoData);
                    Ht.add(gameInfoData);
                }
            }
        }
        return Ht;
    }

    private boolean a(List<GameInfoData> list, GameInfoData gameInfoData) {
        if (list == null || gameInfoData == null) {
            return false;
        }
        for (GameInfoData gameInfoData2 : list) {
            if (!TextUtils.isEmpty(gameInfoData.getGameId()) && gameInfoData.getGameId().equals(gameInfoData2.getGameId())) {
                bf.HG().ai(gameInfoData.getGameId(), gameInfoData.getGameLink());
                return true;
            }
        }
        return false;
    }
}
