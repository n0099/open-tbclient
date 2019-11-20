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
    private SwanAppNAViewContainer aEK;
    private a dqh;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.aEK = new SwanAppNAViewContainer(this.mContext);
        this.aEK.setBackgroundColor(Color.parseColor("#666666"));
    }

    public void j(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            k(cVar);
        }
    }

    private void k(com.baidu.swan.apps.media.d.c cVar) {
        if (cVar != null) {
            if (com.baidu.swan.apps.view.container.c.b.a(cVar.aXp, cVar.id, ac.jc(cVar.aXp)) == null) {
                if (aHq().getModel() != null) {
                    aHq().Va();
                }
                if (aHm().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aHm().getParent()).removeView(aHm());
                }
                aHq().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + aHq().a(aHm(), cVar) + " position " + cVar.aXr);
                return;
            }
            com.baidu.swan.apps.model.a.a.a Mr = cVar.Mr();
            Mr.aXp = aHq().getSlaveId();
            Mr.aXq = aHq().getParentId();
            Mr.id = aHq().getViewId();
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + aHq().a(Mr) + " position " + cVar.aXr);
        }
    }

    private a aHm() {
        if (this.dqh == null) {
            this.dqh = new a(this.mContext);
        }
        return this.dqh;
    }

    public FrameLayout aHn() {
        return aHm().aHn();
    }

    public void k(View.OnClickListener onClickListener) {
        View aHu = aHm().aHu();
        aHu.setOnClickListener(onClickListener);
        l(aHu, 0);
    }

    public void aHo() {
        l(aHm().aHu(), 8);
    }

    public void ck(String str, String str2) {
        aHm().cl(str, str2);
        l(aHm().aHv(), 0);
    }

    public void aHp() {
        l(aHm().aHv(), 8);
    }

    public SwanAppNAViewContainer aHq() {
        return this.aEK;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a extends FrameLayout {
        private FrameLayout dqc;
        private ImageView dqi;
        private SimpleDraweeView dqj;

        public a(@NonNull Context context) {
            super(context);
            aHr();
            aHs();
            aHt();
        }

        private void aHr() {
            this.dqc = new FrameLayout(getContext());
            addView(this.dqc, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aHs() {
            this.dqj = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.dqj.getHierarchy().b(n.b.ked);
            addView(this.dqj, layoutParams);
        }

        private void aHt() {
            this.dqi = new ImageView(b.this.mContext);
            this.dqi.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.dqi, layoutParams);
        }

        public FrameLayout aHn() {
            return this.dqc;
        }

        public View aHu() {
            return this.dqi;
        }

        public SimpleDraweeView aHv() {
            return this.dqj;
        }

        public void cl(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                n.b bVar = n.b.ked;
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
                        n.b bVar2 = n.b.kec;
                        break;
                    case 1:
                        n.b bVar3 = n.b.ked;
                        break;
                    case 2:
                        n.b bVar4 = n.b.kdX;
                        break;
                }
                this.dqj.getHierarchy().b(n.b.ked);
                a(str, this.dqj);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.cDz().b(simpleDraweeView.getController()).aJ(R.cJG()).cEj());
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
