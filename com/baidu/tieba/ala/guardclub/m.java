package com.baidu.tieba.ala.guardclub;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class m extends BaseAdapter {
    private String aVr;
    private List<com.baidu.tieba.ala.guardclub.model.k> blZ;
    private a gfk;
    private int gfl;
    private float gfm;
    private float gfn;
    private int gfo;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.gfm = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.gfn = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gfo = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gfo = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fJ(String str) {
        this.aVr = str;
    }

    public void a(a aVar) {
        this.gfk = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.blZ;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.blZ == null) {
            this.blZ = new ArrayList();
        }
        this.blZ.clear();
        bV(list);
    }

    public void bV(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.blZ == null) {
            this.blZ = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.blZ.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.blZ != null) {
            return this.blZ.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tL */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.blZ.get(i);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.h.live_guard_club_rank_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.fVc = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.gfr = view.findViewById(a.g.layout_avatar);
            bVar2.fVe = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.gfs = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fVe, bVar2.gfs);
            bVar2.gft = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aBx = (TextView) view.findViewById(a.g.tv_name);
            bVar2.gdW = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fVj = (TextView) view.findViewById(a.g.tv_content);
            bVar2.gfv = view.findViewById(a.g.layout_action);
            bVar2.gfw = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.gfx = (TextView) view.findViewById(a.g.tv_joined);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        com.baidu.tieba.ala.guardclub.model.k item = getItem(i);
        if (item != null) {
            a(bVar, i);
            a(bVar, item);
            a(bVar, viewGroup.getContext(), item);
            b(bVar, item);
        }
        return view;
    }

    private void a(HeadImageView headImageView, TbImageView tbImageView) {
        headImageView.setIsRound(true);
        headImageView.setDrawBorder(false);
        headImageView.setAutoChangeStyle(false);
        headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
        tbImageView.setDefaultBgResource(a.d.sdk_transparent);
        tbImageView.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void a(b bVar, int i) {
        if (i + 4 >= 100) {
            bVar.fVc.setText("99+");
            bVar.fVc.setTextSize(0, this.gfn);
            return;
        }
        bVar.fVc.setText(String.valueOf(i + 4));
        bVar.fVc.setTextSize(0, this.gfm);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fVe.stopLoad();
        bVar.fVe.startLoad(kVar.avatar, 12, false, false);
        bVar.gfs.stopLoad();
        b(bVar);
        bVar.fVe.setScaleX(1.0f);
        bVar.fVe.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gft.setVisibility(8);
        } else {
            bVar.gft.setVisibility(0);
            a(bVar);
        }
        String ex = com.baidu.live.guardclub.g.IP().ex(kVar.level);
        if (!TextUtils.isEmpty(ex)) {
            bVar.gfs.startLoad(ex, 10, false);
            bVar.gfs.setVisibility(0);
        } else {
            bVar.gfs.setVisibility(8);
        }
        bVar.gfr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gfk != null) {
                    m.this.gfk.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gfl <= 0) {
            this.gfl = bVar.gdW.getWidth();
            if (this.gfl <= 0) {
                bVar.gdW.measure(0, 0);
                this.gfl = bVar.gdW.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aBx.setPadding(0, 0, this.gfl, 0);
            bVar.gdW.setVisibility(0);
        } else {
            bVar.aBx.setPadding(0, 0, 0, 0);
            bVar.gdW.setVisibility(4);
        }
        bVar.aBx.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gfV;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fVj.setText(String.format(context.getResources().getString(this.gfo), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.aVr) || TextUtils.isEmpty(kVar.aLM) || !this.aVr.equals(kVar.aLM)) {
            bVar.gfv.setVisibility(0);
            if (kVar.gfW) {
                bVar.gfx.setVisibility(0);
                bVar.gfw.setVisibility(8);
                return;
            }
            bVar.gfx.setVisibility(8);
            bVar.gfw.setVisibility(0);
            bVar.gfw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.gfk != null) {
                        m.this.gfk.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gfv.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gfu == null) {
            bVar.gfu = new AnimatorSet();
        }
        bVar.gft.setAnimation("live_anim_guard_join.json");
        bVar.gft.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fVe, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fVe, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gfu.setDuration(1000L);
        bVar.gfu.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gfu.play(ofFloat).with(ofFloat2);
        bVar.gft.playAnimation();
        bVar.gfu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gft.cancelAnimation();
        if (bVar.gfu == null) {
            return;
        }
        bVar.gfu.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aBx;
        private TextView fVc;
        private HeadImageView fVe;
        private TextView fVj;
        private TextView gdW;
        private View gfr;
        private TbImageView gfs;
        private LottieAnimationView gft;
        private AnimatorSet gfu;
        private View gfv;
        private TextView gfw;
        private TextView gfx;

        public b() {
        }

        public void recycle() {
            Rm();
        }

        public void Rm() {
            m.this.b(this);
        }
    }
}
