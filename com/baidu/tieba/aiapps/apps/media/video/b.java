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
    private SwanAppNAViewContainer alI;
    private a dhD;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.alI = new SwanAppNAViewContainer(this.mContext);
        this.alI.setBackgroundColor(Color.parseColor("#666666"));
    }

    public void j(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            k(cVar);
        }
    }

    private void k(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            if (com.baidu.swan.apps.view.container.c.b.a(cVar.aEs, cVar.id, ac.iz(cVar.aEs)) == null) {
                if (aHf().getModel() != null) {
                    aHf().Qm();
                }
                if (aHb().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aHb().getParent()).removeView(aHb());
                }
                aHf().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aHf().a(aHb(), cVar) + " position " + cVar.aEu);
                return;
            }
            com.baidu.swan.apps.model.a.a.a Hw = cVar.Hw();
            Hw.aEs = aHf().getSlaveId();
            Hw.aEt = aHf().getParentId();
            Hw.id = aHf().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aHf().a(Hw) + " position " + cVar.aEu);
        }
    }

    private a aHb() {
        if (this.dhD == null) {
            this.dhD = new a(this.mContext);
        }
        return this.dhD;
    }

    public FrameLayout aHc() {
        return aHb().aHc();
    }

    public void j(View.OnClickListener onClickListener) {
        View aHj = aHb().aHj();
        aHj.setOnClickListener(onClickListener);
        s(aHj, 0);
    }

    public void aHd() {
        s(aHb().aHj(), 8);
    }

    public void cr(String str, String str2) {
        aHb().cs(str, str2);
        s(aHb().aHk(), 0);
    }

    public void aHe() {
        s(aHb().aHk(), 8);
    }

    public SwanAppNAViewContainer aHf() {
        return this.alI;
    }

    private void s(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FrameLayout {
        private ImageView dhE;
        private SimpleDraweeView dhF;
        private FrameLayout dhy;

        public a(@NonNull Context context) {
            super(context);
            aHg();
            aHh();
            aHi();
        }

        private void aHg() {
            this.dhy = new FrameLayout(getContext());
            addView(this.dhy, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aHh() {
            this.dhF = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dhF.getHierarchy().b(n.b.kgM);
            addView(this.dhF, layoutParams);
        }

        private void aHi() {
            this.dhE = new ImageView(b.this.mContext);
            this.dhE.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dhE, layoutParams);
        }

        public FrameLayout aHc() {
            return this.dhy;
        }

        public View aHj() {
            return this.dhE;
        }

        public SimpleDraweeView aHk() {
            return this.dhF;
        }

        public void cs(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.kgM;
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
                        n.b bVar2 = n.b.kgL;
                        break;
                    case 1:
                        n.b bVar3 = n.b.kgM;
                        break;
                    case 2:
                        n.b bVar4 = n.b.kgG;
                        break;
                }
                this.dhF.getHierarchy().b(n.b.kgM);
                a(str, this.dhF);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri iy = iy(str);
            if (iy == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder U = ImageRequestBuilder.U(iy);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                U.c(new com.facebook.imagepipeline.common.c(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cGD().b(simpleDraweeView.getController()).aO(U.cML()).cHn());
        }

        public Uri iy(String str) {
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
