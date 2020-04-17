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
    private String faE;
    private a flt;
    private List<com.baidu.tieba.ala.guardclub.model.k> flu;
    private int flv;
    private float flw;
    private float flx;
    private int fly;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.flw = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.flx = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.fly = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.fly = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void Af(String str) {
        this.faE = str;
    }

    public void a(a aVar) {
        this.flt = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.flu;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.flu == null) {
            this.flu = new ArrayList();
        }
        this.flu.clear();
        bF(list);
    }

    public void bF(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.flu == null) {
            this.flu = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.flu.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.flu != null) {
            return this.flu.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pO */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.flu.get(i);
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
            bVar2.fci = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.flB = view.findViewById(a.g.layout_avatar);
            bVar2.fck = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.flC = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fck, bVar2.flC);
            bVar2.flD = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aPd = (TextView) view.findViewById(a.g.tv_name);
            bVar2.fkf = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fcq = (TextView) view.findViewById(a.g.tv_content);
            bVar2.flF = view.findViewById(a.g.layout_action);
            bVar2.flG = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.flH = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.fci.setText("99+");
            bVar.fci.setTextSize(0, this.flx);
            return;
        }
        bVar.fci.setText(String.valueOf(i + 4));
        bVar.fci.setTextSize(0, this.flw);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fck.stopLoad();
        bVar.fck.startLoad(kVar.avatar, 12, false, false);
        bVar.flC.stopLoad();
        b(bVar);
        bVar.fck.setScaleX(1.0f);
        bVar.fck.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.flD.setVisibility(8);
        } else {
            bVar.flD.setVisibility(0);
            a(bVar);
        }
        String ci = com.baidu.live.guardclub.g.As().ci(kVar.level);
        if (!TextUtils.isEmpty(ci)) {
            bVar.flC.startLoad(ci, 10, false);
            bVar.flC.setVisibility(0);
        } else {
            bVar.flC.setVisibility(8);
        }
        bVar.flB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.flt != null) {
                    m.this.flt.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.flv <= 0) {
            this.flv = bVar.fkf.getWidth();
            if (this.flv <= 0) {
                bVar.fkf.measure(0, 0);
                this.flv = bVar.fkf.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aPd.setPadding(0, 0, this.flv, 0);
            bVar.fkf.setVisibility(0);
        } else {
            bVar.aPd.setPadding(0, 0, 0, 0);
            bVar.fkf.setVisibility(4);
        }
        bVar.aPd.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.fmg;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fcq.setText(String.format(context.getResources().getString(this.fly), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.faE) || TextUtils.isEmpty(kVar.awd) || !this.faE.equals(kVar.awd)) {
            bVar.flF.setVisibility(0);
            if (kVar.fmh) {
                bVar.flH.setVisibility(0);
                bVar.flG.setVisibility(8);
                return;
            }
            bVar.flH.setVisibility(8);
            bVar.flG.setVisibility(0);
            bVar.flG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.flt != null) {
                        m.this.flt.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.flF.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.flE == null) {
            bVar.flE = new AnimatorSet();
        }
        bVar.flD.setAnimation("live_anim_guard_join.json");
        bVar.flD.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fck, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fck, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.flE.setDuration(1000L);
        bVar.flE.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.flE.play(ofFloat).with(ofFloat2);
        bVar.flD.playAnimation();
        bVar.flE.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.flD.cancelAnimation();
        if (bVar.flE == null) {
            return;
        }
        bVar.flE.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView aPd;
        private TextView fci;
        private HeadImageView fck;
        private TextView fcq;
        private TextView fkf;
        private View flB;
        private TbImageView flC;
        private LottieAnimationView flD;
        private AnimatorSet flE;
        private View flF;
        private TextView flG;
        private TextView flH;

        public b() {
        }

        public void recycle() {
            boM();
        }

        public void boM() {
            m.this.b(this);
        }
    }
}
