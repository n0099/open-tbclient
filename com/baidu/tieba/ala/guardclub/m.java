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
/* loaded from: classes7.dex */
public class m extends BaseAdapter {
    private List<com.baidu.tieba.ala.guardclub.model.k> bjc;
    private String fQh;
    private a gbT;
    private int gbU;
    private float gbV;
    private float gbW;
    private int gbX;
    private int mType;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.gbV = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.gbW = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gbX = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gbX = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void Fu(String str) {
        this.fQh = str;
    }

    public void a(a aVar) {
        this.gbT = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bjc;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bjc == null) {
            this.bjc = new ArrayList();
        }
        this.bjc.clear();
        bQ(list);
    }

    public void bQ(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bjc == null) {
            this.bjc = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bjc.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bjc != null) {
            return this.bjc.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ts */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bjc.get(i);
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
            bVar2.fRN = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.gca = view.findViewById(a.g.layout_avatar);
            bVar2.fRP = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.gcb = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fRP, bVar2.gcb);
            bVar2.gcc = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aAP = (TextView) view.findViewById(a.g.tv_name);
            bVar2.gaF = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fRV = (TextView) view.findViewById(a.g.tv_content);
            bVar2.gce = view.findViewById(a.g.layout_action);
            bVar2.gcf = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.gcg = (TextView) view.findViewById(a.g.tv_joined);
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
        headImageView.setDefaultBgResource(a.f.sdk_default_avatar);
        tbImageView.setDefaultBgResource(a.d.sdk_transparent);
        tbImageView.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }

    private void a(b bVar, int i) {
        if (i + 4 >= 100) {
            bVar.fRN.setText("99+");
            bVar.fRN.setTextSize(0, this.gbW);
            return;
        }
        bVar.fRN.setText(String.valueOf(i + 4));
        bVar.fRN.setTextSize(0, this.gbV);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fRP.stopLoad();
        bVar.fRP.startLoad(kVar.avatar, 12, false, false);
        bVar.gcb.stopLoad();
        b(bVar);
        bVar.fRP.setScaleX(1.0f);
        bVar.fRP.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gcc.setVisibility(8);
        } else {
            bVar.gcc.setVisibility(0);
            a(bVar);
        }
        String et = com.baidu.live.guardclub.g.Im().et(kVar.level);
        if (!TextUtils.isEmpty(et)) {
            bVar.gcb.startLoad(et, 10, false);
            bVar.gcb.setVisibility(0);
        } else {
            bVar.gcb.setVisibility(8);
        }
        bVar.gca.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gbT != null) {
                    m.this.gbT.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gbU <= 0) {
            this.gbU = bVar.gaF.getWidth();
            if (this.gbU <= 0) {
                bVar.gaF.measure(0, 0);
                this.gbU = bVar.gaF.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aAP.setPadding(0, 0, this.gbU, 0);
            bVar.gaF.setVisibility(0);
        } else {
            bVar.aAP.setPadding(0, 0, 0, 0);
            bVar.gaF.setVisibility(4);
        }
        bVar.aAP.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gcE;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fRV.setText(String.format(context.getResources().getString(this.gbX), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.fQh) || TextUtils.isEmpty(kVar.aKh) || !this.fQh.equals(kVar.aKh)) {
            bVar.gce.setVisibility(0);
            if (kVar.gcF) {
                bVar.gcg.setVisibility(0);
                bVar.gcf.setVisibility(8);
                return;
            }
            bVar.gcg.setVisibility(8);
            bVar.gcf.setVisibility(0);
            bVar.gcf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.gbT != null) {
                        m.this.gbT.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gce.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gcd == null) {
            bVar.gcd = new AnimatorSet();
        }
        bVar.gcc.setAnimation("live_anim_guard_join.json");
        bVar.gcc.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fRP, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fRP, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gcd.setDuration(1000L);
        bVar.gcd.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gcd.play(ofFloat).with(ofFloat2);
        bVar.gcc.playAnimation();
        bVar.gcd.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gcc.cancelAnimation();
        if (bVar.gcd == null) {
            return;
        }
        bVar.gcd.cancel();
    }

    /* loaded from: classes7.dex */
    public class b {
        private TextView aAP;
        private TextView fRN;
        private HeadImageView fRP;
        private TextView fRV;
        private TextView gaF;
        private View gca;
        private TbImageView gcb;
        private LottieAnimationView gcc;
        private AnimatorSet gcd;
        private View gce;
        private TextView gcf;
        private TextView gcg;

        public b() {
        }

        public void recycle() {
            QC();
        }

        public void QC() {
            m.this.b(this);
        }
    }
}
