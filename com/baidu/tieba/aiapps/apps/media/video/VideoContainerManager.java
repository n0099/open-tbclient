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
/* loaded from: classes10.dex */
public class VideoContainerManager extends com.baidu.swan.apps.component.b.a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView bem;
    private VideoHolderWrapper eay;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bem = new SwanAppComponentContainerView(this.mContext);
        this.bem.setBackgroundColor(Color.parseColor("#666666"));
        dO(1);
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
        return aXW();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bF(@NonNull Context context) {
        return this.bem;
    }

    private void k(c cVar) {
        if (cVar != null) {
            if (!(It() != null)) {
                if (aXW().getParent() instanceof ViewGroup) {
                    ((ViewGroup) aXW().getParent()).removeView(aXW());
                }
                aXZ().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + Io().isSuccess() + " position " + cVar.bdZ);
                return;
            }
            c Ir = Ir();
            if (!TextUtils.equals(cVar.bdV, Ir.bdV) || !TextUtils.equals(cVar.bdW, Ir.bdW) || !TextUtils.equals(cVar.bdX, Ir.bdX)) {
                com.baidu.swan.apps.component.e.a.ak("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bdZ);
        }
    }

    private VideoHolderWrapper aXW() {
        if (this.eay == null) {
            this.eay = new VideoHolderWrapper(this.mContext);
        }
        return this.eay;
    }

    public FrameLayout getVideoHolder() {
        return aXW().getVideoHolder();
    }

    public void k(View.OnClickListener onClickListener) {
        View playerIcon = aXW().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void aXX() {
        l(aXW().getPlayerIcon(), 8);
    }

    public void cF(String str, String str2) {
        aXW().setPoster(str, str2);
        l(aXW().getVideoPoster(), 0);
    }

    public void aXY() {
        l(aXW().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView aXZ() {
        return this.bem;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private SimpleDraweeView eaA;
        private FrameLayout eas;
        private ImageView eaz;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            aYa();
            aYb();
            aYc();
        }

        private void aYa() {
            this.eas = new FrameLayout(getContext());
            addView(this.eas, new FrameLayout.LayoutParams(-1, -1));
        }

        private void aYb() {
            this.eaA = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eaA.getHierarchy().b(p.b.lMk);
            addView(this.eaA, layoutParams);
        }

        private void aYc() {
            this.eaz = new ImageView(VideoContainerManager.this.mContext);
            this.eaz.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eaz, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eas;
        }

        public View getPlayerIcon() {
            return this.eaz;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eaA;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.lMk;
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
                        p.b bVar2 = p.b.lMj;
                        break;
                    case 1:
                        p.b bVar3 = p.b.lMk;
                        break;
                    case 2:
                        p.b bVar4 = p.b.lMe;
                        break;
                }
                this.eaA.getHierarchy().b(p.b.lMk);
                a(str, this.eaA);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dkj().c(simpleDraweeView.getController()).be(X.dro()).dla());
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
