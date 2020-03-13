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
    private a eGC;
    private String eGD;
    private List<com.baidu.tieba.ala.guardclub.model.k> eGE;
    private int eGF;
    private float eGG;
    private float eGH;
    private int eGI;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.eGG = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.eGH = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.eGI = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.eGI = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void yw(String str) {
        this.eGD = str;
    }

    public void a(a aVar) {
        this.eGC = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.eGE;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eGE == null) {
            this.eGE = new ArrayList();
        }
        this.eGE.clear();
        bw(list);
    }

    public void bw(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.eGE == null) {
            this.eGE = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.eGE.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eGE != null) {
            return this.eGE.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ps */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.eGE.get(i);
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
            bVar2.eGL = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.eGM = view.findViewById(a.g.layout_avatar);
            bVar2.eGN = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.eGO = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.eGN, bVar2.eGO);
            bVar2.eGP = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.avq = (TextView) view.findViewById(a.g.tv_name);
            bVar2.eFo = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.eGR = (TextView) view.findViewById(a.g.tv_content);
            bVar2.eGS = view.findViewById(a.g.layout_action);
            bVar2.eGT = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.eGU = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.eGL.setText("99+");
            bVar.eGL.setTextSize(0, this.eGH);
            return;
        }
        bVar.eGL.setText(String.valueOf(i + 4));
        bVar.eGL.setTextSize(0, this.eGG);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.eGN.stopLoad();
        bVar.eGN.startLoad(kVar.avatar, 12, false, false);
        bVar.eGO.stopLoad();
        b(bVar);
        bVar.eGN.setScaleX(1.0f);
        bVar.eGN.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.eGP.setVisibility(8);
        } else {
            bVar.eGP.setVisibility(0);
            a(bVar);
        }
        String bT = com.baidu.live.guardclub.g.vH().bT(kVar.level);
        if (!TextUtils.isEmpty(bT)) {
            bVar.eGO.startLoad(bT, 10, false);
            bVar.eGO.setVisibility(0);
        } else {
            bVar.eGO.setVisibility(8);
        }
        bVar.eGM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.eGC != null) {
                    m.this.eGC.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.eGF <= 0) {
            this.eGF = bVar.eFo.getWidth();
            if (this.eGF <= 0) {
                bVar.eFo.measure(0, 0);
                this.eGF = bVar.eFo.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.avq.setPadding(0, 0, this.eGF, 0);
            bVar.eFo.setVisibility(0);
        } else {
            bVar.avq.setPadding(0, 0, 0, 0);
            bVar.eFo.setVisibility(4);
        }
        bVar.avq.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.eHt;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.eGR.setText(String.format(context.getResources().getString(this.eGI), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.eGD) || TextUtils.isEmpty(kVar.adC) || !this.eGD.equals(kVar.adC)) {
            bVar.eGS.setVisibility(0);
            if (kVar.eHu) {
                bVar.eGU.setVisibility(0);
                bVar.eGT.setVisibility(8);
                return;
            }
            bVar.eGU.setVisibility(8);
            bVar.eGT.setVisibility(0);
            bVar.eGT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.eGC != null) {
                        m.this.eGC.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.eGS.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.eGQ == null) {
            bVar.eGQ = new AnimatorSet();
        }
        bVar.eGP.setAnimation("live_anim_guard_join.json");
        bVar.eGP.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.eGN, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.eGN, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.eGQ.setDuration(1000L);
        bVar.eGQ.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.eGQ.play(ofFloat).with(ofFloat2);
        bVar.eGP.playAnimation();
        bVar.eGQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.eGP.cancelAnimation();
        if (bVar.eGQ == null) {
            return;
        }
        bVar.eGQ.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView avq;
        private TextView eFo;
        private TextView eGL;
        private View eGM;
        private HeadImageView eGN;
        private TbImageView eGO;
        private LottieAnimationView eGP;
        private AnimatorSet eGQ;
        private TextView eGR;
        private View eGS;
        private TextView eGT;
        private TextView eGU;

        public b() {
        }

        public void recycle() {
            bfq();
        }

        public void bfq() {
            m.this.b(this);
        }
    }
}
