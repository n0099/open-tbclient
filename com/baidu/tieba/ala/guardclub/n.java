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
/* loaded from: classes11.dex */
public class n extends BaseAdapter {
    private String beR;
    private List<com.baidu.tieba.ala.guardclub.model.k> bgb;
    private a hbU;
    private int hbV;
    private float hbW;
    private float hbX;
    private int hbY;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.hbW = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.hbX = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.hbY = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.hbY = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void gb(String str) {
        this.beR = str;
    }

    public void a(a aVar) {
        this.hbU = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bgb;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bgb == null) {
            this.bgb = new ArrayList();
        }
        this.bgb.clear();
        cA(list);
    }

    public void cA(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bgb == null) {
            this.bgb = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bgb.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bgb != null) {
            return this.bgb.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wb */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bgb.get(i);
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
            bVar2.gRr = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.hcb = view.findViewById(a.f.layout_avatar);
            bVar2.gRt = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.hcc = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gRt, bVar2.hcc);
            bVar2.hcd = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aGM = (TextView) view.findViewById(a.f.tv_name);
            bVar2.haI = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gRA = (TextView) view.findViewById(a.f.tv_content);
            bVar2.hcf = view.findViewById(a.f.layout_action);
            bVar2.hcg = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.hch = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gRr.setText("99+");
            bVar.gRr.setTextSize(0, this.hbX);
            return;
        }
        bVar.gRr.setText(String.valueOf(i + 4));
        bVar.gRr.setTextSize(0, this.hbW);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gRt.stopLoad();
        bVar.gRt.startLoad(kVar.avatar, 12, false, false);
        bVar.hcc.stopLoad();
        b(bVar);
        bVar.gRt.setScaleX(1.0f);
        bVar.gRt.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.hcd.setVisibility(8);
        } else {
            bVar.hcd.setVisibility(0);
            a(bVar);
        }
        String eT = com.baidu.live.guardclub.g.Ly().eT(kVar.level);
        if (!TextUtils.isEmpty(eT)) {
            bVar.hcc.startLoad(eT, 10, false);
            bVar.hcc.setVisibility(0);
        } else {
            bVar.hcc.setVisibility(8);
        }
        bVar.hcb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.hbU != null) {
                    n.this.hbU.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.hbV <= 0) {
            this.hbV = bVar.haI.getWidth();
            if (this.hbV <= 0) {
                bVar.haI.measure(0, 0);
                this.hbV = bVar.haI.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aGM.setPadding(0, 0, this.hbV, 0);
            bVar.haI.setVisibility(0);
        } else {
            bVar.aGM.setPadding(0, 0, 0, 0);
            bVar.haI.setVisibility(4);
        }
        bVar.aGM.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.hcF;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gRA.setText(String.format(context.getResources().getString(this.hbY), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.beR) || TextUtils.isEmpty(kVar.aLV) || !this.beR.equals(kVar.aLV)) {
            bVar.hcf.setVisibility(0);
            if (kVar.hcG) {
                bVar.hch.setVisibility(0);
                bVar.hcg.setVisibility(8);
                return;
            }
            bVar.hch.setVisibility(8);
            bVar.hcg.setVisibility(0);
            bVar.hcg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.hbU != null) {
                        n.this.hbU.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.hcf.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.hce == null) {
            bVar.hce = new AnimatorSet();
        }
        bVar.hcd.setAnimation("live_anim_guard_join.json");
        bVar.hcd.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gRt, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gRt, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.hce.setDuration(1000L);
        bVar.hce.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.hce.play(ofFloat).with(ofFloat2);
        bVar.hcd.playAnimation();
        bVar.hce.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.hcd.cancelAnimation();
        if (bVar.hce == null) {
            return;
        }
        bVar.hce.cancel();
    }

    /* loaded from: classes11.dex */
    public class b {
        private TextView aGM;
        private TextView gRA;
        private TextView gRr;
        private HeadImageView gRt;
        private TextView haI;
        private View hcb;
        private TbImageView hcc;
        private LottieAnimationView hcd;
        private AnimatorSet hce;
        private View hcf;
        private TextView hcg;
        private TextView hch;

        public b() {
        }

        public void recycle() {
            ZG();
        }

        public void ZG() {
            n.this.b(this);
        }
    }
}
