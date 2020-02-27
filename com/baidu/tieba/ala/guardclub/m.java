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
    private a eGo;
    private String eGp;
    private List<com.baidu.tieba.ala.guardclub.model.k> eGq;
    private int eGr;
    private float eGs;
    private float eGt;
    private int eGu;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.eGs = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.eGt = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.eGu = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.eGu = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void yv(String str) {
        this.eGp = str;
    }

    public void a(a aVar) {
        this.eGo = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.eGq;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eGq == null) {
            this.eGq = new ArrayList();
        }
        this.eGq.clear();
        bw(list);
    }

    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eGq == null) {
            this.eGq = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.eGq.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGq != null) {
            return this.eGq.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ps */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.eGq.get(i);
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
            bVar2.eGx = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.eGy = view.findViewById(a.g.layout_avatar);
            bVar2.eGz = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.eGA = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.eGz, bVar2.eGA);
            bVar2.eGB = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.avp = (TextView) view.findViewById(a.g.tv_name);
            bVar2.eFa = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.eGD = (TextView) view.findViewById(a.g.tv_content);
            bVar2.eGE = view.findViewById(a.g.layout_action);
            bVar2.eGF = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.eGG = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.eGx.setText("99+");
            bVar.eGx.setTextSize(0, this.eGt);
            return;
        }
        bVar.eGx.setText(String.valueOf(i + 4));
        bVar.eGx.setTextSize(0, this.eGs);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.eGz.stopLoad();
        bVar.eGz.startLoad(kVar.avatar, 12, false, false);
        bVar.eGA.stopLoad();
        b(bVar);
        bVar.eGz.setScaleX(1.0f);
        bVar.eGz.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.eGB.setVisibility(8);
        } else {
            bVar.eGB.setVisibility(0);
            a(bVar);
        }
        String bT = com.baidu.live.guardclub.g.vH().bT(kVar.level);
        if (!TextUtils.isEmpty(bT)) {
            bVar.eGA.startLoad(bT, 10, false);
            bVar.eGA.setVisibility(0);
        } else {
            bVar.eGA.setVisibility(8);
        }
        bVar.eGy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eGo != null) {
                    m.this.eGo.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.eGr <= 0) {
            this.eGr = bVar.eFa.getWidth();
            if (this.eGr <= 0) {
                bVar.eFa.measure(0, 0);
                this.eGr = bVar.eFa.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.avp.setPadding(0, 0, this.eGr, 0);
            bVar.eFa.setVisibility(0);
        } else {
            bVar.avp.setPadding(0, 0, 0, 0);
            bVar.eFa.setVisibility(4);
        }
        bVar.avp.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.eHf;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.eGD.setText(String.format(context.getResources().getString(this.eGu), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.eGp) || TextUtils.isEmpty(kVar.adC) || !this.eGp.equals(kVar.adC)) {
            bVar.eGE.setVisibility(0);
            if (kVar.eHg) {
                bVar.eGG.setVisibility(0);
                bVar.eGF.setVisibility(8);
                return;
            }
            bVar.eGG.setVisibility(8);
            bVar.eGF.setVisibility(0);
            bVar.eGF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.eGo != null) {
                        m.this.eGo.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.eGE.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.eGC == null) {
            bVar.eGC = new AnimatorSet();
        }
        bVar.eGB.setAnimation("live_anim_guard_join.json");
        bVar.eGB.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.eGz, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.eGz, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.eGC.setDuration(1000L);
        bVar.eGC.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.eGC.play(ofFloat).with(ofFloat2);
        bVar.eGB.playAnimation();
        bVar.eGC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.eGB.cancelAnimation();
        if (bVar.eGC == null) {
            return;
        }
        bVar.eGC.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView avp;
        private TextView eFa;
        private TbImageView eGA;
        private LottieAnimationView eGB;
        private AnimatorSet eGC;
        private TextView eGD;
        private View eGE;
        private TextView eGF;
        private TextView eGG;
        private TextView eGx;
        private View eGy;
        private HeadImageView eGz;

        public b() {
        }

        public void recycle() {
            bfn();
        }

        public void bfn() {
            m.this.b(this);
        }
    }
}
