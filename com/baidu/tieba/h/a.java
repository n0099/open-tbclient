package com.baidu.tieba.h;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a jLH;
    private final Map<String, List<bz>> jLG = new HashMap();
    private b jLI = cLu();

    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0741a {
        public n eRU;
        public ViewGroup jLJ;
        public List<View> jLK;
        public List<View> jLL;
        public ImageView jLM;
        public ImageView jLN;
        public TextView jLO;
        public TextView jLP;
        public FrameLayout jLQ;
        public Button jLR;
    }

    /* loaded from: classes.dex */
    public interface b {
        void KF(String str);

        View a(Activity activity, String str, View view, c cVar);

        void a(Activity activity, String str, d dVar);

        void a(C0741a c0741a);

        void a(C0741a c0741a, e eVar);

        void b(Activity activity, String str, d dVar);

        void destroyAd(String str);

        View g(Activity activity, String str);

        boolean isAdReady(String str);
    }

    /* loaded from: classes.dex */
    public interface c extends e {
        void onAdClose(String str);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes.dex */
    public interface d {
        void bb(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onAdClicked(String str);

        void onAdError(String str, int i, String str2);

        void onAdShow(String str);
    }

    /* loaded from: classes.dex */
    public static abstract class f implements c {
        @Override // com.baidu.tieba.h.a.e
        public void onAdClicked(String str) {
        }

        @Override // com.baidu.tieba.h.a.e
        public void onAdShow(String str) {
        }

        @Override // com.baidu.tieba.h.a.e
        public void onAdError(String str, int i, String str2) {
        }

        @Override // com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
        }

        @Override // com.baidu.tieba.h.a.c
        public void onRewardedVideo(String str) {
        }
    }

    private b cLu() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, b.class);
        if (runTask != null) {
            return (b) runTask.getData();
        }
        return null;
    }

    private a() {
    }

    public static a cLv() {
        if (jLH == null) {
            synchronized (a.class) {
                if (jLH == null) {
                    jLH = new a();
                }
            }
        }
        return jLH;
    }

    public View g(Activity activity, String str) {
        if (this.jLI != null) {
            return this.jLI.g(activity, str);
        }
        return null;
    }

    public boolean isAdReady(String str) {
        return this.jLI != null && this.jLI.isAdReady(str);
    }

    public View a(Activity activity, String str, View view, c cVar) {
        if (this.jLI != null) {
            return this.jLI.a(activity, str, view, cVar);
        }
        return null;
    }

    public void a(Activity activity, String str, d dVar) {
        if (this.jLI != null) {
            this.jLI.a(activity, str, dVar);
        }
    }

    public void destroyAd(String str) {
        if (this.jLI != null) {
            this.jLI.destroyAd(str);
        }
    }

    public void b(Activity activity, String str, d dVar) {
        if (this.jLI != null) {
            this.jLI.b(activity, str, dVar);
        }
    }

    public void KC(String str) {
        if (this.jLI != null) {
            this.jLI.KF(str);
        }
    }

    public void a(C0741a c0741a, e eVar) {
        if (this.jLI != null) {
            this.jLI.a(c0741a, eVar);
        }
    }

    public void a(C0741a c0741a) {
        if (this.jLI != null) {
            this.jLI.a(c0741a);
        }
    }

    public int cLw() {
        return com.baidu.tbadk.coreExtra.data.e.bvM();
    }

    public int cLx() {
        return com.baidu.tbadk.coreExtra.data.e.bvN();
    }

    @Nullable
    public List<bz> KD(String str) {
        List<bz> list = this.jLG.get(str);
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            String KE = KE(str);
            for (bz bzVar : list) {
                if (bzVar.eRU != null && !bzVar.eRU.isValid()) {
                    arrayList.add(bzVar);
                    TiebaStatic.log(new aq("c14088").an("obj_source", 6).dW("obj_type", KE).an("obj_locate", 1));
                }
            }
            list.removeAll(arrayList);
        }
        return list;
    }

    private String KE(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1391279521:
                if (str.equals("6051001536-500920287")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1052231573:
                if (str.equals("6051001537-901554884")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1426113805:
                if (str.equals("6051001535-87847998")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return PageStayDurationConstants.PageName.PB;
            case 1:
                return PageStayDurationConstants.PageName.FRS;
            case 2:
                return PageStayDurationConstants.PageName.BIGIMAGE;
            default:
                return "";
        }
    }

    public void A(String str, Object obj) {
        List<bz> list = this.jLG.get(str);
        if (list != null && list.size() > 0) {
            for (bz bzVar : list) {
                if (bzVar != null && bzVar.eRU != null && bzVar.eRU.dKW() == obj) {
                    list.remove(bzVar);
                    return;
                }
            }
        }
    }

    public void c(String str, bz bzVar) {
        List<bz> list = this.jLG.get(str);
        if (list == null) {
            list = new LinkedList<>();
            this.jLG.put(str, list);
        }
        list.add(bzVar);
    }
}
