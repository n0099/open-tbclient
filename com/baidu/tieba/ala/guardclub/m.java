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
    private String fol;
    private a fze;
    private List<com.baidu.tieba.ala.guardclub.model.k> fzf;
    private int fzg;
    private float fzh;
    private float fzi;
    private int fzj;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.fzh = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.fzi = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.fzj = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.fzj = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void BP(String str) {
        this.fol = str;
    }

    public void a(a aVar) {
        this.fze = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.fzf;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fzf == null) {
            this.fzf = new ArrayList();
        }
        this.fzf.clear();
        bC(list);
    }

    public void bC(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fzf == null) {
            this.fzf = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.fzf.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fzf != null) {
            return this.fzf.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qp */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.fzf.get(i);
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
            bVar2.fpQ = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.fzm = view.findViewById(a.g.layout_avatar);
            bVar2.fpS = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.fzn = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fpS, bVar2.fzn);
            bVar2.fzo = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aVs = (TextView) view.findViewById(a.g.tv_name);
            bVar2.fxQ = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fpY = (TextView) view.findViewById(a.g.tv_content);
            bVar2.fzq = view.findViewById(a.g.layout_action);
            bVar2.fzr = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.fzs = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.fpQ.setText("99+");
            bVar.fpQ.setTextSize(0, this.fzi);
            return;
        }
        bVar.fpQ.setText(String.valueOf(i + 4));
        bVar.fpQ.setTextSize(0, this.fzh);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fpS.stopLoad();
        bVar.fpS.startLoad(kVar.avatar, 12, false, false);
        bVar.fzn.stopLoad();
        b(bVar);
        bVar.fpS.setScaleX(1.0f);
        bVar.fpS.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.fzo.setVisibility(8);
        } else {
            bVar.fzo.setVisibility(0);
            a(bVar);
        }
        String cp = com.baidu.live.guardclub.g.BH().cp(kVar.level);
        if (!TextUtils.isEmpty(cp)) {
            bVar.fzn.startLoad(cp, 10, false);
            bVar.fzn.setVisibility(0);
        } else {
            bVar.fzn.setVisibility(8);
        }
        bVar.fzm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fze != null) {
                    m.this.fze.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.fzg <= 0) {
            this.fzg = bVar.fxQ.getWidth();
            if (this.fzg <= 0) {
                bVar.fxQ.measure(0, 0);
                this.fzg = bVar.fxQ.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aVs.setPadding(0, 0, this.fzg, 0);
            bVar.fxQ.setVisibility(0);
        } else {
            bVar.aVs.setPadding(0, 0, 0, 0);
            bVar.fxQ.setVisibility(4);
        }
        bVar.aVs.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.fzS;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fpY.setText(String.format(context.getResources().getString(this.fzj), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.fol) || TextUtils.isEmpty(kVar.aBs) || !this.fol.equals(kVar.aBs)) {
            bVar.fzq.setVisibility(0);
            if (kVar.fzT) {
                bVar.fzs.setVisibility(0);
                bVar.fzr.setVisibility(8);
                return;
            }
            bVar.fzs.setVisibility(8);
            bVar.fzr.setVisibility(0);
            bVar.fzr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.fze != null) {
                        m.this.fze.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.fzq.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.fzp == null) {
            bVar.fzp = new AnimatorSet();
        }
        bVar.fzo.setAnimation("live_anim_guard_join.json");
        bVar.fzo.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fpS, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fpS, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.fzp.setDuration(1000L);
        bVar.fzp.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.fzp.play(ofFloat).with(ofFloat2);
        bVar.fzo.playAnimation();
        bVar.fzp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.fzo.cancelAnimation();
        if (bVar.fzp == null) {
            return;
        }
        bVar.fzp.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView aVs;
        private TextView fpQ;
        private HeadImageView fpS;
        private TextView fpY;
        private TextView fxQ;
        private View fzm;
        private TbImageView fzn;
        private LottieAnimationView fzo;
        private AnimatorSet fzp;
        private View fzq;
        private TextView fzr;
        private TextView fzs;

        public b() {
        }

        public void recycle() {
            buC();
        }

        public void buC() {
            m.this.b(this);
        }
    }
}
