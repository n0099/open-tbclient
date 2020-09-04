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
    private List<com.baidu.tieba.ala.guardclub.model.k> bjf;
    private String fQl;
    private a gbX;
    private int gbY;
    private float gbZ;
    private float gca;
    private int gcb;
    private int mType;

    /* loaded from: classes7.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.gbZ = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.gca = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gcb = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gcb = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void Fv(String str) {
        this.fQl = str;
    }

    public void a(a aVar) {
        this.gbX = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bjf;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bjf == null) {
            this.bjf = new ArrayList();
        }
        this.bjf.clear();
        bQ(list);
    }

    public void bQ(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bjf == null) {
            this.bjf = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bjf.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bjf != null) {
            return this.bjf.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ts */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bjf.get(i);
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
            bVar2.fRR = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.gce = view.findViewById(a.g.layout_avatar);
            bVar2.fRT = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.gcf = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fRT, bVar2.gcf);
            bVar2.gcg = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aAR = (TextView) view.findViewById(a.g.tv_name);
            bVar2.gaJ = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fRZ = (TextView) view.findViewById(a.g.tv_content);
            bVar2.gci = view.findViewById(a.g.layout_action);
            bVar2.gcj = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.gck = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.fRR.setText("99+");
            bVar.fRR.setTextSize(0, this.gca);
            return;
        }
        bVar.fRR.setText(String.valueOf(i + 4));
        bVar.fRR.setTextSize(0, this.gbZ);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fRT.stopLoad();
        bVar.fRT.startLoad(kVar.avatar, 12, false, false);
        bVar.gcf.stopLoad();
        b(bVar);
        bVar.fRT.setScaleX(1.0f);
        bVar.fRT.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gcg.setVisibility(8);
        } else {
            bVar.gcg.setVisibility(0);
            a(bVar);
        }
        String et = com.baidu.live.guardclub.g.Im().et(kVar.level);
        if (!TextUtils.isEmpty(et)) {
            bVar.gcf.startLoad(et, 10, false);
            bVar.gcf.setVisibility(0);
        } else {
            bVar.gcf.setVisibility(8);
        }
        bVar.gce.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gbX != null) {
                    m.this.gbX.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gbY <= 0) {
            this.gbY = bVar.gaJ.getWidth();
            if (this.gbY <= 0) {
                bVar.gaJ.measure(0, 0);
                this.gbY = bVar.gaJ.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aAR.setPadding(0, 0, this.gbY, 0);
            bVar.gaJ.setVisibility(0);
        } else {
            bVar.aAR.setPadding(0, 0, 0, 0);
            bVar.gaJ.setVisibility(4);
        }
        bVar.aAR.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gcI;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fRZ.setText(String.format(context.getResources().getString(this.gcb), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.fQl) || TextUtils.isEmpty(kVar.aKj) || !this.fQl.equals(kVar.aKj)) {
            bVar.gci.setVisibility(0);
            if (kVar.gcJ) {
                bVar.gck.setVisibility(0);
                bVar.gcj.setVisibility(8);
                return;
            }
            bVar.gck.setVisibility(8);
            bVar.gcj.setVisibility(0);
            bVar.gcj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.gbX != null) {
                        m.this.gbX.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gci.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gch == null) {
            bVar.gch = new AnimatorSet();
        }
        bVar.gcg.setAnimation("live_anim_guard_join.json");
        bVar.gcg.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fRT, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fRT, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gch.setDuration(1000L);
        bVar.gch.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gch.play(ofFloat).with(ofFloat2);
        bVar.gcg.playAnimation();
        bVar.gch.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gcg.cancelAnimation();
        if (bVar.gch == null) {
            return;
        }
        bVar.gch.cancel();
    }

    /* loaded from: classes7.dex */
    public class b {
        private TextView aAR;
        private TextView fRR;
        private HeadImageView fRT;
        private TextView fRZ;
        private TextView gaJ;
        private View gce;
        private TbImageView gcf;
        private LottieAnimationView gcg;
        private AnimatorSet gch;
        private View gci;
        private TextView gcj;
        private TextView gck;

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
