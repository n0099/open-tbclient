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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends PopupWindow implements View.OnClickListener {
    private final TbPageContext<?> Nw;
    private ViewGroup Ye;
    private View aKv;
    private final List<b> aQh;
    private final a brR;
    private ViewGroup brS;
    private ViewGroup brT;
    private ImageView brU;

    /* loaded from: classes.dex */
    public interface a {
        void go(int i);
    }

    public ab(TbPageContext<?> tbPageContext, View view, a aVar) {
        super(tbPageContext.getPageActivity());
        this.aQh = new ArrayList();
        this.Nw = tbPageContext;
        this.brR = aVar;
        this.aKv = view;
        initView();
    }

    private void initView() {
        this.Ye = (ViewGroup) LayoutInflater.from(this.Nw.getPageActivity()).inflate(t.h.frs_write_popup, (ViewGroup) null);
        setContentView(this.Ye);
        this.brS = (ViewGroup) this.Ye.findViewById(t.g.frs_write_popup_item_container);
        this.brT = (ViewGroup) this.Ye.findViewById(t.g.frs_write_popup_board);
        this.brU = (ImageView) this.Ye.findViewById(t.g.image_frs_write_popup_close);
        setBackgroundDrawable(new ColorDrawable(this.Nw.getResources().getColor(t.d.white_alpha0)));
        this.Nw.getLayoutMode().x(this.Ye);
        this.brT.setPadding(0, UtilHelper.getStatusBarHeight(), 0, 0);
        setWidth(-1);
        setHeight(-1);
        setFocusable(true);
        this.Ye.setOnClickListener(this);
        this.brU.setOnClickListener(this);
        this.brT.setOnClickListener(this);
        this.Ye.setOnKeyListener(new ac(this));
    }

    public void h(boolean z, boolean z2) {
        i(z, z2);
        SA();
        SB();
    }

    private void i(boolean z, boolean z2) {
        this.aQh.add(new b(0, this.Nw.getPageActivity().getString(t.j.publish_topic_thread), t.f.write_popup_normal_item_selector));
        if (z) {
            this.aQh.add(new b(1, this.Nw.getPageActivity().getString(t.j.publish_live_thread), t.f.write_popup_live_item_selector));
        }
        if (z2) {
            this.aQh.add(new b(3, this.Nw.getPageActivity().getString(t.j.publish_video_thread), t.f.write_popup_video_item_selector));
        }
        this.aQh.add(new b(2, this.Nw.getPageActivity().getString(t.j.publish_vote_thread), t.f.write_popup_vote_item_selector));
    }

    private void SA() {
        for (b bVar : this.aQh) {
            if (bVar != null) {
                View inflate = LayoutInflater.from(this.Nw.getPageActivity()).inflate(t.h.frs_write_popup_item, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(t.g.text_frs_write_popup_item);
                ImageView imageView = (ImageView) inflate.findViewById(t.g.image_frs_write_popup_item);
                ar.j((View) textView, t.d.cp_cont_b);
                if (com.baidu.tbadk.core.util.x.o(this.aQh) == 3) {
                    int dimensionPixelOffset = this.Nw.getResources().getDimensionPixelOffset(t.e.ds40);
                    inflate.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                } else if (com.baidu.tbadk.core.util.x.o(this.aQh) == 2) {
                    int dimensionPixelOffset2 = this.Nw.getResources().getDimensionPixelOffset(t.e.ds66);
                    inflate.setPadding(dimensionPixelOffset2, 0, dimensionPixelOffset2, 0);
                }
                textView.setText(bVar.mTitle);
                ar.c(imageView, bVar.brY);
                inflate.setOnClickListener(new ad(this, bVar));
                this.brS.addView(inflate);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.Ye == view || this.brU == view) {
            SC();
        }
    }

    private void SB() {
        com.baidu.adp.lib.h.j.showPopupWindowAtLocation(this, this.aKv, 0, 0, 1);
        this.brT.startAnimation(AnimationUtils.loadAnimation(this.Nw.getPageActivity(), t.a.write_popup_in));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SC() {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.Nw.getPageActivity(), t.a.write_popup_out);
        loadAnimation.setAnimationListener(new ae(this));
        this.brT.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {
        public int brX;
        public int brY;
        public String mTitle;

        public b(int i, String str, int i2) {
            this.brX = i;
            this.mTitle = str;
            this.brY = i2;
        }
    }
}
