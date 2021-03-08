package com.baidu.tieba.h;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static a jUA;
    private InterfaceC0749a jUB = cNv();

    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0749a {
        void Lz(String str);

        void a(Activity activity, @NonNull Object obj, c cVar, ViewGroup viewGroup, List<View> list, List<View> list2);

        void a(Activity activity, String str, ViewGroup viewGroup, c cVar);

        void a(Activity activity, String str, b bVar);

        void a(Application application, e eVar);

        void b(Activity activity, String str, b bVar);

        void destroyAd(String str);

        ViewGroup g(Activity activity, String str);

        Object h(@NonNull Activity activity, @NonNull String str);

        boolean isAdReady(String str);
    }

    /* loaded from: classes.dex */
    public interface b {
        void aE(String str, int i);

        void onError(String str);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onAdClicked(String str);

        void onAdClose(String str);

        void onAdError(String str);

        void onAdShow(String str);

        void onRewardedVideo(String str);
    }

    /* loaded from: classes.dex */
    public interface e {
        void cNA();
    }

    /* loaded from: classes.dex */
    public static abstract class d implements c {
        @Override // com.baidu.tieba.h.a.c
        public void onAdClicked(String str) {
        }

        @Override // com.baidu.tieba.h.a.c
        public void onAdShow(String str) {
        }

        @Override // com.baidu.tieba.h.a.c
        public void onAdError(String str) {
        }

        @Override // com.baidu.tieba.h.a.c
        public void onAdClose(String str) {
        }

        @Override // com.baidu.tieba.h.a.c
        public void onRewardedVideo(String str) {
        }
    }

    private InterfaceC0749a cNv() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, InterfaceC0749a.class);
        if (runTask != null) {
            return (InterfaceC0749a) runTask.getData();
        }
        return null;
    }

    private a() {
    }

    public void cNw() {
        if (this.jUB != null) {
            this.jUB.a(TbadkCoreApplication.getInst(), null);
        }
    }

    public static a cNx() {
        if (jUA == null) {
            synchronized (a.class) {
                if (jUA == null) {
                    jUA = new a();
                }
            }
        }
        return jUA;
    }

    public ViewGroup g(Activity activity, String str) {
        if (this.jUB != null) {
            return this.jUB.g(activity, str);
        }
        return null;
    }

    public boolean isAdReady(String str) {
        return this.jUB != null && this.jUB.isAdReady(str);
    }

    public void a(Activity activity, String str, ViewGroup viewGroup, c cVar) {
        if (this.jUB != null) {
            this.jUB.a(activity, str, viewGroup, cVar);
        }
    }

    public void a(Activity activity, String str, b bVar) {
        if (this.jUB != null) {
            this.jUB.a(activity, str, bVar);
        }
    }

    public void destroyAd(String str) {
        if (this.jUB != null) {
            this.jUB.destroyAd(str);
        }
    }

    public void b(Activity activity, String str, b bVar) {
        if (this.jUB != null) {
            this.jUB.b(activity, str, bVar);
        }
    }

    public Object h(@NonNull Activity activity, @NonNull String str) {
        if (this.jUB != null) {
            return this.jUB.h(activity, str);
        }
        return null;
    }

    public void a(Activity activity, @NonNull Object obj, c cVar, ViewGroup viewGroup, List<View> list, List<View> list2) {
        if (this.jUB != null) {
            this.jUB.a(activity, obj, cVar, viewGroup, list, list2);
        }
    }

    public void Lz(String str) {
        if (this.jUB != null) {
            this.jUB.Lz(str);
        }
    }

    public int cNy() {
        return com.baidu.tbadk.coreExtra.data.e.bwi();
    }

    public int cNz() {
        return com.baidu.tbadk.coreExtra.data.e.bwj();
    }

    public boolean aq(Activity activity) {
        if (com.baidu.tbadk.a.d.biX() && this.jUB != null) {
            r0 = this.jUB.isAdReady("6051001773-1862514716");
            this.jUB.b(activity, "6051001773-1862514716", new b() { // from class: com.baidu.tieba.h.a.1
                @Override // com.baidu.tieba.h.a.b
                public void aE(String str, int i) {
                    ar.Bk("c14005").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.FRS).aq("obj_locate", 0).bsR();
                }

                @Override // com.baidu.tieba.h.a.b
                public void onError(String str) {
                    ar.Bk("c14005").aq("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.FRS).aq("obj_locate", 1).bsR();
                }
            });
        }
        return r0;
    }
}
