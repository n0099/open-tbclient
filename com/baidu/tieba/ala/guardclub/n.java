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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class n extends BaseAdapter {
    private String bdi;
    private List<com.baidu.tieba.ala.guardclub.model.k> ber;
    private a ham;
    private int han;
    private float hao;
    private float hap;
    private int haq;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.hao = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.hap = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.haq = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.haq = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fi(String str) {
        this.bdi = str;
    }

    public void a(a aVar) {
        this.ham = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.ber;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        this.ber.clear();
        cv(list);
    }

    public void cv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.ber.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ber != null) {
            return this.ber.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uB */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.ber.get(i);
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.live_guard_club_rank_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.gPF = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.hat = view.findViewById(a.f.layout_avatar);
            bVar2.gPH = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.hau = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gPH, bVar2.hau);
            bVar2.hav = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aDM = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gZa = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gPO = (TextView) view.findViewById(a.f.tv_content);
            bVar2.hax = view.findViewById(a.f.layout_action);
            bVar2.hay = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.haz = (TextView) view.findViewById(a.f.tv_joined);
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
        headImageView.setDefaultBgResource(a.e.sdk_default_avatar);
        tbImageView.setDefaultBgResource(a.c.sdk_transparent);
        tbImageView.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }

    private void a(b bVar, int i) {
        if (i + 4 >= 100) {
            bVar.gPF.setText("99+");
            bVar.gPF.setTextSize(0, this.hap);
            return;
        }
        bVar.gPF.setText(String.valueOf(i + 4));
        bVar.gPF.setTextSize(0, this.hao);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gPH.stopLoad();
        bVar.gPH.startLoad(kVar.avatar, 12, false, false);
        bVar.hau.stopLoad();
        b(bVar);
        bVar.gPH.setScaleX(1.0f);
        bVar.gPH.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.hav.setVisibility(8);
        } else {
            bVar.hav.setVisibility(0);
            a(bVar);
        }
        String ds = com.baidu.live.guardclub.g.IT().ds(kVar.level);
        if (!TextUtils.isEmpty(ds)) {
            bVar.hau.startLoad(ds, 10, false);
            bVar.hau.setVisibility(0);
        } else {
            bVar.hau.setVisibility(8);
        }
        bVar.hat.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.ham != null) {
                    n.this.ham.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.han <= 0) {
            this.han = bVar.gZa.getWidth();
            if (this.han <= 0) {
                bVar.gZa.measure(0, 0);
                this.han = bVar.gZa.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aDM.setPadding(0, 0, this.han, 0);
            bVar.gZa.setVisibility(0);
        } else {
            bVar.aDM.setPadding(0, 0, 0, 0);
            bVar.gZa.setVisibility(4);
        }
        bVar.aDM.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.haX;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gPO.setText(String.format(context.getResources().getString(this.haq), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.bdi) || TextUtils.isEmpty(kVar.aJM) || !this.bdi.equals(kVar.aJM)) {
            bVar.hax.setVisibility(0);
            if (kVar.haY) {
                bVar.haz.setVisibility(0);
                bVar.hay.setVisibility(8);
                return;
            }
            bVar.haz.setVisibility(8);
            bVar.hay.setVisibility(0);
            bVar.hay.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.ham != null) {
                        n.this.ham.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.hax.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.haw == null) {
            bVar.haw = new AnimatorSet();
        }
        bVar.hav.setAnimation("live_anim_guard_join.json");
        bVar.hav.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gPH, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gPH, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.haw.setDuration(1000L);
        bVar.haw.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.haw.play(ofFloat).with(ofFloat2);
        bVar.hav.playAnimation();
        bVar.haw.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.hav.cancelAnimation();
        if (bVar.haw == null) {
            return;
        }
        bVar.haw.cancel();
    }

    /* loaded from: classes11.dex */
    public class b {
        private TextView aDM;
        private TextView gPF;
        private HeadImageView gPH;
        private TextView gPO;
        private TextView gZa;
        private View hat;
        private TbImageView hau;
        private LottieAnimationView hav;
        private AnimatorSet haw;
        private View hax;
        private TextView hay;
        private TextView haz;

        public b() {
        }

        public void recycle() {
            Xw();
        }

        public void Xw() {
            n.this.b(this);
        }
    }
}
