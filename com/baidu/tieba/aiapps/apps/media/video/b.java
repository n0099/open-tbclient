package com.baidu.tieba.aiapps.apps.media.video;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
    private SwanAppNAViewContainer akG;
    private a def;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.akG = new SwanAppNAViewContainer(this.mContext);
        this.akG.setBackgroundColor(Color.parseColor("#666666"));
    }

    public void j(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            k(cVar);
        }
    }

    private void k(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            if (com.baidu.swan.apps.view.container.c.b.a(cVar.aDm, cVar.id, ac.ir(cVar.aDm)) == null) {
                if (aFd().getModel() != null) {
                    aFd().Pr();
                }
                if (aEZ().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aEZ().getParent()).removeView(aEZ());
                }
                aFd().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aFd().a(aEZ(), cVar) + " position " + cVar.aDo);
                return;
            }
            com.baidu.swan.apps.model.a.a.a GI = cVar.GI();
            GI.aDm = aFd().getSlaveId();
            GI.aDn = aFd().getParentId();
            GI.id = aFd().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aFd().a(GI) + " position " + cVar.aDo);
        }
    }

    private a aEZ() {
        if (this.def == null) {
            this.def = new a(this.mContext);
        }
        return this.def;
    }

    public FrameLayout aFa() {
        return aEZ().aFa();
    }

    public void j(View.OnClickListener onClickListener) {
        View aFh = aEZ().aFh();
        aFh.setOnClickListener(onClickListener);
        s(aFh, 0);
    }

    public void aFb() {
        s(aEZ().aFh(), 8);
    }

    public void cp(String str, String str2) {
        aEZ().cq(str, str2);
        s(aEZ().aFi(), 0);
    }

    public void aFc() {
        s(aEZ().aFi(), 8);
    }

    public SwanAppNAViewContainer aFd() {
        return this.akG;
    }

    private void s(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FrameLayout {
        private FrameLayout dea;
        private ImageView deg;
        private SimpleDraweeView deh;

        public a(Context context) {
            super(context);
            aFe();
            aFf();
            aFg();
        }

        private void aFe() {
            this.dea = new FrameLayout(getContext());
            addView(this.dea, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aFf() {
            this.deh = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.deh.getHierarchy().b(n.b.jWa);
            addView(this.deh, layoutParams);
        }

        private void aFg() {
            this.deg = new ImageView(b.this.mContext);
            this.deg.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.deg, layoutParams);
        }

        public FrameLayout aFa() {
            return this.dea;
        }

        public View aFh() {
            return this.deg;
        }

        public SimpleDraweeView aFi() {
            return this.deh;
        }

        public void cq(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.jWa;
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
                        n.b bVar2 = n.b.jVZ;
                        break;
                    case 1:
                        n.b bVar3 = n.b.jWa;
                        break;
                    case 2:
                        n.b bVar4 = n.b.jVU;
                        break;
                }
                this.deh.getHierarchy().b(n.b.jWa);
                a(str, this.deh);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri iq = iq(str);
            if (iq == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder U = ImageRequestBuilder.U(iq);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                U.c(new com.facebook.imagepipeline.common.c(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cCs().b(simpleDraweeView.getController()).aO(U.cIx()).cDc());
        }

        public Uri iq(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http://") || str.startsWith("https://") || str.startsWith(SkiaImageDecoder.FILE_PREFIX)) {
                return Uri.parse(str);
            }
            if (str.startsWith("/")) {
                return Uri.fromFile(new File(str));
            }
            return null;
        }
    }
}
