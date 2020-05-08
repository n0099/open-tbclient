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
/* loaded from: classes9.dex */
public class b {
    private TbPageContext duK;
    private RelativeLayout eHQ;
    private RelativeLayout eSq;
    private ImageView fqR;
    private GameVideoGridView hLY;
    private com.baidu.tieba.homepage.gamevideo.a.b hLZ;
    private com.baidu.tieba.homepage.gamevideo.view.a hMc;
    private TextView hMd;
    private a hMe;
    private TranslateAnimation hMf;
    private TranslateAnimation hMg;
    private BdUniqueId mBdUniqueId;
    private View mRootView;
    private boolean hMh = false;
    private Animation.AnimationListener hMi = new Animation.AnimationListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.1
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            b.this.hMh = true;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            b.this.hMh = false;
            b.this.bYQ();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (b.this.hLZ != null && i < b.this.hLZ.getCount() && b.this.hLZ.getItem(i) != null && (b.this.hLZ.getItem(i) instanceof com.baidu.tieba.homepage.gamevideo.c.a)) {
                com.baidu.tieba.homepage.gamevideo.c.a aVar = (com.baidu.tieba.homepage.gamevideo.c.a) b.this.hLZ.getItem(i);
                if (aVar.enable == 1) {
                    if (b.this.hMe != null) {
                        b.this.hMe.b(aVar);
                    }
                    com.baidu.tbadk.core.sharedPref.b.aNT().putInt("key_game_video_tab_has_choosed_sub_class_id", aVar.sub_class_id);
                    com.baidu.tbadk.core.sharedPref.b.aNT().putString("key_game_video_tab_has_choosed_sub_class_name", aVar.sub_class_name);
                    b.this.bYQ();
                    TiebaStatic.log(new an("c13489").af("obj_type", aVar.sub_class_id));
                }
            }
        }
    };
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.bYP();
        }
    };
    private PopupWindow.OnDismissListener mOnDismissListener = new PopupWindow.OnDismissListener() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.4
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.hMe != null) {
                b.this.hMe.bYT();
            }
        }
    };
    private a.InterfaceC0576a hMj = new a.InterfaceC0576a() { // from class: com.baidu.tieba.homepage.gamevideo.b.b.5
        @Override // com.baidu.tieba.homepage.gamevideo.view.a.InterfaceC0576a
        public void bYR() {
            b.this.bYO();
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.tieba.homepage.gamevideo.c.a aVar);

        void bYS();

        void bYT();
    }

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.duK = tbPageContext;
        this.mBdUniqueId = bdUniqueId;
        init();
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.duK.getPageActivity()).inflate(R.layout.game_video_choose_halfscreen_layout, (ViewGroup) null);
        this.eSq = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_wrapper);
        this.eHQ = (RelativeLayout) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_wrapper);
        this.fqR = (ImageView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_img);
        this.hMd = (TextView) this.mRootView.findViewById(R.id.id_game_video_choose_half_empty_txt);
        this.hLY = (GameVideoGridView) this.mRootView.findViewById(R.id.id_game_video_choose_half_gridview);
        this.hLY.setMaxHeight(l.getEquipmentWidth(this.duK.getPageActivity()));
        this.hLY.setNumColumns(4);
        this.hLY.setEmptyView(this.eHQ);
        this.hLZ = new com.baidu.tieba.homepage.gamevideo.a.b(this.duK, 102, this.mBdUniqueId);
        this.hLY.setAdapter((ListAdapter) this.hLZ);
        this.hLY.setOnItemClickListener(this.mOnItemClickListener);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        bYN();
        onChangeSkinType();
    }

    private void bYN() {
        this.hMf = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        this.hMf.setDuration(300L);
        this.hMf.setFillAfter(true);
        this.hMf.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hMg = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        this.hMg.setDuration(200L);
        this.hMg.setFillAfter(true);
        this.hMg.setInterpolator(new AccelerateDecelerateInterpolator());
        this.hMg.setAnimationListener(this.hMi);
    }

    public void vR(int i) {
        if (this.hLZ != null) {
            this.hLZ.vR(i);
        }
    }

    public void onChangeSkinType() {
        if (this.eSq != null) {
            am.setBackgroundResource(this.eSq, R.color.cp_bg_line_d);
        }
        if (this.hMd != null) {
            am.setViewTextColor(this.hMd, (int) R.color.cp_cont_d);
        }
        if (this.fqR != null) {
            am.setImageResource(this.fqR, R.drawable.new_pic_emotion_08);
        }
    }

    public void setData(List<com.baidu.tieba.homepage.gamevideo.c.a> list) {
        this.hLZ.setData(list);
    }

    public void cg(View view) {
        if (view != null) {
            this.hLZ.notifyDataSetChanged();
            if (this.hMc == null) {
                this.hMc = new com.baidu.tieba.homepage.gamevideo.view.a(this.duK, this.mRootView, -1, -1);
                this.hMc.setBackgroundDrawable(new ColorDrawable(this.duK.getResources().getColor(R.color.black_alpha66)));
                this.hMc.setAnimationStyle(0);
                this.hMc.a(this.hMj);
                this.hMc.setFocusable(true);
                this.hMc.setOnDismissListener(this.mOnDismissListener);
            }
            if (this.hMc.isShowing()) {
                this.hMc.dismiss();
            }
            this.hMc.showAsDropDown(view, 0, 0);
            this.hLY.bZa();
            if (this.eSq != null && this.hMf != null) {
                this.eSq.startAnimation(this.hMf);
            }
            if (this.hMe != null) {
                this.hMe.bYS();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYO() {
        if (this.hMg != null && this.eSq != null && !this.hMh) {
            this.eSq.startAnimation(this.hMg);
        }
    }

    public void bYP() {
        if (this.hMc != null) {
            this.hMc.dismiss();
        }
    }

    public void bYQ() {
        if (this.hMc != null) {
            this.hMc.bmD();
        }
    }

    public boolean isShowing() {
        if (this.hMc != null) {
            return this.hMc.isShowing();
        }
        return false;
    }

    public void a(a aVar) {
        this.hMe = aVar;
    }

    public void onDestroy() {
        bYQ();
        if (this.hMf != null) {
            this.hMf.cancel();
        }
        if (this.hMg != null) {
            this.hMg.cancel();
        }
        if (this.hLY != null) {
            this.hLY.onDestroy();
        }
    }
}
