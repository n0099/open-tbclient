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
    private String faJ;
    private int flA;
    private float flB;
    private float flC;
    private int flD;
    private a fly;
    private List<com.baidu.tieba.ala.guardclub.model.k> flz;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.flB = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.flC = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.flD = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.flD = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void Ai(String str) {
        this.faJ = str;
    }

    public void a(a aVar) {
        this.fly = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.flz;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.flz == null) {
            this.flz = new ArrayList();
        }
        this.flz.clear();
        bF(list);
    }

    public void bF(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.flz == null) {
            this.flz = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.flz.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.flz != null) {
            return this.flz.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pO */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.flz.get(i);
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
            bVar2.fcn = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.flG = view.findViewById(a.g.layout_avatar);
            bVar2.fcp = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.flH = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fcp, bVar2.flH);
            bVar2.flI = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aPj = (TextView) view.findViewById(a.g.tv_name);
            bVar2.fkk = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fcv = (TextView) view.findViewById(a.g.tv_content);
            bVar2.flK = view.findViewById(a.g.layout_action);
            bVar2.flL = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.flM = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.fcn.setText("99+");
            bVar.fcn.setTextSize(0, this.flC);
            return;
        }
        bVar.fcn.setText(String.valueOf(i + 4));
        bVar.fcn.setTextSize(0, this.flB);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fcp.stopLoad();
        bVar.fcp.startLoad(kVar.avatar, 12, false, false);
        bVar.flH.stopLoad();
        b(bVar);
        bVar.fcp.setScaleX(1.0f);
        bVar.fcp.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.flI.setVisibility(8);
        } else {
            bVar.flI.setVisibility(0);
            a(bVar);
        }
        String ci = com.baidu.live.guardclub.g.Ar().ci(kVar.level);
        if (!TextUtils.isEmpty(ci)) {
            bVar.flH.startLoad(ci, 10, false);
            bVar.flH.setVisibility(0);
        } else {
            bVar.flH.setVisibility(8);
        }
        bVar.flG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fly != null) {
                    m.this.fly.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.flA <= 0) {
            this.flA = bVar.fkk.getWidth();
            if (this.flA <= 0) {
                bVar.fkk.measure(0, 0);
                this.flA = bVar.fkk.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aPj.setPadding(0, 0, this.flA, 0);
            bVar.fkk.setVisibility(0);
        } else {
            bVar.aPj.setPadding(0, 0, 0, 0);
            bVar.fkk.setVisibility(4);
        }
        bVar.aPj.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.fml;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fcv.setText(String.format(context.getResources().getString(this.flD), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.faJ) || TextUtils.isEmpty(kVar.awj) || !this.faJ.equals(kVar.awj)) {
            bVar.flK.setVisibility(0);
            if (kVar.fmm) {
                bVar.flM.setVisibility(0);
                bVar.flL.setVisibility(8);
                return;
            }
            bVar.flM.setVisibility(8);
            bVar.flL.setVisibility(0);
            bVar.flL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.fly != null) {
                        m.this.fly.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.flK.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.flJ == null) {
            bVar.flJ = new AnimatorSet();
        }
        bVar.flI.setAnimation("live_anim_guard_join.json");
        bVar.flI.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fcp, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fcp, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.flJ.setDuration(1000L);
        bVar.flJ.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.flJ.play(ofFloat).with(ofFloat2);
        bVar.flI.playAnimation();
        bVar.flJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.flI.cancelAnimation();
        if (bVar.flJ == null) {
            return;
        }
        bVar.flJ.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView aPj;
        private TextView fcn;
        private HeadImageView fcp;
        private TextView fcv;
        private TextView fkk;
        private View flG;
        private TbImageView flH;
        private LottieAnimationView flI;
        private AnimatorSet flJ;
        private View flK;
        private TextView flL;
        private TextView flM;

        public b() {
        }

        public void recycle() {
            boK();
        }

        public void boK() {
            m.this.b(this);
        }
    }
}
