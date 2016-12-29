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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class q extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> GO;
    private ViewGroup VB;
    private final List<b> aNw;
    private View aVz;
    private final a bRO;
    private ViewGroup bRP;
    private ViewGroup bRQ;
    private ImageView bRR;

    /* loaded from: classes.dex */
    public interface a {
        void hT(int i);
    }

    public q(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aNw = new ArrayList();
        this.GO = tbPageContext;
        this.bRO = aVar;
        this.aVz = view;
        initView();
    }

    private void initView() {
        this.VB = (ViewGroup) LayoutInflater.from(this.GO.getPageActivity()).inflate(r.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.VB);
        this.bRP = (ViewGroup) this.VB.findViewById(r.g.frs_write_popup_item_container);
        this.bRQ = (ViewGroup) this.VB.findViewById(r.g.frs_write_popup_board);
        this.bRR = (ImageView) this.VB.findViewById(r.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.GO.getResources().getColor(r.d.common_color_10262)));
        this.GO.getLayoutMode().x(this.VB);
        this.bRQ.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.VB.setOnClickListener(this);
        this.bRR.setOnClickListener(this);
        this.bRQ.setOnClickListener(this);
        this.VB.setOnKeyListener(new r(this));
    }

    public void p(boolean z, boolean z2) {
        q(z, z2);
        acy();
        acz();
    }

    private void q(boolean z, boolean z2) {
        this.aNw.add(new b(0, this.GO.getPageActivity().getString(r.j.topic_thread), r.f.write_popup_normal_item_selector));
        if (z) {
            this.aNw.add(new b(1, this.GO.getPageActivity().getString(r.j.publish_live_thread), r.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aNw.add(new b(3, this.GO.getPageActivity().getString(r.j.publish_video_thread), r.f.write_popup_video_item_selector));
        }
        this.aNw.add(new b(2, this.GO.getPageActivity().getString(r.j.publish_vote_thread), r.f.write_popup_vote_item_selector));
    }

    private void acy() {
        LinearLayout linearLayout;
        int i = 0;
        LinearLayout linearLayout2 = null;
        while (i < this.aNw.size()) {
            b bVar = this.aNw.get(i);
            if (bVar == null) {
                linearLayout = linearLayout2;
            } else {
                View inflate = LayoutInflater.from(this.GO.getPageActivity()).inflate(r.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(r.g.text_frs_write_popup_item);
                ar.j((View) textView, r.d.cp_cont_b);
                textView.setText(bVar.mTitle);
                ar.c((ImageView) inflate.findViewById(r.g.image_frs_write_popup_item), bVar.bRV);
                inflate.setOnClickListener(new s(this, bVar));
                int dimensionPixelOffset = this.GO.getResources().getDimensionPixelOffset(r.e.ds100);
                if (i != 0 && i % 2 == 0) {
                    dimensionPixelOffset = 0;
                }
                inflate.setPadding(0, 0, dimensionPixelOffset, 0);
                if (i % 3 == 0) {
                    linearLayout = new LinearLayout(this.GO.getPageActivity());
                    linearLayout.setPadding(this.GO.getResources().getDimensionPixelOffset(r.e.ds80), 0, this.GO.getResources().getDimensionPixelOffset(r.e.ds80), this.GO.getResources().getDimensionPixelOffset(r.e.ds76));
                    this.bRP.addView(linearLayout);
                } else {
                    linearLayout = linearLayout2;
                }
                if (linearLayout != null) {
                    linearLayout.addView(inflate);
                }
            }
            i++;
            linearLayout2 = linearLayout;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.VB == view || this.bRR == view) {
            acA();
        }
    }

    private void acz() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aVz, 0, 0, 1);
        this.bRQ.startAnimation(AnimationUtils.loadAnimation(this.GO.getPageActivity(), r.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acA() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.GO.getPageActivity(), r.a.write_popup_out);
        loadAnimation.setAnimationListener(new t(this));
        this.bRQ.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int bRU;
        public int bRV;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.bRU = i;
            this.mTitle = str;
            this.bRV = i2;
        }
    }
}
