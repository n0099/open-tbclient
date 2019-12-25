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
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.swan.apps.media.c.c;
import com.baidu.tieba.R;
import com.facebook.drawee.drawable.p;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
/* loaded from: classes9.dex */
public class VideoContainerManager extends com.baidu.swan.apps.component.b.a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView bdx;
    private VideoHolderWrapper eap;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bdx = new SwanAppComponentContainerView(this.mContext);
        this.bdx.setBackgroundColor(Color.parseColor("#666666"));
        dN(1);
    }

    public void j(c cVar) {
        if (cVar != null) {
            k(cVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    /* renamed from: ew */
    public VideoHolderWrapper bj(@NonNull Context context) {
        return aXC();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bF(@NonNull Context context) {
        return this.bdx;
    }

    private void k(c cVar) {
        if (cVar != null) {
            if (!(HX() != null)) {
                if (aXC().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aXC().getParent()).removeView(aXC());
                }
                aXF().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + HS().isSuccess() + " position " + cVar.bdl);
                return;
            }
            c HV = HV();
            if (!TextUtils.equals(cVar.bdh, HV.bdh) || !TextUtils.equals(cVar.bdi, HV.bdi) || !TextUtils.equals(cVar.bdj, HV.bdj)) {
                com.baidu.swan.apps.component.e.a.aj("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bdl);
        }
    }

    private VideoHolderWrapper aXC() {
        if (this.eap == null) {
            this.eap = new VideoHolderWrapper(this.mContext);
        }
        return this.eap;
    }

    public FrameLayout getVideoHolder() {
        return aXC().getVideoHolder();
    }

    public void l(View.OnClickListener onClickListener) {
        View playerIcon = aXC().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void aXD() {
        l(aXC().getPlayerIcon(), 8);
    }

    public void cF(String str, String str2) {
        aXC().setPoster(str, str2);
        l(aXC().getVideoPoster(), 0);
    }

    public void aXE() {
        l(aXC().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aXF() {
        return this.bdx;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eaj;
        private ImageView eaq;
        private SimpleDraweeView ear;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aXG();
            aXH();
            aXI();
        }

        private void aXG() {
            this.eaj = new FrameLayout(getContext());
            addView(this.eaj, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aXH() {
            this.ear = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.ear.getHierarchy().b(p.b.lII);
            addView(this.ear, layoutParams);
        }

        private void aXI() {
            this.eaq = new ImageView(VideoContainerManager.this.mContext);
            this.eaq.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eaq, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eaj;
        }

        public View getPlayerIcon() {
            return this.eaq;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.ear;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.lII;
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
                        p.b bVar2 = p.b.lIH;
                        break;
                    case 1:
                        p.b bVar3 = p.b.lII;
                        break;
                    case 2:
                        p.b bVar4 = p.b.lIC;
                        break;
                }
                this.ear.getHierarchy().b(p.b.lII);
                a(str, this.ear);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder X = ImageRequestBuilder.X(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                X.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.djg().c(simpleDraweeView.getController()).be(X.dpZ()).djX());
        }

        public Uri getUri(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http://") || str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("file://")) {
                return Uri.parse(str);
            }
            if (str.startsWith("/")) {
                return Uri.fromFile(new File(str));
            }
            return null;
        }
    }
}
