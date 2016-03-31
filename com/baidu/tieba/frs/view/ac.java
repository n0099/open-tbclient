package com.baidu.tieba.frs.view;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ac extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> ND;
    private ViewGroup Wy;
    private View aNr;
    private final List<b> aTc;
    private final a bwZ;
    private ViewGroup bxa;
    private ViewGroup bxb;
    private ImageView bxc;

    /* loaded from: classes.dex */
    public interface a {
        void gF(int i);
    }

    public ac(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aTc = new ArrayList();
        this.ND = tbPageContext;
        this.bwZ = aVar;
        this.aNr = view;
        initView();
    }

    private void initView() {
        this.Wy = (ViewGroup) LayoutInflater.from(this.ND.getPageActivity()).inflate(t.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.Wy);
        this.bxa = (ViewGroup) this.Wy.findViewById(t.g.frs_write_popup_item_container);
        this.bxb = (ViewGroup) this.Wy.findViewById(t.g.frs_write_popup_board);
        this.bxc = (ImageView) this.Wy.findViewById(t.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.ND.getResources().getColor(t.d.white_alpha0)));
        this.ND.getLayoutMode().x(this.Wy);
        this.bxb.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.Wy.setOnClickListener(this);
        this.bxc.setOnClickListener(this);
        this.bxb.setOnClickListener(this);
        this.Wy.setOnKeyListener(new ad(this));
    }

    public void j(boolean z, boolean z2) {
        k(z, z2);
        Ur();
        Us();
    }

    private void k(boolean z, boolean z2) {
        this.aTc.add(new b(0, this.ND.getPageActivity().getString(t.j.publish_topic_thread), t.f.write_popup_normal_item_selector));
        if (z) {
            this.aTc.add(new b(1, this.ND.getPageActivity().getString(t.j.publish_live_thread), t.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aTc.add(new b(3, this.ND.getPageActivity().getString(t.j.publish_video_thread), t.f.write_popup_video_item_selector));
        }
        this.aTc.add(new b(2, this.ND.getPageActivity().getString(t.j.publish_vote_thread), t.f.write_popup_vote_item_selector));
    }

    private void Ur() {
        for (b bVar : this.aTc) {
            if (bVar != null) {
                View inflate = LayoutInflater.from(this.ND.getPageActivity()).inflate(t.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(t.g.text_frs_write_popup_item);
                ImageView imageView = (ImageView) inflate.findViewById(t.g.image_frs_write_popup_item);
                at.j((View) textView, t.d.cp_cont_b);
                if (com.baidu.tbadk.core.util.y.p(this.aTc) == 3) {
                    int dimensionPixelOffset = this.ND.getResources().getDimensionPixelOffset(t.e.ds40);
                    inflate.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                } else if (com.baidu.tbadk.core.util.y.p(this.aTc) == 2) {
                    int dimensionPixelOffset2 = this.ND.getResources().getDimensionPixelOffset(t.e.ds66);
                    inflate.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset2, 0);
                }
                textView.setText(bVar.mTitle);
                at.c(imageView, bVar.bxg);
                inflate.setOnClickListener(new ae(this, bVar));
                this.bxa.addView(inflate);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Wy == view || this.bxc == view) {
            Ut();
        }
    }

    private void Us() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aNr, 0, 0, 1);
        this.bxb.startAnimation(AnimationUtils.loadAnimation(this.ND.getPageActivity(), t.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ut() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ND.getPageActivity(), t.a.write_popup_out);
        loadAnimation.setAnimationListener(new af(this));
        this.bxb.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int bxf;
        public int bxg;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.bxf = i;
            this.mTitle = str;
            this.bxg = i2;
        }
    }
}
