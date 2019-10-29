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
    private SwanAppNAViewContainer aFc;
    private a dqY;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.aFc = new SwanAppNAViewContainer(this.mContext);
        this.aFc.setBackgroundColor(Color.parseColor("#666666"));
    }

    public void j(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            k(cVar);
        }
    }

    private void k(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            if (com.baidu.swan.apps.view.container.c.b.a(cVar.aXH, cVar.id, ac.jc(cVar.aXH)) == null) {
                if (aHs().getModel() != null) {
                    aHs().Vc();
                }
                if (aHo().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aHo().getParent()).removeView(aHo());
                }
                aHs().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aHs().a(aHo(), cVar) + " position " + cVar.aXJ);
                return;
            }
            com.baidu.swan.apps.model.a.a.a Mq = cVar.Mq();
            Mq.aXH = aHs().getSlaveId();
            Mq.aXI = aHs().getParentId();
            Mq.id = aHs().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aHs().a(Mq) + " position " + cVar.aXJ);
        }
    }

    private a aHo() {
        if (this.dqY == null) {
            this.dqY = new a(this.mContext);
        }
        return this.dqY;
    }

    public FrameLayout aHp() {
        return aHo().aHp();
    }

    public void k(View.OnClickListener onClickListener) {
        View aHw = aHo().aHw();
        aHw.setOnClickListener(onClickListener);
        l(aHw, 0);
    }

    public void aHq() {
        l(aHo().aHw(), 8);
    }

    public void ck(String str, String str2) {
        aHo().cl(str, str2);
        l(aHo().aHx(), 0);
    }

    public void aHr() {
        l(aHo().aHx(), 8);
    }

    public SwanAppNAViewContainer aHs() {
        return this.aFc;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FrameLayout {
        private FrameLayout dqT;
        private ImageView dqZ;
        private SimpleDraweeView dra;

        public a(@NonNull Context context) {
            super(context);
            aHt();
            aHu();
            aHv();
        }

        private void aHt() {
            this.dqT = new FrameLayout(getContext());
            addView(this.dqT, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aHu() {
            this.dra = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dra.getHierarchy().b(n.b.keV);
            addView(this.dra, layoutParams);
        }

        private void aHv() {
            this.dqZ = new ImageView(b.this.mContext);
            this.dqZ.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dqZ, layoutParams);
        }

        public FrameLayout aHp() {
            return this.dqT;
        }

        public View aHw() {
            return this.dqZ;
        }

        public SimpleDraweeView aHx() {
            return this.dra;
        }

        public void cl(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.keV;
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
                        n.b bVar2 = n.b.keU;
                        break;
                    case 1:
                        n.b bVar3 = n.b.keV;
                        break;
                    case 2:
                        n.b bVar4 = n.b.keP;
                        break;
                }
                this.dra.getHierarchy().b(n.b.keV);
                a(str, this.dra);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri jb = jb(str);
            if (jb == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder R = ImageRequestBuilder.R(jb);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                R.c(new com.facebook.imagepipeline.common.c(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cDB().b(simpleDraweeView.getController()).aJ(R.cJI()).cEl());
        }

        public Uri jb(String str) {
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
