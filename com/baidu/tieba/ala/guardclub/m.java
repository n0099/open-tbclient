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
    private a eGY;
    private String eGZ;
    private List<com.baidu.tieba.ala.guardclub.model.k> eHa;
    private int eHb;
    private float eHc;
    private float eHd;
    private int eHe;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.eHc = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.eHd = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.eHe = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.eHe = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void yx(String str) {
        this.eGZ = str;
    }

    public void a(a aVar) {
        this.eGY = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.eHa;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eHa == null) {
            this.eHa = new ArrayList();
        }
        this.eHa.clear();
        bw(list);
    }

    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eHa == null) {
            this.eHa = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.eHa.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHa != null) {
            return this.eHa.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pu */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.eHa.get(i);
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
            bVar2.eHh = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.eHi = view.findViewById(a.g.layout_avatar);
            bVar2.eHj = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.eHk = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.eHj, bVar2.eHk);
            bVar2.eHl = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.avA = (TextView) view.findViewById(a.g.tv_name);
            bVar2.eFK = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.eHn = (TextView) view.findViewById(a.g.tv_content);
            bVar2.eHo = view.findViewById(a.g.layout_action);
            bVar2.eHp = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.eHq = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.eHh.setText("99+");
            bVar.eHh.setTextSize(0, this.eHd);
            return;
        }
        bVar.eHh.setText(String.valueOf(i + 4));
        bVar.eHh.setTextSize(0, this.eHc);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.eHj.stopLoad();
        bVar.eHj.startLoad(kVar.avatar, 12, false, false);
        bVar.eHk.stopLoad();
        b(bVar);
        bVar.eHj.setScaleX(1.0f);
        bVar.eHj.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.eHl.setVisibility(8);
        } else {
            bVar.eHl.setVisibility(0);
            a(bVar);
        }
        String bT = com.baidu.live.guardclub.g.vM().bT(kVar.level);
        if (!TextUtils.isEmpty(bT)) {
            bVar.eHk.startLoad(bT, 10, false);
            bVar.eHk.setVisibility(0);
        } else {
            bVar.eHk.setVisibility(8);
        }
        bVar.eHi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eGY != null) {
                    m.this.eGY.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.eHb <= 0) {
            this.eHb = bVar.eFK.getWidth();
            if (this.eHb <= 0) {
                bVar.eFK.measure(0, 0);
                this.eHb = bVar.eFK.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.avA.setPadding(0, 0, this.eHb, 0);
            bVar.eFK.setVisibility(0);
        } else {
            bVar.avA.setPadding(0, 0, 0, 0);
            bVar.eFK.setVisibility(4);
        }
        bVar.avA.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.eHP;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.eHn.setText(String.format(context.getResources().getString(this.eHe), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.eGZ) || TextUtils.isEmpty(kVar.adM) || !this.eGZ.equals(kVar.adM)) {
            bVar.eHo.setVisibility(0);
            if (kVar.eHQ) {
                bVar.eHq.setVisibility(0);
                bVar.eHp.setVisibility(8);
                return;
            }
            bVar.eHq.setVisibility(8);
            bVar.eHp.setVisibility(0);
            bVar.eHp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.eGY != null) {
                        m.this.eGY.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.eHo.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.eHm == null) {
            bVar.eHm = new AnimatorSet();
        }
        bVar.eHl.setAnimation("live_anim_guard_join.json");
        bVar.eHl.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.eHj, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.eHj, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.eHm.setDuration(1000L);
        bVar.eHm.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.eHm.play(ofFloat).with(ofFloat2);
        bVar.eHl.playAnimation();
        bVar.eHm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.eHl.cancelAnimation();
        if (bVar.eHm == null) {
            return;
        }
        bVar.eHm.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView avA;
        private TextView eFK;
        private TextView eHh;
        private View eHi;
        private HeadImageView eHj;
        private TbImageView eHk;
        private LottieAnimationView eHl;
        private AnimatorSet eHm;
        private TextView eHn;
        private View eHo;
        private TextView eHp;
        private TextView eHq;

        public b() {
        }

        public void recycle() {
            bfv();
        }

        public void bfv() {
            m.this.b(this);
        }
    }
}
