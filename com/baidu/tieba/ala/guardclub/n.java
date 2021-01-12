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
/* loaded from: classes10.dex */
public class n extends BaseAdapter {
    private String bab;
    private List<com.baidu.tieba.ala.guardclub.model.k> bbl;
    private a gXo;
    private int gXp;
    private float gXq;
    private float gXr;
    private int gXs;
    private int mType;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.gXq = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.gXr = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gXs = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gXs = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void eQ(String str) {
        this.bab = str;
    }

    public void a(a aVar) {
        this.gXo = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bbl;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bbl == null) {
            this.bbl = new ArrayList();
        }
        this.bbl.clear();
        cA(list);
    }

    public void cA(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bbl == null) {
            this.bbl = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bbl.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbl != null) {
            return this.bbl.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uv */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bbl.get(i);
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
            bVar2.gML = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.gXv = view.findViewById(a.f.layout_avatar);
            bVar2.gMN = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.gXw = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gMN, bVar2.gXw);
            bVar2.gXx = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aBZ = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gWc = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gMU = (TextView) view.findViewById(a.f.tv_content);
            bVar2.gXz = view.findViewById(a.f.layout_action);
            bVar2.gXA = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.gXB = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gML.setText("99+");
            bVar.gML.setTextSize(0, this.gXr);
            return;
        }
        bVar.gML.setText(String.valueOf(i + 4));
        bVar.gML.setTextSize(0, this.gXq);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gMN.stopLoad();
        bVar.gMN.startLoad(kVar.avatar, 12, false, false);
        bVar.gXw.stopLoad();
        b(bVar);
        bVar.gMN.setScaleX(1.0f);
        bVar.gMN.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gXx.setVisibility(8);
        } else {
            bVar.gXx.setVisibility(0);
            a(bVar);
        }
        String dn = com.baidu.live.guardclub.g.HD().dn(kVar.level);
        if (!TextUtils.isEmpty(dn)) {
            bVar.gXw.startLoad(dn, 10, false);
            bVar.gXw.setVisibility(0);
        } else {
            bVar.gXw.setVisibility(8);
        }
        bVar.gXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gXo != null) {
                    n.this.gXo.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gXp <= 0) {
            this.gXp = bVar.gWc.getWidth();
            if (this.gXp <= 0) {
                bVar.gWc.measure(0, 0);
                this.gXp = bVar.gWc.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aBZ.setPadding(0, 0, this.gXp, 0);
            bVar.gWc.setVisibility(0);
        } else {
            bVar.aBZ.setPadding(0, 0, 0, 0);
            bVar.gWc.setVisibility(4);
        }
        bVar.aBZ.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gXZ;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gMU.setText(String.format(context.getResources().getString(this.gXs), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.bab) || TextUtils.isEmpty(kVar.aHi) || !this.bab.equals(kVar.aHi)) {
            bVar.gXz.setVisibility(0);
            if (kVar.gYa) {
                bVar.gXB.setVisibility(0);
                bVar.gXA.setVisibility(8);
                return;
            }
            bVar.gXB.setVisibility(8);
            bVar.gXA.setVisibility(0);
            bVar.gXA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.gXo != null) {
                        n.this.gXo.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gXz.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gXy == null) {
            bVar.gXy = new AnimatorSet();
        }
        bVar.gXx.setAnimation("live_anim_guard_join.json");
        bVar.gXx.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gMN, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gMN, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gXy.setDuration(1000L);
        bVar.gXy.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gXy.play(ofFloat).with(ofFloat2);
        bVar.gXx.playAnimation();
        bVar.gXy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gXx.cancelAnimation();
        if (bVar.gXy == null) {
            return;
        }
        bVar.gXy.cancel();
    }

    /* loaded from: classes10.dex */
    public class b {
        private TextView aBZ;
        private TextView gML;
        private HeadImageView gMN;
        private TextView gMU;
        private TextView gWc;
        private TextView gXA;
        private TextView gXB;
        private View gXv;
        private TbImageView gXw;
        private LottieAnimationView gXx;
        private AnimatorSet gXy;
        private View gXz;

        public b() {
        }

        public void recycle() {
            VN();
        }

        public void VN() {
            n.this.b(this);
        }
    }
}
