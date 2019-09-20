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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.gamevideo.view.GameVideoGridView;
import com.baidu.tieba.homepage.gamevideo.view.a;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private RelativeLayout drP;
    private GameVideoGridView gji;
    private com.baidu.tieba.homepage.gamevideo.a.b gjj;
    private com.baidu.tieba.homepage.gamevideo.view.a gjm;
    private RelativeLayout gjn;
    private ImageView gjo;
    private TextView gjp;
    private a gjq;
    private TranslateAnimation gjr;
    private TranslateAnimation gjs;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private View mRootView;
    private boolean gjt = false;
    private Animation.AnimationListener gju = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.gjt = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.gjt = false;
            b.this.bwZ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.gjj != null && i < b.this.gjj.getCount() && b.this.gjj.getItem(i) != null && (b.this.gjj.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.gjj.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.gjq != null) {
                        b.this.gjq.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.ahU().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.ahU().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bwZ();
                    TiebaStatic.log(new an("c13489").P("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bwY();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.gjq != null) {
                b.this.gjq.bxc();
            }
        }
    };
    private a.InterfaceC0337a gjv = new a.InterfaceC0337a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0337a
        public void bxa() {
            b.this.bwX();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bxb();

        void bxc();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.drP = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.gjn = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gjo = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.gjp = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.gji = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.gji.setMaxHeight(l.af(this.mContext.getPageActivity()));
        this.gji.setNumColumns(4);
        this.gji.setEmptyView(this.gjn);
        this.gjj = new com.baidu.tieba.homepage.gamevideo.a.b(this.mContext, 102, this.mBdUniqueId);
        this.gji.setAdapter((ListAdapter) this.gjj);
        this.gji.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bwW();
        onChangeSkinType();
    }

    private void bwW() {
        this.gjr = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.gjr.setDuration(300L);
        this.gjr.setFillAfter(true);
        this.gjr.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gjs = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.gjs.setDuration(200L);
        this.gjs.setFillAfter(true);
        this.gjs.setInterpolator(new AccelerateDecelerateInterpolator());
        this.gjs.setAnimationListener(this.gju);
    }

    public void ue(int i) {
        if (this.gjj != null) {
            this.gjj.ue(i);
        }
    }

    public void onChangeSkinType() {
        if (this.drP != null) {
            am.k(this.drP, R.color.cp_bg_line_d);
        }
        if (this.gjp != null) {
            am.j(this.gjp, R.color.cp_cont_d);
        }
        if (this.gjo != null) {
            am.c(this.gjo, (int) R.drawable.new_pic_emotion_gray_09);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.gjj.setData(list);
    }

    public void cb(View view) {
        if (view != null) {
            this.gjj.notifyDataSetChanged();
            if (this.gjm == null) {
                this.gjm = new com.baidu.tieba.homepage.gamevideo.view.a(this.mContext, this.mRootView, -1, -1);
                this.gjm.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(R.color.black_alpha66)));
                this.gjm.setAnimationStyle(0);
                this.gjm.a(this.gjv);
                this.gjm.setFocusable(true);
                this.gjm.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.gjm.isShowing()) {
                this.gjm.dismiss();
            }
            this.gjm.showAsDropDown(view, 0, 0);
            this.gji.bxk();
            if (this.drP != null && this.gjr != null) {
                this.drP.startAnimation(this.gjr);
            }
            if (this.gjq != null) {
                this.gjq.bxb();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        if (this.gjs != null && this.drP != null && !this.gjt) {
            this.drP.startAnimation(this.gjs);
        }
    }

    public void bwY() {
        if (this.gjm != null) {
            this.gjm.dismiss();
        }
    }

    public void bwZ() {
        if (this.gjm != null) {
            this.gjm.bxj();
        }
    }

    public boolean isShowing() {
        if (this.gjm != null) {
            return this.gjm.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.gjq = aVar;
    }

    public void onDestroy() {
        bwZ();
        if (this.gjr != null) {
            this.gjr.cancel();
        }
        if (this.gjs != null) {
            this.gjs.cancel();
        }
        if (this.gji != null) {
            this.gji.onDestroy();
        }
    }
}
