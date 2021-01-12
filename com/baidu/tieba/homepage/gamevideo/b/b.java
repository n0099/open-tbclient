package com.baidu.tieba.homepage.gamevideo.b;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    private TbPageContext eSJ;
    private RelativeLayout gAG;
    private RelativeLayout gmB;
    private ImageView hgH;
    private GameVideoGridView jXr;
    private com.baidu.tieba.homepage.gamevideo.a.b jXs;
    private com.baidu.tieba.homepage.gamevideo.view.a jXv;
    private TextView jXw;
    private a jXx;
    private TranslateAnimation jXy;
    private TranslateAnimation jXz;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean jXA = false;
    private Animation.AnimationListener jXB = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.jXA = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.jXA = false;
            b.this.cOk();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jXs != null && i < b.this.jXs.getCount() && b.this.jXs.getItem(i) != null && (b.this.jXs.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jXs.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jXx != null) {
                        b.this.jXx.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.brx().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.brx().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cOk();
                    TiebaStatic.log(new aq("c13489").an("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cOj();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jXx != null) {
                b.this.jXx.cOn();
            }
        }
    };
    private a.InterfaceC0744a jXC = new a.InterfaceC0744a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0744a
        public void cOl() {
            b.this.cOi();
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cOm();

        void cOn();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eSJ = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.gAG = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.gmB = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.hgH = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.jXw = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jXr = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jXr.setMaxHeight(l.getEquipmentWidth(this.eSJ.getPageActivity()));
        this.jXr.setNumColumns(4);
        this.jXr.setEmptyView(this.gmB);
        this.jXs = new com.baidu.tieba.homepage.gamevideo.a.b(this.eSJ, 102, this.mBdUniqueId);
        this.jXr.setAdapter((ListAdapter) this.jXs);
        this.jXr.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cOh();
        onChangeSkinType();
    }

    private void cOh() {
        this.jXy = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jXy.setDuration(300L);
        this.jXy.setFillAfter(true);
        this.jXy.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jXz = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jXz.setDuration(200L);
        this.jXz.setFillAfter(true);
        this.jXz.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jXz.setAnimationListener(this.jXB);
    }

    public void Bz(int i) {
        if (this.jXs != null) {
            this.jXs.Bz(i);
        }
    }

    public void onChangeSkinType() {
        if (this.gAG != null) {
            ao.setBackgroundResource(this.gAG, R.color.CAM_X0201);
        }
        if (this.jXw != null) {
            ao.setViewTextColor(this.jXw, R.color.CAM_X0109);
        }
        if (this.hgH != null) {
            ao.setImageResource(this.hgH, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jXs.setData(list);
    }

    public void dg(View view) {
        if (view != null) {
            this.jXs.notifyDataSetChanged();
            if (this.jXv == null) {
                this.jXv = new com.baidu.tieba.homepage.gamevideo.view.a(this.eSJ, this.mRootView, -1, -1);
                this.jXv.setBackgroundDrawable(new ColorDrawable(this.eSJ.getResources().getColor(R.color.black_alpha66)));
                this.jXv.setAnimationStyle(0);
                this.jXv.a(this.jXC);
                this.jXv.setFocusable(true);
                this.jXv.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jXv.isShowing()) {
                this.jXv.dismiss();
            }
            this.jXv.showAsDropDown(view, 0, 0);
            this.jXr.cOu();
            if (this.gAG != null && this.jXy != null) {
                this.gAG.startAnimation(this.jXy);
            }
            if (this.jXx != null) {
                this.jXx.cOm();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOi() {
        if (this.jXz != null && this.gAG != null && !this.jXA) {
            this.gAG.startAnimation(this.jXz);
        }
    }

    public void cOj() {
        if (this.jXv != null) {
            this.jXv.dismiss();
        }
    }

    public void cOk() {
        if (this.jXv != null) {
            this.jXv.Wo();
        }
    }

    public boolean isShowing() {
        if (this.jXv != null) {
            return this.jXv.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jXx = aVar;
    }

    public void onDestroy() {
        cOk();
        if (this.jXy != null) {
            this.jXy.cancel();
        }
        if (this.jXz != null) {
            this.jXz.cancel();
        }
        if (this.jXr != null) {
            this.jXr.onDestroy();
        }
    }
}
