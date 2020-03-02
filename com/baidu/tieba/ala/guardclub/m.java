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
    private a eGp;
    private String eGq;
    private List<com.baidu.tieba.ala.guardclub.model.k> eGr;
    private int eGs;
    private float eGt;
    private float eGu;
    private int eGv;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.eGt = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.eGu = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.eGv = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.eGv = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void yv(String str) {
        this.eGq = str;
    }

    public void a(a aVar) {
        this.eGp = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.eGr;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eGr == null) {
            this.eGr = new ArrayList();
        }
        this.eGr.clear();
        bw(list);
    }

    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eGr == null) {
            this.eGr = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.eGr.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGr != null) {
            return this.eGr.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ps */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.eGr.get(i);
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
            bVar2.eGy = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.eGz = view.findViewById(a.g.layout_avatar);
            bVar2.eGA = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.eGB = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.eGA, bVar2.eGB);
            bVar2.eGC = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.avp = (TextView) view.findViewById(a.g.tv_name);
            bVar2.eFb = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.eGE = (TextView) view.findViewById(a.g.tv_content);
            bVar2.eGF = view.findViewById(a.g.layout_action);
            bVar2.eGG = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.eGH = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.eGy.setText("99+");
            bVar.eGy.setTextSize(0, this.eGu);
            return;
        }
        bVar.eGy.setText(String.valueOf(i + 4));
        bVar.eGy.setTextSize(0, this.eGt);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.eGA.stopLoad();
        bVar.eGA.startLoad(kVar.avatar, 12, false, false);
        bVar.eGB.stopLoad();
        b(bVar);
        bVar.eGA.setScaleX(1.0f);
        bVar.eGA.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.eGC.setVisibility(8);
        } else {
            bVar.eGC.setVisibility(0);
            a(bVar);
        }
        String bT = com.baidu.live.guardclub.g.vH().bT(kVar.level);
        if (!TextUtils.isEmpty(bT)) {
            bVar.eGB.startLoad(bT, 10, false);
            bVar.eGB.setVisibility(0);
        } else {
            bVar.eGB.setVisibility(8);
        }
        bVar.eGz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eGp != null) {
                    m.this.eGp.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.eGs <= 0) {
            this.eGs = bVar.eFb.getWidth();
            if (this.eGs <= 0) {
                bVar.eFb.measure(0, 0);
                this.eGs = bVar.eFb.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.avp.setPadding(0, 0, this.eGs, 0);
            bVar.eFb.setVisibility(0);
        } else {
            bVar.avp.setPadding(0, 0, 0, 0);
            bVar.eFb.setVisibility(4);
        }
        bVar.avp.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.eHg;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.eGE.setText(String.format(context.getResources().getString(this.eGv), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.eGq) || TextUtils.isEmpty(kVar.adC) || !this.eGq.equals(kVar.adC)) {
            bVar.eGF.setVisibility(0);
            if (kVar.eHh) {
                bVar.eGH.setVisibility(0);
                bVar.eGG.setVisibility(8);
                return;
            }
            bVar.eGH.setVisibility(8);
            bVar.eGG.setVisibility(0);
            bVar.eGG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.eGp != null) {
                        m.this.eGp.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.eGF.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.eGD == null) {
            bVar.eGD = new AnimatorSet();
        }
        bVar.eGC.setAnimation("live_anim_guard_join.json");
        bVar.eGC.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.eGA, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.eGA, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.eGD.setDuration(1000L);
        bVar.eGD.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.eGD.play(ofFloat).with(ofFloat2);
        bVar.eGC.playAnimation();
        bVar.eGD.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.eGC.cancelAnimation();
        if (bVar.eGD == null) {
            return;
        }
        bVar.eGD.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView avp;
        private TextView eFb;
        private HeadImageView eGA;
        private TbImageView eGB;
        private LottieAnimationView eGC;
        private AnimatorSet eGD;
        private TextView eGE;
        private View eGF;
        private TextView eGG;
        private TextView eGH;
        private TextView eGy;
        private View eGz;

        public b() {
        }

        public void recycle() {
            bfp();
        }

        public void bfp() {
            m.this.b(this);
        }
    }
}
