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
    private static ab aHT;
    private static Context mContext;

    private ab() {
    }

    public static synchronized ab Hu() {
        ab abVar;
        synchronized (ab.class) {
            if (aHT == null) {
                aHT = new ab();
                mContext = TbadkApplication.m251getInst().getContext();
            }
            abVar = aHT;
        }
        return abVar;
    }

    public boolean b(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hf().fm(gameInfoData.getGameId());
    }

    public File fo(String str) {
        return c.Hf().fn(str);
    }

    public boolean c(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hf().fj(gameInfoData.getGameId());
    }

    public float d(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return -1.0f;
        }
        return c.Hf().fk(gameInfoData.getGameId());
    }

    public boolean e(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hf().fl(gameInfoData.getGameId());
    }

    public void f(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            c.Hf().af(gameInfoData.getPackageLink(), gameInfoData.getGameId());
        }
    }

    public void g(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            if (TextUtils.isEmpty(gameInfoData.getPackageLink())) {
                UtilHelper.showToast(mContext, com.baidu.tieba.y.donwload_url_error);
                return;
            }
            TiebaStatic.eventStat(mContext, "dl_game", "click", 1, "dev_id", gameInfoData.getGameId(), "ref_id", gameInfoData.getRefId());
            c.Hf().d(gameInfoData.getGameId(), gameInfoData.getPackageLink(), gameInfoData.getGameName(), gameInfoData.getRefId());
        }
    }

    public void h(GameInfoData gameInfoData) {
        if (gameInfoData != null && !TextUtils.isEmpty(gameInfoData.getPackageName()) && !TextUtils.isEmpty(gameInfoData.getLauncherActivity())) {
            UtilHelper.startApk(mContext, gameInfoData.getPackageName(), gameInfoData.getLauncherActivity());
        }
    }

    public void i(GameInfoData gameInfoData) {
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

    public boolean j(GameInfoData gameInfoData) {
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

    public boolean k(GameInfoData gameInfoData) {
        if (gameInfoData == null || gameInfoData.getPackageName() == null) {
            return false;
        }
        int installApkVersion = UtilHelper.getInstallApkVersion(mContext, gameInfoData.getPackageName());
        return installApkVersion > 0 && installApkVersion < com.baidu.adp.lib.g.c.f(gameInfoData.getVersion(), 0);
    }

    public boolean l(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return false;
        }
        return c.Hf().ag(gameInfoData.getGameId(), gameInfoData.getGameName());
    }

    public long m(GameInfoData gameInfoData) {
        if (gameInfoData == null) {
            return -1L;
        }
        return c.Hf().ah(gameInfoData.getGameId(), gameInfoData.getGameName());
    }

    public void n(GameInfoData gameInfoData) {
        if (gameInfoData != null) {
            bg.HK().q(gameInfoData);
        }
    }

    public GameInfoData fr(String str) {
        return bg.HK().fv(str);
    }

    public List<GameInfoData> Hv() {
        List<GameInfoData> HL = bg.HK().HL();
        if (HL == null) {
            return null;
        }
        Iterator<GameInfoData> it = HL.iterator();
        while (it.hasNext()) {
            GameInfoData next = it.next();
            if (next.getGameType() == 1) {
                if (j(next)) {
                    next.setOrderTime(next.getInstallTime());
                } else if (b(next)) {
                    next.setOrderTime(next.getDownloadTime());
                } else {
                    it.remove();
                    bg.HK().fu(next.getGameId());
                }
            } else {
                next.setOrderTime(next.getInstallTime());
            }
        }
        Collections.sort(HL, new ac(this));
        return HL;
    }

    public int o(GameInfoData gameInfoData) {
        if (j(gameInfoData)) {
            if (k(gameInfoData)) {
                return 7;
            }
            return 6;
        } else if (b(gameInfoData)) {
            return 5;
        } else {
            if (e(gameInfoData)) {
                return 3;
            }
            if (c(gameInfoData)) {
                return 2;
            }
            if (!l(gameInfoData)) {
                return 1;
            }
            return 4;
        }
    }

    public List<GameInfoData> G(List<GameInfoData> list) {
        List<GameInfoData> Hv = Hv();
        if (list == null) {
            return Hv;
        }
        for (GameInfoData gameInfoData : list) {
            if (j(gameInfoData) || b(gameInfoData)) {
                if (!a(Hv, gameInfoData)) {
                    n(gameInfoData);
                    Hv.add(gameInfoData);
                }
            }
        }
        return Hv;
    }

    private boolean a(List<GameInfoData> list, GameInfoData gameInfoData) {
        if (list == null || gameInfoData == null) {
            return false;
        }
        for (GameInfoData gameInfoData2 : list) {
            if (!TextUtils.isEmpty(gameInfoData.getGameId()) && gameInfoData.getGameId().equals(gameInfoData2.getGameId())) {
                bg.HK().ai(gameInfoData.getGameId(), gameInfoData.getGameLink());
                return true;
            }
        }
        return false;
    }
}
