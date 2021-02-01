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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class a {
    private static a jSE;
    private final Map<String, List<cb>> jSD = new HashMap();
    private b jSF = cNi();

    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0742a {
        public n eUi;
        public ViewGroup jSJ;
        public List<View> jSK;
        public List<View> jSL;
        public ImageView jSM;
        public ImageView jSN;
        public TextView jSO;
        public TextView jSP;
        public FrameLayout jSQ;
        public Button jSR;
    }

    /* loaded from: classes.dex */
    public interface b {
        void Ls(String str);

        View a(Activity activity, String str, View view, c cVar);

        void a(Activity activity, String str, d dVar);

        void a(C0742a c0742a);

        void a(C0742a c0742a, e eVar);

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

    private b cNi() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, b.class);
        if (runTask != null) {
            return (b) runTask.getData();
        }
        return null;
    }

    private a() {
    }

    public static a cNj() {
        if (jSE == null) {
            synchronized (a.class) {
                if (jSE == null) {
                    jSE = new a();
                }
            }
        }
        return jSE;
    }

    public View g(Activity activity, String str) {
        if (this.jSF != null) {
            return this.jSF.g(activity, str);
        }
        return null;
    }

    public boolean isAdReady(String str) {
        return this.jSF != null && this.jSF.isAdReady(str);
    }

    public View a(Activity activity, String str, View view, c cVar) {
        if (this.jSF != null) {
            return this.jSF.a(activity, str, view, cVar);
        }
        return null;
    }

    public void a(Activity activity, String str, d dVar) {
        if (this.jSF != null) {
            this.jSF.a(activity, str, dVar);
        }
    }

    public void destroyAd(String str) {
        if (this.jSF != null) {
            this.jSF.destroyAd(str);
        }
    }

    public void b(Activity activity, String str, d dVar) {
        if (this.jSF != null) {
            this.jSF.b(activity, str, dVar);
        }
    }

    public void Lp(String str) {
        if (this.jSF != null) {
            this.jSF.Ls(str);
        }
    }

    public void a(C0742a c0742a, e eVar) {
        if (this.jSF != null) {
            this.jSF.a(c0742a, eVar);
        }
    }

    public void a(C0742a c0742a) {
        if (this.jSF != null) {
            this.jSF.a(c0742a);
        }
    }

    public int cNk() {
        return com.baidu.tbadk.coreExtra.data.e.bwf();
    }

    public int cNl() {
        return com.baidu.tbadk.coreExtra.data.e.bwg();
    }

    @Nullable
    public List<cb> Lq(String str) {
        List<cb> list = this.jSD.get(str);
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            String Lr = Lr(str);
            for (cb cbVar : list) {
                if (cbVar.eUi != null && !cbVar.eUi.isValid()) {
                    arrayList.add(cbVar);
                    TiebaStatic.log(new ar("c14088").ap("obj_source", 6).dR("obj_type", Lr).ap("obj_locate", 1));
                }
            }
            list.removeAll(arrayList);
        }
        return list;
    }

    private String Lr(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case 571407466:
                if (str.equals("6051001643-679358748")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1009027920:
                if (str.equals("6051001642-2027944992")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1574990713:
                if (str.equals("6051001641-1251655838")) {
                    c2 = 0;
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

    public void y(String str, Object obj) {
        List<cb> list = this.jSD.get(str);
        if (list != null && list.size() > 0) {
            for (cb cbVar : list) {
                if (cbVar != null && cbVar.eUi != null && cbVar.eUi.dNh() == obj) {
                    list.remove(cbVar);
                    return;
                }
            }
        }
    }

    public void e(String str, cb cbVar) {
        List<cb> list = this.jSD.get(str);
        if (list == null) {
            list = new LinkedList<>();
            this.jSD.put(str, list);
        }
        list.add(cbVar);
    }

    public void b(Activity activity, String str, final String str2, final String str3) {
        if (com.baidu.tbadk.a.d.biV()) {
            List<cb> Lq = Lq(str);
            if (Lq == null || Lq.size() < 2) {
                b(activity, "6051001642-2027944992", new d() { // from class: com.baidu.tieba.h.a.1
                    @Override // com.baidu.tieba.h.a.d
                    public void bb(String str4, int i) {
                        ar.Bd(str2).ap("obj_source", 6).dR("obj_type", str3).ap("obj_locate", 0).bsO();
                    }

                    @Override // com.baidu.tieba.h.a.d
                    public void onError(String str4) {
                        ar.Bd(str2).ap("obj_source", 6).dR("obj_type", str3).ap("obj_locate", 1).bsO();
                    }
                });
            }
        }
    }
}
