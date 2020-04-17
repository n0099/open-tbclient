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
/* loaded from: classes12.dex */
public class VideoContainerManager extends com.baidu.swan.apps.component.b.a<VideoHolderWrapper, c> {
    private SwanAppComponentContainerView bGY;
    private VideoHolderWrapper eEV;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bGY = new SwanAppComponentContainerView(this.mContext);
        this.bGY.setBackgroundColor(Color.parseColor("#666666"));
        ej(1);
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
    /* renamed from: ek */
    public VideoHolderWrapper ba(@NonNull Context context) {
        return biv();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bw(@NonNull Context context) {
        return this.bGY;
    }

    private void k(c cVar) {
        if (cVar != null) {
            if (!(SB() != null)) {
                if (biv().getParent() instanceof ViewGroup) {
                    ((ViewGroup) biv().getParent()).removeView(biv());
                }
                biy().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + Sw().isSuccess() + " position " + cVar.bGM);
                return;
            }
            c Sz = Sz();
            if (!TextUtils.equals(cVar.bGI, Sz.bGI) || !TextUtils.equals(cVar.bGJ, Sz.bGJ) || !TextUtils.equals(cVar.bGK, Sz.bGK)) {
                com.baidu.swan.apps.component.e.a.aC("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bGM);
        }
    }

    private VideoHolderWrapper biv() {
        if (this.eEV == null) {
            this.eEV = new VideoHolderWrapper(this.mContext);
        }
        return this.eEV;
    }

    public FrameLayout getVideoHolder() {
        return biv().getVideoHolder();
    }

    public void k(View.OnClickListener onClickListener) {
        View playerIcon = biv().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        k(playerIcon, 0);
    }

    public void biw() {
        k(biv().getPlayerIcon(), 8);
    }

    public void cY(String str, String str2) {
        biv().setPoster(str, str2);
        k(biv().getVideoPoster(), 0);
    }

    public void bix() {
        k(biv().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView biy() {
        return this.bGY;
    }

    private void k(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eEP;
        private ImageView eEW;
        private SimpleDraweeView eEX;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            biz();
            biA();
            biB();
        }

        private void biz() {
            this.eEP = new FrameLayout(getContext());
            addView(this.eEP, new FrameLayout.LayoutParams(-1, -1));
        }

        private void biA() {
            this.eEX = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eEX.getHierarchy().b(p.b.lWg);
            addView(this.eEX, layoutParams);
        }

        private void biB() {
            this.eEW = new ImageView(VideoContainerManager.this.mContext);
            this.eEW.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eEW, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eEP;
        }

        public View getPlayerIcon() {
            return this.eEW;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eEX;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.lWg;
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
                        p.b bVar2 = p.b.lWf;
                        break;
                    case 1:
                        p.b bVar3 = p.b.lWg;
                        break;
                    case 2:
                        p.b bVar4 = p.b.lWa;
                        break;
                }
                this.eEX.getHierarchy().b(p.b.lWg);
                a(str, this.eEX);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder Z = ImageRequestBuilder.Z(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                Z.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dnP().c(simpleDraweeView.getController()).aW(Z.duW()).doG());
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
