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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes16.dex */
public class b {
    private TbPageContext efn;
    private RelativeLayout fGW;
    private RelativeLayout fvl;
    private ImageView ghx;
    private GameVideoGridView iKe;
    private com.baidu.tieba.homepage.gamevideo.a.b iKf;
    private com.baidu.tieba.homepage.gamevideo.view.a iKi;
    private TextView iKj;
    private a iKk;
    private TranslateAnimation iKl;
    private TranslateAnimation iKm;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean iKn = false;
    private Animation.AnimationListener iKo = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.iKn = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.iKn = false;
            b.this.cxc();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.iKf != null && i < b.this.iKf.getCount() && b.this.iKf.getItem(i) != null && (b.this.iKf.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.iKf.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.iKk != null) {
                        b.this.iKk.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bik().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bik().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cxc();
                    TiebaStatic.log(new aq("c13489").ai("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cxb();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.iKk != null) {
                b.this.iKk.cxf();
            }
        }
    };
    private a.InterfaceC0696a iKp = new a.InterfaceC0696a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0696a
        public void cxd() {
            b.this.cxa();
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cxe();

        void cxf();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.efn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.efn.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.fGW = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fvl = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.ghx = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.iKj = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.iKe = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.iKe.setMaxHeight(l.getEquipmentWidth(this.efn.getPageActivity()));
        this.iKe.setNumColumns(4);
        this.iKe.setEmptyView(this.fvl);
        this.iKf = new com.baidu.tieba.homepage.gamevideo.a.b(this.efn, 102, this.mBdUniqueId);
        this.iKe.setAdapter((ListAdapter) this.iKf);
        this.iKe.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cwZ();
        onChangeSkinType();
    }

    private void cwZ() {
        this.iKl = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.iKl.setDuration(300L);
        this.iKl.setFillAfter(true);
        this.iKl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iKm = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.iKm.setDuration(200L);
        this.iKm.setFillAfter(true);
        this.iKm.setInterpolator(new AccelerateDecelerateInterpolator());
        this.iKm.setAnimationListener(this.iKo);
    }

    public void zR(int i) {
        if (this.iKf != null) {
            this.iKf.zR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.fGW != null) {
            ap.setBackgroundResource(this.fGW, R.color.cp_bg_line_d);
        }
        if (this.iKj != null) {
            ap.setViewTextColor(this.iKj, R.color.cp_cont_d);
        }
        if (this.ghx != null) {
            ap.setImageResource(this.ghx, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.iKf.setData(list);
    }

    public void cp(View view) {
        if (view != null) {
            this.iKf.notifyDataSetChanged();
            if (this.iKi == null) {
                this.iKi = new com.baidu.tieba.homepage.gamevideo.view.a(this.efn, this.mRootView, -1, -1);
                this.iKi.setBackgroundDrawable(new ColorDrawable(this.efn.getResources().getColor(R.color.black_alpha66)));
                this.iKi.setAnimationStyle(0);
                this.iKi.a(this.iKp);
                this.iKi.setFocusable(true);
                this.iKi.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.iKi.isShowing()) {
                this.iKi.dismiss();
            }
            this.iKi.showAsDropDown(view, 0, 0);
            this.iKe.cxm();
            if (this.fGW != null && this.iKl != null) {
                this.fGW.startAnimation(this.iKl);
            }
            if (this.iKk != null) {
                this.iKk.cxe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxa() {
        if (this.iKm != null && this.fGW != null && !this.iKn) {
            this.fGW.startAnimation(this.iKm);
        }
    }

    public void cxb() {
        if (this.iKi != null) {
            this.iKi.dismiss();
        }
    }

    public void cxc() {
        if (this.iKi != null) {
            this.iKi.bHi();
        }
    }

    public boolean isShowing() {
        if (this.iKi != null) {
            return this.iKi.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.iKk = aVar;
    }

    public void onDestroy() {
        cxc();
        if (this.iKl != null) {
            this.iKl.cancel();
        }
        if (this.iKm != null) {
            this.iKm.cancel();
        }
        if (this.iKe != null) {
            this.iKe.onDestroy();
        }
    }
}
