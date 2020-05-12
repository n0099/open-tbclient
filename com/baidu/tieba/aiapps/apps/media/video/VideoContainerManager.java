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
    private SwanAppComponentContainerView bHd;
    private VideoHolderWrapper eFa;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.bHd = new SwanAppComponentContainerView(this.mContext);
        this.bHd.setBackgroundColor(Color.parseColor("#666666"));
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
    /* renamed from: dY */
    public VideoHolderWrapper aO(@NonNull Context context) {
        return bit();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bk(@NonNull Context context) {
        return this.bHd;
    }

    private void k(c cVar) {
        if (cVar != null) {
            if (!(SA() != null)) {
                if (bit().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bit().getParent()).removeView(bit());
                }
                biw().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + Sv().isSuccess() + " position " + cVar.bGR);
                return;
            }
            c Sy = Sy();
            if (!TextUtils.equals(cVar.bGN, Sy.bGN) || !TextUtils.equals(cVar.bGO, Sy.bGO) || !TextUtils.equals(cVar.bGP, Sy.bGP)) {
                com.baidu.swan.apps.component.e.a.aC("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bGR);
        }
    }

    private VideoHolderWrapper bit() {
        if (this.eFa == null) {
            this.eFa = new VideoHolderWrapper(this.mContext);
        }
        return this.eFa;
    }

    public FrameLayout getVideoHolder() {
        return bit().getVideoHolder();
    }

    public void k(View.OnClickListener onClickListener) {
        View playerIcon = bit().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        k(playerIcon, 0);
    }

    public void biu() {
        k(bit().getPlayerIcon(), 8);
    }

    public void cY(String str, String str2) {
        bit().setPoster(str, str2);
        k(bit().getVideoPoster(), 0);
    }

    public void biv() {
        k(bit().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView biw() {
        return this.bHd;
    }

    private void k(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eEU;
        private ImageView eFb;
        private SimpleDraweeView eFc;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bix();
            biy();
            biz();
        }

        private void bix() {
            this.eEU = new FrameLayout(getContext());
            addView(this.eEU, new FrameLayout.LayoutParams(-1, -1));
        }

        private void biy() {
            this.eFc = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eFc.getHierarchy().b(p.b.lWk);
            addView(this.eFc, layoutParams);
        }

        private void biz() {
            this.eFb = new ImageView(VideoContainerManager.this.mContext);
            this.eFb.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eFb, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eEU;
        }

        public View getPlayerIcon() {
            return this.eFb;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eFc;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.lWk;
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
                        p.b bVar2 = p.b.lWj;
                        break;
                    case 1:
                        p.b bVar3 = p.b.lWk;
                        break;
                    case 2:
                        p.b bVar4 = p.b.lWe;
                        break;
                }
                this.eFc.getHierarchy().b(p.b.lWk);
                a(str, this.eFc);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dnN().c(simpleDraweeView.getController()).aX(Z.duU()).doE());
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
