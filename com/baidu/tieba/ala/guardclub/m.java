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
    private String bbs;
    private List<com.baidu.tieba.ala.guardclub.model.k> bsU;
    private a gHr;
    private int gHs;
    private float gHt;
    private float gHu;
    private int gHv;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.gHt = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.gHu = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gHv = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gHv = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void gc(String str) {
        this.bbs = str;
    }

    public void a(a aVar) {
        this.gHr = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bsU;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bsU == null) {
            this.bsU = new ArrayList();
        }
        this.bsU.clear();
        cp(list);
    }

    public void cp(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bsU == null) {
            this.bsU = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bsU.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bsU != null) {
            return this.bsU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uL */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bsU.get(i);
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
            bVar2.gxm = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.gHy = view.findViewById(a.f.layout_avatar);
            bVar2.gxo = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.gHz = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gxo, bVar2.gHz);
            bVar2.gHA = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aFA = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gGf = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gxt = (TextView) view.findViewById(a.f.tv_content);
            bVar2.gHC = view.findViewById(a.f.layout_action);
            bVar2.gHD = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.gHE = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gxm.setText("99+");
            bVar.gxm.setTextSize(0, this.gHu);
            return;
        }
        bVar.gxm.setText(String.valueOf(i + 4));
        bVar.gxm.setTextSize(0, this.gHt);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gxo.stopLoad();
        bVar.gxo.startLoad(kVar.avatar, 12, false, false);
        bVar.gHz.stopLoad();
        b(bVar);
        bVar.gxo.setScaleX(1.0f);
        bVar.gxo.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gHA.setVisibility(8);
        } else {
            bVar.gHA.setVisibility(0);
            a(bVar);
        }
        String eD = com.baidu.live.guardclub.g.KF().eD(kVar.level);
        if (!TextUtils.isEmpty(eD)) {
            bVar.gHz.startLoad(eD, 10, false);
            bVar.gHz.setVisibility(0);
        } else {
            bVar.gHz.setVisibility(8);
        }
        bVar.gHy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gHr != null) {
                    m.this.gHr.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gHs <= 0) {
            this.gHs = bVar.gGf.getWidth();
            if (this.gHs <= 0) {
                bVar.gGf.measure(0, 0);
                this.gHs = bVar.gGf.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aFA.setPadding(0, 0, this.gHs, 0);
            bVar.gGf.setVisibility(0);
        } else {
            bVar.aFA.setPadding(0, 0, 0, 0);
            bVar.gGf.setVisibility(4);
        }
        bVar.aFA.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gIc;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gxt.setText(String.format(context.getResources().getString(this.gHv), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.bbs) || TextUtils.isEmpty(kVar.aQx) || !this.bbs.equals(kVar.aQx)) {
            bVar.gHC.setVisibility(0);
            if (kVar.gId) {
                bVar.gHE.setVisibility(0);
                bVar.gHD.setVisibility(8);
                return;
            }
            bVar.gHE.setVisibility(8);
            bVar.gHD.setVisibility(0);
            bVar.gHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.gHr != null) {
                        m.this.gHr.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gHC.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gHB == null) {
            bVar.gHB = new AnimatorSet();
        }
        bVar.gHA.setAnimation("live_anim_guard_join.json");
        bVar.gHA.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gxo, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gxo, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gHB.setDuration(1000L);
        bVar.gHB.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gHB.play(ofFloat).with(ofFloat2);
        bVar.gHA.playAnimation();
        bVar.gHB.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gHA.cancelAnimation();
        if (bVar.gHB == null) {
            return;
        }
        bVar.gHB.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aFA;
        private TextView gGf;
        private LottieAnimationView gHA;
        private AnimatorSet gHB;
        private View gHC;
        private TextView gHD;
        private TextView gHE;
        private View gHy;
        private TbImageView gHz;
        private TextView gxm;
        private HeadImageView gxo;
        private TextView gxt;

        public b() {
        }

        public void recycle() {
            WE();
        }

        public void WE() {
            m.this.b(this);
        }
    }
}
