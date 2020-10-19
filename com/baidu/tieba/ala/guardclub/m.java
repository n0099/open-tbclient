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
    private String aYC;
    private List<com.baidu.tieba.ala.guardclub.model.k> bpM;
    private int grA;
    private float grB;
    private float grC;
    private int grD;
    private a grz;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.grB = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.grC = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.grD = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.grD = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fX(String str) {
        this.aYC = str;
    }

    public void a(a aVar) {
        this.grz = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.bpM;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bpM == null) {
            this.bpM = new ArrayList();
        }
        this.bpM.clear();
        bY(list);
    }

    public void bY(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.bpM == null) {
            this.bpM = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.bpM.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bpM != null) {
            return this.bpM.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uj */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.bpM.get(i);
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
            bVar2.ghv = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.grG = view.findViewById(a.g.layout_avatar);
            bVar2.ghx = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.grH = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.ghx, bVar2.grH);
            bVar2.grI = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aEC = (TextView) view.findViewById(a.g.tv_name);
            bVar2.gqm = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.ghC = (TextView) view.findViewById(a.g.tv_content);
            bVar2.grK = view.findViewById(a.g.layout_action);
            bVar2.grL = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.grM = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.ghv.setText("99+");
            bVar.ghv.setTextSize(0, this.grC);
            return;
        }
        bVar.ghv.setText(String.valueOf(i + 4));
        bVar.ghv.setTextSize(0, this.grB);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.ghx.stopLoad();
        bVar.ghx.startLoad(kVar.avatar, 12, false, false);
        bVar.grH.stopLoad();
        b(bVar);
        bVar.ghx.setScaleX(1.0f);
        bVar.ghx.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.grI.setVisibility(8);
        } else {
            bVar.grI.setVisibility(0);
            a(bVar);
        }
        String eC = com.baidu.live.guardclub.g.JM().eC(kVar.level);
        if (!TextUtils.isEmpty(eC)) {
            bVar.grH.startLoad(eC, 10, false);
            bVar.grH.setVisibility(0);
        } else {
            bVar.grH.setVisibility(8);
        }
        bVar.grG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.grz != null) {
                    m.this.grz.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.grA <= 0) {
            this.grA = bVar.gqm.getWidth();
            if (this.grA <= 0) {
                bVar.gqm.measure(0, 0);
                this.grA = bVar.gqm.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aEC.setPadding(0, 0, this.grA, 0);
            bVar.gqm.setVisibility(0);
        } else {
            bVar.aEC.setPadding(0, 0, 0, 0);
            bVar.gqm.setVisibility(4);
        }
        bVar.aEC.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gsk;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.ghC.setText(String.format(context.getResources().getString(this.grD), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.aYC) || TextUtils.isEmpty(kVar.aOR) || !this.aYC.equals(kVar.aOR)) {
            bVar.grK.setVisibility(0);
            if (kVar.gsl) {
                bVar.grM.setVisibility(0);
                bVar.grL.setVisibility(8);
                return;
            }
            bVar.grM.setVisibility(8);
            bVar.grL.setVisibility(0);
            bVar.grL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.grz != null) {
                        m.this.grz.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.grK.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.grJ == null) {
            bVar.grJ = new AnimatorSet();
        }
        bVar.grI.setAnimation("live_anim_guard_join.json");
        bVar.grI.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.ghx, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.ghx, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.grJ.setDuration(1000L);
        bVar.grJ.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.grJ.play(ofFloat).with(ofFloat2);
        bVar.grI.playAnimation();
        bVar.grJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.grI.cancelAnimation();
        if (bVar.grJ == null) {
            return;
        }
        bVar.grJ.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aEC;
        private TextView ghC;
        private TextView ghv;
        private HeadImageView ghx;
        private TextView gqm;
        private View grG;
        private TbImageView grH;
        private LottieAnimationView grI;
        private AnimatorSet grJ;
        private View grK;
        private TextView grL;
        private TextView grM;

        public b() {
        }

        public void recycle() {
            Tf();
        }

        public void Tf() {
            m.this.b(this);
        }
    }
}
