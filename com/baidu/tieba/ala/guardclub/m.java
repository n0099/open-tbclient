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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.tb.airbnb.lottie.LottieAnimationView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class m extends BaseAdapter {
    private List<com.baidu.tieba.ala.guardclub.model.k> fKA;
    private int fKB;
    private float fKC;
    private float fKD;
    private int fKE;
    private a fKz;
    private String fzJ;
    private int mType;

    /* loaded from: classes3.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public m(Context context) {
        this.fKC = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
        this.fKD = context.getResources().getDimensionPixelOffset(a.e.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.fKE = a.i.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.fKE = a.i.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void Cn(String str) {
        this.fzJ = str;
    }

    public void a(a aVar) {
        this.fKz = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.fKA;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fKA == null) {
            this.fKA = new ArrayList();
        }
        this.fKA.clear();
        bL(list);
    }

    public void bL(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.fKA == null) {
            this.fKA = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.fKA.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.fKA != null) {
            return this.fKA.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qQ */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.fKA.get(i);
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
            bVar2.fBm = (TextView) view.findViewById(a.g.tv_rank);
            bVar2.fKH = view.findViewById(a.g.layout_avatar);
            bVar2.fBo = (HeadImageView) view.findViewById(a.g.iv_avatar);
            bVar2.fKI = (TbImageView) view.findViewById(a.g.iv_level);
            a(bVar2.fBo, bVar2.fKI);
            bVar2.fKJ = (LottieAnimationView) view.findViewById(a.g.lottie_live);
            bVar2.aXZ = (TextView) view.findViewById(a.g.tv_name);
            bVar2.fJl = (TextView) view.findViewById(a.g.tv_name_suffix);
            bVar2.fBu = (TextView) view.findViewById(a.g.tv_content);
            bVar2.fKL = view.findViewById(a.g.layout_action);
            bVar2.fKM = (TextView) view.findViewById(a.g.tv_guard);
            bVar2.fKN = (TextView) view.findViewById(a.g.tv_joined);
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
            bVar.fBm.setText("99+");
            bVar.fBm.setTextSize(0, this.fKD);
            return;
        }
        bVar.fBm.setText(String.valueOf(i + 4));
        bVar.fBm.setTextSize(0, this.fKC);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.fBo.stopLoad();
        bVar.fBo.startLoad(kVar.avatar, 12, false, false);
        bVar.fKI.stopLoad();
        b(bVar);
        bVar.fBo.setScaleX(1.0f);
        bVar.fBo.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.fKJ.setVisibility(8);
        } else {
            bVar.fKJ.setVisibility(0);
            a(bVar);
        }
        String cx = com.baidu.live.guardclub.g.Ch().cx(kVar.level);
        if (!TextUtils.isEmpty(cx)) {
            bVar.fKI.startLoad(cx, 10, false);
            bVar.fKI.setVisibility(0);
        } else {
            bVar.fKI.setVisibility(8);
        }
        bVar.fKH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m.this.fKz != null) {
                    m.this.fKz.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.fKB <= 0) {
            this.fKB = bVar.fJl.getWidth();
            if (this.fKB <= 0) {
                bVar.fJl.measure(0, 0);
                this.fKB = bVar.fJl.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aXZ.setPadding(0, 0, this.fKB, 0);
            bVar.fJl.setVisibility(0);
        } else {
            bVar.aXZ.setPadding(0, 0, 0, 0);
            bVar.fJl.setVisibility(4);
        }
        bVar.aXZ.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.fLm;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.fBu.setText(String.format(context.getResources().getString(this.fKE), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.fzJ) || TextUtils.isEmpty(kVar.aDD) || !this.fzJ.equals(kVar.aDD)) {
            bVar.fKL.setVisibility(0);
            if (kVar.fLn) {
                bVar.fKN.setVisibility(0);
                bVar.fKM.setVisibility(8);
                return;
            }
            bVar.fKN.setVisibility(8);
            bVar.fKM.setVisibility(0);
            bVar.fKM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.m.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (m.this.fKz != null) {
                        m.this.fKz.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.fKL.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.fKK == null) {
            bVar.fKK = new AnimatorSet();
        }
        bVar.fKJ.setAnimation("live_anim_guard_join.json");
        bVar.fKJ.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.fBo, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.fBo, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.fKK.setDuration(1000L);
        bVar.fKK.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.fKK.play(ofFloat).with(ofFloat2);
        bVar.fKJ.playAnimation();
        bVar.fKK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.fKJ.cancelAnimation();
        if (bVar.fKK == null) {
            return;
        }
        bVar.fKK.cancel();
    }

    /* loaded from: classes3.dex */
    public class b {
        private TextView aXZ;
        private TextView fBm;
        private HeadImageView fBo;
        private TextView fBu;
        private TextView fJl;
        private View fKH;
        private TbImageView fKI;
        private LottieAnimationView fKJ;
        private AnimatorSet fKK;
        private View fKL;
        private TextView fKM;
        private TextView fKN;

        public b() {
        }

        public void recycle() {
            bxz();
        }

        public void bxz() {
            m.this.b(this);
        }
    }
}
