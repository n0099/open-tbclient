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
    private RelativeLayout dqe;
    private GameVideoGridView ghp;
    private com.baidu.tieba.homepage.gamevideo.a.b ghq;
    private com.baidu.tieba.homepage.gamevideo.view.a ght;
    private RelativeLayout ghu;
    private ImageView ghv;
    private TextView ghw;
    private a ghx;
    private TranslateAnimation ghy;
    private TranslateAnimation ghz;
    private BdUniqueId mBdUniqueId;
    private TbPageContext mContext;
    private View mRootView;
    private boolean ghA = false;
    private Animation.AnimationListener ghB = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.ghA = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.ghA = false;
            b.this.bwl();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.ghq != null && i < b.this.ghq.getCount() && b.this.ghq.getItem(i) != null && (b.this.ghq.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.ghq.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.ghx != null) {
                        b.this.ghx.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.ahQ().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bwl();
                    TiebaStatic.log(new an("c13489").P("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bwk();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.ghx != null) {
                b.this.ghx.bwo();
            }
        }
    };
    private a.InterfaceC0326a ghC = new a.InterfaceC0326a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0326a
        public void bwm() {
            b.this.bwj();
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bwn();

        void bwo();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.mContext = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.dqe = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.ghu = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.ghv = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.ghw = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.ghp = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.ghp.setMaxHeight(l.af(this.mContext.getPageActivity()));
        this.ghp.setNumColumns(4);
        this.ghp.setEmptyView(this.ghu);
        this.ghq = new com.baidu.tieba.homepage.gamevideo.a.b(this.mContext, 102, this.mBdUniqueId);
        this.ghp.setAdapter((ListAdapter) this.ghq);
        this.ghp.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bwi();
        onChangeSkinType();
    }

    private void bwi() {
        this.ghy = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.ghy.setDuration(300L);
        this.ghy.setFillAfter(true);
        this.ghy.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ghz = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.ghz.setDuration(200L);
        this.ghz.setFillAfter(true);
        this.ghz.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ghz.setAnimationListener(this.ghB);
    }

    public void ua(int i) {
        if (this.ghq != null) {
            this.ghq.ua(i);
        }
    }

    public void onChangeSkinType() {
        if (this.dqe != null) {
            am.k(this.dqe, R.color.cp_bg_line_d);
        }
        if (this.ghw != null) {
            am.j(this.ghw, R.color.cp_cont_d);
        }
        if (this.ghv != null) {
            am.c(this.ghv, (int) R.drawable.new_pic_emotion_gray_09);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.ghq.setData(list);
    }

    public void cb(View view) {
        if (view != null) {
            this.ghq.notifyDataSetChanged();
            if (this.ght == null) {
                this.ght = new com.baidu.tieba.homepage.gamevideo.view.a(this.mContext, this.mRootView, -1, -1);
                this.ght.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(R.color.black_alpha66)));
                this.ght.setAnimationStyle(0);
                this.ght.a(this.ghC);
                this.ght.setFocusable(true);
                this.ght.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.ght.isShowing()) {
                this.ght.dismiss();
            }
            this.ght.showAsDropDown(view, 0, 0);
            this.ghp.bww();
            if (this.dqe != null && this.ghy != null) {
                this.dqe.startAnimation(this.ghy);
            }
            if (this.ghx != null) {
                this.ghx.bwn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwj() {
        if (this.ghz != null && this.dqe != null && !this.ghA) {
            this.dqe.startAnimation(this.ghz);
        }
    }

    public void bwk() {
        if (this.ght != null) {
            this.ght.dismiss();
        }
    }

    public void bwl() {
        if (this.ght != null) {
            this.ght.bwv();
        }
    }

    public boolean isShowing() {
        if (this.ght != null) {
            return this.ght.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.ghx = aVar;
    }

    public void onDestroy() {
        bwl();
        if (this.ghy != null) {
            this.ghy.cancel();
        }
        if (this.ghz != null) {
            this.ghz.cancel();
        }
        if (this.ghp != null) {
            this.ghp.onDestroy();
        }
    }
}
