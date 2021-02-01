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
    private String bdi;
    private List<com.baidu.tieba.ala.guardclub.model.k> ber;
    private a gZY;
    private int gZZ;
    private float haa;
    private float hab;
    private int hac;
    private int mType;

    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.tieba.ala.guardclub.model.k kVar);

        void b(com.baidu.tieba.ala.guardclub.model.k kVar);
    }

    public n(Context context) {
        this.haa = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
        this.hab = context.getResources().getDimensionPixelOffset(a.d.sdk_fontsize36);
    }

    public void setType(int i) {
        this.mType = i;
        switch (i) {
            case 0:
                this.hac = a.h.guard_club_rank_list_contribution_week;
                return;
            case 1:
                this.hac = a.h.guard_club_rank_list_contribution_total;
                return;
            default:
                return;
        }
    }

    public void fi(String str) {
        this.bdi = str;
    }

    public void a(a aVar) {
        this.gZY = aVar;
    }

    public List<com.baidu.tieba.ala.guardclub.model.k> getDatas() {
        return this.ber;
    }

    public void setData(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        this.ber.clear();
        cv(list);
    }

    public void cv(List<com.baidu.tieba.ala.guardclub.model.k> list) {
        if (this.ber == null) {
            this.ber = new ArrayList();
        }
        if (list != null && !list.isEmpty()) {
            this.ber.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.ber != null) {
            return this.ber.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uB */
    public com.baidu.tieba.ala.guardclub.model.k getItem(int i) {
        if (getCount() > i) {
            return this.ber.get(i);
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
            bVar2.gPr = (TextView) view.findViewById(a.f.tv_rank);
            bVar2.haf = view.findViewById(a.f.layout_avatar);
            bVar2.gPt = (HeadImageView) view.findViewById(a.f.iv_avatar);
            bVar2.hag = (TbImageView) view.findViewById(a.f.iv_level);
            a(bVar2.gPt, bVar2.hag);
            bVar2.hah = (LottieAnimationView) view.findViewById(a.f.lottie_live);
            bVar2.aDM = (TextView) view.findViewById(a.f.tv_name);
            bVar2.gYM = (TextView) view.findViewById(a.f.tv_name_suffix);
            bVar2.gPA = (TextView) view.findViewById(a.f.tv_content);
            bVar2.haj = view.findViewById(a.f.layout_action);
            bVar2.hak = (TextView) view.findViewById(a.f.tv_guard);
            bVar2.hal = (TextView) view.findViewById(a.f.tv_joined);
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
            bVar.gPr.setText("99+");
            bVar.gPr.setTextSize(0, this.hab);
            return;
        }
        bVar.gPr.setText(String.valueOf(i + 4));
        bVar.gPr.setTextSize(0, this.haa);
    }

    private void a(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        bVar.gPt.stopLoad();
        bVar.gPt.startLoad(kVar.avatar, 12, false, false);
        bVar.hag.stopLoad();
        b(bVar);
        bVar.gPt.setScaleX(1.0f);
        bVar.gPt.setScaleY(1.0f);
        if (kVar.liveStatus != 1 || TextUtils.isEmpty(kVar.liveId)) {
            bVar.hah.setVisibility(8);
        } else {
            bVar.hah.setVisibility(0);
            a(bVar);
        }
        String ds = com.baidu.live.guardclub.g.IT().ds(kVar.level);
        if (!TextUtils.isEmpty(ds)) {
            bVar.hag.startLoad(ds, 10, false);
            bVar.hag.setVisibility(0);
        } else {
            bVar.hag.setVisibility(8);
        }
        bVar.haf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.gZY != null) {
                    n.this.gZY.a(kVar);
                }
            }
        });
    }

    private void a(b bVar, Context context, com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (this.gZZ <= 0) {
            this.gZZ = bVar.gYM.getWidth();
            if (this.gZZ <= 0) {
                bVar.gYM.measure(0, 0);
                this.gZZ = bVar.gYM.getMeasuredWidth();
            }
        }
        String str = kVar.name;
        if (str != null && str.endsWith("的真爱团")) {
            str = str.substring(0, str.lastIndexOf("的真爱团"));
            bVar.aDM.setPadding(0, 0, this.gZZ, 0);
            bVar.gYM.setVisibility(0);
        } else {
            bVar.aDM.setPadding(0, 0, 0, 0);
            bVar.gYM.setVisibility(4);
        }
        bVar.aDM.setText(str);
        String str2 = null;
        switch (this.mType) {
            case 0:
                str2 = kVar.haJ;
                break;
            case 1:
                str2 = kVar.score;
                break;
        }
        if (str2 == null) {
            str2 = "";
        }
        bVar.gPA.setText(String.format(context.getResources().getString(this.hac), str2));
    }

    private void b(b bVar, final com.baidu.tieba.ala.guardclub.model.k kVar) {
        if (TextUtils.isEmpty(this.bdi) || TextUtils.isEmpty(kVar.aJM) || !this.bdi.equals(kVar.aJM)) {
            bVar.haj.setVisibility(0);
            if (kVar.haK) {
                bVar.hal.setVisibility(0);
                bVar.hak.setVisibility(8);
                return;
            }
            bVar.hal.setVisibility(8);
            bVar.hak.setVisibility(0);
            bVar.hak.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.guardclub.n.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (n.this.gZY != null) {
                        n.this.gZY.b(kVar);
                    }
                }
            });
            return;
        }
        bVar.haj.setVisibility(4);
    }

    private void a(b bVar) {
        if (bVar.hai == null) {
            bVar.hai = new AnimatorSet();
        }
        bVar.hah.setAnimation("live_anim_guard_join.json");
        bVar.hah.loop(true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bVar.gPt, "scaleX", 0.88f, 1.0f, 0.88f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(bVar.gPt, "scaleY", 0.88f, 1.0f, 0.88f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        bVar.hai.setDuration(1000L);
        bVar.hai.setInterpolator(new AccelerateDecelerateInterpolator());
        bVar.hai.play(ofFloat).with(ofFloat2);
        bVar.hah.playAnimation();
        bVar.hai.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(b bVar) {
        bVar.hah.cancelAnimation();
        if (bVar.hai == null) {
            return;
        }
        bVar.hai.cancel();
    }

    /* loaded from: classes11.dex */
    public class b {
        private TextView aDM;
        private TextView gPA;
        private TextView gPr;
        private HeadImageView gPt;
        private TextView gYM;
        private View haf;
        private TbImageView hag;
        private LottieAnimationView hah;
        private AnimatorSet hai;
        private View haj;
        private TextView hak;
        private TextView hal;

        public b() {
        }

        public void recycle() {
            Xw();
        }

        public void Xw() {
            n.this.b(this);
        }
    }
}
