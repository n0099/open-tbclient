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
    private String aZG;
    private List<com.baidu.tieba.ala.guardclub.model.k> brj;
    private a gGY;
    private int gGZ;
    private float gHa;
    private float gHb;
    private int gHc;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.gHa = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.gHb = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gHc = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gHc = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fW(String str) {
        this.aZG = str;
    }

    public void a(a aVar) {
        this.gGY = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.brj;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.brj == null) {
            this.brj = new ArrayList();
        }
        this.brj.clear();
        cp(list);
    }

    public void cp(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.brj == null) {
            this.brj = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.brj.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.brj != null) {
            return this.brj.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vj */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.brj.get(i);
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
            bVar2.gwT = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.gHf = view.findViewById(a.f.layout_avatar);
            bVar2.gwV = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.gHg = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gwV, bVar2.gHg);
            bVar2.gHh = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aDP = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gFM = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gxa = (TextView) view.findViewById(a.f.tv_content);
            bVar2.gHj = view.findViewById(a.f.layout_action);
            bVar2.gHk = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.gHl = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gwT.setText("99+");
            bVar.gwT.setTextSize(0, this.gHb);
            return;
        }
        bVar.gwT.setText(String.valueOf(i + 4));
        bVar.gwT.setTextSize(0, this.gHa);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gwV.stopLoad();
        bVar.gwV.startLoad(kVar.avatar, 12, false, false);
        bVar.gHg.stopLoad();
        b(bVar);
        bVar.gwV.setScaleX(1.0f);
        bVar.gwV.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gHh.setVisibility(8);
        } else {
            bVar.gHh.setVisibility(0);
            a(bVar);
        }
        String ez = com.baidu.live.guardclub.g.JW().ez(kVar.level);
        if (!TextUtils.isEmpty(ez)) {
            bVar.gHg.startLoad(ez, 10, false);
            bVar.gHg.setVisibility(0);
        } else {
            bVar.gHg.setVisibility(8);
        }
        bVar.gHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gGY != null) {
                    m.this.gGY.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gGZ <= 0) {
            this.gGZ = bVar.gFM.getWidth();
            if (this.gGZ <= 0) {
                bVar.gFM.measure(0, 0);
                this.gGZ = bVar.gFM.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aDP.setPadding(0, 0, this.gGZ, 0);
            bVar.gFM.setVisibility(0);
        } else {
            bVar.aDP.setPadding(0, 0, 0, 0);
            bVar.gFM.setVisibility(4);
        }
        bVar.aDP.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gHJ;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gxa.setText(String.format(context.getResources().getString(this.gHc), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.aZG) || TextUtils.isEmpty(kVar.aOM) || !this.aZG.equals(kVar.aOM)) {
            bVar.gHj.setVisibility(0);
            if (kVar.gHK) {
                bVar.gHl.setVisibility(0);
                bVar.gHk.setVisibility(8);
                return;
            }
            bVar.gHl.setVisibility(8);
            bVar.gHk.setVisibility(0);
            bVar.gHk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.gGY != null) {
                        m.this.gGY.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gHj.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gHi == null) {
            bVar.gHi = new AnimatorSet();
        }
        bVar.gHh.setAnimation("live_anim_guard_join.json");
        bVar.gHh.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gwV, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gwV, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gHi.setDuration(1000L);
        bVar.gHi.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gHi.play(ofFloat).with(ofFloat2);
        bVar.gHh.playAnimation();
        bVar.gHi.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gHh.cancelAnimation();
        if (bVar.gHi == null) {
            return;
        }
        bVar.gHi.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aDP;
        private TextView gFM;
        private View gHf;
        private TbImageView gHg;
        private LottieAnimationView gHh;
        private AnimatorSet gHi;
        private View gHj;
        private TextView gHk;
        private TextView gHl;
        private TextView gwT;
        private HeadImageView gwV;
        private TextView gxa;

        public b() {
        }

        public void recycle() {
            VV();
        }

        public void VV() {
            m.this.b(this);
        }
    }
}
