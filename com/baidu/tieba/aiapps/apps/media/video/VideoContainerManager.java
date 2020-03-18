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
    private SwanAppComponentContainerView biQ;
    private VideoHolderWrapper eff;
    private Context mContext;

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.mContext = context;
        this.biQ = new SwanAppComponentContainerView(this.mContext);
        this.biQ.setBackgroundColor(Color.parseColor("#666666"));
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
    /* renamed from: ey */
    public VideoHolderWrapper bm(@NonNull Context context) {
        return bas();
    }

    @Override // com.baidu.swan.apps.component.b.a
    @NonNull
    protected SwanAppComponentContainerView bI(@NonNull Context context) {
        return this.biQ;
    }

    private void k(c cVar) {
        if (cVar != null) {
            if (!(KN() != null)) {
                if (bas().getParent() instanceof ViewGroup) {
                    ((ViewGroup) bas().getParent()).removeView(bas());
                }
                bav().setDescendantFocusability(393216);
                com.baidu.swan.apps.console.c.d("video", "Add CoverContainerWrapper " + KI().isSuccess() + " position " + cVar.biE);
                return;
            }
            c KL = KL();
            if (!TextUtils.equals(cVar.biA, KL.biA) || !TextUtils.equals(cVar.biB, KL.biB) || !TextUtils.equals(cVar.biC, KL.biC)) {
                com.baidu.swan.apps.component.e.a.at("video", "updateCoverContainerPosition with different id");
            }
            com.baidu.swan.apps.console.c.d("video", "Update CoverContainerWrapper " + a((VideoContainerManager) cVar).isSuccess() + " position " + cVar.biE);
        }
    }

    private VideoHolderWrapper bas() {
        if (this.eff == null) {
            this.eff = new VideoHolderWrapper(this.mContext);
        }
        return this.eff;
    }

    public FrameLayout getVideoHolder() {
        return bas().getVideoHolder();
    }

    public void k(View.OnClickListener onClickListener) {
        View playerIcon = bas().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        l(playerIcon, 0);
    }

    public void bat() {
        l(bas().getPlayerIcon(), 8);
    }

    public void cN(String str, String str2) {
        bas().setPoster(str, str2);
        l(bas().getVideoPoster(), 0);
    }

    public void bau() {
        l(bas().getVideoPoster(), 8);
    }

    public SwanAppComponentContainerView bav() {
        return this.biQ;
    }

    private void l(View view, int i) {
        if (view != null && view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes12.dex */
    public class VideoHolderWrapper extends FrameLayout {
        private FrameLayout eeZ;
        private ImageView efg;
        private SimpleDraweeView efh;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            baw();
            bax();
            bay();
        }

        private void baw() {
            this.eeZ = new FrameLayout(getContext());
            addView(this.eeZ, new FrameLayout.LayoutParams(-1, -1));
        }

        private void bax() {
            this.efh = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.efh.getHierarchy().b(p.b.lOK);
            addView(this.efh, layoutParams);
        }

        private void bay() {
            this.efg = new ImageView(VideoContainerManager.this.mContext);
            this.efg.setImageResource(R.drawable.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.efg, layoutParams);
        }

        public FrameLayout getVideoHolder() {
            return this.eeZ;
        }

        public View getPlayerIcon() {
            return this.efg;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.efh;
        }

        public void setPoster(String str) {
            setPoster(str, "cover");
        }

        public void setPoster(String str, String str2) {
            if (!TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = "cover";
                }
                p.b bVar = p.b.lOK;
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
                        p.b bVar2 = p.b.lOJ;
                        break;
                    case 1:
                        p.b bVar3 = p.b.lOK;
                        break;
                    case 2:
                        p.b bVar4 = p.b.lOE;
                        break;
                }
                this.efh.getHierarchy().b(p.b.lOK);
                a(str, this.efh);
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
            simpleDraweeView.setController(com.facebook.drawee.a.a.c.dlW().c(simpleDraweeView.getController()).bg(Y.dta()).dmN());
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
