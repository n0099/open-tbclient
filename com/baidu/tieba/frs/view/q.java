package com.baidu.tieba.frs.view;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> FY;
    private ViewGroup UR;
    private final List<b> aMy;
    private View aQZ;
    private final a bYt;
    private ViewGroup bYu;
    private ViewGroup bYv;
    private ImageView bYw;
    private final List<View> bYx;

    /* loaded from: classes.dex */
    public interface a {
        void iG(int i);
    }

    public q(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aMy = new ArrayList();
        this.bYx = new ArrayList();
        this.FY = tbPageContext;
        this.bYt = aVar;
        this.aQZ = view;
        initView();
    }

    private void initView() {
        this.UR = (ViewGroup) LayoutInflater.from(this.FY.getPageActivity()).inflate(r.j.frs_write_popup, (ViewGroup) null);
        setContentView(this.UR);
        this.bYu = (ViewGroup) this.UR.findViewById(r.h.frs_write_popup_item_container);
        this.bYv = (ViewGroup) this.UR.findViewById(r.h.frs_write_popup_board);
        this.bYw = (ImageView) this.UR.findViewById(r.h.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.FY.getResources().getColor(r.e.common_color_10262)));
        this.FY.getLayoutMode().v(this.UR);
        this.bYv.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.UR.setOnClickListener(this);
        this.bYw.setOnClickListener(this);
        this.bYv.setOnClickListener(this);
        this.UR.setOnKeyListener(new r(this));
    }

    public void d(boolean z, boolean z2, boolean z3) {
        e(z, z2, z3);
        adI();
        adJ();
    }

    private void e(boolean z, boolean z2, boolean z3) {
        this.aMy.add(new b(0, this.FY.getPageActivity().getString(r.l.topic_thread), r.g.write_popup_normal_item_selector));
        if (z) {
            this.aMy.add(new b(1, this.FY.getPageActivity().getString(r.l.publish_live_thread), r.g.write_popup_live_item_selector));
        }
        if (z2) {
            this.aMy.add(new b(3, this.FY.getPageActivity().getString(r.l.msglist_video), r.g.write_popup_video_item_selector));
        }
        this.aMy.add(new b(2, this.FY.getPageActivity().getString(r.l.publish_vote_thread), r.g.write_popup_vote_item_selector));
        if (z3) {
            this.aMy.add(new b(5, this.FY.getPageActivity().getString(r.l.photo_live_title), r.g.write_popup_live_video_item_selector));
        }
    }

    private void adI() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aMy.size()) {
            b bVar = this.aMy.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.FY.getPageActivity()).inflate(r.j.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(r.h.text_frs_write_popup_item);
                ap.i((View) textView, r.e.cp_cont_b);
                textView.setText(bVar.mTitle);
                ap.c((ImageView) inflate.findViewById(r.h.image_frs_write_popup_item), bVar.bYB);
                inflate.setOnClickListener(new s(this, bVar));
                int dimensionPixelOffset = this.FY.getResources().getDimensionPixelOffset(r.f.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.FY.getPageActivity());
                    linearLayout.setPadding(this.FY.getResources().getDimensionPixelOffset(r.f.ds80), 0, this.FY.getResources().getDimensionPixelOffset(r.f.ds80), 0);
                    this.bYu.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                inflate.setTag(bVar);
                this.bYx.add(inflate);
                if (linearLayout != null) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (i >= 3) {
                        layoutParams.topMargin = this.FY.getResources().getDimensionPixelOffset(r.f.ds76);
                        layoutParams.bottomMargin = this.FY.getResources().getDimensionPixelOffset(r.f.ds76);
                    }
                    linearLayout.addView(inflate, layoutParams);
                }
            }
            i++;
            linearLayout2 = linearLayout;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.UR == view || this.bYw == view) {
            adK();
        }
    }

    private void adJ() {
        long j = com.baidu.tbadk.core.sharedPref.b.tQ().getLong("key_frs_videolive_last_popup_time", 0L);
        com.baidu.adp.lib.g.j.showPopupWindowAtLocation(this, this.aQZ, 0, 0, 1);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.FY.getPageActivity(), r.a.write_popup_in);
        if (j == 0 && this.bYx != null && this.bYx.size() > 0) {
            loadAnimation.setAnimationListener(new t(this));
        }
        this.bYv.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adK() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.FY.getPageActivity(), r.a.write_popup_out);
        loadAnimation.setAnimationListener(new u(this));
        this.bYv.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int bYA;
        public int bYB;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.bYA = i;
            this.mTitle = str;
            this.bYB = i2;
        }
    }
}
