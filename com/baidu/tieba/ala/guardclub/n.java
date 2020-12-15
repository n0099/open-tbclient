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
public class n extends BaseAdapter {
    private String bdg;
    private List<com.baidu.tieba.ala.guardclub.model.k> bep;
    private a gQh;
    private int gQi;
    private float gQj;
    private float gQk;
    private int gQl;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.gQj = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.gQk = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gQl = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gQl = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void gr(String str) {
        this.bdg = str;
    }

    public void a(a aVar) {
        this.gQh = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bep;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bep == null) {
            this.bep = new ArrayList();
        }
        this.bep.clear();
        ct(list);
    }

    public void ct(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bep == null) {
            this.bep = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bep.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bep != null) {
            return this.bep.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vQ */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bep.get(i);
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
            bVar2.gFG = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.gQo = view.findViewById(a.f.layout_avatar);
            bVar2.gFI = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.gQp = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gFI, bVar2.gQp);
            bVar2.gQq = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aGv = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gOV = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gFP = (TextView) view.findViewById(a.f.tv_content);
            bVar2.gQs = view.findViewById(a.f.layout_action);
            bVar2.gQt = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.gQu = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gFG.setText("99+");
            bVar.gFG.setTextSize(0, this.gQk);
            return;
        }
        bVar.gFG.setText(String.valueOf(i + 4));
        bVar.gFG.setTextSize(0, this.gQj);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gFI.stopLoad();
        bVar.gFI.startLoad(kVar.avatar, 12, false, false);
        bVar.gQp.stopLoad();
        b(bVar);
        bVar.gFI.setScaleX(1.0f);
        bVar.gFI.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gQq.setVisibility(8);
        } else {
            bVar.gQq.setVisibility(0);
            a(bVar);
        }
        String eV = com.baidu.live.guardclub.g.LZ().eV(kVar.level);
        if (!TextUtils.isEmpty(eV)) {
            bVar.gQp.startLoad(eV, 10, false);
            bVar.gQp.setVisibility(0);
        } else {
            bVar.gQp.setVisibility(8);
        }
        bVar.gQo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gQh != null) {
                    n.this.gQh.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gQi <= 0) {
            this.gQi = bVar.gOV.getWidth();
            if (this.gQi <= 0) {
                bVar.gOV.measure(0, 0);
                this.gQi = bVar.gOV.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aGv.setPadding(0, 0, this.gQi, 0);
            bVar.gOV.setVisibility(0);
        } else {
            bVar.aGv.setPadding(0, 0, 0, 0);
            bVar.gOV.setVisibility(4);
        }
        bVar.aGv.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gQS;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gFP.setText(String.format(context.getResources().getString(this.gQl), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.bdg) || TextUtils.isEmpty(kVar.aRO) || !this.bdg.equals(kVar.aRO)) {
            bVar.gQs.setVisibility(0);
            if (kVar.gQT) {
                bVar.gQu.setVisibility(0);
                bVar.gQt.setVisibility(8);
                return;
            }
            bVar.gQu.setVisibility(8);
            bVar.gQt.setVisibility(0);
            bVar.gQt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.gQh != null) {
                        n.this.gQh.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gQs.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gQr == null) {
            bVar.gQr = new AnimatorSet();
        }
        bVar.gQq.setAnimation("live_anim_guard_join.json");
        bVar.gQq.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gFI, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gFI, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gQr.setDuration(1000L);
        bVar.gQr.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gQr.play(ofFloat).with(ofFloat2);
        bVar.gQq.playAnimation();
        bVar.gQr.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gQq.cancelAnimation();
        if (bVar.gQr == null) {
            return;
        }
        bVar.gQr.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aGv;
        private TextView gFG;
        private HeadImageView gFI;
        private TextView gFP;
        private TextView gOV;
        private View gQo;
        private TbImageView gQp;
        private LottieAnimationView gQq;
        private AnimatorSet gQr;
        private View gQs;
        private TextView gQt;
        private TextView gQu;

        public b() {
        }

        public void recycle() {
            Yv();
        }

        public void Yv() {
            n.this.b(this);
        }
    }
}
