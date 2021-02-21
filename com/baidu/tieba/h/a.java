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
    private static a jSS;
    private final Map<String, List<cb>> jSR = new HashMap();
    private b jST = cNp();

    /* renamed from: com.baidu.tieba.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0743a {
        public n eUi;
        public ViewGroup jSX;
        public List<View> jSY;
        public List<View> jSZ;
        public ImageView jTa;
        public ImageView jTb;
        public TextView jTc;
        public TextView jTd;
        public FrameLayout jTe;
        public Button jTf;
    }

    /* loaded from: classes.dex */
    public interface b {
        void Lt(String str);

        View a(Activity activity, String str, View view, c cVar);

        void a(Activity activity, String str, d dVar);

        void a(C0743a c0743a);

        void a(C0743a c0743a, e eVar);

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

    private b cNp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921525, b.class);
        if (runTask != null) {
            return (b) runTask.getData();
        }
        return null;
    }

    private a() {
    }

    public static a cNq() {
        if (jSS == null) {
            synchronized (a.class) {
                if (jSS == null) {
                    jSS = new a();
                }
            }
        }
        return jSS;
    }

    public View g(Activity activity, String str) {
        if (this.jST != null) {
            return this.jST.g(activity, str);
        }
        return null;
    }

    public boolean isAdReady(String str) {
        return this.jST != null && this.jST.isAdReady(str);
    }

    public View a(Activity activity, String str, View view, c cVar) {
        if (this.jST != null) {
            return this.jST.a(activity, str, view, cVar);
        }
        return null;
    }

    public void a(Activity activity, String str, d dVar) {
        if (this.jST != null) {
            this.jST.a(activity, str, dVar);
        }
    }

    public void destroyAd(String str) {
        if (this.jST != null) {
            this.jST.destroyAd(str);
        }
    }

    public void b(Activity activity, String str, d dVar) {
        if (this.jST != null) {
            this.jST.b(activity, str, dVar);
        }
    }

    public void Lq(String str) {
        if (this.jST != null) {
            this.jST.Lt(str);
        }
    }

    public void a(C0743a c0743a, e eVar) {
        if (this.jST != null) {
            this.jST.a(c0743a, eVar);
        }
    }

    public void a(C0743a c0743a) {
        if (this.jST != null) {
            this.jST.a(c0743a);
        }
    }

    public int cNr() {
        return com.baidu.tbadk.coreExtra.data.e.bwf();
    }

    public int cNs() {
        return com.baidu.tbadk.coreExtra.data.e.bwg();
    }

    @Nullable
    public List<cb> Lr(String str) {
        List<cb> list = this.jSR.get(str);
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            String Ls = Ls(str);
            for (cb cbVar : list) {
                if (cbVar.eUi != null && !cbVar.eUi.isValid()) {
                    arrayList.add(cbVar);
                    TiebaStatic.log(new ar("c14088").ap("obj_source", 6).dR("obj_type", Ls).ap("obj_locate", 1));
                }
            }
            list.removeAll(arrayList);
        }
        return list;
    }

    private String Ls(String str) {
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
        List<cb> list = this.jSR.get(str);
        if (list != null && list.size() > 0) {
            for (cb cbVar : list) {
                if (cbVar != null && cbVar.eUi != null && cbVar.eUi.dNp() == obj) {
                    list.remove(cbVar);
                    return;
                }
            }
        }
    }

    public void e(String str, cb cbVar) {
        List<cb> list = this.jSR.get(str);
        if (list == null) {
            list = new LinkedList<>();
            this.jSR.put(str, list);
        }
        list.add(cbVar);
    }

    public void b(Activity activity, String str, final String str2, final String str3) {
        if (com.baidu.tbadk.a.d.biV()) {
            List<cb> Lr = Lr(str);
            if (Lr == null || Lr.size() < 2) {
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
