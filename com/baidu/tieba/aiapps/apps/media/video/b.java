package com.baidu.tieba.aiapps.apps.media.video;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.view.container.SwanAppNAViewContainer;
import com.baidu.tieba.R;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.facebook.drawee.drawable.n;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
/* loaded from: classes4.dex */
public class b {
    private SwanAppNAViewContainer alj;
    private a dfL;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.alj = new SwanAppNAViewContainer(this.mContext);
        this.alj.setBackgroundColor(Color.parseColor("#666666"));
    }

    public void j(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            k(cVar);
        }
    }

    private void k(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            if (com.baidu.swan.apps.view.container.c.b.a(cVar.aDU, cVar.id, ac.ix(cVar.aDU)) == null) {
                if (aGz().getModel() != null) {
                    aGz().Qi();
                }
                if (aGv().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aGv().getParent()).removeView(aGv());
                }
                aGz().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aGz().a(aGv(), cVar) + " position " + cVar.aDW);
                return;
            }
            com.baidu.swan.apps.model.a.a.a Hs = cVar.Hs();
            Hs.aDU = aGz().getSlaveId();
            Hs.aDV = aGz().getParentId();
            Hs.id = aGz().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aGz().a(Hs) + " position " + cVar.aDW);
        }
    }

    private a aGv() {
        if (this.dfL == null) {
            this.dfL = new a(this.mContext);
        }
        return this.dfL;
    }

    public FrameLayout aGw() {
        return aGv().aGw();
    }

    public void j(View.OnClickListener onClickListener) {
        View aGD = aGv().aGD();
        aGD.setOnClickListener(onClickListener);
        s(aGD, 0);
    }

    public void aGx() {
        s(aGv().aGD(), 8);
    }

    public void cq(String str, String str2) {
        aGv().cr(str, str2);
        s(aGv().aGE(), 0);
    }

    public void aGy() {
        s(aGv().aGE(), 8);
    }

    public SwanAppNAViewContainer aGz() {
        return this.alj;
    }

    private void s(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FrameLayout {
        private FrameLayout dfG;
        private ImageView dfM;
        private SimpleDraweeView dfN;

        public a(@NonNull Context context) {
            super(context);
            aGA();
            aGB();
            aGC();
        }

        private void aGA() {
            this.dfG = new FrameLayout(getContext());
            addView(this.dfG, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aGB() {
            this.dfN = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dfN.getHierarchy().b(n.b.kdi);
            addView(this.dfN, layoutParams);
        }

        private void aGC() {
            this.dfM = new ImageView(b.this.mContext);
            this.dfM.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dfM, layoutParams);
        }

        public FrameLayout aGw() {
            return this.dfG;
        }

        public View aGD() {
            return this.dfM;
        }

        public SimpleDraweeView aGE() {
            return this.dfN;
        }

        public void cr(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.kdi;
                char c = 65535;
                switch (str2.hashCode()) {
                    case 3143043:
                        if (str2.equals("fill")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 94852023:
                        if (str2.equals("cover")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 951526612:
                        if (str2.equals("contain")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        n.b bVar2 = n.b.kdh;
                        break;
                    case 1:
                        n.b bVar3 = n.b.kdi;
                        break;
                    case 2:
                        n.b bVar4 = n.b.kdc;
                        break;
                }
                this.dfN.getHierarchy().b(n.b.kdi);
                a(str, this.dfN);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri iw = iw(str);
            if (iw == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder U = ImageRequestBuilder.U(iw);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                U.c(new com.facebook.imagepipeline.common.c(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cFu().b(simpleDraweeView.getController()).aO(U.cLC()).cGe());
        }

        public Uri iw(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
                return Uri.parse(str);
            }
            if (str.startsWith("/")) {
                return Uri.fromFile(new File(str));
            }
            return null;
        }
    }
}
