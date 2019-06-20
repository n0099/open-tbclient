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
    private a deh;
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
            if (com.baidu.swan.apps.view.container.c.b.a(cVar.aDm, cVar.id, ac.iq(cVar.aDm)) == null) {
                if (aFg().getModel() != null) {
                    aFg().Pr();
                }
                if (aFc().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aFc().getParent()).removeView(aFc());
                }
                aFg().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aFg().a(aFc(), cVar) + " position " + cVar.aDo);
                return;
            }
            com.baidu.swan.apps.model.a.a.a GI = cVar.GI();
            GI.aDm = aFg().getSlaveId();
            GI.aDn = aFg().getParentId();
            GI.id = aFg().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aFg().a(GI) + " position " + cVar.aDo);
        }
    }

    private a aFc() {
        if (this.deh == null) {
            this.deh = new a(this.mContext);
        }
        return this.deh;
    }

    public FrameLayout aFd() {
        return aFc().aFd();
    }

    public void j(View.OnClickListener onClickListener) {
        View aFk = aFc().aFk();
        aFk.setOnClickListener(onClickListener);
        s(aFk, 0);
    }

    public void aFe() {
        s(aFc().aFk(), 8);
    }

    public void cp(String str, String str2) {
        aFc().cq(str, str2);
        s(aFc().aFl(), 0);
    }

    public void aFf() {
        s(aFc().aFl(), 8);
    }

    public SwanAppNAViewContainer aFg() {
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
        private FrameLayout dec;
        private ImageView dei;
        private SimpleDraweeView dej;

        public a(Context context) {
            super(context);
            aFh();
            aFi();
            aFj();
        }

        private void aFh() {
            this.dec = new FrameLayout(getContext());
            addView(this.dec, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aFi() {
            this.dej = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dej.getHierarchy().b(n.b.jWe);
            addView(this.dej, layoutParams);
        }

        private void aFj() {
            this.dei = new ImageView(b.this.mContext);
            this.dei.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dei, layoutParams);
        }

        public FrameLayout aFd() {
            return this.dec;
        }

        public View aFk() {
            return this.dei;
        }

        public SimpleDraweeView aFl() {
            return this.dej;
        }

        public void cq(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.jWe;
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
                        n.b bVar2 = n.b.jWd;
                        break;
                    case 1:
                        n.b bVar3 = n.b.jWe;
                        break;
                    case 2:
                        n.b bVar4 = n.b.jVY;
                        break;
                }
                this.dej.getHierarchy().b(n.b.jWe);
                a(str, this.dej);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri ip = ip(str);
            if (ip == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder U = ImageRequestBuilder.U(ip);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                U.c(new com.facebook.imagepipeline.common.c(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cCt().b(simpleDraweeView.getController()).aO(U.cIy()).cDd());
        }

        public Uri ip(String str) {
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
