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
    private SwanAppComponentContainerView biD;
    private VideoHolderWrapper eeP;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.biD = new SwanAppComponentContainerView(this.mContext);
        this.biD.setBackgroundColor(Color.parseColor("#666666"));
        ee(1);
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
    /* renamed from: ez */
    public VideoHolderWrapper bn(@NonNull Context context) {
        return bao();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bJ(@NonNull Context context) {
        return this.biD;
    }

    private void k(c cVar) {
        if (cVar != null) {
            if (!(KK() != null)) {
                if (bao().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bao().getParent()).removeView(bao());
                }
                bar().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + KF().isSuccess() + " position " + cVar.bir);
                return;
            }
            c KI = KI();
            if (!TextUtils.equals(cVar.bim, KI.bim) || !TextUtils.equals(cVar.bin, KI.bin) || !TextUtils.equals(cVar.bip, KI.bip)) {
                com.baidu.swan.apps.component.e.a.au("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.bir);
        }
    }

    private VideoHolderWrapper bao() {
        if (this.eeP == null) {
            this.eeP = new VideoHolderWrapper(this.mContext);
        }
        return this.eeP;
    }

    public FrameLayout getVideoHolder() {
        return bao().getVideoHolder();
    }

    public void k(View.OnClickListener onClickListener) {
        View playerIcon = bao().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bap() {
        l(bao().getPlayerIcon(), 8);
    }

    public void cO(String str, String str2) {
        bao().setPoster(str, str2);
        l(bao().getVideoPoster(), 0);
    }

    public void baq() {
        l(bao().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bar() {
        return this.biD;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eeJ;
        private ImageView eeQ;
        private SimpleDraweeView eeR;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            bas();
            bat();
            bau();
        }

        private void bas() {
            this.eeJ = new FrameLayout(getContext());
            addView(this.eeJ, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bat() {
            this.eeR = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.eeR.getHierarchy().b(p.b.lNe);
            addView(this.eeR, layoutParams);
        }

        private void bau() {
            this.eeQ = new ImageView(VideoContainerManager.this.mContext);
            this.eeQ.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.eeQ, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eeJ;
        }

        public View getPlayerIcon() {
            return this.eeQ;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.eeR;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.lNe;
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
                        p.b bVar2 = p.b.lNd;
                        break;
                    case 1:
                        p.b bVar3 = p.b.lNe;
                        break;
                    case 2:
                        p.b bVar4 = p.b.lMY;
                        break;
                }
                this.eeR.getHierarchy().b(p.b.lNe);
                a(str, this.eeR);
            }
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri uri = getUri(str);
            if (uri == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder Y = ImageRequestBuilder.Y(uri);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                Y.c(new d(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dlz().c(simpleDraweeView.getController()).bg(Y.dsD()).dmq());
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
