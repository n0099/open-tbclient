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
public class n extends BaseAdapter {
    private String bdg;
    private List<com.baidu.tieba.ala.guardclub.model.k> bep;
    private a gQf;
    private int gQg;
    private float gQh;
    private float gQi;
    private int gQj;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.gQh = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.gQi = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gQj = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gQj = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void gr(String str) {
        this.bdg = str;
    }

    public void a(a aVar) {
        this.gQf = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bep;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bep == null) {
            this.bep = new ArrayList();
        }
        this.bep.clear();
        ct(list);
    }

    public void ct(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bep == null) {
            this.bep = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bep.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bep != null) {
            return this.bep.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vQ */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bep.get(i);
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
            bVar2.gFE = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.gQm = view.findViewById(a.f.layout_avatar);
            bVar2.gFG = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.gQn = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gFG, bVar2.gQn);
            bVar2.gQo = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aGv = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gOT = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gFN = (TextView) view.findViewById(a.f.tv_content);
            bVar2.gQq = view.findViewById(a.f.layout_action);
            bVar2.gQr = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.gQs = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gFE.setText("99+");
            bVar.gFE.setTextSize(0, this.gQi);
            return;
        }
        bVar.gFE.setText(String.valueOf(i + 4));
        bVar.gFE.setTextSize(0, this.gQh);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gFG.stopLoad();
        bVar.gFG.startLoad(kVar.avatar, 12, false, false);
        bVar.gQn.stopLoad();
        b(bVar);
        bVar.gFG.setScaleX(1.0f);
        bVar.gFG.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gQo.setVisibility(8);
        } else {
            bVar.gQo.setVisibility(0);
            a(bVar);
        }
        String eV = com.baidu.live.guardclub.g.LZ().eV(kVar.level);
        if (!TextUtils.isEmpty(eV)) {
            bVar.gQn.startLoad(eV, 10, false);
            bVar.gQn.setVisibility(0);
        } else {
            bVar.gQn.setVisibility(8);
        }
        bVar.gQm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gQf != null) {
                    n.this.gQf.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gQg <= 0) {
            this.gQg = bVar.gOT.getWidth();
            if (this.gQg <= 0) {
                bVar.gOT.measure(0, 0);
                this.gQg = bVar.gOT.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aGv.setPadding(0, 0, this.gQg, 0);
            bVar.gOT.setVisibility(0);
        } else {
            bVar.aGv.setPadding(0, 0, 0, 0);
            bVar.gOT.setVisibility(4);
        }
        bVar.aGv.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gQQ;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gFN.setText(String.format(context.getResources().getString(this.gQj), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.bdg) || TextUtils.isEmpty(kVar.aRO) || !this.bdg.equals(kVar.aRO)) {
            bVar.gQq.setVisibility(0);
            if (kVar.gQR) {
                bVar.gQs.setVisibility(0);
                bVar.gQr.setVisibility(8);
                return;
            }
            bVar.gQs.setVisibility(8);
            bVar.gQr.setVisibility(0);
            bVar.gQr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.gQf != null) {
                        n.this.gQf.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gQq.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gQp == null) {
            bVar.gQp = new AnimatorSet();
        }
        bVar.gQo.setAnimation("live_anim_guard_join.json");
        bVar.gQo.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gFG, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gFG, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gQp.setDuration(1000L);
        bVar.gQp.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gQp.play(ofFloat).with(ofFloat2);
        bVar.gQo.playAnimation();
        bVar.gQp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gQo.cancelAnimation();
        if (bVar.gQp == null) {
            return;
        }
        bVar.gQp.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aGv;
        private TextView gFE;
        private HeadImageView gFG;
        private TextView gFN;
        private TextView gOT;
        private View gQm;
        private TbImageView gQn;
        private LottieAnimationView gQo;
        private AnimatorSet gQp;
        private View gQq;
        private TextView gQr;
        private TextView gQs;

        public b() {
        }

        public void recycle() {
            Yv();
        }

        public void Yv() {
            n.this.b(this);
        }
    }
}
