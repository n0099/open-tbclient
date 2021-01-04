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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a jQn;
    private final Map<String, List<bz>> jQm = new HashMap();
    private b jQo = cPl();

    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0749a {
        public n eWF;
        public ViewGroup jQp;
        public List<View> jQq;
        public List<View> jQr;
        public ImageView jQs;
        public ImageView jQt;
        public TextView jQu;
        public TextView jQv;
        public FrameLayout jQw;
        public Button jQx;
    }

    /* loaded from: classes.dex */
    public interface b {
        View a(Activity activity, String str, View view, c cVar);

        void a(Activity activity, String str, d dVar);

        void a(C0749a c0749a);

        void a(C0749a c0749a, e eVar);

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
        void a(String str, n nVar);

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

    private b cPl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, b.class);
        if (runTask != null) {
            return (b) runTask.getData();
        }
        return null;
    }

    private a() {
    }

    public static a cPm() {
        if (jQn == null) {
            synchronized (a.class) {
                if (jQn == null) {
                    jQn = new a();
                }
            }
        }
        return jQn;
    }

    public View g(Activity activity, String str) {
        if (this.jQo != null) {
            return this.jQo.g(activity, str);
        }
        return null;
    }

    public boolean isAdReady(String str) {
        return this.jQo != null && this.jQo.isAdReady(str);
    }

    public View a(Activity activity, String str, View view, c cVar) {
        if (this.jQo != null) {
            return this.jQo.a(activity, str, view, cVar);
        }
        return null;
    }

    public void a(Activity activity, String str, d dVar) {
        if (this.jQo != null) {
            this.jQo.a(activity, str, dVar);
        }
    }

    public void destroyAd(String str) {
        if (this.jQo != null) {
            this.jQo.destroyAd(str);
        }
    }

    public void b(Activity activity, String str, d dVar) {
        if (this.jQo != null) {
            this.jQo.b(activity, str, dVar);
        }
    }

    public void a(C0749a c0749a, e eVar) {
        if (this.jQo != null) {
            this.jQo.a(c0749a, eVar);
        }
    }

    public void a(C0749a c0749a) {
        if (this.jQo != null) {
            this.jQo.a(c0749a);
        }
    }

    public int cPn() {
        return com.baidu.tbadk.coreExtra.data.e.bzF();
    }

    public int cPo() {
        return com.baidu.tbadk.coreExtra.data.e.bzG();
    }

    @Nullable
    public List<bz> LN(String str) {
        return this.jQm.get(str);
    }

    public void A(String str, Object obj) {
        List<bz> list = this.jQm.get(str);
        if (list != null && list.size() > 0) {
            for (bz bzVar : list) {
                if (bzVar != null && bzVar.eWF != null && bzVar.eWF.dON() == obj) {
                    list.remove(bzVar);
                    return;
                }
            }
        }
    }

    public void c(String str, bz bzVar) {
        List<bz> list = this.jQm.get(str);
        if (list == null) {
            list = new LinkedList<>();
            this.jQm.put(str, list);
        }
        list.add(bzVar);
    }
}
