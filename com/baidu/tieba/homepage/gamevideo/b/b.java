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
/* loaded from: classes22.dex */
public class b {
    private TbPageContext eCn;
    private RelativeLayout fTa;
    private ImageView gKR;
    private RelativeLayout ggH;
    private GameVideoGridView jul;
    private com.baidu.tieba.homepage.gamevideo.a.b jum;
    private com.baidu.tieba.homepage.gamevideo.view.a jup;
    private TextView juq;
    private a jur;
    private TranslateAnimation jus;
    private TranslateAnimation jut;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean juu = false;
    private Animation.AnimationListener juv = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.juu = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.juu = false;
            b.this.cHz();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.jum != null && i < b.this.jum.getCount() && b.this.jum.getItem(i) != null && (b.this.jum.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.jum.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.jur != null) {
                        b.this.jur.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.bnH().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.bnH().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.cHz();
                    TiebaStatic.log(new aq("c13489").aj("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.cHy();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.jur != null) {
                b.this.jur.cHC();
            }
        }
    };
    private a.InterfaceC0727a juw = new a.InterfaceC0727a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0727a
        public void cHA() {
            b.this.cHx();
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void cHB();

        void cHC();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.eCn = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.eCn.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.ggH = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.fTa = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.gKR = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.juq = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.jul = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.jul.setMaxHeight(l.getEquipmentWidth(this.eCn.getPageActivity()));
        this.jul.setNumColumns(4);
        this.jul.setEmptyView(this.fTa);
        this.jum = new com.baidu.tieba.homepage.gamevideo.a.b(this.eCn, 102, this.mBdUniqueId);
        this.jul.setAdapter((ListAdapter) this.jum);
        this.jul.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        cHw();
        onChangeSkinType();
    }

    private void cHw() {
        this.jus = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.jus.setDuration(300L);
        this.jus.setFillAfter(true);
        this.jus.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jut = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.jut.setDuration(200L);
        this.jut.setFillAfter(true);
        this.jut.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jut.setAnimationListener(this.juv);
    }

    public void Br(int i) {
        if (this.jum != null) {
            this.jum.Br(i);
        }
    }

    public void onChangeSkinType() {
        if (this.ggH != null) {
            ap.setBackgroundResource(this.ggH, R.color.cp_bg_line_d);
        }
        if (this.juq != null) {
            ap.setViewTextColor(this.juq, R.color.cp_cont_d);
        }
        if (this.gKR != null) {
            ap.setImageResource(this.gKR, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.jum.setData(list);
    }

    public void cG(View view) {
        if (view != null) {
            this.jum.notifyDataSetChanged();
            if (this.jup == null) {
                this.jup = new com.baidu.tieba.homepage.gamevideo.view.a(this.eCn, this.mRootView, -1, -1);
                this.jup.setBackgroundDrawable(new ColorDrawable(this.eCn.getResources().getColor(R.color.black_alpha66)));
                this.jup.setAnimationStyle(0);
                this.jup.a(this.juw);
                this.jup.setFocusable(true);
                this.jup.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.jup.isShowing()) {
                this.jup.dismiss();
            }
            this.jup.showAsDropDown(view, 0, 0);
            this.jul.cHJ();
            if (this.ggH != null && this.jus != null) {
                this.ggH.startAnimation(this.jus);
            }
            if (this.jur != null) {
                this.jur.cHB();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHx() {
        if (this.jut != null && this.ggH != null && !this.juu) {
            this.ggH.startAnimation(this.jut);
        }
    }

    public void cHy() {
        if (this.jup != null) {
            this.jup.dismiss();
        }
    }

    public void cHz() {
        if (this.jup != null) {
            this.jup.UA();
        }
    }

    public boolean isShowing() {
        if (this.jup != null) {
            return this.jup.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.jur = aVar;
    }

    public void onDestroy() {
        cHz();
        if (this.jus != null) {
            this.jus.cancel();
        }
        if (this.jut != null) {
            this.jut.cancel();
        }
        if (this.jul != null) {
            this.jul.onDestroy();
        }
    }
}
