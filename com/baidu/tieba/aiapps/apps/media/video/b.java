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
    private a dfS;
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
                if (aGB().getModel() != null) {
                    aGB().Qi();
                }
                if (aGx().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aGx().getParent()).removeView(aGx());
                }
                aGB().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aGB().a(aGx(), cVar) + " position " + cVar.aDW);
                return;
            }
            com.baidu.swan.apps.model.a.a.a Hs = cVar.Hs();
            Hs.aDU = aGB().getSlaveId();
            Hs.aDV = aGB().getParentId();
            Hs.id = aGB().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aGB().a(Hs) + " position " + cVar.aDW);
        }
    }

    private a aGx() {
        if (this.dfS == null) {
            this.dfS = new a(this.mContext);
        }
        return this.dfS;
    }

    public FrameLayout aGy() {
        return aGx().aGy();
    }

    public void j(View.OnClickListener onClickListener) {
        View aGF = aGx().aGF();
        aGF.setOnClickListener(onClickListener);
        s(aGF, 0);
    }

    public void aGz() {
        s(aGx().aGF(), 8);
    }

    public void cq(String str, String str2) {
        aGx().cr(str, str2);
        s(aGx().aGG(), 0);
    }

    public void aGA() {
        s(aGx().aGG(), 8);
    }

    public SwanAppNAViewContainer aGB() {
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
        private FrameLayout dfN;
        private ImageView dfT;
        private SimpleDraweeView dfU;

        public a(@NonNull Context context) {
            super(context);
            aGC();
            aGD();
            aGE();
        }

        private void aGC() {
            this.dfN = new FrameLayout(getContext());
            addView(this.dfN, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aGD() {
            this.dfU = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dfU.getHierarchy().b(n.b.keo);
            addView(this.dfU, layoutParams);
        }

        private void aGE() {
            this.dfT = new ImageView(b.this.mContext);
            this.dfT.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dfT, layoutParams);
        }

        public FrameLayout aGy() {
            return this.dfN;
        }

        public View aGF() {
            return this.dfT;
        }

        public SimpleDraweeView aGG() {
            return this.dfU;
        }

        public void cr(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.keo;
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
                        n.b bVar2 = n.b.ken;
                        break;
                    case 1:
                        n.b bVar3 = n.b.keo;
                        break;
                    case 2:
                        n.b bVar4 = n.b.kei;
                        break;
                }
                this.dfU.getHierarchy().b(n.b.keo);
                a(str, this.dfU);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cFP().b(simpleDraweeView.getController()).aO(U.cLX()).cGz());
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
