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
    private String aZZ;
    private List<com.baidu.tieba.ala.guardclub.model.k> brB;
    private a gBD;
    private int gBE;
    private float gBF;
    private float gBG;
    private int gBH;
    private int mType;

    /* loaded from: classes4.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.gBF = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.gBG = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.gBH = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.gBH = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fX(String str) {
        this.aZZ = str;
    }

    public void a(a aVar) {
        this.gBD = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.brB;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.brB == null) {
            this.brB = new ArrayList();
        }
        this.brB.clear();
        ci(list);
    }

    public void ci(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.brB == null) {
            this.brB = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.brB.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.brB != null) {
            return this.brB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uB */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.brB.get(i);
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
            bVar2.gry = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.gBK = view.findViewById(a.g.layout_avatar);
            bVar2.grA = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.gBL = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.grA, bVar2.gBL);
            bVar2.gBM = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aEK = (TextView) view.findViewById(a.g.tv_name);
            bVar2.gAr = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.grF = (TextView) view.findViewById(a.g.tv_content);
            bVar2.gBO = view.findViewById(a.g.layout_action);
            bVar2.gBP = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.gBQ = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.gry.setText("99+");
            bVar.gry.setTextSize(0, this.gBG);
            return;
        }
        bVar.gry.setText(String.valueOf(i + 4));
        bVar.gry.setTextSize(0, this.gBF);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.grA.stopLoad();
        bVar.grA.startLoad(kVar.avatar, 12, false, false);
        bVar.gBL.stopLoad();
        b(bVar);
        bVar.grA.setScaleX(1.0f);
        bVar.grA.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.gBM.setVisibility(8);
        } else {
            bVar.gBM.setVisibility(0);
            a(bVar);
        }
        String eD = com.baidu.live.guardclub.g.Kf().eD(kVar.level);
        if (!TextUtils.isEmpty(eD)) {
            bVar.gBL.startLoad(eD, 10, false);
            bVar.gBL.setVisibility(0);
        } else {
            bVar.gBL.setVisibility(8);
        }
        bVar.gBK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.gBD != null) {
                    m.this.gBD.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gBE <= 0) {
            this.gBE = bVar.gAr.getWidth();
            if (this.gBE <= 0) {
                bVar.gAr.measure(0, 0);
                this.gBE = bVar.gAr.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aEK.setPadding(0, 0, this.gBE, 0);
            bVar.gAr.setVisibility(0);
        } else {
            bVar.aEK.setPadding(0, 0, 0, 0);
            bVar.gAr.setVisibility(4);
        }
        bVar.aEK.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.gCo;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.grF.setText(String.format(context.getResources().getString(this.gBH), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.aZZ) || TextUtils.isEmpty(kVar.aPA) || !this.aZZ.equals(kVar.aPA)) {
            bVar.gBO.setVisibility(0);
            if (kVar.gCp) {
                bVar.gBQ.setVisibility(0);
                bVar.gBP.setVisibility(8);
                return;
            }
            bVar.gBQ.setVisibility(8);
            bVar.gBP.setVisibility(0);
            bVar.gBP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.gBD != null) {
                        m.this.gBD.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.gBO.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.gBN == null) {
            bVar.gBN = new AnimatorSet();
        }
        bVar.gBM.setAnimation("live_anim_guard_join.json");
        bVar.gBM.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.grA, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.grA, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.gBN.setDuration(1000L);
        bVar.gBN.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.gBN.play(ofFloat).with(ofFloat2);
        bVar.gBM.playAnimation();
        bVar.gBN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.gBM.cancelAnimation();
        if (bVar.gBN == null) {
            return;
        }
        bVar.gBN.cancel();
    }

    /* loaded from: classes4.dex */
    public class b {
        private TextView aEK;
        private TextView gAr;
        private View gBK;
        private TbImageView gBL;
        private LottieAnimationView gBM;
        private AnimatorSet gBN;
        private View gBO;
        private TextView gBP;
        private TextView gBQ;
        private HeadImageView grA;
        private TextView grF;
        private TextView gry;

        public b() {
        }

        public void recycle() {
            Ue();
        }

        public void Ue() {
            m.this.b(this);
        }
    }
}
