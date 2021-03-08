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
import com.baidu.live.lottie.LottieAnimationView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class n extends BaseAdapter {
    private String beK;
    private List<com.baidu.tieba.ala.guardclub.model.k> bfU;
    private a hbV;
    private int hbW;
    private float hbX;
    private float hbY;
    private int hbZ;
    private int mType;

    /* loaded from: classes10.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.hbX = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.hbY = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.hbZ = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.hbZ = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fo(String str) {
        this.beK = str;
    }

    public void a(a aVar) {
        this.hbV = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bfU;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bfU == null) {
            this.bfU = new ArrayList();
        }
        this.bfU.clear();
        cv(list);
    }

    public void cv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bfU == null) {
            this.bfU = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bfU.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bfU != null) {
            return this.bfU.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uD */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bfU.get(i);
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
            bVar2.gRo = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.hcc = view.findViewById(a.f.layout_avatar);
            bVar2.gRq = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.hcd = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gRq, bVar2.hcd);
            bVar2.hce = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aFm = (TextView) view.findViewById(a.f.tv_name);
            bVar2.haJ = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gRx = (TextView) view.findViewById(a.f.tv_content);
            bVar2.hcg = view.findViewById(a.f.layout_action);
            bVar2.hch = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.hci = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gRo.setText("99+");
            bVar.gRo.setTextSize(0, this.hbY);
            return;
        }
        bVar.gRo.setText(String.valueOf(i + 4));
        bVar.gRo.setTextSize(0, this.hbX);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gRq.stopLoad();
        bVar.gRq.startLoad(kVar.avatar, 12, false, false);
        bVar.hcd.stopLoad();
        b(bVar);
        bVar.gRq.setScaleX(1.0f);
        bVar.gRq.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.hce.setVisibility(8);
        } else {
            bVar.hce.setVisibility(0);
            a(bVar);
        }
        String dt = com.baidu.live.guardclub.g.IW().dt(kVar.level);
        if (!TextUtils.isEmpty(dt)) {
            bVar.hcd.startLoad(dt, 10, false);
            bVar.hcd.setVisibility(0);
        } else {
            bVar.hcd.setVisibility(8);
        }
        bVar.hcc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hbV != null) {
                    n.this.hbV.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.hbW <= 0) {
            this.hbW = bVar.haJ.getWidth();
            if (this.hbW <= 0) {
                bVar.haJ.measure(0, 0);
                this.hbW = bVar.haJ.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aFm.setPadding(0, 0, this.hbW, 0);
            bVar.haJ.setVisibility(0);
        } else {
            bVar.aFm.setPadding(0, 0, 0, 0);
            bVar.haJ.setVisibility(4);
        }
        bVar.aFm.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.hcG;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gRx.setText(String.format(context.getResources().getString(this.hbZ), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.beK) || TextUtils.isEmpty(kVar.aLm) || !this.beK.equals(kVar.aLm)) {
            bVar.hcg.setVisibility(0);
            if (kVar.hcH) {
                bVar.hci.setVisibility(0);
                bVar.hch.setVisibility(8);
                return;
            }
            bVar.hci.setVisibility(8);
            bVar.hch.setVisibility(0);
            bVar.hch.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.hbV != null) {
                        n.this.hbV.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.hcg.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.hcf == null) {
            bVar.hcf = new AnimatorSet();
        }
        bVar.hce.setAnimation("live_anim_guard_join.json");
        bVar.hce.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gRq, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gRq, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.hcf.setDuration(1000L);
        bVar.hcf.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.hcf.play(ofFloat).with(ofFloat2);
        bVar.hce.playAnimation();
        bVar.hcf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.hce.cancelAnimation();
        if (bVar.hcf == null) {
            return;
        }
        bVar.hcf.cancel();
    }

    /* loaded from: classes10.dex */
    public class b {
        private TextView aFm;
        private TextView gRo;
        private HeadImageView gRq;
        private TextView gRx;
        private TextView haJ;
        private View hcc;
        private TbImageView hcd;
        private LottieAnimationView hce;
        private AnimatorSet hcf;
        private View hcg;
        private TextView hch;
        private TextView hci;

        public b() {
        }

        public void recycle() {
            Xz();
        }

        public void Xz() {
            n.this.b(this);
        }
    }
}
