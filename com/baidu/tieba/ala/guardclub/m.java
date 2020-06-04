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
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private String fow;
    private a fzp;
    private List<com.baidu.tieba.ala.guardclub.model.k> fzq;
    private int fzr;
    private float fzs;
    private float fzt;
    private int fzu;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.fzs = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.fzt = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.fzu = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.fzu = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void BP(String str) {
        this.fow = str;
    }

    public void a(a aVar) {
        this.fzp = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.fzq;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fzq == null) {
            this.fzq = new ArrayList();
        }
        this.fzq.clear();
        bC(list);
    }

    public void bC(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fzq == null) {
            this.fzq = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.fzq.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fzq != null) {
            return this.fzq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qr */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.fzq.get(i);
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
            bVar2.fqb = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.fzx = view.findViewById(a.g.layout_avatar);
            bVar2.fqd = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.fzy = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fqd, bVar2.fzy);
            bVar2.fzz = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aVs = (TextView) view.findViewById(a.g.tv_name);
            bVar2.fyb = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fqj = (TextView) view.findViewById(a.g.tv_content);
            bVar2.fzB = view.findViewById(a.g.layout_action);
            bVar2.fzC = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.fzD = (TextView) view.findViewById(a.g.tv_joined);
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
        headImageView.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        headImageView.setAutoChangeStyle(false);
        headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
        tbImageView.setDefaultBgResource(a.d.sdk_transparent);
        tbImageView.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void a(b bVar, int i) {
        if (i + 4 >= 100) {
            bVar.fqb.setText("99+");
            bVar.fqb.setTextSize(0, this.fzt);
            return;
        }
        bVar.fqb.setText(String.valueOf(i + 4));
        bVar.fqb.setTextSize(0, this.fzs);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fqd.stopLoad();
        bVar.fqd.startLoad(kVar.avatar, 12, false, false);
        bVar.fzy.stopLoad();
        b(bVar);
        bVar.fqd.setScaleX(1.0f);
        bVar.fqd.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.fzz.setVisibility(8);
        } else {
            bVar.fzz.setVisibility(0);
            a(bVar);
        }
        String cr = com.baidu.live.guardclub.g.BH().cr(kVar.level);
        if (!TextUtils.isEmpty(cr)) {
            bVar.fzy.startLoad(cr, 10, false);
            bVar.fzy.setVisibility(0);
        } else {
            bVar.fzy.setVisibility(8);
        }
        bVar.fzx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fzp != null) {
                    m.this.fzp.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.fzr <= 0) {
            this.fzr = bVar.fyb.getWidth();
            if (this.fzr <= 0) {
                bVar.fyb.measure(0, 0);
                this.fzr = bVar.fyb.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aVs.setPadding(0, 0, this.fzr, 0);
            bVar.fyb.setVisibility(0);
        } else {
            bVar.aVs.setPadding(0, 0, 0, 0);
            bVar.fyb.setVisibility(4);
        }
        bVar.aVs.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.fAd;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fqj.setText(String.format(context.getResources().getString(this.fzu), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.fow) || TextUtils.isEmpty(kVar.aBs) || !this.fow.equals(kVar.aBs)) {
            bVar.fzB.setVisibility(0);
            if (kVar.fAe) {
                bVar.fzD.setVisibility(0);
                bVar.fzC.setVisibility(8);
                return;
            }
            bVar.fzD.setVisibility(8);
            bVar.fzC.setVisibility(0);
            bVar.fzC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.fzp != null) {
                        m.this.fzp.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.fzB.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.fzA == null) {
            bVar.fzA = new AnimatorSet();
        }
        bVar.fzz.setAnimation("live_anim_guard_join.json");
        bVar.fzz.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fqd, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fqd, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.fzA.setDuration(1000L);
        bVar.fzA.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.fzA.play(ofFloat).with(ofFloat2);
        bVar.fzz.playAnimation();
        bVar.fzA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.fzz.cancelAnimation();
        if (bVar.fzA == null) {
            return;
        }
        bVar.fzA.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView aVs;
        private TextView fqb;
        private HeadImageView fqd;
        private TextView fqj;
        private TextView fyb;
        private AnimatorSet fzA;
        private View fzB;
        private TextView fzC;
        private TextView fzD;
        private View fzx;
        private TbImageView fzy;
        private LottieAnimationView fzz;

        public b() {
        }

        public void recycle() {
            buE();
        }

        public void buE() {
            m.this.b(this);
        }
    }
}
